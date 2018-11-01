package cn.faury.fwmf.module.api.qa.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.qa.generate.bean.QaInfoGenerateBean;

import java.io.Serializable;

/**
 * POJO对象：常见问题信息
 * <p>
 * <pre>
 *     QaInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自QaInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class QaInfoBean extends QaInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    /**
     * 内容Bean
     */
    private QaTxtBean qaTxtBean;

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKey() {
        return this.getQaId();
    }

    /**
     * 获取qaTxtBean
     *
     * @return qaTxtBean
     */
    public QaTxtBean getQaTxtBean() {
        return qaTxtBean;
    }

    /**
     * 设置qaTxtBean
     *
     * @param qaTxtBean 值
     */
    public void setQaTxtBean(QaTxtBean qaTxtBean) {
        this.qaTxtBean = qaTxtBean;
    }

    public String getContentJson() {
        return this.qaTxtBean != null ? this.qaTxtBean.getContentJson() : null;
    }

    public String getContentHtml() {
        return this.qaTxtBean != null ? this.qaTxtBean.getContentHtml() : null;
    }

    /**
     * JSON序列化对象(自动生成代码)
     *
     * @return JSON化对象
     */
    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}