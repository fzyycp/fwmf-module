/**
 * APP注册服务协议：ssk-platform-provider-appregister
 *
 * @date 2015年11月24日
 * @author xg.qiu
 * <p>
 * 版权所有：南京扫扫看数字科技有限公司
 */
package cn.faury.fwmf.module.service.app.sqlProvider;

import cn.faury.fwmf.module.api.app.bean.ShopRAppInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfApp;

import java.util.List;
import java.util.Map;

public class ShopRAppInfoSqlProvider {

    /**
     * 获取商店授权App信息
     *
     * @param parameter 查询参数
     * @return SQL
     */
    @SuppressWarnings("unchecked")
    public static String getShopRAppInfoList(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter.size() > 0) {
            sql.append(" SELECT SHOP_ID AS shopId,	APP.APP_ID AS appId,	app.APP_CODE AS appCode" +
                    ",	app.APP_NAME AS appName,	app.APP_OS AS appOS,	app.SYSTEM_ID AS systemId" +
                    ",	app.IS_AVAILABLE AS isAvailable,	SYS.`SYSTEM_CODE` AS systemCode" +
                    ",	SYS.`SYSTEM_NAME` AS systemName FROM ");
            sql.append(DBConstOfApp.TN_PLATFORM_SHOP_R_APP);
            sql.append(" sRapp LEFT JOIN " + DBConstOfApp.TN_APP_INFO + " APP ON APP.APP_ID = sRapp.APP_ID ");
            sql.append(" JOIN " + DBConstOfApp.TN_SYSTEM_INFO + " SYS ON SYS.SYSTEM_ID = APP.SYSTEM_ID");
            sql.append(" WHERE ");
            sql.append(" SHOP_ID IN (");
            List<Long> shopIds = (List<Long>) parameter.get("shopIds");
            for (int i = 0; i < shopIds.size(); i++) {
                sql.append("#{shopIds[" + i + "]},");
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(")");
            // app是否可用
            Boolean isAvailable = (Boolean) parameter.get("isAppAvailable");
            if (isAvailable != null) {
                sql.append("AND APP.IS_AVAILABLE = ");
                sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'");
            }
            sql.append(" ORDER BY sRapp.APP_ID");
        }
        return sql.toString();
    }

    /**
     * 获取商店授权App信息(合并)
     *
     * @param parameter 查询参数
     * @return SQL
     */
    @SuppressWarnings("unchecked")
    public static String getShopRAppInfoListWithConcat(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter.size() > 0) {
            sql.append(" SELECT SHOP_ID AS shopId,GROUP_CONCAT(sRapp.APP_ID) as concatAppIds" +
                    ",app.APP_CODE AS appCode,GROUP_CONCAT(app.APP_NAME) AS concatAppNames" +
                    ",app.APP_OS AS appOS,app.SYSTEM_ID AS systemId" +
                    ",	app.IS_AVAILABLE AS isAvailable,	SYS.`SYSTEM_CODE` AS systemCode" +
                    ",	SYS.`SYSTEM_NAME` AS systemName FROM ");
            sql.append(DBConstOfApp.TN_PLATFORM_SHOP_R_APP);
            sql.append(" sRapp LEFT JOIN " + DBConstOfApp.TN_APP_INFO + " APP ON APP.APP_ID = sRapp.APP_ID ");
            sql.append(" JOIN " + DBConstOfApp.TN_SYSTEM_INFO + " SYS ON SYS.SYSTEM_ID = APP.SYSTEM_ID");
            sql.append(" WHERE ");
            sql.append(" SHOP_ID IN (");
            List<Long> shopIds = (List<Long>) parameter.get("shopIds");
            for (int i = 0; i < shopIds.size(); i++) {
                sql.append("#{shopIds[" + i + "]},");
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(")");
            // app是否可用
            Boolean isAvailable = (Boolean) parameter.get("isAppAvailable");
            if (isAvailable != null) {
                sql.append("AND APP.IS_AVAILABLE = ");
                sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'");
            }
            sql.append(" GROUP BY sRapp.SHOP_ID ORDER BY sRapp.SHOP_ID");
        }
        return sql.toString();
    }

