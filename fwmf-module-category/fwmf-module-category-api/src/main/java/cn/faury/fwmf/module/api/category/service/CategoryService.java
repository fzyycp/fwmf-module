package cn.faury.fwmf.module.api.category.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fwmf.module.api.category.bean.CategoryInfoBean;
import cn.faury.fwmf.module.api.category.bean.CategoryTreeNodeBean;

import java.util.List;
import java.util.Map;

/**
 * 分类服务接口
 */
public interface CategoryService {

    /**
     * 根据分类ID获取所有<b>未删除</b>子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>所有</i></b>子分类；
     * 分类以<b><i>List</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId 分类ID
     * @return 分类树
     */
    public List<CategoryInfoBean> getCategoryAllChildListByCategoryId(final Long categoryId);

    /**
     * 根据分类ID获取所有子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>所有</i></b>子分类；
     * 分类以<b><i>List</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId   分类ID
     * @param isDeleteFlag 是否删除【true:是 false：否 null：全部】
     * @return 分类树
     */
    public List<CategoryInfoBean> getCategoryAllChildListByCategoryId(final Long categoryId, final Boolean isDeleteFlag);

    /**
     * 根据分类ID获取所有<b>未删除</b>子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>所有</i></b>子分类；
     * 分类以<b><i>Tree</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId 分类ID
     * @return 分类树
     */
    public List<CategoryTreeNodeBean> getCategoryAllChildTreeByCategoryId(final Long categoryId);

    /**
     * 根据分类ID获取所有子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>所有</i></b>子分类；
     * 分类以<b><i>Tree</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId   分类ID
     * @param isDeleteFlag 是否删除【true:是 false：否 null：全部】
     * @return 分类树
     */
    public List<CategoryTreeNodeBean> getCategoryAllChildTreeByCategoryId(final Long categoryId,
                                                                          final Boolean isDeleteFlag);

    /**
     * 根据分类ID获取<b>未删除</b>分类信息对象
     *
     * @param categoryId 分类ID
     * @return 分类信息对象
     */
    public CategoryInfoBean getCategoryInfoByCategoryId(final Long categoryId);

    /**
     * 根据多个分类ID获取<b>未删除</b>分类信息对象
     *
     * @param categoryId 分类ID
     * @return 分类信息对象
     */
    public List<CategoryInfoBean> getCategoryInfoByCategoryId(final List<Long> categoryId);

    /**
     * 根据分类ID获取分类信息对象
     *
     * @param categoryId   分类ID
     * @param isDeleteFlag 是否删除【true:是 false：否 null：全部】
     * @return 分类信息对象
     */
    public CategoryInfoBean getCategoryInfoByCategoryId(final Long categoryId, final Boolean isDeleteFlag);

    /**
     * 根据多个分类ID获取分类信息对象
     *
     * @param categoryId   分类ID
     * @param isDeleteFlag 是否删除【true:是 false：否 null：全部】
     * @return 分类信息对象
     */
    public List<CategoryInfoBean> getCategoryInfoByCategoryId(final List<Long> categoryId, final Boolean isDeleteFlag);

    /**
     * 根据分类ID获取第一层<b>未删除</b>子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一层</i></b>子分类；
     * 分类以<b><i>List</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId 分类ID
     * @return 分类树
     */
    public List<CategoryInfoBean> getCategoryOneChildListByCategoryId(final Long categoryId);

    /**
     * 根据分类ID获取第一层子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一层</i></b>子分类；
     * 分类以<b><i>List</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId   分类ID
     * @param isDeleteFlag 是否删除【true:是 false：否 null：全部】
     * @return 分类树
     */
    public List<CategoryInfoBean> getCategoryOneChildListByCategoryId(final Long categoryId, final Boolean isDeleteFlag);

    /**
     * 根据分类ID获取第一、二层<b>未删除</b>子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一、二层</i></b>子分类；
     * 分类以<b><i>Tree</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId 分类ID
     * @return 分类树
     */
    public List<CategoryTreeNodeBean> getCategoryTwoChildTreeByCategoryId(final Long categoryId);

