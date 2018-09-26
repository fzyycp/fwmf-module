package cn.faury.fwmf.module.service.menu.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.menu.bean.FunctionInfoBean;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.api.menu.service.FunctionInfoService;
import cn.faury.fwmf.module.api.menu.service.MenuInfoService;
import cn.faury.fwmf.module.api.menu.util.MenuFuncUtil;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.menu.mapper.MenuInfoMapper;
import cn.faury.fwmf.module.service.menu.mapper.MenuInfoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现：菜单信息表
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了MenuInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class MenuInfoServiceImpl extends CrudBaseServiceImpl<MenuInfoBean, Long> implements MenuInfoService {

    /**
     * 菜单功能按钮服务
     */
    protected FunctionInfoService menuFuncService;

    public MenuInfoServiceImpl(CommonDao commonDao, FunctionInfoService functionInfoService) {
        super(commonDao, MenuInfoMapper.class);
        this.menuFuncService = functionInfoService;
    }

    @Override
    public MenuInfoBean getMenuInfoByMenuId(final Long systemId, final Long menuId, final Boolean isWithFunc,
                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");

        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuInfoByMenu";
        MenuInfoBean menuInfo = this.commonDao.selectOne(state, parameter);

        // 获取功能按钮
        if (menuInfo != null && isWithFunc != null && isWithFunc) {
            List<FunctionInfoBean> funcs = menuFuncService.getMenuFuncListByMenuId(systemId, menuId,
                    isSystemAvailable, isMenuAvailable, isFuncAvailable);
            menuInfo.setFunctionInfoBeans(funcs);
        }

        return menuInfo;
    }

    @Override
    public MenuInfoBean getMenuInfoByMenuId(final String systemCode, final Long menuId, final Boolean isWithFunc,
                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuId", menuId);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuInfoByMenu";
        MenuInfoBean menuInfo = this.commonDao.selectOne(state, parameter);

        // 获取功能按钮
        if (menuInfo != null && isWithFunc != null && isWithFunc) {
            List<FunctionInfoBean> funcs = menuFuncService.getMenuFuncListByMenuId(systemCode, menuId,
                    isSystemAvailable, isMenuAvailable, isFuncAvailable);
            menuInfo.setFunctionInfoBeans(funcs);
        }

        return menuInfo;
    }

    @Override
    public MenuInfoBean getMenuInfoByMenuCode(final Long systemId, final String menuCode, final Boolean isWithFunc,
                                              final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuCode", menuCode);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuInfoByMenu";
        MenuInfoBean menuInfo = this.commonDao.selectOne(state, parameter);

        // 获取功能按钮
        if (menuInfo != null && isWithFunc != null && isWithFunc) {
            List<FunctionInfoBean> funcs = menuFuncService.getMenuFuncListByMenuCode(systemId, menuCode,
                    isSystemAvailable, isMenuAvailable, isFuncAvailable);
            menuInfo.setFunctionInfoBeans(funcs);
        }

        return menuInfo;
    }

    @Override
    public MenuInfoBean getMenuInfoByMenuCode(final String systemCode, final String menuCode, final Boolean isWithFunc,
                                              final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuCode", menuCode);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuInfoByMenu";
        MenuInfoBean menuInfo = this.commonDao.selectOne(state, parameter);

        // 获取功能按钮
        if (menuInfo != null && isWithFunc != null && isWithFunc) {
            List<FunctionInfoBean> funcs = menuFuncService.getMenuFuncListByMenuCode(systemCode, menuCode,
                    isSystemAvailable, isMenuAvailable, isFuncAvailable);
            menuInfo.setFunctionInfoBeans(funcs);
        }

        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getMenuChildInfoByMenuId(final Long systemId, final Long menuId,
                                                       final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                       final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuChildInfoByMenu";
        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);

        // 获取功能按钮
        if (menuInfo != null && isWithFunc != null && isWithFunc) {
            List<FunctionInfoBean> funcs = menuFuncService.getChildMenuFuncListByMenuId(systemId, menuId,
                    isSystemAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }

        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getMenuChildInfoByMenuId(final String systemCode, final Long menuId,
                                                       final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                       final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuId", menuId);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuChildInfoByMenu";
        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);

        // 获取功能按钮
        if (menuInfo != null && isWithFunc != null && isWithFunc.booleanValue()) {
            List<FunctionInfoBean> funcs = menuFuncService.getChildMenuFuncListByMenuId(systemCode, menuId,
                    isSystemAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }

        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getMenuChildInfoByMenuCode(final Long systemId, final String menuCode,
                                                         final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                         final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuCode", menuCode);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuChildInfoByMenu";
        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);

        // 获取功能按钮
        if (menuInfo != null && isWithFunc != null && isWithFunc.booleanValue()) {
            List<FunctionInfoBean> funcs = menuFuncService.getChildMenuFuncListByMenuCode(systemId, menuCode,
                    isSystemAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }

        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getMenuChildInfoByMenuCode(final String systemCode, final String menuCode,
                                                         final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                         final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuCode", menuCode);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuChildInfoByMenu";
        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);

        // 获取功能按钮
        if (menuInfo != null && isWithFunc != null && isWithFunc.booleanValue()) {
            List<FunctionInfoBean> funcs = menuFuncService.getChildMenuFuncListByMenuCode(systemCode, menuCode,
                    isSystemAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }

        return menuInfo;
    }

    @Override
    public PageInfo<MenuInfoBean> getMenuChildPageListByMenuId(Map<String, String> param, Long systemId, Long menuId,
                                                               Boolean isWithFunc, Boolean isSystemAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuChildInfoByMenu";

        return commonDao.selectPage(state, parameter, PageParam.buildDefaultIns(param));
    }

    @Override
    public List<MenuInfoBean> getMenuInfoByMenuBean(Map<String, Object> parameter) {
        AssertUtil.assertFalse(StringUtil.isEmpty((String) parameter.get("menuAction"), (String) parameter.get("menuCode")), "（menuAction 菜单功能编码、menuCode 菜单编码） 二选一");
        AssertUtil.assertNotNull(parameter.get("systemId"), "业务系统ID不能为空或不存在");
        final String state = MenuInfoMapper.class.getName() + ".getMenuInfoByMenuBean";

        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public Boolean isExistRoleRMenu(final List<Long> menuIds) {
        AssertUtil.assertNotEmpty(menuIds, "菜单ID错误");
        String state = MenuInfoMapper.class.getName() + ".getMenuCountById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("menuIds", menuIds);

        List<Integer> list = this.commonDao.selectList(state, parameter);
        return list.get(0) > 0;

    }

    @Override
    public List<MenuInfoBean> getMenuTowChildInfoByMenuId(final Long systemId, final Long menuId,
                                                          final Boolean isSystemAvailable, final Boolean isMenuAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");

        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuTowChildInfoByMenu";

        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuInfoBean> getMenuTowChildInfoByMenuId(final String systemCode, final Long menuId,
                                                          final Boolean isSystemAvailable, final Boolean isMenuAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuId", menuId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuTowChildInfoByMenu";

        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuInfoBean> getMenuTowChildInfoByMenuCode(final Long systemId, final String menuCode,
                                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuCode", menuCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuTowChildInfoByMenu";

        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuInfoBean> getMenuTowChildInfoByMenuCode(final String systemCode, final String menuCode,
                                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        // 获取功能菜单
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuCode", menuCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        final String state = MenuInfoMapper.class.getName() + ".getMenuTowChildInfoByMenu";

        return this.commonDao.selectList(state, parameter);
    }


    @Override
    public Long insertMenuInfo(MenuInfoBean menuInfo) {
        AssertUtil.assertNotNull(menuInfo, "菜单信息不可以为空");
        AssertUtil.assertNotEmpty(menuInfo.getMenuActionKey(), "菜单Action为空或不存在");
        AssertUtil.assertNotEmpty(menuInfo.getMenuCode(), "菜单编码为空或不存在");
        AssertUtil.assertNotEmpty(menuInfo.getMenuName(), "菜单名称为空或不存在");
        AssertUtil.assertNotEmpty(menuInfo.getIsLeaf(), "是否末级为空或不存在");
        AssertUtil.assertNotEmpty(menuInfo.getIsAvailable(), "是否可用为空或不存在");
        AssertUtil.assertTrue(menuInfo.getMenuPid() != null && menuInfo.getMenuPid() > 0, "父菜单ID为空或不存在");
        AssertUtil.assertNotNull(menuInfo.getSystemId(), "业务系统ID不能为空或不存在");
        AssertUtil.assertNotNull(menuInfo.getSort(), "排序为空或不存在");

        Map<String, Object> parameter = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        parameter.put("menuAction", menuInfo.getMenuActionKey());
        parameter.put("systemId", menuInfo.getSystemId());

        param.put("menuCode", menuInfo.getMenuCode());
        param.put("systemId", menuInfo.getSystemId());

        if (menuInfo.getMenuId() != null) {
            parameter.put("menuId", menuInfo.getMenuId());
            param.put("menuId", menuInfo.getMenuId());
        }

        List<MenuInfoBean> info = getMenuInfoByMenuBean(parameter);
        List<MenuInfoBean> mif = getMenuInfoByMenuBean(param);
        AssertUtil.assertEmpty(info, "当前系统存在相同功能编码");
        AssertUtil.assertEmpty(mif, "当前系统存在相同菜单编码");

        String state = MenuInfoMapper.class.getName() + ".insertMenuInfo";
        int res = this.commonDao.insert(state, menuInfo);

        return res > 0 ? menuInfo.getMenuId() : -1L;
    }

    @Override
    public Integer updateMenuInfoById(MenuInfoBean menuInfo) {
        AssertUtil.assertTrue(menuInfo.getMenuId() != null && menuInfo.getMenuId() > 0, "菜单ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<>();
        Map<String, Object> param = new HashMap<>();
        if (StringUtil.isNotEmpty(menuInfo.getMenuActionKey())) {
            parameter.put("menuAction", menuInfo.getMenuActionKey());
        }
        if (StringUtil.isNotEmpty(menuInfo.getMenuCode())) {
            param.put("menuCode", menuInfo.getMenuCode());
        }
        if (menuInfo.getSystemId() != null && menuInfo.getSystemId() > 0) {
            parameter.put("systemId", menuInfo.getSystemId());
            param.put("systemId", menuInfo.getSystemId());
        }

        if (menuInfo.getMenuId() != null && menuInfo.getMenuId() > 0) {
            parameter.put("menuId", menuInfo.getMenuId());
            param.put("menuId", menuInfo.getMenuId());
        }

        List<MenuInfoBean> info = getMenuInfoByMenuBean(parameter);
        List<MenuInfoBean> mif = getMenuInfoByMenuBean(param);
        AssertUtil.assertEmpty(info, "当前系统存在相同功能编码");
        AssertUtil.assertEmpty(mif, "当前系统存在相同菜单编码");

        String state = MenuInfoMapper.class.getName() + ".updateMenuInfoById";

        return this.commonDao.update(state, menuInfo);
    }

    @Transactional
    @Override
    public Integer deleteMenuInfoById(List<Long> menuIds) {
        AssertUtil.assertNotEmpty(menuIds, "菜单ID错误");
        AssertUtil.assertFalse(isExistRoleRMenu(menuIds), "存在角色关联菜单，不能删除");
        String state = MenuInfoMapper.class.getName() + ".deleteMenuInfoById";
        String stateFunc = MenuInfoMapper.class.getName() + ".deleteMenuFuncInfoById";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("menuIds", menuIds);
        this.commonDao.delete(stateFunc, parameter);
        return this.commonDao.delete(state, parameter);
    }

    @Override
    public Integer deleteMenuInfoById(Long menuId, Long systemId) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        List<MenuInfoBean> list = getMenuChildInfoByMenuId(systemId, menuId, null);
        AssertUtil.assertEmpty(list, "菜单下有子菜单，请先删除子菜单");
        List<FunctionInfoBean> funcList = menuFuncService.getMenuFuncListByMenuId(systemId, menuId);
        AssertUtil.assertEmpty(funcList, "菜单下有功能按钮，请先删除功能按钮");
        return deleteMenuInfoById(menuId);
    }
}