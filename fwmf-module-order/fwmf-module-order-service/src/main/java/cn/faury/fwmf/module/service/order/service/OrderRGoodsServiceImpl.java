package cn.faury.fwmf.module.service.order.service;

import cn.faury.fwmf.module.api.order.bean.OrderRGoodsBean;
import cn.faury.fwmf.module.api.order.service.OrderRGoodsService;
import cn.faury.fwmf.module.service.order.mapper.OrderRGoodsMapper;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.List;

public class OrderRGoodsServiceImpl extends CrudBaseServiceImpl<OrderRGoodsBean, Long> implements OrderRGoodsService {
    public OrderRGoodsServiceImpl(CommonDao commonDao) {
        super(commonDao, OrderRGoodsMapper.class);
    }

    /**
     * 获取订单关联的商品列表
     *
     * @param orderId 订单ID
     * @return 商品列表
     */
    @Override
    public List<OrderRGoodsBean> getOrderRGoodsBeanByOrderId(Long orderId) {
        String state = this.mapper.getName() + ".getOrderRGoodsBeanByOrderId";
        return this.commonDao.selectList(state, orderId);
    }
}
