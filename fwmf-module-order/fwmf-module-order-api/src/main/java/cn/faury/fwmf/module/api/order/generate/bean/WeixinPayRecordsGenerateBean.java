/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-23 20:25:43
 */
package cn.faury.fwmf.module.api.order.generate.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Database Table Remarks:
 *   微信支付请求记录
 *
 * This class was generated by Fwmf Generated.
 * This class corresponds to the database table payment_t_weixin_pay_records
 *
 * @fwmf.generated 2018-09-23 20:25:43
 */
public class WeixinPayRecordsGenerateBean {
    /**
     * Database Column Remarks:
     *   唯一标识
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   商户订单号（14位年月日时分秒+6位流水号）
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.OUT_TRADE_NO
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private String outTradeNo;

    /**
     * Database Column Remarks:
     *   订单名称
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.SUBJECT
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private String subject;

    /**
     * Database Column Remarks:
     *   总金额
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.TOTALFEE
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private BigDecimal totalfee;

    /**
     * Database Column Remarks:
     *   支付订单ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.ORDER_ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private Long orderId;

    /**
     * Database Column Remarks:
     *   订单内容
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.BODY
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private String body;

    /**
     * Database Column Remarks:
     *   用户ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.USER_ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private Long userId;

    /**
     * Database Column Remarks:
     *   用户登录名
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.USER_NAME
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private String userName;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.CREATE_TIME
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   微信交易号
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.TRANSACTION_ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private String transactionId;

    /**
     * Database Column Remarks:
     *   交易状态
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.RESULT_CODE
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private String resultCode;

    /**
     * Database Column Remarks:
     *   支付来源（0：手机端 1：网站）
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column payment_t_weixin_pay_records.RECEIVE_SRC
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    private String receiveSrc;

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.ID
     *
     * @return the value of payment_t_weixin_pay_records.ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.ID
     *
     * @param id the value for payment_t_weixin_pay_records.ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.OUT_TRADE_NO
     *
     * @return the value of payment_t_weixin_pay_records.OUT_TRADE_NO
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.OUT_TRADE_NO
     *
     * @param outTradeNo the value for payment_t_weixin_pay_records.OUT_TRADE_NO
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.SUBJECT
     *
     * @return the value of payment_t_weixin_pay_records.SUBJECT
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.SUBJECT
     *
     * @param subject the value for payment_t_weixin_pay_records.SUBJECT
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.TOTALFEE
     *
     * @return the value of payment_t_weixin_pay_records.TOTALFEE
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public BigDecimal getTotalfee() {
        return totalfee;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.TOTALFEE
     *
     * @param totalfee the value for payment_t_weixin_pay_records.TOTALFEE
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setTotalfee(BigDecimal totalfee) {
        this.totalfee = totalfee;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.ORDER_ID
     *
     * @return the value of payment_t_weixin_pay_records.ORDER_ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.ORDER_ID
     *
     * @param orderId the value for payment_t_weixin_pay_records.ORDER_ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.BODY
     *
     * @return the value of payment_t_weixin_pay_records.BODY
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public String getBody() {
        return body;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.BODY
     *
     * @param body the value for payment_t_weixin_pay_records.BODY
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setBody(String body) {
        this.body = body == null ? null : body.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.USER_ID
     *
     * @return the value of payment_t_weixin_pay_records.USER_ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.USER_ID
     *
     * @param userId the value for payment_t_weixin_pay_records.USER_ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.USER_NAME
     *
     * @return the value of payment_t_weixin_pay_records.USER_NAME
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.USER_NAME
     *
     * @param userName the value for payment_t_weixin_pay_records.USER_NAME
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.CREATE_TIME
     *
     * @return the value of payment_t_weixin_pay_records.CREATE_TIME
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.CREATE_TIME
     *
     * @param createTime the value for payment_t_weixin_pay_records.CREATE_TIME
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.TRANSACTION_ID
     *
     * @return the value of payment_t_weixin_pay_records.TRANSACTION_ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.TRANSACTION_ID
     *
     * @param transactionId the value for payment_t_weixin_pay_records.TRANSACTION_ID
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.RESULT_CODE
     *
     * @return the value of payment_t_weixin_pay_records.RESULT_CODE
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.RESULT_CODE
     *
     * @param resultCode the value for payment_t_weixin_pay_records.RESULT_CODE
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column payment_t_weixin_pay_records.RECEIVE_SRC
     *
     * @return the value of payment_t_weixin_pay_records.RECEIVE_SRC
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public String getReceiveSrc() {
        return receiveSrc;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column payment_t_weixin_pay_records.RECEIVE_SRC
     *
     * @param receiveSrc the value for payment_t_weixin_pay_records.RECEIVE_SRC
     *
     * @fwmf.generated 2018-09-23 20:25:43
     */
    public void setReceiveSrc(String receiveSrc) {
        this.receiveSrc = receiveSrc == null ? null : receiveSrc.trim();
    }
}