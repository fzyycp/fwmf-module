package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.menu.service.*;
import cn.faury.fwmf.module.service.menu.service.*;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 菜单服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
@ConditionalOnClass({UserRMenuService.class, UserRMenuServiceImpl.class})
public class FwmfMenuAutoConfiguration {

    /**
     * 菜单服务
     */
    @Bean
    public UserRMenuService userRMenuService(CommonDao commonDao) {
        return new UserRMenuServiceImpl(commonDao);
    }

    /**
     * 菜单功能按钮服务
     */
    @Bean
    public FunctionInfoService functionInfoService(CommonDao commonDao) {
        return new FunctionInfoServiceImpl(commonDao);
    }

    /**
     * 菜单服务
     */
    @Bean
    public MenuInfoService menuInfoService(CommonDao commonDao, FunctionInfoService functionInfoService) {
        return new MenuInfoServiceImpl(commonDao, functionInfoService);
    }

    /**
     * 角色关联功能按钮服务
     */
    @Bean
    public RoleRFuncService roleRFuncService(CommonDao commonDao) {
        return new RoleRFuncServiceImpl(commonDao);
    }

    /**
     * 角色关联菜单服务
     */
    @Bean
    public RoleRMenuService roleRMenuService(CommonDao commonDao, RoleRFuncService roleRFuncService) {
        return new RoleRMenuServiceImpl(commonDao, roleRFuncService);
    }

    /**
     * 业务系统菜单服务
     */
    @Bean
    public SystemRMenuService systemRMenuService(CommonDao commonDao) {
        return new SystemRMenuServiceImpl(commonDao);
    }
}
