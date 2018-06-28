package cn.faury.fwmf.module.service.menu.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.service.menu.sqlProvider.SystemMenuSQLProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 系统菜单Mapper
 */
@AutoScannedMapper
public interface SystemMenuMapper {

	/**
	 * 根据业务系统获取菜单及子菜单信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return 菜单及子菜单信息
	 */
	@SelectProvider(type=SystemMenuSQLProvider.class,method="getRootMenuListWithOneChildBySystem")
	@Results({@Result(property="menuId",column="MENU_ID",javaType=Long.class),
		@Result(property="menuPid",column="MENU_PID"),
		@Result(property="menuName",column="MENU_NAME"),
		@Result(property="menuCode",column="MENU_CODE"),
		@Result(property="menuAction",column="MENU_ACTION"),
		@Result(property="order",column="ORDER"),
		@Result(property="isLeaf",column="IS_LEAF"),
		@Result(property="systemId",column="SYSTEM_ID",javaType=Long.class),
		@Result(property="isAvailable",column="IS_AVAILABLE")})
	public List<MenuInfoBean> getRootMenuListWithOneChildBySystem();
	
	/**
	 * 根据业务系统获取所有菜单及所有级联子菜单信息
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return 菜单及子菜单信息
	 */
	@SelectProvider(type=SystemMenuSQLProvider.class,method="getRootMenuListWithAllChildBySystem")
	@Results({@Result(property="menuId",column="MENU_ID",javaType=Long.class),
		@Result(property="menuPid",column="MENU_PID"),
		@Result(property="menuName",column="MENU_NAME"),
		@Result(property="menuCode",column="MENU_CODE"),
		@Result(property="menuAction",column="MENU_ACTION"),
		@Result(property="order",column="ORDER"),
		@Result(property="isLeaf",column="IS_LEAF"),
		@Result(property="systemId",column="SYSTEM_ID",javaType=Long.class),
		@Result(property="isAvailable",column="IS_AVAILABLE")})
	public List<MenuInfoBean> getRootMenuListWithAllChildBySystem();
	
	/**
	 * 根据业务系统获取一级菜单信息
	 * <pre>
	 * 可能出现的参数：
	 * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
	 * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @return 菜单信息
	 */
	@SelectProvider(type=SystemMenuSQLProvider.class,method="getOneChildMenuListBySystem")
	@Results({@Result(property="menuId",column="MENU_ID",javaType=Long.class),
		@Result(property="menuPid",column="MENU_PID"),
		@Result(property="menuName",column="MENU_NAME"),
		@Result(property="menuCode",column="MENU_CODE"),
		@Result(property="menuAction",column="MENU_ACTION"),
		@Result(property="order",column="ORDER"),
		@Result(property="isLeaf",column="IS_LEAF"),
		@Result(property="systemId",column="SYSTEM_ID",javaType=Long.class),
		@Result(property="isAvailable",column="IS_AVAILABLE")})
	public List<MenuInfoBean> getOneChildMenuListBySystem();
	
	
}
