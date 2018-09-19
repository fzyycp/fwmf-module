package cn.faury.fwmf.module.service.app.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.app.bean.AppVersionBean;
import cn.faury.fwmf.module.service.app.generate.sqlProvider.AppVersionGenerateSqlProvider;
import cn.faury.fwmf.module.service.constant.DBConstOfApp;

import java.util.List;
import java.util.Map;

/**
 * SQL Provider：APP版本信息表
 *
 * <pre>
 *     AppVersionGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自AppVersionGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class AppVersionSqlProvider extends AppVersionGenerateSqlProvider {

	public static String queryAppVersionList(Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" SELECT V.ID id,V.SYS_TYPE sysType,V.VERSION_NUM versionNum,V.URL_TYPE urlType,V.PATH path,V.TITLE title,V.SIZE size,V.SYS_ID sysId,V.APP_ID appId,A.APP_NAME appName,V.IS_COERCION isCoercion,V.IS_FORMAL isFormal,V.MEMO memo,V.CREATE_PERSON createPerson,V.CREATE_PERSON_NAME createPersonName,V.CREATE_TIME createTime,V.UPDATE_PERSON updatePerson,V.UPDATE_PERSON_NAME updatePersonName,V.UPDATE_TIME updateTime,V.DEL_FLAG delFlag ");
		sql.append(" FROM " + DBConstOfApp.TN_APP_VERSION + " V");
		sql.append(" LEFT JOIN " + DBConstOfApp.TN_APP_INFO + " A ON V.APP_ID = A.APP_ID");
		sql.append(" WHERE V.SYS_ID = #{sysId} AND V.DEL_FLAG ='N' ");

		if (parameter.containsKey("appId")) {
			sql.append(" AND V.APP_ID = #{appId}");
		}

		if (parameter.containsKey("sysType")) {
			sql.append(" AND V.SYS_TYPE = #{sysType}");
		}
		sql.append(" ORDER BY appId DESC,sysType DESC,createTime DESC");

		return sql.toString();
	}

	public static String insertAppVersion(AppVersionBean bean) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" INSERT INTO " + DBConstOfApp.TN_APP_VERSION);
		sql.append(" (`SYS_TYPE`,`VERSION_NUM`,`URL_TYPE`,`PATH`,`SIZE`,`SYS_ID`,`APP_ID`,`IS_COERCION`,`IS_FORMAL`,`CREATE_PERSON`,`CREATE_PERSON_NAME`,`CREATE_TIME`,`UPDATE_PERSON`,`UPDATE_PERSON_NAME`,`UPDATE_TIME`,`DEL_FLAG`");
		if (StringUtil.isNotEmpty(bean.getTitle())) {
			sql.append(",`TITLE`");
		}
		if (StringUtil.isNotEmpty(bean.getMemo())) {
			sql.append(",`MEMO`");
		}
		if (StringUtil.isNotEmpty(bean.getIdentifier())) {
			sql.append(",`IDENTIFIER`");
		}
		sql.append(" )");
		sql.append(" VALUES ");
		sql.append(" (#{sysType},#{versionNum},#{urlType},#{path},#{size},#{sysId},#{appId},#{isCoercion},#{isFormal},#{createPerson},#{createPersonName},now(),#{updatePerson},#{updatePersonName},now(),'0'");
		if (StringUtil.isNotEmpty(bean.getTitle())) {
			sql.append(",#{title}");
		}
		if (StringUtil.isNotEmpty(bean.getMemo())) {
			sql.append(",#{memo}");
		}
		if (StringUtil.isNotEmpty(bean.getIdentifier())) {
			sql.append(",#{identifier}");
		}
		sql.append(" )");
		return sql.toString();
	}

	public static String updateAppVersion(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" UPDATE " + DBConstOfApp.TN_APP_VERSION);
		sql.append(" SET ");
		sql.append(" UPDATE_TIME = now() ,");
		if (param.containsKey("updatePerson")) {
			sql.append(" UPDATE_PERSON = #{updatePerson} ,");
		}
		if (param.containsKey("updatePersonName")) {
			sql.append(" UPDATE_PERSON_NAME = #{updatePersonName} ,");
		}
		if (param.containsKey("sysType")) {
			sql.append(" SYS_TYPE = #{sysType} ,");
		}
		if (param.containsKey("versionNum")) {
			sql.append(" VERSION_NUM = #{versionNum} ,");
		}
		if (param.containsKey("urlType")) {
			sql.append(" URL_TYPE = #{urlType} ,");
		}
		if (param.containsKey("path")) {
			sql.append(" PATH = #{path} ,");
		}
		if (param.containsKey("title")) {
			sql.append(" TITLE = #{title} ,");
		}
		if (param.containsKey("size")) {
			sql.append(" SIZE = #{size} ,");
		}
		if (param.containsKey("sysId")) {
			sql.append(" SYS_ID = #{sysId} ,");
		}
		if (param.containsKey("appId")) {
			sql.append(" APP_ID = #{appId} ,");
		}
		if (param.containsKey("isCoercion")) {
			sql.append(" IS_COERCION = #{isCoercion} ,");
		}
		if (param.containsKey("isFormal")) {
			sql.append(" IS_FORMAL = #{isFormal} ,");
		}
		if (param.containsKey("memo")) {
			sql.append(" MEMO = #{memo} ,");
		}
		if (param.containsKey("identifier")) {
			sql.append(" IDENTIFIER = #{identifier},");
		}

		sql.deleteCharAt(sql.length() - 1);
		sql.append(" WHERE ");
		sql.append(" ID = #{id} ");
		return sql.toString();
	}

	public static String delAppVersion(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" UPDATE " + DBConstOfApp.TN_APP_VERSION);
		sql.append(" SET ");
		sql.append(" DEL_FLAG = 'Y' ");
		sql.append(" WHERE ID IN (");
		List<Long> ids = (List<Long>) param.get("ids");
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

	public static String DeleteAppVersion(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" DELETE FROM  " + DBConstOfApp.TN_APP_VERSION);
		sql.append(" WHERE ID IN (");
		List<Long> ids = (List<Long>) param.get("ids");
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

	public static String getVersionNums(Map<String, Object> param) {
		if (param == null || param.size() <= 0) {
			return null;
		}
		if (!param.containsKey("appId") && !param.containsKey("appCode")) {
			return null;
		}
		if (!param.containsKey("sysType")) {
			return null;
		}
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT VERSION_NUM FROM "
		        + DBConstOfApp.TN_APP_VERSION);
		sql.append(" WHERE SYS_TYPE = #{sysType} ");
		if (param.containsKey("appId")) {
			sql.append(" AND APP_ID=#{appId} ");
		}
		if (param.containsKey("appCode")) {
			sql.append(" AND APP_ID = (SELECT APP_ID FROM " + DBConstOfApp.TN_APP_INFO
			        + " WHERE APP_CODE = #{appCode} )");
		}
		if (param.containsKey("isTester")) {
			Boolean isTester = (Boolean) param.get("isTester");
			if (!isTester) {// 不是测试用户，取正式版：1
				sql.append(" AND IS_FORMAL= 'Y' ");
			}
		}

		return sql.toString();
	}

	public static String getAppVersion(Map<String, Object> param) {
		if (param == null || param.size() <= 0) {
			return null;
		}
		StringBuffer sql = new StringBuffer(128);
		sql.append(" SELECT ID id,SYS_TYPE sysType,VERSION_NUM versionNum,URL_TYPE urlType,PATH path,TITLE title,SYS_ID sysId,APP_ID appId,SIZE size,IDENTIFIER identifier,IS_COERCION isCoercion,IS_FORMAL isFormal,MEMO memo,CREATE_PERSON createPerson,CREATE_PERSON_NAME createPersonName,CREATE_TIME createTime,UPDATE_PERSON updatePerson,UPDATE_PERSON_NAME updatePersonName,UPDATE_TIME updateTime,DEL_FLAG delFlag  "
		        + "  FROM " + DBConstOfApp.TN_APP_VERSION);
		sql.append(" WHERE ");
		if (param.containsKey("id")) {
			sql.append(" ID = #{id,jdbcType=BIGINT} ");
		}
		if (param.containsKey("appCode") && param.containsKey("sysType") && param.containsKey("versionNum")) {
			sql.append(" APP_ID = (SELECT APP_ID FROM " + DBConstOfApp.TN_APP_INFO
			        + " WHERE APP_CODE = #{appCode} )");
			sql.append(" AND SYS_TYPE = #{sysType}");
			sql.append(" AND VERSION_NUM = #{versionNum}");
		}

		return sql.toString();
	}

}
