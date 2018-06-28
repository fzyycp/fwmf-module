package cn.faury.fwmf.module.api.user.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 红包用户组信息
 */
public class RedRUserGroupsBean implements Serializable {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 红包ID
	 */
	private Long redId;

	/**
	 * 群ID
	 */
	private Long groupId;

	/**
	 * 群名称
	 */
	private String groupName;

	/**
	 * 人数
	 */
	private Integer num;

	/**
	 * 所属系统
	 */
	private Long systemId;

	/**
	 * 所属系统名称
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
	 * @return the redId
	 */
	public Long getRedId() {
		return redId;
	}

	/**
	 * @param redId
	 *            the redId to set
	 */
	public void setRedId(Long redId) {
		this.redId = redId;
	}

	/**
	 * @return the groupId
	 */
	public Long getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @param num
	 *            the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
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
