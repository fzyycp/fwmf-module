package cn.faury.fwmf.module.service.operation.sqlProvider;

import cn.faury.fwmf.module.service.operation.generate.sqlProvider.OperationRecordGenerateSqlProvider;

/**
 * SQL Provider：操作记录信息表
 *
 * <pre>
 *     OperationRecordGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自OperationRecordGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OperationRecordSqlProvider extends OperationRecordGenerateSqlProvider {
}