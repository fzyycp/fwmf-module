package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.school.service.SchoolInfoService;
import cn.faury.fwmf.module.api.school.service.SchoolRGradeInfoService;
import cn.faury.fwmf.module.api.school.service.SchoolRGradeRClassInfoService;
import cn.faury.fwmf.module.service.school.service.SchoolInfoServiceImpl;
import cn.faury.fwmf.module.service.school.service.SchoolRGradeInfoServiceImpl;
import cn.faury.fwmf.module.service.school.service.SchoolRGradeRClassInfoServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 字典服务服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfSchoolAutoConfiguration {

    /**
     * 学校服务
     */
    @Bean
    @ConditionalOnClass({SchoolInfoService.class, SchoolInfoServiceImpl.class})
    public SchoolInfoService schoolInfoService(CommonDao commonDao) {
        return new SchoolInfoServiceImpl(commonDao);
    }

    /**
     * 学校年级服务
     */
    @Bean
    @ConditionalOnClass({SchoolRGradeInfoService.class, SchoolRGradeInfoServiceImpl.class})
    public SchoolRGradeInfoService schoolRGradeInfoService(CommonDao commonDao) {
        return new SchoolRGradeInfoServiceImpl(commonDao);
    }

    /**
     * 学校年级班级服务
     */
    @Bean
    @ConditionalOnClass({SchoolRGradeRClassInfoService.class, SchoolRGradeRClassInfoServiceImpl.class})
    public SchoolRGradeRClassInfoService schoolRGradeRClassInfoService(CommonDao commonDao) {
        return new SchoolRGradeRClassInfoServiceImpl(commonDao);
    }
}
