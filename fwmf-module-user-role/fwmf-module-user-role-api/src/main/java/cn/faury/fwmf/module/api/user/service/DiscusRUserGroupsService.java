package cn.faury.fwmf.module.api.user.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.user.bean.DiscusRUserGroupsBean;

import java.util.List;
import java.util.Map;

/**
 * 优惠、用户组关联
 */
public interface DiscusRUserGroupsService {

    /**
     * 根据优惠ID获取相关联的用户组信息
     *
     * <pre>
     * 【必填】 Long discusId 优惠ID
     * 【必填】int page 第几页
     * 【必填】 int rows 每一页条数
     * </pre>
     *
     * @return
     */
    @Read
    public PageInfo<DiscusRUserGroupsBean> queryDiscusRUserGroupsByDiscusId(final Map<String, Object> parameter);

    /**
     * 根据优惠ID获取<b>未</b>关联的用户组信息
     *
     * <pre>
     * 【可选】 Long discusId 优惠ID
     * 【必填】 Long systemId 系统ID
     * 【必填】int page 第几页
     * 【必填】 int rows 每一页条数
     * </pre>
     *
     * @return
     */
    @Read
    public PageInfo<DiscusRUserGroupsBean> queryDiscusUnRUserGroupsByDiscusId(final Map<String, Object> parameter);

    /**
     * 插入优惠用户群
     *
     * <pre>
     * 【必填】 List<DiscusRUserGroupsBean> list
     * </pre>
     *
     * @return
     */
    @Write
    public Integer insert(final List<DiscusRUserGroupsBean> list);

    /**
     * 删除优惠用户群
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
     * 删除优惠用户群
     *
     * <pre>
     * 【必填】List<Long> discusId 优惠ID
     * </pre>
     *
     * @return
     */
    @Write
    public Integer delByDiscusId(final List<Long> discusIds);

    /**
     * 删除优惠用户群
     *
     * <pre>
     * 【必填】Long discusId 优惠ID
     * 【必填】List<Long> groupIds 用户群IDS
     * </pre>
     *
     * @return
     */
    @Write
    public Integer delByDiscusId(final Long discusId, final List<Long> groupIds);

}
