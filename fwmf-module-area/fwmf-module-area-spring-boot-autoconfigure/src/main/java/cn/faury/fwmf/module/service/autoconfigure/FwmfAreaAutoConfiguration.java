package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.area.service.AreaService;
import cn.faury.fwmf.module.service.area.service.AreaServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 区域服务服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
@ConditionalOnClass({AreaService.class, AreaServiceImpl.class})
public class FwmfAreaAutoConfiguration {

    /**
     * 字典服务
     */
    @Bean
    public AreaService areaService(CommonDao commonDao) {
        return new AreaServiceImpl(commonDao);
    }
}
