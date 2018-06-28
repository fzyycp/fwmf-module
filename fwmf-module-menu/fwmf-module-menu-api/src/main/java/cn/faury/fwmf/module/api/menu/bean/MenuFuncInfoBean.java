package cn.faury.fwmf.module.api.menu.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 菜单功能按钮Bean
 */
public class MenuFuncInfoBean implements Serializable {

	/**
	 * 功能菜单ID
	 */
	private Long funcId;

	/**
	 * 功能菜单名称
	 */
	private String funcName;

	/**
	 * 功能编码
	 */
	private String funcCode;

	/**
	 * 菜单ID
	 */
	private Long menuId;

	/**
	 * 业务系统ID
	 */
	private Long systemId;

	/**
	 * 是否可用【Y:是 N:否】
	 */
	private String isAvailable;

	/**
	 * @return the funcId
	 */
	public Long getFuncId() {
		return funcId;
	}

	/**
	 * @param funcId
	 *            the funcId to set
	 */
	public void setFuncId(final Long funcId) {
		this.funcId = funcId;
	}

	/**
	 * @return the funcName
	 */
	public String getFuncName() {
		return funcName;
	}

	/**
	 * @param funcName
	 *            the funcName to set
	 */
	public void setFuncName(final String funcName) {
		this.funcName = funcName;
	}

	/**
	 * @return the funcCode
	 */
	public String getFuncCode() {
		return funcCode;
	}

	/**
	 * @param funcCode
	 *            the funcCode to set
	 */
	public void setFuncCode(final String funcCode) {
		this.funcCode = funcCode;
	}

	/**
	 * @return the menuId
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 *            the menuId to set
	 */
	public void setMenuId(final Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the isAvailable
	 */
	public String getIsAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable
	 *            the isAvailable to set
	 */
	public void setIsAvailable(final String isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * @return the systemId
	 */
	public Long getSystemId() {
		return systemId;
	}

	/**
	 * @param systemId
	 *            the systemId to set
	 */
	public void setSystemId(Long systemId) {
		this.systemId = systemId;
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
