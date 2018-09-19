package cn.faury.fwmf.module.api.app.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.app.bean.AppTesterBean;

import java.util.List;
import java.util.Map;

/**
 * 服务接口：APP测试用户信息表
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface AppTesterService extends CrudBaseService<AppTesterBean, Long> {

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
