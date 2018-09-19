package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.PromotionInfoGenerateSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PromotionInfoSqlProvider extends PromotionInfoGenerateSqlProvider {

    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT(
                "PROMOTION_ID", "PROMOTION_NAME", "PROMOTION_SUBJECT", "PROMOTION_CONDITION"
                , "CONDITION_VALUE", "MEET_OPERATION", "MEET_VALUE", "PROMOTION_START_TIME"
                , "PROMOTION_END_TIME", "CREATE_PERSON", "CREATE_TIME", "UPDATE_PERSON", "UPDATE_TIME");
        sql.FROM(DBConstOfOrder.ORDER_T_PROMOTION_INFO);
        if (params != null) {
            if (params.get("promotionStartTime") != null) {
                sql.WHERE("PROMOTION_START_TIME>#{promotionStartTime}");
            }
            if (params.get("promotionId") != null) {
                sql.WHERE("PROMOTION_ID=#{promotionId}");
            }
            if (params.get("promotionName") != null) {
                sql.WHERE("PROMOTION_NAME=#{promotionName}");
            }
            if (params.get("promotionSubject") != null) {
                sql.WHERE("PROMOTION_SUBJECT=#{promotionSubject}");
            }
            if (params.get("promotionCondition") != null) {
                sql.WHERE("PROMOTION_CONDITION=#{promotionCondition}");
            }
        }
        return sql.toString();
    }

    public String getBeanListByIds(Map<String, Object> params) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT PROMOTION_ID, PROMOTION_NAME, PROMOTION_SUBJECT, PROMOTION_CONDITION" +
                ", CONDITION_VALUE, MEET_OPERATION, MEET_VALUE, PROMOTION_START_TIME, PROMOTION_END_TIME" +
                ", CREATE_PERSON, CREATE_TIME, UPDATE_PERSON, UPDATE_TIME");
        sql.append(" FROM ").append(DBConstOfOrder.ORDER_T_PROMOTION_INFO);
        sql.append(" WHERE PROMOTION_ID IN (");
        List ids = (List) params.get("ids");
        for (int i = 0; i < ids.size(); i++) {
            if (i < ids.size() - 1) {
                sql.append(" #{ids[").append(i).append("]}, ");
            } else {
                sql.append(" #{ids[").append(i).append("]} ");
            }
        }
        sql.append(")");
        return sql.toString();
    }
}