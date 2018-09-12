package cn.faury.fwmf.module.service.operation.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.operation.bean.OperationRecordBean;
import cn.faury.fwmf.module.api.operation.config.Operation;
import cn.faury.fwmf.module.api.operation.service.OperationRecordService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.operation.mapper.OperationRecordMapper;

import java.util.Arrays;

/**
 * 服务实现：操作记录信息表
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了OperationRecordService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OperationRecordServiceImpl extends CrudBaseServiceImpl<OperationRecordBean, Long> implements OperationRecordService {

    // 默认等级
    public static final Operation.Type[] DEFAULT_LEVE = {Operation.Type.ADD, Operation.Type.DEL, Operation.Type.MOD};

    private int recordLevel;

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public OperationRecordServiceImpl(CommonDao commonDao) {
        this(commonDao, DEFAULT_LEVE);
    }

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     * @param types     记录等级
     */
    public OperationRecordServiceImpl(CommonDao commonDao, Operation.Type[] types) {
        super(commonDao, OperationRecordMapper.class);
        if (types == null) {
            types = DEFAULT_LEVE;
        }
        this.recordLevel = Arrays.stream(types).reduce(0, (acc, type) -> acc + type.getLevel(), Integer::sum);
    }


    @Override
    public Long insert(OperationRecordBean bean) {
        // 只记录在等级范围内的
        if (bean.getOptLevel() != null && (bean.getOptLevel() & this.getRecordLevel()) > 0) {
            return super.insert(bean);
        }
        return -1L;
    }

    public int getRecordLevel() {
        return recordLevel;
    }
}