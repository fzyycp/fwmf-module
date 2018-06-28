package cn.faury.fwmf.module.api.system.bean;


import cn.faury.fdk.common.utils.JsonUtil;

/**
 * 商店关联业务系统对象Bean
 */
public class ShopRSystemInfoBean extends SystemInfoBean {
	/**
	 * 唯一主键
	 */
	private Long id;

	/**
	 * 商店ID
	 */
	private Long shopId;

	/**
	 * 如果按照商店来合并所有的授权业务系统， 则保存合并后的多个业务系统ID，以逗号隔开
	 */
	private String concatSystemIds;

	/**
	 * 如果按照商店来合并所有的授权业务系统， 则保存合并后的多个业务系统名称，以逗号隔开
	 */
	private String concatSystemNames;

	/**
	 * 获取id
	 *
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置id
	 *
	 * @param id 值
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取shopId
	 *
	 * @return shopId
	 */
	public Long getShopId() {
		return shopId;
	}

	/**
	 * 设置shopId
	 *
	 * @param shopId 值
	 */
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	/**
	 * 获取concatSystemIds
	 *
	 * @return concatSystemIds
	 */
	public String getConcatSystemIds() {
		return concatSystemIds;
	}

	/**
	 * 设置concatSystemIds
	 *
	 * @param concatSystemIds 值
	 */
	public void setConcatSystemIds(String concatSystemIds) {
		this.concatSystemIds = concatSystemIds;
	}

	/**
	 * 获取concatSystemNames
	 *
	 * @return concatSystemNames
	 */
	public String getConcatSystemNames() {
		return concatSystemNames;
	}

	/**
	 * 设置concatSystemNames
	 *
	 * @param concatSystemNames 值
	 */
	public void setConcatSystemNames(String concatSystemNames) {
		this.concatSystemNames = concatSystemNames;
	}

	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}
}
