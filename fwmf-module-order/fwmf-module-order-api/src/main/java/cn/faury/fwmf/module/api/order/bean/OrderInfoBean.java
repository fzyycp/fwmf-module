package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.OrderInfoGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * POJO对象：订单信息表
 *
 * <pre>
 *     OrderInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自OrderInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OrderInfoBean extends OrderInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    // 订单商品信息
    private List<OrderRGoodsBean> goodsList;

    /**
     * 获取goodsList
     *
     * @return goodsList
     */
    public List<OrderRGoodsBean> getGoodsList() {
        return goodsList;
    }

    /**
     * 设置goodsList
     *
     * @param goodsList 值
     */
    public void setGoodsList(List<OrderRGoodsBean> goodsList) {
        this.goodsList = goodsList;
    }

    /**
     * 获取表主键字段名(自动生成代码)
     *
     * @return 主键字段名
     */
    @Override
    public String getPrimaryKeyName() {
        return "ORDER_ID";
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKeyValue() {
        return this.getOrderId();
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
     * 订单状态
     */
    public enum OrderState{
        UNPAID("0", "未支付"), PAID("1", "已支付"), CANCELLED("2", "已取消"), DELETED("3", "已删除");

        private String code;
        private String desc;

        private OrderState(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 编码转化为对象
         */
        public static Optional<OrderState> parse(String code) {
            return Arrays.stream(OrderState.values())
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
     * 交易状态
     */
    public enum TradeState{
        UNSHIPPED("0", "未发货"), SHIPPED("1", "已发货"), CONFIRMED("2", "已确认"), EVALUATED("3", "已评价");

        private String code;
        private String desc;

        private TradeState(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 编码转化为对象
         */
        public static Optional<TradeState> parse(String code) {
            return Arrays.stream(TradeState.values())
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