package cn.faury.fwmf.module.api.system.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.system.bean.ShopRSystemInfoBean;

import java.util.List;


/**
 * 商店授权业务系统服务协议
 */
public interface ShopRSystemService {


    /**
     * 插入商店授权业务系统对象
     * <p>
     * <pre>
     * 仅使用以下字段：
     * 【必填】Long shopId：商店ID
     * 【必填】Long systemId：业务系统ID
     * 其他字段都不使用
     * </pre>
     *
     * @param shopRSystems 商店授权业务系统信息
     * @return 成功插入条数
     */
    @Write
    public Integer insertShopRSystem(final List<ShopRSystemInfoBean> shopRSystems);


    /**
     * 获取商店授权业务系统信息
     *
     * @param shopIds           多个商店ID
     * @param isSystemAvailable 业务系统是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
     * @return 授权的业务系统列表
     */
    @Read
    public List<ShopRSystemInfoBean> getShopRSystemInfoList(final List<Long> shopIds, final Boolean isSystemAvailable);

    /**
     * 获取商店授权业务系统信息，仅查询可用状态的业务系统
     *
     * @param shopIds 多个商店ID
     * @return 授权的业务系统列表
     */
    @Read
    default public List<ShopRSystemInfoBean> getShopRSystemInfoList(final List<Long> shopIds) {
        return getShopRSystemInfoList(shopIds, null);
    }

    /**
     * 获取用户所在商店授权业务系统信息
     *
     * @param userId            用户ID
     * @param isSystemAvailable 业务系统是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
     * @return 商店授权业务系统列表
     */
    @Read
    public List<ShopRSystemInfoBean> getShopRSystemInfoListByUserId(final Long userId, final Boolean isSystemAvailable);

    /**
     * 获取用户所在商店授权业务系统信息，仅查询可用状态的业务系统
     *
     * @param userId 用户ID
     * @return 商店授权业务系统列表
     */
    @Read
    default public List<ShopRSystemInfoBean> getShopRSystemInfoListByUserId(final Long userId) {
        return getShopRSystemInfoListByUserId(userId, Boolean.TRUE);
    }


    /**
     * 获取商店授权业务系统信息（多个业务系统信息合并）
     * <p>
     * <pre>
     * 如果查询结果不需要合并业务系统，则使用{@link #getShopRSystemInfoList(List, Boolean)}
     * </pre>
     *
     * @param shopIds           多个商店ID
     * @param isSystemAvailable 业务系统是否可用【TRUE：可用状态，FALSE：不可用状态，null：所有状态】
     * @return 授权的业务系统列表
     */
    @Read
    public List<ShopRSystemInfoBean> getShopRSystemInfoListWithConcat(final List<Long> shopIds,
                                                                      final Boolean isSystemAvailable);

    /**
     * 修改商店系统授权（删除+新增）
     *
     * @param addSystemIds 新增的系统授权IDs
     * @param delSystemIds 删除的系统授权IDs
     * @param shopId       商店ID
     * @return
     */
    public Integer updateShopRSystem(final List<Long> addSystemIds, final List<Long> delSystemIds, final Long shopId);

    /**
     * 根据商店授权业务系统对象ID删除商店授权关系
     *
     * @param ids 多个唯一主键ID
     * @return 成功删除的条数
     */
    @Write
    public Integer deleteShopRSystemById(final List<Long> ids);

    /**
     * 根据商店ID删除商店所有授权业务系统关系
     *
     * @param shopIds 多个商店ID
     * @return 成功删除条数
     */
    @Write
    public Integer deleteShopRSystemByShopId(final List<Long> shopIds);

    /**
     * 根据商店ID、多个业务系统ID删除商店授权业务系统关系
     *
     * @param systemIds 多个业务系统的ID
     * @param shopId    商店ID
     * @return 成功删除条数
     */
    @Write
    public Integer deleteShopRSystemByShopId(final List<Long> systemIds, final Long shopId);

	/* ====================重载==================== */

    /**
     * 获取商店授权业务系统信息（多个业务系统信息合并），仅查询可用状态的业务系统
     *
     * @param shopIds 多个商店ID
     * @return 授权的业务系统列表
     * @see #getshopRSystemInfoListWithConcat(List, Boolean)
     */
    @Read
    default public List<ShopRSystemInfoBean> getShopRSystemInfoListWithConcat(final List<Long> shopIds) {
        return getShopRSystemInfoListWithConcat(shopIds, null);
    }

}
