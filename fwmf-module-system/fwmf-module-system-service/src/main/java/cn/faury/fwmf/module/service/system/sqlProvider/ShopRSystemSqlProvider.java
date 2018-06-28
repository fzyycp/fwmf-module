package cn.faury.fwmf.module.service.system.sqlProvider;

import cn.faury.fwmf.module.api.system.bean.ShopRSystemInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 商店授权系统SQLMapper Provider
 */
public class ShopRSystemSqlProvider {

	/**
	 * 日志记录器
	 */
	private static Logger log = LoggerFactory.getLogger(ShopRSystemSqlProvider.class);

	/**
	 * 获取商店授权业务系统信息（多个业务系统信息合并）
	 */
	public static String getShopRSystemInfoListWithConcat(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());

		if (parameter == null || parameter.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}

		if (!parameter.containsKey("shopIds")) {
			log.debug("SQL ==> null");
			return null;
		}

		// SQL拼装
		StringBuffer sql = new StringBuffer(128);

		sql.append("SELECT U.SHOP_ID shopId,GROUP_CONCAT(RS.SYSTEM_ID) concatSystemIds,GROUP_CONCAT(S.`SYSTEM_NAME`) concatSystemNames ");
		sql.append(" FROM " + DBConstOfSystem.TN_PLATFORM_SHOP_INFO + " U ");
		sql.append(" LEFT JOIN " + DBConstOfSystem.TN_PLATFORM_SHOP_R_SYSTEM + " RS ON U.SHOP_ID = RS.SHOP_ID");
		sql.append(" LEFT JOIN " + DBConstOfSystem.TN_SYSTEM_INFO + " S ON RS.SYSTEM_ID = S.SYSTEM_ID");
		sql.append(" WHERE ");
		sql.append(" U.SHOP_ID IN ( ");
		// ShopIds 多个商店ID
		@SuppressWarnings("unchecked")
        List<Long> shopIds = (List<Long>) parameter.get("shopIds");
		if (shopIds != null) {
			if (shopIds.size() > 0) {
				for (int i = 0; i < shopIds.size(); i++) {
					sql.append("#{shopIds[" + i + "],jdbcType=BIGINT},");
				}
			}
		}

		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		// 是否可用
		if (parameter.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameter.get("isSystemAvailable");
			sql.append(" AND S.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" GROUP BY U.SHOP_ID ORDER BY U.SHOP_ID DESC");

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * 获取商店授权业务系统信息
	 */
	public static String getShopRSystemInfoList(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());

		if (parameter == null || parameter.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}

		if (!parameter.containsKey("shopIds")) {
			log.debug("SQL ==> null");
			return null;
		}

		// SQL拼装
		StringBuffer sql = new StringBuffer(128);

		sql.append(" SELECT RS.ID id,U.SHOP_ID shopId,RS.SYSTEM_ID systemId,S.`SYSTEM_NAME` systemName,S.`SYSTEM_CODE` systemCode,S.IS_AVAILABLE isAvailable ");
		sql.append(" FROM  " + DBConstOfSystem.TN_PLATFORM_SHOP_INFO + " U ");
		sql.append(" LEFT JOIN " + DBConstOfSystem.TN_PLATFORM_SHOP_R_SYSTEM + " RS ON U.SHOP_ID = RS.shop_ID ");
		sql.append(" LEFT JOIN " + DBConstOfSystem.TN_SYSTEM_INFO + "  S ON RS.SYSTEM_ID = S.SYSTEM_ID");
		sql.append(" WHERE ");
		sql.append(" U.SHOP_ID IN ( ");
		// shopIds 多个商店ID
		@SuppressWarnings("unchecked")
        List<Long> shopIds = (List<Long>) parameter.get("shopIds");
		if (shopIds != null) {
			if (shopIds.size() > 0) {
				for (int i = 0; i < shopIds.size(); i++) {
					sql.append("#{shopIds[" + i + "],jdbcType=BIGINT},");
				}
			}
		}

		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		// 是否可用
		if (parameter.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameter.get("isSystemAvailable");
			sql.append(" AND S.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ORDER BY U.SHOP_ID DESC");

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * 获取商店授权业务系统信息
	 * 
	 * <pre>
	 * 支持的参数：
	 * 【必填】Long userId：用户ID
	 * 【可选】Boolean isSystemAvailable：业务系统是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
	 * </pre>
	 * 
	 * @param parameter
	 *            输入参数
	 * @return 授权的业务系统列表
	 * 
	 */
	public static String getShopRSystemInfoListByUserId(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());

		if (parameter == null || parameter.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}

		if (!parameter.containsKey("userId")) {
			log.debug("SQL ==> null");
			return null;
		}

		// SQL拼装
		StringBuffer sql = new StringBuffer(128);

		sql.append(" SELECT RS.ID id,U.SHOP_ID shopId,RS.SYSTEM_ID systemId,S.`SYSTEM_NAME` systemName,s.`SYSTEM_CODE` systemCode,s.IS_AVAILABLE isAvailable ");
		sql.append(" FROM  " + DBConstOfSystem.TN_PLATFORM_SHOP_INFO + " U ");
		sql.append(" LEFT JOIN " + DBConstOfSystem.TN_PLATFORM_SHOP_R_SYSTEM + " RS ON U.SHOP_ID = RS.shop_ID ");
		sql.append(" LEFT JOIN " + DBConstOfSystem.TN_SYSTEM_INFO + "  S ON RS.SYSTEM_ID = S.SYSTEM_ID");
		sql.append(" WHERE ");
		sql.append(" U.SHOP_ID IN ( ");
		// 用户所在商店
		sql.append("	SELECT SHOP_ID ");
		sql.append("      FROM ").append(DBConstOfSystem.TN_PLATFORM_SHOP_USER_INFO);
		sql.append("     WHERE SHOP_USER_ID = #{userId,jdbcType=BIGINT}");
		sql.append(")");
		// 是否可用
		if (parameter.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameter.get("isSystemAvailable");
			sql.append(" AND S.IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ORDER BY U.SHOP_ID DESC");

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * 插入商店授权业务系统对象
	 * 
	 * <pre>
	 * 仅使用以下字段：
	 * 【必填】Long shopId：商店ID
	 * 【必填】Long systemId：业务系统ID
	 * 其他字段都不使用
	 * </pre>
	 * 
	 * @return 成功插入条数
	 */
	public static String insertShopRSystem(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("shopRSystems")) {
			log.debug("SQL ==> null");
			return null;
		}
		StringBuffer sql = new StringBuffer(128);
		sql.append("INSERT INTO " + DBConstOfSystem.TN_PLATFORM_SHOP_R_SYSTEM + " (`SHOP_ID`, `SYSTEM_ID`) VALUES");
		@SuppressWarnings("unchecked")
        List<ShopRSystemInfoBean> shopRSystems = (List<ShopRSystemInfoBean>) parameters.get("shopRSystems");
		if (shopRSystems != null) {
			if (shopRSystems.size() > 0) {
				for (int i = 0; i < shopRSystems.size(); i++) {

					sql.append("(#{shopRSystems[" + i + "].shopId,jdbcType=BIGINT},  #{shopRSystems[" + i
					        + "].systemId,jdbcType=BIGINT}),");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	/**
	 * <pre>
	 * 1.根据商店授权业务系统对象ID删除商店授权关系
	 * 2. 根据商店ID删除商店所有授权业务系统关系
	 * 3.根据商店ID、多个业务系统ID删除商店授权业务系统关系
	 * </pre>
	 * 
	 * @return 成功删除条数
	 */
	public static String deleteShopRSystemById(final Map<String, Object> parameters) {
		// 参数校验
		log.debug("Parameters ==> " + parameters.toString());
		if (parameters == null || parameters.size() <= 0) {
			log.debug("SQL ==> null");
			return null;
		}
		if (!parameters.containsKey("ids") && !parameters.containsKey("shopIds")
		        && !parameters.containsKey("systemIds") && !parameters.containsKey("shopId")) {
			log.debug("SQL ==> null");
			return null;
		}
		StringBuffer sql = new StringBuffer(128);
		sql.append("DELETE FROM " + DBConstOfSystem.TN_PLATFORM_SHOP_R_SYSTEM);
		sql.append(" WHERE ");
		if (parameters.containsKey("ids") && parameters.get("ids") != null) {
			@SuppressWarnings("unchecked")
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
		if (parameters.containsKey("shopIds") && parameters.get("shopIds") != null) {
			@SuppressWarnings("unchecked")
            List<Long> shopIds = (List<Long>) parameters.get("shopIds");
			sql.append(" SHOP_ID IN ( ");
			if (shopIds != null) {
				if (shopIds.size() > 0) {
					for (int i = 0; i < shopIds.size(); i++) {
						sql.append(" #{shopIds[" + i + "]},");
					}
				}
			}
		}
		if (parameters.containsKey("systemIds") && parameters.get("systemIds") != null
		        && parameters.containsKey("shopId") && parameters.get("shopId") != null) {
			sql.append(" SHOP_ID = #{shopId}");
			@SuppressWarnings("unchecked")
            List<Long> systemIds = (List<Long>) parameters.get("systemIds");
			sql.append(" AND SYSTEM_ID IN ( ");
			if (systemIds != null) {
				if (systemIds.size() > 0) {
					for (int i = 0; i < systemIds.size(); i++) {
						sql.append(" #{systemIds[" + i + "]},");
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
