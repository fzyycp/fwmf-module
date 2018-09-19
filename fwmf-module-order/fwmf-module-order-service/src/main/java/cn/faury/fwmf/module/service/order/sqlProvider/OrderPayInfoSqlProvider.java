package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.api.order.bean.OrderInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderPayInfoGenerateSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class OrderPayInfoSqlProvider extends OrderPayInfoGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        return "SELECT * FROM " + DBConstOfOrder.ORDER_T_ORDER_PAY_INFO;
    }

    public String payOrderPayInfo(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.UPDATE(DBConstOfOrder.ORDER_T_ORDER_PAY_INFO);
        sql.SET("PAY_STATE='" + OrderInfoBean.OrderState.PAID.getCode() + "'");
        sql.SET("PAY_TIME=now()", "PAY_STYLE=#{payStyle}");
        sql.SET("UPDATE_PERSON=#{updatePerson}", "UPDATE_PERSON_NAME=#{updatePersonName}", "UPDATE_TIME=now()");
        sql.WHERE("ORDER_ID=#{orderId}");
        return sql.toString();
    }

    public String cancelOrderPayInfo(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.UPDATE(DBConstOfOrder.ORDER_T_ORDER_PAY_INFO);
        sql.SET("PAY_STATE='" + OrderInfoBean.OrderState.CANCELLED.getCode() + "'");
        sql.SET("UPDATE_PERSON=#{updatePerson}", "UPDATE_PERSON_NAME=#{updatePersonName}", "UPDATE_TIME=now()");
        sql.WHERE("ORDER_ID=#{orderId}");
        return sql.toString();
    }
}