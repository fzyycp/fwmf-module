package cn.faury.fwmf.module.api.user.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 后台用户信息
 */
public class UserInfoBean implements Serializable {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户登录名
     */
    private String loginName;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户登录密码
     */
    private String password;

    /**
     * 用户起用日
     */
    private Date efctYmd;

    /**
     * 用户失效日
     */
    private Date exprYmd;

    /**
     * 时间戳
     */
    private Timestamp insTstmp;

    /**
     * 所属系统ID
     */
    private Long originOsId;

    /**
     * 是否启用：1启用，0禁用
     */
    private String isEnable;

    /**
     * 创建人姓名
     */
    private String createPerson;

    /**
     * 修改人姓名
     */
    private String updatePerson;

    /**
     * 修改时间
     */
    private Timestamp updateTime;

    /****************后加 显示***************/

    public Long getUserId() {
        return userId;
    }

    public UserInfoBean setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public UserInfoBean setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserInfoBean setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Date getEfctYmd() {
        return efctYmd;
    }

    public UserInfoBean setEfctYmd(Date efctYmd) {
        this.efctYmd = efctYmd;
        return this;
    }

    public Date getExprYmd() {
        return exprYmd;
    }

    public UserInfoBean setExprYmd(Date exprYmd) {
        this.exprYmd = exprYmd;
        return this;
    }

    public Timestamp getInsTstmp() {
        return insTstmp;
    }

    public UserInfoBean setInsTstmp(Timestamp insTstmp) {
        this.insTstmp = insTstmp;
        return this;
    }

    public Long getOriginOsId() {
        return originOsId;
    }

    public UserInfoBean setOriginOsId(Long originOsId) {
        this.originOsId = originOsId;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfoBean setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public UserInfoBean setIsEnable(String isEnable) {
        this.isEnable = isEnable;
        return this;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}
