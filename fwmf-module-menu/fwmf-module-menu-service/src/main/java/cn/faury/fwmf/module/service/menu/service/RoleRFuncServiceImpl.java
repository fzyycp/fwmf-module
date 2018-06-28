package cn.faury.fwmf.module.service.menu.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.menu.bean.MenuFuncInfoBean;
import cn.faury.fwmf.module.api.menu.service.RoleRFuncService;
import cn.faury.fwmf.module.service.menu.mapper.RoleRFuncMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色关联功能按钮服务提供者
 */
public class RoleRFuncServiceImpl implements RoleRFuncService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public RoleRFuncServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public List<MenuFuncInfoBean> getRoleRFuncInfosByRoleId(Long systemId, Long roleId, Long menuId,
                                                            Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        parameter.put("roleId", roleId);
        if (menuId != null) {
            parameter.put("menuId", menuId);
        }
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getRoleRFuncInfosByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getRoleRFuncInfosByRoleId(String systemCode, Long roleId, Long menuId,
                                                            Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleId", roleId);
        if (menuId != null) {
            parameter.put("menuId", menuId);
        }
        parameter.put("isAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getRoleRFuncInfosByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getRoleRFuncInfosByRoleId(Long systemId, Long roleId, String menuCode,
                                                            Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        parameter.put("roleId", roleId);
        if (StringUtil.isNotEmpty(menuCode)) {
            parameter.put("menuCode", menuCode);
        }
        parameter.put("isAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getRoleRFuncInfosByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getRoleRFuncInfosByRoleId(String systemCode, Long roleId, String menuCode,
                                                            Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleId", roleId);
        if (StringUtil.isNotEmpty(menuCode)) {
            parameter.put("menuCode", menuCode);
        }
        parameter.put("isAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getRoleRFuncInfosByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getRoleRFuncInfosByRoleCode(Long systemId, String roleCode, Long menuId,
                                                              Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleCode", roleCode);
        if (menuId != null) {
            parameter.put("menuId", menuId);
        }
        parameter.put("isAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getRoleRFuncInfosByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getRoleRFuncInfosByRoleCode(String systemCode, String roleCode, Long menuId,
                                                              Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleCode", roleCode);
        if (menuId != null) {
            parameter.put("menuId", menuId);
        }
        parameter.put("isAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getRoleRFuncInfosByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getRoleRFuncInfosByRoleCode(Long systemId, String roleCode, String menuCode,
                                                              Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleCode", roleCode);
        if (StringUtil.isNotEmpty(menuCode)) {
            parameter.put("menuCode", menuCode);
        }
        parameter.put("isAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getRoleRFuncInfosByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getRoleRFuncInfosByRoleCode(String systemCode, String roleCode, String menuCode,
                                                              Boolean isSystemAvailable, Boolean isRoleAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleCode", roleCode);
        if (StringUtil.isNotEmpty(menuCode)) {
            parameter.put("menuCode", menuCode);
        }
        parameter.put("isAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getRoleRFuncInfosByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getFuncByUserSystemAndRoleIds(final Long userId, final Long systemId,
                                                                final List<Long> roleIds, final Boolean isRoleAvailable,
                                                                final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userId);
        parameter.put("systemId", systemId);
        parameter.put("roleIds", roleIds);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getFuncByUserSystemAndRoleIds";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getFuncByUserSystemAndRoleIds(final Long userId, final String systemCode,
                                                                final List<Long> roleIds, final Boolean isRoleAvailable,
                                                                final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID不能为空或不存在");
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userId);
        parameter.put("systemCode", systemCode);
        parameter.put("roleIds", roleIds);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getFuncByUserSystemAndRoleIds";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getFuncByUserSystemAndRoleCodes(final Long userId, final Long systemId,
                                                                  final List<String> roleCodes, final Boolean isRoleAvailable,
                                                                  final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID不能为空或不存在");
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userId);
        parameter.put("systemId", systemId);
        parameter.put("roleCodes", roleCodes);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getFuncByUserSystemAndRoleIds";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<MenuFuncInfoBean> getFuncByUserSystemAndRoleCodes(final Long userId, final String systemCode,
                                                                  final List<String> roleCodes, final Boolean isRoleAvailable,
                                                                  final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID不能为空或不存在");
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userId);
        parameter.put("systemCode", systemCode);
        parameter.put("roleCodes", roleCodes);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        String state = RoleRFuncMapper.class.getName() + ".getFuncByUserSystemAndRoleIds";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public Integer insertRoleRFuncInfo(Long roleId, List<Long> funcIds) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        AssertUtil.assertNotEmpty(funcIds, "多个功能按钮ID为空或不存在");
        String state = RoleRFuncMapper.class.getName() + ".insertRoleRFuncInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("roleId", roleId);
        parameter.put("funcIds", funcIds);

        return this.commonDao.insert(state, parameter);
    }

    @Override
    public Integer deleteRoleRFuncInfo(Long roleId, List<Long> funcIds) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        AssertUtil.assertNotEmpty(funcIds, "多个功能按钮ID为空或不存在");
        String state = RoleRFuncMapper.class.getName() + ".deleteRoleRFuncInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("roleId", roleId);
        parameter.put("funcIds", funcIds);

        return this.commonDao.delete(state, parameter);
    }

    @Override
    public Integer deleteAllRoleRFuncInfo(Long roleId) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        String state = RoleRFuncMapper.class.getName() + ".deleteAllRoleRFuncInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("roleId", roleId);

        return this.commonDao.delete(state, parameter);
    }
}
