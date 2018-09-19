package cn.faury.fwmf.module.service.order.service;

import cn.faury.fwmf.module.api.order.bean.*;
import cn.faury.fwmf.module.api.order.service.*;
import cn.faury.fwmf.module.api.payment.bean.AlipayCallbackRecordsBean;
import cn.faury.fwmf.module.api.payment.bean.AlipayRecordsBean;
import cn.faury.fwmf.module.api.payment.bean.WeixinCallbackRecordsBean;
import cn.faury.fwmf.module.api.payment.bean.WeixinPayRecordsBean;
import cn.faury.fwmf.module.api.payment.service.AlipayRecordsService;
import cn.faury.fwmf.module.api.payment.service.WeixinPayRecordsService;
import cn.faury.fwmf.module.service.order.mapper.OrderInfoMapper;
import cn.faury.fdk.common.anotation.NonNull;
import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.exception.TipsException;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.DateUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

public class OrderInfoServiceImpl extends CrudBaseServiceImpl<OrderInfoBean, Long> implements OrderInfoService {

    // 记录日志
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 活动服务
    @Autowired(required = false)
    private PromotionInfoService promotionInfoService;

    @Autowired(required = false)
    private OrderRGoodsService orderRGoodsService;

    @Autowired(required = false)
    private GoodsStockService goodsStockService;

    @Autowired(required = false)
    private OrderOperateInfoService orderOperateInfoService;

    @Autowired(required = false)
    private OrderPayInfoService orderPayInfoService;

    @Autowired(required = false)
    private WeixinPayRecordsService weixinPayRecordsService;

    @Autowired(required = false)
    private AlipayRecordsService alipayRecordsService;

    @Autowired(required = false)
    private OrderRLogisticsService orderRLogisticsService;

