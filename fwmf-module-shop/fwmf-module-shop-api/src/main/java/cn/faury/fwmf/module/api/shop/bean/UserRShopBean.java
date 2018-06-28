package cn.faury.fwmf.module.api.shop.bean;


import cn.faury.fdk.common.utils.JsonUtil;

/**
 * 用户关联商店
 */
public class UserRShopBean extends ShopInfoBean {

	private Long shopUserId;

	private String shopLoginName;

	private String shopUserName;

	private String isSelfCreate;

	/**
	 * @return the shopUserId
	 */
	public Long getShopUserId() {
		return shopUserId;
	}

	/**
	 * @param shopUserId
	 *            the shopUserId to set
	 */
	public void setShopUserId(Long shopUserId) {
		this.shopUserId = shopUserId;
	}

	/**
	 * @return the shopLoginName
	 */
	public String getShopLoginName() {
		return shopLoginName;
	}

	/**
	 * @param shopLoginName
	 *            the shopLoginName to set
	 */
	public void setShopLoginName(String shopLoginName) {
		this.shopLoginName = shopLoginName;
	}

	/**
	 * @return the shopUserName
	 */
	public String getShopUserName() {
		return shopUserName;
	}

	/**
	 * @param shopUserName
	 *            the shopUserName to set
	 */
	public void setShopUserName(String shopUserName) {
		this.shopUserName = shopUserName;
	}

	/**
	 * @return the isSelfCreate
	 */
	public String getIsSelfCreate() {
		return isSelfCreate;
	}

	/**
	 * @param isSelfCreate
	 *            the isSelfCreate to set
	 */
	public void setIsSelfCreate(String isSelfCreate) {
		this.isSelfCreate = isSelfCreate;
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
