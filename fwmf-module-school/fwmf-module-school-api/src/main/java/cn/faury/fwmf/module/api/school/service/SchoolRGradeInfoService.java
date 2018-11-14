package cn.faury.fwmf.module.api.school.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeInfoBean;

import java.util.List;

/**
 * 服务接口：学校年级信息表
 * <p>
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface SchoolRGradeInfoService extends CrudBaseService<SchoolRGradeInfoBean, Long> {

    /**
     * 格式化班级名称
     *
     * @param gradeInfoBean    年级信息
     * @param index            序号
     * @param isClassNameShort 是否班级名称简写
     * @return 格式化班级名称
     */
    default String formatClassName(SchoolRGradeInfoBean gradeInfoBean, int index, boolean isClassNameShort) {
        if (isClassNameShort) {
            return index + "班";
        }
        return gradeInfoBean.getGradeName() + index + "班";
    }

    /**
     * 根据学校ID获取年级列表
     *
     * @param schoolId 学校ID
     * @return 年级列表
     */
    public List<SchoolRGradeInfoBean> getGradeListBySchoolId(final Long schoolId);

    /**
     * 插入年级信息，包含班级个数
     *
     * @param gradeInfoBean    年级信息
     * @param classCount       班级个数
     * @param isClassNameShort 是否班级名称简写
     * @return 新插入年级ID
     */
    public Long insert(SchoolRGradeInfoBean gradeInfoBean, int classCount, boolean isClassNameShort);

    /**
     * 扩展班级数
     *
     * @param gradeId       年级ID
     * @param newClassCount 扩展后班级总数
     */
    default public void expandClass(Long gradeId, int newClassCount) {
        expandClass(gradeId, newClassCount, false);
    }

    /**
     * 扩展班级数
     *
     * @param gradeId          年级ID
     * @param newClassCount    扩展后班级总数
     * @param isClassNameShort 是否班级名称简写
     */
    public void expandClass(Long gradeId, int newClassCount, boolean isClassNameShort);
}