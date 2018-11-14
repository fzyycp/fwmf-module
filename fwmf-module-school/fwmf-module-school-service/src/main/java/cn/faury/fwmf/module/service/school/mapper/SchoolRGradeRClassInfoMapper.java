package cn.faury.fwmf.module.service.school.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.service.constant.DBConstOfSchool;
import cn.faury.fwmf.module.service.school.generate.mapper.SchoolRGradeRClassInfoGenerateMapper;
import org.apache.ibatis.annotations.Delete;

/**
 * Mybatis Mapper：学校年级班级信息表
 * <p>
 * <pre>
 *     SchoolRGradeRClassInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自SchoolRGradeRClassInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface SchoolRGradeRClassInfoMapper extends SchoolRGradeRClassInfoGenerateMapper {

    /**
     * 根据年级删除班级信息
     *
     * @param gradeId 年级ID
     * @return 成功删除条数
     */
    @Delete({
            "DELETE FROM ",
            DBConstOfSchool.SYS_T_SCHOOL_R_GRADE_R_CLASS,
            "WHERE GRADE_ID = #{gradeId,jdbcType=BIGINT}"
    })
    int deleteByGradeId(Long gradeId);
}