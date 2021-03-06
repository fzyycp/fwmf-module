/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-12-08 15:12:42
 */
package cn.faury.fwmf.module.service.order.generate.mapper;

import cn.faury.fwmf.module.api.order.bean.PostageRAreaBean;
import cn.faury.fwmf.module.api.order.generate.bean.PostageRAreaGenerateBean;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.PostageRAreaGenerateSqlProvider;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PostageRAreaGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_r_area
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Delete({
        "delete from order_t_postage_r_area",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_r_area
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Insert({
        "insert into order_t_postage_r_area (ID, POSTAGE_ID, ",
        "AREA_CODE_PROVINCE, AREA_DESC_PROVINCE, ",
        "GOODS_COUNT, POSTAGE_PRICE, ",
        "INCREASE_GOODS_COUNT, INCREASE_POSTAGE_PRICE)",
        "values (#{id,jdbcType=BIGINT}, #{postageId,jdbcType=BIGINT}, ",
        "#{areaCodeProvince,jdbcType=VARCHAR}, #{areaDescProvince,jdbcType=VARCHAR}, ",
        "#{goodsCount,jdbcType=INTEGER}, #{postagePrice,jdbcType=DECIMAL}, ",
        "#{increaseGoodsCount,jdbcType=INTEGER}, #{increasePostagePrice,jdbcType=DECIMAL})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(PostageRAreaGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_r_area
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @InsertProvider(type=PostageRAreaGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(PostageRAreaGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_r_area
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @SelectProvider(type=PostageRAreaGenerateSqlProvider.class, method="search")
    @ResultType(PostageRAreaBean.class)
    List<PostageRAreaBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_r_area
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Select({
        "select",
        "ID, POSTAGE_ID, AREA_CODE_PROVINCE, AREA_DESC_PROVINCE, GOODS_COUNT, POSTAGE_PRICE, ",
        "INCREASE_GOODS_COUNT, INCREASE_POSTAGE_PRICE",
        "from order_t_postage_r_area",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="POSTAGE_ID", property="postageId", jdbcType=JdbcType.BIGINT),
        @Result(column="AREA_CODE_PROVINCE", property="areaCodeProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="AREA_DESC_PROVINCE", property="areaDescProvince", jdbcType=JdbcType.VARCHAR),
        @Result(column="GOODS_COUNT", property="goodsCount", jdbcType=JdbcType.INTEGER),
        @Result(column="POSTAGE_PRICE", property="postagePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="INCREASE_GOODS_COUNT", property="increaseGoodsCount", jdbcType=JdbcType.INTEGER),
        @Result(column="INCREASE_POSTAGE_PRICE", property="increasePostagePrice", jdbcType=JdbcType.DECIMAL)
    })
    PostageRAreaBean selectByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_r_area
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @UpdateProvider(type=PostageRAreaGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PostageRAreaGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_r_area
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Update({
        "update order_t_postage_r_area",
        "set POSTAGE_ID = #{postageId,jdbcType=BIGINT},",
          "AREA_CODE_PROVINCE = #{areaCodeProvince,jdbcType=VARCHAR},",
          "AREA_DESC_PROVINCE = #{areaDescProvince,jdbcType=VARCHAR},",
          "GOODS_COUNT = #{goodsCount,jdbcType=INTEGER},",
          "POSTAGE_PRICE = #{postagePrice,jdbcType=DECIMAL},",
          "INCREASE_GOODS_COUNT = #{increaseGoodsCount,jdbcType=INTEGER},",
          "INCREASE_POSTAGE_PRICE = #{increasePostagePrice,jdbcType=DECIMAL}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PostageRAreaGenerateBean record);
}