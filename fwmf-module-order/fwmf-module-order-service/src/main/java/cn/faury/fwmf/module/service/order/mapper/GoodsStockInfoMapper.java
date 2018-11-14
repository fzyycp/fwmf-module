package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.GoodsStockInfoGenerateMapper;
import org.apache.ibatis.annotations.Update;

@AutoScannedMapper
public interface GoodsStockInfoMapper extends GoodsStockInfoGenerateMapper {

    @Update({"UPDATE", DBConstOfOrder.ORDER_T_GOODS_STOCK_INFO,
            "    SET IS_DELETE = 'Y'",
            "  WHERE GOODS_ID = #{goodsId} and IS_DELETE='N'"})
    public int deleteByGoodsId();

    @Update({"UPDATE", DBConstOfOrder.ORDER_T_GOODS_STOCK_INFO,
            "    SET STOCK = STOCK - #{goodsCount}",
            "  WHERE GOODS_ID = #{goodsId} and IS_DELETE='N'"})
    public int updateSubStock();

    @Update({"UPDATE", DBConstOfOrder.ORDER_T_GOODS_STOCK_INFO,
            "    SET STOCK = STOCK + #{goodsCount} ",
            "  WHERE GOODS_ID = #{goodsId} and IS_DELETE='N'"})
    public int updateAddStock();
}
