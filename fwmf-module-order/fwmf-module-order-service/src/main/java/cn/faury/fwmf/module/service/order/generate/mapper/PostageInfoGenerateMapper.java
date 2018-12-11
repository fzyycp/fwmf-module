/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-12-08 15:12:42
 */
package cn.faury.fwmf.module.service.order.generate.mapper;

import cn.faury.fwmf.module.api.order.bean.PostageInfoBean;
import cn.faury.fwmf.module.api.order.generate.bean.PostageInfoGenerateBean;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.PostageInfoGenerateSqlProvider;
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

public interface PostageInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Delete({
        "delete from order_t_postage_info",
        "where POSTAGE_ID = #{postageId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long postageId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Insert({
        "insert into order_t_postage_info (POSTAGE_ID, POSTAGE_NAME, ",
        "POSTAGE_TYPE, GOODS_COUNT, ",
        "POSTAGE_PRICE, INCREASE_GOODS_COUNT, ",
        "INCREASE_POSTAGE_PRICE, CREATE_PERSON, ",
        "CREATE_TIME, UPDATE_PERSON, ",
        "UPDATE_TIME)",
        "values (#{postageId,jdbcType=BIGINT}, #{postageName,jdbcType=VARCHAR}, ",
        "#{postageType,jdbcType=CHAR}, #{goodsCount,jdbcType=INTEGER}, ",
        "#{postagePrice,jdbcType=DECIMAL}, #{increaseGoodsCount,jdbcType=INTEGER}, ",
        "#{increasePostagePrice,jdbcType=DECIMAL}, #{createPerson,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updatePerson,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="postageId")
    int insert(PostageInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @InsertProvider(type=PostageInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="postageId")
    int insertSelective(PostageInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @SelectProvider(type=PostageInfoGenerateSqlProvider.class, method="search")
    @ResultType(PostageInfoBean.class)
    List<PostageInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Select({
        "select",
        "POSTAGE_ID, POSTAGE_NAME, POSTAGE_TYPE, GOODS_COUNT, POSTAGE_PRICE, INCREASE_GOODS_COUNT, ",
        "INCREASE_POSTAGE_PRICE, CREATE_PERSON, CREATE_TIME, UPDATE_PERSON, UPDATE_TIME",
        "from order_t_postage_info",
        "where POSTAGE_ID = #{postageId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="POSTAGE_ID", property="postageId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="POSTAGE_NAME", property="postageName", jdbcType=JdbcType.VARCHAR),
        @Result(column="POSTAGE_TYPE", property="postageType", jdbcType=JdbcType.CHAR),
        @Result(column="GOODS_COUNT", property="goodsCount", jdbcType=JdbcType.INTEGER),
        @Result(column="POSTAGE_PRICE", property="postagePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="INCREASE_GOODS_COUNT", property="increaseGoodsCount", jdbcType=JdbcType.INTEGER),
        @Result(column="INCREASE_POSTAGE_PRICE", property="increasePostagePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="CREATE_PERSON", property="createPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_PERSON", property="updatePerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PostageInfoBean selectByPrimaryKey(Long postageId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @UpdateProvider(type=PostageInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PostageInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_postage_info
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Update({
        "update order_t_postage_info",
        "set POSTAGE_NAME = #{postageName,jdbcType=VARCHAR},",
          "POSTAGE_TYPE = #{postageType,jdbcType=CHAR},",
          "GOODS_COUNT = #{goodsCount,jdbcType=INTEGER},",
          "POSTAGE_PRICE = #{postagePrice,jdbcType=DECIMAL},",
          "INCREASE_GOODS_COUNT = #{increaseGoodsCount,jdbcType=INTEGER},",
          "INCREASE_POSTAGE_PRICE = #{increasePostagePrice,jdbcType=DECIMAL},",
          "CREATE_PERSON = #{createPerson,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_PERSON = #{updatePerson,jdbcType=VARCHAR},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where POSTAGE_ID = #{postageId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PostageInfoGenerateBean record);
}