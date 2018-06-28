package cn.faury.fwmf.module.service.menu.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.menu.bean.MenuFuncInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 功能按钮Mapper的SQL工厂
 */
public class MenuFuncSQLProvider {

    /**
     * 日志记录器
     */
    private static Logger log = LoggerFactory.getLogger(MenuFuncSQLProvider.class);

    /**
     * 根据功能按钮ID获取功能按钮信息
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
     * 【二选一】Long funcId 功能按钮ID / String funcCode 功能按钮编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getMenuFuncInfoByFunc(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        if (parameters == null || parameters.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("menuId") && !parameters.containsKey("menuCode")) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("funcId") && !parameters.containsKey("funcCode")) {
            log.debug("SQL ==> null");
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT FUNCTION_ID FUNCID,FUNCTION_NAME FUNCNAME,FUNCTION_CODE FUNCCODE,MENU_ID MENUID,SYSTEM_ID SYSTEMID,IS_AVAILABLE ISAVAILABLE ");
        sql.append(" FROM " + DBConstOfMenu.TN_FUNCTION_INFO);
        sql.append(" WHERE ");
        // 【二选一】Long funcId 功能按钮ID / String funcCode 功能按钮编码
        if (parameters.containsKey("funcId")) {
            sql.append(" FUNCTION_ID = #{funcId,jdbcType=BIGINT} ");
        } else {
            sql.append(" FUNCTION_CODE = #{funcCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isFuncAvailable") && parameters.get("isFuncAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isFuncAvailable");
            sql.append(" AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        // 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
        sql.append(" AND MENU_ID = (");
        sql.append("       SELECT MENU_ID FROM " + DBConstOfMenu.TN_MENU_INFO);
        sql.append("        WHERE ");
        if (parameters.containsKey("menuId")) {
            sql.append("          MENU_ID = #{menuId,jdbcType=BIGINT} ");
        } else {
            sql.append("          MENU_CODE = #{menuCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
            sql.append("      AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("          AND SYSTEM_ID =(");
        sql.append("       		  SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("               WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("                 SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("                 SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                 AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("              ) ");
        sql.append("     ) ");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 根据菜单获取功能按钮清单信息
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getMenuFuncListByMenu(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        if (parameters == null || parameters.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("menuId") && !parameters.containsKey("menuCode")) {
            log.debug("SQL ==> null");
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT FUNCTION_ID FUNCID,FUNCTION_NAME FUNCNAME,FUNCTION_CODE FUNCCODE,MENU_ID MENUID,SYSTEM_ID SYSTEMID,IS_AVAILABLE ISAVAILABLE ");
        sql.append("  FROM " + DBConstOfMenu.TN_FUNCTION_INFO);
        sql.append(" WHERE ");
        // 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
        sql.append(" MENU_ID = (");
        sql.append("       SELECT MENU_ID FROM " + DBConstOfMenu.TN_MENU_INFO);
        sql.append("        WHERE ");
        if (parameters.containsKey("menuId")) {
            sql.append("          MENU_ID = #{menuId,jdbcType=BIGINT} ");
        } else {
            sql.append("          MENU_CODE = #{menuCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
            sql.append("      AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("          AND SYSTEM_ID =(");
        sql.append("       		  SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("               WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("                 SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("                 SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                 AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("              ) ");
        sql.append("     ) ");
        // 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isFuncAvailable") && parameters.get("isFuncAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isFuncAvailable");
            sql.append(" AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 根据菜单获取子菜单功能按钮清单信息
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuPId 父菜单ID / String menuPCode 菜单编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @param parameters 参数列表
     * @return SQL语句
     */
    public static String getChildMenuFuncListByMenu(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        if (parameters == null || parameters.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("menuPId") && !parameters.containsKey("menuPCode")) {
            log.debug("SQL ==> null");
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT FUNCTION_ID FUNCID,FUNCTION_NAME FUNCNAME,FUNCTION_CODE FUNCCODE,MENU_ID MENUID,SYSTEM_ID SYSTEMID,IS_AVAILABLE ISAVAILABLE ");
        sql.append("  FROM " + DBConstOfMenu.TN_FUNCTION_INFO);
        sql.append(" WHERE ");
        // 【二选一】Long menuPId 父菜单ID / String menuPCode 菜单编码
        sql.append(" MENU_ID IN (");
        sql.append("       SELECT MENU_ID FROM " + DBConstOfMenu.TN_MENU_INFO);
        sql.append("        WHERE MENU_PID=(");
        sql.append("              SELECT MENU_ID FROM " + DBConstOfMenu.TN_MENU_INFO);
        sql.append("        	   WHERE ");
        if (parameters.containsKey("menuPId")) {
            sql.append("                 MENU_ID = #{menuPId,jdbcType=BIGINT} ");
        } else {
            sql.append("                 MENU_CODE = #{menuPCode,jdbcType=VARCHAR} ");
        }
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("                 AND SYSTEM_ID =(");
        sql.append("       		           SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("                        WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("                          SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("                          SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                          AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("                     ) ");
        // 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
            sql.append("            AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("              ) ");
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("          AND SYSTEM_ID =(");
        sql.append("       		  SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("               WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("                 SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("                 SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                 AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("              ) ");
        // 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
            sql.append("      AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append(" ) ");
        // 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isFuncAvailable") && parameters.get("isFuncAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isFuncAvailable");
            sql.append(" AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append(" ORDER BY MENU_ID,FUNCTION_ID ");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    public static String getMenuFuncInfoByFuncCode(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        if (parameters == null || parameters.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("funcCode")) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("menuId")) {
            log.debug("SQL ==> null");
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT FUNCTION_ID funcID ");
        sql.append("  FROM " + DBConstOfMenu.TN_FUNCTION_INFO);
        sql.append(" WHERE ");
        sql.append(" `FUNCTION_CODE` = #{funcCode} AND MENU_ID = #{menuId}");
        if (parameters.containsKey("funcId")) {
            sql.append(" AND FUNCTION_ID != #{funcId}");
        }
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 修改菜单功能信息
     * <p>
     * 【可选】funcName：功能菜单名称 【可选】funcCode：功能编码 【可选】menuId：菜单ID 【可选】systemId：业务系统ID
     * 【可选】isAvailable：是否可用【Y:是 N:否】
     *
     * @param menuFuncInfo 菜单功能按钮对象
     * @return SQL语句
     */
    public static String updateMenuFuncInfo(final MenuFuncInfoBean menuFuncInfo) {
        log.debug("menuFuncInfo ==> " + menuFuncInfo.toString());
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);

        // if (menuFuncInfo.getFuncId().equals("") || menuFuncInfo.getFuncId()
        // == null) {notNull
        if (menuFuncInfo.getFuncId() != null) {
            log.debug("SQL ==> null");
            return null;
        }

        sql.append("UPDATE " + DBConstOfMenu.TN_FUNCTION_INFO);
        sql.append(" SET ");
        // 【可选】funcName：功能菜单名称
        if (StringUtil.isNotEmpty(menuFuncInfo.getFuncName())) {
            sql.append("FUNCTION_NAME= #{funcName,jdbcType=VARCHAR} ,");
        }
        // 【可选】funcCode：功能编码
        if (StringUtil.isNotEmpty(menuFuncInfo.getFuncCode())) {
            sql.append("FUNCTION_CODE= #{funcCode,jdbcType=VARCHAR},");
        }
        // 【可选】menuId：菜单ID
        if (menuFuncInfo.getMenuId() != null) {
            sql.append("MENU_ID= #{menuId,jdbcType=VARCHAR},");
        }
        // 【可选】systemId：业务系统ID
        if (menuFuncInfo.getSystemId() != null) {
            sql.append("SYSTEM_ID= #{systemId,jdbcType=BIGINT},");
        }
        // 【可选】isAvailable：是否可用【Y:是 N:否】
        if (StringUtil.isNotEmpty(menuFuncInfo.getIsAvailable())) {
            sql.append("IS_AVAILABLE= #{isAvailable,jdbcType=VARCHAR},");
        }

        sql.deleteCharAt(sql.length() - 1);
        sql.append(" WHERE FUNCTION_ID = #{funcId,jdbcType=BIGINT} ");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();

    }

    /**
     * 根据功能按钮ID删除功能按钮信息----物理删除
     *
     * @param parameters 输入参数
     * @return SQL语句
     */
    public static String deleteMenuFuncInfoById(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        if (parameters == null || parameters.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("funcIds")) {
            log.debug("SQL ==> null");
            return null;
        }

        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("DELETE FROM " + DBConstOfMenu.TN_FUNCTION_INFO + " WHERE FUNCTION_ID IN (");
        @SuppressWarnings("unchecked")
        List<Long> funcIds = (List<Long>) parameters.get("funcIds");
        if (funcIds != null) {
            if (funcIds.size() > 0) {
                for (int i = 0; i < funcIds.size(); i++) {
                    sql.append(" #{funcIds[" + i + "],jdbcType=BIGINT},");
                }
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 根据菜单ID删除功能按钮信息----物理删除
     *
     * @param parameters 输入参数
     * @return SQL语句
     */
    public static String deleteMenuFuncInfoByMenuId(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        if (parameters == null || parameters.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("menuIds")) {
            log.debug("SQL ==> null");
            return null;
        }

        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("DELETE FROM " + DBConstOfMenu.TN_FUNCTION_INFO + " WHERE MENU_ID IN (");
        @SuppressWarnings("unchecked")
        List<Long> menuIds = (List<Long>) parameters.get("menuIds");
        if (menuIds != null) {
            if (menuIds.size() > 0) {
                for (int i = 0; i < menuIds.size(); i++) {
                    sql.append("#{menuIds[" + i + "],jdbcType=BIGINT},");
                }
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    /**
     * 根据菜单ID查询菜单关联角色的数量
     */
    public static String getFuncCountById(final Map<String, Object> parameters) {
        // 参数校验
        log.debug("Parameters ==> " + parameters.toString());
        if (parameters == null || parameters.size() <= 0) {
            log.debug("SQL ==> null");
            return null;
        }
        if (!parameters.containsKey("funcIds")) {
            log.debug("SQL ==> null");
            return null;
        }

        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT COUNT(ROLE_ID) FROM " + DBConstOfMenu.TN_ROLE_R_FUNCTION);
        sql.append(" WHERE FUNCTION_ID IN  (");
        @SuppressWarnings("unchecked")
        List<Long> funcIds = (List<Long>) parameters.get("funcIds");
        if (funcIds != null) {
            if (funcIds.size() > 0) {
                for (int i = 0; i < funcIds.size(); i++) {
                    sql.append("#{funcIds[" + i + "],jdbcType=BIGINT},");
                }
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

}
