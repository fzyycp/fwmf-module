package cn.faury.fwmf.module.service.order.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.order.bean.PromotionInfoBean;
import cn.faury.fwmf.module.api.order.service.PromotionInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.order.mapper.PromotionInfoMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 服务实现：订单模块：优惠活动信息表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了PromotionInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class PromotionInfoServiceImpl extends CrudBaseServiceImpl<PromotionInfoBean, Long> implements PromotionInfoService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public PromotionInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, PromotionInfoMapper.class);
    }
}
