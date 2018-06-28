package cn.faury.fwmf.module.service.menu.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfMenu;

import java.util.Map;

/**
 * 系统菜单Mapper的SQL工厂
 */
public class SystemMenuSQLProvider {

	/**
	 * 根据业务系统ID/业务系统编码获取根菜单和一级子菜单信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @param parameters
	 *            参数列表
	 * @return SQL语句
	 */
	public static String getRootMenuListWithOneChildBySystem(final Map<String, Object> parameters) {
		// 参数校验
		if (parameters == null || parameters.size() <= 0) {
			return null;
		}
		if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
			return null;
		}
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT MENU_ID, MENU_PID, MENU_NAME, MENU_CODE,MENU_ACTION_KEY MENU_ACTION ");
		sql.append("       ,SORT `ORDER`, IS_LEAF, SYSTEM_ID, IS_AVAILABLE ");
		sql.append("  FROM " + DBConstOfMenu.TN_MENU_INFO);
		sql.append(" WHERE (MENU_PID = 0 OR MENU_PID IN(");
		sql.append("		SELECT MENU_ID ");
		sql.append("  		  FROM " + DBConstOfMenu.TN_MENU_INFO);
		sql.append("         WHERE MENU_PID = 0)");
		sql.append("        ) ");
		
		// 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
		if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
			sql.append(" AND IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		// 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
		sql.append("    AND SYSTEM_ID =(");
		sql.append("       	SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
		sql.append("         WHERE ");
		if (parameters.containsKey("systemId")) {
			sql.append("           SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
		} else {
			sql.append("           SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
		}
		// 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
		if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
			sql.append("                 AND IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append("      ) ");
		sql.append(" ORDER BY MENU_PID,SORT,MENU_ID ");
		return sql.toString();
	}
	
	/**
	 * 根据业务系统ID/业务系统编码获取根菜单和所有级联子菜单信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @param parameters
	 *            参数列表
	 * @return SQL语句
	 */
	public static String getRootMenuListWithAllChildBySystem(final Map<String, Object> parameters) {
		// 参数校验
		if (parameters == null || parameters.size() <= 0) {
			return null;
		}
		if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
			return null;
		}
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT MENU_ID, MENU_PID, MENU_NAME, MENU_CODE,MENU_ACTION_KEY MENU_ACTION ");
		sql.append("       ,SORT `ORDER`,IS_LEAF IS_LEAF,SYSTEM_ID, IS_AVAILABLE ");
		sql.append("  FROM " + DBConstOfMenu.TN_MENU_INFO);
		sql.append(" WHERE SYSTEM_ID =(");
		// 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
		sql.append("       	SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
		sql.append("         WHERE ");
		if (parameters.containsKey("systemId")) {
			sql.append("           SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
		} else {
			sql.append("           SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
		}
		// 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
		if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
			sql.append("                 AND IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append("      ) ");
		
		// 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
		if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
			sql.append(" AND IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append(" ORDER BY MENU_PID,SORT,MENU_ID ");
		return sql.toString();
	}
	
	/**
	 * 根据业务系统ID/业务系统编码获取根菜单信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @param parameters
	 *            参数列表
	 * @return SQL语句
	 */
	public static String getOneChildMenuListBySystem(final Map<String, Object> parameters){
		// 参数校验
		if (parameters == null || parameters.size() <= 0) {
			return null;
		}
		if (!parameters.containsKey("systemId") && !parameters.containsKey("systemCode")) {
			return null;
		}
		// SQL拼装
		StringBuffer sql = new StringBuffer(128);
		sql.append("SELECT MENU_ID, MENU_PID, MENU_NAME, MENU_CODE,MENU_ACTION_KEY MENU_ACTION ");
		sql.append("       ,SORT `ORDER`,IS_LEAF,SYSTEM_ID,IS_AVAILABLE ");
		sql.append("  FROM " + DBConstOfMenu.TN_MENU_INFO);
		sql.append(" WHERE (MENU_PID = 0 ");
		/*sql.append("		SELECT ID ");
		sql.append("  		  FROM " + DBConstOfMenu.TN_MENU_INFO);
		sql.append("         WHERE PID = 0)");*/
		sql.append("        ) ");
		
		// 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
		if (parameters.containsKey("isMenuAvailable") && parameters.get("isMenuAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isMenuAvailable");
			sql.append(" AND IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		// 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
		sql.append("    AND SYSTEM_ID =(");
		sql.append("       	SELECT SYSTEM_ID FROM " + DBConstOfMenu.TN_SYSTEM_INFO);
		sql.append("         WHERE ");
		if (parameters.containsKey("systemId")) {
			sql.append("           SYSTEM_ID = #{systemId,jdbcType=BIGINT} ");
		} else {
			sql.append("           SYSTEM_CODE = #{systemCode,jdbcType=VARCHAR} ");
		}
		// 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
		if (parameters.containsKey("isSystemAvailable") && parameters.get("isSystemAvailable") != null) {
			Boolean isAvailable = (Boolean) parameters.get("isSystemAvailable");
			sql.append("                 AND IS_AVAILABLE = '");
			sql.append(isAvailable.booleanValue() ? "Y" : "N");
			sql.append("' ");
		}
		sql.append("      ) ");
		sql.append(" ORDER BY MENU_PID,SORT,MENU_ID ");
		return sql.toString();
	}
}
