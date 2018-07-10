package cn.faury.fwmf.module.api.shop.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.shop.bean.ShopInfoBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商店信息
 */
public interface ShopInfoService {

	/**
	 * 插入保存商店信息
	 * 
	 * @param bean
	 *            <pre>
	 * 【必填】【String】shopName 商店名称
	 * 【必填】【String】shortName 商店简称
	 * 【必填】【Long】shopKeeperId 店主用户 ID
	 * 【必填】【String】allocatRatio 比例分配
	 * 【必填】【String】payStyle 支付方式
	 * 【必填】【String】shopState 商店状态
	 * 【必填】【String】delFlag 删除标志
	 * 【必填】【Long】createPerson 创建者
	 * 【必填】【Long】resourceSystem 来源系统
	 * 【可选】【String】areaCode 省市县编码
	 * 【可选】【String】address 详细地址
	 * 【可选】【String】remark 备注
	 * </pre>
	 * @return shopId
	 */
	@Write
	public Long insertShopInfo(final ShopInfoBean bean);

	/**
	 * 更新商店信息
	 * 
	 * @param bean
	 *            <pre>
	 * 【必填】【Long】shopId商店ID
	 * 【可选】【String】shopName 商店名称
	 * 【可选】【String】shortName 商店简称
	 * 【可选】【String】allocatRatio 比例分配
	 * 【可选】【String】payStyle 支付方式
	 * 【可选】【String】shopState 商店状态
	 * 【可选】【String】delFlag 删除标志
	 * 【必填】【Long】updatePerson 修改者
	 * 【可选】【String】areaCode 省市县编码
	 * 【可选】【String】address 详细地址
	 * 【可选】【String】remark 备注
	 * </pre>
	 * @return 更新条数
	 */
	@Write
	public int updateShopInfo(final ShopInfoBean bean);

	/**
	 * 删除商店信息（逻辑删除）
	 * 
	 * @param shopIds
	 *            多个商店id
	 * @return 更新条数
	 */
	@Write
	public int deleteShopInfo(final List<Long> shopIds);

	/**
	 * 商店启用
	 * 
	 * @param shopIds
	 *            多个商店ID
	 * @return 更新条数
	 */
	@Write
	default public int updateEnableShopState(final List<Long> shopIds){
        return updateShopState(shopIds, "1");
    }

	/**
	 * 商店禁用
	 * 
	 * @param shopIds
	 *            多个商店ID
	 * @return 更新条数
	 */
	@Write
	default public int updateDisableShopState(final List<Long> shopIds){
        return updateShopState(shopIds, "2");
    }

	/**
	 * 通过商店ID查询商店信息
	 * 
	 * @param shopId
	 *            商店ID
	 */
	@Read
	public ShopInfoBean getShopInfoById(final Long shopId);

	/**
	 * 通过条件查询商店信息
	 * 
	 * @param shopIds
	 *            多个商店IDS
	 * @return
	 */
	@Read
	public List<ShopInfoBean> getShopInfoByshopIds(final List<Long> shopIds);

	/**
	 * 根据系统code、商店名称查询系统下对应的商店
	 * 
	 * @param shopName
	 *            【必填】商店名称
	 * @param systemCode
	 *            【必填】系统code
	 * @param pageParam
	 *            【必填】分页参数
	 * @return
	 */
	@Read
	default public PageInfo<ShopInfoBean> getShopInfoBySystemCode(final String shopName, final String systemCode,
														  final PageParam pageParam){
		AssertUtil.assertNotEmpty(systemCode,"系统code不能为空或不存在");
		AssertUtil.assertNotEmpty(shopName,"商店名称不能为空或不存在");
		Map<String, Object> paramter = new HashMap<>();
		paramter.put("shopName", shopName);
		return getShopInfo(systemCode, pageParam, paramter);
	}

