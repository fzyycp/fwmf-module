package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.order.bean.PostageInfoBean;
import cn.faury.fwmf.module.service.order.generate.mapper.PostageInfoGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.PostageInfoSqlProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：邮费信息表
 *
 * <pre>
 *     PostageInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自PostageInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface PostageInfoMapper extends PostageInfoGenerateMapper {
}