package cn.faury.fwmf.module.api.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * app版本信息Bean
 */
public class AppVersionBean implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 客户端类型
     */
    private String sysType;

    /**
     * 版本号
     */
    private String versionNum;

    /**
     * 连接类型：1.直接链接 2.FTP链接
     */
    private String urlType;

    /**
     * 下载地址
     */
    private String path;

    /**
     * 文件名称
     */
    private String title;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 业务系统ID
     */
    private Long sysId;

    private String sysName;

    /**
     * APP的ID
     */
    private Long appId;

    private String appName;

    /**
     * 是否强制更新
     */
    private String isCoercion;

    /**
     * 是否正式版本
     */
    private String isFormal;

    /**
     * 备注
     */
    private String memo;

    /**
     * 创建人
     */
    private Long createPerson;

    /**
     * 创建人姓名
     */
    private String createPersonName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新人
     */
    private Long updatePerson;

    /**
     * 更新姓名
     */
    private String updatePersonName;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 删除标志
     */
    private String delFlag;

    /**
     * IOS上传专用标志
     */
    private String identifier;

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
     * @return the sysType
     */
    public String getSysType() {
        return sysType;
    }

    /**
     * @param sysType the sysType to set
     */
    public void setSysType(String sysType) {
        this.sysType = sysType;
    }

    /**
     * @return the versionNum
     */
    public String getVersionNum() {
        return versionNum;
    }

    /**
     * @param versionNum the versionNum to set
     */
    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    /**
     * @return the urlType
     */
    public String getUrlType() {
        return urlType;
    }

    /**
     * @param urlType the urlType to set
     */
    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for property 'size'.
     *
     * @return Value for property 'size'.
     */
    public Long getSize() {
        return size;
    }

    /**
     * Setter for property 'size'.
     *
     * @param size Value to set for property 'size'.
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * @return the sysId
     */
    public Long getSysId() {
        return sysId;
    }

    /**
     * @param sysId the sysId to set
     */
    public void setSysId(Long sysId) {
        this.sysId = sysId;
    }

    /**
     * @return the appId
     */
    public Long getAppId() {
        return appId;
    }

    /**
     * @param appId the appId to set
     */
    public void setAppId(Long appId) {
        this.appId = appId;
    }

    /**
     * @return the isCoercion
     */
    public String getIsCoercion() {
        return isCoercion;
    }

    /**
     * @param isCoercion the isCoercion to set
     */
    public void setIsCoercion(String isCoercion) {
        this.isCoercion = isCoercion;
    }

    /**
     * @return the isFormal
     */
    public String getIsFormal() {
        return isFormal;
    }

    /**
     * @param isFormal the isFormal to set
     */
    public void setIsFormal(String isFormal) {
        this.isFormal = isFormal;
    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return the createPerson
     */
    public Long getCreatePerson() {
        return createPerson;
    }

    /**
     * @param createPerson the createPerson to set
     */
    public void setCreatePerson(Long createPerson) {
        this.createPerson = createPerson;
    }

    /**
     * @return the createPersonName
     */
    public String getCreatePersonName() {
        return createPersonName;
    }

    /**
     * @param createPersonName the createPersonName to set
     */
    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName;
    }

    /**
     * @return the createTime
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the updatePerson
     */
    public Long getUpdatePerson() {
        return updatePerson;
    }

    /**
     * @param updatePerson the updatePerson to set
     */
    public void setUpdatePerson(Long updatePerson) {
        this.updatePerson = updatePerson;
    }

    /**
     * @return the updatePersonName
     */
    public String getUpdatePersonName() {
        return updatePersonName;
    }

    /**
     * @param updatePersonName the updatePersonName to set
     */
    public void setUpdatePersonName(String updatePersonName) {
        this.updatePersonName = updatePersonName;
    }

    /**
     * @return the updateTime
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the delFlag
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag the delFlag to set
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * @return the sysName
     */
    public String getSysName() {
        return sysName;
    }

    /**
     * @param sysName the sysName to set
     */
    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    /**
     * @return the appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * @param appName the appName to set
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }

}
