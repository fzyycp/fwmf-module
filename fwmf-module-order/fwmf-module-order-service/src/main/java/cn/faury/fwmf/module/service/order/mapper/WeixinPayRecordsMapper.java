package cn.faury.fwmf.module.service.order.mapper;

import cn.faury.fwmf.module.api.order.bean.WeixinPayRecordsBean;
import cn.faury.fwmf.module.service.constant.DBConstOfOrder;
import cn.faury.fwmf.module.service.order.generate.mapper.WeixinPayRecordsGenerateMapper;
import cn.faury.fwmf.module.service.order.sqlProvider.WeixinPayRecordsSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface WeixinPayRecordsMapper extends WeixinPayRecordsGenerateMapper {

    @SelectProvider(type = WeixinPayRecordsSqlProvider.class, method = "search")
    @ResultType(WeixinPayRecordsBean.class)
    List<WeixinPayRecordsBean> search(Map<String, Object> params);

    @Select({"SELECT ID, OUT_TRADE_NO, `SUBJECT`, TOTALFEE, ORDER_ID, BODY, USER_ID, USER_NAME, CREATE_TIME" +
            "        , TRANSACTION_ID, RESULT_CODE, RECEIVE_SRC"
            , " FROM ", DBConstOfOrder.PAYMENT_T_WEIXIN_PAY_RECORDS
            , "WHERE OUT_TRADE_NO=#{outTradeNo}"
            , "LIMIT 1"})
    @ResultType(WeixinPayRecordsBean.class)
    WeixinPayRecordsBean getBeanByOutTradeNo(Map<String, Object> params);

    @Select({"UPDATE", DBConstOfOrder.PAYMENT_T_WEIXIN_PAY_RECORDS
            ,"SET TRANSACTION_ID=#{transactionId},RESULT_CODE=#{resultCode}"
            , "WHERE OUT_TRADE_NO = #{outTradeNo}"})
    int updateTradeStatus(Map<String, Object> params);
}
