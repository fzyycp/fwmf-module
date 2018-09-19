package cn.faury.fwmf.module.api.order.service;


import cn.faury.fwmf.module.api.order.bean.OrderRGoodsBean;
import cn.faury.fdk.common.db.CrudBaseService;

import java.util.List;

public interface OrderRGoodsService extends CrudBaseService<OrderRGoodsBean, Long> {

    /**
     * 获取订单关联的商品列表
     *
     * @param orderId 订单ID
     * @return 商品列表
     */
    public List<OrderRGoodsBean> getOrderRGoodsBeanByOrderId(Long orderId);

}
