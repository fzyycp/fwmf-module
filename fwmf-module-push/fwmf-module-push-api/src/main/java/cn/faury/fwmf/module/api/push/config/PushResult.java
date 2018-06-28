package cn.faury.fwmf.module.api.push.config;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;


/**
 * 推送结果
 */
public class PushResult implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -319940703033199953L;

	/**
	 * 是否成功
	 */
	private Boolean success;

	/**
	 * 成功返回的推送消息ID
	 */
	private Long msgId;

	/**
	 * 失败返回的异常消息
	 */
	private String exceptionMsg;

	/**
	 * 构造函数
	 * 
	 * @param success
	 *            是否成功
	 * @param msgId
	 *            消息ID
	 * @param exceptionMsg
	 *            异常消息
	 */
	private PushResult(Boolean success, Long msgId, String exceptionMsg) {
		this.success = success;
		this.msgId = msgId;
		this.exceptionMsg = exceptionMsg;
	}

	/**
	 * 创建成功的返回对象
	 * 
	 * @param msgId
	 *            消息ID
	 * @return 结果对象
	 */
	public static PushResult createSuccess(Long msgId) {
		return new PushResult(Boolean.TRUE, msgId, "");
	}

	/**
	 * 创建成功的返回对象
	 * 
	 * @param exceptionMsg
	 *            异常信息
	 * @return 结果对象
	 */
	public static PushResult createFailed(String exceptionMsg) {
		return new PushResult(Boolean.FALSE, -1L, exceptionMsg);
	}

	/**
	 * @return the success
	 */
	public final Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public final void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the msgId
	 */
	public final Long getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId
	 *            the msgId to set
	 */
	public final void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	/**
	 * @return the exceptionMsg
	 */
	public final String getExceptionMsg() {
		return exceptionMsg;
	}

	/**
	 * @param exceptionMsg
	 *            the exceptionMsg to set
	 */
	public final void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}


	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}

}
