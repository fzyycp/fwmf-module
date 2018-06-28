package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.user.bean.UserGroupsInfoBean;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.api.user.service.UserGroupsService;
import cn.faury.fwmf.module.service.user.mapper.UserGroupsMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户群服务提供者
 */
public class UserGroupsServiceImpl implements UserGroupsService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public UserGroupsServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public UserGroupsInfoBean getGroupsInfoById(final Long groupId, final Long systemId, final Boolean isWithUsers,
                                                final Boolean isSystemAvailable) {
        AssertUtil.assertTrue(groupId != null && groupId > 0, "用户群ID错误");
        AssertUtil.assertTrue(systemId != null && systemId > 0, "系统Id错误");

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("groupId", groupId);
        parameter.put("systemId", systemId);
        parameter.put("isWithUsers", isWithUsers);
        parameter.put("isSystemAvailable", isSystemAvailable);
        String state = UserGroupsMapper.class.getName() + ".getGroupsInfoById";
        UserGroupsInfoBean userGroupsInfo = this.commonDao.selectOne(state, parameter);
        // 如果isWithUsers为true，就用户群关联的用户列表
        if (userGroupsInfo != null && isWithUsers != null && isWithUsers.booleanValue()) {
            String stateTemp = UserGroupsMapper.class.getName() + ".getGroupUsers";
            List<UserInfoBean> users = this.commonDao.selectList(stateTemp, parameter);
            userGroupsInfo.setUsers(users);
        }
        return userGroupsInfo;
    }

    @Override
    public List<UserGroupsInfoBean> queryGroupsInfo(final UserGroupsInfoBean userGroupsInfo, final Long systemId,
                                                    final Boolean isWithUsers, final Boolean isSystemAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "系统Id错误");
        String state = UserGroupsMapper.class.getName() + ".queryGroupsInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        if (userGroupsInfo != null) {
            if (userGroupsInfo.getGroupId() != null && !userGroupsInfo.getGroupId().equals(0L)) {
                parameter.put("groupId", userGroupsInfo.getGroupId());
            }
            if (StringUtil.isNotEmpty(userGroupsInfo.getGroupName())) {
                parameter.put("groupName", userGroupsInfo.getGroupName());
            }
        }

        if (isWithUsers != null) {
            parameter.put("isWithUsers", isWithUsers);
        }
        if (isSystemAvailable != null) {
            parameter.put("isSystemAvailable", isSystemAvailable);
        }

        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<UserGroupsInfoBean> queryGroupsInfo(UserGroupsInfoBean userGroupsInfo, String systemCode,
                                                    Boolean isWithUsers, Boolean isSystemAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "系统code错误");
        String state = UserGroupsMapper.class.getName() + ".queryGroupsInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        if (userGroupsInfo != null) {
            if (userGroupsInfo.getGroupId() != null && !userGroupsInfo.getGroupId().equals(0L)) {
                parameter.put("groupId", userGroupsInfo.getGroupId());
            }
            if (StringUtil.isNotEmpty(userGroupsInfo.getGroupName())) {
                parameter.put("groupName", userGroupsInfo.getGroupName());
            }
        }
        if (isWithUsers != null) {
            parameter.put("isWithUsers", isWithUsers);
        }
        if (isSystemAvailable != null) {
            parameter.put("isSystemAvailable", isSystemAvailable);
        }

        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<UserInfoBean> queryGroupUserInfo(final Long groupId) {
        AssertUtil.assertTrue(groupId != null && groupId > 0, "用户群Id错误");
        String stateTemp = UserGroupsMapper.class.getName() + ".getGroupUsers";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("groupId", groupId);
        List<UserInfoBean> users = this.commonDao.selectList(stateTemp, parameter);
        return users;
    }

    @Override
    public PageInfo<UserInfoBean> queryGroupUserInfo(Map<String, Object> param) {
        String stateTemp = UserGroupsMapper.class.getName() + ".getGroupUsers";
        return this.commonDao.selectPage(stateTemp, param, PageParam.buildDefaultIns(param));
    }

    @Override
    public List<UserInfoBean> queryUsersURGroup(Long groupId, Long systemId, String loginName, Boolean isSystemAvailable) {
        AssertUtil.assertTrue(groupId != null && groupId > 0, "用户群id错误");
        AssertUtil.assertTrue(systemId != null && systemId > 0, "系统id错误");
        String stateTemp = UserGroupsMapper.class.getName() + ".queryUsersURGroup";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("groupId", groupId);
        parameter.put("systemId", systemId);
        if (StringUtil.isNotEmpty(loginName)) {
            parameter.put("loginName", loginName);
        }
        parameter.put("isSystemAvailable", isSystemAvailable);
        List<UserInfoBean> users = this.commonDao.selectList(stateTemp, parameter);
        return users;
    }

    @Override
    public PageInfo<UserInfoBean> queryUsersURGroup(Map<String, Object> parameters) {
        String stateTemp = UserGroupsMapper.class.getName() + ".queryUsersURGroup";
        return this.commonDao.selectPage(stateTemp, parameters, PageParam.buildDefaultIns(parameters));
    }

    @Override
    public PageInfo<UserGroupsInfoBean> getGroupsInfoPageList(final Map<String, String> parameters,
                                                              final UserGroupsInfoBean userGroupsInfo, final Long systemId, final Boolean isWithUsers,
                                                              final Boolean isSystemAvailable) {
        String state = UserGroupsMapper.class.getName() + ".queryGroupsInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("groupId", userGroupsInfo.getGroupId());
        parameter.put("groupName", userGroupsInfo.getGroupName());
        parameter.put("systemId", systemId);
        parameter.put("isWithUsers", isWithUsers);
        parameter.put("isSystemAvailable", isSystemAvailable);

        return this.commonDao.selectPage(state, parameter, PageParam.buildDefaultIns(parameters));
    }

    @Override
    public List<UserGroupsInfoBean> queryGroupsInfo(final UserGroupsInfoBean userGroupsInfo, final Long systemId,
                                                    final Long userId, final Boolean isWithUsers, final Boolean isSystemAvailable) {
        String state = UserGroupsMapper.class.getName() + ".queryGroupsInfoByUser";
        Map<String, Object> parameter = new HashMap<>();
        if (userGroupsInfo != null) {
            if (userGroupsInfo.getGroupId() != null && !userGroupsInfo.getGroupId().equals(0L)) {
                parameter.put("groupId", userGroupsInfo.getGroupId());
            }
            if (StringUtil.isNotEmpty(userGroupsInfo.getGroupName())) {
                parameter.put("groupName", userGroupsInfo.getGroupName());
            }
        }
        if (userId != null && !userId.equals(0L)) {
            parameter.put("userId", userId);
        }

        if (systemId != null && !systemId.equals(0L)) {
            parameter.put("systemId", systemId);
        }
        parameter.put("isWithUsers", isWithUsers);
        parameter.put("isSystemAvailable", isSystemAvailable);

        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<UserGroupsInfoBean> queryGroupsInfo(final UserGroupsInfoBean userGroupsInfo, final Long systemId,
                                                    final String loginName, final Boolean isWithUsers, final Boolean isSystemAvailable) {
        String state = UserGroupsMapper.class.getName() + ".queryGroupsInfoByUser";
        Map<String, Object> parameter = new HashMap<String, Object>();
        if (userGroupsInfo != null) {
            if (StringUtil.isNotEmpty(userGroupsInfo.getGroupName())) {
                parameter.put("groupName", userGroupsInfo.getGroupName());
            }
        }
        if (StringUtil.isNotEmpty(loginName)) {
            parameter.put("loginName", loginName);
        }
        if (systemId != null && !systemId.equals(0L)) {
            parameter.put("systemId", systemId);
        }

        parameter.put("isWithUsers", isWithUsers);
        parameter.put("isSystemAvailable", isSystemAvailable);

        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public PageInfo<UserGroupsInfoBean> queryGroupsInfo(Map<String, Object> parameters) {
        String stateTemp = UserGroupsMapper.class.getName() + ".queryGroupsInfoByUser";
        return this.commonDao.selectPage(stateTemp, parameters, PageParam.buildDefaultIns(parameters));
    }

    @Transactional
    public Long insertUserGroupsInfo(final UserGroupsInfoBean userGroupsInfo) {
        AssertUtil.assertNotNull(userGroupsInfo, "用户群信息为空");
        AssertUtil.assertNotEmpty(userGroupsInfo.getGroupName(), "群名称为空或不存在");
        AssertUtil.assertTrue(userGroupsInfo.getSystemId() != null && userGroupsInfo.getSystemId() > 0, "所属系统为空或不存在");
        AssertUtil.assertTrue(userGroupsInfo.getNum() != null && userGroupsInfo.getNum() > 0, "人数为空或不存在");
        AssertUtil.assertTrue(userGroupsInfo.getCreatePerson() != null && userGroupsInfo.getCreatePerson() > 0, "创建人为空或不存在");
        AssertUtil.assertTrue(userGroupsInfo.getUpdatePerson() != null && userGroupsInfo.getUpdatePerson() > 0, "更新人为空或不存在");
        String state = UserGroupsMapper.class.getName() + ".insertGroupsInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();

        int res = this.commonDao.insert(state, userGroupsInfo);
        // 当插入的时候关联用户不为空时，插入关联
        if (res > 0 && userGroupsInfo.getUsers() != null && userGroupsInfo.getUsers().size() > 0) {
            String userGroupstate = UserGroupsMapper.class.getName() + ".insertUserGroupsInfo";
            parameter.put("userInfos", userGroupsInfo.getUsers());
            parameter.put("groupId", userGroupsInfo.getGroupId());
            this.commonDao.insert(userGroupstate, parameter);
        }
        return res > 0 ? userGroupsInfo.getGroupId() : -1L;
    }

    @Transactional
    public int insertUserAndGroupsInfo(List<Long> userIds, UserGroupsInfoBean userGroupsInfo) {
        AssertUtil.assertNotEmpty(userIds, "用户ID为空");

        Map<String, Object> parameter = new HashMap<>();
        String userGroupstate = UserGroupsMapper.class.getName() + ".insertUserGroupsInfo";
        List<UserInfoBean> users = new ArrayList<>();
        for (Long userId : userIds) {
            UserInfoBean user = new UserInfoBean();
            user.setUserId(userId);
            users.add(user);
        }
        parameter.put("userInfos", users);
        if (userGroupsInfo.getGroupId() != null && !userGroupsInfo.getGroupId().equals(0L)) {
            parameter.put("groupId", userGroupsInfo.getGroupId());
        }
        int resT = this.commonDao.insert(userGroupstate, parameter);
        updateUserGroupsInfo(userGroupsInfo);
        return resT;
    }

    @Transactional
    public Integer updateUserGroupsInfo(UserGroupsInfoBean userGroupsInfo) {
        AssertUtil.assertTrue(userGroupsInfo.getGroupId()!=null&&userGroupsInfo.getGroupId()>0,"用户群id错误");
        AssertUtil.assertTrue(userGroupsInfo.getUpdatePerson()!=null&&userGroupsInfo.getUpdatePerson()>0,"更新人为空或不存在");

        String state = UserGroupsMapper.class.getName() + ".updateUserGroupsInfo";
        List<UserInfoBean> users = this.queryGroupUserInfo(userGroupsInfo.getGroupId());
        // 获取关联的用户的个数，插入num
        if (users != null) {
            userGroupsInfo.setNum(users.size());
        }
        return this.commonDao.update(state, userGroupsInfo);
    }

    @Override
    @Transactional
    public Integer deleteUserAndGroupRInfo(List<Long> userIds, Long groupId, Long systemId, Long updatePerson) {
        AssertUtil.assertNotEmpty(userIds,"删除用户为空");
        AssertUtil.assertTrue(groupId!=null&&groupId>0,"用户群id错误");
        AssertUtil.assertTrue(systemId!=null&&systemId>0,"所属系统为空或不存在");
        AssertUtil.assertTrue(updatePerson!=null&&updatePerson>0,"更新人为空或不存在");
        String state = UserGroupsMapper.class.getName() + ".deleteUserAndGroupRInfo";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("userIds", userIds);
        parameter.put("groupId", groupId);
        int res = this.commonDao.update(state, parameter);
        // 删除关联关系后，还需要修改用户群表里面Num字段
        UserGroupsInfoBean userGroup = this.getGroupsInfoById(groupId, systemId, false, null);
        if (res > 0 && userGroup != null) {
            int newNum = userGroup.getNum() - res;
            userGroup.setNum(newNum);
            userGroup.setUpdatePerson(updatePerson);
            userGroup.setSystemId(systemId);
            userGroup.setGroupId(groupId);
            this.updateUserGroupsInfo(userGroup);
        }

        return res;

    }

    @Override
    public Integer deleteUserGroupsInfoById(Long groupId) {
        AssertUtil.assertTrue(groupId!=null&&groupId>0,"用户群id错误");
        String state = UserGroupsMapper.class.getName() + ".deleteUserGroupsInfoById";
        return this.commonDao.update(state, groupId);
    }
}
