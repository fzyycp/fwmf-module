package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.order.bean.PackageInfoBean;
import cn.faury.fwmf.module.service.order.generate.mapper.PackageInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.PackageInfoSqlProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：套餐基本信息表
 *
 * <pre>
 *     PackageInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自PackageInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface PackageInfoMapper extends PackageInfoGenerateMapper {

    @SelectProvider(type = PackageInfoSqlProvider.class, method = "getGoodsPackageList")
    @ResultType(PackageInfoBean.class)
    List<PackageInfoBean> getGoodsPackageList(Long goodsId);

    @UpdateProvider(type = PackageInfoSqlProvider.class, method = "deletePackageBatch")
    int deletePackageBatch(Map<String, Object> params);
}