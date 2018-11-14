/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-14 15:41:39
 */
package cn.faury.fwmf.module.service.order.generate.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.order.generate.bean.PostageInfoGenerateBean;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PostageInfoGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_info
     *
     * @fwmf.generated 2018-11-14 15:41:39
     */
    public String insertSelective(PostageInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_t_postage_info");
        
        if (record.getPostageId() != null) {
            sql.VALUES("POSTAGE_ID", "#{postageId,jdbcType=BIGINT}");
        }
        
        if (record.getPostageName() != null) {
            sql.VALUES("POSTAGE_NAME", "#{postageName,jdbcType=VARCHAR}");
        }
        
        if (record.getPostageType() != null) {
            sql.VALUES("POSTAGE_TYPE", "#{postageType,jdbcType=CHAR}");
        }
        
        if (record.getGoodsCount() != null) {
            sql.VALUES("GOODS_COUNT", "#{goodsCount,jdbcType=INTEGER}");
        }
        
        if (record.getPostagePrice() != null) {
            sql.VALUES("POSTAGE_PRICE", "#{postagePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getIncreaseGoodsCount() != null) {
            sql.VALUES("INCREASE_GOODS_COUNT", "#{increaseGoodsCount,jdbcType=INTEGER}");
        }
        
        if (record.getIncreasePostagePrice() != null) {
            sql.VALUES("INCREASE_POSTAGE_PRICE", "#{increasePostagePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.VALUES("CREATE_PERSON", "#{createPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatePerson() != null) {
            sql.VALUES("UPDATE_PERSON", "#{updatePerson,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_info
     *
     * @fwmf.generated 2018-11-14 15:41:39
     */
    public String updateByPrimaryKeySelective(PostageInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("order_t_postage_info");
        
        if (record.getPostageName() != null) {
            sql.SET("POSTAGE_NAME = #{postageName,jdbcType=VARCHAR}");
        }
        
        if (record.getPostageType() != null) {
            sql.SET("POSTAGE_TYPE = #{postageType,jdbcType=CHAR}");
        }
        
        if (record.getGoodsCount() != null) {
            sql.SET("GOODS_COUNT = #{goodsCount,jdbcType=INTEGER}");
        }
        
        if (record.getPostagePrice() != null) {
            sql.SET("POSTAGE_PRICE = #{postagePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getIncreaseGoodsCount() != null) {
            sql.SET("INCREASE_GOODS_COUNT = #{increaseGoodsCount,jdbcType=INTEGER}");
        }
        
        if (record.getIncreasePostagePrice() != null) {
            sql.SET("INCREASE_POSTAGE_PRICE = #{increasePostagePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.SET("CREATE_PERSON = #{createPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatePerson() != null) {
            sql.SET("UPDATE_PERSON = #{updatePerson,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("POSTAGE_ID = #{postageId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_info
     *
     * @fwmf.generated 2018-11-14 15:41:39
     */
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("POSTAGE_ID, POSTAGE_NAME, POSTAGE_TYPE, GOODS_COUNT, POSTAGE_PRICE, INCREASE_GOODS_COUNT");
        sql.SELECT("INCREASE_POSTAGE_PRICE, CREATE_PERSON, CREATE_TIME, UPDATE_PERSON, UPDATE_TIME");
        
        sql.FROM("order_t_postage_info");
        
        if (params.get("postageId") != null){
            if (!(params.get("postageId") instanceof String) || StringUtil.isNotEmpty((String) params.get("postageId"))){
                sql.WHERE("POSTAGE_ID=#{postageId,jdbcType=BIGINT}");
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
                sql.WHERE("POSTAGE_ID IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("postageName") != null){
            if (!(params.get("postageName") instanceof String) || StringUtil.isNotEmpty((String) params.get("postageName"))){
                sql.WHERE("POSTAGE_NAME=#{postageName,jdbcType=VARCHAR}");
            }
        }
        if (params.get("postageNameLike")!=null){
            if (!(params.get("postageNameLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("postageNameLike"))){
                sql.WHERE("POSTAGE_NAME LIKE CONCAT('%',#{postageNameLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("postageType") != null){
            if (!(params.get("postageType") instanceof String) || StringUtil.isNotEmpty((String) params.get("postageType"))){
                sql.WHERE("POSTAGE_TYPE=#{postageType,jdbcType=CHAR}");
            }
        }
        if (params.get("postageTypeLike")!=null){
            if (!(params.get("postageTypeLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("postageTypeLike"))){
                sql.WHERE("POSTAGE_TYPE LIKE CONCAT('%',#{postageTypeLike,jdbcType=CHAR},'%')");
            }
        }
        if (params.get("goodsCount") != null){
            if (!(params.get("goodsCount") instanceof String) || StringUtil.isNotEmpty((String) params.get("goodsCount"))){
                sql.WHERE("GOODS_COUNT=#{goodsCount,jdbcType=INTEGER}");
            }
        }
        if (params.get("postagePrice") != null){
            if (!(params.get("postagePrice") instanceof String) || StringUtil.isNotEmpty((String) params.get("postagePrice"))){
                sql.WHERE("POSTAGE_PRICE=#{postagePrice,jdbcType=DECIMAL}");
            }
        }
        if (params.get("increaseGoodsCount") != null){
            if (!(params.get("increaseGoodsCount") instanceof String) || StringUtil.isNotEmpty((String) params.get("increaseGoodsCount"))){
                sql.WHERE("INCREASE_GOODS_COUNT=#{increaseGoodsCount,jdbcType=INTEGER}");
            }
        }
        if (params.get("increasePostagePrice") != null){
            if (!(params.get("increasePostagePrice") instanceof String) || StringUtil.isNotEmpty((String) params.get("increasePostagePrice"))){
                sql.WHERE("INCREASE_POSTAGE_PRICE=#{increasePostagePrice,jdbcType=DECIMAL}");
            }
        }
        if (params.get("createPerson") != null){
            if (!(params.get("createPerson") instanceof String) || StringUtil.isNotEmpty((String) params.get("createPerson"))){
                sql.WHERE("CREATE_PERSON=#{createPerson,jdbcType=VARCHAR}");
            }
        }
        if (params.get("createPersonLike")!=null){
            if (!(params.get("createPersonLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("createPersonLike"))){
                sql.WHERE("CREATE_PERSON LIKE CONCAT('%',#{createPersonLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("createTime") != null){
            if (!(params.get("createTime") instanceof String) || StringUtil.isNotEmpty((String) params.get("createTime"))){
                sql.WHERE("CREATE_TIME=#{createTime,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("createTimeStart")!=null){
            if (!(params.get("createTimeStart") instanceof String) || StringUtil.isNotEmpty((String) params.get("createTimeStart"))){
                sql.WHERE("CREATE_TIME >= #{createTimeStart,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("createTimeEnd")!=null){
            if (!(params.get("createTimeEnd") instanceof String) || StringUtil.isNotEmpty((String) params.get("createTimeEnd"))){
                sql.WHERE("CREATE_TIME <= #{createTimeEnd,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("updatePerson") != null){
            if (!(params.get("updatePerson") instanceof String) || StringUtil.isNotEmpty((String) params.get("updatePerson"))){
                sql.WHERE("UPDATE_PERSON=#{updatePerson,jdbcType=VARCHAR}");
            }
        }
        if (params.get("updatePersonLike")!=null){
            if (!(params.get("updatePersonLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("updatePersonLike"))){
                sql.WHERE("UPDATE_PERSON LIKE CONCAT('%',#{updatePersonLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("updateTime") != null){
            if (!(params.get("updateTime") instanceof String) || StringUtil.isNotEmpty((String) params.get("updateTime"))){
                sql.WHERE("UPDATE_TIME=#{updateTime,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("updateTimeStart")!=null){
            if (!(params.get("updateTimeStart") instanceof String) || StringUtil.isNotEmpty((String) params.get("updateTimeStart"))){
                sql.WHERE("UPDATE_TIME >= #{updateTimeStart,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("updateTimeEnd")!=null){
            if (!(params.get("updateTimeEnd") instanceof String) || StringUtil.isNotEmpty((String) params.get("updateTimeEnd"))){
                sql.WHERE("UPDATE_TIME <= #{updateTimeEnd,jdbcType=TIMESTAMP}");
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