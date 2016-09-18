package com.skyworth.beehelperclient.message;

import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.service.IoServiceListener;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;
import org.apache.mina.filter.keepalive.KeepAliveRequestTimeoutHandler;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.google.protobuf.InvalidProtocolBufferException;
import com.skyworth.beehelperclient.protocol.DeviceMsg.DeviceInfo;
import com.skyworth.beehelperclient.protocol.HeartBeatMsg.HeartBeat;
import com.skyworth.beehelperclient.utils.Constants;

import android.content.Context;
import android.util.Log;

/**
 * @Author : DanBin
 * @Date : 2016年9月8日下午4:21:11
 */
public class ClientSession implements Runnable {

	private static final String TAG = "ClientSession";

	// 临时变量
	private DeviceInfo mLinkDevice;
	private String mLinkIp;
	private int mLinkPort;

	// 相关参数
	private static ClientSession INSTANCE = null;
	private IoSession mSession = null;
	private NioSocketConnector mConnector = null;

	public static ClientSession getInstance(Context mCtx) {
		if (INSTANCE == null) {
			synchronized (ClientSession.class) {
				if (INSTANCE == null) {
					INSTANCE = new ClientSession(mCtx);
				}
			}
		}
		return INSTANCE;
	}

	public ClientSession(Context mCtx) {

	}

	public String getLinkIp() {
		return mLinkIp;
	}

	public void setLinkIp(String linkIp) {
		this.mLinkIp = linkIp;
	}

	public int getLinkPort() {
		return mLinkPort;
	}

	public void setLinkPort(int linkPort) {
		this.mLinkPort = linkPort;
	}

	public DeviceInfo getLinkDevice() {
		return mLinkDevice;
	}

	public void configSession(String linkIp) {
		this.configSession(linkIp, Constants.DEFAULT_PORT);
	}

	public void configSession(DeviceInfo linkDevice, int linkPort) {
		this.configSession(linkDevice.getDeviceIp(), linkPort);
		this.mLinkDevice = linkDevice;
	}

	public void configSession(String linkIp, int linkPort) {
		this.initSession(linkIp, linkPort);
		this.mLinkIp = linkIp;
		this.mLinkPort = linkPort;
	}

