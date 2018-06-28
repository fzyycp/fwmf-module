package cn.faury.fwmf.module.api.category.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类标签信息
 */
public class CategoryTagInfoBean extends CategoryInfoBean {

	/**
	 * 关联的标签
	 */
	private List<TagGroupInfoBean> tags;

	/**
	 * 构造函数
	 */
	public CategoryTagInfoBean() {
		super();
		this.tags = new ArrayList<>();
	}

	/**
	 * 拷贝构造函数
	 * 
	 * @param info
	 *            分类信息对象
	 */
	public CategoryTagInfoBean(final CategoryInfoBean info) {
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
		}
	}

	/**
	 * @return the tags
	 */
	public List<TagGroupInfoBean> getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(final List<TagGroupInfoBean> tags) {
		this.tags = tags;
	}
}
