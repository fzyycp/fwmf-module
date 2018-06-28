package cn.faury.fwmf.module.api.user.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * 用户群信息
 */
public class UserGroupsInfoBean implements Serializable {
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
	 * 群用户
	 */
	private List<UserInfoBean> users;
	
	private String groupType;
	
	private String groupMemo;
	
	private Date availableStartDate;
	
	private Date availableEndDate;
	
	private Long createPerson;
	
	private String createPersonName;
	
	private Date createTime;
	
	private Long updatePerson;
	
	private String updatePersonName;
	
	private Date updateTime;
	
	private String delFlag;
	
	
	
	/**
	 * @return the groupId
	 */
	public Long getGroupId() {
		return groupId;
	}


	/**
	 * @param groupId the groupId to set
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
	 * @param groupName the groupName to set
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
	 * @param num the num to set
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
	 * @param systemId the systemId to set
	 */
	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}


	/**
	 * @return the users
	 */
	public List<UserInfoBean> getUsers() {
		return users;
	}


	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserInfoBean> users) {
		this.users = users;
	}
	

	/**
	 * @return the systemName
	 */
	public String getSystemName() {
		return systemName;
	}


	/**
	 * @param systemName the systemName to set
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}


	/**
	 * @return the groupType
	 */
	public String getGroupType() {
		return groupType;
	}


	/**
	 * @param groupType the groupType to set
	 */
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}


	/**
	 * @return the groupMemo
	 */
	public String getGroupMemo() {
		return groupMemo;
	}


	/**
	 * @param groupMemo the groupMemo to set
	 */
	public void setGroupMemo(String groupMemo) {
		this.groupMemo = groupMemo;
	}


	/**
	 * @return the availableStartDate
	 */
	public Date getAvailableStartDate() {
		return availableStartDate;
	}


	/**
	 * @param availableStartDate the availableStartDate to set
	 */
	public void setAvailableStartDate(Date availableStartDate) {
		this.availableStartDate = availableStartDate;
	}


	/**
	 * @return the availableEndDate
	 */
	public Date getAvailableEndDate() {
		return availableEndDate;
	}


	/**
	 * @param availableEndDate the availableEndDate to set
	 */
	public void setAvailableEndDate(Date availableEndDate) {
		this.availableEndDate = availableEndDate;
	}


	/**
	 * @return the createPerson
	 */
	public Long getCreatePerson() {
		return createPerson;
	}


	/**
	 * @param createPerson the createPerson to set
	 */
	public void setCreatePerson(Long createPerson) {
		this.createPerson = createPerson;
	}


	/**
	 * @return the createPersonName
	 */
	public String getCreatePersonName() {
		return createPersonName;
	}


	/**
	 * @param createPersonName the createPersonName to set
	 */
	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}


	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}


	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	/**
	 * @return the updatePerson
	 */
	public Long getUpdatePerson() {
		return updatePerson;
	}


	/**
	 * @param updatePerson the updatePerson to set
	 */
	public void setUpdatePerson(Long updatePerson) {
		this.updatePerson = updatePerson;
	}


	/**
	 * @return the updatePersonName
	 */
	public String getUpdatePersonName() {
		return updatePersonName;
	}


	/**
	 * @param updatePersonName the updatePersonName to set
	 */
	public void setUpdatePersonName(String updatePersonName) {
		this.updatePersonName = updatePersonName;
	}


	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}


	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	/**
	 * @return the delFlag
	 */
	public String getDelFlag() {
		return delFlag;
	}


	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
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
