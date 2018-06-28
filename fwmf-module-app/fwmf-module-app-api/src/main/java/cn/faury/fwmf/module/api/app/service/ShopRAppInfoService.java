package cn.faury.fwmf.module.api.app.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.app.bean.ShopRAppInfoBean;

import java.util.List;


/**
 * 商店授权APP服务
 */
public interface ShopRAppInfoService {

	/**
	 * 获取商店授权App信息
	 * 
	 * @param shopIds
	 *            多个商店ID
	 * @param isAppAvailable
	 *            APP是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
	 * @return 授权的App列表
	 * 
	 */
	@Read
	public List<ShopRAppInfoBean> getShopRAppInfoList(final List<Long> shopIds, final Boolean isAppAvailable);

	/**
	 * 获取商店授权App信息，仅查询可用状态的APP
	 * 
	 * @param shopIds
	 *            多个商店ID
	 * @return 授权的App列表
	 * @see #getShopRAppInfoList(List, Boolean)
	 */
	@Read
	default public List<ShopRAppInfoBean> getShopRAppInfoList(final List<Long> shopIds){
		return getShopRAppInfoList(shopIds, Boolean.TRUE);
	}

	/**
	 * 获取商店授权App信息
	 * 
	 * @param userId
	 *            用户ID
	 * @param isAppAvailable
	 *            APP是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
	 * @return 授权的App列表
	 * 
	 */
	@Read
	public List<ShopRAppInfoBean> getShopRAppInfoListByUserId(final Long userId, final Boolean isAppAvailable);

	/**
	 * 获取商店授权App信息，仅查询可用状态的APP
	 * 
	 * @param userId
	 *            用户ID
	 * @return 授权的App列表
	 * @see #getShopRAppInfoListByUserId(Long, Boolean)
	 */
	@Read
	default public List<ShopRAppInfoBean> getShopRAppInfoListByUserId(final Long userId){
		return getShopRAppInfoListByUserId(userId, Boolean.TRUE);
	}


	/**
	 * 获取商店授权App信息（多个APP信息合并）
	 *
	 * <pre>
	 * 如果查询结果不需要合并APP，则使用{@link #getShopRAppInfoList(List, Boolean)}
	 * </pre>
	 *
	 * @param shopIds
	 *            多个商店ID
	 * @param isAppAvailable
	 *            APP是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
	 * @return 授权的App列表
	 *
	 */
	@Read
	public List<ShopRAppInfoBean> getShopRAppInfoListWithConcat(final List<Long> shopIds, final Boolean isAppAvailable);

	/**
	 * 插入商店授权APP对象
	 *
	 * <pre>
	 * 仅使用以下字段：
	 * 【必填】Long shopId：商店ID
	 * 【必填】Long appId：APP ID
	 * 其他字段都不使用
	 * </pre>
	 *
	 * @param shopRApps
	 *            商店授权APP信息
	 * @return 成功插入条数
	 */
	@Write
	public Integer insertShopRApp(final List<ShopRAppInfoBean> shopRApps);

	/**
	 * 根据商店授权APP对象ID删除商店授权关系
	 *
	 * @param ids
	 *            多个唯一主键ID
	 * @return 成功删除的条数
	 */
	@Write
	public Integer deleteShopRAppById(final List<Long> ids);

	/**
	 * 根据商店ID删除商店所有授权APP关系
	 *
	 * @param shopIds
	 *            多个商店ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteShopRAppByShopId(final List<Long> shopIds);

	/**
	 * 根据商店ID、多个APP ID删除商店授权APP关系
	 *
	 * @param appIds
	 *            多个APP的ID
	 * @param shopId
	 *            商店ID
	 * @return 成功删除条数
	 */
	@Write
	public Integer deleteShopRAppByShopId(final List<Long> appIds, final Long shopId);

	/* ====================重载==================== */

	/**
	 * 获取商店授权App信息（多个APP信息合并），仅查询可用状态的APP
	 *
	 * <pre>
	 * 如果查询结果不需要合并APP，则使用{@link #getShopRAppInfoList(List)}
	 * </pre>
	 *
	 * @param shopIds
	 *            多个商店ID
	 * @return 授权的App列表
	 * @see #getShopRAppInfoListWithConcat(List, Boolean)
	 */
	@Read
	default public List<ShopRAppInfoBean> getShopRAppInfoListWithConcat(final List<Long> shopIds){
		return getShopRAppInfoListWithConcat(shopIds, Boolean.TRUE);
	}

}
