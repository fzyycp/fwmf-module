package cn.faury.fwmf.module.service.menu.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.service.menu.generate.sqlProvider.RoleRFunctionGenerateSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * SQL Provider：角色关联功能按钮表
 *
 * <pre>
 *     RoleRFunctionGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自RoleRFunctionGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class RoleRFunctionSqlProvider extends RoleRFunctionGenerateSqlProvider {

    public String getRoleRFuncInfosByRole(Map<String, Object> params){
        SQL sql = new SQL();
        sql.SELECT("f.`FUNCTION_ID`, f.`FUNCTION_NAME`, f.`FUNCTION_CODE`, f.`MENU_ID`, f.`IS_AVAILABLE`");

        sql.FROM("sys_t_function_info f,sys_t_role_r_function rf");

        sql.WHERE("f.`FUNCTION_ID`=rf.`FUNCTION_ID`");
        if (params.get("roleId") != null){
            if (!(params.get("roleId") instanceof String) || StringUtil.isNotEmpty((String) params.get("roleId"))){
                sql.WHERE("rf.`ROLE_ID`=#{roleId,jdbcType=BIGINT}");
            }
        }
        if (params.get("isAvailable") != null){
            if (!(params.get("isAvailable") instanceof String) || StringUtil.isNotEmpty((String) params.get("isAvailable"))){
                sql.WHERE("f.`IS_AVAILABLE`=#{isAvailable,jdbcType=CHAR}");
            }
        }
        if (params.get("functionId") != null){
            if (!(params.get("functionId") instanceof String) || StringUtil.isNotEmpty((String) params.get("functionId"))){
                sql.WHERE("f.`FUNCTION_ID`=#{functionId,jdbcType=BIGINT}");
            }
        }
        if (params.get("roleCode") != null){
            if (!(params.get("roleCode") instanceof String) || StringUtil.isNotEmpty((String) params.get("roleCode"))){
                sql.WHERE("rf.`ROLE_ID` in (select r.ROLE_ID from sys_t_role_info r where r.ROLE_CODE=#{roleCode,jdbcType=VARCHAR})");
            }
        }

        return sql.toString();
    }

}