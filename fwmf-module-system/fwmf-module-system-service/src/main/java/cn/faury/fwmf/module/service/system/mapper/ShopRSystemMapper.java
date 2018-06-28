package cn.faury.fwmf.module.service.system.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.system.bean.ShopRSystemInfoBean;
import cn.faury.fwmf.module.service.system.sqlProvider.ShopRSystemSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * 
 * 商店授权系统Mapper
 */
@AutoScannedMapper
public interface ShopRSystemMapper {

	/**
	 * 获取商店授权业务系统信息（多个业务系统信息合并）
	 */
	@SelectProvider(method = "getShopRSystemInfoListWithConcat", type = ShopRSystemSqlProvider.class)
	@ResultType(ShopRSystemInfoBean.class)
	public List<ShopRSystemInfoBean> getShopRSystemInfoListWithConcat(final Map<String, Object> parameter);

	/**
	 * 获取商店授权业务系统信息
	 */
	@SelectProvider(method = "getShopRSystemInfoList", type = ShopRSystemSqlProvider.class)
	@ResultType(ShopRSystemInfoBean.class)
	public List<ShopRSystemInfoBean> getShopRSystemInfoList(final Map<String, Object> parameter);

	/**
	 * 获取商店授权业务系统信息
	 * 
	 * <pre>
	 * 支持的参数：
	 * 【必填】Long userId：用户ID
	 * 【可选】Boolean isSystemAvailable：业务系统是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
	 * </pre>
	 * 
	 * @param parameter
	 *            输入参数
	 * @return 授权的业务系统列表
	 * 
	 */
	@SelectProvider(method = "getShopRSystemInfoListByUserId", type = ShopRSystemSqlProvider.class)
	@ResultType(ShopRSystemInfoBean.class)
	public List<ShopRSystemInfoBean> getShopRSystemInfoListByUserId(final Map<String, Object> parameter);

	/**
	 * 插入商店授权业务系统对象
	 * 
	 * <pre>
	 * 仅使用以下字段：
	 * 【必填】Long shopId：商店ID
	 * 【必填】Long systemId：业务系统ID
	 * 其他字段都不使用
	 * </pre>
	 * 
	 * @return 成功插入条数
	 */
	@SelectProvider(type = ShopRSystemSqlProvider.class, method = "insertShopRSystem")
	public Integer insertShopRSystem(final Map<String, Object> parameter);

	/**
	 * <pre>
	 * 1.根据商店授权业务系统对象ID删除商店授权关系
	 * 
	 * 2. 根据商店ID删除商店所有授权业务系统关系
	 * 
	 * 3.根据商店ID、多个业务系统ID删除商店授权业务系统关系
	 * 
	 * </pre>
	 * 
	 * @param parameter
	 * @return 成功删除条数
	 */
	@SelectProvider(type = ShopRSystemSqlProvider.class, method = "deleteShopRSystemById")
	public Integer deleteShopRSystemById(Map<String, Object> parameter);
}
