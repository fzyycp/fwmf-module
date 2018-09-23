package cn.faury.fwmf.module.service.role.service;

import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.exception.TipsException;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.role.bean.RoleInfoBean;
import cn.faury.fwmf.module.api.role.service.RoleInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.role.mapper.RoleInfoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现：角色信息表
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了RoleInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class RoleInfoServiceImpl extends CrudBaseServiceImpl<RoleInfoBean, Long> implements RoleInfoService<RoleInfoBean> {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public RoleInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, RoleInfoMapper.class);
    }

    @Override
    public Long insert(RoleInfoBean bean) {
        AssertUtil.assertNotNull(bean, "角色对象不可以为空");
        AssertUtil.assertNotEmpty(bean.getRoleCode(), "角色编码不可以为空");
        AssertUtil.assertNotEmpty(bean.getRoleName(), "角色名称不可以为空");
        // 编码不可以重复
        List<RoleInfoBean> exists = this.query(Collections.singletonMap("roleCode", bean.getRoleCode()));
        AssertUtil.assertTrue(exists == null || exists.size() == 0, "已存在相同角色编码");

        // 名称不可以重复
        exists = this.query(Collections.singletonMap("roleName", bean.getRoleName()));
        AssertUtil.assertTrue(exists == null || exists.size() == 0, "已存在相同角色名称");

        return super.insert(bean);
    }

    @Override
    public int update(RoleInfoBean bean) {
        AssertUtil.assertNotNull(bean, "角色对象不可以为空");
        AssertUtil.assertNotNull(bean.getRoleId(), "角色ID不可以为空");
        AssertUtil.assertNotEmpty(bean.getRoleCode(), "角色编码不可以为空");
        AssertUtil.assertNotEmpty(bean.getRoleName(), "角色名称不可以为空");

        // 编码不可以重复
        List<RoleInfoBean> exists = this.query(Collections.singletonMap("roleCode", bean.getRoleCode()));
        if (exists != null && exists.size() > 0) {
            if (exists.size() == 1) {
                AssertUtil.assertTrue(bean.getRoleId().longValue() == exists.get(0).getRoleId().longValue(), "已存在相同角色编码");
            } else {
                throw new TipsException(RestResultCode.CODE402.getCode(),"已存在相同角色编码");
            }
        }

        // 名称不可以重复
        exists = this.query(Collections.singletonMap("roleName", bean.getRoleName()));
        if (exists != null && exists.size() > 0) {
            if (exists.size() == 1) {
                AssertUtil.assertTrue(bean.getRoleId().longValue() == exists.get(0).getRoleId().longValue(), "已存在相同角色名称");
            } else {
                throw new TipsException(RestResultCode.CODE402.getCode(),"已存在相同角色名称");
            }
        }

        return super.update(bean);
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
        AssertUtil.assertNotEmpty(systemCode, "系统编码不可以为空");
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
        AssertUtil.assertNotEmpty(systemCode, "系统Code不可以为空");

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
        AssertUtil.assertNotEmpty(roleCode, "角色编码不可以为空");

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
        AssertUtil.assertNotNull(roleInfoBean, "角色信息不存在");

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