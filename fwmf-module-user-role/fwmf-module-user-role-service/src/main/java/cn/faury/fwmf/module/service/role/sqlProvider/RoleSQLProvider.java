package cn.faury.fwmf.module.service.role.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;

import java.util.Map;

/**
 * SQL提供
 */
public class RoleSQLProvider {

    /**
     * 根据用户ID获取指定系统下的角色信息
     *
     * <pre>
     * 可能出现的参数：
     * 【必填】Long userId 用户ID
     * 【可选】String systemCode 业务系统编码
     * </pre>
     * @param parameters 查询参数
     * @return 角色信息
     */
    public static String getUserRolesByUserId(final Map<String, Object> parameters) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT R.ROLE_ID roleId,R.ROLE_CODE roleCode,R.ROLE_NAME roleName,R.IS_AVAILABLE isAvailable, ");
        sql.append("       R.SYSTEM_ID systemId,S.SYSTEM_CODE systemCode,S.SYSTEM_NAME systemName ");
        sql.append("  FROM ").append(DBConstOfUserRole.TN_ROLE_INFO).append(" R, ");
        sql.append(DBConstOfUserRole.TN_USER_R_ROLE).append(" UR, ");
        sql.append(DBConstOfUserRole.TN_SYSTEM_INFO).append(" S ");
        sql.append(" WHERE R.SYSTEM_ID = S.SYSTEM_ID ");
        sql.append("   AND UR.ROLE_ID = R.ROLE_ID");
        sql.append("   AND UR.USER_ID = #{userId,jdbcType=BIGINT} ");
        // 【可选】String systemCode 业务系统编码
        if (parameters.get("systemCode") != null) {
            sql.append("   AND S.SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        sql.append(" AND R.IS_AVAILABLE = 'Y' ");
        sql.append(" AND S.IS_AVAILABLE = 'Y' ");
        return sql.toString();
    }

    /**
     * 根据用户ID获取指定系统下的角色授权信息
     *
     * <pre>
     * 可能出现的参数：
     * 【必填】Long userId 用户ID
     * 【可选】String systemCode 业务系统编码
     * </pre>
     *
     * @param parameters 查询参数
     * @return 用户授权
     */
    public static String getUserRolePermsByUserId(final Map<String, Object> parameters) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT CONCAT(S.SYSTEM_CODE,':',M.MENU_CODE,IF(F.FUNCTION_CODE = '/', '', CONCAT(':',F.FUNCTION_CODE))) PERMS  ");
        sql.append("  FROM ");
        sql.append(DBConstOfUserRole.TN_FUNCTION_INFO).append(" F, ");
        sql.append(DBConstOfUserRole.TN_MENU_INFO).append(" M, ");
        sql.append(DBConstOfUserRole.TN_SYSTEM_INFO).append(" S, ");
        sql.append(DBConstOfUserRole.TN_ROLE_R_MENU).append(" RM, ");
        sql.append(DBConstOfUserRole.TN_ROLE_R_FUNCTION).append(" RF ");
        sql.append("WHERE F.FUNCTION_ID = RF.FUNCTION_ID ");
        sql.append("  AND F.MENU_ID = RM.MENU_ID ");
        sql.append("  AND M.SYSTEM_ID = S.SYSTEM_ID ");
        sql.append("  AND RM.MENU_ID = M.MENU_ID ");
        sql.append("  AND RM.ROLE_ID = RF.ROLE_ID ");
        sql.append(" AND F.IS_AVAILABLE = 'Y' ");
        sql.append(" AND M.IS_AVAILABLE = 'Y' ");
        sql.append(" AND S.IS_AVAILABLE = 'Y' ");

        sql.append("  AND RM.ROLE_ID IN ( ");
        // 获取用户所有的角色列表SQL
        String subSql = getUserRolesByUserId(parameters);
        sql.append("		SELECT roleId ");
        sql.append("		  FROM (").append(subSql).append(") SUB ");
        sql.append(")ORDER BY S.SYSTEM_CODE ,M.MENU_CODE ,F.FUNCTION_CODE ");
        return sql.toString();
    }
}
