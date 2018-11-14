package cn.faury.fwmf.module.service.order.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.order.bean.OrderRGoodsBean;
import cn.faury.fwmf.module.api.order.service.OrderRGoodsService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.order.mapper.OrderRGoodsMapper;

import java.util.List;

/**
 * 服务实现：订单商品关联表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了OrderRGoodsService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OrderRGoodsServiceImpl extends CrudBaseServiceImpl<OrderRGoodsBean, Long> implements OrderRGoodsService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
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
