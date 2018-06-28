package cn.faury.fwmf.module.api.menu.service;


import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.api.menu.bean.MenuTreeNodeBean;
import cn.faury.fwmf.module.api.menu.util.MenuFuncUtil;

import java.util.List;

/**
 * 角色菜单服务协议
 */
public interface RoleRMenuService {

	/**
	 * 根据用户Id，系统Code 获取菜单和功能树
	 *
	 * <pre>
	 *  默认条件：角色可用、菜单可用、功能可用
	 * </pre>
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemCode
	 *            【必填】系统Code
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单树
	 */
	default public List<MenuTreeNodeBean> getMenuTreeByUserSystem(final Long userId, final String systemCode,
														  final Boolean isWithFunc){
        List<MenuInfoBean> menuLst = getMenuInfoByUserSystem(userId, systemCode, isWithFunc);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据业务系统CODE、角色CODE、角色是否可用获取角色下菜单列表
	 *
	 * <pre>
	 * 默认条件：
	 * 系统是否可用：是
	 * 角色是否可用：是
	 * 菜单是否可用：是
	 * 功能按钮是否可用：是
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleCode
	 *            角色CODE
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单列表
	 */
	@Read
	default public List<MenuInfoBean> getRoleRMenuInfosByRoleCode(final String systemCode, final String roleCode,
														  final Boolean isWithFunc){
        return getRoleRMenuInfosByRoleCode(systemCode, roleCode, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }


	/**
	 * 根据业务系统ID、角色ID、角色是否可用获取角色下菜单列表
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleId
	 *            角色ID
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	@Read
	public List<MenuInfoBean> getRoleRMenuInfosByRoleId(final Long systemId, final Long roleId,
														final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
														final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据业务系统CODE、角色ID、角色是否可用获取角色下菜单列表
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleId
	 *            角色ID
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return
	 */
	@Read
	public List<MenuInfoBean> getRoleRMenuInfosByRoleId(final String systemCode, final Long roleId,
														final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
														final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据业务系统ID、角色CODE、角色是否可用获取角色下菜单列表
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleCode
	 *            角色CODE
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	@Read
	public List<MenuInfoBean> getRoleRMenuInfosByRoleCode(final Long systemId, final String roleCode,
														  final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
														  final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据业务系统CODE、角色CODE、角色是否可用获取角色下菜单列表
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleCode
	 *            角色CODE
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	@Read
	public List<MenuInfoBean> getRoleRMenuInfosByRoleCode(final String systemCode, final String roleCode,
														  final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
														  final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 插入角色菜单关联关系
	 *
	 * @param roleId
	 *            角色ID
	 * @param menuIds
	 *            多个菜单ID
	 * @return 成功插入条数
	 */
	@Write
	public Integer insertRoleRMenuInfo(final Long roleId, final List<Long> menuIds);

	/**
	 * 删除角色菜单关联关系，同时删除角色关联菜单的功能按钮
	 *
	 * @param roleId
	 *            角色ID
	 * @param menuIds
	 *            多个菜单ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteRoleRMenuInfo(final Long roleId, final List<Long> menuIds);

	/**
	 * 删除角色下所有的授权菜单，同时删除角色关联的所有授权功能按钮
	 *
	 * @param roleId
	 *            角色ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteAllRoleRMenuInfo(final Long roleId);

	/**
	 * 根据用户Id，系统Id,多个角色Id 获取菜单和功能
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemId
	 *            【必填】系统Id
	 * @param roleIds
	 *            【可选】多个角色Id
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	@Read
	public List<MenuInfoBean> getMenuInfoByUserSystemAndRoleIds(final Long userId, final Long systemId,
																final List<Long> roleIds, final Boolean isWithFunc, final Boolean isRoleAvailable,
																final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据用户Id，系统Id,多个角色Code 获取菜单和功能
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemId
	 *            【必填】系统Id
	 * @param roleCodes
	 *            【可选】多个角色Code
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	@Read
	public List<MenuInfoBean> getMenuInfoByUserSystemAndRoleCodes(final Long userId, final Long systemId,
																  final List<String> roleCodes, final Boolean isWithFunc, final Boolean isRoleAvailable,
																  final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据用户Id，系统Code,多个角色Code 获取菜单和功能
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemCode
	 *            【必填】系统Code
	 * @param roleCodes
	 *            【可选】多个角色Code
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	@Read
	public List<MenuInfoBean> getMenuInfoByUserSystemAndRoleCodes(final Long userId, final String systemCode,
																  final List<String> roleCodes, final Boolean isWithFunc, final Boolean isRoleAvailable,
																  final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据用户Id，系统Code,多个角色Id 获取菜单和功能
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemCode
	 *            【必填】系统Code
	 * @param roleIds
	 *            【可选】多个角色Id
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	@Read
	public List<MenuInfoBean> getMenuInfoByUserSystemAndRoleIds(final Long userId, final String systemCode,
																final List<Long> roleIds, final Boolean isWithFunc, final Boolean isRoleAvailable,
																final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 更新角色菜单、角色功能
	 *
	 * <pre>
	 * (先删除角色相关联的菜单和功能，然后添加新的关联角色、功能)
	 * </pre>
	 *
	 * @param roleId
	 *            角色id
	 * @param menuIds
	 *            菜单ID
	 * @param funcIds
	 *            菜单功能ID
	 * @return 更新成功数
	 */
	@Write
	public Integer updateRoleRMenuInfo(Long roleId, List<Long> menuIds, List<Long> funcIds);

	/* ====================重载==================== */

	/**
	 * 根据业务系统ID、角色ID、角色是否可用获取角色下菜单列表
	 *
	 * <pre>
	 * 默认条件：
	 * 系统是否可用：是
	 * 角色是否可用：是
	 * 菜单是否可用：是
	 * 功能按钮是否可用：是
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleId
	 *            角色ID
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单列表
	 */
	@Read
	default public List<MenuInfoBean> getRoleRMenuInfosByRoleId(final Long systemId, final Long roleId, final Boolean isWithFunc){
        return getRoleRMenuInfosByRoleId(systemId, roleId, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统CODE、角色ID、角色是否可用获取角色下菜单列表
	 *
	 * <pre>
	 * 默认条件：
	 * 系统是否可用：是
	 * 角色是否可用：是
	 * 菜单是否可用：是
	 * 功能按钮是否可用：是
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleId
	 *            角色ID
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单列表
	 */
	@Read
	default public List<MenuInfoBean> getRoleRMenuInfosByRoleId(final String systemCode, final Long roleId,
														final Boolean isWithFunc){
        return getRoleRMenuInfosByRoleId(systemCode, roleId, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统ID、角色CODE、角色是否可用获取角色下菜单列表
	 *
	 * <pre>
	 * 默认条件：
	 * 系统是否可用：是
	 * 角色是否可用：是
	 * 菜单是否可用：是
	 * 功能按钮是否可用：是
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleCode
	 *            角色CODE
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单列表
	 */
	@Read
	default public List<MenuInfoBean> getRoleRMenuInfosByRoleCode(final Long systemId, final String roleCode,
														  final Boolean isWithFunc){
        return getRoleRMenuInfosByRoleCode(systemId, roleCode, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统ID、角色ID、角色是否可用获取角色下菜单树
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleId
	 *            角色ID
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getRoleRMenuTreesByRoleId(final Long systemId, final Long roleId,
															final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
															final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        // 获取列表形式数据
        List<MenuInfoBean> menuLst = getRoleRMenuInfosByRoleId(systemId, roleId, isWithFunc, isSystemAvailable,
                isRoleAvailable, isMenuAvailable, isFuncAvailable);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据业务系统CODE、角色ID、角色是否可用获取角色下菜单树
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleId
	 *            角色ID
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getRoleRMenuTreesByRoleId(final String systemCode, final Long roleId,
															final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
															final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        // 获取列表形式数据
        List<MenuInfoBean> menuLst = getRoleRMenuInfosByRoleId(systemCode, roleId, isWithFunc, isSystemAvailable,
                isRoleAvailable, isMenuAvailable, isFuncAvailable);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据业务系统ID、角色CODE、角色是否可用获取角色下菜单树
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleCode
	 *            角色CODE
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getRoleRMenuTreesByRoleCode(final Long systemId, final String roleCode,
															  final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
															  final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        // 获取列表形式数据
        List<MenuInfoBean> menuLst = getRoleRMenuInfosByRoleCode(systemId, roleCode, isWithFunc, isSystemAvailable,
                isRoleAvailable, isMenuAvailable, isFuncAvailable);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据业务系统CODE、角色CODE、角色是否可用获取角色下菜单树
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleCode
	 *            角色CODE
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getRoleRMenuTreesByRoleCode(final String systemCode, final String roleCode,
															  final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
															  final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        // 获取列表形式数据
        List<MenuInfoBean> menuLst = getRoleRMenuInfosByRoleCode(systemCode, roleCode, isWithFunc, isSystemAvailable,
                isRoleAvailable, isMenuAvailable, isFuncAvailable);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据业务系统ID、角色ID、角色是否可用获取角色下菜单树
	 *
	 * <pre>
	 * 默认条件：
	 * 系统是否可用：是
	 * 角色是否可用：是
	 * 菜单是否可用：是
	 * 功能按钮是否可用：是
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleId
	 *            角色ID
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getRoleRMenuTreesByRoleId(final Long systemId, final Long roleId,
															final Boolean isWithFunc){
        return getRoleRMenuTreesByRoleId(systemId, roleId, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统ID、角色CODE、角色是否可用获取角色下菜单树
	 *
	 * <pre>
	 * 默认条件：
	 * 系统是否可用：是
	 * 角色是否可用：是
	 * 菜单是否可用：是
	 * 功能按钮是否可用：是
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleCode
	 *            角色CODE
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getRoleRMenuTreesByRoleCode(final Long systemId, final String roleCode,
															  final Boolean isWithFunc){
        return getRoleRMenuTreesByRoleCode(systemId, roleCode, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统CODE、角色CODE、角色是否可用获取角色下菜单树
	 *
	 * <pre>
	 * 默认条件：
	 * 系统是否可用：是
	 * 角色是否可用：是
	 * 菜单是否可用：是
	 * 功能按钮是否可用：是
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleCode
	 *            角色CODE
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getRoleRMenuTreesByRoleCode(final String systemCode, final String roleCode,
															  final Boolean isWithFunc){
        return getRoleRMenuTreesByRoleCode(systemCode, roleCode, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据用户Id，系统Id 获取菜单和功能
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemId
	 *            【必填】系统Id
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	@Read
	default public List<MenuInfoBean> getMenuInfoByUserSystem(final Long userId, final Long systemId, final Boolean isWithFunc,
													  final Boolean isRoleAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        return getMenuInfoByUserSystemAndRoleIds(userId, systemId, null, isWithFunc, isRoleAvailable, isMenuAvailable,
                isFuncAvailable);
    }

	/**
	 * 根据用户Id，系统Code 获取菜单和功能
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemCode
	 *            【必填】系统Code
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	default public List<MenuInfoBean> getMenuInfoByUserSystem(final Long userId, final String systemCode,
													  final Boolean isWithFunc, final Boolean isRoleAvailable, final Boolean isMenuAvailable,
													  final Boolean isFuncAvailable){
        return getMenuInfoByUserSystemAndRoleIds(userId, systemCode, null, isWithFunc, isRoleAvailable,
                isMenuAvailable, isFuncAvailable);
    }

	/**
	 * 根据用户Id，系统Id 获取菜单和功能
	 *
	 * <pre>
	 *  默认条件：角色可用、菜单可用、功能可用
	 * </pre>
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemId
	 *            【必填】系统Id
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单列表
	 */
	@Read
	default public List<MenuInfoBean> getMenuInfoByUserSystem(final Long userId, final Long systemId, final Boolean isWithFunc){
        return getMenuInfoByUserSystem(userId, systemId, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据用户Id，系统Code 获取菜单和功能
	 *
	 * <pre>
	 *  默认条件：角色可用、菜单可用、功能可用
	 * </pre>
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemCode
	 *            【必填】系统Code
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单列表
	 */
	default public List<MenuInfoBean> getMenuInfoByUserSystem(final Long userId, final String systemCode,
													  final Boolean isWithFunc){
        return getMenuInfoByUserSystem(userId, systemCode, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据用户Id，系统Id,多个角色Id 获取菜单和功能树
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemId
	 *            【必填】系统Id
	 * @param roleIds
	 *            【可选】多个角色Id
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getMenuTreeByUserSystemAndRoleIds(final Long userId, final Long systemId,
																	final List<Long> roleIds, final Boolean isWithFunc, final Boolean isRoleAvailable,
																	final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        List<MenuInfoBean> menuLst = getMenuInfoByUserSystemAndRoleIds(userId, systemId, roleIds, isWithFunc,
                isRoleAvailable, isMenuAvailable, isFuncAvailable);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据用户Id，系统Id,多个角色Code 获取菜单和功能树
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemId
	 *            【必填】系统Id
	 * @param roleCodes
	 *            【可选】多个角色Code
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getMenuTreeByUserSystemAndRoleCodes(final Long userId, final Long systemId,
																	  final List<String> roleCodes, final Boolean isWithFunc, final Boolean isRoleAvailable,
																	  final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        List<MenuInfoBean> menuLst = getMenuInfoByUserSystemAndRoleCodes(userId, systemId, roleCodes, isWithFunc,
                isRoleAvailable, isMenuAvailable, isFuncAvailable);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据用户Id，系统Code,多个角色Code 获取菜单和功能树
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemCode
	 *            【必填】系统Code
	 * @param roleCodes
	 *            【可选】多个角色Code
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getMenuTreeByUserSystemAndRoleCodes(final Long userId, final String systemCode,
																	  final List<String> roleCodes, final Boolean isWithFunc, final Boolean isRoleAvailable,
																	  final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        List<MenuInfoBean> menuLst = getMenuInfoByUserSystemAndRoleCodes(userId, systemCode, roleCodes, isWithFunc,
                isRoleAvailable, isMenuAvailable, isFuncAvailable);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据用户Id，系统Code,多个角色Id 获取菜单和功能树
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemCode
	 *            【必填】系统Code
	 * @param roleIds
	 *            【可选】多个角色Id
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getMenuTreeByUserSystemAndRoleIds(final Long userId, final String systemCode,
																	final List<Long> roleIds, final Boolean isWithFunc, final Boolean isRoleAvailable,
																	final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        List<MenuInfoBean> menuLst = getMenuInfoByUserSystemAndRoleIds(userId, systemCode, roleIds, isWithFunc,
                isRoleAvailable, isMenuAvailable, isFuncAvailable);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据用户Id，系统Id 获取菜单和功能树
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemId
	 *            【必填】系统Id
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getMenuTreeByUserSystem(final Long userId, final Long systemId,
														  final Boolean isWithFunc, final Boolean isRoleAvailable, final Boolean isMenuAvailable,
														  final Boolean isFuncAvailable){
        List<MenuInfoBean> menuLst = getMenuInfoByUserSystem(userId, systemId, isWithFunc, isRoleAvailable,
                isMenuAvailable, isFuncAvailable);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据用户Id，系统Code 获取菜单和功能树
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemCode
	 *            【必填】系统Code
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单树
	 */
	default public List<MenuTreeNodeBean> getMenuTreeByUserSystem(final Long userId, final String systemCode,
														  final Boolean isWithFunc, final Boolean isRoleAvailable, final Boolean isMenuAvailable,
														  final Boolean isFuncAvailable){
        List<MenuInfoBean> menuLst = getMenuInfoByUserSystem(userId, systemCode, isWithFunc, isRoleAvailable,
                isMenuAvailable, isFuncAvailable);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据用户Id，系统Id 获取菜单和功能树
	 *
	 * <pre>
	 *  默认条件：角色可用、菜单可用、功能可用
	 * </pre>
	 *
	 * @param userId
	 *            【必填】用户Id
	 * @param systemId
	 *            【必填】系统Id
	 * @param isWithFunc
	 *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
	 * @return 菜单树
	 */
	@Read
	default public List<MenuTreeNodeBean> getMenuTreeByUserSystem(final Long userId, final Long systemId,
														  final Boolean isWithFunc){
        List<MenuInfoBean> menuLst = getMenuInfoByUserSystem(userId, systemId, isWithFunc);
        // 转换为树形
        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

}
