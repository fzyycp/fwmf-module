package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.GoodsStockBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.GoodsStockGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.GoodsRStockSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface GoodsStockMapper extends GoodsStockGenerateMapper {
    @SelectProvider(type = GoodsRStockSqlProvider.class, method = "search")
    @ResultType(GoodsStockBean.class)
    List<GoodsStockBean> search(Map<String, Object> params);

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
