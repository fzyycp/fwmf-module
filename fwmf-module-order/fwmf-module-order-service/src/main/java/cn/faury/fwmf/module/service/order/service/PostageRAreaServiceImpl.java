package cn.faury.fwmf.module.service.order.service;

import cn.faury.fwmf.module.api.order.bean.PostageRAreaBean;
import cn.faury.fwmf.module.api.order.service.PostageRAreaService;
import cn.faury.fwmf.module.service.order.mapper.PostageRAreaMapper;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostageRAreaServiceImpl extends CrudBaseServiceImpl<PostageRAreaBean, Long> implements PostageRAreaService {

    public PostageRAreaServiceImpl(CommonDao commonDao) {
        super(commonDao, PostageRAreaMapper.class);
    }

    /**
     * 获取邮费关联的区域列表
     *
     * @param postageId 邮费ID
     * @return 关联区域列表
     */
    @Override
    public List<PostageRAreaBean> getBeanListByPostageId(Long postageId) {
        String state = this.mapper.getName() + ".getBeanListByPostageId";
        return this.commonDao.selectList(state, postageId);
    }

    /**
     * 获取多个邮费关联的区域列表
     *
     * @param postageIdList 邮费ID
     * @return 关联区域列表
     */
    @Override
    public List<PostageRAreaBean> getBeanListByPostageIds(List<Long> postageIdList) {
        String state = this.mapper.getName() + ".getBeanListByPostageIds";
        Map<String, Object> params = new HashMap<>();
        params.put("postageIdList", postageIdList);
        return this.commonDao.selectList(state, params);
    }

    /**
     * 根据邮费ID删除所有关联区域
     *
     * @param postageId 邮费ID
     * @return 成功删除条数
     */
    @Override
    public int deleteByPostageId(Long postageId) {
        String state = this.mapper.getName() + ".deleteByPostageId";
        return this.commonDao.delete(state, postageId);
    }
}
