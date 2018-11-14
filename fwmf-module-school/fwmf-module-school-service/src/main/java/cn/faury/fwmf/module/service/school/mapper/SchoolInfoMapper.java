package cn.faury.fwmf.module.service.school.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.area.bean.AreaBean;
import cn.faury.fwmf.module.api.school.bean.SchoolInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfSchool;
import cn.faury.fwmf.module.service.school.generate.mapper.SchoolInfoGenerateMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：学校信息表
 * <p>
 * <pre>
 *     SchoolInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自SchoolInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface SchoolInfoMapper extends SchoolInfoGenerateMapper {

    /**
     * 获取所有学校所在省份列表
     */
    @Select({"SELECT DISTINCT AREA_CODE_PROVINCE ADMAREA_CODE,AREA_DESC_PROVINCE ADMAREA_NAME FROM"
            , DBConstOfSchool.SYS_T_SCHOOL_INFO
            , "WHERE IS_DELETE='N'"
            , "ORDER BY AREA_CODE_PROVINCE"})
    @ResultType(AreaBean.class)
    List<AreaBean> getSchoolProvinceList();

    /**
     * 获取省份下所有学校所在市列表
     */
    @Select({"SELECT DISTINCT AREA_CODE_CITY ADMAREA_CODE,AREA_DESC_CITY ADMAREA_NAME FROM"
            , DBConstOfSchool.SYS_T_SCHOOL_INFO
            , "WHERE IS_DELETE='N' AND AREA_CODE_PROVINCE=#{provinceCode}"
            , " ORDER BY AREA_CODE_CITY"})
    @ResultType(AreaBean.class)
    List<AreaBean> getSchoolCityList(Map<String, Object> params);

    /**
     * 获取市下所有学校所在区县列表
     */
    @Select({"SELECT DISTINCT AREA_CODE_COUNTY ADMAREA_CODE,AREA_DESC_COUNTY ADMAREA_NAME FROM"
            , DBConstOfSchool.SYS_T_SCHOOL_INFO
            , "WHERE IS_DELETE='N' AND AREA_CODE_CITY=#{cityCode}"
            , " ORDER BY AREA_CODE_COUNTY"})
    @ResultType(AreaBean.class)
    List<AreaBean> getSchoolCountyList(Map<String, Object> params);

    /**
     * 检查区中是否学校名称重复
     */
    @Select({"SELECT * FROM", DBConstOfSchool.SYS_T_SCHOOL_INFO
            , "WHERE IS_DELETE='N' AND AREA_CODE_COUNTY=#{countyCode} "
            , "  AND (SCHOOL_NAME=#{schoolName} OR SCHOOL_SHORTNAME=#{schoolName})"
            , "LIMIT 1"})
    @ResultType(SchoolInfoBean.class)
    SchoolInfoBean checkSchoolNameForCounty(Map<String, Object> params);
}