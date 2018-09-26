package cn.faury.fwmf.module.service.menu.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.menu.bean.FunctionInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfMenu;
import cn.faury.fwmf.module.service.menu.generate.mapper.FunctionInfoGenerateMapper;
import cn.faury.fwmf.module.service.menu.sqlProvider.FunctionInfoSqlProvider;
import cn.faury.fwmf.module.service.menu.sqlProvider.FunctionInfoSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：功能按钮信息表
 *
 * <pre>
 *     FunctionInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自FunctionInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface FunctionInfoMapper extends FunctionInfoGenerateMapper {

    /**
     * 根据功能按钮获取功能按钮信息
     *
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuId 菜单ID / String menuCode 菜单编码
     * 【二选一】Long funcId 功能按钮ID / String funcCode 功能按钮编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @return 功能按钮信息
     */
    @SelectProvider(type = FunctionInfoSqlProvider.class, method = "getMenuFuncInfoByFunc")
    @ResultType(FunctionInfoBean.class)
    public FunctionInfoBean getMenuFuncInfoByFunc();

    /**
     * 根据菜单获取功能按钮清单信息
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
     * @return 功能按钮信息
     */
    @SelectProvider(type = FunctionInfoSqlProvider.class, method = "getMenuFuncListByMenu")
    @ResultType(FunctionInfoBean.class)
    public List<FunctionInfoBean> getMenuFuncListByMenu();

    /**
     * 根据父菜单获取功能按钮清单信息
     *
     * <pre>
     * 可能出现的参数：
     * 【二选一】Long systemId 业务系统ID / String systemCode 业务系统编码
     * 【二选一】Long menuPId 父菜单ID / String menuPCode 菜单编码
     * 【可选】Boolean isSystemAvailable 系统是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isMenuAvailable 菜单是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * 【可选】Boolean isFuncAvailable 功能按钮是否可用【Boolean.TRUE：仅可用； Boolean.FALSE:仅不可用； null:都包含】
     * </pre>
     *
     * @return 功能按钮信息
     */
    @SelectProvider(type = FunctionInfoSqlProvider.class, method = "getChildMenuFuncListByMenu")
    @ResultType(FunctionInfoBean.class)
    public List<FunctionInfoBean> getChildMenuFuncListByMenu();

    /**
     * 根据功能编码查询功能信息（判断功能编码是否存在）
     */
    @SelectProvider(type = FunctionInfoSqlProvider.class, method = "getMenuFuncInfoByFuncCode")
    @ResultType(FunctionInfoBean.class)
    public FunctionInfoBean getMenuFuncInfoByFuncCode();

    /**
     * 根据功能ID判断是否存在角色关联功能
     */
    @SelectProvider(type = FunctionInfoSqlProvider.class, method = "getFuncCountById")
    public int getFuncCountById();

    /**
     * 插入菜单功能信息
     *
     * @param menuFuncInfo
     *            菜单功能按钮对象
     *
     * @return 菜单功能id
     */
    @Insert("INSERT INTO " + DBConstOfMenu.TN_FUNCTION_INFO + " (`FUNCTION_NAME`, `FUNCTION_CODE`,`MENU_ID`, `SYSTEM_ID`,`IS_AVAILABLE`) VALUES "
            + "(#{funcName}, #{funcCode},#{menuId,jdbcType=BIGINT}, #{systemId,jdbcType=BIGINT}, #{isAvailable})")
    @Options(keyProperty = "funcId", useGeneratedKeys = true)
    public Integer insertMenuFuncInfo(final FunctionInfoBean menuFuncInfo);

    /**
     * 修改菜单功能信息
     *
     * @param menuFuncInfo
     *            菜单功能按钮对象
     *
     * @return 成功修改条数
     */
    @UpdateProvider(type = FunctionInfoSqlProvider.class, method = "updateMenuFuncInfo")
    public Integer updateMenuFuncInfo(final FunctionInfoBean menuFuncInfo);

    /**
     * 根据功能按钮ID删除功能按钮信息----物理删除
     *
     * @param parameter
     *            输入参数
     *
     * @return 成功删除条数
     */
    @DeleteProvider(type = FunctionInfoSqlProvider.class, method = "deleteMenuFuncInfoById")
    public Integer deleteMenuFuncInfoById(Map<String, Object> parameter);

    /**
     * 根据菜单ID删除功能按钮信息----物理删除
     *
     * @param parameter
     *            输入参数
     * @return 成功删除条数
     */
    @DeleteProvider(type = FunctionInfoSqlProvider.class, method = "deleteMenuFuncInfoByMenuId")
    public Integer deleteMenuFuncInfoByMenuId(Map<String, Object> parameter);

}