package cn.faury.fwmf.module.api.user.bean;


import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 平台用户组织关系
 */

public class RoleRUserBean implements Serializable {

	/**
	 * 用户ID
	 */
	private Long id;

	/**
	 * 角色ID
	 */
	private Long roleId;

	/**
	 * 用户类别（启用用户，测试用户）
	 */
	private String resvFlag;

	/**
	 * 用户登录名
	 */
	private String accName;

	/**
	 * 用户姓名
	 */
	private String userName;

	/**
	 * 系统名称
	 */
	private String systemName;

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
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the resvFlag
	 */
	public String getResvFlag() {
		return resvFlag;
	}

	/**
	 * @param resvFlag
	 *            the resvFlag to set
	 */
	public void setResvFlag(String resvFlag) {
		this.resvFlag = resvFlag;
	}

	/**
	 * @return the accName
	 */
	public String getAccName() {
		return accName;
	}

	/**
	 * @param accName
	 *            the accName to set
	 */
	public void setAccName(String accName) {
		this.accName = accName;
	}

	/**
	 * @return the systemName
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * @param systemName
	 *            the systemName to set
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
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
