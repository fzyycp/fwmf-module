package cn.faury.fwmf.module.service.app.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.app.bean.AppVersionBean;
import cn.faury.fwmf.module.service.app.generate.mapper.AppVersionGenerateMapper;
import cn.faury.fwmf.module.service.app.sqlProvider.AppVersionSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：APP版本信息表
 *
 * <pre>
 *     AppVersionGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自AppVersionGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface AppVersionMapper extends AppVersionGenerateMapper {

	/**
	 * 查询版本列表
	 * 
	 * @param parameters
	 * @return
	 */
	@SelectProvider(type = AppVersionSqlProvider.class, method = "queryAppVersionList")
	@ResultType(AppVersionBean.class)
	public List<AppVersionBean> queryAppVersionList(Map<String, Object> parameters);

	/**
	 * 查询版本信息
	 * 
	 * @return
	 */
	@SelectProvider(type = AppVersionSqlProvider.class, method = "getAppVersion")
	@ResultType(AppVersionBean.class)
	public AppVersionBean getAppVersion(Map<String, Object> param);

	/**
	 * 插入版本
	 * 
	 * @param bean
	 * @return
	 */
	@InsertProvider(method = "insertAppVersion", type = AppVersionSqlProvider.class)
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public Long insertAppVersion(AppVersionBean bean);

	/**
	 * 更新版本
	 * 
	 * @param param
	 * @return
	 */
	@UpdateProvider(method = "updateAppVersion", type = AppVersionSqlProvider.class)
	public int updateAppVersion(Map<String, Object> param);

	/**
	 * 删除版本
	 * 
	 * @param param
	 * @return
	 */
	@DeleteProvider(method = "delAppVersion", type = AppVersionSqlProvider.class)
	public int delAppVersion(Map<String, Object> param);

	/**
	 * 删除版本
	 * 
	 * @param param
	 * @return
	 */
	@DeleteProvider(method = "DeleteAppVersion", type = AppVersionSqlProvider.class)
	public int DeleteAppVersion(Map<String, Object> param);

	/**
	 * 获取最大版本号
	 * 
	 * @param param
	 * @return
	 */
	@SelectProvider(type = AppVersionSqlProvider.class, method = "getVersionNums")
	public String getVersionNums(Map<String, Object> param);

	/**
	 * 
	 * @param param
	 * @return
	 */
	public AppVersionBean getMaxAppVersion(Map<String, Object> param);
}
