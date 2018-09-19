package cn.faury.fwmf.module.api.order.service;


import cn.faury.fwmf.module.api.order.bean.OrderInfoBean;
import cn.faury.fwmf.module.api.order.bean.OrderRGoodsBeanEnable;
import cn.faury.fwmf.module.api.order.bean.OrderStateStatistics;
import cn.faury.fwmf.module.api.payment.bean.AlipayCallbackRecordsBean;
import cn.faury.fwmf.module.api.payment.bean.WeixinCallbackRecordsBean;
import cn.faury.fdk.common.anotation.NonNull;
import cn.faury.fdk.common.db.CrudBaseService;

import java.math.BigDecimal;
import java.util.List;

public interface OrderInfoService extends CrudBaseService<OrderInfoBean, Long> {

    /**
     * 预处理订单，根据商品清单计算订单基本数据
     * <pre>
     *     返回数据：
     *          商品总数量、订单运费、商品总金额、订单总金额
     *          商品支付总金额、运费支付总金额、订单支付总金额
     * </pre>
     *
     * @param goodsList 商品列表
     * @param postPrice 运费
     */
    public OrderInfoBean preProcessOrder(List<? extends OrderRGoodsBeanEnable> goodsList, @NonNull BigDecimal postPrice);

    /**
     * 创建订单
     *
     * @param orderInfoBean 订单信息
     * @return 订单ID
     */
    public Long createOrder(OrderInfoBean orderInfoBean);

    /**
     * 取消订单
     *
     * @param orderId 订单ID
     * @return 成功取消条数
     */
    public int cancleOrder(final Long orderId, final Long updateUserId, final String updateUserName);

    /**
     * 删除订单
     *
     * @param orderId 订单ID
     * @return 成功删除条数
     */
    public int deleteOrder(final Long orderId, final Long updateUserId, final String updateUserName);

    /**
     * 订单支付成功
     *
     * @param weixinCallbackRecordsBean 支付回调参数
     * @return 成功修改条数
     */
    public int payOrder(final WeixinCallbackRecordsBean weixinCallbackRecordsBean);

    /**
     * 订单支付成功
     *
     * @param alipayCallbackRecordsBean 支付回调参数
     * @return 成功修改条数
     */
    public int payOrder(final AlipayCallbackRecordsBean alipayCallbackRecordsBean);

    /**
     * 平台支付订单
     *
     * @param orderInfoBean 订单信息
     * @return 成功修改条数
     */
    public int payOrderByPlatform(final OrderInfoBean orderInfoBean);

    /**
     * 订单发货
     *
     * @param orderInfoBean 订单信息
     * @return 修改订单条数
     */
    public int shipOrder(final OrderInfoBean orderInfoBean);

    /**
     * 确认收货
     *
     * @param orderInfoBean  订单信息
     * @param updatePersonId 修改用户ID
     * @return 修改订单条数
     */
    public int confirmReceipt(final OrderInfoBean orderInfoBean, final Long updatePersonId);

    /**
     * 评价订单
     *
     * @param orderInfoBean  订单信息
     * @param updatePersonId 修改用户ID
     * @return 修改订单条数
     */
    public int evaluateOrder(final OrderInfoBean orderInfoBean, final Long updatePersonId);

    /**
     * 订单改价
     *
     * @param orderInfoBean 订单信息
     * @return 修改订单条数
     */
    public int updatePayPrice(final OrderInfoBean orderInfoBean);

    /**
     * 根据订单编码获取订单信息
     *
     * @param orderCode 订单编码
     * @return 订单对象
     */
    public OrderInfoBean getBeanByCode(final String orderCode);

    /**
     * 统计用户订单状态
     *
     * @param userId  用户ID
     * @param storeId 商铺ID
     * @return 状态分布
     */
    public List<OrderStateStatistics> statisticsState(final Long userId, final Long storeId);
}
