package cn.faury.fwmf.module.service.menu.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfMenu;
import cn.faury.fwmf.module.service.menu.generate.mapper.MenuInfoGenerateMapper;
import cn.faury.fwmf.module.service.menu.sqlProvider.MenuInfoSqlProvider;
import cn.faury.fwmf.module.service.menu.sqlProvider.MenuInfoSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：菜单信息表
 *
 * <pre>
 *     MenuInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自MenuInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface MenuInfoMapper extends MenuInfoGenerateMapper {

    /**
     * 根据菜单参数获取菜单信息
     *
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @return 菜单信息
     */
    @SelectProvider(type = MenuInfoSqlProvider.class, method = "getMenuInfoByMenu")
    @ResultType(MenuInfoBean.class)
    public MenuInfoBean getMenuInfoByMenu();

    /**
     * 根据菜单参数获取子菜单信息
     *
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @return 子菜单信息
     */
    @SelectProvider(type = MenuInfoSqlProvider.class, method = "getMenuChildInfoByMenu")
    @ResultType(MenuInfoBean.class)
    public List<MenuInfoBean> getMenuChildInfoByMenu();

    /**
     * 根据菜单功能编码获取菜单信息
     *
     * 【二选一】menuAction 菜单功能编码
     * 【二选一】menuCode 菜单编码
     * 【必选】systemId 系统id
     * 【可选】menuId 菜单id
     */
    @SelectProvider(type = MenuInfoSqlProvider.class, method = "getMenuInfoByMenuBean")
    @ResultType(MenuInfoBean.class)
    public MenuInfoBean getMenuInfoByMenuBean();

    /**
     * 根据菜单ID查询菜单关联角色的数量
     */
    @SelectProvider(type = MenuInfoSqlProvider.class, method = "getMenuCountById")
    public int getMenuCountById();

    /**
     * 插入菜单信息
     *
     * <pre>
     * 可能出现的参数：
     * menuPid：父菜单ID，根目录请使用0
     * menuName：菜单名称
     * menuCode：菜单编码
     * menuAction：菜单Action
     * order：排序
     * isLeaf：是否末级【Y:是 N:否】
     * systemId：业务系统ID
     * isAvailable：是否可用【Y:是 N:否】
     * </pre>
     *
     * @param menuInfo
     *            菜单信息
     * @return 菜单id
     */
    @Insert("INSERT INTO "
            + DBConstOfMenu.TN_MENU_INFO
            + " (`MENU_PID`, `MENU_NAME`,`MENU_ACTION_KEY`, `MENU_CODE`,`IS_AVAILABLE`,`IS_LEAF`,`SYSTEM_ID`,`SORT`) VALUES "
            + "(#{menuPid,jdbcType=BIGINT}, #{menuName},#{menuAction}, #{menuCode}, #{isAvailable}, #{isLeaf}, #{systemId,jdbcType=BIGINT}, #{order})")
    @Options(keyProperty = "menuId", useGeneratedKeys = true)
    public Integer insertMenuInfo(final MenuInfoBean menuInfo);

    /**
     * 修改菜单信息
     *
     * <pre>
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
     *            菜单信息对象
     * @return 成功更新条数
     */
    @SelectProvider(type = MenuInfoSqlProvider.class, method = "updateMenuInfoById")
    public Integer updateMenuInfoById(final MenuInfoBean menuInfo);

    /**
     * 1.【物理删除】根据菜单ID删除菜单信息，同时删除菜单下功能按钮
     *
     * @param parameter
     *            输入参数
     *
     * @return 成功删除条数
     */
    @SelectProvider(type = MenuInfoSqlProvider.class, method = "deleteMenuInfoById")
    public Integer deleteMenuInfoById(Map<String, Object> parameter);

    /**
     * 2.【物理删除】根据菜单ID删除菜单信息，同时删除菜单下功能按钮
     *
     * @param parameter
     *            输入参数
     *
     * @return 成功删除条数
     */
    @SelectProvider(type = MenuInfoSqlProvider.class, method = "deleteMenuFuncInfoById")
    public Integer deleteMenuFuncInfoById(Map<String, Object> parameter);

    /**
     * 根据菜单参数获取菜单列表
     *
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     *
     * </pre>
     *
     * @return 菜单列表
     */
    @SelectProvider(type = MenuInfoSqlProvider.class, method = "getMenuTowChildInfoByMenu")
    @ResultType(MenuInfoBean.class)
    public List<MenuInfoBean> getMenuTowChildInfoByMenu();
}