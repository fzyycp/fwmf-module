package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.PromotionInfoBean;
import cn.faury.fwmf.module.service.order.generate.mapper.PromotionInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.PromotionInfoSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;
import java.util.Set;

@AutoScannedMapper
public interface PromotionInfoMapper extends PromotionInfoGenerateMapper {

    @SelectProvider(type = PromotionInfoSqlProvider.class, method = "search")
    @ResultType(PromotionInfoBean.class)
    List<PromotionInfoBean> search(Map<String, Object> params);

    @SelectProvider(type = PromotionInfoSqlProvider.class, method = "getBeanListByIds")
    @ResultType(PromotionInfoBean.class)
    List<PromotionInfoBean> getBeanListByIds(Map<String, Object> params);
}