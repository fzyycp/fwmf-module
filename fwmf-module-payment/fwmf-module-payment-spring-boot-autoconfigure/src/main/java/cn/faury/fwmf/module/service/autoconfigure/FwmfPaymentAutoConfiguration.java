package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fwmf.module.api.payment.service.AlipayCallbackRecordsService;
import cn.faury.fwmf.module.api.payment.service.AlipayRecordsService;
import cn.faury.fwmf.module.api.payment.service.WeixinCallbackRecordsService;
import cn.faury.fwmf.module.api.payment.service.WeixinPayRecordsService;
import cn.faury.fwmf.module.service.payment.service.AlipayCallbackRecordsServiceImpl;
import cn.faury.fwmf.module.service.payment.service.AlipayRecordsServiceImpl;
import cn.faury.fwmf.module.service.payment.service.WeixinCallbackRecordsServiceImpl;
import cn.faury.fwmf.module.service.payment.service.WeixinPayRecordsServiceImpl;
import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfPaymentAutoConfiguration {

    /**
     * 微信支付请求记录服务
     */
    @Bean
    @ConditionalOnClass({WeixinPayRecordsService.class, WeixinPayRecordsServiceImpl.class})
    public WeixinPayRecordsService weixinPayRecordsService(CommonDao commonDao) {
        return new WeixinPayRecordsServiceImpl(commonDao);
    }

    /**
     * 微信支付回调记录服务
     */
    @Bean
    @ConditionalOnClass({WeixinCallbackRecordsService.class, WeixinCallbackRecordsServiceImpl.class})
    public WeixinCallbackRecordsService weixinCallbackRecordsService(CommonDao commonDao) {
        return new WeixinCallbackRecordsServiceImpl(commonDao);
    }

    /**
     * 支付宝支付请求记录服务
     */
    @Bean
    @ConditionalOnClass({AlipayRecordsService.class, AlipayRecordsServiceImpl.class})
    public AlipayRecordsService alipayRecordsService(CommonDao commonDao) {
        return new AlipayRecordsServiceImpl(commonDao);
    }

    /**
     * 支付宝支付回调记录服务
     */
    @Bean
    @ConditionalOnClass({AlipayCallbackRecordsService.class, AlipayCallbackRecordsServiceImpl.class})
    public AlipayCallbackRecordsService alipayCallbackRecordsService(CommonDao commonDao) {
        return new AlipayCallbackRecordsServiceImpl(commonDao);
    }

}
