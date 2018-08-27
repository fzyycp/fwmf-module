package cn.faury.fwmf.module.api.apptester.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * app测试用户信息Bean
 */
public class AppTesterBean implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	/* 主键 */
	private Long id;

	/* 用户ID */
	private Long userId;

	/* 登录名 */
	private String loginName;

	/* 用户姓名 */
	private String userName;

	/* 系统ID */
	private Long sysId;

	/* AppID */
	private Long appId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName
	 *            the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the sysId
	 */
	public Long getSysId() {
		return sysId;
	}

	/**
	 * @param sysId
	 *            the sysId to set
	 */
	public void setSysId(Long sysId) {
		this.sysId = sysId;
	}

	/**
	 * @return the appId
	 */
	public Long getAppId() {
		return appId;
	}

	/**
	 * @param appId
	 *            the appId to set
	 */
	public void setAppId(Long appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}

}
