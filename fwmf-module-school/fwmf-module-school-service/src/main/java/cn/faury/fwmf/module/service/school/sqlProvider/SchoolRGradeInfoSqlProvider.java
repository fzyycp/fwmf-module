package cn.faury.fwmf.module.service.school.sqlProvider;

import cn.faury.fwmf.module.api.school.bean.SchoolRGradeInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfSchool;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SchoolRGradeInfoSqlProvider {

    public String insertSelective(SchoolRGradeInfoBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_t_school_r_grade");

        if (record.getGradeId() != null) {
            sql.VALUES("GRADE_ID", "#{gradeId,jdbcType=BIGINT}");
        }

        if (record.getSchoolId() != null) {
            sql.VALUES("SCHOOL_ID", "#{schoolId,jdbcType=BIGINT}");
        }

        if (record.getGradeCode() != null) {
            sql.VALUES("GRADE_CODE", "#{gradeCode,jdbcType=VARCHAR}");
        }

        if (record.getGradeName() != null) {
            sql.VALUES("GRADE_NAME", "#{gradeName,jdbcType=VARCHAR}");
        }

        if (record.getGradeAlias() != null) {
            sql.VALUES("GRADE_ALIAS", "#{gradeAlias,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SchoolRGradeInfoBean record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_t_school_r_grade");

        if (record.getSchoolId() != null) {
            sql.SET("SCHOOL_ID = #{schoolId,jdbcType=BIGINT}");
        }

        if (record.getGradeCode() != null) {
            sql.SET("GRADE_CODE = #{gradeCode,jdbcType=VARCHAR}");
        }

        if (record.getGradeName() != null) {
            sql.SET("GRADE_NAME = #{gradeName,jdbcType=VARCHAR}");
        }

        if (record.getGradeAlias() != null) {
            sql.SET("GRADE_ALIAS = #{gradeAlias,jdbcType=VARCHAR}");
        }

        sql.WHERE("GRADE_ID = #{gradeId,jdbcType=BIGINT}");

        return sql.toString();
    }

    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("GRADE_ID", "SCHOOL_ID", "GRADE_CODE", "GRADE_NAME", "GRADE_ALIAS");
        sql.FROM(DBConstOfSchool.SYS_T_SCHOOL_R_GRADE);
        if (params.get("schoolId") != null) {
            sql.WHERE("SCHOOL_ID = #{schoolId}");
        }
        if (params.get("gradeId") != null) {
            sql.WHERE("GRADE_ID = #{gradeId}");
        }
        if (params.get("gradeCode") != null) {
            sql.WHERE("GRADE_CODE = #{gradeCode}");
        }
        return sql.toString();
    }

}