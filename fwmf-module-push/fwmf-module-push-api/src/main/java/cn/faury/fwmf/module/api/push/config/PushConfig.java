package cn.faury.fwmf.module.api.push.config;

import cn.faury.fdk.common.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * 推送参数
 */
public class PushConfig {

	/**
	 * 默认发送时间：60秒
	 */
	public static final Long DEFAULT_SEND_TIME = 60L;

	/**
	 * 推送工具
	 */
	private PushTool pushTool;

	/**
	 * 推送设备列表
	 */
	private List<DeviceType> deviceTypes;

	/**
	 * 待发送时间戳(必须在当前时间60s以外，1年（31536000s）以内)
	 */
	private Long sendTime;

	/**
	 * 构造函数
	 */
	public PushConfig(PushTool pt, List<DeviceType> dts, Long sendTime) {
		this.pushTool = pt;
		this.deviceTypes = dts;
		this.sendTime = sendTime;
	}

	/**
	 * 构造函数
	 */
	public PushConfig(PushTool pt, List<DeviceType> dts) {
		this(pt, dts, DEFAULT_SEND_TIME);
	}

	/**
	 * 构造函数
	 */
	public PushConfig(PushTool pt) {
		this(pt, new ArrayList<DeviceType>());
	}

	/**
	 * 构造函数
	 */
	public PushConfig() {
		this(PushTool.INPUSH);
	}

	/**
	 * @return the pushTool
	 */
	public final PushTool getPushTool() {
		return pushTool;
	}

	/**
	 * @return the deviceTypes
	 */
	public final List<DeviceType> getDeviceTypes() {
		return deviceTypes;
	}

	/**
	 * @return the sendTime
	 */
	public final Long getSendTime() {
		return sendTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}

}
