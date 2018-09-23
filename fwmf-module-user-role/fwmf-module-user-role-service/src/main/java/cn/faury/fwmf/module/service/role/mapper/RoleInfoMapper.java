package cn.faury.fwmf.module.service.role.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.role.bean.RoleInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import cn.faury.fwmf.module.service.role.generate.mapper.RoleInfoGenerateMapper;
import cn.faury.fwmf.module.service.role.sqlProvider.RoleSQLProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：角色信息表
 *
 * <pre>
 *     RoleInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自RoleInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface RoleInfoMapper extends RoleInfoGenerateMapper {

    /**
     * 根据用户ID获取指定系统下的角色信息
     *
     * <pre>
     * 可能出现的参数：
     * 【必填】Long userId 用户ID
     * 【可选】String systemCode 业务系统编码
     * </pre>
     *
     * @param parameters 查询参数
     * @return 角色信息
     */
    @SelectProvider(type = RoleSQLProvider.class,method = "getUserRolesByUserId")
    @ResultType(RoleInfoBean.class)
    List<RoleInfoBean> getUserRolesByUserId(Map<String, Object> parameters);

    /**
     * 根据用户ID获取指定系统下的角色授权信息
     *
     * <pre>
     * 可能出现的参数：
     * 【必填】Long userId 用户ID
     * 【可选】String systemCode 业务系统编码
     * </pre>
     *
     * @param parameters 查询参数
     * @return 用户授权
     */
    @SelectProvider(type = RoleSQLProvider.class, method = "getUserRolePermsByUserId")
    @ResultType(String.class)
    List<String> getUserRolePermsByUserId(Map<String, Object> parameters);

    /**
     * 根据角色编码获取角色信息
     *
     * @param roleCode 角色编码
     * @return 角色新
     */
    @Select("SELECT ROLE_ID roleId,ROLE_NAME roleName,ROLE_CODE roleCode,IS_AVAILABLE isAvailable,SYSTEM_ID systemId " +
            "  FROM "+ DBConstOfUserRole.TN_ROLE_INFO +
            " WHERE IS_AVAILABLE = 'Y' AND ROLE_CODE=#{roleCode,jdbcType=VARCHAR} ")
    @ResultType(RoleInfoBean.class)
    RoleInfoBean getRoleInfoByCode(final String roleCode);

    /**
     * 插入用户角色信息
     *
     * <pre>
     * 可能出现的参数：
     * 【必填】Long userId 用户ID
     * 【必填】Long roleId 角色ID
     * </pre>
     *
     * @param parameters 查询参数
     * @return 成功插入条数
     */
    @Insert("INSERT INTO "+ DBConstOfUserRole.TN_USER_R_ROLE+"(`USER_ID`, `ROLE_ID`) " +
            "VALUES (#{userId,jdbcType=BIGINT}, #{roleId,jdbcType=BIGINT})")
    int insertUserRRole(Map<String, Object> parameters);

    /**
     * 删除用户角色信息
     *
     * @param userId 用户ID
     * @return 成功删除条数
     */
    @Insert("DELETE FROM "+ DBConstOfUserRole.TN_USER_R_ROLE + " WHERE USER_ID=#{userId,jdbcType=BIGINT}")
    int deleteUserRRole(final Long userId);
}
