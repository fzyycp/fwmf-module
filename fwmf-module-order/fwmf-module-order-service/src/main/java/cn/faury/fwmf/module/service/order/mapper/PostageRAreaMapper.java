package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.order.bean.PostageRAreaBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.PostageRAreaGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.PostageRAreaSqlProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：地区类型各地区具体邮费信息
 *
 * <pre>
 *     PostageRAreaGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自PostageRAreaGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface PostageRAreaMapper extends PostageRAreaGenerateMapper {

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