	/**
	 * 根据系统code查询系统下的商店信息
	 *
	 * @param systemCode
	 *            【必填】 系统code
	 * @param pageParam
	 *            【必填】分页参数
	 * @return
	 */
	@Read
	default public PageInfo<ShopInfoBean> getShopInfoBySystemCode(final String systemCode, final PageParam pageParam){
        AssertUtil.assertNotEmpty(systemCode,"系统code不能为空或不存在");
        return getShopInfo(systemCode, pageParam, null);
    }

	/**
	 * 根据条件查询商店信息
	 *
	 * @param systemCode
	 *            【必填】 系统code
	 * @param pageParam
	 *            分页参数（null 不分页）
	 * @param paramter
	 *            查询参数
	 *
	 *            <pre>
	 * 支持的查询参数：
	 * 	【可选】 Long shopId:商店ID
	 * 	【可选】【模糊查询】String shopName:商店名称
	 * 	【可选】【模糊查询】String shopKeeperName:店主姓名
	 * 	【可选】【范围查询】String startTime:开通时间范围
	 * 	【可选】【范围查询】String endTime:开通时间范围
	 * 【可选】String shopState：商店状态
	 * </pre>
	 * @return
	 */
	@Read
	public PageInfo<ShopInfoBean> getShopInfo(final String systemCode, final PageParam pageParam,
                                                final Map<String, Object> paramter);

	/**
	 * 新增 判断 商店名是否重复
	 * 
	 * @param shopName
	 * @return
	 */
	default public boolean isExistShopName(final String shopName){
		AssertUtil.assertNotEmpty(shopName, "商店名称为空或不存在");
		return isExistShopInfo(shopName, null, null);
    }

	/**
	 * 新增 判断 商店简称是否重复
	 * 
	 * @param shortName
	 * @return
	 */
	default public boolean isExistShortName(final String shortName){
		AssertUtil.assertNotEmpty(shortName, "商店简称为空或不存在");
		return isExistShopInfo(null, shortName, null);
    }

	/**
	 * 通过条件查询商店信息 ======分页
	 *
	 * @see #queryShopInfo(String, String, Long)
	 */
	@Read
	public PageInfo<ShopInfoBean> queryShopInfo(Map<String, Object> map);

	/**
	 * 通过条件查询商店信息
	 *
	 * @param shopName
	 *            【可选】商店名称
	 * @param shopState
	 *            【可选】商店状态
	 * @param systemId
	 *            【可选】授权系统
	 * @return
	 */
	@Read
	public List<ShopInfoBean> queryShopInfo(final String shopName, final String shopState, final Long systemId);

	/**
	 * 验证是否存在
	 *
	 * @param shopName
	 *            【二选一】商店名称
	 * @param shortName
	 *            【二选一】商店简称
	 * @param shopId
	 *            【可选】商店ID
	 * @return
	 */
	@Read
	public boolean isExistShopInfo(final String shopName, final String shortName, final Long shopId);

	/**
	 * 更新商店状态（启用、禁用）
	 *
	 * @param shopIds
	 *            多个商店ID
	 * @param shopState
	 *            商店状态
	 * @return
	 */
	@Write
	public int updateShopState(final List<Long> shopIds, final String shopState);

	/**
	 * 判断是否授权系统
	 *
	 * @param shopId
	 *            商店ID
	 * @return
	 */
	@Read
	public boolean isShopRSystem(final Long shopId);

	/**
	 * 判断是否授权App
	 *
	 * @param shopId
	 *            商店ID
	 * @return
	 */
	@Read
	public boolean isShopRApp(final Long shopId);

	/**
	 * 判断是否存在自建用户
	 *
	 * @param shopId
	 *            商店ID
	 * @return
	 */
	@Read
	public boolean isShopRUserSelfCreate(final Long shopId);

	/**
	 * 获取未授权系统
	 *
	 * @return
	 */
	@Read
	public List<ShopInfoBean> getShopInfoUnRSystem();

}
