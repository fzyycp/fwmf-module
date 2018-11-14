package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.order.bean.OrderPayInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.OrderPayInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.OrderPayInfoSqlProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.Map;

/**
 * Mybatis Mapper：订单支付信息表
 *
 * <pre>
 *     OrderPayInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自OrderPayInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface OrderPayInfoMapper extends OrderPayInfoGenerateMapper {

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