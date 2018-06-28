package cn.faury.fwmf.module.service.category.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.bean.TagGroupInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagGroupTreeNodeBean;
import cn.faury.fwmf.module.api.category.bean.TagInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagValueInfoBean;
import cn.faury.fwmf.module.api.category.service.TagService;
import cn.faury.fwmf.module.service.category.mapper.TagMapper;

import java.util.*;

/**
 * 标签服务实现
 */
public class TagServiceImpl implements TagService {

    /**
     * 数据库操作器
     */
    private CommonDao commonDao;

    public TagServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public TagInfoBean getTagInfoByTagId(final Long tagProductId, final Boolean isGroup, Boolean isDelte) {
        List<TagInfoBean> result = this.getTagInfoByTagId(Arrays.asList(tagProductId), isGroup, isDelte);
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public List<TagInfoBean> getTagInfoByTagId(final List<Long> tagProductId, final Boolean isGroup, Boolean isDelte) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("tagProductId", tagProductId);
        parameter.put("isGroup", isGroup);
        parameter.put("isDelte", isDelte);
        String state = TagMapper.class.getName() + ".getTagInfoByTagId";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<TagValueInfoBean> getTagValueListByTagId(final Long tagProductId, Boolean isDelte) {
        Map<Long, List<TagValueInfoBean>> result = this.getTagValueListByTagId(Arrays.asList(tagProductId), isDelte);
        if (result != null) {
            return result.get(tagProductId);
        }

        return null;
    }

    @Override
    public Map<Long, List<TagValueInfoBean>> getTagValueListByTagId(final List<Long> tagProductId, Boolean isDelte) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("tagProductId", tagProductId);
        parameter.put("isDelte", isDelte);
        String state = TagMapper.class.getName() + ".getTagValueListByTagId";
        List<TagInfoBean> result = this.commonDao.selectList(state, parameter);

        Map<Long, List<TagValueInfoBean>> valueMap = new HashMap<Long, List<TagValueInfoBean>>();
        for (TagInfoBean r : result) {
            List<TagValueInfoBean> values = valueMap.get(r.getParentId());
            if (values == null) {
                values = new ArrayList<TagValueInfoBean>();
                valueMap.put(r.getParentId(), values);
            }
            values.add(new TagValueInfoBean(r));
        }
        return valueMap;
    }

    @Override
    public List<TagValueInfoBean> getTagValueListByCategoryId(List<Long> categoryId, Boolean isDelte) {
        String state = TagMapper.class.getName() + ".getTagValueListByCategoryId";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("categoryId", categoryId);
        parameter.put("isDelte", isDelte);
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<TagGroupInfoBean> getTagGroupOneChildListByTagId(final Long tagProductId, Boolean isDelte) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("tagProductId", tagProductId);
        parameter.put("isDelte", isDelte);
        String state = TagMapper.class.getName() + ".getTagGroupOneChildListByTagId";
        List<TagGroupInfoBean> result = this.commonDao.selectList(state, parameter);
        // 填充标签组下的标签值列表
        this.attachTagValues2Group(result);
        return result;
    }

