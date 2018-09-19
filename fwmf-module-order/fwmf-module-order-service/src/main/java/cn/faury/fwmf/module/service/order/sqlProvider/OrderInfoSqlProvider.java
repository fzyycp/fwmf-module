package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderInfoGenerateSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class OrderInfoSqlProvider extends OrderInfoGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("ORDER_ID", "ORDER_CODE", "BUYER_ID", "BUYER_LOGIN", "ORDER_STATE", "GOODS_COUNT", "GOODS_PRICE", "POST_PRICE", "ORDER_PRICE", "GOODS_PAY_PRICE", "POST_PAY_PRICE", "ORDER_PAY_PRICE", "PAY_STYLE", "BUY_ENTRANCE", "AREA_CODE_PROVINCE",
                "AREA_DESC_PROVINCE", "AREA_CODE_CITY", "AREA_DESC_CITY", "AREA_CODE_COUNTY", "AREA_DESC_COUNTY", "SCHOOL_NAME", "GRADE_NAME", "CLASS_NAME", "ADDRESS_DETAIL", "CREATE_TIME", "UPDATE_PERSON", "UPDATE_TIME", "RECEIVER_NAME", "TEL_NO", "CODE_NUMBER", "CODE_URL",
                "DEMO", "TRAD_STATE", "SHOP_ID", "STORE_ID", "AGENT_USER_ID", "IS_PICKUP", "EXPRESS_CODE", "EXPRESS_NAME", "EXPRESS_FEE", "TRACK_NUMBER", "PAY_REMARK", "PAY_UPDATE_PERSON", "PAY_UPDATE_TIME", "REFOUND_STATE", "INVOICE", "SEND_TIME", "CONFIRM_TIME",
                "IS_GROUP_BUY",
                "IS_REFUND",
                "IS_APP_ORDER");
        sql.FROM(DBConstOfOrder.ORDER_T_ORDER_INFO);
        if (params != null) {
            if (params.get("orderId") != null) {
                sql.WHERE("ORDER_ID=#{orderId}");
            }
            if (params.get("storeId") != null) {
                sql.WHERE("STORE_ID=#{storeId}");
            }
            if (params.get("buyerId") != null) {
                sql.WHERE("BUYER_ID=#{buyerId}");
            }
            if (params.get("tradState") != null) {
                sql.WHERE("TRAD_STATE=#{tradState}");
            }
            if (params.get("orderState") != null) {
                sql.WHERE("ORDER_STATE=#{orderState}");
            }
            if (params.get("orderStates") != null && params.get("orderStates") instanceof List) {
                List<String> orderStates = (List) params.get("orderStates");
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < orderStates.size(); i++) {
                    tmp.append("#{orderStates[").append(i).append("]},");
                }
                sql.WHERE("ORDER_STATE IN (" + tmp.substring(0, tmp.length() - 1) + ")");
            } else if (params.get("orderState") == null) {// 没有状态参数，默认获取非删除状态
                sql.WHERE("ORDER_STATE <> '3'");
            }
            sql.ORDER_BY("CREATE_TIME DESC");
        }
        return sql.toString();
    }

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