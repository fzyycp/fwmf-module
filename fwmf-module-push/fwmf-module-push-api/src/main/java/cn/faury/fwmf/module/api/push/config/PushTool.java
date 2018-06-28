package cn.faury.fwmf.module.api.push.config;


/**
 * 推送工具
 */
public enum PushTool {

	/** 内部消息 */
	INPUSH("inpush"),
	/** 极光推送 */
	JPUSH("jpush"),
	/** 百度推送 */
	// BAIPUSH("baipush"),
	/** 小米推送 */
	// MIPUSH("mipush")
	;

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
	private PushTool(final String value) {
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
