package cn.faury.fwmf.module.service.push.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.push.bean.PushInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfPush;

import java.util.List;
import java.util.Map;

/**
 * 推送信息 SQLMapper Provider
 */
public class PushSqlProvider {

	/**
	 * 根据：任务标题 、 推送时间 前、推送时间 后 、 任务状态、行数、页数 、对象类型 查询推送列表的推送信息
	 * 
	 * @return SQL语句
	 */
	public static String queryPushInfo(final Map<String, Object> parameters) {
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		StringBuffer sqlWhere = new StringBuffer();
		sql.append("SELECT ").append("PMI.MESSAGE_ID as messageId,").append("PMI.MESSAGE_TITLE as messageTitle,")
		        .append("PMI.PUSH_TYPE as pushType,").append("PMI.MESSAGE_INTRODUCTION as messageIntroduction,")
		        .append("PMI.PUSH_DATE as pushDate,").append("PMI.END_DATE  as endDate,").append("PMI.STATE as state,")
		        .append("PMC.READ_COUNT as readCount,").append("PMC.PUSH_COUNT as pushCount,")
		        .append("PMC.TOTAL_COUNT as totalCount,PMI.TYPE  as type");
		sqlWhere.append(" FROM ").append(DBConstOfPush.TN_PUSH_MESSAGE_INFO).append(" PMI ");

		sqlWhere.append(" LEFT JOIN ").append(DBConstOfPush.TN_PUSH_MESSAGE_COUNT).append(" PMC ON PMC.MESSAGE_ID=PMI.MESSAGE_ID ");
		sqlWhere.append(" WHERE SYS_ID = #{sysId} AND DEL_FLAG = 0 ");
		if (parameters.containsKey("messageTitle")) {
			sqlWhere.append(" AND PMI.MESSAGE_TITLE LIKE CONCAT('%',#{messageTitle},'%') ");
		}
		if (parameters.containsKey("typeCode")) {
			sqlWhere.append(" AND TYPE_CODE = #{typeCode} ");
		}

		if (parameters.containsKey("pushDate")) {
			sqlWhere.append(" AND  PMI.PUSH_DATE >= #{pushDate} ");
		}

		if (parameters.containsKey("endDate")) {
			sqlWhere.append(" AND PMI.PUSH_DATE <= #{endDate} ");
		}

		if (parameters.containsKey("state")) {
			sqlWhere.append(" AND PMI.STATE = #{state} ");
		}
		return sql.toString() + sqlWhere.toString();
	}

