package cn.faury.fwmf.module.service.systemconfig.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.systemconfig.bean.SystemConfigInfoBean;
import cn.faury.fwmf.module.api.systemconfig.service.SystemConfigService;
import cn.faury.fwmf.module.service.systemconfig.mapper.SystemConfigMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统参数配置提供者
 */
public class SystemConfigServiceImpl implements SystemConfigService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public SystemConfigServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public List<SystemConfigInfoBean> getSystemConfigInfoList(Long systemId, Long systemConfigId, Boolean isWithGlobal,
                                                              Boolean isSysAvailable, Boolean isSysConfigAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不合法");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        parameter.put("systemConfigId", systemConfigId);
        parameter.put("isWithGlobal", isWithGlobal);
        parameter.put("isSysAvailable", isSysAvailable);
        parameter.put("isSysConfigAvailable", isSysConfigAvailable);
        String statement = SystemConfigMapper.class.getName() + ".getSystemConfigInfoList";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<SystemConfigInfoBean> getSystemConfigInfoList(String systemCode, String systemConfigKey,
                                                              Boolean isWithGlobal, Boolean isSysAvailable, Boolean isSysConfigAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不可以为空");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemCode", systemCode);
        parameter.put("systemConfigKey", systemConfigKey);
        parameter.put("isWithGlobal", isWithGlobal);
        parameter.put("isSysAvailable", isSysAvailable);
        parameter.put("isSysConfigAvailable", isSysConfigAvailable);
        String statement = SystemConfigMapper.class.getName() + ".getSystemConfigInfoList";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<SystemConfigInfoBean> getSystemConfigInfoList(Long systemId, String systemConfigKey,
                                                              Boolean isWithGlobal, Boolean isSysAvailable, Boolean isSysConfigAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不合法");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        parameter.put("systemConfigKey", systemConfigKey);
        parameter.put("isWithGlobal", isWithGlobal);
        parameter.put("isSysAvailable", isSysAvailable);
        parameter.put("isSysConfigAvailable", isSysConfigAvailable);
        String statement = SystemConfigMapper.class.getName() + ".getSystemConfigInfoList";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<SystemConfigInfoBean> getSystemConfigInfoList(String systemCode, Long systemConfigId,
                                                              Boolean isWithGlobal, Boolean isSysAvailable, Boolean isSysConfigAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不可以为空");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemCode", systemCode);
        parameter.put("systemConfigId", systemConfigId);
        parameter.put("isWithGlobal", isWithGlobal);
        parameter.put("isSysAvailable", isSysAvailable);
        parameter.put("isSysConfigAvailable", isSysConfigAvailable);
        String statement = SystemConfigMapper.class.getName() + ".getSystemConfigInfoList";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<SystemConfigInfoBean> getGlobalSystemConfigInfoList(Boolean isSysConfigAvailable) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("isSysConfigAvailable", isSysConfigAvailable);
        String statement = SystemConfigMapper.class.getName() + ".getGlobalSystemConfigInfoList";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public SystemConfigInfoBean getGlobalSystemConfigInfoByKey(String systemConfigKey, Boolean isSysConfigAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemConfigKey", systemConfigKey);
        parameter.put("isSysConfigAvailable", isSysConfigAvailable);
        String statement = SystemConfigMapper.class.getName() + ".getGlobalSystemConfigInfoByKey";
        return this.commonDao.selectOne(statement, parameter);
    }

    @Override
    public List<SystemConfigInfoBean> querySystemConfigInfo(SystemConfigInfoBean instance, Boolean isWithGlobal) {
        Map<String, Object> parameter = new HashMap<>();
        if (instance != null) {
            // 系统参数配置ID
            if (instance.getSystemConfigId() != null) {
                parameter.put("systemConfigId", instance.getSystemConfigId());
            }
            // 系统参数配置ID
            if (instance.getSystemConfigSystemId() != null) {
                parameter.put("systemConfigSystemId", instance.getSystemConfigSystemId());
            }
            // 系统参数配置KEY
            if (StringUtil.isNotEmpty(instance.getSystemConfigKey())) {
                parameter.put("systemConfigKey", instance.getSystemConfigKey());
            }
            // 系统参数配置Value
            if (StringUtil.isNotEmpty(instance.getSystemConfigValue())) {
                parameter.put("systemConfigValue", instance.getSystemConfigValue());
            }
            // 系统参数配置【是否可用】
            if (StringUtil.isNotEmpty(instance.getIsAvailable())) {
                parameter.put("isAvailable", instance.getIsAvailable());
            }
        }
        // 系统参数配置【是否可用】
        if (null != isWithGlobal) {
            parameter.put("isWithGlobal", isWithGlobal);
        }
        String statement = SystemConfigMapper.class.getName() + ".querySystemConfigInfo";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public SystemConfigInfoBean getSystemConfigInfoById(Long systemConfigId) {
        AssertUtil.assertTrue(systemConfigId != null && systemConfigId > 0, "配置参数ID不合法");
        Map<String, Object> parameter = new HashMap<>();
        // 系统参数配置ID
        parameter.put("systemConfigId", systemConfigId);
        String statement = SystemConfigMapper.class.getName() + ".getSystemConfigInfoById";
        return this.commonDao.selectOne(statement, parameter);
    }

    @Override
    public Boolean checkExistSystemConfigInfo(final Long systemConfigSystemId, final String systemConfigKey) {
        SystemConfigInfoBean instance = new SystemConfigInfoBean();
        instance.setSystemConfigSystemId(systemConfigSystemId);
        instance.setSystemConfigKey(systemConfigKey);
        List<SystemConfigInfoBean> resList = checkSystemConfigInfo(instance);
        if (resList.size() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    @Override
    public Long insertSystemConfigInfo(SystemConfigInfoBean instance) {
        boolean exist = checkExistSystemConfigInfo(instance.getSystemConfigSystemId(), instance.getSystemConfigKey());
        AssertUtil.assertFalse(exist,"全局系统或该系统已经存在了一个相同的参数键：" + instance.getSystemConfigKey());
        String statement = SystemConfigMapper.class.getName() + ".insertSystemConfigInfo";
        int res = this.commonDao.insert(statement, instance);
        return res > 0 ? instance.getSystemConfigId() : -1L;
    }

    @Override
    public Integer deleteSystemConfigInfoByIds(List<Long> systemConfigIds) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemConfigId", systemConfigIds);
        String statement = SystemConfigMapper.class.getName() + ".deleteCodeInfoByCodeIds";
        int res = this.commonDao.delete(statement, parameter);
        return res;
    }

    @Override
    public Boolean updateSystemConfigInfoById(Long systemConfigId, String systemConfigKey, String systemConfigValue,
                                              final String systemConfigDesc, String isAvailable) {
        Long systemConfigSystemId = null;
        // 1.先通过systemConfigId 查询该对象
        SystemConfigInfoBean resBean = getSystemConfigInfoById(systemConfigId);
        if (null != resBean) {
            systemConfigSystemId = resBean.getSystemConfigSystemId();
            if (!resBean.getSystemConfigKey().equals(systemConfigKey)) {
                boolean exist = checkExistSystemConfigInfo(systemConfigSystemId, systemConfigKey);
                AssertUtil.assertFalse(exist,"全局系统或该系统已经存在了一个相同的参数键：" + systemConfigKey);
            }
        }
        Map<String, Object> parameter = new HashMap<String, Object>();
        if (systemConfigId != null) {
            parameter.put("systemConfigId", systemConfigId);
        }
        if (StringUtil.isNotEmpty(systemConfigKey)) {
            parameter.put("systemConfigKey", systemConfigKey);
        }
        if (StringUtil.isNotEmpty(systemConfigValue)) {
            parameter.put("systemConfigValue", systemConfigValue);
        }
        if (StringUtil.isNotEmpty(systemConfigDesc)) {
            parameter.put("systemConfigDesc", systemConfigDesc);
        }
        if (StringUtil.isNotEmpty(isAvailable)) {
            parameter.put("isAvailable", isAvailable);
        }
        String statement = SystemConfigMapper.class.getName() + ".updateSystemConfigInfoById";
        int res = this.commonDao.update(statement, parameter);
        return res > 0;
    }

    @Override
    public Boolean updateSystemConfigInfoByKey(String systemConfigSystemId, String systemConfigKey,
                                               String systemConfigValue, final String systemConfigDesc, String isAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        if (systemConfigSystemId != null) {
            parameter.put("systemConfigSystemId", systemConfigSystemId);
        }
        if (StringUtil.isNotEmpty(systemConfigKey)) {
            parameter.put("systemConfigKey", systemConfigKey);
        }
        if (StringUtil.isNotEmpty(systemConfigValue)) {
            parameter.put("systemConfigValue", systemConfigValue);
        }
        if (StringUtil.isNotEmpty(systemConfigDesc)) {
            parameter.put("systemConfigDesc", systemConfigDesc);
        }
        if (StringUtil.isNotEmpty(isAvailable)) {
            parameter.put("isAvailable", isAvailable);
        }
        String statement = SystemConfigMapper.class.getName() + ".updateSystemConfigInfoByKey";
        int res = this.commonDao.update(statement, parameter);
        return res > 0;
    }

    private List<SystemConfigInfoBean> checkSystemConfigInfo(SystemConfigInfoBean instance) {
        Map<String, Object> parameter = new HashMap<>();
        if (instance!=null) {
            // 系统参数配置ID
            if (instance.getSystemConfigId() != null) {
                parameter.put("systemConfigId", instance.getSystemConfigId());
            }
            // 系统参数配置ID
            if (instance.getSystemConfigSystemId() != null) {
                parameter.put("systemConfigSystemId", instance.getSystemConfigSystemId());
            }
            // 系统参数配置KEY
            if (StringUtil.isNotEmpty(instance.getSystemConfigKey())) {
                parameter.put("systemConfigKey", instance.getSystemConfigKey());
            }
            // 系统参数配置Value
            if (StringUtil.isNotEmpty(instance.getSystemConfigValue())) {
                parameter.put("systemConfigValue", instance.getSystemConfigValue());
            }
            // 系统参数配置【是否可用】
            if (StringUtil.isNotEmpty(instance.getIsAvailable())) {
                parameter.put("isAvailable", instance.getIsAvailable());
            }
        }
        String statement = SystemConfigMapper.class.getName() + ".checkSystemConfigInfo";
        return this.commonDao.selectList(statement, parameter);
    }
}
