package cn.faury.fwmf.module.service.area.service;

import cn.faury.fdk.common.anotation.service.CanReadOnly;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.area.bean.AreaBean;
import cn.faury.fwmf.module.api.area.service.AreaService;
import cn.faury.fwmf.module.service.area.mapper.AreaMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 区域服务实现
 */
@CanReadOnly
public class AreaServiceImpl implements AreaService {

	/**
	 * 数据库操作器
	 */
	private CommonDao commonDao;

	public AreaServiceImpl(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Override
	public List<AreaBean> getAreaOneTreeByCode(String areaCode) {
		AssertUtil.assertNotEmpty(areaCode,"区域编码不可为空");
		String searchCode = "";

		if (areaCode.equals("000000")) {
			searchCode = "__0000";
		} else if (areaCode.endsWith("0000")) {
			searchCode = String.format("%s__00", areaCode.substring(0, 2));
		} else if (areaCode.endsWith("00")) {
			searchCode = String.format("%s__", areaCode.substring(0, 4));
		}

		Map<String, Object> params = new HashMap<>();
		params.put("areaCode", searchCode);
		params.put("exCode", areaCode);

		String state = AreaMapper.class.getName() + ".getAreaByCode";
		List<AreaBean> result = commonDao.selectList(state, params);
		for (AreaBean areaBean : result) {
			areaBean.setSupAreaCode(areaCode);
		}
		return result;
	}

	@Override
	public List<AreaBean> getAreaAllTreeByCode(String areaCode) {
		AssertUtil.assertNotEmpty(areaCode,"区域编码不可为空");
		String searchCode = "";

		if (areaCode.equals("000000")) {
			searchCode = "______";
		} else if (areaCode.endsWith("0000")) {
			searchCode = String.format("%s____", areaCode.substring(0, 2));
		} else if (areaCode.endsWith("00")) {
			searchCode = String.format("%s__", areaCode.substring(0, 4));
		}

		Map<String, Object> params = new HashMap<>();
		params.put("areaCode", searchCode);
		String state = AreaMapper.class.getName() + ".getAreaByCode";
		List<AreaBean> result = commonDao.selectList(state, params);

		for (AreaBean areaBean : result) {
			if (areaBean.getAdmareaCode().endsWith("0000")) {
				areaBean.setSupAreaCode("000000");
			} else if (areaBean.getAdmareaCode().endsWith("00")) {
				areaBean.setSupAreaCode(String.format("%s0000", areaBean.getAdmareaCode().substring(0, 2)));
			} else {
				areaBean.setSupAreaCode(String.format("%s00", areaBean.getAdmareaCode().substring(0, 4)));
			}
		}
		return result;
	}
}
