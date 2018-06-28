package cn.faury.fwmf.module.service.user.mapper;


import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.ShopRUserBean;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import cn.faury.fwmf.module.service.user.sqlProvider.ShopRUserSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface ShopRUserMapper {

	@Insert("INSERT INTO " + DBConstOfUserRole.TN_SHOP_USER_INFO
	        + " (`SHOP_USER_ID`, `SHOP_ID`,`IS_SELF_CREATE`,IS_ADMIN) VALUES "
	        + "(#{shopUserId}, #{shopId},#{isSelfCreate},#{isAdmin})")
	@Options(keyProperty = "id", useGeneratedKeys = true)
	public Long insertShopRUserInfo(final ShopRUserBean bean);

	/**
	 * 获取商店关联用户列表
	 */
	@SelectProvider(type = ShopRUserSQLProvider.class, method = "queryShopRUserInfoList")
	@ResultType(ShopRUserBean.class)
	public List<ShopRUserBean> queryShopRUserInfoList(Map<String, Object> parameters);

	/**
	 * 通过条件查询商店用户信息
	 */
	@SelectProvider(type = ShopRUserSQLProvider.class, method = "getShopInfo")
	@ResultType(ShopRUserBean.class)
	public List<ShopRUserBean> getShopInfo(Map<String, Object> parameters);

	/**
	 * 获取商店未关联关联用户列表
	 */
	@SelectProvider(type = ShopRUserSQLProvider.class, method = "getShopUnUserList")
	@ResultType(ShopRUserBean.class)
	public List<ShopRUserBean> getShopUnUserList(Map<String, Object> parameters);

	/**
	 * 通过商店用户ID查询商店用户信息
	 */
	@SelectProvider(type = ShopRUserSQLProvider.class, method = "getShopRUserInfoById")
	@ResultType(ShopRUserBean.class)
	public ShopRUserBean getShopRUserInfoById(Map<String, Object> parameter);

	/**
	 * 删除商店用户关联表
	 */
	@SelectProvider(type = ShopRUserSQLProvider.class, method = "deleteShopRUser")
	public Integer deleteShopRUser(Map<String, Object> parameter);

	@Select("SELECT COUNT(USER_ID) COUNT FROM " + DBConstOfUserRole.TN_USER_R_SYSTEM
	        + " WHERE USER_ID = #{shopUserId} UNION ALL SELECT COUNT(USER_ID) COUNT FROM "
	        + DBConstOfUserRole.TN_USER_R_APP
	        + " WHERE USER_ID = #{shopUserId} UNION ALL SELECT COUNT(USER_ID) COUNT FROM "
	        + DBConstOfUserRole.TN_APP_TESTER
	        + " WHERE USER_ID = #{shopUserId} UNION ALL SELECT COUNT(USER_ID) COUNT FROM " + DBConstOfUserRole.TN_USER_R_ROLE
	        + " WHERE USER_ID = #{shopUserId} UNION ALL SELECT COUNT(USER_ID) COUNT FROM "
	        + DBConstOfUserRole.TN_CDA_GROUP_USER + " WHERE USER_ID=#{shopUserId}")
	public List<Integer> isShopUserR(Long shopUserId);

}
