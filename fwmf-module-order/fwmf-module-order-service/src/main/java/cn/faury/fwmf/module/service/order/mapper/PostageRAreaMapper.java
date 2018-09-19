package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.PostageRAreaBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.PostageRAreaGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.PostageRAreaSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface PostageRAreaMapper extends PostageRAreaGenerateMapper {

    @SelectProvider(type = PostageRAreaSqlProvider.class, method = "search")
    @ResultType(PostageRAreaBean.class)
    List<PostageRAreaBean> search(Map<String, Object> params);

    @Select({"SELECT ID, POSTAGE_ID, AREA_CODE_PROVINCE, AREA_DESC_PROVINCE,GOODS_COUNT" +
            "        , POSTAGE_PRICE, INCREASE_GOODS_COUNT, INCREASE_POSTAGE_PRICE"
            , "FROM", DBConstOfOrder.ORDER_T_POSTAGE_R_AREA, "WHERE POSTAGE_ID=#{postageId}"})
    @ResultType(PostageRAreaBean.class)
    List<PostageRAreaBean> getBeanListByPostageId(Long postageId);

    @SelectProvider(type = PostageRAreaSqlProvider.class, method = "getBeanListByPostageIds")
    @ResultType(PostageRAreaBean.class)
    List<PostageRAreaBean> getBeanListByPostageIds(Map<String,Object> params);

    @Delete({"DELETE FROM", DBConstOfOrder.ORDER_T_POSTAGE_R_AREA, "WHERE POSTAGE_ID=#{postageId}"})
    int deleteByPostageId(Long postageId);
}