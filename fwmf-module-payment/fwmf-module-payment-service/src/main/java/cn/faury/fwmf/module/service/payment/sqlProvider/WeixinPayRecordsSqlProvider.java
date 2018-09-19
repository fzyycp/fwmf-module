package cn.faury.fwmf.module.service.payment.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfPayment;
import cn.faury.fwmf.module.service.payment.generate.sqlProvider.WeixinPayRecordsGenerateSqlProvider;

import java.util.Map;

public class WeixinPayRecordsSqlProvider extends WeixinPayRecordsGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        return "SELECT * FROM " + DBConstOfPayment.PAYMENT_T_WEIXIN_PAY_RECORDS;
    }

}
