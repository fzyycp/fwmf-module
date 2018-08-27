package cn.faury.fwmf.module.service.school.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.DateUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.area.bean.AreaBean;
import cn.faury.fwmf.module.api.area.utils.AreaUtil;
import cn.faury.fwmf.module.api.school.bean.SchoolInfoBean;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeInfoBean;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeRClassInfoBean;
import cn.faury.fwmf.module.api.school.config.SchoolLevel;
import cn.faury.fwmf.module.api.school.service.SchoolInfoService;
import cn.faury.fwmf.module.api.school.service.SchoolRGradeInfoService;
import cn.faury.fwmf.module.api.school.service.SchoolRGradeRClassInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.school.mapper.SchoolInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public class SchoolInfoServiceImpl extends CrudBaseServiceImpl<SchoolInfoBean, Long> implements SchoolInfoService {

    @Autowired(required = false)
    private SchoolRGradeInfoService schoolRGradeInfoService;

    @Autowired(required = false)
    private SchoolRGradeRClassInfoService schoolRGradeRClassInfoService;

    public SchoolInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, SchoolInfoMapper.class);
    }

    /**
     * 根据区域编码获取区域下学校列表
     *
     * @param areaCode    区域编码
     * @param schoolLevel 学校类型
     * @return 学校列表
     */
    @Override
    public List<SchoolInfoBean> getSchoolListByAreaCode(final String areaCode, final SchoolLevel schoolLevel) {
        Map<String, Object> params = new HashMap<>();
        params.put("areaCode", areaCode);
        if (schoolLevel != null) {
            params.put("schoolLevel", schoolLevel.getCode());
        }
        params.put(PageParam.KEY.KEY_PAGE_NO, 1);
        params.put(PageParam.KEY.KEY_PAGE_SIZE, Integer.MAX_VALUE);
        return this.search(params).getList();
    }

    /**
     * 获取有学校信息的省份列表
     */
    @Override
    public List<AreaBean> getSchoolProvinceList() {
        String state = this.mapper.getName() + ".getSchoolProvinceList";
        return this.commonDao.selectList(state);
    }

    /**
     * 获取有学校信息的市列表
     *
     * @param provinceCode 省份编码
     */
    @Override
    public List<AreaBean> getSchoolCityList(String provinceCode) {
        if (AreaUtil.isProvinceOnly(provinceCode)) {
            return new ArrayList<>();
        }
        String state = this.mapper.getName() + ".getSchoolCityList";
        return this.commonDao.selectList(state, Collections.singletonMap("provinceCode", provinceCode));
    }

    /**
     * 获取有学校信息的区县列表
     *
     * @param cityCode 市编码
     */
    @Override
    public List<AreaBean> getSchoolCountyList(String cityCode) {
        if (AreaUtil.isCityOnly(cityCode)) {
            return new ArrayList<>();
        }
        String state = this.mapper.getName() + ".getSchoolCountyList";
        return this.commonDao.selectList(state, Collections.singletonMap("cityCode", cityCode));
    }

    @Override
    public PageInfo<SchoolInfoBean> search(final Map<String, Object> param) {
        Map<String, Object> _params = new HashMap<>();
        _params.putAll(param);
        String _areaCode = (String) _params.get("areaCode");
        if (StringUtil.isNotEmpty(_areaCode)) {
            if ("000000".equals(_areaCode)) {
                _areaCode = "______";
            } else if (_areaCode.endsWith("0000")) {
                _areaCode = _areaCode.substring(0, 2) + "____";
            } else if (_areaCode.endsWith("00")) {
                _areaCode = _areaCode.substring(0, 4) + "__";
            }
            _params.put("areaCode", _areaCode);
        }
        return super.search(_params);
    }

    /**
     * 检查区县下学校名称是否存在
     *
     * @param schoolName 学校名称
     * @param countyCode 区县编码
     * @return 是否存在
     */
    @Override
    public boolean checkSchoolNameForCounty(String schoolName, String countyCode) {
        String state = this.mapper.getName() + ".checkSchoolNameForCounty";
        Map<String, Object> params = new HashMap<>();
        params.put("schoolName", schoolName);
        params.put("countyCode", countyCode);
        return this.commonDao.selectOne(state, params) != null;
    }

    /**
     * 创建学校信息，带年级班级信息
     *
     * @param schoolInfoBean           学校信息
     * @param schoolRGradeInfoBeanList 年级信息
     * @param classCount               班级个数
     */
    @Transactional
    @Override
    public void createSchoolWithGradeAndClass(SchoolInfoBean schoolInfoBean, List<SchoolRGradeInfoBean> schoolRGradeInfoBeanList, int classCount) {
        // 插入学校信息
        final Long schoolId = this.insert(schoolInfoBean);
        schoolRGradeInfoBeanList.forEach(gradeInfoBean -> {
            // 插入年级信息
            gradeInfoBean.setSchoolId(schoolId);
            if (StringUtil.isEmpty(gradeInfoBean.getGradeAlias())) {
                gradeInfoBean.setGradeAlias(gradeInfoBean.getGradeName());
            }
            Long gradeId = schoolRGradeInfoService.insert(gradeInfoBean);
            // 构造班级信息
            for (int i = 1; i <= classCount; i++) {
                SchoolRGradeRClassInfoBean classInfoBean = new SchoolRGradeRClassInfoBean();
                classInfoBean.setSchoolId(schoolId);
                classInfoBean.setGradeId(gradeId);
                classInfoBean.setClassCode(gradeInfoBean.getGradeCode() + String.format("%02d", i));
                classInfoBean.setClassName(gradeInfoBean.getGradeName() + i + "班");
                classInfoBean.setClassAlias(classInfoBean.getClassName());
                schoolRGradeRClassInfoService.insert(classInfoBean);
            }
        });
    }

    /**
     * 复制创建学校信息
     *
     * @param schoolInfoBean 新的学校信息，schoolId作为被拷贝对象
     */
    @Override
    public Long copySchoolInfo(SchoolInfoBean schoolInfoBean) {
        Long copyId = schoolInfoBean.getSchoolId();
        SchoolInfoBean copyBean = this.getBeanById(copyId);
        // 复制学校基本信息并插入
        SchoolInfoBean _param = new SchoolInfoBean();
        _param.setSchoolName(schoolInfoBean.getSchoolName());
        _param.setSchoolShortname(schoolInfoBean.getSchoolShortname());
        _param.setAreaCodeProvince(schoolInfoBean.getAreaCodeProvince());
        _param.setAreaCodeCity(schoolInfoBean.getAreaCodeCity());
        _param.setAreaCodeCounty(schoolInfoBean.getAreaCodeCounty());
        _param.setAreaDescProvince(schoolInfoBean.getAreaDescProvince());
        _param.setAreaDescCity(schoolInfoBean.getAreaDescCity());
        _param.setAreaDescCounty(schoolInfoBean.getAreaDescCounty());
        _param.setContactName(schoolInfoBean.getContactName());
        _param.setTelNo(schoolInfoBean.getTelNo());
        _param.setAddress(schoolInfoBean.getAddress());
        _param.setCreatePerson(schoolInfoBean.getCreatePerson());
        _param.setCreateTime(DateUtil.getCurrentDate());
        _param.setUpdatePerson(_param.getCreatePerson());
        _param.setUpdateTime(_param.getCreateTime());
        _param.setSchoolLevel(copyBean.getSchoolLevel());
        final Long newSchoolId = this.insert(_param);
        List<SchoolRGradeInfoBean> gradeInfoBeanList = schoolRGradeInfoService.getGradeListBySchoolId(copyBean.getSchoolId());
        gradeInfoBeanList.forEach(gradeInfoBean -> {
            // 获取班级列表
            List<SchoolRGradeRClassInfoBean> classInfoBeanList = schoolRGradeRClassInfoService.getClassListByGradeId(gradeInfoBean.getGradeId());
            // 插入年级信息
            gradeInfoBean.setSchoolId(newSchoolId);
            gradeInfoBean.setGradeId(null);
            final Long newGradeId = schoolRGradeInfoService.insert(gradeInfoBean);
            // 插入班级信息
            classInfoBeanList.forEach(classInfoBean -> {
                classInfoBean.setClassId(null);
                classInfoBean.setGradeId(newGradeId);
                classInfoBean.setSchoolId(newSchoolId);
                schoolRGradeRClassInfoService.insert(classInfoBean);
            });
        });
        return newSchoolId;
    }
}
