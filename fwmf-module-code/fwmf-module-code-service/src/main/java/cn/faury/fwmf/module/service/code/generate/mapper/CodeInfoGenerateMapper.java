/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-14 22:45:40
 */
package cn.faury.fwmf.module.service.code.generate.mapper;

import cn.faury.fwmf.module.api.code.bean.CodeInfoBean;
import cn.faury.fwmf.module.api.code.generate.bean.CodeInfoGenerateBean;
import cn.faury.fwmf.module.service.code.generate.sqlProvider.CodeInfoGenerateSqlProvider;
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

public interface CodeInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_code_info
     *
     * @fwmf.generated 2018-11-14 22:45:40
     */
    @Delete({
        "delete from sys_t_code_info",
        "where CODE_ID = #{codeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long codeId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_code_info
     *
     * @fwmf.generated 2018-11-14 22:45:40
     */
    @Insert({
        "insert into sys_t_code_info (CODE_ID, CODE_GROUP_ID, ",
        "CODE_NAME, CODE_CODE, ",
        "CODE_ORDER)",
        "values (#{codeId,jdbcType=BIGINT}, #{codeGroupId,jdbcType=BIGINT}, ",
        "#{codeName,jdbcType=VARCHAR}, #{codeCode,jdbcType=VARCHAR}, ",
        "#{codeOrder,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="codeId")
    int insert(CodeInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_code_info
     *
     * @fwmf.generated 2018-11-14 22:45:40
     */
    @InsertProvider(type=CodeInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="codeId")
    int insertSelective(CodeInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_code_info
     *
     * @fwmf.generated 2018-11-14 22:45:40
     */
    @SelectProvider(type=CodeInfoGenerateSqlProvider.class, method="search")
    @ResultType(CodeInfoBean.class)
    List<CodeInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_code_info
     *
     * @fwmf.generated 2018-11-14 22:45:40
     */
    @Select({
        "select",
        "CODE_ID, CODE_GROUP_ID, CODE_NAME, CODE_CODE, CODE_ORDER",
        "from sys_t_code_info",
        "where CODE_ID = #{codeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="CODE_ID", property="codeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="CODE_GROUP_ID", property="codeGroupId", jdbcType=JdbcType.BIGINT),
        @Result(column="CODE_NAME", property="codeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_CODE", property="codeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="CODE_ORDER", property="codeOrder", jdbcType=JdbcType.INTEGER)
    })
    CodeInfoBean selectByPrimaryKey(Long codeId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_code_info
     *
     * @fwmf.generated 2018-11-14 22:45:40
     */
    @UpdateProvider(type=CodeInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CodeInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_code_info
     *
     * @fwmf.generated 2018-11-14 22:45:40
     */
    @Update({
        "update sys_t_code_info",
        "set CODE_GROUP_ID = #{codeGroupId,jdbcType=BIGINT},",
          "CODE_NAME = #{codeName,jdbcType=VARCHAR},",
          "CODE_CODE = #{codeCode,jdbcType=VARCHAR},",
          "CODE_ORDER = #{codeOrder,jdbcType=INTEGER}",
        "where CODE_ID = #{codeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CodeInfoGenerateBean record);
}