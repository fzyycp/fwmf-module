package cn.faury.fwmf.module.service.order.service;


import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.order.bean.GoodsStockInfoBean;
import cn.faury.fwmf.module.api.order.service.GoodsStockInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.order.mapper.GoodsStockInfoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务实现：商品库存信息表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了GoodsStockInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class GoodsStockInfoServiceImpl extends CrudBaseServiceImpl<GoodsStockInfoBean, Long> implements GoodsStockInfoService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public GoodsStockInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, GoodsStockInfoMapper.class);
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
        String statem = GoodsStockInfoMapper.class.getName() + ".deleteByGoodsId";
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
    public Long updateShelfStock(GoodsStockInfoBean goodsStockBean) {
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

        String statem = GoodsStockInfoMapper.class.getName() + ".updateSubStock";
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

        String statem = GoodsStockInfoMapper.class.getName() + ".updateAddStock";
        return this.commonDao.update(statem, parameter);
    }
}
