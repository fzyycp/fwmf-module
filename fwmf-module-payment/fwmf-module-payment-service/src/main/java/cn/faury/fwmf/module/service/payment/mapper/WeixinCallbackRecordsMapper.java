package cn.faury.fwmf.module.service.payment.mapper;

import cn.faury.fwmf.module.api.payment.bean.WeixinCallbackRecordsBean;
import cn.faury.fwmf.module.service.payment.generate.mapper.WeixinCallbackRecordsGenerateMapper;
import cn.faury.fwmf.module.service.payment.sqlProvider.WeixinCallbackRecordsSqlProvider;
import cn.faury.fdk.mybatis.AutoScannedMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface WeixinCallbackRecordsMapper extends WeixinCallbackRecordsGenerateMapper {

    @SelectProvider(type = WeixinCallbackRecordsSqlProvider.class, method = "search")
    @ResultType(WeixinCallbackRecordsBean.class)
    List<WeixinCallbackRecordsBean> search(Map<String, Object> params);
}
