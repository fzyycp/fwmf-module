package cn.faury.fwmf.module.service.category.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.bean.RedRCategoryBean;
import cn.faury.fwmf.module.api.category.service.RedRCategoryService;
import cn.faury.fwmf.module.service.category.mapper.RedRCategoryMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 红包关联分类
 */
public class RedRCategoryServiceImpl implements RedRCategoryService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public RedRCategoryServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public PageInfo<RedRCategoryBean> queryRedRCategoryByRedId(Map<String, Object> parameter) {
        AssertUtil.assertNotNull(parameter.get("redId"), "红包ID错误");
        PageParam pageParam = PageParam.buildDefaultIns(parameter);
        Map<String, Object> param = new HashMap<>();
        param.put("redId", parameter.get("redId"));
        String state = RedRCategoryMapper.class.getName() + ".queryRedRCategoryByRedId";
        return this.commonDao.selectPage(state, param, pageParam);
    }

    @Override
    public List<RedRCategoryBean> queryRedRCategoryByRedId(Long redId) {
        AssertUtil.assertNotNull(redId, "红包ID错误");
        Map<String, Object> param = new HashMap<>();
        param.put("redId", redId);
        String state = RedRCategoryMapper.class.getName() + ".queryRedRCategoryByRedId";
        return this.commonDao.selectList(state, param);
    }

    @Override
    public Integer insert(List<RedRCategoryBean> list) {
        AssertUtil.assertTrue(list != null && list.size() > 0, "要保存的红包关联分类信息为空");
        list.forEach(bean -> {
            AssertUtil.assertTrue(bean.getRedId() != null && bean.getId() > 0, "红包ID为空或不存在");
            AssertUtil.assertTrue(bean.getProductCategoryId() != null && bean.getProductCategoryId() > 0, "商品分类ID为空或不存在");
        });
        String state = RedRCategoryMapper.class.getName() + ".insert";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("list", list);
        int res = this.commonDao.insert(state, parameter);
        return res;
    }

    @Override
    public Integer delByIds(List<Long> ids) {
        AssertUtil.assertTrue(ids != null && ids.size() > 0, "删除主键为空或不存在");
        String state = RedRCategoryMapper.class.getName() + ".del";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("ids", ids);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    @Override
    public Integer delByRedId(List<Long> redIds) {
        AssertUtil.assertTrue(redIds != null && redIds.size() > 0, "红包ID为空或不存在");
        String state = RedRCategoryMapper.class.getName() + ".del";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("redIds", redIds);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    @Override
    public Integer delByRedId(Long redId, List<Long> productCategoryIds) {
        AssertUtil.assertTrue(redId != null && redId > 0, "红包ID为空或不存在");
        AssertUtil.assertTrue(productCategoryIds != null && productCategoryIds.size() > 0, "商品分类ID为空或不存在");
        String state = RedRCategoryMapper.class.getName() + ".del";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("redId", redId);
        parameter.put("productCategoryIds", productCategoryIds);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }
}
