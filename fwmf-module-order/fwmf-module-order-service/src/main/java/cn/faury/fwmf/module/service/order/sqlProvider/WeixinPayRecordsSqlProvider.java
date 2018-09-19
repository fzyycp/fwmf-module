package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.WeixinPayRecordsGenerateSqlProvider;

import java.util.Map;

public class WeixinPayRecordsSqlProvider extends WeixinPayRecordsGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        return "SELECT * FROM " + DBConstOfOrder.PAYMENT_T_WEIXIN_PAY_RECORDS;
    }

}
