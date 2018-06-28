package cn.faury.fwmf.module.api.user.bean;


import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户列表信息
 */
public class UserListBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 3489129448138212554L;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 所属系统ID
	 */
	private Long originOsId;

	/**
	 * 用户登录名
	 */
	private String loginName;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * 用户类型
	 */
	private String resvFlg;

	/**
	 * 所属系统名称
	 */
	private String originOsName;

	/**
	 * 用户授权系统名称
	 */
	private String userRSystemName;

	/**
	 * 用户授权系统ID
	 */
	private String userRSystemId;

	/**
	 * 用户授权App名称
	 */
	private String userRAppName;

	/**
	 * 用户授权AppID
	 */
	private String userRAppId;

	/**
	 * 注册时间
	 */
	private Timestamp insTstmp;

	/**
	 * 是否启用：1启用，0禁用
	 */
	private String isEnable;

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
	public void setUserId(final Long userId) {
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
	public void setLoginName(final String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the originOsId
	 */
	public Long getOriginOsId() {
		return originOsId;
	}

	/**
	 * @param originOsId
	 *            the originOsId to set
	 */
	public void setOriginOsId(Long originOsId) {
		this.originOsId = originOsId;
	}

	/**
	 * @return the originOsName
	 */
	public String getOriginOsName() {
		return originOsName;
	}

	/**
	 * @param originOsName
	 *            the originOsName to set
	 */
	public void setOriginOsName(String originOsName) {
		this.originOsName = originOsName;
	}

	/**
	 * @return the userRSystemName
	 */
	public String getUserRSystemName() {
		return userRSystemName;
	}

	/**
	 * @param userRSystemName
	 *            the userRSystemName to set
	 */
	public void setUserRSystemName(String userRSystemName) {
		this.userRSystemName = userRSystemName;
	}

	/**
	 * @return the userRSystemId
	 */
	public String getUserRSystemId() {
		return userRSystemId;
	}

	/**
	 * @param userRSystemId
	 *            the userRSystemId to set
	 */
	public void setUserRSystemId(String userRSystemId) {
		this.userRSystemId = userRSystemId;
	}

	/**
	 * @return the userRAppName
	 */
	public String getUserRAppName() {
		return userRAppName;
	}

	/**
	 * @param userRAppName
	 *            the userRAppName to set
	 */
	public void setUserRAppName(String userRAppName) {
		this.userRAppName = userRAppName;
	}

	/**
	 * @return the userRAppId
	 */
	public String getUserRAppId() {
		return userRAppId;
	}

	/**
	 * @param userRAppId
	 *            the userRAppId to set
	 */
	public void setUserRAppId(String userRAppId) {
		this.userRAppId = userRAppId;
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
	 * @return the resvFlg
	 */
	public String getResvFlg() {
		return resvFlg;
	}

	/**
	 * @param resvFlg
	 *            the resvFlg to set
	 */
	public void setResvFlg(String resvFlg) {
		this.resvFlg = resvFlg;
	}

	/**
	 * @return the insTstmp
	 */
	public Timestamp getInsTstmp() {
		return insTstmp;
	}

	/**
	 * @param insTstmp
	 *            the insTstmp to set
	 */
	public void setInsTstmp(Timestamp insTstmp) {
		this.insTstmp = insTstmp;
	}

	/**
	 * @return the isEnable
	 */
	public String getIsEnable() {
		return isEnable;
	}

	/**
	 * @param isEnable
	 *            the isEnable to set
	 */
	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
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
