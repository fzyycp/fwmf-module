package cn.faury.fwmf.module.service.category.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.bean.SystemCategoryBean;
import cn.faury.fwmf.module.api.category.service.SystemCategoryService;
import cn.faury.fwmf.module.service.category.mapper.SystemCategoryMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统分类授权服务协议实现
 */
public class SystemCategoryServiceImpl implements SystemCategoryService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public SystemCategoryServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public List<SystemCategoryBean> getAllSystemCategory() {
        String statement = SystemCategoryMapper.class.getName() + ".getSysCategoryAllByCondition";
        return commonDao.selectList(statement);
    }

    @Override
    public List<SystemCategoryBean> getSystemCategory(Long systemId) {
        AssertUtil.assertTrue(systemId != null && systemId >= 0, "系统ID为空或不存在");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemId", systemId);
        String statement = SystemCategoryMapper.class.getName() + ".getSysCategoryAllByCondition";
        return commonDao.selectList(statement, parameter);
    }

    @Override
    public List<SystemCategoryBean> getSystemCategory(String systemCode) {
        AssertUtil.assertNotEmpty(systemCode, "系统编码不可以为空");
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("systemCode", systemCode);
        String statement = SystemCategoryMapper.class.getName() + ".getSysCategoryAllByCondition";
        return commonDao.selectList(statement, parameter);
    }

    @Override
    public List<SystemCategoryBean> getCategoryAllBySystemCodeAndCId(String systemCode, Long categoryId) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemCode", systemCode);
        if (null != categoryId) {
            parameter.put("productCategoryId", categoryId);
        }

        String statement = SystemCategoryMapper.class.getName() + ".getSysCategoryAllByCondition";
        List<SystemCategoryBean> categoryList = commonDao.selectList(statement, parameter);
        // // 得到所有的 parentID 0/2001056/2001058/2001059/2001060
        // // 一个一个解析为[0,2001056,2001058,2001059,2001060]
        // Set<String> setPath = new HashSet<String>();
        // for (CategoryInfoBean cate : categoryList) {
        // String[] xpath = cate.getXpath().split("/");
        // for (String path : xpath) {
        // // 将parentId 放入set集合 （去重）
        // setPath.add(path);
        // }
        // }
        // List<String> listPath = new ArrayList<String>(setPath);
        // Map<String, Object> parentIdMap = new HashMap<String, Object>();
        // statement = SystemCategoryMapper.class.getName() +
        // ".getSysCategoryAll";
        // parentIdMap.put("parentIds", listPath);
        // List<SystemCategoryBean> list = this.commonDao.selectList(statement,
        // parentIdMap);
        return categoryList;
    }

    @Override
    public Long saveSystemCategoryInfo(Long systemId, List<SystemCategoryBean> sysCategoryList, Long templateId) {
        AssertUtil.assertTrue(systemId != null && systemId >= 0, "系统ID为空或不存在");
        long res = deleteSystemCategoryInfo(systemId, templateId);
        if (sysCategoryList.size() > 0) {
            Map<String, Object> parameter = new HashMap<>();
            parameter.put("systemId", systemId);
            parameter.put("sysCategoryList", sysCategoryList);
            String statement = SystemCategoryMapper.class.getName() + ".saveSystemCategoryInfoForList";
            res += commonDao.insert(statement, parameter);
        }
        return res;
    }

    @Override
    public Long deleteSystemCategoryInfo(Long systemId, Long templateId) {
        AssertUtil.assertTrue(systemId != null && systemId >= 0, "系统ID为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("systemId", systemId);
        parameter.put("templateId", templateId);
        String statement = SystemCategoryMapper.class.getName() + ".deleteSystemCategoryInfo";
        return (long) commonDao.delete(statement, parameter);
    }
}
