package cn.faury.fwmf.module.service.order.service;

import cn.faury.fwmf.module.api.order.bean.OrderOperateInfoBean;
import cn.faury.fwmf.module.api.order.service.OrderOperateInfoService;
import cn.faury.fwmf.module.service.order.mapper.OrderOperateInfoMapper;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

public class OrderOperateInfoServiceImpl extends CrudBaseServiceImpl<OrderOperateInfoBean, Long> implements OrderOperateInfoService {
    public OrderOperateInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, OrderOperateInfoMapper.class);
    }
}
