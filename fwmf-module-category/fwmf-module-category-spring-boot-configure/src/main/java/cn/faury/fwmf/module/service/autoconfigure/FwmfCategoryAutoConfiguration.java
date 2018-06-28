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
    @ConditionalOnClass({CategoryService.class, CategoryServiceImpl.class})
    public CategoryService categoryService(CommonDao commonDao) {
        return new CategoryServiceImpl(commonDao);
    }

    /**
     * 分类标签服务
     */
    @Bean
    @ConditionalOnClass({CategoryService.class, CategoryTagService.class, CategoryTagServiceImpl.class})
    public CategoryTagService categoryTagService(CommonDao commonDao, CategoryService categoryService) {
        return new CategoryTagServiceImpl(commonDao, categoryService);
    }

    /**
     * 优惠关联服务
     */
    @Bean
    @ConditionalOnClass({DiscusRCategoryService.class, DiscusRCategoryServiceImpl.class})
    public DiscusRCategoryService discusRCategoryService(CommonDao commonDao) {
        return new DiscusRCategoryServiceImpl(commonDao);
    }

    /**
     * 红包关联服务
     */
    @Bean
    @ConditionalOnClass({RedRCategoryService.class, RedRCategoryServiceImpl.class})
    public RedRCategoryService redRCategoryService(CommonDao commonDao) {
        return new RedRCategoryServiceImpl(commonDao);
    }

    /**
     * 系统分类授权服务
     */
    @Bean
    @ConditionalOnClass({SystemCategoryService.class, SystemCategoryServiceImpl.class})
    public SystemCategoryService systemCategoryService(CommonDao commonDao) {
        return new SystemCategoryServiceImpl(commonDao);
    }

    /**
     * 系统标签授权服务
     */
    @Bean
    @ConditionalOnClass({SystemTagService.class, SystemTagServiceImpl.class})
    public SystemTagService systemTagService(CommonDao commonDao) {
        return new SystemTagServiceImpl(commonDao);
    }

    /**
     * 标签服务
     */
    @Bean
    @ConditionalOnClass({TagService.class, TagServiceImpl.class})
    public TagService tagService(CommonDao commonDao) {
        return new TagServiceImpl(commonDao);
    }
}
