package cn.faury.fwmf.module.service.appversion.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.bean.AppVersionBean;
import cn.faury.fwmf.module.service.appversion.sqlProvider.AppVersionSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface AppVersionMapper {

	/**
	 * 查询版本列表
	 * 
	 * @param parameters
	 * @return
	 */
	@SelectProvider(type = AppVersionSQLProvider.class, method = "queryAppVersionList")
	@ResultType(AppVersionBean.class)
	public List<AppVersionBean> queryAppVersionList(Map<String, Object> parameters);

	/**
	 * 查询版本信息
	 * 
	 * @return
	 */
	@SelectProvider(type = AppVersionSQLProvider.class, method = "getAppVersion")
	@ResultType(AppVersionBean.class)
	public AppVersionBean getAppVersion(Map<String, Object> param);

	/**
	 * 插入版本
	 * 
	 * @param bean
	 * @return
	 */
	@InsertProvider(method = "insertAppVersion", type = AppVersionSQLProvider.class)
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public Long insertAppVersion(AppVersionBean bean);

	/**
	 * 更新版本
	 * 
	 * @param param
	 * @return
	 */
	@UpdateProvider(method = "updateAppVersion", type = AppVersionSQLProvider.class)
	public int updateAppVersion(Map<String, Object> param);

	/**
	 * 删除版本
	 * 
	 * @param param
	 * @return
	 */
	@DeleteProvider(method = "delAppVersion", type = AppVersionSQLProvider.class)
	public int delAppVersion(Map<String, Object> param);

	/**
	 * 删除版本
	 * 
	 * @param param
	 * @return
	 */
	@DeleteProvider(method = "DeleteAppVersion", type = AppVersionSQLProvider.class)
	public int DeleteAppVersion(Map<String, Object> param);

	/**
	 * 获取最大版本号
	 * 
	 * @param param
	 * @return
	 */
	@SelectProvider(type = AppVersionSQLProvider.class, method = "getVersionNums")
	public String getVersionNums(Map<String, Object> param);

	/**
	 * 
	 * @param param
	 * @return
	 */
	public AppVersionBean getMaxAppVersion(Map<String, Object> param);
}
