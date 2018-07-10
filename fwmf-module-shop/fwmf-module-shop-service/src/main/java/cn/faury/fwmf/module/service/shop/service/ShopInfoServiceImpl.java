package cn.faury.fwmf.module.service.shop.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.shop.bean.ShopInfoBean;
import cn.faury.fwmf.module.api.shop.service.ShopInfoService;
import cn.faury.fwmf.module.service.shop.mapper.ShopInfoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopInfoServiceImpl implements ShopInfoService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public ShopInfoServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public PageInfo<ShopInfoBean> queryShopInfo(Map<String, Object> parameters) {
        String state = ShopInfoMapper.class.getName() + ".queryShopInfo";
        return this.commonDao.selectPage(state, parameters, PageParam.buildDefaultIns(parameters));
    }

    @Override
    public List<ShopInfoBean> queryShopInfo(String shopName, String shopState, Long systemId) {
        String state = ShopInfoMapper.class.getName() + ".queryShopInfo";
        Map<String, Object> param = new HashMap<String, Object>();
        if (StringUtil.isNotEmpty(shopName)) {
            param.put("shopName", shopName);
        }
        if (StringUtil.isNotEmpty(shopState)) {
            param.put("shopState", shopState);
        }
        if (systemId != null && systemId > 0) {
            param.put("systemId", systemId);
        }
        return this.commonDao.selectList(state, param);

    }

    @Override
    public PageInfo<ShopInfoBean> getShopInfoBySystemCode(String shopName, String systemCode, PageParam pageParam) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        AssertUtil.assertNotEmpty(shopName, "商店名称不能为空或不存在");

        Map<String, Object> param = new HashMap<>();
        String state = ShopInfoMapper.class.getName() + ".queryShopInfo";
        param.put("systemCode", systemCode);
        param.put("shopName", shopName);

        return this.commonDao.selectPage(state, param, pageParam);
    }

    @Override
    public PageInfo<ShopInfoBean> getShopInfoBySystemCode(String systemCode, PageParam pageParam) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");

        Map<String, Object> param = new HashMap<String, Object>();
        String state = ShopInfoMapper.class.getName() + ".queryShopInfo";
        param.put("systemCode", systemCode);

        if (pageParam != null) {
            return this.commonDao.selectPage(state, param, pageParam);
        } else {
            return new PageInfo<>(this.commonDao.selectList(state, param));
        }
    }

    public PageInfo<ShopInfoBean> getShopInfo(String systemCode, PageParam pageParam, Map<String, Object> parameter) {
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码不能为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("systemCode", systemCode);
        if (StringUtil.isNotEmpty((String) parameter.get("shopName"))) {
            param.put("shopName", parameter.get("shopName"));
        }
        if (StringUtil.isNotEmpty((String) parameter.get("shopState"))) {
            param.put("shopState", parameter.get("shopState"));
        }
        if (StringUtil.isNotEmpty((String) parameter.get("shopKeeperName"))) {
            param.put("shopKeeperName", parameter.get("shopKeeperName"));
        }
        if (StringUtil.isNotEmpty((String) parameter.get("startTime"))) {
            param.put("startTime", parameter.get("startTime"));
        }
        if (StringUtil.isNotEmpty((String) parameter.get("endTime"))) {
            param.put("endTime", parameter.get("endTime"));
        }
        if (parameter.get("shopId") != null && !parameter.get("shopId").equals(0L)) {
            param.put("shopId", parameter.get("shopId"));
        }

        String state = ShopInfoMapper.class.getName() + ".queryShopInfo";
        if (pageParam != null) {
            return this.commonDao.selectPage(state, param, pageParam);
        } else {
            List<ShopInfoBean> pageList = this.commonDao.selectList(state, param);
            return new PageInfo<>(pageList);
        }
    }

    @Override
    public List<ShopInfoBean> getShopInfoByshopIds(List<Long> shopIds) {
        AssertUtil.assertNotEmpty(shopIds, "商店IDs为空或不存在");
        String state = ShopInfoMapper.class.getName() + ".queryShopInfo";
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("shopIds", shopIds);
        return this.commonDao.selectList(state, param);

    }

    @Override
    public ShopInfoBean getShopInfoById(Long shopId) {
        AssertUtil.assertTrue(shopId != null && shopId > 0, "商店ID为空或不存在");
        String state = ShopInfoMapper.class.getName() + ".getShopInfoById";
        return this.commonDao.selectOne(state, shopId);
    }

    @Override
    public boolean isExistShopInfo(String shopName, String shortName, Long shopId) {
        AssertUtil.assertFalse(StringUtil.isEmpty(shopName) && StringUtil.isEmpty(shortName), "商店简称/名称为空或不存在");

        Map<String, Object> param = new HashMap<>();
        if (StringUtil.isNotEmpty(shortName)) {
            param.put("shortName", shortName);
        }
        if (StringUtil.isNotEmpty(shopName)) {
            param.put("shopName", shopName);
        }
        if (shopId != null && shopId > 0) {
            param.put("shopId", shopId);
        }

        String state = ShopInfoMapper.class.getName() + ".getShopInfoByName";
        Integer n = this.commonDao.selectOne(state, param);
        if (n == 0) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean isShopRSystem(Long shopId) {
        AssertUtil.assertTrue(shopId != null && shopId > 0, "商店ID为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("shopId", shopId);
        String state = ShopInfoMapper.class.getName() + ".getShopRSystemCounts";
        int n = this.commonDao.selectOne(state, param);
        return n > 0;
    }

    @Override
    public boolean isShopRApp(Long shopId) {
        AssertUtil.assertTrue(shopId != null && shopId > 0, "商店ID为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("shopId", shopId);
        String state = ShopInfoMapper.class.getName() + ".getShopRAppCounts";
        int n = this.commonDao.selectOne(state, param);
        return n > 0;
    }

    @Override
    public boolean isShopRUserSelfCreate(Long shopId) {
        AssertUtil.assertTrue(shopId != null && shopId > 0, "商店ID为空或不存在");

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("shopId", shopId);
        String state = ShopInfoMapper.class.getName() + ".getShopRUserSelfCreateCounts";
        int n = this.commonDao.selectOne(state, param);
        return n > 0;
    }

    @Override
    public List<ShopInfoBean> getShopInfoUnRSystem() {
        String state = ShopInfoMapper.class.getName() + ".getShopInfoUnRSystem";
        return this.commonDao.selectList(state);
    }

    @Override
    public Long insertShopInfo(ShopInfoBean bean) {
        AssertUtil.assertNotNull(bean, "商店信息不可以为空");
        AssertUtil.assertNotEmpty(bean.getShopName(), "商店名称为空或不存在");
        AssertUtil.assertNotEmpty(bean.getShortName(), "商店简称为空或不存在");
        AssertUtil.assertNotEmpty(bean.getAllocatRatio(), "分配比例为空为空或不存在");
        AssertUtil.assertNotEmpty(bean.getShopState(), "商店状态为空或不存在");
        AssertUtil.assertNotEmpty(bean.getPayStyle(), "支付方式为空或不存在");
        AssertUtil.assertNotEmpty(bean.getDelFlag(), "删除标志为空或不存在");

        boolean exist = isExistShopInfo(bean.getShopName(), null, null);
        AssertUtil.assertFalse(exist, "商店名称已存在");
        exist = isExistShopInfo(null, bean.getShortName(), null);
        AssertUtil.assertFalse(exist, "商店简称已存在");

        String state = ShopInfoMapper.class.getName() + ".insertShopInfo";
        int res = this.commonDao.insert(state, bean);
        return res > 0 ? bean.getShopId() : -1;
    }

    @Override
    public int updateShopInfo(ShopInfoBean bean) {
        AssertUtil.assertNotNull(bean, "商店信息不可以为空");
        AssertUtil.assertTrue(bean.getShopId() != null && bean.getShopId() > 0, "商店ID为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("shopId", bean.getShopId());
        if (StringUtil.isNotEmpty(bean.getShopName())) {
            boolean exist = isExistShopInfo(bean.getShopName(), null, bean.getShopId());
            AssertUtil.assertFalse(exist, "商店名称已存在");
            param.put("shopName", bean.getShopName());
        }
        if (StringUtil.isNotEmpty(bean.getShortName())) {
            boolean exist = isExistShopInfo(null, bean.getShortName(), bean.getShopId());
            AssertUtil.assertFalse(exist, "商店简称已存在");
            param.put("shortName", bean.getShortName());
        }
        if (StringUtil.isNotEmpty(bean.getAllocatRatio())) {
            param.put("allocatRatio", bean.getAllocatRatio());
        }
        if (StringUtil.isNotEmpty(bean.getShopState())) {
            param.put("shopState", bean.getShopState());
        }
        if (StringUtil.isNotEmpty(bean.getPayStyle())) {
            param.put("payStyle", bean.getPayStyle());
        }
        if (StringUtil.isNotEmpty(bean.getAreaCode())) {
            param.put("areaCode", bean.getAreaCode());
        }
        if (StringUtil.isNotEmpty(bean.getAddress())) {
            param.put("address", bean.getAddress());
        }
        if (StringUtil.isNotEmpty(bean.getRemark())) {
            param.put("remark", bean.getRemark());
        }
        if (StringUtil.isNotEmpty(bean.getDelFlag())) {
            param.put("delFlag", bean.getDelFlag());
        }
        if (bean.getUpdatePerson() != null) {
            param.put("updatePerson", bean.getUpdatePerson());
        }

        String state = ShopInfoMapper.class.getName() + ".updateShopInfo";
        return this.commonDao.update(state, param);
    }

    @Override
    public int deleteShopInfo(List<Long> shopIds) {
        AssertUtil.assertNotEmpty(shopIds, "商店id为空或不存在");
        shopIds.forEach(id -> {
            boolean exist = isShopRSystem(id);
            AssertUtil.assertFalse(exist, "商店存在授权系统，删除授权系统后再删除商店数据");

            exist = isShopRApp(id);
            AssertUtil.assertFalse(exist, "商店存在授权App，删除授权App后再删除商店数据");

            exist = isShopRUserSelfCreate(id);
            AssertUtil.assertFalse(exist, "商店存在商店管理员以外的自建用户，删除自建用户后再删除商店数据");
        });
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("shopIds", shopIds);
        String state = ShopInfoMapper.class.getName() + ".deleteShopInfo";
        return this.commonDao.update(state, param);
    }

    @Override
    public int updateShopState(List<Long> shopIds, final String shopState) {
        AssertUtil.assertNotEmpty(shopIds, "商店id为空或不存在");

        Map<String, Object> param = new HashMap<>();
        param.put("shopIds", shopIds);
        param.put("shopState", shopState);
        String state = ShopInfoMapper.class.getName() + ".updateShopState";
        return this.commonDao.update(state, param);
    }
}
