package cn.faury.fwmf.module.service.menu.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 角色关联功能按钮的SQL工厂
 */
public class RoleRFuncSQLProvider {

	/**
	 * 日志记录器
	 */
	private static Logger log = LoggerFactory.getLogger(RoleRFuncSQLProvider.class);

	/**
	 * 根据业务系统、角色、菜单,是否可用等获取角色下菜单功能按钮列表
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
	 * 【可选】 Long menuId 菜单ID / String menuCode 菜单CODE编码
	 * 【可选】isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @param parameters
	 *            输入参数
	 * @return SQL语句
	 */
	public static String getRoleRFuncInfosByRole(final Map<String, Object> parameters) {
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
		sql.append("SELECT F.FUNCTION_ID,F.FUNCTION_NAME,F.FUNCTION_CODE,F.MENU_ID,F.IS_AVAILABLE  ");
		sql.append(" FROM " + DBConstOfMenu.TN_FUNCTION_INFO + " F");
		sql.append(" JOIN " + DBConstOfMenu.TN_ROLE_R_FUNCTION + " RF ON F.FUNCTION_ID = RF.FUNCTION_ID");
		sql.append(" JOIN " + DBConstOfMenu.TN_MENU_INFO + " M ON M.MENU_ID = F.MENU_ID");
		sql.append(" WHERE ");

		// 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
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
		// 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
		sql.append(" AND RF.ROLE_ID = (");
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

		// 【可选】isFuncAvailable 功能按钮是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
		if (parameters.containsKey("isFuncAvailable") && parameters.get("isFuncAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isFuncAvailable");
			sql.append(" AND F.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}

		// 【可选】 Long menuId 菜单ID / String menuCode 菜单CODE编码
		if (parameters.get("menuId") != null) {
			sql.append(" AND M.MENU_ID = #{menuId,jdbcType=BIGINT} ");
		} else if (parameters.get("menuCode") != null) {
			sql.append(" AND M.MENU_CODE = #{menuCode,jdbcType=VARCHAR} ");
		}

		// 【可选】isMenuAvailable 菜单是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
			sql.append(" AND M.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ORDER BY F.MENU_ID,F.FUNCTION_ID,F.FUNCTION_NAME ");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * 插入角色功能按钮关联关系
	 * 
	 * @param parameters
	 *            输入参数
	 * @return SQL语句
	 */
	public static String insertRoleRFuncInfo(final Map<String, Object> parameters) {

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
		if (!parameters.containsKey("funcIds")) {
			log.debug("SQL ==> null");
			return null;
		}

		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		// funcIds 多个功能按钮ID
		@SuppressWarnings("unchecked")
        List<Long> funcIds = (List<Long>) parameters.get("funcIds");
		sql.append("INSERT INTO " + DBConstOfMenu.TN_ROLE_R_FUNCTION + " (`ROLE_ID`, `FUNCTION_ID`) VALUES ");
		if (funcIds != null) {
			if (funcIds.size() > 0) {
				for (int i = 0; i < funcIds.size(); i++) {
					sql.append("(#{roleId,jdbcType=BIGINT},  #{funcIds[" + i + "],jdbcType=BIGINT}),");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * 删除角色功能按钮关联关系
	 * 
	 * @param parameters
	 *            输入参数
	 * @return SQL语句
	 */
	public static String deleteRoleRFuncInfo(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}

		if (!parameters.containsKey("funcIds")) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("roleId")) {
			log.debug("SQL ==> null");
			return null;
		}

		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("DELETE FROM " + DBConstOfMenu.TN_ROLE_R_FUNCTION + " WHERE ");
		// roleId 角色ID
		sql.append("ROLE_ID = #{roleId} ");
		sql.append(" AND FUNCTION_ID IN (");
		// funcIds 多个功能按钮ID
		@SuppressWarnings("unchecked")
        List<Long> funcIds = (List<Long>) parameters.get("funcIds");
		if (funcIds != null) {
			if (funcIds.size() > 0) {
				for (int i = 0; i < funcIds.size(); i++) {
					sql.append(" #{funcIds[" + i + "],jdbcType=BIGINT},");
				}
				sql.deleteCharAt(sql.length() - 1);
			}
		}

		sql.append(")");

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();

	}

	/**
	 * 根据用户Id，系统Code/ID 获取功能
	 * 
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
	 * @return 菜单功能列表
	 */
	public static String getFuncByUserSystemAndRoleIds(final Map<String, Object> parameters) {
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
		sql.append("SELECT F.FUNCTION_ID FUNCID,F.FUNCTION_NAME FUNCNAME,F.FUNCTION_CODE FUNCCODE,F.MENU_ID MENUID,F.SYSTEM_ID SYSTEMID,F.IS_AVAILABLE ISAVAILABLE ");
		sql.append(" FROM " + DBConstOfMenu.TN_FUNCTION_INFO + " F");
		sql.append(" LEFT JOIN " + DBConstOfMenu.TN_ROLE_R_FUNCTION + " RF ON F.FUNCTION_ID = RF.FUNCTION_ID");
		sql.append(" LEFT JOIN " + DBConstOfMenu.TN_MENU_INFO + " M ON M.MENU_ID = F.MENU_ID");
		sql.append(" WHERE ");

		// 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
		sql.append(" F.SYSTEM_ID = (");
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
		if (parameters.get("roleIds") != null || parameters.get("roleCodes") != null) {
			//
			if (parameters.get("roleIds") != null && ((List<Long>) parameters.get("roleIds")).size() > 0) {
				List<Long> roleIds = (List<Long>) parameters.get("roleIds");
				// 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
				sql.append(" AND RF.ROLE_ID IN (");
				sql.append(" SELECT R.ID FROM " + DBConstOfMenu.TN_ROLE_INFO + " R");
				sql.append(" WHERE ");
				sql.append(" R.ID  IN  (");
				for (int i = 0; i < roleIds.size(); i++) {
					sql.append(" #{roleIds[" + i + "],jdbcType=BIGINT},");
				}
				sql.deleteCharAt(sql.length() - 1);
				sql.append(" ) ");
				// 【可选】isRoleAvailable 角色是否可用
				// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
				if (parameters.containsKey("isRoleAvailable") && parameters.get("isRoleAvailable") != null) {
					Boolean isAvailable = (Boolean) parameters.get("isRoleAvailable");
					sql.append(" AND R.IS_AVAILABLE = '");
					sql.append(isAvailable.booleanValue() ? "Y" : "N");
					sql.append("' ");
				}
				sql.append(" AND R.SYSTEM_ID = (");
				sql.append(" SELECT TS.SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO + " TS");
				sql.append(" WHERE ");
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
				sql.append(" ) ");
			} else if (parameters.get("roleCodes") != null && ((List<Long>) parameters.get("roleCodes")).size() > 0) {
				List<String> roleCodes = (List<String>) parameters.get("roleCodes");
				// 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
				sql.append(" AND RF.ROLE_ID IN (");
				sql.append(" SELECT R.ID FROM " + DBConstOfMenu.TN_ROLE_INFO + " R");
				sql.append(" WHERE ");
				sql.append(" R.CODE  IN  (");
				for (int i = 0; i < roleCodes.size(); i++) {
					sql.append(" #{roleCodes[" + i + "],jdbcType=VARCHAR},");
				}
				sql.deleteCharAt(sql.length() - 1);
				sql.append(" ) ");
				// 【可选】isRoleAvailable 角色是否可用
				// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
				if (parameters.containsKey("isRoleAvailable") && parameters.get("isRoleAvailable") != null) {
					Boolean isAvailable = (Boolean) parameters.get("isRoleAvailable");
					sql.append(" AND R.IS_AVAILABLE = '");
					sql.append(isAvailable.booleanValue() ? "Y" : "N");
					sql.append("' ");
				}
				sql.append(" AND R.SYSTEM_ID = (");
				sql.append(" SELECT TS.SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO + " TS");
				sql.append(" WHERE ");
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
				sql.append(" ) ");
			}
		} else {
			sql.append(" AND RF.ROLE_ID IN (");
			sql.append(" SELECT UR.ROLE_ID FROM " + DBConstOfMenu.TN_USER_R_ROLE + " UR,");
			sql.append(DBConstOfMenu.TN_ROLE_INFO + " TR ");
			sql.append(" WHERE UR.ROLE_ID=TR.ID AND ");
			sql.append(" UR.USER_ID = #{userId,jdbcType=BIGINT}");
			sql.append(" AND TR.SYSTEM_ID = (");
			sql.append(" SELECT TS.SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO + " TS");
			sql.append(" WHERE ");
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

			if (parameters.containsKey("isRoleAvailable") && parameters.get("isRoleAvailable") != null) {
				Boolean isAvailable = (Boolean) parameters.get("isRoleAvailable");
				sql.append(" AND TR.IS_AVAILABLE = '");
				sql.append(isAvailable.booleanValue() ? "Y" : "N");
				sql.append("' ");
			}
			sql.append(" ) ");

		}

		// 【可选】isFuncAvailable 功能按钮是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
		if (parameters.containsKey("isFuncAvailable") && parameters.get("isFuncAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isFuncAvailable");
			sql.append(" AND F.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ORDER BY F.MENU_ID,F.FUNCTION_ID,F.FUNCTION_NAME ");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}
}
