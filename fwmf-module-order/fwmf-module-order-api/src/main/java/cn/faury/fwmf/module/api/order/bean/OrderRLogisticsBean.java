package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.OrderRLogisticsGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

public class OrderRLogisticsBean extends OrderRLogisticsGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {
    @Override
    public Long getPrimaryKey() {
        return getId();
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }

    /**
     * 物流状态
     */
    public enum LogisticsState {
        NO_TRACE("0", "待发货"), WAITING("1", "待揽件"), EN_ROUTE("2", "在途中"), SIGNED_IN("3", "已签收"), PROBLEM("4", "问题件");

        private String code;
        private String desc;

        private LogisticsState(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 编码转化为对象
         */
        public static Optional<LogisticsState> parse(String code) {
            return Arrays.stream(LogisticsState.values())
                    .filter(value -> value.code.equals(code))
                    .findFirst();
        }

        /**
         * 获取code
         *
         * @return code
         */
        public String getCode() {
            return code;
        }

        /**
         * 获取desc
         *
         * @return desc
         */
        public String getDesc() {
            return desc;
        }
    }

}
