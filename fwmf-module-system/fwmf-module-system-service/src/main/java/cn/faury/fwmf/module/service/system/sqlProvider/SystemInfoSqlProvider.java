package cn.faury.fwmf.module.service.system.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 业务系统 SQLMapper Provider
 */
public class SystemInfoSqlProvider {

    /**
     * 日志记录器
     */
    private static Logger log = LoggerFactory.getLogger(SystemInfoSqlProvider.class);

    /**
     * 根据业务系统CODE获取业务系统信息
     * <p>
     * <pre>
     * 可能的参数：
     * 【必填】String systemCode：业务系统编码
     * 【可选】Boolean isAvailable：是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getSystemInfoByCode(final Map<String, Object> parameters) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT SYSTEM_ID SYSTEMID,`SYSTEM_NAME` SYSTEMNAME,`SYSTEM_CODE` SYSTEMCODE,IS_AVAILABLE ISAVAILABLE ");
        sql.append("  FROM ").append(DBConstOfSystem.TN_SYSTEM_INFO);
        sql.append(" WHERE  `SYSTEM_CODE` = #{systemCode} ");

        // 是否可用
        if (parameters.get("isAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isAvailable");
            sql.append(" AND IS_AVAILABLE = '");
            sql.append(isAvailable ? "Y" : "N");
            sql.append("' ");
        }

        sql.append(" ORDER BY IS_AVAILABLE DESC,SYSTEM_NAME ASC,SYSTEM_CODE ASC ");
        return sql.toString();
    }

    public static String getSystemInfoByName(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("parameters ==> " + parameters.toString());

        if (parameters == null || parameters.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }

        if (!parameters.containsKey("systemName")) {
            log.debug("SQL ==> null");
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT COUNT(1) ");
        sql.append("  FROM ").append(DBConstOfSystem.TN_SYSTEM_INFO);
        sql.append(" WHERE  `SYSTEM_NAME` = #{systemName} ");

        // 是否可用
        if (parameters.get("isAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isAvailable");
            sql.append(" AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }

        return sql.toString();
    }

    /**
     * 根据输入条件查询业务系统信息列表
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【可选】Long systemId 业务系统ID
     * 【可选】String systemName 业务系统名称
     * 【可选】String systemCode 业务系统编码
     * 【可选】String isAvailable 是否可用
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String querySystemInfo(final Map<String, Object> parameters) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT SYSTEM_ID,`SYSTEM_NAME`,`SYSTEM_CODE`,IS_AVAILABLE ");
        sql.append("  FROM ").append(DBConstOfSystem.TN_SYSTEM_INFO);
        // 是否存在查询参数
        if (parameters.size() > 0) {
            sql.append(" WHERE ");
            boolean needAnd = false;
            // 业务系统ID
            if (parameters.containsKey("systemId")) {
                sql.append(" SYSTEM_ID = #{systemId} ");
                needAnd = true;
            }
            // 业务系统名称
            if (parameters.containsKey("systemName")) {
                if (needAnd) {
                    sql.append(" AND ");
                }
                sql.append(" `SYSTEM_NAME` LIKE CONCAT('%',#{systemName},'%') ");
                needAnd = true;
            }
            // 业务系统编码
            if (parameters.containsKey("systemCode")) {
                if (needAnd) {
                    sql.append(" AND ");
                }
                sql.append(" `SYSTEM_CODE` LIKE CONCAT('%',#{systemCode},'%') ");
                needAnd = true;
            }
            // 是否可用
            if (parameters.containsKey("isAvailable")) {
                if (needAnd) {
                    sql.append(" AND ");
                }
                if ("N".equals(parameters.get("isAvailable"))) {
                    sql.append(" IS_AVAILABLE = 'N' ");
                } else {
                    sql.append(" IS_AVAILABLE = 'Y' ");
                }
                needAnd = true;
            }
        }
        sql.append(" ORDER BY IS_AVAILABLE DESC,SYSTEM_NAME ASC,SYSTEM_CODE ASC ");
        return sql.toString();
    }

    /**
     * 根据系统ID，更新系统信息，参数为null的不更新
     */
    public static String updateSystemInfoById(final Map<String, Object> parameters) {
        StringBuffer sql = new StringBuffer(128);
        sql.append("UPDATE " + DBConstOfSystem.TN_SYSTEM_INFO);
        sql.append("   SET ");
        if (parameters.get("systemName") != null) {
            sql.append("`SYSTEM_NAME`=#{systemName},");
        }
        if (parameters.get("systemCode") != null) {
            sql.append("`SYSTEM_CODE`=#{systemCode},");
        }
        if (parameters.get("isAvailable") != null) {
            sql.append("`IS_AVAILABLE`=#{isAvailable},");
        }
        sql.setLength(sql.length() - 1);
        sql.append(" WHERE `SYSTEM_ID`=#{systemId,jdbcType=BIGINT}");
        return sql.toString();
    }
}
