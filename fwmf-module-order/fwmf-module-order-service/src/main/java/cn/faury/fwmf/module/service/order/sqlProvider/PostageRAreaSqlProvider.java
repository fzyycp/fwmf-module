package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderInfoGenerateSqlProvider;

import java.util.List;
import java.util.Map;

/**
 * SQL Provider：地区类型各地区具体邮费信息
 *
 * <pre>
 *     PostageRAreaGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自PostageRAreaGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class PostageRAreaSqlProvider extends OrderInfoGenerateSqlProvider {

    public String getBeanListByPostageIds(Map<String,Object> params) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ID, POSTAGE_ID, AREA_CODE_PROVINCE, AREA_DESC_PROVINCE,GOODS_COUNT");
        sql.append("        , POSTAGE_PRICE, INCREASE_GOODS_COUNT, INCREASE_POSTAGE_PRICE");
        sql.append("  FROM ").append(DBConstOfOrder.ORDER_T_POSTAGE_R_AREA);
        sql.append(" WHERE POSTAGE_ID IN(");
        List<Long> postageIdList = (List<Long>) params.get("postageIdList");
        for (int i = 0; i < postageIdList.size(); i++) {
            sql.append("#{postageIdList[").append(i).append("]},");
        }
        sql.setLength(sql.length() - 1);
        postageIdList.forEach(postageId -> sql.append(""));
        sql.append(")");
        return sql.toString();
    }
}