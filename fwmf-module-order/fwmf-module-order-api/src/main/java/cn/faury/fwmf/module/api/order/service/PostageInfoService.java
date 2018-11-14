package cn.faury.fwmf.module.api.order.service;


import cn.faury.fwmf.module.api.order.bean.OrderRGoodsBeanEnable;
import cn.faury.fwmf.module.api.order.bean.PostageInfoBean;
import cn.faury.fwmf.module.api.order.bean.PostageRAreaBean;
import cn.faury.fdk.common.db.CrudBaseService;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 服务接口：邮费信息表
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface PostageInfoService extends CrudBaseService<PostageInfoBean, Long> {

    /**
     * 插入带区域配置的运费信息
     * @param postageInfoBean 运费信息
     * @param postageRAreaBeanList 区域配置信息
     * @return 运费ID
     */
    public Long insert(PostageInfoBean postageInfoBean, List<PostageRAreaBean> postageRAreaBeanList);

    /**
     * 更新区域型运费信息
     * @param postageInfoBean 运费信息
     * @param postageRAreaBeanList 区域配置信息
     * @return 成功更新条数
     */
    public int update(PostageInfoBean postageInfoBean, List<PostageRAreaBean> postageRAreaBeanList);

    /**
     * 计算商品总运费
     *
     * @param goodsList           商品列表
     * @param addressProvinceCode 地址省份编码
     */
    public BigDecimal calculatePostagePrice(List<? extends OrderRGoodsBeanEnable> goodsList, String addressProvinceCode);

    /**
     * 根据邮费ID计算运费总价
     * @param postageId 邮费ID
     * @param goodsCount 商品数量
     * @param addressProvinceCode 寄送地址省份编码
     * @return 运费总价
     */
    public BigDecimal calculatePostagePriceById(Long postageId,int goodsCount,String addressProvinceCode);
}
