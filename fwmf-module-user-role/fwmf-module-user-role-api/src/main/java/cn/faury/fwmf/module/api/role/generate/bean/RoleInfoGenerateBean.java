/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-21 14:58:58
 */
package cn.faury.fwmf.module.api.role.generate.bean;

/**
 * Database Table Remarks:
 *   角色信息表
 *
 * This class was generated by Fwmf Generated.
 * This class corresponds to the database table sys_t_role_info
 *
 * @fwmf.generated 2018-09-21 14:58:58
 */
public class RoleInfoGenerateBean {
    /**
     * Database Column Remarks:
     *   角色ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_role_info.ROLE_ID
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    private Long roleId;

    /**
     * Database Column Remarks:
     *   角色名称
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_role_info.ROLE_NAME
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    private String roleName;

    /**
     * Database Column Remarks:
     *   角色编码
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_role_info.ROLE_CODE
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    private String roleCode;

    /**
     * Database Column Remarks:
     *   是否可用（Y:可用  N:不可用）
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_role_info.IS_AVAILABLE
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    private String isAvailable;

    /**
     * Database Column Remarks:
     *   所属系统ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_role_info.SYSTEM_ID
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    private Long systemId;

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_role_info.ROLE_ID
     *
     * @return the value of sys_t_role_info.ROLE_ID
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_role_info.ROLE_ID
     *
     * @param roleId the value for sys_t_role_info.ROLE_ID
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_role_info.ROLE_NAME
     *
     * @return the value of sys_t_role_info.ROLE_NAME
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_role_info.ROLE_NAME
     *
     * @param roleName the value for sys_t_role_info.ROLE_NAME
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_role_info.ROLE_CODE
     *
     * @return the value of sys_t_role_info.ROLE_CODE
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_role_info.ROLE_CODE
     *
     * @param roleCode the value for sys_t_role_info.ROLE_CODE
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_role_info.IS_AVAILABLE
     *
     * @return the value of sys_t_role_info.IS_AVAILABLE
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    public String getIsAvailable() {
        return isAvailable;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_role_info.IS_AVAILABLE
     *
     * @param isAvailable the value for sys_t_role_info.IS_AVAILABLE
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable == null ? null : isAvailable.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_role_info.SYSTEM_ID
     *
     * @return the value of sys_t_role_info.SYSTEM_ID
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    public Long getSystemId() {
        return systemId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_role_info.SYSTEM_ID
     *
     * @param systemId the value for sys_t_role_info.SYSTEM_ID
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }
}