package cn.faury.fwmf.module.api.system.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.system.bean.UserRSystemInfoBean;

import java.util.Arrays;
import java.util.List;

/**
 * 用户关联业务系统服务
 */
public interface UserRSystemService {

	/**
	 * 获取用户授权业务系统信息
	 * 
	 * <pre>
	 * 如果查询结果需要合并业务系统，则使用{@link #getUserRSystemInfoListWithConcat(List, Boolean)}
	 * </pre>
	 * 
	 * @param userIds
	 *            多个用户ID
	 * @param isSystemAvailable
	 *            业务系统是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
	 * @return 授权的业务系统列表
	 * 
	 */
	@Read
	public List<UserRSystemInfoBean> getUserRSystemInfoList(final List<Long> userIds, final Boolean isSystemAvailable);

	/**
	 * 根据用户ID删除用户所有授权业务系统关系
	 * 
	 * @param userIds
	 *            多个用户ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteUserRSystemByUserId(final List<Long> userIds);

	/**
	 * 获取用户授权业务系统信息，仅查询可用状态的业务系统
	 * 
	 * @param userIds
	 *            多个用户ID
	 * @return 授权的业务系统列表
	 * @see #getUserRSystemInfoList(List, Boolean)
	 */
	@Read
	default public List<UserRSystemInfoBean> getUserRSystemInfoList(final List<Long> userIds){
        return getUserRSystemInfoList(userIds, Boolean.TRUE);
    }

	/**
	 * 授权用户关联业务系统
	 * 
	 * @param userId
	 *            用户ID
	 * @param systemCode
	 *            业务系统编码
	 * @return 成功插入条数
	 */
	@Write
	public Integer insertUserRSystem(final Long userId, final String systemCode);


	/**
	 * 获取用户授权业务系统信息（多个业务系统信息合并）
	 *
	 * <pre>
	 * 如果查询结果不需要合并业务系统，则使用{@link #getUserRSystemInfoList(List, Boolean)}
	 * </pre>
	 *
	 * @param userIds
	 *            多个用户ID
	 * @param isSystemAvailable
	 *            业务系统是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
	 * @return 授权的业务系统列表
	 *
	 */
	@Read
	public List<UserRSystemInfoBean> getUserRSystemInfoListWithConcat(final List<Long> userIds,
																	  final Boolean isSystemAvailable);

	/**
	 * 插入用户授权业务系统对象
	 *
	 * <pre>
	 * 仅使用以下字段：
	 * 【必填】Long userId：用户ID
	 * 【必填】Long systemId：业务系统ID
	 * 其他字段都不使用
	 * </pre>
	 *
	 * @param userRSystems
	 *            用户授权业务系统信息
	 * @return 成功插入条数
	 */
	@Write
	public Integer insertUserRSystem(final List<UserRSystemInfoBean> userRSystems);

	/**
	 * 修改用户系统授权（删除+新增）
	 *
	 * @param addSystemIds
	 *            新增的系统授权IDs
	 * @param delSystemIds
	 *            删除的系统授权IDs
	 * @param userId
	 *            用户ID
	 * @return
	 */
	public Integer updateUserRSystem(final List<Long> addSystemIds, final List<Long> delSystemIds, final Long userId);

	/**
	 * 根据用户授权业务系统对象ID删除用户授权关系
	 *
	 * @param ids
	 *            多个唯一主键ID
	 * @return 成功删除的条数
	 */
	@Write
	public Integer deleteUserRSystemById(final List<Long> ids);

	/**
	 * 根据用户ID、多个业务系统ID删除用户授权业务系统关系
	 *
	 * @param systemIds
	 *            多个业务系统的ID
	 * @param userId
	 *            用户ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteUserRSystemByUserId(final List<Long> systemIds, final Long userId);

	/**
	 * 判断用户、授权系统是否已经设置代理人
	 */
	@Read
	public Boolean isSystemInAgentUse(final UserRSystemInfoBean userRSystems);

	/**
	 * 判断用户、授权系统是否已经关联角色
	 */
	@Read
	public Boolean isSystemRRole(final UserRSystemInfoBean userRSystems);

	/* ====================重载==================== */

	/**
	 * 获取用户授权业务系统信息（多个业务系统信息合并），仅查询可用状态的业务系统
	 *
	 * @param userIds
	 *            多个用户ID
	 * @return 授权的业务系统列表
	 * @see #getUserRSystemInfoListWithConcat(List, Boolean)
	 */
	@Read
	default public List<UserRSystemInfoBean> getUserRSystemInfoListWithConcat(final List<Long> userIds){
        return getUserRSystemInfoListWithConcat(userIds, Boolean.TRUE);
    }

	/**
	 * 授权用户关联业务系统
	 *
	 * @param userId
	 *            用户ID
	 * @param systemId
	 *            业务系统ID
	 * @return 成功插入条数
	 */
	@Write
	default public Integer insertUserRSystem(final Long userId, final Long systemId){
        return this.updateUserRSystem(Arrays.asList(systemId), null, userId);
    }
}
