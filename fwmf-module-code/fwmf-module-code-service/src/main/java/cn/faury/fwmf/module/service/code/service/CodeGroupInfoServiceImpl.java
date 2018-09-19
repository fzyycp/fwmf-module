package cn.faury.fwmf.module.service.code.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.code.bean.CodeGroupInfoBean;
import cn.faury.fwmf.module.api.code.service.CodeGroupInfoService;
import cn.faury.fwmf.module.service.code.mapper.CodeGroupInfoMapper;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

/**
 * 服务实现：数据字典分组表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了CodeGroupInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class CodeGroupInfoServiceImpl extends CrudBaseServiceImpl<CodeGroupInfoBean, Long> implements CodeGroupInfoService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public CodeGroupInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, CodeGroupInfoMapper.class);
    }
}