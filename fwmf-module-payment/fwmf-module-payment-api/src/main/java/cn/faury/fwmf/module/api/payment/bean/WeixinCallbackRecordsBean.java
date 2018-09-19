package cn.faury.fwmf.module.api.payment.bean;

import cn.faury.fwmf.module.api.payment.generate.bean.WeixinCallbackRecordsGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;

import java.io.Serializable;

/**
 * 微信支付回调
 */
public class WeixinCallbackRecordsBean extends WeixinCallbackRecordsGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    @Override
    public Long getPrimaryKey() {
        return this.getId();
    }
}