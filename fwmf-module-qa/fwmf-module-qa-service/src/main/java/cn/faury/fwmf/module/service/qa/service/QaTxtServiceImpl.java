package cn.faury.fwmf.module.service.qa.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.api.qa.bean.QaTxtBean;
import cn.faury.fwmf.module.api.qa.service.QaTxtService;
import cn.faury.fwmf.module.service.qa.mapper.QaTxtMapper;

/**
 * 服务实现：常见问题txt
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了QaTxtService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class QaTxtServiceImpl extends CrudBaseServiceImpl<QaTxtBean, Long> implements QaTxtService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public QaTxtServiceImpl(CommonDao commonDao) {
        super(commonDao, QaTxtMapper.class);
    }

    /**
     * 根据QA ID获取对象信息
     *
     * @param qaId QA的ID
     * @return QA内容对象
     */
    @Override
    public QaTxtBean getBeanByQaId(Long qaId) {
        String state = this.mapper.getName()+".getBeanByQaId";
        return this.commonDao.selectOne(state,qaId);
    }

    /**
     * 根据QA的ID删除内容信息
     *
     * @param qaId QA的ID
     * @return 成功删除条数
     */
    @Override
    public int deleteByQaId(Long qaId) {
        String state = this.mapper.getName()+".deleteByQaId";
        return this.commonDao.delete(state,qaId);
    }
}