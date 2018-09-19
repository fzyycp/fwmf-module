package cn.faury.fwmf.module.service.app.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.app.bean.AppInfoBean;
import cn.faury.fwmf.module.service.app.generate.sqlProvider.AppInfoGenerateSqlProvider;
import cn.faury.fwmf.module.service.constant.DBConstOfApp;

import java.util.List;
import java.util.Map;

/**
 * SQL Provider：APP信息
 *
 * <pre>
 *     AppInfoGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自AppInfoGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class AppInfoSqlProvider extends AppInfoGenerateSqlProvider {

	/**
	 * SQL拼接字符串:WHERE
	 */
	private static String WHERE = " WHERE ";

	/**
	 * SQL拼接字符串:AND
	 */
	private static String AND = " AND ";

	/**
	 * SQL拼接字符串:LIKE
	 */
	private static String LIKE = " LIKE ";

	/**
	 * SQL拼接字符串:ORDER_BY
	 */
	private static String ORDER_BY = " ORDER BY ";

	/**
	 * 根据条件分页查询手机APP注册信息
	 *
	 * @param parameters 查询参数
	 * @return SQL
	 */
	public static String queryAppInfoByPager(Map<String, Object> parameters) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(
		        "SELECT APP_ID AS appId,APP_CODE AS appCode,APP_NAME AS appName,APP_OS AS appOS,SYSTEM_ID AS systemId,"
		                + "app.IS_AVAILABLE AS isAvailable,s.`SYSTEM_CODE` AS systemCode,s.`SYSTEM_NAME` AS systemName,"
		                + "REJECT_GUEST_USER rejectGuestUser,REJECT_SHOPPING_USER rejectShoppingUser,ALLOW_BACKGROUND_USER allowBackgroundUser,TRACK_ID trackId,SERVER_DOMAIN serverDomain"
		                + " FROM " + DBConstOfApp.TN_APP_INFO + " app LEFT JOIN " + DBConstOfApp.TN_SYSTEM_INFO
		                + " s ON s.SYSTEM_ID = app.SYSTEM_ID").append(WHERE + " 1=1 ");
		if (parameters.size() > 0) {
			// APP是否可用
			if (parameters.containsKey("isAppAvailable")
			        && StringUtil.isNotEmpty((String) parameters.get("isAppAvailable"))) {
				sql.append(AND).append("app.`IS_AVAILABLE` = #{isAppAvailable}");
			}
			// 系统ID
			if (parameters.containsKey("systemId")) {
				sql.append(AND).append("app.`SYSTEM_ID` = #{systemId}");
			}
			// 系统code
			if (parameters.containsKey("systemCode")) {
				sql.append(AND).append("s.`SYSTEM_CODE`").append(LIKE).append("CONCAT('%' ,#{systemCode},'%')");
			}
			// appCode
			if (parameters.containsKey("appCode") && StringUtil.isNotEmpty((String) parameters.get("appCode"))) {
				sql.append(AND).append("app.`APP_CODE`").append(LIKE).append("CONCAT('%' ,#{appCode},'%')");
			}
			// appName
			if (parameters.containsKey("appName") && StringUtil.isNotEmpty((String) parameters.get("appName"))) {
				sql.append(AND).append("app.`APP_NAME`").append(LIKE).append("CONCAT('%' ,#{appName},'%')");
			}
			sql.append(ORDER_BY).append("APP_NAME, APP_CODE ASC,IS_AVAILABLE DESC");
		}

		return sql.toString();
	}

	/**
	 * 根据条件不分页查询手机APP注册信息
	 *
	 * @param parameters 查询参数
	 * @return SQL
	 */
	public static String queryAppInfo(Map<String, Object> parameters) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(
		        "SELECT APP_ID AS appId,APP_CODE AS appCode,APP_NAME AS appName,APP_OS AS appOS,SYSTEM_ID AS systemId,"
		                + "app.IS_AVAILABLE AS isAvailable,s.`SYSTEM_CODE` AS systemCode,s.`SYSTEM_NAME` AS systemName,"
		                + "REJECT_GUEST_USER rejectGuestUser ,REJECT_SHOPPING_USER rejectShoppingUser,ALLOW_BACKGROUND_USER allowBackgroundUser,TRACK_ID trackId,SERVER_DOMAIN serverDomain"
		                + " FROM " + DBConstOfApp.TN_APP_INFO + " app LEFT JOIN " + DBConstOfApp.TN_SYSTEM_INFO
		                + " s ON s.SYSTEM_ID = app.SYSTEM_ID").append(WHERE + " 1=1 ");
		if (parameters.size() > 0) {
			// APP是否可用
			if (parameters.containsKey("isAppAvailable")) {
				Boolean isAppAvailable = (Boolean) parameters.get("isAppAvailable");
				sql.append(AND).append("app.`IS_AVAILABLE` = '").append(isAppAvailable.booleanValue() ? "Y" : "N")
				        .append("'");
			}
			// 系统ID
			if (parameters.containsKey("systemId")) {
				sql.append(AND).append("app.`SYSTEM_ID` = #{systemId}");
			}
			// 系统code
			if (parameters.containsKey("systemCode")) {
				sql.append(AND).append("s.`SYSTEM_CODE`").append(LIKE).append("CONCAT('%' ,#{systemCode},'%')");
			}
			// appCode
			if (parameters.containsKey("appCode") && StringUtil.isNotEmpty((String) parameters.get("appCode"))) {
				sql.append(AND).append("app.`APP_CODE`").append(LIKE).append("CONCAT('%' ,#{appCode},'%')");
			}
			// appName
			if (parameters.containsKey("appName") && StringUtil.isNotEmpty((String) parameters.get("appName"))) {
				sql.append(AND).append("app.`APP_NAME`= ").append(LIKE).append("CONCAT('%' ,#{appName},'%')");
			}
			sql.append(ORDER_BY).append("APP_NAME, APP_CODE ASC,IS_AVAILABLE DESC");
		}

		return sql.toString();
	}

	/**
	 * 根据条件查询手机APP注册信息
	 *
	 * @param parameters 查询参数
	 * @return SQL
	 */
	public static String getAppInfoList(Map<String, Object> parameters) {
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT APP_ID AS appId,APP_CODE AS appCode,APP_NAME AS appName,APP_OS AS appOS,s.SYSTEM_ID AS systemId,"
		        + "app.IS_AVAILABLE AS isAvailable,s.`SYSTEM_CODE` AS systemCode,s.`SYSTEM_NAME` AS systemName,"
		        + "REJECT_GUEST_USER rejectGuestUser ,REJECT_SHOPPING_USER rejectShoppingUser,ALLOW_BACKGROUND_USER allowBackgroundUser,TRACK_ID trackId,SERVER_DOMAIN serverDomain"
		        + "  FROM "
		        + DBConstOfApp.TN_APP_INFO
		        + " app LEFT JOIN "
		        + DBConstOfApp.TN_SYSTEM_INFO
		        + " s ON s.SYSTEM_ID = app.SYSTEM_ID");
		if (parameters.size() > 0) {
			// 系统是否可用
			if (parameters.containsKey("isSysAvailable")) {
				Boolean isSysAvailable = (Boolean) parameters.get("isSysAvailable");
				sql.append(AND).append("s.`IS_AVAILABLE` = '").append(isSysAvailable.booleanValue() ? "Y" : "N")
				        .append("'");
			}
			sql.append(WHERE + " 1=1");
			// 系统ID
			if (parameters.containsKey("systemId")) {
				sql.append(AND).append("app.`SYSTEM_ID` = #{systemId}");
			}
			// 系统code
			if (parameters.containsKey("systemCode")) {
				sql.append(AND).append("s.`SYSTEM_CODE` = #{systemCode}");
			}
			// appID
			if (parameters.containsKey("appId")) {
				sql.append(AND).append("app.`APP_ID` = #{appId}");
			}
			// appCode
			if (parameters.containsKey("appCode")) {
				sql.append(AND).append("app.`APP_CODE`= #{appCode}");
			}
			// APP是否可用
			if (parameters.containsKey("isAppAvailable")) {
				Boolean isAppAvailable = (Boolean) parameters.get("isAppAvailable");
				sql.append(AND).append("app.`IS_AVAILABLE` = '").append(isAppAvailable.booleanValue() ? "Y" : "N")
				        .append("'");
			}
			sql.append(ORDER_BY).append("APP_NAME, APP_CODE ASC,app.IS_AVAILABLE DESC");
		}

		return sql.toString();
	}

	/**
	 * 根据appCode删除手机APP注册信息
	 *
	 * @param parameters 查询参数
	 * @return SQL
	 */
	public static String deleteAppInfoByAppCodes(final Map<String, Object> parameters) {
		StringBuffer sql = new StringBuffer(128);
		if (parameters.size() > 0) {
			sql.append(" DELETE  FROM ");
			sql.append(DBConstOfApp.TN_APP_INFO);
			// appCodes
			if (parameters.containsKey("appCodes")) {
				sql.append(WHERE + "`APP_CODE` IN (");
				List<?> appCodes = (List<?>) parameters.get("appCodes");
				for (int i = 0; i < appCodes.size(); i++) {
					sql.append("#{appCodes[" + i + "]}");
					if (i != appCodes.size() - 1) {
						sql.append(",");
					}
				}
				sql.append(")");
			}
		}
		return sql.toString();
	}

	/**
	 * 根据appIds删除手机APP注册信息
	 *
	 * @param parameters 查询参数
	 * @return SQL
	 */
	public static String deleteAppInfoByAppIds(final Map<String, Object> parameters) {
		StringBuffer sql = new StringBuffer(128);
		if (parameters.size() > 0) {
			sql.append(" DELETE  FROM ");
			sql.append(DBConstOfApp.TN_APP_INFO);
			// appIDs
			if (parameters.containsKey("appIds")) {
				sql.append(WHERE + "`APP_ID` IN (");
				List<?> appIds = (List<?>) parameters.get("appIds");
				for (int i = 0; i < appIds.size(); i++) {
					sql.append("#{appIds[" + i + "]}");
					if (i != appIds.size() - 1) {
						sql.append(",");
					}
				}
				sql.append(")");
			}
		}
		return sql.toString();
	}

	/**
	 * 更新手机APP注册信息
	 * 
	 * @param app
	 *            APP对象
	 * @return SQL
	 */
	public static String updateAppInfo(final AppInfoBean app) {
		StringBuffer sql = new StringBuffer(128);
		if (null != app) {
			sql.append(" UPDATE ").append(DBConstOfApp.TN_APP_INFO);
			sql.append(" set ");
			if (StringUtil.isNotEmpty(app.getAppName())) {
				sql.append("`APP_NAME`=#{appName},");
			}
			if (StringUtil.isNotEmpty(app.getAppOs())) {
				sql.append("`APP_OS`=#{appOS},");
			}
			if (null != app.getSystemId()) {
				sql.append("`SYSTEM_ID`=#{systemId},");
			}
			if (null != app.getIsAvailable()) {
				sql.append("`IS_AVAILABLE`=#{isAvailable},");
			}
			if (StringUtil.isNotEmpty(app.getRejectGuestUser())) {
				sql.append("`REJECT_GUEST_USER`=#{rejectGuestUser},");
			}
			if (StringUtil.isNotEmpty(app.getRejectShoppingUser())) {
				sql.append("`REJECT_SHOPPING_USER`=#{rejectShoppingUser},");
			}
			if (StringUtil.isNotEmpty(app.getAllowBackgroundUser())) {
				sql.append("`ALLOW_BACKGROUND_USER`=#{allowBackgroundUser},");
			}
			if (StringUtil.isNotEmpty(app.getTrackId())) {
				sql.append("`TRACK_ID`=#{trackId},");
			}
			if (StringUtil.isNotEmpty(app.getServerDomain())) {
				sql.append("`SERVER_DOMAIN`=#{serverDomain},");
			}
			// 判断是用appId修改还是用appCode
			if (null != app.getAppId()) {
				// 使用id修改的时候可以修改appCode值
				if (StringUtil.isNotEmpty(app.getAppCode())) {
					sql.append("`APP_CODE` = #{appCode},");
				}
				// 去掉最后一个逗号
				sql.deleteCharAt(sql.length() - 1);
				sql.append(WHERE).append("`APP_ID` = #{appId}");
			} else if (StringUtil.isNotEmpty(app.getAppCode())) {
				// 去掉最后一个逗号
				sql.deleteCharAt(sql.length() - 1);
				// id是主键不可以修改
				sql.append(WHERE).append("`APP_CODE` = #{appCode}");
			}
		}
		return sql.toString();
	}

	public static String checkAppCode(Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		sql.append("select APP_ID AS appId,APP_CODE AS appCode,APP_NAME AS appName,APP_OS AS appOS,"
		        + "REJECT_GUEST_USER rejectGuestUser ,REJECT_SHOPPING_USER rejectShoppingUser,"
		        + "ALLOW_BACKGROUND_USER allowBackgroundUser,TRACK_ID trackId,SERVER_DOMAIN serverDomain FROM " + DBConstOfApp.TN_APP_INFO
		        + " where APP_CODE = #{appCode}");
		if (parameter.containsKey("appId")) {
			sql.append(" and APP_ID !=#{appId}");
		}
		return sql.toString();
	}

	public static String checkAppName(Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		sql.append("select APP_ID AS appId,APP_CODE AS appCode,APP_NAME AS appName,APP_OS AS appOS,"
		        + "REJECT_GUEST_USER rejectGuestUser ,REJECT_SHOPPING_USER rejectShoppingUser,"
		        + "ALLOW_BACKGROUND_USER allowBackgroundUser,TRACK_ID trackId,SERVER_DOMAIN serverDomain FROM " + DBConstOfApp.TN_APP_INFO
		        + " where APP_NAME =#{appName}");
		if (parameter.containsKey("appId")) {
			sql.append(" and APP_ID !=#{appId}");
		}
		return sql.toString();
	}

}
