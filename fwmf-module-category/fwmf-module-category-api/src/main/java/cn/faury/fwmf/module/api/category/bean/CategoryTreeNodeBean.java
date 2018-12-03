package cn.faury.fwmf.module.api.category.bean;

import cn.faury.fdk.common.utils.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分类树形结构数据
 */
public class CategoryTreeNodeBean extends CategoryInfoBean {

    /**
     * 子分类节点
     */
    private List<CategoryTreeNodeBean> childrens;

    /**
     * 节点属性
     */
    private Map<String, String> attributes;

    /**
     * 构造函数
     */
    public CategoryTreeNodeBean() {
        childrens = new ArrayList<>();
        attributes = new HashMap<>();
    }

    /**
     * 拷贝构造函数
     *
     * @param categoryInfoBean 复制的分类信息Bean
     */
    public CategoryTreeNodeBean(CategoryInfoBean categoryInfoBean) {
        this();
        if (categoryInfoBean != null) {
            this.setParentName(categoryInfoBean.getParentName());
            this.setProductCategoryId(categoryInfoBean.getProductCategoryId());
            this.setProductCategoryName(categoryInfoBean.getProductCategoryName());
            this.setDisplayOrder(categoryInfoBean.getDisplayOrder());
            this.setParentId(categoryInfoBean.getParentId());
            this.setUsageCode(categoryInfoBean.getUsageCode());
            this.setIsDelete(categoryInfoBean.getIsDelete());
            this.setXpath(categoryInfoBean.getXpath());
        }
    }

    /**
     * 添加子节点
     *
     * @param categoryInfoBean 子节点对象
     */
    public void addChildrens(CategoryInfoBean categoryInfoBean) {
        if (categoryInfoBean != null) {
            if (childrens == null) {
                childrens = new ArrayList<>();
            }
            CategoryTreeNodeBean children = new CategoryTreeNodeBean(categoryInfoBean);
            children.setParentName(this.getProductCategoryName());
            children.setParentId(this.getParentId());
            children.setXpath(String.format("%s/%s",this.getXpath(),this.getProductCategoryId()));
            childrens.add(children);
        }
    }

    /**
     * 设置节点属性
     *
     * @param key   属性KEY
     * @param value 属性内容
     */
    public void putAttributes(String key, String value) {
        if (StringUtil.isNotEmpty(key)) {
            if (attributes == null) {
                attributes = new HashMap<>();
            }
            attributes.put(key, value);
        }
    }

    /**
     * 获取childrens
     *
     * @return childrens
     */
    public List<CategoryTreeNodeBean> getChildrens() {
        return childrens;
    }

    /**
     * 设置childrens
     *
     * @param childrens 值
     */
    public void setChildrens(List<CategoryTreeNodeBean> childrens) {
        this.childrens = childrens;
    }

    /**
     * 获取attributes
     *
     * @return attributes
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * 设置attributes
     *
     * @param attributes 值
     */
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
