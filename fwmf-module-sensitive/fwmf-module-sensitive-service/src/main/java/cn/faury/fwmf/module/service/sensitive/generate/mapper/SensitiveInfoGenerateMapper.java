/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-09-26 15:03:32
 */
package cn.faury.fwmf.module.service.sensitive.generate.mapper;

import cn.faury.fwmf.module.api.sensitive.bean.SensitiveInfoBean;
import cn.faury.fwmf.module.api.sensitive.generate.bean.SensitiveInfoGenerateBean;
import cn.faury.fwmf.module.service.sensitive.generate.sqlProvider.SensitiveInfoGenerateSqlProvider;
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

public interface SensitiveInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_sensitive_info
     *
     * @fwmf.generated 2018-09-26 15:03:32
     */
    @Delete({
        "delete from sys_t_sensitive_info",
        "where SENSITIVE_ID = #{sensitiveId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long sensitiveId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_sensitive_info
     *
     * @fwmf.generated 2018-09-26 15:03:32
     */
    @Insert({
        "insert into sys_t_sensitive_info (SENSITIVE_ID, SENSITIVE_VALUE, ",
        "REPLACE_VALUE, CREATE_PERSON, ",
        "CREATE_PERSON_NAME, CREATE_TIME, ",
        "UPDATE_PERSON, UPDATE_PERSON_NAME, ",
        "UPDATE_TIME)",
        "values (#{sensitiveId,jdbcType=BIGINT}, #{sensitiveValue,jdbcType=VARCHAR}, ",
        "#{replaceValue,jdbcType=VARCHAR}, #{createPerson,jdbcType=BIGINT}, ",
        "#{createPersonName,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updatePerson,jdbcType=BIGINT}, #{updatePersonName,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="sensitiveId")
    int insert(SensitiveInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_sensitive_info
     *
     * @fwmf.generated 2018-09-26 15:03:32
     */
    @InsertProvider(type=SensitiveInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="sensitiveId")
    int insertSelective(SensitiveInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_sensitive_info
     *
     * @fwmf.generated 2018-09-26 15:03:32
     */
    @SelectProvider(type=SensitiveInfoGenerateSqlProvider.class, method="search")
    @ResultType(SensitiveInfoBean.class)
    List<SensitiveInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_sensitive_info
     *
     * @fwmf.generated 2018-09-26 15:03:32
     */
    @Select({
        "select",
        "SENSITIVE_ID, SENSITIVE_VALUE, REPLACE_VALUE, CREATE_PERSON, CREATE_PERSON_NAME, ",
        "CREATE_TIME, UPDATE_PERSON, UPDATE_PERSON_NAME, UPDATE_TIME",
        "from sys_t_sensitive_info",
        "where SENSITIVE_ID = #{sensitiveId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="SENSITIVE_ID", property="sensitiveId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SENSITIVE_VALUE", property="sensitiveValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="REPLACE_VALUE", property="replaceValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_PERSON", property="createPerson", jdbcType=JdbcType.BIGINT),
        @Result(column="CREATE_PERSON_NAME", property="createPersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="CREATE_TIME", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="UPDATE_PERSON", property="updatePerson", jdbcType=JdbcType.BIGINT),
        @Result(column="UPDATE_PERSON_NAME", property="updatePersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="UPDATE_TIME", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SensitiveInfoBean selectByPrimaryKey(Long sensitiveId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_sensitive_info
     *
     * @fwmf.generated 2018-09-26 15:03:32
     */
    @UpdateProvider(type=SensitiveInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SensitiveInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_sensitive_info
     *
     * @fwmf.generated 2018-09-26 15:03:32
     */
    @Update({
        "update sys_t_sensitive_info",
        "set SENSITIVE_VALUE = #{sensitiveValue,jdbcType=VARCHAR},",
          "REPLACE_VALUE = #{replaceValue,jdbcType=VARCHAR},",
          "CREATE_PERSON = #{createPerson,jdbcType=BIGINT},",
          "CREATE_PERSON_NAME = #{createPersonName,jdbcType=VARCHAR},",
          "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
          "UPDATE_PERSON = #{updatePerson,jdbcType=BIGINT},",
          "UPDATE_PERSON_NAME = #{updatePersonName,jdbcType=VARCHAR},",
          "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}",
        "where SENSITIVE_ID = #{sensitiveId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SensitiveInfoGenerateBean record);
}