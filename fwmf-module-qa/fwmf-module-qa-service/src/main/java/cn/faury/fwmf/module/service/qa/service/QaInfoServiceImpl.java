package cn.faury.fwmf.module.service.qa.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.qa.bean.QaInfoBean;
import cn.faury.fwmf.module.api.qa.bean.QaTxtBean;
import cn.faury.fwmf.module.api.qa.service.QaInfoService;
import cn.faury.fwmf.module.api.qa.service.QaTxtService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.qa.mapper.QaInfoMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 * 服务实现：常见问题信息
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了QaInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class QaInfoServiceImpl extends CrudBaseServiceImpl<QaInfoBean, Long> implements QaInfoService {

    // 内容服务
    private QaTxtService qaTxtService;

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public QaInfoServiceImpl(CommonDao commonDao,QaTxtService qaTxtService) {
        super(commonDao, QaInfoMapper.class);
        this.qaTxtService = qaTxtService;
    }

    @Override
    public QaInfoBean getQaBeanWithTxtById(Long qaId) {
        QaInfoBean qaInfoBean = this.getBeanById(qaId);
        if (qaInfoBean!=null && this.qaTxtService!=null){
            QaTxtBean qaTxtBean = this.qaTxtService.getBeanByQaId(qaId);
            qaInfoBean.setQaTxtBean(qaTxtBean);
        }
        return qaInfoBean;
    }

    @Override
    @Transactional
    public Long save(QaInfoBean bean) {
        if(bean.getQaId()==null){
            Long qaId = this.insert(bean);
            bean.setQaId(qaId);
        }else{
            this.update(bean);
        }

        //保存qahtml和json
        this.qaTxtService.deleteByQaId(bean.getQaId());

        QaTxtBean txtBean=new QaTxtBean();
        txtBean.setQaId(bean.getQaId());
        txtBean.setContentHtml(bean.getContentHtml());
        txtBean.setContentJson(bean.getContentJson());
        this.qaTxtService.insert(txtBean);

        return bean.getQaId();
    }
}