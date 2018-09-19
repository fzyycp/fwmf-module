package cn.faury.fwmf.module.service.code.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.code.bean.CodeInfoBean;
import cn.faury.fwmf.module.service.code.generate.mapper.CodeInfoGenerateMapper;
import cn.faury.fwmf.module.service.constant.DBConstOfCode;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Mybatis Mapper：数据字典表
 * <p>
 * <pre>
 *     CodeInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自CodeInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface CodeInfoMapper extends CodeInfoGenerateMapper {

    @Select({"SELECT c.CODE_ID, c.CODE_GROUP_ID, c.CODE_NAME, c.CODE_CODE, c.CODE_ORDER"
            , " FROM " + DBConstOfCode.TN_CODE_INFO + " c," + DBConstOfCode.TN_CODE_GROUP_INFO + " g"
            , "WHERE c.CODE_GROUP_ID = g.CODE_GROUP_ID"
            , "  AND g.CODE_GROUP_CODE = #{codeGroupCode}"})
    @ResultType(CodeInfoBean.class)
    List<CodeInfoBean> getCodeListByGroupCode(String codeGroupCode);
}