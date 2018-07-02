package cn.faury.fwmf.module.service.app.service;

import cn.faury.fdk.common.anotation.service.CanReadWrite;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.app.bean.AppInfoBean;
import cn.faury.fwmf.module.api.app.service.AppInfoService;
import cn.faury.fwmf.module.service.app.mapper.AppInfoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 【可读可写】手机APP注册信息Service
 */
@CanReadWrite
public class AppInfoServiceImpl implements AppInfoService {

    /**
     * 数据库操作器dao
     */
    protected CommonDao commonDao;

    public AppInfoServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 手机APP注册信息Mapper.class
     */
    protected static String MAPPER_CLASS_NAME = AppInfoMapper.class.getName();

    @Override
    public PageInfo<AppInfoBean> queryAppInfoByPager(Map<String, Object> parameter) {
        PageParam pageParam = PageParam.buildDefaultIns(parameter);
        String statement = MAPPER_CLASS_NAME + ".queryAppInfoByPager";
        return this.commonDao.selectPage(statement, parameter, pageParam);
    }

    @Override
    public List<AppInfoBean> queryAppInfo(Map<String, Object> parameter) {
        String statement = MAPPER_CLASS_NAME + ".queryAppInfo";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<AppInfoBean> getAppInfoList(Long systemId, Long appId, Boolean isSysAvailable,
                                            Boolean isAppAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        // 系统ID
        if (null != systemId) {
            parameter.put("systemId", systemId);
        }
        // appID
        if (null != appId) {
            parameter.put("appId", appId);
        }
        // 系统是否可用
        if (null != isSysAvailable) {
            parameter.put("isSysAvailable", isSysAvailable);
        }
        // APP是否可用
        if (null != isAppAvailable) {
            parameter.put("isAppAvailable", isAppAvailable);
        }
        String statement = MAPPER_CLASS_NAME + ".getAppInfoList";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<AppInfoBean> getAppInfoList(String systemCode, Long appId, Boolean isSysAvailable,
                                            Boolean isAppAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        // 系统code
        if (null != systemCode && !"".equals(systemCode)) {
            parameter.put("systemCode", systemCode);
        }
        // appID
        if (null != appId) {
            parameter.put("appId", appId);
        }
        // 系统是否可用
        if (null != isSysAvailable) {
            parameter.put("isSysAvailable", isSysAvailable);
        }
        // APP是否可用
        if (null != isAppAvailable) {
            parameter.put("isAppAvailable", isAppAvailable);
        }
        String statement = MAPPER_CLASS_NAME + ".getAppInfoList";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<AppInfoBean> getAppInfoList(Long systemId, String appCode, Boolean isSysAvailable,
                                            Boolean isAppAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        // 系统code
        if (null != systemId) {
            parameter.put("systemId", systemId);
        }
        // appCode
        if (null != appCode && !"".equals(appCode)) {
            parameter.put("appCode", appCode);
        }
        // 系统是否可用
        if (null != isSysAvailable) {
            parameter.put("isSysAvailable", isSysAvailable);
        }
        // APP是否可用
        if (null != isAppAvailable) {
            parameter.put("isAppAvailable", isAppAvailable);
        }
        String statement = MAPPER_CLASS_NAME + ".getAppInfoList";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<AppInfoBean> getAppInfoList(String systemCode, String appCode, Boolean isSysAvailable,
                                            Boolean isAppAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        // 系统code
        if (null != systemCode && !"".equals(systemCode)) {
            parameter.put("systemCode", systemCode);
        }
        // appID
        if (null != appCode && !"".equals(appCode)) {
            parameter.put("appCode", appCode);
        }
        // 系统是否可用
        if (null != isSysAvailable) {
            parameter.put("isSysAvailable", isSysAvailable);
        }
        // APP是否可用
        if (null != isAppAvailable) {
            parameter.put("isAppAvailable", isAppAvailable);
        }
        String statement = MAPPER_CLASS_NAME + ".getAppInfoList";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<AppInfoBean> getAppInfoByMId(Long messageId) {
        String statement = MAPPER_CLASS_NAME + ".getAppInfoByMIdNotContact";
        return this.commonDao.selectList(statement, messageId);
    }

    @Override
    public AppInfoBean getAppInfoByMIdIsWithContact(Long messageId) {
        String statement = MAPPER_CLASS_NAME + ".getAppInfoByMIdIsWithContact";
        return this.commonDao.selectOne(statement, messageId);
    }

    @Override
    public String checkAppInfo(Map<String, Object> parameter) {
        String appCode = (String) parameter.get("appCode");
        String appName = (String) parameter.get("appName");
        String errorMsg = null;

        Map<String, Object> param1 = new HashMap<>();
        Map<String, Object> param2 = new HashMap<>();
        param1.put("appCode", parameter.get("appCode"));
        param2.put("appName", parameter.get("appName"));
        if (parameter.containsKey("appId")) {
            param1.put("appId", parameter.get("appId"));
            param2.put("appId", parameter.get("appId"));
        }

        String statementCode = MAPPER_CLASS_NAME + ".checkAppCode";
        AppInfoBean temp1 = this.commonDao.selectOne(statementCode, param1);
        String statementName = MAPPER_CLASS_NAME + ".checkAppName";
        AppInfoBean temp2 = this.commonDao.selectOne(statementName, param2);
        // APPCODE
        if (null != temp1) {
            if (appCode.equals(temp1.getAppCode())) {
                errorMsg = "系统已存在相同的app编码：【" + appCode + "】!";
            }
        }
        // APPNAME
        if (null != temp2) {
            if (appName.equals(temp2.getAppName())) {
                errorMsg = "系统已存在相同的app名称：【" + appName + "】!";
            }
        }
        return errorMsg;
    }

    @Override
    public AppInfoBean isAppInUse(String appCode) {
        String statement = MAPPER_CLASS_NAME + ".getAppCountByAppCode";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("appCode", appCode);
        return this.commonDao.selectOne(statement, parameter);
    }

    @Override
    public Long insertAppInfo(AppInfoBean app) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("appCode", app.getAppCode());
        parameter.put("appName", app.getAppName());
        String errorMsg = checkAppInfo(parameter);
        AssertUtil.assertEmpty(errorMsg, RestResultCode.CODE500.getCode(), errorMsg);
        String statement = MAPPER_CLASS_NAME + ".insertAppInfo";
        return this.commonDao.insert(statement, app) > 0 ? app.getAppId() : -1;
    }

    @Override
    public Long deleteAppInfoByAppCodes(List<String> appCodes) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("appCodes", appCodes);
        String statement = MAPPER_CLASS_NAME + ".deleteAppInfoByAppCodes";
        return (long) this.commonDao.delete(statement, parameter);
    }

    @Override
    public Integer deleteAppInfoByAppIds(List<Long> appIds) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("appIds", appIds);
        String statement = MAPPER_CLASS_NAME + ".deleteAppInfoByAppIds";
        return this.commonDao.delete(statement, parameter);
    }

    @Override
    public String updateAppInfo(AppInfoBean app) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("appId", app.getAppId());
        parameter.put("appCode", app.getAppCode());
        parameter.put("appName", app.getAppName());
        String errorMsg = null;
        AppInfoBean appInfoBean = getAppInfoByAppId(app.getSystemId(), app.getAppId(), null, null);
        if (!app.getAppCode().equals(appInfoBean.getAppCode())) {
            errorMsg = checkAppInfo(parameter);
            AssertUtil.assertEmpty(errorMsg, RestResultCode.CODE500.getCode(), errorMsg);
        }
        if (!app.getAppName().equals(appInfoBean.getAppName())) {
            errorMsg = checkAppInfo(parameter);
        }
        String statement = MAPPER_CLASS_NAME + ".updateAppInfo";
        long res = this.commonDao.update(statement, app);
        return res > 0 ? errorMsg : errorMsg;
    }
}
