package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.exception.TipsException;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.DateUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.user.bean.ShopRUserBean;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.api.user.service.ShopRUserService;
import cn.faury.fwmf.module.api.user.service.UserService;
import cn.faury.fwmf.module.service.user.mapper.ShopRUserMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商店用户服务
 */
public class ShopRUserServiceImpl implements ShopRUserService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    protected UserService userService;

    public ShopRUserServiceImpl(CommonDao commonDao, UserService userService) {
        this.commonDao = commonDao;
        this.userService = userService;
    }

    @Override
    public PageInfo<ShopRUserBean> queryShopRUserInfoPage(Map<String, Object> parameters) {
        AssertUtil.assertNotEmpty((String) parameters.get("shopId"), "商店ID不能为空");
        String state = ShopRUserMapper.class.getName() + ".queryShopRUserInfoList";

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("shopId", parameters.get("shopId"));
        if (StringUtil.isNotEmpty((String) parameters.get("systemId"))) {
            parameter.put("systemId", parameters.get("systemId"));
        }
        if (StringUtil.isNotEmpty((String) parameters.get("shopUserLoginName"))) {
            parameter.put("shopUserLoginName", parameters.get("shopUserLoginName"));
        }
        if (StringUtil.isNotEmpty((String) parameters.get("shopUserName"))) {
            parameter.put("shopUserName", parameters.get("shopUserName"));
        }

        return this.commonDao.selectPage(state, parameter, PageParam.buildDefaultIns(parameters));
    }

    @Override
    public List<ShopRUserBean> queryShopRUserInfoList(Map<String, Object> parameters) {
        String state = ShopRUserMapper.class.getName() + ".queryShopRUserInfoList";
        Map<String, Object> parameter = new HashMap<String, Object>();
        if (StringUtil.isNotEmpty((String) parameters.get("systemId"))) {
            parameter.put("systemId", parameters.get("systemId"));
        }
        if (StringUtil.isNotEmpty((String) parameters.get("shopUserLoginName"))) {
            parameter.put("shopUserLoginName", parameters.get("shopUserLoginName"));
        }
        if (StringUtil.isNotEmpty((String) parameters.get("shopUserName"))) {
            parameter.put("shopUserName", parameters.get("shopUserName"));
        }

        return this.commonDao.selectList(state, parameter);
    }

    @Override
    public ShopRUserBean getShopRUserInfoById(Long shopUserId, Long shopId) {
        AssertUtil.assertTrue(shopUserId != null && shopUserId > 0, "用户ID为空或不存在");
        AssertUtil.assertTrue(shopId != null && shopId > 0, "商店ID为空或不存在");
        String state = ShopRUserMapper.class.getName() + ".getShopRUserInfoById";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("shopUserId", shopUserId);
        parameter.put("shopId", shopId);
        return this.commonDao.selectOne(state, parameter);
    }

    @Override
    public PageInfo<ShopRUserBean> getShopUnUserList(Map<String, Object> parameters) {
        AssertUtil.assertNotEmpty((String) parameters.get("shopId"), "商店ID不能为空");
        AssertUtil.assertNotEmpty((String) parameters.get("systemId"), "系统ID不能为空");

        String state = ShopRUserMapper.class.getName() + ".getShopUnUserList";

        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("shopId", parameters.get("shopId"));
        parameter.put("systemId", parameters.get("systemId"));
        if (StringUtil.isNotEmpty((String) parameters.get("shopUserLoginName"))) {
            parameter.put("shopUserLoginName", parameters.get("shopUserLoginName"));
        }
        if (StringUtil.isNotEmpty((String) parameters.get("shopUserName"))) {
            parameter.put("shopUserName", parameters.get("shopUserName"));
        }

        return this.commonDao.selectPage(state, parameter, PageParam.buildDefaultIns(parameters));
    }

    @SuppressWarnings({"unchecked", "unused"})
    @Override
    public PageInfo<ShopRUserBean> getShopInfo(PageParam pageParam, Map<String, Object> parameter) {

        Map<String, Object> param = new HashMap<>();
        Long shopId = -1L;
        if (parameter.get("shopId") != null) {
            try {
                shopId = Long.parseLong(parameter.get("shopId").toString());
            } catch (Exception e) {
                throw new TipsException(RestResultCode.CODE500.getCode(), "传入参数错误：" + e.getMessage(), "软件异常", e);
            }
        }

        if (shopId > 0L) {
            param.put("shopId", parameter.get("shopId"));
        }
        try {
            if (StringUtil.isNotEmpty((String) parameter.get("systemCode"))) {
                param.put("systemCode", parameter.get("systemCode"));
            }
            if (StringUtil.isNotEmpty((String) parameter.get("shopName"))) {
                param.put("shopName", parameter.get("shopName"));
            }
            if (StringUtil.isNotEmpty((String) parameter.get("shortName"))) {
                param.put("shortName", parameter.get("shortName"));
            }
            if (StringUtil.isNotEmpty((String) parameter.get("shopUserName"))) {
                param.put("shopUserName", parameter.get("shopUserName"));
            }
            if (StringUtil.isNotEmpty((String) parameter.get("shopUserLoginName"))) {
                param.put("shopUserLoginName", parameter.get("shopUserLoginName"));
            }
            if (parameter.get("userIds") != null) {
                List<Long> userIds = (List<Long>) parameter.get("userIds");
                if (userIds.size() > 0) {
                    param.put("userIds", userIds);
                }
            }
        } catch (Exception e) {
            throw new TipsException(RestResultCode.CODE500.getCode(), "传入参数错误：" + e.getMessage(), "软件异常", e);
        }

        String state = ShopRUserMapper.class.getName() + ".getShopInfo";
        if (pageParam != null) {
            return this.commonDao.selectPage(state, param, pageParam);
        } else {
            List<ShopRUserBean> pageList = this.commonDao.selectList(state, param);
            return new PageInfo<>(pageList);
        }
    }

    @Override
    public Boolean isShopUserR(Long shopUserId) {
        AssertUtil.assertTrue(shopUserId != null && shopUserId > 0, "用户ID为空或不存在");
        String state = ShopRUserMapper.class.getName() + ".isShopUserR";
        List<Integer> list = this.commonDao.selectList(state, shopUserId);
        StringBuffer message = new StringBuffer(128);
        message.append("用户");
        Integer count = 0;
        if (list != null && list.size() > 0) {
            if (list.get(0) > 0) {
                count = count + list.get(0);
                message.append("已授权系统，");
            }
            if (list.get(1) > 0) {
                count = count + list.get(1);
                message.append("已授权App，");
            }
            if (list.get(2) > 0) {
                count = count + list.get(2);
                message.append("是测试用户，");
            }
            if (list.get(3) > 0) {
                count = count + list.get(3);
                message.append("关联角色，");
            }
            if (list.get(4) > 0) {
                count = count + list.get(4);
                message.append("关联用户组，");
            }
            // 存在关联关系
            if (count > 0) {
                message.append("请取消关联之后，重新删除。");
                throw new TipsException(RestResultCode.CODE500.getCode(), message.toString());
            }
        }
        return true;
    }

    @Override
    @Transactional
    public Long insertShopRUser(ShopRUserBean bean) {
        AssertUtil.assertNotNull(bean, "要保存的商店用户信息为空");
        AssertUtil.assertNotEmpty(bean.getShopUserLoginName(), "用户登录名为空或不存在！");
        AssertUtil.assertNotEmpty(bean.getShopUserName(), "用户姓名为空或不存在！");
        AssertUtil.assertNotEmpty(bean.getPassword(), "密码为空或不存在！");
        AssertUtil.assertNotEmpty(bean.getCreatePerson(), "创建人为空或不存在！");
        AssertUtil.assertTrue(bean.getSystemId() != null && bean.getSystemId() > 0, "系统ID为空或不存在");

        AssertUtil.assertTrue(bean.getShopId() != null && bean.getShopId() > 0, "商店ID为空或不存在");
        AssertUtil.assertNotEmpty(bean.getIsSelfCreate(), "是否自建为空或不存在！");
        AssertUtil.assertNotEmpty(bean.getIsAdmin(), "是否是店主为空或不存在！");

        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.setLoginName(bean.getShopUserLoginName());
        userInfoBean.setUserName(bean.getShopUserName());
        userInfoBean.setPassword(bean.getPassword());
        userInfoBean.setEfctYmd(new Date());
        userInfoBean.setExprYmd(DateUtil.parse("2049-12-31"));
        userInfoBean.setOriginOsId(bean.getSystemId());
        userInfoBean.setCreatePerson(bean.getCreatePerson());
        userInfoBean.setUpdatePerson(StringUtil.emptyDefault(bean.getUpdatePerson(), bean.getCreatePerson()));


        Long userId = userService.insertUserInfo(userInfoBean);
        this.insertShopRUserById(bean.getShopId(), userId, bean.getIsSelfCreate(), bean.getIsAdmin());
        return userId;

    }

    @Override
    public Integer insertShopRUserById(Long shopId, Long shopUserId, String isSelfCreate, String isAdmin) {
        AssertUtil.assertTrue(shopId != null && shopId > 0, "商店ID为空或不存在");
        AssertUtil.assertTrue(shopUserId != null && shopUserId > 0, "用户ID不能为空或不存在");
        AssertUtil.assertNotEmpty(isSelfCreate, "是否自建为空或不存在！");
        AssertUtil.assertNotEmpty(isAdmin, "是否是店主为空或不存在！");

        String state = ShopRUserMapper.class.getName() + ".insertShopRUserInfo";
        ShopRUserBean bean = new ShopRUserBean();
        bean.setIsSelfCreate(isSelfCreate);
        bean.setShopId(shopId);
        bean.setShopUserId(shopUserId);
        bean.setIsAdmin(isAdmin);
        return this.commonDao.insert(state, bean);
    }

    @Override
    public Integer deleteShopRUser(final List<Long> shopUserIds, final Long shopId) {
        AssertUtil.assertNotEmpty(shopUserIds, "用户ID不能为空或不存在");
        AssertUtil.assertTrue(shopId != null && shopId > 0, "商店ID为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("shopUserIds", shopUserIds);
        parameter.put("shopId", shopId);
        String state = ShopRUserMapper.class.getName() + ".deleteShopRUser";
        return this.commonDao.delete(state, parameter);
    }

    @Override
    @Transactional
    public Integer deleteUser(final List<Long> shopUserIds, Long shopId, Boolean isSelfCreate) {
        AssertUtil.assertNotEmpty(shopUserIds, "用户ID不能为空或不存在");
        AssertUtil.assertTrue(shopId != null && shopId > 0, "商店ID为空或不存在");
        AssertUtil.assertNotNull(isSelfCreate, "是否自建不能为空或不存在");

        shopUserIds.forEach(id -> {
            ShopRUserBean bean = this.getShopRUserInfoById(id, shopId);
            // 数据不存在
            AssertUtil.assertNotNull(bean, "要删除的商店用户不存在或已被删除");
            // 传入的是否自建参数是否合法
            if ("Y".equals(bean.getIsSelfCreate()) != isSelfCreate) {
                throw new TipsException(RestResultCode.CODE500.getCode(), "输入参数非法【是否自建参数与数据库不一致】");
            }
            // 店主用户不可以删除
            if ("Y".equals(bean.getIsAdmin())) {
                throw new TipsException(RestResultCode.CODE500.getCode(), "店主用户" + bean.getShopUserLoginName() + "不能被删除");
            }
            if (isSelfCreate) {
                this.isShopUserR(id);
            }
        });
        return deleteShopRUser(shopUserIds, shopId);
    }

    @Override
    public Integer updateShopRUser(ShopRUserBean bean) {
        AssertUtil.assertNotEmpty(bean.getIsSelfCreate(), "是否自建不能为空或不存在");
        AssertUtil.assertTrue(bean.getIsSelfCreate().equals("N"), "非自建用户不能修改用户信息");
        AssertUtil.assertTrue(bean.getShopUserId() != null && bean.getShopUserId() > 0, "用户ID不能为空或不存在");
        AssertUtil.assertNotEmpty(bean.getShopUserLoginName(), "用户登录名为空或不存在");
        AssertUtil.assertNotEmpty(bean.getShopUserName(), "用户姓名为空或不存在");

        return userService.updateUserInfoById(bean.getShopUserName(), null, null, bean.getUpdatePerson(),
                bean.getShopUserId());
    }
}
