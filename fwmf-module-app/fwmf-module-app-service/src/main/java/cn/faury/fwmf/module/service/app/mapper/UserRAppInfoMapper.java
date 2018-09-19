package cn.faury.fwmf.module.service.app.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.app.bean.UserRAppInfoBean;
import cn.faury.fwmf.module.service.app.sqlProvider.UserRAppInfoSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface UserRAppInfoMapper {

	/**
	 * 获取用户授权App信息
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@SelectProvider(method = "getUserRAppInfoList", type = UserRAppInfoSqlProvider.class)
	@ResultType(UserRAppInfoBean.class)
	public List<UserRAppInfoBean> getUserRAppInfoList(final Map<String, Object> parameter);

	/**
	 * 获取用户授权App信息(合并信息)
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@SelectProvider(method = "getUserRAppInfoListWithConcat", type = UserRAppInfoSqlProvider.class)
	@ResultType(UserRAppInfoBean.class)
	public List<UserRAppInfoBean> getUserRAppInfoListWithConcat(final Map<String, Object> parameter);

	/**
	 * 插入用户授权APP对象 仅使用以下字段： 【必填】Long userId：用户ID 【必填】Long appId：APP ID 其他字段都不使用
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@InsertProvider(method = "insertUserRApp", type = UserRAppInfoSqlProvider.class)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public Integer insertUserRApp(final Map<String, Object> parameter);

	/**
	 * 根据用户授权APP对象ID删除用户授权关系
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@DeleteProvider(method = "deleteUserRAppById", type = UserRAppInfoSqlProvider.class)
	public Integer deleteUserRAppById(final Map<String, Object> parameter);

	/**
	 * 
	 * 根据用户ID、多个APP ID删除用户授权APP关系
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@DeleteProvider(method = "deleteUserRAppByUserIds", type = UserRAppInfoSqlProvider.class)
	public Integer deleteUserRAppByUserIds(Map<String, Object> parameter);

	/**
	 * 根据用户ID删除用户所有授权APP关系
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@DeleteProvider(method = "deleteUserRAppByUserId", type = UserRAppInfoSqlProvider.class)
	public Integer deleteUserRAppByUserId(final Map<String, Object> parameter);
}
