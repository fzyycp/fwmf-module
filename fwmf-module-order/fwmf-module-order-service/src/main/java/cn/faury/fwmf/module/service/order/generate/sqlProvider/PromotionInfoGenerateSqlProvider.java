package cn.faury.fwmf.module.service.order.generate.sqlProvider;

import cn.faury.fwmf.module.api.order.generate.bean.PromotionInfoGenerateBean;
import org.apache.ibatis.jdbc.SQL;

public class PromotionInfoGenerateSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_promotion_info
     *
     * @mbg.generated Sat Aug 04 17:17:43 CST 2018
     */
    public String insertSelective(PromotionInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_t_promotion_info");
        
        sql.VALUES("PROMOTION_ID", "#{promotionId,jdbcType=BIGINT}");
        
        if (record.getPromotionName() != null) {
            sql.VALUES("PROMOTION_NAME", "#{promotionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionSubject() != null) {
            sql.VALUES("PROMOTION_SUBJECT", "#{promotionSubject,jdbcType=CHAR}");
        }
        
        if (record.getPromotionCondition() != null) {
            sql.VALUES("PROMOTION_CONDITION", "#{promotionCondition,jdbcType=CHAR}");
        }
        
        if (record.getConditionValue() != null) {
            sql.VALUES("CONDITION_VALUE", "#{conditionValue,jdbcType=DECIMAL}");
        }
        
        if (record.getMeetOperation() != null) {
            sql.VALUES("MEET_OPERATION", "#{meetOperation,jdbcType=VARCHAR}");
        }
        
        if (record.getMeetValue() != null) {
            sql.VALUES("MEET_VALUE", "#{meetValue,jdbcType=DECIMAL}");
        }
        
        if (record.getPromotionStartTime() != null) {
            sql.VALUES("PROMOTION_START_TIME", "#{promotionStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPromotionEndTime() != null) {
            sql.VALUES("PROMOTION_END_TIME", "#{promotionEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.VALUES("CREATE_PERSON", "#{createPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatePerson() != null) {
            sql.VALUES("UPDATE_PERSON", "#{updatePerson,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_promotion_info
     *
     * @mbg.generated Sat Aug 04 17:17:43 CST 2018
     */
    public String updateByPrimaryKeySelective(PromotionInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("order_t_promotion_info");
        
        if (record.getPromotionName() != null) {
            sql.SET("PROMOTION_NAME = #{promotionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPromotionSubject() != null) {
            sql.SET("PROMOTION_SUBJECT = #{promotionSubject,jdbcType=CHAR}");
        }
        
        if (record.getPromotionCondition() != null) {
            sql.SET("PROMOTION_CONDITION = #{promotionCondition,jdbcType=CHAR}");
        }
        
        if (record.getConditionValue() != null) {
            sql.SET("CONDITION_VALUE = #{conditionValue,jdbcType=DECIMAL}");
        }
        
        if (record.getMeetOperation() != null) {
            sql.SET("MEET_OPERATION = #{meetOperation,jdbcType=VARCHAR}");
        }
        
        if (record.getMeetValue() != null) {
            sql.SET("MEET_VALUE = #{meetValue,jdbcType=DECIMAL}");
        }
        
        if (record.getPromotionStartTime() != null) {
            sql.SET("PROMOTION_START_TIME = #{promotionStartTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPromotionEndTime() != null) {
            sql.SET("PROMOTION_END_TIME = #{promotionEndTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.SET("CREATE_PERSON = #{createPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatePerson() != null) {
            sql.SET("UPDATE_PERSON = #{updatePerson,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("PROMOTION_ID = #{promotionId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}