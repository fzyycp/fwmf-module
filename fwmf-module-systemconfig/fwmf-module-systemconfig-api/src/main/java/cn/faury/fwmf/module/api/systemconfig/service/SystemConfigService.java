package cn.faury.fwmf.module.api.systemconfig.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.systemconfig.bean.SystemConfigInfoBean;

import java.util.Arrays;
import java.util.List;

/**
 * 系统参数配置服务协议
 */
public interface SystemConfigService {

    /**
     * 查询系统参数配置信息，该方法默认查询包含全局信息如需不包含查询
     * <p>
     * <pre>
     * 	【可选】：systemConfigId 		如果该参数没有值则传null
     * 	【可选】：systemConfigKey 	如果该参数没有值则传null或者""
     * 	【可选】：systemConfigValue 	如果该参数没有值则传null或者""
     * 	【可选】：isAvailable 		如果该参数没有值则传null或者""
     * </pre>
     *
     * @param instance 系统参数配置查询对象
     * @return 系统参数配置信息列表以<b>List</b>展示
     */
    @Read
    default public List<SystemConfigInfoBean> querySystemConfigInfo(final SystemConfigInfoBean instance) {
        return querySystemConfigInfo(instance, Boolean.TRUE);
    }

    /**
     * 根据系统code、系统参数配置key、是否使用全局、系统是否可用、系统参数配置是否可用获取系统参数配置详情列表信息
     *
     * @param systemCode           【必选】所对应业务系统code
     * @param systemConfigKey      【可选】<i>该参数如果传入null或""则表示不使用该参数，默认根据<b>systemCode</b>
     *                             执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal         【可选】是否使用全局 TRUE为使用，FALSE为不使用
     * @param isSysAvailable       【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
     * @param isSysConfigAvailable 【可选】系统配置参数是否可用，TRUE为可用，FALSE为不可用
     * @return 系统参数配置详情列表信息以<b>List</b>展示
     */
    @Read
    public List<SystemConfigInfoBean> getSystemConfigInfoList(final String systemCode, final String systemConfigKey,
                                                              final Boolean isWithGlobal, final Boolean isSysAvailable, final Boolean isSysConfigAvailable);

    /**
     * 查询系统参数配置信息 该方法默认查询包含全局信息
     * <p>
     * <pre>
     * 	【可选】：systemConfigId 		如果该参数没有值则传null
     * 	【可选】：systemConfigKey 	如果该参数没有值则传null或者""
     * 	【可选】：systemConfigValue 	如果该参数没有值则传null或者""
     * 	【可选】：isAvailable 		如果该参数没有值则传null或者""
     *  【可选】：isWithGlobal		TRUE为使用，FALSE为不使用
     * </pre>
     *
     * @param instance     系统参数配置查询对象
     * @param isWithGlobal 【可选】是否使用全局 TRUE为使用，FALSE为不使用
     * @return 系统参数配置信息列表以<b>List</b>展示
     */
    @Read
    public List<SystemConfigInfoBean> querySystemConfigInfo(final SystemConfigInfoBean instance, final Boolean isWithGlobal);

