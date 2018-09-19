package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.code.service.CodeGroupInfoService;
import cn.faury.fwmf.module.api.code.service.CodeInfoService;
import cn.faury.fwmf.module.service.code.service.CodeGroupInfoServiceImpl;
import cn.faury.fwmf.module.service.code.service.CodeInfoServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 字典服务服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfCodeAutoConfiguration {

    /**
     * 字典服务
     */
    @Bean
    @ConditionalOnClass({CodeInfoService.class, CodeInfoServiceImpl.class})
    public CodeInfoService codeInfoService(CommonDao commonDao) {
        return new CodeInfoServiceImpl(commonDao);
    }

    /**
     * 字典分组服务
     */
    @Bean
    @ConditionalOnClass({CodeGroupInfoService.class, CodeGroupInfoServiceImpl.class})
    public CodeGroupInfoService codeGroupInfoService(CommonDao commonDao) {
        return new CodeGroupInfoServiceImpl(commonDao);
    }
}
