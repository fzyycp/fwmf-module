package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.operation.bean.OperationRecordBean;
import cn.faury.fwmf.module.api.operation.config.Operation;
import cn.faury.fwmf.module.api.operation.service.OperationRecordService;
import cn.faury.fwmf.module.service.operation.service.OperationRecordServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 区域服务服务自动装配器
 */
@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfOperationAutoConfiguration {

    private Logger logger = LoggerFactory.getLogger(FwmfOperationAutoConfiguration.class);

    @Value("${fwmf.module.operation.types:}")
    private String types = "";

    /**
     * 操作记录服务
     */
    @Bean
    @ConditionalOnClass({OperationRecordService.class, OperationRecordServiceImpl.class})
    public OperationRecordService areaService(CommonDao commonDao) {
        if (StringUtil.isNotEmpty(types)) {
            Operation.Type[] type = Arrays.stream(types.split(","))
                    .filter(StringUtil::isNotEmpty)
                    .map(Operation.Type::parse)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList())
                    .toArray(new Operation.Type[0]);
            logger.debug("操作日志记录等级：{}", Arrays.stream(type).map(Operation.Type::getDesc).collect(Collectors.joining(",", "{", "}")));
            return new OperationRecordServiceImpl(commonDao, type);
        } else {
            logger.debug("操作日志记录默认等级：{}", Arrays.stream(OperationRecordServiceImpl.DEFAULT_LEVE).map(Operation.Type::getDesc).collect(Collectors.joining(",", "{", "}")));
            return new OperationRecordServiceImpl(commonDao);
        }
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
