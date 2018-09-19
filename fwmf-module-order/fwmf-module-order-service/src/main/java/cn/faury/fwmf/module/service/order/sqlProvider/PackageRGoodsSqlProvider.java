package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.GoodsStockGenerateSqlProvider;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.PackageRGoodsGenerateSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class PackageRGoodsSqlProvider extends PackageRGoodsGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        return "SELECT * FROM " + DBConstOfOrder.ORDER_T_PACKAGE_R_GOODS;
    }

    public String getBeanListByPackageId(Long packageId) {
        SQL sql = new SQL();
        sql.SELECT("GOODS_ID", "GOODS_TYPE");
        sql.FROM(DBConstOfOrder.ORDER_T_PACKAGE_R_GOODS);
        sql.WHERE("PACKAGE_ID=#{packageId}");
        return sql.toString();
    }
}
