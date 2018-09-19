package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderRLogisticsGenerateSqlProvider;

import java.util.Map;

public class OrderRLogisticsSqlProvider extends OrderRLogisticsGenerateSqlProvider {

    public String search(Map<String, Object> params) {
        return "SELECT * FROM "+DBConstOfOrder.ORDER_T_ORDER_R_LOGISTICS;
    }
}
