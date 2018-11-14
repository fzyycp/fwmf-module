/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-14 15:41:38
 */
package cn.faury.fwmf.module.service.order.generate.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.order.generate.bean.GoodsStockInfoGenerateBean;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class GoodsStockInfoGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_goods_stock_info
     *
     * @fwmf.generated 2018-11-14 15:41:38
     */
    public String insertSelective(GoodsStockInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_t_goods_stock_info");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getGoodsId() != null) {
            sql.VALUES("GOODS_ID", "#{goodsId,jdbcType=BIGINT}");
        }
        
        if (record.getStock() != null) {
            sql.VALUES("STOCK", "#{stock,jdbcType=INTEGER}");
        }
        
        if (record.getDemo() != null) {
            sql.VALUES("DEMO", "#{demo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.VALUES("CREATE_PERSON", "#{createPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDelete() != null) {
            sql.VALUES("IS_DELETE", "#{isDelete,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_goods_stock_info
     *
     * @fwmf.generated 2018-11-14 15:41:38
     */
    public String updateByPrimaryKeySelective(GoodsStockInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("order_t_goods_stock_info");
        
        if (record.getGoodsId() != null) {
            sql.SET("GOODS_ID = #{goodsId,jdbcType=BIGINT}");
        }
        
        if (record.getStock() != null) {
            sql.SET("STOCK = #{stock,jdbcType=INTEGER}");
        }
        
        if (record.getDemo() != null) {
            sql.SET("DEMO = #{demo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.SET("CREATE_PERSON = #{createPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIsDelete() != null) {
            sql.SET("IS_DELETE = #{isDelete,jdbcType=CHAR}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_goods_stock_info
     *
     * @fwmf.generated 2018-11-14 15:41:38
     */
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("ID, GOODS_ID, STOCK, DEMO, CREATE_PERSON, CREATE_TIME, IS_DELETE");
        
        sql.FROM("order_t_goods_stock_info");
        
        if (params.get("id") != null){
            if (!(params.get("id") instanceof String) || StringUtil.isNotEmpty((String) params.get("id"))){
                sql.WHERE("ID=#{id,jdbcType=BIGINT}");
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
                sql.WHERE("ID IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("goodsId") != null){
            if (!(params.get("goodsId") instanceof String) || StringUtil.isNotEmpty((String) params.get("goodsId"))){
                sql.WHERE("GOODS_ID=#{goodsId,jdbcType=BIGINT}");
            }
        }
        if (params.get("stock") != null){
            if (!(params.get("stock") instanceof String) || StringUtil.isNotEmpty((String) params.get("stock"))){
                sql.WHERE("STOCK=#{stock,jdbcType=INTEGER}");
            }
        }
        if (params.get("demo") != null){
            if (!(params.get("demo") instanceof String) || StringUtil.isNotEmpty((String) params.get("demo"))){
                sql.WHERE("DEMO=#{demo,jdbcType=VARCHAR}");
            }
        }
        if (params.get("demoLike")!=null){
            if (!(params.get("demoLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("demoLike"))){
                sql.WHERE("DEMO LIKE CONCAT('%',#{demoLike,jdbcType=VARCHAR},'%')");
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