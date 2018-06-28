package cn.faury.fwmf.module.api.user.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 用户代理人Bean
 */
public class UserAgentInfoBean implements Serializable {

    /**
     * 唯一主键
     */
    private Long id;

    /**
     * 被代理人ID
     */
    private Long userId;

    /**
     * 被代理人登录名
     */
    private String loginName;

    /**
     * 被代理人用户姓名
     */
    private String userName;

    /**
     * 代理人ID
     */
    private Long agentUserId;

    /**
     * 代理人登录名
     */
    private String agentLoginName;

    /**
     * 代理人用户姓名
     */
    private String agentUserName;

    /**
     * 业务系统ID或者APP ID
     */
    private Long osId;

    /**
     * 业务系统编码或者APP编码
     */
    private String osCode;

    /**
     * 业务系统名称或者APP名称
     */
    private String osName;

    /**
     * 系统类型【0:业务系统，1:手机APP】
     */
    private String osType;

    /**
     * 是否可用【Y:是 N：否】
     */
    private String isAvailable;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return the agentUserId
     */
    public Long getAgentUserId() {
        return agentUserId;
    }

    /**
     * @param agentUserId the agentUserId to set
     */
    public void setAgentUserId(Long agentUserId) {
        this.agentUserId = agentUserId;
    }

    /**
     * @return the agentLoginName
     */
    public String getAgentLoginName() {
        return agentLoginName;
    }

    /**
     * @param agentLoginName the agentLoginName to set
     */
    public void setAgentLoginName(String agentLoginName) {
        this.agentLoginName = agentLoginName;
    }

    /**
     * @return the osId
     */
    public Long getOsId() {
        return osId;
    }

    /**
     * @param osId the osId to set
     */
    public void setOsId(Long osId) {
        this.osId = osId;
    }

    /**
     * @return the osCode
     */
    public String getOsCode() {
        return osCode;
    }

    /**
     * @param osCode the osCode to set
     */
    public void setOsCode(String osCode) {
        this.osCode = osCode;
    }

    /**
     * @return the osName
     */
    public String getOsName() {
        return osName;
    }

    /**
     * @param osName the osName to set
     */
    public void setOsName(String osName) {
        this.osName = osName;
    }

    /**
     * @return the osType
     */
    public String getOsType() {
        return osType;
    }

    /**
     * @param osType the osType to set
     */
    public void setOsType(String osType) {
        this.osType = osType;
    }

    /**
     * @return the isAvailable
     */
    public String getIsAvailable() {
        return isAvailable;
    }

    /**
     * @param isAvailable the isAvailable to set
     */
    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the agentUserName
     */
    public String getAgentUserName() {
        return agentUserName;
    }

    /**
     * @param agentUserName the agentUserName to set
     */
    public void setAgentUserName(String agentUserName) {
        this.agentUserName = agentUserName;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }

}
