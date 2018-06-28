package cn.faury.fwmf.module.api.category.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.category.bean.RedRCategoryBean;

import java.util.List;
import java.util.Map;

/**
 * 红包、商品分类关联
 */
public interface RedRCategoryService {

    /**
     * 根据红包ID获取相关联的商品分类信息
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
    public PageInfo<RedRCategoryBean> queryRedRCategoryByRedId(final Map<String, Object> parameter);

    /**
     * 根据红包ID获取相关联的商品分类信息
     *
     * @param redId
     *            红包ID
     * @return
     */
    @Read
    public List<RedRCategoryBean> queryRedRCategoryByRedId(final Long redId);

    /**
     * 插入红包商品分类
     *
     * <pre>
     * 【必填】 List<RedRCategoryBean> list
     * </pre>
     *
     * @return
     */
    @Write
    public Integer insert(final List<RedRCategoryBean> list);

    /**
     * 删除红包商品分类
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
     * 删除红包商品分类
     *
     * <pre>
     * 【必填】List<Long> redId 红包ID
     * </pre>
     *
     * @return
     */
    @Write
    public Integer delByRedId(final List<Long> redIds);

    /**
     * 删除红包商品分类
     *
     * <pre>
     * 【必填】Long redId 红包ID
     * 【必填】List<Long> productCategoryIds 商品分类IDS
     * </pre>
     *
     * @return
     */
    @Write
    public Integer delByRedId(final Long redId, final List<Long> productCategoryIds);


}
