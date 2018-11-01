package cn.faury.fwmf.module.service.qa.sqlProvider;

import cn.faury.fwmf.module.service.qa.generate.sqlProvider.QaInfoGenerateSqlProvider;

/**
 * SQL Provider：常见问题信息
 *
 * <pre>
 *     QaInfoGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自QaInfoGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class QaInfoSqlProvider extends QaInfoGenerateSqlProvider {
}