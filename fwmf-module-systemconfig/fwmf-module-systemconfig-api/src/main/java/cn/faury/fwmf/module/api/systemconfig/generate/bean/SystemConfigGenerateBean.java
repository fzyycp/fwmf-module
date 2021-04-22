/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2019-01-17 14:52:11
 */
package cn.faury.fwmf.module.api.systemconfig.generate.bean;

/**
 * Database Table Remarks:
 *   系统参数配置表
 *
 * This class was generated by Fwmf Generated.
 * This class corresponds to the database table sys_t_system_config
 *
 * @fwmf.generated 2019-01-17 14:52:11
 */
public class SystemConfigGenerateBean {
    /**
     * Database Column Remarks:
     *   系统参数配置ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_system_config.SYSTEM_CONFIG_ID
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    private Long systemConfigId;

    /**
     * Database Column Remarks:
     *   配置KEY
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_system_config.SYSTEM_CONFIG_KEY
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    private String systemConfigKey;

    /**
     * Database Column Remarks:
     *   配置VALUE
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_system_config.SYSTEM_CONFIG_VALUE
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    private String systemConfigValue;

    /**
     * Database Column Remarks:
     *   所属系统
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_system_config.SYSTEM_CONFIG_SYSTEM_ID
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    private Long systemConfigSystemId;

    /**
     * Database Column Remarks:
     *   使用说明
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_system_config.SYSTEM_CONFIG_DESC
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    private String systemConfigDesc;

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_system_config.SYSTEM_CONFIG_ID
     *
     * @return the value of sys_t_system_config.SYSTEM_CONFIG_ID
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    public Long getSystemConfigId() {
        return systemConfigId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_system_config.SYSTEM_CONFIG_ID
     *
     * @param systemConfigId the value for sys_t_system_config.SYSTEM_CONFIG_ID
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    public void setSystemConfigId(Long systemConfigId) {
        this.systemConfigId = systemConfigId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_system_config.SYSTEM_CONFIG_KEY
     *
     * @return the value of sys_t_system_config.SYSTEM_CONFIG_KEY
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    public String getSystemConfigKey() {
        return systemConfigKey;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_system_config.SYSTEM_CONFIG_KEY
     *
     * @param systemConfigKey the value for sys_t_system_config.SYSTEM_CONFIG_KEY
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    public void setSystemConfigKey(String systemConfigKey) {
        this.systemConfigKey = systemConfigKey == null ? null : systemConfigKey.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_system_config.SYSTEM_CONFIG_VALUE
     *
     * @return the value of sys_t_system_config.SYSTEM_CONFIG_VALUE
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    public String getSystemConfigValue() {
        return systemConfigValue;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_system_config.SYSTEM_CONFIG_VALUE
     *
     * @param systemConfigValue the value for sys_t_system_config.SYSTEM_CONFIG_VALUE
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    public void setSystemConfigValue(String systemConfigValue) {
        this.systemConfigValue = systemConfigValue == null ? null : systemConfigValue.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_system_config.SYSTEM_CONFIG_SYSTEM_ID
     *
     * @return the value of sys_t_system_config.SYSTEM_CONFIG_SYSTEM_ID
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    public Long getSystemConfigSystemId() {
        return systemConfigSystemId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_system_config.SYSTEM_CONFIG_SYSTEM_ID
     *
     * @param systemConfigSystemId the value for sys_t_system_config.SYSTEM_CONFIG_SYSTEM_ID
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    public void setSystemConfigSystemId(Long systemConfigSystemId) {
        this.systemConfigSystemId = systemConfigSystemId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_system_config.SYSTEM_CONFIG_DESC
     *
     * @return the value of sys_t_system_config.SYSTEM_CONFIG_DESC
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    public String getSystemConfigDesc() {
        return systemConfigDesc;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_system_config.SYSTEM_CONFIG_DESC
     *
     * @param systemConfigDesc the value for sys_t_system_config.SYSTEM_CONFIG_DESC
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    public void setSystemConfigDesc(String systemConfigDesc) {
        this.systemConfigDesc = systemConfigDesc == null ? null : systemConfigDesc.trim();
    }
}