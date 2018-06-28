package cn.faury.fwmf.module.api.user.service;


import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.user.bean.UserAgentInfoBean;

import java.util.List;
import java.util.Map;


/**
 * 用户代理
 */
public interface UserAgentService {

	/**
	 * 根据被代理用户ID获取所有代理人信息对象
	 * 
	 * @param userId
	 *            被代理用户ID
	 * @return 代理人信息对象
	 */
	@Read
	public List<UserAgentInfoBean> getUserAgentInfoByUserId(final Long userId);

	/**
	 * 根据代理用户ID获取所有被代理人信息对象
	 * 
	 * @param agentUserId
	 *            被代理用户ID
	 * @return 代理人信息对象
	 */
	@Read
	public List<UserAgentInfoBean> getUserAgentInfoByAgentUserId(final Long agentUserId);

	/* ==========用户代理信息========== */

	/**
	 * 插入用户代理人信息
	 *
	 * <pre>
	 * 新增规则：如果对象为null或验证不过则直接返回-1
	 * 参数说明：
	 * 【不使用】id：唯一主键
	 * 【必填】userId：被代理人ID
	 * 【不使用】loginName：被代理人登录名
	 * 【必填】agentUserId：代理人ID
	 * 【不使用】agentLoginName：代理人登录名
	 * 【必填】osId：业务系统ID或者APP ID
	 * 【不使用】osCode：业务系统编码或者APP编码
	 * 【不使用】osName：业务系统名称或者APP名称
	 * 【必填】osType：系统类型【0:业务系统，1:手机APP】
	 * 【必填】isAvailable：是否可用【Y:是 N：否】
	 * </pre>
	 *
	 * @param userAgentInfo
	 *            要插入的对象
	 * @return 如果保存成功则返回唯一主键ID，否则返回-1
	 */
	@Write
	public Long insertUserAgentInfo(final UserAgentInfoBean userAgentInfo);

	/**
	 * 修改代理人信息（是否启用）
	 *
	 * @param userAgentInfo
	 *            要修改的对象
	 *
	 *            <pre>
	 * 【使用】id：唯一主键
	 * 【必填】isAvailable：是否可用【Y:是 N：否】
	 * </pre>
	 * @return
	 */
	public Long updateUserAgentInfo(final UserAgentInfoBean userAgentInfo);

	/**
	 * 根据用户代理人关系表唯一主键ID删除代理人信息对象
	 *
	 * @param ids
	 *            多个唯一主键ID
	 * @return 代理人信息对象
	 */
	@Write
	public Integer deleteUserAgentInfoById(final List<Long> ids);

	/**
	 * 根据被代理人ID删除所有代理人关系
	 *
	 * @param userIds
	 *            多个被代理人ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteUserAgentInfoByUserId(final List<Long> userIds);

	/**
	 * 根据被代理人ID、代理人ID删除代理人关系
	 *
	 * @param agentUserIds
	 *            多个代理人ID
	 * @param userId
	 *            被代理人ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteUserAgentInfoByUserId(final List<Long> agentUserIds, final Long userId);

	/**
	 * 查询代理人信息列表
	 *
	 * <pre>
	 * 查询规则：如果对象为null或者字符串为''，则不使用该条件查询
	 * 参数说明：
	 * 【可选】id：唯一主键
	 * 【可选】userId：被代理人ID
	 * 【不使用】loginName：被代理人登录名
	 * 【可选】agentUserId：代理人ID
	 * 【不使用】agentLoginName：代理人登录名
	 * 【可选】osId：业务系统ID或者APP ID
	 * 【不使用】osCode：业务系统编码或者APP编码
	 * 【不使用】osName：业务系统名称或者APP名称
	 * 【可选】osType：系统类型【0:业务系统，1:手机APP】
	 * 【可选】isAvailable：是否可用【Y:是 N：否】
	 * </pre>
	 *
	 * @param userAgentInfo
	 *            查询参数对象
	 * @return 查询结果列表
	 */
	@Read
	public List<UserAgentInfoBean> queryUserAgentInfo(final UserAgentInfoBean userAgentInfo);

	/**
	 * 查询未代理当前用户的授权系统的当前系统用户
	 *
	 * <pre>
	 * 参数说明：
	 * page：分页参数
	 * rows:分页参数
	 * 【必选】userId：被代理人ID
	 * 【必选】osId：业务系统ID或者APP ID
	 * </pre>
	 *
	 * @return
	 */
	@Read
	public PageInfo<UserAgentInfoBean> queryUserUnAgentInfo(final Map<String, Object> parameters);

	/**
	 * 根据用户代理人关系表唯一主键ID查询代理人信息对象
	 *
	 * @param id
	 *            唯一主键ID
	 * @return 代理人信息对象
	 */
	@Read
	public UserAgentInfoBean getUserAgentInfoById(final Long id);

}
