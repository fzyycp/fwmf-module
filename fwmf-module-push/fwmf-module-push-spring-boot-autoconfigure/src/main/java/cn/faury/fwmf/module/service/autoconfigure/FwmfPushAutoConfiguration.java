package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.push.service.PushService;
import cn.faury.fwmf.module.service.push.service.PushServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 推送服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
@ConditionalOnClass({PushService.class, PushServiceImpl.class})
public class FwmfPushAutoConfiguration {

    /**
     * 菜单服务
     */
    @Bean
    public PushService roleService(CommonDao commonDao) {
        return new PushServiceImpl(commonDao);
    }
}
