package cn.faury.fwmf.module.service.order.generate.mapper;

import cn.faury.fwmf.module.api.order.bean.PackageRGoodsBean;
import cn.faury.fwmf.module.api.order.generate.bean.PackageRGoodsGenerateBean;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.PackageRGoodsGenerateSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface PackageRGoodsGenerateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @mbg.generated Tue Aug 07 16:54:55 CST 2018
     */
    @Delete({
            "delete from order_t_package_r_goods",
            "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @mbg.generated Tue Aug 07 16:54:55 CST 2018
     */
    @Insert({
            "insert into order_t_package_r_goods (ID, PACKAGE_ID, ",
            "GOODS_ID, GOODS_TYPE)",
            "values (#{id,jdbcType=BIGINT}, #{packageId,jdbcType=BIGINT}, ",
            "#{goodsId,jdbcType=BIGINT}, #{goodsType,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true)
    int insert(PackageRGoodsGenerateBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @mbg.generated Tue Aug 07 16:54:55 CST 2018
     */
    @InsertProvider(type = PackageRGoodsGenerateSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true)
    int insertSelective(PackageRGoodsGenerateBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @mbg.generated Tue Aug 07 16:54:55 CST 2018
     */
    @Select({
            "select",
            "ID, PACKAGE_ID, GOODS_ID, GOODS_TYPE",
            "from order_t_package_r_goods",
            "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "ID", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "PACKAGE_ID", property = "packageId", jdbcType = JdbcType.BIGINT),
            @Result(column = "GOODS_ID", property = "goodsId", jdbcType = JdbcType.BIGINT),
            @Result(column = "GOODS_TYPE", property = "goodsType", jdbcType = JdbcType.VARCHAR)
    })
    PackageRGoodsBean selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @mbg.generated Tue Aug 07 16:54:55 CST 2018
     */
    @UpdateProvider(type = PackageRGoodsGenerateSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PackageRGoodsGenerateBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_package_r_goods
     *
     * @mbg.generated Tue Aug 07 16:54:55 CST 2018
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