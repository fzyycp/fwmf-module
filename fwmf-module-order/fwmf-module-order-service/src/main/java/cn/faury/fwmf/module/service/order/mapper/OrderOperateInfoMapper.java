package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.OrderOperateInfoBean;
import cn.faury.fwmf.module.service.order.generate.mapper.OrderOperateInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.OrderOperateInfoSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface OrderOperateInfoMapper extends OrderOperateInfoGenerateMapper {
    @SelectProvider(type = OrderOperateInfoSqlProvider.class, method = "search")
    @ResultType(OrderOperateInfoBean.class)
    List<OrderOperateInfoBean> search(Map<String, Object> params);
}