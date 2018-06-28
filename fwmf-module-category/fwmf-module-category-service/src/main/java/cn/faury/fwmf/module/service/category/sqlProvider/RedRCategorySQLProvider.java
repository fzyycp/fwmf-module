package cn.faury.fwmf.module.service.category.sqlProvider;

import cn.faury.fwmf.module.api.category.bean.RedRCategoryBean;
import cn.faury.fwmf.module.service.constant.DBConstOfCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class RedRCategorySQLProvider {

	/**
	 * 日志记录器
	 */
	private static Logger log = LoggerFactory.getLogger(RedRCategorySQLProvider.class);

	public static String queryRedRCategoryByRedId(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append(" SELECT C.PRODUCT_CATEGORY_ID productCategoryId, C.PRODUCT_CATEGORY_NAME productCategoryName FROM "
		        + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO + " C ");
		sql.append(" LEFT JOIN " + DBConstOfCategory.TN_DISCOUNT_RED_R_OBJECT
		        + " D ON D.OBJECT_ID = C.PRODUCT_CATEGORY_ID");
		sql.append(" WHERE D.RED_ENVELOPE_ID = #{redId} AND OBJECT_TYPE = '1'");

		sql.append(" ORDER BY C.PRODUCT_CATEGORY_ID DESC");
		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	@SuppressWarnings("unchecked")
	public static String insert(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("INSERT INTO " + DBConstOfCategory.TN_DISCOUNT_RED_R_OBJECT);
		sql.append(" (RED_ENVELOPE_ID,OBJECT_TYPE,OBJECT_ID)");
		sql.append(" VALUES ");
		List<RedRCategoryBean> list = (List<RedRCategoryBean>) parameter.get("list");
		if (list != null) {
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					sql.append(" (#{list[" + i + "].redId},'1',#{list[" + i + "].productCategoryId}),");
				}
			}
		}
		sql.deleteCharAt(sql.length() - 1);

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}

	@SuppressWarnings("unchecked")
	public static String del(Map<String, Object> parameter) {
		// 参数校验
		log.debug("parameter ==> " + parameter.toString());
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("delete FROM  " + DBConstOfCategory.TN_DISCOUNT_RED_R_OBJECT);
		sql.append(" WHERE OBJECT_TYPE = '1' ");
		if (parameter.containsKey("ids")) {
			sql.append(" AND ID in (");
			List<Long> ids = (List<Long>) parameter.get("ids");
			if (ids != null) {
				if (ids.size() > 0) {
					for (int i = 0; i < ids.size(); i++) {
						sql.append(" #{ids[" + i + "]},");
					}
				}
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" )");
		}

		if (parameter.containsKey("redIds")) {
			sql.append(" AND RED_ENVELOPE_ID in (");
			List<Long> redIds = (List<Long>) parameter.get("redIds");
			if (redIds != null) {
				if (redIds.size() > 0) {
					for (int i = 0; i < redIds.size(); i++) {
						sql.append(" #{redIds[" + i + "]},");
					}
				}
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" )");
		}
		if (parameter.containsKey("redId") && parameter.containsKey("productCategoryIds")) {
			sql.append(" AND RED_ENVELOPE_ID = #{redId}");
			sql.append(" and OBJECT_ID in (");
			List<Long> productCategoryIds = (List<Long>) parameter.get("productCategoryIds");
			if (productCategoryIds != null) {
				if (productCategoryIds.size() > 0) {
					for (int i = 0; i < productCategoryIds.size(); i++) {
						sql.append(" #{productCategoryIds[" + i + "]},");
					}
				}
			}
			sql.deleteCharAt(sql.length() - 1);
			sql.append(" )");
		}

		log.debug("SQL ==> " + sql.toString());
		return sql.toString();
	}
}
