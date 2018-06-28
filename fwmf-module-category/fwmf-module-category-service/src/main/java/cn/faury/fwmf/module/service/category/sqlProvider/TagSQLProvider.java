package cn.faury.fwmf.module.service.category.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.category.bean.TagGroupInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagValueInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfCategory;
import org.apache.ibatis.jdbc.SqlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 标签MapperSQL工厂
 */
public class TagSQLProvider {

    /**
     * 日志记录器
     */
    private static Logger log = LoggerFactory.getLogger(TagSQLProvider.class);

    /**
     * 根据多个标签ID获取标签信息对象
     * <p/>
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【必填】List&lt;Long&gt; tagProductId 标签ID
     * 【可选】Boolean isGroup 是否查询标签组【true:只查询标签组 false:只查询标签值 null:查询所有】
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getTagInfoByTagId(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("tagProductId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT TAG_PRODUCT_ID,TAG_PRODUCT_NAME,TAG_PRODUCT_TYPE,PARENT_ID,XPATH ");
        sql.append("  FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG);
        sql.append(" WHERE TAG_PRODUCT_ID IN (");
        List<?> tagProductId = (List<?>) parameters.get("tagProductId");
        for (int i = 0; i < tagProductId.size(); i++) {
            sql.append("#{tagProductId[" + i + "]}");
            if (i != tagProductId.size() - 1) {
                sql.append(",");
            }
        }
        sql.append(")");
        if (parameters.get("isGroup") != null) {
            Boolean isGroup = (Boolean) parameters.get("isGroup");
            sql.append(" AND TAG_PRODUCT_TYPE = '");
            sql.append(isGroup.booleanValue() ? TagGroupInfoBean.TAG_TYPE_GROUP : TagValueInfoBean.TAG_TYPE_VALUE);
            sql.append("' ");
        }
        if (parameters.get("isDelte") != null) {
            Boolean isDelte = (Boolean) parameters.get("isDelte");
            sql.append(" AND DEL_FLAG = '");
            sql.append(isDelte.booleanValue() ? '1' : '0');
            sql.append("' ");
        }
        sql.append(" ORDER BY PARENT_ID ASC,TAG_PRODUCT_ID ASC");
        return sql.toString();
    }

    /**
     * 根据多个标签组ID获取标签值信息对象
     * <p/>
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【必填】List&lt;Long&gt; tagProductId 标签组ID
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getTagValueListByTagId(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("tagProductId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT TAG_PRODUCT_ID,TAG_PRODUCT_NAME,TAG_PRODUCT_TYPE,PARENT_ID,XPATH ");
        sql.append("  FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG);
        sql.append(" WHERE TAG_PRODUCT_TYPE = '02' ");
        if (parameters.get("isDelte") != null) {
            Boolean isDelte = (Boolean) parameters.get("isDelte");
            sql.append(" AND DEL_FLAG = '");
            sql.append(isDelte.booleanValue() ? '1' : '0');
            sql.append("' ");
        }
        sql.append("   AND PARENT_ID IN (");
        List<?> tagProductId = (List<?>) parameters.get("tagProductId");
        for (int i = 0; i < tagProductId.size(); i++) {
            sql.append("#{tagProductId[" + i + "]}");
            if (i != tagProductId.size() - 1) {
                sql.append(",");
            }
        }
        sql.append(")");
        sql.append(" ORDER BY PARENT_ID ASC,TAG_PRODUCT_ID ASC");
        return sql.toString();
    }

    /**
     * 根据分类获取多个标签值列表
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    @SuppressWarnings("unchecked")
    public static String getTagValueListByCategoryId(final Map<String, Object> parameters) {
        // 拼装占位符
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT PT.TAG_PRODUCT_ID,PT.TAG_PRODUCT_NAME,PT.TAG_PRODUCT_TYPE,PT.PARENT_ID,PT.XPATH");
        sql.append(" FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG + " PT");
        sql.append(" JOIN " + DBConstOfCategory.TN_PRODUCT_CATEGORY_R_TAG + " CRT ON PT.TAG_PRODUCT_ID = CRT.TAG_ID");
        sql.append(" WHERE CRT.PRODUCT_CATEGORY_ID IN (");
        List<Object> paramList = (List<Object>) parameters.get("categoryId");
        int size = paramList.size();
        for (int i = 0; i < size; i++) {
            sql.append("#{categoryId[" + i + "]}");
            if (i != size - 1) {
                sql.append(",");
            }
        }
        sql.append(")");
        if (parameters.get("isDelte") != null) {
            Boolean isDelte = (Boolean) parameters.get("isDelte");
            sql.append(" AND PT.DEL_FLAG = '");
            sql.append(isDelte.booleanValue() ? '1' : '0');
            sql.append("' ");
        }
        return sql.toString();
    }

    /**
     * 根据标签ID获取<b>第一层</b>子标签组对象列表
     * <p/>
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【必填】Long tagProductId 标签ID
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getTagGroupOneChildListByTagId(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("tagProductId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT TAG_PRODUCT_ID,TAG_PRODUCT_NAME,TAG_PRODUCT_TYPE,PARENT_ID,XPATH ");
        sql.append("  FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG);
        sql.append(" WHERE TAG_PRODUCT_TYPE = '").append(TagGroupInfoBean.TAG_TYPE_GROUP).append("'");
        sql.append("   AND PARENT_ID = #{tagProductId,jdbcType=BIGINT}");
        if (parameters.get("isDelte") != null) {
            Boolean isDelte = (Boolean) parameters.get("isDelte");
            sql.append(" AND DEL_FLAG = '");
            sql.append(isDelte.booleanValue() ? '1' : '0');
            sql.append("' ");
        }
        sql.append(" ORDER BY PARENT_ID ASC,TAG_PRODUCT_ID ASC");
        return sql.toString();
    }

    /**
     * 根据标签ID获取<b>第一层、第二层</b>子标签组对象列表
     * <p/>
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【必填】Long tagProductId 标签ID
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getTagGroupTwoChildListByTagId(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("tagProductId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT TAG_PRODUCT_ID,TAG_PRODUCT_NAME,TAG_PRODUCT_TYPE,PARENT_ID,XPATH ");
        sql.append("  FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG);
        sql.append(" WHERE TAG_PRODUCT_TYPE = '").append(TagGroupInfoBean.TAG_TYPE_GROUP).append("'");
        sql.append("   AND (   PARENT_ID = #{tagProductId,jdbcType=BIGINT} ");
        sql.append("        OR PARENT_ID IN(");
        sql.append("           SELECT TAG_PRODUCT_ID ");
        sql.append("             FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG);
        sql.append("            WHERE PARENT_ID = #{tagProductId,jdbcType=BIGINT})");
        sql.append("       )");
        if (parameters.get("isDelte") != null) {
            Boolean isDelte = (Boolean) parameters.get("isDelte");
            sql.append(" AND DEL_FLAG = '");
            sql.append(isDelte.booleanValue() ? '1' : '0');
            sql.append("' ");
        }
        sql.append(" ORDER BY PARENT_ID ASC,TAG_PRODUCT_ID ASC");
        return sql.toString();
    }

    /**
     * 根据标签ID获取<b>第一层、第二层</b>子标签组对象列表
     * <p/>
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【必填】Long tagProductId 标签ID
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getTagGroupAllChildListByTagId(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("tagProductId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT TAG_PRODUCT_ID,TAG_PRODUCT_NAME,TAG_PRODUCT_TYPE,PARENT_ID,XPATH ");
        sql.append("  FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG);
        sql.append(" WHERE TAG_PRODUCT_TYPE = '").append(TagGroupInfoBean.TAG_TYPE_GROUP).append("'");

        // 非根目录
        if (false == "0".equals(String.valueOf(parameters.get("tagProductId")))) {
            sql.append(" AND XPATH LIKE (");
            sql.append(" 	SELECT CONCAT(XPATH,'/%') ");
            sql.append("      FROM " + DBConstOfCategory.TN_PRODUCT_TAG);
            sql.append("     WHERE TAG_PRODUCT_ID = #{tagProductId,jdbcType=BIGINT}) ");
        }
        if (parameters.get("isDelte") != null) {
            Boolean isDelte = (Boolean) parameters.get("isDelte");
            sql.append(" AND DEL_FLAG = '");
            sql.append(isDelte.booleanValue() ? '1' : '0');
            sql.append("' ");
        }
        sql.append(" ORDER BY PARENT_ID ASC,TAG_PRODUCT_ID ASC");
        return sql.toString();
    }

    /**
     * 检查标签名称是否有重复
     *
     * @param tagInfoBean 标签信息
     * @return SQL语句
     */
    public static String checkSameName(final TagInfoBean tagInfoBean) {
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("COUNT(0)");
        SqlBuilder.FROM(DBConstOfCategory.TN_PRODUCT_TAG);
        SqlBuilder.WHERE("TAG_PRODUCT_NAME = #{tagProductName}");
        SqlBuilder.WHERE("PARENT_ID = #{parentId}");
        SqlBuilder.WHERE("TAG_PRODUCT_TYPE = #{tagProductType}");
        if (tagInfoBean.getTagProductId() != null) {
            SqlBuilder.WHERE("TAG_PRODUCT_ID <> #{tagProductId}");
        }
        return SqlBuilder.SQL();
    }

