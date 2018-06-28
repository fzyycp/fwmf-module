package cn.faury.fwmf.module.api.push.config;


/**
 * 推送消息状态
 */
public enum PushMessageState {

	/**
	 * 1：保存
	 */
	SAVE(1),
	/**
	 * 2：已提交待审核
	 */
	SUBMITTED(2),
	/**
	 * 3：已审核待推送
	 */
	APPROVED(3),
	/**
	 * 4：已推送
	 */
	PUSHED(4),
	/**
	 * 5：停用
	 */
	DISABLED(5),
	/**
	 * 6：退回
	 */
	ROLLBACK(6),
	/**
	 * 7:极光
	 */
	JPUSH(7);

	/**
	 * 参数值
	 */
	private final Integer value;

	/**
	 * 构造函数
	 * 
	 * @param value
	 *            参数值
	 */
	private PushMessageState(final Integer value) {
		this.value = value;
	}

	/**
	 * 获取参数值
	 * 
	 * @return 参数值
	 */
	public Integer value() {
		return this.value;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value());
	}

}
