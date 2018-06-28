package cn.faury.fwmf.module.service.systemconfig.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.systemconfig.bean.SystemConfigInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfSystemConfig;
import cn.faury.fwmf.module.service.systemconfig.sqlProvider.SystemConfigInfoSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 系统参数配置表Mapper
 */
@AutoScannedMapper
public interface SystemConfigMapper {

	@SelectProvider(method = "getSystemConfigInfoList", type = SystemConfigInfoSqlProvider.class)
	@ResultType(SystemConfigInfoBean.class)
	public List<SystemConfigInfoBean> getSystemConfigInfoList(final Map<String, Object> parameter);

	@SelectProvider(method = "getGlobalSystemConfigInfoList", type = SystemConfigInfoSqlProvider.class)
	@ResultType(SystemConfigInfoBean.class)
	public List<SystemConfigInfoBean> getGlobalSystemConfigInfoList(final Map<String, Object> parameters);

	/**
	 * 根据系统参数配置ID获取系统参数配置信息
	 */
	@SelectProvider(method = "querySystemConfigInfo", type = SystemConfigInfoSqlProvider.class)
	@ResultType(SystemConfigInfoBean.class)
	public SystemConfigInfoBean getSystemConfigInfoById(final Map<String, Object> parameter);

	/**
	 * 根据系统参数配置key获取全局系统参数配置信息
	 */
	@SelectProvider(method = "getGlobalSystemConfigInfoByKey", type = SystemConfigInfoSqlProvider.class)
	@ResultType(SystemConfigInfoBean.class)
	public SystemConfigInfoBean getGlobalSystemConfigInfoByKey(final Map<String, Object> parameter);

	/**
	 * 根据所属系统ID获取系统参数配置信息列表
	 */
	@Select("SELECT c.SYSTEM_CONFIG_ID as systemConfigId,SYSTEM_CONFIG_KEY as systemConfigKey,"
	        + "SYSTEM_CONFIG_VALUE as systemConfigValue,"
	        + "SYSTEM_CONFIG_SYSTEM as systemConfigSystemId,"
	        + "SYSTEM_CONFIG_TIME as systemConfigTime,c.IS_AVAILABLE as isAvailable ,s.SYSTEM_NAME  as systemName, "
	        + "SYSTEM_CONFIG_DESC as systemConfigDesc"
	        + " FROM "
	        + DBConstOfSystemConfig.TN_SYSTEM_CONFIG
	        + " c "
	        + "INNER JOIN "
	        + DBConstOfSystemConfig.TN_SYSTEM_INFO
	        + " s "
	        + "ON s.SYSTEM_ID = c.SYSTEM_CONFIG_SYSTEM where 1=1 AND (	SYSTEM_CONFIG_SYSTEM = #{systemConfigSystemId} OR SYSTEM_CONFIG_SYSTEM IS NULL )")
	@ResultType(SystemConfigInfoBean.class)
	public List<SystemConfigInfoBean> getSystemConfigInfoBySystemId(final Map<String, Object> parameter);

	/**
	 * 根据系统参数KEY获取系统参数配置信息
	 */
	@SelectProvider(method = "querySystemConfigInfo", type = SystemConfigInfoSqlProvider.class)
	@ResultType(SystemConfigInfoBean.class)
	public SystemConfigInfoBean getSystemConfigInfoByKey(final Map<String, Object> parameter);

	/**
	 * 根据输入条件查询系统参数配置信息列表
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【可选】Long   systemConfigId 		系统参数配置ID
	 * 【可选】String systemConfigKey 	系统参数配置KEY
	 * 【可选】String systemConfigValue 	系统参数配置VALUE
	 * 【可选】String isAvailable 		是否可用
	 * </pre>
	 * 
	 * @param parameter
	 *            参数列表
	 * @return 查询结果
	 * @author xg.qiu
	 */
	@SelectProvider(method = "querySystemConfigInfo", type = SystemConfigInfoSqlProvider.class)
	@ResultType(SystemConfigInfoBean.class)
	public List<SystemConfigInfoBean> querySystemConfigInfo(final Map<String, Object> parameter);

