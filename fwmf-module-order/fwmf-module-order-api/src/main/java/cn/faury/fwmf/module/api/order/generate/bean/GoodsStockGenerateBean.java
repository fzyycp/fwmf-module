package cn.faury.fwmf.module.api.order.generate.bean;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table order_t_goods_stock_info
 */
public class GoodsStockGenerateBean {
    /**
     * Database Column Remarks:
     *   ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_goods_stock_info.ID
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   商品ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_goods_stock_info.GOODS_ID
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    private Long goodsId;

    /**
     * Database Column Remarks:
     *   库存
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_goods_stock_info.STOCK
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    private Integer stock;

    /**
     * Database Column Remarks:
     *   备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_goods_stock_info.DEMO
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    private String demo;

    /**
     * Database Column Remarks:
     *   创建人姓名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_goods_stock_info.CREATE_PERSON
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    private String createPerson;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_goods_stock_info.CREATE_TIME
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    private Date createTime;

    /**
     * Database Column Remarks:
     *   是否删除【N：未删除  Y：已删除】
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_t_goods_stock_info.IS_DELETE
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    private String isDelete;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_goods_stock_info.ID
     *
     * @return the value of order_t_goods_stock_info.ID
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_goods_stock_info.ID
     *
     * @param id the value for order_t_goods_stock_info.ID
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_goods_stock_info.GOODS_ID
     *
     * @return the value of order_t_goods_stock_info.GOODS_ID
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public Long getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_goods_stock_info.GOODS_ID
     *
     * @param goodsId the value for order_t_goods_stock_info.GOODS_ID
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_goods_stock_info.STOCK
     *
     * @return the value of order_t_goods_stock_info.STOCK
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_goods_stock_info.STOCK
     *
     * @param stock the value for order_t_goods_stock_info.STOCK
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_goods_stock_info.DEMO
     *
     * @return the value of order_t_goods_stock_info.DEMO
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public String getDemo() {
        return demo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_goods_stock_info.DEMO
     *
     * @param demo the value for order_t_goods_stock_info.DEMO
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public void setDemo(String demo) {
        this.demo = demo == null ? null : demo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_goods_stock_info.CREATE_PERSON
     *
     * @return the value of order_t_goods_stock_info.CREATE_PERSON
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public String getCreatePerson() {
        return createPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_goods_stock_info.CREATE_PERSON
     *
     * @param createPerson the value for order_t_goods_stock_info.CREATE_PERSON
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_goods_stock_info.CREATE_TIME
     *
     * @return the value of order_t_goods_stock_info.CREATE_TIME
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_goods_stock_info.CREATE_TIME
     *
     * @param createTime the value for order_t_goods_stock_info.CREATE_TIME
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_t_goods_stock_info.IS_DELETE
     *
     * @return the value of order_t_goods_stock_info.IS_DELETE
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_t_goods_stock_info.IS_DELETE
     *
     * @param isDelete the value for order_t_goods_stock_info.IS_DELETE
     *
     * @mbg.generated Sun Aug 05 23:04:46 CST 2018
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}