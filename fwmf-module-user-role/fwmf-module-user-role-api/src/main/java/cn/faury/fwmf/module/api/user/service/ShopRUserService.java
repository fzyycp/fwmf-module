package cn.faury.fwmf.module.api.user.service;


import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fwmf.module.api.user.bean.ShopRUserBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商店用户关联
 */
public interface ShopRUserService {

	/**
	 * 插入商店用户关联表(通过用户ID获取用户信息，然后商店用户关联)
	 *
	 * @param shopId
	 *            商店ID
	 * @param shopUserId
	 *            商店用户ID
	 * @param isSelfCreate
	 *            是否自建
	 * @param isAdmin
	 *            是否是店主
	 * @return
	 */
	@Write
	public Integer insertShopRUserById(final Long shopId, final Long shopUserId, final String isSelfCreate,
                                       final String isAdmin);
	/**
	 * 删除用户表、用户密码表、商店用户关联表
	 * 
	 * @param shopUserIds
	 *            【必填】多个用户IDS
	 * @param shopId
	 *            【必填】商店ID
	 * @param isSelfCreate
	 *            【必填】是否自己创建：true，自建
	 * @return Integer
	 */
	@Write
	public Integer deleteUser(final List<Long> shopUserIds, final Long shopId, final Boolean isSelfCreate);

	/**
	 * 通过商店用户ID查询商店用户信息
	 * 
	 * @param shopUserId
	 *            【必填】商店用户ID
	 * @param shopId
	 *            【必填】商店ID
	 * @return 商店用户信息
	 */
	@Read
	public ShopRUserBean getShopRUserInfoById(final Long shopUserId, final Long shopId);

	/**
	 * 通过条件查询商店用户信息
	 * 
	 * 
	 * @param pageParam
	 *            分页参数
	 * @param paramter
	 *            查询条件
	 * 
	 *            <pre>
	 * 【可选】String systemCode 系统Code
	 * 【可选】Long shopId 商店ID
	 * 【可选】String shopName 商店名称
	 * 【可选】String ShortName 商店简称
	 * 【可选】String shopUserName 商店用户姓名
	 * 【可选】String shopUserLoginName 商店用户登录名
	 * 【可选】List<Long> userIds 商店用户IDs
	 * </pre>
	 * @return 商店用户信息
	 */
	@Read
	public PageInfo<ShopRUserBean> getShopInfo(final PageParam pageParam, final Map<String, Object> paramter);

	/**
	 * 通过商店ID查询商店用户信息
	 * 
	 * @param pageParam
	 *            分页参数
	 * @param shopId
	 *            商店ID
	 * @return 商店用户信息
	 */
	@Read
	default public PageInfo<ShopRUserBean> getShopInfoByShopId(final PageParam pageParam, final Long shopId){
		Map<String, Object> paramter = new HashMap<String, Object>();
		paramter.put("shopId", shopId);
		return getShopInfo(pageParam, paramter);
	}

	/**
	 * 通过商店名称查询商店用户信息
	 * 
	 * @param pageParam
	 *            分页参数
	 * @param shopName
	 *            商店名称
	 * @return 商店用户信息
	 */
	@Read
	default public PageInfo<ShopRUserBean> getShopInfoByShopName(final PageParam pageParam, final String shopName){
		Map<String, Object> paramter = new HashMap<String, Object>();
		paramter.put("shopName", shopName);
		return getShopInfo(pageParam, paramter);
	}

	/**
	 * 通过商店简称查询商店用户信息
	 * 
	 * @param pageParam
	 *            分页参数
	 * @param shortName
	 *            商店简称
	 * @return 商店用户信息
	 */
	@Read
	default public PageInfo<ShopRUserBean> getShopInfoByShortName(final PageParam pageParam, final String shortName){
		Map<String, Object> paramter = new HashMap<String, Object>();
		paramter.put("shortName", shortName);
		return getShopInfo(pageParam, paramter);
	}

	/**
	 * 插入商店用户关联表(先插入用户表（密码获取系统参数），然后商店用户关联)
	 *
	 * <pre>
	 * shopUserLoginName 【必填】商店用户登录名
	 * shopUserName 【必填】商店用户姓名
	 * isSelfCreate 【必填】是否自己创建
	 * isAdmin【必填】是否店主
	 * shopId 【必填】商店ID
	 * systemId 【必填】所属系统ID
	 * password 【必填】密码
	 * </pre>
	 *
	 * @param bean
	 * @return
	 */
	@Write
	public Long insertShopRUser(final ShopRUserBean bean);

	/**
	 *
	 * @param 【必填】shopUserIds 多个用户IDS
	 * @param 【必填】shopId 商店ID
	 * @return
	 */
	@Write
	public Integer deleteShopRUser(final List<Long> shopUserIds, final Long shopId);

	/**
	 * 通过商店id查询商店用户 =======分页
	 *
	 * <pre>
	 * @param 【可选】shopUserLoginName shopUserLoginName
	 * @param 【可选】shopUserName 商店用户姓名
	 * @param 【必填】shopId 商店ID
	 * @param 【必填】systrmId 系统ID
	 * </pre>
	 *
	 * @param map
	 * @return
	 */
	@Read
	public PageInfo<ShopRUserBean> queryShopRUserInfoPage(final Map<String, Object> map);

	/**
	 * 通过商店id查询商店用户
	 *
	 * <pre>
	 * @param 【可选】shopUserLoginName shopUserLoginName
	 * @param 【可选】shopUserName 商店用户姓名
	 * @param 【必填】shopId 商店ID
	 * @param 【必填】systrmId 系统ID
	 * </pre>
	 *
	 * @param map
	 * @return
	 */
	@Read
	public List<ShopRUserBean> queryShopRUserInfoList(final Map<String, Object> map);

	/**
	 * 获取未关联商店用户
	 *
	 * <pre>
	 * 参数说明：
	 * page：分页参数
	 * rows:分页参数
	 * 【必选】shopId：商店ID
	 * 【必选】systemId：业务系统ID或者APP ID
	 * </pre>
	 *
	 * @return
	 */
	@Read
	public PageInfo<ShopRUserBean> getShopUnUserList(final Map<String, Object> parameters);

	/**
	 * 判断用户是否关联其他表（授权系统、APP，用户组，测试用户，角色）
	 *
	 * @param shopUserId
	 *            商店用户ID
	 * @return
	 */
	@Read
	public Boolean isShopUserR(final Long shopUserId);

    /**
     * 修改商店用户关联信息(修改用户表，修改商店用户关联)
     *
     * <pre>
     * shopUserId 【必填】商店用户ID
     * shopUserLoginName 【必填】商店用户登录名
     * shopUserName 【必填】商店用户姓名
     * isSelfCreate 【必填】是否自己创建1，自建
     * </pre>
     *
     * @param bean
     * @return Integer
     */
    @Write
    public Integer updateShopRUser(final ShopRUserBean bean);
}
