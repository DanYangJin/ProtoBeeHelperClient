package com.skyworth.beehelperclient.adapter;

import java.util.List;

import com.skyworth.beehelperclient.R;
import com.skyworth.beehelperclient.protocol.DeviceMsg.DeviceInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/** 
* @author  作者 : DanBin 
* @version 创建时间：2016年9月8日 下午1:42:17 
* 类说明 
*/
public class DeviceAdapter extends BaseAdapter{

	private Context mCtx;
	private List<DeviceInfo> mDeviceInfos;
	
	public DeviceAdapter(Context mCtx, List<DeviceInfo> mDeviceInfos) {
		this.mCtx = mCtx;
		this.mDeviceInfos = mDeviceInfos;
	}
	
	@Override
	public int getCount() {
		return mDeviceInfos.size();
	}

	@Override
	public Object getItem(int position) {
		return mDeviceInfos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mCtx).inflate(R.layout.device_item, null);
		}
		TextView mTitleView = (TextView)convertView.findViewById(R.id.device_title_tv);
		DeviceInfo deviceInfo = mDeviceInfos.get(position);
		if (deviceInfo == null) {
			return convertView;
		}
		mTitleView.setText(deviceInfo.getDeviceIp());
		return convertView;
	}

}
