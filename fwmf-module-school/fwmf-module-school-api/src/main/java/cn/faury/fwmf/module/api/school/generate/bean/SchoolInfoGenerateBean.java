/**
 * This file was generator by Fwmf Generated
 * @fwmf.generated 2018-08-18 22:31:52
 */
package cn.faury.fwmf.module.api.school.generate.bean;

import java.util.Date;

/**
 *
 * This class was generated by Fwmf Generated.
 * This class corresponds to the database table sys_t_school_info
 *
 * @fwmf.generated 2018-08-18 22:31:52
 */
public class SchoolInfoGenerateBean {
    /**
     * Database Column Remarks:
     *   学校ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.SCHOOL_ID
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private Long schoolId;

    /**
     * Database Column Remarks:
     *   学校名称
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.SCHOOL_NAME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String schoolName;

    /**
     * Database Column Remarks:
     *   学校简称
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.SCHOOL_SHORTNAME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String schoolShortname;

    /**
     * Database Column Remarks:
     *   省编码
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.AREA_CODE_PROVINCE
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String areaCodeProvince;

    /**
     * Database Column Remarks:
     *   省描述
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.AREA_DESC_PROVINCE
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String areaDescProvince;

    /**
     * Database Column Remarks:
     *   市编码
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.AREA_CODE_CITY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String areaCodeCity;

    /**
     * Database Column Remarks:
     *   市描述
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.AREA_DESC_CITY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String areaDescCity;

    /**
     * Database Column Remarks:
     *   区县编码
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.AREA_CODE_COUNTY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String areaCodeCounty;

    /**
     * Database Column Remarks:
     *   区县描述
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.AREA_DESC_COUNTY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String areaDescCounty;

    /**
     * Database Column Remarks:
     *   联系人姓名
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.CONTACT_NAME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String contactName;

    /**
     * Database Column Remarks:
     *   联系人电话
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.TEL_NO
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String telNo;

    /**
     * Database Column Remarks:
     *   学校地址
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.ADDRESS
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String address;

    /**
     * Database Column Remarks:
     *   是否删除【N：未删除   Y：已删除】
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.IS_DELETE
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String isDelete;

    /**
     * Database Column Remarks:
     *   变化标识(ADD、DEL、MOD)
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.PKG
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String pkg;

    /**
     * Database Column Remarks:
     *   创建者姓名
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.CREATE_PERSON
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String createPerson;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.CREATE_TIME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   更新者姓名
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.UPDATE_PERSON
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String updatePerson;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.UPDATE_TIME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private Date updateTime;

    /**
     * Database Column Remarks:
     *   k:幼儿园 p:小学  j:初中  s:高中
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column sys_t_school_info.SCHOOL_LEVEL
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    private String schoolLevel;

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.SCHOOL_ID
     *
     * @return the value of sys_t_school_info.SCHOOL_ID
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public Long getSchoolId() {
        return schoolId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.SCHOOL_ID
     *
     * @param schoolId the value for sys_t_school_info.SCHOOL_ID
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.SCHOOL_NAME
     *
     * @return the value of sys_t_school_info.SCHOOL_NAME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.SCHOOL_NAME
     *
     * @param schoolName the value for sys_t_school_info.SCHOOL_NAME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.SCHOOL_SHORTNAME
     *
     * @return the value of sys_t_school_info.SCHOOL_SHORTNAME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getSchoolShortname() {
        return schoolShortname;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.SCHOOL_SHORTNAME
     *
     * @param schoolShortname the value for sys_t_school_info.SCHOOL_SHORTNAME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setSchoolShortname(String schoolShortname) {
        this.schoolShortname = schoolShortname == null ? null : schoolShortname.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.AREA_CODE_PROVINCE
     *
     * @return the value of sys_t_school_info.AREA_CODE_PROVINCE
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getAreaCodeProvince() {
        return areaCodeProvince;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.AREA_CODE_PROVINCE
     *
     * @param areaCodeProvince the value for sys_t_school_info.AREA_CODE_PROVINCE
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setAreaCodeProvince(String areaCodeProvince) {
        this.areaCodeProvince = areaCodeProvince == null ? null : areaCodeProvince.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.AREA_DESC_PROVINCE
     *
     * @return the value of sys_t_school_info.AREA_DESC_PROVINCE
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getAreaDescProvince() {
        return areaDescProvince;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.AREA_DESC_PROVINCE
     *
     * @param areaDescProvince the value for sys_t_school_info.AREA_DESC_PROVINCE
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setAreaDescProvince(String areaDescProvince) {
        this.areaDescProvince = areaDescProvince == null ? null : areaDescProvince.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.AREA_CODE_CITY
     *
     * @return the value of sys_t_school_info.AREA_CODE_CITY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getAreaCodeCity() {
        return areaCodeCity;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.AREA_CODE_CITY
     *
     * @param areaCodeCity the value for sys_t_school_info.AREA_CODE_CITY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setAreaCodeCity(String areaCodeCity) {
        this.areaCodeCity = areaCodeCity == null ? null : areaCodeCity.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.AREA_DESC_CITY
     *
     * @return the value of sys_t_school_info.AREA_DESC_CITY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getAreaDescCity() {
        return areaDescCity;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.AREA_DESC_CITY
     *
     * @param areaDescCity the value for sys_t_school_info.AREA_DESC_CITY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setAreaDescCity(String areaDescCity) {
        this.areaDescCity = areaDescCity == null ? null : areaDescCity.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.AREA_CODE_COUNTY
     *
     * @return the value of sys_t_school_info.AREA_CODE_COUNTY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getAreaCodeCounty() {
        return areaCodeCounty;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.AREA_CODE_COUNTY
     *
     * @param areaCodeCounty the value for sys_t_school_info.AREA_CODE_COUNTY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setAreaCodeCounty(String areaCodeCounty) {
        this.areaCodeCounty = areaCodeCounty == null ? null : areaCodeCounty.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.AREA_DESC_COUNTY
     *
     * @return the value of sys_t_school_info.AREA_DESC_COUNTY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getAreaDescCounty() {
        return areaDescCounty;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.AREA_DESC_COUNTY
     *
     * @param areaDescCounty the value for sys_t_school_info.AREA_DESC_COUNTY
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setAreaDescCounty(String areaDescCounty) {
        this.areaDescCounty = areaDescCounty == null ? null : areaDescCounty.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.CONTACT_NAME
     *
     * @return the value of sys_t_school_info.CONTACT_NAME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.CONTACT_NAME
     *
     * @param contactName the value for sys_t_school_info.CONTACT_NAME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.TEL_NO
     *
     * @return the value of sys_t_school_info.TEL_NO
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.TEL_NO
     *
     * @param telNo the value for sys_t_school_info.TEL_NO
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.ADDRESS
     *
     * @return the value of sys_t_school_info.ADDRESS
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.ADDRESS
     *
     * @param address the value for sys_t_school_info.ADDRESS
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.IS_DELETE
     *
     * @return the value of sys_t_school_info.IS_DELETE
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.IS_DELETE
     *
     * @param isDelete the value for sys_t_school_info.IS_DELETE
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.PKG
     *
     * @return the value of sys_t_school_info.PKG
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getPkg() {
        return pkg;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.PKG
     *
     * @param pkg the value for sys_t_school_info.PKG
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setPkg(String pkg) {
        this.pkg = pkg == null ? null : pkg.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.CREATE_PERSON
     *
     * @return the value of sys_t_school_info.CREATE_PERSON
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getCreatePerson() {
        return createPerson;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.CREATE_PERSON
     *
     * @param createPerson the value for sys_t_school_info.CREATE_PERSON
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.CREATE_TIME
     *
     * @return the value of sys_t_school_info.CREATE_TIME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.CREATE_TIME
     *
     * @param createTime the value for sys_t_school_info.CREATE_TIME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.UPDATE_PERSON
     *
     * @return the value of sys_t_school_info.UPDATE_PERSON
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getUpdatePerson() {
        return updatePerson;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.UPDATE_PERSON
     *
     * @param updatePerson the value for sys_t_school_info.UPDATE_PERSON
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson == null ? null : updatePerson.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.UPDATE_TIME
     *
     * @return the value of sys_t_school_info.UPDATE_TIME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.UPDATE_TIME
     *
     * @param updateTime the value for sys_t_school_info.UPDATE_TIME
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column sys_t_school_info.SCHOOL_LEVEL
     *
     * @return the value of sys_t_school_info.SCHOOL_LEVEL
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String getSchoolLevel() {
        return schoolLevel;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column sys_t_school_info.SCHOOL_LEVEL
     *
     * @param schoolLevel the value for sys_t_school_info.SCHOOL_LEVEL
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public void setSchoolLevel(String schoolLevel) {
        this.schoolLevel = schoolLevel == null ? null : schoolLevel.trim();
    }
}