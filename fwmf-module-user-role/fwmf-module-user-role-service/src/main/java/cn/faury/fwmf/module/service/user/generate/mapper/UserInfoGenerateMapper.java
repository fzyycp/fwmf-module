/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2019-02-18 10:33:36
 */
package cn.faury.fwmf.module.service.user.generate.mapper;

import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.api.user.generate.bean.UserInfoGenerateBean;
import cn.faury.fwmf.module.service.user.generate.sqlProvider.UserInfoGenerateSqlProvider;
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

public interface UserInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2019-02-18 10:33:36
     */
    @Delete({
        "DELETE FROM sys_t_user_info",
        "WHERE `USER_ID` = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long userId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2019-02-18 10:33:36
     */
    @Insert({
        "INSERT INTO sys_t_user_info (`USER_ID`, `LOGIN_NAME`, ",
        "`USER_NAME`, `PASSWORD`, ",
        "`EFCT_YMD`, `EXPR_YMD`, `INS_TSTMP`, ",
        "`ORIGIN_OS_ID`, `USER_TYPE`, ",
        "`IS_ENABLE`, `IS_DELETE`, `CREATE_PERSON`, ",
        "`CREATE_PERSON_NAME`, `UPDATE_PERSON`, ",
        "`UPDATE_PERSON_NAME`, `UPDATE_TIME`)",
        "VALUES (#{userId,jdbcType=BIGINT}, #{loginName,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{efctYmd,jdbcType=DATE}, #{exprYmd,jdbcType=DATE}, #{insTstmp,jdbcType=TIMESTAMP}, ",
        "#{originOsId,jdbcType=BIGINT}, #{userType,jdbcType=VARCHAR}, ",
        "#{isEnable,jdbcType=CHAR}, #{isDelete,jdbcType=CHAR}, #{createPerson,jdbcType=BIGINT}, ",
        "#{createPersonName,jdbcType=VARCHAR}, #{updatePerson,jdbcType=BIGINT}, ",
        "#{updatePersonName,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="userId")
    int insert(UserInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2019-02-18 10:33:36
     */
    @InsertProvider(type=UserInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="userId")
    int insertSelective(UserInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2019-02-18 10:33:36
     */
    @SelectProvider(type=UserInfoGenerateSqlProvider.class, method="search")
    @ResultType(UserInfoBean.class)
    List<UserInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2019-02-18 10:33:36
     */
    @Select({
        "SELECT",
        "`USER_ID`, `LOGIN_NAME`, `USER_NAME`, `PASSWORD`, `EFCT_YMD`, `EXPR_YMD`, `INS_TSTMP`, ",
        "`ORIGIN_OS_ID`, `USER_TYPE`, `IS_ENABLE`, `IS_DELETE`, `CREATE_PERSON`, `CREATE_PERSON_NAME`, ",
        "`UPDATE_PERSON`, `UPDATE_PERSON_NAME`, `UPDATE_TIME`",
        "FROM sys_t_user_info",
        "WHERE `USER_ID` = #{userId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="USER_ID", property="userId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="LOGIN_NAME", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="USER_NAME", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="PASSWORD", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="EFCT_YMD", property="efctYmd", jdbcType=JdbcType.DATE),
        @Result(column="EXPR_YMD", property="exprYmd", jdbcType=JdbcType.DATE),
        @Result(column="INS_TSTMP", property="insTstmp", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ORIGIN_OS_ID", property="originOsId", jdbcType=JdbcType.BIGINT),
        @Result(column="USER_TYPE", property="userType", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_ENABLE", property="isEnable", jdbcType=JdbcType.CHAR),
        @Result(column="IS_DELETE", property="isDelete", jdbcType=JdbcType.CHAR),
        @Result(column="CREATE_PERSON", property="createPerson", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_PERSON_NAME", property="createPersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_PERSON", property="updatePerson", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_PERSON_NAME", property="updatePersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    UserInfoBean selectByPrimaryKey(Long userId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2019-02-18 10:33:36
     */
    @UpdateProvider(type=UserInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_user_info
     *
     * @fwmf.generated 2019-02-18 10:33:36
     */
    @Update({
        "UPDATE sys_t_user_info",
        "SET `LOGIN_NAME` = #{loginName,jdbcType=VARCHAR},",
          "`USER_NAME` = #{userName,jdbcType=VARCHAR},",
          "`PASSWORD` = #{password,jdbcType=VARCHAR},",
          "`EFCT_YMD` = #{efctYmd,jdbcType=DATE},",
          "`EXPR_YMD` = #{exprYmd,jdbcType=DATE},",
          "`INS_TSTMP` = #{insTstmp,jdbcType=TIMESTAMP},",
          "`ORIGIN_OS_ID` = #{originOsId,jdbcType=BIGINT},",
          "`USER_TYPE` = #{userType,jdbcType=VARCHAR},",
          "`IS_ENABLE` = #{isEnable,jdbcType=CHAR},",
          "`IS_DELETE` = #{isDelete,jdbcType=CHAR},",
          "`CREATE_PERSON` = #{createPerson,jdbcType=BIGINT},",
          "`CREATE_PERSON_NAME` = #{createPersonName,jdbcType=VARCHAR},",
          "`UPDATE_PERSON` = #{updatePerson,jdbcType=BIGINT},",
          "`UPDATE_PERSON_NAME` = #{updatePersonName,jdbcType=VARCHAR},",
          "`UPDATE_TIME` = #{updateTime,jdbcType=TIMESTAMP}",
        "WHERE `USER_ID` = #{userId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserInfoGenerateBean record);
}