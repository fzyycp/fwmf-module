package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.OrderOperateInfoGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * 订单处理日志信息
 */
public class OrderOperateInfoBean extends OrderOperateInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    @Override
    public Long getPrimaryKey() {
        return this.getId();
    }

    public enum OperateType {
        CREATE("1", "订单创建"), UPDATE("2", "订单修改"), PAID("3", "订单支付"), CANCEL("4", "订单取消"), FINISH("5", "订单完成"), DELETE("6", "订单删除");

        private String code;
        private String desc;

        private OperateType(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 编码转化为对象
         */
        public static Optional<OperateType> parse(String code) {
            return Arrays.stream(OperateType.values())
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