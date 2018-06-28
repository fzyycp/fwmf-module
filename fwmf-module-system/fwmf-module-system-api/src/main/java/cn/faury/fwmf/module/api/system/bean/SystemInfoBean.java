package cn.faury.fwmf.module.api.system.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;


/**
 * 业务系统对象Bean
 */
public class SystemInfoBean implements Serializable {

	/**
	 * 业务系统ID
	 */
	private Long systemId = null;

	/**
	 * 业务系统名称
	 */
	private String systemName = null;

	/**
	 * 业务系统编码
	 */
	private String systemCode = null;

	/**
	 * 是否可用【1:是 0:否】
	 */
	private String isAvailable = null;

	/**
	 * 获取systemId
	 *
	 * @return systemId
	 */
	public Long getSystemId() {
		return systemId;
	}

	/**
	 * 设置systemId
	 *
	 * @param systemId 值
	 */
	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	/**
	 * 获取systemName
	 *
	 * @return systemName
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * 设置systemName
	 *
	 * @param systemName 值
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	/**
	 * 获取systemCode
	 *
	 * @return systemCode
	 */
	public String getSystemCode() {
		return systemCode;
	}

	/**
	 * 设置systemCode
	 *
	 * @param systemCode 值
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	/**
	 * 获取isAvailable
	 *
	 * @return isAvailable
	 */
	public String getIsAvailable() {
		return isAvailable;
	}

	/**
	 * 设置isAvailable
	 *
	 * @param isAvailable 值
	 */
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}
}
