package cn.faury.fwmf.module.service.category.sqlProvider;

import cn.faury.fwmf.module.api.category.bean.SystemTagBean;
import cn.faury.fwmf.module.service.constant.DBConstOfCategory;
import org.apache.ibatis.jdbc.SqlBuilder;

import java.util.List;
import java.util.Map;

/**
 * 业务系统标签授权SQL
 */
public class SystemTagSqlProvider {

    /**
     * 根据系统code获取指定标签授权信息
     */
    public static String getSystemTagInfoByCondition(final Map<String, Object> parameter) {
        SqlBuilder.BEGIN();
        SqlBuilder
                .SELECT("SYS.SYSTEM_ID AS systemId,TRS.TAG_PRODUCT_ID AS tagProductId," +
                        "	SYS.`SYSTEM_CODE` AS systemCode,	SYS.`SYSTEM_NAME` AS systemName," +
                        "	TAG_PRODUCT_NAME AS tagProductName,	TAG_PRODUCT_TYPE AS tagProductType," +
                        "	PARENT_ID AS parentId,XPATH,IS_LEAF as isLeaf ");
        SqlBuilder.FROM(DBConstOfCategory.TN_PRODUCT_TAG_R_SYSTEM + " TRS");
        SqlBuilder.JOIN(DBConstOfCategory.TN_SYSTEM_INFO + " SYS ON SYS.SYSTEM_ID = TRS.SYSTEM_ID ");
        SqlBuilder.JOIN(DBConstOfCategory.TN_PRODUCT_TAG + " TAG ON TAG.TAG_PRODUCT_ID = TRS.TAG_PRODUCT_ID ");
        if (parameter != null && parameter.size() > 0) {
            // 系统code
            if (parameter.containsKey("systemCode")) {
                SqlBuilder.WHERE(" SYS.`SYSTEM_CODE` = #{systemCode} ");
            }
            // 系统Id
            if (parameter.containsKey("systemId")) {
                SqlBuilder.WHERE(" SYS.`SYSTEM_ID` = #{systemId} ");
            }
            // 标签Id
            if (parameter.containsKey("tagId")) {
                SqlBuilder.WHERE(" TRS.`TAG_PRODUCT_ID` = #{tagId} ");
            }
            SqlBuilder.ORDER_BY(" TAG.`TAG_PRODUCT_ID`");
        }
        return SqlBuilder.SQL();
    }

    /**
     * 保存标签授权信息
     *
     * @param parameter
     * @return
     */
    public static String saveSystemTagInfo(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter != null && parameter.size() > 0) {
            @SuppressWarnings("unchecked")
            List<SystemTagBean> tagList = (List<SystemTagBean>) parameter.get("tagList");
            if (tagList.size() > 0 && null != tagList) {
                sql.append("INSERT INTO ");
                sql.append(DBConstOfCategory.TN_PRODUCT_TAG_R_SYSTEM);
                sql.append("(SYSTEM_ID,IS_LEAF,TAG_PRODUCT_ID) VALUES ");
                for (int i = 0; i < tagList.size(); i++) {
                    List<Long> tagIds = tagList.get(i).getTagIds();
                    if (null != tagIds && tagIds.size() > 0) {
                        for (int j = 0; j < tagIds.size(); j++) {
                            sql.append("(#{systemId},#{tagList[" + i + "].isLeaf},#{tagList[" + i + "].tagIds[" + j
                                    + "]}),");
                        }
                    }
                }
                sql.deleteCharAt(sql.length() - 1);
            }
        }
        return sql.toString();
    }

    /**
     * 删除标签授权
     */
    public static String deleteSystemTagInfo(final Map<String, Object> parameter) {
        StringBuffer sql = new StringBuffer(128);
        if (parameter != null && parameter.size() > 0) {
            sql.append(" DELETE FROM ");
            sql.append(DBConstOfCategory.TN_PRODUCT_TAG_R_SYSTEM);
            sql.append(" WHERE SYSTEM_ID = #{systemId} ");
        }
        return sql.toString();

    }
}
