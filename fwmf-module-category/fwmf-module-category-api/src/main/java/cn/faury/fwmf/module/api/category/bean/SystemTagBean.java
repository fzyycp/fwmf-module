package cn.faury.fwmf.module.api.category.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 系统商品标签授权Bean
 */
public class SystemTagBean extends TagInfoBean implements Serializable {

	/**
	 * 系统Id
	 */
	private Long systemId;

	/**
	 * 系统code
	 */
	private String systemCode;

	/**
	 * 系统code
	 */
	private String systemName;

	/**
	 * 是否叶子节点
	 */
	private String isLeaf;

	/**
	 * 保存商品标签Id集合
	 */
	private List<Long> tagIds;

	/**
	 * @return the tagIds
	 */
	public List<Long> getTagIds() {
		return tagIds;
	}

	/**
	 * @param tagIds
	 *            the tagIds to set
	 */
	public void setTagIds(List<Long> tagIds) {
		this.tagIds = tagIds;
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
