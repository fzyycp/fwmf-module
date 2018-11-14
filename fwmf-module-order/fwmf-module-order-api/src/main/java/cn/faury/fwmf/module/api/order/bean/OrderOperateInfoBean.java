package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.order.generate.bean.OrderOperateInfoGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * POJO对象：订单操作日志表
 *
 * <pre>
 *     OrderOperateInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自OrderOperateInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OrderOperateInfoBean extends OrderOperateInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

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