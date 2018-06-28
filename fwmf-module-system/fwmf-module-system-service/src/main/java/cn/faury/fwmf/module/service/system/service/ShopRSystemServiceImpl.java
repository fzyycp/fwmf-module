package cn.faury.fwmf.module.service.system.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.system.bean.ShopRSystemInfoBean;
import cn.faury.fwmf.module.api.system.service.ShopRSystemService;
import cn.faury.fwmf.module.service.system.mapper.ShopRSystemMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商店授权业务系统服务提供者
 */
public class ShopRSystemServiceImpl implements ShopRSystemService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public ShopRSystemServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public List<ShopRSystemInfoBean> getShopRSystemInfoListWithConcat(List<Long> shopIds, Boolean isSystemAvailable) {
        AssertUtil.assertTrue(shopIds != null && shopIds.size() > 0, "商店ID错误");
        String state = ShopRSystemMapper.class.getName() + ".getShopRSystemInfoListWithConcat";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("shopIds", shopIds);
        parameter.put("isSystemAvailable", isSystemAvailable);
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<ShopRSystemInfoBean> getShopRSystemInfoList(List<Long> shopIds, Boolean isSystemAvailable) {
        AssertUtil.assertTrue(shopIds != null && shopIds.size() > 0, "商店ID错误");
        String state = ShopRSystemMapper.class.getName() + ".getShopRSystemInfoList";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("shopIds", shopIds);
        parameter.put("isSystemAvailable", isSystemAvailable);
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public List<ShopRSystemInfoBean> getShopRSystemInfoListByUserId(Long userId, Boolean isSystemAvailable) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID错误");
        String state = ShopRSystemMapper.class.getName() + ".getShopRSystemInfoListByUserId";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("userId", userId);
        parameter.put("isSystemAvailable", isSystemAvailable);
        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public Integer insertShopRSystem(List<ShopRSystemInfoBean> shopRSystems) {
        AssertUtil.assertTrue(shopRSystems != null && shopRSystems.size() > 0, "商店授权业务系统信息为空");
        shopRSystems.forEach(bean -> {
            AssertUtil.assertTrue(bean.getShopId() != null && bean.getShopId() > 0, "商店授权业务系统信息商店ID错误");
            AssertUtil.assertTrue(bean.getSystemId() != null && bean.getSystemId() > 0, "商店授权业务系统信息业务系统ID错误");

        });
        // 新增
        int res = 0;
        String state = ShopRSystemMapper.class.getName() + ".insertShopRSystem";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("shopRSystems", shopRSystems);
        res = this.commonDao.insert(state, parameter);

        return res;
    }

    @Transactional
    @Override
    public Integer updateShopRSystem(List<Long> addSystemIds, List<Long> delSystemIds, Long shopId) {
        AssertUtil.assertTrue(shopId != null && shopId > 0, "商店ID错误");
        int n = 0;
        if (addSystemIds != null && addSystemIds.size() > 0) {
            List<ShopRSystemInfoBean> ShopRSystems = new ArrayList<ShopRSystemInfoBean>();
            for (Long addSystemId : addSystemIds) {
                ShopRSystemInfoBean info = new ShopRSystemInfoBean();
                info.setShopId(shopId);
                info.setSystemId(addSystemId);
                info.setIsAvailable("Y");
                ShopRSystems.add(info);
            }
            n = insertShopRSystem(ShopRSystems);
        }
        if (delSystemIds != null && delSystemIds.size() > 0) {
            List<Long> systemIds = new ArrayList<>();
            for (int i = 0; i < delSystemIds.size(); i++) {
                systemIds.add(delSystemIds.get(i));
            }
            n = deleteShopRSystemByShopId(systemIds, shopId);
        }
        return n;

    }

    @Override
    public Integer deleteShopRSystemById(List<Long> ids) {
        AssertUtil.assertTrue(ids!=null&&ids.size()>0,"要删除的主键ID为空");
        String state = ShopRSystemMapper.class.getName() + ".deleteShopRSystemById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("ids", ids);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    @Override
    public Integer deleteShopRSystemByShopId(List<Long> shopIds) {
        AssertUtil.assertTrue(shopIds!=null&&shopIds.size()>0,"商店ID错误");
        String state = ShopRSystemMapper.class.getName() + ".deleteShopRSystemById";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("shopIds", shopIds);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    @Override
    public Integer deleteShopRSystemByShopId(List<Long> systemIds, Long shopId) {
        AssertUtil.assertTrue(systemIds!=null&&systemIds.size()>0,"系统ID错误");
        AssertUtil.assertTrue(shopId!=null&&shopId>0,"商店ID错误");

        String state = ShopRSystemMapper.class.getName() + ".deleteShopRSystemById";
        Map<String, Object> parameter = new HashMap<String, Object>();

        parameter.put("systemIds", systemIds);
        parameter.put("shopId", shopId);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

}
