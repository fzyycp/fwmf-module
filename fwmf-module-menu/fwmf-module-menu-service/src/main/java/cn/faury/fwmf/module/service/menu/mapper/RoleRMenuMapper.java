package cn.faury.fwmf.module.service.menu.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfMenu;
import cn.faury.fwmf.module.service.menu.sqlProvider.RoleRMenuSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 角色关联菜单服务Mapper
 */
@AutoScannedMapper
public interface RoleRMenuMapper {

	/**
	 * 根据业务系统ID、角色CODE、业务系统CODE、角色ID、角色是否可用获取角色下菜单列表
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】String systemCode 业务系统CODE /Long systemId 业务系统ID 
	 * 【二选一】String roleCode 角色CODE /Long roleId 角色ID
	 * 【可选】isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return 查询结果
	 */
	@SelectProvider(type = RoleRMenuSQLProvider.class, method = "getRoleRMenuInfosByRole")
	@ResultType(MenuInfoBean.class)
	public List<MenuInfoBean> getRoleRMenuInfosByRole();

	/**
	 * 插入角色菜单关联关系
	 * 
	 * @param roleId
	 *            角色ID
	 * @param menuId
	 *            菜单ID
	 * @return 成功插入条数
	 */
	@InsertProvider(type = RoleRMenuSQLProvider.class, method = "insertRoleRMenuInfo")
	public abstract Integer insertRoleRMenuInfo(Long roleId, Long menuId);

	/**
	 * 1.删除角色菜单关联关系，同时删除角色关联菜单的功能按钮
	 * 
	 * @param parameter
	 *            输入参数
	 * @return 成功删除条数
	 */

	@DeleteProvider(type = RoleRMenuSQLProvider.class, method = "deleteRoleRMenuInfo")
	public Integer deleteRoleRMenuInfo(Map<String, Object> parameter);

	/**
	 * 2.删除角色菜单关联关系，同时删除角色关联菜单的功能按钮
	 * 
	 * @param parameter
	 *            输入参数
	 * @return 成功删除条数
	 */

	@DeleteProvider(type = RoleRMenuSQLProvider.class, method = "deleteRoleRMenuFuncInfo")
	public Integer deleteRoleRMenuFuncInfo(Map<String, Object> parameter);

	/**
	 * 1.删除角色下所有的授权菜单，同时删除角色关联的所有授权功能按钮
	 * 
	 * @param parameter
	 *            输入参数
	 * @return 成功删除条数
	 */
	@Delete("DELETE FROM " + DBConstOfMenu.TN_ROLE_R_MENU + " WHERE ROLE_ID = #{roleId,jdbcType=BIGINT}")
	public Integer deleteAllRoleRMenuInfo(Map<String, Object> parameter);

	/**
	 * 2.删除角色下所有的授权菜单，同时删除角色关联的所有授权功能按钮
	 * 
	 * @param parameter
	 *            输入参数
	 * @return 成功删除条数
	 */
	@Delete("DELETE FROM " + DBConstOfMenu.TN_ROLE_R_FUNCTION + " WHERE FUNCTION_ID IN (SELECT FUNCTION_ID FROM "
	        + DBConstOfMenu.TN_FUNCTION_INFO + " WHERE MENU_ID IN (SELECT MENU_ID FROM " + DBConstOfMenu.TN_MENU_INFO
	        + " WHERE MENU_ID IN (SELECT MENU_ID FROM " + DBConstOfMenu.TN_ROLE_R_MENU
	        + " WHERE ROLE_ID = #{roleId,jdbcType=BIGINT}))) ")
	public Integer deleteAllRoleRMenuFuncInfo(Map<String, Object> parameter);
	
	
	/**
	 * 根据用户Id，系统Code/ID 获取菜单和功能
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】String systemCode 业务系统CODE /Long systemId 业务系统ID 
	 * 【二选一】String roleCode 角色CODE /Long roleId 角色ID
	 * 【可选】List<String> roleCodes 多个角色Code /List<Long> roleIds 多个角色Id
	 * 【可选】isWithFunc 是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * 【可选】isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isFuncAvailable 功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @param parameter  传的参数
	 * @return 菜单列表
	 */
	@SelectProvider(type = RoleRMenuSQLProvider.class, method = "getMenuInfoByUserSystemAndRoleIds")
	@ResultType(MenuInfoBean.class)
	public List<MenuInfoBean> getMenuInfoByUserSystemAndRoleIds(Map<String, Object> parameter);
	
}
