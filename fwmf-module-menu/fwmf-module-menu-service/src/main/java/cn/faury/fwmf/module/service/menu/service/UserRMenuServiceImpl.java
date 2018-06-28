package cn.faury.fwmf.module.service.menu.service;

import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.entry.TreeNodeEntry;
import cn.faury.fdk.common.exception.TipsException;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.api.menu.service.UserRMenuService;
import cn.faury.fwmf.module.service.menu.mapper.UserRMenuMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户关联菜单服务实现
 */
public class UserRMenuServiceImpl implements UserRMenuService {
    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public UserRMenuServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 根据用户ID获取系统授权菜单列表
     *
     * @param systemCode 系统编码
     * @param userId     用户ID
     * @return 授权菜单
     */
    @Override
    public List<MenuInfoBean> getMenuInfoByUserId(String systemCode, Long userId) {
        if (userId==null || userId<=0L) {
            throw new TipsException(RestResultCode.CODE500.getCode(),"系统错误","用户ID参数错误");
        }
        if (StringUtil.isEmpty(systemCode)) {
            throw new TipsException(RestResultCode.CODE500.getCode(),"系统错误","系统Code参数错误");
        }
        String state = UserRMenuMapper.class.getName() + ".getMenuInfoByUserId";
        Map<String, Object> param = new HashMap<>();
        param.put("systemCode",systemCode);
        param.put("userId",userId);
        return this.commonDao.selectList(state, param);
    }

    /**
     * 根据用户ID获取系统授权菜单列表
     *
     * @param systemCode 系统编码
     * @param userId     用户ID
     * @return 授权菜单
     */
    @Override
    public List<TreeNodeEntry> getMenuTreeNodeByUserId(String systemCode, Long userId) {
        List<TreeNodeEntry> tmenus = new ArrayList<>();

        List<MenuInfoBean> menus = this.getMenuInfoByUserId(systemCode,userId);

        // 找出所有根节点
        Map<Long,TreeNodeEntry> pnode = new HashMap<>();
        for(MenuInfoBean menu:menus){
            if(menu.getMenuPid()==0){
                TreeNodeEntry tmenu = new TreeNodeEntry(menu.getMenuActionKey(),menu.getMenuName(),false);
                tmenu.setChildren(new ArrayList<>());
                tmenus.add(tmenu);
                pnode.put(menu.getMenuId(),tmenu);
            }
        }

        // 找出所有二级菜单
        for(MenuInfoBean menu:menus){
            if(menu.getMenuPid()>0){
                // 添加子节点
                TreeNodeEntry tmenu = pnode.get(menu.getMenuPid());
                if(tmenu!=null){
                    TreeNodeEntry cmenu = new TreeNodeEntry(menu.getMenuActionKey(),menu.getMenuName(),false);
                    tmenu.getChildren().add(cmenu);
                }
            }
        }

        return tmenus;
    }


}