	public static String queryPushMessage(final Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer();

		// 2.4 用户群、指定用户
		sql.append("SELECT DISTINCT PMI.MESSAGE_ID AS messageId,PMI.MESSAGE_TITLE AS messageTitle,"
		        + "	PMI.PUSH_DATE AS pushDate,PMI.END_DATE AS endDate,PMI.STATE state,PMI.TYPE type,PMI.CREATE_TIME AS createTime,"
		        + "	PMI.UPDATE_TIME AS updateTime,PMI.PUSH_TYPE AS pushType,PMI.SYS_ID as sysId,PMR.APP_ID appId,"
		        + " PMR.USER_ID userId,PMR.IS_READ isRead,PMR.PUSH_TIME pushTime ");
		sql.append(" FROM " + DBConstOfPush.TN_PUSH_MESSAGE_RECEIVE + " PMR ");
		sql.append(" LEFT JOIN " + DBConstOfPush.TN_PUSH_MESSAGE_INFO + " PMI ON PMR.MESSAGE_ID = PMI.MESSAGE_ID ");
		sql.append(" LEFT JOIN " + DBConstOfPush.TN_SYSTEM_INFO + " S ON PMR.SYS_ID=S.SYSTEM_ID ");
		sql.append(" LEFT JOIN " + DBConstOfPush.TN_APP_INFO + " A ON PMR.APP_ID=A.APP_ID ");
		sql.append(" LEFT JOIN " + DBConstOfPush.TN_USER_INFO + " U ON PMR.USER_ID = U.ID");
		sql.append(" WHERE PMR.DEL_FLAG != 1 AND PMI.STATE = '4' AND PMR.DEL_FLAG = 'N' ");
		sql.append(" AND PMI.CREATE_TIME >= U.INS_TSTMP AND CONCAT(PMI.END_DATE,' 23:59:59') >= NOW() ");
		if (parameter.containsKey("userId")) {
			sql.append(" AND PMR.USER_ID = #{userId} ");
		}
		if (parameter.containsKey("systemCode")) {
			sql.append(" AND S.SYSTEM_CODE = #{systemCode}  ");
		}
		if (parameter.containsKey("appCode")) {
			sql.append(" AND A.APP_CODE = #{appCode}  ");
		}
		if (parameter.containsKey("pushTime")) {
			sql.append(" AND PMR.PUSH_TIME >= #{pushTime} ");
		}
		if (parameter.containsKey("isRead") && parameter.get("isRead") != null) {
			Boolean isRead = (Boolean) parameter.get("isRead");
			sql.append(" AND PMR.IS_READ = '");
			sql.append(isRead.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		if (parameter.containsKey("isPush") && parameter.get("isPush") != null) {
			Boolean isPush = (Boolean) parameter.get("isPush");
			sql.append(" AND PMR.IS_PUSH = '");
			sql.append(isPush.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		// sql.append(" order by PMR.PUSH_TIME desc ");
		sql.append(" UNION ");
		// 1.3 全部、固定用户
		sql.append("SELECT DISTINCT PMI.MESSAGE_ID AS messageId,PMI.MESSAGE_TITLE AS messageTitle,"
		        + "	PMI.PUSH_DATE AS pushDate,PMI.END_DATE AS endDate,PMI.STATE state,PMI.TYPE type,PMI.CREATE_TIME AS createTime,"
		        + "	PMI.UPDATE_TIME AS updateTime,PMI.PUSH_TYPE AS pushType,PMI.SYS_ID as sysId,PRA.APP_ID appId,#{userId} userId,"
		        + "IF (ISNULL(PMR.IS_READ),'N',PMR.IS_READ) isRead,PMR.PUSH_TIME pushTime ");
		sql.append(" FROM " + DBConstOfPush.TN_PUSH_MESSAGE_INFO + " PMI ");
		sql.append(" LEFT JOIN " + DBConstOfPush.TN_PUSH_R_APP + " PRA ON PMI.MESSAGE_ID = PRA.MESSAGE_ID");
		sql.append(" LEFT JOIN " + DBConstOfPush.TN_SYSTEM_INFO + " S ON PMI.SYS_ID = S.SYSTEM_ID");
		sql.append(" LEFT JOIN " + DBConstOfPush.TN_APP_INFO + " T ON PRA.APP_ID = T.APP_ID");
		sql.append(" LEFT JOIN " + DBConstOfPush.TN_PUSH_MESSAGE_READ
		        + " PMR ON PMR.MESSAGE_ID = PMI.MESSAGE_ID AND PMR.USER_ID = #{userId} ");
		sql.append(" LEFT JOIN " + DBConstOfPush.TN_USER_INFO + " U ON U.ID = #{userId} ");
		sql.append(" WHERE (PMR.DEL_FLAG IS NULL OR PMR.DEL_FLAG != 1) AND (PMI.STATE = '4' ");
		sql.append(" AND PMI.PUSH_TYPE = '1' OR (PMI.PUSH_TYPE = '3' AND EXISTS (SELECT * FROM "
		        + DBConstOfPush.TN_USER_INFO + " WHERE ACC_NAME LIKE 'YK%' AND ID = #{userId} )) )");
		sql.append(" AND PMI.CREATE_TIME >= U.INS_TSTMP AND CONCAT(PMI.END_DATE,' 23:59:59') >= NOW() ");
		if (parameter.containsKey("systemCode")) {
			sql.append(" AND S.SYSTEM_CODE = #{systemCode}  ");
		}
		if (parameter.containsKey("appCode")) {
			sql.append(" AND T.APP_CODE= #{appCode} ");
		}
		if (parameter.containsKey("pushTime")) {
			sql.append(" AND PMR.PUSH_TIME >= #{pushTime} ");
		}
		if (parameter.containsKey("isRead") && parameter.get("isRead") != null) {
			Boolean isRead = (Boolean) parameter.get("isRead");
			if (isRead.booleanValue()) {// 已读
				sql.append(" AND PMR.IS_READ = 'Y'  ");
			} else {// 未读
				sql.append(" AND (PMI.MESSAGE_ID NOT IN (SELECT MESSAGE_ID FROM "
				        + DBConstOfPush.TN_PUSH_MESSAGE_READ + " WHERE USER_ID = #{userId}) OR PMR.IS_READ = 'N' ) ");
			}

		}
		if (parameter.containsKey("isPush") && parameter.get("isPush") != null) {
			Boolean isPush = (Boolean) parameter.get("isPush");
			if (isPush.booleanValue()) {// 已获取
				sql.append(" AND PMI.MESSAGE_ID IN (SELECT MESSAGE_ID FROM " + DBConstOfPush.TN_PUSH_MESSAGE_READ
				        + " WHERE USER_ID = #{userId})  ");
			} else {// 未获取
				sql.append(" AND PMI.MESSAGE_ID NOT IN (SELECT MESSAGE_ID FROM "
				        + DBConstOfPush.TN_PUSH_MESSAGE_READ + " WHERE USER_ID = #{userId}) ");
			}
		}
		sql.append(" order by pushTime desc,messageId desc ");
		return sql.toString();

	}

	/**
	 * @return String
	 */
	public static String findPushMessageById(final Map<String, String> parameters) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ").append("PMI.MESSAGE_ID,").append("PMI.MESSAGE_TITLE,").append("PMI.PUSH_TYPE,")
		        .append("PMI.MESSAGE_INTRODUCTION,").append("PMI.PUSH_DATE,").append("PMI.END_DATE,")
		        .append("PMI.STATE,").append("PMI.TYPE,").append("PC.MESSAGE_CONTENT,").append("PMI.CREATE_PERSON ,")
		        .append("PMI.CREATE_TIME,").append("PMI.UPDATE_PERSON,").append("PMI.UPDATE_TIME ,")
		        .append("PMI.DEL_FLAG,").append("PMC.READ_COUNT,").append("PMC.PUSH_COUNT,").append("PMC.TOTAL_COUNT,")
		        .append("PMI.SYS_ID,").append("BS.SYS_NAME,").append("PMI.TYPE,").append("PMW.EDITOR_ID,")
		        .append("PMW.INFONAME ");

		sql.append(" FROM ").append("T_PUSH_MESSAGE_INFO").append(" PMI ");
		sql.append(" LEFT JOIN ").append("T_PUSH_MESSAGE_CONTENT_INFO").append(" PC ON PC.MESSAGE_ID=PMI.MESSAGE_ID ");
		sql.append(" LEFT JOIN ").append("T_PUSH_MESSAGE_COUNT").append(" PMC ON PMC.MESSAGE_ID=PMI.MESSAGE_ID ");
		sql.append(" LEFT JOIN ").append("t_business_system").append(" BS ON BS.SYS_ID=PMI.SYS_ID ");
		sql.append(" LEFT JOIN ").append(" T_PUSH_MESSAGE_WEBEDITOR ")
		        .append(" PMW ON PMW.MESSAGE_ID=PMI.MESSAGE_ID  ");
		if (parameters.containsKey("messageId")) {
			sql.append(" WHERE PMI.MESSAGE_ID=#{messageId}");
		}

		return sql.toString();

	}

	/**
	 * 
	 * @return String
	 */

	public static String findCustomerGroupByMsgId(final Map<String, String> parameters) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ").append("PCG.MESSAGE_ID,PCG.CUSTOMER_GROUP_ID,CG.GROUP_NAME AS CUSTOMER_GROUP_NAME")
		        .append(" FROM ").append("T_PUSH_R_CUSTOMER_GROUP").append(" PCG ");
		sql.append(" LEFT JOIN ").append("T_CDA_GROUP").append(" CG ON CG.ID=PCG.CUSTOMER_GROUP_ID ");
		if (parameters.containsKey("messageId")) {
			sql.append(" WHERE PCG.MESSAGE_ID=#{messageId}");
		}
		return sql.toString();

	}

	/**
	 * 
	 * @return String
	 */
	public static String findGoodsIdsByMessageId(final Map<String, String> parameters) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT g.ID GOODS_ID, g.GOODS_NAME GOODS_NAME FROM t_push_message_goods m "
		        + "LEFT JOIN t_tdc_goods_info_main g ON m.GOODS_ID = g.ID ");
		if (parameters.containsKey("messageId")) {
			sql.append(" WHERE m.MESSAGE_ID = #{messageId}");
		}
		return sql.toString();
	}

