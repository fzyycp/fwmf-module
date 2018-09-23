package cn.faury.fwmf.module.service.order.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.order.bean.WeixinPayRecordsBean;
import cn.faury.fwmf.module.api.order.service.WeixinPayRecordsService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.order.mapper.WeixinPayRecordsMapper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务实现：微信支付请求记录
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了WeixinPayRecordsService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class WeixinPayRecordsServiceImpl extends CrudBaseServiceImpl<WeixinPayRecordsBean, Long> implements WeixinPayRecordsService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
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
     * @param resultCode    交易状态
     * @param outTradeNo    商户交易号
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
