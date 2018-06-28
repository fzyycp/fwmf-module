package cn.faury.fwmf.module.service.user.mapper;


import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.UserListBean;
import cn.faury.fwmf.module.service.user.sqlProvider.SystemRUserSQLProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface SystemRUserMapper {

	/**
	 * 通过条件查询系统用户信息
	 *
	 *            <pre>
	 * 【可选】String systemCode 来源系统Code
	 * 【可选】String loginName 用户登录名
	 * 【可选】List<String> userTypeList 用户类型(cn.wassk.platform.service.user.config.UserType)
	 * 【可选】String startTime （注册时间）开始时间
	 * 【可选】String endTime （注册时间）结束时间
	 * </pre>
	 * @return 商店用户信息
	 */
	@SelectProvider(type = SystemRUserSQLProvider.class, method = "getUserInfoList")
	@ResultType(UserListBean.class)
	public List<UserListBean> getUserInfoList(Map<String, Object> param);
}
