package cn.faury.fwmf.module.service.order.service;

import cn.faury.fwmf.module.api.order.bean.PromotionInfoBean;
import cn.faury.fwmf.module.api.order.service.PromotionInfoService;
import cn.faury.fwmf.module.service.order.mapper.PromotionInfoMapper;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PromotionInfoServiceImpl extends CrudBaseServiceImpl<PromotionInfoBean, Long> implements PromotionInfoService {

    public PromotionInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, PromotionInfoMapper.class);
    }

    /**
     * 根据ID获取优惠信息列表
     *
     * @param ids id列表
     * @return 优惠信息
     */
    @Override
    public List<PromotionInfoBean> getBeanListByIds(Collection<Long> ids) {
        String state = this.mapper.getName() + ".getBeanListByIds";
        return this.commonDao.selectList(state, Collections.singletonMap("ids", new ArrayList<>(ids)));
    }
}
