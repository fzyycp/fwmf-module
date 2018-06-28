package cn.faury.fwmf.module.api.user.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fwmf.module.api.user.bean.UserListBean;

import java.util.Map;

/**
 * 系统用户服务
 */
public interface SystemRUserService {

	/**
	 * 通过条件查询系统用户信息
	 * 
	 * 
	 * @param pageParam
	 *            分页参数
	 * @param parameters
	 *            查询条件
	 * 
	 *            <pre>
	 * 【可选】String systemCode 来源系统Code
	 * 【可选】String loginName 用户登录名
	 * 【可选】List<String> userTypeList 用户类型(cn.wassk.platform.service.user.config.UserType)
	 * 【可选】String startTime （注册时间）开始时间
	 * 【可选】String endTime （注册时间）结束时间
	 * </pre>
	 * @return 商店用户信息
	 */
	@Read
	public PageInfo<UserListBean> getUserInfoList(final PageParam pageParam, final Map<String, Object> parameters);
}
