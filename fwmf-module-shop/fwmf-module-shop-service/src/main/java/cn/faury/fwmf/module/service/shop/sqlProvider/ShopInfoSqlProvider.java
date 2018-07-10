package cn.faury.fwmf.module.service.shop.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.shop.bean.ShopInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ShopInfoSqlProvider {

    /**
     * 日志记录器
     */
    private static Logger log = LoggerFactory.getLogger(ShopInfoSqlProvider.class);

    /**
     * 通过条件查询商店信息
     */
    public static String queryShopInfo(Map<String, Object> parameter) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append(" SELECT DISTINCT S.`SHOP_ID` shopId,S.`SHOP_NAME` shopName,S.`SHORT_NAME` shortName,S.`SHOPKEEPER_ID` shopKeeperId,S.`ALLOCAT_RATIO` allocatRatio,S.`PAY_STYLE` payStyle,");
        sql.append(" S.`AREA_CODE` areaCode,S.`ADDRESS` address,S.`REMARK` remark,S.`SHOP_STATE` shopState,S.`ORIGIN_SYSTEM` originSystem,"
                + "S.`CREATE_PERSON` createPerson,S.`CREATE_TIME` createTime,S.`UPDATE_PERSON` updatePerson,S.`UPDATE_TIME` updateTime,S.`DEL_FLAG` delFlag");
        sql.append(" FROM " + DBConstOfShop.TN_PLATFORM_SHOP_INFO + " S");
        sql.append(" left join " + DBConstOfShop.TN_PLATFORM_SHOP_R_SYSTEM + " M ON S.SHOP_ID = M.SHOP_ID ");
        if (parameter.containsKey("shopKeeperName")) {
            sql.append(" left join " + DBConstOfShop.TN_USER_INFO + " U ON S.SHOPKEEPER_ID = U.ID ");
        }
        sql.append(" WHERE ");
        sql.append(" DEL_FLAG = 'N' ");

        if (parameter.containsKey("shopName")) {
            sql.append(" AND S.SHOP_NAME LIKE CONCAT('%',#{shopName},'%') ");
        }
        if (parameter.containsKey("shopState")) {
            sql.append(" AND S.SHOP_STATE = #{shopState}");
        }

        if (parameter.containsKey("systemId")) {
            sql.append(" AND M.SYSTEM_ID = #{systemId}");
        }
        if (parameter.containsKey("systemCode")) {
            sql.append(" AND M.SYSTEM_ID = (SELECT SYSTEM_ID FROM " + DBConstOfShop.TN_SYSTEM_INFO
                    + " WHERE `SYSTEM_CODE` = #{systemCode}) AND S.SHOP_STATE = '1' ");
        }
        if (parameter.containsKey("shopKeeperName")) {
            sql.append(" AND U.USER_NAME LIKE CONCAT('%',#{shopKeeperName},'%')  ");
        }
        if (parameter.containsKey("startTime")) {
            sql.append(" AND S.CREATE_TIME >= #{startTime}");
        }
        if (parameter.containsKey("endTime")) {
            sql.append(" AND S.CREATE_TIME <= #{endTime}");
        }
        if (parameter.containsKey("shopIds")) {
            sql.append(" AND S.SHOP_ID IN (");
            List<Long> shopIds = (List<Long>) parameter.get("shopIds");
            if (shopIds != null) {
                if (shopIds.size() > 0) {
                    for (int i = 0; i < shopIds.size(); i++) {
                        sql.append(" #{shopIds[" + i + "]},");
                    }
                }
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" )");
        }
        if (parameter.containsKey("shopId")) {
            sql.append(" AND S.SHOP_ID = #{shopId}");
        }

        sql.append(" ORDER BY S.SHOP_STATE ASC,S.`SHOP_NAME` ASC");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 通过商店ID查询商店信息
     */
    public static String getShopInfoById(Long shopId) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append(" SELECT S.`SHOP_ID` shopId,S.`SHOP_NAME` shopName,S.`SHORT_NAME` shortName,U.`LOGIN_NAME` shopKeeperName,U.`USER_NAME` shopKeeperUserName,S.`SHOPKEEPER_ID` shopKeeperId,S.`ALLOCAT_RATIO` allocatRatio,S.`PAY_STYLE` payStyle,");
        sql.append(" S.`AREA_CODE` areaCode,S.`ADDRESS` address,S.`REMARK` remark,S.`SHOP_STATE` shopState,S.`ORIGIN_SYSTEM` originSystem,S.`CREATE_PERSON` createPerson,S.`CREATE_TIME` createTime,S.`UPDATE_PERSON` updatePerson,S.`UPDATE_TIME` updateTime,S.`DEL_FLAG` delFlag");
        sql.append(" FROM " + DBConstOfShop.TN_PLATFORM_SHOP_INFO + " S ");
        sql.append(" left join " + DBConstOfShop.TN_USER_INFO + " U ON S.SHOPKEEPER_ID = U.USER_ID ");
        sql.append(" WHERE ");
        sql.append(" SHOP_ID = #{shopId} ");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    public static String getShopInfoByName(Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        sql.append(" SELECT COUNT(SHOP_ID) FROM " + DBConstOfShop.TN_PLATFORM_SHOP_INFO);
        sql.append(" WHERE ");
        if (parameter.containsKey("shopName")) {
            sql.append(" SHOP_NAME = #{shopName} ");
        }
        if (parameter.containsKey("shortName")) {
            sql.append(" SHORT_NAME = #{shortName} ");
        }
        if (parameter.containsKey("shopId")) {
            sql.append(" AND SHOP_ID != #{shopId} ");
        }
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 插入保存商店信息
     */
    public static String insertShopInfo(ShopInfoBean bean) {
        StringBuffer sql = new StringBuffer(128);
        sql.append(" INSERT INTO " + DBConstOfShop.TN_PLATFORM_SHOP_INFO);
        sql.append(" (`SHOP_NAME`, `SHORT_NAME`, `SHOPKEEPER_ID`, `ALLOCAT_RATIO`, `PAY_STYLE`, `SHOP_STATE`, `DEL_FLAG`,`CREATE_PERSON`,`CREATE_TIME`,`ORIGIN_SYSTEM`,UPDATE_TIME");
        if (StringUtil.isNotEmpty(bean.getAreaCode())) {
            sql.append(", `AREA_CODE`");
        }
        if (StringUtil.isNotEmpty(bean.getAddress())) {
            sql.append(", `ADDRESS`");
        }
        if (StringUtil.isNotEmpty(bean.getRemark())) {
            sql.append(", `REMARK`");
        }

        sql.append(" )");
        sql.append(" VALUES ");
        sql.append("( #{shopName},#{shortName},#{shopKeeperId},#{allocatRatio},#{payStyle},#{shopState},#{delFlag},#{createPerson},now(),#{originSystem},now()");
        if (StringUtil.isNotEmpty(bean.getAreaCode())) {
            sql.append(", #{areaCode}");
        }
        if (StringUtil.isNotEmpty(bean.getAddress())) {
            sql.append(", #{address}");
        }
        if (StringUtil.isNotEmpty(bean.getRemark())) {
            sql.append(", #{remark}");
        }
        sql.append(" )");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 更新商店信息
     */
    public static String updateShopInfo(Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        sql.append(" UPDATE " + DBConstOfShop.TN_PLATFORM_SHOP_INFO);
        sql.append(" SET ");
        sql.append(" UPDATE_TIME = now() ,");
        if (parameter.containsKey("updatePerson")) {
            sql.append(" UPDATE_PERSON = #{updatePerson} ,");
        }
        if (parameter.containsKey("shopName")) {
            sql.append(" SHOP_NAME = #{shopName} ,");
        }
        if (parameter.containsKey("shortName")) {
            sql.append(" SHORT_NAME = #{shortName} ,");
        }
        if (parameter.containsKey("allocatRatio")) {
            sql.append(" ALLOCAT_RATIO = #{allocatRatio} ,");
        }
        if (parameter.containsKey("payStyle")) {
            sql.append(" PAY_STYLE = #{payStyle} ,");
        }
        if (parameter.containsKey("shopState")) {
            sql.append(" SHOP_STATE = #{shopState} ,");
        }
        if (parameter.containsKey("areaCode")) {
            sql.append(" AREA_CODE = #{areaCode} ,");
        }
        if (parameter.containsKey("address")) {
            sql.append(" ADDRESS = #{address} ,");
        }
        if (parameter.containsKey("remark")) {
            sql.append(" REMARK = #{remark} ,");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" WHERE ");
        if (parameter.containsKey("shopId")) {
            sql.append(" SHOP_ID = #{shopId} ");
        }
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 删除商店信息（逻辑删除）
     */
    @SuppressWarnings("unchecked")
    public static String deleteShopInfo(Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        sql.append(" UPDATE " + DBConstOfShop.TN_PLATFORM_SHOP_INFO);
        sql.append(" SET ");
        sql.append(" DEL_FLAG = 'Y' ");
        sql.append(" WHERE SHOP_ID IN (");
        List<Long> shopIds = (List<Long>) parameter.get("shopIds");
        if (shopIds != null) {
            if (shopIds.size() > 0) {
                for (int i = 0; i < shopIds.size(); i++) {
                    sql.append(" #{shopIds[" + i + "]},");
                }
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" )");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    @SuppressWarnings("unchecked")
    public static String updateShopState(Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        sql.append(" UPDATE " + DBConstOfShop.TN_PLATFORM_SHOP_INFO);
        sql.append(" SET ");
        sql.append(" SHOP_STATE = #{shopState} ");
        sql.append(" WHERE SHOP_ID IN (");
        List<Long> shopIds = (List<Long>) parameter.get("shopIds");
        if (shopIds != null) {
            if (shopIds.size() > 0) {
                for (int i = 0; i < shopIds.size(); i++) {
                    sql.append(" #{shopIds[" + i + "]},");
                }
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" )");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 查询商店授权系统数量
     */
    public static String getShopRSystemCounts(Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT COUNT(SYSTEM_ID) FROM " + DBConstOfShop.TN_PLATFORM_SHOP_R_SYSTEM
                + " where SHOP_ID = #{shopId}");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 查询商店授权App数量
     */
    public static String getShopRAppCounts(Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT COUNT(APP_ID) FROM " + DBConstOfShop.TN_SHOP_R_APP
                + " where SHOP_ID = #{shopId}");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 查询商店自建用户数量
     */
    public static String getShopRUserSelfCreateCounts(Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        sql.append(" SELECT COUNT(SHOP_USER_ID) FROM " + DBConstOfShop.TN_PLATFORM_SHOP_USER_INFO);
        sql.append(" WHERE SHOP_ID = #{shopId}");
        sql.append(" AND SHOP_USER_ID NOT IN (");
        sql.append(" select SHOPKEEPER_ID from " + DBConstOfShop.TN_PLATFORM_SHOP_INFO);
        sql.append(" WHERE SHOP_ID = #{shopId})");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    public static String getShopInfoUnRSystem() {
        StringBuffer sql = new StringBuffer(128);
        sql.append(" SELECT DISTINCT S.`SHOP_ID` shopId,S.`SHOP_NAME` shopName,S.`SHORT_NAME` shortName,S.`SHOPKEEPER_ID` shopKeeperId,S.`ALLOCAT_RATIO` allocatRatio,S.`PAY_STYLE` payStyle,");
        sql.append(" S.`AREA_CODE` areaCode,S.`ADDRESS` address,S.`REMARK` remark,S.`SHOP_STATE` shopState,S.`ORIGIN_SYSTEM` originSystem,S.`CREATE_PERSON` createPerson,S.`CREATE_TIME` createTime,S.`UPDATE_PERSON` updatePerson,S.`UPDATE_TIME` updateTime,S.`DEL_FLAG` delFlag");
        sql.append(" FROM " + DBConstOfShop.TN_PLATFORM_SHOP_INFO + " S");
        sql.append(" WHERE ");
        sql.append(" DEL_FLAG = 'N' ");
        sql.append(" AND SHOP_ID not in ( ");
        sql.append(" SELECT DISTINCT SHOP_ID FROM " + DBConstOfShop.TN_PLATFORM_SHOP_R_SYSTEM);
        sql.append(" )");
        sql.append(" ORDER BY S.SHOP_STATE ASC,S.`SHOP_NAME` ASC");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

}
