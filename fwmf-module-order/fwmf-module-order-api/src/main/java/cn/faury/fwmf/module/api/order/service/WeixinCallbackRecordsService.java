package cn.faury.fwmf.module.api.order.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.order.bean.WeixinCallbackRecordsBean;

/**
 * 服务接口：微信支付回调记录
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface WeixinCallbackRecordsService extends CrudBaseService<WeixinCallbackRecordsBean, Long> {
}