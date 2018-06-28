package cn.faury.fwmf.module.api.category.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.category.bean.DiscusRCategoryBean;

import java.util.List;
import java.util.Map;

/**
 * 优惠、商品分类关联
 */
public interface DiscusRCategoryService {


    /**
     * 根据优惠ID获取相关联的商品分类信息
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
    public PageInfo<DiscusRCategoryBean> queryDiscusRCategoryByDiscusId(final Map<String, Object> parameter);

    /**
     * 根据优惠ID获取相关联的商品分类信息
     *
     * @param discusId
     *            优惠ID
     * @return
     */
    @Read
    public List<DiscusRCategoryBean> queryDiscusRCategoryByDiscusId(final Long discusId);

    /**
     * 插入优惠商品分类
     *
     * <pre>
     * 【必填】 List<DiscusRCategoryBean> list
     * </pre>
     *
     * @return
     */
    @Write
    public Integer insert(final List<DiscusRCategoryBean> list);

    /**
     * 删除优惠商品分类
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
     * 删除优惠商品分类
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
     * 删除优惠商品分类
     *
     * <pre>
     * 【必填】Long discusId 优惠ID
     * 【必填】List<Long> productCategoryIds 商品分类IDS
     * </pre>
     *
     * @return
     */
    @Write
    public Integer delByDiscusId(final Long discusId, final List<Long> productCategoryIds);

}
