package cn.faury.fwmf.module.service.menu.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 角色关联菜单服务的SQL工厂
 */
public class RoleRMenuSQLProvider {

	/**
	 * 日志记录器
	 */
	private static Logger log = LoggerFactory.getLogger(RoleRMenuSQLProvider.class);

	/**
	 * 根据业务系统、角色、是否可用获取角色下菜单列表
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
	 * @param parameters
	 *            输入参数
	 * @return 查询SQL
	 */
	public static String getRoleRMenuInfosByRole(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}

		if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("roleId") && !parameters.containsKey("roleCode")) {
			log.debug("SQL ==> null");
			return null;
		}
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT M.MENU_ID MENUID,M.MENU_PID MENUPID,M.MENU_NAME MENUNAME" +
                ",M.MENU_CODE MENUCODE,M.MENU_ACTION_KEY menuActionKey, ");
		sql.append("M.SORT,M.IS_LEAF isLeaf,M.SYSTEM_ID systemId,M.IS_AVAILABLE isAvailable ");
		sql.append(" FROM " + DBConstOfMenu.TN_MENU_INFO + " M");
		sql.append(" LEFT JOIN " + DBConstOfMenu.TN_ROLE_R_MENU + " RM ON M.MENU_ID = RM.MENU_ID");
		sql.append(" WHERE ");
		// 【二选一】String systemCode 业务系统CODE /Long systemId 业务系统ID
		sql.append(" M.SYSTEM_ID = (");
		sql.append(" SELECT S.SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO + " S");
		sql.append(" WHERE ");
		if (parameters.containsKey("systemId")) {
			sql.append(" S.SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
		} else {
			sql.append(" S.SYSTEM_CODE= #{systemCode} ");
		}
		// 【可选】isSystemAvailable 系统是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
			sql.append(" AND S.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ) ");
		sql.append(" AND RM.ROLE_ID = (");
		sql.append(" SELECT R.ID FROM " + DBConstOfMenu.TN_ROLE_INFO + " R");
		sql.append(" WHERE ");
		if (parameters.containsKey("roleId")) {
			sql.append(" R.ID = #{roleId,jdbcType=BIGINT} ");
		} else {
			sql.append(" R.CODE = #{roleCode,jdbcType=VARCHAR} ");
		}
		// 【可选】isRoleAvailable 角色是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isRoleAvailable") && parameters.get("isRoleAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isRoleAvailable");
			sql.append(" AND R.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ) ");
		// 【可选】isMenuAvailable 菜单是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
			sql.append(" AND M.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ORDER BY M.SYSTEM_ID,M.MENU_PID,M.SORT,M.MENU_ID,M.MENU_NAME ");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();

	}

	/**
	 * 新增角色菜单授权信息
	 * 
	 * @param parameters
	 *            输入参数
	 * @return SQL语句
	 */
	public static String insertRoleRMenuInfo(final Map<String, Object> parameters) {

		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("roleId")) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("menuIds")) {
			log.debug("SQL ==> null");
			return null;
		}

		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		// menuIds 多个菜单id
		@SuppressWarnings("unchecked")
        List<Long> menuIds = (List<Long>) parameters.get("menuIds");
		sql.append("INSERT INTO " + DBConstOfMenu.TN_ROLE_R_MENU + " (`ROLE_ID`, `MENU_ID`) VALUES ");
		if (menuIds != null) {
			if (menuIds.size() > 0) {
				for (int i = 0; i < menuIds.size(); i++) {
					sql.append("(#{roleId,jdbcType=BIGINT},  #{menuIds[" + i + "],jdbcType=BIGINT}),");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * 1.删除角色菜单关联关系，同时删除角色关联菜单的功能按钮
	 * 
	 * @param parameters
	 *            输入参数
	 * @return SQL语句
	 */
	public static String deleteRoleRMenuInfo(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("menuIds")) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("roleCode")) {
			log.debug("SQL ==> null");
			return null;
		}

		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("DELETE FROM " + DBConstOfMenu.TN_ROLE_R_MENU + " WHERE ");
		// roleId 角色ID
		sql.append("ROLE_ID = #{roleId}");
		sql.append(" AND MENU_ID IN (");
		// menuIds 多个菜单id
		@SuppressWarnings("unchecked")
        List<Long> menuIds = (List<Long>) parameters.get("menuIds");
		if (menuIds != null) {
			if (menuIds.size() > 0) {
				for (int i = 0; i < menuIds.size(); i++) {
					sql.append("#{menuIds[" + i + "],jdbcType=BIGINT},");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();

	}

	/**
	 * 2.删除角色菜单关联关系，同时删除角色关联菜单的功能按钮
	 * 
	 * @param parameters
	 *            输入参数
	 * @return SQL语句
	 */
	public static String deleteRoleRMenuFuncInfo(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("menuIds")) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("roleCode")) {
			log.debug("SQL ==> null");
			return null;
		}

		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("DELETE FROM " + DBConstOfMenu.TN_ROLE_R_FUNCTION);
		sql.append(" WHERE ");
		sql.append(" FUNCTION_ID IN (SELECT FUNCTION_ID FROM " + DBConstOfMenu.TN_FUNCTION_INFO);
		sql.append(" WHERE ");
		sql.append(" MENU_ID IN (SELECT MENU_ID FROM " + DBConstOfMenu.TN_MENU_INFO);
		sql.append(" WHERE ");
		sql.append(" MENU_ID IN (SELECT MENU_ID FROM " + DBConstOfMenu.TN_ROLE_R_MENU);
		sql.append(" WHERE ");

		// roleId 角色ID
		sql.append(" ROLE_ID = #{roleId} ");
		sql.append(" AND MENU_ID IN (");
		// menuIds 多个菜单id
		@SuppressWarnings("unchecked")
        List<Long> menuIds = (List<Long>) parameters.get("menuIds");
		if (menuIds != null) {
			if (menuIds.size() > 0) {
				for (int i = 0; i < menuIds.size(); i++) {
					sql.append("#{menuIds[" + i + "],jdbcType=BIGINT},");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		sql.append(" )");
		sql.append("  )");
		sql.append("   )");

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();

	}

	/**
	 * 根据用户Id，系统Code/ID 获取菜单和功能
	 * 
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
	 * @return 菜单列表
	 */
	public static String getMenuInfoByUserSystemAndRoleIds(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}

		if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("userId")) {
			log.debug("SQL ==> null");
			return null;
		}
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT DISTINCT M.MENU_ID menuId,M.MENU_PID menuPid,M.MENU_NAME menuName" +
				",M.MENU_CODE menuCode,M.MENU_ACTION_KEY menuActionKey, ");
		sql.append("M.SORT,M.IS_LEAF isLeaf,M.SYSTEM_ID systemId,M.IS_AVAILABLE isAvailable ");
		sql.append(" FROM " + DBConstOfMenu.TN_MENU_INFO + " M");
		sql.append(" LEFT JOIN " + DBConstOfMenu.TN_ROLE_R_MENU + " RM ON M.MENU_ID = RM.MENU_ID");
		sql.append(" WHERE ");
		// 【二选一】String systemCode 业务系统CODE /Long systemId 业务系统ID
		sql.append(" M.SYSTEM_ID = (");
		sql.append(" SELECT S.SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO + " S");
		sql.append(" WHERE ");
		if (parameters.containsKey("systemId")) {
			sql.append(" S.SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
		} else {
			sql.append(" S.SYSTEM_CODE= #{systemCode} ");
		}
		// 【可选】isSystemAvailable 系统是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
			sql.append(" AND S.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ) ");

		sql.append(" AND RM.ROLE_ID IN (");
		sql.append(" SELECT UR.ROLE_ID FROM " + DBConstOfMenu.TN_USER_R_ROLE + " UR , ");
		sql.append(DBConstOfMenu.TN_ROLE_INFO + " TR ");
		sql.append(" WHERE UR.ROLE_ID=TR.ROLE_ID AND ");
		sql.append(" USER_ID = #{userId,jdbcType=BIGINT}");
		sql.append(" AND TR.SYSTEM_ID = (");
		sql.append(" SELECT TS.SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO + " TS");
		sql.append(" WHERE ");
		// 【二选一】String systemCode 业务系统CODE /Long systemId 业务系统ID
		if (parameters.containsKey("systemId")) {
			sql.append(" TS.SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
		} else {
			sql.append(" TS.SYSTEM_CODE= #{systemCode} ");
		}
		// 【可选】isSystemAvailable 系统是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
			sql.append(" AND TS.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ) ");
		// 【可选】isRoleAvailable 角色是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isRoleAvailable") && parameters.get("isRoleAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isRoleAvailable");
			sql.append(" AND TR.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		// 【可选】roleIds 多个角色Id
		if (parameters.get("roleIds") != null && ((List<Long>) parameters.get("roleIds")).size() > 0) {
			List<Long> roleIds = (List<Long>) parameters.get("roleIds");
			sql.append(" AND TR.ROLE_ID in (");
			for (int i = 0; i < roleIds.size(); i++) {
				sql.append(" #{roleIds[" + i + "],jdbcType=BIGINT},");
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" ) ");
		} else if (parameters.get("roleCodes") != null && ((List<Long>) parameters.get("roleCodes")).size() > 0) {
			// 多个角色编码
			List<String> roleCodes = (List<String>) parameters.get("roleCodes");
			sql.append(" AND TR.ROLE_CODE in (");
			for (int i = 0; i < roleCodes.size(); i++) {
				sql.append(" #{roleCodes[" + i + "],jdbcType=BIGINT},");
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" ) ");
		}
		sql.append(" ) ");

		// 【可选】isMenuAvailable 菜单是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
			sql.append(" AND M.IS_AVAILABLE= '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ORDER BY M.SYSTEM_ID,M.MENU_PID,M.SORT,M.MENU_ID ");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

}
