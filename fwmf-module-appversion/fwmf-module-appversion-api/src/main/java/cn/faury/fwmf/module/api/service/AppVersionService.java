package cn.faury.fwmf.module.api.service;


import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fwmf.module.api.bean.AppVersionBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * app版本发布
 */
public interface AppVersionService {

    /**
     * 查询最大版本号
     *
     * @param appCode  APP编码
     * @param sysType  客户端型号
     * @param isTester 是否测试用户
     * @return 版本号
     */
    @Read
    default public String getMaxVersionNum(final String appCode, final String sysType, final Boolean isTester){
        AssertUtil.assertNotEmpty(appCode,"app编码为空或不存在");
        AssertUtil.assertNotEmpty(sysType,"客户端型号为空或不存在");
        Map<String, Object> param = new HashMap<>();
        param.put("appCode", appCode);
        param.put("sysType", sysType);
        param.put("isTester", isTester);
        return getMaxVersionNum(param);
    }

    /**
     * 获取版本信息
     *
     * @param appCode    APP编码
     * @param sysType    客户端型号
     * @param versionNum 版本号
     * @return AppVersionBean
     */
    @Read
    public AppVersionBean getAppVersion(final String appCode, final String sysType, final String versionNum);

    /**
     * 获取系统下app版本信息（分页）
     *
     * @param parameters
     * @return
     */
    @Read
    public PageInfo<AppVersionBean> queryAppVersionPage(final Map<String, Object> parameters);

    /**
     * 获取系统下app版本信息
     *
     * @param parameters
     * @return
     */
    @Read
    public List<AppVersionBean> queryAppVersionList(final Map<String, Object> parameters);

    /**
     * 通过id查询app版本信息
     *
     * @param id 主键
     * @return AppVersionBean
     */
    @Read
    public AppVersionBean getAppVersionById(final Long id);

    /**
     * 获取最大版本号
     *
     * @param appId   appID
     * @param sysType 操作系统
     * @return
     */
    @Read
    default public String getMaxVersionNum(final Long appId, final String sysType) {
        AssertUtil.assertTrue(appId != null && appId > 0,"appID为空或不存在");
        AssertUtil.assertNotEmpty(sysType,"客户端型号为空或不存在");
        Map<String, Object> param = new HashMap<>();
        param.put("appId", appId);
        param.put("sysType", sysType);
        return getMaxVersionNum(param);
    }

    /**
     * 获取最大版本号
     *
     * @param param <pre>
     *              Long appId/String appCode
     *              String sysType
     *              </pre>
     * @return
     */
    @Read
    public String getMaxVersionNum(final Map<String, Object> param);

    /**
     * 插入app版本信息
     * <p>
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
     *
     * @param bean
     * @return id主键
     */
    @Write
    public Long insertAppVersion(final AppVersionBean bean);

    /**
     * 更新app版本信息
     * <p>
     * <pre>
     * 【必填】Long id 主键
     * 【可选】String sysType 客户端类型
     * 【可选】String versionNum 版本号
     * 【可选】String urlType 连接类型
     * 【可选】String path 下载地址
     * 【可选】String title 文件名称
     * 【可选】Long sysId 业务系统ID
     * 【可选】Long appId APP的ID
     * 【可选】String isCoercion 是否强制更新
     * 【可选】String isFormal 是否正式版本
     * 【可选】String memo 备注
     * 【必填】Long updatePerson 更新人
     * 【必填】String updatePersonName 更新姓名
     * 【可选】String delFlag 删除标志
     * </pre>
     *
     * @param bean
     * @return 成功次数
     */
    @Write
    public int updateAppVersion(final AppVersionBean bean);

    /**
     * 删除app版本信息
     *
     * @param ids
     * @return 成功次数
     */
    @Write
    public int delAppVersion(final List<Long> ids);

    /**
     * 逻辑删除app历史版本信息
     *
     * @param ids
     * @return 成功次数
     */
    @Write
    default public int logicDelAppVersion(final List<Long> ids){

        return delAppVersion(ids);
    }

    /**
     * 删除app版本信息(物理删除)
     *
     * @param ids
     * @return 成功次数
     */
    @Write
    public int DeleteAppVersion(final List<Long> ids);
}
