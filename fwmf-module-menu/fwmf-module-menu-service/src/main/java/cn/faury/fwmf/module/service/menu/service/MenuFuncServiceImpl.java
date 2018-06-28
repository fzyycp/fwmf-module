package cn.faury.fwmf.module.service.menu.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.menu.bean.MenuFuncInfoBean;
import cn.faury.fwmf.module.api.menu.service.MenuFuncService;
import cn.faury.fwmf.module.service.menu.mapper.MenuFuncMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单功能按钮服务提供者
 */
public class MenuFuncServiceImpl implements MenuFuncService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public MenuFuncServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public MenuFuncInfoBean getMenuFuncInfoByFuncId(final Long systemId, final Long menuId, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        AssertUtil.assertTrue(funcId != null && funcId > 0, "功能按钮ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("funcId", funcId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public MenuFuncInfoBean getMenuFuncInfoByFuncId(final Long systemId, final String menuCode, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        AssertUtil.assertTrue(funcId != null && funcId > 0, "功能按钮ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuCode", menuCode);
        parameter.put("funcId", funcId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public MenuFuncInfoBean getMenuFuncInfoByFuncId(final String systemCode, final Long menuId, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        AssertUtil.assertTrue(funcId != null && funcId > 0, "功能按钮ID不能为空或不存在");
        parameter.put("systemCode", systemCode);
        parameter.put("menuId", menuId);
        parameter.put("funcId", funcId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public MenuFuncInfoBean getMenuFuncInfoByFuncId(final String systemCode, final String menuCode, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        AssertUtil.assertTrue(funcId != null && funcId > 0, "功能按钮ID不能为空或不存在");
        parameter.put("systemCode", systemCode);
        parameter.put("menuCode", menuCode);
        parameter.put("funcId", funcId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public MenuFuncInfoBean getMenuFuncInfoByFuncCode(final Long systemId, final Long menuId, final String funcCode,
                                                      final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        AssertUtil.assertNotEmpty(funcCode, "功能按钮编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("funcCode", funcCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public MenuFuncInfoBean getMenuFuncInfoByFuncCode(final Long systemId, final String menuCode,
                                                      final String funcCode, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                      final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        AssertUtil.assertNotEmpty(funcCode, "功能按钮编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuCode", menuCode);
        parameter.put("funcCode", funcCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public MenuFuncInfoBean getMenuFuncInfoByFuncCode(final String systemCode, final Long menuId,
                                                      final String funcCode, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                      final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        AssertUtil.assertNotEmpty(funcCode, "功能按钮编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuId", menuId);
        parameter.put("funcCode", funcCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public MenuFuncInfoBean getMenuFuncInfoByFuncCode(final String systemCode, final String menuCode,
                                                      final String funcCode, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                      final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        AssertUtil.assertNotEmpty(funcCode, "功能按钮编码不能为空或不存在");

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuCode", menuCode);
        parameter.put("funcCode", funcCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getMenuFuncListByMenuId(final Long systemId, final Long menuId,
                                                          final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getMenuFuncListByMenuId(final String systemCode, final Long menuId,
                                                          final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuId", menuId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getMenuFuncListByMenuCode(final Long systemId, final String menuCode,
                                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuCode", menuCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getMenuFuncListByMenuCode(final String systemCode, final String menuCode,
                                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuCode", menuCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getChildMenuFuncListByMenuId(final Long systemId, final Long menuPId,
                                                               final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuPId != null && menuPId > 0, "父菜单ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuPId", menuPId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getChildMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getChildMenuFuncListByMenuId(final String systemCode, final Long menuPId,
                                                               final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(menuPId != null && menuPId > 0, "父菜单ID不能为空或不存在");
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuPId", menuPId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getChildMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getChildMenuFuncListByMenuCode(final Long systemId, final String menuPCode,
                                                                 final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuPCode, "父菜单编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuPCode", menuPCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getChildMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getChildMenuFuncListByMenuCode(final String systemCode, final String menuPCode,
                                                                 final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuPCode, "父菜单编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuPCode", menuPCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getChildMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public PageInfo<MenuFuncInfoBean> getMenuFuncPageListByMenuId(Map<String, String> param, Long systemId, Long menuId,
                                                                  Boolean isSystemAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuFuncMapper.class.getName() + ".getMenuFuncListByMenu";

        return commonDao.selectPage(state, parameter, PageParam.buildDefaultIns(param));

    }

    @Override
    public MenuFuncInfoBean getMenuFuncInfoByFuncCode(MenuFuncInfoBean menuFuncInfoBean) {

        String state = MenuFuncMapper.class.getName() + ".getMenuFuncInfoByFuncCode";
        Map<String, Object> parameter = new HashMap<>();
        if (menuFuncInfoBean != null) {
            if (StringUtil.isNotEmpty(menuFuncInfoBean.getFuncCode())) {
                parameter.put("funcCode", menuFuncInfoBean.getFuncCode());
            }
            if (menuFuncInfoBean.getMenuId() != null) {
                parameter.put("menuId", menuFuncInfoBean.getMenuId());
            }
            if (menuFuncInfoBean.getFuncId() != null) {
                parameter.put("menuId", menuFuncInfoBean.getFuncId());
            }
        }

        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public Boolean isExistRoleRFunc(List<Long> funcIds) {
        AssertUtil.assertTrue(funcIds != null && funcIds.size() > 0, "功能IDfuncIds错误");
        String state = MenuFuncMapper.class.getName() + ".getFuncCountById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("funcIds", funcIds);

        List<Integer> list = this.commonDao.selectList(state, parameter);
        if (list.get(0) > 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Long insertMenuFuncInfo(MenuFuncInfoBean menuFuncInfo) {
        AssertUtil.assertNotNull(menuFuncInfo, "功能菜单信息不可以为空");
        AssertUtil.assertNotEmpty(menuFuncInfo.getFuncName(), "功能菜单名称为空或不存在");
        AssertUtil.assertNotEmpty(menuFuncInfo.getFuncCode(), "功能编码为空或不存在");
        AssertUtil.assertTrue(menuFuncInfo.getMenuId() != null && menuFuncInfo.getMenuId() > 0, "菜单ID为空或不存在");
        AssertUtil.assertTrue(menuFuncInfo.getSystemId() != null && menuFuncInfo.getSystemId() > 0, "业务系统ID为空或不存在");
        AssertUtil.assertNotEmpty(menuFuncInfo.getIsAvailable(), "是否可用为空或不存在");
        MenuFuncInfoBean bean = getMenuFuncInfoByFuncCode(menuFuncInfo);
        AssertUtil.assertNull(bean,"当前菜单存在相同功能编码");

        String state = MenuFuncMapper.class.getName() + ".insertMenuFuncInfo";
        int res = this.commonDao.insert(state, menuFuncInfo);

        return res > 0 ? menuFuncInfo.getFuncId() : -1L;
    }

    @Override
    public Integer updateMenuFuncInfo(MenuFuncInfoBean menuFuncInfo) {
        AssertUtil.assertTrue(menuFuncInfo.getFuncId()!=null&& menuFuncInfo.getFuncId()>0,"功能菜单ID为空或不存在");
        MenuFuncInfoBean bean = getMenuFuncInfoByFuncCode(menuFuncInfo);
        AssertUtil.assertNull(bean,"存在相同功能编码");
        String state = MenuFuncMapper.class.getName() + ".updateMenuFuncInfo";

        return this.commonDao.update(state, menuFuncInfo);
    }

    @Override
    public Integer deleteMenuFuncInfoById(List<Long> funcIds) {
        AssertUtil.assertFalse(isExistRoleRFunc(funcIds),"存在角色关联功能，不能删除");
        String state = MenuFuncMapper.class.getName() + ".deleteMenuFuncInfoById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("funcIds", funcIds);
        return this.commonDao.delete(state, parameter);
    }

    @Override
    public Integer deleteMenuFuncInfoByMenuId(List<Long> menuIds) {
        AssertUtil.assertTrue(menuIds!=null&& menuIds.size()>0,"菜单ID menuIds错误");
        String state = MenuFuncMapper.class.getName() + ".deleteMenuFuncInfoByMenuId";
        Map<String, Object> parameter = new HashMap<>();

        parameter.put("menuIds", menuIds);
        return this.commonDao.delete(state, parameter);
    }

}
