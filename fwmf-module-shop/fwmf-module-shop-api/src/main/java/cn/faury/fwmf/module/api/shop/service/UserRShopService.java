package cn.faury.fwmf.module.api.shop.service;


import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fwmf.module.api.shop.bean.ShopInfoBean;

import java.util.List;

/**
 * 用户商店信息
 */
public interface UserRShopService {

	/**
	 * 通过用户ID查询商店信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return
	 */
	@Read
	public List<ShopInfoBean> getShopInfoByUserId(final Long userId);

}
