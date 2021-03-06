/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-12-08 15:12:42
 */
package cn.faury.fwmf.module.service.order.generate.mapper;

import cn.faury.fwmf.module.api.order.bean.AlipayRecordsBean;
import cn.faury.fwmf.module.api.order.generate.bean.AlipayRecordsGenerateBean;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.AlipayRecordsGenerateSqlProvider;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface AlipayRecordsGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Delete({
        "delete from payment_t_alipay_records",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Insert({
        "insert into payment_t_alipay_records (ID, OUT_TRADE_NO, ",
        "SUBJECT, TOTALFEE, ",
        "ORDER_ID, BODY, USER_ID, ",
        "USER_NAME, CREATE_TIME, ",
        "ALIPAY_TRADE_NO, TRADE_STATUS, ",
        "RECEIVE_SRC)",
        "values (#{id,jdbcType=BIGINT}, #{outTradeNo,jdbcType=CHAR}, ",
        "#{subject,jdbcType=VARCHAR}, #{totalfee,jdbcType=DECIMAL}, ",
        "#{orderId,jdbcType=BIGINT}, #{body,jdbcType=VARCHAR}, #{userId,jdbcType=BIGINT}, ",
        "#{userName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{alipayTradeNo,jdbcType=VARCHAR}, #{tradeStatus,jdbcType=VARCHAR}, ",
        "#{receiveSrc,jdbcType=CHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(AlipayRecordsGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @InsertProvider(type=AlipayRecordsGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(AlipayRecordsGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @SelectProvider(type=AlipayRecordsGenerateSqlProvider.class, method="search")
    @ResultType(AlipayRecordsBean.class)
    List<AlipayRecordsBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Select({
        "select",
        "ID, OUT_TRADE_NO, SUBJECT, TOTALFEE, ORDER_ID, BODY, USER_ID, USER_NAME, CREATE_TIME, ",
        "ALIPAY_TRADE_NO, TRADE_STATUS, RECEIVE_SRC",
        "from payment_t_alipay_records",
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
        @Result(column="ALIPAY_TRADE_NO", property="alipayTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_STATUS", property="tradeStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="RECEIVE_SRC", property="receiveSrc", jdbcType=JdbcType.CHAR)
    })
    AlipayRecordsBean selectByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @UpdateProvider(type=AlipayRecordsGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AlipayRecordsGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_records
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Update({
        "update payment_t_alipay_records",
        "set OUT_TRADE_NO = #{outTradeNo,jdbcType=CHAR},",
          "SUBJECT = #{subject,jdbcType=VARCHAR},",
          "TOTALFEE = #{totalfee,jdbcType=DECIMAL},",
          "ORDER_ID = #{orderId,jdbcType=BIGINT},",
          "BODY = #{body,jdbcType=VARCHAR},",
          "USER_ID = #{userId,jdbcType=BIGINT},",
          "USER_NAME = #{userName,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "ALIPAY_TRADE_NO = #{alipayTradeNo,jdbcType=VARCHAR},",
          "TRADE_STATUS = #{tradeStatus,jdbcType=VARCHAR},",
          "RECEIVE_SRC = #{receiveSrc,jdbcType=CHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AlipayRecordsGenerateBean record);
}