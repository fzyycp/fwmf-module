package cn.faury.fwmf.module.service.role.sqlProvider;

import cn.faury.fwmf.module.service.role.generate.sqlProvider.UserRRoleGenerateSqlProvider;

/**
 * SQL Provider：用户关联角色表
 *
 * <pre>
 *     UserRRoleGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自UserRRoleGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class UserRRoleSqlProvider extends UserRRoleGenerateSqlProvider {
}