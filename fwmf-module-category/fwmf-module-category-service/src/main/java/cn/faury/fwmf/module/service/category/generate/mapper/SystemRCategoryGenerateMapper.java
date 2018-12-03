/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-15 08:50:34
 */
package cn.faury.fwmf.module.service.category.generate.mapper;

import cn.faury.fwmf.module.api.category.bean.SystemRCategoryBean;
import cn.faury.fwmf.module.api.category.generate.bean.SystemRCategoryGenerateBean;
import cn.faury.fwmf.module.service.category.generate.sqlProvider.SystemRCategoryGenerateSqlProvider;
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

public interface SystemRCategoryGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_r_system
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    @Delete({
        "delete from product_t_category_r_system",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_r_system
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    @Insert({
        "insert into product_t_category_r_system (ID, SYSTEM_ID, ",
        "PRODUCT_CATEGORY_ID, USAGE_CODE, ",
        "IS_LEAF)",
        "values (#{id,jdbcType=BIGINT}, #{systemId,jdbcType=BIGINT}, ",
        "#{productCategoryId,jdbcType=BIGINT}, #{usageCode,jdbcType=INTEGER}, ",
        "#{isLeaf,jdbcType=CHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemRCategoryGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_r_system
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    @InsertProvider(type=SystemRCategoryGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemRCategoryGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_r_system
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    @SelectProvider(type=SystemRCategoryGenerateSqlProvider.class, method="search")
    @ResultType(SystemRCategoryBean.class)
    List<SystemRCategoryBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_r_system
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    @Select({
        "select",
        "ID, SYSTEM_ID, PRODUCT_CATEGORY_ID, USAGE_CODE, IS_LEAF",
        "from product_t_category_r_system",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SYSTEM_ID", property="systemId", jdbcType=JdbcType.BIGINT),
        @Result(column="PRODUCT_CATEGORY_ID", property="productCategoryId", jdbcType=JdbcType.BIGINT),
        @Result(column="USAGE_CODE", property="usageCode", jdbcType=JdbcType.INTEGER),
        @Result(column="IS_LEAF", property="isLeaf", jdbcType=JdbcType.CHAR)
    })
    SystemRCategoryBean selectByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_r_system
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    @UpdateProvider(type=SystemRCategoryGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemRCategoryGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_r_system
     *
     * @fwmf.generated 2018-11-15 08:50:34
     */
    @Update({
        "update product_t_category_r_system",
        "set SYSTEM_ID = #{systemId,jdbcType=BIGINT},",
          "PRODUCT_CATEGORY_ID = #{productCategoryId,jdbcType=BIGINT},",
          "USAGE_CODE = #{usageCode,jdbcType=INTEGER},",
          "IS_LEAF = #{isLeaf,jdbcType=CHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SystemRCategoryGenerateBean record);
}