    /**
     * 根据分类ID获取第一、二层子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一、二层</i></b>子分类；
     * 分类以<b><i>Tree</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId   分类ID
     * @param isDeleteFlag 是否删除【true:是 false：否 null：全部】
     * @return 分类树
     */
    public List<CategoryTreeNodeBean> getCategoryTwoChildTreeByCategoryId(final Long categoryId,
                                                                          final Boolean isDeleteFlag);

    /**
     * 根据分类ID获取第一层子分类树
     * <p>
     * <pre>
     * <b>(不包含已删除)</b>
     * 获取分类ID下<b>第一层</b>子分类；
     * 分类以<b>List</b>返回；
     * </pre>
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【必填】用途ID
     * @param systemCode 【必填】系统code
     * @return List
     */
    @Read
    public default List<CategoryInfoBean> getCategoryOneChildListByCategoryId(final Long categoryId, final Long templateId,
                                                                              final String systemCode) {
        AssertUtil.assertNotNull(categoryId, "分类ID为空或不存在");
        AssertUtil.assertTrue(templateId != null && templateId > 0, "用途为空或不存在");
        AssertUtil.assertNotEmpty(systemCode, "系统code为空或不存在");
        return queryCategoryOneChildListWithoutDelByCategoryId(categoryId, templateId, systemCode);
    }

    /**
     * 根据分类ID获取第一、二层子分类树
     * <p>
     * <pre>
     * <b>(不包含已删除)</b>
     * 获取分类ID下<b>第一、二层</b>子分类；
     * 分类以<b>List树形结构</b>返回；
     * </pre>
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【必填】用途ID
     * @param systemCode 【必填】系统code
     * @return List<CategoryTreeNodeBean> 树型
     */
    @Read
    public default List<CategoryTreeNodeBean> getCategoryTwoChildTreeByCategoryId(final Long categoryId, final Long templateId,
                                                                                  final String systemCode) {
        AssertUtil.assertNotNull(categoryId, "分类ID为空或不存在");
        AssertUtil.assertTrue(templateId != null && templateId > 0, "用途为空或不存在");
        AssertUtil.assertNotEmpty(systemCode, "系统code为空或不存在");
        return queryCategoryTwoChildTreeWithoutDelByCategoryId(categoryId, templateId, systemCode);
    }

    /**
     * 根据分类ID获取所有子分类
     * <p>
     * <pre>
     * <b>(不包含：已删除)</b>
     * 获取分类ID下<b>所有</b>子分类；
     * 分类以<b>List</b>的形式返回；
     * </pre>
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【必填】用途ID
     * @param systemCode 【必填】系统code
     * @return List<CategoryInfoBean>
     */
    @Read
    public default List<CategoryInfoBean> getCategoryAllChildListByCategoryId(final Long categoryId, final Long templateId,
                                                                              final String systemCode) {
        AssertUtil.assertNotNull(categoryId, "分类ID为空或不存在");
        AssertUtil.assertTrue(templateId != null && templateId > 0, "用途为空或不存在");
        AssertUtil.assertNotEmpty(systemCode, "系统code为空或不存在");
        return queryCategoryAllChildListWithoutDelByCategoryId(categoryId, templateId, systemCode);
    }

    /**
     * 根据分类ID获取所有子分类
     * <p>
     * <pre>
     * <b>(不包含：已删除)</b>
     * 获取分类ID下<b>所有</b>子分类；
     * 分类以<b>Tree</b>的形式返回；
     * </pre>
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【必填】用途ID
     * @param systemCode 【必填】系统code
     * @return List<CategoryInfoBean>
     */
    @Read
    public List<CategoryTreeNodeBean> getCategoryAllChildTreeByCategoryId(final Long categoryId, final Long templateId,
                                                                          final String systemCode);

