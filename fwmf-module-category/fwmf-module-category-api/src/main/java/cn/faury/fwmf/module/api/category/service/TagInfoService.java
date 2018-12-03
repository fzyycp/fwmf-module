package cn.faury.fwmf.module.api.category.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.category.bean.TagInfoBean;

import java.util.List;
import java.util.Optional;

/**
 * 服务接口：标签信息表
 *
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface TagInfoService extends CrudBaseService<TagInfoBean, Long> {

    /**
     * 根据ID获取标签信息，带父节点名称
     * @param id 分类ID
     * @return 分类对象
     */
    public TagInfoBean getBeanByIdWithParentName(Long id);

    /**
     * 获取下级标签组
     * @param parentId 父节点ID
     * @return 下级标签组
     */
    public List<TagInfoBean> getSubTagGroupsByParentId(Long parentId);

    /**
     * 获取下级标签值
     * @param parentId 父节点ID
     * @return 下级标签值
     */
    public List<TagInfoBean> getSubTagValuesByParentId(Long parentId);

    /**
     * 根据编码获取标签组
     * @param tagCode 标签编码
     * @return 标签组对象
     */
    public Optional<TagInfoBean> getTagGroupByCode(String tagCode);

    /**
     * 根据编码获取标签值
     * @param tagCode 标签编码
     * @return 标签值对象
     */
    public Optional<TagInfoBean> getTagValueByCode(String tagCode);

}