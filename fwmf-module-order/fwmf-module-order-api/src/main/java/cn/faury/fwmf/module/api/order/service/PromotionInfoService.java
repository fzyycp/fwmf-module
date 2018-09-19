package cn.faury.fwmf.module.api.order.service;

import cn.faury.fwmf.module.api.order.bean.PromotionInfoBean;
import cn.faury.fdk.common.db.CrudBaseService;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface PromotionInfoService extends CrudBaseService<PromotionInfoBean, Long> {
    /**
     * 根据ID获取优惠信息列表
     *
     * @param ids id列表
     * @return 优惠信息
     */
    public List<PromotionInfoBean> getBeanListByIds(Collection<Long> ids);
}
