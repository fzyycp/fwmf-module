package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.order.bean.OrderRLogisticsBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.OrderRLogisticsGenerateMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：订单物流信息表
 *
 * <pre>
 *     OrderRLogisticsGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自OrderRLogisticsGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface OrderRLogisticsMapper extends OrderRLogisticsGenerateMapper {

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
