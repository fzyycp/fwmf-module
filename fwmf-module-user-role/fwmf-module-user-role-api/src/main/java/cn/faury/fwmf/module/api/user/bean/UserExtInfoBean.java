package cn.faury.fwmf.module.api.user.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 用户扩展信息表
 */
public class UserExtInfoBean implements Serializable {
    /**
     * ID
     */
    private Long userId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 生日
     */
    private String brthYmd;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 头像地址
     */
    private String avatarUrl;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBrthYmd() {
        return brthYmd;
    }

    public void setBrthYmd(String brthYmd) {
        this.brthYmd = brthYmd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}
