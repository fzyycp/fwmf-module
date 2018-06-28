package cn.faury.fwmf.module.service.system.sqlProvider;

import cn.faury.fwmf.module.api.system.bean.UserRSystemInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 用户授权系统SQLMapper Provider
 */
public class UserRSystemSqlProvider {

	/**
	 * 日志记录器
	 */
	private static Logger log = LoggerFactory.getLogger(UserRSystemSqlProvider.class);

	/**
	 * 获取用户授权业务系统信息（多个业务系统信息合并）
	 */
	public static String getUserRSystemInfoListWithConcat(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());

		if (parameter == null || parameter.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}

		if (!parameter.containsKey("userIds")) {
			log.debug("SQL ==> null");
			return null;
		}

		// SQL拼装
		StringBuffer sql = new StringBuffer(128);

		sql.append("SELECT U.ID userId,GROUP_CONCAT(RS.SYSTEM_ID) concatSystemIds,GROUP_CONCAT(S.`SYSTEM_NAME`) concatSystemNames ");
		sql.append(" FROM " + DBConstOfSystem.TN_USER_INFO + " U ");
		sql.append(" LEFT JOIN " + DBConstOfSystem.TN_USER_R_SYSTEM + " RS ON U.ID = RS.USER_ID");
		sql.append(" LEFT JOIN " + DBConstOfSystem.TN_SYSTEM_INFO + " S ON RS.SYSTEM_ID = S.SYSTEM_ID");
		sql.append(" WHERE ");
		sql.append(" U.ID IN ( ");
		// userIds 多个用户ID
		@SuppressWarnings("unchecked")
        List<Long> userIds = (List<Long>) parameter.get("userIds");
		if (userIds != null) {
			if (userIds.size() > 0) {
				for (int i = 0; i < userIds.size(); i++) {
					sql.append("#{userIds[" + i + "],jdbcType=BIGINT},");
				}
			}
		}

		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		// 是否可用
		if (parameter.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameter.get("isSystemAvailable");
			sql.append(" AND S.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" GROUP BY U.ID ORDER BY U.ID DESC");

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * 获取用户授权业务系统信息
	 */
	public static String getUserRSystemInfoList(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());

		if (parameter == null || parameter.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}

		if (!parameter.containsKey("userIds")) {
			log.debug("SQL ==> null");
			return null;
		}

		// SQL拼装
		StringBuffer sql = new StringBuffer(128);

		sql.append(" SELECT RS.ID id,U.ID userId,RS.SYSTEM_ID systemId,S.`SYSTEM_NAME` systemName,s.`SYSTEM_CODE` systemCode,s.IS_AVAILABLE isAvailable ");
		sql.append(" FROM  " + DBConstOfSystem.TN_USER_INFO + " U ");
		sql.append(" LEFT JOIN " + DBConstOfSystem.TN_USER_R_SYSTEM + " RS ON U.ID = RS.USER_ID ");
		sql.append(" LEFT JOIN " + DBConstOfSystem.TN_SYSTEM_INFO + "  S ON RS.SYSTEM_ID = S.SYSTEM_ID");
		sql.append(" WHERE ");
		sql.append(" U.ID IN ( ");
		// userIds 多个用户ID
		@SuppressWarnings("unchecked")
        List<Long> userIds = (List<Long>) parameter.get("userIds");
		if (userIds != null) {
			if (userIds.size() > 0) {
				for (int i = 0; i < userIds.size(); i++) {
					sql.append("#{userIds[" + i + "],jdbcType=BIGINT},");
				}
			}
		}

		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		// 是否可用
		if (parameter.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameter.get("isSystemAvailable");
			sql.append(" AND S.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ORDER BY U.ID DESC");

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * 判断授权系统是否已经设置代理人
	 */
	public static String getSystemInAgentUse(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());

		if (parameter == null || parameter.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}

		if (!parameter.containsKey("userId")) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameter.containsKey("systemId")) {
			log.debug("SQL ==> null");
			return null;
		}
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);

		sql.append(" SELECT S.`SYSTEM_NAME` systemName");
		sql.append(" FROM " + DBConstOfSystem.TN_SYSTEM_INFO + " S ," + DBConstOfSystem.TN_USER_AGENT + " A ");
		sql.append(" WHERE S.SYSTEM_ID = A.OS_ID");
		sql.append(" AND A.USER_ID = #{userId}  AND A.OS_ID= #{systemId}");

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();

	}

