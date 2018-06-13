/*
 * Copyright (c)
 */

package cn.faury.fwmf.module.api.role.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.role.bean.RoleInfoBean;

import java.util.List;

/**
 * 角色服务协议
 */
public interface RoleService<T extends RoleInfoBean> {

    /**
     * 根据用户ID获取指定系统下的角色信息，只查询启用状态的角色和业务系统
     *
     * @param systemCode
     *            业务系统编码
     * @param userId
     *            用户ID
     * @return 用户角色列表
     */
    @Read
    List<T> getUserRolesByUserId(final String systemCode, final Long userId);

    /**
     * 根据用户ID获取指定系统下的角色授权信息
     *
     * @param systemCode
     *            业务系统编码
     * @param userId
     *            用户ID
     * @return 用户授权列表
     */
    @Read
    List<String> getUserRolePermsByUserId(final String systemCode, final Long userId);

    /**
     * 根据角色编码获取角色信息
     *
     * @param roleCode 角色编码
     * @return 角色对象
     */
    @Read
    T getRoleInfoByCode(final String roleCode);

    /**
     * 插入用户角色信息
     *
     * @param userId   用户ID
     * @param roleCode 角色编码
     * @return 成功插入条数
     */
    @Write
    int insertUserRRole(final Long userId, final String roleCode);

    /**
     * 删除用户角色信息
     *
     * @param userId 用户ID
     * @return 成功删除条数
     */
    @Write
    int deleteUserRRole(final Long userId);

    /**
     * 更新用户角色
     * <p>
     * 先删除原有的角色，插入新的角色
     *
     * @param userId   用户ID
     * @param roleCode 用户编码
     * @return 成功插入条数
     */
    @Write
    int updateUserRRole(final Long userId, final String roleCode);
}
