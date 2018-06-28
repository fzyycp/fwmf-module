package cn.faury.fwmf.module.api.user.bean;


import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 商店用户组织关系
 */

public class ShopRUserBean implements Serializable {

    /**
     * 商店用户ID
     */
    private Long shopUserId;

    /**
     * 商店用户登录名
     */
    private String shopUserLoginName;

    /**
     * 商店用户姓名
     */
    private String shopUserName;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否自己创建
     */
    private String isSelfCreate;

    /**
     * 商店ID
     */
    private Long shopId;

    /**
     * 所属系统ID
     */
    private Long systemId;

    /**
     * 系统编码
     */
    private String systemCode;

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 是否是店主
     */
    private String isAdmin;

    /**
     * 创建人姓名
     */
    private String createPerson;

    /**
     * 修改人姓名
     */
    private String updatePerson;
    /**
     * @return the shopUserId
     */
    public Long getShopUserId() {
        return shopUserId;
    }

    /**
     * @param shopUserId the shopUserId to set
     */
    public void setShopUserId(Long shopUserId) {
        this.shopUserId = shopUserId;
    }

    /**
     * @return the shopUserLoginName
     */
    public String getShopUserLoginName() {
        return shopUserLoginName;
    }

    /**
     * @param shopUserLoginName the shopUserLoginName to set
     */
    public void setShopUserLoginName(String shopUserLoginName) {
        this.shopUserLoginName = shopUserLoginName;
    }

    /**
     * @return the shopUserName
     */
    public String getShopUserName() {
        return shopUserName;
    }

    /**
     * @param shopUserName the shopUserName to set
     */
    public void setShopUserName(String shopUserName) {
        this.shopUserName = shopUserName;
    }

    /**
     * @return the isSelfCreate
     */
    public String getIsSelfCreate() {
        return isSelfCreate;
    }

    /**
     * @param isSelfCreate the isSelfCreate to set
     */
    public void setIsSelfCreate(String isSelfCreate) {
        this.isSelfCreate = isSelfCreate;
    }

    /**
     * @return the shopId
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * @param shopId the shopId to set
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * @return the systemId
     */
    public Long getSystemId() {
        return systemId;
    }

    /**
     * @param systemId the systemId to set
     */
    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    /**
     * @return the systemCode
     */
    public String getSystemCode() {
        return systemCode;
    }

    /**
     * @param systemCode the systemCode to set
     */
    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the systemName
     */
    public String getSystemName() {
        return systemName;
    }

    /**
     * @param systemName the systemName to set
     */
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    /**
     * @return the isAdmin
     */
    public String getIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * 获取createPerson
     *
     * @return createPerson
     */
    public String getCreatePerson() {
        return createPerson;
    }

    /**
     * 设置createPerson
     *
     * @param createPerson 值
     */
    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    /**
     * 获取updatePerson
     *
     * @return updatePerson
     */
    public String getUpdatePerson() {
        return updatePerson;
    }

    /**
     * 设置updatePerson
     *
     * @param updatePerson 值
     */
    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
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
