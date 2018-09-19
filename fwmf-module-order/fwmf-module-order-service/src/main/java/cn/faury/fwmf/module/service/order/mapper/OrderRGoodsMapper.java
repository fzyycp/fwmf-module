package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.OrderRGoodsBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.OrderRGoodsGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.OrderRGoodsSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface OrderRGoodsMapper extends OrderRGoodsGenerateMapper {
    @SelectProvider(type = OrderRGoodsSqlProvider.class, method = "search")
    @ResultType(OrderRGoodsBean.class)
    List<OrderRGoodsBean> search(Map<String, Object> params);

    @Select({"SELECT ORDER_R_GOODS_ID, ORDER_ID, SHOP_ID, STORE_ID, GOODS_ID, TDC_CODE_ID, TDC_CODE_PIC_URL" +
            "        , TITLE_IMG, GOODS_NAME, GOODS_TYPE, GOODS_PRICE, BUY_PRICE, GOODS_STOCK, GOODS_COUNT, BUY_SUBTOTAL" +
            "        , PROMOTION_PRICE_ID, PROMOTION_PRICE_NAME, PROMOTION_PRICE_AMOUNT, GOODS_PAY_PRICE, POSTAGE_ID" +
            "        , POST_PRICE, PROMOTION_POST_ID, PROMOTION_POST_NAME, IS_RECEIVE, IS_REVIEWS",
            "  FROM", DBConstOfOrder.ORDER_T_ORDER_R_GOODS,
            " WHERE ORDER_ID=#{orderId}"})
    @ResultType(OrderRGoodsBean.class)
    List<OrderRGoodsBean> getOrderRGoodsBeanByOrderId(Long orderId);

}