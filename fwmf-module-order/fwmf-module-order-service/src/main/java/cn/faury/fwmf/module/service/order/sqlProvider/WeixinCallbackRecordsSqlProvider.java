package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.WeixinCallbackRecordsGenerateSqlProvider;

import java.util.Map;

public class WeixinCallbackRecordsSqlProvider extends WeixinCallbackRecordsGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        return "SELECT * FROM " + DBConstOfOrder.PAYMENT_T_WEIXIN_CALLBACK_RECORDS;
    }

}
