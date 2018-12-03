package cn.faury.fwmf.module.api.category.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.category.bean.CategoryInfoBean;
import cn.faury.fwmf.module.api.category.bean.CategoryTreeNodeBean;

import java.util.List;

/**
 * 服务接口：分类信息表
 * <p>
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface CategoryInfoService extends CrudBaseService<CategoryInfoBean, Long> {

    /**
     * 根据ID获取分类信息，带父节点名称
     *
     * @param id 分类ID
     * @return 分类对象
     */
    public CategoryInfoBean getBeanByIdWithParentName(Long id);

    /**
     * 获取直接下级分类列表
     *
     * @param parentId 父分类ID
     * @return 下级分类列表
     */
    public List<CategoryInfoBean> getSubCategoryList(Long parentId);

    /**
     * 获取所有下级分类列表
     *
     * @param parentId 父分类ID
     * @return 所有下级分类列表
     */
    public List<CategoryInfoBean> getAllSubCategoryList(Long parentId);

    /**
     * 获取直接下级分类列表
     *
     * @param parentId 父分类ID
     * @param usage    用途编码（1、2、4、8、16、32），多种支持求和
     * @return 下级分类列表
     */
    public List<CategoryInfoBean> getSubCategoryList(Long parentId, int usage);

    /**
     * 获取所有下级分类树
     *
     * @param parentId 父分类ID
     * @return 所有下级分类树
     */
    public List<CategoryTreeNodeBean> getAllSubCategoryTree(Long parentId);
}