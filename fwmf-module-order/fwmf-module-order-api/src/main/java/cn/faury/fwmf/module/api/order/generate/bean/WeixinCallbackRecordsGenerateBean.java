package cn.faury.fwmf.module.api.order.generate.bean;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table payment_t_weixin_callback_records
 */
public class WeixinCallbackRecordsGenerateBean {
    /**
     * Database Column Remarks:
     *   唯一标识
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment_t_weixin_callback_records.ID
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   商户订单号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment_t_weixin_callback_records.OUT_TRADE_NO
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    private String outTradeNo;

    /**
     * Database Column Remarks:
     *   微信交易号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment_t_weixin_callback_records.TRANSACTION_ID
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    private String transactionId;

    /**
     * Database Column Remarks:
     *   业务结果
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment_t_weixin_callback_records.RESULT_CODE
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    private String resultCode;

    /**
     * Database Column Remarks:
     *   回调参数列表
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment_t_weixin_callback_records.PARAMETER_LIST
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    private String parameterList;

    /**
     * Database Column Remarks:
     *   回调时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment_t_weixin_callback_records.CALLBACK_TIME
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    private Date callbackTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payment_t_weixin_callback_records.ID
     *
     * @return the value of payment_t_weixin_callback_records.ID
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payment_t_weixin_callback_records.ID
     *
     * @param id the value for payment_t_weixin_callback_records.ID
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payment_t_weixin_callback_records.OUT_TRADE_NO
     *
     * @return the value of payment_t_weixin_callback_records.OUT_TRADE_NO
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public String getOutTradeNo() {
        return outTradeNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payment_t_weixin_callback_records.OUT_TRADE_NO
     *
     * @param outTradeNo the value for payment_t_weixin_callback_records.OUT_TRADE_NO
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payment_t_weixin_callback_records.TRANSACTION_ID
     *
     * @return the value of payment_t_weixin_callback_records.TRANSACTION_ID
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payment_t_weixin_callback_records.TRANSACTION_ID
     *
     * @param transactionId the value for payment_t_weixin_callback_records.TRANSACTION_ID
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payment_t_weixin_callback_records.RESULT_CODE
     *
     * @return the value of payment_t_weixin_callback_records.RESULT_CODE
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public String getResultCode() {
        return resultCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payment_t_weixin_callback_records.RESULT_CODE
     *
     * @param resultCode the value for payment_t_weixin_callback_records.RESULT_CODE
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public void setResultCode(String resultCode) {
        this.resultCode = resultCode == null ? null : resultCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payment_t_weixin_callback_records.PARAMETER_LIST
     *
     * @return the value of payment_t_weixin_callback_records.PARAMETER_LIST
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public String getParameterList() {
        return parameterList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payment_t_weixin_callback_records.PARAMETER_LIST
     *
     * @param parameterList the value for payment_t_weixin_callback_records.PARAMETER_LIST
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public void setParameterList(String parameterList) {
        this.parameterList = parameterList == null ? null : parameterList.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payment_t_weixin_callback_records.CALLBACK_TIME
     *
     * @return the value of payment_t_weixin_callback_records.CALLBACK_TIME
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public Date getCallbackTime() {
        return callbackTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payment_t_weixin_callback_records.CALLBACK_TIME
     *
     * @param callbackTime the value for payment_t_weixin_callback_records.CALLBACK_TIME
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }
}