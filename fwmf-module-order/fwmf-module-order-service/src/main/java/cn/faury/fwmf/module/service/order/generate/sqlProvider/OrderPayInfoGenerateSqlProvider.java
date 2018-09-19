package cn.faury.fwmf.module.service.order.generate.sqlProvider;

import cn.faury.fwmf.module.api.order.generate.bean.OrderPayInfoGenerateBean;
import org.apache.ibatis.jdbc.SQL;

public class OrderPayInfoGenerateSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_order_pay_info
     *
     * @mbg.generated Mon Aug 06 14:43:55 CST 2018
     */
    public String insertSelective(OrderPayInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_t_order_pay_info");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getOrderId() != null) {
            sql.VALUES("ORDER_ID", "#{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getPayAmount() != null) {
            sql.VALUES("PAY_AMOUNT", "#{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayState() != null) {
            sql.VALUES("PAY_STATE", "#{payState,jdbcType=CHAR}");
        }
        
        if (record.getPayTime() != null) {
            sql.VALUES("PAY_TIME", "#{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayStyle() != null) {
            sql.VALUES("PAY_STYLE", "#{payStyle,jdbcType=CHAR}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.VALUES("CREATE_PERSON", "#{createPerson,jdbcType=BIGINT}");
        }
        
        if (record.getCreatePersonName() != null) {
            sql.VALUES("CREATE_PERSON_NAME", "#{createPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatePerson() != null) {
            sql.VALUES("UPDATE_PERSON", "#{updatePerson,jdbcType=BIGINT}");
        }
        
        if (record.getUpdatePersonName() != null) {
            sql.VALUES("UPDATE_PERSON_NAME", "#{updatePersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDzState() != null) {
            sql.VALUES("DZ_STATE", "#{dzState,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_order_pay_info
     *
     * @mbg.generated Mon Aug 06 14:43:55 CST 2018
     */
    public String updateByPrimaryKeySelective(OrderPayInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("order_t_order_pay_info");
        
        if (record.getOrderId() != null) {
            sql.SET("ORDER_ID = #{orderId,jdbcType=BIGINT}");
        }
        
        if (record.getPayAmount() != null) {
            sql.SET("PAY_AMOUNT = #{payAmount,jdbcType=DECIMAL}");
        }
        
        if (record.getPayState() != null) {
            sql.SET("PAY_STATE = #{payState,jdbcType=CHAR}");
        }
        
        if (record.getPayTime() != null) {
            sql.SET("PAY_TIME = #{payTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPayStyle() != null) {
            sql.SET("PAY_STYLE = #{payStyle,jdbcType=CHAR}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.SET("CREATE_PERSON = #{createPerson,jdbcType=BIGINT}");
        }
        
        if (record.getCreatePersonName() != null) {
            sql.SET("CREATE_PERSON_NAME = #{createPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatePerson() != null) {
            sql.SET("UPDATE_PERSON = #{updatePerson,jdbcType=BIGINT}");
        }
        
        if (record.getUpdatePersonName() != null) {
            sql.SET("UPDATE_PERSON_NAME = #{updatePersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDzState() != null) {
            sql.SET("DZ_STATE = #{dzState,jdbcType=INTEGER}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}