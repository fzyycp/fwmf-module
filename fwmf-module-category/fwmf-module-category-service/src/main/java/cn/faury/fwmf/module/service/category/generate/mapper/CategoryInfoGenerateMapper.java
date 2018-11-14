/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-14 17:14:29
 */
package cn.faury.fwmf.module.service.category.generate.mapper;

import cn.faury.fwmf.module.api.category.bean.CategoryInfoBean;
import cn.faury.fwmf.module.api.category.generate.bean.CategoryInfoGenerateBean;
import cn.faury.fwmf.module.service.category.generate.sqlProvider.CategoryInfoGenerateSqlProvider;
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

public interface CategoryInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_info
     *
     * @fwmf.generated 2018-11-14 17:14:29
     */
    @Delete({
        "delete from product_t_category_info",
        "where PRODUCT_CATEGORY_ID = #{productCategoryId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long productCategoryId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_info
     *
     * @fwmf.generated 2018-11-14 17:14:29
     */
    @Insert({
        "insert into product_t_category_info (PRODUCT_CATEGORY_ID, PRODUCT_CATEGORY_NAME, ",
        "DISPLAY_ORDER, PARENT_ID, ",
        "USAGE_CODE, IS_DELETE, ",
        "XPATH)",
        "values (#{productCategoryId,jdbcType=BIGINT}, #{productCategoryName,jdbcType=VARCHAR}, ",
        "#{displayOrder,jdbcType=INTEGER}, #{parentId,jdbcType=BIGINT}, ",
        "#{usageCode,jdbcType=INTEGER}, #{isDelete,jdbcType=CHAR}, ",
        "#{xpath,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="productCategoryId")
    int insert(CategoryInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_info
     *
     * @fwmf.generated 2018-11-14 17:14:29
     */
    @InsertProvider(type=CategoryInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="productCategoryId")
    int insertSelective(CategoryInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_info
     *
     * @fwmf.generated 2018-11-14 17:14:29
     */
    @SelectProvider(type=CategoryInfoGenerateSqlProvider.class, method="search")
    @ResultType(CategoryInfoBean.class)
    List<CategoryInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_info
     *
     * @fwmf.generated 2018-11-14 17:14:29
     */
    @Select({
        "select",
        "PRODUCT_CATEGORY_ID, PRODUCT_CATEGORY_NAME, DISPLAY_ORDER, PARENT_ID, USAGE_CODE, ",
        "IS_DELETE, XPATH",
        "from product_t_category_info",
        "where PRODUCT_CATEGORY_ID = #{productCategoryId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="PRODUCT_CATEGORY_ID", property="productCategoryId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="PRODUCT_CATEGORY_NAME", property="productCategoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="DISPLAY_ORDER", property="displayOrder", jdbcType=JdbcType.INTEGER),
        @Result(column="PARENT_ID", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="USAGE_CODE", property="usageCode", jdbcType=JdbcType.INTEGER),
        @Result(column="IS_DELETE", property="isDelete", jdbcType=JdbcType.CHAR),
        @Result(column="XPATH", property="xpath", jdbcType=JdbcType.VARCHAR)
    })
    CategoryInfoBean selectByPrimaryKey(Long productCategoryId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_info
     *
     * @fwmf.generated 2018-11-14 17:14:29
     */
    @UpdateProvider(type=CategoryInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CategoryInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table product_t_category_info
     *
     * @fwmf.generated 2018-11-14 17:14:29
     */
    @Update({
        "update product_t_category_info",
        "set PRODUCT_CATEGORY_NAME = #{productCategoryName,jdbcType=VARCHAR},",
          "DISPLAY_ORDER = #{displayOrder,jdbcType=INTEGER},",
          "PARENT_ID = #{parentId,jdbcType=BIGINT},",
          "USAGE_CODE = #{usageCode,jdbcType=INTEGER},",
          "IS_DELETE = #{isDelete,jdbcType=CHAR},",
          "XPATH = #{xpath,jdbcType=VARCHAR}",
        "where PRODUCT_CATEGORY_ID = #{productCategoryId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CategoryInfoGenerateBean record);
}