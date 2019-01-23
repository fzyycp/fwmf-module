package cn.faury.fwmf.module.service.menu.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.menu.bean.FunctionInfoBean;
import cn.faury.fwmf.module.service.menu.generate.mapper.RoleRFunctionGenerateMapper;
import cn.faury.fwmf.module.service.menu.sqlProvider.RoleRFunctionSqlProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：角色关联功能按钮表
 *
 * <pre>
 *     RoleRFunctionGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自RoleRFunctionGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface RoleRFunctionMapper extends RoleRFunctionGenerateMapper {

    @SelectProvider(type=RoleRFunctionSqlProvider.class, method="getRoleRFuncInfosByRole")
    @ResultType(FunctionInfoBean.class)
    List<FunctionInfoBean>  getRoleRFuncInfosByRole(Map<String, Object> param);
}