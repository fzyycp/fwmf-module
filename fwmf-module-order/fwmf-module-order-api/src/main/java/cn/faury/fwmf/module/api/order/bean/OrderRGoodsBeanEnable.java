package cn.faury.fwmf.module.api.order.bean;

import java.math.BigDecimal;

/**
 * 可以作为订单商品的基本结构
 */
public interface OrderRGoodsBeanEnable {
    /**
     * 获取商品数量
     */
    public Integer getGoodsCount();

    /**
     * 获取购买总金额
     */
    public BigDecimal getBuySubtotal();

    /**
     * 保存计算完优惠信息后的付款总金额
     * @param goodsPayPrice 商品支付价格
     */
    public void setGoodsPayPrice(BigDecimal goodsPayPrice);
    /**
     * 获取价格活动ID
     */
    public Long getPromotionPriceId();

    /**
     * 获取邮费ID
     */
    public Long getPostageId();

    /**
     * 获取邮费活动ID
     */
    public Long getPromotionPostId();

    /**
     * 获取商品类型
     * @return 商品类型
     */
    public String getGoodsType();
}
