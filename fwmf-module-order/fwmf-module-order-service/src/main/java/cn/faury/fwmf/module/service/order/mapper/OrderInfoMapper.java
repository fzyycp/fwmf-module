package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.order.bean.OrderInfoBean;
import cn.faury.fwmf.module.api.order.bean.OrderStateStatistics;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.OrderInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.OrderInfoSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：订单信息表
 *
 * <pre>
 *     OrderInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自OrderInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface OrderInfoMapper extends OrderInfoGenerateMapper {

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