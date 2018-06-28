package cn.faury.fwmf.module.api.system.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.system.bean.SystemInfoBean;

import java.util.List;
import java.util.Map;

/**
 * 业务系统服务协议
 */
public interface SystemService {

    /**
     * 根据业务系统CODE获取业务系统信息
     *
     * @param systemCode  业务系统ID
     * @param isAvailable 是否可用
     * @return 业务系统信息对象
     */
    @Read
    public SystemInfoBean getSystemInfoByCode(final String systemCode, final Boolean isAvailable);

    /**
     * 根据业务系统编码验证业务系统信息是否存在
     *
     * @param systemCode  业务系统编码
     * @param isAvailable 是否可用
     * @return 业务系统信息对象
     */
    @Read
    default public Boolean isSystemInfoExistByCode(final String systemCode, final Boolean isAvailable) {
        return (getSystemInfoByCode(systemCode, isAvailable) != null);
    }

    /**
     * 根据业务系统名称验证业务系统信息是否存在
     *
     * @param systemName  业务系统名称
     * @param isAvailable 是否可用
     * @return 业务系统信息对象
     */
    @Read
    public Boolean isSystemInfoExistByName(final String systemName, final Boolean isAvailable);

	/* ====================重载==================== */

    /**
     * 根据业务系统CODE获取【可用的】业务系统信息
     *
     * @param systemCode 业务系统ID
     * @return 业务系统信息对象
     */
    @Read
    default public SystemInfoBean getSystemInfoByCode(final String systemCode) {
        return getSystemInfoByCode(systemCode, Boolean.TRUE);
    }

    /**
     * 根据业务系统编码验证业务系统信息是否存在，只验证启用状态的
     *
     * @param systemCode 业务系统编码
     * @return 业务系统信息对象
     */
    @Read
    default public Boolean isSystemInfoExistByCode(final String systemCode) {
        return isSystemInfoExistByCode(systemCode, Boolean.TRUE);
    }

    /**
     * 根据业务系统名称验证业务系统信息是否存在，只验证启用状态的
     *
     * @param systemName 业务系统名称
     * @return 业务系统信息对象
     */
    @Read
    default public Boolean isSystemInfoExistByName(final String systemName) {
        return isSystemInfoExistByName(systemName, Boolean.TRUE);
    }

	/* ==========part1:以下为需要读权限的服务接口========== */

    /**
     * 查询业务系统信息
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【可选】Long systemId 业务系统ID
     * 【可选】String systemName 业务系统名称
     * 【可选】String systemCode 业务系统编码
     * 【可选】String isAvailable 是否可用
     * </pre>
     *
     * @param systemInfo 查询对象
     * @return 查询结果
     */
    @Read
    public List<SystemInfoBean> querySystemInfo(final SystemInfoBean systemInfo);

    /**
     * 查询业务系统信息=======分页
     * <p>
     * <pre>
     * 可能出现的参数：
     * 【可选】Long systemId 业务系统ID
     * 【可选】String systemName 业务系统名称
     * 【可选】String systemCode 业务系统编码
     * 【可选】String isAvailable 是否可用
     * </pre>
     *
     * @param parameters 查询参数
     * @return 查询结果
     */
    @Read
    public PageInfo<SystemInfoBean> querySystemInfoList(final Map<String, Object> parameters);

	/* ==========part2:以下为需要写权限的服务接口========== */

    /**
     * 新增业务系统信息
     *
     * @param systemName  业务系统名称
     * @param systemCode  业务系统编码
     * @param isAvailable 是否可用
     * @return 保存成功后业务系统对象ID，失败则返回-1
     */
    @Write
    public Long insertSystemInfo(final String systemName, final String systemCode, final String isAvailable);

    /**
     * 根据业务系统ID更新业务系统信息
     *
     * @param systemName  业务系统名称
     * @param systemCode  业务系统编码
     * @param isAvailable 是否可用
     * @param systemId    业务系统ID
     * @return 是否更新成功
     */
    @Write
    public Boolean updateSystemInfoById(final String systemName, final String systemCode, final String isAvailable,
                                        final Long systemId);

    /**
     * 根据业务系统Code更新业务系统名称或者是否可用状态
     *
     * @param systemName  业务系统名称
     * @param isAvailable 是否可用
     * @param systemCode  业务系统编码
     * @return 是否更新成功
     */
    @Write
    public Boolean updateSystemInfoByCode(final String systemName, final String isAvailable, final String systemCode);

    /**
     * 根据业务系统ID删除业务系统信息
     * <p>
     * <pre>
     * 	<b>逻辑删除</b>:将系统<b>是否可用</b>改为<b>否</b>即可
     * </pre>
     *
     * @param systemId 业务系统ID
     * @return 是否删除成功
     */
    @Write
    public Boolean deleteSystemInfoById(final Long systemId);

    /**
     * 根据业务系统Code删除业务系统信息
     * <p>
     * <pre>
     * 	<b>逻辑删除</b>:将系统<b>是否可用</b>改为<b>否</b>即可
     * </pre>
     *
     * @param systemCode 业务系统Code
     * @return 是否删除成功
     */
    @Write
    public Boolean deleteSystemInfoByCode(final String systemCode);

	/* ====================重载==================== */

    /**
     * 根据业务系统ID获取业务系统信息
     *
     * @param systemId    业务系统ID
     * @param isAvailable 是否可用
     * @return 业务系统信息对象
     */
    @Read
    default public SystemInfoBean getSystemInfoById(final Long systemId, final Boolean isAvailable) {
        SystemInfoBean q = new SystemInfoBean();
        // 业务系统ID参数
        q.setSystemId(systemId);

        // 是否可用参数
        if (isAvailable != null) {
            if (isAvailable.booleanValue()) {
                q.setIsAvailable("Y");
            } else {
                q.setIsAvailable("N");
            }
        }

        // 执行查询
        List<SystemInfoBean> result = querySystemInfo(q);

        return (result != null && result.size() > 0) ? result.get(0) : null;
    }

    /**
     * 根据业务系统ID获取【可用的】业务系统信息
     *
     * @param systemId 业务系统ID
     * @return 业务系统信息对象
     */
    @Read
    default public SystemInfoBean getSystemInfoById(final Long systemId) {
        return getSystemInfoById(systemId, Boolean.TRUE);
    }

    /**
     * 根据业务系统ID验证业务系统信息是否存在
     *
     * @param systemId    业务系统ID
     * @param isAvailable 是否可用
     * @return 业务系统信息对象
     */
    @Read
    default public Boolean isSystemInfoExist(final Long systemId, final Boolean isAvailable) {
        return (getSystemInfoById(systemId, isAvailable) != null);
    }

    /**
     * 根据业务系统Code验证业务系统信息是否存在
     *
     * @param systemCode  业务系统Code
     * @param isAvailable 是否可用
     * @return 业务系统信息对象
     */
    @Read
    default public Boolean isSystemInfoExist(final String systemCode, final Boolean isAvailable) {
        return (getSystemInfoByCode(systemCode, isAvailable) != null);
    }

}
