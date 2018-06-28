package cn.faury.fwmf.module.api.push.config;


/**
 * 推送设备类型
 */
public enum DeviceType {

	/** 安卓系统 */
	Android("android"),
	/** 苹果IOS系统 */
	IOS("ios"),
	/** 微软WP系统 */
	WinPhone("winphone");

	/**
	 * 参数值
	 */
	private final String value;

	/**
	 * 构造函数
	 * 
	 * @param value
	 *            参数值
	 */
	private DeviceType(final String value) {
		this.value = value;
	}

	/**
	 * 获取参数值
	 * 
	 * @return 参数值
	 */
	public String value() {
		return this.value;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.value();
	}

}
