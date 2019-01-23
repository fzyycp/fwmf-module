package cn.faury.fwmf.module.service.menu.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.menu.bean.FunctionInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfMenu;
import cn.faury.fwmf.module.service.menu.sqlProvider.RoleRFuncSQLProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * 角色关联功能按钮服务Mapper
 */
@AutoScannedMapper
@Deprecated
public interface RoleRFuncMapper {

	/**
	 * 根据业务系统、角色、菜单,是否可用等获取角色下菜单功能按钮列表
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
	 * 【二选一】 Long menuId 菜单ID / String menuCode 菜单CODE编码
	 * 【可选】isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return 查询结果
	 */
	@SelectProvider(type = RoleRFuncSQLProvider.class, method = "getRoleRFuncInfosByRole")
	@ResultType(FunctionInfoBean.class)
	public List<FunctionInfoBean> getRoleRFuncInfosByRole();

	/**
	 * 插入角色功能按钮关联关系
	 * 
	 * @param roleId
	 *            角色ID
	 * @param funcId
	 *            功能按钮ID
	 * @return 成功插入条数
	 */
	@InsertProvider(type = RoleRFuncSQLProvider.class, method = "insertRoleRFuncInfo")
	public abstract Integer insertRoleRFuncInfo(Long roleId, Long funcId);

	/**
	 * 删除角色功能按钮关联关系
	 * 
	 * @param parameter
	 *            输入参数
	 * @return 成功删除条数
	 */
	@SelectProvider(type = RoleRFuncSQLProvider.class, method = "deleteRoleRFuncInfo")
	public Integer deleteRoleRFuncInfo(Map<String, Object> parameter);

	/**
	 * 删除角色下所有的授权功能按钮
	 * 
	 * @param parameter
	 *            输入参数
	 * @return 成功删除条数
	 */
	@Delete("DELETE FROM " + DBConstOfMenu.TN_ROLE_R_FUNCTION + " WHERE ROLE_ID = #{roleId,jdbcType=BIGINT}")
	public Integer deleteAllRoleRFuncInfo(Map<String, Object> parameter);
	
	/**
	 * 根据用户Id，系统Code/ID 获取功能
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】String systemCode 业务系统CODE /Long systemId 业务系统ID 
	 * 【二选一】String roleCode 角色CODE /Long roleId 角色ID
	 * 【可选】List<String> roleCodes 多个角色Code /List<Long> roleIds 多个角色Id
	 * 【可选】isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isFuncAvailable 功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @param parameter  传的参数
	 * @return 菜单功能列表
	 */
	@SelectProvider(type = RoleRFuncSQLProvider.class, method = "getFuncByUserSystemAndRoleIds")
	@ResultType(FunctionInfoBean.class)
	public List<FunctionInfoBean> getFuncByUserSystemAndRoleIds(Map<String, Object> parameter);
	 
}