    @Override
    public List<TagGroupInfoBean> getTagGroupTwoChildListByTagId(final Long tagProductId, Boolean isDelte) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("tagProductId", tagProductId);
        parameter.put("isDelte", isDelte);
        String state = TagMapper.class.getName() + ".getTagGroupTwoChildListByTagId";
        List<TagGroupInfoBean> result = this.commonDao.selectList(state, parameter);
        // 填充标签组下的标签值列表
        this.attachTagValues2Group(result);
        return result;
    }

    @Override
    public List<TagGroupInfoBean> getTagGroupAllChildListByTagId(final Long tagProductId, Boolean isDelte) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("tagProductId", tagProductId);
        parameter.put("isDelte", isDelte);
        String state = TagMapper.class.getName() + ".getTagGroupAllChildListByTagId";
        List<TagGroupInfoBean> result = this.commonDao.selectList(state, parameter);
        // 填充标签组下的标签值列表
        this.attachTagValues2Group(result);
        return result;
    }

    @Override
    public List<TagGroupTreeNodeBean> getTagGroupOneChildTreeByTagId(final Long tagProductId, Boolean isDelte) {
        List<TagGroupInfoBean> tagLst = this.getTagGroupOneChildListByTagId(tagProductId, isDelte);
        return convertList2Tree(tagLst);
    }

    @Override
    public List<TagGroupTreeNodeBean> getTagGroupTwoChildTreeByTagId(final Long tagProductId, Boolean isDelte) {
        List<TagGroupInfoBean> tagLst = this.getTagGroupTwoChildListByTagId(tagProductId, isDelte);
        return convertList2Tree(tagLst);
    }

    @Override
    public List<TagGroupTreeNodeBean> getTagGroupAllChildTreeByTagId(final Long tagProductId, Boolean isDelte) {
        List<TagGroupInfoBean> tagLst = this.getTagGroupAllChildListByTagId(tagProductId, isDelte);
        return convertList2Tree(tagLst);
    }

    @Override
    public PageInfo<TagInfoBean> searchList(Map<String, String[]> params) {
        int page = 1, rows = 20;
        try {
            page = Integer.parseInt(params.get("page")[0]);
        } catch (Exception ignored) {
        }
        try {
            rows = Integer.parseInt(params.get("rows")[0]);
        } catch (Exception ignored) {
        }
        PageParam pageParam = new PageParam(page, rows);
        Long tagId = Long.parseLong(params.get("tagProductId")[0]);
        List<Long> tagProductId = new ArrayList<>();
        tagProductId.add(tagId);

        String state = TagMapper.class.getName() + ".getTagValueListByTagId";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("tagProductId", tagProductId);
        parameter.put("isDelte", false);
        return commonDao.selectPage(state, parameter, pageParam);
    }

    @Override
    public Long saveTag(TagInfoBean tagInfoBean) {
        Integer checkCount = this.commonDao.selectOne(TagMapper.class.getName() + ".checkSameName", tagInfoBean);
        AssertUtil.assertTrue(checkCount <= 0, "同层级下已有相同的标签名称");
        if (tagInfoBean.getTagProductId() == null) {
            String state = TagMapper.class.getName() + ".insertTagInfo";
            this.commonDao.insert(state, tagInfoBean);
        } else {
            String state = TagMapper.class.getName() + ".updateTagInfo";
            this.commonDao.update(state, tagInfoBean);
        }
        return tagInfoBean.getTagProductId();
    }

    @Override
    public Integer deleteTag(String ids) {
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
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("tagProductIds", idsValue);

        String state = TagMapper.class.getName() + ".checkHasCategory";
        Integer checHasShop = this.commonDao.selectOne(state, parameter);
        AssertUtil.assertTrue(checHasShop <= 0, "要删除的标签关联商品分类信息");
        state = TagMapper.class.getName() + ".checkHasChildren";
        Integer checkCount = this.commonDao.selectOne(state, parameter);
        AssertUtil.assertTrue(checkCount <= 0, "要删除的标签含有子标签或标签值");

        List<TagInfoBean> list = queryTagInfoByTagProductId(idsValue, null, null, false);
        AssertUtil.assertFalse(list != null && list.size() > 0, "要删除的标签含有子标签或标签值");

        state = TagMapper.class.getName() + ".deleteTagInfo";
        return this.commonDao.delete(state, idsValue);
    }

    /**
     * 给标签分组增加标签值列表
     *
     * @param tagGroup 标签分组列表
     */
    private void attachTagValues2Group(final List<TagGroupInfoBean> tagGroup) {
        // 填充标签组下的标签值列表
        if (tagGroup != null && tagGroup.size() > 0) {
            // 获取标签组ID列表
            List<Long> tagGroupIds = new ArrayList<Long>();
            for (TagGroupInfoBean tg : tagGroup) {
                tagGroupIds.add(tg.getTagProductId());
            }
            if (tagGroupIds.size() > 0) {
                // 根据标签组ID获取对应的标签值
                Map<Long, List<TagValueInfoBean>> values = this.getTagValueListByTagId(tagGroupIds, null);
                if (values != null && values.size() > 0) {
                    // 填充对应的标签值列表到标签组对象中
                    for (TagGroupInfoBean tg : tagGroup) {
                        List<TagValueInfoBean> tagValues = values.get(tg.getTagProductId());
                        if (tagValues != null) {
                            tg.setValues(tagValues);
                        }
                    }
                }
            }
        }
    }

    /**
     * 给树节点添加子节点
     *
     * @param tagNode 树节点
     * @param tagMap  PID分组数据
     */
    private void attachChildrens(final TagGroupTreeNodeBean tagNode, final Map<Long, List<TagGroupInfoBean>> tagMap) {
        // 非叶子节点才会有子节点
        if (tagNode != null && tagMap != null && tagMap.size() > 0) {
            // 获取所有子节点
            List<TagGroupInfoBean> childrens = tagMap.get(tagNode.getTagProductId());
            if (childrens != null) {
                List<TagGroupTreeNodeBean> nodeLst = new ArrayList<TagGroupTreeNodeBean>();
                for (TagGroupInfoBean children : childrens) {
                    TagGroupTreeNodeBean node = new TagGroupTreeNodeBean(children);
                    attachChildrens(node, tagMap);
                    nodeLst.add(node);
                }
                tagNode.setChildrens(nodeLst);
            }
        }
    }

    /**
     * 将平行的列表转换为树形（平行的列表必须以PID进行分组排序）
     *
     * @param tagLst 分类列表
     * @return
     */
    private List<TagGroupTreeNodeBean> convertList2Tree(final List<TagGroupInfoBean> tagLst) {
        // 菜单树
        List<TagGroupTreeNodeBean> tagTree = new ArrayList<TagGroupTreeNodeBean>();
        // 将以PID进行分组
        Map<Long, List<TagGroupInfoBean>> tagMap = new HashMap<Long, List<TagGroupInfoBean>>();
        Map<Long, Long> tagIds = new HashMap<Long, Long>();
        for (TagGroupInfoBean tagBean : tagLst) {
            tagIds.put(tagBean.getTagProductId(), tagBean.getTagProductId());
            List<TagGroupInfoBean> tmp = tagMap.get(tagBean.getParentId());
            if (tmp == null) {
                tmp = new ArrayList<TagGroupInfoBean>();
                tagMap.put(tagBean.getParentId(), tmp);
            }
            tmp.add(tagBean);
        }
        // 找到最上层为跟节点
        for (TagGroupInfoBean tagBean : tagLst) {
            Long tmp = tagIds.get(tagBean.getParentId());
            // 将PID为不存在的作为根级菜单
            if (tmp == null) {
                TagGroupTreeNodeBean categoryNode = new TagGroupTreeNodeBean(tagBean);
                tagTree.add(categoryNode);
            }
        }

        for (TagGroupTreeNodeBean tagNode : tagTree) {
            attachChildrens(tagNode, tagMap);
        }
        return tagTree;
    }

    @Override
    public List<TagInfoBean> queryTagInfoByTagProductId(List<Long> tagProductId, String systemCode, Boolean isGroup,
                                                        Boolean isDelte) {
        Map<String, Object> parameter = new HashMap<>();
        AssertUtil.assertTrue(tagProductId != null && tagProductId.size() > 0, "标签分类ID为空或不存在");
        parameter.put("tagProductId", tagProductId);

        if (StringUtil.isNotEmpty(systemCode)) {
            parameter.put("systemCode", systemCode);
        }
        if (isGroup != null) {
            parameter.put("isGroup", isGroup);
        }
        parameter.put("isDelte", isDelte);
        String state = TagMapper.class.getName() + ".queryTagInfoByTagProductId";
        return this.commonDao.selectList(state, parameter);
    }

}
