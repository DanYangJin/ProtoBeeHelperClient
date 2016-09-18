package com.skyworth.beehelperclient.protocol;

import com.google.gson.Gson;
import com.skyworth.beehelperclient.protocol.DeviceMsg.DeviceInfo;

public class MsgJunitTest {

	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			DeviceInfo.Builder builder = DeviceInfo.newBuilder();
			builder.setDeviceUid("123456abcdefghq123456789");
			builder.setDeviceIp("127.0.0.1");
			builder.setDeviceName("A810123456789");
			byte[] bytes = builder.build().toByteArray();
			System.out.println("device length : " + bytes.length);
			DeviceInfo deviceInfo = DeviceInfo.parseFrom(bytes);
			System.out.println("deviceName : " + deviceInfo.getDeviceName());
			long center = System.currentTimeMillis();
			System.out.println("protobuf time : " + (center - start));
			
			DeviceItem deviceItem = new DeviceItem("123456abcdefghq123456789", "127.0.0.1", "A810123456789");
			String str = deviceItem.toString();
			System.out.println("device length : " + str.length());
			DeviceItem device = DeviceItem.parse(str);
			System.out.println("deviceName : " + device.getDeviceName());
			long end = System.currentTimeMillis();
			System.out.println("json time : " + (end - center));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static class DeviceItem {
		private String deviceUid;
		private String deviceIp;
		private String deviceName;

		public DeviceItem(String deviceUid, String deviceIp, String deviceName) {
			this.deviceUid = deviceUid;
			this.deviceIp = deviceIp;
			this.deviceName = deviceName;
		}

		public String getDeviceUid() {
			return deviceUid;
		}

		public void setDeviceUid(String deviceUid) {
			this.deviceUid = deviceUid;
		}

		public String getDeviceIp() {
			return deviceIp;
		}

		public void setDeviceIp(String deviceIp) {
			this.deviceIp = deviceIp;
		}

		public String getDeviceName() {
			return deviceName;
		}

		public void setDeviceName(String deviceName) {
			this.deviceName = deviceName;
		}

		@Override
		public String toString() {
			return new Gson().toJson(this);
		}

		public static DeviceItem parse(String msg) {
			return new Gson().fromJson(msg, DeviceItem.class);
		}
	}

}
