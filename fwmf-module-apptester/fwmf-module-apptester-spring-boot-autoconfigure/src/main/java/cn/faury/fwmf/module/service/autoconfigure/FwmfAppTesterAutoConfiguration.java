package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.apptester.service.AppTesterService;
import cn.faury.fwmf.module.service.apptester.service.AppTesterServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * APP测试人员服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfAppTesterAutoConfiguration {

    /**
     * APP服务
     */
    @Bean
    @ConditionalOnClass({AppTesterService.class, AppTesterServiceImpl.class})
    public AppTesterService appTesterService(CommonDao commonDao) {
        return new AppTesterServiceImpl(commonDao);
    }

}
