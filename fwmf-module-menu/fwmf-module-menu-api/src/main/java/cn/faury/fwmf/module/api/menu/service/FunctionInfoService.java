package cn.faury.fwmf.module.api.menu.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.menu.bean.FunctionInfoBean;

import java.util.List;
import java.util.Map;

/**
 * 服务接口：功能按钮信息表
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface FunctionInfoService extends CrudBaseService<FunctionInfoBean, Long> {

    /**
     * 根据功能按钮ID获取功能按钮信息
     *
     * @param systemId
     *            业务系统ID
     * @param menuId
     *            菜单ID
     * @param funcId
     *            功能按钮ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 功能按钮信息
     */
    @Read
    public FunctionInfoBean getMenuFuncInfoByFuncId(final Long systemId, final Long menuId, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据功能按钮ID获取功能按钮信息
     *
     * @param systemId
     *            业务系统ID
     * @param menuCode
     *            菜单编码
     * @param funcId
     *            功能按钮ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 功能按钮信息
     */
    @Read
    public FunctionInfoBean getMenuFuncInfoByFuncId(final Long systemId, final String menuCode, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据功能按钮ID获取功能按钮信息
     *
     * @param systemCode
     *            业务系统编码
     * @param menuId
     *            菜单ID
     * @param funcId
     *            功能按钮ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 功能按钮信息
     */
    @Read
    public FunctionInfoBean getMenuFuncInfoByFuncId(final String systemCode, final Long menuId, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据功能按钮ID获取功能按钮信息
     *
     * @param systemCode
     *            业务系统编码
     * @param menuCode
     *            菜单编码
     * @param funcId
     *            功能按钮ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 功能按钮信息
     */
    @Read
    public FunctionInfoBean getMenuFuncInfoByFuncId(final String systemCode, final String menuCode, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据功能按钮编码获取功能按钮信息
     *
     * @param systemId
     *            业务系统ID
     * @param menuId
     *            菜单ID
     * @param funcCode
     *            功能按钮编码
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 功能按钮信息
     */
    @Read
    public FunctionInfoBean getMenuFuncInfoByFuncCode(final Long systemId, final Long menuId, final String funcCode,
                                                      final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据功能按钮编码获取功能按钮信息
     *
     * @param systemId
     *            业务系统ID
     * @param menuCode
     *            菜单编码
     * @param funcCode
     *            功能按钮编码
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 功能按钮信息
     */
    @Read
    public FunctionInfoBean getMenuFuncInfoByFuncCode(final Long systemId, final String menuCode,
                                                      final String funcCode, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                      final Boolean isFuncAvailable);

    /**
     * 根据功能按钮编码获取功能按钮信息
     *
     * @param systemCode
     *            业务系统编码
     * @param menuId
     *            菜单ID
     * @param funcCode
     *            功能按钮编码
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 功能按钮信息
     */
    @Read
    public FunctionInfoBean getMenuFuncInfoByFuncCode(final String systemCode, final Long menuId,
                                                      final String funcCode, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                      final Boolean isFuncAvailable);

    /**
     * 根据功能按钮编码获取功能按钮信息
     *
     * @param systemCode
     *            业务系统编码
     * @param menuCode
     *            菜单编码
     * @param funcCode
     *            功能按钮编码
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 功能按钮信息
     */
    @Read
    public FunctionInfoBean getMenuFuncInfoByFuncCode(final String systemCode, final String menuCode,
                                                      final String funcCode, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                      final Boolean isFuncAvailable);

    /**
     * 根据菜单ID获取菜单功能按钮列表
     *
     * @param systemId
     *            业务系统ID
     * @param menuId
     *            菜单ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单的功能按钮列表
     */
    @Read
    public List<FunctionInfoBean> getMenuFuncListByMenuId(final Long systemId, final Long menuId,
                                                          final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单ID获取菜单功能按钮列表
     *
     * @param systemCode
     *            业务系统编码
     * @param menuId
     *            菜单ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单的功能按钮列表
     */
    @Read
    public List<FunctionInfoBean> getMenuFuncListByMenuId(final String systemCode, final Long menuId,
                                                          final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单ID获取菜单功能按钮分页列表
     *
     * @param param
     *            分页信息
     * @param systemId
     *            业务系统Id
     * @param menuId
     *            菜单ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单的功能按钮分页列表
     */
    public PageInfo<FunctionInfoBean> getMenuFuncPageListByMenuId(Map<String, String> param, final Long systemId,
                                                                  final Long menuId, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                                  final Boolean isFuncAvailable);

    /**
     * 根据菜单编码获取菜单功能按钮列表
     *
     * @param systemId
     *            业务系统ID
     * @param menuCode
     *            菜单编码
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单功能按钮列表
     */
    @Read
    public List<FunctionInfoBean> getMenuFuncListByMenuCode(final Long systemId, final String menuCode,
                                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单编码获取菜单功能按钮列表
     *
     * @param systemCode
     *            业务系统编码
     * @param menuCode
     *            菜单编码
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单功能按钮列表
     */
    @Read
    public List<FunctionInfoBean> getMenuFuncListByMenuCode(final String systemCode, final String menuCode,
                                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单ID获取子菜单功能按钮列表
     *
     * @param systemId
     *            业务系统ID
     * @param menuPId
     *            父菜单ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单的功能按钮列表
     */
    @Read
    public List<FunctionInfoBean> getChildMenuFuncListByMenuId(final Long systemId, final Long menuPId,
                                                               final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单ID获取子菜单功能按钮列表
     *
     * @param systemCode
     *            业务系统编码
     * @param menuPId
     *            父菜单ID
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单的功能按钮列表
     */
    @Read
    public List<FunctionInfoBean> getChildMenuFuncListByMenuId(final String systemCode, final Long menuPId,
                                                               final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单编码获取子菜单功能按钮列表
     *
     * @param systemId
     *            业务系统ID
     * @param menuPCode
     *            父菜单编码
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单功能按钮列表
     */
    @Read
    public List<FunctionInfoBean> getChildMenuFuncListByMenuCode(final Long systemId, final String menuPCode,
                                                                 final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 根据菜单编码获取子菜单功能按钮列表
     *
     * @param systemCode
     *            业务系统编码
     * @param menuPCode
     *            父菜单编码
     * @param isSystemAvailable
     *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isMenuAvailable
     *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @param isFuncAvailable
     *            功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * @return 菜单功能按钮列表
     */
    @Read
    public List<FunctionInfoBean> getChildMenuFuncListByMenuCode(final String systemCode, final String menuPCode,
                                                                 final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable);

    /**
     * 插入菜单的功能按钮信息
     *
     * <pre>
     * 对象参数：
     * 【不使用】funcId：功能菜单ID
     * 【必填】funcName：功能菜单名称
     * 【必填】funcCode：功能编码
     * 【必填】menuId：菜单ID
     * 【必填】systemId：业务系统ID
     * 【必填】isAvailable：是否可用【Y:是 N:否】
     * </pre>
     *
     * @param menuFuncInfo
     *            菜单功能按钮对象
     * @return 保存成功后业务系统对象ID，失败则返回-1
     */
    public Long insertMenuFuncInfo(final FunctionInfoBean menuFuncInfo);

    /**
     * 更新菜单的功能按钮信息
     *
     * <pre>
     * 更新规则：如果值为null或者''，则不更新该字段
     * 对象参数：
     * 【必填】funcId：功能菜单ID
     * 【可选】funcName：功能菜单名称
     * 【可选】funcCode：功能编码
     * 【可选】menuId：菜单ID
     * 【可选】systemId：业务系统ID
     * 【可选】isAvailable：是否可用【Y:是 N:否】
     * </pre>
     *
     * @param menuFuncInfo
     *            输入参数
     * @return 成功更新条数
     */
    public Integer updateMenuFuncInfo(final FunctionInfoBean menuFuncInfo);

    /**
     * 根据功能按钮ID删除功能按钮信息
     *
     * @param funcIds
     *            多个功能按钮ID
     * @return 成功删除个数
     */
    public Integer deleteMenuFuncInfoById(final List<Long> funcIds);

    /**
     * 根据菜单ID删除功能按钮信息
     *
     * @param menuIds
     *            多个菜单ID
     * @return 成功删除个数
     */
    public Integer deleteMenuFuncInfoByMenuId(final List<Long> menuIds);

    /**
     * 根据功能ID判断是否存在角色关联功能
     *
     * @param funcIds
     *            功能ID
     * @return
     */
    public Boolean isExistRoleRFunc(final List<Long> funcIds);

	/* ====================重载==================== */

    /**
     * 根据功能按钮ID获取功能按钮信息
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
     * @param funcId
     *            功能按钮ID
     * @return 功能按钮信息
     */
    @Read
    default public FunctionInfoBean getMenuFuncInfoByFuncId(final Long systemId, final Long menuId, final Long funcId){
        return getMenuFuncInfoByFuncId(systemId, menuId, funcId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据功能按钮ID获取功能按钮信息
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
     * @param funcId
     *            功能按钮ID
     * @return 功能按钮信息
     */
    @Read
    default public FunctionInfoBean getMenuFuncInfoByFuncId(final Long systemId, final String menuCode, final Long funcId){
        return getMenuFuncInfoByFuncId(systemId, menuCode, funcId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据功能按钮ID获取功能按钮信息
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
     * @param funcId
     *            功能按钮ID
     * @return 功能按钮信息
     */
    default public FunctionInfoBean getMenuFuncInfoByFuncId(final String systemCode, final Long menuId, final Long funcId){
        return getMenuFuncInfoByFuncId(systemCode, menuId, funcId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据功能按钮ID获取功能按钮信息
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
     * @param funcId
     *            功能按钮ID
     * @return 功能按钮信息
     */
    @Read
    default public FunctionInfoBean getMenuFuncInfoByFuncId(final String systemCode, final String menuCode, final Long funcId){
        return getMenuFuncInfoByFuncId(systemCode, menuCode, funcId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据功能按钮编码获取功能按钮信息
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
     * @param funcCode
     *            功能按钮编码
     * @return 功能按钮信息
     */
    @Read
    default public FunctionInfoBean getMenuFuncInfoByFuncCode(final Long systemId, final Long menuId, final String funcCode){
        return getMenuFuncInfoByFuncCode(systemId, menuId, funcCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据功能按钮编码获取功能按钮信息
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
     * @param funcCode
     *            功能按钮编码
     * @return 功能按钮信息
     */
    @Read
    default public FunctionInfoBean getMenuFuncInfoByFuncCode(final Long systemId, final String menuCode, final String funcCode){
        return getMenuFuncInfoByFuncCode(systemId, menuCode, funcCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据功能按钮编码获取功能按钮信息
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
     * @param funcCode
     *            功能按钮编码
     * @return 功能按钮信息
     */
    @Read
    default public FunctionInfoBean getMenuFuncInfoByFuncCode(final String systemCode, final Long menuId, final String funcCode){
        return getMenuFuncInfoByFuncCode(systemCode, menuId, funcCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据功能按钮编码获取功能按钮信息
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
     * @param funcCode
     *            功能按钮编码
     * @return 功能按钮信息
     */
    @Read
    default public FunctionInfoBean getMenuFuncInfoByFuncCode(final String systemCode, final String menuCode,
                                                              final String funcCode){
        return getMenuFuncInfoByFuncCode(systemCode, menuCode, funcCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单ID获取菜单功能按钮列表
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
     * @return 菜单的功能按钮列表
     */
    @Read
    default public List<FunctionInfoBean> getMenuFuncListByMenuId(final Long systemId, final Long menuId){
        return getMenuFuncListByMenuId(systemId, menuId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);

    }

    /**
     * 根据菜单ID获取菜单功能按钮列表
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
     * @return 菜单的功能按钮列表
     */
    @Read
    default public List<FunctionInfoBean> getMenuFuncListByMenuId(final String systemCode, final Long menuId){
        return getMenuFuncListByMenuId(systemCode, menuId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单编码获取菜单功能按钮列表
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
     * @return 菜单功能按钮列表
     */
    @Read
    default public List<FunctionInfoBean> getMenuFuncListByMenuCode(final Long systemId, final String menuCode){
        return getMenuFuncListByMenuCode(systemId, menuCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单编码获取菜单功能按钮列表
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
     * @return 菜单功能按钮列表
     */
    @Read
    default public List<FunctionInfoBean> getMenuFuncListByMenuCode(final String systemCode, final String menuCode){
        return getMenuFuncListByMenuCode(systemCode, menuCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单ID获取子菜单功能按钮列表
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
     * @param menuPId
     *            父菜单ID
     * @return 菜单的功能按钮列表
     */
    @Read
    default public List<FunctionInfoBean> getChildMenuFuncListByMenuId(final Long systemId, final Long menuPId){
        return getChildMenuFuncListByMenuId(systemId, menuPId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单ID获取子菜单功能按钮列表
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
     * @param menuPId
     *            父菜单ID
     * @return 菜单的功能按钮列表
     */
    @Read
    default public List<FunctionInfoBean> getChildMenuFuncListByMenuId(final String systemCode, final Long menuPId){
        return getChildMenuFuncListByMenuId(systemCode, menuPId, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单编码获取子菜单功能按钮列表
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
     * @param menuPCode
     *            父菜单编码
     * @return 菜单功能按钮列表
     */
    @Read
    default public List<FunctionInfoBean> getChildMenuFuncListByMenuCode(final Long systemId, final String menuPCode){
        return getChildMenuFuncListByMenuCode(systemId, menuPCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据菜单编码获取子菜单功能按钮列表
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
     * @param menuPCode
     *            父菜单编码
     * @return 菜单功能按钮列表
     */
    @Read
    default public List<FunctionInfoBean> getChildMenuFuncListByMenuCode(final String systemCode, final String menuPCode){
        return getChildMenuFuncListByMenuCode(systemCode, menuPCode, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据功能编码查询功能信息（判断功能编码是否存在）
     *
     * @param 【必填】funcCode 功能编码
     * @param 【可选】funcId 功能id
     * @return
     */
    @Read
    public FunctionInfoBean getMenuFuncInfoByFuncCode(final FunctionInfoBean menuFuncInfoBean);

}