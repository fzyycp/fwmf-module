/**
 * 业务平台Web：ssk-platform-service-area
 * 
 * @date 2015年11月6日
 * @author yc.fan
 *
 * 版权所有：南京扫扫看数字科技有限公司
 */
package cn.faury.fwmf.module.api.area.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 地区信息Bean
 */
public class AreaBean implements Serializable {

	/**
	 * 地区编码
	 */
	private String admareaCode;

	/**
	 * 地区名称
	 */
	private String admareaName;

	/**
	 * 下辖地区
	 */
	private List<AreaBean> subAreas;

	/**
	 * 上级地区编码
	 */
	private String supAreaCode;

	/**
	 * Gets admarea code.
	 *
	 * @return the admarea code
	 */
	public String getAdmareaCode() {
		return admareaCode;
	}

	/**
	 * Sets admarea code.
	 *
	 * @param admareaCode
	 *            the admarea code
	 */
	public void setAdmareaCode(String admareaCode) {
		this.admareaCode = admareaCode;
	}

	/**
	 * Gets admarea name.
	 *
	 * @return the admarea name
	 */
	public String getAdmareaName() {
		return admareaName;
	}

	/**
	 * Sets admarea name.
	 *
	 * @param admareaName
	 *            the admarea name
	 */
	public void setAdmareaName(String admareaName) {
		this.admareaName = admareaName;
	}

	/**
	 * Gets sub areas.
	 *
	 * @return the sub areas
	 */
	public List<AreaBean> getSubAreas() {
		return subAreas;
	}

	/**
	 * Sets sub areas.
	 *
	 * @param subAreas
	 *            the sub areas
	 */
	public void setSubAreas(List<AreaBean> subAreas) {
		this.subAreas = subAreas;
	}

	/**
	 * Gets sup area code.
	 *
	 * @return the sup area code
	 */
	public String getSupAreaCode() {
		return supAreaCode;
	}

	/**
	 * Sets sup area code.
	 *
	 * @param supAreaCode
	 *            the sup area code
	 */
	public void setSupAreaCode(String supAreaCode) {
		this.supAreaCode = supAreaCode;
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
