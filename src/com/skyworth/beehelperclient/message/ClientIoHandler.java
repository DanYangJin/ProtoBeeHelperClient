package com.skyworth.beehelperclient.message;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import android.util.Log;

/**
 * @ClassName : IoMessageHandler.java
 * @Author : DanBin
 * @Date : 2016年6月16日下午4:50:56
 */
public class ClientIoHandler extends IoHandlerAdapter {

	private static final String TAG = "ClientIoHandler";

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		super.exceptionCaught(session, cause);
		Log.e(TAG, "@@@exceptionCaught@@@" + cause.getMessage());
	}

	@Override
	public void inputClosed(IoSession session) throws Exception {
		super.inputClosed(session);
		Log.e(TAG, "@@@inputClosed@@@");
	}

	@Override
	public void messageReceived(IoSession session, Object object) throws Exception {
		super.messageReceived(session, object);
		byte[] msg = (byte[])object;
		Log.i("info", " received length : " + msg.length);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		super.messageSent(session, message);
		Log.e(TAG, "@@@messageSent@@@");
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
		Log.e(TAG, "@@@sessionClosed@@@");
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		super.sessionCreated(session);
		Log.e(TAG, "@@@sessionCreated@@@");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		super.sessionIdle(session, status);
		Log.e(TAG, "@@@sessionIdle@@@");

	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		super.sessionOpened(session);
		Log.e(TAG, "@@@sessionOpened@@@");
	}

}
