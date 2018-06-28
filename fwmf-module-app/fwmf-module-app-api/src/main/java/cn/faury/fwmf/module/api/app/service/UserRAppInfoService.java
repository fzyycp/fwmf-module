package cn.faury.fwmf.module.api.app.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.app.bean.UserRAppInfoBean;

import java.util.List;

/**
 * 用户授权APP服务
 */
public interface UserRAppInfoService {

	/**
	 * 获取用户授权App信息
	 * 
	 * @param userIds
	 *            多个用户ID
	 * @param isAppAvailable
	 *            APP是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
	 * @return 授权的App列表
	 * 
	 */
	@Read
	public List<UserRAppInfoBean> getUserRAppInfoList(final List<Long> userIds, final Boolean isAppAvailable);

	/**
	 * 获取用户授权App信息，仅查询可用状态的APP
	 * 
	 * @param userIds
	 *            多个用户ID
	 * @return 授权的App列表
	 * @see #getUserRAppInfoList(List, Boolean)
	 */
	@Read
	default public List<UserRAppInfoBean> getUserRAppInfoList(final List<Long> userIds){
		return getUserRAppInfoList(userIds, Boolean.TRUE);
	}

	/**
	 * 插入用户授权APP对象
	 * 
	 * <pre>
	 * 仅使用以下字段：
	 * 【必填】Long userId：用户ID
	 * 【必填】Long appId：APP ID
	 * 其他字段都不使用
	 * </pre>
	 * 
	 * @param userRApps
	 *            用户授权APP信息
	 * @return 成功插入条数
	 */
	@Write
	public Integer insertUserRApp(final List<UserRAppInfoBean> userRApps);

	/**
	 * 获取用户授权App信息（多个APP信息合并）
	 *
	 * <pre>
	 * 如果查询结果不需要合并APP，则使用{@link #getUserRAppInfoList(List, Boolean)}
	 * </pre>
	 *
	 * @param userIds
	 *            多个用户ID
	 * @param isAppAvailable
	 *            APP是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
	 * @return 授权的App列表
	 *
	 */
	@Read
	public List<UserRAppInfoBean> getUserRAppInfoListWithConcat(final List<Long> userIds, final Boolean isAppAvailable);

	/**
	 * 根据用户授权APP对象ID删除用户授权关系
	 *
	 * @param ids
	 *            多个唯一主键ID
	 * @return 成功删除的条数
	 */
	@Write
	public Integer deleteUserRAppById(final List<Long> ids);

	/**
	 * 根据用户ID删除用户所有授权APP关系
	 *
	 * @param userIds
	 *            多个用户ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteUserRAppByUserId(final List<Long> userIds);

	/**
	 * 根据用户ID、多个APP ID删除用户授权APP关系
	 *
	 * @param appIds
	 *            多个APP的ID
	 * @param userId
	 *            用户ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteUserRAppByUserId(final List<Long> appIds, final Long userId);

	/* ====================重载==================== */

	/**
	 * 获取用户授权App信息（多个APP信息合并），仅查询可用状态的APP
	 *
	 * <pre>
	 * 如果查询结果不需要合并APP，则使用{@link #getUserRAppInfoList(List)}
	 * </pre>
	 *
	 * @param userIds
	 *            多个用户ID
	 * @return 授权的App列表
	 * @see #getUserRAppInfoListWithConcat(List, Boolean)
	 */
	@Read
	default public List<UserRAppInfoBean> getUserRAppInfoListWithConcat(final List<Long> userIds){
		return getUserRAppInfoListWithConcat(userIds, Boolean.TRUE);
	}

}
