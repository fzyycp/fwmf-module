package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderInfoGenerateSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * SQL Provider：订单信息表
 *
 * <pre>
 *     OrderInfoGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自OrderInfoGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OrderInfoSqlProvider extends OrderInfoGenerateSqlProvider {

    public String updateOrderInfoState(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.UPDATE(DBConstOfOrder.ORDER_T_ORDER_INFO);
        sql.SET("ORDER_STATE=#{orderState}");
        sql.SET("TRAD_STATE=#{tradeState}");
        sql.SET("PAY_STYLE=#{payStyle}");
        sql.SET("UPDATE_PERSON=#{updatePerson}");
        sql.SET("PAY_TIME=now()");
        sql.SET("UPDATE_TIME=now()");
        if (params.get("payRemark") != null) {//平台支付
            sql.SET("PAY_REMARK=#{payRemark}");
            sql.SET("PAY_UPDATE_PERSON=#{updatePerson}");
            sql.SET("PAY_UPDATE_TIME=now()");
        }
        sql.WHERE("ORDER_ID=#{orderId}");
        return sql.toString();
    }

    public String statisticsState(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("ORDER_STATE", "TRAD_STATE TRADE_STATE", "COUNT(*) COUNT");
        sql.FROM(DBConstOfOrder.ORDER_T_ORDER_INFO);
        sql.WHERE("BUYER_ID=#{userId}");
        if (params != null && params.get("storeId") != null) {
            sql.WHERE("STORE_ID=#{storeId}");
        }
        sql.GROUP_BY("ORDER_STATE", "TRAD_STATE");
        return sql.toString();
    }
}