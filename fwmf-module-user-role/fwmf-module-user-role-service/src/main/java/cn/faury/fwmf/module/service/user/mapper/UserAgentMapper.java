package cn.faury.fwmf.module.service.user.mapper;


import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.UserAgentInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import cn.faury.fwmf.module.service.user.sqlProvider.UserAgentSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface UserAgentMapper {

	/**
	 * 查询代理人信息列表
	 * 
	 * <pre>
	 * 查询规则：如果对象为null或者字符串为''，则不使用该条件查询
	 * 参数说明：
	 * 【可选】id：唯一主键
	 * 【可选】userId：被代理人ID
	 * 【可选】agentUserId：代理人ID
	 * 【可选】osId：业务系统ID或者APP ID
	 * 【可选】osType：系统类型【0:业务系统，1:手机APP】
	 * 【可选】isAvailable：是否可用【Y:是 N：否】
	 * </pre>
	 * 
	 * @return 查询结果列表
	 */
	@SelectProvider(type = UserAgentSQLProvider.class, method = "queryUserAgentInfo")
	@ResultType(UserAgentInfoBean.class)
	public List<UserAgentInfoBean> queryUserAgentInfo(Map<String, Object> parameter);

	/**
	 * 查询未代理当前用户的授权系统的当前系统用户
	 */
	@SelectProvider(type = UserAgentSQLProvider.class, method = "queryUserUnAgentInfo")
	@ResultType(UserAgentInfoBean.class)
	public List<UserAgentInfoBean> queryUserUnAgentInfo(Map<String, Object> parameter);

	/**
	 * 根据用户代理人关系表唯一主键ID查询代理人信息对象
	 */
	@SelectProvider(type = UserAgentSQLProvider.class, method = "getUserAgentInfoById")
	@ResultType(UserAgentInfoBean.class)
	public UserAgentInfoBean getUserAgentInfoById(final Long id);

	/**
	 * 插入用户代理人信息
	 */
	@Insert("INSERT INTO " + DBConstOfUserRole.TN_USER_AGENT
	        + " (`USER_ID`, `AGENT_USER_ID`, `OS_ID`, `OS_TYPE`, `IS_AVAILABLE`) VALUES "
	        + "(#{userId}, #{agentUserId}, #{osId}, #{osType}, #{isAvailable})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public Integer insertUserAgentInfo(final UserAgentInfoBean userAgentInfo);

	@Update("UPDATE " + DBConstOfUserRole.TN_USER_AGENT + "  SET IS_AVAILABLE = #{isAvailable} WHERE ID = #{id}  ")
	public Integer updateUserAgentInfo(final UserAgentInfoBean userAgentInfo);

	/**
	 * 根据用户代理人关系表唯一主键ID删除代理人信息对象
	 */
	@SelectProvider(type = UserAgentSQLProvider.class, method = "deleteUserAgentInfoById")
	public Integer deleteUserAgentInfoById(Map<String, Object> parameter);

	/**
	 * <PRE>
	 *  1.根据被代理人ID删除所有代理人关系
	 * 2.根据被代理人ID、代理人ID删除代理人关系
	 */
	@SelectProvider(type = UserAgentSQLProvider.class, method = "deleteUserAgentInfoById")
	public Integer deleteUserAgentInfoByUserId(Map<String, Object> parameter);

}
