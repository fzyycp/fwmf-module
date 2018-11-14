package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.service.*;
import cn.faury.fwmf.module.service.category.service.*;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 区域服务服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfCategoryAutoConfiguration {

    /**
     * 分类服务
     */
    @Bean
    @ConditionalOnClass({CategoryInfoService.class, CategoryInfoServiceImpl.class})
    public CategoryInfoService categoryInfoService(CommonDao commonDao) {
        return new CategoryInfoServiceImpl(commonDao);
    }

    /**
     * 分类授权业务系统服务
     */
    @Bean
    @ConditionalOnClass({SystemRCategoryService.class, SystemRCategoryServiceImpl.class})
    public SystemRCategoryService systemRCategoryService(CommonDao commonDao) {
        return new SystemRCategoryServiceImpl(commonDao);
    }

    /**
     * 分类关联标签服务
     */
    @Bean
    @ConditionalOnClass({CategoryRTagService.class, CategoryRTagServiceImpl.class})
    public CategoryRTagService categoryRTagService(CommonDao commonDao) {
        return new CategoryRTagServiceImpl(commonDao);
    }

    /**
     * 标签服务
     */
    @Bean
    @ConditionalOnClass({TagInfoService.class, TagInfoServiceImpl.class})
    public TagInfoService tagInfoService(CommonDao commonDao) {
        return new TagInfoServiceImpl(commonDao);
    }

    /**
     * 标签授权系统服务
     */
    @Bean
    @ConditionalOnClass({SystemRTagService.class, SystemRTagServiceImpl.class})
    public SystemRTagService systemRTagService(CommonDao commonDao) {
        return new SystemRTagServiceImpl(commonDao);
    }
}
