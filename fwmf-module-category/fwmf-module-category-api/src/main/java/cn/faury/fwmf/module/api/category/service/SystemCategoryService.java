package cn.faury.fwmf.module.api.category.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.category.bean.SystemCategoryBean;
import cn.faury.fwmf.module.api.category.bean.SystemCategoryTreeBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统商品分类授权服务协议
 */
public interface SystemCategoryService {

    /**
     * 根据业务系统systemCode获取所有业务系统下已授权分类信息 ，返回list
     *
     * @param systemCode 业务系统systemCode
     * @return 业务系统下分类信息 以<b>List</b>展示
     */
    @Read
    public List<SystemCategoryBean> getSystemCategory(final String systemCode);

    /**
     * 根据业务系统Code 获取所有业务系统下已授权分类信息，返回tree
     *
     * @param systemCode 业务系统Code
     * @return 业务系统下分类信息 以<b>Tree</b>展示
     */
    @Read
    default public List<SystemCategoryTreeBean> getSystemCategoryTreelist(final String systemCode){
        List<SystemCategoryBean> resList = getSystemCategory(systemCode);
        return convertSystemCategoryTree(resList);
    }

    /**
     * 根据分类ID获取当前业务系统下<b>已授权</b>子分类
     *
     * @param systemCode 系统code
     * @param categoryId 分类ID 该参数不传则表示默认查询业务系统下所有分类信息。
     * @return 分类信息
     */
    @Read
    public List<SystemCategoryBean> getCategoryAllBySystemCodeAndCId(final String systemCode, final Long categoryId);

    /**
     * 根据分类ID获取当前业务系统下<b>已授权</b>子分类树
     * <p>
     * <pre>
     * 获取分类ID下<b><i>所有</i></b>子分类；
     * 分类以<b><i>tree</i></b>的形式返回；
     * </pre>
     *
     * @param systemCode 系统code
     * @param categoryId 分类ID 该参数不传则表示默认查询业务系统下所有分类信息。
     * @return 分类树
     */
    @Read
    default public List<SystemCategoryTreeBean> getCategoryAllBySystemCodeAndCIdTreeList(final String systemCode,
                                                                                 final Long categoryId){
        List<SystemCategoryBean> categoryList = this.getCategoryAllBySystemCodeAndCId(systemCode, categoryId);
        return convertSystemCategoryTree(categoryList);
    }

    /**
     * 获取所有业务系统下分类信息
     *
     * @return 业务系统下分类信息 以<b>List</b>展示
     */
    @Read
    public List<SystemCategoryBean> getAllSystemCategory() ;

    /**
     * 根据业务系统Id获取所有业务系统下分类信息
     *
     * @param systemId 业务系统ID
     * @return 业务系统下分类信息 以<b>List</b>展示
     */
    @Read
    public List<SystemCategoryBean> getSystemCategory(final Long systemId);

    /**
     * 保存系统商品分类授权
     *
     * @param systemId        系统Id
     * @param sysCategoryList 多个系统商品分类授权实体Bean
     *                        <p>
     *                        <pre>
     *                                                          systemId 业务系统ID
     *                                                          isLeaf 是否叶子节点 是：Y 否：N
     *                                                          productCategoryId 分类Id
     *                                                          templateId 用途ID
     *                                               </pre>
     * @param templateId      用途ID
     * @return
     */
    @Write
    public Long saveSystemCategoryInfo(final Long systemId, final List<SystemCategoryBean> sysCategoryList,
                                       final Long templateId);

    /**
     * 根据系统ID删除业务系统下所有商品分类授权
     *
     * @param systemId   业务系统Id
     * @param templateId 用途ID
     * @return 返回删除的记录数（count）
     */
    @Write
    public Long deleteSystemCategoryInfo(final Long systemId, final Long templateId);

    /**
     * 根据业务系统Code 获取所有业务系统分类信息
     *
     * @return 业务系统下分类信息 以<b>Tree</b>展示
     */
    @Read
    default public List<SystemCategoryTreeBean> getSystemCategoryTreelist(final Long systemId){
        List<SystemCategoryBean> resList = getSystemCategory(systemId);
        return convertSystemCategoryTree(resList);
    }

    /**
     * 将平行树 转换 tree展示
     *
     * @param resList
     * @return
     */
    default List<SystemCategoryTreeBean> convertSystemCategoryTree(List<SystemCategoryBean> resList) {
        List<SystemCategoryTreeBean> cateTree = new ArrayList<SystemCategoryTreeBean>();
        Map<Long, List<SystemCategoryBean>> cateMap = new HashMap<Long, List<SystemCategoryBean>>();
        Map<Long, Long> cateIds = new HashMap<Long, Long>();
        for (SystemCategoryBean cate : resList) {
            cateIds.put(cate.getProductCategoryId(), cate.getProductCategoryId());
            List<SystemCategoryBean> temp = cateMap.get(cate.getParentId());
            if (temp == null) {
                temp = new ArrayList<SystemCategoryBean>();
                cateMap.put(cate.getParentId(), temp);
            }
            temp.add(cate);
        }
        for (SystemCategoryBean cate : resList) {
            Long temp = cateIds.get(cate.getParentId());
            if (temp == null) {
                SystemCategoryTreeBean tree = new SystemCategoryTreeBean(cate);
                cateTree.add(tree);
            }
        }
        for (SystemCategoryTreeBean tree : cateTree) {
            attachChildrens(tree, cateMap);
        }
        return cateTree;
    }
    /**
     * 添加子节点
     *
     * @param cate
     * @param cateMap
     */
    default void attachChildrens(final SystemCategoryTreeBean cate,
                                 final Map<Long, List<SystemCategoryBean>> cateMap) {
        if (cate != null && cateMap != null && cateMap.size() > 0) {
            List<SystemCategoryBean> childrens = cateMap.get(cate.getProductCategoryId());
            if (childrens != null) {
                List<SystemCategoryTreeBean> treeList = new ArrayList<>();
                for (SystemCategoryBean systemCategoryBean : childrens) {
                    SystemCategoryTreeBean tree = new SystemCategoryTreeBean(systemCategoryBean);
                    attachChildrens(tree, cateMap);
                    treeList.add(tree);
                }
                cate.setChildrens(treeList);
            }
        }
    }

}
