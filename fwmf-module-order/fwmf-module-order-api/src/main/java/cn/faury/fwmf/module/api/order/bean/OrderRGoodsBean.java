package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.order.generate.bean.OrderRGoodsGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * POJO对象：订单商品关联表
 *
 * <pre>
 *     OrderRGoodsGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自OrderRGoodsGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OrderRGoodsBean extends OrderRGoodsGenerateBean implements PrimaryKeyEnableBean<Long>, OrderRGoodsBeanEnable, Serializable {

    /**
     * 获取表主键字段名(自动生成代码)
     *
     * @return 主键字段名
     */
    @Override
    public String getPrimaryKeyName() {
        return "ORDER_R_GOODS_ID";
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKeyValue() {
        return this.getOrderRGoodsId();
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

    public enum GoodsType{
        Goods("goods", "单个商品"), Package("package", "套装组合"), ;

        private String code;
        private String desc;

        private GoodsType(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 编码转化为对象
         */
        public static Optional<GoodsType> parse(String code) {
            return Arrays.stream(GoodsType.values())
                    .filter(value -> value.code.equals(code))
                    .findFirst();
        }

        public String getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }


    }
}