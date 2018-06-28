package cn.faury.fwmf.module.api.menu.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 菜单信息对象
 */
public class MenuInfoBean implements Serializable {

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 上级菜单ID
     */
    private Long menuPid;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单所对应的ActionKey
     */
    private String menuActionKey;

    /**
     * 菜单编码
     */
    private String menuCode;

    /**
     * 菜单是否可用【0:不可用  1:可用】
     */
    private String isAvailable;

    /**
     * 是否末级【0:不是  1:是】
     */
    private String isLeaf;

    /**
     * 系统ID
     */
    private String systemId;

    /**
     * 排序
     */
    private String sort;

    /**
     * 功能按钮
     */
    private List<MenuFuncInfoBean> funcs = new ArrayList<>();

    /**
     * 获取menuId
     *
     * @return menuId
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置menuId
     *
     * @param menuId 值
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取menuPid
     *
     * @return menuPid
     */
    public Long getMenuPid() {
        return menuPid;
    }

    /**
     * 设置menuPid
     *
     * @param menuPid 值
     */
    public void setMenuPid(Long menuPid) {
        this.menuPid = menuPid;
    }

    /**
     * 获取menuName
     *
     * @return menuName
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置menuName
     *
     * @param menuName 值
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取menuActionKey
     *
     * @return menuActionKey
     */
    public String getMenuActionKey() {
        return menuActionKey;
    }

    /**
     * 设置menuActionKey
     *
     * @param menuActionKey 值
     */
    public void setMenuActionKey(String menuActionKey) {
        this.menuActionKey = menuActionKey;
    }

    /**
     * 获取menuCode
     *
     * @return menuCode
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * 设置menuCode
     *
     * @param menuCode 值
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * 获取isAvailable
     *
     * @return isAvailable
     */
    public String getIsAvailable() {
        return isAvailable;
    }

    /**
     * 设置isAvailable
     *
     * @param isAvailable 值
     */
    public void setIsAvailable(String isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * 获取isLeaf
     *
     * @return isLeaf
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置isLeaf
     *
     * @param isLeaf 值
     */
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 获取systemId
     *
     * @return systemId
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * 设置systemId
     *
     * @param systemId 值
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    /**
     * 获取sort
     *
     * @return sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置sort
     *
     * @param sort 值
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 获取funcs
     *
     * @return funcs
     */
    public List<MenuFuncInfoBean> getFuncs() {
        return funcs;
    }

    /**
     * 设置funcs
     *
     * @param funcs 值
     */
    public void setFuncs(List<MenuFuncInfoBean> funcs) {
        this.funcs = funcs;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}
