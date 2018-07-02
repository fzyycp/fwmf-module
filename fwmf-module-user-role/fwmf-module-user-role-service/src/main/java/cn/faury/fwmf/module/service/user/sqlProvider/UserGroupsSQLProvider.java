package cn.faury.fwmf.module.service.user.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.user.bean.UserGroupsInfoBean;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class UserGroupsSQLProvider {

    /**
     * 日志记录器
     */
    private static Logger log = LoggerFactory.getLogger(UserGroupsSQLProvider.class);

    /**
     * 根据groupId获取用户群信息
     */
    public static String getGroupsInfoById(Map<String, Object> parameter) {
        // 参数校验
        log.debug("parameter ==> " + parameter.toString());

        if (parameter == null || parameter.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }

        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT G.ID groupId,G.GROUP_NAME groupName,G.NUM ,G.ORIGIN_OS_ID systemId " +
                ",s.SYSTEM_NAME systemName FROM "
                + DBConstOfUserRole.TN_CDA_GROUP + " G ");
        sql.append(" , " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ");

        sql.append(" WHERE ");
        sql.append(" G.ORIGIN_OS_ID=S.SYSTEM_ID AND ");
        sql.append(" G.ID = #{groupId,jdbcType=BIGINT} ");
        sql.append(" AND G.ORIGIN_OS_ID=(");
        sql.append(" SELECT SYSTEM_ID FROM " + DBConstOfUserRole.TN_SYSTEM_INFO);
        sql.append(" WHERE ");
        if (parameter.containsKey("systemId")) {
            sql.append(" SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append(" SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameter.containsKey("isSystemAvailable") && parameter.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameter.get("isSystemAvailable");
            sql.append("                 AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'");
            sql.append("' ");
        }
        sql.append(" )");

        sql.append(" ORDER BY G.ORIGIN_OS_ID,G.ID DESC");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 根据用户群Id获取关联用户
     *
     * @param parameter 参数 groupId
     * @return 关联用户列表
     */
    public static String getGroupUsers(Map<String, Object> parameter) {
        // 参数校验
        log.debug("parameter ==> " + parameter.toString());

        if (parameter == null || parameter.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT U.ID userId,U.ACC_NAME loginName,U.USER_NAME userName" +
                ",S.`SYSTEM_NAME` originOsName FROM "
                + DBConstOfUserRole.TN_USER_INFO + " U ");
        sql.append(" JOIN " + DBConstOfUserRole.TN_CDA_GROUP_USER + " GU ON U.ID=GU.USER_ID ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ON U.ORIGIN_OS_ID = S.SYSTEM_ID");
        sql.append(" WHERE ");
        sql.append(" GU.GROUP_ID = #{groupId,jdbcType=BIGINT} ");

        sql.append(" ORDER BY U.ORIGIN_OS_ID,U.ID DESC");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 根据查询条件查询用户群信息列表
     */
    public static String queryGroupsInfo(Map<String, Object> parameter) {
        // 参数校验
        log.debug("parameter ==> " + parameter.toString());

        if (parameter == null || parameter.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT  G.ID groupId,G.GROUP_NAME groupName,G.NUM ,G.ORIGIN_OS_ID systemId " +
                ",s.SYSTEM_NAME systemName FROM "
                + DBConstOfUserRole.TN_CDA_GROUP + " G ");
        sql.append(" , " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ");
        sql.append(" WHERE ");
        sql.append(" G.ORIGIN_OS_ID=S.SYSTEM_ID ");

        if (parameter.get("groupId") != null) {
            sql.append(" AND G.ID = #{groupId,jdbcType=BIGINT} ");
        }

        if (parameter.get("groupName") != null) {
            sql.append(" AND G.GROUP_NAME LIKE CONCAT('%',#{groupName},'%') ");
        }

        sql.append(" AND G.ORIGIN_OS_ID=(");
        sql.append(" SELECT SYSTEM_ID FROM " + DBConstOfUserRole.TN_SYSTEM_INFO);
        sql.append(" WHERE ");
        if (parameter.containsKey("systemId")) {
            sql.append(" SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append(" SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameter.containsKey("isSystemAvailable") && parameter.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameter.get("isSystemAvailable");
            sql.append("                 AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'");
            sql.append("' ");
        }
        sql.append(" )");

        sql.append(" ORDER BY G.ORIGIN_OS_ID,G.ID DESC");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 查询未关联用户群的用户信息列表
     *
     * @param parameter 参数
     * @return 未关联用户信息列表
     */
    public static String queryUsersURGroup(Map<String, Object> parameter) {
        // 参数校验
        log.debug("parameter ==> " + parameter.toString());

        if (parameter == null || parameter.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT U.ID userId,U.ACC_NAME loginName,U.USER_NAME userName" +
                ",S.SYSTEM_ID originOsId ,S.SYSTEM_NAME originOsName FROM "
                + DBConstOfUserRole.TN_USER_INFO + " U ");
        sql.append(" , " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ");
        sql.append(" WHERE ");
        sql.append(" U.ORIGIN_OS_ID=S.SYSTEM_ID ");
        if (parameter.containsKey("loginName")) {
            sql.append(" AND U.ACC_NAME LIKE CONCAT('%',#{loginName},'%')");
        }
        sql.append(" AND ( U.ID IN ( ");
        sql.append(" SELECT US.USER_ID FROM " + DBConstOfUserRole.TN_USER_R_SYSTEM + " US WHERE US.SYSTEM_ID =(");
        sql.append(" SELECT TS.SYSTEM_ID FROM " + DBConstOfUserRole.TN_SYSTEM_INFO + " TS ");
        sql.append(" WHERE ");
        if (parameter.containsKey("systemId")) {
            sql.append(" TS.SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append(" TS.SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        if (parameter.containsKey("isSystemAvailable") && parameter.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameter.get("isSystemAvailable");
            sql.append("                 AND TS.IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'");
            sql.append("' ");
        }
        if (parameter.get("groupId") != null) {
            sql.append(" AND TS.SYSTEM_ID IN ( ");
            sql.append(" SELECT G.ORIGIN_OS_ID FROM " + DBConstOfUserRole.TN_CDA_GROUP + " G ");
            sql.append(" WHERE  G.ID = #{groupId,jdbcType=BIGINT} ");
            sql.append(" ) ");
        }

        sql.append(" ) ");
        sql.append(" ) OR U.RESV_FLG = 3 )");
        if (parameter.get("groupId") != null) {
            sql.append(" AND U.ID NOT IN ( ");
            sql.append(" SELECT GU.USER_ID FROM " + DBConstOfUserRole.TN_CDA_GROUP_USER + " GU ");
            sql.append(" WHERE GU.GROUP_ID = #{groupId,jdbcType=BIGINT} ");
            sql.append(" )");
        }
        sql.append(" ORDER BY U.ORIGIN_OS_ID,U.ID DESC");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 插入多条用户群与用户关联信息
     *
     * @param parameter 参数
     * @return 受影响行数
     */
    public static String insertUserGroupsInfo(Map<String, Object> parameter) {
        // 参数校验
        log.debug("Parameters ==> " + parameter.toString());
        if (parameter == null || parameter.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameter.containsKey("userInfos")) {
            log.debug("SQL ==> null");
            return null;
        }
        StringBuffer sql = new StringBuffer(128);
        sql.append("INSERT INTO " + DBConstOfUserRole.TN_CDA_GROUP_USER + " (`GROUP_ID`, `USER_ID`) VALUES");
        @SuppressWarnings("unchecked")
        List<UserInfoBean> users = (List<UserInfoBean>) parameter.get("userInfos");
        if (users != null) {
            if (users.size() > 0) {
                for (int i = 0; i < users.size(); i++) {
                    sql.append("(#{groupId,jdbcType=BIGINT},  #{userInfos[" + i + "].userId,jdbcType=BIGINT}),");
                }
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 删除用户群与用户信息关联信息
     *
     * @param parameter 参数
     * @return 受影响行数
     */
    public static String deleteUserAndGroupRInfo(Map<String, Object> parameter) {
        // 参数校验
        log.debug("Parameters ==> " + parameter.toString());
        if (parameter == null || parameter.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameter.containsKey("userIds")) {
            log.debug("SQL ==> null");
            return null;
        }
        StringBuffer sql = new StringBuffer(128);
        sql.append("DELETE FROM " + DBConstOfUserRole.TN_CDA_GROUP_USER);
        @SuppressWarnings("unchecked")
        List<Long> users = (List<Long>) parameter.get("userIds");
        if (users != null) {
            if (users.size() > 0) {
                sql.append(" WHERE USER_ID IN ( ");
                for (int i = 0; i < users.size(); i++) {
                    sql.append("#{userIds[" + i + "],jdbcType=BIGINT},");
                }
                sql.deleteCharAt(sql.length() - 1);
                sql.append(" ) ");
                sql.append(" AND GROUP_ID = #{groupId,jdbcType=BIGINT}");
            }
        }
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 根据用户群信息查询用户群列表
     */
    public static String queryGroupsInfoByUser(Map<String, Object> parameter) {
        // 参数校验
        log.debug("parameter ==> " + parameter.toString());

        if (parameter == null || parameter.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT  G.ID groupId,G.GROUP_NAME groupName,G.NUM ,G.ORIGIN_OS_ID systemId " +
                ",s.SYSTEM_NAME systemName FROM "
                + DBConstOfUserRole.TN_CDA_GROUP + " G ");
        sql.append(" , " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ");
        sql.append(" WHERE ");
        sql.append(" G.ORIGIN_OS_ID=S.SYSTEM_ID ");
        sql.append(" AND G.DEL_FLAG='N' ");
        if (parameter.get("groupId") != null) {
            sql.append(" AND G.ID = #{groupId,jdbcType=BIGINT} ");
        }

        if (parameter.get("groupName") != null) {
            sql.append(" AND G.GROUP_NAME LIKE CONCAT('%',#{groupName},'%') ");
        }

        sql.append(" AND G.ORIGIN_OS_ID IN (");
        sql.append(" SELECT SYSTEM_ID FROM " + DBConstOfUserRole.TN_SYSTEM_INFO);
        // 判断不传系统信息
        if (parameter.containsKey("systemId") || parameter.containsKey("systemCode")) {
            sql.append(" WHERE ");
            if (parameter.containsKey("systemId")) {
                sql.append(" SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
            } else {
                sql.append(" SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
            }
            // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
            // Boolean.FALSE:仅不可用； null:都包含】
            if (parameter.containsKey("isSystemAvailable") && parameter.get("isSystemAvailable") != null) {
                Boolean isAvailable = (Boolean) parameter.get("isSystemAvailable");
                sql.append("                 AND IS_AVAILABLE = '");
                sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'");
                sql.append("' ");
            }
        } else {

            // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
            // Boolean.FALSE:仅不可用； null:都包含】
            if (parameter.containsKey("isSystemAvailable") && parameter.get("isSystemAvailable") != null) {
                Boolean isAvailable = (Boolean) parameter.get("isSystemAvailable");
                sql.append("                 WHERE IS_AVAILABLE = '");
                sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'");
                sql.append("' ");
            }
        }

        sql.append(" )");
        if (parameter.get("userId") != null || parameter.get("loginName") != null) {
            sql.append(" AND G.ID IN ( ");
            sql.append(" SELECT GU.GROUP_ID FROM " + DBConstOfUserRole.TN_CDA_GROUP_USER + " GU ");
            if (parameter.get("userId") != "" || parameter.get("loginName") != "") {
                sql.append(" WHERE GU.USER_ID IN ( ");

                sql.append(" SELECT U.ID FROM " + DBConstOfUserRole.TN_USER_INFO + " U WHERE ");
                if (parameter.containsKey("userId")) {
                    sql.append(" ID = #{userId,jdbcType=BIGINT} ");
                } else {
                    sql.append(" ACC_NAME LIKE CONCAT('%',#{loginName},'%') ");
                }
                sql.append(" ) ");
            }
            sql.append(" ) ");
        }

        sql.append(" ORDER BY G.ORIGIN_OS_ID,G.ID DESC");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    public static String updateUserGroupsInfo(UserGroupsInfoBean userGroupsInfo) {
        // 参数校验
        log.debug("userGroupsInfo ==> " + userGroupsInfo.toString());
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append(" UPDATE " + DBConstOfUserRole.TN_CDA_GROUP);
        sql.append(" SET ");
        if (userGroupsInfo.getNum() != null && userGroupsInfo.getNum() != 0) {
            sql.append(" `NUM`= #{num} ,");
        }
        if (StringUtil.isNotEmpty(userGroupsInfo.getGroupName())) {
            sql.append(" `GROUP_NAME`= #{groupName} ,");
        }
        if (userGroupsInfo.getUpdatePerson() != null && !userGroupsInfo.getUpdatePerson().equals(0L)) {
            sql.append(" `UPDATE_PERSON`= #{updatePerson} ,");
        }

        sql.append(" `UPDATE_TIME`= now()  ");
        sql.append(" WHERE ID = #{groupId} ");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }
}
