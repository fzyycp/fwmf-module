package cn.faury.fwmf.module.api.user.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.user.bean.RoleRUserBean;

import java.util.List;
import java.util.Map;


/**
 * 用户角色关联
 */
public interface RoleRUserService {

	/**
	 * 插入用户角色关系
	 * 
	 * @param roleRUser
	 *            用户角色关系
	 * @return 成功插入条数
	 */
	@Write
	public Integer insertRoleRUser(final List<RoleRUserBean> roleRUser);

	/**
	 * 根据用户ID删除用户角色关系
	 * 
	 * @param userIds
	 *            多个用户ID
	 * @return 成功删除记录条数
	 */
	@Write
	public Integer deleteRoleRUserByUserId(final List<Long> userIds);

	// ================== 用户角色关系 =====================//

	/**
	 * 根据角色ID删除用户角色关系
	 *
	 * @param roleIds
	 *            多个角色ID
	 * @return
	 */
	@Write
	public Integer deleteRoleRUserByRoleId(final List<Long> roleIds);

	/**
	 * 根据角色ID、用户ID删除用户角色关系
	 *
	 * @param roleId
	 *            角色ID
	 * @param userIds
	 *            多个用户ID
	 * @return
	 */
	@Write
	public Integer deleteRoleRUserByRoleId(Long roleId, final List<Long> userIds);

