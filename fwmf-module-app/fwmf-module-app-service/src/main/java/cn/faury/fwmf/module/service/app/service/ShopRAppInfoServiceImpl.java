package cn.faury.fwmf.module.service.app.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.app.bean.ShopRAppInfoBean;
import cn.faury.fwmf.module.api.app.service.ShopRAppInfoService;
import cn.faury.fwmf.module.service.app.mapper.ShopRAppInfoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopRAppInfoServiceImpl implements ShopRAppInfoService {

    /**
     * 数据库操作器DAO
     */
    protected CommonDao commonDao;

    public ShopRAppInfoServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public List<ShopRAppInfoBean> getShopRAppInfoList(List<Long> shopIds, Boolean isAppAvailable) {
        AssertUtil.assertNotEmpty(shopIds, "商店ID不可以为空");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("shopIds", shopIds);
        parameter.put("isAppAvailable", isAppAvailable);
        String statement = ShopRAppInfoMapper.class.getName() + ".getShopRAppInfoList";
        return commonDao.selectList(statement, parameter);
    }

    @Override
    public List<ShopRAppInfoBean> getShopRAppInfoListWithConcat(List<Long> shopIds, Boolean isAppAvailable) {
        AssertUtil.assertNotEmpty(shopIds, "商店ID不可以为空");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("shopIds", shopIds);
        parameter.put("isAppAvailable", isAppAvailable);
        String statement = ShopRAppInfoMapper.class.getName() + ".getShopRAppInfoListWithConcat";
        return commonDao.selectList(statement, parameter);
    }

    @Override
    public List<ShopRAppInfoBean> getShopRAppInfoListByUserId(Long userId, Boolean isAppAvailable) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("userId", userId);
        parameter.put("isAppAvailable", isAppAvailable);
        String statement = ShopRAppInfoMapper.class.getName() + ".getShopRAppInfoListByUserId";
        return commonDao.selectList(statement, parameter);
    }

    @Override
    public Integer insertShopRApp(List<ShopRAppInfoBean> shopRApps) {
        AssertUtil.assertNotEmpty(shopRApps, "商店关联APP不可以为空");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("shopRApps", shopRApps);
        String statement = ShopRAppInfoMapper.class.getName() + ".insertShopRApp";
        return commonDao.insert(statement, parameter);
    }

    @Override
    public Integer deleteShopRAppById(List<Long> ids) {
        AssertUtil.assertNotEmpty(ids, "商店ID不可以为空");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("ids", ids);
        String statement = ShopRAppInfoMapper.class.getName() + ".deleteShopRAppById";
        return commonDao.delete(statement, parameter);
    }

    @Override
    public Integer deleteShopRAppByShopId(List<Long> appIds, Long shopId) {
        AssertUtil.assertTrue(shopId != null && shopId > 0, "商店ID不能为空或不存在");
        AssertUtil.assertNotEmpty(appIds, "APP ID不可以为空");

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("appIds", appIds);
        parameter.put("shopId", shopId);
        String statement = ShopRAppInfoMapper.class.getName() + ".deleteShopRAppByShopIds";
        return commonDao.delete(statement, parameter);
    }

    @Override
    public Integer deleteShopRAppByShopId(List<Long> shopIds) {
        AssertUtil.assertNotEmpty(shopIds, "商店ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("shopIds", shopIds);
        String statement = ShopRAppInfoMapper.class.getName() + ".deleteShopRAppByShopId";
        return commonDao.delete(statement, parameter);
    }
}
