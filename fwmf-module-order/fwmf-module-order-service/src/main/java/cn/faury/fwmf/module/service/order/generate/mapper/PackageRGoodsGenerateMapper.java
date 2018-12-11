/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-12-08 15:12:42
 */
package cn.faury.fwmf.module.service.order.generate.mapper;

import cn.faury.fwmf.module.api.order.bean.PackageRGoodsBean;
import cn.faury.fwmf.module.api.order.generate.bean.PackageRGoodsGenerateBean;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.PackageRGoodsGenerateSqlProvider;
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

public interface PackageRGoodsGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Delete({
        "delete from order_t_package_r_goods",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Insert({
        "insert into order_t_package_r_goods (ID, PACKAGE_ID, ",
        "GOODS_ID, GOODS_TYPE)",
        "values (#{id,jdbcType=BIGINT}, #{packageId,jdbcType=BIGINT}, ",
        "#{goodsId,jdbcType=BIGINT}, #{goodsType,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(PackageRGoodsGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @InsertProvider(type=PackageRGoodsGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(PackageRGoodsGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @SelectProvider(type=PackageRGoodsGenerateSqlProvider.class, method="search")
    @ResultType(PackageRGoodsBean.class)
    List<PackageRGoodsBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Select({
        "select",
        "ID, PACKAGE_ID, GOODS_ID, GOODS_TYPE",
        "from order_t_package_r_goods",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="PACKAGE_ID", property="packageId", jdbcType=JdbcType.BIGINT),
        @Result(column="GOODS_ID", property="goodsId", jdbcType=JdbcType.BIGINT),
        @Result(column="GOODS_TYPE", property="goodsType", jdbcType=JdbcType.VARCHAR)
    })
    PackageRGoodsBean selectByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @UpdateProvider(type=PackageRGoodsGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PackageRGoodsGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @fwmf.generated 2018-12-08 15:12:42
     */
    @Update({
        "update order_t_package_r_goods",
        "set PACKAGE_ID = #{packageId,jdbcType=BIGINT},",
          "GOODS_ID = #{goodsId,jdbcType=BIGINT},",
          "GOODS_TYPE = #{goodsType,jdbcType=VARCHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(PackageRGoodsGenerateBean record);
}