package cn.faury.fwmf.module.api.menu.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.menu.bean.FunctionInfoBean;

import java.util.List;

/**
 * 角色功能按钮服务协议
 */
@Deprecated
public interface RoleRFuncService {

	/**
	 * 根据业务系统CODE、角色ID、菜单ID获取角色下菜单功能按钮列表
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
	 * @param menuId
	 *            菜单ID
	 * @return 菜单功能按钮列表
	 */
	@Read
	default public List<FunctionInfoBean> getRoleRFuncInfosByRoleId(final String systemCode, final Long roleId,
															final Long menuId){
        return getRoleRFuncInfosByRoleId(systemCode, roleId, menuId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统CODE、角色ID、菜单编码获取角色下菜单功能按钮列表
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
	 * @param menuCode
	 *            菜单编码
	 * @return 菜单功能按钮列表
	 */
	@Read
	default public List<FunctionInfoBean> getRoleRFuncInfosByRoleId(final String systemCode, final Long roleId,
                                                            final String menuCode){
        return getRoleRFuncInfosByRoleId(systemCode, roleId, menuCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统CODE、角色CODE、菜单ID获取角色下菜单功能按钮列表
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
	 * @param menuId
	 *            菜单ID
	 * @return 菜单功能按钮列表
	 */
	@Read
	default public List<FunctionInfoBean> getRoleRFuncInfosByRoleCode(final String systemCode, final String roleCode,
                                                              final Long menuId){
        return getRoleRFuncInfosByRoleCode(systemCode, roleCode, menuId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统CODE、角色CODE、菜单编码获取角色下菜单功能按钮列表
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
	 * @param menuCode
	 *            菜单 编码
	 * @return 菜单功能按钮列表
	 */
	@Read
	default public List<FunctionInfoBean> getRoleRFuncInfosByRoleCode(final String systemCode, final String roleCode,
                                                              final String menuCode){
        return getRoleRFuncInfosByRoleCode(systemCode, roleCode, menuCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }


	/**
	 * 根据业务系统ID、角色ID、菜单ID、是否可用等获取角色下菜单功能按钮列表
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleId
	 *            角色ID
	 * @param menuId
	 *            菜单ID
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getRoleRFuncInfosByRoleId(final Long systemId, final Long roleId, final Long menuId,
															final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isMenuAvailable,
															final Boolean isFuncAvailable);

	/**
	 * 根据业务系统CODE、角色ID、菜单ID、是否可用等获取角色下菜单功能按钮列表
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleId
	 *            角色ID
	 * @param menuId
	 *            菜单ID
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getRoleRFuncInfosByRoleId(final String systemCode, final Long roleId, final Long menuId,
															final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isMenuAvailable,
															final Boolean isFuncAvailable);

	/**
	 * 根据业务系统ID、角色ID、菜单编码、是否可用等获取角色下菜单功能按钮列表
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleId
	 *            角色ID
	 * @param menuCode
	 *            菜单编码
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getRoleRFuncInfosByRoleId(final Long systemId, final Long roleId,
															final String menuCode,
															final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isMenuAvailable,
															final Boolean isFuncAvailable);

	/**
	 * 根据业务系统CODE、角色ID、菜单编码、是否可用等获取角色下菜单功能按钮列表
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleId
	 *            角色ID
	 * @param menuCode
	 *            菜单编码
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getRoleRFuncInfosByRoleId(final String systemCode, final Long roleId,
															final String menuCode, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
															final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据业务系统ID、角色CODE、菜单ID、是否可用等获取角色下菜单功能按钮列表
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleCode
	 *            角色CODE
	 * @param menuId
	 *            菜单ID
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getRoleRFuncInfosByRoleCode(final Long systemId, final String roleCode,
															  final Long menuId,
															  final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isMenuAvailable,
															  final Boolean isFuncAvailable);

	/**
	 * 根据业务系统CODE、角色CODE、菜单ID、是否可用等获取角色下菜单功能按钮列表
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleCode
	 *            角色CODE
	 * @param menuId
	 *            菜单ID
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getRoleRFuncInfosByRoleCode(final String systemCode, final String roleCode,
															  final Long menuId, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
															  final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据业务系统ID、角色CODE、菜单编码、是否可用等获取角色下菜单功能按钮列表
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param roleCode
	 *            角色CODE
	 * @param menuCode
	 *            菜单编码
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getRoleRFuncInfosByRoleCode(final Long systemId, final String roleCode,
															  final String menuCode, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
															  final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据业务系统CODE、角色CODE、菜单编码、是否可用等获取角色下菜单功能按钮列表
	 *
	 * @param systemCode
	 *            业务系统CODE
	 * @param roleCode
	 *            角色CODE
	 * @param menuCode
	 *            菜单编码
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isRoleAvailable
	 *            角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable
	 *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getRoleRFuncInfosByRoleCode(final String systemCode, final String roleCode,
															  final String menuCode, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
															  final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 插入角色功能按钮关联关系
	 *
	 * @param roleId
	 *            角色ID
	 * @param funcIds
	 *            多个功能按钮ID
	 * @return 成功插入条数
	 */
	@Write
	public Integer insertRoleRFuncInfo(final Long roleId, final List<Long> funcIds);

	/**
	 * 删除角色功能按钮关联关系
	 *
	 * @param roleId
	 *            角色ID
	 * @param funcIds
	 *            多个功能按钮ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteRoleRFuncInfo(final Long roleId, final List<Long> funcIds);

	/**
	 * 删除角色下所有的授权功能按钮
	 *
	 * @param roleId
	 *            角色ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteAllRoleRFuncInfo(final Long roleId);

	/**
	 * 根据用户Id，系统Id,多个角色Id 获取功能
	 * @param userId 【必填】用户Id
	 * @param systemId 【必填】系统Id
	 * @param roleIds 【可选】多个角色Id
	 * @param isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable 功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getFuncByUserSystemAndRoleIds(final Long userId,final Long systemId,
																final List<Long> roleIds,final Boolean isRoleAvailable,
																final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据用户Id，系统Code,多个角色Id 获取功能
	 * @param userId  【必填】用户Id
	 * @param systemCode 【必填】系统Code
	 * @param roleIds 【可选】多个角色Id
	 * @param isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable 功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getFuncByUserSystemAndRoleIds(final Long userId,final String systemCode,
																final List<Long> roleIds,final Boolean isRoleAvailable,
																final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据用户Id，系统Id,多个角色Code 获取功能
	 * @param userId 【必填】用户Id
	 * @param systemId 【必填】系统Id
	 * @param roleCodes 【可选】多个角色Code
	 * @param isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable 功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getFuncByUserSystemAndRoleCodes(final Long userId,final Long systemId,
																  final List<String> roleCodes,final Boolean isRoleAvailable,
																  final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/**
	 * 根据用户Id，系统Code,多个角色Code 获取功能
	 * @param userId 【必填】用户Id
	 * @param systemCode 【必填】系统Code
	 * @param roleCodes 【可选】多个角色Code
	 * @param isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable 功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	public List<FunctionInfoBean> getFuncByUserSystemAndRoleCodes(final Long userId,final String systemCode,
																  final List<String> roleCodes,final Boolean isRoleAvailable,
																  final Boolean isMenuAvailable, final Boolean isFuncAvailable);

	/* ====================重载==================== */

	/**
	 * 根据业务系统ID、角色ID、菜单ID获取角色下菜单功能按钮列表
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
	 * @param menuId
	 *            菜单ID
	 * @return 菜单功能按钮列表
	 */
	@Read
	default public List<FunctionInfoBean> getRoleRFuncInfosByRoleId(final Long systemId, final Long roleId, final Long menuId){
        return getRoleRFuncInfosByRoleId(systemId, roleId, menuId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统ID、角色ID、菜单编码获取角色下菜单功能按钮列表
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
	 * @param menuCode
	 *            菜单编码
	 * @return 菜单功能按钮列表
	 */
	@Read
	default public List<FunctionInfoBean> getRoleRFuncInfosByRoleId(final Long systemId, final Long roleId,
															final String menuCode){
        return getRoleRFuncInfosByRoleId(systemId, roleId, menuCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统ID、角色CODE、菜单ID获取角色下菜单功能按钮列表
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
	 * @param menuId
	 *            菜单ID
	 * @return 菜单功能按钮列表
	 */
	@Read
	default public List<FunctionInfoBean> getRoleRFuncInfosByRoleCode(final Long systemId, final String roleCode,
															  final Long menuId){
        return getRoleRFuncInfosByRoleCode(systemId, roleCode, menuId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据业务系统ID、角色CODE、菜单编码获取角色下菜单功能按钮列表
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
	 * @param menuCode
	 *            菜单编码
	 * @return 菜单功能按钮列表
	 */
	@Read
	default public List<FunctionInfoBean> getRoleRFuncInfosByRoleCode(final Long systemId, final String roleCode,
															  final String menuCode){
        return getRoleRFuncInfosByRoleCode(systemId, roleCode, menuCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                Boolean.TRUE);
    }

	/**
	 * 根据用户Id，系统Id 获取功能
	 * @param userId  【必填】用户Id
	 * @param systemId 【必填】系统Id
	 * @param isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable 功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	default public List<FunctionInfoBean> getFuncByUserSystem(final Long userId,final Long systemId,
													  final Boolean isRoleAvailable,
													  final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        return getFuncByUserSystemAndRoleIds(userId, systemId, null, isRoleAvailable, isMenuAvailable,
                isFuncAvailable);
    }

	/**
	 * 根据用户Id，系统Code 获取功能
	 * @param userId  【必填】用户Id
	 * @param systemCode 【必填】系统Id
	 * @param isRoleAvailable 角色是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isFuncAvailable 功能是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单功能按钮列表
	 */
	@Read
	default public List<FunctionInfoBean> getFuncByUserSystem(final Long userId,final String systemCode,
													  final Boolean isRoleAvailable,
													  final Boolean isMenuAvailable, final Boolean isFuncAvailable){
        return getFuncByUserSystemAndRoleIds(userId, systemCode, null, isRoleAvailable, isMenuAvailable,
                isFuncAvailable);
    }
}
