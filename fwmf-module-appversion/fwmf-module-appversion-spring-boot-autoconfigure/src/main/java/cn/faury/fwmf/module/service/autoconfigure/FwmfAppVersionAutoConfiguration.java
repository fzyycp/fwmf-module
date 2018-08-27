package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.service.AppVersionService;
import cn.faury.fwmf.module.service.appversion.service.AppVersionServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * APP服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfAppVersionAutoConfiguration {

    /**
     * APP版本服务
     */
    @Bean
    @ConditionalOnClass({AppVersionService.class, AppVersionServiceImpl.class})
    public AppVersionService appVersionService(CommonDao commonDao) {
        return new AppVersionServiceImpl(commonDao);
    }

}
