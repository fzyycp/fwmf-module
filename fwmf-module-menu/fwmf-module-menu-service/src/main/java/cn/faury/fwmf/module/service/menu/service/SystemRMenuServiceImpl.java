package cn.faury.fwmf.module.service.menu.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.api.menu.service.SystemRMenuService;
import cn.faury.fwmf.module.service.menu.mapper.SystemMenuMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单服务提供者:从业务系统的角度
 */
public class SystemRMenuServiceImpl implements SystemRMenuService {

	/**
	 * 数据库操作器
	 */
	protected CommonDao commonDao;

    public SystemRMenuServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
	public List<MenuInfoBean> getRootMenuListWithOneChildBySystemId(final Long systemId,
																	final Boolean isSystemAvailable, final Boolean isMenuAvailable) {
		AssertUtil.assertTrue(systemId!=null&&systemId>0,"业务系统ID不能为空或不存在");
		// 设置参数
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("systemId", systemId);
		parameter.put("isSystemAvailable", isSystemAvailable);
		parameter.put("isMenuAvailable", isMenuAvailable);
		final String state = SystemMenuMapper.class.getName() + ".getRootMenuListWithOneChildBySystem";
		return this.commonDao.selectList(state, parameter);
	}

	@Override
	public List<MenuInfoBean> getRootMenuListWithOneChildBySystemCode(final String systemCode,
                                                                      final Boolean isSystemAvailable, final Boolean isMenuAvailable) {
		AssertUtil.assertNotEmpty(systemCode,"业务系统编码不能为空或不存在");
		// 设置参数
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("systemCode", systemCode);
		parameter.put("isSystemAvailable", isSystemAvailable);
		parameter.put("isMenuAvailable", isMenuAvailable);
		final String state = SystemMenuMapper.class.getName() + ".getRootMenuListWithOneChildBySystem";
		return this.commonDao.selectList(state, parameter);
	}

	@Override
	public List<MenuInfoBean> getRootMenuListWithAllChildBySystemId(final Long systemId,
                                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable) {
		AssertUtil.assertTrue(systemId!=null&&systemId>0,"业务系统ID不能为空或不存在");
		// 设置参数
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("systemId", systemId);
		parameter.put("isSystemAvailable", isSystemAvailable);
		parameter.put("isMenuAvailable", isMenuAvailable);
		final String state = SystemMenuMapper.class.getName() + ".getRootMenuListWithAllChildBySystem";
		return this.commonDao.selectList(state, parameter);
	}

	@Override
	public List<MenuInfoBean> getRootMenuListWithAllChildBySystemCode(final String systemCode,
                                                                      final Boolean isSystemAvailable, final Boolean isMenuAvailable) {
		AssertUtil.assertNotEmpty(systemCode,"业务系统编码不能为空或不存在");
		// 设置参数
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("systemCode", systemCode);
		parameter.put("isSystemAvailable", isSystemAvailable);
		parameter.put("isMenuAvailable", isMenuAvailable);
		final String state = SystemMenuMapper.class.getName() + ".getRootMenuListWithAllChildBySystem";
		return this.commonDao.selectList(state, parameter);
	}

	@Override
	public PageInfo<MenuInfoBean> getMenuPageListBySystemId(Map<String, String> params, Long systemId,
                                                            Boolean isSystemAvailable, Boolean isMenuAvailable) {
        AssertUtil.assertTrue(systemId!=null&&systemId>0,"业务系统ID不能为空或不存在");
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("systemId", systemId);
		parameter.put("isSystemAvailable", isSystemAvailable);
		parameter.put("isMenuAvailable", isMenuAvailable);
		final String state = SystemMenuMapper.class.getName() + ".getOneChildMenuListBySystem";
		return commonDao.selectPage(state, parameter, PageParam.buildDefaultIns(params));
	}
}
