package cn.faury.fwmf.module.api.category.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 标签信息Bean
 */
public class TagInfoBean implements Serializable {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 8367276774746743137L;

	/**
	 * 标签ID
	 */
	private Long tagProductId;

	/**
	 * 标签名称
	 */
	private String tagProductName;

	/**
	 * 标签类型
	 */
	private String tagProductType;

	/**
	 * 父标签ID
	 */
	private Long parentId;

	/**
	 * 全路径
	 */
	private String xpath;

	/**
	 * 所属分类ID（只在关联查询时使用，不一定有值）
	 */
	private Long productCategoryId;

	/**
	 * @return the tagProductId
	 */
	public Long getTagProductId() {
		return tagProductId;
	}

	/**
	 * @param tagProductId
	 *            the tagProductId to set
	 */
	public void setTagProductId(final Long tagProductId) {
		this.tagProductId = tagProductId;
	}

	/**
	 * @return the tagProductName
	 */
	public String getTagProductName() {
		return tagProductName;
	}

	/**
	 * @param tagProductName
	 *            the tagProductName to set
	 */
	public void setTagProductName(final String tagProductName) {
		this.tagProductName = tagProductName;
	}

	/**
	 * @return the tagProductType
	 */
	public String getTagProductType() {
		return tagProductType;
	}

	/**
	 * @param tagProductType
	 *            the tagProductType to set
	 */
	public void setTagProductType(final String tagProductType) {
		this.tagProductType = tagProductType;
	}

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(final Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the xpath
	 */
	public String getXpath() {
		return xpath;
	}

	/**
	 * @param xpath
	 *            the xpath to set
	 */
	public void setXpath(final String xpath) {
		this.xpath = xpath;
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
	public void setProductCategoryId(final Long productCategoryId) {
		this.productCategoryId = productCategoryId;
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
