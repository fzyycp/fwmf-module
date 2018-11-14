/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-14 15:41:38
 */
package cn.faury.fwmf.module.service.order.generate.mapper;

import cn.faury.fwmf.module.api.order.bean.GoodsStockInfoBean;
import cn.faury.fwmf.module.api.order.generate.bean.GoodsStockInfoGenerateBean;
import cn.faury.fwmf.module.service.order.generate.sqlProvider.GoodsStockInfoGenerateSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface GoodsStockInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_goods_stock_info
     *
     * @fwmf.generated 2018-11-14 15:41:38
     */
    @Delete({
        "delete from order_t_goods_stock_info",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_goods_stock_info
     *
     * @fwmf.generated 2018-11-14 15:41:38
     */
    @Insert({
        "insert into order_t_goods_stock_info (ID, GOODS_ID, ",
        "STOCK, DEMO, CREATE_PERSON, ",
        "CREATE_TIME, IS_DELETE)",
        "values (#{id,jdbcType=BIGINT}, #{goodsId,jdbcType=BIGINT}, ",
        "#{stock,jdbcType=INTEGER}, #{demo,jdbcType=VARCHAR}, #{createPerson,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{isDelete,jdbcType=CHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(GoodsStockInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_goods_stock_info
     *
     * @fwmf.generated 2018-11-14 15:41:38
     */
    @InsertProvider(type=GoodsStockInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(GoodsStockInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_goods_stock_info
     *
     * @fwmf.generated 2018-11-14 15:41:38
     */
    @SelectProvider(type=GoodsStockInfoGenerateSqlProvider.class, method="search")
    @ResultType(GoodsStockInfoBean.class)
    List<GoodsStockInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_goods_stock_info
     *
     * @fwmf.generated 2018-11-14 15:41:38
     */
    @Select({
        "select",
        "ID, GOODS_ID, STOCK, DEMO, CREATE_PERSON, CREATE_TIME, IS_DELETE",
        "from order_t_goods_stock_info",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="GOODS_ID", property="goodsId", jdbcType=JdbcType.BIGINT),
        @Result(column="STOCK", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="DEMO", property="demo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_PERSON", property="createPerson", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="IS_DELETE", property="isDelete", jdbcType=JdbcType.CHAR)
    })
    GoodsStockInfoBean selectByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_goods_stock_info
     *
     * @fwmf.generated 2018-11-14 15:41:38
     */
    @UpdateProvider(type=GoodsStockInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GoodsStockInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table order_t_goods_stock_info
     *
     * @fwmf.generated 2018-11-14 15:41:38
     */
    @Update({
        "update order_t_goods_stock_info",
        "set GOODS_ID = #{goodsId,jdbcType=BIGINT},",
          "STOCK = #{stock,jdbcType=INTEGER},",
          "DEMO = #{demo,jdbcType=VARCHAR},",
          "CREATE_PERSON = #{createPerson,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "IS_DELETE = #{isDelete,jdbcType=CHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(GoodsStockInfoGenerateBean record);
}