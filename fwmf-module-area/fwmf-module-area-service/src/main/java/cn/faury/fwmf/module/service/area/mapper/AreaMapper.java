package cn.faury.fwmf.module.service.area.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.area.bean.AreaBean;
import cn.faury.fwmf.module.service.area.sqlProvider.AreaSQLProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;


@AutoScannedMapper
public interface AreaMapper {

    /**
     * 获取指定的查询获取地区
     * <p/>
     * <pre>
     * 可能出现的参数：
     * 【必填】String  标签ID
     * </pre>
     *
     * @return 区域信息
     */
    @SelectProvider(type = AreaSQLProvider.class, method = "getAreaByCode")
    @Results({@Result(property = "admareaCode", column = "ADMAREA_ID", javaType = String.class),
            @Result(property = "admareaName", column = "ADMAREA_NAME", javaType = String.class)})
    List<AreaBean> getAreaByCode();

}
