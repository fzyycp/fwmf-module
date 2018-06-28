package cn.faury.fwmf.module.service.category.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.bean.DiscusRCategoryBean;
import cn.faury.fwmf.module.api.category.service.DiscusRCategoryService;
import cn.faury.fwmf.module.service.category.mapper.DiscusRCategoryMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 优惠关联分类
 */
public class DiscusRCategoryServiceImpl implements DiscusRCategoryService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public DiscusRCategoryServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public PageInfo<DiscusRCategoryBean> queryDiscusRCategoryByDiscusId(Map<String, Object> parameter) {
        AssertUtil.assertNotNull(parameter.get("discusId"), "优惠ID错误");
        PageParam pageParam = PageParam.buildDefaultIns(parameter);
        Map<String, Object> param = new HashMap<>();
        param.put("discusId", parameter.get("discusId"));
        String state = DiscusRCategoryMapper.class.getName() + ".queryDiscusRCategoryByDiscusId";
        return this.commonDao.selectPage(state, param, pageParam);
    }

    @Override
    public List<DiscusRCategoryBean> queryDiscusRCategoryByDiscusId(Long discusId) {
        AssertUtil.assertNotNull(discusId, "优惠ID错误");

        Map<String, Object> param = new HashMap<>();
        param.put("discusId", discusId);
        String state = DiscusRCategoryMapper.class.getName() + ".queryDiscusRCategoryByDiscusId";
        return this.commonDao.selectList(state, param);
    }

    @Override
    public Integer insert(List<DiscusRCategoryBean> list) {
        AssertUtil.assertTrue(list!=null&&list.size()>0,"要保存的优惠信息为空");
        list.forEach(bean -> {
            AssertUtil.assertTrue(bean.getDiscusId()!=null&&bean.getDiscusId()>0,"优惠ID为空或不存在");
            AssertUtil.assertTrue(bean.getProductCategoryId()!=null&&bean.getProductCategoryId()>0,"商品分类ID为空或不存在");
        });
        String state = DiscusRCategoryMapper.class.getName() + ".insert";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("list", list);
        int res = this.commonDao.insert(state, parameter);
        return res;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * cn.wassk.platform.inteface.category.service.LocalDiscusRCategoryService
     * #delByIds(java.util.List)
     */
    @Override
    public Integer delByIds(List<Long> ids) {
        AssertUtil.assertTrue(ids!=null&&ids.size()>0,"删除主键为空或不存在");
        String state = DiscusRCategoryMapper.class.getName() + ".del";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("ids", ids);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    @Override
    public Integer delByDiscusId(List<Long> discusIds) {
        AssertUtil.assertTrue(discusIds!=null&&discusIds.size()>0,"优惠ID为空或不存在");
        String state = DiscusRCategoryMapper.class.getName() + ".del";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("discusIds", discusIds);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * cn.wassk.platform.inteface.category.service.LocalDiscusRCategoryService
     * #delByDiscusId(java.lang.Long, java.util.List)
     */
    @Override
    public Integer delByDiscusId(Long discusId, List<Long> productCategoryIds) {
        AssertUtil.assertTrue(discusId!=null&&discusId>0,"优惠ID为空或不存在");
        AssertUtil.assertTrue(productCategoryIds!=null&&productCategoryIds.size()>0,"商品分类ID为空或不存在");
        String state = DiscusRCategoryMapper.class.getName() + ".del";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("discusId", discusId);
        parameter.put("productCategoryIds", productCategoryIds);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }
}
