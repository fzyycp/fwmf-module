package cn.faury.fwmf.module.service.category.sqlProvider;

import cn.faury.fwmf.module.service.category.generate.sqlProvider.CategoryInfoGenerateSqlProvider;

/**
 * SQL Provider：分类信息表
 *
 * <pre>
 *     CategoryInfoGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自CategoryInfoGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class CategoryInfoSqlProvider extends CategoryInfoGenerateSqlProvider {
}