package cn.faury.fwmf.module.api.systemconfig.bean;


import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 系统参数配置Bean
 */
public class SystemConfigInfoBean implements Serializable {
    /**
     * 系统参数配置ID
     */
    private Long systemConfigId;

    /**
     * 配置KEY
     */
    private String systemConfigKey;

    /**
     * 配置VALUE
     */
    private String systemConfigValue;

    /**
     * 所属系统ID
     */
    private Long systemConfigSystemId;

    /**
     * 创建时间
     */
    private Timestamp systemConfigTime;

    /**
     * 是否可用
     */
    private String isAvailable;

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 使用说明
     */
    private String systemConfigDesc;

    /**
     * 获取systemConfigId
     *
     * @return systemConfigId
     */
    public Long getSystemConfigId() {
        return systemConfigId;
    }

    /**
     * 设置systemConfigId
     *
     * @param systemConfigId 值
     */
    public void setSystemConfigId(Long systemConfigId) {
        this.systemConfigId = systemConfigId;
    }

    /**
     * 获取systemConfigKey
     *
     * @return systemConfigKey
     */
    public String getSystemConfigKey() {
        return systemConfigKey;
    }

    /**
     * 设置systemConfigKey
     *
     * @param systemConfigKey 值
     */
    public void setSystemConfigKey(String systemConfigKey) {
        this.systemConfigKey = systemConfigKey;
    }

    /**
     * 获取systemConfigValue
     *
     * @return systemConfigValue
     */
    public String getSystemConfigValue() {
        return systemConfigValue;
    }

    /**
     * 设置systemConfigValue
     *
     * @param systemConfigValue 值
     */
    public void setSystemConfigValue(String systemConfigValue) {
        this.systemConfigValue = systemConfigValue;
    }

    /**
     * 获取systemConfigSystemId
     *
     * @return systemConfigSystemId
     */
    public Long getSystemConfigSystemId() {
        return systemConfigSystemId;
    }

    /**
     * 设置systemConfigSystemId
     *
     * @param systemConfigSystemId 值
     */
    public void setSystemConfigSystemId(Long systemConfigSystemId) {
        this.systemConfigSystemId = systemConfigSystemId;
    }

    /**
     * 获取systemConfigTime
     *
     * @return systemConfigTime
     */
    public Timestamp getSystemConfigTime() {
        return systemConfigTime;
    }

    /**
     * 设置systemConfigTime
     *
     * @param systemConfigTime 值
     */
    public void setSystemConfigTime(Timestamp systemConfigTime) {
        this.systemConfigTime = systemConfigTime;
    }

    /**
     * 获取isAvailable
     *
     * @return isAvailable
     */
    public String getIsAvailable() {
        return isAvailable;
    }

    /**
     * 设置isAvailable
     *
     * @param isAvailable 值
     */
    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * 获取systemName
     *
     * @return systemName
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * 设置systemName
     *
     * @param systemName 值
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    /**
     * 获取systemConfigDesc
     *
     * @return systemConfigDesc
     */
    public String getSystemConfigDesc() {
        return systemConfigDesc;
    }

    /**
     * 设置systemConfigDesc
     *
     * @param systemConfigDesc 值
     */
    public void setSystemConfigDesc(String systemConfigDesc) {
        this.systemConfigDesc = systemConfigDesc;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}
