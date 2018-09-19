package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.PostageInfoBean;
import cn.faury.fwmf.module.service.order.generate.mapper.PostageInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.PostageInfoSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface PostageInfoMapper extends PostageInfoGenerateMapper {

    @SelectProvider(type = PostageInfoSqlProvider.class, method = "search")
    @ResultType(PostageInfoBean.class)
    List<PostageInfoBean> search(Map<String, Object> params);

    @SelectProvider(type = PostageInfoSqlProvider.class, method = "getBeanListByIds")
    @ResultType(PostageInfoBean.class)
    List<PostageInfoBean> getBeanListByIds(Map<String, Object> params);
}