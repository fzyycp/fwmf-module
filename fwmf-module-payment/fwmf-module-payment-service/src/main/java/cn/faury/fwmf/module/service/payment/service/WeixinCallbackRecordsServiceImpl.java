package cn.faury.fwmf.module.service.payment.service;

import cn.faury.fwmf.module.api.payment.bean.WeixinCallbackRecordsBean;
import cn.faury.fwmf.module.api.payment.service.WeixinCallbackRecordsService;
import cn.faury.fwmf.module.service.payment.mapper.WeixinCallbackRecordsMapper;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

public class WeixinCallbackRecordsServiceImpl extends CrudBaseServiceImpl<WeixinCallbackRecordsBean, Long> implements WeixinCallbackRecordsService {
    public WeixinCallbackRecordsServiceImpl(CommonDao commonDao) {
        super(commonDao, WeixinCallbackRecordsMapper.class);
    }
}
