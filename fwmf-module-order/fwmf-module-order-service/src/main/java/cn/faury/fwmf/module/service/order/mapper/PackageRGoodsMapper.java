package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.PackageRGoodsBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.PackageRGoodsGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.PackageRGoodsSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface PackageRGoodsMapper extends PackageRGoodsGenerateMapper {

    @SelectProvider(type = PackageRGoodsSqlProvider.class, method = "search")
    @ResultType(PackageRGoodsBean.class)
    List<PackageRGoodsBean> search(Map<String, Object> params);

    @SelectProvider(type = PackageRGoodsSqlProvider.class, method = "getBeanListByPackageId")
    @ResultType(PackageRGoodsBean.class)
    List<PackageRGoodsBean> getBeanListByPackageId(Long packageId);

    @Delete({"DELETE FROM", DBConstOfOrder.ORDER_T_PACKAGE_R_GOODS
            , "WHERE PACKAGE_ID=#{packageId}"})
    int deleteByPackageId(Long packageId);
}