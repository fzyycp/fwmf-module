package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.PromotionInfoGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

/**
 * POJO对象：订单模块：优惠活动信息表
 *
 * <pre>
 *     PromotionInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自PromotionInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */

public class PromotionInfoBean extends PromotionInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    /**
     * 获取表主键字段名(自动生成代码)
     *
     * @return 主键字段名
     */
    @Override
    public String getPrimaryKeyName() {
        return "PROMOTION_ID";
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKeyValue() {
        return this.getPromotionId();
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
     * 获取文字描述
     */
    public String getDescription() {
        StringBuilder desc = new StringBuilder();
        if (Condition.PRICE.getCode().equals(this.getPromotionCondition())) {
            desc.append("满").append(this.getConditionValue()).append("元");
        } else if (Condition.COUNT.getCode().equals(this.getPromotionCondition())) {
            desc.append("满").append(this.getConditionValue().intValue()).append("件");
        }

        if (Subject.GOODS.getCode().equals(this.getPromotionSubject())) {
            if (MeetOperation.SUBTRACT.getCode().equals(this.getMeetOperation())) {
                desc.append(" 减").append(this.getMeetValue()).append("元");
            } else if (MeetOperation.DISCOUNT.getCode().equals(this.getMeetOperation())) {
                desc.append(" 打").append(this.getMeetValue().multiply(BigDecimal.TEN)).append("折");
            }
        } else if (Subject.POST.getCode().equals(this.getPromotionSubject())){
            if (MeetOperation.SET.getCode().equals(this.getMeetOperation())) {
                if (this.getMeetValue().compareTo(BigDecimal.ZERO) <= 0) {
                    desc.append(" 免邮费");
                } else {
                    desc.append(" 邮费为").append(this.getMeetValue()).append("元");
                }
            }
        }

        return desc.toString();
    }

    /**
     * 活动对象
     */
    public enum Subject {
        GOODS("00", "商品价格"), POST("01", "订单运费");

        private String code;
        private String desc;

        private Subject(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 编码转化为对象
         */
        public static Optional<Subject> parse(String code) {
            return Arrays.stream(Subject.values())
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

    /**
     * 活动条件
     */
    public enum Condition {
        COUNT("00", "数量型"), PRICE("01", "金额型");

        private String code;
        private String desc;

        private Condition(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 编码转化为对象
         */
        public static Optional<Condition> parse(String code) {
            return Arrays.stream(Condition.values())
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

    /**
     * 活动条件达成后计算方式
     */
    public enum MeetOperation {
        SET("set", "设值"), DISCOUNT("discount", "折扣"), SUBTRACT("subtract", "满减");

        private String code;
        private String desc;

        private MeetOperation(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 编码转化为对象
         */
        public static Optional<Condition> parse(String code) {
            return Arrays.stream(Condition.values())
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