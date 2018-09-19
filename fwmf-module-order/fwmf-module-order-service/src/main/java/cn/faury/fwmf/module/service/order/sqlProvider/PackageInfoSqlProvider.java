package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.GoodsStockGenerateSqlProvider;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.PackageInfoGenerateSqlProvider;
import cn.faury.fdk.common.utils.StringUtil;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PackageInfoSqlProvider extends PackageInfoGenerateSqlProvider {
    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("pkg.PACKAGE_ID", "pkg.PACKAGE_NAME", "pkg.PACKAGE_PRICE", "pkg.SHOP_ID"
                , "pkg.STORE_ID", "pkg.POSTAGE_ID", "post.POSTAGE_NAME", "pkg.IS_DELETE", "pkg.CREATE_PERSON"
                , "pkg.CREATE_PERSON_NAME", "pkg.CREATE_TIME", "pkg.UPDATE_PERSON"
                , "pkg.UPDATE_PERSON_NAME", "pkg.UPDATE_TIME");
        sql.FROM(DBConstOfOrder.ORDER_T_PACKAGE_INFO + " pkg", DBConstOfOrder.ORDER_T_POSTAGE_INFO + " post");
        sql.WHERE("pkg.POSTAGE_ID=post.POSTAGE_ID");
        if (params != null) {
            if (params.get("packageId") != null) {
                sql.WHERE("PACKAGE_ID=#{packageId}");
            }
            if (params.get("packageName") != null) {
                sql.WHERE("PACKAGE_NAME LIKE CONCAT('%',#{packageName},'%')");
            }
            if (params.get("isDelete") != null) {
                sql.WHERE("IS_DELETE=#{isDelete}");
            } else {
                sql.WHERE("IS_DELETE='" + StringUtil.WHETHER_NO + "'");
            }
        }
        return sql.toString();
    }

    public String getGoodsPackageList(Long goodsId) {
        SQL sql = new SQL();
        sql.SELECT("otpi.PACKAGE_ID", "PACKAGE_NAME", "PACKAGE_PRICE", "SHOP_ID", "STORE_ID", "POSTAGE_ID"
                , "IS_DELETE", "CREATE_PERSON", "CREATE_PERSON_NAME", "CREATE_TIME", "UPDATE_PERSON"
                , "UPDATE_PERSON_NAME", "UPDATE_TIME");
        sql.FROM(DBConstOfOrder.ORDER_T_PACKAGE_INFO + " otpi");
        sql.JOIN(DBConstOfOrder.ORDER_T_PACKAGE_R_GOODS + " otprg");
        sql.WHERE("otpi.PACKAGE_ID = otprg.PACKAGE_ID");
        sql.WHERE("otprg.GOODS_ID=#{goodsId}");
        sql.WHERE("otpi.IS_DELETE='" + StringUtil.WHETHER_NO + "'");
        return sql.toString();
    }

    public String deletePackageBatch(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.UPDATE(DBConstOfOrder.ORDER_T_PACKAGE_INFO);
        sql.SET("IS_DELETE='" + StringUtil.WHETHER_YES + "'");
        List<Long> packageIds = (List<Long>) params.get("packageIds");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < packageIds.size(); i++) {
            builder.append("#{packageIds[").append(i).append("]},");
        }
        builder.setLength(builder.length() - 1);
        sql.WHERE("PACKAGE_ID IN (" + builder.toString() + ")");
        return sql.toString();
    }
}
