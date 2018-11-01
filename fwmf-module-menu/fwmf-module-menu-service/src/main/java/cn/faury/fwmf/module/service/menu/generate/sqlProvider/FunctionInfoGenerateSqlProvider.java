/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-26 11:34:22
 */
package cn.faury.fwmf.module.service.menu.generate.sqlProvider;

import cn.faury.fwmf.module.api.menu.generate.bean.FunctionInfoGenerateBean;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class FunctionInfoGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_function_info
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public String insertSelective(FunctionInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_t_function_info");
        
        if (record.getFunctionId() != null) {
            sql.VALUES("FUNCTION_ID", "#{functionId,jdbcType=BIGINT}");
        }
        
        if (record.getFunctionName() != null) {
            sql.VALUES("FUNCTION_NAME", "#{functionName,jdbcType=VARCHAR}");
        }
        
        if (record.getFunctionCode() != null) {
            sql.VALUES("FUNCTION_CODE", "#{functionCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuId() != null) {
            sql.VALUES("MENU_ID", "#{menuId,jdbcType=BIGINT}");
        }
        
        if (record.getIsAvailable() != null) {
            sql.VALUES("IS_AVAILABLE", "#{isAvailable,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_function_info
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public String updateByPrimaryKeySelective(FunctionInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_t_function_info");
        
        if (record.getFunctionName() != null) {
            sql.SET("FUNCTION_NAME = #{functionName,jdbcType=VARCHAR}");
        }
        
        if (record.getFunctionCode() != null) {
            sql.SET("FUNCTION_CODE = #{functionCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMenuId() != null) {
            sql.SET("MENU_ID = #{menuId,jdbcType=BIGINT}");
        }
        
        if (record.getIsAvailable() != null) {
            sql.SET("IS_AVAILABLE = #{isAvailable,jdbcType=CHAR}");
        }
        
        sql.WHERE("FUNCTION_ID = #{functionId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_function_info
     *
     * @fwmf.generated 2018-09-26 11:34:22
     */
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("FUNCTION_ID, FUNCTION_NAME, FUNCTION_CODE, MENU_ID, IS_AVAILABLE");
        
        sql.FROM("sys_t_function_info");
        
        if (params.get("functionId")!=null){
            sql.WHERE("FUNCTION_ID=#{functionId,jdbcType=BIGINT}");
        }
        if (params.get("functionName")!=null){
            sql.WHERE("FUNCTION_NAME=#{functionName,jdbcType=VARCHAR}");
        }
        if (params.get("functionNameLike")!=null){
            sql.WHERE("FUNCTION_NAME LIKE CONCAT('%',#{functionNameLike,jdbcType=VARCHAR},'%')");
        }
        if (params.get("functionCode")!=null){
            sql.WHERE("FUNCTION_CODE=#{functionCode,jdbcType=VARCHAR}");
        }
        if (params.get("functionCodeLike")!=null){
            sql.WHERE("FUNCTION_CODE LIKE CONCAT('%',#{functionCodeLike,jdbcType=VARCHAR},'%')");
        }
        if (params.get("menuId")!=null){
            sql.WHERE("MENU_ID=#{menuId,jdbcType=BIGINT}");
        }
        if (params.get("isAvailable")!=null){
            sql.WHERE("IS_AVAILABLE=#{isAvailable,jdbcType=CHAR}");
        }
        if (params.get("isAvailableLike")!=null){
            sql.WHERE("IS_AVAILABLE LIKE CONCAT('%',#{isAvailableLike,jdbcType=CHAR},'%')");
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