package cn.faury.fwmf.module.service.system.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.system.bean.SystemInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfSystem;
import cn.faury.fwmf.module.service.system.sqlProvider.SystemInfoSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 业务系统信息表Mapper
 */
@AutoScannedMapper
public interface SystemInfoMapper {

	/**
	 * 根据业务系统CODE获取业务系统信息
	 * 
	 * <pre>
	 * 可能的参数：
	 * 【必填】String systemCode：业务系统编码
	 * 【可选】Boolean isAvailable：是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @param parameter
	 *            查询参数
	 * 
	 * @return 业务系统信息对象
	 */
	@SelectProvider(method = "getSystemInfoByCode", type = SystemInfoSqlProvider.class)
	@ResultType(SystemInfoBean.class)
	public SystemInfoBean getSystemInfoByCode(final Map<String, Object> parameter);

	/**
	 * 根据业务系统名称获取业务系统信息
	 * 
	 * <pre>
	 * 可能的参数：
	 * 【必填】String systemName：业务系统名称
	 * 【可选】Boolean isAvailable：是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * </pre>
	 * 
	 * @param parameter
	 *            查询参数
	 * 
	 * @return 业务系统信息对象
	 */
	@SelectProvider(method = "getSystemInfoByName", type = SystemInfoSqlProvider.class)
	@ResultType(SystemInfoBean.class)
	public int getSystemInfoByName(final Map<String, Object> parameter);

	/**
	 * 查询业务系统信息
	 * 
	 * @param parameter
	 *            查询参数
	 * @return 查询结果
	 */
	@SelectProvider(method = "querySystemInfo", type = SystemInfoSqlProvider.class)
	@Results({ @Result(property = "systemId", column = "SYSTEM_ID", javaType = Long.class),
	        @Result(property = "systemName", column = "SYSTEM_NAME"),
			@Result(property = "systemCode", column = "SYSTEM_CODE"),
	        @Result(property = "isAvailable", column = "IS_AVAILABLE") })
	public List<SystemInfoBean> querySystemInfo(final Map<String, Object> parameter);

	/**
	 * 插入业务系统信息
	 * 
	 * <pre>
	 * 接收的参数：
	 * 【必填】systemName：业务系统名称
	 * 【必填】systemCode：业务系统编码
	 * 【必填】isAvailable：时可用
	 * </pre>
	 * 
	 * @param systemInfo
	 *            业务系统对象
	 * @return 成功插入后的业务系统ID，失败则返回-1
	 */
	@Insert("INSERT INTO " + DBConstOfSystem.TN_SYSTEM_INFO
	        + " (`SYSTEM_NAME`, `SYSTEM_CODE`, `IS_AVAILABLE`) VALUES (#{systemName}, #{systemCode}, #{isAvailable})")
	@Options(keyProperty = "systemId", useGeneratedKeys = true)
	public Integer insertSystemInfo(final SystemInfoBean systemInfo);

	/**
	 * 根据系统ID更新系统信息
	 * 
	 * @param systemName
	 *            业务系统信息
	 * @param systemCode
	 *            业务系统编码
	 * @param isAvailable
	 *            是否可用
	 * @param systemId
	 *            业务系统ID
	 * @return 更新条数
	 */
	@UpdateProvider(type = SystemInfoSqlProvider.class,method = "updateSystemInfoById")
	public Integer updateSystemInfoById(String systemName, String systemCode, String isAvailable, Long systemId);

	/**
	 * 根据系统Code更新系统信息
	 * 
	 * @param systemName
	 *            业务系统信息
	 * @param isAvailable
	 *            是否可用
	 * @param systemCode
	 *            业务系统编码
	 * @return 更新条数
	 */
	@Update("UPDATE " + DBConstOfSystem.TN_SYSTEM_INFO + " SET `SYSTEM_NAME`=#{systemName}, `IS_AVAILABLE`=#{isAvailable} "
	        + " WHERE `SYSTEM_CODE`=#{systemCode}")
	public Integer updateSystemInfoByCode(String systemName, String isAvailable, String systemCode);

	/**
	 * 根据业务系统ID删除业务系统信息(逻辑删除设置为不可用)
	 * 
	 * @param systemId
	 *            业务系统ID
	 * @return 删除条数
	 */
	@Update("UPDATE " + DBConstOfSystem.TN_SYSTEM_INFO + " SET `IS_AVAILABLE`='N' "
	        + " WHERE `SYSTEM_ID`=#{systemId,jdbcType=BIGINT}")
	public Integer deleteSystemInfoById(Long systemId);

	/**
	 * 根据业务系统Code删除业务系统信息(逻辑删除设置为不可用)
	 * 
	 * @param systemCode
	 *            业务系统Code
	 * @return 删除条数
	 */
	@Update("UPDATE " + DBConstOfSystem.TN_SYSTEM_INFO + " SET `IS_AVAILABLE`='N' "
	        + " WHERE `SYSTEM_CODE`=#{systemCode,jdbcType=BIGINT}")
	public Integer deleteSystemInfoByCode(String systemCode);
}
