package cn.faury.fwmf.module.service.systemconfig.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.systemconfig.bean.SystemConfigBean;
import cn.faury.fwmf.module.api.systemconfig.service.SystemConfigService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.systemconfig.mapper.SystemConfigMapper;

/**
 * 服务实现：系统参数配置表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了SystemConfigService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class SystemConfigServiceImpl extends CrudBaseServiceImpl<SystemConfigBean, Long> implements SystemConfigService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public SystemConfigServiceImpl(CommonDao commonDao) {
        super(commonDao, SystemConfigMapper.class);
    }
}