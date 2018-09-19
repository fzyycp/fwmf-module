package cn.faury.fwmf.module.api.order.service;

import cn.faury.fwmf.module.api.order.bean.PackageInfoBean;
import cn.faury.fwmf.module.api.order.bean.PackageRGoodsBean;
import cn.faury.fdk.common.db.CrudBaseService;

import java.util.List;

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