    /**
     * 检查指定标签是否有子标签
     *
     * @param parameters SQL参数
     * @return SQL语句
     */
    public static String checkHasChildren(final Map<String, Object> parameters) {
        // 拼装占位符
        @SuppressWarnings("unchecked")
        List<Object> paramList = (List<Object>) parameters.get("tagProductIds");
        int size = paramList.size();
        String[] holders = new String[size];
        for (int i = 0; i < size; i++) {
            holders[i] = "#{tagProductIds[" + i + "]}";
        }
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("COUNT(0)");
        SqlBuilder.FROM(DBConstOfCategory.TN_GOODS_R_TAG);
        SqlBuilder.WHERE(String.format(" TAG_ID IN (%s)", StringUtil.join(holders, ",")));
        return SqlBuilder.SQL();
    }

    /**
     * 检查指定标签是否有商品信息
     *
     * @param parameters SQL参数
     * @return SQL语句
     */
    public static String checkHasCategory(final Map<String, Object> parameters) {
        // 拼装占位符
        @SuppressWarnings("unchecked")
        List<Object> paramList = (List<Object>) parameters.get("tagProductIds");
        int size = paramList.size();
        String[] holders = new String[size];
        for (int i = 0; i < size; i++) {
            holders[i] = "#{tagProductIds[" + i + "]}";
        }
        SqlBuilder.BEGIN();
        SqlBuilder.SELECT("COUNT(1)");
        SqlBuilder.FROM(DBConstOfCategory.TN_PRODUCT_CATEGORY_R_TAG + " a ");
        SqlBuilder.JOIN(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO
                + " b ON  b.PRODUCT_CATEGORY_ID = a.PRODUCT_CATEGORY_ID ");
        SqlBuilder.WHERE(String.format(" a.TAG_ID IN (%s)", StringUtil.join(holders, ",")));
        SqlBuilder.WHERE(" b.DEL_FLAG = 0 ");
        return SqlBuilder.SQL();
    }

