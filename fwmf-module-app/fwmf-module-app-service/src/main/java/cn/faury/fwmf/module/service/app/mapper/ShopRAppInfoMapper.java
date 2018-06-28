package cn.faury.fwmf.module.service.app.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.app.bean.ShopRAppInfoBean;
import cn.faury.fwmf.module.service.app.sqlProvider.ShopRAppInfoSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface ShopRAppInfoMapper {

	/**
	 * 获取商店授权App信息
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@SelectProvider(method = "getShopRAppInfoList", type = ShopRAppInfoSqlProvider.class)
	@ResultType(ShopRAppInfoBean.class)
	public List<ShopRAppInfoBean> getShopRAppInfoList(final Map<String, Object> parameter);

	/**
	 * 获取商店授权App信息 需合并
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@SelectProvider(method = "getShopRAppInfoListWithConcat", type = ShopRAppInfoSqlProvider.class)
	@ResultType(ShopRAppInfoBean.class)
	public List<ShopRAppInfoBean> getShopRAppInfoListWithConcat(final Map<String, Object> parameter);

	/**
	 * 获取商店授权App信息
	 * 
	 * <pre>
	 * 支持的参数：
	 * 【必填】Long userId：用户ID
	 * 【可选】Boolean isSystemAvailable：业务系统是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
	 * </pre>
	 * 
	 * @param parameter
	 *            输入参数
	 * @return 授权APP列表
	 */
	@SelectProvider(method = "getShopRAppInfoListByUserId", type = ShopRAppInfoSqlProvider.class)
	@ResultType(ShopRAppInfoBean.class)
	public List<ShopRAppInfoBean> getShopRAppInfoListByUserId(final Map<String, Object> parameter);

	/**
	 * 新增授权信息
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@InsertProvider(method = "insertShopRApp", type = ShopRAppInfoSqlProvider.class)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public Integer insertShopRApp(final Map<String, Object> parameter);

	/**
	 * 删除授权信息
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@DeleteProvider(method = "deleteShopRAppById", type = ShopRAppInfoSqlProvider.class)
	public Integer deleteShopRAppById(final Map<String, Object> parameter);

	/**
	 * 根据商店ID、多个APP ID删除商店授权APP关系
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@DeleteProvider(method = "deleteShopRAppByShopIds", type = ShopRAppInfoSqlProvider.class)
	public Integer deleteShopRAppByShopIds(final Map<String, Object> parameter);

	/**
	 * 根据商店ID、多个APP ID删除商店授权APP关系
	 *
	 * @param parameter 查询参数
	 * @return 结果
	 */
	@DeleteProvider(method = "deleteShopRAppByShopId", type = ShopRAppInfoSqlProvider.class)
	public Integer deleteShopRAppByShopId(final Map<String, Object> parameter);
}
