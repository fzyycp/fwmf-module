/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-21 17:22:30
 */
package cn.faury.fwmf.module.service.role.generate.sqlProvider;

import cn.faury.fwmf.module.api.role.generate.bean.UserRRoleGenerateBean;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserRRoleGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_r_role
     *
     * @fwmf.generated 2018-09-21 17:22:30
     */
    public String insertSelective(UserRRoleGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_t_user_r_role");
        
        if (record.getId() != null) {
            sql.VALUES("ID", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("USER_ID", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getRoleId() != null) {
            sql.VALUES("ROLE_ID", "#{roleId,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_r_role
     *
     * @fwmf.generated 2018-09-21 17:22:30
     */
    public String updateByPrimaryKeySelective(UserRRoleGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_t_user_r_role");
        
        if (record.getUserId() != null) {
            sql.SET("USER_ID = #{userId,jdbcType=BIGINT}");
        }
        
        if (record.getRoleId() != null) {
            sql.SET("ROLE_ID = #{roleId,jdbcType=BIGINT}");
        }
        
        sql.WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_r_role
     *
     * @fwmf.generated 2018-09-21 17:22:30
     */
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("ID, USER_ID, ROLE_ID");
        
        sql.FROM("sys_t_user_r_role");
        
        if (params.get("id")!=null){
            sql.WHERE("ID=#{id,jdbcType=BIGINT}");
        }
        if (params.get("userId")!=null){
            sql.WHERE("USER_ID=#{userId,jdbcType=BIGINT}");
        }
        if (params.get("roleId")!=null){
            sql.WHERE("ROLE_ID=#{roleId,jdbcType=BIGINT}");
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