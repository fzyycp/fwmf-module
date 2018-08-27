package cn.faury.fwmf.module.service.school.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeRClassInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfSchool;
import cn.faury.fwmf.module.service.school.sqlProvider.SchoolRGradeRClassInfoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface SchoolRGradeRClassInfoMapper {
    @Delete({
            "DELETE FROM ",
            DBConstOfSchool.SYS_T_SCHOOL_R_GRADE_R_CLASS,
            "WHERE GRADE_ID = #{gradeId,jdbcType=BIGINT}"
    })
    int deleteByGradeId(Long gradeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @mbg.generated Tue Jul 31 10:54:33 CST 2018
     */
    @Delete({
            "delete from sys_t_school_r_grade_r_class",
            "where CLASS_ID = #{classId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long classId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @mbg.generated Tue Jul 31 10:54:33 CST 2018
     */
    @Insert({
            "insert into sys_t_school_r_grade_r_class (CLASS_ID, GRADE_ID, ",
            "SCHOOL_ID, CLASS_CODE, ",
            "CLASS_NAME, CLASS_ALIAS)",
            "values (#{classId,jdbcType=BIGINT}, #{gradeId,jdbcType=BIGINT}, ",
            "#{schoolId,jdbcType=BIGINT}, #{classCode,jdbcType=VARCHAR}, ",
            "#{className,jdbcType=VARCHAR}, #{classAlias,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "classId")
    int insert(SchoolRGradeRClassInfoBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @mbg.generated Tue Jul 31 10:54:33 CST 2018
     */
    @InsertProvider(type = SchoolRGradeRClassInfoSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "classId")
    int insertSelective(SchoolRGradeRClassInfoBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @mbg.generated Tue Jul 31 10:54:33 CST 2018
     */
    @Select({
            "select",
            "CLASS_ID, GRADE_ID, SCHOOL_ID, CLASS_CODE, CLASS_NAME, CLASS_ALIAS",
            "from sys_t_school_r_grade_r_class",
            "where CLASS_ID = #{classId,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column = "CLASS_ID", property = "classId", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "GRADE_ID", property = "gradeId", jdbcType = JdbcType.BIGINT),
            @Result(column = "SCHOOL_ID", property = "schoolId", jdbcType = JdbcType.BIGINT),
            @Result(column = "CLASS_CODE", property = "classCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CLASS_NAME", property = "className", jdbcType = JdbcType.VARCHAR),
            @Result(column = "CLASS_ALIAS", property = "classAlias", jdbcType = JdbcType.VARCHAR)
    })
    SchoolRGradeRClassInfoBean selectByPrimaryKey(Long classId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @mbg.generated Tue Jul 31 10:54:33 CST 2018
     */
    @UpdateProvider(type = SchoolRGradeRClassInfoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SchoolRGradeRClassInfoBean record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_t_school_r_grade_r_class
     *
     * @mbg.generated Tue Jul 31 10:54:33 CST 2018
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
    int updateByPrimaryKey(SchoolRGradeRClassInfoBean record);

    @SelectProvider(type = SchoolRGradeRClassInfoSqlProvider.class, method = "search")
    @ResultType(SchoolRGradeRClassInfoBean.class)
    List<SchoolRGradeRClassInfoBean> search(Map<String, Object> params);
}