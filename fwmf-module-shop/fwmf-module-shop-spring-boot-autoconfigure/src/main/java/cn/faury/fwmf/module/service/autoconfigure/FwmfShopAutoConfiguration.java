package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.shop.service.ShopInfoService;
import cn.faury.fwmf.module.api.shop.service.UserRShopService;
import cn.faury.fwmf.module.service.shop.service.ShopInfoServiceImpl;
import cn.faury.fwmf.module.service.shop.service.UserRShopServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 推送服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
@AutoConfigureBefore(name = {"cn.faury.fdk.mobile.autoconfigure.FdkMobileAutoConfiguration"})
public class FwmfShopAutoConfiguration {

    /**
     * 商店信息服务
     */
    @Bean
    @ConditionalOnClass({ShopInfoService.class, ShopInfoServiceImpl.class})
    public ShopInfoService shopInfoService(CommonDao commonDao) {
        return new ShopInfoServiceImpl(commonDao);
    }

    /**
     * 用户关联商店服务
     */
    @Bean
    @ConditionalOnClass({UserRShopService.class, UserRShopServiceImpl.class})
    public UserRShopService userRShopService(CommonDao commonDao) {
        return new UserRShopServiceImpl(commonDao);
    }
}
