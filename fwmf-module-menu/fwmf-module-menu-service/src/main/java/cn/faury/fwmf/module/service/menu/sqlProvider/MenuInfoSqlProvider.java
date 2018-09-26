package cn.faury.fwmf.module.service.menu.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfMenu;
import cn.faury.fwmf.module.service.menu.generate.sqlProvider.MenuInfoGenerateSqlProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * SQL Provider：菜单信息表
 *
 * <pre>
 *     MenuInfoGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自MenuInfoGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class MenuInfoSqlProvider extends MenuInfoGenerateSqlProvider {

    /**
     * 日志记录器
     */
    private static Logger log = LoggerFactory.getLogger(MenuInfoSqlProvider.class);

    /**
     * 根据菜单ID/菜单编码获取菜单信息
     *
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @param parameters
     *            参数列表
     * @return SQL语句
     */
    public static String getMenuInfoByMenu(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
            return null;
        }
        if (!parameters.containsKey("menuId") && !parameters.containsKey("menuCode")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT MENU_ID MENUID,MENU_PID MENUPID,MENU_NAME MENUNAME,MENU_CODE MENUCODE,MENU_ACTION_KEY MENUACTIONKEY ");
        sql.append("       ,SORT 'ORDER',IS_LEAF ISLEAF,SYSTEM_ID SYSTEMID,IS_AVAILABLE ISAVAILABLE ");
        sql.append("  FROM " + DBConstOfMenu.TN_MENU_INFO);
        sql.append(" WHERE ");
        // 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
        if (parameters.containsKey("menuId")) {
            sql.append("   MENU_ID = #{menuId,jdbcType=BIGINT} ");
        } else {
            sql.append("   MENU_CODE = #{menuCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
            sql.append(" AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("   AND SYSTEM_ID =(");
        sql.append("       	SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("         WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("           SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("           SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                 AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("      ) ");
        return sql.toString();
    }

    /**
     * 菜单ID/菜单编码获取子菜单列表
     *
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @param parameters
     *            参数列表
     * @return SQL语句
     */
    public static String getMenuChildInfoByMenu(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
            return null;
        }
        if (!parameters.containsKey("menuId") && !parameters.containsKey("menuCode")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT MENU_ID MENUID,MENU_PID MENUPID,MENU_NAME MENUNAME,MENU_CODE MENUCODE,MENU_ACTION_KEY MENUACTIONKEY ");
        sql.append("       ,SORT `ORDER`,IS_LEAF ISLEAF,SYSTEM_ID SYSTEMID,IS_AVAILABLE ISAVAILABLE ");
        sql.append("  FROM " + DBConstOfMenu.TN_MENU_INFO);
        sql.append(" WHERE MENU_PID = (");
        sql.append("       SELECT MENU_ID FROM ").append(DBConstOfMenu.TN_MENU_INFO);
        sql.append("        WHERE ");
        // 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
        if (parameters.containsKey("menuId")) {
            sql.append("          MENU_ID = #{menuId,jdbcType=BIGINT} ");
        } else {
            sql.append("          MENU_CODE = #{menuCode,jdbcType=VARCHAR} ");
        }
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("         AND SYSTEM_ID =(");
        sql.append("       	        SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("                 WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("                   SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("                   SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("      ) ");

        sql.append(")");
        // 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
            sql.append(" AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("   AND SYSTEM_ID =(");
        sql.append("       	SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("         WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("           SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("           SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                 AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("  ) ORDER BY MENU_PID,SORT,MENU_ID ");
        return sql.toString();
    }

    /**
     * 根据菜单功能编码获取菜单信息
     *
     * 【二选一】menuAction 菜单功能编码
     * 【二选一】menuCode 菜单编码
     * 【必选】systemId 系统id
     * 【可选】menuId 菜单id
     */
    public static String getMenuInfoByMenuBean(final Map<String, Object> parameters) {
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("menuAction") && !parameters.containsKey("menuCode")) {
            return null;
        }
        if (!parameters.containsKey("systemId")) {
            return null;
        }

        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT MENU_ID menuId");
        sql.append("  FROM " + DBConstOfMenu.TN_MENU_INFO);
        sql.append(" WHERE ");
        sql.append(" SYSTEM_ID = #{systemId}");
        if (parameters.containsKey("menuActionKey")) {
            sql.append(" AND MENU_ACTION_KEY = #{menuActionKey}");
        }
        if (parameters.containsKey("menuCode")) {
            sql.append(" AND `MENU_CODE` = #{menuCode}");
        }
        if (parameters.containsKey("menuId")) {
            sql.append(" AND MENU_ID != #{menuId}");
        }
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();

    }

    /**
     * 根据菜单ID查询菜单关联角色的数量
     */
    public static String getMenuCountById(final Map<String, Object> parameters) {
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
        sql.append("SELECT COUNT(ROLE_ID) FROM " + DBConstOfMenu.TN_ROLE_R_MENU);
        sql.append(" WHERE MENU_ID IN  (");
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
     * 修改菜单信息
     *
     * <pre>
     * 可能出现的参数：
     * 【必填】menuId：菜单ID
     * 【可选】menuPid：父菜单ID，根目录请使用0
     * 【可选】menuName：菜单名称
     * 【可选】menuCode：菜单编码
     * 【可选】menuAction：菜单Action
     * 【可选】order：排序
     * 【可选】isLeaf：是否末级【Y:是 N:否】
     * 【可选】systemId：业务系统ID
     * 【可选】isAvailable：是否可用【Y:是 N:否】
     * </pre>
     *
     * @param menuInfo
     *            菜单对象
     * @return SQL语句
     */
    public static String updateMenuInfoById(final MenuInfoBean menuInfo) {
        log.debug("menuInfo ==> " + menuInfo.toString());
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);

        if (menuInfo.getMenuId()==null) {
            log.debug("SQL ==> null");
            return null;
        }

        sql.append("UPDATE " + DBConstOfMenu.TN_MENU_INFO);
        sql.append(" SET ");

        // 【可选】menuPid：父菜单ID，根目录请使用0
        if (menuInfo.getMenuPid()!=null) {
            sql.append("MENU_PID= #{menuPid,jdbcType=BIGINT},");
        }

        // 【可选】menuName：菜单名称
        if (StringUtil.isNotEmpty(menuInfo.getMenuName())) {
            sql.append("MENU_NAME= #{menuName,jdbcType=VARCHAR},");
        }
        // 【可选】menuCode：菜单编码
        if (StringUtil.isNotEmpty(menuInfo.getMenuCode())) {
            sql.append("MENU_CODE= #{menuCode,jdbcType=VARCHAR},");
        }

        // 【可选】menuAction：菜单Action
        if (StringUtil.isNotEmpty(menuInfo.getMenuActionKey())) {
            sql.append("MENU_ACTION_KEY= #{menuActionKey,jdbcType=VARCHAR},");
        }

        // 【可选】order：排序
        if (menuInfo.getSort()!=null) {
            sql.append("SORT= #{order,jdbcType=BIGINT},");
        }

        // 【可选】isLeaf：是否末级【Y:是 N:否】
        if (StringUtil.isNotEmpty(menuInfo.getIsLeaf())) {
            sql.append("IS_LEAF= #{isLeaf,jdbcType=VARCHAR},");
        }

        // 【可选】systemId：业务系统ID
        if (menuInfo.getSystemId()!=null) {
            sql.append("SYSTEM_ID= #{systemId,jdbcType=BIGINT},");
        }

        // 【可选】isAvailable：是否可用【Y:是 N:否】
        if (StringUtil.isNotEmpty(menuInfo.getIsAvailable())) {
            sql.append("IS_AVAILABLE= #{isAvailable,jdbcType=VARCHAR},");
        }

        sql.deleteCharAt(sql.length() - 1);
        sql.append(" WHERE MENU_ID = #{menuId,jdbcType=BIGINT} ");

        log.debug("SQL ==> " + sql.toString());
        return sql.toString();

    }

    /**
     * 1.【物理删除】根据菜单ID删除菜单信息，同时删除菜单下功能按钮
     *
     * @param parameters
     *            输入参数
     * @return SQL语句
     */
    public static String deleteMenuInfoById(final Map<String, Object> parameters) {
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
        sql.append("DELETE FROM " + DBConstOfMenu.TN_MENU_INFO + " WHERE MENU_ID IN (");
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
     * 2.【物理删除】根据菜单ID删除菜单信息，同时删除菜单下功能按钮
     *
     * @param parameters
     *            输入参数
     * @return SQL语句
     */
    public static String deleteMenuFuncInfoById(final Map<String, Object> parameters) {
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
        sql.append("DELETE FROM " + DBConstOfMenu.TN_FUNCTION_INFO + " WHERE MENU_ID IN  (");
        sql.append(" SELECT MENU_ID FROM  " + DBConstOfMenu.TN_MENU_INFO + " WHERE MENU_ID IN  (");
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
        sql.append(" )");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();

    }

    /**
     * 菜单ID/菜单编码获取2级子菜单列表
     *
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @param parameters
     *            参数列表
     * @return SQL语句
     */
    public static String getMenuTowChildInfoByMenu(final Map<String, Object> parameters){
        // 参数校验
        if (parameters == null || parameters.size() <= 0) {
            return null;
        }
        if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
            return null;
        }
        if (!parameters.containsKey("menuId") && !parameters.containsKey("menuCode")) {
            return null;
        }
        // SQL拼装
        StringBuffer sql = new StringBuffer(128);
        sql.append("SELECT MENU_ID MENUID,MENU_PID MENUPID,MENU_NAME MENUNAME,MENU_CODE MENUCODE,MENU_ACTION_KEY MENUACTIONKey ");
        sql.append("       ,SORT `ORDER`,IS_LEAF ISLEAF,SYSTEM_ID SYSTEMID,IS_AVAILABLE ISAVAILABLE ");
        sql.append("  FROM " + DBConstOfMenu.TN_MENU_INFO);
        sql.append(" WHERE (MENU_PID = (");
        sql.append("       SELECT MENU_ID FROM ").append(DBConstOfMenu.TN_MENU_INFO);
        sql.append("        WHERE ");
        // 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
        if (parameters.containsKey("menuId")) {
            sql.append("          MENU_ID = #{menuId,jdbcType=BIGINT} ");
        } else {
            sql.append("          MENU_CODE = #{menuCode,jdbcType=VARCHAR} ");
        }
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("         AND SYSTEM_ID =(");
        sql.append("       	        SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("                 WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("                   SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("                   SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("      ) ");
        sql.append(") OR MENU_PID in (");
        //查第二级
        sql.append("SELECT MENU_ID ");
        sql.append("  FROM " + DBConstOfMenu.TN_MENU_INFO);
        sql.append(" WHERE MENU_PID = (");
        sql.append("       SELECT MENU_ID FROM ").append(DBConstOfMenu.TN_MENU_INFO);
        sql.append("        WHERE ");
        // 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
        if (parameters.containsKey("menuId")) {
            sql.append("          MENU_ID = #{menuId,jdbcType=BIGINT} ");
        } else {
            sql.append("          MENU_CODE = #{menuCode,jdbcType=VARCHAR} ");
        }
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("         AND SYSTEM_ID =(");
        sql.append("       	        SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("                 WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("                   SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("                   SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("      ) ");
        sql.append(")");
        // 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
            sql.append(" AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("   AND SYSTEM_ID =(");
        sql.append("       	SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("         WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("           SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("           SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                 AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("      ) ");

        sql.append(")) ");

        // 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
            sql.append(" AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        // 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
        sql.append("   AND SYSTEM_ID =(");
        sql.append("       	SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
        sql.append("         WHERE ");
        if (parameters.containsKey("systemId")) {
            sql.append("           SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
        } else {
            sql.append("           SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
        }
        // 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用；
        // Boolean.FALSE:仅不可用； null:都包含】
        if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
            Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
            sql.append("                 AND IS_AVAILABLE = '");
            sql.append(isAvailable.booleanValue() ? "Y" : "N");
            sql.append("' ");
        }
        sql.append("      ) ");
        return sql.toString();
    }
}