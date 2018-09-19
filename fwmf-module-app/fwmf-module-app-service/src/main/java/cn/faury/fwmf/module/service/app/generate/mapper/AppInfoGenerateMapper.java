/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-19 09:50:08
 */
package cn.faury.fwmf.module.service.app.generate.mapper;

import cn.faury.fwmf.module.api.app.bean.AppInfoBean;
import cn.faury.fwmf.module.api.app.generate.bean.AppInfoGenerateBean;
import cn.faury.fwmf.module.service.app.generate.sqlProvider.AppInfoGenerateSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface AppInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_info
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @Delete({
        "delete from sys_t_app_info",
        "where APP_ID = #{appId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long appId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_info
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @Insert({
        "insert into sys_t_app_info (APP_ID, APP_CODE, ",
        "APP_NAME, APP_OS, ",
        "SYSTEM_ID, REJECT_GUEST_USER, ",
        "REJECT_SHOPPING_USER, ALLOW_BACKGROUND_USER, ",
        "IS_AVAILABLE, TRACK_ID, ",
        "SERVER_DOMAIN)",
        "values (#{appId,jdbcType=BIGINT}, #{appCode,jdbcType=VARCHAR}, ",
        "#{appName,jdbcType=VARCHAR}, #{appOs,jdbcType=VARCHAR}, ",
        "#{systemId,jdbcType=BIGINT}, #{rejectGuestUser,jdbcType=CHAR}, ",
        "#{rejectShoppingUser,jdbcType=CHAR}, #{allowBackgroundUser,jdbcType=CHAR}, ",
        "#{isAvailable,jdbcType=CHAR}, #{trackId,jdbcType=VARCHAR}, ",
        "#{serverDomain,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="appId")
    int insert(AppInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_info
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @InsertProvider(type=AppInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="appId")
    int insertSelective(AppInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_info
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @SelectProvider(type=AppInfoGenerateSqlProvider.class, method="search")
    @ResultType(AppInfoBean.class)
    List<AppInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_info
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @Select({
        "select",
        "APP_ID, APP_CODE, APP_NAME, APP_OS, SYSTEM_ID, REJECT_GUEST_USER, REJECT_SHOPPING_USER, ",
        "ALLOW_BACKGROUND_USER, IS_AVAILABLE, TRACK_ID, SERVER_DOMAIN",
        "from sys_t_app_info",
        "where APP_ID = #{appId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="APP_CODE", property="appCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="APP_NAME", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="APP_OS", property="appOs", jdbcType=JdbcType.VARCHAR),
        @Result(column="SYSTEM_ID", property="systemId", jdbcType=JdbcType.BIGINT),
        @Result(column="REJECT_GUEST_USER", property="rejectGuestUser", jdbcType=JdbcType.CHAR),
        @Result(column="REJECT_SHOPPING_USER", property="rejectShoppingUser", jdbcType=JdbcType.CHAR),
        @Result(column="ALLOW_BACKGROUND_USER", property="allowBackgroundUser", jdbcType=JdbcType.CHAR),
        @Result(column="IS_AVAILABLE", property="isAvailable", jdbcType=JdbcType.CHAR),
        @Result(column="TRACK_ID", property="trackId", jdbcType=JdbcType.VARCHAR),
        @Result(column="SERVER_DOMAIN", property="serverDomain", jdbcType=JdbcType.VARCHAR)
    })
    AppInfoBean selectByPrimaryKey(Long appId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_info
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @UpdateProvider(type=AppInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_info
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @Update({
        "update sys_t_app_info",
        "set APP_CODE = #{appCode,jdbcType=VARCHAR},",
          "APP_NAME = #{appName,jdbcType=VARCHAR},",
          "APP_OS = #{appOs,jdbcType=VARCHAR},",
          "SYSTEM_ID = #{systemId,jdbcType=BIGINT},",
          "REJECT_GUEST_USER = #{rejectGuestUser,jdbcType=CHAR},",
          "REJECT_SHOPPING_USER = #{rejectShoppingUser,jdbcType=CHAR},",
          "ALLOW_BACKGROUND_USER = #{allowBackgroundUser,jdbcType=CHAR},",
          "IS_AVAILABLE = #{isAvailable,jdbcType=CHAR},",
          "TRACK_ID = #{trackId,jdbcType=VARCHAR},",
          "SERVER_DOMAIN = #{serverDomain,jdbcType=VARCHAR}",
        "where APP_ID = #{appId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AppInfoGenerateBean record);
}