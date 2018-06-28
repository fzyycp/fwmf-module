package cn.faury.fwmf.module.api.area.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fwmf.module.api.area.bean.AreaBean;

import java.util.List;

/**
 * 地区服务
 */
public interface AreaService {

	/**
	 * 获取指定区域的下一层区域
	 *
	 * @param areaCode
	 *            指定区域ID（若要获取所有省级区域，则传000000）
	 * @return 下一层区域列表
	 */
	@Read
    List<AreaBean> getAreaOneTreeByCode(String areaCode);

	/**
	 * 获取指定区域的所有下辖区域
	 *
	 * @param areaCode
	 *            指定区域ID（若要获取所有区域，则传000000）
	 * @return 下层所有区域列表
	 */
	@Read
    List<AreaBean> getAreaAllTreeByCode(String areaCode);

}
