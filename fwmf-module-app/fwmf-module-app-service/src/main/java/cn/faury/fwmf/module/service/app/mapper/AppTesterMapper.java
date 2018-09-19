package cn.faury.fwmf.module.service.app.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.app.bean.AppTesterBean;
import cn.faury.fwmf.module.service.app.generate.mapper.AppTesterGenerateMapper;
import cn.faury.fwmf.module.service.app.sqlProvider.AppTesterSqlProvider;
import cn.faury.fwmf.module.service.constant.DBConstOfApp;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：APP测试用户信息表
 *
 * <pre>
 *     AppTesterGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自AppTesterGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface AppTesterMapper extends AppTesterGenerateMapper {

	/**
	 * 查询关联测试用户
	 * 
	 * @param param
	 * @return
	 */
	@SelectProvider(type = AppTesterSqlProvider.class, method = "queryAppTesterPage")
	@ResultType(AppTesterBean.class)
	public List<AppTesterBean> queryAppTesterPage(Map<String, Object> param);

	/**
	 * 查询未关联的用户
	 * 
	 * @param param
	 * @return
	 */
	@SelectProvider(type = AppTesterSqlProvider.class, method = "queryUNAppTesterPage")
	@ResultType(AppTesterBean.class)
	public List<AppTesterBean> queryUNAppTesterPage(Map<String, Object> param);

	/**
	 * 添加测试用户
	 * 
	 * @param param
	 * @return
	 */
	@InsertProvider(type = AppTesterSqlProvider.class, method = "insertAppTester")
	public int insertAppTester(Map<String, Object> param);

	/**
	 * 删除测试用户
	 * 
	 * @param param
	 * @return
	 */
	@DeleteProvider(type = AppTesterSqlProvider.class, method = "delAppTester")
	public int delAppTester(Map<String, Object> param);

	/**
	 * 查询测试用户bean
	 * 
	 * @param param
	 * @return
	 */
	@Select(" SELECT ID id,USER_ID userId,LOGIN_NAME loginName,SYS_ID sysId,APP_ID appId FROM "
	        + DBConstOfApp.TN_APP_TESTER + " WHERE USER_ID = #{userId} AND APP_ID = (SELECT APP_ID FROM "
	        + DBConstOfApp.TN_APP_INFO + " WHERE APP_CODE = #{appCode} )")
	public AppTesterBean getAppTesterByUserId(Map<String, Object> param);
}
