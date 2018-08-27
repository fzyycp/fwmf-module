package cn.faury.fwmf.module.api.school.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeRClassInfoBean;

import java.util.List;

/**
 * 通用增删改查基础服务接口，可以根据业务需要进一步扩展
 * 只需生成一次，后面不需要再生成
 */
public interface SchoolRGradeRClassInfoService extends CrudBaseService<SchoolRGradeRClassInfoBean, Long> {

    /**
     * 根据年级ID获取班级列表
     *
     * @param gradeId 年级ID
     * @return 班级列表
     */
    public List<SchoolRGradeRClassInfoBean> getClassListByGradeId(final Long gradeId);

    /**
     * 根据年级ID删除所有的班级信息
     * @param gradeId 年级ID
     * @return 成功删除条数
     */
    public int deleteByGradeId(final Long gradeId);

    /**
     * 根据学校ID获取班级列表
     *
     * @param schoolId 学校ID
     * @return 班级列表
     */
    public List<SchoolRGradeRClassInfoBean> getClassListBySchoolId(final Long schoolId);

}