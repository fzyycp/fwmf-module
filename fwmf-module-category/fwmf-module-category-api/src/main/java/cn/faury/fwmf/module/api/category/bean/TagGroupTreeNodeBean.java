package cn.faury.fwmf.module.api.category.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签组信息TreeNode
 */
public class TagGroupTreeNodeBean extends TagGroupInfoBean {

	/**
	 * 子节点
	 */
	private List<TagGroupTreeNodeBean> childrens;

	/**
	 * 构造函数
	 */
	public TagGroupTreeNodeBean() {
		super();
		this.childrens = new ArrayList<TagGroupTreeNodeBean>();
	}

	/**
	 * 拷贝构造函数
	 */
	public TagGroupTreeNodeBean(final TagGroupInfoBean tagInfo) {
		this();
		if (tagInfo != null) {
			this.setTagProductId(tagInfo.getTagProductId());
			this.setTagProductName(tagInfo.getTagProductName());
			this.setTagProductType(tagInfo.getTagProductType());
			this.setParentId(tagInfo.getParentId());
			this.setXpath(tagInfo.getXpath());
			this.setProductCategoryId(tagInfo.getProductCategoryId());
			this.setValues(tagInfo.getValues());
		}
	}

	/**
	 * @return the childrens
	 */
	public List<TagGroupTreeNodeBean> getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens
	 *            the childrens to set
	 */
	public void setChildrens(final List<TagGroupTreeNodeBean> childrens) {
		this.childrens = childrens;
	}
}
