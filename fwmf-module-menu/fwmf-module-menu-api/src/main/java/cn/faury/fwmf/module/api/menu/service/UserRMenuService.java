
package cn.faury.fwmf.module.api.menu.service;

import cn.faury.fdk.common.entry.TreeNodeEntry;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;

import java.util.List;

/**
 * 角色关联菜单服务
 */
public interface UserRMenuService {

    /**
     * 根据用户ID获取系统授权菜单列表
     *
     * @param systemCode 系统编码
     * @param userId     用户ID
     * @return 授权菜单
     */
    List<MenuInfoBean> getMenuInfoByUserId(final String systemCode, final Long userId);

    /**
     * 根据用户ID获取系统授权菜单列表
     *
     * @param systemCode 系统编码
     * @param userId     用户ID
     * @return 授权菜单
     */
    List<TreeNodeEntry> getMenuTreeNodeByUserId(final String systemCode, final Long userId);
}
