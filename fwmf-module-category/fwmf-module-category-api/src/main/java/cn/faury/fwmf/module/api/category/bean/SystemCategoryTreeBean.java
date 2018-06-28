package cn.faury.fwmf.module.api.category.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 分类tree
 */
public class SystemCategoryTreeBean extends SystemCategoryBean {

	/**
     * 
     */
	public SystemCategoryTreeBean() {
	}

	public SystemCategoryTreeBean(final SystemCategoryBean sc) {
		if (null != sc) {

			this.setCreatePersonName(sc.getCreatePersonName());
			this.setCreateTime(sc.getCreateTime());
			this.setUpdatePersonName(sc.getUpdatePersonName());
			this.setUpdateTime(sc.getUpdateTime());
			this.setXpath(sc.getXpath());
			this.setTemplateId(sc.getTemplateId());
			this.setSystemId(sc.getSystemId());
			this.setSystemCode(sc.getSystemCode());
			this.setSystemName(sc.getSystemName());
			this.setProductCategoryName(sc.getProductCategoryName());
			this.setProductCategoryId(sc.getProductCategoryId());
			this.setParentId(sc.getParentId());
			this.setDisplayOrder(sc.getDisplayOrder());
			this.setDelFlag(sc.getDelFlag());
			this.setChildrens(new ArrayList<SystemCategoryTreeBean>());
		}
	}

	private List<SystemCategoryTreeBean> childrens;

	public List<SystemCategoryTreeBean> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<SystemCategoryTreeBean> childrens) {
		this.childrens = childrens;
	}

}
