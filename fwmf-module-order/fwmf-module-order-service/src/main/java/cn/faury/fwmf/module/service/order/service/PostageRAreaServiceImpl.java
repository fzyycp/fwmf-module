package cn.faury.fwmf.module.service.order.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.order.bean.PostageRAreaBean;
import cn.faury.fwmf.module.api.order.service.PostageRAreaService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.order.mapper.PostageRAreaMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现：地区类型各地区具体邮费信息
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了PostageRAreaService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class PostageRAreaServiceImpl extends CrudBaseServiceImpl<PostageRAreaBean, Long> implements PostageRAreaService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
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
