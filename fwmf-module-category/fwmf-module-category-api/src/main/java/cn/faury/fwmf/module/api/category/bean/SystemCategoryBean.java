package cn.faury.fwmf.module.api.category.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 系统商品分类授权Bean
 */
public class SystemCategoryBean extends CategoryInfoBean implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 系统Id
	 */
	private Long systemId;

	/**
	 * 系统code
	 */
	private String systemCode;

	/**
	 * 是否叶子节点
	 */
	private String isLeaf;

	/**
	 * 分类Id集合
	 */
	private List<Long> categoryIds;

	/**
	 * @return the categoryIds
	 */
	public List<Long> getCategoryIds() {
		return categoryIds;
	}

	/**
	 * @param categoryIds
	 *            the categoryIds to set
	 */
	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	/**
	 * @return the isLeaf
	 */
	public String getIsLeaf() {
		return isLeaf;
	}

	/**
	 * @param isLeaf
	 *            the isLeaf to set
	 */
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	/**
	 * 系统Name
	 */
	private String systemName;

	public Long getSystemId() {
		return systemId;
	}

	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getSystemName() {
		return systemName;
	}

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
