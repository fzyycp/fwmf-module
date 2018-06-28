package cn.faury.fwmf.module.service.shop.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.shop.bean.ShopInfoBean;
import cn.faury.fwmf.module.api.shop.service.UserRShopService;
import cn.faury.fwmf.module.service.shop.mapper.UserRShopMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRShopServiceImpl implements UserRShopService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public UserRShopServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public List<ShopInfoBean> getShopInfoByUserId(Long userId) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");

        String state = UserRShopMapper.class.getName() + ".getShopInfoByUserId";
        Map<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        return this.commonDao.selectList(state, param);

    }
}
