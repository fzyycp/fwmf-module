package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.WeixinCallbackRecordsBean;
import cn.faury.fwmf.module.service.order.generate.mapper.WeixinCallbackRecordsGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.WeixinCallbackRecordsSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：微信支付回调记录
 *
 * <pre>
 *     WeixinCallbackRecordsGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自WeixinCallbackRecordsGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface WeixinCallbackRecordsMapper extends WeixinCallbackRecordsGenerateMapper {
}
