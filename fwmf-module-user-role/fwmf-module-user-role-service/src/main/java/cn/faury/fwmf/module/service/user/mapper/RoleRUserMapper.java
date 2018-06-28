package cn.faury.fwmf.module.service.user.mapper;


import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.RoleRUserBean;
import cn.faury.fwmf.module.service.user.sqlProvider.RoleRUserSQLProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface RoleRUserMapper {

	/**
	 * 根据业务系统ID、业务系统编码、角色ID、角色CODE编码，查询关联用户信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
	 * 【可选】isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return
	 */
	@SelectProvider(type = RoleRUserSQLProvider.class, method = "getRoleRUserInfoByRole")
	@ResultType(RoleRUserBean.class)
	public List<RoleRUserBean> getRoleRUserInfoByRole();

	/**
	 * 根据业务系统ID、业务系统编码、角色ID、角色CODE编码，查询<b>未关联授权系统 </b>用户信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
	 * 【可选】 userName 用户登录名  -------查询条件
	 * 【可选】isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return
	 */
	@SelectProvider(type = RoleRUserSQLProvider.class, method = "getUserUnRoleInfoByRole")
	@ResultType(RoleRUserBean.class)
	public List<RoleRUserBean> getUserUnRoleInfoByRole();

	/**
	 * 根据业务系统ID、业务系统编码、角色ID、角色CODE编码，查询<b>未关联授权系统 商店</b>用户信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
	 * 【可选】 userName 用户登录名  -------查询条件
	 * 【可选】isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return
	 */
	@SelectProvider(type = RoleRUserSQLProvider.class, method = "getShopUserUnRoleInfoByRole")
	@ResultType(RoleRUserBean.class)
	public List<RoleRUserBean> getShopUserUnRoleInfoByRole();

	/**
	 * 根据业务系统ID、业务系统编码，查询<b>授权系统关联 </b>用户信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【可选】isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isUserRSysAvalible 授权是否启用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return
	 */
	@SelectProvider(type = RoleRUserSQLProvider.class, method = "getUserInfoBySystem")
	@ResultType(RoleRUserBean.class)
	public List<RoleRUserBean> getUserInfoBySystem();

	/**
	 * 插入用户角色关系
	 */
	@SelectProvider(type = RoleRUserSQLProvider.class, method = "insertRoleRUser")
	public Integer insertRoleRUser(final Map<String, Object> parameter);

	/**
	 * <pre>
	 * 1.根据角色ID删除用户角色关系
	 * 2.根据用户ID删除用户角色关系
	 * 3.根据角色ID、用户ID删除用户角色关系
	 * </pre>
	 * 
	 * @return
	 */
	@SelectProvider(type = RoleRUserSQLProvider.class, method = "deleteRoleRUserById")
	public Integer deleteRoleRUserById(final Map<String, Object> parameter);

}
