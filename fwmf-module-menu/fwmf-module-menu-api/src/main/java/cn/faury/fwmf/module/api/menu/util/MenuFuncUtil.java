package cn.faury.fwmf.module.api.menu.util;

import cn.faury.fwmf.module.api.menu.bean.MenuFuncInfoBean;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.api.menu.bean.MenuTreeNodeBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单、功能按钮工具
 */
public class MenuFuncUtil {

	/**
	 * 给树节点添加子节点
	 * 
	 * @param menuNode
	 *            树节点
	 * @param menuMap
	 *            PID分组数据
	 */
	private static void attachChildrens(final MenuTreeNodeBean menuNode, final Map<Long, List<MenuInfoBean>> menuMap) {
		// 非叶子节点才会有子节点
		if (menuNode != null && menuMap != null && menuMap.size() > 0) {
			// 获取所有子节点
			List<MenuInfoBean> childrens = menuMap.get(menuNode.getMenuId());
			if (childrens != null) {
				List<MenuTreeNodeBean> nodeLst = new ArrayList<MenuTreeNodeBean>();
				for (MenuInfoBean menuBean : childrens) {
					MenuTreeNodeBean node = new MenuTreeNodeBean(menuBean);
					attachChildrens(node, menuMap);
					nodeLst.add(node);
				}
				menuNode.setChildrens(nodeLst);
			}
		}
	}

	/**
	 * 将平行的菜单信息列表转换为树形（平行的菜单列表必须以PID进行分组排序）
	 * 
	 * @param menuLst
	 *            菜单列表
	 * @return
	 */
	public static List<MenuTreeNodeBean> convertMenuList2Tree(final List<MenuInfoBean> menuLst) {
		// 菜单树
		List<MenuTreeNodeBean> menuTree = new ArrayList<MenuTreeNodeBean>();
		// 将以PID进行分组
		Map<Long, List<MenuInfoBean>> menuMap = new HashMap<Long, List<MenuInfoBean>>();
		Map<Long, Long> menuIds = new HashMap<Long, Long>();
		for (MenuInfoBean menuBean : menuLst) {
			menuIds.put(menuBean.getMenuId(), menuBean.getMenuId());
			List<MenuInfoBean> tmp = menuMap.get(menuBean.getMenuPid());
			if (tmp == null) {
				tmp = new ArrayList<MenuInfoBean>();
				menuMap.put(menuBean.getMenuPid(), tmp);
			}
			tmp.add(menuBean);
		}
		// 找到最上层为跟节点
		for (MenuInfoBean menuBean : menuLst) {
			Long tmp = menuIds.get(menuBean.getMenuPid());
			// 将PID为不存在的作为根级菜单
			if (tmp == null) {
				MenuTreeNodeBean menuNode = new MenuTreeNodeBean(menuBean);
				menuTree.add(menuNode);
			}
		}
		for (MenuTreeNodeBean menuNode : menuTree) {
			attachChildrens(menuNode, menuMap);
		}
		return menuTree;
	}

	/**
	 * 将菜单功能按钮分别添加到对应的菜单中去
	 * 
	 * @param funcs
	 *            所有的菜单功能按钮
	 * @param menuInfo
	 *            所有的菜单
	 */
	public static void attachMenuFuncs(List<MenuFuncInfoBean> funcs, List<MenuInfoBean> menuInfo) {
		if (funcs != null && funcs.size() > 0) {
			// 将功能按钮按照菜单ID进行分组
			Map<Long, List<MenuFuncInfoBean>> menuFuncs = new HashMap<Long, List<MenuFuncInfoBean>>();
			for (MenuFuncInfoBean bean : funcs) {
				List<MenuFuncInfoBean> tmpFuncs = menuFuncs.get(bean.getMenuId());
				if (tmpFuncs == null) {
					tmpFuncs = new ArrayList<MenuFuncInfoBean>();
					menuFuncs.put(bean.getMenuId(), tmpFuncs);
				}
				tmpFuncs.add(bean);
			}
			// 设置各个菜单的功能按钮清单
			for (MenuInfoBean bean : menuInfo) {
				List<MenuFuncInfoBean> tmpFuncs = menuFuncs.get(bean.getMenuId());
				if (tmpFuncs != null) {
					bean.setFuncs(tmpFuncs);
				}
			}
		}
	}

}
