/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-12-08 15:12:42
 */
package cn.faury.fwmf.module.service.order.generate.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.order.generate.bean.WeixinCallbackRecordsGenerateBean;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class WeixinCallbackRecordsGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_weixin_callback_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public String insertSelective(WeixinCallbackRecordsGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("payment_t_weixin_callback_records");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.VALUES("OUT_TRADE_NO", "#{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTransactionId() != null) {
            sql.VALUES("TRANSACTION_ID", "#{transactionId,jdbcType=VARCHAR}");
        }
        
        if (record.getResultCode() != null) {
            sql.VALUES("RESULT_CODE", "#{resultCode,jdbcType=VARCHAR}");
        }
        
        if (record.getParameterList() != null) {
            sql.VALUES("PARAMETER_LIST", "#{parameterList,jdbcType=VARCHAR}");
        }
        
        if (record.getCallbackTime() != null) {
            sql.VALUES("CALLBACK_TIME", "#{callbackTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_weixin_callback_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public String updateByPrimaryKeySelective(WeixinCallbackRecordsGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("payment_t_weixin_callback_records");
        
        if (record.getOutTradeNo() != null) {
            sql.SET("OUT_TRADE_NO = #{outTradeNo,jdbcType=VARCHAR}");
        }
        
        if (record.getTransactionId() != null) {
            sql.SET("TRANSACTION_ID = #{transactionId,jdbcType=VARCHAR}");
        }
        
        if (record.getResultCode() != null) {
            sql.SET("RESULT_CODE = #{resultCode,jdbcType=VARCHAR}");
        }
        
        if (record.getParameterList() != null) {
            sql.SET("PARAMETER_LIST = #{parameterList,jdbcType=VARCHAR}");
        }
        
        if (record.getCallbackTime() != null) {
            sql.SET("CALLBACK_TIME = #{callbackTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_weixin_callback_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("ID, OUT_TRADE_NO, TRANSACTION_ID, RESULT_CODE, PARAMETER_LIST, CALLBACK_TIME");
        
        sql.FROM("payment_t_weixin_callback_records");
        
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
        if (params.get("outTradeNo") != null){
            if (!(params.get("outTradeNo") instanceof String) || StringUtil.isNotEmpty((String) params.get("outTradeNo"))){
                sql.WHERE("OUT_TRADE_NO=#{outTradeNo,jdbcType=VARCHAR}");
            }
        }
        if (params.get("outTradeNoLike")!=null){
            if (!(params.get("outTradeNoLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("outTradeNoLike"))){
                sql.WHERE("OUT_TRADE_NO LIKE CONCAT('%',#{outTradeNoLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("transactionId") != null){
            if (!(params.get("transactionId") instanceof String) || StringUtil.isNotEmpty((String) params.get("transactionId"))){
                sql.WHERE("TRANSACTION_ID=#{transactionId,jdbcType=VARCHAR}");
            }
        }
        if (params.get("transactionIdLike")!=null){
            if (!(params.get("transactionIdLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("transactionIdLike"))){
                sql.WHERE("TRANSACTION_ID LIKE CONCAT('%',#{transactionIdLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("resultCode") != null){
            if (!(params.get("resultCode") instanceof String) || StringUtil.isNotEmpty((String) params.get("resultCode"))){
                sql.WHERE("RESULT_CODE=#{resultCode,jdbcType=VARCHAR}");
            }
        }
        if (params.get("resultCodeLike")!=null){
            if (!(params.get("resultCodeLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("resultCodeLike"))){
                sql.WHERE("RESULT_CODE LIKE CONCAT('%',#{resultCodeLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("parameterList") != null){
            if (!(params.get("parameterList") instanceof String) || StringUtil.isNotEmpty((String) params.get("parameterList"))){
                sql.WHERE("PARAMETER_LIST=#{parameterList,jdbcType=VARCHAR}");
            }
        }
        if (params.get("parameterListLike")!=null){
            if (!(params.get("parameterListLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("parameterListLike"))){
                sql.WHERE("PARAMETER_LIST LIKE CONCAT('%',#{parameterListLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("callbackTime") != null){
            if (!(params.get("callbackTime") instanceof String) || StringUtil.isNotEmpty((String) params.get("callbackTime"))){
                sql.WHERE("CALLBACK_TIME=#{callbackTime,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("callbackTimeStart")!=null){
            if (!(params.get("callbackTimeStart") instanceof String) || StringUtil.isNotEmpty((String) params.get("callbackTimeStart"))){
                sql.WHERE("CALLBACK_TIME >= #{callbackTimeStart,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("callbackTimeEnd")!=null){
            if (!(params.get("callbackTimeEnd") instanceof String) || StringUtil.isNotEmpty((String) params.get("callbackTimeEnd"))){
                sql.WHERE("CALLBACK_TIME <= #{callbackTimeEnd,jdbcType=TIMESTAMP}");
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