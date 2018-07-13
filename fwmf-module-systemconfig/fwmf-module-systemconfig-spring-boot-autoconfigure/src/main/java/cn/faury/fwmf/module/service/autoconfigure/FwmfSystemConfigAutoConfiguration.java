package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.systemconfig.service.SystemConfigService;
import cn.faury.fwmf.module.service.systemconfig.service.SystemConfigServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 区域服务服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfSystemConfigAutoConfiguration {

    /**
     * 系统配置服务
     */
    @Bean
    @ConditionalOnClass({SystemConfigService.class, SystemConfigServiceImpl.class})
    public SystemConfigService systemConfigService(CommonDao commonDao) {
        return new SystemConfigServiceImpl(commonDao);
    }

}
