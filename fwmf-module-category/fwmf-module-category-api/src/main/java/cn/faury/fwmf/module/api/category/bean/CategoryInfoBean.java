package cn.faury.fwmf.module.api.category.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 分类Bean对象
 */
public class CategoryInfoBean implements Serializable {

    /**
     * 主键,分类ID
     */
    private Long productCategoryId;

    /**
     * 分类ID+用途（id:templateId）
     */
    private String cateTempId;

    /**
     * 分类名称
     */
    private String productCategoryName;

    /**
     * 显示顺序
     */
    private Integer displayOrder;

    /**
     * 上级分类ID
     */
    private Long parentId;

    /**
     * 模板ID
     */
    private Long templateId;

    /**
     * 用途
     */
    private List<Long> templateIdList;

    /**
     * 创建者
     */
    private String createPersonName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updatePersonName;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标志
     */
    private String delFlag;

    /**
     * 全路径
     */
    private String xpath;

    /**
     * @return the productCategoryId
     */
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * @param productCategoryId the productCategoryId to set
     */
    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * @return the cateTempId
     */
    public String getCateTempId() {
        return cateTempId;
    }

    /**
     * @param cateTempId the cateTempId to set
     */
    public void setCateTempId(String cateTempId) {
        this.cateTempId = cateTempId;
    }

    /**
     * @return the productCategoryName
     */
    public String getProductCategoryName() {
        return productCategoryName;
    }

    /**
     * @param productCategoryName the productCategoryName to set
     */
    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    /**
     * @return the displayOrder
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * @param displayOrder the displayOrder to set
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the templateId
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId the templateId to set
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * @return the templateIdList
     */
    public List<Long> getTemplateIdList() {
        return templateIdList;
    }

    /**
     * @param templateIdList the templateIdList to set
     */
    public void setTemplateIdList(List<Long> templateIdList) {
        this.templateIdList = templateIdList;
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
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
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
     * @return the xpath
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * @param xpath the xpath to set
     */
    public void setXpath(String xpath) {
        this.xpath = xpath;
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
