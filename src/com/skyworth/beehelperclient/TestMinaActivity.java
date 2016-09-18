package com.skyworth.beehelperclient;

import com.skyworth.beehelperclient.message.ClientSession;
import com.skyworth.beehelperclient.protocol.RequestInfoMsg.RequestInfo;
import com.skyworth.beehelperclient.protocol.RequestInfoMsg.RequestParam;
import com.skyworth.beehelperclient.utils.Constants;
import com.skyworth.beehelperclient.utils.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @Author : DanBin
 * @Date : 2016年9月9日上午9:37:14
 */
public class TestMinaActivity extends Activity implements OnClickListener{

	private static final String TAG = "TestMinaActivity";
	private Button mSendButton;
	
	public static void run(Context mContext, String mIp) {
		Intent intent = new Intent(mContext, TestMinaActivity.class);
		intent.putExtra("ip", mIp);
		mContext.startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		extraIntent();
		ClientSession.getInstance(this).initConnection();
		setContentView(R.layout.activity_test_mina);
		mSendButton = (Button) findViewById(R.id.send);
		mSendButton.setOnClickListener(this);
	}

	private void extraIntent() {
		String ip = getIntent().getStringExtra("ip");
		Log.i(TAG, ip);
		ClientSession.getInstance(this).configSession(ip, Constants.TCP_PORT);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ClientSession.getInstance(this).closeConnection();
	}
	
	@Override
	public void onClick(View v) {
		ClientSession.getInstance(this).send(buildRequestInfo());
	}
	
	private byte[] buildRequestInfo() {
		RequestInfo.Builder builder1 = RequestInfo.newBuilder();
		builder1.setMsgUid(Utils.getRandomID());
		builder1.setMsgType(1);
		builder1.setMsgAction(2);
		RequestParam.Builder builder2 = RequestParam.newBuilder();
		builder1.addMsgParam(builder2.setKey("videoId").setValue("123456").build());
		builder1.addMsgParam(builder2.setKey("videoId222").setValue("123456789").build());
		return builder1.build().toByteArray();
	}
	
}
