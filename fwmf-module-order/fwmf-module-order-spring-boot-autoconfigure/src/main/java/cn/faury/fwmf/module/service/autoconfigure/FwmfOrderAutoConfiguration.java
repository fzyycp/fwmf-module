package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fwmf.module.api.order.service.*;
import cn.faury.fdk.mybatis.autoconfigure.FdkMybatisAutoConfiguration;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.order.service.*;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(FdkMybatisAutoConfiguration.class)
public class FwmfOrderAutoConfiguration {

    /**
     * 商品库存服务
     */
    @Bean
    @ConditionalOnClass({GoodsStockService.class, GoodsStockServiceImpl.class})
    public GoodsStockService goodsStockService(CommonDao commonDao) {
        return new GoodsStockServiceImpl(commonDao);
    }

    /**
     * 订单服务
     */
    @Bean
    @ConditionalOnClass({OrderInfoService.class, OrderInfoServiceImpl.class})
    public OrderInfoService orderInfoService(CommonDao commonDao) {
        return new OrderInfoServiceImpl(commonDao);
    }

    /**
     * 订单操作日志服务
     */
    @Bean
    @ConditionalOnClass({OrderOperateInfoService.class, OrderOperateInfoServiceImpl.class})
    public OrderOperateInfoService orderOperateInfoService(CommonDao commonDao) {
        return new OrderOperateInfoServiceImpl(commonDao);
    }

    /**
     * 订单支付信息服务
     */
    @Bean
    @ConditionalOnClass({OrderPayInfoService.class, OrderPayInfoServiceImpl.class})
    public OrderPayInfoService orderPayInfoService(CommonDao commonDao) {
        return new OrderPayInfoServiceImpl(commonDao);
    }

    /**
     * 订单商品服务
     */
    @Bean
    @ConditionalOnClass({OrderRGoodsService.class, OrderRGoodsServiceImpl.class})
    public OrderRGoodsService orderRGoodsService(CommonDao commonDao) {
        return new OrderRGoodsServiceImpl(commonDao);
    }

    /**
     * 订单物流服务
     */
    @Bean
    @ConditionalOnClass({OrderRLogisticsService.class, OrderRLogisticsServiceImpl.class})
    public OrderRLogisticsService orderRLogisticsService(CommonDao commonDao) {
        return new OrderRLogisticsServiceImpl(commonDao);
    }

    /**
     * 商品套餐信息服务
     */
    @Bean
    @ConditionalOnClass({PackageInfoService.class, PackageInfoServiceImpl.class})
    public PackageInfoService packageInfoService(CommonDao commonDao) {
        return new PackageInfoServiceImpl(commonDao);
    }

    /**
     * 商品套餐关联商品服务
     */
    @Bean
    @ConditionalOnClass({PackageRGoodsService.class, PackageRGoodsServiceImpl.class})
    public PackageRGoodsService packageRGoodsService(CommonDao commonDao) {
        return new PackageRGoodsServiceImpl(commonDao);
    }

    /**
     * 邮费服务
     */
    @Bean
    @ConditionalOnClass({PostageInfoService.class, PostageInfoServiceImpl.class})
    public PostageInfoService postageInfoService(CommonDao commonDao) {
        return new PostageInfoServiceImpl(commonDao);
    }

    /**
     * 邮费关联区域服务
     */
    @Bean
    @ConditionalOnClass({PostageRAreaService.class, PostageRAreaServiceImpl.class})
    public PostageRAreaService postageRAreaService(CommonDao commonDao) {
        return new PostageRAreaServiceImpl(commonDao);
    }

    /**
     * 优惠活动服务
     */
    @Bean
    @ConditionalOnClass({PromotionInfoService.class, PromotionInfoServiceImpl.class})
    public PromotionInfoService promotionInfoService(CommonDao commonDao) {
        return new PromotionInfoServiceImpl(commonDao);
    }
}
