package cn.faury.fwmf.module.service.user.mapper;


import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.UserGroupsInfoBean;
import cn.faury.fwmf.module.service.user.sqlProvider.PushRUserGroupsSQLProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface PushRUserGroupsMapper {

	@SelectProvider(type = PushRUserGroupsSQLProvider.class, method = "getUserGroupsInfoByMessageId")
	@ResultType(UserGroupsInfoBean.class)
	public List<UserGroupsInfoBean> getUserGroupsInfoByMessageId(Map<String, Object> parameter);
}
