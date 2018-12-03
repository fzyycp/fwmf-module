package cn.faury.fwmf.module.service.category.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.bean.CategoryInfoBean;
import cn.faury.fwmf.module.api.category.bean.CategoryTreeNodeBean;
import cn.faury.fwmf.module.api.category.service.CategoryInfoService;
import cn.faury.fwmf.module.api.category.util.TreeUtil;
import cn.faury.fwmf.module.service.category.mapper.CategoryInfoMapper;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 服务实现：分类信息表
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了CategoryInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class CategoryInfoServiceImpl extends CrudBaseServiceImpl<CategoryInfoBean, Long> implements CategoryInfoService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public CategoryInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, CategoryInfoMapper.class);
    }

    @Override
    public PageInfo<CategoryInfoBean> search(Map<String, Object> param) {
        Map<String, Object> _params = new HashMap<>();
        // 默认，可被覆盖
        _params.put("ORDER_BY", "PARENT_ID,ASC,DISPLAY_ORDER,ASC");
        _params.put("isDelete", StringUtil.WHETHER_NO);
        _params.putAll(param);
        return super.search(_params);
    }

    @Override
    public int deleteById(Long primaryKey) {
        // 获取下级分类
        List<CategoryInfoBean> subCategory = this.getSubCategoryList(primaryKey);
        AssertUtil.assertTrue(subCategory == null || subCategory.size() <= 0, "当前分类存在子分类不可以删除");
        return super.deleteById(primaryKey);
    }

    /**
     * 根据ID获取分类信息，带父节点名称
     *
     * @param id 分类ID
     * @return 分类对象
     */
    @Override
    public CategoryInfoBean getBeanByIdWithParentName(Long id) {
        CategoryInfoBean bean = this.getBeanById(id);
        if (bean != null && bean.getParentId() != null && bean.getParentId() > 0) {
            CategoryInfoBean parentBean = this.getBeanById(bean.getParentId());
            if (parentBean != null) {
                bean.setParentName(parentBean.getProductCategoryName());
            }
        }

        return bean;
    }

    /**
     * 获取直接下级分类列表
     *
     * @param parentId 分类ID
     * @return 下级分类列表
     */
    @Override
    public List<CategoryInfoBean> getSubCategoryList(Long parentId) {
        Map<String, Object> params = new HashMap<>();
        params.put("parentId", parentId);

        return query(params);
    }

    /**
     * 获取所有下级分类列表
     *
     * @param parentId 父分类ID
     * @return 所有下级分类列表
     */
    @Override
    public List<CategoryInfoBean> getAllSubCategoryList(Long parentId) {
        if (parentId == null || parentId == 0) {// 根节点直接返回所有
            return query(null);
        }

        CategoryInfoBean bean = this.getBeanById(parentId);
        AssertUtil.assertNotNull(bean, "父分类不存在");
        String xpath = String.format("%s/%s", bean.getXpath(), bean.getProductCategoryId());
        return query(Collections.singletonMap("xpathLike", xpath));
    }

    /**
     * 获取直接下级分类列表
     *
     * @param parentId 父分类ID
     * @param usage    用途编码（1、2、4、8、16、32），多种支持求和
     * @return 下级分类列表
     */
    @Override
    public List<CategoryInfoBean> getSubCategoryList(Long parentId, int usage) {
        Map<String, Object> params = new HashMap<>();
        params.put("parentId", parentId);

        List<CategoryInfoBean> result = query(params);
        // 与运算大于1
        return result.stream().filter(bean -> (bean.getUsageCode() & usage) > 0).collect(Collectors.toList());
    }

    /**
     * 获取所有下级分类树
     *
     * @param parentId 父分类ID
     * @return 所有下级分类树
     */
    @Override
    public List<CategoryTreeNodeBean> getAllSubCategoryTree(Long parentId) {
        return TreeUtil.convertList2Tree(this.getAllSubCategoryList(parentId));
    }
}