package cn.faury.fwmf.module.service.shop.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.shop.bean.ShopInfoBean;
import cn.faury.fwmf.module.service.shop.sqlProvider.ShopInfoSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface ShopInfoMapper {

	/**
	 * 通过条件查询商店信息
	 */
	@SelectProvider(type = ShopInfoSqlProvider.class, method = "queryShopInfo")
	@ResultType(ShopInfoBean.class)
	public List<ShopInfoBean> queryShopInfo(Map<String, Object> parameter);

	/**
	 * 通过商店ID查询商店信息
	 */
	@SelectProvider(type = ShopInfoSqlProvider.class, method = "getShopInfoById")
	@ResultType(ShopInfoBean.class)
	public ShopInfoBean getShopInfoById(Long shopId);

	/**
	 * 获取商店信息(验证是否存在)
	 */
	@SelectProvider(type = ShopInfoSqlProvider.class, method = "getShopInfoByName")
	public Integer getShopInfoByName(Map<String, Object> parameter);

	/**
	 * 插入保存商店信息
	 */
	@InsertProvider(type = ShopInfoSqlProvider.class, method = "insertShopInfo")
	@Options(keyProperty = "shopId", useGeneratedKeys = true, keyColumn = "SHOP_ID")
	public Integer insertShopInfo(ShopInfoBean bean);

	/**
	 * 更新商店信息
	 */
	@UpdateProvider(type = ShopInfoSqlProvider.class, method = "updateShopInfo")
	public Integer updateShopInfo(Map<String, Object> parameter);

	/**
	 * 删除商店信息（逻辑删除）
	 */
	@UpdateProvider(type = ShopInfoSqlProvider.class, method = "deleteShopInfo")
	public Integer deleteShopInfo(Map<String, Object> parameter);

	/**
	 * 更新商店状态（启用、禁用）
	 */
	@UpdateProvider(type = ShopInfoSqlProvider.class, method = "updateShopState")
	public Integer updateShopState(Map<String, Object> parameter);

	/**
	 * 查询商店授权系统数量
	 */
	@SelectProvider(type = ShopInfoSqlProvider.class, method = "getShopRSystemCounts")
	public int getShopRSystemCounts(Map<String, Object> parameter);

	/**
	 * 查询商店授权App数量
	 */
	@SelectProvider(type = ShopInfoSqlProvider.class, method = "getShopRAppCounts")
	public int getShopRAppCounts(Map<String, Object> parameter);

	/**
	 * 查询商店自建用户数量
	 */
	@SelectProvider(type = ShopInfoSqlProvider.class, method = "getShopRUserSelfCreateCounts")
	public int getShopRUserSelfCreateCounts(Map<String, Object> parameter);

	/**
	 * 获取未授权系统
	 */
	@SelectProvider(type = ShopInfoSqlProvider.class, method = "getShopInfoUnRSystem")
	@ResultType(ShopInfoBean.class)
	public List<ShopInfoBean> getShopInfoUnRSystem();

}
