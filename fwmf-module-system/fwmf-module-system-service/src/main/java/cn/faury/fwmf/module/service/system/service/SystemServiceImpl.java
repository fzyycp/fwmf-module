package cn.faury.fwmf.module.service.system.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.system.bean.SystemInfoBean;
import cn.faury.fwmf.module.api.system.service.SystemService;
import cn.faury.fwmf.module.service.system.mapper.SystemInfoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务系统服务提供者
 */
public class SystemServiceImpl implements SystemService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public SystemServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public SystemInfoBean getSystemInfoByCode(String systemCode, Boolean isAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "要查询的系统编码不可以为空");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemCode", systemCode);
        parameter.put("isAvailable", isAvailable);
        String state = SystemInfoMapper.class.getName() + ".getSystemInfoByCode";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public List<SystemInfoBean> querySystemInfo(SystemInfoBean systemInfo) {
        Map<String, Object> parameter = new HashMap<>();
        if (systemInfo != null) {
            if (systemInfo.getSystemId() != null) {
                parameter.put("systemId", systemInfo.getSystemId());
            }
            if (StringUtil.isNotEmpty(systemInfo.getSystemName())) {
                parameter.put("systemName", systemInfo.getSystemName());
            }
            if (StringUtil.isNotEmpty(systemInfo.getSystemCode())) {
                parameter.put("systemCode", systemInfo.getSystemCode());
            }
            if (StringUtil.isNotEmpty(systemInfo.getIsAvailable())) {
                parameter.put("isAvailable", systemInfo.getIsAvailable());
            }
        }

        String state = SystemInfoMapper.class.getName() + ".querySystemInfo";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public PageInfo<SystemInfoBean> querySystemInfoList(Map<String, Object> parameters) {
        String state = SystemInfoMapper.class.getName() + ".querySystemInfo";
        PageParam pageParam = PageParam.buildDefaultIns(parameters);

        Map<String, Object> param = new HashMap<>();
        SystemInfoBean systemInfo = (parameters != null) ? ((SystemInfoBean) parameters.get("systemInfoBean")) : null;
        if (systemInfo != null) {
            if (systemInfo.getSystemId() != null) {
                param.put("systemId", systemInfo.getSystemId());
            }
            if (StringUtil.isNotEmpty(systemInfo.getSystemName())) {
                param.put("systemName", systemInfo.getSystemName());
            }
            if (StringUtil.isNotEmpty(systemInfo.getSystemCode())) {
                param.put("systemCode", systemInfo.getSystemCode());
            }
            if (StringUtil.isNotEmpty(systemInfo.getIsAvailable())) {
                param.put("isAvailable", systemInfo.getIsAvailable());
            }
        }

        return this.commonDao.selectPage(state, param, pageParam);
    }

    @Override
    public Boolean isSystemInfoExistByName(String systemName, Boolean isAvailable) {
        Map<String, Object> parameter = new HashMap<>();

        if (StringUtil.isNotEmpty(systemName)) {
            parameter.put("systemName", systemName);
        }
        parameter.put("isAvailable", isAvailable);
        String state = SystemInfoMapper.class.getName() + ".getSystemInfoByName";

        int n = this.commonDao.selectOne(state, parameter);

        return n > 0;
    }

    @Override
    public Long insertSystemInfo(String systemName, String systemCode, String isAvailable) {
        AssertUtil.assertNotEmpty(systemName, "系统名称不可以为空");
        AssertUtil.assertNotEmpty(systemCode, "系统编码不可以为空");
        AssertUtil.assertNotEmpty(isAvailable, "是否可用不可以为空");
        // 输入参数验证
        // 验证业务系统code是否存在
        boolean exist = this.isSystemInfoExist(systemCode, null);
        AssertUtil.assertFalse(exist, String.format("业务系统编码[%s]已存在(包含未启用状态)",systemCode));
        // 验证业务系统名称是否存在
        exist = this.isSystemInfoExistByName(systemName, null);
        AssertUtil.assertFalse(exist, String.format("业务系统名称[%s]已存在(包含未启用状态)",systemName));

        SystemInfoBean systemInfo = new SystemInfoBean();
        systemInfo.setSystemName(systemName);
        systemInfo.setSystemCode(systemCode);
        systemInfo.setIsAvailable(isAvailable);
        String state = SystemInfoMapper.class.getName() + ".insertSystemInfo";
        int res = this.commonDao.insert(state, systemInfo);
        return res > 0 ? systemInfo.getSystemId() : -1L;
    }

    @Override
    public Boolean updateSystemInfoById(String systemName, String systemCode, String isAvailable, Long systemId) {
        // 输入参数验证
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不可为空");
        // 获取当前修改的业务系统
        SystemInfoBean oldInfo = this.getSystemInfoById(systemId, null);
        AssertUtil.assertNotNull(oldInfo, "当前修改的业务系统不存在(包含未启用状态)");
        // 修改业务系统名称则验证是否会重复
        if (StringUtil.isNotEmpty(systemName)) {
            // 修改了业务系统名称
            if (!systemName.equals(oldInfo.getSystemName())) {
                // 验证业务系统名称是否存在
                boolean exist = this.isSystemInfoExistByName(systemName, null);
                AssertUtil.assertFalse(exist, String.format("新的业务系统名称[%s]已存在(包含未启用状态)!", systemName));
            }
        }
        // 修改业务系统Code则验证是否会重复
        if (StringUtil.isNotEmpty(systemCode)) {
            // 修改了业务系统Code
            if (!systemCode.equals(oldInfo.getSystemCode())) {
                // 验证业务系统code是否存在
                boolean exist = this.isSystemInfoExist(systemCode, null);
                AssertUtil.assertFalse(exist, String.format("新的业务系统编码[%s]已存在(包含未启用状态)!", systemCode));
            }
        }

        // 验证通过
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemName", systemName);
        parameter.put("systemCode", systemCode);
        parameter.put("isAvailable", isAvailable);
        parameter.put("systemId", systemId);
        String state = SystemInfoMapper.class.getName() + ".updateSystemInfoById";
        int res = this.commonDao.update(state, parameter);
        return res > 0;
    }

    @Override
    public Boolean updateSystemInfoByCode(String systemName, String isAvailable, String systemCode) {
        // 输入参数验证
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不可为空");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemName", systemName);
        parameter.put("systemCode", systemCode);
        parameter.put("isAvailable", isAvailable);
        String state = SystemInfoMapper.class.getName() + ".updateSystemInfoByCode";
        int res = this.commonDao.update(state, parameter);
        return res > 0;
    }

    @Override
    public Boolean deleteSystemInfoById(Long systemId) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        String state = SystemInfoMapper.class.getName() + ".deleteSystemInfoById";
        int res = this.commonDao.update(state, parameter);
        return res > 0;
    }

    @Override
    public Boolean deleteSystemInfoByCode(String systemCode) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        String state = SystemInfoMapper.class.getName() + ".deleteSystemInfoByCode";
        int res = this.commonDao.update(state, parameter);
        return res > 0;
    }

}
