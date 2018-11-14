package cn.faury.fwmf.module.api.order.service;


import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.order.bean.GoodsStockInfoBean;

/**
 * 服务接口：商品库存信息表
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface GoodsStockInfoService extends CrudBaseService<GoodsStockInfoBean, Long> {

    /**
     *  删除商品库存
     * @param goodsId 商品ID
     * @return 成功删除条数
     */
    public int deleteByGoodsId(Long goodsId);

    /**
     * 上架更新库存总数
     * @param goodsStockBean 新的库存信息
     * @return 成功更新条数
     */
    public Long updateShelfStock(GoodsStockInfoBean goodsStockBean);

    /**
     * 减少库存
     *
     * @param goodsId 商品ID
     * @param goodsCount 商品个数
     * @return 成功更新条数
     */
    public int updateSubStock(Long goodsId, int goodsCount);

    /**
     * 增加库存
     * @param goodsId 商品ID
     * @param goodsCount 商品个数
     * @return 成功更新条数
     */
    public int updateAddStock(Long goodsId, int goodsCount);

}
