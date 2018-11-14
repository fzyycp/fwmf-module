package cn.faury.fwmf.module.service.order.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.order.bean.OrderOperateInfoBean;
import cn.faury.fwmf.module.api.order.service.OrderOperateInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.order.mapper.OrderOperateInfoMapper;

/**
 * 服务实现：订单操作日志表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了OrderOperateInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OrderOperateInfoServiceImpl extends CrudBaseServiceImpl<OrderOperateInfoBean, Long> implements OrderOperateInfoService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public OrderOperateInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, OrderOperateInfoMapper.class);
    }
}
