package cn.faury.fwmf.module.service.order.service;


import cn.faury.fwmf.module.api.order.bean.GoodsStockBean;
import cn.faury.fwmf.module.api.order.service.GoodsStockService;
import cn.faury.fwmf.module.service.order.mapper.GoodsStockMapper;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

public class GoodsStockServiceImpl extends CrudBaseServiceImpl<GoodsStockBean, Long> implements GoodsStockService {
    public GoodsStockServiceImpl(CommonDao commonDao) {
        super(commonDao, GoodsStockMapper.class);
    }

    /**
     * 删除商品库存
     *
     * @param goodsId 商品ID
     * @return 成功删除条数
     */
    @Override
    public int deleteByGoodsId(Long goodsId) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("goodsId", goodsId);
        String statem = GoodsStockMapper.class.getName() + ".deleteByGoodsId";
        return this.commonDao.update(statem, parameter);
    }

    /**
     * 上架更新库存总数
     *
     * @param goodsStockBean 新的库存信息
     * @return 成功更新条数
     */
    @Override
    @Transactional
    public Long updateShelfStock(GoodsStockBean goodsStockBean) {
        // 删除旧的库存
        this.deleteByGoodsId(goodsStockBean.getGoodsId());
        // 插入新的库存
        return this.insert(goodsStockBean);
    }

    /**
     * 减少库存
     *
     * @param goodsId    商品ID
     * @param goodsCount 商品个数
     * @return 成功更新条数
     */
    @Override
    public int updateSubStock(Long goodsId, int goodsCount) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("goodsId", goodsId);
        parameter.put("goodsCount", goodsCount);

        String statem = GoodsStockMapper.class.getName() + ".updateSubStock";
        return this.commonDao.update(statem, parameter);
    }

    /**
     * 增加库存
     *
     * @param goodsId    商品ID
     * @param goodsCount 商品个数
     * @return 成功更新条数
     */
    @Override
    public int updateAddStock(Long goodsId, int goodsCount) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("goodsId", goodsId);
        parameter.put("goodsCount", goodsCount);

        String statem = GoodsStockMapper.class.getName() + ".updateAddStock";
        return this.commonDao.update(statem, parameter);
    }
}
