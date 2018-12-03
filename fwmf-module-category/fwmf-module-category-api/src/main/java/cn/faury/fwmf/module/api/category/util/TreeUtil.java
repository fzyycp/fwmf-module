package cn.faury.fwmf.module.api.category.util;

import cn.faury.fwmf.module.api.category.bean.CategoryInfoBean;
import cn.faury.fwmf.module.api.category.bean.CategoryTreeNodeBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeUtil {

    /**
     * 给树节点添加子节点
     *
     * @param categoryNode
     *            树节点
     * @param categoryMap
     *            PID分组数据
     */
    public static void attachChildrens(final CategoryTreeNodeBean categoryNode,
                                 final Map<Long, List<CategoryInfoBean>> categoryMap) {
        // 非叶子节点才会有子节点
        if (categoryNode != null && categoryMap != null && categoryMap.size() > 0) {
            // 获取所有子节点
            List<CategoryInfoBean> childrens = categoryMap.get(categoryNode.getProductCategoryId());
            if (childrens != null) {
                List<CategoryTreeNodeBean> nodeLst = new ArrayList<>();
                for (CategoryInfoBean children : childrens) {
                    CategoryTreeNodeBean node = new CategoryTreeNodeBean(children);
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
     * @param categoryLst
     *            分类列表
     * @return 树形森林
     */
    public static List<CategoryTreeNodeBean> convertList2Tree(final List<CategoryInfoBean> categoryLst) {
        // 菜单树
        List<CategoryTreeNodeBean> categoryTree = new ArrayList<>();
        // 将以PID进行分组
        Map<Long, List<CategoryInfoBean>> categoryMap = new HashMap<>();
        Map<Long, Long> categoryIds = new HashMap<>();
        for (CategoryInfoBean categoryBean : categoryLst) {
            categoryIds.put(categoryBean.getProductCategoryId(), categoryBean.getProductCategoryId());
            if (categoryBean.getProductCategoryId() == null) {
                System.out.println(categoryBean.toString());
            }
            List<CategoryInfoBean> tmp = categoryMap.computeIfAbsent(categoryBean.getParentId(), k -> new ArrayList<>());
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

}
