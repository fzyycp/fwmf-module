/**
 *  业务平台：ssk-platform-service-category
 * 
 * @date 2015年12月14日
 * @author yn.yin
 *
 * 版权所有：南京扫扫看数字科技有限公司
 */
package cn.faury.fwmf.module.api.category.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 红包商品信息
 */
public class RedRCategoryBean implements Serializable {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 红包ID
	 */
	private Long redId;

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
