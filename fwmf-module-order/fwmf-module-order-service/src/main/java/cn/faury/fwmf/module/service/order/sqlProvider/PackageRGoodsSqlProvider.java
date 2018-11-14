package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.PackageRGoodsGenerateSqlProvider;
import org.apache.ibatis.jdbc.SQL;

/**
 * SQL Provider：套餐关联表
 *
 * <pre>
 *     PackageRGoodsGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自PackageRGoodsGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class PackageRGoodsSqlProvider extends PackageRGoodsGenerateSqlProvider {

    public String getBeanListByPackageId(Long packageId) {
        SQL sql = new SQL();
        sql.SELECT("GOODS_ID", "GOODS_TYPE");
        sql.FROM(DBConstOfOrder.ORDER_T_PACKAGE_R_GOODS);
        sql.WHERE("PACKAGE_ID=#{packageId}");
        return sql.toString();
    }
}
