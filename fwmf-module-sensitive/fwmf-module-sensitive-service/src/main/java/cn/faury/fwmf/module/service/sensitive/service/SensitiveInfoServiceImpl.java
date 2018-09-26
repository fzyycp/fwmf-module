package cn.faury.fwmf.module.service.sensitive.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.sensitive.bean.SensitiveInfoBean;
import cn.faury.fwmf.module.api.sensitive.service.SensitiveInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.sensitive.mapper.SensitiveInfoMapper;

/**
 * 服务实现：敏感词信息表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了SensitiveInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class SensitiveInfoServiceImpl extends CrudBaseServiceImpl<SensitiveInfoBean, Long> implements SensitiveInfoService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public SensitiveInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, SensitiveInfoMapper.class);
    }
}