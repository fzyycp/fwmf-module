package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.PackageInfoGenerateSqlProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * SQL Provider：套餐基本信息表
 *
 * <pre>
 *     PackageInfoGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自PackageInfoGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class PackageInfoSqlProvider extends PackageInfoGenerateSqlProvider {

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
