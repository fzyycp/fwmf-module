/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-21 14:58:58
 */
package cn.faury.fwmf.module.service.role.generate.mapper;

import cn.faury.fwmf.module.api.role.bean.RoleInfoBean;
import cn.faury.fwmf.module.api.role.generate.bean.RoleInfoGenerateBean;
import cn.faury.fwmf.module.service.role.generate.sqlProvider.RoleInfoGenerateSqlProvider;
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

public interface RoleInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_role_info
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    @Delete({
        "delete from sys_t_role_info",
        "where ROLE_ID = #{roleId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long roleId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_role_info
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    @Insert({
        "insert into sys_t_role_info (ROLE_ID, ROLE_NAME, ",
        "ROLE_CODE, IS_AVAILABLE, ",
        "SYSTEM_ID)",
        "values (#{roleId,jdbcType=BIGINT}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleCode,jdbcType=VARCHAR}, #{isAvailable,jdbcType=CHAR}, ",
        "#{systemId,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="roleId")
    int insert(RoleInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_role_info
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    @InsertProvider(type=RoleInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="roleId")
    int insertSelective(RoleInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_role_info
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    @SelectProvider(type=RoleInfoGenerateSqlProvider.class, method="search")
    @ResultType(RoleInfoBean.class)
    List<RoleInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_role_info
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    @Select({
        "select",
        "ROLE_ID, ROLE_NAME, ROLE_CODE, IS_AVAILABLE, SYSTEM_ID",
        "from sys_t_role_info",
        "where ROLE_ID = #{roleId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ROLE_ID", property="roleId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="ROLE_NAME", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ROLE_CODE", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_AVAILABLE", property="isAvailable", jdbcType=JdbcType.CHAR),
        @Result(column="SYSTEM_ID", property="systemId", jdbcType=JdbcType.BIGINT)
    })
    RoleInfoBean selectByPrimaryKey(Long roleId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_role_info
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    @UpdateProvider(type=RoleInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RoleInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_role_info
     *
     * @fwmf.generated 2018-09-21 14:58:58
     */
    @Update({
        "update sys_t_role_info",
        "set ROLE_NAME = #{roleName,jdbcType=VARCHAR},",
          "ROLE_CODE = #{roleCode,jdbcType=VARCHAR},",
          "IS_AVAILABLE = #{isAvailable,jdbcType=CHAR},",
          "SYSTEM_ID = #{systemId,jdbcType=BIGINT}",
        "where ROLE_ID = #{roleId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RoleInfoGenerateBean record);
}