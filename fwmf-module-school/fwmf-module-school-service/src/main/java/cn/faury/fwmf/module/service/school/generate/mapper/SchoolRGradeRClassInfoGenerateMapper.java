/**
 * This file was generator by Fwmf Generated
 * ！！！Do not modify this file！！ 
 *
 * @fwmf.generated 2018-11-10 14:29:03
 */
package cn.faury.fwmf.module.service.school.generate.mapper;

import cn.faury.fwmf.module.api.school.bean.SchoolRGradeRClassInfoBean;
import cn.faury.fwmf.module.api.school.generate.bean.SchoolRGradeRClassInfoGenerateBean;
import cn.faury.fwmf.module.service.school.generate.sqlProvider.SchoolRGradeRClassInfoGenerateSqlProvider;
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

public interface SchoolRGradeRClassInfoGenerateMapper {
    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @fwmf.generated 2018-11-10 14:29:03
     */
    @Delete({
        "delete from sys_t_school_r_grade_r_class",
        "where CLASS_ID = #{classId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long classId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @fwmf.generated 2018-11-10 14:29:03
     */
    @Insert({
        "insert into sys_t_school_r_grade_r_class (CLASS_ID, GRADE_ID, ",
        "SCHOOL_ID, CLASS_CODE, ",
        "CLASS_NAME, CLASS_ALIAS)",
        "values (#{classId,jdbcType=BIGINT}, #{gradeId,jdbcType=BIGINT}, ",
        "#{schoolId,jdbcType=BIGINT}, #{classCode,jdbcType=VARCHAR}, ",
        "#{className,jdbcType=VARCHAR}, #{classAlias,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="classId")
    int insert(SchoolRGradeRClassInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @fwmf.generated 2018-11-10 14:29:03
     */
    @InsertProvider(type=SchoolRGradeRClassInfoGenerateSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="classId")
    int insertSelective(SchoolRGradeRClassInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @fwmf.generated 2018-11-10 14:29:03
     */
    @SelectProvider(type=SchoolRGradeRClassInfoGenerateSqlProvider.class, method="search")
    @ResultType(SchoolRGradeRClassInfoBean.class)
    List<SchoolRGradeRClassInfoBean> search(Map<String, Object> params);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @fwmf.generated 2018-11-10 14:29:03
     */
    @Select({
        "select",
        "CLASS_ID, GRADE_ID, SCHOOL_ID, CLASS_CODE, CLASS_NAME, CLASS_ALIAS",
        "from sys_t_school_r_grade_r_class",
        "where CLASS_ID = #{classId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="CLASS_ID", property="classId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="GRADE_ID", property="gradeId", jdbcType=JdbcType.BIGINT),
        @Result(column="SCHOOL_ID", property="schoolId", jdbcType=JdbcType.BIGINT),
        @Result(column="CLASS_CODE", property="classCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLASS_NAME", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="CLASS_ALIAS", property="classAlias", jdbcType=JdbcType.VARCHAR)
    })
    SchoolRGradeRClassInfoBean selectByPrimaryKey(Long classId);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @fwmf.generated 2018-11-10 14:29:03
     */
    @UpdateProvider(type=SchoolRGradeRClassInfoGenerateSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SchoolRGradeRClassInfoGenerateBean record);

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @fwmf.generated 2018-11-10 14:29:03
     */
    @Update({
        "update sys_t_school_r_grade_r_class",
        "set GRADE_ID = #{gradeId,jdbcType=BIGINT},",
          "SCHOOL_ID = #{schoolId,jdbcType=BIGINT},",
          "CLASS_CODE = #{classCode,jdbcType=VARCHAR},",
          "CLASS_NAME = #{className,jdbcType=VARCHAR},",
          "CLASS_ALIAS = #{classAlias,jdbcType=VARCHAR}",
        "where CLASS_ID = #{classId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SchoolRGradeRClassInfoGenerateBean record);
}