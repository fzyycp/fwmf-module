package cn.faury.fwmf.module.api.user.service;


import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.user.bean.UserGroupsInfoBean;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;

import java.util.List;
import java.util.Map;

/**
 * 用户群
 */
public interface UserGroupsService {

    /**
     * 根据系统ID查询系统下所有用户群
     *
     * @param systemId          【必填】系统ID
     * @param isSystemAvailable 【可选】系统是否可用
     * @return 用户群
     */
    @Read
    default public List<UserGroupsInfoBean> queryGroupsInfoBySystemId(final Long systemId, final Boolean isSystemAvailable){
        return queryGroupsInfo(null, systemId, null, isSystemAvailable);
    }

    /**
     * 根据系统code查询系统下所有用户群
     *
     * @param systemCode        【必填】系统code
     * @param isSystemAvailable 【可选】系统是否可用
     * @return 用户群
     */
    @Read
    default public List<UserGroupsInfoBean> queryGroupsInfoBySystemCode(final String systemCode, final Boolean isSystemAvailable){
        return queryGroupsInfo(null, systemCode, null, isSystemAvailable);
    }


    /**
     * 根据群组id获取用户群信息
     *
     * @param groupId 群Id
     * @return UserGroupsInfoBean 用户群对象
     */
    @Read
    public UserGroupsInfoBean getGroupsInfoById(final Long groupId, final Long systemId, final Boolean isWithUsers,
                                                final Boolean isSystemAvailable);

    /**
     * 根据用户群信息查询用户群列表
     *
     * @param userGroupsInfo    用户群对象
     * @param systemId          系统id
     * @param isWithUsers       是否包含用户
     * @param isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 群列表
     */
    @Read
    public List<UserGroupsInfoBean> queryGroupsInfo(final UserGroupsInfoBean userGroupsInfo, final Long systemId,
                                                    final Boolean isWithUsers, final Boolean isSystemAvailable);

    /**
     * 根据用户群信息查询用户群列表
     *
     * @param userGroupsInfo    用户群对象
     * @param systemCode        系统code
     * @param isWithUsers       是否包含用户
     * @param isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 群列表
     */
    @Read
    public List<UserGroupsInfoBean> queryGroupsInfo(final UserGroupsInfoBean userGroupsInfo, final String systemCode,
                                                    final Boolean isWithUsers, final Boolean isSystemAvailable);

    /**
     * 根据用户群信息查询用户群列表
     *
     * @param userGroupsInfo    用户群对象
     * @param systemId          系统id
     * @param userId            用户id
     * @param isWithUsers       是否包含用户
     * @param isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 群列表
     */
    @Read
    public List<UserGroupsInfoBean> queryGroupsInfo(final UserGroupsInfoBean userGroupsInfo, final Long systemId,
                                                    final Long userId, final Boolean isWithUsers, final Boolean isSystemAvailable);

    /**
     * 根据用户群信息查询用户群列表
     *
     * @param userGroupsInfo    用户群对象
     * @param systemId          系统id
     * @param loginName         用户登录名
     * @param isWithUsers       是否包含用户
     * @param isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 群列表
     */
    @Read
    public List<UserGroupsInfoBean> queryGroupsInfo(final UserGroupsInfoBean userGroupsInfo, final Long systemId,
                                                    final String loginName, final Boolean isWithUsers, final Boolean isSystemAvailable);

    /**
     * 根据用户群信息查询用户群列表 ========分页
     *
     * @param param
     * @return
     * @see #queryGroupsInfo(UserGroupsInfoBean, Long, String, Boolean, Boolean)
     */
    @Read
    public PageInfo<UserGroupsInfoBean> queryGroupsInfo(final Map<String, Object> param);

    /**
     * 根据用户群信息查询用户群<br>
     * 分页</br>列表
     *
     * @param params            分页信息（page,pageSize）
     * @param userGroupsInfo    用户群对象
     * @param systemId          系统id
     * @param isWithUsers       是否包含用户
     * @param isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 群列表
     */
    @Read
    public PageInfo<UserGroupsInfoBean> getGroupsInfoPageList(final Map<String, String> params,
                                                              final UserGroupsInfoBean userGroupsInfo, final Long systemId, final Boolean isWithUsers,
                                                              final Boolean isSystemAvailable);

    /**
     * 根据用户群Id获取关联的用户信息
     *
     * @param groupId 用户群Id
     * @return 关联的用户列表
     */
    @Read
    public List<UserInfoBean> queryGroupUserInfo(final Long groupId);

    /**
     * 根据用户群Id获取关联的用户信息 ======分页
     *
     * @param param
     * @return
     * @see #queryGroupUserInfo(Long)
     */
    @Read
    public PageInfo<UserInfoBean> queryGroupUserInfo(final Map<String, Object> param);

    /**
     * 根据用户群id和系统id，获取系统下面，未关联用户群的用户信息
     *
     * @param groupId           用户群id
     * @param systemId          系统id
     * @param loginName         用户登录名
     * @param isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 未关联的用户列表
     */
    @Read
    public List<UserInfoBean> queryUsersURGroup(final Long groupId, final Long systemId, String loginName,
                                                final Boolean isSystemAvailable);

    /**
     * 根据用户群id和系统id，获取系统下面，未关联用户群的用户信息=====分页
     *
     * @param params
     * @return 未关联的用户列表
     * @see #queryUsersURGroup(Long, Long, String, Boolean)
     */
    @Read
    public PageInfo<UserInfoBean> queryUsersURGroup(final Map<String, Object> params);

    /**
     * 插入用户群信息
     *
     * @param userGroupsInfo 用户群信息
     * @return 群id
     */
    @Write
    public Long insertUserGroupsInfo(final UserGroupsInfoBean userGroupsInfo);

    /**
     * 插入用户与用户群关联信息
     *
     * @param userIds        多个用户Id
     * @param userGroupsInfo 用户群Id
     * @return 受影响的行数
     */
    @Write
    public int insertUserAndGroupsInfo(final List<Long> userIds, final UserGroupsInfoBean userGroupsInfo);

    /**
     * 更新用户群信息
     *
     * @param userGroupsInfo 用户群信息
     * @return 成功返回受影响的行数，失败-1
     */
    @Write
    public Integer updateUserGroupsInfo(final UserGroupsInfoBean userGroupsInfo);

    /**
     * 删除用户群信息
     *
     * @param groupId 群id
     * @return 成功返回受影响的行数，失败-1
     */
    @Write
    public Integer deleteUserGroupsInfoById(final Long groupId);

    /**
     * 删除用户与用户群关联信息
     *
     * @param userIds      多个用户id
     * @param groupId      用户群Id
     * @param systemId     系统id
     * @param updatePerson 修改人id
     * @return 受影响行数
     */
    @Write
    public Integer deleteUserAndGroupRInfo(final List<Long> userIds, final Long groupId, final Long systemId,
                                           final Long updatePerson);

}
