package cn.faury.fwmf.module.service.menu.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.menu.bean.FunctionInfoBean;
import cn.faury.fwmf.module.api.menu.service.FunctionInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.menu.mapper.FunctionInfoMapper;
import cn.faury.fwmf.module.service.menu.mapper.FunctionInfoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现：功能按钮信息表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了FunctionInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class FunctionInfoServiceImpl extends CrudBaseServiceImpl<FunctionInfoBean, Long> implements FunctionInfoService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public FunctionInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, FunctionInfoMapper.class);
    }

    @Override
    public FunctionInfoBean getMenuFuncInfoByFuncId(final Long systemId, final Long menuId, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        AssertUtil.assertTrue(funcId != null && funcId > 0, "功能按钮ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("funcId", funcId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public FunctionInfoBean getMenuFuncInfoByFuncId(final Long systemId, final String menuCode, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        AssertUtil.assertTrue(funcId != null && funcId > 0, "功能按钮ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuCode", menuCode);
        parameter.put("funcId", funcId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public FunctionInfoBean getMenuFuncInfoByFuncId(final String systemCode, final Long menuId, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        AssertUtil.assertTrue(funcId != null && funcId > 0, "功能按钮ID不能为空或不存在");
        parameter.put("systemCode", systemCode);
        parameter.put("menuId", menuId);
        parameter.put("funcId", funcId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public FunctionInfoBean getMenuFuncInfoByFuncId(final String systemCode, final String menuCode, final Long funcId,
                                                    final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        AssertUtil.assertTrue(funcId != null && funcId > 0, "功能按钮ID不能为空或不存在");
        parameter.put("systemCode", systemCode);
        parameter.put("menuCode", menuCode);
        parameter.put("funcId", funcId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public FunctionInfoBean getMenuFuncInfoByFuncCode(final Long systemId, final Long menuId, final String funcCode,
                                                      final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        AssertUtil.assertNotEmpty(funcCode, "功能按钮编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("funcCode", funcCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public FunctionInfoBean getMenuFuncInfoByFuncCode(final Long systemId, final String menuCode,
                                                      final String funcCode, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                      final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        AssertUtil.assertNotEmpty(funcCode, "功能按钮编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuCode", menuCode);
        parameter.put("funcCode", funcCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public FunctionInfoBean getMenuFuncInfoByFuncCode(final String systemCode, final Long menuId,
                                                      final String funcCode, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                      final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        AssertUtil.assertNotEmpty(funcCode, "功能按钮编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuId", menuId);
        parameter.put("funcCode", funcCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public FunctionInfoBean getMenuFuncInfoByFuncCode(final String systemCode, final String menuCode,
                                                      final String funcCode, final Boolean isSystemAvailable, final Boolean isMenuAvailable,
                                                      final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        AssertUtil.assertNotEmpty(funcCode, "功能按钮编码不能为空或不存在");

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuCode", menuCode);
        parameter.put("funcCode", funcCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncInfoByFunc";
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public List<FunctionInfoBean> getMenuFuncListByMenuId(final Long systemId, final Long menuId,
                                                          final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<FunctionInfoBean> getMenuFuncListByMenuId(final String systemCode, final Long menuId,
                                                          final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuId", menuId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<FunctionInfoBean> getMenuFuncListByMenuCode(final Long systemId, final String menuCode,
                                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuCode", menuCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<FunctionInfoBean> getMenuFuncListByMenuCode(final String systemCode, final String menuCode,
                                                            final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuCode, "菜单编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuCode", menuCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<FunctionInfoBean> getChildMenuFuncListByMenuId(final Long systemId, final Long menuPId,
                                                               final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuPId != null && menuPId > 0, "父菜单ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuPId", menuPId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getChildMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<FunctionInfoBean> getChildMenuFuncListByMenuId(final String systemCode, final Long menuPId,
                                                               final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(menuPId != null && menuPId > 0, "父菜单ID不能为空或不存在");
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuPId", menuPId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getChildMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<FunctionInfoBean> getChildMenuFuncListByMenuCode(final Long systemId, final String menuPCode,
                                                                 final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertNotEmpty(menuPCode, "父菜单编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("menuPCode", menuPCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getChildMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<FunctionInfoBean> getChildMenuFuncListByMenuCode(final String systemCode, final String menuPCode,
                                                                 final Boolean isSystemAvailable, final Boolean isMenuAvailable, final Boolean isFuncAvailable) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(menuPCode, "父菜单编码不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        parameter.put("menuPCode", menuPCode);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getChildMenuFuncListByMenu";
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public PageInfo<FunctionInfoBean> getMenuFuncPageListByMenuId(Map<String, String> param, Long systemId, Long menuId,
                                                                  Boolean isSystemAvailable, Boolean isMenuAvailable, Boolean isFuncAvailable) {
        AssertUtil.assertTrue(systemId != null && systemId > 0, "业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(menuId != null && menuId > 0, "菜单ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        parameter.put("menuId", menuId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        parameter.put("isMenuAvailable", isMenuAvailable);
        parameter.put("isFuncAvailable", isFuncAvailable);
        final String state = FunctionInfoMapper.class.getName() + ".getMenuFuncListByMenu";

        return commonDao.selectPage(state, parameter, PageParam.buildDefaultIns(param));

    }

    @Override
    public FunctionInfoBean getMenuFuncInfoByFuncCode(FunctionInfoBean menuFuncInfoBean) {

        String state = FunctionInfoMapper.class.getName() + ".getMenuFuncInfoByFuncCode";
        Map<String, Object> parameter = new HashMap<>();
        if (menuFuncInfoBean != null) {
            if (StringUtil.isNotEmpty(menuFuncInfoBean.getFunctionCode())) {
                parameter.put("funcCode", menuFuncInfoBean.getFunctionCode());
            }
            if (menuFuncInfoBean.getMenuId() != null) {
                parameter.put("menuId", menuFuncInfoBean.getMenuId());
            }
            if (menuFuncInfoBean.getFunctionId() != null) {
                parameter.put("menuId", menuFuncInfoBean.getFunctionId());
            }
        }

        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public Boolean isExistRoleRFunc(List<Long> funcIds) {
        AssertUtil.assertTrue(funcIds != null && funcIds.size() > 0, "功能IDfuncIds错误");
        String state = FunctionInfoMapper.class.getName() + ".getFuncCountById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("funcIds", funcIds);

        List<Integer> list = this.commonDao.selectList(state, parameter);
        if (list.get(0) > 0) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public Long insertMenuFuncInfo(FunctionInfoBean menuFuncInfo) {
        AssertUtil.assertNotNull(menuFuncInfo, "功能菜单信息不可以为空");
        AssertUtil.assertNotEmpty(menuFuncInfo.getFunctionName(), "功能菜单名称为空或不存在");
        AssertUtil.assertNotEmpty(menuFuncInfo.getFunctionCode(), "功能编码为空或不存在");
        AssertUtil.assertTrue(menuFuncInfo.getMenuId() != null && menuFuncInfo.getMenuId() > 0, "菜单ID为空或不存在");
        AssertUtil.assertNotEmpty(menuFuncInfo.getIsAvailable(), "是否可用为空或不存在");
        FunctionInfoBean bean = getMenuFuncInfoByFuncCode(menuFuncInfo);
        AssertUtil.assertNull(bean,"当前菜单存在相同功能编码");

        String state = FunctionInfoMapper.class.getName() + ".insertMenuFuncInfo";
        int res = this.commonDao.insert(state, menuFuncInfo);

        return res > 0 ? menuFuncInfo.getFunctionId() : -1L;
    }

    @Override
    public Integer updateMenuFuncInfo(FunctionInfoBean menuFuncInfo) {
        AssertUtil.assertTrue(menuFuncInfo.getFunctionId()!=null&& menuFuncInfo.getFunctionId()>0,"功能菜单ID为空或不存在");
        FunctionInfoBean bean = getMenuFuncInfoByFuncCode(menuFuncInfo);
        AssertUtil.assertNull(bean,"存在相同功能编码");
        String state = FunctionInfoMapper.class.getName() + ".updateMenuFuncInfo";

        return this.commonDao.update(state, menuFuncInfo);
    }

    @Override
    public Integer deleteMenuFuncInfoById(List<Long> funcIds) {
        AssertUtil.assertFalse(isExistRoleRFunc(funcIds),"存在角色关联功能，不能删除");
        String state = FunctionInfoMapper.class.getName() + ".deleteMenuFuncInfoById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("funcIds", funcIds);
        return this.commonDao.delete(state, parameter);
    }

    @Override
    public Integer deleteMenuFuncInfoByMenuId(List<Long> menuIds) {
        AssertUtil.assertTrue(menuIds!=null&& menuIds.size()>0,"菜单ID menuIds错误");
        String state = FunctionInfoMapper.class.getName() + ".deleteMenuFuncInfoByMenuId";
        Map<String, Object> parameter = new HashMap<>();

        parameter.put("menuIds", menuIds);
        return this.commonDao.delete(state, parameter);
    }
}