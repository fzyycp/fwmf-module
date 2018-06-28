package cn.faury.fwmf.module.api.category.service;


import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.category.bean.SystemTagBean;
import cn.faury.fwmf.module.api.category.bean.SystemTagTreeBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统商品标签授权服务协议
 */
public interface SystemTagService {

	/**
	 * 根据业务系统Code获取所有业务系统下标签信息
	 * 
	 * @param systemCode
	 *            业务系统Code
	 * 
	 * @return 业务系统下标签信息 以<b>List</b>展示
	 */
	@Read
	public List<SystemTagBean> getSystemTagInfo(final String systemCode);

	/**
	 * 根据业务系统Code获取所有业务系统下标签信息
	 * 
	 * @param systemCode
	 *            业务系统Code
	 * @return 业务系统下标签信息 以<b>Tree</b>展示
	 */
	@Read
	default public List<SystemTagTreeBean> getSystemTagTreeList(final String systemCode){
		List<SystemTagBean> resList = getSystemTagInfo(systemCode);
		return convertSystemTagTree(resList);
	}

	/**
	 * 根据系统code获取指定标签授权信息
	 * 
	 * @param systemCode
	 *            系统Code
	 * @param tagId
	 *            标签Id
	 * @return
	 */
	@Read
	public List<SystemTagBean> getSystemTagInfo(final String systemCode, final Long tagId);

	/**
	 * 根据系统code获取标签授权信息 以<i>Tree</i>展示
	 * 
	 * @param systemCode
	 *            系统Code
	 * @param tagId
	 *            标签Id
	 * @return 商品标签授权信息 以<i>Tree</i>展示
	 */
	@Read
	default public List<SystemTagTreeBean> getSystemTagInfoTreeList(final String systemCode, final Long tagId){
		List<SystemTagBean> systemTagInfo = getSystemTagInfo(systemCode, tagId);
		return convertSystemTagTree(systemTagInfo);
	}
	/**
	 * 获取所有业务系统下标签信息
	 *
	 * @return 业务系统下标签信息 以<b>List</b>展示
	 */
	@Read
	public List<SystemTagBean> getAllSystemTagInfo();

	/**
	 * 根据业务系统Id获取所有业务系统下标签信息
	 *
	 * @param systemId
	 *            业务系统ID
	 *
	 * @return 业务系统下标签信息 以<b>List</b>展示
	 */
	@Read
	public List<SystemTagBean> getSystemTagInfo(final Long systemId);

	/**
	 * 保存系统商品标签授权
	 *
	 * @param systemId
	 *            系统ID
	 * @param tagList
	 *            商品标签Bean的List
	 * @return 是否保存成功
	 */
	@Write
	public Long saveSystemTagInfo(final Long systemId, final List<SystemTagBean> tagList);

	/**
	 * 根据系统Id删除业务系统下所有商品标签授权
	 *
	 * @param systemId
	 *            系统ID
	 * @return 返回删除记录数大于0表示删除成功，否则失败
	 */
	@Write
	public Long deleteSystemTagInfo(final Long systemId);

	/**
	 * 将平行的列表信息转换tree
	 *
	 * @param resList
	 * @return
	 */
	default List<SystemTagTreeBean> convertSystemTagTree(List<SystemTagBean> resList) {
		List<SystemTagTreeBean> cateTree = new ArrayList<SystemTagTreeBean>();
		Map<Long, List<SystemTagBean>> cateMap = new HashMap<Long, List<SystemTagBean>>();
		Map<Long, Long> cateIds = new HashMap<Long, Long>();
		for (SystemTagBean cate : resList) {
			cateIds.put(cate.getTagProductId(), cate.getTagProductId());
			List<SystemTagBean> temp = cateMap.get(cate.getParentId());
			if (temp == null) {
				temp = new ArrayList<SystemTagBean>();
				cateMap.put(cate.getParentId(), temp);
			}
			temp.add(cate);
		}
		for (SystemTagBean cate : resList) {
			Long temp = cateIds.get(cate.getParentId());
			if (temp == null) {
				SystemTagTreeBean tree = new SystemTagTreeBean(cate);
				cateTree.add(tree);
			}
		}

		for (SystemTagTreeBean tree : cateTree) {
			attachChildrens(tree, cateMap);
		}
		return cateTree;
	}

	/**
	 * @param tree
	 * @param cateMap
	 */
	default void attachChildrens(SystemTagTreeBean cate, Map<Long, List<SystemTagBean>> cateMap) {
		if (cate != null && cateMap != null && cateMap.size() > 0) {
			List<SystemTagBean> childrens = cateMap.get(cate.getTagProductId());
			if (childrens != null) {
				List<SystemTagTreeBean> treeList = new ArrayList<SystemTagTreeBean>();
				for (SystemTagBean systemCategoryBean : childrens) {
					SystemTagTreeBean tree = new SystemTagTreeBean(systemCategoryBean);
					attachChildrens(tree, cateMap);
					treeList.add(tree);
				}
				cate.setChildrens(treeList);
			}
		}
	}

}
