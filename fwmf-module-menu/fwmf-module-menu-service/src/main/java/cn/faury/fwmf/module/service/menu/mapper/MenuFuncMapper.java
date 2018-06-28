package cn.faury.fwmf.module.service.menu.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.menu.bean.MenuFuncInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfMenu;
import cn.faury.fwmf.module.service.menu.sqlProvider.MenuFuncSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 菜单功能Mapper
 */
@AutoScannedMapper
public interface MenuFuncMapper {

	/**
	 * 根据功能按钮获取功能按钮信息
	 * 
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
	 * @return 功能按钮信息
	 */
	@SelectProvider(type = MenuFuncSQLProvider.class, method = "getMenuFuncInfoByFunc")
	@ResultType(MenuFuncInfoBean.class)
	public MenuFuncInfoBean getMenuFuncInfoByFunc();

	/**
	 * 根据菜单获取功能按钮清单信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
	 * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return 功能按钮信息
	 */
	@SelectProvider(type = MenuFuncSQLProvider.class, method = "getMenuFuncListByMenu")
	@ResultType(MenuFuncInfoBean.class)
	public List<MenuFuncInfoBean> getMenuFuncListByMenu();

	/**
	 * 根据父菜单获取功能按钮清单信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【二选一】Long menuPId 父菜单ID / String menuPCode 菜单编码
	 * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return 功能按钮信息
	 */
	@SelectProvider(type = MenuFuncSQLProvider.class, method = "getChildMenuFuncListByMenu")
	@ResultType(MenuFuncInfoBean.class)
	public List<MenuFuncInfoBean> getChildMenuFuncListByMenu();

	/**
	 * 根据功能编码查询功能信息（判断功能编码是否存在）
	 */
	@SelectProvider(type = MenuFuncSQLProvider.class, method = "getMenuFuncInfoByFuncCode")
	@ResultType(MenuFuncInfoBean.class)
	public MenuFuncInfoBean getMenuFuncInfoByFuncCode();

	/**
	 * 根据功能ID判断是否存在角色关联功能
	 */
	@SelectProvider(type = MenuFuncSQLProvider.class, method = "getFuncCountById")
	public int getFuncCountById();

	/**
	 * 插入菜单功能信息
	 * 
	 * @param menuFuncInfo
	 *            菜单功能按钮对象
	 * 
	 * @return 菜单功能id
	 */
	@Insert("INSERT INTO " + DBConstOfMenu.TN_FUNCTION_INFO + " (`FUNCTION_NAME`, `FUNCTION_CODE`,`MENU_ID`, `SYSTEM_ID`,`IS_AVAILABLE`) VALUES "
	        + "(#{funcName}, #{funcCode},#{menuId,jdbcType=BIGINT}, #{systemId,jdbcType=BIGINT}, #{isAvailable})")
	@Options(keyProperty = "funcId", useGeneratedKeys = true)
	public Integer insertMenuFuncInfo(final MenuFuncInfoBean menuFuncInfo);

	/**
	 * 修改菜单功能信息
	 * 
	 * @param menuFuncInfo
	 *            菜单功能按钮对象
	 * 
	 * @return 成功修改条数
	 */
	@UpdateProvider(type = MenuFuncSQLProvider.class, method = "updateMenuFuncInfo")
	public Integer updateMenuFuncInfo(final MenuFuncInfoBean menuFuncInfo);

	/**
	 * 根据功能按钮ID删除功能按钮信息----物理删除
	 * 
	 * @param parameter
	 *            输入参数
	 * 
	 * @return 成功删除条数
	 */
	@DeleteProvider(type = MenuFuncSQLProvider.class, method = "deleteMenuFuncInfoById")
	public Integer deleteMenuFuncInfoById(Map<String, Object> parameter);

	/**
	 * 根据菜单ID删除功能按钮信息----物理删除
	 * 
	 * @param parameter
	 *            输入参数
	 * @return 成功删除条数
	 */
	@DeleteProvider(type = MenuFuncSQLProvider.class, method = "deleteMenuFuncInfoByMenuId")
	public Integer deleteMenuFuncInfoByMenuId(Map<String, Object> parameter);
}
