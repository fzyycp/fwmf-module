package cn.faury.fwmf.module.service.school.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.school.bean.SchoolInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfSchool;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SchoolInfoSqlProvider {

    public String insertSelective(SchoolInfoBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO(DBConstOfSchool.SYS_T_SCHOOL_INFO);

        if (record.getSchoolId() != null) {
            sql.VALUES("SCHOOL_ID", "#{schoolId,jdbcType=BIGINT}");
        }

        if (record.getSchoolName() != null) {
            sql.VALUES("SCHOOL_NAME", "#{schoolName,jdbcType=VARCHAR}");
        }

        if (record.getSchoolShortname() != null) {
            sql.VALUES("SCHOOL_SHORTNAME", "#{schoolShortname,jdbcType=VARCHAR}");
        }

        if (record.getAreaCodeProvince() != null) {
            sql.VALUES("AREA_CODE_PROVINCE", "#{areaCodeProvince,jdbcType=VARCHAR}");
        }

        if (record.getAreaDescProvince() != null) {
            sql.VALUES("AREA_DESC_PROVINCE", "#{areaDescProvince,jdbcType=VARCHAR}");
        }

        if (record.getAreaCodeCity() != null) {
            sql.VALUES("AREA_CODE_CITY", "#{areaCodeCity,jdbcType=VARCHAR}");
        }

        if (record.getAreaDescCity() != null) {
            sql.VALUES("AREA_DESC_CITY", "#{areaDescCity,jdbcType=VARCHAR}");
        }

        if (record.getAreaCodeCounty() != null) {
            sql.VALUES("AREA_CODE_COUNTY", "#{areaCodeCounty,jdbcType=VARCHAR}");
        }

        if (record.getAreaDescCounty() != null) {
            sql.VALUES("AREA_DESC_COUNTY", "#{areaDescCounty,jdbcType=VARCHAR}");
        }

        if (record.getContactName() != null) {
            sql.VALUES("CONTACT_NAME", "#{contactName,jdbcType=VARCHAR}");
        }

        if (record.getTelNo() != null) {
            sql.VALUES("TEL_NO", "#{telNo,jdbcType=VARCHAR}");
        }

        if (record.getAddress() != null) {
            sql.VALUES("ADDRESS", "#{address,jdbcType=VARCHAR}");
        }

        if (record.getIsDelete() != null) {
            sql.VALUES("IS_DELETE", "#{isDelete,jdbcType=CHAR}");
        }

        if (record.getPkg() != null) {
            sql.VALUES("PKG", "#{pkg,jdbcType=VARCHAR}");
        }

        if (record.getCreatePerson() != null) {
            sql.VALUES("CREATE_PERSON", "#{createPerson,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdatePerson() != null) {
            sql.VALUES("UPDATE_PERSON", "#{updatePerson,jdbcType=VARCHAR}");
        }

        if (record.getUpdateTime() != null) {
            sql.VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getSchoolLevel() != null) {
            sql.VALUES("SCHOOL_LEVEL", "#{schoolLevel,jdbcType=CHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SchoolInfoBean record) {
        SQL sql = new SQL();
        sql.UPDATE(DBConstOfSchool.SYS_T_SCHOOL_INFO);

        if (record.getSchoolName() != null) {
            sql.SET("SCHOOL_NAME = #{schoolName,jdbcType=VARCHAR}");
        }

        if (record.getSchoolShortname() != null) {
            sql.SET("SCHOOL_SHORTNAME = #{schoolShortname,jdbcType=VARCHAR}");
        }

        if (record.getAreaCodeProvince() != null) {
            sql.SET("AREA_CODE_PROVINCE = #{areaCodeProvince,jdbcType=VARCHAR}");
        }

        if (record.getAreaDescProvince() != null) {
            sql.SET("AREA_DESC_PROVINCE = #{areaDescProvince,jdbcType=VARCHAR}");
        }

        if (record.getAreaCodeCity() != null) {
            sql.SET("AREA_CODE_CITY = #{areaCodeCity,jdbcType=VARCHAR}");
        }

        if (record.getAreaDescCity() != null) {
            sql.SET("AREA_DESC_CITY = #{areaDescCity,jdbcType=VARCHAR}");
        }

        if (record.getAreaCodeCounty() != null) {
            sql.SET("AREA_CODE_COUNTY = #{areaCodeCounty,jdbcType=VARCHAR}");
        }

        if (record.getAreaDescCounty() != null) {
            sql.SET("AREA_DESC_COUNTY = #{areaDescCounty,jdbcType=VARCHAR}");
        }

        if (record.getContactName() != null) {
            sql.SET("CONTACT_NAME = #{contactName,jdbcType=VARCHAR}");
        }

        if (record.getTelNo() != null) {
            sql.SET("TEL_NO = #{telNo,jdbcType=VARCHAR}");
        }

        if (record.getAddress() != null) {
            sql.SET("ADDRESS = #{address,jdbcType=VARCHAR}");
        }

        if (record.getIsDelete() != null) {
            sql.SET("IS_DELETE = #{isDelete,jdbcType=CHAR}");
        }

        if (record.getPkg() != null) {
            sql.SET("PKG = #{pkg,jdbcType=VARCHAR}");
        }

        if (record.getCreatePerson() != null) {
            sql.SET("CREATE_PERSON = #{createPerson,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdatePerson() != null) {
            sql.SET("UPDATE_PERSON = #{updatePerson,jdbcType=VARCHAR}");
        }

        if (record.getUpdateTime() != null) {
            sql.SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getSchoolLevel() != null) {
            sql.SET("SCHOOL_LEVEL = #{schoolLevel,jdbcType=CHAR}");
        }

        sql.WHERE("SCHOOL_ID = #{schoolId,jdbcType=BIGINT}");

        return sql.toString();
    }

    public String search(Map<String, Object> params) {
        SQL sql = new SQL();
        sql.SELECT("SCHOOL_ID", "SCHOOL_NAME", "SCHOOL_SHORTNAME",
                "AREA_CODE_PROVINCE", "AREA_DESC_PROVINCE", "AREA_CODE_CITY",
                "AREA_DESC_CITY", "AREA_CODE_COUNTY", "AREA_DESC_COUNTY", "CONTACT_NAME",
                "TEL_NO", "ADDRESS", "IS_DELETE", "PKG", "CREATE_PERSON",
                "CREATE_TIME", "UPDATE_PERSON", "UPDATE_TIME", "SCHOOL_LEVEL");
        sql.FROM(DBConstOfSchool.SYS_T_SCHOOL_INFO);
        sql.WHERE("IS_DELETE='N'");
        if (params.get("areaCode") != null) {
            sql.WHERE("(AREA_CODE_COUNTY LIKE #{areaCode} " +
                    " OR AREA_CODE_CITY LIKE #{areaCode} " +
                    " OR AREA_CODE_PROVINCE LIKE #{areaCode})");
        }
        if (params.get("schoolLevel") != null) {
            sql.WHERE("SCHOOL_LEVEL=#{schoolLevel}");
        }
        if (StringUtil.hasValue(params, "schoolName")) {
            sql.WHERE("SCHOOL_NAME LIKE CONCAT('%',#{schoolName},'%')");
        }
        if (StringUtil.hasValue(params, "contactName")) {
            sql.WHERE("CONTACT_NAME LIKE CONCAT('%',#{contactName},'%')");
        }
        if (StringUtil.hasValue(params, "telNo")) {
            sql.WHERE("TEL_NO LIKE CONCAT('%',#{telNo},'%')");
        }
        return sql.toString();
    }
}