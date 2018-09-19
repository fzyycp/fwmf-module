package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.OrderPayInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.OrderPayInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.OrderPayInfoSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface OrderPayInfoMapper extends OrderPayInfoGenerateMapper {
    @SelectProvider(type = OrderPayInfoSqlProvider.class, method = "search")
    @ResultType(OrderPayInfoBean.class)
    List<OrderPayInfoBean> search(Map<String, Object> params);

    @Select({"SELECT ID, ORDER_ID, PAY_AMOUNT, PAY_STATE, PAY_TIME, PAY_STYLE, CREATE_PERSON" +
            ", CREATE_PERSON_NAME, CREATE_TIME, UPDATE_PERSON, UPDATE_PERSON_NAME, UPDATE_TIME, DZ_STATE"
            , " FROM", DBConstOfOrder.ORDER_T_ORDER_PAY_INFO
            , "WHERE ORDER_ID=#{orderId}"
            , "LIMIT 1"})
    @ResultType(OrderPayInfoBean.class)
    OrderPayInfoBean getBeanByOrderId(Long orderId);

    @UpdateProvider(type = OrderPayInfoSqlProvider.class, method = "payOrderPayInfo")
    int payOrderPayInfo(Map<String, Object> params);

    @UpdateProvider(type = OrderPayInfoSqlProvider.class, method = "cancelOrderPayInfo")
    int cancelOrderPayInfo(Map<String, Object> params);


}