/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-21 15:16:46
 */
package cn.faury.fwmf.module.service.user.generate.sqlProvider;

import cn.faury.fwmf.module.api.user.generate.bean.UserInfoGenerateBean;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserInfoGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2018-09-21 15:16:46
     */
    public String insertSelective(UserInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_t_user_info");
        
        if (record.getUserId() != null) {
            sql.VALUES("USER_ID", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getLoginName() != null) {
            sql.VALUES("LOGIN_NAME", "#{loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("USER_NAME", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("PASSWORD", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getEfctYmd() != null) {
            sql.VALUES("EFCT_YMD", "#{efctYmd,jdbcType=DATE}");
        }
        
        if (record.getExprYmd() != null) {
            sql.VALUES("EXPR_YMD", "#{exprYmd,jdbcType=DATE}");
        }
        
        if (record.getInsTstmp() != null) {
            sql.VALUES("INS_TSTMP", "#{insTstmp,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOriginOsId() != null) {
            sql.VALUES("ORIGIN_OS_ID", "#{originOsId,jdbcType=BIGINT}");
        }
        
        if (record.getUserType() != null) {
            sql.VALUES("USER_TYPE", "#{userType,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEnable() != null) {
            sql.VALUES("IS_ENABLE", "#{isEnable,jdbcType=CHAR}");
        }
        
        if (record.getIsDelete() != null) {
            sql.VALUES("IS_DELETE", "#{isDelete,jdbcType=CHAR}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.VALUES("CREATE_PERSON", "#{createPerson,jdbcType=BIGINT}");
        }
        
        if (record.getCreatePersonName() != null) {
            sql.VALUES("CREATE_PERSON_NAME", "#{createPersonName,jdbcType=VARCHAR}");
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
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2018-09-21 15:16:46
     */
    public String updateByPrimaryKeySelective(UserInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_t_user_info");
        
        if (record.getLoginName() != null) {
            sql.SET("LOGIN_NAME = #{loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("USER_NAME = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("PASSWORD = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getEfctYmd() != null) {
            sql.SET("EFCT_YMD = #{efctYmd,jdbcType=DATE}");
        }
        
        if (record.getExprYmd() != null) {
            sql.SET("EXPR_YMD = #{exprYmd,jdbcType=DATE}");
        }
        
        if (record.getInsTstmp() != null) {
            sql.SET("INS_TSTMP = #{insTstmp,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOriginOsId() != null) {
            sql.SET("ORIGIN_OS_ID = #{originOsId,jdbcType=BIGINT}");
        }
        
        if (record.getUserType() != null) {
            sql.SET("USER_TYPE = #{userType,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEnable() != null) {
            sql.SET("IS_ENABLE = #{isEnable,jdbcType=CHAR}");
        }
        
        if (record.getIsDelete() != null) {
            sql.SET("IS_DELETE = #{isDelete,jdbcType=CHAR}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.SET("CREATE_PERSON = #{createPerson,jdbcType=BIGINT}");
        }
        
        if (record.getCreatePersonName() != null) {
            sql.SET("CREATE_PERSON_NAME = #{createPersonName,jdbcType=VARCHAR}");
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
        
        sql.WHERE("USER_ID = #{userId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2018-09-21 15:16:46
     */
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("USER_ID, LOGIN_NAME, USER_NAME, PASSWORD, EFCT_YMD, EXPR_YMD, INS_TSTMP, ORIGIN_OS_ID");
        sql.SELECT("USER_TYPE, IS_ENABLE, IS_DELETE, CREATE_PERSON, CREATE_PERSON_NAME, UPDATE_PERSON");
        sql.SELECT("UPDATE_PERSON_NAME, UPDATE_TIME");
        
        sql.FROM("sys_t_user_info");
        
        if (params.get("userId")!=null){
            sql.WHERE("USER_ID=#{userId,jdbcType=BIGINT}");
        }
        if (params.get("loginName")!=null){
            sql.WHERE("LOGIN_NAME=#{loginName,jdbcType=VARCHAR}");
        }
        if (params.get("loginNameLike")!=null){
            sql.WHERE("LOGIN_NAME LIKE CONCAT('%',#{loginNameLike,jdbcType=VARCHAR},'%')");
        }
        if (params.get("userName")!=null){
            sql.WHERE("USER_NAME=#{userName,jdbcType=VARCHAR}");
        }
        if (params.get("userNameLike")!=null){
            sql.WHERE("USER_NAME LIKE CONCAT('%',#{userNameLike,jdbcType=VARCHAR},'%')");
        }
        if (params.get("password")!=null){
            sql.WHERE("PASSWORD=#{password,jdbcType=VARCHAR}");
        }
        if (params.get("passwordLike")!=null){
            sql.WHERE("PASSWORD LIKE CONCAT('%',#{passwordLike,jdbcType=VARCHAR},'%')");
        }
        if (params.get("efctYmd")!=null){
            sql.WHERE("EFCT_YMD=#{efctYmd,jdbcType=DATE}");
        }
        if (params.get("efctYmdStart")!=null){
            sql.WHERE("EFCT_YMD >= #{efctYmdStart,jdbcType=DATE}");
        }
        if (params.get("efctYmdEnd")!=null){
            sql.WHERE("EFCT_YMD <= #{efctYmdEnd,jdbcType=DATE}");
        }
        if (params.get("exprYmd")!=null){
            sql.WHERE("EXPR_YMD=#{exprYmd,jdbcType=DATE}");
        }
        if (params.get("exprYmdStart")!=null){
            sql.WHERE("EXPR_YMD >= #{exprYmdStart,jdbcType=DATE}");
        }
        if (params.get("exprYmdEnd")!=null){
            sql.WHERE("EXPR_YMD <= #{exprYmdEnd,jdbcType=DATE}");
        }
        if (params.get("insTstmp")!=null){
            sql.WHERE("INS_TSTMP=#{insTstmp,jdbcType=TIMESTAMP}");
        }
        if (params.get("insTstmpStart")!=null){
            sql.WHERE("INS_TSTMP >= #{insTstmpStart,jdbcType=TIMESTAMP}");
        }
        if (params.get("insTstmpEnd")!=null){
            sql.WHERE("INS_TSTMP <= #{insTstmpEnd,jdbcType=TIMESTAMP}");
        }
        if (params.get("originOsId")!=null){
            sql.WHERE("ORIGIN_OS_ID=#{originOsId,jdbcType=BIGINT}");
        }
        if (params.get("userType")!=null){
            sql.WHERE("USER_TYPE=#{userType,jdbcType=VARCHAR}");
        }
        if (params.get("userTypeLike")!=null){
            sql.WHERE("USER_TYPE LIKE CONCAT('%',#{userTypeLike,jdbcType=VARCHAR},'%')");
        }
        if (params.get("isEnable")!=null){
            sql.WHERE("IS_ENABLE=#{isEnable,jdbcType=CHAR}");
        }
        if (params.get("isEnableLike")!=null){
            sql.WHERE("IS_ENABLE LIKE CONCAT('%',#{isEnableLike,jdbcType=CHAR},'%')");
        }
        if (params.get("isDelete")!=null){
            sql.WHERE("IS_DELETE=#{isDelete,jdbcType=CHAR}");
        }
        if (params.get("isDeleteLike")!=null){
            sql.WHERE("IS_DELETE LIKE CONCAT('%',#{isDeleteLike,jdbcType=CHAR},'%')");
        }
        if (params.get("createPerson")!=null){
            sql.WHERE("CREATE_PERSON=#{createPerson,jdbcType=BIGINT}");
        }
        if (params.get("createPersonName")!=null){
            sql.WHERE("CREATE_PERSON_NAME=#{createPersonName,jdbcType=VARCHAR}");
        }
        if (params.get("createPersonNameLike")!=null){
            sql.WHERE("CREATE_PERSON_NAME LIKE CONCAT('%',#{createPersonNameLike,jdbcType=VARCHAR},'%')");
        }
        if (params.get("updatePerson")!=null){
            sql.WHERE("UPDATE_PERSON=#{updatePerson,jdbcType=BIGINT}");
        }
        if (params.get("updatePersonName")!=null){
            sql.WHERE("UPDATE_PERSON_NAME=#{updatePersonName,jdbcType=VARCHAR}");
        }
        if (params.get("updatePersonNameLike")!=null){
            sql.WHERE("UPDATE_PERSON_NAME LIKE CONCAT('%',#{updatePersonNameLike,jdbcType=VARCHAR},'%')");
        }
        if (params.get("updateTime")!=null){
            sql.WHERE("UPDATE_TIME=#{updateTime,jdbcType=TIMESTAMP}");
        }
        if (params.get("updateTimeStart")!=null){
            sql.WHERE("UPDATE_TIME >= #{updateTimeStart,jdbcType=TIMESTAMP}");
        }
        if (params.get("updateTimeEnd")!=null){
            sql.WHERE("UPDATE_TIME <= #{updateTimeEnd,jdbcType=TIMESTAMP}");
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