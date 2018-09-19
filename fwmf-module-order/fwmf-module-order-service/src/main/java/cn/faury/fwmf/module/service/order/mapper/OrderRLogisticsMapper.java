package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.OrderRLogisticsBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.OrderRLogisticsGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.OrderRLogisticsSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface OrderRLogisticsMapper extends OrderRLogisticsGenerateMapper {

    @SelectProvider(type = OrderRLogisticsSqlProvider.class, method = "search")
    @ResultType(OrderRLogisticsBean.class)
    List<OrderRLogisticsBean> search(Map<String, Object> params);

    @Select({"SELECT ID, ORDER_ID, INSERT_TIME, ACCEPT_TIME, ACCEPT_STATION, STATE",
            "   FROM", DBConstOfOrder.ORDER_T_ORDER_R_LOGISTICS
            , "WHERE ORDER_ID=#{orderId}"
            , "ORDER BY INSERT_TIME DESC,ACCEPT_TIME DESC"})
    @ResultType(OrderRLogisticsBean.class)
    List<OrderRLogisticsBean> getOrderLogisticsByOrderId(Long orderId);

    @Update({"UPDATE", DBConstOfOrder.ORDER_T_ORDER_R_LOGISTICS
            , "SET STATE=#{newState}"
            , "WHERE ORDER_ID=#{orderId}"})
    int updateOrderLogisticsState(Map<String, Object> params);
}
