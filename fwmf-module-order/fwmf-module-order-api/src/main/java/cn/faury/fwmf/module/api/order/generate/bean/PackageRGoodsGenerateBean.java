/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-12-08 15:12:42
 */
package cn.faury.fwmf.module.api.order.generate.bean;

/**
 * Database Table Remarks:
 *   套餐关联表
 *
 * This class was generated by Fwmf Generated.
 * This class corresponds to the database table order_t_package_r_goods
 *
 * @fwmf.generated 2018-12-08 15:12:42
 */
public class PackageRGoodsGenerateBean {
    /**
     * Database Column Remarks:
     *   ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column order_t_package_r_goods.ID
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   套餐ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column order_t_package_r_goods.PACKAGE_ID
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    private Long packageId;

    /**
     * Database Column Remarks:
     *   商品ID
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column order_t_package_r_goods.GOODS_ID
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    private Long goodsId;

    /**
     * Database Column Remarks:
     *   类型
     *
     * This field was generated by Fwmf Generated.
     * This field corresponds to the database column order_t_package_r_goods.GOODS_TYPE
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    private String goodsType;

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column order_t_package_r_goods.ID
     *
     * @return the value of order_t_package_r_goods.ID
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column order_t_package_r_goods.ID
     *
     * @param id the value for order_t_package_r_goods.ID
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column order_t_package_r_goods.PACKAGE_ID
     *
     * @return the value of order_t_package_r_goods.PACKAGE_ID
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public Long getPackageId() {
        return packageId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column order_t_package_r_goods.PACKAGE_ID
     *
     * @param packageId the value for order_t_package_r_goods.PACKAGE_ID
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column order_t_package_r_goods.GOODS_ID
     *
     * @return the value of order_t_package_r_goods.GOODS_ID
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column order_t_package_r_goods.GOODS_ID
     *
     * @param goodsId the value for order_t_package_r_goods.GOODS_ID
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method returns the value of the database column order_t_package_r_goods.GOODS_TYPE
     *
     * @return the value of order_t_package_r_goods.GOODS_TYPE
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method sets the value of the database column order_t_package_r_goods.GOODS_TYPE
     *
     * @param goodsType the value for order_t_package_r_goods.GOODS_TYPE
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }
}