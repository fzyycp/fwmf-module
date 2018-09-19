package cn.faury.fwmf.module.api.payment.bean;

import cn.faury.fwmf.module.api.payment.generate.bean.WeixinPayRecordsGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;

import java.io.Serializable;

/**
 * 微信支付请求
 */
public class WeixinPayRecordsBean extends WeixinPayRecordsGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    @Override
    public Long getPrimaryKey() {
        return this.getId();
    }
}