    /**
     * 插入商品标签记录
     *
     * @return SQL语句
     */
    public static String insertTagInfo() {
        SqlBuilder.BEGIN();
        SqlBuilder.INSERT_INTO(DBConstOfCategory.TN_PRODUCT_TAG);
        SqlBuilder.VALUES("TAG_PRODUCT_NAME, TAG_PRODUCT_TYPE, PARENT_ID, XPATH,DEL_FLAG",
                "#{tagProductName}, #{tagProductType}, #{parentId}, #{xpath},'0'");
        return SqlBuilder.SQL();
    }

    /**
     * 更新商品标签记录
     *
     * @param tagInfoBean 商品标签信息
     * @return SQL语句
     */
    public static String updateTagInfo(final TagInfoBean tagInfoBean) {

        if (null == tagInfoBean || tagInfoBean.getTagProductId() == null) {
            log.debug("SQL UPDATE TAG_PRODUCT_ID ==> null");
            return null;
        }
        SqlBuilder.BEGIN();
        SqlBuilder.UPDATE(DBConstOfCategory.TN_PRODUCT_TAG);
        SqlBuilder.SET("TAG_PRODUCT_NAME = #{tagProductName}");
        SqlBuilder.WHERE("TAG_PRODUCT_ID = #{tagProductId}");
        return SqlBuilder.SQL();
    }

