package cn.faury.fwmf.module.api.order.service;


import cn.faury.fwmf.module.api.order.bean.PostageRAreaBean;
import cn.faury.fdk.common.db.CrudBaseService;

import java.util.List;

/**
 * 服务接口：地区类型各地区具体邮费信息
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface PostageRAreaService extends CrudBaseService<PostageRAreaBean, Long> {

    /**
     * 获取邮费关联的区域列表
     *
     * @param postageId 邮费ID
     * @return 关联区域列表
     */
    public List<PostageRAreaBean> getBeanListByPostageId(Long postageId);

    /**
     * 获取多个邮费关联的区域列表
     *
     * @param postageIdList 邮费ID
     * @return 关联区域列表
     */
    public List<PostageRAreaBean> getBeanListByPostageIds(List<Long> postageIdList);

    /**
     * 根据邮费ID删除所有关联区域
     * @param postageId 邮费ID
     * @return 成功删除条数
     */
    public int deleteByPostageId(Long postageId);
}
