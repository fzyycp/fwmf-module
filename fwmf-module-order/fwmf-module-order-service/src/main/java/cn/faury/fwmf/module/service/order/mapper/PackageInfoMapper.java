package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.PackageInfoBean;
import cn.faury.fwmf.module.api.order.bean.PostageInfoBean;
import cn.faury.fwmf.module.service.order.generate.mapper.PackageInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.generate.mapper.PostageInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.PackageInfoSqlProvider;
import cn.faury.fwmf.module.service.order.sqlProvider.PostageInfoSqlProvider;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface PackageInfoMapper extends PackageInfoGenerateMapper {

    @SelectProvider(type = PackageInfoSqlProvider.class, method = "search")
    @ResultType(PackageInfoBean.class)
    List<PackageInfoBean> search(Map<String, Object> params);

    @SelectProvider(type = PackageInfoSqlProvider.class, method = "getGoodsPackageList")
    @ResultType(PackageInfoBean.class)
    List<PackageInfoBean> getGoodsPackageList(Long goodsId);

    @UpdateProvider(type = PackageInfoSqlProvider.class, method = "deletePackageBatch")
    int deletePackageBatch(Map<String, Object> params);
}