package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.OrderRGoodsGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * 订单商品信息表
 */
public class OrderRGoodsBean extends OrderRGoodsGenerateBean implements PrimaryKeyEnableBean<Long>, OrderRGoodsBeanEnable, Serializable {

    @Override
    public Long getPrimaryKey() {
        return this.getOrderRGoodsId();
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