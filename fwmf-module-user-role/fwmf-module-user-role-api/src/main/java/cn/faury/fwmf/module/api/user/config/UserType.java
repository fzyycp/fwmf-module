package cn.faury.fwmf.module.api.user.config;

/**
 * 用户类型
 * 
 * <pre>
 * 0:框架用户，1:业务系统用户，
 * 3:购物用户，9:游客
 * </pre>
 */
public enum UserType {

	/** 0:平台用户 */
	FWMF("0", "框架用户"),
	/** 1:业务系统用户(原商店用户) */
	SYSTEM("1", "业务系统用户"),
	/** 3:购物用户 */
	SHOPPING("3", "购物用户"),
	/** 9:游客 */
	GUEST("9", "游客");

	/**
	 * 值
	 */
	private String value;

	/**
	 * 描述
	 */
	private String desc;

	/**
	 * 构造函数
	 * 
	 * @param value
	 *            值
	 */
	private UserType(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	/**
	 * @return the value
	 */
	public final String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public final void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.getValue();
	}

}