    /**
     * 根据分类ID获取系统授权的所有分类
     *
     * @param categoryId 【必填】分类ID
     * @param systemCode 【必填】系统code
     * @return
     */
    @Read
    public List<CategoryTreeNodeBean> getCategoryAllChildTreeByCategoryId(final Long categoryId, final String systemCode);

    /**
     * 根据分类ID获取第一、二层<b>未删除</b>子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一、二层</i></b>子分类；
     * 分类以<b><i>List</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId 分类ID
     * @return 分类树
     */
    public List<CategoryInfoBean> getCategoryTwoChildListByCategoryId(final Long categoryId);

    /**
     * 根据分类ID获取第一、二层子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一、二层</i></b>子分类；
     * 分类以<b><i>List</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId   分类ID
     * @param isDeleteFlag 是否删除【true:是 false：否 null：全部】
     * @return 分类树
     */
    public List<CategoryInfoBean> getCategoryTwoChildListByCategoryId(final Long categoryId, final Boolean isDeleteFlag);

    /**
     * 根据分类ID获取第一层<b>未删除</b>子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一层</i></b>子分类；
     * 分类以<b><i>Tree</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId 分类ID
     * @return 分类树
     */
    public List<CategoryTreeNodeBean> getCategoryOneChildTreeByCategoryId(final Long categoryId);

    /**
     * 根据分类ID获取第一层子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>第一层</i></b>子分类；
     * 分类以<b><i>Tree</i></b>的形式返回；
     * </pre>
     *
     * @param categoryId   分类ID
     * @param isDeleteFlag 是否删除【true:是 false：否 null：全部】
     * @return 分类树
     */
    public List<CategoryTreeNodeBean> getCategoryOneChildTreeByCategoryId(final Long categoryId,
                                                                          final Boolean isDeleteFlag);

    /**
     * 获取全体分类信息
     *
     * @param isDeleteFlag 是否删除【true:是 false：否 null：全部】
     * @return 分类信息
     */
    public List<CategoryInfoBean> getAllCategory(final Boolean isDeleteFlag);

    /**
     * 检查分类名称是否重复
     *
     * @param categoryInfoBean 商品分类信息
     * @return 重复名称的数量
     */
    public Integer checkCategoryName(final CategoryInfoBean categoryInfoBean);

    /**
     * 生成分类显示顺序
     *
     * @param parentId 父分类ID
     * @return 显示顺序
     */
    public Integer genDisplayOrder(final Long parentId, final Long categoryId);

    /**
     * 分页检索
     *
     * @param params 检索参数
     * @return 检索结果
     */
    public PageInfo<CategoryInfoBean> searchList(Map<String, Object> params, int page, int rows);

    /**
     * 保存分类信息
     *
     * @param categoryInfoBean 分类信息
     * @return 保存记录ID
     */
    public Long saveCategoryInfo(CategoryInfoBean categoryInfoBean);

    /**
     * 删除分类信息
     *
     * @param ids 删除分类ID集
     * @return 删除记录数
     */
    public Integer deleteCategoryInfo(String ids);

    // ------------------------------根据（父分类ID，系统code，用途）获取一层子节点-----------------------------------------

    /**
     * 根据分类ID获取第一层子分类
     * <p>
     * <pre>
     * 获取分类ID下<b>第一层</b>子分类；
     * 分类以<b>List</b>的形式返回；
     * </pre>
     *
     * @param categoryId   【必填】分类ID
     * @param templateId   【可选】用途ID
     * @param systemCode   【可选】系统code
     * @param isDeleteFlag 【可选】是否删除【true:是, false：否 ,null：全部】
     * @return List<CategoryInfoBean>
     */
    @Read
    public List<CategoryInfoBean> queryCategoryOneChildListByCategoryId(final Long categoryId, final Long templateId,
                                                                        final String systemCode, final Boolean isDeleteFlag);

