package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderInfoGenerateSqlProvider;

import java.util.List;
import java.util.Map;

public class PostageInfoSqlProvider extends OrderInfoGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        return "SELECT * FROM " + DBConstOfOrder.ORDER_T_POSTAGE_INFO;
    }

    public String getBeanListByIds(Map<String, Object> params) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ").append(DBConstOfOrder.ORDER_T_POSTAGE_INFO);
        sql.append(" WHERE POSTAGE_ID IN (");
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