package cn.faury.fwmf.module.api.user.bean;


import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用户OAUTH信息
 */
public class UserOAuthInfoBean implements Serializable {

    /**
     * 唯一标识
     */
    private Long oauthId;

    /**
     * 用户ID（来自用户信息表）
     */
    private Long userId;

    /**
     * 接口调用凭证
     */
    private String accessToken;

    /**
     * 用户刷新access_token
     */
    private String refreshToken;

    /**
     * 授权用户唯一标识（APP内唯一）
     */
    private String openid;

    /**
     * 用户统一标识（开放平台内唯一）
     */
    private String unionid;

    /**
     * 第一次登录时创建的原始用户ID
     */
    private Long originUserId;

    /**
     * 第三方类型
     */
    private String oauthFrom;

    /**
     * 扩展内容，为了返回前台用的，不与数据库中对于
     */
    private Map<String,Serializable> exts = new LinkedHashMap<>();

    public Long getOauthId() {
        return oauthId;
    }

    public void setOauthId(Long oauthId) {
        this.oauthId = oauthId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public Long getOriginUserId() {
        return originUserId;
    }

    public void setOriginUserId(Long originUserId) {
        this.originUserId = originUserId;
    }

    public String getOauthFrom() {
        return oauthFrom;
    }

    public void setOauthFrom(String oauthFrom) {
        this.oauthFrom = oauthFrom;
    }

    public Map<String, Serializable> getExts() {
        return exts;
    }

    public void setExts(Map<String, Serializable> exts) {
        this.exts = exts;
    }

    /**
     *  JSON格式输出
     *
     * @return JSON
     */
    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}
