package cn.faury.fwmf.module.service.system.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.system.bean.SystemInfoBean;
import cn.faury.fwmf.module.api.system.bean.UserRSystemInfoBean;
import cn.faury.fwmf.module.api.system.service.SystemService;
import cn.faury.fwmf.module.api.system.service.UserRSystemService;
import cn.faury.fwmf.module.service.system.mapper.UserRSystemMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户授权业务系统服务提供者
 */
public class UserRSystemServiceImpl implements UserRSystemService {
    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    protected SystemService systemService;

    public UserRSystemServiceImpl(CommonDao commonDao, SystemService systemService) {
        this.commonDao = commonDao;
        this.systemService = systemService;
    }

    @Override
    public List<UserRSystemInfoBean> getUserRSystemInfoListWithConcat(List<Long> userIds, Boolean isSystemAvailable) {
        AssertUtil.assertTrue(userIds != null && userIds.size() > 0, "用户ID错误");
        String state = UserRSystemMapper.class.getName() + ".getUserRSystemInfoListWithConcat";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("userIds", userIds);
        parameter.put("isSystemAvailable", isSystemAvailable);
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<UserRSystemInfoBean> getUserRSystemInfoList(List<Long> userIds, Boolean isSystemAvailable) {
        AssertUtil.assertTrue(userIds != null && userIds.size() > 0, "用户ID错误");
        String state = UserRSystemMapper.class.getName() + ".getUserRSystemInfoList";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userIds", userIds);
        parameter.put("isSystemAvailable", isSystemAvailable);
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public Boolean isSystemInAgentUse(final UserRSystemInfoBean userRSystem) {
        AssertUtil.assertNotNull(userRSystem, "用户授权业务系统信息不可以为空");
        AssertUtil.assertTrue(userRSystem.getUserId() != null && userRSystem.getUserId() > 0, "用户授权业务系统信息用户ID不可以为空");
        AssertUtil.assertTrue(userRSystem.getSystemId() != null && userRSystem.getSystemId() > 0, "用户授权业务系统信息系统ID不可以为空");
        String state = UserRSystemMapper.class.getName() + ".getSystemInAgentUse";
        Map<String, Object> parameter = new HashMap<>();

        parameter.put("userId", userRSystem.getUserId());
        parameter.put("systemId", userRSystem.getSystemId());
        List<UserRSystemInfoBean> list = this.commonDao.selectList(state, parameter);

        return list.size() > 0;
    }

    @Override
    public Boolean isSystemRRole(UserRSystemInfoBean userRSystem) {
        AssertUtil.assertNotNull(userRSystem, "用户授权业务系统信息不可以为空");
        AssertUtil.assertTrue(userRSystem.getUserId() != null && userRSystem.getUserId() > 0, "用户授权业务系统信息用户ID不可以为空");
        AssertUtil.assertTrue(userRSystem.getSystemId() != null && userRSystem.getSystemId() > 0, "用户授权业务系统信息系统ID不可以为空");
        String state = UserRSystemMapper.class.getName() + ".getSystemRRole";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userRSystem.getUserId());
        parameter.put("systemId", userRSystem.getSystemId());
        List<UserRSystemInfoBean> list = this.commonDao.selectList(state, parameter);

        return list.size() > 0;
    }

    @Override
    public Integer insertUserRSystem(List<UserRSystemInfoBean> userRSystems) {
        AssertUtil.assertTrue(userRSystems!=null&&userRSystems.size()>0,"用户授权业务系统信息不可以为空");
        userRSystems.forEach(userRSystem->{
            AssertUtil.assertTrue(userRSystem.getUserId() != null && userRSystem.getUserId() > 0, "用户授权业务系统信息用户ID不可以为空");
            AssertUtil.assertTrue(userRSystem.getSystemId() != null && userRSystem.getSystemId() > 0, "用户授权业务系统信息系统ID不可以为空");

        });
        // 新增
        int res = 0;
        String state = UserRSystemMapper.class.getName() + ".insertUserRSystem";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userRSystems", userRSystems);
        res = this.commonDao.insert(state, parameter);

        return res;
    }

    @Override
    public Integer insertUserRSystem(Long userId, String systemCode) {
        SystemInfoBean systemInfo = systemService.getSystemInfoByCode(systemCode);
        AssertUtil.assertNotNull(systemInfo,String.format("业务系统[%s]不存在！", systemCode));
        return this.insertUserRSystem(userId, systemInfo.getSystemId());
    }

    @Transactional
    @Override
    public Integer updateUserRSystem(List<Long> addSystemIds, List<Long> delSystemIds, Long userId) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID错误");
        int n = 0;
        if (addSystemIds!=null && addSystemIds.size() > 0) {
            List<UserRSystemInfoBean> userRSystems = new ArrayList<>();
            for (Long addSystemId : addSystemIds) {
                UserRSystemInfoBean info = new UserRSystemInfoBean();
                info.setUserId(userId);
                info.setSystemId(addSystemId);
                info.setIsAvailable("Y");
                userRSystems.add(info);

            }
            n = insertUserRSystem(userRSystems);
        }
        if (delSystemIds!=null && delSystemIds.size() > 0) {
            n = deleteUserRSystemByUserId(delSystemIds, userId);
        }
        return n;

    }

    @Override
    public Integer deleteUserRSystemById(List<Long> ids) {
        AssertUtil.assertTrue(ids != null && ids.size() > 0, "唯一主键ID错误");
        String state = UserRSystemMapper.class.getName() + ".deleteUserRSystemById";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("ids", ids);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    @Override
    public Integer deleteUserRSystemByUserId(List<Long> userIds) {
        AssertUtil.assertTrue(userIds != null && userIds.size() > 0, "用户ID错误");
        String state = UserRSystemMapper.class.getName() + ".deleteUserRSystemById";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("userIds", userIds);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    @Override
    public Integer deleteUserRSystemByUserId(List<Long> systemIds, Long userId) {
        AssertUtil.assertTrue(systemIds != null && systemIds.size() > 0, "系统ID错误");
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID错误");

        String state = UserRSystemMapper.class.getName() + ".deleteUserRSystemById";
        Map<String, Object> parameter = new HashMap<>();

        parameter.put("systemIds", systemIds);
        parameter.put("userId", userId);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }
}
