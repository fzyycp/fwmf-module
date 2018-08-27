package cn.faury.fwmf.module.service.apptester.sqlProvider;

import cn.faury.fwmf.module.api.apptester.bean.AppTesterBean;
import cn.faury.fwmf.module.service.constant.DBConstOfAppTester;

import java.util.List;
import java.util.Map;

public class AppTesterSQLProvider {

	public static String queryAppTesterPage(Map<String, Object> parameter) {
		// 参数校验
		StringBuffer sql = new StringBuffer(128);
		sql.append(" SELECT ID id,USER_ID userId,LOGIN_NAME loginName,SYS_ID sysId,APP_ID appId FROM "
		        + DBConstOfAppTester.TN_APP_TESTER);
		sql.append(" WHERE APP_ID = #{appId} ");
		if (parameter.containsKey("userIds")) {
			List<Long> list = (List<Long>) parameter.get("userIds");
			sql.append(" AND USER_ID IN (");
			for (int i = 0; i < list.size(); i++) {
				sql.append(" #{userIds[" + i + "]},");
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" )");
		}
		sql.append(" GROUP BY ID DESC ");
		return sql.toString();
	}

	public static String queryUNAppTesterPage(Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" SELECT DISTINCT U.ID id,U.ACC_NAME loginName,U.USER_NAME userName FROM "
		        + DBConstOfAppTester.TN_USER_INFO + " U");
		sql.append(" LEFT JOIN " + DBConstOfAppTester.TN_USER_R_APP + " A ON A.USER_ID = U.ID");
		sql.append(" WHERE ( A.APP_ID = #{appId} OR U.RESV_FLG = 3) AND U.ID NOT IN (");
		sql.append(" SELECT USER_ID FROM " + DBConstOfAppTester.TN_APP_TESTER);
		sql.append("  WHERE APP_ID = #{appId}) ");
		if (parameter.containsKey("loginName")) {
			sql.append("  AND ACC_NAME  LIKE CONCAT('%',#{loginName},'%') ");
		}
		sql.append("  ORDER BY A.APP_ID DESC ");
		return sql.toString();
	}

	public static String insertAppTester(Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" INSERT INTO " + DBConstOfAppTester.TN_APP_TESTER);
		sql.append("(USER_ID,LOGIN_NAME,SYS_ID,APP_ID)");
		sql.append(" VALUES ");
		List<AppTesterBean> list = (List<AppTesterBean>) parameter.get("list");
		for (int i = 0; i < list.size(); i++) {
			sql.append("(#{list[" + i + "].userId},#{list[" + i + "].loginName},#{list[" + i + "].sysId},#{list[" + i
			        + "].appId}),");
		}
		sql.deleteCharAt(sql.length() - 1);

		return sql.toString();
	}

	public static String delAppTester(Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" DELETE FROM " + DBConstOfAppTester.TN_APP_TESTER);
		sql.append(" WHERE ID IN (");
		List<Long> ids = (List<Long>) parameter.get("ids");
		if (ids != null) {
			if (ids.size() > 0) {
				for (int i = 0; i < ids.size(); i++) {
					sql.append(" #{ids[" + i + "]},");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(" )");
		return sql.toString();
	}

}
