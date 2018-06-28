package cn.faury.fwmf.module.service.user.mapper;


import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.UserListBean;
import cn.faury.fwmf.module.service.user.sqlProvider.PushRUserSQLProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface PushRUserMapper {

	@SelectProvider(type = PushRUserSQLProvider.class, method = "getUserInfoByMessageId")
	@ResultType(UserListBean.class)
	public List<UserListBean> getUserInfoByMessageId(Map<String, Object> parameter);
}
