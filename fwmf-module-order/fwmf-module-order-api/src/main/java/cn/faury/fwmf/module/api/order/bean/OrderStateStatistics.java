package cn.faury.fwmf.module.api.order.bean;

import java.io.Serializable;

/**
 * 订单状态统计
 */
public class OrderStateStatistics implements Serializable {
    private String orderState;
    private String tradeState;
    private int count;

    /**
     * 获取orderState
     *
     * @return orderState
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * 设置orderState
     *
     * @param orderState 值
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    /**
     * 获取tradeState
     *
     * @return tradeState
     */
    public String getTradeState() {
        return tradeState;
    }

    /**
     * 设置tradeState
     *
     * @param tradeState 值
     */
    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    /**
     * 获取count
     *
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置count
     *
     * @param count 值
     */
    public void setCount(int count) {
        this.count = count;
    }
}
