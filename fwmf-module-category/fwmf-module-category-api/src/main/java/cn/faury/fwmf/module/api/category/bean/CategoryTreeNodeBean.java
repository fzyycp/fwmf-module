package cn.faury.fwmf.module.api.category.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分类信息Tree节点对象
 */
public class CategoryTreeNodeBean extends CategoryInfoBean {

	/**
	 * 子分类节点
	 */
	private List<CategoryTreeNodeBean> childrens;

	/** 节点属性 */
	private Map<String, String> attributes = new HashMap<>();

	/**
	 * 构造函数
	 */
	public CategoryTreeNodeBean() {
		super();
		this.childrens = new ArrayList<>();
	}

	/**
	 * 拷贝构造函数
	 */
	public CategoryTreeNodeBean(final CategoryInfoBean info) {
		this();
		if (info != null) {
			this.setCreatePersonName(info.getCreatePersonName());
			this.setCreateTime(info.getCreateTime());
			this.setDelFlag(info.getDelFlag());
			this.setDisplayOrder(info.getDisplayOrder());
			this.setParentId(info.getParentId());
			this.setProductCategoryId(info.getProductCategoryId());
			this.setProductCategoryName(info.getProductCategoryName());
			this.setTemplateId(info.getTemplateId());
			this.setUpdatePersonName(info.getUpdatePersonName());
			this.setUpdateTime(info.getUpdateTime());
			this.setXpath(info.getXpath());
			this.setCateTempId(info.getCateTempId());
		}
	}

	/**
	 * @return the childrens
	 */
	public List<CategoryTreeNodeBean> getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens
	 *            the childrens to set
	 */
	public void setChildrens(final List<CategoryTreeNodeBean> childrens) {
		this.childrens = childrens;
	}

	/**
	 * @return the attributes
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes
	 *            the attributes to set
	 */
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
}
