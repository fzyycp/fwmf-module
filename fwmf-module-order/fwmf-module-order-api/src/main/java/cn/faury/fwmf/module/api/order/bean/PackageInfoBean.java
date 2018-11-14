package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.PackageInfoGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * POJO对象：套餐基本信息表
 *
 * <pre>
 *     PackageInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自PackageInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class PackageInfoBean extends PackageInfoGenerateBean implements PrimaryKeyEnableBean<Long>, OrderRGoodsBeanEnable, Serializable {

    /**
     * 邮费名称
     */
    private String postageName;

    /**
     * 套餐关联商品列表
     */
    private List<PackageRGoodsBean> goodsList;

    private List<OrderRGoodsBean> orderRGoodsBeanList;

    /**
     * 获取表主键字段名(自动生成代码)
     *
     * @return 主键字段名
     */
    @Override
    public String getPrimaryKeyName() {
        return "PACKAGE_ID";
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKeyValue() {
        return this.getPackageId();
    }

    /**
     * JSON序列化对象(自动生成代码)
     *
     * @return JSON化对象
     */
    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }

    /**
     * 获取商品数量
     */
    @Override
    public Integer getGoodsCount() {
        return 1;
    }

    /**
     * 获取购买总金额
     */
    @Override
    public BigDecimal getBuySubtotal() {
        return this.getPackagePrice();
    }

    /**
     * 保存计算完优惠信息后的付款总金额
     *
     * @param goodsPayPrice 商品支付价格
     */
    @Override
    public void setGoodsPayPrice(BigDecimal goodsPayPrice) {
        this.setPackagePrice(goodsPayPrice);
    }

    /**
     * 获取价格活动ID，套餐不参加活动
     */
    @Override
    public Long getPromotionPriceId() {
        return null;
    }

    /**
     * 获取邮费活动ID，套餐不参加活动
     */
    @Override
    public Long getPromotionPostId() {
        return null;
    }

    /**
     * 获取商品类型
     *
     * @return 商品类型
     */
    @Override
    public String getGoodsType() {
        return OrderRGoodsBean.GoodsType.Package.getCode();
    }

//////////////////////GET\SET

    /**
     * 获取postageName
     *
     * @return postageName
     */
    public String getPostageName() {
        return postageName;
    }

    /**
     * 设置postageName
     *
     * @param postageName 值
     */
    public void setPostageName(String postageName) {
        this.postageName = postageName;
    }

    /**
     * 获取goodsList
     *
     * @return goodsList
     */
    public List<PackageRGoodsBean> getGoodsList() {
        return goodsList;
    }

    /**
     * 设置goodsList
     *
     * @param goodsList 值
     */
    public void setGoodsList(List<PackageRGoodsBean> goodsList) {
        this.goodsList = goodsList;
    }

    /**
     * 获取orderRGoodsBeanList
     *
     * @return orderRGoodsBeanList
     */
    public List<OrderRGoodsBean> getOrderRGoodsBeanList() {
        return orderRGoodsBeanList;
    }

    /**
     * 设置orderRGoodsBeanList
     *
     * @param orderRGoodsBeanList 值
     */
    public void setOrderRGoodsBeanList(List<OrderRGoodsBean> orderRGoodsBeanList) {
        this.orderRGoodsBeanList = orderRGoodsBeanList;
    }
}