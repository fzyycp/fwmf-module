package cn.faury.fwmf.module.api.order.service;


import cn.faury.fwmf.module.api.order.bean.OrderRGoodsBean;
import cn.faury.fdk.common.db.CrudBaseService;

import java.util.List;

/**
 * 服务接口：订单商品关联表
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface OrderRGoodsService extends CrudBaseService<OrderRGoodsBean, Long> {

    /**
     * 获取订单关联的商品列表
     *
     * @param orderId 订单ID
     * @return 商品列表
     */
    public List<OrderRGoodsBean> getOrderRGoodsBeanByOrderId(Long orderId);

}
