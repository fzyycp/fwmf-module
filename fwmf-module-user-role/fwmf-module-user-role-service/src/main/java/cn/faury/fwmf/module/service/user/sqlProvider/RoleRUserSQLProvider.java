package cn.faury.fwmf.module.service.user.sqlProvider;

import cn.faury.fwmf.module.api.user.bean.RoleRUserBean;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class RoleRUserSQLProvider {

	/**
	 * 日志记录器
	 */
	private static Logger log = LoggerFactory.getLogger(RoleRUserSQLProvider.class);

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
	public static String getRoleRUserInfoByRole(final Map<String, Object> parameters) {
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
		sql.append("SELECT U.LOGIN_NAME accName,U.USER_NAME userName,U.USER_ID,TS.SYSTEM_NAME systemName  ");
		sql.append(" FROM " + DBConstOfUserRole.TN_USER_INFO + " U ");
		sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_R_ROLE + " UO ON U.USER_ID = UO.USER_ID");
		sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_SYSTEM_INFO + " TS ON U.ORIGIN_OS_ID = TS.SYSTEM_ID");
		sql.append(" WHERE ");
		/*
		 * if (parameters.containsKey("isUserRSysAvalible") &&
		 * parameters.get("isUserRSysAvalible") != null) { Boolean isAvailable =
		 * (Boolean) parameters.get("isUserRSysAvalible");
		 * sql.append(" AND RS.IS_AVAILABLE = '");
		 * sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'"); sql.append("' ");
		 * }
		 */
		// 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
		sql.append(" UO.ROLE_ID IN (");
		sql.append(" SELECT R.ROLE_ID FROM " + DBConstOfUserRole.TN_ROLE_INFO + " R");
		sql.append(" WHERE ");
		if (parameters.containsKey("roleId")) {
			sql.append(" R.ROLE_ID = #{roleId,jdbcType=BIGINT} ");
		} else {
			sql.append(" R.ROLE_CODE = #{roleCode,jdbcType=VARCHAR} ");
		}
		// 【可选】isRoleAvailable 角色是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isRoleAvailable") && parameters.get("isRoleAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isRoleAvailable");
			sql.append(" AND R.IS_AVAILABLE = '");
			sql.append(isAvailable ? "Y" : "N");
			sql.append("' ");
		}
		// 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
		if (parameters.containsKey("systemId") || parameters.containsKey("systemCode")) {
			sql.append(" AND R.SYSTEM_ID = ( SELECT S.SYSTEM_ID FROM " + DBConstOfUserRole.TN_SYSTEM_INFO + " S");
			sql.append(" WHERE");
			if (parameters.containsKey("systemId")) {
				sql.append(" S.SYSTEM_ID = #{systemId}");
			}
			if (parameters.containsKey("systemCode")) {
				sql.append(" S.`SYSTEM_CODE` = #{systemCode}");
			}
			if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
				Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
				sql.append(" AND S.IS_AVAILABLE = '");
				sql.append(isAvailable ? "Y" : "N");
				sql.append("' ");
			}
			sql.append(" ) ");
		}
		sql.append(" ) ");
		if (parameters.containsKey("loginName")) {
			sql.append(" AND U.LOGIN_NAME like CONCAT('%',#{loginName},'%')");
		}
		sql.append(" ORDER BY U.LOGIN_NAME,U.USER_ID ");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();

	}

	/**
	 * 根据业务系统ID、业务系统编码、角色ID、角色CODE编码，查询未关联用户信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
	 * 【可选】 userName 用户登录名  -------查询条件
	 * 【可选】isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】isUserRSysAvalible 授权是否启用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return
	 */
	public static String getUserUnRoleInfoByRole(final Map<String, Object> parameters) {
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
		sql.append("SELECT AU.LOGIN_NAME loginName,AU.USER_NAME userName,AU.USER_ID " +
                ",TS.SYSTEM_NAME systemName  ");
		sql.append(" FROM " + DBConstOfUserRole.TN_USER_INFO + " AU ");
		sql.append(" ," + DBConstOfUserRole.TN_SYSTEM_INFO + " TS ");
		sql.append(" WHERE  TS.SYSTEM_ID=AU.ORIGIN_OS_ID ");
		sql.append(" AND  AU.USER_ID  NOT IN (");
		sql.append("SELECT U.USER_ID ");
		sql.append(" FROM " + DBConstOfUserRole.TN_USER_INFO + " U ");
		sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_R_ROLE + " UO ON U.USER_ID = UO.USER_ID");
		sql.append(" WHERE ");
		// 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码
		sql.append(" UO.ROLE_ID IN (");
		sql.append(" SELECT R.ROLE_ID FROM " + DBConstOfUserRole.TN_ROLE_INFO + " R");
		sql.append(" WHERE ");
		if (parameters.containsKey("roleId")) {
			sql.append(" R.ROLE_ID = #{roleId,jdbcType=BIGINT} ");
		} else {
			sql.append(" R.ROLE_CODE = #{roleCode,jdbcType=VARCHAR} ");
		}
		// 【可选】isRoleAvailable 角色是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isRoleAvailable") && parameters.get("isRoleAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isRoleAvailable");
			sql.append(" AND R.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ) ) ");
		// 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
		sql.append(" AND AU.USER_ID IN (");
		sql.append(" SELECT RS.USER_ID FROM " + DBConstOfUserRole.TN_USER_R_SYSTEM + " RS");
		sql.append(" WHERE");
		sql.append(" RS.SYSTEM_ID = ( SELECT S.SYSTEM_ID FROM " + DBConstOfUserRole.TN_SYSTEM_INFO + " S");
		sql.append(" WHERE");
		if (parameters.containsKey("systemId")) {
			sql.append(" S.SYSTEM_ID = #{systemId}");
		}
		if (parameters.containsKey("systemCode")) {
			sql.append(" S.`SYSTEM_CODE` = #{systemCode}");
		}

		if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
			sql.append(" AND S.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ) ");
		if (parameters.containsKey("isUserRSysAvalible") && parameters.get("isUserRSysAvalible") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isUserRSysAvalible");
			sql.append(" AND RS.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append("  )");
		if (parameters.containsKey("userName")) {
			sql.append(" AND AU.LOGIN_NAME like CONCAT('%',#{userName},'%')");
		}

		sql.append(" ORDER BY AU.LOGIN_NAME,AU.USER_ID ");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();

	}

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
	 */
	public static String getShopUserUnRoleInfoByRole(final Map<String, Object> parameters) {
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
		sql.append("SELECT AU.LOGIN_NAME accName,AU.USER_NAME userName,AU.USER_ID" +
				",TS.SYSTEM_NAME systemName  ");
		sql.append(" FROM " + DBConstOfUserRole.TN_USER_INFO + " AU," + DBConstOfUserRole.TN_SHOP_USER_INFO + " SU,"
		        + DBConstOfUserRole.TN_SYSTEM_INFO + " TS");
		sql.append(" WHERE  SU.SHOP_USER_ID = AU.USER_ID AND TS.SYSTEM_ID=AU.ORIGIN_OS_ID ");
		sql.append(" AND SU.SHOP_ID IN ( SELECT SHOP_ID FROM " + DBConstOfUserRole.TN_SHOP_R_SYSTEM);
		sql.append(" WHERE SYSTEM_ID = (SELECT SYSTEM_ID FROM " + DBConstOfUserRole.TN_SYSTEM_INFO + " WHERE ");
		// 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
		if (parameters.containsKey("systemId")) {
			sql.append(" SYSTEM_ID = #{systemId}");
		}
		if (parameters.containsKey("systemCode")) {
			sql.append(" SYSTEM_CODE = #{systemCode} ");
		}
		if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
			sql.append(" AND IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append("))");
		// 【二选一】 Long roleId 角色ID / String roleCode 角色CODE编码

		sql.append(" AND SU.SHOP_USER_ID NOT IN (SELECT USER_ID FROM " + DBConstOfUserRole.TN_USER_R_ROLE);

		sql.append(" WHERE ROLE_ID = (SELECT ID FROM " + DBConstOfUserRole.TN_ROLE_INFO);
		sql.append(" WHERE ");
		if (parameters.containsKey("roleId")) {
			sql.append(" ID = #{roleId,jdbcType=BIGINT} ");
		} else {
			sql.append(" CODE like CONCAT('%',#{roleCode},'%')");
		}
		// 【可选】isRoleAvailable 角色是否可用
		// 【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用；null:都包含】
		if (parameters.containsKey("isRoleAvailable") && parameters.get("isRoleAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isRoleAvailable");
			sql.append(" AND IS_AVAILABLE = '");
			sql.append(isAvailable ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ) ) ");
		if (parameters.containsKey("userName")) {
			sql.append(" AND AU.LOGIN_NAME like CONCAT('%',#{userName},'%')");
		}
		sql.append(" ORDER BY AU.LOGIN_NAME,AU.USER_ID ");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

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
	public static String getUserInfoBySystem(final Map<String, Object> parameters) {
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
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT AU.LOGIN_NAME loginName,AU.USER_NAME userName,AU.USER_ID  ");
		sql.append(" FROM " + DBConstOfUserRole.TN_USER_INFO + " AU ");
		sql.append(" WHERE USER_ID IN (");
		sql.append(" SELECT USER_ID FROM " + DBConstOfUserRole.TN_USER_R_SYSTEM);
		sql.append(" WHERE");
		sql.append(" SYSTEM_ID = ( SELECT SYSTEM_ID FROM " + DBConstOfUserRole.TN_SYSTEM_INFO);
		sql.append(" WHERE");
		// 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
		if (parameters.containsKey("systemId")) {
			sql.append(" SYSTEM_ID = #{systemId}");
		}
		if (parameters.containsKey("systemCode")) {
			sql.append(" `SYSTEM_CODE` = #{systemCode}");
		}

		if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
			sql.append(" AND IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ) ");
		if (parameters.containsKey("isUserRSysAvalible") && parameters.get("isUserRSysAvalible") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isUserRSysAvalible");
			sql.append(" AND IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append("  )");
		sql.append(" ORDER BY AU.LOGIN_NAME,AU.USER_ID ");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * 插入用户角色关系
	 */
	public static String insertRoleRUser(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("roleRUser")) {
			log.debug("SQL ==> null");
			return null;
		}
		StringBuffer sql = new StringBuffer(128);
		sql.append("INSERT INTO " + DBConstOfUserRole.TN_USER_R_ROLE + " (`USER_ID`, `ROLE_ID`) VALUES");
		@SuppressWarnings("unchecked")
        List<RoleRUserBean> roleRUser = (List<RoleRUserBean>) parameters.get("roleRUser");
		if (roleRUser != null) {
			if (roleRUser.size() > 0) {
				for (int i = 0; i < roleRUser.size(); i++) {

					sql.append("(#{roleRUser[" + i + "].id,jdbcType=BIGINT},  #{roleRUser[" + i
					        + "].roleId,jdbcType=BIGINT}),");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * <pre>
	 * 1.根据角色ID删除用户角色关系
	 * 2.根据用户ID删除用户角色关系
	 * </pre>
	 * 
	 * @return
	 */
	public static String deleteRoleRUserById(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("roleIds") && !parameters.containsKey("userIds")
		        && !parameters.containsKey("roleId") && !parameters.containsKey("userId")) {
			log.debug("SQL ==> null");
			return null;
		}
		StringBuffer sql = new StringBuffer(128);
		sql.append("DELETE FROM " + DBConstOfUserRole.TN_USER_R_ROLE);
		sql.append(" WHERE ");
		if (parameters.containsKey("roleIds") && parameters.get("roleIds") != null) {
			@SuppressWarnings("unchecked")
            List<Long> roleIds = (List<Long>) parameters.get("roleIds");
			sql.append(" ROLE_ID IN ( ");
			if (roleIds != null) {
				if (roleIds.size() > 0) {
					for (int i = 0; i < roleIds.size(); i++) {
						sql.append(" #{roleIds[" + i + "]},");
					}
				}
			}
		}
		if (parameters.containsKey("userIds") && parameters.get("userIds") != null) {
			@SuppressWarnings("unchecked")
            List<Long> userIds = (List<Long>) parameters.get("userIds");
			sql.append(" USER_ID IN ( ");
			if (userIds != null) {
				if (userIds.size() > 0) {
					for (int i = 0; i < userIds.size(); i++) {
						sql.append(" #{userIds[" + i + "]},");
					}
				}
			}
		}

		if (parameters.containsKey("roleId") && parameters.get("roleId") != null && parameters.containsKey("userId")
		        && parameters.get("userId") != null) {
			@SuppressWarnings("unchecked")
            List<Long> userId = (List<Long>) parameters.get("userId");
			sql.append(" ROLE_ID = #{roleId} ");
			sql.append(" AND USER_ID IN ( ");
			if (userId != null) {
				if (userId.size() > 0) {
					for (int i = 0; i < userId.size(); i++) {
						sql.append(" #{userId[" + i + "]},");
					}
				}
			}
		}

		sql.deleteCharAt(sql.length() - 1);
		sql.append(" )");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}
}
