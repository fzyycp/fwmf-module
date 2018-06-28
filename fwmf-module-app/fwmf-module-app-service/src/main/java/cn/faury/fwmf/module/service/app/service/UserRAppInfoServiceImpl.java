package cn.faury.fwmf.module.service.app.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.app.bean.UserRAppInfoBean;
import cn.faury.fwmf.module.api.app.service.UserRAppInfoService;
import cn.faury.fwmf.module.service.app.mapper.UserRAppInfoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * APP注册服务协议
 */
public class UserRAppInfoServiceImpl implements UserRAppInfoService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public UserRAppInfoServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * APP注册Mapper.class
     */
    protected String MAPPER_CLASS_NAME = UserRAppInfoMapper.class.getName();

    @Override
    public List<UserRAppInfoBean> getUserRAppInfoList(List<Long> userIds, Boolean isAppAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();

        parameter.put("userIds", userIds);
        parameter.put("isAppAvailable", isAppAvailable);

        String statement = MAPPER_CLASS_NAME + ".getUserRAppInfoList";
        return this.commonDao.selectList(statement, parameter);

    }

    @Override
    public List<UserRAppInfoBean> getUserRAppInfoListWithConcat(List<Long> userIds, Boolean isAppAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();

        parameter.put("userIds", userIds);
        parameter.put("isAppAvailable", isAppAvailable);

        String statement = MAPPER_CLASS_NAME + ".getUserRAppInfoListWithConcat";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public Integer insertUserRApp(List<UserRAppInfoBean> userRApps) {
        AssertUtil.assertNotEmpty(userRApps, "用户关联APP不可以为空");
        userRApps.forEach(bean -> {
            AssertUtil.assertTrue(bean.getAppId() != null && bean.getAppId() > 0, "AppID不能为空");
        });
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userRApps", userRApps);
        String statement = MAPPER_CLASS_NAME + ".insertUserRApp";
        return this.commonDao.insert(statement, parameter);
    }

    @Override
    public Integer deleteUserRAppById(List<Long> ids) {
        AssertUtil.assertNotEmpty(ids, "ID不可以为空");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("ids", ids);
        String statement = MAPPER_CLASS_NAME + ".deleteUserRAppById";
        return this.commonDao.delete(statement, parameter);
    }

    @Override
    public Integer deleteUserRAppByUserId(List<Long> userIds) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userIds", userIds);
        String statement = MAPPER_CLASS_NAME + ".deleteUserRAppByUserId";
        return this.commonDao.delete(statement, parameter);
    }

    /*
     *
     * @see
     * cn.wassk.platform.inteface.appregister.adapter.UserRAppInfoServiceAdapter
     * #deleteBuserRAppByUserId(java.util.List, java.lang.Long)
     */
    @Override
    public Integer deleteUserRAppByUserId(List<Long> appIds, Long userId) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("appIds", appIds);
        parameter.put("userId", userId);
        String statement = MAPPER_CLASS_NAME + ".deleteUserRAppByUserIds";
        return this.commonDao.delete(statement, parameter);
    }
}