    /**
     * 根据分类ID获取第一层子分类(包括：已删除)
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【可选】用途ID
     * @param systemCode 【可选】系统code
     * @return List<CategoryInfoBean>
     */
    @Read
    public default List<CategoryInfoBean> queryCategoryOneChildListWithDelByCategoryId(final Long categoryId,
                                                                                       final Long templateId, final String systemCode) {
        return queryCategoryOneChildListByCategoryId(categoryId, templateId, systemCode, null);
    }

    /**
     * 根据分类ID获取第一层子分类(
     * <p>
     * <pre>
     * 不包括：已删除
     * </pre>
     * <p>
     * )
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【可选】用途ID
     * @param systemCode 【可选】系统code
     * @return List<CategoryInfoBean>
     */
    @Read
    public default List<CategoryInfoBean> queryCategoryOneChildListWithoutDelByCategoryId(final Long categoryId,
                                                                                          final Long templateId, final String systemCode) {
        return queryCategoryOneChildListByCategoryId(categoryId, templateId, systemCode, false);
    }

    // ------------------------------根据（父分类ID，系统code，用途）获取两层子节点（树形/非树型）-----------------------------------

    /**
     * 根据分类ID获取第一、二层子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b>第一、二层</b>子分类；
     * 分类以<b>List树形结构</b>返回；
     * </pre>
     *
     * @param categoryId   【必填】分类ID
     * @param templateId   【可选】用途ID
     * @param systemCode   【可选】系统code
     * @param isDeleteFlag 【可选】是否删除【true:是, false：否 ,null：全部】
     * @return List<CategoryTreeNodeBean> 树型
     */
    @Read
    public List<CategoryTreeNodeBean> queryCategoryTwoChildTreeByCategoryId(final Long categoryId,
                                                                            final Long templateId, final String systemCode, final Boolean isDeleteFlag);

    /**
     * 根据分类ID获取第一、二层子分类
     * <p>
     * <pre>
     * 获取分类ID下<b>第一、二层</b>子分类；
     * 分类以<b>List非树形结构</b>返回；
     * </pre>
     *
     * @param categoryId   【必填】分类ID
     * @param templateId   【可选】用途ID
     * @param systemCode   【可选】系统code
     * @param isDeleteFlag 【可选】是否删除【true:是, false：否 ,null：全部】
     * @return List<CategoryInfoBean>
     */
    @Read
    public List<CategoryInfoBean> queryCategoryTwoChildListByCategoryId(final Long categoryId, final Long templateId,
                                                                        final String systemCode, final Boolean isDeleteFlag);

    /**
     * 根据分类ID获取第一、二层子分类树
     * <p>
     * <pre>
     * <b>(包含已删除)</b>
     * 获取分类ID下<b>第一、二层</b>子分类；
     * 分类以<b>List树形结构</b>返回；
     * </pre>
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【可选】用途ID
     * @param systemCode 【可选】系统code
     * @return List<CategoryTreeNodeBean> 树型
     */
    @Read
    public default List<CategoryTreeNodeBean> queryCategoryTwoChildTreeWithDelByCategoryId(final Long categoryId,
                                                                                           final Long templateId, final String systemCode) {
        return queryCategoryTwoChildTreeByCategoryId(categoryId, templateId, systemCode, null);
    }

    /**
     * 根据分类ID获取第一、二层子分类
     * <p>
     * <pre>
     * <b>(包含已删除)</b>
     * 获取分类ID下<b>第一、二层</b>子分类；
     * 分类以<b>List非树形结构</b>返回；
     * </pre>
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【可选】用途ID
     * @param systemCode 【可选】系统code
     * @return List<CategoryInfoBean>
     */
    @Read
    public default List<CategoryInfoBean> queryCategoryTwoChildListWithDelByCategoryId(final Long categoryId,
                                                                                       final Long templateId, final String systemCode) {
        return queryCategoryTwoChildListByCategoryId(categoryId, templateId, systemCode, null);
    }

