package cn.faury.fwmf.module.api.qa.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.qa.bean.QaTxtBean;

/**
 * 服务接口：常见问题txt
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface QaTxtService extends CrudBaseService<QaTxtBean, Long> {

    /**
     * 根据QA ID获取对象信息
     * @param qaId QA的ID
     * @return QA内容对象
     */
    public QaTxtBean getBeanByQaId(Long qaId);

    /**
     * 根据QA的ID删除内容信息
     * @param qaId QA的ID
     * @return 成功删除条数
     */
    public int deleteByQaId(Long qaId);
}