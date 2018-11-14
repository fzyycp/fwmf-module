package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.order.bean.PackageRGoodsBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.PackageRGoodsGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.PackageRGoodsSqlProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Mybatis Mapper：套餐关联表
 *
 * <pre>
 *     PackageRGoodsGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自PackageRGoodsGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface PackageRGoodsMapper extends PackageRGoodsGenerateMapper {

    @SelectProvider(type = PackageRGoodsSqlProvider.class, method = "getBeanListByPackageId")
    @ResultType(PackageRGoodsBean.class)
    List<PackageRGoodsBean> getBeanListByPackageId(Long packageId);

    @Delete({"DELETE FROM", DBConstOfOrder.ORDER_T_PACKAGE_R_GOODS
            , "WHERE PACKAGE_ID=#{packageId}"})
    int deleteByPackageId(Long packageId);
}