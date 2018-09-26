package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.sensitive.service.SensitiveInfoService;
import cn.faury.fwmf.module.service.sensitive.service.SensitiveInfoServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 菜单服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfSensitiveAutoConfiguration {

    /**
     * 菜单服务
     */
    @Bean
    @ConditionalOnClass({SensitiveInfoService.class, SensitiveInfoServiceImpl.class})
    public SensitiveInfoService sensitiveInfoService(CommonDao commonDao) {
        return new SensitiveInfoServiceImpl(commonDao);
    }

}
