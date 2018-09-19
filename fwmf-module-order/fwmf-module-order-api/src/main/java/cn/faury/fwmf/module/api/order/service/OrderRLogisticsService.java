package cn.faury.fwmf.module.api.order.service;

import cn.faury.fwmf.module.api.order.bean.OrderRLogisticsBean;
import cn.faury.fdk.common.db.CrudBaseService;

import java.util.List;

public interface OrderRLogisticsService extends CrudBaseService<OrderRLogisticsBean, Long> {

    /**
     * 根据订单ID获取物流信息
     *
     * @param orderId 订单ID
     * @return 物流信息
     */
    public List<OrderRLogisticsBean> getOrderLogisticsByOrderId(Long orderId);

    /**
     * 更新订单的物流状态（所有跟踪记录的状态都为最后状态）
     *
     * @param newState   新的状态
     * @param orderId 订单ID
     * @return 成功更新条数
     */
    public int updateOrderLogisticsState(String newState, Long orderId);

    /**
     * 支付成功后，初始化订单物流信息
     *
     * @param orderId 订单ID
     */
    public void initLogisticsAfterPaySuccess(Long orderId);

    /**
     * 通过快递鸟获取物流跟踪列表
     *
     * @param eBusinessId 快递鸟ID
     * @param appKey      快递鸟KEY
     * @param expressCode 快递公司编码
     * @param trackNumber 运单号
     * @return 物流跟踪列表
     */
    public List<OrderRLogisticsBean> queryKdniaoTrackList(String eBusinessId, String appKey, String expressCode, String trackNumber);

    /**
     * 查询并保存订单物流跟踪信息
     *
     * @param eBusinessId 快递鸟ID
     * @param appKey      快递鸟KEY
     * @param orderId     订单ID
     * @return 新的物流跟踪信息
     */
    public List<OrderRLogisticsBean> queryTrackAndInsert(Long orderId, String eBusinessId, String appKey);
}
