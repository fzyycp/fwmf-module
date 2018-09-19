/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-03 10:52:39
 */
package cn.faury.fwmf.module.service.payment.generate.mapper;

import cn.faury.fwmf.module.api.payment.bean.AlipayCallbackRecordsBean;
import cn.faury.fwmf.module.api.payment.generate.bean.AlipayCallbackRecordsGenerateBean;
import cn.faury.fwmf.module.service.payment.generate.sqlProvider.AlipayCallbackRecordsGenerateSqlProvider;
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

public interface AlipayCallbackRecordsGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_callback_records
     *
     * @fwmf.generated 2018-09-03 10:52:39
     */
    @Delete({
        "delete from payment_t_alipay_callback_records",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_callback_records
     *
     * @fwmf.generated 2018-09-03 10:52:39
     */
    @Insert({
        "insert into payment_t_alipay_callback_records (ID, OUT_TRADE_NO, ",
        "ALIPAY_TRADE_NO, TRADE_STATUS, ",
        "PARAMETER_LIST, CALLBACK_TIME)",
        "values (#{id,jdbcType=BIGINT}, #{outTradeNo,jdbcType=CHAR}, ",
        "#{alipayTradeNo,jdbcType=VARCHAR}, #{tradeStatus,jdbcType=VARCHAR}, ",
        "#{parameterList,jdbcType=VARCHAR}, #{callbackTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(AlipayCallbackRecordsGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_callback_records
     *
     * @fwmf.generated 2018-09-03 10:52:39
     */
    @InsertProvider(type=AlipayCallbackRecordsGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(AlipayCallbackRecordsGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_callback_records
     *
     * @fwmf.generated 2018-09-03 10:52:39
     */
    @SelectProvider(type=AlipayCallbackRecordsGenerateSqlProvider.class, method="search")
    @ResultType(AlipayCallbackRecordsBean.class)
    List<AlipayCallbackRecordsBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_callback_records
     *
     * @fwmf.generated 2018-09-03 10:52:39
     */
    @Select({
        "select",
        "ID, OUT_TRADE_NO, ALIPAY_TRADE_NO, TRADE_STATUS, PARAMETER_LIST, CALLBACK_TIME",
        "from payment_t_alipay_callback_records",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="OUT_TRADE_NO", property="outTradeNo", jdbcType=JdbcType.CHAR),
        @Result(column="ALIPAY_TRADE_NO", property="alipayTradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_STATUS", property="tradeStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="PARAMETER_LIST", property="parameterList", jdbcType=JdbcType.VARCHAR),
        @Result(column="CALLBACK_TIME", property="callbackTime", jdbcType=JdbcType.TIMESTAMP)
    })
    AlipayCallbackRecordsBean selectByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_callback_records
     *
     * @fwmf.generated 2018-09-03 10:52:39
     */
    @UpdateProvider(type=AlipayCallbackRecordsGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AlipayCallbackRecordsGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table payment_t_alipay_callback_records
     *
     * @fwmf.generated 2018-09-03 10:52:39
     */
    @Update({
        "update payment_t_alipay_callback_records",
        "set OUT_TRADE_NO = #{outTradeNo,jdbcType=CHAR},",
          "ALIPAY_TRADE_NO = #{alipayTradeNo,jdbcType=VARCHAR},",
          "TRADE_STATUS = #{tradeStatus,jdbcType=VARCHAR},",
          "PARAMETER_LIST = #{parameterList,jdbcType=VARCHAR},",
          "CALLBACK_TIME = #{callbackTime,jdbcType=TIMESTAMP}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AlipayCallbackRecordsGenerateBean record);
}