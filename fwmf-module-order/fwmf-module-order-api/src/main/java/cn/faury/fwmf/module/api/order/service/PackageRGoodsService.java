package cn.faury.fwmf.module.api.order.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.order.bean.PackageRGoodsBean;

import java.util.List;

/**
 * 服务接口：套餐关联表
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface PackageRGoodsService extends CrudBaseService<PackageRGoodsBean, Long> {

    /**
     * 根据套餐ID获取关联商品列表
     *
     * @param packageId 套餐ID
     * @return 商品列表
     */
    public List<PackageRGoodsBean> getBeanListByPackageId(Long packageId);

    /**
     * 批量插入套餐关联商品信息
     * @param packageRGoodsBeanList 套餐关联商品信息
     * @return 成功插入的ID列表
     */
    public List<Long> insertBatch(List<PackageRGoodsBean> packageRGoodsBeanList);

    /**
     * 根据套餐ID删除关联商品列表
     *
     * @param packageId 套餐ID
     * @return 成功删除条数
     */
    public int deleteByPackageId(Long packageId);
}
