package cn.faury.fwmf.module.service.school.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.school.bean.SchoolInfoBean;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeInfoBean;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeRClassInfoBean;
import cn.faury.fwmf.module.api.school.service.SchoolInfoService;
import cn.faury.fwmf.module.api.school.service.SchoolRGradeInfoService;
import cn.faury.fwmf.module.api.school.service.SchoolRGradeRClassInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.school.mapper.SchoolRGradeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 服务实现：学校年级信息表
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了SchoolRGradeInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class SchoolRGradeInfoServiceImpl extends CrudBaseServiceImpl<SchoolRGradeInfoBean, Long> implements SchoolRGradeInfoService {

    @Autowired(required = false)
    private SchoolInfoService schoolInfoService;

    @Autowired(required = false)
    private SchoolRGradeRClassInfoService schoolRGradeRClassInfoService;

    public SchoolRGradeInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, SchoolRGradeInfoMapper.class);
    }

    /**
     * 根据学校ID获取年级列表
     *
     * @param schoolId 学校ID
     * @return 年级列表
     */
    @Override
    public List<SchoolRGradeInfoBean> getGradeListBySchoolId(Long schoolId) {
        Map<String, Object> params = new HashMap<>();
        params.put("schoolId", schoolId);
        params.put("ORDER_BY", "GRADE_CODE,ASC");
        return this.query(params);
    }

    /**
     * 插入年级信息，包含班级个数
     *
     * @param gradeInfoBean    年级信息
     * @param classCount       班级个数
     * @param isClassNameShort 是否班级名称简写
     * @return 新插入年级ID
     */
    @Override
    @Transactional
    public Long insert(SchoolRGradeInfoBean gradeInfoBean, int classCount, boolean isClassNameShort) {
        Long gradeId = this.insert(gradeInfoBean);
        // 构造班级信息
        for (int i = 1; i <= classCount; i++) {
            SchoolRGradeRClassInfoBean classInfoBean = new SchoolRGradeRClassInfoBean();
            classInfoBean.setSchoolId(gradeInfoBean.getSchoolId());
            classInfoBean.setGradeId(gradeId);
            classInfoBean.setClassCode(gradeInfoBean.getGradeCode() + String.format("%02d", i));
            classInfoBean.setClassName(formatClassName(gradeInfoBean,i,isClassNameShort));
            classInfoBean.setClassAlias(classInfoBean.getClassName());
            schoolRGradeRClassInfoService.insert(classInfoBean);
        }
        return gradeId;
    }

    @Transactional
    @Override
    public int deleteById(Long primaryKey) {
        // 先删除班级
        schoolRGradeRClassInfoService.deleteByGradeId(primaryKey);
        // 在删除年级
        return super.deleteById(primaryKey);
    }

    /**
     * 扩展班级数
     *
     * @param gradeId          年级ID
     * @param newClassCount    扩展后班级总数
     * @param isClassNameShort 是否班级名称简写
     */
    @Override
    public void expandClass(Long gradeId, int newClassCount, boolean isClassNameShort) {
        // 获取年级信息
        SchoolRGradeInfoBean gradeInfoBean = this.getBeanById(gradeId);
        AssertUtil.assertNotNull(gradeInfoBean, "年级信息不存");

        // 获取年级下班级数
        List<SchoolRGradeRClassInfoBean> classInfoBeanList = schoolRGradeRClassInfoService.getClassListByGradeId(gradeId);
        if (classInfoBeanList != null && classInfoBeanList.size() < newClassCount) {// 现有班级数小于新的总班级数
            List<String> oldClassCode = classInfoBeanList.stream().map(SchoolRGradeRClassInfoBean::getClassCode).collect(Collectors.toList());
            String oldClassName = classInfoBeanList.size() > 0 ? classInfoBeanList.get(0).getClassName() : "";
            for (int i = 1; i <= newClassCount; i++) {
                String newClassCode = gradeInfoBean.getGradeCode() + String.format("%02d", i);
                if (oldClassCode.contains(newClassCode)) {
                    continue;
                }
                SchoolRGradeRClassInfoBean classInfoBean = new SchoolRGradeRClassInfoBean();
                classInfoBean.setSchoolId(gradeInfoBean.getSchoolId());
                classInfoBean.setGradeId(gradeInfoBean.getGradeId());
                classInfoBean.setClassCode(newClassCode);
                if (StringUtil.isNotEmpty(oldClassName) && oldClassName.contains(gradeInfoBean.getGradeName())) {
                    classInfoBean.setClassName(gradeInfoBean.getGradeName() + i + "班");
                } else {
                    classInfoBean.setClassName(formatClassName(gradeInfoBean,i,isClassNameShort));
                }
                classInfoBean.setClassAlias(classInfoBean.getClassName());
                schoolRGradeRClassInfoService.insert(classInfoBean);
            }
        }
    }
}
