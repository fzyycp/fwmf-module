package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.GoodsStockGenerateSqlProvider;

import java.util.Map;

public class GoodsRStockSqlProvider extends GoodsStockGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        return "SELECT * FROM " + DBConstOfOrder.ORDER_T_GOODS_STOCK_INFO;
    }
}
