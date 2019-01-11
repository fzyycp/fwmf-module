package cn.faury.fwmf.module.service.menu.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.menu.bean.FunctionInfoBean;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.wassk.customized.umall.module.api.bussiness.bean.RoleRFunctionBean;
import cn.wassk.customized.umall.module.api.bussiness.service.RoleRFunctionService;
import cn.wassk.customized.umall.module.service.bussiness.mapper.RoleRFunctionMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现：角色关联功能按钮表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了RoleRFunctionService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class RoleRFunctionServiceImpl extends CrudBaseServiceImpl<RoleRFunctionBean, Long> implements RoleRFunctionService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public RoleRFunctionServiceImpl(CommonDao commonDao) {
        super(commonDao, RoleRFunctionMapper.class);
    }

    @Override
    public List<FunctionInfoBean> getRoleRFuncInfosByRoleCode(String roleCode, String isAvailable) {
        Map<String,Object> map=new HashMap<>();
        map.put("roleCode",roleCode);
        map.put("isAvailable",isAvailable);
        String state=this.mapper.getName()+".getRoleRFuncInfosByRole";
        return this.commonDao.selectList(state,map);
    }

    @Override
    public int updateRoleRFunctionInfo(Long roleId, List<Long> functionIdList) {
        Map<String,Object> map=new HashMap<>();
        map.put("roleId",roleId);
        List<RoleRFunctionBean> roleRFunctionBeans=this.query(map);
        //先删除
        if(roleRFunctionBeans.size()>0){
            List<Long> ids=new ArrayList<>();
            roleRFunctionBeans.forEach(bean->{
                ids.add(bean.getId());
            });
            this.deleteByIdBatch(ids);
        }
        //再插入
        for(Long functionId:functionIdList){
            RoleRFunctionBean roleRFunctionBean=new RoleRFunctionBean();
            roleRFunctionBean.setFunctionId(functionId);
            roleRFunctionBean.setRoleId(roleId);
            this.insert(roleRFunctionBean);
        }
        return functionIdList.size();
    }
}