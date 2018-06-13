package cn.faury.fwmf.module.service.role.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.role.bean.RoleInfoBean;
import cn.faury.fwmf.module.api.role.service.RoleService;
import cn.faury.fwmf.module.service.role.mapper.RoleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色服务提供者
 */
public class RoleServiceImpl implements RoleService<RoleInfoBean> {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public RoleServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 根据用户ID获取指定系统下的角色信息，只查询启用状态的角色和业务系统
     *
     * @param systemCode 业务系统编码
     * @param userId     用户ID
     * @return 用户角色列表
     */
    @Override
    public List<RoleInfoBean> getUserRolesByUserId(String systemCode, Long userId) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotEmpty(systemCode,"系统编码不可以为空");
        String state = RoleInfoMapper.class.getName() + ".getUserRolesByUserId";
        Map<String, Object> param = new HashMap<>();
        param.put("systemCode", systemCode);
        param.put("userId", userId);
        return this.commonDao.selectList(state, param);
    }

    /**
     * 根据用户ID获取指定系统下的角色授权信息，只查询启用状态的角色和业务系统
     *
     * @param systemCode 业务系统编码
     * @param userId     用户ID
     * @return 用户授权列表
     */
    @Override
    public List<String> getUserRolePermsByUserId(String systemCode, Long userId) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotEmpty(systemCode,"系统Code不可以为空");

        String state = RoleInfoMapper.class.getName() + ".getUserRolePermsByUserId";
        Map<String, Object> param = new HashMap<>();
        param.put("systemCode", systemCode);
        param.put("userId", userId);
        return this.commonDao.selectList(state, param);
    }

    /**
     * 根据角色编码获取角色信息
     *
     * @param roleCode 角色编码
     * @return 角色对象
     */
    @Override
    public RoleInfoBean getRoleInfoByCode(String roleCode) {
        AssertUtil.assertNotEmpty(roleCode,"角色编码不可以为空");

        String state = RoleInfoMapper.class.getName() + ".getRoleInfoByCode";
        return this.commonDao.selectOne(state, roleCode);
    }

    /**
     * 插入用户角色信息
     *
     * @param userId   用户ID
     * @param roleCode 角色编码
     * @return 成功插入条数
     */
    @Override
    public int insertUserRRole(Long userId, String roleCode) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotEmpty(roleCode, "角色编码不可以为空");

        RoleInfoBean roleInfoBean = this.getRoleInfoByCode(roleCode);
        AssertUtil.assertNotNull(roleInfoBean,"角色信息不存在");

        String state = RoleInfoMapper.class.getName() + ".insertUserRRole";
        Map<String, Object> param = new HashMap<>();
        param.put("roleId", roleInfoBean.getRoleId());
        param.put("userId", userId);
        return this.commonDao.insert(state, param);
    }

    /**
     * 删除用户角色信息
     *
     * @param userId 用户ID
     * @return 成功删除条数
     */
    @Override
    public int deleteUserRRole(Long userId) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");

        String state = RoleInfoMapper.class.getName() + ".deleteUserRRole";
        return this.commonDao.insert(state, userId);
    }

    /**
     * 更新用户角色
     * <p>
     * 先删除原有的角色，插入新的角色
     *
     * @param userId   用户ID
     * @param roleCode 用户编码
     * @return 成功插入条数
     */
    @Override
    @Transactional
    public int updateUserRRole(Long userId, String roleCode) {
        this.deleteUserRRole(userId);
        return this.insertUserRRole(userId, roleCode);
    }
}
