/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-14 17:14:30
 */
package cn.faury.fwmf.module.api.category.generate.bean;

/**
 * Database Table Remarks:
 *   标签信息表
 *
 * This class was generated by Fwmf Generated.
 * This class corresponds to the database table product_t_tag_info
 *
 * @fwmf.generated 2018-11-14 17:14:30
 */
public class TagInfoGenerateBean {
    /**
     * Database Column Remarks:
     *   标签ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_tag_info.TAG_ID
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    private Long tagId;

    /**
     * Database Column Remarks:
     *   标签编码
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_tag_info.TAG_CODE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    private String tagCode;

    /**
     * Database Column Remarks:
     *   标签值
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_tag_info.TAG_VALUE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    private String tagValue;

    /**
     * Database Column Remarks:
     *   标签类型（01：标签分组  02：标签值）
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_tag_info.TAG_TYPE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    private String tagType;

    /**
     * Database Column Remarks:
     *   显示顺序
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_tag_info.DISPLAY_ORDER
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    private Integer displayOrder;

    /**
     * Database Column Remarks:
     *   父ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_tag_info.PARENT_ID
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    private Long parentId;

    /**
     * Database Column Remarks:
     *   全路径
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_tag_info.XPATH
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    private String xpath;

    /**
     * Database Column Remarks:
     *   是否删除（Y：是  N：否）
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_tag_info.IS_DELETE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    private String isDelete;

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_tag_info.TAG_ID
     *
     * @return the value of product_t_tag_info.TAG_ID
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_tag_info.TAG_ID
     *
     * @param tagId the value for product_t_tag_info.TAG_ID
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_tag_info.TAG_CODE
     *
     * @return the value of product_t_tag_info.TAG_CODE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public String getTagCode() {
        return tagCode;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_tag_info.TAG_CODE
     *
     * @param tagCode the value for product_t_tag_info.TAG_CODE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public void setTagCode(String tagCode) {
        this.tagCode = tagCode == null ? null : tagCode.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_tag_info.TAG_VALUE
     *
     * @return the value of product_t_tag_info.TAG_VALUE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public String getTagValue() {
        return tagValue;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_tag_info.TAG_VALUE
     *
     * @param tagValue the value for product_t_tag_info.TAG_VALUE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public void setTagValue(String tagValue) {
        this.tagValue = tagValue == null ? null : tagValue.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_tag_info.TAG_TYPE
     *
     * @return the value of product_t_tag_info.TAG_TYPE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public String getTagType() {
        return tagType;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_tag_info.TAG_TYPE
     *
     * @param tagType the value for product_t_tag_info.TAG_TYPE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public void setTagType(String tagType) {
        this.tagType = tagType == null ? null : tagType.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_tag_info.DISPLAY_ORDER
     *
     * @return the value of product_t_tag_info.DISPLAY_ORDER
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_tag_info.DISPLAY_ORDER
     *
     * @param displayOrder the value for product_t_tag_info.DISPLAY_ORDER
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_tag_info.PARENT_ID
     *
     * @return the value of product_t_tag_info.PARENT_ID
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_tag_info.PARENT_ID
     *
     * @param parentId the value for product_t_tag_info.PARENT_ID
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_tag_info.XPATH
     *
     * @return the value of product_t_tag_info.XPATH
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_tag_info.XPATH
     *
     * @param xpath the value for product_t_tag_info.XPATH
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public void setXpath(String xpath) {
        this.xpath = xpath == null ? null : xpath.trim();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_tag_info.IS_DELETE
     *
     * @return the value of product_t_tag_info.IS_DELETE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_tag_info.IS_DELETE
     *
     * @param isDelete the value for product_t_tag_info.IS_DELETE
     *
     * @fwmf.generated 2018-11-14 17:14:30
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}