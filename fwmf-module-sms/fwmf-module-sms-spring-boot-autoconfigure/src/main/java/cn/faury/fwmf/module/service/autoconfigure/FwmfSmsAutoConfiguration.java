package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.sms.service.SmsVCodeService;
import cn.faury.fwmf.module.service.sms.service.SmsVCodeServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfSmsAutoConfiguration {

    @Value("${fwmf.module.sms.send-message-url:}")
    private String sendMessageUrl;

    /**
     * 验证码服务
     */
    @Bean
    @ConditionalOnClass({SmsVCodeService.class, SmsVCodeServiceImpl.class})
    public SmsVCodeService smsVCodeService(CommonDao commonDao) {
        return new SmsVCodeServiceImpl(commonDao,sendMessageUrl);
    }

}
