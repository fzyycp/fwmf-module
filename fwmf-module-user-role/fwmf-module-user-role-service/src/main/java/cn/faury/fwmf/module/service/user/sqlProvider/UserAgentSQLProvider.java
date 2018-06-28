package cn.faury.fwmf.module.service.user.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class UserAgentSQLProvider {

    /**
     * 日志记录器
     */
    private static Logger log = LoggerFactory.getLogger(UserAgentSQLProvider.class);

    /**
     * 查询代理人信息列表
     * <p>
     * <pre>
     * 【可选】id：唯一主键
     * 【可选】userId：被代理人ID
     * 【可选】agentUserId：代理人ID
     * 【可选】osId：业务系统ID或者APP ID
     * 【可选】osType：系统类型 【0:业务系统，1:手机APP】
     * 【可选】isAvailable：是否可用【Y：是，N：否】
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String queryUserAgentInfo(Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        /*
		 * if (parameters == null || parameters.size() <= 0) {
		 * log.debug("SQL ==> null"); return null; }
		 */
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        if (!parameters.containsKey("osType")) { // osType:不选
            sql.append("SELECT A.ID,A.USER_ID userId,UA.ACC_NAME loginName,UA.USER_NAME userName,A.AGENT_USER_ID agentUserId,UB.ACC_NAME agentLoginName,UA.USER_NAME agentUserName,A.OS_TYPE osType,A.OS_ID osId,AF.APP_NAME osName,AF.APP_CODE osCode,A.IS_AVAILABLE isAvailable ");
            sql.append(" FROM " + DBConstOfUserRole.TN_USER_AGENT + " A ");
            sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UA ON A.USER_ID = UA.ID ");
            sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UB ON A.AGENT_USER_ID = UB.ID ");
            sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_APP_INFO + " AF ON A.OS_ID = AF.APP_ID ");
            if (parameters != null && parameters.size() > 0) {
                sql.append(" WHERE ");
                sql.append(" A.OS_TYPE = '1'");
                if (parameters.containsKey("id")) {
                    sql.append(" AND A.id = #{id}");
                }
                if (parameters.containsKey("userId")) {
                    sql.append(" AND A.USER_ID = #{userId}");
                }
                if (parameters.containsKey("agentUserId")) {
                    sql.append(" AND A.AGENT_USER_ID = #{agentUserId}");
                }
                if (parameters.containsKey("isAvailable")) {
                    sql.append(" AND A.IS_AVAILABLE = #{isAvailable}");
                }
                if (parameters.containsKey("osId")) {
                    sql.append(" AND A.OS_ID = #{osId}");
                }
            }
            sql.append(" UNION ");
            sql.append("SELECT A.ID,A.USER_ID userId,UA.ACC_NAME loginName,UA.USER_NAME userName,A.AGENT_USER_ID agentUserId,UB.ACC_NAME agentLoginName,UA.USER_NAME agentUserName,A.OS_TYPE osType,A.OS_ID osId,S.NAME osName,S.CODE osCode,A.IS_AVAILABLE isAvailable ");
            sql.append(" FROM " + DBConstOfUserRole.TN_USER_AGENT + " A ");
            sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UA ON A.USER_ID = UA.ID ");
            sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UB ON A.AGENT_USER_ID = UB.ID ");
            sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ON A.OS_ID = S.SYSTEM_ID ");
            if (parameters != null && parameters.size() > 0) {
                sql.append(" WHERE ");
                sql.append(" A.OS_TYPE = '0'");
                if (parameters.containsKey("id")) {
                    sql.append(" AND A.id = #{id}");
                }
                if (parameters.containsKey("userId")) {
                    sql.append(" AND A.USER_ID = #{userId}");
                }
                if (parameters.containsKey("agentUserId")) {
                    sql.append(" AND A.AGENT_USER_ID = #{agentUserId}");
                }
                if (parameters.containsKey("isAvailable")) {
                    sql.append(" AND A.IS_AVAILABLE = #{isAvailable}");
                }
                if (parameters.containsKey("osId")) {
                    sql.append(" AND A.OS_ID = #{osId}");
                }
            }

        } else if (parameters.containsKey("osType")) {
            String osType = (String) parameters.get("osType");
            if (osType.equals("1")) {// osType:1 app
                sql.append("SELECT A.ID,A.USER_ID userId,UA.ACC_NAME loginName,UA.USER_NAME userName,A.AGENT_USER_ID agentUserId,UB.ACC_NAME agentLoginName,UA.USER_NAME agentUserName,A.OS_TYPE osType,A.OS_ID osId,AF.APP_NAME osName,AF.APP_CODE osCode,A.IS_AVAILABLE isAvailable ");
                sql.append(" FROM " + DBConstOfUserRole.TN_USER_AGENT + " A ");
                sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UA ON A.USER_ID = UA.ID ");
                sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UB ON A.AGENT_USER_ID = UB.ID ");
                sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_APP_INFO + " AF ON A.OS_ID = AF.APP_ID ");
                sql.append(" WHERE ");
                sql.append(" A.OS_TYPE = '1'");
            } else { // osType: 0 业务系统
                sql.append("SELECT A.ID,A.USER_ID userId,UA.ACC_NAME loginName,UA.USER_NAME userName,A.AGENT_USER_ID agentUserId,UB.ACC_NAME agentLoginName,UA.USER_NAME agentUserName,A.OS_TYPE osType,A.OS_ID osId,S.NAME osName,S.CODE osCode,A.IS_AVAILABLE isAvailable ");
                sql.append(" FROM " + DBConstOfUserRole.TN_USER_AGENT + " A ");
                sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UA ON A.USER_ID = UA.ID ");
                sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UB ON A.AGENT_USER_ID = UB.ID ");
                sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ON A.OS_ID = S.SYSTEM_ID ");
                sql.append(" WHERE ");
                sql.append(" A.OS_TYPE = '0'");
            }

            if (parameters.containsKey("id")) {
                sql.append(" AND A.id = #{id}");
            }
            if (parameters.containsKey("userId")) {
                sql.append(" AND A.USER_ID = #{userId}");
            }
            if (parameters.containsKey("agentUserId")) {
                sql.append(" AND A.AGENT_USER_ID = #{agentUserId}");
            }
            if (parameters.containsKey("isAvailable")) {
                sql.append(" AND A.IS_AVAILABLE = #{isAvailable}");
            }
            if (parameters.containsKey("osId")) {
                sql.append(" AND A.OS_ID = #{osId}");
            }
        }
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 查询未代理当前用户的授权系统的当前系统用户
     */
    public static String queryUserUnAgentInfo(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        if (parameters == null || parameters.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("userId") && !parameters.containsKey("osId")) {
            log.debug("SQL ==> null");
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT U.ID userId,U.ACC_NAME loginName,U.USER_NAME userName,S.`SYSTEM_NAME` osName");
        sql.append(" FROM " + DBConstOfUserRole.TN_USER_INFO + " U , " + DBConstOfUserRole.TN_SYSTEM_INFO + " S");
        sql.append(" WHERE ");
        sql.append(" U.ORIGIN_OS_ID = S.SYSTEM_ID ");
        sql.append(" AND ");
        // Long userId = (Long) parameters.get("userId");
        sql.append(" U.ORIGIN_OS_ID = (SELECT ORIGIN_OS_ID FROM  " + DBConstOfUserRole.TN_USER_INFO
                + "  WHERE ID=#{userId})  ");
        sql.append(" AND ");
        // Long osId = (Long) parameters.get("osId");
        sql.append(" U.ID NOT IN (SELECT AGENT_USER_ID FROM " + DBConstOfUserRole.TN_USER_AGENT
                + " WHERE USER_ID=#{userId} AND OS_ID=#{osId}) AND U.ID != #{userId} ");
        if (parameters.containsKey("userName")) {
            sql.append(" AND U.ACC_NAME LIKE CONCAT('%',#{userName},'%')");
        }
        sql.append(" ORDER BY U.ID DESC");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 根据用户代理人关系表唯一主键ID查询代理人信息对象
     *
     * @param id 主键ID
     * @return
     */
    public static String getUserAgentInfoById(final Long id) {
        // 参数校验
        log.debug("id ==> " + id.toString());
        if (id == null || id == 0) {
            log.debug("SQL ==> null");
            return null;
        }

        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT A.ID id,A.USER_ID userId,UA.ACC_NAME loginName,UA.USER_NAME userName,A.AGENT_USER_ID agentUserId,UB.ACC_NAME agentLoginName,UA.USER_NAME agentUserName,A.OS_TYPE osType,A.OS_ID osId,AF.APP_NAME osName,AF.APP_CODE osCode,A.IS_AVAILABLE isAvailable ");
        sql.append(" FROM " + DBConstOfUserRole.TN_USER_AGENT + " A ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UA ON A.USER_ID = UA.ID ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UB ON A.AGENT_USER_ID = UB.ID ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_APP_INFO + " AF ON A.OS_ID = AF.APP_ID ");
        sql.append(" WHERE ");
        sql.append(" A.id = #{id} AND A.OS_TYPE='0'");
        sql.append(" UNION ");
        sql.append("SELECT A.ID id,A.USER_ID userId,UA.ACC_NAME loginName,UA.USER_NAME userName,A.AGENT_USER_ID agentUserId,UB.ACC_NAME agentLoginName,UA.USER_NAME agentUserName,A.OS_TYPE osType,A.OS_ID osId,S.NAME osName,S.CODE osCode,A.IS_AVAILABLE isAvailable  ");
        sql.append(" FROM " + DBConstOfUserRole.TN_USER_AGENT + " A ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UA ON A.USER_ID = UA.ID ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " UB ON A.AGENT_USER_ID = UB.ID ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ON A.OS_ID = S.SYSTEM_ID ");
        sql.append(" WHERE ");
        sql.append(" A.id = #{id} AND A.OS_TYPE='1'");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 三选一
     * <p>
     * <PRE>
     * 1.根据用户代理人关系表唯一主键ID删除代理人信息对象
     * 2.根据被代理人ID删除所有代理人关系
     * 3.根据被代理人ID、代理人ID删除代理人关系
     * </PRE>
     *
     * @param parameters
     * @return
     */
    public static String deleteUserAgentInfoById(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        if (parameters == null || parameters.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("ids") && !parameters.containsKey("userIds")
                && !parameters.containsKey("agentUserIds") && !parameters.containsKey("userId")) {
            log.debug("SQL ==> null");
            return null;
        }
        StringBuffer sql = new StringBuffer(128);
        sql.append("DELETE FROM " + DBConstOfUserRole.TN_USER_AGENT);
        sql.append(" WHERE ");
        if (parameters.containsKey("ids") && parameters.get("ids") != null) {
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
        if (parameters.containsKey("agentUserIds") && parameters.get("agentUserIds") != null
                && parameters.containsKey("userId") && parameters.get("userId") != null) {
            sql.append(" USER_ID = #{userId}");
            List<Long> agentUserIds = (List<Long>) parameters.get("agentUserIds");
            sql.append(" AND AGENT_USER_ID IN ( ");
            if (agentUserIds != null) {
                if (agentUserIds.size() > 0) {
                    for (int i = 0; i < agentUserIds.size(); i++) {
                        sql.append(" #{agentUserIds[" + i + "]},");
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
