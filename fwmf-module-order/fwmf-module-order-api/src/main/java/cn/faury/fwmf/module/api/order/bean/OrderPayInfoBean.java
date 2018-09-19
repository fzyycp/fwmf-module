package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.OrderPayInfoGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * 订单支付信息
 */
public class OrderPayInfoBean extends OrderPayInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    @Override
    public Long getPrimaryKey() {
        return this.getId();
    }

    public enum PayStyle {
        PLATFORM("platform", "平台支付"), ALIPAY("alipay", "支付宝支付"), WEIXIN("weixin", "微信支付");

        private String code;
        private String desc;

        private PayStyle(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 编码转化为对象
         */
        public static Optional<PayStyle> parse(String code) {
            return Arrays.stream(PayStyle.values())
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