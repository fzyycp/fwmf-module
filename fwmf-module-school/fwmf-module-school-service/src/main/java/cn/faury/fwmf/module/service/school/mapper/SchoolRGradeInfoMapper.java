package cn.faury.fwmf.module.service.school.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.school.bean.SchoolRGradeInfoBean;
import cn.faury.fwmf.module.service.school.generate.mapper.SchoolRGradeInfoGenerateMapper;
import cn.faury.fwmf.module.service.school.sqlProvider.SchoolRGradeInfoSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：学校年级信息表
 *
 * <pre>
 *     SchoolRGradeInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自SchoolRGradeInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface SchoolRGradeInfoMapper extends SchoolRGradeInfoGenerateMapper {
}