package cn.faury.fwmf.module.api.user.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.user.bean.RedRUserGroupsBean;

import java.util.List;
import java.util.Map;

/**
 * 红包、用户组关联
 */
public interface RedRUserGroupsService {

    /**
     * 根据红包ID获取相关联的用户组信息
     *
     * <pre>
     * 【必填】 Long redId 红包ID
     * 【必填】int page 第几页
     * 【必填】 int rows 每一页条数
     * </pre>
     *
     * @return
     */
    @Read
    public PageInfo<RedRUserGroupsBean> queryRedRUserGroupsByRedId(final Map<String, Object> parameter);

    /**
     * 根据红包ID获取<b>未</b>关联的用户组信息
     *
     * <pre>
     * 【可选】 Long redId 红包ID
     * 【必填】 Long systemId 系统ID
     * 【必填】int page 第几页
     * 【必填】 int rows 每一页条数
     * </pre>
     *
     * @return
     */
    @Read
    public PageInfo<RedRUserGroupsBean> queryRedUnRUserGroupsByRedId(final Map<String, Object> parameter);

    /**
     * 插入红包用户群
     *
     * <pre>
     * 【必填】 List<RedRUserGroupsBean> list
     * </pre>
     *
     * @return
     */
    @Write
    public Integer insert(final List<RedRUserGroupsBean> list);

    /**
     * 删除红包用户群
     *
     * <pre>
     * 【必填】 List<Long> ids 主键
     * </pre>
     *
     * @return
     */
    @Write
    public Integer delByIds(final List<Long> ids);

    /**
     * 删除红包用户群
     *
     * <pre>
     * 【必填】List<Long> RedId 红包ID
     * </pre>
     *
     * @return
     */
    @Write
    public Integer delByRedId(final List<Long> redIds);

    /**
     * 删除红包用户群
     *
     * <pre>
     * 【必填】Long redId 红包ID
     * 【必填】List<Long> groupIds 用户群IDS
     * </pre>
     *
     * @return
     */
    @Write
    public Integer delByRedId(final Long redId, final List<Long> groupIds);

}
