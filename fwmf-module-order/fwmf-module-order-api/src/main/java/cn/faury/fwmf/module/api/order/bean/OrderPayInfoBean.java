package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.order.generate.bean.OrderPayInfoGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * POJO对象：订单支付信息表
 *
 * <pre>
 *     OrderPayInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自OrderPayInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OrderPayInfoBean extends OrderPayInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

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