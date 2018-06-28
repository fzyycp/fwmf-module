package cn.faury.fwmf.module.api.category.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统标签tree
 */
public class SystemTagTreeBean extends SystemTagBean {
	/**
     * 
     */
	public SystemTagTreeBean() {
	}

	private List<SystemTagTreeBean> childrens;

	public SystemTagTreeBean(final SystemTagBean tag) {
		if (null != tag) {

			this.setParentId(tag.getParentId());
			this.setProductCategoryId(tag.getProductCategoryId());
			this.setSystemCode(tag.getSystemCode());
			this.setSystemId(tag.getSystemId());
			this.setSystemName(tag.getSystemName());
			this.setTagProductId(tag.getTagProductId());
			this.setTagProductName(tag.getTagProductName());
			this.setTagProductType(tag.getTagProductType());
			this.setXpath(tag.getXpath());
			this.setChildrens(new ArrayList<SystemTagTreeBean>());
		}
	}

	public List<SystemTagTreeBean> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<SystemTagTreeBean> childrens) {
		this.childrens = childrens;
	}

}
