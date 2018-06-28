package cn.faury.fwmf.module.service.category.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.service.constant.DBConstOfCategory;
import org.apache.ibatis.jdbc.SqlBuilder;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 分类MapperSQL工厂
 */
public class CategorySQLProvider {

    /**
     * 根据多个分类ID获取分类信息对象
     * <p/>
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【必填】List&lt;Long&gt; categoryId 分类ID
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getCategoryInfoByCategoryId(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("categoryId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT PRODUCT_CATEGORY_ID, PRODUCT_CATEGORY_NAME, DISPLAY_ORDER, PARENT_ID, TEMPLATE_ID, CREATE_PERSON_NAME, CREATE_TIME, UPDATE_PERSON_NAME, UPDATE_TIME, DEL_FLAG,XPATH ");
        sql.append("  FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        sql.append(" WHERE PRODUCT_CATEGORY_ID IN (");
        List<?> categoryId = (List<?>) parameters.get("categoryId");
        for (int i = 0; i < categoryId.size(); i++) {
            sql.append("#{categoryId[" + i + "]}");
            if (i != categoryId.size() - 1) {
                sql.append(",");
            }
        }
        sql.append(")");

        if (parameters.containsKey("isDeleteFlag") && parameters.get("isDeleteFlag") != null) {
            Boolean isDeleteFlag = (Boolean) parameters.get("isDeleteFlag");
            sql.append(" AND DEL_FLAG = '");
            sql.append(isDeleteFlag.booleanValue() ? "1" : "0");
            sql.append("' ");
        }
        sql.append(" ORDER BY PARENT_ID ASC,DISPLAY_ORDER ASC,UPDATE_TIME DESC");
        return sql.toString();
    }

    /**
     * 根据分类ID获取第一层子分类信息列表
     * <p/>
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一层</i></b>子分类；
     * 分类以<b><i>List</i></b>的形式返回；
     *
     * 可能出现的参数：
     * 【必填】Long categoryId 分类ID
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getCategoryOneChildListByCategoryId(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("categoryId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT PRODUCT_CATEGORY_ID, PRODUCT_CATEGORY_NAME, DISPLAY_ORDER, PARENT_ID, TEMPLATE_ID, CREATE_PERSON_NAME, CREATE_TIME, UPDATE_PERSON_NAME, UPDATE_TIME, DEL_FLAG,XPATH ");
        sql.append("  FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        sql.append(" WHERE PARENT_ID = #{categoryId,jdbcType=BIGINT}");
        if (parameters.containsKey("isDeleteFlag") && parameters.get("isDeleteFlag") != null) {
            Boolean isDeleteFlag = (Boolean) parameters.get("isDeleteFlag");
            sql.append(" AND DEL_FLAG = '");
            sql.append(isDeleteFlag.booleanValue() ? "1" : "0");
            sql.append("' ");
        }
        sql.append(" ORDER BY PARENT_ID ASC,DISPLAY_ORDER ASC,UPDATE_TIME DESC");
        return sql.toString();
    }

    /**
     * 根据分类ID获取第一、二层子分类信息列表
     * <p/>
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一、二层</i></b>子分类；
     * 分类以<b><i>List</i></b>的形式返回；
     *
     * 可能出现的参数：
     * 【必填】Long categoryId 分类ID
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getCategoryTwoChildListByCategoryId(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("categoryId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT PRODUCT_CATEGORY_ID, PRODUCT_CATEGORY_NAME, DISPLAY_ORDER, PARENT_ID, TEMPLATE_ID, CREATE_PERSON_NAME, CREATE_TIME, UPDATE_PERSON_NAME, UPDATE_TIME, DEL_FLAG,XPATH ");
        sql.append("  FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        sql.append(" WHERE (PARENT_ID = #{categoryId,jdbcType=BIGINT} OR PARENT_ID IN(");
        sql.append("       SELECT PRODUCT_CATEGORY_ID ");
        sql.append("         FROM ").append(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        sql.append("        WHERE PARENT_ID = #{categoryId,jdbcType=BIGINT}))");
        if (parameters.containsKey("isDeleteFlag") && parameters.get("isDeleteFlag") != null) {
            Boolean isDeleteFlag = (Boolean) parameters.get("isDeleteFlag");
            sql.append(" AND DEL_FLAG = '");
            sql.append(isDeleteFlag.booleanValue() ? "1" : "0");
            sql.append("' ");
        }
        sql.append(" ORDER BY PARENT_ID ASC,DISPLAY_ORDER ASC,UPDATE_TIME DESC");
        return sql.toString();
    }

    /**
     * 根据分类ID获取所有子分类信息列表
     * <p/>
     * <p>
     * <pre>
     * 获取分类ID下<b><i>所有级联</i></b>子分类；
     * 分类以<b><i>List</i></b>的形式返回；
     *
     * 可能出现的参数：
     * 【必填】Long categoryId 分类ID
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getCategoryAllChildListByCategoryId(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("categoryId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT PRODUCT_CATEGORY_ID, PRODUCT_CATEGORY_NAME, DISPLAY_ORDER, PARENT_ID, TEMPLATE_ID, CREATE_PERSON_NAME, CREATE_TIME, UPDATE_PERSON_NAME, UPDATE_TIME, DEL_FLAG,XPATH ");
        sql.append("  FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        boolean hasWhere = false;
        // 非根目录
        if (false == "0".equals(String.valueOf(parameters.get("categoryId")))) {
            hasWhere = true;
            sql.append(" WHERE XPATH LIKE (");
            sql.append(" 	SELECT CONCAT(XPATH,'/',PRODUCT_CATEGORY_ID,'%') ");
            sql.append("      FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
            sql.append("     WHERE PRODUCT_CATEGORY_ID =  #{categoryId,jdbcType=BIGINT}) ");
        }
        if (parameters.containsKey("isDeleteFlag") && parameters.get("isDeleteFlag") != null) {
            Boolean isDeleteFlag = (Boolean) parameters.get("isDeleteFlag");
            if (hasWhere) {
                sql.append(" AND DEL_FLAG = '");
            } else {
                sql.append(" WHERE DEL_FLAG = '");
            }
            sql.append(isDeleteFlag.booleanValue() ? "1" : "0");
            sql.append("' ");
        }
        sql.append(" ORDER BY PARENT_ID ASC,DISPLAY_ORDER ASC,UPDATE_TIME DESC");
        return sql.toString();
    }

    /**
     * 根据分类ID获取子分类信息列表
     * <p/>
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一层</i></b>子分类；
     * 分类以<b><i>List</i></b>的形式返回；
     *
     * 可能出现的参数：
     * 【必填】Long categoryId 分类ID
     * 【非必填】String categoryName 分类名称
     * 【非必填】String categoryState 分类状态
     * </pre>
     *
     * @param parameter 参数列表
     * @return SQL语句
     */
    public static String getCategoryOneChildListByCategoryIdWithSelf(final Map<String, Object> parameter) {
        /*
         * SqlBuilder.BEGIN(); SqlBuilder.SELECT(
		 * "PRODUCT_CATEGORY_ID, PRODUCT_CATEGORY_NAME, DISPLAY_ORDER, PARENT_ID, TEMPLATE_ID, "
		 * +
		 * "CREATE_PERSON_NAME, CREATE_TIME, UPDATE_PERSON_NAME, UPDATE_TIME, DEL_FLAG, XPATH"
		 * ); SqlBuilder.FROM(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO); if
		 * (parameters.containsKey("categoryName") &&
		 * StringUtil.isNotEmpty(String.valueOf(parameters.get("categoryName")))) {
		 * SqlBuilder
		 * .WHERE("PRODUCT_CATEGORY_NAME LIKE CONCAT('%', #{categoryName}, '%')"
		 * ); } if (parameters.containsKey("categoryState") &&
		 * StringUtil.isNotEmpty(String.valueOf(parameters.get("categoryState"))))
		 * { SqlBuilder.WHERE("DEL_FLAG = #{categoryState}"); }
		 * 
		 * SqlBuilder.AND(); SqlBuilder.WHERE("PARENT_ID = #{categoryId}");
		 * SqlBuilder
		 * .ORDER_BY("PARENT_ID ASC, DISPLAY_ORDER ASC, UPDATE_TIME DESC");
		 * return SqlBuilder.SQL();
		 */

        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT DISTINCT C.PRODUCT_CATEGORY_ID productCategoryId, C.PRODUCT_CATEGORY_NAME productCategoryName, C.DISPLAY_ORDER displayOrder, C.PARENT_ID parentId, C.TEMPLATE_ID templateId, C.CREATE_PERSON_NAME createPersonName, C.CREATE_TIME createTime, C.UPDATE_PERSON_NAME updatePersonName, C.UPDATE_TIME updateTime, C.DEL_FLAG delFlag,C.XPATH xpath");
        sql.append(" FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO + " C");
        sql.append(" WHERE C.PARENT_ID = #{categoryId,jdbcType=BIGINT}");
        if (parameter.containsKey("templateId")) {
            sql.append(" AND C.TEMPLATE_ID & #{templateId}");
        }
        if (parameter.containsKey("categoryName") && StringUtil.isNotEmpty(String.valueOf(parameter.get("categoryName")))) {
            sql.append(" AND C.PRODUCT_CATEGORY_NAME LIKE CONCAT('%', #{categoryName}, '%')");
        }
        if (parameter.containsKey("categoryState")
                && StringUtil.isNotEmpty(String.valueOf(parameter.get("categoryState")))) {
            sql.append(" AND C.DEL_FLAG = #{categoryState}");
        }
        sql.append(" ORDER BY C.PARENT_ID ASC,C.DISPLAY_ORDER ASC,C.UPDATE_TIME DESC");
        return sql.toString();
    }

    /**
     * 获取全部分类信息
     * <p>
     * <pre>
     * 获取全部分类信息；
     * 分类信息以<b><i>List</i></b>的形式返回；
     *
     * 可能出现的参数：
     * 【非必填】Boolean isDeleteFlag 是否删除
     * </pre>
     *
     * @param categoryState 参数列表
     * @return SQL语句
     */
    public static String getAllCategory(String categoryState) {
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("PRODUCT_CATEGORY_ID, PRODUCT_CATEGORY_NAME, DISPLAY_ORDER, PARENT_ID, TEMPLATE_ID, "
                + "CREATE_PERSON_NAME, CREATE_TIME, UPDATE_PERSON_NAME, UPDATE_TIME, DEL_FLAG, XPATH");
        SqlBuilder.FROM(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        if (StringUtil.isNotEmpty(categoryState)) {
            SqlBuilder.WHERE("DEL_FLAG = #{_parameter}");
        }
        return SqlBuilder.SQL();
    }

    /**
     * 检查分类名称是否重复
     *
     * @return SQL语句
     */
    public static String checkCategoryName() {
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("COUNT(0)");
        SqlBuilder.FROM(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        SqlBuilder.WHERE("PRODUCT_CATEGORY_NAME = #{productCategoryName}");
        SqlBuilder.WHERE("PRODUCT_CATEGORY_ID <> #{productCategoryId}");
        SqlBuilder.WHERE("PARENT_ID = #{parentId}");
        SqlBuilder.WHERE("DEL_FLAG = '0'");
        return SqlBuilder.SQL();
    }

    /**
     * 检查是否含有子节点
     */
    public static String checkHasChildren(Map<String, Object> parameters) {
        // 拼装占位符
        List<Object> paramList = (List<Object>) parameters.get("list");
        StringJoiner joiner = new StringJoiner(",");
        for (int i = 0; i < paramList.size(); i++) {
            joiner.add("#{list[" + i + "]}");
        }
        return "SELECT COUNT(0) " +
                "  FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO +
                " WHERE DEL_FLAG = '0' AND " + String.format("PARENT_ID IN (%s)", joiner.toString());
    }

    /**
     * 生成显示顺序
     *
     * @return SQL语句
     */
    public static String genDisplayOrder() {
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("IFNULL(MAX(DISPLAY_ORDER) + 1, 1)");
        SqlBuilder.FROM(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        SqlBuilder.WHERE("PARENT_ID = #{parentId}");
        SqlBuilder.WHERE("PRODUCT_CATEGORY_ID <> #{categoryId}");
        SqlBuilder.WHERE("DEL_FLAG = '0'");
        return SqlBuilder.SQL();
    }

    /**
     * 新增分类信息
     *
     * @return SQL语句
     */
    public static String insertCategoryInfo() {
        SqlBuilder.BEGIN();
        SqlBuilder.INSERT_INTO(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        SqlBuilder.VALUES("PRODUCT_CATEGORY_NAME, DISPLAY_ORDER, PARENT_ID, TEMPLATE_ID, CREATE_PERSON_NAME, "
                        + "CREATE_TIME, UPDATE_PERSON_NAME, UPDATE_TIME, DEL_FLAG, XPATH",
                "#{productCategoryName}, #{displayOrder}, #{parentId}, #{templateId}, #{createPersonName}, "
                        + "#{createTime}, #{updatePersonName}, #{updateTime}, '0', #{xpath}");
        return SqlBuilder.SQL();
    }

    /**
     * 修改分类信息
     *
     * @return SQL语句
     */
    public static String updateCategoryInfo() {
        SqlBuilder.BEGIN();
        SqlBuilder.UPDATE(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        SqlBuilder.SET("PRODUCT_CATEGORY_NAME = #{productCategoryName}");
        SqlBuilder.SET("DISPLAY_ORDER = #{displayOrder}");
        SqlBuilder.SET("PARENT_ID = #{parentId}");
        SqlBuilder.SET("TEMPLATE_ID = #{templateId}");
        SqlBuilder.SET("UPDATE_PERSON_NAME = #{updatePersonName}");
        SqlBuilder.SET("UPDATE_TIME = #{updateTime}");
        SqlBuilder.SET("XPATH = #{xpath}");
        SqlBuilder.WHERE("PRODUCT_CATEGORY_ID = #{productCategoryId}");
        return SqlBuilder.SQL();
    }

    /**
     * 删除分类信息
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String deleteCategoryInfo(final Map<String, Object> parameters) {
        // 拼装占位符
        @SuppressWarnings("unchecked")
        List<Object> paramList = (List<Object>) parameters.get("list");
        StringJoiner joiner = new StringJoiner(",");
        for (int i = 0; i < paramList.size(); i++) {
            joiner.add("#{list[" + i + "]}");
        }

        SqlBuilder.BEGIN();
        SqlBuilder.UPDATE(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        SqlBuilder.SET("DEL_FLAG = '1'");
        SqlBuilder.WHERE(String.format("PRODUCT_CATEGORY_ID IN (%s)", joiner.toString()));

        return SqlBuilder.SQL();
    }

    public static String queryCategoryOneChildListByCategoryId(final Map<String, Object> parameter) {
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT DISTINCT C.PRODUCT_CATEGORY_ID productCategoryId, C.PRODUCT_CATEGORY_NAME productCategoryName, C.DISPLAY_ORDER displayOrder, C.PARENT_ID parentId, C.TEMPLATE_ID templateId, C.CREATE_PERSON_NAME createPersonName, C.CREATE_TIME createTime, C.UPDATE_PERSON_NAME updatePersonName, C.UPDATE_TIME updateTime, C.DEL_FLAG delFlag,C.XPATH xpath");
        sql.append(" FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO + " C");
        if (parameter.containsKey("systemCode")) {
            sql.append(" JOIN " + DBConstOfCategory.TN_PRODUCT_CATEGORY_R_SYSTEM
                    + " CS ON C.PRODUCT_CATEGORY_ID = CS.PRODUCT_CATEGORY_ID");
        }
        sql.append(" WHERE C.PARENT_ID = #{categoryId,jdbcType=BIGINT}");
        if (parameter.containsKey("isDeleteFlag") && parameter.get("isDeleteFlag") != null) {
            Boolean isDeleteFlag = (Boolean) parameter.get("isDeleteFlag");
            sql.append(" AND C.DEL_FLAG = '");
            sql.append(isDeleteFlag.booleanValue() ? "1" : "0");
            sql.append("' ");
        }
        if (parameter.containsKey("templateId")) {
            sql.append(" AND C.TEMPLATE_ID & #{templateId}");
        }
        if (parameter.containsKey("systemCode")) {
            sql.append(" AND CS.SYSTEM_ID IN (SELECT SYSTEM_ID FROM " + DBConstOfCategory.TN_SYSTEM_INFO
                    + " WHERE SYSTEM_CODE = #{systemCode} )");
        }
        sql.append(" ORDER BY C.PARENT_ID ASC,C.DISPLAY_ORDER ASC,C.UPDATE_TIME DESC");
        return sql.toString();
    }

    public static String queryCategoryTwoChildListByCategoryId(final Map<String, Object> parameter) {
        // 参数校验
        if (parameter == null || parameter.size() <= 0) {
            return null;
        }
        if (!parameter.containsKey("categoryId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT DISTINCT C.PRODUCT_CATEGORY_ID productCategoryId, C.PRODUCT_CATEGORY_NAME productCategoryName, C.DISPLAY_ORDER displayOrder, C.PARENT_ID parentId, C.TEMPLATE_ID templateId, C.CREATE_PERSON_NAME createPersonName, C.CREATE_TIME createTime, C.UPDATE_PERSON_NAME updatePersonName, C.UPDATE_TIME updateTime, C.DEL_FLAG delFlag,C.XPATH xpath");
        sql.append("  FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO + " C");
        if (parameter.containsKey("systemCode")) {
            sql.append(" JOIN " + DBConstOfCategory.TN_PRODUCT_CATEGORY_R_SYSTEM
                    + " CS ON C.PRODUCT_CATEGORY_ID = CS.PRODUCT_CATEGORY_ID");
        }
        sql.append(" WHERE (C.PARENT_ID = #{categoryId,jdbcType=BIGINT} OR C.PARENT_ID IN(");
        sql.append("       SELECT PRODUCT_CATEGORY_ID ");
        sql.append("         FROM ").append(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
        sql.append("        WHERE PARENT_ID = #{categoryId,jdbcType=BIGINT}");
        if (parameter.containsKey("templateId")) {
            sql.append(" AND TEMPLATE_ID & #{templateId}");
        }
        sql.append(" ))");
        if (parameter.containsKey("isDeleteFlag") && parameter.get("isDeleteFlag") != null) {
            Boolean isDeleteFlag = (Boolean) parameter.get("isDeleteFlag");
            sql.append(" AND C.DEL_FLAG = '");
            sql.append(isDeleteFlag.booleanValue() ? "1" : "0");
            sql.append("' ");
        }

        if (parameter.containsKey("systemCode")) {
            sql.append(" AND CS.SYSTEM_ID IN (SELECT SYSTEM_ID FROM " + DBConstOfCategory.TN_SYSTEM_INFO
                    + " WHERE SYSTEM_CODE = #{systemCode} )");
            if (parameter.containsKey("templateId")) {
                sql.append(" AND CS.TEMPLATE_ID & #{templateId}");
            }
        } else {
            if (parameter.containsKey("templateId")) {
                sql.append(" AND C.TEMPLATE_ID & #{templateId}");
            }
        }
        sql.append(" ORDER BY C.PARENT_ID ASC,C.DISPLAY_ORDER ASC,C.UPDATE_TIME DESC");
        return sql.toString();
    }

    public static String queryCategoryAllChildListByCategoryId(final Map<String, Object> parameter) {
        // 参数校验
        if (parameter == null || parameter.size() <= 0) {
            return null;
        }
        if (!parameter.containsKey("categoryId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT DISTINCT C.PRODUCT_CATEGORY_ID productCategoryId, C.PRODUCT_CATEGORY_NAME productCategoryName, C.DISPLAY_ORDER displayOrder, C.PARENT_ID parentId, C.TEMPLATE_ID templateId, C.CREATE_PERSON_NAME createPersonName, C.CREATE_TIME createTime, C.UPDATE_PERSON_NAME updatePersonName, C.UPDATE_TIME updateTime, C.DEL_FLAG delFlag,C.XPATH xpath");
        sql.append("  FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO + " C");
        if (parameter.containsKey("systemCode")) {
            sql.append(" JOIN " + DBConstOfCategory.TN_PRODUCT_CATEGORY_R_SYSTEM
                    + " CS ON C.PRODUCT_CATEGORY_ID = CS.PRODUCT_CATEGORY_ID");
        }
        boolean hasWhere = false;
        // 非根目录
        if (!"0".equals(String.valueOf(parameter.get("categoryId")))) {
            hasWhere = true;
            sql.append(" WHERE XPATH LIKE (");
            sql.append(" 	SELECT CONCAT(XPATH,'/',PRODUCT_CATEGORY_ID,'%') ");
            sql.append("      FROM " + DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO);
            sql.append("     WHERE PRODUCT_CATEGORY_ID =  #{categoryId,jdbcType=BIGINT}) ");
            hasWhere = true;
        }
        if (parameter.containsKey("isDeleteFlag") && parameter.get("isDeleteFlag") != null) {
            Boolean isDeleteFlag = (Boolean) parameter.get("isDeleteFlag");
            if (hasWhere) {
                sql.append(" AND DEL_FLAG = '");
            } else {
                sql.append(" WHERE DEL_FLAG = '");
            }
            sql.append(isDeleteFlag.booleanValue() ? "1" : "0");
            sql.append("' ");
            hasWhere = true;
        }

        if (parameter.containsKey("systemCode")) {
            if (hasWhere) {
                sql.append(" AND");
            } else {
                sql.append(" WHERE");
            }
            sql.append(" CS.SYSTEM_ID IN (SELECT SYSTEM_ID FROM " + DBConstOfCategory.TN_SYSTEM_INFO
                    + " WHERE SYSTEM_CODE = #{systemCode} )");
            hasWhere = true;
            if (parameter.containsKey("templateId")) {
                if (hasWhere) {
                    sql.append(" AND");
                } else {
                    sql.append(" WHERE");
                }
                sql.append(" CS.TEMPLATE_ID & #{templateId}");
                hasWhere = true;
            }
        } else {
            if (parameter.containsKey("templateId")) {
                if (hasWhere) {
                    sql.append(" AND");
                } else {
                    sql.append(" WHERE");
                }
                sql.append(" C.TEMPLATE_ID & #{templateId}");
                hasWhere = true;
            }
        }
        sql.append(" ORDER BY C.PARENT_ID ASC,C.DISPLAY_ORDER ASC,C.UPDATE_TIME DESC");
        return sql.toString();
    }

}
