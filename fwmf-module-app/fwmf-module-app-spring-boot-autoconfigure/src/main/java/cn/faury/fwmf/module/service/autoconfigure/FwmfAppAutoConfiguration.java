package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.app.service.*;
import cn.faury.fwmf.module.service.app.service.*;
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
     * APP测试人员服务
     */
    @Bean
    @ConditionalOnClass({AppTesterService.class, AppTesterServiceImpl.class})
    public AppTesterService appTesterService(CommonDao commonDao) {
        return new AppTesterServiceImpl(commonDao);
    }

    /**
     * APP版本服务
     */
    @Bean
    @ConditionalOnClass({AppVersionService.class, AppVersionServiceImpl.class})
    public AppVersionService appVersionService(CommonDao commonDao) {
        return new AppVersionServiceImpl(commonDao);
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
