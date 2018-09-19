package cn.faury.fwmf.module.service.code.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.code.bean.CodeInfoBean;
import cn.faury.fwmf.module.api.code.service.CodeInfoService;
import cn.faury.fwmf.module.service.code.mapper.CodeInfoMapper;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.Collections;
import java.util.List;

/**
 * 服务实现：数据字典表
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了CodeInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class CodeInfoServiceImpl extends CrudBaseServiceImpl<CodeInfoBean, Long> implements CodeInfoService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public CodeInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, CodeInfoMapper.class);
    }

    /**
     * 根据分组编码获取该组列表
     *
     * @param codeGroupCode 分组编码
     * @return 该组列表
     */
    @Override
    public List<CodeInfoBean> getCodeListByGroupCode(String codeGroupCode) {
        String state = this.mapper + ".getCodeListByGroupCode";
        return this.commonDao.selectList(state, codeGroupCode);
    }
}