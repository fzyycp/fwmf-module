package cn.faury.fwmf.module.service.menu.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.service.menu.sqlProvider.UserRMenuSQLProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * 用户关联菜单Mapper
 */
@AutoScannedMapper
public interface UserRMenuMapper {
    /**
     * 根据用户ID获取指定系统下的菜单信息
     *
     * <pre>
     * 可能出现的参数：
     * 【必填】Long userId 用户ID
     * 【可选】String systemCode 业务系统编码
     * </pre>
     *
     * @param parameters 查询参数
     * @return 菜单信息
     */
    @SelectProvider(type = UserRMenuSQLProvider.class,method = "getMenuInfoByUserId")
    @ResultType(MenuInfoBean.class)
    List<MenuInfoBean> getMenuInfoByUserId(Map<String, Object> parameters);

}
