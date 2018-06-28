package cn.faury.fwmf.module.service.user.mapper;


import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.UserGroupsInfoBean;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import cn.faury.fwmf.module.service.user.sqlProvider.UserGroupsSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface UserGroupsMapper {

	/**
	 * 根据群组id获取用户群信息
	 * 
	 * @param groupId
	 *            【必填】用户群id
	 * @param systemId
	 *            【必填】系统id
	 * @param isWithUsers
	 *            【可选】是否包含所关联的用户
	 * @param isSystemAvailable
	 *            【可选】 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 用户群信息
	 */
	@SelectProvider(type = UserGroupsSQLProvider.class, method = "getGroupsInfoById")
	@ResultType(UserGroupsInfoBean.class)
	public UserGroupsInfoBean getGroupsInfoById(final Long groupId, final Long systemId, final Boolean isWithUsers,
                                                final Boolean isSystemAvailable);

	/**
	 * 根据用户群id获取关联的用户信息
	 *
	 * @param groupId
	 *            用户群id
	 * @return 关联的用户
	 */
	@SelectProvider(type = UserGroupsSQLProvider.class, method = "getGroupUsers")
	@ResultType(UserInfoBean.class)
	public List<UserInfoBean> getGroupUsers(final Long groupId);

	/**
	 * 查询用户群信息列表
	 *
	 * @param userGroupsInfo
	 *            用户群对象查询条件
	 * @param systemId
	 *            系统id
	 * @param isWithUsers
	 *            【可选】是否包含所关联的用户
	 * @param isSystemAvailable
	 *            【可选】 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 用户群信息列表
	 */
	@SelectProvider(type = UserGroupsSQLProvider.class, method = "queryGroupsInfo")
	@ResultType(UserGroupsInfoBean.class)
	public List<UserGroupsInfoBean> queryGroupsInfo(final UserGroupsInfoBean userGroupsInfo, final Long systemId,
                                                    final Boolean isWithUsers, final Boolean isSystemAvailable);

	/**
	 * 根据群id查询未关联的用户列表
	 *
	 * @param groupId
	 *            用户群id
	 * @param systemId
	 *            系统Id
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 用户信息列表
	 */
	@SelectProvider(type = UserGroupsSQLProvider.class, method = "queryUsersURGroup")
	@ResultType(UserInfoBean.class)
	public List<UserInfoBean> queryUsersURGroup(Long groupId, Long systemId, Boolean isSystemAvailable);

	/**
	 * 插入群与用户关联信息 userInfos 多个用户对象List<UserInfoBean> groupId 用户群id Long
	 *
	 * @param parameter
	 *            userInfos和groupId的map
	 * @return 受影响行数
	 */
	@SelectProvider(type = UserGroupsSQLProvider.class, method = "insertUserGroupsInfo")
	@ResultType(Integer.class)
	public int insertUserGroupsInfo(Map<String, Object> parameter);

	/**
	 * 插入用户群信息 createPerson 【必填】创建人id
	 *
	 * @param userGroupsInfo
	 *            用户群信息
	 * @return 主键id
	 */
	@Insert("INSERT INTO "
	        + DBConstOfUserRole.TN_CDA_GROUP
	        + " (`GROUP_NAME`, `ORIGIN_OS_ID`, `NUM`,`CREATE_PERSON`,`CREATE_TIME`,`UPDATE_PERSON`,`UPDATE_TIME`,`DEL_FLAG`) VALUES (#{groupName}, #{systemId}, #{num},#{createPerson},now(),#{createPerson},now(),'0')")
	@Options(keyProperty = "groupId", useGeneratedKeys = true)
	public Long insertGroupsInfo(final UserGroupsInfoBean userGroupsInfo);

	/**
	 * 更新用户群信息
	 */

	@SelectProvider(type = UserGroupsSQLProvider.class, method = "updateUserGroupsInfo")
	public Integer updateUserGroupsInfo(UserGroupsInfoBean userGroupsInfo);

	@Update(" UPDATE " + DBConstOfUserRole.TN_CDA_GROUP + " SET DEL_FLAG = '1' WHERE ID = #{groupId}")
	public Integer deleteUserGroupsInfoById(Long groupId);

	/**
	 * 删除用户和用户群关联关系
	 *
	 * @param userIds
	 *            多个用户id
	 * @param groupId
	 *            用户群id
	 * @param systemId
	 *            系统id
	 * @param updatePerson
	 *            更新人id
	 * @return 受影响的行数
	 */
	@SelectProvider(type = UserGroupsSQLProvider.class, method = "deleteUserAndGroupRInfo")
	@ResultType(Integer.class)
	public Integer deleteUserAndGroupRInfo(List<Long> userIds, Long groupId, Long systemId, Long updatePerson);

	@SelectProvider(type = UserGroupsSQLProvider.class, method = "queryGroupsInfoByUser")
	@ResultType(UserGroupsInfoBean.class)
	public List<UserGroupsInfoBean> queryGroupsInfoByUser(final UserGroupsInfoBean userGroupsInfo, final Long systemId,
                                                          final Long userId, final Boolean isWithUsers, final Boolean isSystemAvailable);
}
