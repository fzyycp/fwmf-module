package cn.faury.fwmf.module.service.order.service;

import cn.faury.fwmf.module.api.order.bean.OrderInfoBean;
import cn.faury.fwmf.module.api.order.bean.OrderPayInfoBean;
import cn.faury.fwmf.module.api.order.bean.OrderRLogisticsBean;
import cn.faury.fwmf.module.api.order.service.OrderInfoService;
import cn.faury.fwmf.module.api.order.service.OrderPayInfoService;
import cn.faury.fwmf.module.api.order.service.OrderRLogisticsService;
import cn.faury.fwmf.module.service.order.mapper.OrderRLogisticsMapper;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.DateUtil;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fdk.common.utils.KdniaoTrackUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class OrderRLogisticsServiceImpl extends CrudBaseServiceImpl<OrderRLogisticsBean, Long> implements OrderRLogisticsService {

    @Autowired(required = false)
    private OrderPayInfoService orderPayInfoService;

    @Autowired(required = false)
    private OrderInfoService orderInfoService;

    public OrderRLogisticsServiceImpl(CommonDao commonDao) {
        super(commonDao, OrderRLogisticsMapper.class);
    }

    /**
     * 根据订单ID获取物流信息
     *
     * @param orderId 订单ID
     * @return 物流信息
     */
    @Override
    public List<OrderRLogisticsBean> getOrderLogisticsByOrderId(Long orderId) {
        String state = this.mapper.getName() + ".getOrderLogisticsByOrderId";
        return this.commonDao.selectList(state, orderId);
    }

    /**
     * 更新订单的物流状态（所有跟踪记录的状态都为最后状态）
     *
     * @param newState 新的状态
     * @param orderId  订单ID
     * @return 成功更新条数
     */
    @Override
    public int updateOrderLogisticsState(String newState, Long orderId) {
        String state = this.mapper.getName() + ".updateOrderLogisticsState";
        Map<String, Object> params = new HashMap<>();
        params.put("orderId", orderId);
        params.put("newState", newState);
        return this.commonDao.update(state, params);
    }

    /**
     * 支付成功后，初始化订单物流信息
     *
     * @param orderId 订单ID
     */
    @Override
    public void initLogisticsAfterPaySuccess(Long orderId) {
        OrderPayInfoBean orderPayInfoBean = orderPayInfoService.getBeanByOrderId(orderId);
        // 已支付状态订单
        if (orderPayInfoBean != null && OrderInfoBean.OrderState.PAID.getCode().equals(orderPayInfoBean.getPayState())) {
            OrderRLogisticsBean bean1 = new OrderRLogisticsBean();
            bean1.setOrderId(orderPayInfoBean.getOrderId());
            bean1.setAcceptTime(DateUtil.formatDateTime(orderPayInfoBean.getPayTime()));
            bean1.setAcceptStation("订单支付成功，等待系统确认");
            bean1.setState(OrderRLogisticsBean.LogisticsState.NO_TRACE.getCode());
            this.insert(bean1);
            OrderRLogisticsBean bean2 = new OrderRLogisticsBean();
            bean2.setOrderId(orderPayInfoBean.getOrderId());
            bean2.setAcceptTime(DateUtil.getCurrentDateTimeStr());
            bean2.setAcceptStation("商家正在准备配货，等待发货");
            bean2.setState(OrderRLogisticsBean.LogisticsState.NO_TRACE.getCode());
            this.insert(bean2);
        }
    }

    /**
     * 通过快递鸟获取物流跟踪列表
     *
     * @param eBusinessId 快递鸟ID
     * @param appKey      快递鸟KEY
     * @param expressCode 快递公司编码
     * @param trackNumber 运单号
     * @return 物流跟踪列表
     */
    @Override
    public List<OrderRLogisticsBean> queryKdniaoTrackList(String eBusinessId, String appKey, String expressCode, String trackNumber) {
        // 倒序
        List<OrderRLogisticsBean> result = new ArrayList<>();
        KdniaoTrackUtil kdniaoTrackUtil = new KdniaoTrackUtil(eBusinessId, appKey);
        try {
            String trackJson = kdniaoTrackUtil.getOrderTracesByJson(expressCode, trackNumber);

            JSONObject resultJson = JsonUtil.jsonToObject(trackJson, JSONObject.class);//JSONObject.fromObject(trackJson);
            JSONArray traces = resultJson.getJSONArray("Traces");
            for (int i = 0; i < traces.size(); i++) {
                Map<String, String> m = (Map<String, String>) traces.get(i);
                OrderRLogisticsBean bean = new OrderRLogisticsBean();
                bean.setInsertTime(DateUtil.getCurrentDate());
                bean.setAcceptTime(m.get("AcceptTime"));
                bean.setAcceptStation(m.get("AcceptStation"));
                bean.setState(resultJson.get("State").toString());
                result.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 倒序排列
        result.sort((bean1, bean2) -> bean2.getAcceptTime().compareTo(bean1.getAcceptTime()));
        return result;
    }

    /**
     * 查询并保存订单物流跟踪信息
     *
     * @param orderId 订单ID
     * @return 新的物流跟踪信息
     */
    @Override
    public List<OrderRLogisticsBean> queryTrackAndInsert(Long orderId, String eBusinessId, String appKey) {
        AssertUtil.assertNotNull(orderId, "订单ID不合法");
        OrderInfoBean orderInfoBean = orderInfoService.getBeanById(orderId);
        AssertUtil.assertNotNull(orderInfoBean, "订单信息不存在");

        List<OrderRLogisticsBean> logisticsBeanList = this.getOrderLogisticsByOrderId(orderInfoBean.getOrderId());
        if (logisticsBeanList != null && logisticsBeanList.size() > 0) {
            // 查看最近一条记录状态，如果是3-签收或者4-问题件则直接从数据库中查询
            Optional<OrderRLogisticsBean.LogisticsState> lastState = OrderRLogisticsBean.LogisticsState.parse(logisticsBeanList.get(0).getState());
            if (lastState.isPresent() && (
                    lastState.get() == OrderRLogisticsBean.LogisticsState.WAITING
                            || lastState.get() == OrderRLogisticsBean.LogisticsState.EN_ROUTE)) {
                // 待揽件和在途则去查询最新快递信息
                List<OrderRLogisticsBean> tracks = queryKdniaoTrackList(eBusinessId, appKey, orderInfoBean.getExpressCode(), orderInfoBean.getTrackNumber());
                if (tracks.size() > 0) {
                    tracks.forEach(track -> track.setOrderId(orderInfoBean.getOrderId()));
                    // 是3-签收或者4-问题件状态，表示最终状态，插入数据库，下次不再从快递鸟获取
                    if (OrderRLogisticsBean.LogisticsState.SIGNED_IN.getCode().equals(tracks.get(0).getState())
                            || OrderRLogisticsBean.LogisticsState.PROBLEM.getCode().equals(tracks.get(0).getState())) {
                        tracks.forEach(this::insert);
                        this.updateOrderLogisticsState(tracks.get(0).getState(), orderInfoBean.getOrderId());
                    }
                }
                logisticsBeanList.addAll(0, tracks);
            }
        }
        return logisticsBeanList;
    }
}
