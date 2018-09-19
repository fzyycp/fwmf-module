package cn.faury.fwmf.module.service.order.service;

import cn.faury.fwmf.module.api.order.bean.OrderInfoBean;
import cn.faury.fwmf.module.api.order.bean.OrderPayInfoBean;
import cn.faury.fwmf.module.api.order.service.OrderPayInfoService;
import cn.faury.fwmf.module.service.order.mapper.OrderPayInfoMapper;
import cn.faury.fdk.common.utils.DateUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class OrderPayInfoServiceImpl extends CrudBaseServiceImpl<OrderPayInfoBean, Long> implements OrderPayInfoService {
    public OrderPayInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, OrderPayInfoMapper.class);
    }

    /**
     * 根据订单ID获取订单支付记录
     *
     * @param orderId 订单ID
     * @return 订单支付记录
     */
    @Override
    public OrderPayInfoBean getBeanByOrderId(Long orderId) {
        String state = this.mapper.getName() + ".getBeanByOrderId";
        return this.commonDao.selectOne(state, orderId);
    }

    /**
     * 创建订单支付记录
     *
     * @param orderInfoBean 订单信息
     * @return 成功条数
     */
    @Override
    public Long createOrderPayInfo(final OrderInfoBean orderInfoBean) {
        OrderPayInfoBean orderPayInfoBean = new OrderPayInfoBean();
        orderPayInfoBean.setOrderId(orderInfoBean.getOrderId());
        orderPayInfoBean.setPayAmount(orderInfoBean.getOrderPayPrice());
        orderPayInfoBean.setPayState(orderInfoBean.getOrderState());
        orderPayInfoBean.setCreatePerson(orderInfoBean.getBuyerId());
        orderPayInfoBean.setCreatePersonName(orderInfoBean.getBuyerLogin());
        orderPayInfoBean.setCreateTime(DateUtil.getCurrentDate());
        return this.insert(orderPayInfoBean);
    }

    /**
     * 支付订单
     *
     * @param orderId        订单ID
     * @param payStyle       支付方式
     * @param updateUserId   支付人ID
     * @param updateUserName 支付人登录名
     * @return 成功更新条数
     */
    @Override
    public int payOrderPayInfo(final Long orderId, OrderPayInfoBean.PayStyle payStyle, Long updateUserId, String updateUserName) {
        String state = this.mapper.getName() + ".payOrderPayInfo";
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("payStyle", payStyle.getCode());
        params.put("updatePerson", updateUserId);
        params.put("updatePersonName", updateUserName);
        return this.commonDao.update(state, params);
    }

    /**
     * 取消订单
     *
     * @param orderId        订单ID
     * @param updateUserId   支付人ID
     * @param updateUserName 支付人登录名
     * @return 成功更新条数
     */
    @Override
    public int cancelOrderPayInfo(final Long orderId, Long updateUserId, String updateUserName) {
        String state = this.mapper.getName() + ".cancelOrderPayInfo";
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("updatePerson", updateUserId);
        params.put("updatePersonName", updateUserName);
        return this.commonDao.update(state, params);
    }
}
