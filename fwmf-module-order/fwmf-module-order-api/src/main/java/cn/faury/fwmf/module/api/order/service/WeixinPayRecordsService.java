package cn.faury.fwmf.module.api.order.service;

import cn.faury.fwmf.module.api.order.bean.WeixinPayRecordsBean;
import cn.faury.fdk.common.db.CrudBaseService;

/**
 * 服务接口：微信支付请求记录
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
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
