package cn.faury.fwmf.module.service.constant;

public interface DBConstOfOrder {

    /**
     * 订单模块：邮费信息表
     */
    public static final String ORDER_T_POSTAGE_INFO = "order_t_postage_info";

    /**
     * 订单模块：邮费关联地区信息表
     */
    public static final String ORDER_T_POSTAGE_R_AREA = "order_t_postage_r_area";

    /**
     * 订单模块：订单信息表
     */
    public static final String ORDER_T_CUSTOMER_ADDRESS = "order_t_customer_address";

    /**
     * 订单模块：订单信息表
     */
    public static final String ORDER_T_ORDER_INFO = "order_t_order_info";

    /**
     * 订单模块：订单商品关联表
     */
    public static final String ORDER_T_ORDER_R_GOODS = "order_t_order_r_goods";

    /**
     * 订单模块：优惠活动信息表
     */
    public static final String ORDER_T_PROMOTION_INFO = "order_t_promotion_info";

    /**
     * 订单模块：商品库存信息表
     */
    public static final String ORDER_T_GOODS_STOCK_INFO = "order_t_goods_stock_info";

    /**
     * 订单模块：订单操作日志表
     */
    public static final String ORDER_T_ORDER_OPERATE_INFO = "order_t_order_operate_info";

    /**
     * 订单模块：订单支付信息表
     */
    public static final String ORDER_T_ORDER_PAY_INFO = "order_t_order_pay_info";

    /**
     * 订单模块：套餐基本信息表
     */
    public static final String ORDER_T_PACKAGE_INFO = "order_t_package_info";

    /**
     * 订单模块：套餐关联表
     */
    public static final String ORDER_T_PACKAGE_R_GOODS = "order_t_package_r_goods";

    /**
     * 订单模块：订单物流信息表
     */
    public static final String ORDER_T_ORDER_R_LOGISTICS = "order_t_order_r_logistics";

    /**
     * 微信支付请求记录
     */
    public static final String PAYMENT_T_WEIXIN_PAY_RECORDS = "payment_t_weixin_pay_records";

    /**
     * 微信支付回调记录
     */
    public static final String PAYMENT_T_WEIXIN_CALLBACK_RECORDS = "payment_t_weixin_callback_records";

    /**
     * 支付宝支付请求记录
     */
    public static final String PAYMENT_T_ALIPAY_RECORDS = "payment_t_alipay_records";

    /**
     * 支付宝支付回调记录
     */
    public static final String PAYMENT_T_ALIPAY_CALLBACK_RECORDS = "payment_t_alipay_callback_records";

}
