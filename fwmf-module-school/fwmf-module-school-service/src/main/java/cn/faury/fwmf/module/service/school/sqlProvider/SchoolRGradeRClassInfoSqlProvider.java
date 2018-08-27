package cn.faury.fwmf.module.service.school.sqlProvider;

import cn.faury.fwmf.module.api.school.bean.SchoolRGradeRClassInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfSchool;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SchoolRGradeRClassInfoSqlProvider {

    public String insertSelective(SchoolRGradeRClassInfoBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_t_school_r_grade_r_class");

        if (record.getClassId() != null) {
            sql.VALUES("CLASS_ID", "#{classId,jdbcType=BIGINT}");
        }

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

    public String updateByPrimaryKeySelective(SchoolRGradeRClassInfoBean record) {
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

    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("CLASS_ID", "GRADE_ID", "SCHOOL_ID", "CLASS_CODE", "CLASS_NAME", "CLASS_ALIAS");
        sql.FROM(DBConstOfSchool.SYS_T_SCHOOL_R_GRADE_R_CLASS);
        if (params.get("schoolId") != null) {
            sql.WHERE("SCHOOL_ID = #{schoolId}");
        }
        if (params.get("gradeId") != null) {
            sql.WHERE("GRADE_ID = #{gradeId}");
        }
        if (params.get("classId") != null) {
            sql.WHERE("CLASS_ID = #{classId}");
        }
        return sql.toString();
    }
}