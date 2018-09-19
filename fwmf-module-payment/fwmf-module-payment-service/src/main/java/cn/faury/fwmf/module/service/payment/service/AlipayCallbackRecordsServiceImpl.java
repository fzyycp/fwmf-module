package cn.faury.fwmf.module.service.payment.service;

import cn.faury.fwmf.module.api.payment.bean.AlipayCallbackRecordsBean;
import cn.faury.fwmf.module.api.payment.service.AlipayCallbackRecordsService;
import cn.faury.fwmf.module.service.payment.mapper.AlipayCallbackRecordsMapper;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

/**
 * 服务实现：
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了AlipayCallbackRecordsService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class AlipayCallbackRecordsServiceImpl extends CrudBaseServiceImpl<AlipayCallbackRecordsBean, Long> implements AlipayCallbackRecordsService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public AlipayCallbackRecordsServiceImpl(CommonDao commonDao) {
        super(commonDao, AlipayCallbackRecordsMapper.class);
    }
}