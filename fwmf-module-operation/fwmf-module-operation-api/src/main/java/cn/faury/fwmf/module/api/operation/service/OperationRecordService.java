package cn.faury.fwmf.module.api.operation.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.operation.bean.OperationRecordBean;

/**
 * 服务接口：操作记录信息表
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface OperationRecordService extends CrudBaseService<OperationRecordBean, Long> {
}