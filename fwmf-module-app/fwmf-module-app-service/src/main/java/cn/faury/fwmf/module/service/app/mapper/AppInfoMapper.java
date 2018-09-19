package cn.faury.fwmf.module.service.app.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.app.bean.AppInfoBean;
import cn.faury.fwmf.module.service.app.generate.mapper.AppInfoGenerateMapper;
import cn.faury.fwmf.module.service.app.sqlProvider.AppInfoSqlProvider;
import cn.faury.fwmf.module.service.constant.DBConstOfApp;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：APP信息
 *
 * <pre>
 *     AppInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自AppInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface AppInfoMapper  extends AppInfoGenerateMapper {

	/**
	 * check APPCode信息
	 *
	 * @param parameter 查询参数
	 * @return 查询结果
	 */
	@SelectProvider(method = "checkAppCode", type = AppInfoSqlProvider.class)
	@ResultType(AppInfoBean.class)
	public List<AppInfoBean> checkAppCode(final Map<String, Object> parameter);

	/**
	 * check APPName信息
	 *
	 * @param parameter 查询参数
	 * @return 查询结果
	 */

	@SelectProvider(method = "checkAppName", type = AppInfoSqlProvider.class)
	@ResultType(AppInfoBean.class)
	public List<AppInfoBean> checkAppName(final Map<String, Object> parameter);

	/**
	 * 不分页查询手机APP注册信息
	 *
	 * @param parameter 查询参数
	 * @return 查询结果
	 */
	@SelectProvider(method = "queryAppInfo", type = AppInfoSqlProvider.class)
	@ResultType(AppInfoBean.class)
	public List<AppInfoBean> queryAppInfo(final Map<String, Object> parameter);

	/**
	 * 分页查询手机APP注册信息
	 *
	 * @param parameter 查询参数
	 * @return 查询结果
	 */
	@SelectProvider(method = "queryAppInfoByPager", type = AppInfoSqlProvider.class)
	@ResultType(AppInfoBean.class)
	public List<AppInfoBean> queryAppInfoByPager(final Map<String, Object> parameter);

	/**
	 * 根据系统Id、appId、系统是否可用以及app是否可用获取app注册信息列表
	 * 
	 * @param parameter 查询参数
	 * @return 查询结果
	 */
	@SelectProvider(method = "getAppInfoList", type = AppInfoSqlProvider.class)
	@ResultType(AppInfoBean.class)
	public List<AppInfoBean> getAppInfoList(final Map<String, Object> parameter);

	/**
	 * 根据推送id 获取app
	 * 
	 * @param messageId 推送ID
	 * @return Aapp列表
	 */
	@Select("SELECT	app.APP_ID AS appId,APP_CODE AS appCode,APP_NAME AS appName,APP_OS AS appOS,REJECT_GUEST_USER rejectGuestUser ,"
	        + "REJECT_SHOPPING_USER rejectShoppingUser,ALLOW_BACKGROUND_USER allowBackgroundUser FROM  "
	        + DBConstOfApp.TN_APP_INFO
	        + " APP JOIN "
	        + DBConstOfApp.TN_PUSH_R_APP
	        + " PRA ON PRA.APP_ID = APP.APP_ID where PRA.MESSAGE_ID = #{messageId}")
	@ResultType(AppInfoBean.class)
	public List<AppInfoBean> getAppInfoByMIdNotContact(final Long messageId);

	/**
	 * 根据推送id 获取app
	 * 
	 * @param messageId 推送ID
	 * @return Aapp列表
	 */
	@Select("SELECT	GROUP_CONCAT(app.APP_ID) AS contactAppIds,GROUP_CONCAT(APP.APP_NAME) AS contactAppNames FROM  "
	        + DBConstOfApp.TN_APP_INFO + " APP JOIN " + DBConstOfApp.TN_PUSH_R_APP
	        + " PRA ON PRA.APP_ID = APP.APP_ID where PRA.MESSAGE_ID = #{messageId} GROUP BY PRA.MESSAGE_ID")
	@ResultType(AppInfoBean.class)
	public List<AppInfoBean> getAppInfoByMIdIsWithContact(final Long messageId);

	/**
	 * 新增手机APP注册信息
	 * 
	 * @param app APP信息
	 * @return 结果
	 */
	@Insert("INSERT INTO "
	        + DBConstOfApp.TN_APP_INFO
	        + "(APP_CODE,APP_NAME,APP_OS,SYSTEM_ID,IS_AVAILABLE,REJECT_GUEST_USER,REJECT_SHOPPING_USER,ALLOW_BACKGROUND_USER,TRACK_ID,SERVER_DOMAIN)"
	        + "VALUES(#{appCode},#{appName},#{appOS},#{systemId},#{isAvailable},#{rejectGuestUser},#{rejectShoppingUser},#{allowBackgroundUser},#{trackId},#{serverDomain})")
	@Options(useGeneratedKeys = true, keyProperty = "appId")
	public Long insertAppInfo(final AppInfoBean app);

	/**
	 * 根据appCodes删除手机APP注册信息
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@DeleteProvider(method = "deleteAppInfoByAppCodes", type = AppInfoSqlProvider.class)
	public Long deleteAppInfoByAppCodes(final Map<String, Object> parameter);

	/**
	 * 根据appIds删除手机APP注册信息
	 * 
	 * @param parameters 查询参数
	 * @return 结果
	 */
	@DeleteProvider(method = "deleteAppInfoByAppIds", type = AppInfoSqlProvider.class)
	public Long deleteAppInfoByAppIds(final Map<String, Object> parameters);

	/**
	 * 修改手机APP注册信息
	 * 
	 * @param app APP信息
	 * @return 更新结果
	 */
	@UpdateProvider(method = "updateAppInfo", type = AppInfoSqlProvider.class)
	public Long updateAppInfo(final AppInfoBean app);

	@Select("select APP_ID AS appId,APP_CODE AS appCode,APP_NAME AS appName,APP_OS AS appOS,SYSTEM_ID AS systemId,"
	        + "REJECT_GUEST_USER rejectGuestUser ,REJECT_SHOPPING_USER rejectShoppingUser,"
	        + "ALLOW_BACKGROUND_USER allowBackgroundUser,TRACK_ID trackId,SERVER_DOMAIN serverDomain FROM " + DBConstOfApp.TN_APP_INFO
	        + " where APP_CODE = #{appCode} AND IS_AVAILABLE = 'Y' ")
	public AppInfoBean getAppCountByAppCode();
}
