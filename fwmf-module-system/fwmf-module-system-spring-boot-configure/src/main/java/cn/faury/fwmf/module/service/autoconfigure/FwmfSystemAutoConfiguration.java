package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.system.service.ShopRSystemService;
import cn.faury.fwmf.module.api.system.service.SystemService;
import cn.faury.fwmf.module.api.system.service.UserRSystemService;
import cn.faury.fwmf.module.service.system.service.ShopRSystemServiceImpl;
import cn.faury.fwmf.module.service.system.service.SystemServiceImpl;
import cn.faury.fwmf.module.service.system.service.UserRSystemServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 区域服务服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfSystemAutoConfiguration {

    /**
     * 商店授权业务系统服务
     */
    @Bean
    @ConditionalOnClass({ShopRSystemService.class, ShopRSystemServiceImpl.class})
    public ShopRSystemService shopRSystemService(CommonDao commonDao) {
        return new ShopRSystemServiceImpl(commonDao);
    }

    /**
     * 业务系统服务
     */
    @Bean
    @ConditionalOnClass({SystemService.class, SystemServiceImpl.class})
    public SystemService systemService(CommonDao commonDao) {
        return new SystemServiceImpl(commonDao);
    }

    /**
     * 用户授权业务系统服务
     */
    @Bean
    @ConditionalOnClass({UserRSystemService.class,SystemService.class, UserRSystemServiceImpl.class})
    public UserRSystemService userRSystemService(CommonDao commonDao, SystemService systemService) {
        return new UserRSystemServiceImpl(commonDao, systemService);
    }
}
