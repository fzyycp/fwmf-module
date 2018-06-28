package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.exception.TipsException;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.user.bean.UserAgentInfoBean;
import cn.faury.fwmf.module.api.user.service.UserAgentService;
import cn.faury.fwmf.module.service.user.mapper.UserAgentMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户代理人服务提供者
 */
public class UserAgentServiceImpl implements UserAgentService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public UserAgentServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public List<UserAgentInfoBean> queryUserAgentInfo(UserAgentInfoBean userAgentInfo) {
        String state = UserAgentMapper.class.getName() + ".queryUserAgentInfo";
        Map<String, Object> parameter = new HashMap<>();
        if (userAgentInfo != null) {
            if (userAgentInfo.getId() != null && !userAgentInfo.getId().equals(0L)) {
                parameter.put("id", userAgentInfo.getId());
            }
            if (userAgentInfo.getUserId() != null && !userAgentInfo.getUserId().equals(0L)) {
                parameter.put("userId", userAgentInfo.getUserId());
            }
            if (userAgentInfo.getAgentUserId() != null && !userAgentInfo.getAgentUserId().equals(0L)) {
                parameter.put("agentUserId", userAgentInfo.getAgentUserId());
            }
            if (userAgentInfo.getOsId() != null && !userAgentInfo.getOsId().equals(0L)) {
                parameter.put("osId", userAgentInfo.getOsId());
            }
            if (StringUtil.isNotEmpty(userAgentInfo.getOsType())) {
                parameter.put("osType", userAgentInfo.getOsType());
            }
            if (StringUtil.isNotEmpty(userAgentInfo.getIsAvailable())) {
                parameter.put("isAvailable", userAgentInfo.getIsAvailable());
            }
        }
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public PageInfo<UserAgentInfoBean> queryUserUnAgentInfo(final Map<String, Object> parameters) {
        AssertUtil.assertNotNull(parameters.get("userId"), "被代理人ID错误");
        AssertUtil.assertNotNull(parameters.get("osId"), "系统ID错误");

        String state = UserAgentMapper.class.getName() + ".queryUserUnAgentInfo";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", parameters.get("userId"));
        param.put("osId", parameters.get("osId"));
        if (StringUtil.isNotEmpty((String) parameters.get("userName"))) {
            param.put("userName", parameters.get("userName"));
        }

        return this.commonDao.selectPage(state, param, PageParam.buildDefaultIns(parameters));
    }

    @Override
    public UserAgentInfoBean getUserAgentInfoById(Long id) {
        AssertUtil.assertTrue(id != null && id > 0, "唯一主键ID错误");
        String state = UserAgentMapper.class.getName() + ".getUserAgentInfoById";
        return this.commonDao.selectOne(state, id);
    }

    @Override
    public List<UserAgentInfoBean> getUserAgentInfoByUserId(Long userId) {
        AssertUtil.assertTrue(userId != null && userId > 0, "被代理用户ID错误");
        String state = UserAgentMapper.class.getName() + ".queryUserAgentInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userId);
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<UserAgentInfoBean> getUserAgentInfoByAgentUserId(Long agentUserId) {
        AssertUtil.assertTrue(agentUserId != null && agentUserId > 0, "代理用户ID错误");
        String state = UserAgentMapper.class.getName() + ".queryUserAgentInfo";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("agentUserId", agentUserId);
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public Long insertUserAgentInfo(UserAgentInfoBean userAgentInfo) {
        AssertUtil.assertTrue(userAgentInfo.getUserId() != null && userAgentInfo.getUserId() > 0, "被代理人ID错误");
        AssertUtil.assertTrue(userAgentInfo.getAgentUserId() != null && userAgentInfo.getAgentUserId() > 0, "代理人ID错误");
        AssertUtil.assertTrue(userAgentInfo.getOsId() != null && userAgentInfo.getOsId() > 0, "业务系统ID错误");
        AssertUtil.assertNotEmpty(userAgentInfo.getOsType(), "新增内容系统类型不能为空");
        AssertUtil.assertNotEmpty(userAgentInfo.getIsAvailable(), "新增内容isAvailable不能为空");
        String state = UserAgentMapper.class.getName() + ".insertUserAgentInfo";

        List<UserAgentInfoBean> userAgentList = queryUserAgentInfo(userAgentInfo);
        if (userAgentList.size() > 0) {
            throw new TipsException(RestResultCode.CODE500.getCode(), "存在重复代理人，请重新选择");
        }
        int res = this.commonDao.insert(state, userAgentInfo);
        return res > 0 ? userAgentInfo.getId() : -1;
    }

    @Override
    public Long updateUserAgentInfo(UserAgentInfoBean userAgentInfo) {
        AssertUtil.assertTrue(userAgentInfo.getId() != null && userAgentInfo.getId() > 0, "唯一主键错误");
        String state = UserAgentMapper.class.getName() + ".updateUserAgentInfo";
        AssertUtil.assertNotEmpty(userAgentInfo.getIsAvailable(), "修改内容isAvailable不能为空");
        return (Long) (long) this.commonDao.update(state, userAgentInfo);
    }

    @Override
    public Integer deleteUserAgentInfoById(List<Long> ids) {
        AssertUtil.assertNotEmpty(ids,"唯一主键ID错误");
        String state = UserAgentMapper.class.getName() + ".deleteUserAgentInfoById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("ids", ids);
        return this.commonDao.delete(state, parameter);
    }

    @Override
    public Integer deleteUserAgentInfoByUserId(List<Long> userIds) {
        AssertUtil.assertNotEmpty(userIds,"被代理人ID错误");
        String state = UserAgentMapper.class.getName() + ".deleteUserAgentInfoByUserId";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userIds", userIds);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    @Override
    public Integer deleteUserAgentInfoByUserId(List<Long> agentUserIds, Long userId) {
        AssertUtil.assertNotEmpty(agentUserIds,"代理人ID错误");
        AssertUtil.assertTrue(userId!=null&&userId>0,"用户ID错误");
        String state = UserAgentMapper.class.getName() + ".deleteUserAgentInfoByUserId";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("agentUserIds", agentUserIds);
        parameter.put("userId", userId);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

}
