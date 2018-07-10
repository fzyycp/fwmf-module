package cn.faury.fwmf.module.service.user.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class SystemRUserSQLProvider {

    /**
     * 日志记录器
     */
    private static Logger log = LoggerFactory.getLogger(SystemRUserSQLProvider.class);

    @SuppressWarnings("unchecked")
    public static String getUserInfoList(Map<String, Object> parameter) {
        // 参数校验
        log.debug("parameter ==> " + parameter.toString());

        if (parameter == null || parameter.size() <= 0) {
            log.debug("SQL ==> null");
        }

        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        Boolean flag = false;
        sql.append("SELECT U.USER_ID userId,U.LOGIN_NAME loginName,U.USER_NAME userName,U.ORIGIN_OS_ID originOsId" +
                ",U.INS_TSTMP insTstmp,U.IS_ENABLE isEnable" +
                ",S.`SYSTEM_NAME` originOsName FROM "
                + DBConstOfUserRole.TN_USER_INFO + " U ");
        sql.append(" LEFT JOIN " + DBConstOfUserRole.TN_SYSTEM_INFO + " S ON U.ORIGIN_OS_ID = S.SYSTEM_ID");
        // 【可选】loginName：登录ID
        if (parameter.containsKey("loginName")) {
            if (flag) {
                sql.append(" AND");
            } else {
                sql.append(" WHERE ");
            }
            sql.append(" U.LOGIN_NAME LIKE CONCAT('%',#{loginName,jdbcType=VARCHAR},'%')");
            flag = true;
        }
        if (parameter.containsKey("systemCode")) {
            if (flag) {
                sql.append(" AND");
            } else {
                sql.append(" WHERE ");
            }

            sql.append(" S.SYSTEM_CODE = #{systemCode} ");
            flag = true;
        }
        if (parameter.containsKey("userTypeList")) {
            List<Long> userTypeList = (List<Long>) parameter.get("userTypeList");
            if (flag) {
                sql.append(" AND");
            } else {
                sql.append(" WHERE ");
            }
            sql.append(" U.RESV_FLG in ( ");
            if (userTypeList != null && userTypeList.size() > 0) {
                for (int i = 0; i < userTypeList.size(); i++) {
                    sql.append(" #{userTypeList[" + i + "]},");
                }
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" )");

            flag = true;
        }
        if (parameter.containsKey("startTime")) {
            if (flag) {
                sql.append(" AND");
            } else {
                sql.append(" WHERE ");
            }
            sql.append(" U.INS_TSTMP >= #{startTime}");
            flag = true;
        }
        if (parameter.containsKey("endTime")) {
            if (flag) {
                sql.append(" AND");
            } else {
                sql.append(" WHERE ");
            }
            sql.append(" U.INS_TSTMP <= #{endTime}");
            flag = true;
        }

        sql.append(" ORDER BY originOsId DESC,insTstmp DESC ");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }
}
