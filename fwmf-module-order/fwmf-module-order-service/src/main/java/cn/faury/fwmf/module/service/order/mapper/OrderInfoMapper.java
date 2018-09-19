package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.OrderInfoBean;
import cn.faury.fwmf.module.api.order.bean.OrderStateStatistics;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.OrderInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.OrderInfoSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface OrderInfoMapper extends OrderInfoGenerateMapper {

    @SelectProvider(type = OrderInfoSqlProvider.class, method = "search")
    @ResultType(OrderInfoBean.class)
    List<OrderInfoBean> search(Map<String, Object> params);

    @Update({"UPDATE", DBConstOfOrder.ORDER_T_ORDER_INFO
            , "  SET ORDER_STATE='2'"
            , "WHERE ORDER_STATE=0 AND ORDER_ID=#{orderId}"})
    int cancleOrder(Long orderId);

    @Update({"UPDATE", DBConstOfOrder.ORDER_T_ORDER_INFO
            , "  SET ORDER_STATE='3'"
            , "WHERE ORDER_STATE=2 AND ORDER_ID=#{orderId}"})
    int deleteOrder(Long orderId);

    @UpdateProvider(type = OrderInfoSqlProvider.class, method = "updateOrderInfoState")
    int updateOrderInfoState(Map<String, Object> params);

    @Update({"UPDATE", DBConstOfOrder.ORDER_T_ORDER_PAY_INFO
            , "  SET PAY_STATE=#{payState},PAY_STYLE=#{payStyle},PAY_TIME=now()"
            , "WHERE ORDER_ID=#{orderId}"})
    int updateOrderPayInfoState(Map<String, Object> params);

    @Select({"SELECT * FROM", DBConstOfOrder.ORDER_T_ORDER_INFO
            , "WHERE ORDER_CODE=#{orderCode}"})
    @ResultType(OrderInfoBean.class)
    OrderInfoBean getBeanByCode(String orderCode);

    @SelectProvider(type = OrderInfoSqlProvider.class, method = "statisticsState")
    @ResultType(OrderInfoBean.class)
    List<OrderStateStatistics> statisticsState(Map<String, Object> params);
}