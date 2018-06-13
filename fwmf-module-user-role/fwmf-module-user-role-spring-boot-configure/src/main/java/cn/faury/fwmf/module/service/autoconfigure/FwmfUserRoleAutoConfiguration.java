package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.role.service.RoleService;
import cn.faury.fwmf.module.api.user.service.UserService;
import cn.faury.fwmf.module.service.role.service.RoleServiceImpl;
import cn.faury.fwmf.module.service.user.service.UserServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用户角色服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
@ConditionalOnClass({RoleService.class, UserService.class})
public class FwmfUserRoleAutoConfiguration {

    /**
     * 角色服务
     */
    @Bean
    public RoleService roleService(CommonDao commonDao) {
        return new RoleServiceImpl(commonDao);
    }

    /**
     * 用户服务
     */
    @Bean
    public UserService userService(CommonDao commonDao, RoleService roleService) {
        return new UserServiceImpl(commonDao,roleService);
    }
}
