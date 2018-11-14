package cn.faury.fwmf.module.api.order.service;


import cn.faury.fwmf.module.api.order.bean.OrderInfoBean;
import cn.faury.fwmf.module.api.order.bean.OrderPayInfoBean;
import cn.faury.fdk.common.db.CrudBaseService;

/**
 * 服务接口：订单支付信息表
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface OrderPayInfoService extends CrudBaseService<OrderPayInfoBean, Long> {

    /**
     * 根据订单ID获取订单支付记录
     * @param orderId 订单ID
     * @return 订单支付记录
     */
    public OrderPayInfoBean getBeanByOrderId(Long orderId);

    /**
     * 创建订单支付记录
     *
     * @param orderInfoBean 订单信息
     * @return 记录ID
     */
    public Long createOrderPayInfo(final OrderInfoBean orderInfoBean);

    /**
     * 支付订单
     *
     * @param orderId        订单ID
     * @param payStyle       支付方式
     * @param updateUserId   支付人ID
     * @param updateUserName 支付人登录名
     * @return 成功更新条数
     */
    public int payOrderPayInfo(final Long orderId, final OrderPayInfoBean.PayStyle payStyle, final Long updateUserId, final String updateUserName);

    /**
     * 取消订单
     *
     * @param orderId        订单ID
     * @param updateUserId   支付人ID
     * @param updateUserName 支付人登录名
     * @return 成功更新条数
     */
    public int cancelOrderPayInfo(final Long orderId, final Long updateUserId, final String updateUserName);
}
