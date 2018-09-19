package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderRGoodsGenerateSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class OrderRGoodsSqlProvider extends OrderRGoodsGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("ORDER_R_GOODS_ID", "ORDER_ID", "SHOP_ID", "STORE_ID", "GOODS_ID", "TDC_CODE_ID"
                , "TDC_CODE_PIC_URL", "TITLE_IMG", "GOODS_NAME", "GOODS_TYPE", "GOODS_PRICE", "BUY_PRICE"
                , "GOODS_STOCK", "GOODS_COUNT", "BUY_SUBTOTAL", "PROMOTION_PRICE_ID", "PROMOTION_PRICE_NAME"
                , "PROMOTION_PRICE_AMOUNT", "GOODS_PAY_PRICE", "POSTAGE_ID", "POST_PRICE", "PROMOTION_POST_ID"
                , "PROMOTION_POST_NAME", "IS_RECEIVE", "IS_REVIEWS");
        sql.FROM(DBConstOfOrder.ORDER_T_ORDER_R_GOODS);
        if (params!=null) {
            if (params.get("orderId") != null) {
                sql.WHERE("ORDER_ID=#{orderId}");
            }
        }
        return sql.toString();
    }
}