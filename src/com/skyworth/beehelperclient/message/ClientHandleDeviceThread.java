package com.skyworth.beehelperclient.message;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.google.protobuf.InvalidProtocolBufferException;
import com.skyworth.beehelperclient.protocol.DeviceMsg.DeviceInfo;
import com.skyworth.beehelperclient.utils.Utils;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * @ClassName : ClientHandleDeviceThread.java
 * @Author : DanBin
 * @Date : 2016年7月6日上午10:45:14
 */
public class ClientHandleDeviceThread implements Runnable {

	private static final String TAG = "ClientHandleDeviceThread";
	private static final String SEND_UDP_ADDRESS = "255.255.255.255";
	private static final int SEND_UDP_PORT = 12344;
	private static final int RECEIVER_UDP_PORT = 12388;
	// 广播相关
	private DatagramSocket mSendSocket = null;
	private DatagramPacket mSendPacket = null;
	private InetAddress mInetAddress = null;
	private OnSearchListener mListener = null;
	private Thread mSPThread = null;
	private FindSPThread mReceiverThread = null;

	// 临时变量
	private Context mCtx = null;
	private byte[] mSendData = null;
	private int mSendCount = 10;
	private int mCurrentCount = 0;
	private long mInterval = 2000;

	// 标记
	private boolean isSearching = true;
	private boolean mHasDevice = false;

	private static final int MSG_FIND_DEVICE = 0x001;
	private static final int MSG_FIND_END = 0x002;

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (mListener == null) {
				return;
			}
			switch (msg.what) {
			case MSG_FIND_DEVICE:
				mListener.findDevice((DeviceInfo) msg.obj);
				break;
			case MSG_FIND_END:
				mListener.findDeviceEnd();
				break;
			}
		}
	};
	
	public ClientHandleDeviceThread(Context mCtx) {
		this.mCtx = mCtx;
	}

	public void setSearchListener(OnSearchListener mListener) {
		this.mListener = mListener;
	}

	public void setSearchInterval(long interval) {
		this.mInterval = interval;
	}

	@Override
	public void run() {
		try {
			this.initData();
			this.mReceiverThread = new FindSPThread();
			this.mReceiverThread.start();
			while (isSearching) {
				findDevice();
				Thread.sleep(mInterval);
				mCurrentCount++;
				if (mCurrentCount > mSendCount && !mHasDevice) {
					this.startCallBackFSEnd();
					this.stopThread();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initData() {
		try {
			this.mInetAddress = InetAddress.getByName(SEND_UDP_ADDRESS);
			this.mSendSocket = new DatagramSocket();
			this.mSendSocket.setReuseAddress(true);
			this.mSendData = buildDeviceProtocol();
			this.mSendPacket = new DatagramPacket(this.mSendData, this.mSendData.length, this.mInetAddress,
					SEND_UDP_PORT);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	private byte[] buildDeviceProtocol() {
		DeviceInfo.Builder builder = DeviceInfo.newBuilder();
		builder.setDeviceUid(Utils.getRandomID());
		builder.setDeviceIp(Utils.getWirelessIp(mCtx));
		builder.setDeviceName(Build.MODEL);
		return builder.build().toByteArray();
	}

	public void findDevice() {
		try {
			mSendSocket.send(mSendPacket);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startThread() {
		mSPThread = new Thread(this);
		mSPThread.start();
	}

	public void stopThread() {
		if (mReceiverThread != null) {
			mReceiverThread.stopThread();
		}
		if (mSPThread != null) {
			isSearching = false;
			mCurrentCount = 0;
		}
		if (mSendSocket != null) {
			mSendSocket.disconnect();
			mSendSocket.close();
		}
	}

	private synchronized DeviceInfo handlePacket(DatagramPacket recevierDp) {
		try {
			//ProtoBuf数据解析必须保证前后传递字节长度一致
			byte[] receiverByte = new String(recevierDp.getData(), recevierDp.getOffset(), recevierDp.getLength())
					.getBytes();
			DeviceInfo serverDevice = DeviceInfo.parseFrom(receiverByte);
			if (serverDevice != null) {
				Log.i(TAG, serverDevice.getDeviceIp());
				return serverDevice;
			}
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		return null;
	}

	private synchronized void startCallBackFSEnd() {
		Message msg = mHandler.obtainMessage();
		msg.what = MSG_FIND_END;
		mHandler.sendMessage(msg);
	}

	private synchronized void startCallBackFS(DeviceInfo device) {
		stopCallBackFS();
		Message msg = mHandler.obtainMessage();
		msg.what = MSG_FIND_DEVICE;
		msg.obj = device;
		mHandler.sendMessage(msg);
	}

	private synchronized void stopCallBackFS() {
		mHandler.removeMessages(MSG_FIND_DEVICE);
	}

	private class FindSPThread extends Thread {

		private boolean isRuning = true;
		private DatagramSocket udpSocket = null;

		@Override
		public void run() {
			try {
				// 绑定地址之前需回收，否则无法重新绑定
				udpSocket = new DatagramSocket(null);
				udpSocket.setReuseAddress(true);
				udpSocket.bind(new InetSocketAddress(RECEIVER_UDP_PORT));
				while (isRuning) {
					byte[] data = new byte[256];
					DatagramPacket udpPacket = new DatagramPacket(data, data.length);
					udpSocket.receive(udpPacket);
					if (udpPacket.getLength() != 0) {
						DeviceInfo device = handlePacket(udpPacket);
						if (device != null) {
							startCallBackFS(device);
							mHasDevice = true;
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void stopThread() {
			isRuning = false;
			if (udpSocket != null) {
				udpSocket.disconnect();
				udpSocket.close();
			}
		}
	}

}
