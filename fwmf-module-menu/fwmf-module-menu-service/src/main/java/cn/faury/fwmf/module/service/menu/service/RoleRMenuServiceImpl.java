package cn.faury.fwmf.module.service.menu.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.menu.bean.MenuFuncInfoBean;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.api.menu.service.RoleRFuncService;
import cn.faury.fwmf.module.api.menu.service.RoleRMenuService;
import cn.faury.fwmf.module.api.menu.util.MenuFuncUtil;
import cn.faury.fwmf.module.service.menu.mapper.RoleRFuncMapper;
import cn.faury.fwmf.module.service.menu.mapper.RoleRMenuMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色关联菜单服务提供者
 */
public class RoleRMenuServiceImpl implements RoleRMenuService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    /**
     * 角色授权功能按钮服务
     */
    protected RoleRFuncService roleRFuncService;

    public RoleRMenuServiceImpl(CommonDao commonDao, RoleRFuncService roleRFuncService) {
        this.commonDao = commonDao;
        this.roleRFuncService = roleRFuncService;
    }

    @Override
    public List<MenuInfoBean> getRoleRMenuInfosByRoleId(Long systemId, Long roleId, Boolean isWithFunc,
                                                        Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleId", roleId);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRMenuMapper.class.getName() + ".getRoleRMenuInfosByRole";

        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);

        // 获取角色授权的功能按钮列表
        if (isWithFunc != null && isWithFunc && menuInfo != null && menuInfo.size() > 0) {
            List<MenuFuncInfoBean> funcs = roleRFuncService.getRoleRFuncInfosByRoleId(systemId, roleId,
                    (Long) null, isSystemAvailable, isRoleAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }
        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getRoleRMenuInfosByRoleId(String systemCode, Long roleId, Boolean isWithFunc,
                                                        Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleId", roleId);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRMenuMapper.class.getName() + ".getRoleRMenuInfosByRole";

        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);

        // 获取角色授权的功能按钮列表
        if (isWithFunc != null && isWithFunc && menuInfo != null && menuInfo.size() > 0) {
            List<MenuFuncInfoBean> funcs = roleRFuncService.getRoleRFuncInfosByRoleId(systemCode, roleId,
                    (Long) null, isSystemAvailable, isRoleAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }
        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getRoleRMenuInfosByRoleCode(Long systemId, String roleCode, Boolean isWithFunc,
                                                          Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleCode", roleCode);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRMenuMapper.class.getName() + ".getRoleRMenuInfosByRole";

        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);

        // 获取角色授权的功能按钮列表
        if (isWithFunc != null && isWithFunc && menuInfo != null && menuInfo.size() > 0) {
            List<MenuFuncInfoBean> funcs = roleRFuncService.getRoleRFuncInfosByRoleCode(systemId, roleCode,
                    (Long) null, isSystemAvailable, isRoleAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }
        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getRoleRMenuInfosByRoleCode(String systemCode, String roleCode, Boolean isWithFunc,
                                                          Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleCode", roleCode);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRMenuMapper.class.getName() + ".getRoleRMenuInfosByRole";

        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);

        // 获取角色授权的功能按钮列表
        if (isWithFunc != null && isWithFunc && menuInfo != null && menuInfo.size() > 0) {
            List<MenuFuncInfoBean> funcs = roleRFuncService.getRoleRFuncInfosByRoleCode(systemCode, roleCode,
                    (Long) null, isSystemAvailable, isRoleAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }
        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getMenuInfoByUserSystemAndRoleIds(final Long userId, final Long systemId,
                                                                final List<Long> roleIds, final Boolean isWithFunc, final Boolean isRoleAvailable,
                                                                final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID不能为空或不存在");
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userId);
        parameter.put("systemId", systemId);
        parameter.put("roleIds", roleIds);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRMenuMapper.class.getName() + ".getMenuInfoByUserSystemAndRoleIds";
        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);
        // 获取角色授权的功能按钮列表
        if (isWithFunc != null && isWithFunc && menuInfo != null && menuInfo.size() > 0) {
            List<MenuFuncInfoBean> funcs = roleRFuncService.getFuncByUserSystemAndRoleIds(userId, systemId,
                    roleIds, isRoleAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }
        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getMenuInfoByUserSystemAndRoleCodes(final Long userId, final Long systemId,
                                                                  final List<String> roleCodes, final Boolean isWithFunc, final Boolean isRoleAvailable,
                                                                  final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID不能为空或不存在");
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userId);
        parameter.put("systemId", systemId);
        parameter.put("roleCodes", roleCodes);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRMenuMapper.class.getName() + ".getMenuInfoByUserSystemAndRoleIds";
        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);
        // 获取角色授权的功能按钮列表
        if (isWithFunc != null && isWithFunc && menuInfo != null && menuInfo.size() > 0) {
            List<MenuFuncInfoBean> funcs = roleRFuncService.getFuncByUserSystemAndRoleCodes(userId, systemId,
                    roleCodes, isRoleAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }
        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getMenuInfoByUserSystemAndRoleCodes(final Long userId, final String systemCode,
                                                                  final List<String> roleCodes, final Boolean isWithFunc, final Boolean isRoleAvailable,
                                                                  final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID不能为空或不存在");
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userId);
        parameter.put("systemCode", systemCode);
        parameter.put("roleCodes", roleCodes);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRMenuMapper.class.getName() + ".getMenuInfoByUserSystemAndRoleIds";
        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);
        // 获取角色授权的功能按钮列表
        if (isWithFunc != null && isWithFunc && menuInfo != null && menuInfo.size() > 0) {
            List<MenuFuncInfoBean> funcs = roleRFuncService.getFuncByUserSystemAndRoleCodes(userId, systemCode,
                    roleCodes, isRoleAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }
        return menuInfo;
    }

    @Override
    public List<MenuInfoBean> getMenuInfoByUserSystemAndRoleIds(final Long userId, final String systemCode,
                                                                final List<Long> roleIds, final Boolean isWithFunc, final Boolean isRoleAvailable,
                                                                final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID不能为空或不存在");
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userId);
        parameter.put("systemCode", systemCode);
        parameter.put("roleIds", roleIds);
        parameter.put("isWithFunc", isWithFunc);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRMenuMapper.class.getName() + ".getMenuInfoByUserSystemAndRoleIds";
        List<MenuInfoBean> menuInfo = this.commonDao.selectList(state, parameter);
        // 获取角色授权的功能按钮列表
        if (isWithFunc != null && isWithFunc && menuInfo != null && menuInfo.size() > 0) {
            List<MenuFuncInfoBean> funcs = roleRFuncService.getFuncByUserSystemAndRoleIds(userId, systemCode,
                    roleIds, isRoleAvailable, isMenuAvailable, isFuncAvailable);
            MenuFuncUtil.attachMenuFuncs(funcs, menuInfo);
        }
        return menuInfo;
    }


    @Override
    public Integer insertRoleRMenuInfo(Long roleId, List<Long> menuIds) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuIds, "多个菜单ID为空或不存在");
        String state = RoleRMenuMapper.class.getName() + ".insertRoleRMenuInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("roleId", roleId);
        parameter.put("menuIds", menuIds);

        return this.commonDao.insert(state, parameter);
    }

    @Transactional
    @Override
    public Integer deleteRoleRMenuInfo(Long roleId, List<Long> menuIds) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuIds, "多个菜单ID为空或不存在");
        String state = RoleRMenuMapper.class.getName() + ".deleteRoleRMenuInfo";
        String stateFunc = RoleRMenuMapper.class.getName() + ".deleteRoleRMenuFuncInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("roleId", roleId);
        parameter.put("menuIds", menuIds);
        int res = 0;
        res = this.commonDao.delete(stateFunc, parameter);
        if (res >= 0) {
            res = this.commonDao.delete(state, parameter);
        }

        return res;
    }

    @Transactional
    @Override
    public Integer deleteAllRoleRMenuInfo(Long roleId) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        String state = RoleRMenuMapper.class.getName() + ".deleteAllRoleRMenuInfo";
        String stateFunc = RoleRFuncMapper.class.getName() + ".deleteAllRoleRFuncInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("roleId", roleId);
        int res = 0;
        res = this.commonDao.delete(stateFunc, parameter);
        if (res >= 0) {
            res = this.commonDao.delete(state, parameter);
        }

        return res;
    }

    @Override
    @Transactional
    public Integer updateRoleRMenuInfo(Long roleId, List<Long> menuIds, List<Long> funcIds) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        int res = 0;
        res = this.deleteAllRoleRMenuInfo(roleId);
        roleRFuncService.deleteAllRoleRFuncInfo(roleId);
        if (menuIds.size() > 0) {
            insertRoleRMenuInfo(roleId, menuIds);
        }
        if (funcIds.size() > 0) {
            roleRFuncService.insertRoleRFuncInfo(roleId, funcIds);
        }
        return res;
    }

}
