package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.app.service.AppInfoService;
import cn.faury.fwmf.module.api.app.service.ShopRAppInfoService;
import cn.faury.fwmf.module.api.app.service.UserRAppInfoService;
import cn.faury.fwmf.module.service.app.service.AppInfoServiceImpl;
import cn.faury.fwmf.module.service.app.service.ShopRAppInfoServiceImpl;
import cn.faury.fwmf.module.service.app.service.UserRAppInfoServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * APP服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
@AutoConfigureBefore(name = {"cn.faury.fdk.mobile.autoconfigure.FdkMobileAutoConfiguration"})
public class FwmfAppAutoConfiguration {

    /**
     * APP服务
     */
    @Bean
    @ConditionalOnClass({AppInfoService.class, AppInfoServiceImpl.class})
    public AppInfoService appInfoService(CommonDao commonDao) {
        return new AppInfoServiceImpl(commonDao);
    }

    /**
     * 商店授权APP服务
     */
    @Bean
    @ConditionalOnClass({ShopRAppInfoService.class, ShopRAppInfoServiceImpl.class})
    public ShopRAppInfoService shopRAppInfoService(CommonDao commonDao) {
        return new ShopRAppInfoServiceImpl(commonDao);
    }

    /**
     * 用户授权APP服务
     */
    @Bean
    @ConditionalOnClass({UserRAppInfoService.class, UserRAppInfoServiceImpl.class})
    public UserRAppInfoService userRAppInfoService(CommonDao commonDao) {
        return new UserRAppInfoServiceImpl(commonDao);
    }
}
