package cn.faury.fwmf.module.service.apptester.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.apptester.bean.AppTesterBean;
import cn.faury.fwmf.module.service.apptester.sqlProvider.AppTesterSQLProvider;
import cn.faury.fwmf.module.service.constant.DBConstOfAppTester;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface AppTesterMapper {

	/**
	 * 查询关联测试用户
	 * 
	 * @param param
	 * @return
	 */
	@SelectProvider(type = AppTesterSQLProvider.class, method = "queryAppTesterPage")
	@ResultType(AppTesterBean.class)
	public List<AppTesterBean> queryAppTesterPage(Map<String, Object> param);

	/**
	 * 查询未关联的用户
	 * 
	 * @param param
	 * @return
	 */
	@SelectProvider(type = AppTesterSQLProvider.class, method = "queryUNAppTesterPage")
	@ResultType(AppTesterBean.class)
	public List<AppTesterBean> queryUNAppTesterPage(Map<String, Object> param);

	/**
	 * 添加测试用户
	 * 
	 * @param param
	 * @return
	 */
	@InsertProvider(type = AppTesterSQLProvider.class, method = "insertAppTester")
	public int insertAppTester(Map<String, Object> param);

	/**
	 * 删除测试用户
	 * 
	 * @param param
	 * @return
	 */
	@DeleteProvider(type = AppTesterSQLProvider.class, method = "delAppTester")
	public int delAppTester(Map<String, Object> param);

	/**
	 * 查询测试用户bean
	 * 
	 * @param param
	 * @return
	 */
	@Select(" SELECT ID id,USER_ID userId,LOGIN_NAME loginName,SYS_ID sysId,APP_ID appId FROM "
	        + DBConstOfAppTester.TN_APP_TESTER + " WHERE USER_ID = #{userId} AND APP_ID = (SELECT APP_ID FROM "
	        + DBConstOfAppTester.TN_APP_INFO + " WHERE APP_CODE = #{appCode} )")
	public AppTesterBean getAppTesterByUserId(Map<String, Object> param);
}
