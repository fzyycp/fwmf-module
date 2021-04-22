/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2019-01-17 14:52:11
 */
package cn.faury.fwmf.module.service.systemconfig.generate.mapper;

import cn.faury.fwmf.module.api.systemconfig.bean.SystemConfigBean;
import cn.faury.fwmf.module.api.systemconfig.generate.bean.SystemConfigGenerateBean;
import cn.faury.fwmf.module.service.systemconfig.generate.sqlProvider.SystemConfigGenerateSqlProvider;
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

public interface SystemConfigGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_system_config
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    @Delete({
        "DELETE FROM sys_t_system_config",
        "WHERE `SYSTEM_CONFIG_ID` = #{systemConfigId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long systemConfigId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_system_config
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    @Insert({
        "INSERT INTO sys_t_system_config (`SYSTEM_CONFIG_ID`, `SYSTEM_CONFIG_KEY`, ",
        "`SYSTEM_CONFIG_VALUE`, `SYSTEM_CONFIG_SYSTEM_ID`, ",
        "`SYSTEM_CONFIG_DESC`)",
        "VALUES (#{systemConfigId,jdbcType=BIGINT}, #{systemConfigKey,jdbcType=VARCHAR}, ",
        "#{systemConfigValue,jdbcType=VARCHAR}, #{systemConfigSystemId,jdbcType=BIGINT}, ",
        "#{systemConfigDesc,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="systemConfigId")
    int insert(SystemConfigGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_system_config
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    @InsertProvider(type=SystemConfigGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="systemConfigId")
    int insertSelective(SystemConfigGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_system_config
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    @SelectProvider(type=SystemConfigGenerateSqlProvider.class, method="search")
    @ResultType(SystemConfigBean.class)
    List<SystemConfigBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_system_config
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    @Select({
        "SELECT",
        "`SYSTEM_CONFIG_ID`, `SYSTEM_CONFIG_KEY`, `SYSTEM_CONFIG_VALUE`, `SYSTEM_CONFIG_SYSTEM_ID`, ",
        "`SYSTEM_CONFIG_DESC`",
        "FROM sys_t_system_config",
        "WHERE `SYSTEM_CONFIG_ID` = #{systemConfigId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="SYSTEM_CONFIG_ID", property="systemConfigId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SYSTEM_CONFIG_KEY", property="systemConfigKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="SYSTEM_CONFIG_VALUE", property="systemConfigValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="SYSTEM_CONFIG_SYSTEM_ID", property="systemConfigSystemId", jdbcType=JdbcType.BIGINT),
        @Result(column="SYSTEM_CONFIG_DESC", property="systemConfigDesc", jdbcType=JdbcType.VARCHAR)
    })
    SystemConfigBean selectByPrimaryKey(Long systemConfigId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_system_config
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    @UpdateProvider(type=SystemConfigGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemConfigGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_system_config
     *
     * @fwmf.generated 2019-01-17 14:52:11
     */
    @Update({
        "UPDATE sys_t_system_config",
        "SET `SYSTEM_CONFIG_KEY` = #{systemConfigKey,jdbcType=VARCHAR},",
          "`SYSTEM_CONFIG_VALUE` = #{systemConfigValue,jdbcType=VARCHAR},",
          "`SYSTEM_CONFIG_SYSTEM_ID` = #{systemConfigSystemId,jdbcType=BIGINT},",
          "`SYSTEM_CONFIG_DESC` = #{systemConfigDesc,jdbcType=VARCHAR}",
        "WHERE `SYSTEM_CONFIG_ID` = #{systemConfigId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SystemConfigGenerateBean record);
}