	/**
	 * 根据输入条件查询check系统参数配置信息列表
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【可选】Long   systemConfigId 		系统参数配置ID
	 * 【可选】String systemConfigKey 	系统参数配置KEY
	 * 【可选】String systemConfigValue 	系统参数配置VALUE
	 * 【可选】String isAvailable 		是否可用
	 * </pre>
	 * 
	 * @param parameter
	 *            参数列表
	 * @return 查询结果
	 * @author xg.qiu
	 */
	@SelectProvider(method = "checkSystemConfigInfo", type = SystemConfigInfoSqlProvider.class)
	@ResultType(SystemConfigInfoBean.class)
	public List<SystemConfigInfoBean> checkSystemConfigInfo(final Map<String, Object> parameter);

	/**
	 * 获取所有系统参数配置信息列表
	 * 
	 * @return 所有系统参数配置列表信息
	 */
	@SelectProvider(method = "querySystemConfigInfo", type = SystemConfigInfoSqlProvider.class)
	@ResultType(SystemConfigInfoBean.class)
	public List<SystemConfigInfoBean> getAllSystemConfigInfo();

	/**
	 * 新增系统参数配置信息
	 * 
	 * @param instance
	 *            系统参数配置对象
	 * @return 保存成功后返回系统参数配置对象ID，失败则返回-1
	 * @author xg.qiu
	 */
	@Insert("INSERT INTO "
	        + DBConstOfSystemConfig.TN_SYSTEM_CONFIG
	        + "(SYSTEM_CONFIG_KEY,SYSTEM_CONFIG_VALUE,SYSTEM_CONFIG_SYSTEM,SYSTEM_CONFIG_TIME,IS_AVAILABLE,SYSTEM_CONFIG_DESC)"
	        + "VALUES(#{systemConfigKey},#{systemConfigValue},#{systemConfigSystemId},#{systemConfigTime},#{isAvailable},#{systemConfigDesc})")
	@Options(keyProperty = "systemConfigId", useGeneratedKeys = true)
	public Long insertSystemConfigInfo(final SystemConfigInfoBean instance);

	/**
	 * 根据系统参数配置ID删除系统参数配置信息
	 * 
	 * <pre>
	 * 	此方法只支持物理删除,如需逻辑删除@see {@link #updateSystemConfigInfoByKey(Long, String, String, String)}
	 * </pre>
	 * 
	 * @param systemConfigIds
	 *            系统参数配置ID
	 * @return 是否删除成功
	 */
	@DeleteProvider(type = SystemConfigInfoSqlProvider.class, method = "deleteSystemConfigInfoByIds")
	public Boolean deleteCodeInfoByCodeIds(final Long systemConfigIds);

	/**
	 * 根据【systemConfigId】<br />
	 * 修改【systemConfigKey、systemConfigValue、isAvailable】 系统参数配置信息
	 * 
	 * @param systemConfigId
	 *            系统参数配置ID
	 * @param systemConfigKey
	 *            系统参数配置KEY
	 * @param systemConfigValue
	 *            系统参数配置VALUE
	 * @param isAvailable
	 *            是否可用
	 * @return 是否修改成功
	 */
	@UpdateProvider(type = SystemConfigInfoSqlProvider.class, method = "updateSystemConfigIdById")
	public Boolean updateSystemConfigInfoById(final Long systemConfigId, final String systemConfigKey,
                                              final String systemConfigValue, final String isAvailable);

	/**
	 * 根据【systemConfigSystemId、systemConfigKey】<br />
	 * 修改【systemConfigValue、isAvailable】 系统参数配置信息
	 *
	 * @param systemConfigSystemId
	 *            所属系统ID
	 * @param systemConfigKey
	 *            系统参数配置KEY
	 * @param systemConfigValue
	 *            系统参数配置VALUE
	 * @param isAvailable
	 *            是否可用
	 * @return 是否修改成功
	 */
	@UpdateProvider(type = SystemConfigInfoSqlProvider.class, method = "updateSystemConfigInfoByKey")
	public Boolean updateSystemConfigInfoByKey(final Long systemConfigSystemId, final String systemConfigKey,
                                               final String systemConfigValue, final String isAvailable);

}
