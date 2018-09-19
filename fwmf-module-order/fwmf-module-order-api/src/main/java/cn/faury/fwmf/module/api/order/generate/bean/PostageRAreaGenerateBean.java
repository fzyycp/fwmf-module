package cn.faury.fwmf.module.api.order.generate.bean;

import java.math.BigDecimal;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table order_t_postage_r_area
 */
public class PostageRAreaGenerateBean {
    /**
     * Database Column Remarks:
     *   唯一标志，无业务意义
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_postage_r_area.ID
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   邮费ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_postage_r_area.POSTAGE_ID
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    private Long postageId;

    /**
     * Database Column Remarks:
     *   省份编码，多个以逗号隔开
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_postage_r_area.AREA_CODE_PROVINCE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    private String areaCodeProvince;

    /**
     * Database Column Remarks:
     *   省份描述，多个以逗号隔开
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_postage_r_area.AREA_DESC_PROVINCE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    private String areaDescProvince;

    /**
     * Database Column Remarks:
     *   基础商品数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_postage_r_area.GOODS_COUNT
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    private Integer goodsCount;

    /**
     * Database Column Remarks:
     *   基础配送费
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_postage_r_area.POSTAGE_PRICE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    private BigDecimal postagePrice;

    /**
     * Database Column Remarks:
     *   增加商品数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_postage_r_area.INCREASE_GOODS_COUNT
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    private Integer increaseGoodsCount;

    /**
     * Database Column Remarks:
     *   增加配送费
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_postage_r_area.INCREASE_POSTAGE_PRICE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    private BigDecimal increasePostagePrice;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_postage_r_area.ID
     *
     * @return the value of order_t_postage_r_area.ID
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_postage_r_area.ID
     *
     * @param id the value for order_t_postage_r_area.ID
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_postage_r_area.POSTAGE_ID
     *
     * @return the value of order_t_postage_r_area.POSTAGE_ID
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public Long getPostageId() {
        return postageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_postage_r_area.POSTAGE_ID
     *
     * @param postageId the value for order_t_postage_r_area.POSTAGE_ID
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public void setPostageId(Long postageId) {
        this.postageId = postageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_postage_r_area.AREA_CODE_PROVINCE
     *
     * @return the value of order_t_postage_r_area.AREA_CODE_PROVINCE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public String getAreaCodeProvince() {
        return areaCodeProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_postage_r_area.AREA_CODE_PROVINCE
     *
     * @param areaCodeProvince the value for order_t_postage_r_area.AREA_CODE_PROVINCE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public void setAreaCodeProvince(String areaCodeProvince) {
        this.areaCodeProvince = areaCodeProvince == null ? null : areaCodeProvince.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_postage_r_area.AREA_DESC_PROVINCE
     *
     * @return the value of order_t_postage_r_area.AREA_DESC_PROVINCE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public String getAreaDescProvince() {
        return areaDescProvince;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_postage_r_area.AREA_DESC_PROVINCE
     *
     * @param areaDescProvince the value for order_t_postage_r_area.AREA_DESC_PROVINCE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public void setAreaDescProvince(String areaDescProvince) {
        this.areaDescProvince = areaDescProvince == null ? null : areaDescProvince.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_postage_r_area.GOODS_COUNT
     *
     * @return the value of order_t_postage_r_area.GOODS_COUNT
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public Integer getGoodsCount() {
        return goodsCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_postage_r_area.GOODS_COUNT
     *
     * @param goodsCount the value for order_t_postage_r_area.GOODS_COUNT
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_postage_r_area.POSTAGE_PRICE
     *
     * @return the value of order_t_postage_r_area.POSTAGE_PRICE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public BigDecimal getPostagePrice() {
        return postagePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_postage_r_area.POSTAGE_PRICE
     *
     * @param postagePrice the value for order_t_postage_r_area.POSTAGE_PRICE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public void setPostagePrice(BigDecimal postagePrice) {
        this.postagePrice = postagePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_postage_r_area.INCREASE_GOODS_COUNT
     *
     * @return the value of order_t_postage_r_area.INCREASE_GOODS_COUNT
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public Integer getIncreaseGoodsCount() {
        return increaseGoodsCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_postage_r_area.INCREASE_GOODS_COUNT
     *
     * @param increaseGoodsCount the value for order_t_postage_r_area.INCREASE_GOODS_COUNT
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public void setIncreaseGoodsCount(Integer increaseGoodsCount) {
        this.increaseGoodsCount = increaseGoodsCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_postage_r_area.INCREASE_POSTAGE_PRICE
     *
     * @return the value of order_t_postage_r_area.INCREASE_POSTAGE_PRICE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public BigDecimal getIncreasePostagePrice() {
        return increasePostagePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_postage_r_area.INCREASE_POSTAGE_PRICE
     *
     * @param increasePostagePrice the value for order_t_postage_r_area.INCREASE_POSTAGE_PRICE
     *
     * @mbg.generated Sat Aug 04 20:36:28 CST 2018
     */
    public void setIncreasePostagePrice(BigDecimal increasePostagePrice) {
        this.increasePostagePrice = increasePostagePrice;
    }
}