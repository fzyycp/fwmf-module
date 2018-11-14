/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-14 22:38:58
 */
package cn.faury.fwmf.module.service.operation.generate.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.operation.generate.bean.OperationRecordGenerateBean;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OperationRecordGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_operation_record
     *
     * @fwmf.generated 2018-11-14 22:38:58
     */
    public String insertSelective(OperationRecordGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_t_operation_record");
        
        if (record.getOperationRecordId() != null) {
            sql.VALUES("OPERATION_RECORD_ID", "#{operationRecordId,jdbcType=BIGINT}");
        }
        
        if (record.getNamespace() != null) {
            sql.VALUES("NAMESPACE", "#{namespace,jdbcType=VARCHAR}");
        }
        
        if (record.getActionName() != null) {
            sql.VALUES("ACTION_NAME", "#{actionName,jdbcType=VARCHAR}");
        }
        
        if (record.getActionClass() != null) {
            sql.VALUES("ACTION_CLASS", "#{actionClass,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodName() != null) {
            sql.VALUES("METHOD_NAME", "#{methodName,jdbcType=VARCHAR}");
        }
        
        if (record.getMenu() != null) {
            sql.VALUES("MENU", "#{menu,jdbcType=VARCHAR}");
        }
        
        if (record.getFunction() != null) {
            sql.VALUES("FUNCTION", "#{function,jdbcType=VARCHAR}");
        }
        
        if (record.getOptLevel() != null) {
            sql.VALUES("OPT_LEVEL", "#{optLevel,jdbcType=INTEGER}");
        }
        
        if (record.getOptCode() != null) {
            sql.VALUES("OPT_CODE", "#{optCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOptDesc() != null) {
            sql.VALUES("OPT_DESC", "#{optDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSuccess() != null) {
            sql.VALUES("IS_SUCCESS", "#{isSuccess,jdbcType=CHAR}");
        }
        
        if (record.getArguments() != null) {
            sql.VALUES("ARGUMENTS", "#{arguments,jdbcType=VARCHAR}");
        }
        
        if (record.getResult() != null) {
            sql.VALUES("RESULT", "#{result,jdbcType=VARCHAR}");
        }
        
        if (record.getErrorMessage() != null) {
            sql.VALUES("ERROR_MESSAGE", "#{errorMessage,jdbcType=VARCHAR}");
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
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_operation_record
     *
     * @fwmf.generated 2018-11-14 22:38:58
     */
    public String updateByPrimaryKeySelective(OperationRecordGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_t_operation_record");
        
        if (record.getNamespace() != null) {
            sql.SET("NAMESPACE = #{namespace,jdbcType=VARCHAR}");
        }
        
        if (record.getActionName() != null) {
            sql.SET("ACTION_NAME = #{actionName,jdbcType=VARCHAR}");
        }
        
        if (record.getActionClass() != null) {
            sql.SET("ACTION_CLASS = #{actionClass,jdbcType=VARCHAR}");
        }
        
        if (record.getMethodName() != null) {
            sql.SET("METHOD_NAME = #{methodName,jdbcType=VARCHAR}");
        }
        
        if (record.getMenu() != null) {
            sql.SET("MENU = #{menu,jdbcType=VARCHAR}");
        }
        
        if (record.getFunction() != null) {
            sql.SET("FUNCTION = #{function,jdbcType=VARCHAR}");
        }
        
        if (record.getOptLevel() != null) {
            sql.SET("OPT_LEVEL = #{optLevel,jdbcType=INTEGER}");
        }
        
        if (record.getOptCode() != null) {
            sql.SET("OPT_CODE = #{optCode,jdbcType=VARCHAR}");
        }
        
        if (record.getOptDesc() != null) {
            sql.SET("OPT_DESC = #{optDesc,jdbcType=VARCHAR}");
        }
        
        if (record.getIsSuccess() != null) {
            sql.SET("IS_SUCCESS = #{isSuccess,jdbcType=CHAR}");
        }
        
        if (record.getArguments() != null) {
            sql.SET("ARGUMENTS = #{arguments,jdbcType=VARCHAR}");
        }
        
        if (record.getResult() != null) {
            sql.SET("RESULT = #{result,jdbcType=VARCHAR}");
        }
        
        if (record.getErrorMessage() != null) {
            sql.SET("ERROR_MESSAGE = #{errorMessage,jdbcType=VARCHAR}");
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
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("OPERATION_RECORD_ID = #{operationRecordId,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_operation_record
     *
     * @fwmf.generated 2018-11-14 22:38:58
     */
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("OPERATION_RECORD_ID, NAMESPACE, ACTION_NAME, ACTION_CLASS, METHOD_NAME, MENU, FUNCTION");
        sql.SELECT("OPT_LEVEL, OPT_CODE, OPT_DESC, IS_SUCCESS, ARGUMENTS, RESULT, ERROR_MESSAGE, IS_DELETE");
        sql.SELECT("CREATE_PERSON, CREATE_PERSON_NAME, CREATE_TIME");
        
        sql.FROM("sys_t_operation_record");
        
        if (params.get("operationRecordId") != null){
            if (!(params.get("operationRecordId") instanceof String) || StringUtil.isNotEmpty((String) params.get("operationRecordId"))){
                sql.WHERE("OPERATION_RECORD_ID=#{operationRecordId,jdbcType=BIGINT}");
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
                sql.WHERE("OPERATION_RECORD_ID IN (" + inClause.toString() + ")");
            }
        }
        if (params.get("namespace") != null){
            if (!(params.get("namespace") instanceof String) || StringUtil.isNotEmpty((String) params.get("namespace"))){
                sql.WHERE("NAMESPACE=#{namespace,jdbcType=VARCHAR}");
            }
        }
        if (params.get("namespaceLike")!=null){
            if (!(params.get("namespaceLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("namespaceLike"))){
                sql.WHERE("NAMESPACE LIKE CONCAT('%',#{namespaceLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("actionName") != null){
            if (!(params.get("actionName") instanceof String) || StringUtil.isNotEmpty((String) params.get("actionName"))){
                sql.WHERE("ACTION_NAME=#{actionName,jdbcType=VARCHAR}");
            }
        }
        if (params.get("actionNameLike")!=null){
            if (!(params.get("actionNameLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("actionNameLike"))){
                sql.WHERE("ACTION_NAME LIKE CONCAT('%',#{actionNameLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("actionClass") != null){
            if (!(params.get("actionClass") instanceof String) || StringUtil.isNotEmpty((String) params.get("actionClass"))){
                sql.WHERE("ACTION_CLASS=#{actionClass,jdbcType=VARCHAR}");
            }
        }
        if (params.get("actionClassLike")!=null){
            if (!(params.get("actionClassLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("actionClassLike"))){
                sql.WHERE("ACTION_CLASS LIKE CONCAT('%',#{actionClassLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("methodName") != null){
            if (!(params.get("methodName") instanceof String) || StringUtil.isNotEmpty((String) params.get("methodName"))){
                sql.WHERE("METHOD_NAME=#{methodName,jdbcType=VARCHAR}");
            }
        }
        if (params.get("methodNameLike")!=null){
            if (!(params.get("methodNameLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("methodNameLike"))){
                sql.WHERE("METHOD_NAME LIKE CONCAT('%',#{methodNameLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("menu") != null){
            if (!(params.get("menu") instanceof String) || StringUtil.isNotEmpty((String) params.get("menu"))){
                sql.WHERE("MENU=#{menu,jdbcType=VARCHAR}");
            }
        }
        if (params.get("menuLike")!=null){
            if (!(params.get("menuLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("menuLike"))){
                sql.WHERE("MENU LIKE CONCAT('%',#{menuLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("function") != null){
            if (!(params.get("function") instanceof String) || StringUtil.isNotEmpty((String) params.get("function"))){
                sql.WHERE("FUNCTION=#{function,jdbcType=VARCHAR}");
            }
        }
        if (params.get("functionLike")!=null){
            if (!(params.get("functionLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("functionLike"))){
                sql.WHERE("FUNCTION LIKE CONCAT('%',#{functionLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("optLevel") != null){
            if (!(params.get("optLevel") instanceof String) || StringUtil.isNotEmpty((String) params.get("optLevel"))){
                sql.WHERE("OPT_LEVEL=#{optLevel,jdbcType=INTEGER}");
            }
        }
        if (params.get("optCode") != null){
            if (!(params.get("optCode") instanceof String) || StringUtil.isNotEmpty((String) params.get("optCode"))){
                sql.WHERE("OPT_CODE=#{optCode,jdbcType=VARCHAR}");
            }
        }
        if (params.get("optCodeLike")!=null){
            if (!(params.get("optCodeLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("optCodeLike"))){
                sql.WHERE("OPT_CODE LIKE CONCAT('%',#{optCodeLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("optDesc") != null){
            if (!(params.get("optDesc") instanceof String) || StringUtil.isNotEmpty((String) params.get("optDesc"))){
                sql.WHERE("OPT_DESC=#{optDesc,jdbcType=VARCHAR}");
            }
        }
        if (params.get("optDescLike")!=null){
            if (!(params.get("optDescLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("optDescLike"))){
                sql.WHERE("OPT_DESC LIKE CONCAT('%',#{optDescLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("isSuccess") != null){
            if (!(params.get("isSuccess") instanceof String) || StringUtil.isNotEmpty((String) params.get("isSuccess"))){
                sql.WHERE("IS_SUCCESS=#{isSuccess,jdbcType=CHAR}");
            }
        }
        if (params.get("isSuccessLike")!=null){
            if (!(params.get("isSuccessLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("isSuccessLike"))){
                sql.WHERE("IS_SUCCESS LIKE CONCAT('%',#{isSuccessLike,jdbcType=CHAR},'%')");
            }
        }
        if (params.get("arguments") != null){
            if (!(params.get("arguments") instanceof String) || StringUtil.isNotEmpty((String) params.get("arguments"))){
                sql.WHERE("ARGUMENTS=#{arguments,jdbcType=VARCHAR}");
            }
        }
        if (params.get("argumentsLike")!=null){
            if (!(params.get("argumentsLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("argumentsLike"))){
                sql.WHERE("ARGUMENTS LIKE CONCAT('%',#{argumentsLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("result") != null){
            if (!(params.get("result") instanceof String) || StringUtil.isNotEmpty((String) params.get("result"))){
                sql.WHERE("RESULT=#{result,jdbcType=VARCHAR}");
            }
        }
        if (params.get("resultLike")!=null){
            if (!(params.get("resultLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("resultLike"))){
                sql.WHERE("RESULT LIKE CONCAT('%',#{resultLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("errorMessage") != null){
            if (!(params.get("errorMessage") instanceof String) || StringUtil.isNotEmpty((String) params.get("errorMessage"))){
                sql.WHERE("ERROR_MESSAGE=#{errorMessage,jdbcType=VARCHAR}");
            }
        }
        if (params.get("errorMessageLike")!=null){
            if (!(params.get("errorMessageLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("errorMessageLike"))){
                sql.WHERE("ERROR_MESSAGE LIKE CONCAT('%',#{errorMessageLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("isDelete") != null){
            if (!(params.get("isDelete") instanceof String) || StringUtil.isNotEmpty((String) params.get("isDelete"))){
                sql.WHERE("IS_DELETE=#{isDelete,jdbcType=CHAR}");
            }
        }
        if (params.get("isDeleteLike")!=null){
            if (!(params.get("isDeleteLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("isDeleteLike"))){
                sql.WHERE("IS_DELETE LIKE CONCAT('%',#{isDeleteLike,jdbcType=CHAR},'%')");
            }
        }
        if (params.get("createPerson") != null){
            if (!(params.get("createPerson") instanceof String) || StringUtil.isNotEmpty((String) params.get("createPerson"))){
                sql.WHERE("CREATE_PERSON=#{createPerson,jdbcType=BIGINT}");
            }
        }
        if (params.get("createPersonName") != null){
            if (!(params.get("createPersonName") instanceof String) || StringUtil.isNotEmpty((String) params.get("createPersonName"))){
                sql.WHERE("CREATE_PERSON_NAME=#{createPersonName,jdbcType=VARCHAR}");
            }
        }
        if (params.get("createPersonNameLike")!=null){
            if (!(params.get("createPersonNameLike") instanceof String) || StringUtil.isNotEmpty((String) params.get("createPersonNameLike"))){
                sql.WHERE("CREATE_PERSON_NAME LIKE CONCAT('%',#{createPersonNameLike,jdbcType=VARCHAR},'%')");
            }
        }
        if (params.get("createTime") != null){
            if (!(params.get("createTime") instanceof String) || StringUtil.isNotEmpty((String) params.get("createTime"))){
                sql.WHERE("CREATE_TIME=#{createTime,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("createTimeStart")!=null){
            if (!(params.get("createTimeStart") instanceof String) || StringUtil.isNotEmpty((String) params.get("createTimeStart"))){
                sql.WHERE("CREATE_TIME >= #{createTimeStart,jdbcType=TIMESTAMP}");
            }
        }
        if (params.get("createTimeEnd")!=null){
            if (!(params.get("createTimeEnd") instanceof String) || StringUtil.isNotEmpty((String) params.get("createTimeEnd"))){
                sql.WHERE("CREATE_TIME <= #{createTimeEnd,jdbcType=TIMESTAMP}");
            }
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