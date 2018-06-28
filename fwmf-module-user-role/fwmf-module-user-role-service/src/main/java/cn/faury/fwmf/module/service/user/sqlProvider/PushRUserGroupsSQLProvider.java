package cn.faury.fwmf.module.service.user.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class PushRUserGroupsSQLProvider {

	/**
	 * 日志记录器
	 */
	private static Logger log = LoggerFactory.getLogger(PushRUserGroupsSQLProvider.class);

	@SuppressWarnings("unchecked")
	public static String getUserGroupsInfoByMessageId(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT G.ID groupId,G.GROUP_NAME groupName,G.NUM ,G.ORIGIN_OS_ID systemId FROM "
		        + DBConstOfUserRole.TN_CDA_GROUP + " G ");
		sql.append(" WHERE G.ID  IN (");
		sql.append(" select CUSTOMER_GROUP_ID from " + DBConstOfUserRole.TN_PUSH_R_CUSTOMER_GROUP);
		sql.append(" where MESSAGE_ID in (");
		List<Long> messageIds = (List<Long>) parameter.get("messageIds");
		if (messageIds != null) {
			if (messageIds.size() > 0) {
				for (int i = 0; i < messageIds.size(); i++) {
					sql.append(" #{messageIds[" + i + "]},");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(" ))");

		sql.append(" ORDER BY G.ORIGIN_OS_ID,G.ID DESC");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

}
