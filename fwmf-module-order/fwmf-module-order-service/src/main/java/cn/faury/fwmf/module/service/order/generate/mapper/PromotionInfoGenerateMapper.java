/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-12-08 15:12:42
 */
package cn.faury.fwmf.module.service.order.generate.mapper;

import cn.faury.fwmf.module.api.order.bean.PromotionInfoBean;
import cn.faury.fwmf.module.api.order.generate.bean.PromotionInfoGenerateBean;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.PromotionInfoGenerateSqlProvider;
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

public interface PromotionInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_promotion_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Delete({
        "delete from order_t_promotion_info",
        "where PROMOTION_ID = #{promotionId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long promotionId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_promotion_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Insert({
        "insert into order_t_promotion_info (PROMOTION_ID, PROMOTION_NAME, ",
        "PROMOTION_SUBJECT, PROMOTION_CONDITION, ",
        "CONDITION_VALUE, MEET_OPERATION, ",
        "MEET_VALUE, PROMOTION_START_TIME, ",
        "PROMOTION_END_TIME, CREATE_PERSON, ",
        "CREATE_PERSON_NAME, CREATE_TIME, ",
        "UPDATE_PERSON, UPDATE_PERSON_NAME, ",
        "UPDATE_TIME)",
        "values (#{promotionId,jdbcType=BIGINT}, #{promotionName,jdbcType=VARCHAR}, ",
        "#{promotionSubject,jdbcType=CHAR}, #{promotionCondition,jdbcType=CHAR}, ",
        "#{conditionValue,jdbcType=DECIMAL}, #{meetOperation,jdbcType=VARCHAR}, ",
        "#{meetValue,jdbcType=DECIMAL}, #{promotionStartTime,jdbcType=TIMESTAMP}, ",
        "#{promotionEndTime,jdbcType=TIMESTAMP}, #{createPerson,jdbcType=BIGINT}, ",
        "#{createPersonName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updatePerson,jdbcType=BIGINT}, #{updatePersonName,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="promotionId")
    int insert(PromotionInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_promotion_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @InsertProvider(type=PromotionInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="promotionId")
    int insertSelective(PromotionInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_promotion_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @SelectProvider(type=PromotionInfoGenerateSqlProvider.class, method="search")
    @ResultType(PromotionInfoBean.class)
    List<PromotionInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_promotion_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Select({
        "select",
        "PROMOTION_ID, PROMOTION_NAME, PROMOTION_SUBJECT, PROMOTION_CONDITION, CONDITION_VALUE, ",
        "MEET_OPERATION, MEET_VALUE, PROMOTION_START_TIME, PROMOTION_END_TIME, CREATE_PERSON, ",
        "CREATE_PERSON_NAME, CREATE_TIME, UPDATE_PERSON, UPDATE_PERSON_NAME, UPDATE_TIME",
        "from order_t_promotion_info",
        "where PROMOTION_ID = #{promotionId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="PROMOTION_ID", property="promotionId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="PROMOTION_NAME", property="promotionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PROMOTION_SUBJECT", property="promotionSubject", jdbcType=JdbcType.CHAR),
        @Result(column="PROMOTION_CONDITION", property="promotionCondition", jdbcType=JdbcType.CHAR),
        @Result(column="CONDITION_VALUE", property="conditionValue", jdbcType=JdbcType.DECIMAL),
        @Result(column="MEET_OPERATION", property="meetOperation", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEET_VALUE", property="meetValue", jdbcType=JdbcType.DECIMAL),
        @Result(column="PROMOTION_START_TIME", property="promotionStartTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="PROMOTION_END_TIME", property="promotionEndTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="CREATE_PERSON", property="createPerson", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_PERSON_NAME", property="createPersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_PERSON", property="updatePerson", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_PERSON_NAME", property="updatePersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PromotionInfoBean selectByPrimaryKey(Long promotionId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_promotion_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @UpdateProvider(type=PromotionInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PromotionInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_promotion_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Update({
        "update order_t_promotion_info",
        "set PROMOTION_NAME = #{promotionName,jdbcType=VARCHAR},",
          "PROMOTION_SUBJECT = #{promotionSubject,jdbcType=CHAR},",
          "PROMOTION_CONDITION = #{promotionCondition,jdbcType=CHAR},",
          "CONDITION_VALUE = #{conditionValue,jdbcType=DECIMAL},",
          "MEET_OPERATION = #{meetOperation,jdbcType=VARCHAR},",
          "MEET_VALUE = #{meetValue,jdbcType=DECIMAL},",
          "PROMOTION_START_TIME = #{promotionStartTime,jdbcType=TIMESTAMP},",
          "PROMOTION_END_TIME = #{promotionEndTime,jdbcType=TIMESTAMP},",
          "CREATE_PERSON = #{createPerson,jdbcType=BIGINT},",
          "CREATE_PERSON_NAME = #{createPersonName,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_PERSON = #{updatePerson,jdbcType=BIGINT},",
          "UPDATE_PERSON_NAME = #{updatePersonName,jdbcType=VARCHAR},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where PROMOTION_ID = #{promotionId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PromotionInfoGenerateBean record);
}