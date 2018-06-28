package cn.faury.fwmf.module.api.app.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 手机APP注册Bean
 */
public class AppInfoBean implements Serializable {

    /**
     * APP ID
     */
    private Long appId;

    /**
     * APP编码
     */
    private String appCode;

    /**
     * APP名称
     */
    private String appName;

    /**
     * 合并之后的appId
     */
    private String contactAppIds;

    /**
     * 合并之后的appName
     */
    private String contactAppNames;

    /**
     * APP操作系统描述（安卓/IOS，中文/英文）
     */
    private String appOS;

    /**
     * 所属业务系统ID
     */
    private Long systemId;

    /**
     * 是否可用（Y：可用，N：不可用）
     */
    private String isAvailable;

    /**
     * systemCode
     */
    private String systemCode;

    /**
     * systemName
     */
    private String systemName;

    /**
     * 拒绝游客用户登录【Y：是，N：否】
     */
    private String rejectGuestUser;

    /**
     * 拒绝购物用户登录【Y：是，N：否】
     */
    private String rejectShoppingUser;

    /**
     * 允许后台用户登录【Y：是，N：否】
     */
    private String allowBackgroundUser;

    /**
     * APPStore编号
     */
    private String trackId;

    /**
     * 域名
     */
    private String serverDomain;

    /**
     * 获取appId
     *
     * @return appId
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * 设置appId
     *
     * @param appId 值
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * 获取appCode
     *
     * @return appCode
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * 设置appCode
     *
     * @param appCode 值
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    /**
     * 获取appName
     *
     * @return appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置appName
     *
     * @param appName 值
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * 获取contactAppIds
     *
     * @return contactAppIds
     */
    public String getContactAppIds() {
        return contactAppIds;
    }

    /**
     * 设置contactAppIds
     *
     * @param contactAppIds 值
     */
    public void setContactAppIds(String contactAppIds) {
        this.contactAppIds = contactAppIds;
    }

    /**
     * 获取contactAppNames
     *
     * @return contactAppNames
     */
    public String getContactAppNames() {
        return contactAppNames;
    }

    /**
     * 设置contactAppNames
     *
     * @param contactAppNames 值
     */
    public void setContactAppNames(String contactAppNames) {
        this.contactAppNames = contactAppNames;
    }

    /**
     * 获取appOS
     *
     * @return appOS
     */
    public String getAppOS() {
        return appOS;
    }

    /**
     * 设置appOS
     *
     * @param appOS 值
     */
    public void setAppOS(String appOS) {
        this.appOS = appOS;
    }

    /**
     * 获取systemId
     *
     * @return systemId
     */
    public Long getSystemId() {
        return systemId;
    }

    /**
     * 设置systemId
     *
     * @param systemId 值
     */
    public void setSystemId(Long systemId) {
        this.systemId = systemId;
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
     * 获取systemCode
     *
     * @return systemCode
     */
    public String getSystemCode() {
        return systemCode;
    }

    /**
     * 设置systemCode
     *
     * @param systemCode 值
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
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
     * 获取rejectGuestUser
     *
     * @return rejectGuestUser
     */
    public String getRejectGuestUser() {
        return rejectGuestUser;
    }

    /**
     * 设置rejectGuestUser
     *
     * @param rejectGuestUser 值
     */
    public void setRejectGuestUser(String rejectGuestUser) {
        this.rejectGuestUser = rejectGuestUser;
    }

    /**
     * 获取rejectShoppingUser
     *
     * @return rejectShoppingUser
     */
    public String getRejectShoppingUser() {
        return rejectShoppingUser;
    }

    /**
     * 设置rejectShoppingUser
     *
     * @param rejectShoppingUser 值
     */
    public void setRejectShoppingUser(String rejectShoppingUser) {
        this.rejectShoppingUser = rejectShoppingUser;
    }

    /**
     * 获取allowBackgroundUser
     *
     * @return allowBackgroundUser
     */
    public String getAllowBackgroundUser() {
        return allowBackgroundUser;
    }

    /**
     * 设置allowBackgroundUser
     *
     * @param allowBackgroundUser 值
     */
    public void setAllowBackgroundUser(String allowBackgroundUser) {
        this.allowBackgroundUser = allowBackgroundUser;
    }

    /**
     * 获取trackId
     *
     * @return trackId
     */
    public String getTrackId() {
        return trackId;
    }

    /**
     * 设置trackId
     *
     * @param trackId 值
     */
    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    /**
     * 获取serverDomain
     *
     * @return serverDomain
     */
    public String getServerDomain() {
        return serverDomain;
    }

    /**
     * 设置serverDomain
     *
     * @param serverDomain 值
     */
    public void setServerDomain(String serverDomain) {
        this.serverDomain = serverDomain;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}
