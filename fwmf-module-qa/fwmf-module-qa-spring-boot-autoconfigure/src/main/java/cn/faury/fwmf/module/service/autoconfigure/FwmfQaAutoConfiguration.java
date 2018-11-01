package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.qa.service.QaInfoService;
import cn.faury.fwmf.module.api.qa.service.QaTxtService;
import cn.faury.fwmf.module.service.qa.service.QaInfoServiceImpl;
import cn.faury.fwmf.module.service.qa.service.QaTxtServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 常见问题服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfQaAutoConfiguration {

    private Logger logger = LoggerFactory.getLogger(FwmfQaAutoConfiguration.class);

    /**
     * 问题服务
     */
    @Bean
    @ConditionalOnClass({QaInfoService.class, QaInfoServiceImpl.class, QaTxtService.class})
    public QaInfoService qaInfoService(CommonDao commonDao, QaTxtService qaTxtService) {
        return new QaInfoServiceImpl(commonDao, qaTxtService);
    }

    /**
     * 问题内容服务
     */
    @Bean
    @ConditionalOnClass({QaTxtService.class, QaTxtServiceImpl.class})
    public QaTxtService qaTxtService(CommonDao commonDao) {
        return new QaTxtServiceImpl(commonDao);
    }

}
