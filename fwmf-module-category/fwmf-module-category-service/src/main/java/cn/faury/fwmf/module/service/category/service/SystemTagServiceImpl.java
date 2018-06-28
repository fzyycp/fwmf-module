package cn.faury.fwmf.module.service.category.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.bean.SystemTagBean;
import cn.faury.fwmf.module.api.category.service.SystemTagService;
import cn.faury.fwmf.module.service.category.mapper.SystemTagMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统标签服务协议实现
 */
public class SystemTagServiceImpl implements SystemTagService {

    /**
     * 数据库操作DAO
     */
    protected CommonDao commonDao;

    public SystemTagServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public List<SystemTagBean> getAllSystemTagInfo() {
        String statement = SystemTagMapper.class.getName() + ".getAllSystemTagInfo";
        return commonDao.selectList(statement);
    }

    @Override
    public List<SystemTagBean> getSystemTagInfo(Long systemId) {
        AssertUtil.assertTrue(systemId != null && systemId >= 0, "系统ID为空或不存在");

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        String statement = SystemTagMapper.class.getName() + ".getSystemTagInfoBySystemId";
        return commonDao.selectList(statement, parameter);
    }

    @Override
    public List<SystemTagBean> getSystemTagInfo(String systemCode) {
        AssertUtil.assertNotEmpty(systemCode, "系统编码不可以为空");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemCode", systemCode);
        String statement = SystemTagMapper.class.getName() + ".getSystemTagInfoBySystemCode";
        return commonDao.selectList(statement, parameter);
    }

    @Override
    public List<SystemTagBean> getSystemTagInfo(String systemCode, Long tagId) {
        AssertUtil.assertNotEmpty(systemCode, "系统编码不可以为空");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemCode", systemCode);
        if (null != tagId) {
            parameter.put("tagId", tagId);
        }
        String statement = SystemTagMapper.class.getName() + ".getSystemTagInfoByCondition";
        return commonDao.selectList(statement, parameter);
    }

    @Override
    public Long saveSystemTagInfo(Long systemId, List<SystemTagBean> tagList) {
        AssertUtil.assertTrue(systemId != null && systemId >= 0, "系统ID为空或不存在");
        long res = this.deleteSystemTagInfo(systemId);
        if (tagList.size() > 0) {
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("systemId", systemId);
            parameter.put("tagList", tagList);
            String statement = SystemTagMapper.class.getName() + ".saveSystemTagInfo";
            res += (long) commonDao.insert(statement, parameter);
        }
        return res;
    }

    @Override
    public Long deleteSystemTagInfo(Long systemId) {
        AssertUtil.assertTrue(systemId != null && systemId >= 0, "系统ID为空或不存在");

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        String statement = SystemTagMapper.class.getName() + ".deleteSystemTagInfo";
        return (long) commonDao.insert(statement, parameter);
    }
}
