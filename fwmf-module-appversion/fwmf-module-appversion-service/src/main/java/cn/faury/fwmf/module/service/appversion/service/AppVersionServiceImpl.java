package cn.faury.fwmf.module.service.appversion.service;


import cn.faury.fdk.common.anotation.service.CanReadWrite;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.common.utils.VersionUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.bean.AppVersionBean;
import cn.faury.fwmf.module.api.service.AppVersionService;
import cn.faury.fwmf.module.service.appversion.mapper.AppVersionMapper;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CanReadWrite
public class AppVersionServiceImpl implements AppVersionService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public AppVersionServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public PageInfo<AppVersionBean> queryAppVersionPage(Map<String, Object> parameters) {
        AssertUtil.assertNotNull(parameters, "查询参数不可以为空");
        AssertUtil.assertNotNull(parameters.get("sysid"), "系统ID不可以为空");
        String state = AppVersionMapper.class.getName() + ".queryAppVersionList";

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("sysId", parameters.get("sysId"));
        if (StringUtil.isNotEmpty((String) parameters.get("sysType"))) {
            param.put("sysType", parameters.get("sysType"));
        }

        return this.commonDao.selectPage(state, param, PageParam.buildDefaultIns(parameters));
    }

    @Override
    public List<AppVersionBean> queryAppVersionList(Map<String, Object> parameters) {
        String state = AppVersionMapper.class.getName() + ".queryAppVersionList";
        AssertUtil.assertNotNull(parameters.get("sysId"), "系统id为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("sysId", parameters.get("sysId"));

        if (StringUtil.isNotEmpty((String) parameters.get("appId"))) {
            param.put("appId", parameters.get("appId"));
        }
        if (StringUtil.isNotEmpty((String) parameters.get("sysType"))) {
            param.put("sysType", parameters.get("sysType"));
        }

        return this.commonDao.selectList(state, param);
    }

    @Override
    public AppVersionBean getAppVersionById(Long id) {
        AssertUtil.assertTrue(id != null && id > 0, "版本id错误");
        Map<String, Object> param = new HashMap<>();
        param.put("id", id);
        String state = AppVersionMapper.class.getName() + ".getAppVersion";
        return this.commonDao.selectOne(state, param);
    }

    @Override
    public String getMaxVersionNum(Map<String, Object> param) {
        String state = AppVersionMapper.class.getName() + ".getVersionNums";
        List<String> appVersions = this.commonDao.selectList(state, param);
        if (appVersions.size() > 0) {
            return Collections.max(appVersions, (o1, o2) -> VersionUtil.compareVersionNo(o1, o2) > 0 ? 1 : -1);
        } else {
            return "0.0";
        }
    }

    @Override
    public AppVersionBean getAppVersion(String appCode, String sysType, String versionNum) {
        AssertUtil.assertNotEmpty(appCode,"APP编码为空或不存在");
        AssertUtil.assertNotEmpty(sysType,"操作系统为空或不存在");
        AssertUtil.assertNotEmpty(versionNum,"版本号为空或不存在");
        Map<String, Object> param = new HashMap<>();
        param.put("appCode", appCode);
        param.put("sysType", sysType);
        param.put("versionNum", versionNum);

        String state = AppVersionMapper.class.getName() + ".getAppVersion";
        return this.commonDao.selectOne(state, param);
    }

    /**
     * <pre>
     * 【必填】String sysType 客户端类型
     * 【必填】String versionNum 版本号
     * 【必填】String urlType 连接类型
     * 【必填】String path 下载地址
     * 【可选】String title 文件名称
     * 【必填】Long sysId 业务系统ID
     * 【必填】Long appId APP的ID
     * 【必填】String isCoercion 是否强制更新
     * 【必填】String isFormal 是否正式版本
     * 【可选】String memo 备注
     * 【必填】Long createPerson 创建人
     * 【必填】String createPersonName 创建人姓名
     * 【必填】Long updatePerson 更新人
     * 【必填】String updatePersonName 更新姓名
     * </pre>
     */
    @Override
    public Long insertAppVersion(AppVersionBean bean) {
        String state = AppVersionMapper.class.getName() + ".insertAppVersion";
        AssertUtil.assertNotEmpty(bean.getSysType(), "客户端类型为空或不存在");
        AssertUtil.assertNotEmpty(bean.getVersionNum(), "版本号为空或不存在");
        AssertUtil.assertNotEmpty(bean.getUrlType(), "连接类型为空或不存在");
        AssertUtil.assertNotEmpty(bean.getPath(), "下载地址为空或不存在");
        AssertUtil.assertTrue(bean.getSysId() != null && bean.getSysId() > 0, "业务系统ID为空或不存在");
        AssertUtil.assertTrue(bean.getAppId() != null && bean.getAppId() > 0, "APPID为空或不存在");
        AssertUtil.assertNotEmpty(bean.getIsCoercion(), "是否强制更新为空或不存在");
        AssertUtil.assertNotEmpty(bean.getIsFormal(), "是否正式版本为空或不存在");
        AssertUtil.assertTrue(bean.getCreatePerson() != null && bean.getCreatePerson() > 0, "创建人为空或不存在");
        AssertUtil.assertNotEmpty(bean.getCreatePersonName(), "创建人姓名为空或不存在");
        AssertUtil.assertTrue(bean.getUpdatePerson() != null && bean.getUpdatePerson() > 0, "更新人为空或不存在");
        AssertUtil.assertNotEmpty(bean.getUpdatePersonName(), "更新姓名为空或不存在！");
        AssertUtil.assertTrue(VersionUtil.isVersionNo(bean.getVersionNum()), "版本号格式不合法");
        AssertUtil.assertFalse(VersionUtil.compareVersionNo(getMaxVersionNum(bean.getAppId(), bean.getSysType()), bean.getVersionNum()) > 0, "版本号小于或等于最新版本号，请重新输入");
        int res = this.commonDao.insert(state, bean);
        return res > 0 ? bean.getId() : -1L;
    }

    @Override
    public int updateAppVersion(AppVersionBean bean) {
        AssertUtil.assertNotNull(bean, "版本信息不可以为空");
        AssertUtil.assertTrue(bean.getId() != null && bean.getId() > 0, "版本ID为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", bean.getId());
        if (StringUtil.isNotEmpty(bean.getSysType())) {
            param.put("sysType", bean.getSysType());
        }
        if (StringUtil.isNotEmpty(bean.getVersionNum())) {
            param.put("versionNum", bean.getVersionNum());
        }
        if (StringUtil.isNotEmpty(bean.getUrlType())) {
            param.put("urlType", bean.getUrlType());
        }
        if (StringUtil.isNotEmpty(bean.getPath())) {
            param.put("path", bean.getPath());
        }
        if (StringUtil.isNotEmpty(bean.getTitle())) {
            param.put("title", bean.getTitle());
        }
        if (StringUtil.isNotEmpty(bean.getMemo())) {
            param.put("memo", bean.getMemo());
        }
        if (bean.getSysId() != null && bean.getSysId() > 0) {
            param.put("sysId", bean.getSysId());
        }
        if (bean.getAppId() != null && bean.getAppId() > 0) {
            param.put("appId", bean.getAppId());
        }
        if (StringUtil.isNotEmpty(bean.getIsCoercion())) {
            param.put("isCoercion", bean.getIsCoercion());
        }
        if (StringUtil.isNotEmpty(bean.getIsFormal())) {
            param.put("isFormal", bean.getIsFormal());
        }

        if (bean.getUpdatePerson() != null && bean.getUpdatePerson() > 0) {
            param.put("updatePerson", bean.getUpdatePerson());
        }
        if (StringUtil.isNotEmpty(bean.getUpdatePersonName())) {
            param.put("updatePersonName", bean.getUpdatePersonName());
        }
        if (StringUtil.isNotEmpty(bean.getIdentifier())) {
            param.put("identifier", bean.getIdentifier());
        }
        String state = AppVersionMapper.class.getName() + ".updateAppVersion";
        return this.commonDao.update(state, param);
    }

    @Override
    public int delAppVersion(List<Long> ids) {
        String state = AppVersionMapper.class.getName() + ".delAppVersion";
        AssertUtil.assertNotEmpty(ids, "删除数据为空或不存在");
        Map<String, Object> param = new HashMap<>();
        param.put("ids", ids);
        return this.commonDao.delete(state, param);
    }

    @Override
    public int DeleteAppVersion(List<Long> ids) {
        String state = AppVersionMapper.class.getName() + ".DeleteAppVersion";
        AssertUtil.assertNotEmpty(ids, "删除数据为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ids", ids);
        return this.commonDao.delete(state, param);
    }

}
