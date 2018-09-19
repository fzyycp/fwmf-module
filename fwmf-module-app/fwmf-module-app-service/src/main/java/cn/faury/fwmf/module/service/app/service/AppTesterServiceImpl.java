package cn.faury.fwmf.module.service.app.service;


import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.app.bean.AppTesterBean;
import cn.faury.fwmf.module.api.app.service.AppTesterService;
import cn.faury.fwmf.module.service.app.mapper.AppTesterMapper;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现：APP测试用户信息表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了AppTesterService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class AppTesterServiceImpl extends CrudBaseServiceImpl<AppTesterBean, Long> implements AppTesterService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public AppTesterServiceImpl(CommonDao commonDao) {
        super(commonDao, AppTesterMapper.class);
    }

    @Override
    public PageInfo<AppTesterBean> queryAppTesterPage(Map<String, Object> parameters) {
        AssertUtil.assertNotNull(parameters, "查询参数不可以为空");
        AssertUtil.assertNotNull(parameters.get("appID"), "APP ID为空或不存在");
        String state = AppTesterMapper.class.getName() + ".queryAppTesterPage";

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appId", parameters.get("appId"));

        return this.commonDao.selectPage(state, param, PageParam.buildDefaultIns(parameters));
    }

    @Override
    public PageInfo<AppTesterBean> queryUNAppTesterPage(Map<String, Object> parameters) {
        AssertUtil.assertNotNull(parameters.get("appID"), "APP ID为空或不存在");

        String state = AppTesterMapper.class.getName() + ".queryUNAppTesterPage";

        Map<String, Object> param = new HashMap<>();
        param.put("appId", parameters.get("appId"));
        if (parameters.get("loginName") != null) {
            param.put("loginName", parameters.get("loginName"));
        }

        return this.commonDao.selectPage(state, param, PageParam.buildDefaultIns(parameters));
    }

    @Override
    public List<AppTesterBean> queryAppTesterPage(Long appId, List<Long> userIds) {
        AssertUtil.assertTrue(appId != null && appId > 0, "APP ID为空或不存在");

        String state = AppTesterMapper.class.getName() + ".queryAppTesterPage";
        Map<String, Object> param = new HashMap<>();
        param.put("appId", appId);
        if (userIds != null || userIds.size() > 0) {
            param.put("userIds", userIds);
        }

        return this.commonDao.selectList(state, param);
    }

    @Override
    public AppTesterBean getAppTesterByUserId(String appCode, Long userId) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");
        AssertUtil.assertNotEmpty(appCode, "APP编码为空或不存在");
        String state = AppTesterMapper.class.getName() + ".getAppTesterByUserId";
        Map<String, Object> param = new HashMap<>();
        param.put("appCode", appCode);
        param.put("userId", userId);

        return this.commonDao.selectOne(state, param);
    }

    @Override
    public int insertAppTester(List<AppTesterBean> list) {
        AssertUtil.assertNotEmpty(list, "保存数据不能为空");
        List<Long> userIds = new ArrayList<>();
        list.forEach(bean -> {
            AssertUtil.assertTrue(bean != null && bean.getAppId() > 0, "appId为空或不存在");
            AssertUtil.assertTrue(bean != null && bean.getUserId() > 0, "用户ID为空或不存在");
            AssertUtil.assertTrue(bean != null && bean.getSysId() > 0, "系统ID为空或不存在");
            AssertUtil.assertNotEmpty(bean.getLoginName(), "用户登录名为空或不存在");
            userIds.add(bean.getUserId());
        });

        List<AppTesterBean> beanList = queryAppTesterPage(list.get(0).getAppId(), userIds);
        if (beanList != null) {
            for (int i = 0; i < beanList.size(); i++) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (beanList.get(i).getUserId().equals(list.get(j))) {
                        list.remove(j);
                    }
                }
            }
        }

        String state = AppTesterMapper.class.getName() + ".insertAppTester";
        Map<String, Object> param = new HashMap<>();
        param.put("list", list);
        return this.commonDao.insert(state, param);
    }

    @Override
    public int delAppTester(List<Long> ids) {
        AssertUtil.assertNotEmpty(ids,"删除数据不能为空");
        ids.forEach(id->{
            AssertUtil.assertTrue(id!=null&&id>0,"删除主键为空或不存在");
        });
        String state = AppTesterMapper.class.getName() + ".delAppTester";
        Map<String, Object> param = new HashMap<>();
        param.put("ids", ids);
        return this.commonDao.delete(state, param);
    }
}
