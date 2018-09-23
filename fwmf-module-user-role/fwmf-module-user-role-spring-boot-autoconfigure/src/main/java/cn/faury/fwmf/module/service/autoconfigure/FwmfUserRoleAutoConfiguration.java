package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.role.service.RoleInfoService;
import cn.faury.fwmf.module.api.user.service.*;
import cn.faury.fwmf.module.service.role.service.RoleInfoServiceImpl;
import cn.faury.fwmf.module.service.user.service.*;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用户角色服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
@AutoConfigureBefore(name = {"cn.faury.fdk.shiro.autoconfigure.FdkShiroAutoConfiguration"
        , "cn.faury.fdk.mobile.autoconfigure.FdkMobileAutoConfiguration"})
public class FwmfUserRoleAutoConfiguration {

    /**
     * 角色服务
     */
    @Bean
    @ConditionalOnClass({RoleInfoService.class, RoleInfoServiceImpl.class})
    public RoleInfoService roleInfoService(CommonDao commonDao) {
        return new RoleInfoServiceImpl(commonDao);
    }

    /**
     * 用户服务
     */
    @Bean
    @ConditionalOnClass({UserInfoService.class, UserInfoServiceImpl.class})
    public UserInfoService userInfoService(CommonDao commonDao, RoleInfoService roleInfoService) {
        return new UserInfoServiceImpl(commonDao, roleInfoService);
    }

    /**
     * 优惠用户组关联服务
     */
    @Bean
    @ConditionalOnClass({DiscusRUserGroupsService.class, DiscusRUserGroupsServiceImpl.class})
    public DiscusRUserGroupsService discusRUserGroupsService(CommonDao commonDao) {
        return new DiscusRUserGroupsServiceImpl(commonDao);
    }

    /**
     * 推送用户群关联
     */
    @Bean
    @ConditionalOnClass({PushRUserGroupsService.class, PushRUserGroupsServiceImpl.class})
    public PushRUserGroupsService pushRUserGroupsService(CommonDao commonDao) {
        return new PushRUserGroupsServiceImpl(commonDao);
    }

    /**
     * 推送用户关联
     */
    @Bean
    @ConditionalOnClass({PushRUserService.class, PushRUserServiceImpl.class})
    public PushRUserService pushRUserService(CommonDao commonDao) {
        return new PushRUserServiceImpl(commonDao);
    }

    /**
     * 红包用户组关联
     */
    @Bean
    @ConditionalOnClass({RedRUserGroupsService.class, RedRUserGroupsServiceImpl.class})
    public RedRUserGroupsService redRUserGroupsService(CommonDao commonDao) {
        return new RedRUserGroupsServiceImpl(commonDao);
    }

    /**
     * 角色用户服务
     */
    @Bean
    @ConditionalOnClass({RoleRUserService.class, RoleRUserServiceImpl.class})
    public RoleRUserService roleRUserService(CommonDao commonDao) {
        return new RoleRUserServiceImpl(commonDao);
    }

    /**
     * 商店用户服务
     */
    @Bean
    @ConditionalOnClass({ShopRUserService.class, ShopRUserServiceImpl.class, UserInfoService.class})
    public ShopRUserService shopRUserService(CommonDao commonDao, UserInfoService userInfoService) {
        return new ShopRUserServiceImpl(commonDao, userInfoService);
    }

    /**
     * 系统用户服务
     */
    @Bean
    @ConditionalOnClass({SystemRUserService.class, SystemRUserServiceImpl.class})
    public SystemRUserService systemRUserService(CommonDao commonDao) {
        return new SystemRUserServiceImpl(commonDao);
    }

    /**
     * 用户代理人服务
     */
    @Bean
    @ConditionalOnClass({UserAgentService.class, UserAgentServiceImpl.class})
    public UserAgentService userAgentService(CommonDao commonDao) {
        return new UserAgentServiceImpl(commonDao);
    }

    /**
     * 用户群服务
     */
    @Bean
    @ConditionalOnClass({UserGroupsService.class, UserGroupsServiceImpl.class})
    public UserGroupsService userGroupsService(CommonDao commonDao) {
        return new UserGroupsServiceImpl(commonDao);
    }

    /**
     * 用户OAuth服务
     */
    @Bean
    @ConditionalOnClass({UserOAuthService.class, UserOAuthServiceImpl.class})
    public UserOAuthService userOAuthService(CommonDao commonDao) {
        return new UserOAuthServiceImpl(commonDao);
    }
}
