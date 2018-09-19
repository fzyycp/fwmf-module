package cn.faury.fwmf.module.service.order.generate.mapper;

import cn.faury.fwmf.module.api.order.generate.bean.WeixinPayRecordsGenerateBean;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.WeixinPayRecordsGenerateSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface WeixinPayRecordsGenerateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_t_weixin_pay_records
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    @Delete({
        "delete from payment_t_weixin_pay_records",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_t_weixin_pay_records
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    @Insert({
        "insert into payment_t_weixin_pay_records (ID, OUT_TRADE_NO, ",
        "SUBJECT, TOTALFEE, ",
        "ORDER_ID, BODY, USER_ID, ",
        "USER_NAME, CREATE_TIME, ",
        "TRANSACTION_ID, RESULT_CODE, ",
        "RECEIVE_SRC)",
        "values (#{id,jdbcType=BIGINT}, #{outTradeNo,jdbcType=CHAR}, ",
        "#{subject,jdbcType=VARCHAR}, #{totalfee,jdbcType=DECIMAL}, ",
        "#{orderId,jdbcType=BIGINT}, #{body,jdbcType=VARCHAR}, #{userId,jdbcType=BIGINT}, ",
        "#{userName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{transactionId,jdbcType=VARCHAR}, #{resultCode,jdbcType=VARCHAR}, ",
        "#{receiveSrc,jdbcType=CHAR})"
    })
    @Options(useGeneratedKeys = true)
    int insert(WeixinPayRecordsGenerateBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_t_weixin_pay_records
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    @InsertProvider(type=WeixinPayRecordsGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys = true)
    int insertSelective(WeixinPayRecordsGenerateBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_t_weixin_pay_records
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    @Select({
        "select",
        "ID, OUT_TRADE_NO, SUBJECT, TOTALFEE, ORDER_ID, BODY, USER_ID, USER_NAME, CREATE_TIME, ",
        "TRANSACTION_ID, RESULT_CODE, RECEIVE_SRC",
        "from payment_t_weixin_pay_records",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="OUT_TRADE_NO", property="outTradeNo", jdbcType=JdbcType.CHAR),
        @Result(column="SUBJECT", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="TOTALFEE", property="totalfee", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORDER_ID", property="orderId", jdbcType=JdbcType.BIGINT),
        @Result(column="BODY", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="TRANSACTION_ID", property="transactionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="RESULT_CODE", property="resultCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="RECEIVE_SRC", property="receiveSrc", jdbcType=JdbcType.CHAR)
    })
    WeixinPayRecordsGenerateBean selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_t_weixin_pay_records
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    @UpdateProvider(type=WeixinPayRecordsGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WeixinPayRecordsGenerateBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment_t_weixin_pay_records
     *
     * @mbg.generated Tue Aug 07 09:22:28 CST 2018
     */
    @Update({
        "update payment_t_weixin_pay_records",
        "set OUT_TRADE_NO = #{outTradeNo,jdbcType=CHAR},",
          "SUBJECT = #{subject,jdbcType=VARCHAR},",
          "TOTALFEE = #{totalfee,jdbcType=DECIMAL},",
          "ORDER_ID = #{orderId,jdbcType=BIGINT},",
          "BODY = #{body,jdbcType=VARCHAR},",
          "USER_ID = #{userId,jdbcType=BIGINT},",
          "USER_NAME = #{userName,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "TRANSACTION_ID = #{transactionId,jdbcType=VARCHAR},",
          "RESULT_CODE = #{resultCode,jdbcType=VARCHAR},",
          "RECEIVE_SRC = #{receiveSrc,jdbcType=CHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WeixinPayRecordsGenerateBean record);
}