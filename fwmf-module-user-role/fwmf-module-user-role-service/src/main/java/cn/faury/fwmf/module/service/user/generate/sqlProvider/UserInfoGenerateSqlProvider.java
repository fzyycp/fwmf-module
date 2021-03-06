/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2019-02-18 10:33:36
 */
package cn.faury.fwmf.module.service.user.generate.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.user.generate.bean.UserInfoGenerateBean;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class UserInfoGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2019-02-18 10:33:36
     */
    public String insertSelective(UserInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_t_user_info");
        
        if (record.getUserId() != null) {
            sql.VALUES("`USER_ID`", "#{userId,jdbcType=BIGINT}");
        }
        
        if (record.getLoginName() != null) {
            sql.VALUES("`LOGIN_NAME`", "#{loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("`USER_NAME`", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("`PASSWORD`", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getEfctYmd() != null) {
            sql.VALUES("`EFCT_YMD`", "#{efctYmd,jdbcType=DATE}");
        }
        
        if (record.getExprYmd() != null) {
            sql.VALUES("`EXPR_YMD`", "#{exprYmd,jdbcType=DATE}");
        }
        
        if (record.getInsTstmp() != null) {
            sql.VALUES("`INS_TSTMP`", "#{insTstmp,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOriginOsId() != null) {
            sql.VALUES("`ORIGIN_OS_ID`", "#{originOsId,jdbcType=BIGINT}");
        }
        
        if (record.getUserType() != null) {
            sql.VALUES("`USER_TYPE`", "#{userType,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEnable() != null) {
            sql.VALUES("`IS_ENABLE`", "#{isEnable,jdbcType=CHAR}");
        }
        
        if (record.getIsDelete() != null) {
            sql.VALUES("`IS_DELETE`", "#{isDelete,jdbcType=CHAR}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.VALUES("`CREATE_PERSON`", "#{createPerson,jdbcType=BIGINT}");
        }
        
        if (record.getCreatePersonName() != null) {
            sql.VALUES("`CREATE_PERSON_NAME`", "#{createPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdatePerson() != null) {
            sql.VALUES("`UPDATE_PERSON`", "#{updatePerson,jdbcType=BIGINT}");
        }
        
        if (record.getUpdatePersonName() != null) {
            sql.VALUES("`UPDATE_PERSON_NAME`", "#{updatePersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("`UPDATE_TIME`", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2019-02-18 10:33:36
     */
    public String updateByPrimaryKeySelective(UserInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_t_user_info");
        
        if (record.getLoginName() != null) {
            sql.SET("`LOGIN_NAME` = #{loginName,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("`USER_NAME` = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("`PASSWORD` = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getEfctYmd() != null) {
            sql.SET("`EFCT_YMD` = #{efctYmd,jdbcType=DATE}");
        }
        
        if (record.getExprYmd() != null) {
            sql.SET("`EXPR_YMD` = #{exprYmd,jdbcType=DATE}");
        }
        
        if (record.getInsTstmp() != null) {
            sql.SET("`INS_TSTMP` = #{insTstmp,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOriginOsId() != null) {
            sql.SET("`ORIGIN_OS_ID` = #{originOsId,jdbcType=BIGINT}");
        }
        
        if (record.getUserType() != null) {
            sql.SET("`USER_TYPE` = #{userType,jdbcType=VARCHAR}");
        }
        
        if (record.getIsEnable() != null) {
            sql.SET("`IS_ENABLE` = #{isEnable,jdbcType=CHAR}");
        }
        
        if (record.getIsDelete() != null) {
            sql.SET("`IS_DELETE` = #{isDelete,jdbcType=CHAR}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.SET("`CREATE_PERSON` = #{createPerson,jdbcType=BIGINT}");
        }
        
        if (record.getCreatePersonName() != null) {
            sql.SET("`CREATE_PERSON_NAME` = #{createPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdatePerson() != null) {
            sql.SET("`UPDATE_PERSON` = #{updatePerson,jdbcType=BIGINT}");
        }
        
        if (record.getUpdatePersonName() != null) {
            sql.SET("`UPDATE_PERSON_NAME` = #{updatePersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("`UPDATE_TIME` = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("`USER_ID` = #{userId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2019-02-18 10:33:36
     */
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("`USER_ID`, `LOGIN_NAME`, `USER_NAME`, `PASSWORD`, `EFCT_YMD`, `EXPR_YMD`, `INS_TSTMP`");
        sql.SELECT("`ORIGIN_OS_ID`, `USER_TYPE`, `IS_ENABLE`, `IS_DELETE`, `CREATE_PERSON`, `CREATE_PERSON_NAME`");
        sql.SELECT("`UPDATE_PERSON`, `UPDATE_PERSON_NAME`, `UPDATE_TIME`");
        
        sql.FROM("sys_t_user_info");
        
        if (params.get("userId") != null){
            if (!(params.get("userId") instanceof String) || StringUtil.isNotEmpty((String) params.get("userId"))){
                sql.WHERE("`USER_ID`=#{userId,jdbcType=BIGINT}");
            }
        }
        if (params.get("userIdNotEqual") != null){
            if (!(params.get("userIdNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("userIdNotEqual"))){
                sql.WHERE("`USER_ID` <> #{userIdNotEqual,jdbcType=BIGINT}");
            }
        }
        if (params.get("userIdInList") != null && params.get("userIdInList") instanceof List) {
            List list = (List) params.get("userIdInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{userIdInList[").append(i).append("],jdbcType=BIGINT},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`USER_ID` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("ids") != null && params.get("ids") instanceof List) {
            List list = (List) params.get("ids");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{ids[").append(i).append("],jdbcType=BIGINT},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`USER_ID` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("loginName") != null){
            if (!(params.get("loginName") instanceof String) || StringUtil.isNotEmpty((String) params.get("loginName"))){
                sql.WHERE("`LOGIN_NAME`=#{loginName,jdbcType=VARCHAR}");
            }
        }
        if (params.get("loginNameNotEqual") != null){
            if (!(params.get("loginNameNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("loginNameNotEqual"))){
                sql.WHERE("`LOGIN_NAME` <> #{loginNameNotEqual,jdbcType=VARCHAR}");
            }
        }
        if (params.get("loginNameInList") != null && params.get("loginNameInList") instanceof List) {
            List list = (List) params.get("loginNameInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{loginNameInList[").append(i).append("],jdbcType=VARCHAR},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`LOGIN_NAME` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("loginNameLike")!=null){
            if (!(params.get("loginNameLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("loginNameLike"))){
                sql.WHERE("`LOGIN_NAME` LIKE CONCAT('%',#{loginNameLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("userName") != null){
            if (!(params.get("userName") instanceof String) || StringUtil.isNotEmpty((String) params.get("userName"))){
                sql.WHERE("`USER_NAME`=#{userName,jdbcType=VARCHAR}");
            }
        }
        if (params.get("userNameNotEqual") != null){
            if (!(params.get("userNameNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("userNameNotEqual"))){
                sql.WHERE("`USER_NAME` <> #{userNameNotEqual,jdbcType=VARCHAR}");
            }
        }
        if (params.get("userNameInList") != null && params.get("userNameInList") instanceof List) {
            List list = (List) params.get("userNameInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{userNameInList[").append(i).append("],jdbcType=VARCHAR},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`USER_NAME` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("userNameLike")!=null){
            if (!(params.get("userNameLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("userNameLike"))){
                sql.WHERE("`USER_NAME` LIKE CONCAT('%',#{userNameLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("password") != null){
            if (!(params.get("password") instanceof String) || StringUtil.isNotEmpty((String) params.get("password"))){
                sql.WHERE("`PASSWORD`=#{password,jdbcType=VARCHAR}");
            }
        }
        if (params.get("passwordNotEqual") != null){
            if (!(params.get("passwordNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("passwordNotEqual"))){
                sql.WHERE("`PASSWORD` <> #{passwordNotEqual,jdbcType=VARCHAR}");
            }
        }
        if (params.get("passwordInList") != null && params.get("passwordInList") instanceof List) {
            List list = (List) params.get("passwordInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{passwordInList[").append(i).append("],jdbcType=VARCHAR},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`PASSWORD` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("passwordLike")!=null){
            if (!(params.get("passwordLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("passwordLike"))){
                sql.WHERE("`PASSWORD` LIKE CONCAT('%',#{passwordLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("efctYmd") != null){
            if (!(params.get("efctYmd") instanceof String) || StringUtil.isNotEmpty((String) params.get("efctYmd"))){
                sql.WHERE("`EFCT_YMD`=#{efctYmd,jdbcType=DATE}");
            }
        }
        if (params.get("efctYmdNotEqual") != null){
            if (!(params.get("efctYmdNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("efctYmdNotEqual"))){
                sql.WHERE("`EFCT_YMD` <> #{efctYmdNotEqual,jdbcType=DATE}");
            }
        }
        if (params.get("efctYmdInList") != null && params.get("efctYmdInList") instanceof List) {
            List list = (List) params.get("efctYmdInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{efctYmdInList[").append(i).append("],jdbcType=DATE},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`EFCT_YMD` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("efctYmdStart")!=null){
            if (!(params.get("efctYmdStart") instanceof String) || StringUtil.isNotEmpty((String) params.get("efctYmdStart"))){
                sql.WHERE("`EFCT_YMD` >= #{efctYmdStart,jdbcType=DATE}");
            }
        }
        if (params.get("efctYmdEnd")!=null){
            if (!(params.get("efctYmdEnd") instanceof String) || StringUtil.isNotEmpty((String) params.get("efctYmdEnd"))){
                sql.WHERE("`EFCT_YMD` <= #{efctYmdEnd,jdbcType=DATE}");
            }
        }
        if (params.get("exprYmd") != null){
            if (!(params.get("exprYmd") instanceof String) || StringUtil.isNotEmpty((String) params.get("exprYmd"))){
                sql.WHERE("`EXPR_YMD`=#{exprYmd,jdbcType=DATE}");
            }
        }
        if (params.get("exprYmdNotEqual") != null){
            if (!(params.get("exprYmdNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("exprYmdNotEqual"))){
                sql.WHERE("`EXPR_YMD` <> #{exprYmdNotEqual,jdbcType=DATE}");
            }
        }
        if (params.get("exprYmdInList") != null && params.get("exprYmdInList") instanceof List) {
            List list = (List) params.get("exprYmdInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{exprYmdInList[").append(i).append("],jdbcType=DATE},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`EXPR_YMD` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("exprYmdStart")!=null){
            if (!(params.get("exprYmdStart") instanceof String) || StringUtil.isNotEmpty((String) params.get("exprYmdStart"))){
                sql.WHERE("`EXPR_YMD` >= #{exprYmdStart,jdbcType=DATE}");
            }
        }
        if (params.get("exprYmdEnd")!=null){
            if (!(params.get("exprYmdEnd") instanceof String) || StringUtil.isNotEmpty((String) params.get("exprYmdEnd"))){
                sql.WHERE("`EXPR_YMD` <= #{exprYmdEnd,jdbcType=DATE}");
            }
        }
        if (params.get("insTstmp") != null){
            if (!(params.get("insTstmp") instanceof String) || StringUtil.isNotEmpty((String) params.get("insTstmp"))){
                sql.WHERE("`INS_TSTMP`=#{insTstmp,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("insTstmpNotEqual") != null){
            if (!(params.get("insTstmpNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("insTstmpNotEqual"))){
                sql.WHERE("`INS_TSTMP` <> #{insTstmpNotEqual,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("insTstmpInList") != null && params.get("insTstmpInList") instanceof List) {
            List list = (List) params.get("insTstmpInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{insTstmpInList[").append(i).append("],jdbcType=TIMESTAMP},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`INS_TSTMP` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("insTstmpStart")!=null){
            if (!(params.get("insTstmpStart") instanceof String) || StringUtil.isNotEmpty((String) params.get("insTstmpStart"))){
                sql.WHERE("`INS_TSTMP` >= #{insTstmpStart,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("insTstmpEnd")!=null){
            if (!(params.get("insTstmpEnd") instanceof String) || StringUtil.isNotEmpty((String) params.get("insTstmpEnd"))){
                sql.WHERE("`INS_TSTMP` <= #{insTstmpEnd,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("originOsId") != null){
            if (!(params.get("originOsId") instanceof String) || StringUtil.isNotEmpty((String) params.get("originOsId"))){
                sql.WHERE("`ORIGIN_OS_ID`=#{originOsId,jdbcType=BIGINT}");
            }
        }
        if (params.get("originOsIdNotEqual") != null){
            if (!(params.get("originOsIdNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("originOsIdNotEqual"))){
                sql.WHERE("`ORIGIN_OS_ID` <> #{originOsIdNotEqual,jdbcType=BIGINT}");
            }
        }
        if (params.get("originOsIdInList") != null && params.get("originOsIdInList") instanceof List) {
            List list = (List) params.get("originOsIdInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{originOsIdInList[").append(i).append("],jdbcType=BIGINT},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`ORIGIN_OS_ID` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("userType") != null){
            if (!(params.get("userType") instanceof String) || StringUtil.isNotEmpty((String) params.get("userType"))){
                sql.WHERE("`USER_TYPE`=#{userType,jdbcType=VARCHAR}");
            }
        }
        if (params.get("userTypeNotEqual") != null){
            if (!(params.get("userTypeNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("userTypeNotEqual"))){
                sql.WHERE("`USER_TYPE` <> #{userTypeNotEqual,jdbcType=VARCHAR}");
            }
        }
        if (params.get("userTypeInList") != null && params.get("userTypeInList") instanceof List) {
            List list = (List) params.get("userTypeInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{userTypeInList[").append(i).append("],jdbcType=VARCHAR},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`USER_TYPE` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("userTypeLike")!=null){
            if (!(params.get("userTypeLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("userTypeLike"))){
                sql.WHERE("`USER_TYPE` LIKE CONCAT('%',#{userTypeLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("isEnable") != null){
            if (!(params.get("isEnable") instanceof String) || StringUtil.isNotEmpty((String) params.get("isEnable"))){
                sql.WHERE("`IS_ENABLE`=#{isEnable,jdbcType=CHAR}");
            }
        }
        if (params.get("isEnableNotEqual") != null){
            if (!(params.get("isEnableNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("isEnableNotEqual"))){
                sql.WHERE("`IS_ENABLE` <> #{isEnableNotEqual,jdbcType=CHAR}");
            }
        }
        if (params.get("isEnableInList") != null && params.get("isEnableInList") instanceof List) {
            List list = (List) params.get("isEnableInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{isEnableInList[").append(i).append("],jdbcType=CHAR},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`IS_ENABLE` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("isEnableLike")!=null){
            if (!(params.get("isEnableLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("isEnableLike"))){
                sql.WHERE("`IS_ENABLE` LIKE CONCAT('%',#{isEnableLike,jdbcType=CHAR},'%')");
            }
        }
        if (params.get("isDelete") != null){
            if (!(params.get("isDelete") instanceof String) || StringUtil.isNotEmpty((String) params.get("isDelete"))){
                sql.WHERE("`IS_DELETE`=#{isDelete,jdbcType=CHAR}");
            }
        }
        if (params.get("isDeleteNotEqual") != null){
            if (!(params.get("isDeleteNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("isDeleteNotEqual"))){
                sql.WHERE("`IS_DELETE` <> #{isDeleteNotEqual,jdbcType=CHAR}");
            }
        }
        if (params.get("isDeleteInList") != null && params.get("isDeleteInList") instanceof List) {
            List list = (List) params.get("isDeleteInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{isDeleteInList[").append(i).append("],jdbcType=CHAR},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`IS_DELETE` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("isDeleteLike")!=null){
            if (!(params.get("isDeleteLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("isDeleteLike"))){
                sql.WHERE("`IS_DELETE` LIKE CONCAT('%',#{isDeleteLike,jdbcType=CHAR},'%')");
            }
        }
        if (params.get("createPerson") != null){
            if (!(params.get("createPerson") instanceof String) || StringUtil.isNotEmpty((String) params.get("createPerson"))){
                sql.WHERE("`CREATE_PERSON`=#{createPerson,jdbcType=BIGINT}");
            }
        }
        if (params.get("createPersonNotEqual") != null){
            if (!(params.get("createPersonNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("createPersonNotEqual"))){
                sql.WHERE("`CREATE_PERSON` <> #{createPersonNotEqual,jdbcType=BIGINT}");
            }
        }
        if (params.get("createPersonInList") != null && params.get("createPersonInList") instanceof List) {
            List list = (List) params.get("createPersonInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{createPersonInList[").append(i).append("],jdbcType=BIGINT},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`CREATE_PERSON` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("createPersonName") != null){
            if (!(params.get("createPersonName") instanceof String) || StringUtil.isNotEmpty((String) params.get("createPersonName"))){
                sql.WHERE("`CREATE_PERSON_NAME`=#{createPersonName,jdbcType=VARCHAR}");
            }
        }
        if (params.get("createPersonNameNotEqual") != null){
            if (!(params.get("createPersonNameNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("createPersonNameNotEqual"))){
                sql.WHERE("`CREATE_PERSON_NAME` <> #{createPersonNameNotEqual,jdbcType=VARCHAR}");
            }
        }
        if (params.get("createPersonNameInList") != null && params.get("createPersonNameInList") instanceof List) {
            List list = (List) params.get("createPersonNameInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{createPersonNameInList[").append(i).append("],jdbcType=VARCHAR},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`CREATE_PERSON_NAME` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("createPersonNameLike")!=null){
            if (!(params.get("createPersonNameLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("createPersonNameLike"))){
                sql.WHERE("`CREATE_PERSON_NAME` LIKE CONCAT('%',#{createPersonNameLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("updatePerson") != null){
            if (!(params.get("updatePerson") instanceof String) || StringUtil.isNotEmpty((String) params.get("updatePerson"))){
                sql.WHERE("`UPDATE_PERSON`=#{updatePerson,jdbcType=BIGINT}");
            }
        }
        if (params.get("updatePersonNotEqual") != null){
            if (!(params.get("updatePersonNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("updatePersonNotEqual"))){
                sql.WHERE("`UPDATE_PERSON` <> #{updatePersonNotEqual,jdbcType=BIGINT}");
            }
        }
        if (params.get("updatePersonInList") != null && params.get("updatePersonInList") instanceof List) {
            List list = (List) params.get("updatePersonInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{updatePersonInList[").append(i).append("],jdbcType=BIGINT},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`UPDATE_PERSON` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("updatePersonName") != null){
            if (!(params.get("updatePersonName") instanceof String) || StringUtil.isNotEmpty((String) params.get("updatePersonName"))){
                sql.WHERE("`UPDATE_PERSON_NAME`=#{updatePersonName,jdbcType=VARCHAR}");
            }
        }
        if (params.get("updatePersonNameNotEqual") != null){
            if (!(params.get("updatePersonNameNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("updatePersonNameNotEqual"))){
                sql.WHERE("`UPDATE_PERSON_NAME` <> #{updatePersonNameNotEqual,jdbcType=VARCHAR}");
            }
        }
        if (params.get("updatePersonNameInList") != null && params.get("updatePersonNameInList") instanceof List) {
            List list = (List) params.get("updatePersonNameInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{updatePersonNameInList[").append(i).append("],jdbcType=VARCHAR},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`UPDATE_PERSON_NAME` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("updatePersonNameLike")!=null){
            if (!(params.get("updatePersonNameLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("updatePersonNameLike"))){
                sql.WHERE("`UPDATE_PERSON_NAME` LIKE CONCAT('%',#{updatePersonNameLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("updateTime") != null){
            if (!(params.get("updateTime") instanceof String) || StringUtil.isNotEmpty((String) params.get("updateTime"))){
                sql.WHERE("`UPDATE_TIME`=#{updateTime,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("updateTimeNotEqual") != null){
            if (!(params.get("updateTimeNotEqual") instanceof String) || StringUtil.isNotEmpty((String) params.get("updateTimeNotEqual"))){
                sql.WHERE("`UPDATE_TIME` <> #{updateTimeNotEqual,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("updateTimeInList") != null && params.get("updateTimeInList") instanceof List) {
            List list = (List) params.get("updateTimeInList");
            if (list != null && list.size() > 0) {
                StringBuilder inClause = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    inClause.append("#{updateTimeInList[").append(i).append("],jdbcType=TIMESTAMP},");
                }
                inClause.setLength(inClause.length() - 1);
                sql.WHERE("`UPDATE_TIME` IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("updateTimeStart")!=null){
            if (!(params.get("updateTimeStart") instanceof String) || StringUtil.isNotEmpty((String) params.get("updateTimeStart"))){
                sql.WHERE("`UPDATE_TIME` >= #{updateTimeStart,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("updateTimeEnd")!=null){
            if (!(params.get("updateTimeEnd") instanceof String) || StringUtil.isNotEmpty((String) params.get("updateTimeEnd"))){
                sql.WHERE("`UPDATE_TIME` <= #{updateTimeEnd,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("ORDER_BY") != null){
            String orderBy = (String) params.get("ORDER_BY");
            String[] columns = orderBy.split(",");
            for (int i = 0; i < columns.length; i = i + 2) {
                if (i+1<columns.length){
                    sql.ORDER_BY(String.format("`%s` %s",columns[i],columns[i+1]));
                } else {
                    sql.ORDER_BY(columns[i]);
                }
            }
        }
        
        return sql.toString();
    }
}