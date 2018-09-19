package cn.faury.fwmf.module.api.order.service;


import cn.faury.fwmf.module.api.order.bean.GoodsStockBean;
import cn.faury.fdk.common.db.CrudBaseService;

public interface GoodsStockService extends CrudBaseService<GoodsStockBean, Long> {

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
    public Long updateShelfStock(GoodsStockBean goodsStockBean);

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
