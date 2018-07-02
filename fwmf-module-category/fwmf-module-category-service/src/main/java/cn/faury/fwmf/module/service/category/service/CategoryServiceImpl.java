package cn.faury.fwmf.module.service.category.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.bean.CategoryInfoBean;
import cn.faury.fwmf.module.api.category.bean.CategoryTreeNodeBean;
import cn.faury.fwmf.module.api.category.service.CategoryService;
import cn.faury.fwmf.module.service.category.mapper.CategoryMapper;

import java.util.*;

/**
 * 分类服务实现
 */
public class CategoryServiceImpl implements CategoryService {

    /**
     * 数据库操作器
     */
    private CommonDao commonDao;

    public CategoryServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 给树节点添加子节点
     *
     * @param categoryNode 树节点
     * @param categoryMap  PID分组数据
     */
    private void attachChildrens(final CategoryTreeNodeBean categoryNode,
                                 final Map<Long, List<CategoryInfoBean>> categoryMap) {
        // 非叶子节点才会有子节点
        if (categoryNode != null && categoryMap != null && categoryMap.size() > 0) {
            // 获取所有子节点
            List<CategoryInfoBean> childrens = categoryMap.get(categoryNode.getProductCategoryId());
            if (childrens != null) {
                List<CategoryTreeNodeBean> nodeLst = new ArrayList<CategoryTreeNodeBean>();
                for (CategoryInfoBean menuBean : childrens) {
                    CategoryTreeNodeBean node = new CategoryTreeNodeBean(menuBean);
                    attachChildrens(node, categoryMap);
                    nodeLst.add(node);
                }
                categoryNode.setChildrens(nodeLst);
            }
        }
    }

