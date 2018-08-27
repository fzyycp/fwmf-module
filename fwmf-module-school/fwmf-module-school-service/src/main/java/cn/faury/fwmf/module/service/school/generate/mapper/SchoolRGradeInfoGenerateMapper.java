/**
 * This file was generator by Fwmf Generated
 * @fwmf.generated 2018-08-18 22:31:52
 */
package cn.faury.fwmf.module.service.school.generate.mapper;

import cn.faury.fwmf.module.api.school.generate.bean.SchoolRGradeInfoGenerateBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SchoolRGradeInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database tablesys_t_school_r_grade
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    @Delete({
        "delete from sys_t_school_r_grade",
        "where GRADE_ID = #{gradeId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long gradeId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database tablesys_t_school_r_grade
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    @Insert({
        "insert into sys_t_school_r_grade (SCHOOL_ID, GRADE_CODE, ",
        "GRADE_NAME, GRADE_ALIAS)",
        "values (#{schoolId,jdbcType=BIGINT}, #{gradeCode,jdbcType=VARCHAR}, ",
        "#{gradeName,jdbcType=VARCHAR}, #{gradeAlias,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="gradeId")
    int insert(SchoolRGradeInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database tablesys_t_school_r_grade
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    @InsertProvider(type=SchoolRGradeGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="gradeId")
    int insertSelective(SchoolRGradeInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database tablesys_t_school_r_grade
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    @Select({
        "select",
        "GRADE_ID, SCHOOL_ID, GRADE_CODE, GRADE_NAME, GRADE_ALIAS",
        "from sys_t_school_r_grade",
        "where GRADE_ID = #{gradeId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="GRADE_ID", property="gradeId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="SCHOOL_ID", property="schoolId", jdbcType=JdbcType.BIGINT),
        @Result(column="GRADE_CODE", property="gradeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="GRADE_NAME", property="gradeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="GRADE_ALIAS", property="gradeAlias", jdbcType=JdbcType.VARCHAR)
    })
    SchoolRGradeInfoGenerateBean selectByPrimaryKey(Long gradeId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database tablesys_t_school_r_grade
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    @UpdateProvider(type=SchoolRGradeGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SchoolRGradeInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database tablesys_t_school_r_grade
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    @Update({
        "update sys_t_school_r_grade",
        "set SCHOOL_ID = #{schoolId,jdbcType=BIGINT},",
          "GRADE_CODE = #{gradeCode,jdbcType=VARCHAR},",
          "GRADE_NAME = #{gradeName,jdbcType=VARCHAR},",
          "GRADE_ALIAS = #{gradeAlias,jdbcType=VARCHAR}",
        "where GRADE_ID = #{gradeId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SchoolRGradeInfoGenerateBean record);
}