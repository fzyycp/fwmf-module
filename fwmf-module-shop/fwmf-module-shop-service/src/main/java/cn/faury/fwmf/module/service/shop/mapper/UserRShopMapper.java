package cn.faury.fwmf.module.service.shop.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.shop.bean.ShopInfoBean;
import cn.faury.fwmf.module.service.shop.sqlProvider.UserRShopSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface UserRShopMapper {

	/**
	 * 通过用户ID查询商店信息
	 */
	@SelectProvider(type = UserRShopSqlProvider.class, method = "getShopInfoByUserId")
	@ResultType(ShopInfoBean.class)
	public List<ShopInfoBean> getShopInfoByUserId(Map<String, Object> parameter);

}
