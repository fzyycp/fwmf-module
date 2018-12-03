package cn.faury.fwmf.module.service.category.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.bean.TagInfoBean;
import cn.faury.fwmf.module.api.category.service.TagInfoService;
import cn.faury.fwmf.module.service.category.mapper.TagInfoMapper;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 服务实现：标签信息表
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了TagInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class TagInfoServiceImpl extends CrudBaseServiceImpl<TagInfoBean, Long> implements TagInfoService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public TagInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, TagInfoMapper.class);
    }

    @Override
    public PageInfo<TagInfoBean> search(Map<String, Object> param) {
        Map<String, Object> _params = new HashMap<>();
        // 默认，可被覆盖
        _params.put("ORDER_BY", "DISPLAY_ORDER,ASC");
        _params.put("isDelete", StringUtil.WHETHER_NO);
        _params.putAll(param);
        return super.search(_params);
    }

    /**
     * 根据ID获取标签信息，带父节点名称
     *
     * @param id 分类ID
     * @return 分类对象
     */
    @Override
    public TagInfoBean getBeanByIdWithParentName(Long id) {
        TagInfoBean bean = this.getBeanById(id);
        if (bean != null && bean.getParentId() != null && bean.getParentId() > 0) {
            TagInfoBean parentBean = this.getBeanById(bean.getParentId());
            if (parentBean != null) {
                bean.setParentName(parentBean.getTagValue());
            }
        }

        return bean;
    }

    /**
     * 获取下级标签组
     *
     * @param parentId 父节点ID
     * @return 下级标签组
     */
    @Override
    public List<TagInfoBean> getSubTagGroupsByParentId(Long parentId) {
        Map<String, Object> params = new HashMap<>();
        params.put("tagType", "01");
        params.put("parentId", parentId);

        return query(params);
    }

    /**
     * 获取下级标签值
     *
     * @param parentId 父节点ID
     * @return 下级标签值
     */
    @Override
    public List<TagInfoBean> getSubTagValuesByParentId(Long parentId) {
        Map<String, Object> params = new HashMap<>();
        params.put("tagType", "02");
        params.put("parentId", parentId);

        return query(params);
    }

    /**
     * 根据编码获取标签组
     *
     * @param tagCode 标签编码
     * @return 标签组对象
     */
    @Override
    public Optional<TagInfoBean> getTagGroupByCode(String tagCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("tagType", "01");
        params.put("tagCode", tagCode);
        List<TagInfoBean> tagInfoBeanList = this.query(params);
        return Optional.ofNullable(tagInfoBeanList != null && tagInfoBeanList.size() > 0 ? tagInfoBeanList.get(0) : null);
    }

    /**
     * 根据编码获取标签值
     *
     * @param tagCode 标签编码
     * @return 标签值对象
     */
    @Override
    public Optional<TagInfoBean> getTagValueByCode(String tagCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("tagType", "02");
        params.put("tagCode", tagCode);
        List<TagInfoBean> tagInfoBeanList = this.query(params);
        return Optional.ofNullable(tagInfoBeanList != null && tagInfoBeanList.size() > 0 ? tagInfoBeanList.get(0) : null);
    }

}