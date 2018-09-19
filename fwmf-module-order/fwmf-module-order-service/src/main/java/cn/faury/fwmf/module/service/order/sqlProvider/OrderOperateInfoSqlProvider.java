package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderOperateInfoGenerateSqlProvider;

import java.util.Map;

public class OrderOperateInfoSqlProvider extends OrderOperateInfoGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        return "SELECT * FROM " + DBConstOfOrder.ORDER_T_ORDER_OPERATE_INFO;
    }

}