	// ------------------ 授权系统 关联角色 普通用户 -----------------------
	/**
	 * 根据角色ID查询<b> 授权系统 关联角色</b>用户信息
	 *
	 * @param systemId
	 *            系统ID
	 * @param roleId
	 *            角色ID
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getRoleRUserInfoByRoleId(final Long systemId, final Long roleId,
														final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isUserRSysAvalible);

	/**
	 * 根据角色ID查询<b> 授权系统 关联角色</b>用户信息 分页
	 *
	 * @param systemId
	 *            系统Id
	 * @param roleId
	 *            角色Id
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public PageInfo<RoleRUserBean> getRoleRUserPageListByRoleId(Map<String, String> params, final Long systemId,
															final Long roleId, final Boolean isSystemAvailable, final Boolean isRoleAvailable,
															final Boolean isUserRSysAvalible);

	/**
	 * 根据角色ID查询<b> 授权系统 关联角色</b>用户信息
	 *
	 * @param systemCode
	 *            系统编码
	 * @param roleId
	 *            角色ID
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getRoleRUserInfoByRoleId(final String systemCode, final Long roleId,
														final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isUserRSysAvalible);

	/**
	 * 根据角色编码查询<b> 授权系统 关联角色</b>用户信息
	 *
	 * @param systemCode
	 *            系统编码
	 * @param roleCode
	 *            角色编码
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getRoleRUserInfoByRoleCode(final String systemCode, final String roleCode,
														  final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isUserRSysAvalible);

	/**
	 * 根据角色编码查询<b> 授权系统 关联角色</b>用户信息
	 *
	 * @param systemId
	 *            系统ID
	 * @param roleCode
	 *            角色编码
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getRoleRUserInfoByRoleCode(final Long systemId, final String roleCode,
														  final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isUserRSysAvalible);

	// ------------------ 授权系统 关联角色 普通用户 ----------------------- END

	// ------------------ 未关联授权系统角色 普通用户 -----------------------
	/**
	 * 根据角色ID查询<b>未关联授权系统 </b>用户信息
	 *
	 * @param systemId
	 *            系统ID
	 * @param roleId
	 *            角色ID
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getUserUnRoleInfoByRoleId(final Long systemId, final Long roleId,
														 final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isUserRSysAvalible);

	/**
	 * 根据角色ID查询<b>未关联授权系统 </b>用户信息
	 *
	 * @param systemCode
	 *            系统编码
	 * @param roleId
	 *            角色ID
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getUserUnRoleInfoByRoleId(final String systemCode, final Long roleId,
														 final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isUserRSysAvalible);

	/**
	 * 根据角色编码查询<b> 未关联授权系统 </b>用户信息
	 *
	 * @param systemCode
	 *            系统编码
	 * @param roleCode
	 *            角色编码
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getUserUnRoleInfoByRoleCode(final String systemCode, final String roleCode,
														   final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isUserRSysAvalible);

	/**
	 * 根据角色编码查询<b>未关联授权系统 </b>用户信息
	 *
	 * @param systemId
	 *            系统ID
	 * @param roleCode
	 *            角色编码
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getUserUnRoleInfoByRoleCode(final Long systemId, final String roleCode,
														   final Boolean isSystemAvailable, final Boolean isRoleAvailable, final Boolean isUserRSysAvalible);

	/**
	 * 根据角色Id查询<b>未关联授权系统 </b>用户信息
	 *
	 * @param param
	 *            分页信息
	 * @param systemId
	 *            系统Id
	 * @param roleId
	 *            角色Id
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public PageInfo<RoleRUserBean> getUserUnRolePageListByRoleId(Map<String, String> param, final Long systemId,
															 final Long roleId, final Boolean isSystemAvailable, final Boolean isRoleAvailable, final String userName,
															 final Boolean isUserRSysAvalible);

	// ------------------ 未关联授权系统角色 普通用户 -----------------------END

	// ------------------ 未关联授权系统角色 商店用户 -----------------------
	/**
	 * 根据角色ID查询<b>未关联授权系统商店 </b>用户信息
	 *
	 * @param systemId
	 *            系统ID
	 * @param roleId
	 *            角色ID
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getShopUserUnRoleInfoByRoleId(final Long systemId, final Long roleId,
															 final Boolean isSystemAvailable, final Boolean isRoleAvailable);

	/**
	 * 根据角色ID查询<b>未关联授权系统商店 </b>用户信息
	 *
	 * @param systemCode
	 *            系统编码
	 * @param roleId
	 *            角色ID
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getShopUserUnRoleInfoByRoleId(final String systemCode, final Long roleId,
															 final Boolean isSystemAvailable, final Boolean isRoleAvailable);

	/**
	 * 根据角色编码查询<b>未关联授权系统商店 </b>用户信息
	 *
	 * @param systemId
	 *            系统ID
	 * @param roleCode
	 *            角色编码
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getShopUserUnRoleInfoByRoleCode(final Long systemId, final String roleCode,
															   final Boolean isSystemAvailable, final Boolean isRoleAvailable);

	/**
	 * 根据角色编码查询<b>未关联授权系统商店 </b>用户信息
	 *
	 * @param systemCode
	 *            系统编码
	 * @param roleCode
	 *            角色编码
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getShopUserUnRoleInfoByRoleCode(final String systemCode, final String roleCode,
															   final Boolean isSystemAvailable, final Boolean isRoleAvailable);

	/**
	 * 根据角色ID查询<b>未关联授权系统商店 </b>用户信息 分页
	 *
	 * @param param
	 *            分页信息
	 * @param systemId
	 *            系统Id
	 * @param roleId
	 *            角色Id
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isRoleAvailable
	 *            角色是否可用
	 * @param userName
	 *            用户登录名
	 * @return
	 */
	@Read
	public PageInfo<RoleRUserBean> getShopUserUnRolePageListByRoleId(Map<String, String> param, final Long systemId,
																	 final Long roleId, final Boolean isSystemAvailable, final Boolean isRoleAvailable, final String userName);

	// ------------------ 未关联授权系统角色 商店用户 ----------------------- END
	/**
	 * 根据系统ID查询<b> 授权系统 关联</b>用户信息
	 *
	 * @param systemId
	 *            系统ID
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getUserInfoBySystemId(final Long systemId, final Boolean isSystemAvailable,
													 final Boolean isUserRSysAvalible);

	/**
	 * 根据系统编码查询<b> 授权系统 关联</b>用户信息
	 *
	 * @param systemCode
	 *            系统编码
	 * @param isSystemAvailable
	 *            系统是否可用
	 * @param isUserRSysAvalible
	 *            授权是否启用
	 * @return
	 */
	@Read
	public List<RoleRUserBean> getUserInfoBySystemCode(final String systemCode, final Boolean isSystemAvailable,
													   final Boolean isUserRSysAvalible);

}
