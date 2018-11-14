package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.order.bean.AlipayRecordsBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.AlipayRecordsGenerateMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Mybatis Mapper：
 *
 * <pre>
 *     AlipayRecordsGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自AlipayRecordsGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface AlipayRecordsMapper extends AlipayRecordsGenerateMapper {


    @Select({"SELECT ID, OUT_TRADE_NO, `SUBJECT`, TOTALFEE, ORDER_ID, BODY, USER_ID, USER_NAME, CREATE_TIME" +
            "        , ALIPAY_TRADE_NO, TRADE_STATUS, RECEIVE_SRC"
            , " FROM ", DBConstOfOrder.PAYMENT_T_ALIPAY_RECORDS
            , "WHERE OUT_TRADE_NO=#{outTradeNo}"
            , "LIMIT 1"})
    @ResultType(AlipayRecordsBean.class)
    AlipayRecordsBean getBeanByOutTradeNo(Map<String, Object> params);

    @Select({"UPDATE", DBConstOfOrder.PAYMENT_T_ALIPAY_RECORDS
            ,"SET ALIPAY_TRADE_NO=#{alipayTradeNo},TRADE_STATUS=#{tradeStatus}"
            , "WHERE OUT_TRADE_NO = #{outTradeNo}"})
    int updateTradeStatus(Map<String, Object> params);
}