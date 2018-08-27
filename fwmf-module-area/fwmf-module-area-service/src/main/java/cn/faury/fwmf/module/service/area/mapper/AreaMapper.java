package cn.faury.fwmf.module.service.area.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.area.bean.AreaBean;
import cn.faury.fwmf.module.service.area.sqlProvider.AreaSQLProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@AutoScannedMapper
public interface AreaMapper {

    /**
     * 获取指定的查询获取地区
     *
     * @return 区域信息
     */
    @SelectProvider(type = AreaSQLProvider.class, method = "getAreaByCode")
    @ResultType(AreaBean.class)
    List<AreaBean> getAreaByCode();

}
