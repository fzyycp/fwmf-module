/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-12-08 15:12:42
 */
package cn.faury.fwmf.module.service.order.generate.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.order.generate.bean.WeixinPayRecordsGenerateBean;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class WeixinPayRecordsGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_weixin_pay_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public String insertSelective(WeixinPayRecordsGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("payment_t_weixin_pay_records");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getOutTradeNo() != null) {
            sql.VALUES("OUT_TRADE_NO", "#{outTradeNo,jdbcType=CHAR}");
        }
        
        if (record.getSubject() != null) {
            sql.VALUES("SUBJECT", "#{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalfee() != null) {
            sql.VALUES("TOTALFEE", "#{totalfee,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderId() != null) {
            sql.VALUES("ORDER_ID", "#{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getBody() != null) {
            sql.VALUES("BODY", "#{body,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("USER_ID", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("USER_NAME", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTransactionId() != null) {
            sql.VALUES("TRANSACTION_ID", "#{transactionId,jdbcType=VARCHAR}");
        }
        
        if (record.getResultCode() != null) {
            sql.VALUES("RESULT_CODE", "#{resultCode,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiveSrc() != null) {
            sql.VALUES("RECEIVE_SRC", "#{receiveSrc,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_weixin_pay_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public String updateByPrimaryKeySelective(WeixinPayRecordsGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("payment_t_weixin_pay_records");
        
        if (record.getOutTradeNo() != null) {
            sql.SET("OUT_TRADE_NO = #{outTradeNo,jdbcType=CHAR}");
        }
        
        if (record.getSubject() != null) {
            sql.SET("SUBJECT = #{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getTotalfee() != null) {
            sql.SET("TOTALFEE = #{totalfee,jdbcType=DECIMAL}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("ORDER_ID = #{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getBody() != null) {
            sql.SET("BODY = #{body,jdbcType=VARCHAR}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("USER_ID = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("USER_NAME = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTransactionId() != null) {
            sql.SET("TRANSACTION_ID = #{transactionId,jdbcType=VARCHAR}");
        }
        
        if (record.getResultCode() != null) {
            sql.SET("RESULT_CODE = #{resultCode,jdbcType=VARCHAR}");
        }
        
        if (record.getReceiveSrc() != null) {
            sql.SET("RECEIVE_SRC = #{receiveSrc,jdbcType=CHAR}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_weixin_pay_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("ID, OUT_TRADE_NO, SUBJECT, TOTALFEE, ORDER_ID, BODY, USER_ID, USER_NAME, CREATE_TIME");
        sql.SELECT("TRANSACTION_ID, RESULT_CODE, RECEIVE_SRC");
        
        sql.FROM("payment_t_weixin_pay_records");
        
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
                sql.WHERE("OUT_TRADE_NO=#{outTradeNo,jdbcType=CHAR}");
            }
        }
        if (params.get("outTradeNoLike")!=null){
            if (!(params.get("outTradeNoLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("outTradeNoLike"))){
                sql.WHERE("OUT_TRADE_NO LIKE CONCAT('%',#{outTradeNoLike,jdbcType=CHAR},'%')");
            }
        }
        if (params.get("subject") != null){
            if (!(params.get("subject") instanceof String) || StringUtil.isNotEmpty((String) params.get("subject"))){
                sql.WHERE("SUBJECT=#{subject,jdbcType=VARCHAR}");
            }
        }
        if (params.get("subjectLike")!=null){
            if (!(params.get("subjectLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("subjectLike"))){
                sql.WHERE("SUBJECT LIKE CONCAT('%',#{subjectLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("totalfee") != null){
            if (!(params.get("totalfee") instanceof String) || StringUtil.isNotEmpty((String) params.get("totalfee"))){
                sql.WHERE("TOTALFEE=#{totalfee,jdbcType=DECIMAL}");
            }
        }
        if (params.get("orderId") != null){
            if (!(params.get("orderId") instanceof String) || StringUtil.isNotEmpty((String) params.get("orderId"))){
                sql.WHERE("ORDER_ID=#{orderId,jdbcType=BIGINT}");
            }
        }
        if (params.get("body") != null){
            if (!(params.get("body") instanceof String) || StringUtil.isNotEmpty((String) params.get("body"))){
                sql.WHERE("BODY=#{body,jdbcType=VARCHAR}");
            }
        }
        if (params.get("bodyLike")!=null){
            if (!(params.get("bodyLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("bodyLike"))){
                sql.WHERE("BODY LIKE CONCAT('%',#{bodyLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("userId") != null){
            if (!(params.get("userId") instanceof String) || StringUtil.isNotEmpty((String) params.get("userId"))){
                sql.WHERE("USER_ID=#{userId,jdbcType=BIGINT}");
            }
        }
        if (params.get("userName") != null){
            if (!(params.get("userName") instanceof String) || StringUtil.isNotEmpty((String) params.get("userName"))){
                sql.WHERE("USER_NAME=#{userName,jdbcType=VARCHAR}");
            }
        }
        if (params.get("userNameLike")!=null){
            if (!(params.get("userNameLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("userNameLike"))){
                sql.WHERE("USER_NAME LIKE CONCAT('%',#{userNameLike,jdbcType=VARCHAR},'%')");
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
        if (params.get("receiveSrc") != null){
            if (!(params.get("receiveSrc") instanceof String) || StringUtil.isNotEmpty((String) params.get("receiveSrc"))){
                sql.WHERE("RECEIVE_SRC=#{receiveSrc,jdbcType=CHAR}");
            }
        }
        if (params.get("receiveSrcLike")!=null){
            if (!(params.get("receiveSrcLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("receiveSrcLike"))){
                sql.WHERE("RECEIVE_SRC LIKE CONCAT('%',#{receiveSrcLike,jdbcType=CHAR},'%')");
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