	private void initSession(String linkIp, int linkPort) {
		Log.i(TAG, "@@@initSession@@@@ " + linkIp);
		mConnector = new NioSocketConnector();
		mConnector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new MinaProtobufEncoder(), new MinaProtobufDecoder()));
		mConnector.getFilterChain().addLast("heartbeat", buildHeartBeatBody());
		mConnector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, Constants.IDELTIMEOUT);
		mConnector.setDefaultRemoteAddress(new InetSocketAddress(linkIp, linkPort));
		mConnector.setHandler(new ClientIoHandler());
		mConnector.setConnectTimeoutMillis(Constants.CONNECT_TIME_OUT * 1000L);
		mConnector.addListener(new HeartBeatListener());
		startBuildSThread();
	}

	private KeepAliveFilter buildHeartBeatBody() {
		KeepAliveMessageFactory heartBeatFactory = new KeepAliveMessageFactoryImpl();
		KeepAliveFilter heartBeat = new KeepAliveFilter(heartBeatFactory, IdleStatus.READER_IDLE,
				KeepAliveRequestTimeoutHandlerImpl.CLOSE);
		heartBeat.setForwardEvent(true);
		heartBeat.setRequestInterval(Constants.HEARTBEATRATE);
		heartBeat.setRequestTimeout(Constants.HEARTTIMEOUT);
		return heartBeat;
	}

	// 启动创建Session线程
	public void startBuildSThread() {
		new Thread(this).start();
	}

	public void closeSession() {
		if (mSession != null) {
			mSession.closeNow();
			mSession = null;
		}
		if (mConnector != null) {
			mConnector.dispose();
			mConnector = null;
		}
	}

	// TODO 以后考虑第一次连接时无限重连,暂不考虑视需求而定
	public void buildSession() {
		try {
			ConnectFuture future = mConnector.connect();
			future.awaitUninterruptibly();
			mSession = future.getSession();
			if (mSession.isConnected()) {
				Log.i(TAG, "@@@@服务器连接成功@@@@");
			}
		} catch (Exception e) {
			Log.i(TAG, "@@@服务器连接异常@@@" + e.getMessage());
		}
	}

	// 在应用起来之前必须执行initConnection
	public void initConnection() {

	}

	// 在应用退出之后必须关闭相关操作
	public void closeConnection() {
		closeSession();
	}

	/**
	 * 客户端发送TCP消息方法
	 * 
	 * @param msg
	 *            : 消息内容
	 */
	public void send(byte[] msg) {
		Log.i("info", "msg : " + msg);
		if (mSession == null || !mSession.isConnected()) {
			return;
		}
		mSession.write(msg);
	}

	@Override
	public void run() {
		buildSession();
	}

	/**
	 * 客户端与服务器重试机制
	 * 
	 * 
	 */
	private void tryConnection() throws Exception {
		int mCount = 0;
		while (true) {
			try {
				mCount++;
				ConnectFuture future = mConnector.connect();
				future.awaitUninterruptibly();
				mSession = future.getSession();
				if (mSession.isConnected()) {
					Log.i(TAG, "@@@重连成功@@@");
					mCount = 0;
					break;
				}
			} catch (Exception e) {
				if (mCount == Constants.CONNECT_COUNT) {
					Log.i(TAG, "@@@重连失败@@@");
					break;
				} else {
					Log.i(TAG, "@@@正在重连中,当前尝试次数@@@" + mCount);
					Thread.sleep(3000);
				}
			}
		}
	}

	/**
	 * 重新建立连接线程
	 * 
	 */
	private class TryConnectionThread extends Thread {
		@Override
		public void run() {
			try {
				tryConnection();
			} catch (Exception e) {
				Log.i(TAG, e.getMessage());
			}
		}
	}

	/**
	 * 构建客户端与服务器心跳机制
	 * 
	 */
	public class KeepAliveMessageFactoryImpl implements KeepAliveMessageFactory {

		/* 心跳包发送内容 */
		public HeartBeat HEARTBEATREQUEST;
		/* 心跳包相应内容 */
		public HeartBeat HEARTBEATRESPONSE;

		public KeepAliveMessageFactoryImpl() {
			HeartBeat.Builder builder1 = HeartBeat.newBuilder();
			builder1.setMsg(1);
			HEARTBEATREQUEST = builder1.build();
			HeartBeat.Builder builder2 = HeartBeat.newBuilder();
			builder2.setMsg(2);
			HEARTBEATRESPONSE = builder2.build();
		}

		@Override
		public Object getRequest(IoSession session) {
			return HEARTBEATREQUEST.toByteArray();
		}

		@Override
		public Object getResponse(IoSession session, Object request) {
			return null;
		}

		/**
		 * 如果接受的长度为2,则表示心跳请求
		 * 
		 */
		@Override
		public boolean isRequest(IoSession session, Object message) {
			try {
				byte[] msg = (byte[]) message;
				if (msg.length == 2) {
					HeartBeat heartBeat = HeartBeat.parseFrom(msg);
					int value = heartBeat.getMsg();
					if (value == 1) {
						return true;
					}
				}
			} catch (InvalidProtocolBufferException e) {
				e.printStackTrace();
			}
			return false;
		}

		/**
		 * 如果接受的长度为2,则表示心跳响应
		 * 
		 */
		@Override
		public boolean isResponse(IoSession session, Object message) {
			try {
				byte[] msg = (byte[]) message;
				if (msg.length == 2) {
					Log.i(TAG, "@@@isResponse is heartbeat@@@");
					HeartBeat heartBeat = HeartBeat.parseFrom(msg);
					int value = heartBeat.getMsg();
					if (value == 2) {
						return true;
					}
				} 
			} catch (InvalidProtocolBufferException e) {
				e.printStackTrace();
			}
			return false;
		}

	}

	private class KeepAliveRequestTimeoutHandlerImpl implements KeepAliveRequestTimeoutHandler {

		@Override
		public void keepAliveRequestTimedOut(KeepAliveFilter filter, IoSession session) throws Exception {
			Log.i(TAG, "@@@@心跳超时@@@@");
			new TryConnectionThread().start();
		}
	}

	private class HeartBeatListener implements IoServiceListener {

		@Override
		public void serviceActivated(IoService service) throws Exception {
			Log.i(TAG, "@@@@serviceActivated@@@@");
		}

		@Override
		public void serviceDeactivated(IoService service) throws Exception {
			Log.i(TAG, "@@@@serviceDeactivated@@@@");
		}

		@Override
		public void serviceIdle(IoService service, IdleStatus status) throws Exception {
			Log.i(TAG, "@@@@serviceIdle@@@@");
		}

		@Override
		public void sessionClosed(IoSession session) throws Exception {
			Log.i(TAG, "@@@@sessionClosed@@@@");
		}

		@Override
		public void sessionCreated(IoSession session) throws Exception {
			Log.i(TAG, "@@@@sessionCreated@@@@");
		}

		@Override
		public void sessionDestroyed(IoSession session) {
			Log.i(TAG, "@@@@sessionDestroyed@@@@");
			new TryConnectionThread().start();
		}
	}

}
