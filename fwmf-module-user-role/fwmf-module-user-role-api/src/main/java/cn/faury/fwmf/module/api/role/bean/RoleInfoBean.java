package cn.faury.fwmf.module.api.role.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 角色对象Bean
 */
public class RoleInfoBean implements Serializable {

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 是否可用【1:是 0:否】
     */
    private String isAvailable;

    /**
     * 业务系统ID
     */
    private Long systemId;

    /**
     * 业务系统编码
     */
    private String systemCode;

    /**
     * 业务系统名称
     */
    private String systemName;

    public Long getRoleId() {
        return roleId;
    }

    public RoleInfoBean setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public RoleInfoBean setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public RoleInfoBean setRoleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }

    public String getIsAvailable() {
        return isAvailable;
    }

    public RoleInfoBean setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
        return this;
    }

    public Long getSystemId() {
        return systemId;
    }

    public RoleInfoBean setSystemId(Long systemId) {
        this.systemId = systemId;
        return this;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public RoleInfoBean setSystemCode(String systemCode) {
        this.systemCode = systemCode;
        return this;
    }

    public String getSystemName() {
        return systemName;
    }

    public RoleInfoBean setSystemName(String systemName) {
        this.systemName = systemName;
        return this;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}
