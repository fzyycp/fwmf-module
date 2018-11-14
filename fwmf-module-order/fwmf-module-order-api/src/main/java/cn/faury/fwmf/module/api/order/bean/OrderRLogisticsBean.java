package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.OrderRLogisticsGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * POJO对象：订单物流信息表
 *
 * <pre>
 *     OrderRLogisticsGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自OrderRLogisticsGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OrderRLogisticsBean extends OrderRLogisticsGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    /**
     * 获取表主键字段名(自动生成代码)
     *
     * @return 主键字段名
     */
    @Override
    public String getPrimaryKeyName() {
        return "ID";
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKeyValue() {
        return this.getId();
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
