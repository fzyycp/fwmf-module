package cn.faury.fwmf.module.service.school.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.area.bean.AreaBean;
import cn.faury.fwmf.module.api.school.bean.SchoolInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfSchool;
import cn.faury.fwmf.module.service.school.sqlProvider.SchoolInfoSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface SchoolInfoMapper {
    @Delete({
            "delete from",
            DBConstOfSchool.SYS_T_SCHOOL_INFO,
            "where SCHOOL_ID = #{schoolId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long schoolId);

    @Insert({
            "insert into ", DBConstOfSchool.SYS_T_SCHOOL_INFO, " (SCHOOL_ID, SCHOOL_NAME, ",
            "SCHOOL_SHORTNAME, AREA_CODE_PROVINCE, ",
            "AREA_DESC_PROVINCE, AREA_CODE_CITY, ",
            "AREA_DESC_CITY, AREA_CODE_COUNTY, ",
            "AREA_DESC_COUNTY, CONTACT_NAME, ",
            "TEL_NO, ADDRESS, ",
            "IS_DELETE, PKG, CREATE_PERSON, ",
            "CREATE_TIME, UPDATE_PERSON, ",
            "UPDATE_TIME, SCHOOL_LEVEL)",
            "values (#{schoolId,jdbcType=BIGINT}, #{schoolName,jdbcType=VARCHAR}, ",
            "#{schoolShortname,jdbcType=VARCHAR}, #{areaCodeProvince,jdbcType=VARCHAR}, ",
            "#{areaDescProvince,jdbcType=VARCHAR}, #{areaCodeCity,jdbcType=VARCHAR}, ",
            "#{areaDescCity,jdbcType=VARCHAR}, #{areaCodeCounty,jdbcType=VARCHAR}, ",
            "#{areaDescCounty,jdbcType=VARCHAR}, #{contactName,jdbcType=VARCHAR}, ",
            "#{telNo,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
            "#{isDelete,jdbcType=CHAR}, #{pkg,jdbcType=VARCHAR}, #{createPerson,jdbcType=VARCHAR}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{updatePerson,jdbcType=VARCHAR}, ",
            "#{updateTime,jdbcType=TIMESTAMP}, #{schoolLevel,jdbcType=CHAR})"
    })
    int insert(SchoolInfoBean record);

    @InsertProvider(type = SchoolInfoSqlProvider.class, method = "insertSelective")
    @Options(useGeneratedKeys = true, keyProperty = "schoolId")
    int insertSelective(SchoolInfoBean record);

    @Select({
            "select",
            "SCHOOL_ID, SCHOOL_NAME, SCHOOL_SHORTNAME, AREA_CODE_PROVINCE, AREA_DESC_PROVINCE, ",
            "AREA_CODE_CITY, AREA_DESC_CITY, AREA_CODE_COUNTY, AREA_DESC_COUNTY, CONTACT_NAME, ",
            "TEL_NO, ADDRESS, IS_DELETE, PKG, CREATE_PERSON, CREATE_TIME, UPDATE_PERSON, ",
            "UPDATE_TIME, SCHOOL_LEVEL",
            "from",
            DBConstOfSchool.SYS_T_SCHOOL_INFO,
            "where SCHOOL_ID = #{schoolId,jdbcType=BIGINT}"
    })
    @ResultType(SchoolInfoBean.class)
    SchoolInfoBean selectByPrimaryKey(Long schoolId);

    @UpdateProvider(type = SchoolInfoSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SchoolInfoBean record);

    @Update({
            "update ", DBConstOfSchool.SYS_T_SCHOOL_INFO,
            "set SCHOOL_NAME = #{schoolName,jdbcType=VARCHAR},",
            "SCHOOL_SHORTNAME = #{schoolShortname,jdbcType=VARCHAR},",
            "AREA_CODE_PROVINCE = #{areaCodeProvince,jdbcType=VARCHAR},",
            "AREA_DESC_PROVINCE = #{areaDescProvince,jdbcType=VARCHAR},",
            "AREA_CODE_CITY = #{areaCodeCity,jdbcType=VARCHAR},",
            "AREA_DESC_CITY = #{areaDescCity,jdbcType=VARCHAR},",
            "AREA_CODE_COUNTY = #{areaCodeCounty,jdbcType=VARCHAR},",
            "AREA_DESC_COUNTY = #{areaDescCounty,jdbcType=VARCHAR},",
            "CONTACT_NAME = #{contactName,jdbcType=VARCHAR},",
            "TEL_NO = #{telNo,jdbcType=VARCHAR},",
            "ADDRESS = #{address,jdbcType=VARCHAR},",
            "IS_DELETE = #{isDelete,jdbcType=CHAR},",
            "PKG = #{pkg,jdbcType=VARCHAR},",
            "CREATE_PERSON = #{createPerson,jdbcType=VARCHAR},",
            "CREATE_TIME = #{createTime,jdbcType=TIMESTAMP},",
            "UPDATE_PERSON = #{updatePerson,jdbcType=VARCHAR},",
            "UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP},",
            "SCHOOL_LEVEL = #{schoolLevel,jdbcType=CHAR}",
            "where SCHOOL_ID = #{schoolId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SchoolInfoBean record);

    @SelectProvider(type = SchoolInfoSqlProvider.class, method = "search")
    @ResultType(SchoolInfoBean.class)
    List<SchoolInfoBean> search(Map<String, Object> params);

    @Select({"SELECT DISTINCT AREA_CODE_PROVINCE ADMAREA_CODE,AREA_DESC_PROVINCE ADMAREA_NAME FROM"
            , DBConstOfSchool.SYS_T_SCHOOL_INFO
            , "WHERE IS_DELETE='N'"})
    @ResultType(AreaBean.class)
    List<AreaBean> getSchoolProvinceList();

    @Select({"SELECT DISTINCT AREA_CODE_CITY ADMAREA_CODE,AREA_DESC_CITY ADMAREA_NAME FROM"
            , DBConstOfSchool.SYS_T_SCHOOL_INFO
            , "WHERE IS_DELETE='N' AND AREA_CODE_PROVINCE=#{provinceCode}"})
    @ResultType(AreaBean.class)
    List<AreaBean> getSchoolCityList(Map<String, Object> params);

    @Select({"SELECT DISTINCT AREA_CODE_COUNTY ADMAREA_CODE,AREA_DESC_COUNTY ADMAREA_NAME FROM"
            , DBConstOfSchool.SYS_T_SCHOOL_INFO
            , "WHERE IS_DELETE='N' AND AREA_CODE_CITY=#{cityCode}"})
    @ResultType(AreaBean.class)
    List<AreaBean> getSchoolCountyList(Map<String, Object> params);

    @Select({"SELECT * FROM", DBConstOfSchool.SYS_T_SCHOOL_INFO
            , "WHERE IS_DELETE='N' AND AREA_CODE_COUNTY=#{countyCode} "
            , "  AND (SCHOOL_NAME=#{schoolName} OR SCHOOL_SHORTNAME=#{schoolName})"
            , "LIMIT 1"})
    @ResultType(SchoolInfoBean.class)
    SchoolInfoBean checkSchoolNameForCounty(Map<String, Object> params);
}