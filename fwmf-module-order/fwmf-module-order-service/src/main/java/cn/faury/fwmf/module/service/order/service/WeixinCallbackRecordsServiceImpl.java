package cn.faury.fwmf.module.service.order.service;

import cn.faury.fwmf.module.api.order.bean.WeixinCallbackRecordsBean;
import cn.faury.fwmf.module.api.order.service.WeixinCallbackRecordsService;
import cn.faury.fwmf.module.service.order.mapper.WeixinCallbackRecordsMapper;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

public class WeixinCallbackRecordsServiceImpl extends CrudBaseServiceImpl<WeixinCallbackRecordsBean, Long> implements WeixinCallbackRecordsService {
    public WeixinCallbackRecordsServiceImpl(CommonDao commonDao) {
        super(commonDao, WeixinCallbackRecordsMapper.class);
    }
}
