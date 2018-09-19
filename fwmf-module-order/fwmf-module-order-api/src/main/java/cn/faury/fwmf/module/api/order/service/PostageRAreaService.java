package cn.faury.fwmf.module.api.order.service;


import cn.faury.fwmf.module.api.order.bean.PostageRAreaBean;
import cn.faury.fdk.common.db.CrudBaseService;

import java.util.List;

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
