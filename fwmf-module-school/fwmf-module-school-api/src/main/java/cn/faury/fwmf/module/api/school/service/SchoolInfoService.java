package cn.faury.fwmf.module.api.school.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.area.bean.AreaBean;
import cn.faury.fwmf.module.api.school.bean.SchoolInfoBean;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeInfoBean;
import cn.faury.fwmf.module.api.school.config.SchoolLevel;

import java.util.List;

/**
 * 通用增删改查基础服务接口，可以根据业务需要进一步扩展
 * 只需生成一次，后面不需要再生成
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
    public void createSchoolWithGradeAndClass(SchoolInfoBean schoolInfoBean, List<SchoolRGradeInfoBean> schoolRGradeInfoBeanList, int classCount);

    /**
     * 复制创建学校信息
     *
     * @param schoolInfoBean 新的学校信息，schoolId作为被拷贝对象
     * @return 新的创建的学校ID
     */
    public Long copySchoolInfo(SchoolInfoBean schoolInfoBean);
}