package cn.faury.fwmf.module.service.user.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class PushRUserSQLProvider {

	/**
	 * 日志记录器
	 */
	private static Logger log = LoggerFactory.getLogger(PushRUserSQLProvider.class);

	@SuppressWarnings({ "unchecked" })
	public static String getUserInfoByMessageId(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT U.USER_ID userId,U.LOGIN_NAME loginName,U.USER_NAME userName,U.ORIGIN_OS_ID originOsId FROM "
		        + DBConstOfUserRole.TN_USER_INFO + " U ");
		sql.append(" WHERE U.USER_ID IN (");
		sql.append(" select USER_ID from " + DBConstOfUserRole.TN_PUSH_R_CUSTOMER_USER);
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

		sql.append(" ORDER BY originOsId DESC");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

}
