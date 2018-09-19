package cn.faury.fwmf.module.service.order.service;

import cn.faury.fwmf.module.api.order.bean.OrderRGoodsBeanEnable;
import cn.faury.fwmf.module.api.order.bean.PostageInfoBean;
import cn.faury.fwmf.module.api.order.bean.PostageRAreaBean;
import cn.faury.fwmf.module.api.order.generate.bean.PostageInfoGenerateBean;
import cn.faury.fwmf.module.api.order.generate.bean.PostageRAreaGenerateBean;
import cn.faury.fwmf.module.api.order.service.PostageInfoService;
import cn.faury.fwmf.module.api.order.service.PostageRAreaService;
import cn.faury.fwmf.module.service.order.mapper.PostageInfoMapper;
import cn.faury.fdk.common.anotation.NonNull;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class PostageInfoServiceImpl extends CrudBaseServiceImpl<PostageInfoBean, Long> implements PostageInfoService {

    @Autowired(required = false)
    private PostageRAreaService postageRAreaService;

    public PostageInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, PostageInfoMapper.class);
    }

    /**
     * 插入带区域配置的运费信息
     *
     * @param postageInfoBean      运费信息
     * @param postageRAreaBeanList 区域配置信息
     * @return 运费ID
     */
    @Override
    public Long insert(PostageInfoBean postageInfoBean, List<PostageRAreaBean> postageRAreaBeanList) {
        final Long postageId = this.insert(postageInfoBean);
        if (postageRAreaBeanList != null && postageRAreaBeanList.size() > 0) {
            postageRAreaBeanList.forEach(postageRAreaBean -> {
                postageRAreaBean.setPostageId(postageId);
                postageRAreaService.insert(postageRAreaBean);
            });
        }
        return postageId;
    }

    /**
     * 更新区域型运费信息
     *
     * @param postageInfoBean      运费信息
     * @param postageRAreaBeanList 区域配置信息
     * @return 成功更新条数
     */
    @Override
    public int update(PostageInfoBean postageInfoBean, List<PostageRAreaBean> postageRAreaBeanList) {
        postageRAreaService.deleteByPostageId(postageInfoBean.getPostageId());
        postageRAreaBeanList.forEach(postageRAreaBean -> {
            postageRAreaBean.setPostageId(postageInfoBean.getPostageId());
            postageRAreaService.insert(postageRAreaBean);
        });
        return this.update(postageInfoBean);
    }

    /**
     * 根据邮费ID获取多个对象Bean
     *
     * @param ids 邮费ID列表
     * @return 邮费对象
     */
    @Override
    public List<PostageInfoBean> getBeanListByIds(Collection<Long> ids) {
        String state = this.mapper.getName() + ".getBeanListByIds";
        return this.commonDao.selectList(state, Collections.singletonMap("ids", new ArrayList<>(ids)));
    }

    /**
     * 计算商品总运费
     * <p>
     * <pre>
     *    如果涉及到多个邮费ID采取以下策略：
     *      1，基础邮费=所有邮费ID中基础邮费最大的
     *      2，递增邮费=单独计算每种邮费下各自商品递增之和，超出数量为各自数量减去各自的基数
     *      3，最终邮费=基础邮费+递增邮费
     * </pre>
     *
     * @param goodsList           商品列表
     * @param addressProvinceCode 地址省份编码
     */
    @Override
    public BigDecimal calculatePostagePrice(List<? extends OrderRGoodsBeanEnable> goodsList, String addressProvinceCode) {
        BigDecimal postagePrice = null;
        if (goodsList != null) {
            /*
             * 如果涉及到多个邮费ID采取以下策略：
             *  1，基础邮费=所有邮费ID中基础邮费最大的
             *  2，递增邮费=单独计算每种邮费下各自商品递增之和，超出数量为各自数量减去各自的基数
             *  3，最终邮费=基础邮费+递增邮费
             */
            // 邮费ID -》 商品列表
            Map<Long, List<OrderRGoodsBeanEnable>> postageRGoods = new HashMap<>();
            goodsList.forEach(bean -> postageRGoods.computeIfAbsent(bean.getPostageId(), k -> new ArrayList<>()));
            if (postageRGoods.size() > 0) {
                List<PostageInfoBean> postageInfoBeanList = this.getBeanListByIds(postageRGoods.keySet());
                if (postageInfoBeanList != null && postageInfoBeanList.size() > 0) {// 存在邮费信息
                    postagePrice = BigDecimal.ZERO;
                    // 1，基础邮费=所有邮费ID中基础邮费最大的
                    Optional<PostageInfoBean> maxPostage = postageInfoBeanList.stream().max(Comparator.comparing(PostageInfoGenerateBean::getPostagePrice));
                    if (maxPostage.isPresent()) {
                        postagePrice = postagePrice.add(maxPostage.get().getPostagePrice());
                    }
                    // 2，递增邮费=单独计算每种邮费下各自商品递增之和，超出数量为各自数量减去各自的基数
                    BigDecimal increasePrice = postageInfoBeanList.stream().reduce(BigDecimal.ZERO, (sum, bean) -> {
                        int totalGoodsCount = postageRGoods.get(bean.getPostageId())
                                .stream()
                                .reduce(0, (sum1, bean1) -> sum1 + bean1.getGoodsCount(), (sum1, count1) -> sum1 + count1);

                        return sum.add(calculatePostageIncrease(bean, totalGoodsCount, addressProvinceCode));
                    }, BigDecimal::add);
                    // 3，最终邮费=基础邮费+递增邮费
                    postagePrice = postagePrice.add(increasePrice);
                }
            }
        }
        return postagePrice;
    }

    /**
     * 根据邮费ID计算运费总价
     *
     * @param postageId           邮费ID
     * @param goodsCount          商品数量
     * @param addressProvinceCode 寄送地址省份编码
     * @return 运费总价
     */
    @Override
    public BigDecimal calculatePostagePriceById(Long postageId, int goodsCount, String addressProvinceCode) {
        PostageInfoBean postageInfoBean = this.getBeanById(postageId);
        // 超重价格
        BigDecimal increase = this.calculatePostageIncrease(postageInfoBean, goodsCount, addressProvinceCode);
        return postageInfoBean.getPostagePrice().add(increase);
    }


    /**
     * 计算商品超过基础数量增加的邮费
     *
     * @param postageInfoBean     邮费对象
     * @param totalGoodsCount     商品总数量
     * @param addressProvinceCode 地址省份编码
     * @return 商品超过基础数量增加的邮费
     */
    private BigDecimal calculatePostageIncrease(@NonNull PostageInfoBean postageInfoBean, int totalGoodsCount, @NonNull String addressProvinceCode) {
//        // 商品总数量
//        int totalGoodsCount = orderRGoodsBeanList.stream().reduce(0, (sum, bean) -> sum + bean.getGoodsCount(), (sum, count) -> sum + count);
        // 基础运费数量
        int baseGoodsCount = postageInfoBean.getGoodsCount();
        // 递增商品数量
        int increaseCount = postageInfoBean.getIncreaseGoodsCount();
        // 递增商品运费
        BigDecimal increasePostagePrice = postageInfoBean.getIncreasePostagePrice();

        // 区域类型地址,判断区域是否存在
        if (PostageInfoBean.PostageType.AREA.getCode().equals(postageInfoBean.getPostageType()) && postageRAreaService != null) {
            // 获取邮费关联区域列表
            List<PostageRAreaBean> postageRAreaBeanList = postageRAreaService.getBeanListByPostageId(postageInfoBean.getPostageId());
            if (postageRAreaBeanList != null) {
                // 找到包含当前地址的第一个关联区域信息
                Optional<PostageRAreaBean> postageRAreaBean = postageRAreaBeanList.stream()
                        .filter(bean -> bean.getAreaCodeProvince().contains(addressProvinceCode))
                        .findFirst();
                if (postageRAreaBean.isPresent()) {
                    baseGoodsCount = postageRAreaBean.get().getGoodsCount();
                    increaseCount = postageRAreaBean.get().getIncreaseGoodsCount();
                    increasePostagePrice = postageRAreaBean.get().getIncreasePostagePrice();
                }
            }
        }

        BigDecimal increase;
        if (totalGoodsCount > baseGoodsCount) {// 超出基础数量
            // 倍数 = （商品数量-基础数量）/ 每增加数量
            int multi = (totalGoodsCount - baseGoodsCount) / increaseCount;
            if (totalGoodsCount - baseGoodsCount > multi * increaseCount) {
                multi = multi + 1;
            }
            increase = increasePostagePrice.multiply(new BigDecimal(multi));
        } else {
            increase = BigDecimal.ZERO;
        }
        return increase;
    }
}
