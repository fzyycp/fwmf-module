package cn.faury.fwmf.module.api.category.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 优惠商品信息
 */
public class DiscusRCategoryBean implements Serializable {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 优惠ID
	 */
	private Long discusId;

	/**
	 * 主键,分类ID
	 */
	private Long productCategoryId;

	/**
	 * 分类名称
	 */
	private String productCategoryName;

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
	 * @return the discusId
	 */
	public Long getDiscusId() {
		return discusId;
	}

	/**
	 * @param discusId
	 *            the discusId to set
	 */
	public void setDiscusId(Long discusId) {
		this.discusId = discusId;
	}

	/**
	 * @return the productCategoryId
	 */
	public Long getProductCategoryId() {
		return productCategoryId;
	}

	/**
	 * @param productCategoryId
	 *            the productCategoryId to set
	 */
	public void setProductCategoryId(Long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	/**
	 * @return the productCategoryName
	 */
	public String getProductCategoryName() {
		return productCategoryName;
	}

	/**
	 * @param productCategoryName
	 *            the productCategoryName to set
	 */
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
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
