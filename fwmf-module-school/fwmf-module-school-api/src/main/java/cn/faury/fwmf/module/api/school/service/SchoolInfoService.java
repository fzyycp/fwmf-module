package cn.faury.fwmf.module.api.school.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.area.bean.AreaBean;
import cn.faury.fwmf.module.api.school.bean.SchoolInfoBean;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeInfoBean;
import cn.faury.fwmf.module.api.school.config.SchoolLevel;

import java.util.List;

/**
 * 服务接口：学校信息表
 * <p>
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface SchoolInfoService extends CrudBaseService<SchoolInfoBean, Long> {

    /**
     * 根据区域编码获取区域下学校列表
     *
     * @param areaCode 区域编码
     * @return 学校列表
     */
    public List<SchoolInfoBean> getSchoolListByAreaCode(final String areaCode, final SchoolLevel schoolLevel);

    /**
     * 获取有学校信息的省份列表
     */
    public List<AreaBean> getSchoolProvinceList();

    /**
     * 获取有学校信息的市列表
     *
     * @param provinceCode 省份编码
     */
    public List<AreaBean> getSchoolCityList(String provinceCode);

    /**
     * 获取有学校信息的区县列表
     *
     * @param cityCode 市编码
     */
    public List<AreaBean> getSchoolCountyList(String cityCode);

    /**
     * 检查区县下学校名称是否存在
     *
     * @param schoolName 学校名称
     * @param countyCode 区县编码
     * @return 是否存在
     */
    public boolean checkSchoolNameForCounty(String schoolName, String countyCode);

    /**
     * 创建学校信息，带年级班级信息
     *
     * @param schoolInfoBean           学校信息
     * @param schoolRGradeInfoBeanList 年级信息
     * @param classCount               班级个数
     */
    default public void createSchoolWithGradeAndClass(SchoolInfoBean schoolInfoBean, List<SchoolRGradeInfoBean> schoolRGradeInfoBeanList, int classCount) {
        createSchoolWithGradeAndClass(schoolInfoBean, schoolRGradeInfoBeanList, classCount, false);
    }

    /**
     * 创建学校信息，带年级班级信息
     *
     * @param schoolInfoBean           学校信息
     * @param schoolRGradeInfoBeanList 年级信息
     * @param classCount               班级个数
     * @param isClassNameShort         是否班级名称简写
     */
    public void createSchoolWithGradeAndClass(SchoolInfoBean schoolInfoBean, List<SchoolRGradeInfoBean> schoolRGradeInfoBeanList, int classCount, boolean isClassNameShort);

    /**
     * 复制创建学校信息
     *
     * @param schoolInfoBean 新的学校信息，schoolId作为被拷贝对象
     * @return 新的创建的学校ID
     */
    public Long copySchoolInfo(SchoolInfoBean schoolInfoBean);
}