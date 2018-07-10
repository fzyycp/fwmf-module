package cn.faury.fwmf.module.service.user.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ShopRUserSQLProvider {

    /**
     * 日志记录器
     */
    private static Logger log = LoggerFactory.getLogger(ShopRUserSQLProvider.class);

    public static String queryShopRUserInfoList(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());

        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append(" SELECT SU.SHOP_USER_ID shopUserId,U.LOGIN_NAME shopUserLoginName" +
                ",U.USER_NAME shopUserName,SU.SHOP_ID shopId,U.ORIGIN_OS_ID systemId" +
                ",S.`SYSTEM_NAME` systemName,SU.IS_SELF_CREATE isSelfCreate,SU.IS_ADMIN isAdmin");
        sql.append(" FROM " + DBConstOfUserRole.TN_SHOP_USER_INFO + " SU ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " U ON SU.SHOP_USER_ID = U.USER_ID");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ON U.ORIGIN_OS_ID = S.SYSTEM_ID");
        sql.append(" WHERE ");
        sql.append(" SU.SHOP_ID =#{shopId} ");
        if (parameters.containsKey("systemId")) {
            sql.append(" AND U.ORIGIN_OS_ID =#{systemId} ");
        }
        if (parameters.containsKey("shopUserLoginName")) {
            sql.append(" AND U.LOGIN_NAME LIKE CONCAT('%',#{shopUserLoginName},'%')");
        }
        if (parameters.containsKey("shopUserName")) {
            sql.append(" AND U.USER_NAME LIKE CONCAT('%',#{shopUserName},'%')");
        }

        sql.append(" ORDER BY U.LOGIN_NAME ");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();

    }

    public static String getShopRUserInfoById(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());

        StringBuffer sql = new StringBuffer(128);
        sql.append(" SELECT DISTINCT SU.SHOP_USER_ID shopUserId,U.LOGIN_NAME shopUserLoginName,U.USER_NAME shopUserName,SU.IS_SELF_CREATE isSelfCreate,U.ORIGIN_OS_ID systemId,SU.IS_ADMIN isAdmin");
        sql.append(" FROM " + DBConstOfUserRole.TN_SHOP_USER_INFO + " SU ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " U ON SU.SHOP_USER_ID = U.USER_ID");
        sql.append(" WHERE ");
        sql.append(" su.SHOP_USER_ID =#{shopUserId} ");
        sql.append(" AND SU.SHOP_ID =#{shopId} ");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();

    }

    @SuppressWarnings("unchecked")
    public static String getShopInfo(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());

        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append(" SELECT DISTINCT SU.SHOP_USER_ID shopUserId,U.LOGIN_NAME shopUserLoginName,U.USER_NAME shopUserName,U.ORIGIN_OS_ID systemId,"
                + "S.`SYSTEM_NAME` systemName,SU.IS_SELF_CREATE isSelfCreate,SU.IS_ADMIN isAdmin,PS.SHOP_ID shopId");
        sql.append(" FROM " + DBConstOfUserRole.TN_SHOP_USER_INFO + " SU ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_USER_INFO + " U ON SU.SHOP_USER_ID = U.USER_ID");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_SHOP_INFO + " PS ON PS.SHOP_ID = SU.SHOP_ID");
        sql.append(" LEFT JOIN  " + DBConstOfUserRole.TN_SHOP_R_SYSTEM + " RS ON PS.SHOP_ID = RS.SHOP_ID");
        sql.append(" LEFT JOIN  " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ON S.SYSTEM_ID = RS.SYSTEM_ID");
        if (parameters.size() > 0) {
            sql.append(" WHERE ");
            boolean flag = false;
            if (parameters.containsKey("systemCode")) {
                if (flag) {
                    sql.append(" AND ");
                }
                sql.append(" S.`SYSTEM_CODE` = #{systemCode} ");
                flag = true;
            }
            if (parameters.containsKey("shopId")) {
                if (flag) {
                    sql.append(" AND ");
                }
                sql.append(" PS.SHOP_ID = #{shopId}");
                flag = true;
            }
            if (parameters.containsKey("shopName")) {
                if (flag) {
                    sql.append(" AND ");
                }
                sql.append(" PS.SHOP_NAME LIKE CONCAT('%',#{shopName},'%')");
                flag = true;
            }
            if (parameters.containsKey("shortName")) {
                if (flag) {
                    sql.append(" AND ");
                }
                sql.append(" PS.SHORT_NAME LIKE CONCAT('%',#{shortName},'%')");
                flag = true;
            }
            if (parameters.containsKey("shopUserLoginName")) {
                if (flag) {
                    sql.append(" AND ");
                }
                sql.append(" U.LOGIN_NAME LIKE CONCAT('%',#{shopUserLoginName},'%')");
                flag = true;
            }
            if (parameters.containsKey("shopUserName")) {
                if (flag) {
                    sql.append(" AND ");
                }
                sql.append(" U.USER_NAME LIKE CONCAT('%',#{shopUserName},'%')");
                flag = true;
            }
            if (parameters.containsKey("userIds")) {
                if (flag) {
                    sql.append(" AND ");
                }
                List<Long> userIds = (List<Long>) parameters.get("userIds");
                sql.append("  SU.SHOP_USER_ID IN (");
                if (userIds != null) {
                    if (userIds.size() > 0) {
                        for (int i = 0; i < userIds.size(); i++) {
                            sql.append(" #{userIds[" + i + "]},");
                        }
                    }
                }
                sql.deleteCharAt(sql.length() - 1);
                sql.append(")");
                flag = true;
            }

        }

        sql.append(" ORDER BY U.LOGIN_NAME ");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();

    }

    public static String deleteShopRUser(final Map<String, Object> parameter) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append(" DELETE FROM " + DBConstOfUserRole.TN_SHOP_USER_INFO);
        sql.append(" WHERE SHOP_USER_ID IN (");
        @SuppressWarnings("unchecked")
        List<Long> shopUserIds = (List<Long>) parameter.get("shopUserIds");
        if (shopUserIds != null) {
            if (shopUserIds.size() > 0) {
                for (int i = 0; i < shopUserIds.size(); i++) {
                    sql.append(" #{shopUserIds[" + i + "]},");
                }
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" )");
        sql.append(" AND SHOP_ID = #{shopId}");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    public static String getShopUnUserList(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append(" SELECT u.ID shopUserId,U.LOGIN_NAME shopUserLoginName,U.USER_NAME shopUserName" +
                ",U.ORIGIN_OS_ID systemId,S.`SYSTEM_NAME` systemName");
        sql.append(" FROM " + DBConstOfUserRole.TN_USER_INFO + " U ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ON U.ORIGIN_OS_ID = S.SYSTEM_ID");
        sql.append(" WHERE ");
        sql.append(" U.ORIGIN_OS_ID =#{systemId} ");
        sql.append(" AND U.USER_ID NOT in (select SHOP_USER_ID from " + DBConstOfUserRole.TN_SHOP_USER_INFO
                + " where SHOP_ID = #{shopId})");

        if (parameters.containsKey("shopUserLoginName")) {
            sql.append(" AND U.LOGIN_NAME LIKE CONCAT('%',#{shopUserLoginName},'%')");
        }
        if (parameters.containsKey("shopUserName")) {
            sql.append(" AND U.USER_NAME LIKE CONCAT('%',#{shopUserName},'%')");
        }

        sql.append(" ORDER BY U.LOGIN_NAME ");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

}