    /**
     * 根据系统code、系统参数配置key获取系统参数配置信息
     *
     * @param systemCode      【必选】系统code
     * @param systemConfigKey 【必选】系统参数配置key
     * @return 系统参数配置信息
     */
    @Read
    default public SystemConfigInfoBean getSystemConfigInfoByKey(final String systemCode, final String systemConfigKey) {
        return this.getSystemConfigInfoByKey(systemCode, systemConfigKey, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据系统code获取系统参数配置列表信息
     *
     * @param systemCode 【必选】系统code
     * @return 系统参数配置信息列表以<b>List</b>展示
     */
    @Read
    default public List<SystemConfigInfoBean> getSystemConfigInfoByCode(final String systemCode) {
        return this.getSystemConfigInfoList(systemCode, (Long) null, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据系统code、系统参数配置key、是否使用全局获取系统参数配置详情列表信息
     *
     * @param systemCode      【必选】所对应业务系统code
     * @param systemConfigKey 【可选】<i>该参数如果传入null或""则表示不使用该参数，默认根据<b>systemCode</b>
     *                        执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal    【可选】是否使用全局
     * @return 系统参数配置详情列表信息以<b>List</b>展示
     */
    @Read
    default public List<SystemConfigInfoBean> getSystemConfigInfoList(final String systemCode, final String systemConfigKey,
                                                                      final Boolean isWithGlobal) {
        return getSystemConfigInfoList(systemCode, systemConfigKey, isWithGlobal, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据系统code、系统参数配置key、是否使用全局、系统是否可用、系统参数配置是否可用获取系统参数配置信息
     *
     * @param systemCode           【必选】所对应业务系统code
     * @param systemConfigKey      【可选】<i>该参数如果传入null或""则表示不使用该参数，默认根据<b>systemCode</b>
     *                             执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal         【可选】是否使用全局
     * @param isSysAvailable       【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
     * @param isSysConfigAvailable 【可选】系统配置参数是否可用，TRUE为可用，FALSE为不可用
     * @return 系统参数配置信息
     */
    @Read
    default public SystemConfigInfoBean getSystemConfigInfoByKey(final String systemCode, final String systemConfigKey,
                                                                 final Boolean isWithGlobal, final Boolean isSysAvailable, final Boolean isSysConfigAvailable) {
        List<SystemConfigInfoBean> resList = getSystemConfigInfoList(systemCode, systemConfigKey, isWithGlobal,
                isSysAvailable, isSysConfigAvailable);
        if (resList.size() > 0) {
            return resList.get(0);
        }
        return null;
    }

    /**
     * 根据系统code、系统参数配置ID、是否使用全局、系统是否可用、系统参数配置是否可用获取系统参数配置信息
     *
     * @param systemCode           【必选】所对应业务系统code
     * @param systemConfigId       【可选】<i>该参数如果传入null则表示不使用该参数，默认根据<b>systemId</b>
     *                             执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal         【可选】是否使用全局
     * @param isSysAvailable       【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
     * @param isSysConfigAvailable 【可选】系统配置参数是否可用，TRUE为可用，FALSE为不可用
     * @return 系统参数配置信息
     */
    @Read
    default public SystemConfigInfoBean getSystemConfigInfoById(final String systemCode, final Long systemConfigId,
                                                                final Boolean isWithGlobal, final Boolean isSysAvailable, final Boolean isSysConfigAvailable) {
        List<SystemConfigInfoBean> resList = getSystemConfigInfoList(systemCode, systemConfigId, isWithGlobal,
                isSysAvailable, isSysConfigAvailable);
        if (resList.size() > 0) {
            return resList.get(0);
        }
        return null;
    }

    /**
     * 根据系统Key获取全局系统参数配置信息
     *
     * @param systemConfigKey 系统参数配置key
     * @return
     */
    @Read
    default public SystemConfigInfoBean getGlobalSystemConfigInfoByKey(final String systemConfigKey) {
        return getGlobalSystemConfigInfoByKey(systemConfigKey, Boolean.TRUE);
    }

    /**
     * 根据系统参数配置key、系统参数配置是否可用获取全局系统参数配置信息
     *
     * @param systemConfigKey      系统参数配置key
     * @param isSysConfigAvailable 系统参数配置是否可用 TRUE为可用，FALSE为不可用
     * @return 系统参数配置信息对象
     */
    @Read
    public SystemConfigInfoBean getGlobalSystemConfigInfoByKey(final String systemConfigKey,
                                                               final Boolean isSysConfigAvailable);

    /**
     * 获取全局系统中参数配置列表信息
     *
     * @return 系统参数配置详情列表信息以<b>List</b>展示
     */
    @Read
    default public List<SystemConfigInfoBean> getGlobalSystemConfigInfoList() {
        return getGlobalSystemConfigInfoList(Boolean.TRUE);
    }

    /**
     * 根据系统参数配置是否可用获取全局系统中参数配置列表信息
     *
     * @param isSysConfigAvailable 系统参数配置是否可用 TRUE为可用，FALSE为不可用
     * @return 系统参数配置详情列表信息以<b>List</b>展示
     */
    @Read
    public List<SystemConfigInfoBean> getGlobalSystemConfigInfoList(final Boolean isSysConfigAvailable);


	/* ==========part1:以下为需要读权限的服务接口========== */

    /**
     * 根据系统ID、系统参数配置ID、是否使用全局、系统是否可用、系统参数配置是否可用获取系统参数配置详情列表信息
     *
     * @param systemId             【必选】所对应业务系统ID
     * @param systemConfigId       【可选】<i>该参数如果传入null则表示不使用该参数，默认根据<b>systemId</b>
     *                             执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal         【可选】是否使用全局 TRUE为使用，FALSE为不使用
     * @param isSysAvailable       【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
     * @param isSysConfigAvailable 【可选】系统配置参数是否可用，TRUE为可用，FALSE为不可用
     * @return 系统参数配置详情列表信息以<b>List</b>展示
     */
    @Read
    public List<SystemConfigInfoBean> getSystemConfigInfoList(final Long systemId, final Long systemConfigId,
                                                              final Boolean isWithGlobal, final Boolean isSysAvailable, final Boolean isSysConfigAvailable);

    /**
     * 根据系统ID、系统参数配置key、是否使用全局、系统是否可用、系统参数配置是否可用获取系统参数配置详情列表信息
     *
     * @param systemId             【必选】所对应业务系统ID
     * @param systemConfigKey      【可选】<i>该参数如果传入null或""则表示不使用该参数，默认根据<b>systemId</b>
     *                             执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal         【可选】是否使用全局 TRUE为使用，FALSE为不使用
     * @param isSysAvailable       【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
     * @param isSysConfigAvailable 【可选】系统配置参数是否可用，TRUE为可用，FALSE为不可用
     * @return 系统参数配置详情列表信息以<b>List</b>展示
     */
    @Read
    public List<SystemConfigInfoBean> getSystemConfigInfoList(final Long systemId, final String systemConfigKey,
                                                              final Boolean isWithGlobal, final Boolean isSysAvailable, final Boolean isSysConfigAvailable);

    /**
     * 根据系统code、系统参数配置ID、是否使用全局、系统是否可用、系统参数配置是否可用获取系统参数配置详情列表信息
     *
     * @param systemCode           【必选】所对应业务系统code
     * @param systemConfigId       【可选】<i>该参数如果传入null则表示不使用该参数，默认根据<b>systemCode</b>
     *                             执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal         【可选】是否使用全局 TRUE为使用，FALSE为不使用
     * @param isSysAvailable       【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
     * @param isSysConfigAvailable 【可选】系统配置参数是否可用，TRUE为可用，FALSE为不可用
     * @return 系统参数配置详情列表信息以<b>List</b>展示
     */
    @Read
    public List<SystemConfigInfoBean> getSystemConfigInfoList(final String systemCode, final Long systemConfigId,
                                                              final Boolean isWithGlobal, final Boolean isSysAvailable, final Boolean isSysConfigAvailable);

    // ====================================【对象】

    /**
     * 根据系统参数配置ID获取系统参数配置信息
     *
     * @param systemConfigId 系统参数配置ID
     * @return 系统参数配置对象
     */
    @Read
    public SystemConfigInfoBean getSystemConfigInfoById(final Long systemConfigId);

    /**
     * 根据所属系统ID获取系统参数配置信息列表
     *
     * @param systemConfigSystemId 所属系统ID
     * @return 系统参数配置对象集合
     */
    @Read
    default public List<SystemConfigInfoBean> getSystemConfigInfoBySystemId(final Long systemConfigSystemId) {
        return this.getSystemConfigInfoList(systemConfigSystemId, (Long) null, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 获取所有系统参数配置信息列表
     *
     * @return 所有系统参数配置列表信息
     */
    @Read
    default public List<SystemConfigInfoBean> getAllSystemConfigInfo(){
        return querySystemConfigInfo(null);
    }

    /**
     * 新增或修改时检查系统参数KEY是否重复
     *
     * @param systemConfigSystemId 系统ID
     * @param systemConfigKey      系统参数KEY
     * @return 是否重复
     */
    @Read
    public Boolean checkExistSystemConfigInfo(final Long systemConfigSystemId, final String systemConfigKey);

	/* ==========part2:以下为需要写权限的服务接口========== */

    /**
     * 新增系统参数配置信息
     * <p>
     * <pre>
     *  		参数：<br />
     * 	 systemConfigKey:系统参数配置信息key<br />
     *      systemConfigValue:系统参数配置信息value<br />
     *      systemConfigSystemId:业务系统Id<br />
     *      isAvailable:系统参数配置信息是否可用<br />
     * </pre>
     *
     * @param instance 系统参数配置对象
     * @return 保存成功后返回系统参数配置对象ID，失败则返回-1
     */
    @Write
    public Long insertSystemConfigInfo(final SystemConfigInfoBean instance);

    /**
     * 【物理删除】根据系统参数配置ID删除系统参数配置信息
     *
     * @param systemConfigId 系统参数配置ID
     * @return 返回删除count数 大于0表示删除成功
     */
    @Write
    default public Integer deleteSystemConfigInfoById(final Long systemConfigId) {
        return this.deleteSystemConfigInfoByIds(Arrays.asList(systemConfigId));
    }

    /**
     * 【物理删除】根据系统参数配置ID批量删除系统参数配置信息
     *
     * @param systemConfigIds 系统参数配置ID
     * @return 返回删除count数 大于0表示删除成功
     */
    @Write
    public Integer deleteSystemConfigInfoByIds(final List<Long> systemConfigIds);

    /**
     * 根据【systemConfigId】<br />
     * 修改【systemConfigKey、systemConfigValue、isAvailable】 系统参数配置信息
     *
     * @param systemConfigId    系统参数配置ID
     * @param systemConfigKey   系统参数配置KEY
     * @param systemConfigValue 系统参数配置VALUE
     * @param systemConfigDesc  使用说明
     * @param isAvailable       是否可用
     * @return 是否修改成功
     */
    @Write
    public Boolean updateSystemConfigInfoById(final Long systemConfigId, final String systemConfigKey,
                                              final String systemConfigValue, final String systemConfigDesc, final String isAvailable);

    /**
     * 根据【systemConfigSystemId、systemConfigKey】<br />
     * 修改【systemConfigValue、isAvailable】 系统参数配置信息
     *
     * @param systemConfigSystemId 所属系统ID
     * @param systemConfigKey      系统参数配置KEY
     * @param systemConfigValue    系统参数配置VALUE
     * @param systemConfigDesc     使用说明
     * @param isAvailable          是否可用
     * @return 是否修改成功
     */
    @Write
    public Boolean updateSystemConfigInfoByKey(final String systemConfigSystemId, final String systemConfigKey,
                                               final String systemConfigValue, final String systemConfigDesc, final String isAvailable);

    // =======================================【重载】==========================================、、

    /**
     * 根据系统ID、系统参数配置ID、是否使用全局、系统是否可用、系统参数配置是否可用获取系统参数配置信息
     *
     * @param systemId             【必选】所对应业务系统code
     * @param systemConfigId       【可选】<i>该参数如果传入null则表示不使用该参数，默认根据<b>systemId</b>
     *                             执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal         【可选】是否使用全局
     * @param isSysAvailable       【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
     * @param isSysConfigAvailable 【可选】系统配置参数是否可用，TRUE为可用，FALSE为不可用
     * @return 系统参数配置信息
     */
    @Read
    default public SystemConfigInfoBean getSystemConfigInfoById(final Long systemId, final Long systemConfigId,
                                                                final Boolean isWithGlobal, final Boolean isSysAvailable, final Boolean isSysConfigAvailable) {
        List<SystemConfigInfoBean> resList = getSystemConfigInfoList(systemId, systemConfigId, isWithGlobal,
                isSysAvailable, isSysConfigAvailable);
        if (resList.size() > 0) {
            return resList.get(0);
        }
        return null;
    }

    /**
     * 根据系统ID、系统参数配置key、是否使用全局、系统是否可用、系统参数配置是否可用获取系统参数配置信息
     *
     * @param systemId             【必选】所对应业务系统ID
     * @param systemConfigKey      【可选】<i>该参数如果传入null或""则表示不使用该参数，默认根据<b>systemId</b>
     *                             执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal         【可选】是否使用全局
     * @param isSysAvailable       【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
     * @param isSysConfigAvailable 【可选】系统配置参数是否可用，TRUE为可用，FALSE为不可用
     * @return 系统参数配置信息
     */
    @Read
    default public SystemConfigInfoBean getSystemConfigInfoByKey(final Long systemId, final String systemConfigKey,
                                                                 final Boolean isWithGlobal, final Boolean isSysAvailable, final Boolean isSysConfigAvailable) {
        List<SystemConfigInfoBean> resList = getSystemConfigInfoList(systemId, systemConfigKey, isWithGlobal,
                isSysAvailable, isSysConfigAvailable);
        if (resList.size() > 0) {
            return resList.get(0);
        }
        return null;
    }

    /**
     * 根据系统ID、系统参数配置key、是否使用全局获取系统参数配置详情列表信息
     *
     * @param systemId        【必选】所对应业务系统ID
     * @param systemConfigKey 【可选】<i>该参数如果传入null或""则表示不使用该参数，默认根据<b>systemId</b>
     *                        执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal    【可选】是否使用全局
     * @return 系统参数配置详情列表信息以<b>List</b>展示
     */
    @Read
    default public List<SystemConfigInfoBean> getSystemConfigInfoList(final Long systemId, final String systemConfigKey,
                                                                      final Boolean isWithGlobal) {
        return getSystemConfigInfoList(systemId, systemConfigKey, isWithGlobal, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据系统code、系统参数配置ID、是否使用全局获取系统参数配置详情列表信息
     *
     * @param systemCode     【必选】所对应业务系统code
     * @param systemConfigId 【可选】<i>该参数如果传入null则表示不使用该参数，默认根据<b>systemCode</b>
     *                       执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal   【可选】是否使用全局
     * @return 系统参数配置详情列表信息以<b>List</b>展示
     */
    @Read
    default public List<SystemConfigInfoBean> getSystemConfigInfoList(final String systemCode, final Long systemConfigId,
                                                                      final Boolean isWithGlobal) {
        return getSystemConfigInfoList(systemCode, systemConfigId, isWithGlobal, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据系统id、系统参数配置ID、是否使用全局获取系统参数配置详情列表信息
     *
     * @param systemId       【必选】所对应业务系统id
     * @param systemConfigId 【可选】<i>该参数如果传入null则表示不使用该参数，默认根据<b>systemCode</b>
     *                       执行查询所有系统参数配置详情列表信息 </i>
     * @param isWithGlobal   【可选】是否使用全局
     * @return 系统参数配置详情列表信息以<b>List</b>展示
     */
    @Read
    default public List<SystemConfigInfoBean> getSystemConfigInfoList(Long systemId, Long systemConfigId, Boolean isWithGlobal) {
        return getSystemConfigInfoList(systemId, systemConfigId, isWithGlobal, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据系统Id获取系统参数配置列表信息
     *
     * @param systemId 【必选】 系统ID
     * @return 系统参数配置信息列表以<b>List</b>展示
     */
    @Read
    default public List<SystemConfigInfoBean> getSystemConfigInfoListById(final Long systemId) {
        return this.getSystemConfigInfoList(systemId, (Long) null, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据系统ID、系统参数配置ID获取系统参数配置信息
     *
     * @param systemId       【必选】系统ID
     * @param systemConfigId 【必选】系统参数配置ID
     * @return 系统参数配置信息
     */
    @Read
    default public SystemConfigInfoBean getSystemConfigInfoById(final Long systemId, final Long systemConfigId) {
        return this.getSystemConfigInfoById(systemId, systemConfigId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据系统ID、系统参数配置key获取系统参数配置信息
     *
     * @param systemId        【必选】系统ID
     * @param systemConfigKey 【必选】系统参数配置key
     * @return 系统参数配置信息
     */
    @Read
    default public SystemConfigInfoBean getSystemConfigInfoByKey(final Long systemId, final String systemConfigKey) {
        return this.getSystemConfigInfoByKey(systemId, systemConfigKey, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据系统code、系统参数配置ID获取系统参数配置信息
     *
     * @param systemCode     【必选】系统code
     * @param systemConfigId 【必选】 系统参数配置ID
     * @return 系统参数配置信息
     */
    @Read
    default public SystemConfigInfoBean getSystemConfigInfoById(final String systemCode, final Long systemConfigId) {
        return this.getSystemConfigInfoById(systemCode, systemConfigId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

}
