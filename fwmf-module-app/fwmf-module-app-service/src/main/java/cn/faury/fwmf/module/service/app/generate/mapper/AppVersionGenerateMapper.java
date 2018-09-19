/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-19 09:50:08
 */
package cn.faury.fwmf.module.service.app.generate.mapper;

import cn.faury.fwmf.module.api.app.bean.AppVersionBean;
import cn.faury.fwmf.module.api.app.generate.bean.AppVersionGenerateBean;
import cn.faury.fwmf.module.service.app.generate.sqlProvider.AppVersionGenerateSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface AppVersionGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_version
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @Delete({
        "delete from sys_t_app_version",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_version
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @Insert({
        "insert into sys_t_app_version (ID, SYS_TYPE, ",
        "VERSION_NUM, URL_TYPE, ",
        "PATH, TITLE, SIZE, ",
        "SYS_ID, APP_ID, IS_COERCION, ",
        "IS_FORMAL, IDENTIFIER, ",
        "MEMO, CREATE_PERSON, ",
        "CREATE_PERSON_NAME, CREATE_TIME, ",
        "UPDATE_PERSON, UPDATE_PERSON_NAME, ",
        "UPDATE_TIME, DEL_FLAG)",
        "values (#{id,jdbcType=BIGINT}, #{sysType,jdbcType=VARCHAR}, ",
        "#{versionNum,jdbcType=VARCHAR}, #{urlType,jdbcType=CHAR}, ",
        "#{path,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, #{size,jdbcType=BIGINT}, ",
        "#{sysId,jdbcType=BIGINT}, #{appId,jdbcType=BIGINT}, #{isCoercion,jdbcType=CHAR}, ",
        "#{isFormal,jdbcType=CHAR}, #{identifier,jdbcType=VARCHAR}, ",
        "#{memo,jdbcType=VARCHAR}, #{createPerson,jdbcType=BIGINT}, ",
        "#{createPersonName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updatePerson,jdbcType=BIGINT}, #{updatePersonName,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{delFlag,jdbcType=CHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(AppVersionGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_version
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @InsertProvider(type=AppVersionGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(AppVersionGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_version
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @SelectProvider(type=AppVersionGenerateSqlProvider.class, method="search")
    @ResultType(AppVersionBean.class)
    List<AppVersionBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_version
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @Select({
        "select",
        "ID, SYS_TYPE, VERSION_NUM, URL_TYPE, PATH, TITLE, SIZE, SYS_ID, APP_ID, IS_COERCION, ",
        "IS_FORMAL, IDENTIFIER, MEMO, CREATE_PERSON, CREATE_PERSON_NAME, CREATE_TIME, ",
        "UPDATE_PERSON, UPDATE_PERSON_NAME, UPDATE_TIME, DEL_FLAG",
        "from sys_t_app_version",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SYS_TYPE", property="sysType", jdbcType=JdbcType.VARCHAR),
        @Result(column="VERSION_NUM", property="versionNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="URL_TYPE", property="urlType", jdbcType=JdbcType.CHAR),
        @Result(column="PATH", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="TITLE", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="SIZE", property="size", jdbcType=JdbcType.BIGINT),
        @Result(column="SYS_ID", property="sysId", jdbcType=JdbcType.BIGINT),
        @Result(column="APP_ID", property="appId", jdbcType=JdbcType.BIGINT),
        @Result(column="IS_COERCION", property="isCoercion", jdbcType=JdbcType.CHAR),
        @Result(column="IS_FORMAL", property="isFormal", jdbcType=JdbcType.CHAR),
        @Result(column="IDENTIFIER", property="identifier", jdbcType=JdbcType.VARCHAR),
        @Result(column="MEMO", property="memo", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_PERSON", property="createPerson", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_PERSON_NAME", property="createPersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_PERSON", property="updatePerson", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_PERSON_NAME", property="updatePersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="DEL_FLAG", property="delFlag", jdbcType=JdbcType.CHAR)
    })
    AppVersionBean selectByPrimaryKey(Long id);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_version
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @UpdateProvider(type=AppVersionGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AppVersionGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_app_version
     *
     * @fwmf.generated 2018-09-19 09:50:08
     */
    @Update({
        "update sys_t_app_version",
        "set SYS_TYPE = #{sysType,jdbcType=VARCHAR},",
          "VERSION_NUM = #{versionNum,jdbcType=VARCHAR},",
          "URL_TYPE = #{urlType,jdbcType=CHAR},",
          "PATH = #{path,jdbcType=VARCHAR},",
          "TITLE = #{title,jdbcType=VARCHAR},",
          "SIZE = #{size,jdbcType=BIGINT},",
          "SYS_ID = #{sysId,jdbcType=BIGINT},",
          "APP_ID = #{appId,jdbcType=BIGINT},",
          "IS_COERCION = #{isCoercion,jdbcType=CHAR},",
          "IS_FORMAL = #{isFormal,jdbcType=CHAR},",
          "IDENTIFIER = #{identifier,jdbcType=VARCHAR},",
          "MEMO = #{memo,jdbcType=VARCHAR},",
          "CREATE_PERSON = #{createPerson,jdbcType=BIGINT},",
          "CREATE_PERSON_NAME = #{createPersonName,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_PERSON = #{updatePerson,jdbcType=BIGINT},",
          "UPDATE_PERSON_NAME = #{updatePersonName,jdbcType=VARCHAR},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
          "DEL_FLAG = #{delFlag,jdbcType=CHAR}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AppVersionGenerateBean record);
}