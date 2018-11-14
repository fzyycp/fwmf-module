package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.order.bean.OrderRGoodsBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.OrderRGoodsGenerateMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Mybatis Mapper：订单商品关联表
 *
 * <pre>
 *     OrderRGoodsGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自OrderRGoodsGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface OrderRGoodsMapper extends OrderRGoodsGenerateMapper {

    @Select({"SELECT ORDER_R_GOODS_ID, ORDER_ID, SHOP_ID, STORE_ID, GOODS_ID, TDC_CODE_ID, TDC_CODE_PIC_URL" +
            "        , TITLE_IMG, GOODS_NAME, GOODS_TYPE, GOODS_PRICE, BUY_PRICE, GOODS_STOCK, GOODS_COUNT, BUY_SUBTOTAL" +
            "        , PROMOTION_PRICE_ID, PROMOTION_PRICE_NAME, PROMOTION_PRICE_AMOUNT, GOODS_PAY_PRICE, POSTAGE_ID" +
            "        , POST_PRICE, PROMOTION_POST_ID, PROMOTION_POST_NAME, IS_RECEIVE, IS_REVIEWS",
            "  FROM", DBConstOfOrder.ORDER_T_ORDER_R_GOODS,
            " WHERE ORDER_ID=#{orderId}"})
    @ResultType(OrderRGoodsBean.class)
    List<OrderRGoodsBean> getOrderRGoodsBeanByOrderId(Long orderId);

}