    /**
     * 获取商店授权App信息
     *
     * <pre>
     * 支持的参数：
     * 【必填】Long userId：用户ID
     * 【可选】Boolean isSystemAvailable：业务系统是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
     * </pre>
     *
     * @param parameter
     *            查询参数
     * @return 授权APP信息
     */
    public static String getShopRAppInfoListByUserId(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter.size() > 0) {
            sql.append(" SELECT SHOP_ID AS shopId,	APP.APP_ID AS appId,	app.APP_CODE AS appCode" +
                    ",	app.APP_NAME AS appName,	app.APP_OS AS appOS,	app.SYSTEM_ID AS systemId" +
                    ",	app.IS_AVAILABLE AS isAvailable,	SYS.`SYSTEM_CODE` AS systemCode" +
                    ",	SYS.`SYSTEM_NAME` AS systemName FROM ");
            sql.append(DBConstOfApp.TN_PLATFORM_SHOP_R_APP);
            sql.append(" sRapp LEFT JOIN " + DBConstOfApp.TN_APP_INFO + " APP ON APP.APP_ID = sRapp.APP_ID ");
            sql.append(" JOIN " + DBConstOfApp.TN_SYSTEM_INFO + " SYS ON SYS.SYSTEM_ID = APP.SYSTEM_ID");
            sql.append(" WHERE ");
            sql.append(" SHOP_ID IN (");
            // 用户所在商店
            sql.append("	SELECT SHOP_ID ");
            sql.append("      FROM ").append(DBConstOfApp.TN_PLATFORM_SHOP_USER_INFO);
            sql.append("     WHERE SHOP_USER_ID = #{userId,jdbcType=BIGINT}");
            sql.append(")");
            // app是否可用
            Boolean isAvailable = (Boolean) parameter.get("isAppAvailable");
            if (isAvailable != null) {
                sql.append("AND APP.IS_AVAILABLE = ");
                sql.append(isAvailable.booleanValue() ? "'Y'" : "'N'");
            }
            sql.append(" ORDER BY sRapp.APP_ID");
        }
        return sql.toString();
    }

    /**
     * 插入商店授权APP对象
     *
     * @param parameter 查询参数
     * @return SQL
     */
    @SuppressWarnings("unchecked")
    public static String insertShopRApp(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter.size() > 0) {
            sql.append(" insert into ");
            sql.append(DBConstOfApp.TN_PLATFORM_SHOP_R_APP);
            sql.append("(SHOP_ID,APP_ID)");
            sql.append("VALUES");
            List<ShopRAppInfoBean> shopRApps = (List<ShopRAppInfoBean>) parameter.get("shopRApps");
            for (int i = 0; i < shopRApps.size(); i++) {
                sql.append("(#{shopRApps[" + i + "].shopId},#{shopRApps[" + i + "].appId}),");
            }
            sql.deleteCharAt(sql.length() - 1);
        }
        return sql.toString();
    }

    /**
     * 根据商店授权APP对象ID删除商店授权关系
     *
     * @param parameter 查询参数
     * @return SQL
     */
    @SuppressWarnings("unchecked")
    public static String deleteShopRAppById(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter.size() > 0) {
            sql.append(" delete from ");
            sql.append(DBConstOfApp.TN_PLATFORM_SHOP_R_APP);
            sql.append(" where APP_ID in(");
            List<Long> ids = (List<Long>) parameter.get("ids");
            for (int i = 0; i < ids.size(); i++) {
                sql.append("#{ids[" + i + "]}");
                if (i != ids.size() - 1) {
                    sql.append(",");
                }
            }
            sql.append(")");
        }
        return sql.toString();
    }

    /**
     * 删除关系
     * @param parameter 查询参数
     * @return SQL
     */
    @SuppressWarnings("unchecked")
    public static String deleteShopRAppByShopIds(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter != null && parameter.size() > 0) {
            sql.append(" delete from ");
            sql.append(DBConstOfApp.TN_PLATFORM_SHOP_R_APP);
            List<Long> appIds = (List<Long>) parameter.get("appIds");
            sql.append(" where APP_ID in(");
            for (int i = 0; i < appIds.size(); i++) {
                sql.append("#{appIds[" + i + "]}");
                if (i != appIds.size() - 1) {
                    sql.append(",");
                }
            }
            sql.append(")");
            sql.append(" AND  SHOP_ID =#{shopId}");
        }
        return sql.toString();
    }

    /**
     * 根据商店ID删除商店所有授权APP关系
     *
     * @param parameter 查询参数
     * @return SQL
     */
    @SuppressWarnings("unchecked")
    public static String deleteShopRAppByShopId(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter.size() > 0) {
            sql.append(" delete from ");
            sql.append(DBConstOfApp.TN_PLATFORM_SHOP_R_APP);
            sql.append(" where SHOP_ID in(");
            List<Long> shopIds = (List<Long>) parameter.get("shopIds");
            for (int i = 0; i < shopIds.size(); i++) {
                sql.append("#{shopIds[" + i + "]}");
                if (i != shopIds.size() - 1) {
                    sql.append(",");
                }
            }
            sql.append(")");
        }
        return sql.toString();
    }
}