    /**
     * 根据分类ID获取第一、二层子分类树
     * <p>
     * <pre>
     * <b>(不包含已删除)</b>
     * 获取分类ID下<b>第一、二层</b>子分类；
     * 分类以<b>List树形结构</b>返回；
     * </pre>
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【可选】用途ID
     * @param systemCode 【可选】系统code
     * @return List<CategoryTreeNodeBean> 树型
     */
    @Read
    public default List<CategoryTreeNodeBean> queryCategoryTwoChildTreeWithoutDelByCategoryId(final Long categoryId,
                                                                                              final Long templateId, final String systemCode) {
        return queryCategoryTwoChildTreeByCategoryId(categoryId, templateId, systemCode, false);
    }

    /**
     * 根据分类ID获取第一、二层子分类
     * <p>
     * <pre>
     * <b>(不包含已删除)</b>
     * 获取分类ID下<b>第一、二层</b>子分类；
     * 分类以<b>List非树形结构</b>返回；
     * </pre>
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【可选】用途ID
     * @param systemCode 【可选】系统code
     * @return List<CategoryInfoBean>
     */
    @Read
    public default List<CategoryInfoBean> queryCategoryTwoChildListWithoutDelByCategoryId(final Long categoryId,
                                                                                          final Long templateId, final String systemCode) {
        return queryCategoryTwoChildListByCategoryId(categoryId, templateId, systemCode, false);
    }

    // -------------------------------------根据（父分类ID，系统code，用途）获取全部节点列表（非树形）------------------------------

    /**
     * 根据分类ID获取所有子分类
     * <p>
     * <pre>
     * 获取分类ID下<b>所有</b>子分类；
     * 分类以<b>List</b>的形式返回；
     * </pre>
     *
     * @param categoryId   【必填】分类ID
     * @param templateId   【可选】用途ID
     * @param systemCode   【可选】系统code
     * @param isDeleteFlag 【可选】是否删除【true:是, false：否 ,null：全部】
     * @return List<CategoryInfoBean>
     */
    @Read
    public List<CategoryInfoBean> queryCategoryAllChildListByCategoryId(final Long categoryId, final Long templateId,
                                                                        final String systemCode, final Boolean isDeleteFlag);

    /**
     * 根据分类ID获取所有子分类
     * <p>
     * <pre>
     * (包含：已删除)
     * 获取分类ID下<b>所有</b>子分类；
     * 分类以<b>List</b>的形式返回；
     * </pre>
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【可选】用途ID
     * @param systemCode 【可选】系统code
     * @return List<CategoryInfoBean>
     */
    @Read
    public default List<CategoryInfoBean> queryCategoryAllChildListWithDelByCategoryId(final Long categoryId,
                                                                                       final Long templateId, final String systemCode) {
        return queryCategoryAllChildListByCategoryId(categoryId, templateId, systemCode, null);
    }

    /**
     * 根据分类ID获取所有子分类
     * <p>
     * <pre>
     * (不包含：已删除)
     * 获取分类ID下<b>所有</b>子分类；
     * 分类以<b>List</b>的形式返回；
     * </pre>
     *
     * @param categoryId 【必填】分类ID
     * @param templateId 【可选】用途ID
     * @param systemCode 【可选】系统code
     * @return List<CategoryInfoBean>
     */
    @Read
    public default List<CategoryInfoBean> queryCategoryAllChildListWithoutDelByCategoryId(final Long categoryId,
                                                                                          final Long templateId, final String systemCode) {
        return queryCategoryAllChildListByCategoryId(categoryId, templateId, systemCode, false);
    }

    /**
     * 获取所有子分类（树型）
     * <p>
     * <pre>
     * (不包含：已删除)
     * 获取<b>所有</b>子分类，分类ID格式：(id:templateId)
     * 分类以<b>ListTree</b>的形式返回；
     * </pre>
     *
     * @param templateId 【必填】用途ID
     * @return List<CategoryTreeNodeBean>
     */
    @Read
    public List<CategoryTreeNodeBean> queryCategoryAllChildTreeWithTemplate(final Long templateId);

}
