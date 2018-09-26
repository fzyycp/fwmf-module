package cn.faury.fwmf.module.api.menu.bean;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单TreeNodeBean
 */
public class MenuTreeNodeBean extends MenuInfoBean implements Serializable {

	/**
     * 序列化
     */
	private static final long serialVersionUID = -1724473717869837788L;

	/**
	 * 子菜单功能按钮列表
	 */
	private List<MenuTreeNodeBean> childrens;

	/**
	 * 构造函数
	 */
	public MenuTreeNodeBean() {
	}

	/**
	 * 拷贝构造函数
	 * 
	 * @param menuInofBean
	 *            菜单信息
	 */
	public MenuTreeNodeBean(final MenuInfoBean menuInofBean) {
		if (menuInofBean != null) {
			this.setMenuId(menuInofBean.getMenuId());
			this.setMenuPid(menuInofBean.getMenuPid());
			this.setMenuName(menuInofBean.getMenuName());
			this.setMenuCode(menuInofBean.getMenuCode());
			this.setMenuActionKey(menuInofBean.getMenuActionKey());
			this.setSort(menuInofBean.getSort());
			this.setIsLeaf(menuInofBean.getIsLeaf());
			this.setSystemId(menuInofBean.getSystemId());
			this.setIsAvailable(menuInofBean.getIsAvailable());
			this.setFunctionInfoBeans(menuInofBean.getFunctionInfoBeans());
			this.setChildrens(new ArrayList<>());
		}
	}

	/**
	 * @return the childrens
	 */
	public List<MenuTreeNodeBean> getChildrens() {
		return childrens;
	}

	/**
	 * @param childrens
	 *            the childrens to set
	 */
	public void setChildrens(final List<MenuTreeNodeBean> childrens) {
		this.childrens = childrens;
	}
}
