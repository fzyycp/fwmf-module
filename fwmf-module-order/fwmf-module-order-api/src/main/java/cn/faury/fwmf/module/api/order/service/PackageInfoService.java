package cn.faury.fwmf.module.api.order.service;

import cn.faury.fwmf.module.api.order.bean.PackageInfoBean;
import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;

import java.util.List;

public interface PackageInfoService extends CrudBaseService<PackageInfoBean, Long> {

    /**
     * 获取商品所在套餐列表
     *
     * @param goodsId   商品ID
     * @param pageParam 分页参数
     * @return 查询结果
     */
    public PageInfo<PackageInfoBean> getGoodsPackageList(Long goodsId, PageParam pageParam);

    /**
     * 插入套餐和对应的关联商品
     *
     * @param packageInfoBean 套餐信息和商品信息
     * @return 套餐ID
     */
    public Long insertPackageWithGoods(PackageInfoBean packageInfoBean);

    /**
     * 更新套餐和对应的关联商品
     *
     * @param packageInfoBean 套餐信息和商品信息
     * @return 套餐ID
     */
    public int updatePackageWithGoods(PackageInfoBean packageInfoBean);

    /**
     * 删除套餐
     *
     * @param packageIds 多个套餐ID
     * @return 成功删除个数
     */
    public int deletePackageBatch(List<Long> packageIds);
}
