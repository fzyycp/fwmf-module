package cn.faury.fwmf.module.api.menu.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.api.menu.bean.MenuTreeNodeBean;
import cn.faury.fwmf.module.api.menu.util.MenuFuncUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 服务接口：菜单信息表
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface MenuInfoService extends CrudBaseService<MenuInfoBean, Long> {

    /**
     * 根据菜单ID获取菜单信息
     *
     * @param systemCode
     *            业务系统编码
     * @param menuId
     *            菜单ID
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单信息
     */
    @Read
    public MenuInfoBean getMenuInfoByMenuId(final String systemCode, final Long menuId, final Boolean isWithFunc,
                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单ID获取菜单信息
     *
     * <pre>
     * 【菜单】
     * 菜单状态为<b><i>可用</i></b>
     *
     * 【功能按钮】
     * 功能按钮状态为<b><i>可用</i></b>
     * </pre>
     *
     * @param systemCode
     *            业务系统编码
     * @param menuId
     *            菜单ID
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @return 菜单信息
     */
    @Read
    default public MenuInfoBean getMenuInfoByMenuId(final String systemCode, final Long menuId, final Boolean isWithFunc){
        return getMenuInfoByMenuId(systemCode, menuId, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }


    /**
     * 根据菜单ID获取菜单信息
     *
     * @param systemId
     *            业务系统ID
     * @param menuId
     *            菜单ID
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单信息
     */
    @Read
    public MenuInfoBean getMenuInfoByMenuId(final Long systemId, final Long menuId, final Boolean isWithFunc,
                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单编码获取菜单信息
     *
     * @param systemId
     *            业务系统ID
     * @param menuCode
     *            菜单编码
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单信息
     */
    @Read
    public MenuInfoBean getMenuInfoByMenuCode(final Long systemId, final String menuCode, final Boolean isWithFunc,
                                              final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单编码获取菜单信息
     *
     * @param systemCode
     *            业务系统编码
     * @param menuCode
     *            菜单编码
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单信息
     */
    @Read
    public MenuInfoBean getMenuInfoByMenuCode(final String systemCode, final String menuCode, final Boolean isWithFunc,
                                              final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单ID获取所有子菜单信息列表
     *
     * @param systemId
     *            业务系统ID
     * @param menuId
     *            菜单ID
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 子菜单信息列表
     */
    @Read
    public List<MenuInfoBean> getMenuChildInfoByMenuId(final Long systemId, final Long menuId,
                                                       final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                       final Boolean isFuncAvailable);

    /**
     * 根据菜单ID获取所有子菜单信息列表
     *
     * @param systemCode
     *            业务系统编码
     * @param menuId
     *            菜单ID
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 子菜单信息列表
     */
    @Read
    public List<MenuInfoBean> getMenuChildInfoByMenuId(final String systemCode, final Long menuId,
                                                       final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                       final Boolean isFuncAvailable);

    /**
     * 根据菜单ID获取所有子菜单信息<b><i>分页</i></b>列表
     *
     * @param param
     *            分页信息page和rows
     * @param systemId
     *            系统ID
     * @param menuId
     *            菜单ID
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单分页列表
     */
    @Read
    public PageInfo<MenuInfoBean> getMenuChildPageListByMenuId(Map<String, String> param, final Long systemId,
                                                               final Long menuId, final Boolean isWithFunc, final Boolean isSystemAvailable,
                                                               final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单编码获取所有子菜单信息列表
     *
     * @param systemId
     *            业务系统ID
     * @param menuCode
     *            菜单编码
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 子菜单信息列表
     */
    @Read
    public List<MenuInfoBean> getMenuChildInfoByMenuCode(final Long systemId, final String menuCode,
                                                         final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                         final Boolean isFuncAvailable);

    /**
     * 根据系统ID 菜单ID 获取2级子菜单信息列表
     *
     * @param systemId
     *            系统ID
     * @param menuId
     *            菜单ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单信息列表
     */
    @Read
    public List<MenuInfoBean> getMenuTowChildInfoByMenuId(final Long systemId, final Long menuId,
                                                          final Boolean isSystemAvailable, final Boolean isMenuAvailable);

    /**
     * 根据系统ID 菜单编码 获取2级子菜单信息列表
     *
     * @param systemId
     *            系统ID
     * @param menuCode
     *            菜单编码
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单信息列表
     */
    @Read
    public List<MenuInfoBean> getMenuTowChildInfoByMenuCode(final Long systemId, final String menuCode,
                                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable);

    /**
     * 根据系统编码 菜单编码 获取2级子菜单信息列表
     *
     * @param systemCode
     *            系统编码
     * @param menuCode
     *            菜单编码
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单信息列表
     */
    @Read
    public List<MenuInfoBean> getMenuTowChildInfoByMenuCode(final String systemCode, final String menuCode,
                                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable);

    /**
     * 根据系统编码 菜单Id 获取2级子菜单信息列表
     *
     * @param systemCode
     *            系统编码
     * @param menuId
     *            菜单ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单信息列表
     */
    @Read
    public List<MenuInfoBean> getMenuTowChildInfoByMenuId(final String systemCode, final Long menuId,
                                                          final Boolean isSystemAvailable, final Boolean isMenuAvailable);

    /**
     * 根据菜单编码获取所有子菜单信息列表
     *
     * @param systemCode
     *            业务系统编码
     * @param menuCode
     *            菜单编码
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 子菜单信息列表
     */
    @Read
    public List<MenuInfoBean> getMenuChildInfoByMenuCode(final String systemCode, final String menuCode,
                                                         final Boolean isWithFunc, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                         final Boolean isFuncAvailable);

    /**
     * 插入菜单信息
     *
     * <pre>
     * 对象参数：
     * 【不使用】menuId：菜单ID
     * 【必填】menuPid：父菜单ID，根目录请使用0
     * 【必填】menuName：菜单名称
     * 【必填】menuCode：菜单编码
     * 【必填】menuAction：菜单Action
     * 【必填】order：排序
     * 【必填】isLeaf：是否末级【Y:是 N:否】
     * 【必填】systemId：业务系统ID
     * 【必填】isAvailable：是否可用【Y:是 N:否】
     * </pre>
     *
     * @param menuInfo
     *            输入参数
     * @return 保存成功后业务系统对象ID，失败则返回-1
     */
    @Write
    public Long insertMenuInfo(final MenuInfoBean menuInfo);

    /**
     * 根据菜单ID更新菜单信息
     *
     * <pre>
     * 更新规则：如果值为null或者''，则不更新该字段
     * 对象参数：
     * 【必填】menuId：菜单ID
     * 【可选】menuPid：父菜单ID，根目录请使用0
     * 【可选】menuName：菜单名称
     * 【可选】menuCode：菜单编码
     * 【可选】menuAction：菜单Action
     * 【可选】order：排序
     * 【可选】isLeaf：是否末级【Y:是 N:否】
     * 【可选】systemId：业务系统ID
     * 【可选】isAvailable：是否可用【Y:是 N:否】
     * </pre>
     *
     * @param menuInfo
     *            输入参数
     * @return 成功更新条数
     */
    @Write
    public Integer updateMenuInfoById(final MenuInfoBean menuInfo);

    /**
     * 【物理删除】根据菜单ID删除菜单信息，同时删除菜单下功能按钮
     *
     * <pre>
     * 逻辑删除：即禁用，请参考{@link MenuInfoService#updateMenuInfoById(MenuInfoBean)}
     * </pre>
     *
     * @param menuIds
     *            多个菜单ID
     * @return 成功删除个数
     */
    @Write
    public Integer deleteMenuInfoById(final List<Long> menuIds);

    /**
     * 根据菜单功能编码获取菜单信息
     *
     * 【二选一】menuAction 菜单功能编码
     * 【二选一】menuCode 菜单编码
     * 【必选】systemId 系统id
     * 【可选】menuId 菜单id
     * @return
     */
    public List<MenuInfoBean> getMenuInfoByMenuBean(final Map<String, Object> param);

    /**
     * 根据菜单ID判断是否存在角色关联菜单
     *
     * @param menuIds
     *            菜单ID
     *
     * @return
     */
    public Boolean isExistRoleRMenu(final List<Long> menuIds);

	/* ====================重载==================== */

    /**
     * 根据菜单ID获取菜单信息
     *
     * <pre>
     * 【菜单】
     * 菜单状态为<b><i>可用</i></b>
     *
     * 【功能按钮】
     * 功能按钮状态为<b><i>可用</i></b>
     * </pre>
     *
     * @param systemId
     *            业务系统ID
     * @param menuId
     *            菜单ID
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @return 菜单信息
     */
    @Read
    default public MenuInfoBean getMenuInfoByMenuId(final Long systemId, final Long menuId, final Boolean isWithFunc){
        return getMenuInfoByMenuId(systemId, menuId, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单编码获取菜单信息
     *
     * <pre>
     * 【菜单】
     * 菜单状态为<b><i>可用</i></b>
     *
     * 【功能按钮】
     * 功能按钮状态为<b><i>可用</i></b>
     * </pre>
     *
     * @param systemId
     *            业务系统ID
     * @param menuCode
     *            菜单编码
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @return 菜单信息
     */
    @Read
    default public MenuInfoBean getMenuInfoByMenuCode(final Long systemId, final String menuCode, final Boolean isWithFunc){
        return getMenuInfoByMenuCode(systemId, menuCode, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单编码获取菜单信息
     *
     * <pre>
     * 【菜单】
     * 菜单状态为<b><i>可用</i></b>
     *
     * 【功能按钮】
     * 功能按钮状态为<b><i>可用</i></b>
     * </pre>
     *
     * @param systemCode
     *            业务系统编码
     * @param menuCode
     *            菜单编码
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @return 菜单信息
     */
    @Read
    default public MenuInfoBean getMenuInfoByMenuCode(final String systemCode, final String menuCode, final Boolean isWithFunc){
        return getMenuInfoByMenuCode(systemCode, menuCode, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单ID获取所有子菜单信息列表
     *
     * <pre>
     * 【菜单】
     * 菜单状态为<b><i>可用</i></b>
     *
     * 【功能按钮】
     * 功能按钮状态为<b><i>可用</i></b>
     * </pre>
     *
     * @param systemId
     *            业务系统ID
     * @param menuId
     *            菜单ID
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @return 子菜单信息列表
     */
    @Read
    default public List<MenuInfoBean> getMenuChildInfoByMenuId(final Long systemId, final Long menuId, final Boolean isWithFunc){
        return getMenuChildInfoByMenuId(systemId, menuId, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单ID获取所有子菜单信息列表
     *
     * <pre>
     * 【菜单】
     * 菜单状态为<b><i>可用</i></b>
     *
     * 【功能按钮】
     * 功能按钮状态为<b><i>可用</i></b>
     * </pre>
     *
     * @param systemCode
     *            业务系统编码
     * @param menuId
     *            菜单ID
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @return 子菜单信息列表
     */
    @Read
    default public List<MenuInfoBean> getMenuChildInfoByMenuId(final String systemCode, final Long menuId,
                                                               final Boolean isWithFunc){
        return getMenuChildInfoByMenuId(systemCode, menuId, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单编码获取所有子菜单信息列表
     *
     * <pre>
     * 【菜单】
     * 菜单状态为<b><i>可用</i></b>
     *
     * 【功能按钮】
     * 功能按钮状态为<b><i>可用</i></b>
     * </pre>
     *
     * @param systemId
     *            业务系统ID
     * @param menuCode
     *            菜单编码
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @return 子菜单信息列表
     */
    @Read
    default public List<MenuInfoBean> getMenuChildInfoByMenuCode(final Long systemId, final String menuCode,
                                                                 final Boolean isWithFunc){
        return getMenuChildInfoByMenuCode(systemId, menuCode, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单编码获取所有子菜单信息列表
     *
     * <pre>
     * 【菜单】
     * 菜单状态为<b><i>可用</i></b>
     *
     * 【功能按钮】
     * 功能按钮状态为<b><i>可用</i></b>
     * </pre>
     *
     * @param systemCode
     *            业务系统编码
     * @param menuCode
     *            菜单编码
     * @param isWithFunc
     *            是否包含功能按钮【Boolean.TRUE:包含，否则不包含】
     * @return 子菜单信息列表
     */
    @Read
    default public List<MenuInfoBean> getMenuChildInfoByMenuCode(final String systemCode, final String menuCode,
                                                                 final Boolean isWithFunc){
        return getMenuChildInfoByMenuCode(systemCode, menuCode, isWithFunc, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单ID删除菜单信息，同时删除菜单下功能按钮
     *
     * @param menuId
     *            菜单ID
     * @return 成功删除个数
     */
    @Write
    default public Integer deleteMenuInfoById(final Long menuId){
        return deleteMenuInfoById(Arrays.asList(menuId));
    }

    /**
     * 【物理删除】根据菜单ID删除菜单信息
     *
     * <pre>
     * 菜单下面有子菜单，不予删除
     * </pre>
     *
     * @param menuId
     * @param systemId
     * @return
     */
    @Write
    public Integer deleteMenuInfoById(final Long menuId, final Long systemId);

    /**
     * 根据系统ID 菜单ID 获取菜单下面的2级菜单树
     *
     * @param systemId
     *            系统Id
     * @param menuId
     *            菜单Id
     * @return 菜单树
     */
    @Read
    default public List<MenuTreeNodeBean> getMenuTowChildInfoByMenuId(final Long systemId, final Long menuId){
        List<MenuInfoBean> menuLst = getMenuTowChildInfoByMenuId(systemId, menuId, true, true);

        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

    /**
     * 根据系统编码 菜单编码 获取菜单下面的2级菜单树
     *
     * @param systemCode
     *            系统编码
     * @param menuCode
     *            菜单编码
     * @return 菜单树
     */
    @Read
    default public List<MenuTreeNodeBean> getMenuTowChildInfoByMenuCode(final String systemCode, final String menuCode){
        List<MenuInfoBean> menuLst = getMenuTowChildInfoByMenuCode(systemCode, systemCode, true, true);

        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

    /**
     * 根据系统编码 菜单ID 获取菜单下面的2级菜单树
     *
     * @param systemCode
     *            系统编码
     * @param menuId
     *            菜单Id
     * @return 菜单树
     */
    @Read
    default public List<MenuTreeNodeBean> getMenuTowChildInfoByMenuId(final String systemCode, final Long menuId){
        List<MenuInfoBean> menuLst = getMenuTowChildInfoByMenuId(systemCode, menuId, true, true);

        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

    /**
     * 根据系统Id 菜单编码 获取菜单下面的2级菜单树
     *
     * @param systemId
     *            系统ID
     * @param menuCode
     *            菜单编码
     * @return 菜单树
     */
    @Read
    default public List<MenuTreeNodeBean> getMenuTowChildInfoByMenuCode(final Long systemId, final String menuCode){
        List<MenuInfoBean> menuLst = getMenuTowChildInfoByMenuCode(systemId, menuCode, true, true);

        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

}