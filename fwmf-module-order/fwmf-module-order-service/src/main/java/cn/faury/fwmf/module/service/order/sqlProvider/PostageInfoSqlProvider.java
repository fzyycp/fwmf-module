package cn.faury.fwmf.module.service.order.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.OrderInfoGenerateSqlProvider;

import java.util.List;
import java.util.Map;

/**
 * SQL Provider：邮费信息表
 *
 * <pre>
 *     PostageInfoGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自PostageInfoGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class PostageInfoSqlProvider extends OrderInfoGenerateSqlProvider {
}