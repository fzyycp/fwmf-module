package cn.faury.fwmf.module.service.payment.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfPayment;
import cn.faury.fwmf.module.service.payment.generate.sqlProvider.WeixinCallbackRecordsGenerateSqlProvider;

import java.util.Map;

public class WeixinCallbackRecordsSqlProvider extends WeixinCallbackRecordsGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        return "SELECT * FROM " + DBConstOfPayment.PAYMENT_T_WEIXIN_CALLBACK_RECORDS;
    }

}
