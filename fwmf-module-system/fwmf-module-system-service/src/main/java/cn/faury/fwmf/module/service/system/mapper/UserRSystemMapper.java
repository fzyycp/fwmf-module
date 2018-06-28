package cn.faury.fwmf.module.service.system.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.system.bean.UserRSystemInfoBean;
import cn.faury.fwmf.module.service.system.sqlProvider.UserRSystemSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * 用户授权系统Mapper
 */
@AutoScannedMapper
public interface UserRSystemMapper {

	/**
	 * 获取用户授权业务系统信息（多个业务系统信息合并）
	 */
	@SelectProvider(method = "getUserRSystemInfoListWithConcat", type = UserRSystemSqlProvider.class)
	@ResultType(UserRSystemInfoBean.class)
	public List<UserRSystemInfoBean> getUserRSystemInfoListWithConcat(final Map<String, Object> parameter);

	/**
	 * 获取用户授权业务系统信息
	 */
	@SelectProvider(method = "getUserRSystemInfoList", type = UserRSystemSqlProvider.class)
	@ResultType(UserRSystemInfoBean.class)
	public List<UserRSystemInfoBean> getUserRSystemInfoList(final Map<String, Object> parameter);

	/**
	 * 判断授权系统是否已经设置代理人
	 */
	@SelectProvider(method = "getSystemInAgentUse", type = UserRSystemSqlProvider.class)
	@ResultType(UserRSystemInfoBean.class)
	public List<UserRSystemInfoBean> getSystemInAgentUse(final Map<String, Object> parameter);

	/**
	 * 判断用户、授权系统是否已经关联角色
	 */
	@SelectProvider(method = "getSystemRRole", type = UserRSystemSqlProvider.class)
	@ResultType(UserRSystemInfoBean.class)
	public List<UserRSystemInfoBean> getSystemRRole(final Map<String, Object> parameter);

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
	 * @return 成功插入条数
	 */
	@SelectProvider(type = UserRSystemSqlProvider.class, method = "insertUserRSystem")
	public Integer insertUserRSystem(final Map<String, Object> parameter);

	/**
	 * <pre>
	 * 1.根据用户授权业务系统对象ID删除用户授权关系
	 * 2. 根据用户ID删除用户所有授权业务系统关系
	 * 3.根据用户ID、多个业务系统ID删除用户授权业务系统关系
	 * </pre>
	 * 
	 * @param parameter
	 * @return 成功删除条数
	 */
	@SelectProvider(type = UserRSystemSqlProvider.class, method = "deleteUserRSystemById")
	public Integer deleteUserRSystemById(Map<String, Object> parameter);
}
