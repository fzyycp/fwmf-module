package cn.faury.fwmf.module.service.category.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.category.bean.TagGroupInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagValueInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfCategory;
import org.apache.ibatis.jdbc.SqlBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分类标签Mapper
 */
public class CategoryTagSQLProvider {

	/**
	 * 根据分类ID、标签组ID获取分类标签下标签组所拥有的标签值列表
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【必填】Long categoryId 分类ID
	 * 【必填】List&lt;Long&gt; tagProductId 标签组ID
	 * 【可选】Boolean isCategoryDelete 分类是否删除【true:是 false：否 null：全部】
	 * </pre>
	 * 
	 * @param parameters
	 *            参数列表
	 * @return SQL语句
	 */
	public static String getTagValueInfoByGroupId(final Map<String, Object> parameters) {
		// 参数校验
		if (parameters == null || parameters.size() <= 0) {
			return null;
		}
		if (false == parameters.containsKey("categoryId")) {
			return null;
		}
		if (false == parameters.containsKey("tagProductId")) {
			return null;
		}
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT R.PRODUCT_CATEGORY_ID, T.TAG_PRODUCT_ID, T.TAG_PRODUCT_NAME, T.TAG_PRODUCT_TYPE, T.PARENT_ID, T.XPATH ");
		sql.append("  FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG).append(" T, ");
		sql.append(DBConstOfCategory.TN_PRODUCT_CATEGORY_R_TAG).append(" R,");
		sql.append(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO).append(" C ");
		sql.append(" WHERE T.TAG_PRODUCT_TYPE = '").append(TagValueInfoBean.TAG_TYPE_VALUE).append("' ");
		sql.append("   AND T.TAG_PRODUCT_ID = R.TAG_ID ");
		sql.append("   AND R.PRODUCT_CATEGORY_ID = C.PRODUCT_CATEGORY_ID ");
		// 分类参数
		if (parameters.get("categoryId") != null) {
			sql.append("   AND R.PRODUCT_CATEGORY_ID IN ( ");
			List<?> categoryId = (List<?>) parameters.get("categoryId");
			for (int i = 0; i < categoryId.size(); i++) {
				sql.append("#{categoryId[" + i + "]}");
				if (i != categoryId.size() - 1) {
					sql.append(",");
				}
			}
			sql.append("       ) ");
		}
		// 标签组参数
		if (parameters.get("tagProductId") != null) {
			sql.append("   AND R.TAG_CATEGORY_ID IN (");
			List<?> tagProductId = (List<?>) parameters.get("tagProductId");
			for (int i = 0; i < tagProductId.size(); i++) {
				sql.append("#{tagProductId[" + i + "]}");
				if (i != tagProductId.size() - 1) {
					sql.append(",");
				}
			}
			sql.append("       ) ");
		}
		if (parameters.containsKey("isCategoryDelete") && parameters.get("isCategoryDelete") != null) {
			Boolean isCategoryDelete = (Boolean) parameters.get("isCategoryDelete");
			sql.append(" AND C.DEL_FLAG = '").append(isCategoryDelete.booleanValue() ? "Y" : "N").append("' ");
		}
		sql.append(" ORDER BY R.PRODUCT_CATEGORY_ID,T.PARENT_ID ASC,T.TAG_PRODUCT_ID ASC");
		return sql.toString();
	}

	/**
	 * 根据分类ID获取分类标签下所拥有的标签组列表
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【必填】Long categoryId 分类ID
	 * 【可选】Boolean isCategoryDelete 分类是否删除【true:是 false：否 null：全部】
	 * </pre>
	 * 
	 * @param parameters
	 *            参数列表
	 * @return SQL语句
	 */
	public static String getTagGroupListByCategoryId(final Map<String, Object> parameters) {
		// 参数校验
		if (parameters == null || parameters.size() <= 0) {
			return null;
		}
		if (false == parameters.containsKey("categoryId")) {
			return null;
		}
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT DISTINCT R.PRODUCT_CATEGORY_ID, T.TAG_PRODUCT_ID, T.TAG_PRODUCT_NAME, T.TAG_PRODUCT_TYPE, T.PARENT_ID, T.XPATH ");
		sql.append("  FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG).append(" T, ");
		sql.append(DBConstOfCategory.TN_PRODUCT_CATEGORY_R_TAG).append(" R,");
		sql.append(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO).append(" C ");
		sql.append(" WHERE T.TAG_PRODUCT_TYPE = '").append(TagGroupInfoBean.TAG_TYPE_GROUP).append("' ");
		sql.append("   AND T.TAG_PRODUCT_ID = R.TAG_CATEGORY_ID ");
		sql.append("   AND R.PRODUCT_CATEGORY_ID = C.PRODUCT_CATEGORY_ID ");
		sql.append("   AND R.PRODUCT_CATEGORY_ID IN ( ");
		List<?> categoryId = (List<?>) parameters.get("categoryId");
		for (int i = 0; i < categoryId.size(); i++) {
			sql.append("#{categoryId[" + i + "]}");
			if (i != categoryId.size() - 1) {
				sql.append(",");
			}
		}
		sql.append("   ) ");

		if (parameters.containsKey("isCategoryDelete") && parameters.get("isCategoryDelete") != null) {
			Boolean isCategoryDelete = (Boolean) parameters.get("isCategoryDelete");
			sql.append("      AND C.DEL_FLAG = '");
			sql.append(isCategoryDelete.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ORDER BY R.PRODUCT_CATEGORY_ID,T.PARENT_ID ASC,T.TAG_PRODUCT_ID ASC");
		return sql.toString();
	}

	/**
	 * 插入分类标签信息
	 *
	 * @param parameters
	 *            参数列表
	 * @return SQL语句
	 */
	public static String insertCategoryTagInfo(final Map<String, Object> parameters) {
		@SuppressWarnings("unchecked")
        List<Long[]> tagsId = (List<Long[]>) parameters.get("tagsId");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ").append(DBConstOfCategory.TN_PRODUCT_CATEGORY_R_TAG);
		sql.append("(PRODUCT_CATEGORY_ID, TAG_CATEGORY_ID, TAG_ID) VALUES ");
		List<String> values = new ArrayList<>();
		for (int i = 0; i < tagsId.size(); i++) {
			values.add(String.format("(#{categoryId}, #{tagsId[%d].groupId}, #{tagsId[%d].valueId})", i, i));
		}
		sql.append(StringUtil.join(values, ","));

		return sql.toString();
	}

	/**
	 * 删除分类标签信息
	 *
	 * @param parameters
	 *            参数列表
	 * @return SQL语句
	 */
	public static String deleteCategoryTagInfo(final Map<String, Object> parameters) {
		@SuppressWarnings("unchecked")
        List<Long> paramList = (List<Long>) parameters.get("list");
		int size = paramList.size();
		String[] holders = new String[size];
		for (int i = 0; i < size; i++) {
			holders[i] = "#{list[" + i + "]}";
		}

		SqlBuilder.BEGIN();
		SqlBuilder.DELETE_FROM(DBConstOfCategory.TN_PRODUCT_CATEGORY_R_TAG);
		SqlBuilder.WHERE(String.format("PRODUCT_CATEGORY_ID IN (%s)", StringUtil.join(holders, ",")));
		return SqlBuilder.SQL();
	}

	public static String queryTagInfoByCategoryId(Map<String, Object> parameter) {
		// 参数校验
		if (parameter == null || parameter.size() <= 0) {
			return null;
		}
		if (!parameter.containsKey("categoryId")) {
			return null;
		}
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT DISTINCT R.PRODUCT_CATEGORY_ID productCategoryId, T.TAG_PRODUCT_ID tagProductId, T.TAG_PRODUCT_NAME tagProductName, T.TAG_PRODUCT_TYPE tagProductType, T.PARENT_ID parentId, T.XPATH xpath ");
		sql.append("  FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG).append(" T ");
		sql.append(" JOIN " + DBConstOfCategory.TN_PRODUCT_CATEGORY_R_TAG).append(" R ON T.TAG_PRODUCT_ID = R.TAG_ID ");
		sql.append(" JOIN " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO).append(
		        " C ON R.PRODUCT_CATEGORY_ID = C.PRODUCT_CATEGORY_ID ");
		if (parameter.containsKey("systemCode")) {
			sql.append(" JOIN " + DBConstOfCategory.TN_PRODUCT_CATEGORY_R_SYSTEM
			        + " CS ON C.PRODUCT_CATEGORY_ID = CS.PRODUCT_CATEGORY_ID");
		}
		sql.append(" WHERE ");
		sql.append(" R.PRODUCT_CATEGORY_ID IN ( ");
		List<?> categoryId = (List<?>) parameter.get("categoryId");
		for (int i = 0; i < categoryId.size(); i++) {
			sql.append("#{categoryId[" + i + "]}");
			if (i != categoryId.size() - 1) {
				sql.append(",");
			}
		}
		sql.append("   ) ");
		if (parameter.containsKey("templateId")) {
			sql.append(" AND C.TEMPLATE_ID & #{templateId}");
		}
		if (parameter.containsKey("systemCode")) {
			sql.append(" AND CS.SYSTEM_ID IN (SELECT SYSTEM_ID FROM " + DBConstOfCategory.TN_SYSTEM_INFO
			        + " WHERE SYSTEM_CODE = #{systemCode} )");
		}
		if (parameter.containsKey("isCategoryDelete") && parameter.get("isCategoryDelete") != null) {
			Boolean isCategoryDelete = (Boolean) parameter.get("isCategoryDelete");
			sql.append("   AND C.DEL_FLAG = '");
			sql.append(isCategoryDelete.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}

		sql.append(" ORDER BY R.PRODUCT_CATEGORY_ID,T.PARENT_ID ASC,T.TAG_PRODUCT_ID ASC");
		return sql.toString();
	}

}
