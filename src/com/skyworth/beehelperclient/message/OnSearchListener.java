package com.skyworth.beehelperclient.message;

import com.skyworth.beehelperclient.protocol.DeviceMsg.DeviceInfo;

/**
 * @ClassName : OnSearchListener.java
 * @Author : DanBin
 * @Date : 2016年7月6日上午10:53:17
 */

public abstract interface OnSearchListener {
	public abstract void findDevice(DeviceInfo device);
	public abstract void findDeviceEnd();
}
