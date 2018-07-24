package cn.faury.fwmf.module.api.shop.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 商店信息Bean
 */
public class ShopInfoBean implements Serializable {

	/** 商店ID SHOP_ID */
	private Long shopId;

	/** 商店名称 */
	private String shopName;

	/** 商店简称 */
	private String shortName;

	/** 店主用户 ID */
	private Long shopKeeperId;

	/** 店主用户 登录名 */
	private String shopKeeperName;

	/** 店主用户姓名 */
	private String shopKeeperUserName;

	/** 比例分配 */
	private String allocatRatio;

	/** 商店状态 */
	private String shopState;

	/**
	 * 支付方式
	 */
	private String payStyle;

	/**
	 * 省市县编码
	 */
	private String areaCode;

	/**
	 * 详细地址
	 */
	private String address;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 来源系统
	 */
	private Long originSystem;

	/** 创建者 */
	private String createPerson;

	/** 创建时间 */
	private Timestamp createTime;

	/** 更新者 */
	private String updatePerson;

	/** 更新时间 */
	private Timestamp updateTime;

	/** 删除标志 */
	private String delFlag;

	/**
	 * 商店授权系统IDS
	 */
	private String shopRSystemIds;

	/**
	 * 商店授权系统名称
	 */
	private String shopRSystemNames;

	/**
	 * 商店授权APPIDS
	 */
	private String shopRAppIds;

	/**
	 * 商店授权APP名称
	 */
	private String shopRAppNames;

	/**
	 * @return the shopId
	 */
	public Long getShopId() {
		return shopId;
	}

	/**
	 * @param shopId
	 *            the shopId to set
	 */
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	/**
	 * @return the shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * @param shopName
	 *            the shopName to set
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * @return the shortName
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * @param shortName
	 *            the shortName to set
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * @return the shopKeeperId
	 */
	public Long getShopKeeperId() {
		return shopKeeperId;
	}

	/**
	 * @param shopKeeperId
	 *            the shopKeeperId to set
	 */
	public void setShopKeeperId(Long shopKeeperId) {
		this.shopKeeperId = shopKeeperId;
	}

	/**
	 * @return the allocatRatio
	 */
	public String getAllocatRatio() {
		return allocatRatio;
	}

	/**
	 * @return the shopKeeperName
	 */
	public String getShopKeeperName() {
		return shopKeeperName;
	}

	/**
	 * @param shopKeeperName
	 *            the shopKeeperName to set
	 */
	public void setShopKeeperName(String shopKeeperName) {
		this.shopKeeperName = shopKeeperName;
	}

	/**
	 * @return the shopKeeperUserName
	 */
	public String getShopKeeperUserName() {
		return shopKeeperUserName;
	}

	/**
	 * @param shopKeeperUserName
	 *            the shopKeeperUserName to set
	 */
	public void setShopKeeperUserName(String shopKeeperUserName) {
		this.shopKeeperUserName = shopKeeperUserName;
	}

	/**
	 * @param allocatRatio
	 *            the allocatRatio to set
	 */
	public void setAllocatRatio(String allocatRatio) {
		this.allocatRatio = allocatRatio;
	}

	/**
	 * @return the shopState
	 */
	public String getShopState() {
		return shopState;
	}

	/**
	 * @param shopState
	 *            the shopState to set
	 */
	public void setShopState(String shopState) {
		this.shopState = shopState;
	}

	/**
	 * @return the payStyle
	 */
	public String getPayStyle() {
		return payStyle;
	}

	/**
	 * @param payStyle
	 *            the payStyle to set
	 */
	public void setPayStyle(String payStyle) {
		this.payStyle = payStyle;
	}

	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode
	 *            the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the createPerson
	 */
	public String getCreatePerson() {
		return createPerson;
	}

	/**
	 * @param createPerson
	 *            the createPerson to set
	 */
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}

	/**
	 * @return the updatePerson
	 */
	public String getUpdatePerson() {
		return updatePerson;
	}

	/**
	 * @param updatePerson
	 *            the updatePerson to set
	 */
	public void setUpdatePerson(String updatePerson) {
		this.updatePerson = updatePerson;
	}

	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Timestamp updateTime) {
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
	 * @return the shopRSystemIds
	 */
	public String getShopRSystemIds() {
		return shopRSystemIds;
	}

	/**
	 * @param shopRSystemIds
	 *            the shopRSystemIds to set
	 */
	public void setShopRSystemIds(String shopRSystemIds) {
		this.shopRSystemIds = shopRSystemIds;
	}

	/**
	 * @return the shopRSystemNames
	 */
	public String getShopRSystemNames() {
		return shopRSystemNames;
	}

	/**
	 * @param shopRSystemNames
	 *            the shopRSystemNames to set
	 */
	public void setShopRSystemNames(String shopRSystemNames) {
		this.shopRSystemNames = shopRSystemNames;
	}

	/**
	 * @return the shopRAppIds
	 */
	public String getShopRAppIds() {
		return shopRAppIds;
	}

	/**
	 * @param shopRAppIds
	 *            the shopRAppIds to set
	 */
	public void setShopRAppIds(String shopRAppIds) {
		this.shopRAppIds = shopRAppIds;
	}

	/**
	 * @return the shopRAppNames
	 */
	public String getShopRAppNames() {
		return shopRAppNames;
	}

	/**
	 * @param shopRAppNames
	 *            the shopRAppNames to set
	 */
	public void setShopRAppNames(String shopRAppNames) {
		this.shopRAppNames = shopRAppNames;
	}

	/**
	 * @return the originSystem
	 */
	public Long getOriginSystem() {
		return originSystem;
	}

	/**
	 * @param originSystem
	 *            the originSystem to set
	 */
	public void setOriginSystem(Long originSystem) {
		this.originSystem = originSystem;
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
