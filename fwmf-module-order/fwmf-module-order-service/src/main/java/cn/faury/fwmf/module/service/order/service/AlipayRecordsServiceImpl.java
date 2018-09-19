package cn.faury.fwmf.module.service.order.service;

import cn.faury.fwmf.module.api.order.bean.AlipayRecordsBean;
import cn.faury.fwmf.module.api.order.service.AlipayRecordsService;
import cn.faury.fwmf.module.service.order.mapper.AlipayRecordsMapper;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务实现：
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了AlipayRecordsService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class AlipayRecordsServiceImpl extends CrudBaseServiceImpl<AlipayRecordsBean, Long> implements AlipayRecordsService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public AlipayRecordsServiceImpl(CommonDao commonDao) {
        super(commonDao, AlipayRecordsMapper.class);
    }

    /**
     * 根据交易号获取支付记录
     *
     * @param outTradeNo 商户订单交易号
     * @return 支付记录
     */
    @Override
    public AlipayRecordsBean getBeanByOutTradeNo(String outTradeNo) {
        String state = this.mapper.getName() + ".getBeanByOutTradeNo";
        return this.commonDao.selectOne(state, Collections.singletonMap("outTradeNo", outTradeNo));
    }

    /**
     * 更新支付宝回调状态
     *
     * @param alipayTradeNo     支付宝交易号
     * @param tradeStatus 交易状态
     * @param outTradeNo  交易号
     * @return 支付记录
     */
    @Override
    public int updateTradeStatus(String alipayTradeNo, String tradeStatus, String outTradeNo) {
        String state = this.mapper.getName() + ".updateTradeStatus";
        Map<String, Object> params = new HashMap<>();
        params.put("alipayTradeNo", alipayTradeNo);
        params.put("tradeStatus", tradeStatus);
        params.put("outTradeNo", outTradeNo);
        return this.commonDao.update(state, params);
    }
}