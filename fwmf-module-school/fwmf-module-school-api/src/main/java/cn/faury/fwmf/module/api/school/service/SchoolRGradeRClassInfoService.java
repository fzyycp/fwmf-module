package cn.faury.fwmf.module.api.school.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeRClassInfoBean;

import java.util.List;

/**
 * 服务接口：学校年级班级信息表
 * <p>
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
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
     *
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