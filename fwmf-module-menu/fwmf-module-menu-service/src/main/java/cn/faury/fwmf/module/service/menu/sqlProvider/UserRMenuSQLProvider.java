package cn.faury.fwmf.module.service.menu.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfMenu;

import java.util.Map;

/**
 * 用户关联菜单SQL工厂
 */
public class UserRMenuSQLProvider {

    /**
     * 根据用户ID获取指定系统下的菜单信息
     *
     * <pre>
     * 可能出现的参数：
     * 【必填】Long userId 用户ID
     * 【可选】String systemCode 业务系统编码
     * </pre>
     * @param parameters 查询参数
     * @return 菜单信息
     */
    public static String getMenuInfoByUserId(final Map<String, Object> parameters) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT m.MENU_ID menuId,m.MENU_PID menuPid,m.MENU_NAME menuName,m.MENU_ACTION_KEY menuActionKey, ");
        sql.append("       m.MENU_CODE menuCode,m.IS_AVAILABLE isAvailable,m.IS_LEAF isLeaf,m.SYSTEM_ID systemId,m.SORT sort ");
        sql.append("  FROM ").append(DBConstOfMenu.TN_MENU_INFO).append(" m, ");
        sql.append(DBConstOfMenu.TN_SYSTEM_INFO).append(" s, ");
        sql.append(DBConstOfMenu.TN_ROLE_R_MENU).append(" rm, ");
        sql.append(DBConstOfMenu.TN_USER_R_ROLE).append(" ur ");
        sql.append(" WHERE m.MENU_ID = rm.MENU_ID AND m.SYSTEM_ID = s.SYSTEM_ID ");
        sql.append("   AND m.IS_AVAILABLE = 'Y' AND s.IS_AVAILABLE = 'Y' ");
        sql.append("   AND rm.ROLE_ID = ur.ROLE_ID AND ur.USER_ID = #{userId,jdbcType=BIGINT} ");
        // 【可选】String systemCode 业务系统编码
        if (parameters.get("systemCode") != null) {
            sql.append("   AND s.SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        sql.append(" ORDER BY m.SYSTEM_ID,m.MENU_PID,m.SORT");
        return sql.toString();
    }
}