    /**
     * 将平行的列表转换为树形（平行的列表必须以PID进行分组排序）
     *
     * @param categoryLst 分类列表
     * @return
     */
    private List<CategoryTreeNodeBean> convertList2Tree(final List<CategoryInfoBean> categoryLst) {
        // 菜单树
        List<CategoryTreeNodeBean> categoryTree = new ArrayList<CategoryTreeNodeBean>();
        // 将以PID进行分组
        Map<Long, List<CategoryInfoBean>> categoryMap = new HashMap<Long, List<CategoryInfoBean>>();
        Map<Long, Long> categoryIds = new HashMap<Long, Long>();
        for (CategoryInfoBean categoryBean : categoryLst) {
            categoryIds.put(categoryBean.getProductCategoryId(), categoryBean.getProductCategoryId());
            if (categoryBean.getProductCategoryId() == null) {
                System.out.println(categoryBean.toString());
            }
            List<CategoryInfoBean> tmp = categoryMap.get(categoryBean.getParentId());
            if (tmp == null) {
                tmp = new ArrayList<CategoryInfoBean>();
                categoryMap.put(categoryBean.getParentId(), tmp);
            }
            tmp.add(categoryBean);
        }
        // 找到最上层为跟节点
        for (CategoryInfoBean categoryBean : categoryLst) {
            Long tmp = categoryIds.get(categoryBean.getParentId());
            // 将PID为不存在的作为根级菜单
            if (tmp == null) {
                CategoryTreeNodeBean categoryNode = new CategoryTreeNodeBean(categoryBean);
                categoryTree.add(categoryNode);
            }
        }
        for (CategoryTreeNodeBean categoryNode : categoryTree) {
            attachChildrens(categoryNode, categoryMap);
        }
        return categoryTree;
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryInfoByCategoryId(java.lang.Long)
     */
    @Override
    public CategoryInfoBean getCategoryInfoByCategoryId(final Long categoryId) {
        return this.getCategoryInfoByCategoryId(categoryId, Boolean.FALSE);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryInfoByCategoryId(java.util.List)
     */
    @Override
    public List<CategoryInfoBean> getCategoryInfoByCategoryId(final List<Long> categoryId) {
        return this.getCategoryInfoByCategoryId(categoryId, Boolean.FALSE);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryInfoByCategoryId(java.lang.Long, java.lang.Boolean)
     */
    @Override
    public CategoryInfoBean getCategoryInfoByCategoryId(final Long categoryId, final Boolean isDeleteFlag) {
        List<CategoryInfoBean> result = this.getCategoryInfoByCategoryId(Arrays.asList(categoryId), isDeleteFlag);
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryInfoByCategoryId(java.util.List, java.lang.Boolean)
     */
    @Override
    public List<CategoryInfoBean> getCategoryInfoByCategoryId(final List<Long> categoryId, final Boolean isDeleteFlag) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("categoryId", categoryId);
        parameter.put("isDeleteFlag", isDeleteFlag);
        String state = CategoryMapper.class.getName() + ".getCategoryInfoByCategoryId";
        return this.commonDao.selectList(state, parameter);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryOneChildListByCategoryId(java.lang.Long)
     */
    @Override
    public List<CategoryInfoBean> getCategoryOneChildListByCategoryId(final Long categoryId) {
        return this.getCategoryOneChildListByCategoryId(categoryId, Boolean.FALSE);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryOneChildListByCategoryId(java.lang.Long, java.lang.Boolean)
     */
    @Override
    public List<CategoryInfoBean> getCategoryOneChildListByCategoryId(final Long categoryId, final Boolean isDeleteFlag) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("categoryId", categoryId);
        parameter.put("isDeleteFlag", isDeleteFlag);
        String state = CategoryMapper.class.getName() + ".getCategoryOneChildListByCategoryId";
        return this.commonDao.selectList(state, parameter);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryTwoChildListByCategoryId(java.lang.Long)
     */
    @Override
    public List<CategoryInfoBean> getCategoryTwoChildListByCategoryId(final Long categoryId) {
        return this.getCategoryTwoChildListByCategoryId(categoryId, Boolean.FALSE);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryTwoChildListByCategoryId(java.lang.Long, java.lang.Boolean)
     */
    @Override
    public List<CategoryInfoBean> getCategoryTwoChildListByCategoryId(final Long categoryId, final Boolean isDeleteFlag) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("categoryId", categoryId);
        parameter.put("isDeleteFlag", isDeleteFlag);
        String state = CategoryMapper.class.getName() + ".getCategoryTwoChildListByCategoryId";
        return this.commonDao.selectList(state, parameter);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryAllChildListByCategoryId(java.lang.Long)
     */
    @Override
    public List<CategoryInfoBean> getCategoryAllChildListByCategoryId(final Long categoryId) {
        return this.getCategoryAllChildListByCategoryId(categoryId, Boolean.FALSE);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryAllChildListByCategoryId(java.lang.Long, java.lang.Boolean)
     */
    @Override
    public List<CategoryInfoBean> getCategoryAllChildListByCategoryId(final Long categoryId, final Boolean isDeleteFlag) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("categoryId", categoryId);
        parameter.put("isDeleteFlag", isDeleteFlag);
        String state = CategoryMapper.class.getName() + ".getCategoryAllChildListByCategoryId";
        return this.commonDao.selectList(state, parameter);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryOneChildTreeByCategoryId(java.lang.Long)
     */
    @Override
    public List<CategoryTreeNodeBean> getCategoryOneChildTreeByCategoryId(final Long categoryId) {
        return this.getCategoryOneChildTreeByCategoryId(categoryId, Boolean.FALSE);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryOneChildTreeByCategoryId(java.lang.Long, java.lang.Boolean)
     */
    @Override
    public List<CategoryTreeNodeBean> getCategoryOneChildTreeByCategoryId(final Long categoryId,
                                                                          final Boolean isDeleteFlag) {
        List<CategoryInfoBean> categoryLst = this.getCategoryOneChildListByCategoryId(categoryId, isDeleteFlag);
        return convertList2Tree(categoryLst);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryTwoChildTreeByCategoryId(java.lang.Long)
     */
    @Override
    public List<CategoryTreeNodeBean> getCategoryTwoChildTreeByCategoryId(final Long categoryId) {
        return this.getCategoryTwoChildTreeByCategoryId(categoryId, Boolean.FALSE);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryTwoChildTreeByCategoryId(java.lang.Long, java.lang.Boolean)
     */
    @Override
    public List<CategoryTreeNodeBean> getCategoryTwoChildTreeByCategoryId(final Long categoryId,
                                                                          final Boolean isDeleteFlag) {
        List<CategoryInfoBean> categoryLst = this.getCategoryTwoChildListByCategoryId(categoryId, isDeleteFlag);
        return convertList2Tree(categoryLst);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryAllChildTreeByCategoryId(java.lang.Long)
     */
    @Override
    public List<CategoryTreeNodeBean> getCategoryAllChildTreeByCategoryId(final Long categoryId) {
        return this.getCategoryAllChildTreeByCategoryId(categoryId, Boolean.FALSE);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getCategoryAllChildTreeByCategoryId(java.lang.Long, java.lang.Boolean)
     */
    @Override
    public List<CategoryTreeNodeBean> getCategoryAllChildTreeByCategoryId(final Long categoryId,
                                                                          final Boolean isDeleteFlag) {
        List<CategoryInfoBean> categoryLst = this.getCategoryAllChildListByCategoryId(categoryId, isDeleteFlag);
        return convertList2Tree(categoryLst);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * getAllCategory(java.lang.Boolean)
     */
    @Override
    public List<CategoryInfoBean> getAllCategory(final Boolean isDeleteFlag) {
        String categoryState = null;
        if (isDeleteFlag != null) {
            categoryState = isDeleteFlag ? "Y" : "N";
        }
        String state = CategoryMapper.class.getName() + ".getAllCategory";
        return this.commonDao.selectList(state, categoryState);

    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * checkCategoryName
     * (cn.wassk.platform.inteface.category.bean.CategoryInfoBean)
     */
    @Override
    public Integer checkCategoryName(final CategoryInfoBean categoryInfoBean) {
        String state = CategoryMapper.class.getName() + ".checkCategoryName";
        return this.commonDao.selectOne(state, categoryInfoBean);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * genDisplayOrder
     * (cn.wassk.platform.inteface.category.bean.CategoryInfoBean)
     */
    @Override
    public Integer genDisplayOrder(final Long parentId, final Long categoryId) {
        Map<String, Object> params = new HashMap<>();
        params.put("parentId", parentId);
        params.put("categoryId", categoryId);
        String state = CategoryMapper.class.getName() + ".genDisplayOrder";
        return this.commonDao.selectOne(state, params);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * searchList(java.util.Map)
     */
    @Override
    public PageInfo<CategoryInfoBean> searchList(Map<String, Object> params, int page, int rows) {
        String state = CategoryMapper.class.getName() + ".getCategoryOneChildListByCategoryIdWithSelf";
        PageParam pageParam = new PageParam(page, rows);

        return this.commonDao.selectPage(state, params, pageParam);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * saveCategoryInfo
     * (cn.wassk.platform.inteface.category.bean.CategoryInfoBean)
     */
    @Override
    public Long saveCategoryInfo(CategoryInfoBean categoryInfoBean) {
        AssertUtil.assertFalse(checkCategoryName(categoryInfoBean) > 0, "同层级下已有相同的分类名称");

        if (categoryInfoBean.getProductCategoryId() == null || categoryInfoBean.getProductCategoryId() < 0) {
            String state = CategoryMapper.class.getName() + ".insertCategoryInfo";
            this.commonDao.insert(state, categoryInfoBean);
        } else {
            String state = CategoryMapper.class.getName() + ".updateCategoryInfo";
            this.commonDao.update(state, categoryInfoBean);
        }
        return categoryInfoBean.getProductCategoryId();
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.CategoryService#
     * deleteCategoryInfo(java.lang.String)
     */
    @Override
    public Integer deleteCategoryInfo(String ids) {
        String[] idsStr = ids.split(",");
        List<Long> idsValue = new ArrayList<>();
        for (String idStr : idsStr) {
            try {
                Long idValue = Long.parseLong(idStr);
                idsValue.add(idValue);
            } catch (NumberFormatException e) {
                idsValue.add(-1L);
            }
        }

        String state = CategoryMapper.class.getName() + ".checkHasChildren";
        Integer count = this.commonDao.selectOne(state, idsValue);
        AssertUtil.assertFalse(count > 0, "要删除的分类含有子分类");

        state = CategoryMapper.class.getName() + ".deleteCategoryInfo";
        return this.commonDao.delete(state, idsValue);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.LocalCategoryService#
     * queryCategoryOneChildList(java.util.Map)
     */
    @Override
    public List<CategoryInfoBean> queryCategoryOneChildListByCategoryId(Long categoryId, Long templateId,
                                                                        String systemCode, Boolean isDeleteFlag) {
        Map<String, Object> parameter = new HashMap<>();
        AssertUtil.assertNotNull(categoryId, "分类id为空或不存在");
        parameter.put("categoryId", categoryId);
        if (templateId != null) {
            parameter.put("templateId", templateId);
        }
        if (StringUtil.isNotEmpty(systemCode)) {
            parameter.put("systemCode", systemCode);
        }
        if (isDeleteFlag != null) {
            parameter.put("isDeleteFlag", isDeleteFlag);
        }
        String state = CategoryMapper.class.getName() + ".queryCategoryOneChildListByCategoryId";
        return this.commonDao.selectList(state, parameter);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.LocalCategoryService#
     * queryCategoryTwoChildTreeByCategoryId(java.lang.Long, java.lang.Long,
     * java.lang.String, boolean)
     */
    @Override
    public List<CategoryTreeNodeBean> queryCategoryTwoChildTreeByCategoryId(Long categoryId, Long templateId,
                                                                            String systemCode, Boolean isDeleteFlag) {
        List<CategoryInfoBean> categoryLst = this.queryCategoryTwoChildListByCategoryId(categoryId, templateId,
                systemCode, isDeleteFlag);
        return convertList2Tree(categoryLst);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.LocalCategoryService#
     * queryCategoryTwoChildListByCategoryId(java.lang.Long, java.lang.Long,
     * java.lang.String, boolean)
     */
    @Override
    public List<CategoryInfoBean> queryCategoryTwoChildListByCategoryId(Long categoryId, Long templateId,
                                                                        String systemCode, Boolean isDeleteFlag) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        AssertUtil.assertNotNull(categoryId, "分类id为空或不存在");
        parameter.put("categoryId", categoryId);
        if (templateId != null) {
            parameter.put("templateId", templateId);
        }
        if (StringUtil.isNotEmpty(systemCode)) {
            parameter.put("systemCode", systemCode);
        }
        if (isDeleteFlag != null) {
            parameter.put("isDeleteFlag", isDeleteFlag);
        }
        String state = CategoryMapper.class.getName() + ".queryCategoryTwoChildListByCategoryId";
        return this.commonDao.selectList(state, parameter);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.LocalCategoryService#
     * queryCategoryAllChildListByCategoryId(java.lang.Long, java.lang.Long,
     * java.lang.String, boolean)
     */
    @Override
    public List<CategoryInfoBean> queryCategoryAllChildListByCategoryId(Long categoryId, Long templateId,
                                                                        String systemCode, Boolean isDeleteFlag) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        AssertUtil.assertNotNull(categoryId, "分类id为空或不存在");
        parameter.put("categoryId", categoryId);
        if (templateId != null) {
            parameter.put("templateId", templateId);
        }
        if (StringUtil.isNotEmpty(systemCode)) {
            parameter.put("systemCode", systemCode);
        }
        if (isDeleteFlag != null) {
            parameter.put("isDeleteFlag", isDeleteFlag);
        }
        String state = CategoryMapper.class.getName() + ".queryCategoryAllChildListByCategoryId";
        return this.commonDao.selectList(state, parameter);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.service.category.service.CategoryService#
     * getCategoryAllChildTreeByCategoryId(java.lang.Long, java.lang.String)
     */
    @Override
    public List<CategoryTreeNodeBean> getCategoryAllChildTreeByCategoryId(Long categoryId, String systemCode) {
        AssertUtil.assertNotNull(categoryId, "分类ID为空或不存在");
        AssertUtil.assertNotEmpty(systemCode,"系统code为空或不存在");

        List<CategoryInfoBean> list = queryCategoryAllChildListByCategoryId(categoryId, null, systemCode, false);
        return convertList2Tree(list);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.service.category.service.CategoryService#
     * getCategoryAllChildTreeByCategoryId(java.lang.Long, java.lang.Long,
     * java.lang.String)
     */
    @Override
    public List<CategoryTreeNodeBean> getCategoryAllChildTreeByCategoryId(Long categoryId, Long templateId,
                                                                          String systemCode) {
        AssertUtil.assertNotNull(categoryId, "分类ID为空或不存在");
        AssertUtil.assertNotNull(templateId, "用途为空或不存在");
        AssertUtil.assertNotEmpty(systemCode,"系统code为空或不存在");
        List<CategoryInfoBean> list = queryCategoryAllChildListByCategoryId(categoryId, templateId, systemCode, false);
        return convertList2Tree(list);
    }

    /*
     * (non-Javadoc)
     *
     * @see cn.wassk.platform.inteface.category.service.LocalCategoryService#
     * queryCategoryAllChildTreeWithoutDel(java.lang.Long, java.lang.Long,
     * java.lang.String)
     */
    @Override
    public List<CategoryTreeNodeBean> queryCategoryAllChildTreeWithTemplate(final Long templateId) {

        List<CategoryInfoBean> list = queryCategoryAllChildListByCategoryId(0L, templateId, null, false);
        List<CategoryInfoBean> tlist = new ArrayList<CategoryInfoBean>();
        for (CategoryInfoBean bean : list) {
            bean.setCateTempId(bean.getProductCategoryId() + ":" + templateId);

            tlist.add(bean);
        }
        return convertList2Tree(tlist);
    }

}
