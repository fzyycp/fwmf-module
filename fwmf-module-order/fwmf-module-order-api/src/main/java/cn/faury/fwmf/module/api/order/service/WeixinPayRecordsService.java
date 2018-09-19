package cn.faury.fwmf.module.api.order.service;

import cn.faury.fwmf.module.api.order.bean.WeixinPayRecordsBean;
import cn.faury.fdk.common.db.CrudBaseService;

public interface WeixinPayRecordsService extends CrudBaseService<WeixinPayRecordsBean, Long> {

    /**
     * 根据交易号获取支付记录
     *
     * @param outTradeNo 商户订单交易号
     * @return 支付记录
     */
    public WeixinPayRecordsBean getBeanByOutTradeNo(String outTradeNo);

    /**
     * 更新微信回调状态
     *
     * @param transactionId 微信交易号
     * @param resultCode    交易状态
     * @param outTradeNo    交易号
     * @return 支付记录
     */
    public int updateTradeStatus(String transactionId, String resultCode, String outTradeNo);
}
