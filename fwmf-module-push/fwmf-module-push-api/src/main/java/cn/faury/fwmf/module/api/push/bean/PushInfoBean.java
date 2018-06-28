package cn.faury.fwmf.module.api.push.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * 推送信息Bean
 */
public class PushInfoBean implements Serializable {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 消息id
	 */
	private Long messageId = null;

	/** 商品ID **/
	private Long goodsId = null;

	/** 用户ID **/
	private Long uId = null;

	/** 用户群ID **/
	private Long gId = null;

	/** 系统业务 **/
	private Long sysId = null;

	/** 标题 **/
	private String messageTitle = null;

	/** 介绍 **/
	private String messageIntroduction = null;

	/** 推送日期 **/
	private Date pushDate = null;

	/** 截止日期 **/
	private Date endDate = null;

	/** 状态 1：保存 2：待审核 3：待推送 4：已推送 5：停用' **/
	private Integer state = null;

	/** 类型（0：普通，1：微阅读） **/
	private Integer type = null;

	/** 创建人ID **/
	private Long createPerson = null;

	/** 创建人名称 **/
	private String createPersonName = null;

	/** 创建时间 **/
	private String createTime = null;

	/** 修改人ID **/
	private Long updatePerson = null;

	/** 修改人名称 **/
	private String updatePersonName = null;

	/** 修改时间 **/
	private String updateTime = null;

	/** 删除标记 **/
	private String delFlag = null;

	/** 推送类型 */
	private String pushType = null;

	/**
	 * IOS推送是否正式版
	 */
	private String isApnsProduction = null;

	/**
	 * 离线消息保留时常（秒）
	 */
	private Long timeToLive = null;

	/**
	 * 2、推送信息内容表 t_push_message_content_info
	 */
	/** 推送内容 **/
	private String messageContent = null;

	/**
	 * 3、推送信息统计表 t_push_message_count
	 */
	/** 推送总数 **/
	private Integer totalCount = null;

	/** 推送次数 **/
	private Integer pushCount = null;

	/** 阅读次数 **/
	private Integer readCount = null;

	/**
	 * 4、推送客户群关联表 t_push_r_customer_group
	 */
	/** 客户群ID **/
	private Long customerGroupId = null;

	/** 客户群名称 **/
	private String customerGroupName = null;

	/** 客户群ID集 **/
	private String customerGroupIds = null;

	/** 客户群名称集 **/
	private String customerGroupNames = null;

	/**
	 * 5、推送商品关联表 t_push_message_goods
	 */
	/** 商品ID集 **/
	private String pushGoodsIds = null;

	/** 商品名称集 **/
	private String pushGoodsNames = null;

	/**
	 * 6、推送微阅读表 t_push_message_webeditor
	 */
	/** 微阅读id **/
	private Long webEditorId = null;

	/** 微阅读名称 **/
	private String infoName = null;

	/**
	 * 7、推送关联用户表 t_push_r_customer_user
	 */
	/** 推送用户Id **/
	private Long userId;

	/** 推送用户Id集 **/
	private String userIds;

	/** 推送用户名称集 **/
	private String userNames;

	/**
	 * 8、推送关联目标APP表 t_push_r_app
	 */
	/** APP Id **/
	private Long appId;

	private String appIds;

	private String appNames;

	/** 全部、固定用户阅读表 t_push_message_read */
	/* 是否已读 */
	private String isRead;

	/* 阅读时间 */
	private String readTime;

	/* 推送获取时间 */
	private String pushTime;

	/* 商品属性 */
	private String codeNumber;

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
	 * @return the messageId
	 */
	public Long getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId
	 *            the messageId to set
	 */
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the goodsId
	 */
	public Long getGoodsId() {
		return goodsId;
	}

	/**
	 * @param goodsId
	 *            the goodsId to set
	 */
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * @return the uId
	 */
	public Long getuId() {
		return uId;
	}

