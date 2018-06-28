package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.user.bean.RoleRUserBean;
import cn.faury.fwmf.module.api.user.service.RoleRUserService;
import cn.faury.fwmf.module.service.user.mapper.RoleRUserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色用户服务提供者
 */
public class RoleRUserServiceImpl implements RoleRUserService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public RoleRUserServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public List<RoleRUserBean> getRoleRUserInfoByRoleId(Long systemId, Long roleId, Boolean isSystemAvailable,
                                                        Boolean isRoleAvailable, final Boolean isUserRSysAvalible) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        parameter.put("roleId", roleId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getRoleRUserInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public PageInfo<RoleRUserBean> getRoleRUserPageListByRoleId(Map<String, String> params, Long systemId, Long roleId,
                                                                Boolean isSystemAvailable, Boolean isRoleAvailable, final Boolean isUserRSysAvalible) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleId", roleId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        if (StringUtil.isNotEmpty(params.get("loginName"))) {
            parameter.put("loginName", params.get("loginName"));
        }
        final String state = RoleRUserMapper.class.getName() + ".getRoleRUserInfoByRole";
        return commonDao.selectPage(state, parameter, PageParam.buildDefaultIns(params));
    }

    @Override
    public List<RoleRUserBean> getRoleRUserInfoByRoleId(String systemCode, Long roleId, Boolean isSystemAvailable,
                                                        Boolean isRoleAvailable, final Boolean isUserRSysAvalible) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleId", roleId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getRoleRUserInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getRoleRUserInfoByRoleCode(String systemCode, String roleCode,
                                                          Boolean isSystemAvailable, Boolean isRoleAvailable, final Boolean isUserRSysAvalible) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleCode", roleCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getRoleRUserInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getRoleRUserInfoByRoleCode(Long systemId, String roleCode, Boolean isSystemAvailable,
                                                          Boolean isRoleAvailable, final Boolean isUserRSysAvalible) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleCode", roleCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getRoleRUserInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getUserUnRoleInfoByRoleId(Long systemId, Long roleId, Boolean isSystemAvailable,
                                                         Boolean isRoleAvailable, final Boolean isUserRSysAvalible) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleId", roleId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getUserUnRoleInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getUserUnRoleInfoByRoleId(String systemCode, Long roleId, Boolean isSystemAvailable,
                                                         Boolean isRoleAvailable, final Boolean isUserRSysAvalible) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleId", roleId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getUserUnRoleInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getUserUnRoleInfoByRoleCode(String systemCode, String roleCode,
                                                           Boolean isSystemAvailable, Boolean isRoleAvailable, final Boolean isUserRSysAvalible) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleCode", roleCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getUserUnRoleInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getUserUnRoleInfoByRoleCode(Long systemId, String roleCode, Boolean isSystemAvailable,
                                                           Boolean isRoleAvailable, final Boolean isUserRSysAvalible) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleCode", roleCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getUserUnRoleInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public PageInfo<RoleRUserBean> getUserUnRolePageListByRoleId(Map<String, String> param, Long systemId, Long roleId,
                                                                 Boolean isSystemAvailable, Boolean isRoleAvailable, String userName, final Boolean isUserRSysAvalible) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleId", roleId);
        if (userName != null) {
            parameter.put("userName", userName);
        }

        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getUserUnRoleInfoByRole";
        return commonDao.selectPage(state, parameter, PageParam.buildDefaultIns(param));
    }

    @Override
    public List<RoleRUserBean> getUserInfoBySystemId(Long systemId, Boolean isSystemAvailable,
                                                     Boolean isUserRSysAvalible) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getUserInfoBySystem";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getUserInfoBySystemCode(String systemCode, Boolean isSystemAvailable,
                                                       Boolean isUserRSysAvalible) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isUserRSysAvalible", isUserRSysAvalible);
        final String state = RoleRUserMapper.class.getName() + ".getUserInfoBySystem";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getShopUserUnRoleInfoByRoleId(Long systemId, Long roleId, Boolean isSystemAvailable,
                                                             Boolean isRoleAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleId", roleId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        final String state = RoleRUserMapper.class.getName() + ".getShopUserUnRoleInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getShopUserUnRoleInfoByRoleId(String systemCode, Long roleId, Boolean isSystemAvailable,
                                                             Boolean isRoleAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleId", roleId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        final String state = RoleRUserMapper.class.getName() + ".getShopUserUnRoleInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getShopUserUnRoleInfoByRoleCode(Long systemId, String roleCode,
                                                               Boolean isSystemAvailable, Boolean isRoleAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleCode", roleCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        final String state = RoleRUserMapper.class.getName() + ".getShopUserUnRoleInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<RoleRUserBean> getShopUserUnRoleInfoByRoleCode(String systemCode, String roleCode,
                                                               Boolean isSystemAvailable, Boolean isRoleAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(roleCode, "角色Code不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("roleCode", roleCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        final String state = RoleRUserMapper.class.getName() + ".getShopUserUnRoleInfoByRole";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public PageInfo<RoleRUserBean> getShopUserUnRolePageListByRoleId(Map<String, String> param, Long systemId, Long roleId,
                                                                     Boolean isSystemAvailable, Boolean isRoleAvailable, String userName) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("roleId", roleId);
        if (userName != null) {
            parameter.put("userName", userName);
        }

        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isRoleAvailable", isRoleAvailable);
        final String state = RoleRUserMapper.class.getName() + ".getShopUserUnRoleInfoByRole";
        return commonDao.selectPage(state, parameter, PageParam.buildDefaultIns(param));
    }

    @Override
    public Integer insertRoleRUser(List<RoleRUserBean> roleRUser) {
        String state = RoleRUserMapper.class.getName() + ".insertRoleRUser";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("roleRUser", roleRUser);
        return this.commonDao.insert(state, parameter);
    }

    @Override
    public Integer deleteRoleRUserByRoleId(List<Long> roleIds) {
        AssertUtil.assertNotEmpty(roleIds, "多个角色ID为空或不存在");
        String state = RoleRUserMapper.class.getName() + ".deleteRoleRUserById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("roleIds", roleIds);
        return this.commonDao.delete(state, parameter);
    }

    @Override
    public Integer deleteRoleRUserByUserId(List<Long> userIds) {
        AssertUtil.assertNotEmpty(userIds, "多个用户ID为空或不存在");
        String state = RoleRUserMapper.class.getName() + ".deleteRoleRUserById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userIds", userIds);
        return this.commonDao.delete(state, parameter);
    }

    @Override
    public Integer deleteRoleRUserByRoleId(Long roleId, List<Long> userIds) {
        AssertUtil.assertTrue(roleId != null && roleId > 0, "角色ID不能为空或不存在");
        AssertUtil.assertNotEmpty(userIds, "多个用户ID为空或不存在");
        String state = RoleRUserMapper.class.getName() + ".deleteRoleRUserById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("roleId", roleId);
        parameter.put("userId", userIds);
        return this.commonDao.delete(state, parameter);
    }
}
