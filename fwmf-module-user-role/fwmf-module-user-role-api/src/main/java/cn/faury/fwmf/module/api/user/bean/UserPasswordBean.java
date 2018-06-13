package cn.faury.fwmf.module.api.user.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 用户密码信息
 */
public class UserPasswordBean implements Serializable {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户登录密码
     */
    private String password;

    public Long getUserId() {
        return userId;
    }

    public UserPasswordBean setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserPasswordBean setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }

}
