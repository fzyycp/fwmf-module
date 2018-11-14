package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.api.order.bean.OrderInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderPayInfoGenerateSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * SQL Provider：订单支付信息表
 *
 * <pre>
 *     OrderPayInfoGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自OrderPayInfoGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OrderPayInfoSqlProvider extends OrderPayInfoGenerateSqlProvider {

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