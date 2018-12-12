/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-12-12 08:48:52
 */
package cn.faury.fwmf.module.service.category.generate.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.category.generate.bean.CategoryInfoGenerateBean;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CategoryInfoGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_info
     *
     * @fwmf.generated 2018-12-12 08:48:52
     */
    public String insertSelective(CategoryInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product_t_category_info");
        
        if (record.getProductCategoryId() != null) {
            sql.VALUES("PRODUCT_CATEGORY_ID", "#{productCategoryId,jdbcType=BIGINT}");
        }
        
        if (record.getProductCategoryName() != null) {
            sql.VALUES("PRODUCT_CATEGORY_NAME", "#{productCategoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getDisplayOrder() != null) {
            sql.VALUES("DISPLAY_ORDER", "#{displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            sql.VALUES("PARENT_ID", "#{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getIconPath() != null) {
            sql.VALUES("ICON_PATH", "#{iconPath,jdbcType=VARCHAR}");
        }
        
        if (record.getUsageCode() != null) {
            sql.VALUES("USAGE_CODE", "#{usageCode,jdbcType=INTEGER}");
        }
        
        if (record.getIsDelete() != null) {
            sql.VALUES("IS_DELETE", "#{isDelete,jdbcType=CHAR}");
        }
        
        if (record.getXpath() != null) {
            sql.VALUES("XPATH", "#{xpath,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_info
     *
     * @fwmf.generated 2018-12-12 08:48:52
     */
    public String updateByPrimaryKeySelective(CategoryInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("product_t_category_info");
        
        if (record.getProductCategoryName() != null) {
            sql.SET("PRODUCT_CATEGORY_NAME = #{productCategoryName,jdbcType=VARCHAR}");
        }
        
        if (record.getDisplayOrder() != null) {
            sql.SET("DISPLAY_ORDER = #{displayOrder,jdbcType=INTEGER}");
        }
        
        if (record.getParentId() != null) {
            sql.SET("PARENT_ID = #{parentId,jdbcType=BIGINT}");
        }
        
        if (record.getIconPath() != null) {
            sql.SET("ICON_PATH = #{iconPath,jdbcType=VARCHAR}");
        }
        
        if (record.getUsageCode() != null) {
            sql.SET("USAGE_CODE = #{usageCode,jdbcType=INTEGER}");
        }
        
        if (record.getIsDelete() != null) {
            sql.SET("IS_DELETE = #{isDelete,jdbcType=CHAR}");
        }
        
        if (record.getXpath() != null) {
            sql.SET("XPATH = #{xpath,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("PRODUCT_CATEGORY_ID = #{productCategoryId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_info
     *
     * @fwmf.generated 2018-12-12 08:48:52
     */
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("PRODUCT_CATEGORY_ID, PRODUCT_CATEGORY_NAME, DISPLAY_ORDER, PARENT_ID, ICON_PATH");
        sql.SELECT("USAGE_CODE, IS_DELETE, XPATH");
        
        sql.FROM("product_t_category_info");
        
        if (params.get("productCategoryId") != null){
            if (!(params.get("productCategoryId") instanceof String) || StringUtil.isNotEmpty((String) params.get("productCategoryId"))){
                sql.WHERE("PRODUCT_CATEGORY_ID=#{productCategoryId,jdbcType=BIGINT}");
            }
        }
        if (params.get("ids") != null && params.get("ids") instanceof List) {
            List list = (List) params.get("ids");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{ids[").append(i).append("],jdbcType=BIGINT},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("PRODUCT_CATEGORY_ID IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("productCategoryName") != null){
            if (!(params.get("productCategoryName") instanceof String) || StringUtil.isNotEmpty((String) params.get("productCategoryName"))){
                sql.WHERE("PRODUCT_CATEGORY_NAME=#{productCategoryName,jdbcType=VARCHAR}");
            }
        }
        if (params.get("productCategoryNameLike")!=null){
            if (!(params.get("productCategoryNameLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("productCategoryNameLike"))){
                sql.WHERE("PRODUCT_CATEGORY_NAME LIKE CONCAT('%',#{productCategoryNameLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("displayOrder") != null){
            if (!(params.get("displayOrder") instanceof String) || StringUtil.isNotEmpty((String) params.get("displayOrder"))){
                sql.WHERE("DISPLAY_ORDER=#{displayOrder,jdbcType=INTEGER}");
            }
        }
        if (params.get("parentId") != null){
            if (!(params.get("parentId") instanceof String) || StringUtil.isNotEmpty((String) params.get("parentId"))){
                sql.WHERE("PARENT_ID=#{parentId,jdbcType=BIGINT}");
            }
        }
        if (params.get("iconPath") != null){
            if (!(params.get("iconPath") instanceof String) || StringUtil.isNotEmpty((String) params.get("iconPath"))){
                sql.WHERE("ICON_PATH=#{iconPath,jdbcType=VARCHAR}");
            }
        }
        if (params.get("iconPathLike")!=null){
            if (!(params.get("iconPathLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("iconPathLike"))){
                sql.WHERE("ICON_PATH LIKE CONCAT('%',#{iconPathLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("usageCode") != null){
            if (!(params.get("usageCode") instanceof String) || StringUtil.isNotEmpty((String) params.get("usageCode"))){
                sql.WHERE("USAGE_CODE=#{usageCode,jdbcType=INTEGER}");
            }
        }
        if (params.get("isDelete") != null){
            if (!(params.get("isDelete") instanceof String) || StringUtil.isNotEmpty((String) params.get("isDelete"))){
                sql.WHERE("IS_DELETE=#{isDelete,jdbcType=CHAR}");
            }
        }
        if (params.get("isDeleteLike")!=null){
            if (!(params.get("isDeleteLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("isDeleteLike"))){
                sql.WHERE("IS_DELETE LIKE CONCAT('%',#{isDeleteLike,jdbcType=CHAR},'%')");
            }
        }
        if (params.get("xpath") != null){
            if (!(params.get("xpath") instanceof String) || StringUtil.isNotEmpty((String) params.get("xpath"))){
                sql.WHERE("XPATH=#{xpath,jdbcType=VARCHAR}");
            }
        }
        if (params.get("xpathLike")!=null){
            if (!(params.get("xpathLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("xpathLike"))){
                sql.WHERE("XPATH LIKE CONCAT('%',#{xpathLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("ORDER_BY") != null){
            String orderBy = (String) params.get("ORDER_BY");
            String[] columns = orderBy.split(",");
            for (int i = 0; i < columns.length; i = i + 2) {
                if (i+1<columns.length){
                    sql.ORDER_BY(String.format("%s %s",columns[i],columns[i+1]));
                } else {
                    sql.ORDER_BY(columns[i]);
                }
            }
        }
        
        return sql.toString();
    }
}