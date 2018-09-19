package cn.faury.fwmf.module.api.payment.service;

import cn.faury.fwmf.module.api.payment.bean.AlipayRecordsBean;
import cn.faury.fdk.common.db.CrudBaseService;

/**
 * 服务接口：
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface AlipayRecordsService extends CrudBaseService<AlipayRecordsBean, Long> {

    /**
     * 根据交易号获取支付记录
     *
     * @param outTradeNo 商户订单交易号
     * @return 支付记录
     */
    public AlipayRecordsBean getBeanByOutTradeNo(String outTradeNo);

    /**
     * 更新支付宝回调状态
     *
     * @param tradeNo 支付宝交易号
     * @param tradeStatus    交易状态
     * @param outTradeNo    交易号
     * @return 支付记录
     */
    public int updateTradeStatus(String tradeNo, String tradeStatus, String outTradeNo);

}