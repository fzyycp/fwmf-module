/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-12-12 09:25:10
 */
package cn.faury.fwmf.module.service.order.generate.mapper;

import cn.faury.fwmf.module.api.order.bean.OrderInfoBean;
import cn.faury.fwmf.module.api.order.generate.bean.OrderInfoGenerateBean;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderInfoGenerateSqlProvider;
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

public interface OrderInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_order_info
     *
     * @fwmf.generated 2018-12-12 09:25:10
     */
    @Delete({
        "delete from order_t_order_info",
        "where ORDER_ID = #{orderId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long orderId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_order_info
     *
     * @fwmf.generated 2018-12-12 09:25:10
     */
    @Insert({
        "insert into order_t_order_info (ORDER_ID, ORDER_CODE, ",
        "BUYER_ID, BUYER_LOGIN, ",
        "ORDER_STATE, GOODS_COUNT, ",
        "GOODS_PRICE, POST_PRICE, ",
        "ORDER_PRICE, GOODS_PAY_PRICE, ",
        "POST_PAY_PRICE, ORDER_PAY_PRICE, ",
        "PAY_STYLE, BUY_ENTRANCE, ",
        "AREA_CODE_PROVINCE, AREA_DESC_PROVINCE, ",
        "AREA_CODE_CITY, AREA_DESC_CITY, ",
        "AREA_CODE_COUNTY, AREA_DESC_COUNTY, ",
        "SCHOOL_NAME, GRADE_NAME, ",
        "CLASS_NAME, ADDRESS_DETAIL, ",
        "CREATE_TIME, EXPIRED_TIME, ",
        "UPDATE_PERSON, UPDATE_PERSON_NAME, ",
        "UPDATE_TIME, RECEIVER_NAME, ",
        "TEL_NO, CODE_NUMBER, ",
        "CODE_URL, REMARK, ",
        "TRADE_STATE, SHOP_ID, ",
        "STORE_ID, AGENT_USER_ID, ",
        "IS_PICKUP, EXPRESS_CODE, ",
        "EXPRESS_NAME, EXPRESS_FEE, ",
        "TRACK_NUMBER, PAY_REMARK, ",
        "PAY_UPDATE_PERSON, PAY_UPDATE_PERSON_NAME, ",
        "PAY_UPDATE_TIME, REFOUND_STATE, ",
        "INVOICE, PAY_TIME, ",
        "SEND_TIME, CONFIRM_TIME, ",
        "CONFIRM_CLOSING_TIME, DELAYED_RECEIVE_COUNT, ",
        "IS_GROUP_BUY, IS_REFUND, ",
        "IS_APP_ORDER)",
        "values (#{orderId,jdbcType=BIGINT}, #{orderCode,jdbcType=CHAR}, ",
        "#{buyerId,jdbcType=BIGINT}, #{buyerLogin,jdbcType=VARCHAR}, ",
        "#{orderState,jdbcType=CHAR}, #{goodsCount,jdbcType=INTEGER}, ",
        "#{goodsPrice,jdbcType=DECIMAL}, #{postPrice,jdbcType=DECIMAL}, ",
        "#{orderPrice,jdbcType=DECIMAL}, #{goodsPayPrice,jdbcType=DECIMAL}, ",
        "#{postPayPrice,jdbcType=DECIMAL}, #{orderPayPrice,jdbcType=DECIMAL}, ",
        "#{payStyle,jdbcType=CHAR}, #{buyEntrance,jdbcType=CHAR}, ",
        "#{areaCodeProvince,jdbcType=VARCHAR}, #{areaDescProvince,jdbcType=VARCHAR}, ",
        "#{areaCodeCity,jdbcType=VARCHAR}, #{areaDescCity,jdbcType=VARCHAR}, ",
        "#{areaCodeCounty,jdbcType=VARCHAR}, #{areaDescCounty,jdbcType=VARCHAR}, ",
        "#{schoolName,jdbcType=VARCHAR}, #{gradeName,jdbcType=VARCHAR}, ",
        "#{className,jdbcType=VARCHAR}, #{addressDetail,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{expiredTime,jdbcType=TIMESTAMP}, ",
        "#{updatePerson,jdbcType=BIGINT}, #{updatePersonName,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{receiverName,jdbcType=VARCHAR}, ",
        "#{telNo,jdbcType=VARCHAR}, #{codeNumber,jdbcType=VARCHAR}, ",
        "#{codeUrl,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{tradeState,jdbcType=CHAR}, #{shopId,jdbcType=BIGINT}, ",
        "#{storeId,jdbcType=BIGINT}, #{agentUserId,jdbcType=BIGINT}, ",
        "#{isPickup,jdbcType=CHAR}, #{expressCode,jdbcType=VARCHAR}, ",
        "#{expressName,jdbcType=VARCHAR}, #{expressFee,jdbcType=VARCHAR}, ",
        "#{trackNumber,jdbcType=VARCHAR}, #{payRemark,jdbcType=VARCHAR}, ",
        "#{payUpdatePerson,jdbcType=BIGINT}, #{payUpdatePersonName,jdbcType=VARCHAR}, ",
        "#{payUpdateTime,jdbcType=TIMESTAMP}, #{refoundState,jdbcType=CHAR}, ",
        "#{invoice,jdbcType=VARCHAR}, #{payTime,jdbcType=TIMESTAMP}, ",
        "#{sendTime,jdbcType=TIMESTAMP}, #{confirmTime,jdbcType=TIMESTAMP}, ",
        "#{confirmClosingTime,jdbcType=TIMESTAMP}, #{delayedReceiveCount,jdbcType=INTEGER}, ",
        "#{isGroupBuy,jdbcType=CHAR}, #{isRefund,jdbcType=CHAR}, ",
        "#{isAppOrder,jdbcType=CHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="orderId")
    int insert(OrderInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_order_info
     *
     * @fwmf.generated 2018-12-12 09:25:10
     */
    @InsertProvider(type=OrderInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="orderId")
    int insertSelective(OrderInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_order_info
     *
     * @fwmf.generated 2018-12-12 09:25:10
     */
    @SelectProvider(type=OrderInfoGenerateSqlProvider.class, method="search")
    @ResultType(OrderInfoBean.class)
    List<OrderInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_order_info
     *
     * @fwmf.generated 2018-12-12 09:25:10
     */
    @Select({
        "select",
        "ORDER_ID, ORDER_CODE, BUYER_ID, BUYER_LOGIN, ORDER_STATE, GOODS_COUNT, GOODS_PRICE, ",
        "POST_PRICE, ORDER_PRICE, GOODS_PAY_PRICE, POST_PAY_PRICE, ORDER_PAY_PRICE, PAY_STYLE, ",
        "BUY_ENTRANCE, AREA_CODE_PROVINCE, AREA_DESC_PROVINCE, AREA_CODE_CITY, AREA_DESC_CITY, ",
        "AREA_CODE_COUNTY, AREA_DESC_COUNTY, SCHOOL_NAME, GRADE_NAME, CLASS_NAME, ADDRESS_DETAIL, ",
        "CREATE_TIME, EXPIRED_TIME, UPDATE_PERSON, UPDATE_PERSON_NAME, UPDATE_TIME, RECEIVER_NAME, ",
        "TEL_NO, CODE_NUMBER, CODE_URL, REMARK, TRADE_STATE, SHOP_ID, STORE_ID, AGENT_USER_ID, ",
        "IS_PICKUP, EXPRESS_CODE, EXPRESS_NAME, EXPRESS_FEE, TRACK_NUMBER, PAY_REMARK, ",
        "PAY_UPDATE_PERSON, PAY_UPDATE_PERSON_NAME, PAY_UPDATE_TIME, REFOUND_STATE, INVOICE, ",
        "PAY_TIME, SEND_TIME, CONFIRM_TIME, CONFIRM_CLOSING_TIME, DELAYED_RECEIVE_COUNT, ",
        "IS_GROUP_BUY, IS_REFUND, IS_APP_ORDER",
        "from order_t_order_info",
        "where ORDER_ID = #{orderId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ORDER_ID", property="orderId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ORDER_CODE", property="orderCode", jdbcType=JdbcType.CHAR),
        @Result(column="BUYER_ID", property="buyerId", jdbcType=JdbcType.BIGINT),
        @Result(column="BUYER_LOGIN", property="buyerLogin", jdbcType=JdbcType.VARCHAR),
        @Result(column="ORDER_STATE", property="orderState", jdbcType=JdbcType.CHAR),
        @Result(column="GOODS_COUNT", property="goodsCount", jdbcType=JdbcType.INTEGER),
        @Result(column="GOODS_PRICE", property="goodsPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="POST_PRICE", property="postPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORDER_PRICE", property="orderPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="GOODS_PAY_PRICE", property="goodsPayPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="POST_PAY_PRICE", property="postPayPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="ORDER_PAY_PRICE", property="orderPayPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="PAY_STYLE", property="payStyle", jdbcType=JdbcType.CHAR),
        @Result(column="BUY_ENTRANCE", property="buyEntrance", jdbcType=JdbcType.CHAR),
        @Result(column="AREA_CODE_PROVINCE", property="areaCodeProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="AREA_DESC_PROVINCE", property="areaDescProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="AREA_CODE_CITY", property="areaCodeCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="AREA_DESC_CITY", property="areaDescCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="AREA_CODE_COUNTY", property="areaCodeCounty", jdbcType=JdbcType.VARCHAR),
        @Result(column="AREA_DESC_COUNTY", property="areaDescCounty", jdbcType=JdbcType.VARCHAR),
        @Result(column="SCHOOL_NAME", property="schoolName", jdbcType=JdbcType.VARCHAR),
        @Result(column="GRADE_NAME", property="gradeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLASS_NAME", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="ADDRESS_DETAIL", property="addressDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="EXPIRED_TIME", property="expiredTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_PERSON", property="updatePerson", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_PERSON_NAME", property="updatePersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="RECEIVER_NAME", property="receiverName", jdbcType=JdbcType.VARCHAR),
        @Result(column="TEL_NO", property="telNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_NUMBER", property="codeNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_URL", property="codeUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRADE_STATE", property="tradeState", jdbcType=JdbcType.CHAR),
        @Result(column="SHOP_ID", property="shopId", jdbcType=JdbcType.BIGINT),
        @Result(column="STORE_ID", property="storeId", jdbcType=JdbcType.BIGINT),
        @Result(column="AGENT_USER_ID", property="agentUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="IS_PICKUP", property="isPickup", jdbcType=JdbcType.CHAR),
        @Result(column="EXPRESS_CODE", property="expressCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXPRESS_NAME", property="expressName", jdbcType=JdbcType.VARCHAR),
        @Result(column="EXPRESS_FEE", property="expressFee", jdbcType=JdbcType.VARCHAR),
        @Result(column="TRACK_NUMBER", property="trackNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAY_REMARK", property="payRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAY_UPDATE_PERSON", property="payUpdatePerson", jdbcType=JdbcType.BIGINT),
        @Result(column="PAY_UPDATE_PERSON_NAME", property="payUpdatePersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAY_UPDATE_TIME", property="payUpdateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="REFOUND_STATE", property="refoundState", jdbcType=JdbcType.CHAR),
        @Result(column="INVOICE", property="invoice", jdbcType=JdbcType.VARCHAR),
        @Result(column="PAY_TIME", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="SEND_TIME", property="sendTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CONFIRM_TIME", property="confirmTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CONFIRM_CLOSING_TIME", property="confirmClosingTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="DELAYED_RECEIVE_COUNT", property="delayedReceiveCount", jdbcType=JdbcType.INTEGER),
        @Result(column="IS_GROUP_BUY", property="isGroupBuy", jdbcType=JdbcType.CHAR),
        @Result(column="IS_REFUND", property="isRefund", jdbcType=JdbcType.CHAR),
        @Result(column="IS_APP_ORDER", property="isAppOrder", jdbcType=JdbcType.CHAR)
    })
    OrderInfoBean selectByPrimaryKey(Long orderId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_order_info
     *
     * @fwmf.generated 2018-12-12 09:25:10
     */
    @UpdateProvider(type=OrderInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_order_info
     *
     * @fwmf.generated 2018-12-12 09:25:10
     */
    @Update({
        "update order_t_order_info",
        "set ORDER_CODE = #{orderCode,jdbcType=CHAR},",
          "BUYER_ID = #{buyerId,jdbcType=BIGINT},",
          "BUYER_LOGIN = #{buyerLogin,jdbcType=VARCHAR},",
          "ORDER_STATE = #{orderState,jdbcType=CHAR},",
          "GOODS_COUNT = #{goodsCount,jdbcType=INTEGER},",
          "GOODS_PRICE = #{goodsPrice,jdbcType=DECIMAL},",
          "POST_PRICE = #{postPrice,jdbcType=DECIMAL},",
          "ORDER_PRICE = #{orderPrice,jdbcType=DECIMAL},",
          "GOODS_PAY_PRICE = #{goodsPayPrice,jdbcType=DECIMAL},",
          "POST_PAY_PRICE = #{postPayPrice,jdbcType=DECIMAL},",
          "ORDER_PAY_PRICE = #{orderPayPrice,jdbcType=DECIMAL},",
          "PAY_STYLE = #{payStyle,jdbcType=CHAR},",
          "BUY_ENTRANCE = #{buyEntrance,jdbcType=CHAR},",
          "AREA_CODE_PROVINCE = #{areaCodeProvince,jdbcType=VARCHAR},",
          "AREA_DESC_PROVINCE = #{areaDescProvince,jdbcType=VARCHAR},",
          "AREA_CODE_CITY = #{areaCodeCity,jdbcType=VARCHAR},",
          "AREA_DESC_CITY = #{areaDescCity,jdbcType=VARCHAR},",
          "AREA_CODE_COUNTY = #{areaCodeCounty,jdbcType=VARCHAR},",
          "AREA_DESC_COUNTY = #{areaDescCounty,jdbcType=VARCHAR},",
          "SCHOOL_NAME = #{schoolName,jdbcType=VARCHAR},",
          "GRADE_NAME = #{gradeName,jdbcType=VARCHAR},",
          "CLASS_NAME = #{className,jdbcType=VARCHAR},",
          "ADDRESS_DETAIL = #{addressDetail,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "EXPIRED_TIME = #{expiredTime,jdbcType=TIMESTAMP},",
          "UPDATE_PERSON = #{updatePerson,jdbcType=BIGINT},",
          "UPDATE_PERSON_NAME = #{updatePersonName,jdbcType=VARCHAR},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "RECEIVER_NAME = #{receiverName,jdbcType=VARCHAR},",
          "TEL_NO = #{telNo,jdbcType=VARCHAR},",
          "CODE_NUMBER = #{codeNumber,jdbcType=VARCHAR},",
          "CODE_URL = #{codeUrl,jdbcType=VARCHAR},",
          "REMARK = #{remark,jdbcType=VARCHAR},",
          "TRADE_STATE = #{tradeState,jdbcType=CHAR},",
          "SHOP_ID = #{shopId,jdbcType=BIGINT},",
          "STORE_ID = #{storeId,jdbcType=BIGINT},",
          "AGENT_USER_ID = #{agentUserId,jdbcType=BIGINT},",
          "IS_PICKUP = #{isPickup,jdbcType=CHAR},",
          "EXPRESS_CODE = #{expressCode,jdbcType=VARCHAR},",
          "EXPRESS_NAME = #{expressName,jdbcType=VARCHAR},",
          "EXPRESS_FEE = #{expressFee,jdbcType=VARCHAR},",
          "TRACK_NUMBER = #{trackNumber,jdbcType=VARCHAR},",
          "PAY_REMARK = #{payRemark,jdbcType=VARCHAR},",
          "PAY_UPDATE_PERSON = #{payUpdatePerson,jdbcType=BIGINT},",
          "PAY_UPDATE_PERSON_NAME = #{payUpdatePersonName,jdbcType=VARCHAR},",
          "PAY_UPDATE_TIME = #{payUpdateTime,jdbcType=TIMESTAMP},",
          "REFOUND_STATE = #{refoundState,jdbcType=CHAR},",
          "INVOICE = #{invoice,jdbcType=VARCHAR},",
          "PAY_TIME = #{payTime,jdbcType=TIMESTAMP},",
          "SEND_TIME = #{sendTime,jdbcType=TIMESTAMP},",
          "CONFIRM_TIME = #{confirmTime,jdbcType=TIMESTAMP},",
          "CONFIRM_CLOSING_TIME = #{confirmClosingTime,jdbcType=TIMESTAMP},",
          "DELAYED_RECEIVE_COUNT = #{delayedReceiveCount,jdbcType=INTEGER},",
          "IS_GROUP_BUY = #{isGroupBuy,jdbcType=CHAR},",
          "IS_REFUND = #{isRefund,jdbcType=CHAR},",
          "IS_APP_ORDER = #{isAppOrder,jdbcType=CHAR}",
        "where ORDER_ID = #{orderId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderInfoGenerateBean record);
}