	/**
	 * 保存商品推送
	 * 
	 * @param parameters
	 * @return
	 */
	public static String insertPushMessageGoods(final Map<String, Object> parameters) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" INSERT INTO ");
		sql.append(DBConstOfPush.TN_PUSH_MESSAGE_GOODS + " (MESSAGE_ID,GOODS_ID)");
		if (parameters.size() > 0) {
			sql.append(" VALUES");
			@SuppressWarnings("unchecked")
            List<Long> ids = (List<Long>) parameters.get("pushGoodsId");
			for (int i = 0; i < ids.size(); i++) {
				sql.append("(#{messageId},#{pushGoodsId[" + i + "]}),");
			}
			sql.deleteCharAt(sql.length() - 1);
		}
		return sql.toString();
	}

	/**
	 * 保存指定用户
	 * 
	 * @param parameters
	 * @return
	 */
	public static String insertUser(final Map<String, Object> parameters) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" INSERT INTO ");
		sql.append(DBConstOfPush.TN_PUSH_R_CUSTOMER_USER + " (MESSAGE_ID,SYS_ID,USER_ID)");
		if (parameters.size() > 0) {
			sql.append(" VALUES");
			@SuppressWarnings("unchecked")
            List<Long> ids = (List<Long>) parameters.get("usersIds");
			for (int i = 0; i < ids.size(); i++) {
				sql.append("(#{messageId},#{sysId},#{usersIds[" + i + "]}),");
			}
			sql.deleteCharAt(sql.length() - 1);
		}
		return sql.toString();
	}

	/**
	 * 保存用户群
	 * 
	 * @param parameters
	 * @return
	 */
	public static String insertUserGroups(final Map<String, Object> parameters) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" INSERT INTO ");
		sql.append(DBConstOfPush.TN_PUSH_R_CUSTOMER_GROUP + " (MESSAGE_ID,SYS_ID,CUSTOMER_GROUP_ID)");
		if (parameters.size() > 0) {
			sql.append(" VALUES");
			@SuppressWarnings("unchecked")
            List<Long> ids = (List<Long>) parameters.get("customerGroupIds");
			for (int i = 0; i < ids.size(); i++) {
				sql.append("(#{messageId},#{sysId},#{customerGroupIds[" + i + "]}),");
			}
			sql.deleteCharAt(sql.length() - 1);
		}
		return sql.toString();
	}

	/**
	 * 保存APP
	 * 
	 * @param parameters
	 * @return
	 */
	public static String insertAppInfo(final Map<String, Object> parameters) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" INSERT INTO ");
		sql.append(DBConstOfPush.TN_PUSH_R_APP + " (MESSAGE_ID,SYS_ID,APP_ID)");
		if (parameters.size() > 0) {
			sql.append(" VALUES");
			@SuppressWarnings("unchecked")
            List<Long> appIds = (List<Long>) parameters.get("appIds");
			for (int i = 0; i < appIds.size(); i++) {
				sql.append("(#{messageId},#{sysId},#{appIds[" + i + "]}),");
			}
			sql.deleteCharAt(sql.length() - 1);
		}
		return sql.toString();
	}

	/**
	 * 指定用户、用户群阅读
	 * 
	 * @param parameter
	 * @return
	 */
	public static String readMessageReceive(final Map<String, Object> parameter) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" UPDATE " + DBConstOfPush.TN_PUSH_MESSAGE_RECEIVE);
		sql.append(" SET IS_READ = 'Y' , READ_TIME = now()  WHERE MESSAGE_ID = #{messageId} AND USER_ID = #{userId}");
		sql.append(" AND APP_ID = (SELECT APP_ID FROM " + DBConstOfPush.TN_APP_INFO
		        + " WHERE APP_CODE = #{appCode} )");
		sql.append(" AND SYS_ID = (SELECT SYSTEM_ID FROM " + DBConstOfPush.TN_SYSTEM_INFO + " WHERE SYSTEM_CODE = #{sysCode} )");
		return sql.toString();
	}

	public static String insertMessageRead(final Map<String, Object> param) {
		StringBuffer sql = new StringBuffer(128);
		List<PushInfoBean> list = (List<PushInfoBean>) param.get("list");
		sql.append("INSERT INTO " + DBConstOfPush.TN_PUSH_MESSAGE_READ);
		sql.append("(MESSAGE_ID,SYS_ID,APP_ID,USER_ID,IS_READ,READ_TIME,PUSH_TIME,DEL_FLAG) VALUES");
		for (int i = 0; i < list.size(); i++) {
			sql.append("(#{list[" + i + "].messageId},#{list[" + i + "].sysId},#{list[" + i + "].appId},#{list[" + i
			        + "].userId},");
			if (StringUtil.isNotEmpty(list.get(i).getIsRead())) {
				sql.append("#{list[" + i + "].isRead},");
			} else {
				sql.append("'N',");
			}
			if (StringUtil.isNotEmpty(list.get(i).getReadTime())) {
				sql.append("#{list[" + i + "].readTime},");
			} else {
				sql.append("now(),");
			}
			if (StringUtil.isNotEmpty(list.get(i).getPushTime())) {
				sql.append("#{list[" + i + "].pushTime},");
			} else {
				sql.append("now(),");
			}
			if (StringUtil.isNotEmpty(list.get(i).getDelFlag())) {
				sql.append("#{list[" + i + "].delFlag},");
			} else {
				sql.append("'N',");
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append("),");
		}
		sql.deleteCharAt(sql.length() - 1);
		return sql.toString();
	}

	@SuppressWarnings("unchecked")
	public static String updateGetMessageReceive(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" UPDATE " + DBConstOfPush.TN_PUSH_MESSAGE_RECEIVE);
		sql.append(" SET IS_PUSH = 'Y' WHERE ");
		List<PushInfoBean> list = (List<PushInfoBean>) param.get("list");
		sql.append(" USER_ID = #{list[0].userId}");
		sql.append(" AND MESSAGE_ID IN ( ");
		for (int i = 0; i < list.size(); i++) {
			sql.append(" #{list[" + i + "].messageId} ,");

		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		return sql.toString();
	}

	public static String updateMessageRead(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" UPDATE " + DBConstOfPush.TN_PUSH_MESSAGE_READ);
		sql.append(" SET IS_READ = 'Y',READ_TIME= now()  WHERE MESSAGE_ID = #{messageId} AND USER_ID = #{userId}");
		if (param.containsKey("appId")) {
			sql.append(" AND APP_ID = #{appId}");
		}
		if (param.containsKey("appCode")) {
			sql.append(" AND APP_ID = (SELECT APP_ID FROM " + DBConstOfPush.TN_APP_INFO
			        + " WHERE APP_CODE = #{appCode})");
		}
		if (param.containsKey("sysId")) {
			sql.append(" AND SYS_ID = #{sysId}");
		}
		if (param.containsKey("sysCode")) {
			sql.append(" AND SYS_ID = (SELECT SYSTEM_ID FROM " + DBConstOfPush.TN_SYSTEM_INFO + " WHERE SYSTEM_CODE = #{sysCode} )");
		}

		return sql.toString();
	}

	@SuppressWarnings("unchecked")
	public static String delMessageReceiveByUserId(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" UPDATE " + DBConstOfPush.TN_PUSH_MESSAGE_RECEIVE);
		sql.append(" SET DEL_FLAG = 'Y' WHERE USER_ID = #{userId}");
		List<Long> list = (List<Long>) param.get("list");
		sql.append(" AND MESSAGE_ID IN ( ");
		for (int i = 0; i < list.size(); i++) {
			sql.append(" #{list[" + i + "]} ,");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		return sql.toString();
	}

	@SuppressWarnings("unchecked")
	public static String delMessageReadByUserId(Map<String, Object> param) {
		StringBuffer sql = new StringBuffer(128);
		sql.append(" UPDATE " + DBConstOfPush.TN_PUSH_MESSAGE_READ);
		sql.append(" SET DEL_FLAG = 'Y' WHERE USER_ID = #{userId}");
		List<Long> list = (List<Long>) param.get("list");
		sql.append(" AND MESSAGE_ID IN ( ");
		for (int i = 0; i < list.size(); i++) {
			sql.append(" #{list[" + i + "]} ,");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		return sql.toString();
	}
}
