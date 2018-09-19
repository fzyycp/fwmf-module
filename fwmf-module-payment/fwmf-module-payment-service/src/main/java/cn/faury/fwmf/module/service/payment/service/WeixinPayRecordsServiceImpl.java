package cn.faury.fwmf.module.service.payment.service;

import cn.faury.fwmf.module.api.payment.bean.WeixinPayRecordsBean;
import cn.faury.fwmf.module.api.payment.service.WeixinPayRecordsService;
import cn.faury.fwmf.module.service.payment.mapper.WeixinPayRecordsMapper;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WeixinPayRecordsServiceImpl extends CrudBaseServiceImpl<WeixinPayRecordsBean, Long> implements WeixinPayRecordsService {
    public WeixinPayRecordsServiceImpl(CommonDao commonDao) {
        super(commonDao, WeixinPayRecordsMapper.class);
    }

    /**
     * 根据交易号获取支付记录
     *
     * @param outTradeNo 交易和
     * @return 支付记录
     */
    @Override
    public WeixinPayRecordsBean getBeanByOutTradeNo(String outTradeNo) {
        String state = this.mapper.getName() + ".getBeanByOutTradeNo";
        return this.commonDao.selectOne(state, Collections.singletonMap("outTradeNo", outTradeNo));
    }

    /**
     * 更新微信回调状态
     *
     * @param transactionId 微信交易号
     * @param resultCode   交易状态
     * @param outTradeNo       商户交易号
     * @return 支付记录
     */
    @Override
    public int updateTradeStatus(String transactionId, String resultCode, String outTradeNo) {
        String state = this.mapper.getName() + ".updateTradeStatus";
        Map<String, Object> params = new HashMap<>();
        params.put("transactionId", transactionId);
        params.put("resultCode", resultCode);
        params.put("outTradeNo", outTradeNo);
        return this.commonDao.update(state, params);
    }
}