    /**
     * 删除商品标签记录
     *
     * @param parameters SQL参数
     * @return SQL语句
     */
    public static String deleteTagInfo(final Map<String, Object> parameters) {
        // 拼装占位符
        @SuppressWarnings("unchecked")
        List<Object> paramList = (List<Object>) parameters.get("list");
        int size = paramList.size();
        String[] holders = new String[size];
        for (int i = 0; i < size; i++) {
            holders[i] = "#{list[" + i + "]}";
        }

        SqlBuilder.BEGIN();
        SqlBuilder.UPDATE(DBConstOfCategory.TN_PRODUCT_TAG);
        SqlBuilder.SET("DEL_FLAG = '1' ");
        SqlBuilder.WHERE(String.format("TAG_PRODUCT_ID IN (%s)", StringUtil.join(holders, ",")));
        return SqlBuilder.SQL();
    }

    /**
     * 根据多个标签ID获取标签信息对象
     *
     * @return List<TagInfoBean>
     */
    public static String queryTagInfoByTagProductId(final Map<String, Object> parameter) {
        // 参数校验
        if (parameter == null || parameter.size() <= 0) {
            return null;
        }
        if (!parameter.containsKey("tagProductId")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT T.TAG_PRODUCT_ID tagProductId,T.TAG_PRODUCT_NAME tagProductName,T.TAG_PRODUCT_TYPE tagProductType,T.PARENT_ID parentId,T.XPATH xpath ");
        sql.append("  FROM ").append(DBConstOfCategory.TN_PRODUCT_TAG + " T ");
        if (parameter.containsKey("systemCode")) {
            sql.append(" JOIN " + DBConstOfCategory.TN_PRODUCT_TAG_R_SYSTEM
                    + " S ON T.TAG_PRODUCT_ID = S.TAG_PRODUCT_ID");
        }
        sql.append(" WHERE ");
        List<?> tagProductId = (List<?>) parameter.get("tagProductId");
        for (int i = 0; i < tagProductId.size(); i++) {
            if (i != 0) {
                sql.append(" OR ");
            }
            sql.append(" XPATH LIKE CONCAT('%', #{tagProductId[" + i + "]}, '%')");

        }
        if (parameter.get("isGroup") != null) {
            Boolean isGroup = (Boolean) parameter.get("isGroup");
            sql.append(" AND TAG_PRODUCT_TYPE = '");
            sql.append(isGroup.booleanValue() ? TagGroupInfoBean.TAG_TYPE_GROUP : TagValueInfoBean.TAG_TYPE_VALUE);
            sql.append("' ");
        }
        if (parameter.containsKey("systemCode")) {

            sql.append(" AND S.SYSTEM_ID IN (SELECT SYSTEM_ID FROM " + DBConstOfCategory.TN_SYSTEM_INFO
                    + " WHERE SYSTEM_CODE = #{systemCode} )");
        }
        if (parameter.get("isDelte") != null) {
            Boolean isDelte = (Boolean) parameter.get("isDelte");
            sql.append(" AND T.DEL_FLAG = '");
            sql.append(isDelte.booleanValue() ? '1' : '0');
            sql.append("' ");
        }
        sql.append(" ORDER BY T.PARENT_ID ASC,T.TAG_PRODUCT_ID ASC");
        return sql.toString();
    }
}
