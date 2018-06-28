package cn.faury.fwmf.module.service.category.service;


import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.bean.*;
import cn.faury.fwmf.module.api.category.service.CategoryService;
import cn.faury.fwmf.module.api.category.service.CategoryTagService;
import cn.faury.fwmf.module.service.category.mapper.CategoryTagMapper;

import java.util.*;

/**
 * 分类标签服务实现
 */
public class CategoryTagServiceImpl implements CategoryTagService {

    /**
     * 数据库操作器
     */
    private CommonDao commonDao;

    /**
     * 分类服务
     */
    private CategoryService categoryService;

    public CategoryTagServiceImpl(CommonDao commonDao, CategoryService categoryService) {
        this.commonDao = commonDao;
        this.categoryService = categoryService;
    }

    @Override
    public Map<Long, Map<Long, List<TagValueInfoBean>>> getTagValueInfoByGroupId(final List<Long> categoryId,
                                                                                 final List<Long> tagProductId, final Boolean isCategoryDelete) {
        Map<Long, Map<Long, List<TagValueInfoBean>>> resultMap = new HashMap<>();

        if (categoryId == null || tagProductId == null) {
            return resultMap;
        }

        // 查询分类下标签组里面可用的标签值列表
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("categoryId", categoryId);
        parameter.put("tagProductId", tagProductId);
        parameter.put("isCategoryDelete", isCategoryDelete);
        String state = CategoryTagMapper.class.getName() + ".getTagValueInfoByGroupId";
        List<TagValueInfoBean> results = this.commonDao.selectList(state, parameter);

        // 组装返回结果：<标签组ID，标签值列表>
        if (results != null && results.size() > 0) {
            for (TagValueInfoBean result : results) {
                // 获取分类下标签分组
                Map<Long, List<TagValueInfoBean>> tmpGroup = resultMap.get(result.getProductCategoryId());
                if (tmpGroup == null) {
                    tmpGroup = new HashMap<Long, List<TagValueInfoBean>>();
                    resultMap.put(result.getProductCategoryId(), tmpGroup);
                }
                // 获取标签分组下标签值
                List<TagValueInfoBean> tmpValue = tmpGroup.get(result.getParentId());
                if (tmpValue == null) {
                    tmpValue = new ArrayList<TagValueInfoBean>();
                    tmpGroup.put(result.getParentId(), tmpValue);
                }
                tmpValue.add(result);
            }
        }

        return resultMap;
    }

    @Override
    public Map<Long, Map<Long, List<TagValueInfoBean>>> getTagValueInfoByGroupId(final List<Long> categoryId,
                                                                                 final List<Long> tagProductId) {
        return this.getTagValueInfoByGroupId(categoryId, tagProductId, Boolean.FALSE);
    }

    @Override
    public Map<Long, List<TagValueInfoBean>> getTagValueInfoByGroupId(final Long categoryId,
                                                                      final List<Long> tagProductId, Boolean isCategoryDelete) {
        Map<Long, Map<Long, List<TagValueInfoBean>>> result = this.getTagValueInfoByGroupId(Arrays.asList(categoryId),
                tagProductId, isCategoryDelete);
        if (result != null) {
            return result.get(categoryId);
        }
        return null;
    }

    @Override
    public Map<Long, List<TagValueInfoBean>> getTagValueInfoByGroupId(final Long categoryId,
                                                                      final List<Long> tagProductId) {
        return this.getTagValueInfoByGroupId(categoryId, tagProductId, Boolean.FALSE);
    }

    @Override
    public List<TagValueInfoBean> getTagValueInfoByGroupId(final Long categoryId, final Long tagProductId,
                                                           final Boolean isCategoryDelete) {
        Map<Long, List<TagValueInfoBean>> result = this.getTagValueInfoByGroupId(categoryId,
                Arrays.asList(tagProductId), isCategoryDelete);
        if (result != null) {
            return result.get(tagProductId);
        }
        return null;
    }

    @Override
    public List<TagValueInfoBean> getTagValueInfoByGroupId(final Long categoryId, final Long tagProductId) {
        return this.getTagValueInfoByGroupId(categoryId, tagProductId, Boolean.FALSE);
    }

    @Override
    public Map<Long, List<TagGroupInfoBean>> getTagGroupListByCategoryId(final List<Long> categoryId,
                                                                         final Boolean isCategoryDelete) {
        Map<Long, List<TagGroupInfoBean>> resultMap = new HashMap<Long, List<TagGroupInfoBean>>();
        if (categoryId == null) {
            return resultMap;
        }

        // 查询分类下可用的标签组
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("categoryId", categoryId);
        parameter.put("isCategoryDelete", isCategoryDelete);
        String state = CategoryTagMapper.class.getName() + ".getTagGroupListByCategoryId";
        List<TagGroupInfoBean> results = this.commonDao.selectList(state, parameter);

        if (results == null || results.size() <= 0) {
            return resultMap;
        }

        // 按照分类、分组归类
        List<Long> categoryLst = new ArrayList<Long>();
        List<Long> groupLst = new ArrayList<Long>();
        for (TagGroupInfoBean r : results) {
            categoryLst.add(r.getProductCategoryId());
            groupLst.add(r.getTagProductId());
        }

        // 获取分类、分组下的标签值
        Map<Long, Map<Long, List<TagValueInfoBean>>> values = new HashMap<Long, Map<Long, List<TagValueInfoBean>>>();

        if (categoryLst != null && categoryLst.size() > 0 && groupLst != null && categoryLst.size() > 0) {
            values = this.getTagValueInfoByGroupId(categoryLst, groupLst, isCategoryDelete);
        }

        // 组装返回结果
        for (TagGroupInfoBean r : results) {
            List<TagGroupInfoBean> groups = resultMap.get(r.getProductCategoryId());
            if (groups == null) {
                groups = new ArrayList<TagGroupInfoBean>();
                resultMap.put(r.getProductCategoryId(), groups);
            }
            // 获取标签组的标签值
            List<TagValueInfoBean> tagValues = null;
            if (values != null && values.get(r.getProductCategoryId()) != null) {
                tagValues = values.get(r.getProductCategoryId()).get(r.getTagProductId());
            }
            if (tagValues != null) {
                r.setValues(tagValues);
            }
            groups.add(r);
        }
        return resultMap;
    }

