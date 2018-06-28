package cn.faury.fwmf.module.service.app.sqlProvider;

import cn.faury.fwmf.module.api.app.bean.UserRAppInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfApp;

import java.util.List;
import java.util.Map;

/**
 * APP注册服务SQL提供
 */
public class UserRAppInfoSqlProvider {

	/**
	 * 获取用户授权App信息
	 *
	 * @param parameter 参数
	 * @return SQL
	 */
	@SuppressWarnings("unchecked")
	public static String getUserRAppInfoList(final Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		if (parameter.size() > 0) {
			sql.append("SELECT 	UR.ID as id, UR.USER_ID as userId,UR.APP_ID as appId" +
					", app.APP_CODE as appCode,app.APP_NAME as appName" +
					",app.IS_AVAILABLE as isAvailable,APP.APP_OS as appOS" +
					",  SYS.`SYSTEM_ID` AS systemId,	SYS.`SYSTEM_CODE` AS systemCode" +
					",sys.`SYSTEM_NAME` AS systemName FROM ");
			sql.append(DBConstOfApp.TN_USER_R_APP);
			sql.append(" UR LEFT JOIN " + DBConstOfApp.TN_APP_INFO + " APP ON APP.APP_ID = UR.APP_ID ");
			sql.append(" JOIN " + DBConstOfApp.TN_SYSTEM_INFO + " SYS ON SYS.SYSTEM_ID = APP.SYSTEM_ID");
			sql.append(" WHERE ");
			sql.append(" UR.USER_ID IN (");
			List<Long> userIds = (List<Long>) parameter.get("userIds");
			for (int i = 0; i < userIds.size(); i++) {
				sql.append("#{userIds[" + i + "]},");
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(")");
			// app是否可用
			Boolean isAvailable = (Boolean) parameter.get("isAppAvailable");
			if (isAvailable != null) {
				sql.append("AND APP.IS_AVAILABLE = ");
				sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'");
			}
			sql.append(" ORDER BY ur.APP_ID");
		}
		return sql.toString();
	}

	/**
	 * 获取用户授权App信息（多个APP信息合并）
	 *
	 * @param parameter 参数
	 * @return SQL
	 */
	@SuppressWarnings("unchecked")
	public static String getUserRAppInfoListWithConcat(final Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		if (parameter.size() > 0) {
			sql.append("SELECT  UR.USER_ID AS userId,GROUP_CONCAT(ur.APP_ID) as concatAppIds, "); // 合并后的ID
			sql.append("GROUP_CONCAT(app.APP_NAME) as concatAppNames,");// 合并后的Name
			sql.append(" APP.APP_ID as appId,APP.APP_CODE AS appCode,APP.APP_NAME AS appName" +
					",APP.APP_OS AS appOS, SYS.`SYSTEM_ID` AS systemId,	SYS.`SYSTEM_CODE` AS systemCode" +
					",	sys.`SYSTEM_NAME` AS systemName,  APP.IS_AVAILABLE as isAvailable FROM ");
			sql.append(DBConstOfApp.TN_USER_R_APP);
			sql.append(" UR  JOIN " + DBConstOfApp.TN_APP_INFO + " APP ON APP.APP_ID = UR.APP_ID ");
			sql.append(" JOIN " + DBConstOfApp.TN_SYSTEM_INFO + " SYS ON SYS.SYSTEM_ID = APP.SYSTEM_ID");
			sql.append(" WHERE ");
			sql.append(" UR.USER_ID IN (");
			List<Long> userIds = (List<Long>) parameter.get("userIds");
			for (int i = 0; i < userIds.size(); i++) {
				sql.append("#{userIds[" + i + "]},");
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(")");
			// app是否可用
			Boolean isAvailable = (Boolean) parameter.get("isAppAvailable");
			if (isAvailable != null) {
				sql.append("AND APP.IS_AVAILABLE = ");
				sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'");
			}
			sql.append(" GROUP BY ur.USER_ID ORDER BY ur.APP_ID");
		}
		return sql.toString();
	}

	/**
	 * 插入用户授权APP对象
	 *
	 * @param parameter 参数
	 * @return SQL
	 */
	@SuppressWarnings("unchecked")
	public static String insertUserRApp(final Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		if (parameter.size() > 0) {
			sql.append(" insert into ");
			sql.append(DBConstOfApp.TN_USER_R_APP);
			sql.append("(USER_ID,APP_ID)");
			sql.append("VALUES");
			List<UserRAppInfoBean> userRApps = (List<UserRAppInfoBean>) parameter.get("userRApps");
			for (int i = 0; i < userRApps.size(); i++) {
				sql.append("(#{userRApps[" + i + "].userId},#{userRApps[" + i + "].appId}),");
			}
			sql.deleteCharAt(sql.length() - 1);
		}
		return sql.toString();
	}

	/**
	 * 根据用户ID删除用户所有授权APP关系
	 *
	 * @param parameter 参数
	 * @return SQL
	 */
	@SuppressWarnings("unchecked")
	public static String deleteUserRAppByUserId(final Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		if (parameter.size() > 0) {
			sql.append(" delete from ");
			sql.append(DBConstOfApp.TN_USER_R_APP);
			sql.append(" where USER_ID in(");
			List<Long> userIds = (List<Long>) parameter.get("userIds");
			for (int i = 0; i < userIds.size(); i++) {
				sql.append("#{userIds[" + i + "]}");
				if (i != userIds.size() - 1) {
					sql.append(",");
				}
			}
			sql.append(")");
		}
		return sql.toString();
	}

	/**
	 * 根据用户ID、多个APP ID删除用户授权APP关系
	 *
	 * @param parameter 参数
	 * @return SQL
	 */
	@SuppressWarnings("unchecked")
	public static String deleteUserRAppByUserIds(final Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		if (parameter.size() > 0) {
			sql.append(" delete from ");
			sql.append(DBConstOfApp.TN_USER_R_APP);
			List<Long> appIds = (List<Long>) parameter.get("appIds");
			sql.append(" where APP_ID in(");
			for (int i = 0; i < appIds.size(); i++) {
				sql.append("#{appIds[" + i + "]}");
				if (i != appIds.size() - 1) {
					sql.append(",");
				}
			}
			sql.append(")");
			sql.append(" AND  USER_ID =#{userId}");
		}
		return sql.toString();
	}

	/**
	 * 根据用户授权APP对象ID删除用户授权关系
	 * 
	 * @param parameter 参数
	 * @return SQL
	 */
	@SuppressWarnings("unchecked")
	public static String deleteUserRAppById(final Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		if (parameter.size() > 0) {
			sql.append(" delete from ");
			sql.append(DBConstOfApp.TN_USER_R_APP);
			sql.append(" where APP_ID in(");
			List<Long> ids = (List<Long>) parameter.get("ids");
			for (int i = 0; i < ids.size(); i++) {
				sql.append("#{ids[" + i + "]}");
				if (i != ids.size() - 1) {
					sql.append(",");
				}
			}
			sql.append(")");
		}
		return sql.toString();
	}
}
