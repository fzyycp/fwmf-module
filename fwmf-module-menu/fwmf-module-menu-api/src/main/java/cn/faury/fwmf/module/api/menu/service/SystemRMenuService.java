package cn.faury.fwmf.module.api.menu.service;


import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.api.menu.bean.MenuTreeNodeBean;
import cn.faury.fwmf.module.api.menu.util.MenuFuncUtil;

import java.util.List;
import java.util.Map;

/**
 * 菜单服务接口：根据业务系统来获取
 */
public interface SystemRMenuService {

	/**
	 * 根据业务系统编码获取<b><i>所有可用</i></b>的菜单列表
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>所有</i></b>的菜单；
	 * 菜单状态为<b><i>可用</i></b>；
	 * 菜单以<b><i>PID分组、列表</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统编码
	 * @return 菜单列表
	 */
	default public List<MenuInfoBean> getRootMenuListWithAllChildBySystemCode(final String systemCode){
        return getRootMenuListWithAllChildBySystemCode(systemCode, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据业务系统编码获取<b><i>所有可用</i></b>的菜单树
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>所有</i></b>的菜单；
	 * 菜单状态为<b><i>可用</i></b>；
	 * 菜单以<b><i>Tree</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统编码
	 * @return 菜单列表
	 */
	default public List<MenuTreeNodeBean> getRootMenuTreeWithAllChildBySystemCode(final String systemCode){
        return getRootMenuTreeWithAllChildBySystemCode(systemCode, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据业务系统编码获取<b><i>根及其子级可用</i></b>的菜单列表
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>根及其子级</i></b>的菜单；
	 * 菜单状态为<b><i>可用</i></b>；
	 * 菜单以<b><i>PID分组、列表</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统编码
	 * @return 菜单列表
	 */
	default public List<MenuInfoBean> getRootMenuListWithOneChildBySystemCode(final String systemCode){
        return getRootMenuListWithOneChildBySystemCode(systemCode, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据业务系统编码获取<b><i>根及其子级可用</i></b>的菜单树
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>根及其子级</i></b>的菜单；
	 * 各个菜单信息包含对应的子菜单信息
	 * 菜单状态为<b><i>可用</i></b>；
	 * 菜单以<b><i>Tree</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统编码
	 * @return 菜单列表
	 */
	default public List<MenuTreeNodeBean> getRootMenuTreeWithOneChildBySystemCode(final String systemCode){
        return getRootMenuTreeWithOneChildBySystemCode(systemCode, Boolean.TRUE, Boolean.TRUE);
    }


	/**
	 * 根据业务系统ID获取<b><i>根及其子级</i></b>的菜单列表
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>根及其子级</i></b>的菜单；
	 * 菜单以<b><i>PID分组、列表</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	public List<MenuInfoBean> getRootMenuListWithOneChildBySystemId(final Long systemId,
																	final Boolean isSystemAvailable, final Boolean isMenuAvailable);

	/**
	 * 根据业务系统编码获取<b><i>根及其子级</i></b>的菜单列表
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>根及其子级</i></b>的菜单；
	 * 菜单以<b><i>PID分组、列表</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统编码
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	public List<MenuInfoBean> getRootMenuListWithOneChildBySystemCode(final String systemCode,
																	  final Boolean isSystemAvailable, final Boolean isMenuAvailable);

	/**
	 * 根据业务系统ID获取<b><i>所有</i></b>的菜单列表
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>所有</i></b>的菜单；
	 * 菜单以<b><i>PID分组、列表</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	public List<MenuInfoBean> getRootMenuListWithAllChildBySystemId(final Long systemId,
																	final Boolean isSystemAvailable, final Boolean isMenuAvailable);

	/**
	 * 根据业务系统编码获取<b><i>所有</i></b>的菜单列表
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>所有</i></b>的菜单；
	 * 菜单以<b><i>PID分组、列表</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统编码
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	public List<MenuInfoBean> getRootMenuListWithAllChildBySystemCode(final String systemCode,
																	  final Boolean isSystemAvailable, final Boolean isMenuAvailable);

	/**
	 * 根据业务系统ID获取的菜单<b><i>分页</i></b>列表
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下菜单<b><i>分页</i></b>的列表；
	 * 菜单以<b><i>PID分组、列表</i></b>的形式返回；
	 * </pre>
	 *
	 * @param params
	 *            分页信息page和rows
	 * @param systemId
	 *            业务系统ID
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	@Read
	public PageInfo<MenuInfoBean> getMenuPageListBySystemId(Map<String, String> params, final Long systemId,
															final Boolean isSystemAvailable, final Boolean isMenuAvailable);

	/* ====================重载==================== */

	/**
	 * 根据业务系统ID获取<b><i>根及其子级可用</i></b>的菜单列表
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>根及其子级</i></b>的菜单；
	 * 菜单状态为<b><i>可用</i></b>；
	 * 菜单以<b><i>PID分组、列表</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @return 菜单列表
	 */
	default public List<MenuInfoBean> getRootMenuListWithOneChildBySystemId(final Long systemId){
        return getRootMenuListWithOneChildBySystemId(systemId, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据业务系统ID获取<b><i>所有可用</i></b>的菜单列表
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>所有</i></b>的菜单；
	 * 菜单状态为<b><i>可用</i></b>；
	 * 菜单以<b><i>PID分组、列表</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @return 菜单列表
	 */
	default public List<MenuInfoBean> getRootMenuListWithAllChildBySystemId(final Long systemId){
        return getRootMenuListWithAllChildBySystemId(systemId, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据业务系统ID获取<b><i>根及其子级</i></b>的菜单树（包含对应的子节点）
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>根及其子级</i></b>的菜单；
	 * 各个菜单信息包含对应的子菜单信息
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	default public List<MenuTreeNodeBean> getRootMenuTreeWithOneChildBySystemId(final Long systemId,
																		final Boolean isSystemAvailable, final Boolean isMenuAvailable){
        // 根据业务系统ID获取根菜单和对应的下级菜单列表
        List<MenuInfoBean> menuLst = getRootMenuListWithOneChildBySystemId(systemId, isSystemAvailable, isMenuAvailable);

        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据业务系统ID获取<b><i>所有</i></b>的菜单树
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>所有</i></b>的菜单；
	 * 菜单以<b><i>Tree</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	default public List<MenuTreeNodeBean> getRootMenuTreeWithAllChildBySystemId(final Long systemId,
																		final Boolean isSystemAvailable, final Boolean isMenuAvailable){
        // 根据业务系统ID获取根菜单和所有级联下级菜单列表
        List<MenuInfoBean> menuLst = getRootMenuListWithAllChildBySystemId(systemId, isSystemAvailable, isMenuAvailable);

        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据业务系统编码获取<b><i>根及其子级</i></b>的菜单树
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>根及其子级</i></b>的菜单；
	 * 各个菜单信息包含对应的子菜单信息
	 * 菜单以<b><i>Tree</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统编码
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	default public List<MenuTreeNodeBean> getRootMenuTreeWithOneChildBySystemCode(final String systemCode,
																		  final Boolean isSystemAvailable, final Boolean isMenuAvailable){
        // 根据业务系统ID获取根菜单和对应的下级菜单列表
        List<MenuInfoBean> menuLst = getRootMenuListWithOneChildBySystemCode(systemCode, isSystemAvailable,
                isMenuAvailable);

        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据业务系统编码获取<b><i>所有</i></b>的菜单树
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>所有</i></b>的菜单；
	 * 菜单以<b><i>Tree</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemCode
	 *            业务系统编码
	 * @param isSystemAvailable
	 *            系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @param isMenuAvailable
	 *            菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
	 * @return 菜单列表
	 */
	default public List<MenuTreeNodeBean> getRootMenuTreeWithAllChildBySystemCode(final String systemCode,
																		  final Boolean isSystemAvailable, final Boolean isMenuAvailable){
        // 根据业务系统ID获取根菜单和所有级联下级菜单列表
        List<MenuInfoBean> menuLst = getRootMenuListWithAllChildBySystemCode(systemCode, isSystemAvailable,
                isMenuAvailable);

        return MenuFuncUtil.convertMenuList2Tree(menuLst);
    }

	/**
	 * 根据业务系统ID获取<b><i>根及其子级可用</i></b>的菜单树（包含对应的子节点）
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>根及其子级</i></b>的菜单；
	 * 各个菜单信息包含对应的子菜单信息
	 * 菜单状态为<b><i>可用</i></b>；
	 * 菜单以<b><i>Tree</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @return 菜单列表
	 */
	default public List<MenuTreeNodeBean> getRootMenuTreeWithOneChildBySystemId(final Long systemId){
        return getRootMenuTreeWithOneChildBySystemId(systemId, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据业务系统ID获取<b><i>所有（可用、不可用）</i></b>的菜单树
	 *
	 * <pre>
	 * 【菜单】
	 * 获取业务系统下<b><i>所有</i></b>的菜单；
	 * 菜单状态为<b><i>所有</i></b>；
	 * 菜单以<b><i>Tree</i></b>的形式返回；
	 * </pre>
	 *
	 * @param systemId
	 *            业务系统ID
	 * @return 菜单列表
	 */
	default public List<MenuTreeNodeBean> getRootMenuTreeWithAllChildBySystemId(final Long systemId){
        return getRootMenuTreeWithAllChildBySystemId(systemId, null, null);
    }

}
