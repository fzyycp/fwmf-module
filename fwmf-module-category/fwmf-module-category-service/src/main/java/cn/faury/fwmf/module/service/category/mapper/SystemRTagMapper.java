package cn.faury.fwmf.module.service.category.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.service.category.generate.mapper.SystemRTagGenerateMapper;

/**
 * Mybatis Mapper：商品标签授权业务系统
 *
 * <pre>
 *     SystemRTagGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自SystemRTagGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface SystemRTagMapper extends SystemRTagGenerateMapper {
}