	/**
	 * 判断用户、授权系统是否已经关联角色
	 */
	public static String getSystemRRole(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());

		if (parameter == null || parameter.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}

		if (!parameter.containsKey("userId")) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameter.containsKey("systemId")) {
			log.debug("SQL ==> null");
			return null;
		}
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);

		sql.append(" SELECT S.`SYSTEM_NAME` systemName");
		sql.append(" FROM " + DBConstOfSystem.TN_ROLE_INFO + " R," + DBConstOfSystem.TN_SYSTEM_INFO + " S ");
		sql.append(" WHERE R.SYSTEM_ID = S.SYSTEM_ID");
		sql.append(" AND EXISTS ( SELECT 1 FROM " + DBConstOfSystem.TN_USER_R_ROLE + " UR");
		sql.append(" WHERE UR.`USER_ID` = #{userId}  AND UR.ROLE_ID = r.ID )");
		sql.append(" AND S.SYSTEM_ID IN ( SELECT SYSTEM_ID FROM " + DBConstOfSystem.TN_USER_R_SYSTEM);
		sql.append(" WHERE USER_ID = #{userId} )");
		sql.append(" and s.SYSTEM_ID = #{systemId} ");

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * 插入用户授权业务系统对象
	 * 
	 * <pre>
	 * 仅使用以下字段：
	 * 【必填】Long userId：用户ID
	 * 【必填】Long systemId：业务系统ID
	 * 其他字段都不使用
	 * </pre>
	 * 
	 * @return 成功插入条数
	 */
	public static String insertUserRSystem(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("userRSystems")) {
			log.debug("SQL ==> null");
			return null;
		}
		StringBuffer sql = new StringBuffer(128);
		sql.append("INSERT INTO " + DBConstOfSystem.TN_USER_R_SYSTEM + " (`USER_ID`, `SYSTEM_ID`) VALUES");
		@SuppressWarnings("unchecked")
        List<UserRSystemInfoBean> userRSystems = (List<UserRSystemInfoBean>) parameters.get("userRSystems");
		if (userRSystems != null) {
			if (userRSystems.size() > 0) {
				for (int i = 0; i < userRSystems.size(); i++) {

					sql.append("(#{userRSystems[" + i + "].userId,jdbcType=BIGINT},  #{userRSystems[" + i
					        + "].systemId,jdbcType=BIGINT}),");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * <pre>
	 * 1.根据用户授权业务系统对象ID删除用户授权关系
	 * 2. 根据用户ID删除用户所有授权业务系统关系
	 * 3.根据用户ID、多个业务系统ID删除用户授权业务系统关系
	 * </pre>
	 * 
	 * @return 成功删除条数
	 */
	public static String deleteUserRSystemById(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("ids") && !parameters.containsKey("userIds")
		        && !parameters.containsKey("systemIds") && !parameters.containsKey("userId")) {
			log.debug("SQL ==> null");
			return null;
		}
		StringBuffer sql = new StringBuffer(128);
		sql.append("DELETE FROM " + DBConstOfSystem.TN_USER_R_SYSTEM);
		sql.append(" WHERE ");
		if (parameters.containsKey("ids") && parameters.get("ids") != null) {
			@SuppressWarnings("unchecked")
            List<Long> ids = (List<Long>) parameters.get("ids");
			sql.append(" ID IN ( ");
			if (ids != null) {
				if (ids.size() > 0) {
					for (int i = 0; i < ids.size(); i++) {
						sql.append(" #{ids[" + i + "]},");
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
		if (parameters.containsKey("systemIds") && parameters.get("systemIds") != null
		        && parameters.containsKey("userId") && parameters.get("userId") != null) {
			sql.append(" USER_ID = #{userId}");
			@SuppressWarnings("unchecked")
            List<Long> systemIds = (List<Long>) parameters.get("systemIds");
			sql.append(" AND SYSTEM_ID IN ( ");
			if (systemIds != null) {
				if (systemIds.size() > 0) {
					for (int i = 0; i < systemIds.size(); i++) {
						sql.append(" #{systemIds[" + i + "]},");
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
