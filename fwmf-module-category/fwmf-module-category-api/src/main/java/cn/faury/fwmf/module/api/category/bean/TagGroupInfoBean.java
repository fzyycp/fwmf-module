package cn.faury.fwmf.module.api.category.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签组Bean对象
 */
public class TagGroupInfoBean extends TagInfoBean {
	/**
	 * 标签组类型：01
	 */
	public final static String TAG_TYPE_GROUP = "01";

	/**
	 * 标签值
	 */
	private List<TagValueInfoBean> values;

	/**
	 * 构造函数
	 */
	public TagGroupInfoBean() {
		super();
		super.setTagProductType(TAG_TYPE_GROUP);
		this.values = new ArrayList<TagValueInfoBean>();
	}

	/**
	 * 拷贝构造函数
	 * @param tag
	 */
	public TagGroupInfoBean(final TagInfoBean tag) {
		this();
		if (tag != null && TAG_TYPE_GROUP.equals(tag.getTagProductType())) {
			this.setTagProductId(tag.getParentId());
			this.setTagProductName(tag.getTagProductName());
			this.setTagProductType(TAG_TYPE_GROUP);
			this.setParentId(tag.getParentId());
			this.setXpath(tag.getXpath());
			this.setProductCategoryId(tag.getProductCategoryId());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.wassk.platform.inteface.category.bean.TagInfoBean#getTagProductType()
	 */
	@Override
	public String getTagProductType() {
		return TAG_TYPE_GROUP;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.wassk.platform.inteface.category.bean.TagInfoBean#setTagProductType
	 * (java.lang.String)
	 */
	@Override
	public void setTagProductType(final String tagProductType) {
		super.setTagProductType(TAG_TYPE_GROUP);
	}

	/**
	 * @return the values
	 */
	public List<TagValueInfoBean> getValues() {
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public void setValues(final List<TagValueInfoBean> values) {
		this.values = values;
	}

}
