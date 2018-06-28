package cn.faury.fwmf.module.service.category.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.category.bean.SystemCategoryBean;
import cn.faury.fwmf.module.service.constant.DBConstOfCategory;
import org.apache.ibatis.jdbc.SqlBuilder;

import java.util.List;
import java.util.Map;

/**
 * 业务系统分类授权SQL
 */
public class SystemCategorySqlProvider {

    /**
     * 根据系统code获取分类信息
     *
     * @return
     */
    public static String getSysCategoryAllByCondition(final Map<String, Object> parameter) {
        SqlBuilder.BEGIN();
        SqlBuilder
                .SELECT("SYS.SYSTEM_ID AS systemId,	CRS.PRODUCT_CATEGORY_ID AS productCategoryId,	" +
                        "SYS.`SYSTEM_CODE` AS systemCode,	SYS.`SYSTEM_NAME` AS systemName,	" +
                        "CATE.PRODUCT_CATEGORY_NAME AS productCategoryName,	DISPLAY_ORDER AS displayOrder,"
                        + "PARENT_ID AS parentId,	CRS.TEMPLATE_ID AS templateId,	CREATE_PERSON_NAME createPersonName," +
                        "	CREATE_TIME AS createTime,	UPDATE_PERSON_NAME AS updatePersonName,	" +
                        "UPDATE_TIME AS updateTime,	DEL_FLAG AS delFlag,XPATH AS xpath, CRS.IS_LEAF as isLeaf ");
        SqlBuilder.FROM(DBConstOfCategory.TN_PRODUCT_CATEGORY_R_SYSTEM + " CRS ");
        SqlBuilder.JOIN(DBConstOfCategory.TN_SYSTEM_INFO + " SYS ON SYS.SYSTEM_D = SYSTEM_ID ");
        SqlBuilder.JOIN(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO
                + " CATE  ON CATE.PRODUCT_CATEGORY_ID = CRS.PRODUCT_CATEGORY_ID  ");
        if (parameter != null && parameter.size() > 0) {
            if (parameter.containsKey("systemId")) {
                SqlBuilder.WHERE("SYS.`SYSTEM_ID` = #{systemId}");
            }
            if (parameter.containsKey("systemCode")) {
                SqlBuilder.WHERE("SYS.`SYSTEM_CODE` = #{systemCode}");
            }
            if (parameter.containsKey("productCategoryId")) {
                SqlBuilder.AND();
                SqlBuilder.WHERE(" CATE.PRODUCT_CATEGORY_ID = #{productCategoryId}");
            }
        }
        SqlBuilder.ORDER_BY(" CATE.PARENT_ID,DISPLAY_ORDER ");
        return SqlBuilder.SQL();
    }

    /**
     * 获取已经授权分类信息以及父节点
     *
     * @param parameter
     * @return
     */
    public static String getSysCategoryAll(final Map<String, Object> parameter) {
        @SuppressWarnings("unchecked")
        List<String> parentIds = (List<String>) parameter.get("parentIds");
        int size = parentIds.size();
        String[] holders = new String[size];
        for (int i = 0; i < size; i++) {
            holders[i] = "#{parentIds[" + i + "]}";
        }
        SqlBuilder.BEGIN();
        SqlBuilder
                .SELECT("SYS.SYSTEM_ID AS systemId,CRS.PRODUCT_CATEGORY_ID AS productCategoryId,SYS.`SYSTEM_CODE` AS systemCode,	SYS.`SYSTEM_NAME` AS systemName,	CATE.PRODUCT_CATEGORY_NAME AS productCategoryName,	DISPLAY_ORDER AS displayOrder,"
                        + "PARENT_ID AS parentId,CRS.TEMPLATE_ID AS templateId,	CREATE_PERSON_NAME createPersonName,	CREATE_TIME AS createTime,	UPDATE_PERSON_NAME AS updatePersonName,	UPDATE_TIME AS updateTime,	DEL_FLAG AS delFlag,XPATH AS xpath");
        SqlBuilder.FROM(DBConstOfCategory.TN_PRODUCT_CATEGORY_R_SYSTEM + " CRS ");
        SqlBuilder.JOIN(DBConstOfCategory.TN_SYSTEM_INFO + " SYS ON SYS.SYSTEM_ID = SYSTEM_ID ");
        SqlBuilder.JOIN(DBConstOfCategory.TN_PRODUCT_CATEGORY_INFO
                + " CATE  ON CATE.PRODUCT_CATEGORY_ID = CRS.PRODUCT_CATEGORY_ID ");
        SqlBuilder.WHERE(String.format(" PARENT_ID IN(%s)", StringUtil.join(holders, ",")));
        return SqlBuilder.SQL();
    }

    /**
     * 保存分类授权信息
     *
     * @param parameter
     * @return
     */
    public static String saveSystemCategoryInfo(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter != null && parameter.size() > 0) {
            sql.append("INSERT INTO ");
            sql.append(DBConstOfCategory.TN_PRODUCT_CATEGORY_R_SYSTEM);
            sql.append("(SYSTEM_ID,PRODUCT_CATEGORY_ID) VALUES ");
            @SuppressWarnings("unchecked")
            List<Long> categoryIds = (List<Long>) parameter.get("categoryIds");
            if (categoryIds.size() > 0) {
                for (int i = 0; i < categoryIds.size(); i++) {
                    sql.append("(#{systemId},#{categoryIds[" + i + "]}),");
                }
            }
            sql.deleteCharAt(sql.length() - 1);
        }
        return sql.toString();
    }

    /**
     * 保存系统商品分类授权
     *
     * @param parameter 多个系统商品分类授权实体Bean
     *                        <p>
     *                        <pre>
     *                                                          	systemId:业务系统ID
     *                                               			isLeaf：是否叶子节点 是：1 否：0
     *                                               				categoryIds：分类Id集合
     *                                               </pre>
     * @return 保存成功的记录数
     */
    public static String saveSystemCategoryInfoForList(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter!=null&& parameter.size()>0) {
            @SuppressWarnings("unchecked")
            List<SystemCategoryBean> cate = (List<SystemCategoryBean>) parameter.get("sysCategoryList");
            if (cate.size() > 0 && null != cate) {
                sql.append("INSERT INTO ");
                sql.append(DBConstOfCategory.TN_PRODUCT_CATEGORY_R_SYSTEM);
                sql.append("(SYSTEM_ID,IS_LEAF,PRODUCT_CATEGORY_ID,TEMPLATE_ID) VALUES ");
                for (int i = 0; i < cate.size(); i++) {
                    sql.append("(#{systemId},#{sysCategoryList[" + i + "].isLeaf},#{sysCategoryList[" + i
                            + "].productCategoryId},#{sysCategoryList[" + i + "].templateId}),");
                }
            }
            sql.deleteCharAt(sql.length() - 1);
        }
        return sql.toString();
    }

    /**
     * 删除分类授权
     *
     * @param parameter
     * @return
     */
    public static String deleteSystemCategoryInfo(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter!=null&& parameter.size()>0) {
            sql.append(" DELETE FROM ");
            sql.append(DBConstOfCategory.TN_PRODUCT_CATEGORY_R_SYSTEM);
            sql.append(" WHERE SYSTEM_ID = #{systemId } AND TEMPLATE_ID = #{templateId} ");
        }
        return sql.toString();

    }
}
