/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-15 08:50:34
 */
package cn.faury.fwmf.module.api.category.generate.bean;

/**
 * Database Table Remarks:
 *   分类关联标签表
 *
 * This class was generated by Fwmf Generated.
 * This class corresponds to the database table product_t_category_r_tag
 *
 * @fwmf.generated 2018-11-15 08:50:34
 */
public class CategoryRTagGenerateBean {
    /**
     * Database Column Remarks:
     *   唯一标志
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_category_r_tag.ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   分类ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_category_r_tag.PRODUCT_CATEGORY_ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    private Long productCategoryId;

    /**
     * Database Column Remarks:
     *   标签组ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_category_r_tag.TAG_CATEGORY_ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    private Long tagCategoryId;

    /**
     * Database Column Remarks:
     *   标签ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_category_r_tag.TAG_ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    private Long tagId;

    /**
     * Database Column Remarks:
     *   排序
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column product_t_category_r_tag.DISPLAY_ORDER
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    private Integer displayOrder;

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_category_r_tag.ID
     *
     * @return the value of product_t_category_r_tag.ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_category_r_tag.ID
     *
     * @param id the value for product_t_category_r_tag.ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_category_r_tag.PRODUCT_CATEGORY_ID
     *
     * @return the value of product_t_category_r_tag.PRODUCT_CATEGORY_ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    public Long getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_category_r_tag.PRODUCT_CATEGORY_ID
     *
     * @param productCategoryId the value for product_t_category_r_tag.PRODUCT_CATEGORY_ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_category_r_tag.TAG_CATEGORY_ID
     *
     * @return the value of product_t_category_r_tag.TAG_CATEGORY_ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    public Long getTagCategoryId() {
        return tagCategoryId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_category_r_tag.TAG_CATEGORY_ID
     *
     * @param tagCategoryId the value for product_t_category_r_tag.TAG_CATEGORY_ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    public void setTagCategoryId(Long tagCategoryId) {
        this.tagCategoryId = tagCategoryId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_category_r_tag.TAG_ID
     *
     * @return the value of product_t_category_r_tag.TAG_ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    public Long getTagId() {
        return tagId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_category_r_tag.TAG_ID
     *
     * @param tagId the value for product_t_category_r_tag.TAG_ID
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column product_t_category_r_tag.DISPLAY_ORDER
     *
     * @return the value of product_t_category_r_tag.DISPLAY_ORDER
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    public Integer getDisplayOrder() {
        return displayOrder;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column product_t_category_r_tag.DISPLAY_ORDER
     *
     * @param displayOrder the value for product_t_category_r_tag.DISPLAY_ORDER
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}