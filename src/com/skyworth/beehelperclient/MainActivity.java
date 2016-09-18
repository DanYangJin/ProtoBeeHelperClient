package com.skyworth.beehelperclient;

import java.util.ArrayList;
import java.util.List;

import com.skyworth.beehelperclient.adapter.DeviceAdapter;
import com.skyworth.beehelperclient.message.ClientHandleDeviceThread;
import com.skyworth.beehelperclient.message.OnSearchListener;
import com.skyworth.beehelperclient.protocol.DeviceMsg.DeviceInfo;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnSearchListener, OnItemClickListener {

	private static final String TAG = "MainActivity";

	private ListView mDeviceListView;
	private DeviceAdapter mDeviceAdapter;

	private List<DeviceInfo> mDeviceInfos;
	private ClientHandleDeviceThread mClientHandleDeviceThread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDeviceInfos = new ArrayList<DeviceInfo>();
		mDeviceListView = (ListView) findViewById(R.id.deviceListView);
		mDeviceListView.setOnItemClickListener(this);
		mDeviceAdapter = new DeviceAdapter(this, mDeviceInfos);
		mDeviceListView.setAdapter(mDeviceAdapter);
	}

	@Override
	protected void onResume() {
		super.onResume();
		initSearchThread();
	}

	@Override
	protected void onPause() {
		super.onPause();
		stopSearchThread();
	}

	private void initSearchThread() {
		mDeviceInfos.clear();
		mClientHandleDeviceThread = new ClientHandleDeviceThread(this);
		mClientHandleDeviceThread.setSearchInterval(2000);
		mClientHandleDeviceThread.setSearchListener(this);
		mClientHandleDeviceThread.startThread();
	}

	private void stopSearchThread() {
		mClientHandleDeviceThread.stopThread();
	}

	@Override
	public void findDevice(DeviceInfo device) {
		if (hasDevice(device)) {
			return;
		}
		mDeviceInfos.add(device);
		mDeviceAdapter.notifyDataSetChanged();
	}

	@Override
	public void findDeviceEnd() {
		Log.i(TAG, "findDeviceEnd");
	}

	private synchronized boolean hasDevice(DeviceInfo device) {
		if (mDeviceInfos == null || mDeviceInfos.isEmpty()) {
			return false;
		}
		for (DeviceInfo d : mDeviceInfos) {
			if (TextUtils.equals(d.getDeviceIp(), device.getDeviceIp())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		DeviceInfo deviceInfo = mDeviceInfos.get(position);
		if (deviceInfo == null) {
			return;
		}
		TestMinaActivity.run(this, deviceInfo.getDeviceIp());
	}
	
	
}
