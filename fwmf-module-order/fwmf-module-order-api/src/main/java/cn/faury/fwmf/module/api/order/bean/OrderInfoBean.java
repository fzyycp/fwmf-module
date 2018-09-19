package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.OrderInfoGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 订单信息表
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

    @Override
    public Long getPrimaryKey() {
        return this.getOrderId();
    }

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