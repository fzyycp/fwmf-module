package cn.faury.fwmf.module.api.apptester.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.apptester.bean.AppTesterBean;

import java.util.List;
import java.util.Map;

/**
 * app测试用户
 */
public interface AppTesterService {

	/**
	 * 通过用户ID查询（判断用户是否是测试用户）
	 * 
	 * @param appCode
	 *            APP编码
	 * @param userId
	 *            用户ID
	 * @return
	 */
	@Read
	public AppTesterBean getAppTesterByUserId(final String appCode, final Long userId);


	/**
	 * 根据条件查询测试用户信息（分页）
	 *
	 * @param parameters
	 *            <pre>
	 * Long appId appid
	 * </pre>
	 * @return Page<AppTesterBean>
	 */
	@Read
	public PageInfo<AppTesterBean> queryAppTesterPage(final Map<String, Object> parameters);

	/**
	 * 获取没有关联的用户
	 *
	 * @param parameters
	 *            <pre>
	 * Long appId appid
	 * Long systemId 系统ID
	 * </pre>
	 * @return
	 */
	public PageInfo<AppTesterBean> queryUNAppTesterPage(final Map<String, Object> parameters);

	/**
	 * 根据条件查询测试用户信息
	 *
	 * @param appId
	 *            APP ID
	 * @param userIds
	 *            用户ID
	 * @return List<AppTesterBean>
	 */
	@Read
	public List<AppTesterBean> queryAppTesterPage(final Long appId, final List<Long> userIds);

	/**
	 * 添加测试用户
	 *
	 * @param bean
	 * @return
	 */
	@Write
	public int insertAppTester(final List<AppTesterBean> bean);

	/**
	 * 删除测试用户
	 *
	 * @param ids
	 * @return
	 */
	@Write
	public int delAppTester(final List<Long> ids);
}