	/**
	 * @param uId
	 *            the uId to set
	 */
	public void setuId(Long uId) {
		this.uId = uId;
	}

	/**
	 * @return the gId
	 */
	public Long getgId() {
		return gId;
	}

	/**
	 * @param gId
	 *            the gId to set
	 */
	public void setgId(Long gId) {
		this.gId = gId;
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
	 * @return the messageTitle
	 */
	public String getMessageTitle() {
		return messageTitle;
	}

	/**
	 * @param messageTitle
	 *            the messageTitle to set
	 */
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	/**
	 * @return the messageIntroduction
	 */
	public String getMessageIntroduction() {
		return messageIntroduction;
	}

	/**
	 * @param messageIntroduction
	 *            the messageIntroduction to set
	 */
	public void setMessageIntroduction(String messageIntroduction) {
		this.messageIntroduction = messageIntroduction;
	}

	/**
	 * @return the pushDate
	 */
	public Date getPushDate() {
		return pushDate;
	}

	/**
	 * @param pushDate
	 *            the pushDate to set
	 */
	public void setPushDate(Date pushDate) {
		this.pushDate = pushDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the createPerson
	 */
	public Long getCreatePerson() {
		return createPerson;
	}

	/**
	 * @param createPerson
	 *            the createPerson to set
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
	 * @param createPersonName
	 *            the createPersonName to set
	 */
	public void setCreatePersonName(String createPersonName) {
		this.createPersonName = createPersonName;
	}

	/**
	 * @return the updatePerson
	 */
	public Long getUpdatePerson() {
		return updatePerson;
	}

	/**
	 * @param updatePerson
	 *            the updatePerson to set
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
	 * @param updatePersonName
	 *            the updatePersonName to set
	 */
	public void setUpdatePersonName(String updatePersonName) {
		this.updatePersonName = updatePersonName;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the delFlag
	 */
	public String getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag
	 *            the delFlag to set
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * @return the pushType
	 */
	public String getPushType() {
		return pushType;
	}

	/**
	 * @param pushType
	 *            the pushType to set
	 */
	public void setPushType(String pushType) {
		this.pushType = pushType;
	}

	/**
	 * @return the messageContent
	 */
	public String getMessageContent() {
		return messageContent;
	}

	/**
	 * @param messageContent
	 *            the messageContent to set
	 */
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	/**
	 * @return the totalCount
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the pushCount
	 */
	public Integer getPushCount() {
		return pushCount;
	}

	/**
	 * @param pushCount
	 *            the pushCount to set
	 */
	public void setPushCount(Integer pushCount) {
		this.pushCount = pushCount;
	}

	/**
	 * @return the readCount
	 */
	public Integer getReadCount() {
		return readCount;
	}

	/**
	 * @param readCount
	 *            the readCount to set
	 */
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	/**
	 * @return the customerGroupId
	 */
	public Long getCustomerGroupId() {
		return customerGroupId;
	}

	/**
	 * @param customerGroupId
	 *            the customerGroupId to set
	 */
	public void setCustomerGroupId(Long customerGroupId) {
		this.customerGroupId = customerGroupId;
	}

	/**
	 * @return the customerGroupName
	 */
	public String getCustomerGroupName() {
		return customerGroupName;
	}

	/**
	 * @param customerGroupName
	 *            the customerGroupName to set
	 */
	public void setCustomerGroupName(String customerGroupName) {
		this.customerGroupName = customerGroupName;
	}

	/**
	 * @return the customerGroupIds
	 */
	public String getCustomerGroupIds() {
		return customerGroupIds;
	}

	/**
	 * @param customerGroupIds
	 *            the customerGroupIds to set
	 */
	public void setCustomerGroupIds(String customerGroupIds) {
		this.customerGroupIds = customerGroupIds;
	}

	/**
	 * @return the customerGroupNames
	 */
	public String getCustomerGroupNames() {
		return customerGroupNames;
	}

	/**
	 * @param customerGroupNames
	 *            the customerGroupNames to set
	 */
	public void setCustomerGroupNames(String customerGroupNames) {
		this.customerGroupNames = customerGroupNames;
	}

	/**
	 * @return the pushGoodsIds
	 */
	public String getPushGoodsIds() {
		return pushGoodsIds;
	}

	/**
	 * @param pushGoodsIds
	 *            the pushGoodsIds to set
	 */
	public void setPushGoodsIds(String pushGoodsIds) {
		this.pushGoodsIds = pushGoodsIds;
	}

	/**
	 * @return the pushGoodsNames
	 */
	public String getPushGoodsNames() {
		return pushGoodsNames;
	}

	/**
	 * @param pushGoodsNames
	 *            the pushGoodsNames to set
	 */
	public void setPushGoodsNames(String pushGoodsNames) {
		this.pushGoodsNames = pushGoodsNames;
	}

	/**
	 * @return the webEditorId
	 */
	public Long getWebEditorId() {
		return webEditorId;
	}

	/**
	 * @param webEditorId
	 *            the webEditorId to set
	 */
	public void setWebEditorId(Long webEditorId) {
		this.webEditorId = webEditorId;
	}

	/**
	 * @return the infoName
	 */
	public String getInfoName() {
		return infoName;
	}

	/**
	 * @param infoName
	 *            the infoName to set
	 */
	public void setInfoName(String infoName) {
		this.infoName = infoName;
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
	 * @return the userIds
	 */
	public String getUserIds() {
		return userIds;
	}

	/**
	 * @param userIds
	 *            the userIds to set
	 */
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	/**
	 * @return the userNames
	 */
	public String getUserNames() {
		return userNames;
	}

	/**
	 * @param userNames
	 *            the userNames to set
	 */
	public void setUserNames(String userNames) {
		this.userNames = userNames;
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

	/**
	 * @return the appIds
	 */
	public String getAppIds() {
		return appIds;
	}

	/**
	 * @param appIds
	 *            the appIds to set
	 */
	public void setAppIds(String appIds) {
		this.appIds = appIds;
	}

	/**
	 * @return the appNames
	 */
	public String getAppNames() {
		return appNames;
	}

	/**
	 * @param appNames
	 *            the appNames to set
	 */
	public void setAppNames(String appNames) {
		this.appNames = appNames;
	}

	/**
	 * @return the isRead
	 */
	public String getIsRead() {
		return isRead;
	}

	/**
	 * @param isRead
	 *            the isRead to set
	 */
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	/**
	 * @return the readTime
	 */
	public String getReadTime() {
		return readTime;
	}

	/**
	 * @param readTime
	 *            the readTime to set
	 */
	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

	/**
	 * @return the pushTime
	 */
	public String getPushTime() {
		return pushTime;
	}

	/**
	 * @param pushTime
	 *            the pushTime to set
	 */
	public void setPushTime(String pushTime) {
		this.pushTime = pushTime;
	}

	/**
	 * @return the codeNumber
	 */
	public String getCodeNumber() {
		return codeNumber;
	}

	/**
	 * @param codeNumber
	 *            the codeNumber to set
	 */
	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}

	/**
	 * @return the isApnsProduction
	 */
	public String getIsApnsProduction() {
		return isApnsProduction;
	}

	/**
	 * @param isApnsProduction
	 *            the isApnsProduction to set
	 */
	public void setIsApnsProduction(String isApnsProduction) {
		this.isApnsProduction = isApnsProduction;
	}

	/**
	 * @return the timeToLive
	 */
	public Long getTimeToLive() {
		return timeToLive;
	}

	/**
	 * @param timeToLive
	 *            the timeToLive to set
	 */
	public void setTimeToLive(Long timeToLive) {
		this.timeToLive = timeToLive;
	}

	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}

}
