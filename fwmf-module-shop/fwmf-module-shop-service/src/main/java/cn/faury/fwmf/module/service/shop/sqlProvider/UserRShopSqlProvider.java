package cn.faury.fwmf.module.service.shop.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfShop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 用户商店
 */
public class UserRShopSqlProvider {

	/**
	 * 日志记录器
	 */
	private static Logger log = LoggerFactory.getLogger(UserRShopSqlProvider.class);

	/**
	 * 通过用户ID查询商店信息
	 */
	public static String getShopInfoByUserId(Map<String, Object> parameter) {
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append(" SELECT DISTINCT S.`SHOP_ID` shopId,S.`SHOP_NAME` shopName,S.`SHORT_NAME` shortName,S.`SHOPKEEPER_ID` shopKeeperId,S.`ALLOCAT_RATIO` allocatRatio,S.`PAY_STYLE` payStyle,");
		sql.append(" S.`AREA_CODE` areaCode,S.`ADDRESS` address,S.`REMARK` remark,S.`SHOP_STATE` shopState,S.`ORIGIN_SYSTEM` originSystem,"
		        + "S.`CREATE_PERSON` createPerson,S.`CREATE_TIME` createTime,S.`UPDATE_PERSON` updatePerson,S.`UPDATE_TIME` updateTime,S.`DEL_FLAG` delFlag");
		sql.append(" FROM " + DBConstOfShop.TN_SHOP_INFO + " S");
		sql.append(" left join " + DBConstOfShop.TN_SHOP_USER_INFO + " U ON S.SHOP_ID = U.SHOP_ID ");
		sql.append(" WHERE ");
		sql.append(" U.SHOP_USER_ID = #{userId} ");

		sql.append(" ORDER BY S.SHOP_STATE ASC,S.`SHOP_NAME` ASC");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

}
