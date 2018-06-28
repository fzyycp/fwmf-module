package cn.faury.fwmf.module.service.systemconfig.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.service.constant.DBConstOfSystemConfig;

import java.util.List;
import java.util.Map;

/**
 * 业务系统 SQLMapper Provider
 */
public class SystemConfigInfoSqlProvider {

    /**
     * SQL拼接字符串:WHERE
     */
    private static String WHERE = " WHERE ";

    /**
     * SQL拼接字符串:AND
     */
    private static String AND = " AND ";

    /**
     * SQL拼接字符串:LIKE
     */
    private static String LIKE = " LIKE ";

    /**
     * SQL拼接字符串:ORDER_BY
     */
    private static String ORDER_BY = " ORDER BY ";

    /**
     * 根据系统参数配置key获取全局系统参数配置信息
     */
    public static String getGlobalSystemConfigInfoByKey(final Map<String, Object> parameters) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT c.SYSTEM_CONFIG_ID as systemConfigId,SYSTEM_CONFIG_KEY as systemConfigKey,"
                + "SYSTEM_CONFIG_VALUE as systemConfigValue,"
                + "SYSTEM_CONFIG_SYSTEM as systemConfigSystemId,"
                + "SYSTEM_CONFIG_TIME as systemConfigTime,c.IS_AVAILABLE as isAvailable ,"
                + "s.SYSTEM_NAME  as systemName,SYSTEM_CONFIG_DESC as systemConfigDesc ");
        sql.append(" FROM ");
        sql.append(DBConstOfSystemConfig.TN_SYSTEM_CONFIG).append(" c ");
        sql.append("LEFT JOIN ").append(DBConstOfSystemConfig.TN_SYSTEM_INFO).append(" s ");
        sql.append("ON s.SYSTEM_ID = c.SYSTEM_CONFIG_SYSTEM ");
        sql.append(WHERE).append("1=1");
        if (parameters.containsKey("isSysConfigAvailable") && null != (Boolean) parameters.get("isSysConfigAvailable")) {
            Boolean available = (Boolean) parameters.get("isSysConfigAvailable");
            sql.append(AND).append(" c.IS_AVAILABLE = '").append(available.booleanValue() ? "Y" : "N").append("'");
        }
        // 系统参数配置key
        if (parameters.containsKey("systemConfigKey") && StringUtil.isNotEmpty((String) parameters.get("systemConfigKey"))) {
            sql.append(AND).append("  c.`SYSTEM_CONFIG_KEY`  = '" + parameters.get("systemConfigKey") + "' ");

        }
        sql.append(AND).append(" c.SYSTEM_CONFIG_SYSTEM IS NULL ");
        sql.append(ORDER_BY).append(" SYSTEM_CONFIG_SYSTEM ASC ,isAvailable DESC ");
        return sql.toString();
    }

    /**
     * 根据系统参数配置是否可用获取全局系统中参数配置列表信息
     */
    public static String getGlobalSystemConfigInfoList(final Map<String, Object> parameters) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT c.SYSTEM_ID as systemConfigId,SYSTEM_CONFIG_KEY as systemConfigKey,"
                + "SYSTEM_CONFIG_VALUE as systemConfigValue,"
                + "SYSTEM_CONFIG_SYSTEM as systemConfigSystemId,"
                + "SYSTEM_CONFIG_TIME as systemConfigTime,SYSTEM_CONFIG_DESC as systemConfigDesc,"
                + "c.IS_AVAILABLE as isAvailable ,s.SYSTEM_NAME  as systemName ");
        sql.append(" FROM ");
        sql.append(DBConstOfSystemConfig.TN_SYSTEM_CONFIG).append(" c ");
        sql.append("LEFT JOIN ").append(DBConstOfSystemConfig.TN_SYSTEM_INFO).append(" s ");
        sql.append("ON s.SYSTEM_ID = c.SYSTEM_CONFIG_SYSTEM ");
        sql.append(WHERE).append("1=1");
        if (parameters.containsKey("isSysConfigAvailable") && null != (Boolean) parameters.get("isSysConfigAvailable")) {
            Boolean available = (Boolean) parameters.get("isSysConfigAvailable");
            sql.append(AND).append(" c.IS_AVAILABLE = '").append(available.booleanValue() ? "Y" : "N").append("'");
        }
        sql.append(AND).append(" c.SYSTEM_CONFIG_SYSTEM IS NULL ");
        sql.append(ORDER_BY).append(" SYSTEM_CONFIG_SYSTEM ASC ,isAvailable DESC ");
        return sql.toString();
    }

    /**
     * 根据参数信息获取系统参数配置列表信息
     *
     * @param parameter
     * @return 系统参数配置信息列表以<b>List</b>展示
     */
    public static String getSystemConfigInfoList(final Map<String, Object> parameter) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT c.SYSTEM_ID as systemConfigId,SYSTEM_CONFIG_KEY as systemConfigKey,"
                + "SYSTEM_CONFIG_VALUE as systemConfigValue,"
                + "SYSTEM_CONFIG_SYSTEM as systemConfigSystemId,"
                + "SYSTEM_CONFIG_TIME as systemConfigTime,SYSTEM_CONFIG_DESC as systemConfigDesc,"
                + "c.IS_AVAILABLE as isAvailable ,s.SYSTEM_NAME  as systemName ");
        sql.append(" FROM ");
        sql.append(DBConstOfSystemConfig.TN_SYSTEM_CONFIG).append(" c ");
        sql.append("LEFT JOIN ").append(DBConstOfSystemConfig.TN_SYSTEM_INFO).append(" s ");
        sql.append("ON s.SYSTEM_ID = c.SYSTEM_CONFIG_SYSTEM ");
        if (parameter.containsKey("isSysAvailable") && null != (Boolean) parameter.get("isSysAvailable")) {
            Boolean available = (Boolean) parameter.get("isSysAvailable");
            sql.append(AND).append(" s.IS_AVAILABLE = '").append(available.booleanValue() ? "Y" : "N").append("'");
        }
        sql.append(WHERE).append("1=1");
        if (parameter.size() > 0) {
            // 系统ID
            if (parameter.containsKey("systemId")) {
                Boolean isWithGlobal = (Boolean) parameter.get("isWithGlobal");

                if (isWithGlobal != null && isWithGlobal) {
                    // 需要查询全局信息
                    sql.append(AND).append(" (SYSTEM_CONFIG_SYSTEM = #{systemId} OR SYSTEM_CONFIG_SYSTEM  is NULL) ");
                } else {
                    // 指定系统参数ID信息
                    sql.append(AND).append(" (SYSTEM_CONFIG_SYSTEM = #{systemId}) ");
                }
            }
            // 系统code
            if (parameter.containsKey("systemCode") && StringUtil.isNotEmpty((String) parameter.get("systemCode"))) {

                Boolean isWithGlobal = (Boolean) parameter.get("isWithGlobal");
                if (isWithGlobal!=null && isWithGlobal) {
                    // 需要查询全局信息
                    sql.append(AND).append(" ( s.`SYSTEM_CODE`  = #{systemCode} OR SYSTEM_CONFIG_SYSTEM  is NULL ) ");
                } else {
                    // 指定系统参数ID信息
                    sql.append(AND).append("  s.`SYSTEM_CODE`  = #{systemCode} ");
                }
            }
            // 系统参数配置ID
            if (parameter.containsKey("systemConfigId") && null != parameter.get("systemConfigId")) {
                sql.append(AND).append(" c.`SYSTEM_CONFIG_ID`= #{systemConfigId}");
            }
            // 系统参数配置key
            if (parameter.containsKey("systemConfigKey")
                    && StringUtil.isNotEmpty((String) parameter.get("systemConfigKey"))) {
                sql.append(AND).append("  c.`SYSTEM_CONFIG_KEY`  = #{systemConfigKey} ");
            }
            // 系统参数配置是否可用
            if (parameter.containsKey("isSysConfigAvailable")
                    && null != (Boolean) parameter.get("isSysConfigAvailable")) {
                Boolean available = (Boolean) parameter.get("isSysConfigAvailable");
                sql.append(AND).append(" c.IS_AVAILABLE = '").append(available.booleanValue() ? "Y" : "N").append("'");
            }
        }
        // return sql
        return sql.toString();
    }

    /**
     * 查询系统参数配置信息 该方法默认查询包含全局信息
     */
    public static String querySystemConfigInfo(final Map<String, Object> parameters) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT c.SYSTEM_CONFIG_ID as systemConfigId,SYSTEM_CONFIG_KEY as systemConfigKey,"
                + "SYSTEM_CONFIG_VALUE as systemConfigValue,"
                + "SYSTEM_CONFIG_SYSTEM as systemConfigSystemId,"
                + "SYSTEM_CONFIG_TIME as systemConfigTime,SYSTEM_CONFIG_DESC as systemConfigDesc,"
                + "c.IS_AVAILABLE as isAvailable ,s.SYSTEM_NAME  as systemName ");
        sql.append(" FROM ");
        sql.append(DBConstOfSystemConfig.TN_SYSTEM_CONFIG).append(" c ");
        sql.append("LEFT JOIN ").append(DBConstOfSystemConfig.TN_SYSTEM_INFO).append(" s ");
        sql.append("ON s.SYSTEM_ID = c.SYSTEM_CONFIG_SYSTEM ");
        sql.append(WHERE).append("1=1");
        if (parameters.size() > 0) {
            // 系统参数配置ID
            if (parameters.containsKey("systemConfigId")) {
                sql.append(AND).append(" c.SYSTEM_CONFIG_ID = #{systemConfigId} ");
            }
            // 系统ID
            if (parameters.containsKey("systemConfigSystemId")) {
                // Long systemId = (Long)
                // parameters.get("systemConfigSystemId");
                Boolean isWithGlobal = (Boolean) parameters.get("isWithGlobal");
                if (isWithGlobal) {
                    // 需要查询全局信息
                    sql.append(AND).append(
                            " (SYSTEM_CONFIG_SYSTEM = #{systemConfigSystemId} OR SYSTEM_CONFIG_SYSTEM  is NULL) ");
                } else {
                    // 指定系统参数ID信息
                    sql.append(AND).append(" (SYSTEM_CONFIG_SYSTEM = #{systemConfigSystemId}) ");
                }
            }
            // 系统参数配置KEY
            if (parameters.containsKey("systemConfigKey")) {
                sql.append(AND).append(" SYSTEM_CONFIG_KEY ").append(LIKE)
                        .append(" CONCAT('%',#{systemConfigKey},'%')   ");
            }
            // 系统参数配置VLAUE
            if (parameters.containsKey("systemConfigValue")) {
                sql.append(AND).append(" SYSTEM_CONFIG_VALUE ").append(LIKE)
                        .append(" CONCAT('%',#{systemConfigValue},'%') ");
            }
            // 系统参数配置 是否可用
            if (parameters.containsKey("isAvailable")) {
                sql.append(AND).append(" c.IS_AVAILABLE = #{isAvailable} ");
            }
        }
        // 查询可用的系统公共代码信息
        sql.append(ORDER_BY).append(" SYSTEM_CONFIG_SYSTEM ASC ,isAvailable DESC ");
        // 返回组装好SQL
        return sql.toString();
    }

    public static String checkSystemConfigInfo(final Map<String, Object> parameters) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT c.SYSTEM_CONFIG_ID as systemConfigId,SYSTEM_CONFIG_KEY as systemConfigKey,"
                + "SYSTEM_CONFIG_VALUE as systemConfigValue,"
                + "SYSTEM_CONFIG_SYSTEM as systemConfigSystemId,"
                + "SYSTEM_CONFIG_TIME as systemConfigTime,SYSTEM_CONFIG_DESC as systemConfigDesc,"
                + "c.IS_AVAILABLE as isAvailable ,s.SYSTEM_NAME  as systemName ");
        sql.append(" FROM ");
        sql.append(DBConstOfSystemConfig.TN_SYSTEM_CONFIG).append(" c ");
        sql.append("LEFT JOIN ").append(DBConstOfSystemConfig.TN_SYSTEM_INFO).append(" s ");
        sql.append("ON s.SYSTEM_ID = c.SYSTEM_CONFIG_SYSTEM ");
        sql.append(WHERE).append("1=1");
        if (parameters.size() > 0) {
            // 系统参数配置ID
            if (parameters.containsKey("systemConfigId")) {
                sql.append(AND).append(" c.SYSTEM_CONFIG_ID = #{systemConfigId} ");
            }

            // 系统ID
            if (parameters.containsKey("systemConfigSystemId")) {
                Long systemId = (Long) parameters.get("systemConfigSystemId");
                sql.append(AND).append(" (c.SYSTEM_CONFIG_SYSTEM = ' ");
                sql.append(systemId == null ? "NULL" : systemId);
                sql.append("' OR s.SYSTEM_ID is  NULL)");

            }
            // 系统参数配置KEY
            if (parameters.containsKey("systemConfigKey")) {
                sql.append(AND).append(" SYSTEM_CONFIG_KEY = #{systemConfigKey} ");
            }
            // 系统参数配置VLAUE
            if (parameters.containsKey("systemConfigValue")) {
                sql.append(AND).append(" SYSTEM_CONFIG_VALUE = #{systemConfigValue} ");
            }
            // 系统参数配置 是否可用
            if (parameters.containsKey("isAvailable")) {
                sql.append(AND).append(" c.IS_AVAILABLE = #{isAvailable} ");
            }
        }
        // 返回组装好SQL
        return sql.toString();
    }

    public static String updateSystemConfigIdById(final Map<String, Object> parameters) {
        StringBuffer sql = new StringBuffer(128);
        sql.append(" update ");
        sql.append(DBConstOfSystemConfig.TN_SYSTEM_CONFIG);
        if (parameters.size() > 0) {
            boolean isSplit = false;
            sql.append(" set ");
            // 系统参数配置KEY
            if (parameters.get("systemConfigKey") != null && parameters.containsKey("systemConfigKey")) {
                sql.append(" SYSTEM_CONFIG_KEY = #{systemConfigKey}   ");
                isSplit = true;
            }
            // 系统参数配置VLAUE
            if (parameters.get("systemConfigValue") != null && parameters.containsKey("systemConfigValue")) {
                if (isSplit) {
                    sql.append(", ");
                }
                sql.append(" SYSTEM_CONFIG_VALUE = #{systemConfigValue}");
                isSplit = true;
            }
            // 使用说明
            if (parameters.get("systemConfigDesc") != null && parameters.containsKey("systemConfigDesc")) {
                if (isSplit) {
                    sql.append(", ");
                }
                sql.append(" SYSTEM_CONFIG_DESC = #{systemConfigDesc}");
                isSplit = true;
            }
            // 系统参数配置 是否可用
            if (parameters.get("isAvailable") != null && parameters.containsKey("isAvailable")) {
                if (isSplit) {
                    sql.append(", ");
                }
                sql.append(" IS_AVAILABLE = #{isAvailable} ");
                isSplit = true;
            }
            // 系统参数配置ID
            if (parameters.get("systemConfigId") != null && parameters.containsKey("systemConfigId")) {
                if (isSplit) {
                    sql.append(" where  SYSTEM_CONFIG_ID = #{systemConfigId} ");
                }
                isSplit = true;
            }
        }
        return sql.toString();

    }

    public static String updateSystemConfigInfoByKey(final Map<String, Object> parameters) {
        StringBuffer sql = new StringBuffer(128);
        sql.append(" update ");
        sql.append(DBConstOfSystemConfig.TN_SYSTEM_CONFIG);
        if (parameters.size() > 0) {
            boolean isSplit = false;
            sql.append(" set ");
            // 系统参数配置VLAUE
            if (parameters.get("systemConfigValue") != null && parameters.containsKey("systemConfigValue")) {
                sql.append(" SYSTEM_CONFIG_VALUE = #{systemConfigValue}");
                isSplit = true;
            }
            // 使用说明
            if (parameters.get("systemConfigDesc") != null && parameters.containsKey("systemConfigDesc")) {
                if (isSplit) {
                    sql.append(", ");
                }
                sql.append(" ,SYSTEM_CONFIG_DESC = #{systemConfigDesc}");
            }
            // 系统参数配置 是否可用
            if (parameters.get("isAvailable") != null && parameters.containsKey("isAvailable")) {
                if (isSplit) {
                    sql.append(", ");
                }
                sql.append(" IS_AVAILABLE = #{isAvailable} ");
                isSplit = true;
            }
            // 系统ID
            if (parameters.get("systemConfigSystemId") != null && parameters.containsKey("systemConfigSystemId")) {
                if (isSplit) {
                    sql.append(" where  SYSTEM_CONFIG_SYSTEM = #{systemConfigSystemId} ");
                }
                isSplit = true;
            }
            // 系统key
            if (parameters.get("systemConfigKey") != null && parameters.containsKey("systemConfigKey")) {
                if (isSplit) {
                    sql.append(AND);
                }
                sql.append(" SYSTEM_CONFIG_KEY = #{systemConfigKey} ");
                isSplit = true;
            }
        }
        return sql.toString();
    }

    public static String deleteSystemConfigInfoByIds(final Map<String, Object> parameters) {
        StringBuffer sql = new StringBuffer(128);
        sql.append(" delete from ");
        sql.append(DBConstOfSystemConfig.TN_SYSTEM_CONFIG);
        if (parameters.size() > 0) {
            if (parameters.containsKey("systemConfigId")) {
                sql.append(" where SYSTEM_CONFIG_ID IN (");
                List<?> systemConfigIds = (List<?>) parameters.get("systemConfigId");
                for (int i = 0; i < systemConfigIds.size(); i++) {
                    sql.append(" #{systemConfigId[" + i + "]}");
                    if (i != systemConfigIds.size() - 1) {
                        sql.append(",");
                    }
                }
                sql.append(")");
            }
        }
        return sql.toString();
    }
}
