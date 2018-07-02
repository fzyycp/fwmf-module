package cn.faury.fwmf.module.service.user.sqlProvider;


import cn.faury.fwmf.module.api.user.bean.DiscusRUserGroupsBean;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class DiscusRUserGroupsSQLProvider {

	/**
	 * 日志记录器
	 */
	private static Logger log = LoggerFactory.getLogger(DiscusRUserGroupsSQLProvider.class);

	public static String queryDiscusRUserGroupsByDiscusId(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT G.ID groupId,G.GROUP_NAME groupName,G.NUM ,G.ORIGIN_OS_ID systemId FROM "
		        + DBConstOfUserRole.TN_CDA_GROUP + " G ");
		sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_DISCOUNT_DISCUS_R_OBJECT + " D ON D.OBJECT_ID = G.ID");
		sql.append(" WHERE D.DISCUS_ID = #{discusId} AND OBJECT_TYPE = '3'");

		sql.append(" ORDER BY G.ORIGIN_OS_ID,G.ID DESC");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	public static String queryDiscusUnRUserGroupsByDiscusId(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT G.ID groupId,G.GROUP_NAME groupName,G.NUM ,G.ORIGIN_OS_ID systemId FROM "
		        + DBConstOfUserRole.TN_CDA_GROUP + " G ");
		sql.append(" WHERE G.DEL_FLAG = 'N' AND G.ORIGIN_OS_ID = #{systemId} ");
		sql.append(" AND G.ID NOT IN (SELECT OBJECT_ID FROM " + DBConstOfUserRole.TN_DISCOUNT_DISCUS_R_OBJECT);
		sql.append(" WHERE DISCUS_ID = #{discusId} )");
		if (parameter.containsKey("userGroupName")) {
			sql.append(" AND G.GROUP_NAME LIKE CONCAT('%', #{userGroupName},'%')");
		}
		sql.append(" ORDER BY G.ID DESC");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	@SuppressWarnings("unchecked")
	public static String insert(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("INSERT INTO " + DBConstOfUserRole.TN_DISCOUNT_DISCUS_R_OBJECT);
		sql.append(" (DISCUS_ID,OBJECT_TYPE,OBJECT_ID)");
		sql.append(" VALUES ");
		List<DiscusRUserGroupsBean> list = (List<DiscusRUserGroupsBean>) parameter.get("list");
		if (list != null) {
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					sql.append(" (#{list[" + i + "].discusId},'3',#{list[" + i + "].groupId}),");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	@SuppressWarnings("unchecked")
	public static String del(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("delete FROM  " + DBConstOfUserRole.TN_DISCOUNT_DISCUS_R_OBJECT);
		sql.append(" WHERE OBJECT_TYPE = '3' ");
		if (parameter.containsKey("ids")) {
			sql.append(" AND ID in (");
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
		}

		if (parameter.containsKey("discusIds")) {
			sql.append(" AND DISCUS_ID in (");
			List<Long> discusIds = (List<Long>) parameter.get("discusIds");
			if (discusIds != null) {
				if (discusIds.size() > 0) {
					for (int i = 0; i < discusIds.size(); i++) {
						sql.append(" #{discusIds[" + i + "]},");
					}
				}
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" )");
		}
		if (parameter.containsKey("discusId") && parameter.containsKey("groupIds")) {
			sql.append(" AND DISCUS_ID = #{discusId}");
			sql.append(" AND OBJECT_ID in (");
			List<Long> groupIds = (List<Long>) parameter.get("groupIds");
			if (groupIds != null) {
				if (groupIds.size() > 0) {
					for (int i = 0; i < groupIds.size(); i++) {
						sql.append(" #{groupIds[" + i + "]},");
					}
				}
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" )");
		}

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

}
