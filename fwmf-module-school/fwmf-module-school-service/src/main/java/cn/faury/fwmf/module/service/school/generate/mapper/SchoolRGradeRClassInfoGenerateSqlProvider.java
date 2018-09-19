/**
 * This file was generator by Fwmf Generated
 * @fwmf.generated 2018-08-18 22:31:52
 */
package cn.faury.fwmf.module.service.school.generate.mapper;

import cn.faury.fwmf.module.api.school.generate.bean.SchoolRGradeRClassInfoGenerateBean;
import org.apache.ibatis.jdbc.SQL;

public class SchoolRGradeRClassInfoGenerateSqlProvider {

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database tablesys_t_school_r_grade_r_class
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String insertSelective(SchoolRGradeRClassInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_t_school_r_grade_r_class");
        
        if (record.getGradeId() != null) {
            sql.VALUES("GRADE_ID", "#{gradeId,jdbcType=BIGINT}");
        }
        
        if (record.getSchoolId() != null) {
            sql.VALUES("SCHOOL_ID", "#{schoolId,jdbcType=BIGINT}");
        }
        
        if (record.getClassCode() != null) {
            sql.VALUES("CLASS_CODE", "#{classCode,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            sql.VALUES("CLASS_NAME", "#{className,jdbcType=VARCHAR}");
        }
        
        if (record.getClassAlias() != null) {
            sql.VALUES("CLASS_ALIAS", "#{classAlias,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by Fwmf Generated.
     * This method corresponds to the database tablesys_t_school_r_grade_r_class
     *
     * @fwmf.generated 2018-08-18 22:31:52
     */
    public String updateByPrimaryKeySelective(SchoolRGradeRClassInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_t_school_r_grade_r_class");
        
        if (record.getGradeId() != null) {
            sql.SET("GRADE_ID = #{gradeId,jdbcType=BIGINT}");
        }
        
        if (record.getSchoolId() != null) {
            sql.SET("SCHOOL_ID = #{schoolId,jdbcType=BIGINT}");
        }
        
        if (record.getClassCode() != null) {
            sql.SET("CLASS_CODE = #{classCode,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            sql.SET("CLASS_NAME = #{className,jdbcType=VARCHAR}");
        }
        
        if (record.getClassAlias() != null) {
            sql.SET("CLASS_ALIAS = #{classAlias,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("CLASS_ID = #{classId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}