    public OrderInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, OrderInfoMapper.class);
    }

    // 计算所有商品总价
    private BigDecimal sumOrderRGoodsPriceTotal(@NonNull List<? extends OrderRGoodsBeanEnable> goodsList) {
        return goodsList.stream().reduce(BigDecimal.ZERO, (sum, bean) -> sum.add(bean.getBuySubtotal()), BigDecimal::add);
    }

    /**
     * 获取活动ID到商品列表的映射Map
     *
     * @param goodsList 商品列表
     * @return 映射Map
     */
    private Map<Long, List<OrderRGoodsBeanEnable>> getOrderRGoodsBeanMap(List<? extends OrderRGoodsBeanEnable> goodsList) {
        // 活动到商品的归类：<活动ID，商品列表>
        final Map<Long, List<OrderRGoodsBeanEnable>> promotionRGoodsMap = new HashMap<>();
        // 拆分商品到不同类型的活动中，并计算各个商品的小计价格
        goodsList.stream()
                .filter(bean -> (bean.getPromotionPriceId() != null || bean.getPromotionPostId() != null))
                .forEach(bean -> {
                    // 价格活动
                    if (bean.getPromotionPriceId() != null) {
                        promotionRGoodsMap.computeIfAbsent(bean.getPromotionPriceId(), k -> new ArrayList<>());
                        promotionRGoodsMap.get(bean.getPromotionPriceId()).add(bean);
                    }
                    // 邮费活动
                    if (bean.getPromotionPostId() != null) {
                        promotionRGoodsMap.computeIfAbsent(bean.getPromotionPostId(), k -> new ArrayList<>());
                        promotionRGoodsMap.get(bean.getPromotionPostId()).add(bean);
                    }
                });
        return promotionRGoodsMap;
    }

    /**
     * 预处理订单，根据商品清单计算订单基本数据
     * <pre>
     *     返回数据：
     *          商品总数量、商品总金额、商品支付总金额(如果有活动即为减去活动的优惠额)
     *          订单运费、订单运费支付总金额(默认输入的运费)
     *          订单总金额、订单支付总金额
     * </pre>
     *
     * @param goodsList 商品列表
     * @param postPrice 运费
     */
    @Override
    public OrderInfoBean preProcessOrder(@NonNull List<? extends OrderRGoodsBeanEnable> goodsList, @NonNull BigDecimal postPrice) {
        AssertUtil.assertNotNull(postPrice, "商品邮费不可以为空");

        // 活动到商品的归类：<活动ID，商品列表>
        final Map<Long, List<OrderRGoodsBeanEnable>> promotionRGoodsMap = getOrderRGoodsBeanMap(goodsList);

        OrderInfoBean preOrder = new OrderInfoBean();
        // 商品总数量、商品总金额、商品支付总金额(如果有活动即为减去活动的优惠额)
        preOrder.setGoodsCount(goodsList.stream().reduce(0, (sum, bean) -> sum + bean.getGoodsCount(), (sum, count) -> sum + count));
        preOrder.setGoodsPrice(sumOrderRGoodsPriceTotal(goodsList));
        preOrder.setGoodsPayPrice(preOrder.getGoodsPrice());

        // 订单运费、订单运费支付总金额(默认输入的运费)
        preOrder.setPostPrice(postPrice);
        preOrder.setPostPayPrice(preOrder.getPostPrice());

        // 保存所有优惠活动的邮费，最后取最大值作为订单的邮费
        final List<BigDecimal> promotionPostList = new ArrayList<>();

        // 活动服务启用
        if (promotionInfoService != null && promotionRGoodsMap.size() > 0) {
            // 获取所有优惠活动对象
            List<PromotionInfoBean> promotionInfoList = promotionInfoService.getBeanListByIds(promotionRGoodsMap.keySet());
            // 存在活动
            if (promotionInfoList != null && promotionInfoList.size() > 0) {
                // 计算每个活动中所有商品的优惠金额
                promotionInfoList.forEach(promotionInfoBean -> {
                    // a,获取活动的商品列表
                    List<OrderRGoodsBeanEnable> goodsBeanList = promotionRGoodsMap.get(promotionInfoBean.getPromotionId());
                    // 活动条件是否达到标志
                    boolean promotionReach = isPromotionReach(goodsBeanList, promotionInfoBean);
                    logger.trace("==计算活动条件达成结果为{}", promotionReach);
                    // 活动达成，则将减免的金额分摊到各个商品中
                    if (promotionReach) {
                        if (PromotionInfoBean.Subject.GOODS.getCode().equals(promotionInfoBean.getPromotionSubject())) {// 价格活动
                            // 计算要减少的金额
                            BigDecimal subtract = BigDecimal.ZERO;
                            if (PromotionInfoBean.MeetOperation.DISCOUNT.getCode().equals(promotionInfoBean.getMeetOperation())) {
                                // 折扣，所有商品价格*折扣价
                                BigDecimal discount = promotionInfoBean.getMeetValue();
                                if (discount.compareTo(BigDecimal.ZERO) > 0 && discount.compareTo(BigDecimal.ONE) < 1) {
                                    logger.trace("{}", "==数据有效，减少金额=当前活动所有商品总价 * (1-折扣价)");
                                    subtract = sumOrderRGoodsPriceTotal(goodsBeanList).multiply(BigDecimal.ONE.subtract(discount));
                                    // 保存到各个商品中去
                                    goodsBeanList.forEach(orderRGoodsBeanEnable -> {
                                        // 支付价 = 购买价 * 折扣
                                        orderRGoodsBeanEnable.setGoodsPayPrice(orderRGoodsBeanEnable.getBuySubtotal().multiply(discount));
                                    });
                                }
                            } else if (PromotionInfoBean.MeetOperation.SUBTRACT.getCode().equals(promotionInfoBean.getMeetOperation())) {
                                // 满减
                                subtract = promotionInfoBean.getMeetValue();
                                // 商品总价
                                BigDecimal total = sumOrderRGoodsPriceTotal(goodsBeanList);
                                // 计算折扣
                                final BigDecimal discount = BigDecimal.ONE.subtract(subtract.divide(total, BigDecimal.ROUND_HALF_EVEN));
                                // 保存到各个商品中去
                                goodsBeanList.forEach(orderRGoodsBeanEnable -> {
                                    // 支付价 = 购买价 * 折扣
                                    orderRGoodsBeanEnable.setGoodsPayPrice(orderRGoodsBeanEnable.getBuySubtotal().multiply(discount));
                                });
                            }
                            // 商品支付金额= 原支付金额 - 优惠金额
                            preOrder.setGoodsPayPrice(preOrder.getGoodsPayPrice().subtract(subtract));
                        } else if (PromotionInfoBean.Subject.POST.getCode().equals(promotionInfoBean.getPromotionSubject())) {// 邮费活动
                            // 仅支持设置邮费
                            if (PromotionInfoBean.MeetOperation.SET.getCode().equals(promotionInfoBean.getMeetOperation())) {
                                // 设置邮费
                                promotionPostList.add(promotionInfoBean.getMeetValue());
                            }
                        }
                    } else {// 活动未达成，所有商品的活动信息清空
                        logger.trace("{}", "==活动未达成");
                    }
                });
            }
        } else {
            logger.trace("{}", "活动服务未启用或没有参与活动的商品");
        }

        // 存在邮费活动，取最大值作为订单的邮费
        Optional<BigDecimal> maxPost = promotionPostList.stream().max(BigDecimal::compareTo);
        maxPost.ifPresent(preOrder::setPostPayPrice);

        // 订单总金额、订单支付总金额
        preOrder.setOrderPrice(preOrder.getGoodsPrice().add(preOrder.getPostPrice()));
        preOrder.setOrderPayPrice(preOrder.getGoodsPayPrice().add(preOrder.getPostPayPrice()));

        return preOrder;
    }

    /**
     * 创建订单
     *
     * @param orderInfoBean 订单信息
     * @return 订单ID
     */
    @Override
    @Transactional
    public Long createOrder(OrderInfoBean orderInfoBean) {
        // 计算优惠和价格
        OrderInfoBean orderPrice = preProcessOrder(orderInfoBean.getGoodsList(), orderInfoBean.getPostPrice());

        // 商品总数量、商品总金额、商品支付总金额(如果有活动即为减去活动的优惠额)
        orderInfoBean.setGoodsCount(orderPrice.getGoodsCount());
        orderInfoBean.setGoodsPrice(orderPrice.getGoodsPrice());
        orderInfoBean.setGoodsPayPrice(orderPrice.getGoodsPayPrice());
        // 订单运费、订单运费支付总金额(默认输入的运费)
        orderInfoBean.setPostPrice(orderPrice.getPostPrice());
        orderInfoBean.setPostPayPrice(orderPrice.getPostPayPrice());
        // 订单总金额、订单支付总金额
        orderInfoBean.setOrderPrice(orderPrice.getOrderPrice());
        orderInfoBean.setOrderPayPrice(orderPrice.getOrderPayPrice());

        orderInfoBean.getGoodsList().forEach(orderRGoodsBean -> {
            if (orderRGoodsBean.getGoodsPayPrice() == null) {
                orderRGoodsBean.setGoodsPayPrice(orderRGoodsBean.getGoodsPrice());
            }
        });

        // 保存订单信息
        Long orderId = this.insert(orderInfoBean);
        // 创建订单支付信息
        orderPayInfoService.createOrderPayInfo(orderInfoBean);
        // 创建订单操作日志
        this.createOrderOperateInfo(orderId, OrderOperateInfoBean.OperateType.CREATE, true, "", orderInfoBean.getBuyerId(), orderInfoBean.getBuyerLogin());

        // 保存订单商品信息
        List<OrderRGoodsBean> orderRGoodsBeans = orderInfoBean.getGoodsList();
        orderRGoodsBeans.forEach(orderRGoodsBean -> {
            orderRGoodsBean.setOrderId(orderId);
            orderRGoodsService.insert(orderRGoodsBean);
            goodsStockService.updateSubStock(orderRGoodsBean.getGoodsId(), orderRGoodsBean.getGoodsCount());
        });
        return orderId;
    }


    // 判断参与该活动的商品是否满足条件
    private void processPricePromotion(List<OrderRGoodsBean> orderRGoodsBean, PromotionInfoBean promotionInfoBean) {
        logger.trace("开始处理活动[{}]是否满足", promotionInfoBean != null ? promotionInfoBean.getPromotionName() : "null");
        // 活动信息不为空且活动对象为价格
        if (promotionInfoBean != null && orderRGoodsBean != null
                && PromotionInfoBean.Subject.GOODS.getCode().equals(promotionInfoBean.getPromotionSubject())
                && orderRGoodsBean.size() > 0) {
            logger.trace("==当前活动为{}", promotionInfoBean);

            // 活动条件是否达到标志
            boolean promotionReach = isPromotionReach(orderRGoodsBean, promotionInfoBean);
            logger.trace("==计算活动条件达成结果为{}", promotionReach);

            // 活动达成，则将减免的金额分摊到各个商品中
            if (promotionReach) {
                // PromotionInfoBean.MeetOperation.SET,设置，常用于邮费免邮,此处为价格活动，不要进行判断，防止数据库数据错误导致诡异数据
                if (PromotionInfoBean.MeetOperation.DISCOUNT.getCode().equals(promotionInfoBean.getMeetOperation())) {
                    // 折扣，所有商品价格*折扣价
                    BigDecimal discount = promotionInfoBean.getMeetValue();
                    if (discount.compareTo(BigDecimal.ZERO) > 0 && discount.compareTo(BigDecimal.ONE) < 1) {
                        logger.trace("{}", "==数据有效，计算各个商品的优惠金额=购买价 * (1-折扣价)");
                        orderRGoodsBean.forEach(bean -> bean.setPromotionPriceAmount(bean.getBuyPrice().multiply(BigDecimal.ONE.subtract(discount))));
                    }
                } else if (PromotionInfoBean.MeetOperation.SUBTRACT.getCode().equals(promotionInfoBean.getMeetOperation())) {
                    // 满减，所有商品按照价格权重减去相应的分摊
                    BigDecimal subtract = promotionInfoBean.getMeetValue();
                    // 商品总价
                    BigDecimal sumPrice = orderRGoodsBean.stream().reduce(new BigDecimal(0), (sum, bean) -> sum.add(bean.getBuySubtotal()), BigDecimal::add);
                    // 分摊比例
                    BigDecimal discount = subtract.divide(sumPrice);
                    if (discount.compareTo(BigDecimal.ZERO) > 0 && discount.compareTo(BigDecimal.ONE) < 1) {
                        logger.trace("{}", "==数据有效，计算各个商品的优惠金额=购买价 * (1-满减额/商品总价)");
                        orderRGoodsBean.forEach(bean -> bean.setPromotionPriceAmount(bean.getBuyPrice().multiply(BigDecimal.ONE.subtract(discount))));
                    }
                }
            } else {// 活动未达成，所有商品的活动信息清空
                logger.trace("{}", "==活动未达成将优惠金额设置为0");
                orderRGoodsBean.forEach(bean -> bean.setPromotionPriceAmount(BigDecimal.ZERO));
            }
        }
    }

    // 判断活动条件是否达成
    private boolean isPromotionReach(List<? extends OrderRGoodsBeanEnable> orderRGoodsBean, PromotionInfoBean promotionInfoBean) {
        boolean promotionReach = false;
        if (PromotionInfoBean.Condition.COUNT.getCode().equals(promotionInfoBean.getPromotionCondition())) {// 数量型活动
            logger.trace("==当前活动类型为{}", PromotionInfoBean.Condition.COUNT.getDesc());
            // 数量型活动，看看商品总个数是否满足要求的数量
            int sumCount = orderRGoodsBean.stream().reduce(0, (sum, bean) -> sum + bean.getGoodsCount(), (sum, count) -> sum + count);
            logger.trace("==当前参与活动的商品总个数为{},活动条件为{}", sumCount, promotionInfoBean.getConditionValue());
            // 商品总数量大于活动要求数量则活动达成
            promotionReach = sumCount >= promotionInfoBean.getConditionValue().intValue();
        } else if (PromotionInfoBean.Condition.PRICE.getCode().equals(promotionInfoBean.getPromotionCondition())) {// 价格型活动
            logger.trace("==当前活动类型为{}", PromotionInfoBean.Condition.PRICE.getDesc());
            BigDecimal sumPrice = orderRGoodsBean.stream().reduce(new BigDecimal(0), (sum, bean) -> sum.add(bean.getBuySubtotal()), BigDecimal::add);
            logger.trace("==当前参与活动的商品总价为{},活动条件为{}", sumPrice, promotionInfoBean.getConditionValue());
            promotionReach = sumPrice.compareTo(promotionInfoBean.getConditionValue()) >= 0;
        } else { // 数据库数据错误
            // do nothing
            logger.trace("==数据库数据错误，数据库存储的类型code为{}", promotionInfoBean.getPromotionCondition());
        }
        return promotionReach;
    }

    /**
     * 取消订单
     *
     * @param orderId 订单ID
     * @return 成功取消条数
     */
    @Override
    @Transactional
    public int cancleOrder(final Long orderId, final Long updateUserId, final String updateUserName) {
        // 更新订单状态
        String state = this.mapper.getName() + ".cancleOrder";
        int cancel = this.commonDao.update(state, orderId);
        // 更新支付状态
        orderPayInfoService.cancelOrderPayInfo(orderId, updateUserId, updateUserName);
        // 创建订单操作日志
        this.createOrderOperateInfo(orderId, OrderOperateInfoBean.OperateType.CANCEL, true, "", updateUserId, updateUserName);
        // 恢复库存
        List<OrderRGoodsBean> orderRGoodsBeans = orderRGoodsService.getOrderRGoodsBeanByOrderId(orderId);
        orderRGoodsBeans.forEach(orderRGoodsBean -> goodsStockService.updateAddStock(orderRGoodsBean.getGoodsId(), orderRGoodsBean.getGoodsCount()));
        return cancel;
    }

    /**
     * 删除订单
     *
     * @param orderId 订单ID
     * @return 成功删除条数
     */
    @Override
    @Transactional
    public int deleteOrder(final Long orderId, final Long updateUserId, final String updateUserName) {
        // 更新支付状态
        orderPayInfoService.cancelOrderPayInfo(orderId, updateUserId, updateUserName);
        // 创建订单操作日志
        this.createOrderOperateInfo(orderId, OrderOperateInfoBean.OperateType.DELETE, true, "", updateUserId, updateUserName);
        String state = this.mapper.getName() + ".deleteOrder";
        return this.commonDao.update(state, orderId);
    }

    /**
     * 订单支付成功
     *
     * @param weixinCallbackRecordsBean 支付回调参数
     * @return 成功修改条数
     */
    @Override
    @Transactional
    public int payOrder(WeixinCallbackRecordsBean weixinCallbackRecordsBean) {
        // 获取微信支付记录
        WeixinPayRecordsBean weixinPayRecordsBean = weixinPayRecordsService.getBeanByOutTradeNo(weixinCallbackRecordsBean.getOutTradeNo());
        logger.debug("微信支付请求记录：{}-{}", weixinCallbackRecordsBean.getOutTradeNo(), weixinPayRecordsBean == null ? "不存在" : "存在");

        int result = 0;
        if (weixinPayRecordsBean != null) {
            OrderInfoBean orderInfoBean = this.getBeanById(weixinPayRecordsBean.getOrderId());
            orderInfoBean.setUpdatePerson(orderInfoBean.getBuyerLogin());
            OrderPayInfoBean orderPayInfoBean = orderPayInfoService.getBeanByOrderId(weixinPayRecordsBean.getOrderId());
            // a) 向订单日志信息表中插入一条订单支付的操作记录
            OrderOperateInfoBean ooi = this.createOrderOperateInfo(weixinPayRecordsBean.getOrderId(), OrderOperateInfoBean.OperateType.PAID, true, null, weixinPayRecordsBean.getUserId(), orderInfoBean.getBuyerLogin());
            if (ooi == null || ooi.getId() == null || ooi.getId() < 0) {
                logger.debug("{}", "创建订单支付记录失败，请重试");
                throw new TipsException(RestResultCode.CODE500.getCode(), "创建订单支付记录失败", "创建订单记录失败");
            }
            // b) 验证订单是否存在或已支付或已取消
            this.validOrderState(orderInfoBean, weixinPayRecordsBean.getUserId());
            // c) 修改订单基本信息表中的订单状态
            logger.debug("{}", "修改订单基本信息表中的订单状态Start...");
            boolean updated = this.updateOrderInfoState(orderInfoBean, "1", OrderInfoBean.OrderState.PAID, OrderInfoBean.TradeState.UNSHIPPED);
            if (!updated) {
                logger.debug("{}", "修改订单状态失败，请重试");
                throw new TipsException(RestResultCode.CODE500.getCode(), "修改订单状态失败", "修改订单状态失败");
            }
            logger.debug("{}", "修改订单基本信息表中的订单状态End...");
            // d) 修改订单支付信息表中的订单状态
            logger.debug("{}", "修改订单支付信息表中的订单状态Start...");
            updated = this.updateOrderPayInfoState(orderPayInfoBean, OrderInfoBean.OrderState.PAID, OrderPayInfoBean.PayStyle.WEIXIN);
            if (!updated) {
                logger.debug("{}", "修改订单支付状态失败，请重试");
                throw new TipsException(RestResultCode.CODE500.getCode(), "修改订单支付状态失败");
            }
            logger.debug("{}", "修改订单支付信息表中的订单状态End...");
            // e)修改订单物流信息
            logger.debug("{}", "初始化订单物流信息Start...");
            orderRLogisticsService.initLogisticsAfterPaySuccess(orderInfoBean.getOrderId());
            logger.debug("{}", "初始化订单物流信息End...");

            // f)更新微信支付记录【远程调用放在最后】
            result = weixinPayRecordsService.updateTradeStatus(weixinCallbackRecordsBean.getTransactionId(), weixinCallbackRecordsBean.getResultCode(), weixinCallbackRecordsBean.getOutTradeNo());
            AssertUtil.assertTrue(result > 0, "微信支付记录更新失败");
        }
        return result;
    }

    /**
     * 订单支付成功
     *
     * @param alipayCallbackRecordsBean 支付回调参数
     * @return 成功修改条数
     */
    @Override
    @Transactional
    public int payOrder(AlipayCallbackRecordsBean alipayCallbackRecordsBean) {
        // 获取支付宝支付记录
        AlipayRecordsBean alipayRecordsBean = alipayRecordsService.getBeanByOutTradeNo(alipayCallbackRecordsBean.getOutTradeNo());
        logger.debug("支付宝支付请求记录：{}-{}", alipayCallbackRecordsBean.getOutTradeNo(), alipayRecordsBean == null ? "不存在" : "存在");

        int result = 0;
        if (alipayRecordsBean != null) {
            OrderInfoBean orderInfoBean = this.getBeanById(alipayRecordsBean.getOrderId());
            orderInfoBean.setUpdatePerson(orderInfoBean.getBuyerLogin());
            OrderPayInfoBean orderPayInfoBean = orderPayInfoService.getBeanByOrderId(alipayRecordsBean.getOrderId());
            // a) 向订单日志信息表中插入一条订单支付的操作记录
            OrderOperateInfoBean ooi = this.createOrderOperateInfo(alipayRecordsBean.getOrderId(), OrderOperateInfoBean.OperateType.PAID, true, null, alipayRecordsBean.getUserId(), orderInfoBean.getBuyerLogin());
            if (ooi == null || ooi.getId() == null || ooi.getId() < 0) {
                logger.debug("{}", "创建订单支付记录失败，请重试");
                throw new TipsException(RestResultCode.CODE500.getCode(), "创建订单支付记录失败", "创建订单记录失败");
            }
            // b) 验证订单是否存在或已支付或已取消
            this.validOrderState(orderInfoBean, alipayRecordsBean.getUserId());
            // c) 修改订单基本信息表中的订单状态
            logger.debug("{}", "修改订单基本信息表中的订单状态Start...");
            boolean updated = this.updateOrderInfoState(orderInfoBean, "1", OrderInfoBean.OrderState.PAID, OrderInfoBean.TradeState.UNSHIPPED);
            if (!updated) {
                logger.debug("{}", "修改订单状态失败，请重试");
                throw new TipsException(RestResultCode.CODE500.getCode(), "修改订单状态失败", "修改订单状态失败");
            }
            logger.debug("{}", "修改订单基本信息表中的订单状态End...");
            // d) 修改订单支付信息表中的订单状态
            logger.debug("{}", "修改订单支付信息表中的订单状态Start...");
            updated = this.updateOrderPayInfoState(orderPayInfoBean, OrderInfoBean.OrderState.PAID, OrderPayInfoBean.PayStyle.ALIPAY);
            if (!updated) {
                logger.debug("{}", "修改订单支付状态失败，请重试");
                throw new TipsException(RestResultCode.CODE500.getCode(), "修改订单支付状态失败");
            }
            logger.debug("{}", "修改订单支付信息表中的订单状态End...");
            // e)修改订单物流信息
            logger.debug("{}", "初始化订单物流信息Start...");
            orderRLogisticsService.initLogisticsAfterPaySuccess(orderInfoBean.getOrderId());
            logger.debug("{}", "初始化订单物流信息End...");

            // f)更新微信支付记录【远程调用放在最后】
            result = alipayRecordsService.updateTradeStatus(alipayCallbackRecordsBean.getAlipayTradeNo(), alipayCallbackRecordsBean.getTradeStatus(), alipayCallbackRecordsBean.getOutTradeNo());
            AssertUtil.assertTrue(result > 0, "支付宝支付记录更新失败");
        }
        return result;
    }

    /**
     * 平台支付订单
     *
     * @param orderInfoBean 订单信息
     * @return 成功修改条数
     */
    @Override
    @Transactional
    public int payOrderByPlatform(OrderInfoBean orderInfoBean) {
        OrderPayInfoBean orderPayInfoBean = orderPayInfoService.getBeanByOrderId(orderInfoBean.getOrderId());
        // a) 向订单日志信息表中插入一条订单支付的操作记录
        OrderOperateInfoBean ooi = this.createOrderOperateInfo(orderInfoBean.getOrderId(), OrderOperateInfoBean.OperateType.PAID, false, String.format("%s执行平台支付", orderInfoBean.getUpdatePerson()), orderInfoBean.getBuyerId(), orderInfoBean.getBuyerLogin());
        if (ooi == null || ooi.getId() == null || ooi.getId() < 0) {
            logger.debug("{}", "创建订单支付记录失败，请重试");
            throw new TipsException(RestResultCode.CODE500.getCode(), "创建订单支付记录失败", "创建订单记录失败");
        }
        // b) 验证订单是否存在或已支付或已取消
        this.validOrderState(orderInfoBean, orderInfoBean.getBuyerId());
        // c) 修改订单基本信息表中的订单状态
        logger.debug("{}", "修改订单基本信息表中的订单状态Start...");
        boolean updated = this.updateOrderInfoState(orderInfoBean, "2", OrderInfoBean.OrderState.PAID, OrderInfoBean.TradeState.UNSHIPPED);
        if (!updated) {
            logger.debug("{}", "修改订单状态失败，请重试");
            throw new TipsException(RestResultCode.CODE500.getCode(), "修改订单状态失败", "修改订单状态失败");
        }
        logger.debug("{}", "修改订单基本信息表中的订单状态End...");
        // d) 修改订单支付信息表中的订单状态
        logger.debug("{}", "修改订单支付信息表中的订单状态Start...");
        updated = this.updateOrderPayInfoState(orderPayInfoBean, OrderInfoBean.OrderState.PAID, OrderPayInfoBean.PayStyle.PLATFORM);
        if (!updated) {
            logger.debug("{}", "修改订单支付状态失败，请重试");
            throw new TipsException(RestResultCode.CODE500.getCode(), "修改订单支付状态失败");
        }
        logger.debug("{}", "修改订单支付信息表中的订单状态End...");
        // e)修改订单物流信息
        logger.debug("{}", "初始化订单物流信息Start...");
        orderRLogisticsService.initLogisticsAfterPaySuccess(orderInfoBean.getOrderId());
        logger.debug("{}", "初始化订单物流信息End...");

        return 1;
    }

    // 创建操作记录
    private OrderOperateInfoBean createOrderOperateInfo(Long orderId, OrderOperateInfoBean.OperateType type, boolean isShopping,
                                                        String content, Long operaterId, String operaterName) {
        // 创建insert所需要的参数
        OrderOperateInfoBean bean = new OrderOperateInfoBean();
        bean.setIsShopping(isShopping ? StringUtil.WHETHER_YES : StringUtil.WHETHER_NO);
        bean.setOrderId(orderId);
        bean.setOperateTypeId(type.getCode());
        bean.setOperateTypeDesc(type.getDesc());
        bean.setOperateTime(DateUtil.getCurrentTimestamp());
        bean.setOperaterId(operaterId);
        bean.setOperaterName(operaterName);
        // 构造操作内容
        String tmp_content = content;
        if (StringUtil.isEmpty(content)) {
            tmp_content = String.format("[%s]执行[%s]！", bean.getOperaterName(), bean.getOperateTypeDesc());
        }
        bean.setOperateContent(tmp_content);
        orderOperateInfoService.insert(bean);
        return bean;
    }

    // 检查订单状态
    private void validOrderState(OrderInfoBean orderInfo, Long userId) {
        logger.debug("{}", "验证订单是否存在或已支付或已取消Start....");
        if (orderInfo == null) {
            logger.debug("{}", "该订单不存在");
            // 订单信息必须存在
            throw new TipsException(RestResultCode.CODE500.getCode(), "该订单不存在", "该订单不存在");
        } else if (Long.compare(userId, orderInfo.getBuyerId()) != 0) {
            // 验证传入的用户ID是否为合法的订单创建人ID
            logger.debug("{}", "参数用户ID非订单购买人ID");
            throw new TipsException(RestResultCode.CODE500.getCode(), "参数用户ID非订单购买人ID", "参数错误");
        } else if (orderInfo.getOrderPayPrice() == null) {
            logger.debug("{}", "该订单信息错误");
            // 订单信息中的支付金额必须存在
            throw new TipsException(RestResultCode.CODE500.getCode(), "该订单信息错误", "订单信息错误");
        } else if (OrderInfoBean.OrderState.CANCELLED.getCode().equals(orderInfo.getOrderState())) {
            logger.debug("{}", "该订单已取消");
            // 订单信息状态必须为未支付
            throw new TipsException(RestResultCode.CODE500.getCode(), "该订单已取消", "订单信息错误");
        } else if (OrderInfoBean.OrderState.PAID.getCode().equals(orderInfo.getOrderState())) {
            // 订单信息状态必须为未支付
            logger.debug("{}", "该订单已支付");
            throw new TipsException(RestResultCode.CODE500.getCode(), "该订单已支付", "订单信息错误");
        } else if (!OrderInfoBean.OrderState.UNPAID.getCode().equals(orderInfo.getOrderState())) {
            logger.debug("{}", "该订单已取消或已支付");
            // 订单信息状态必须为未支付
            throw new TipsException(RestResultCode.CODE500.getCode(), "该订单已取消或已支付", "订单信息错误");
        }
        logger.debug("{}", "验证订单是否存在或已支付或已取消End...");
    }

    // 修改订单状态
    private boolean updateOrderInfoState(OrderInfoBean orderInfo, String payStyle, OrderInfoBean.OrderState state, OrderInfoBean.TradeState tradeState) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("orderState", state.getCode());
        parameter.put("tradeState", tradeState.getCode());
        parameter.put("payStyle", payStyle);
        parameter.put("orderId", orderInfo.getOrderId());
        parameter.put("updatePerson", orderInfo.getUpdatePerson());
        if (StringUtil.isNotEmpty(orderInfo.getPayRemark())) {
            parameter.put("payRemark", orderInfo.getPayRemark());
        }
        String statem = this.mapper.getName() + ".updateOrderInfoState";
        int res = this.commonDao.update(statem, parameter);
        return res > 0;
    }

    // 修改订单支付信息状态
    private boolean updateOrderPayInfoState(OrderPayInfoBean orderPayInfoBean, OrderInfoBean.OrderState paid, OrderPayInfoBean.PayStyle payStyle) {
        Map<String, Object> params = new HashMap<>();
        params.put("payState", paid.getCode());
        params.put("payStyle", payStyle.getCode());
        params.put("orderId", orderPayInfoBean.getOrderId());
        String state = this.mapper.getName() + ".updateOrderPayInfoState";
        return this.commonDao.update(state, params) > 0;
    }

    /**
     * 订单发货
     *
     * @param orderInfoBean 订单信息
     * @return 修改订单条数
     */
    @Transactional
    @Override
    public int shipOrder(final OrderInfoBean orderInfoBean) {
        // 插入物流状态信息
        OrderRLogisticsBean orderRLogisticsBean = new OrderRLogisticsBean();
        orderRLogisticsBean.setOrderId(orderInfoBean.getOrderId());
        orderRLogisticsBean.setAcceptTime(DateUtil.getCurrentDateTimeStr());
        orderRLogisticsBean.setAcceptStation("商品已打包完成，等待物流公司揽件");
        orderRLogisticsBean.setState(OrderRLogisticsBean.LogisticsState.WAITING.getCode());
        orderRLogisticsService.insert(orderRLogisticsBean);
        // 更新订单物流状态
        orderRLogisticsService.updateOrderLogisticsState(orderRLogisticsBean.getState(), orderRLogisticsBean.getOrderId());
        // 修改订单物流信息
        OrderInfoBean _orderInfoParam = new OrderInfoBean();
        _orderInfoParam.setOrderId(orderInfoBean.getOrderId());
        _orderInfoParam.setExpressCode(orderInfoBean.getExpressCode());
        _orderInfoParam.setExpressName(orderInfoBean.getExpressName());
        _orderInfoParam.setExpressFee(orderInfoBean.getExpressFee());
        _orderInfoParam.setTrackNumber(orderInfoBean.getTrackNumber());
        _orderInfoParam.setSendTime(DateUtil.getCurrentDate());
        _orderInfoParam.setTradState(OrderInfoBean.TradeState.SHIPPED.getCode());
        _orderInfoParam.setUpdatePerson(orderInfoBean.getUpdatePerson());
        _orderInfoParam.setUpdateTime(DateUtil.getCurrentDate());
        return this.update(_orderInfoParam);
    }

    /**
     * 确认收货
     *
     * @param orderInfoBean  订单信息
     * @param updatePersonId 修改用户ID
     * @return 修改订单条数
     */
    @Transactional
    @Override
    public int confirmReceipt(OrderInfoBean orderInfoBean, final Long updatePersonId) {
        // 插入一条订单完成的操作日志
        OrderOperateInfoBean orderOperateInfoBean = new OrderOperateInfoBean();
        orderOperateInfoBean.setIsShopping(StringUtil.WHETHER_YES);
        orderOperateInfoBean.setOrderId(orderInfoBean.getOrderId());
        orderOperateInfoBean.setOperateTypeId(OrderOperateInfoBean.OperateType.FINISH.getCode());
        orderOperateInfoBean.setOperateTypeDesc(OrderOperateInfoBean.OperateType.FINISH.getDesc());
        orderOperateInfoBean.setOperateTime(DateUtil.getCurrentTimestamp());
        orderOperateInfoBean.setOperaterId(updatePersonId);
        orderOperateInfoBean.setOperaterName(orderInfoBean.getUpdatePerson());
        // 构造操作内容
        String tmp_content = String.format("[%s]执行[%s]！", orderOperateInfoBean.getOperaterName(), orderOperateInfoBean.getOperateTypeDesc());
        orderOperateInfoBean.setOperateContent(tmp_content);
        orderOperateInfoService.insert(orderOperateInfoBean);

        // 确认订单收货
        OrderInfoBean _orderInfoParam = new OrderInfoBean();
        _orderInfoParam.setOrderId(orderInfoBean.getOrderId());
        _orderInfoParam.setTradState(OrderInfoBean.TradeState.CONFIRMED.getCode());
        _orderInfoParam.setConfirmTime(DateUtil.getCurrentDate());
        _orderInfoParam.setUpdatePerson(orderInfoBean.getUpdatePerson());
        _orderInfoParam.setUpdateTime(DateUtil.getCurrentDate());
        return this.update(_orderInfoParam);
    }

    /**
     * 评价订单
     *
     * @param orderInfoBean  订单信息
     * @param updatePersonId 修改用户ID
     * @return 修改订单条数
     */
    @Override
    public int evaluateOrder(OrderInfoBean orderInfoBean, Long updatePersonId) {
        // 评价订单
        OrderInfoBean _orderInfoParam = new OrderInfoBean();
        _orderInfoParam.setOrderId(orderInfoBean.getOrderId());
        _orderInfoParam.setTradState(OrderInfoBean.TradeState.EVALUATED.getCode());
        _orderInfoParam.setUpdatePerson(orderInfoBean.getUpdatePerson());
        _orderInfoParam.setUpdateTime(DateUtil.getCurrentDate());
        return this.update(_orderInfoParam);
    }

    /**
     * 订单改价
     *
     * @param orderInfoBean 订单信息
     * @return 修改订单条数
     */
    @Override
    @Transactional
    public int updatePayPrice(OrderInfoBean orderInfoBean) {
        // 订单修改记录
        this.createOrderOperateInfo(orderInfoBean.getOrderId(), OrderOperateInfoBean.OperateType.UPDATE
                , false, String.format("%s修改订单价格为%s", orderInfoBean.getUpdatePerson(), orderInfoBean.getOrderPayPrice())
                , null, orderInfoBean.getUpdatePerson());
        // 订单改价
        OrderInfoBean _orderInfoParam = new OrderInfoBean();
        _orderInfoParam.setOrderId(orderInfoBean.getOrderId());
        _orderInfoParam.setOrderPayPrice(orderInfoBean.getOrderPayPrice());
        _orderInfoParam.setIsGroupBuy(orderInfoBean.getIsGroupBuy());
        _orderInfoParam.setUpdatePerson(orderInfoBean.getUpdatePerson());
        _orderInfoParam.setUpdateTime(DateUtil.getCurrentDate());
        return this.update(_orderInfoParam);
    }

    /**
     * 根据订单编码获取订单信息
     *
     * @param orderCode 订单编码
     * @return 订单对象
     */
    @Override
    public OrderInfoBean getBeanByCode(String orderCode) {
        String state = this.mapper.getName() + ".getBeanByCode";
        return this.commonDao.selectOne(state, orderCode);
    }

    /**
     * 统计用户订单状态
     *
     * @param userId 用户ID
     * @return 状态分布
     */
    @Override
    public List<OrderStateStatistics> statisticsState(Long userId, Long storeId) {
        String state = this.mapper.getName() + ".statisticsState";
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        if (storeId != null) {
            params.put("storeId", storeId);
        }
        return this.commonDao.selectList(state, params);
    }
}