    @Override
    public Map<Long, List<TagGroupInfoBean>> getTagGroupListByCategoryId(final List<Long> categoryId) {
        return this.getTagGroupListByCategoryId(categoryId, Boolean.FALSE);
    }

    @Override
    public List<TagGroupInfoBean> getTagGroupListByCategoryId(final Long categoryId, final Boolean isCategoryDelete) {
        Map<Long, List<TagGroupInfoBean>> result = this.getTagGroupListByCategoryId(Arrays.asList(categoryId),
                isCategoryDelete);
        if (result != null) {
            return result.get(categoryId);
        }
        return null;
    }

    @Override
    public List<TagGroupInfoBean> getTagGroupListByCategoryId(final Long categoryId) {
        return this.getTagGroupListByCategoryId(categoryId, Boolean.FALSE);
    }

    @Override
    public Map<Long, List<CategoryTagInfoBean>> getCategoryTagInfoByCategoryId(final List<Long> categoryId,
                                                                               final Boolean isCategoryDelete) {
        Map<Long, List<CategoryTagInfoBean>> resultMap = new HashMap<Long, List<CategoryTagInfoBean>>();
        if (categoryId == null || categoryId.size() <= 0) {
            return resultMap;
        }
        // 获取分类信息Bean
        List<CategoryInfoBean> categoryInfoLst = this.categoryService.getCategoryInfoByCategoryId(categoryId,
                isCategoryDelete);
        // 获取分类标签组信息
        Map<Long, List<TagGroupInfoBean>> tagGroupMap = this.getTagGroupListByCategoryId(categoryId, isCategoryDelete);
        // 组装结果
        for (CategoryInfoBean category : categoryInfoLst) {
            CategoryTagInfoBean ct = new CategoryTagInfoBean(category);
            List<CategoryTagInfoBean> lst = resultMap.get(ct.getProductCategoryId());
            if (lst == null) {
                lst = new ArrayList<CategoryTagInfoBean>();
                resultMap.put(ct.getProductCategoryId(), lst);
            }
            // 获取分类下的标签组
            List<TagGroupInfoBean> tagGroup = tagGroupMap.get(ct.getProductCategoryId());
            if (tagGroup != null) {
                ct.setTags(tagGroup);
            }
            lst.add(ct);
        }

        return resultMap;
    }

    @Override
    public Map<Long, List<CategoryTagInfoBean>> getCategoryTagInfoByCategoryId(final List<Long> categoryId) {
        return this.getCategoryTagInfoByCategoryId(categoryId, Boolean.FALSE);
    }

    @Override
    public List<CategoryTagInfoBean> getCategoryTagInfoByCategoryId(final Long categoryId,
                                                                    final Boolean isCategoryDelete) {
        Map<Long, List<CategoryTagInfoBean>> result = this.getCategoryTagInfoByCategoryId(Arrays.asList(categoryId),
                isCategoryDelete);
        if (result != null) {
            return result.get(categoryId);
        }
        return null;
    }

    @Override
    public List<CategoryTagInfoBean> getCategoryTagInfoByCategoryId(final Long categoryId) {
        return this.getCategoryTagInfoByCategoryId(categoryId, Boolean.FALSE);
    }

    @Override
    public Integer saveCategoryTagInfo(Long categoryId, List<Map<String, Long>> tagsId) {
        Map<String, Object> paramter = new HashMap<>();
        List<Long> categoryIds = new ArrayList<>();
        categoryIds.add(categoryId);
        paramter.put("categoryId", categoryId);
        paramter.put("tagsId", tagsId);

        String state = CategoryTagMapper.class.getName() + ".deleteCategoryTagInfo";
        Integer removeCount = this.commonDao.delete(state, categoryIds);

        Integer addCount = 0;
        if (tagsId.size() > 0) {
            state = CategoryTagMapper.class.getName() + ".insertCategoryTagInfo";
            addCount = this.commonDao.insert(state, paramter);
        }

        return addCount - removeCount;
    }

    @Override
    public List<TagInfoBean> queryTagInfoByCategoryId(List<Long> categoryId, String systemCode, Long templateId,
                                                      Boolean isCategoryDelete) {
        AssertUtil.assertTrue(categoryId != null && categoryId.size() > 0, "分类ID为空或不存在");
        
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("categoryId", categoryId);
        if (templateId!=null) {
            parameter.put("templateId", templateId);
        }
        if (StringUtil.isNotEmpty(systemCode)) {
            parameter.put("systemCode", systemCode);
        }
        if (isCategoryDelete!=null) {
            parameter.put("isCategoryDelete", isCategoryDelete);
        }
        String state = CategoryTagMapper.class.getName() + ".queryTagInfoByCategoryId";
        return this.commonDao.selectList(state, parameter);
    }

}
