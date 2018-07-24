package cn.faury.fwmf.module.web.shop.controller;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.entry.RestResultEntry;
import cn.faury.fdk.common.exception.TipsException;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.shiro.autoconfigure.FdkShiroProperties;
import cn.faury.fdk.shiro.utils.SessionUtil;
import cn.faury.fwmf.module.api.shop.bean.ShopInfoBean;
import cn.faury.fwmf.module.api.shop.service.ShopInfoService;
import cn.faury.fwmf.module.api.system.bean.SystemInfoBean;
import cn.faury.fwmf.module.api.system.service.SystemService;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.api.user.config.UserType;
import cn.faury.fwmf.module.api.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fwmf/data/shop")
@Api(value = "商店信息", tags = {"商店信息接口"})
public class ShopController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired(required = false)
    ShopInfoService shopInfoService;

    @Autowired(required = false)
    UserService userService;

    @Autowired(required = false)
    SystemService systemService;

    @Autowired(required = false)
    FdkShiroProperties fdkShiroProperties;

    @GetMapping("queryShopInfo")
    @ApiOperation(value = "商店信息查询", notes = "商店信息查询")
    public RestResultEntry queryShopInfo(@ApiParam(name = "商店名称") String shopName
            , @ApiParam(name = "是否可用") String shopState
            , @ApiParam(name = "页码") String pageNo
            , @ApiParam(name = "分页大小") String pageSize) {
        AssertUtil.assertNotNull(shopInfoService, "商店服务shopInfoService未启用");

        Map<String, Object> param = new HashMap<>();
        param.put(PageParam.KEY.KEY_PAGE_NO, pageNo);
        param.put(PageParam.KEY.KEY_PAGE_SIZE, pageSize);
        param.put("shopName", shopName);
        param.put("shopState", shopState);

        PageInfo<ShopInfoBean> shopPage;
        try {
            shopPage = shopInfoService.queryShopInfo(param);
        } catch (TipsException e) {
            logger.debug(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("商店服务调用失败", e);
            throw new TipsException(RestResultCode.CODE500.getCode(), "商店服务调用失败", e);
        }
        return RestResultEntry.createSuccessResult(shopPage);
    }

    @GetMapping("getShopInfoById")
    @ApiOperation(value = "获取商店信息", notes = "通过商店Id来获取商店信息")
    public RestResultEntry getShopInfoById(Long shopId) {
        AssertUtil.assertNotNull(shopInfoService, "商店服务shopInfoService未启用");
        return RestResultEntry.createSuccessResult(shopInfoService.getShopInfoById(shopId));
    }

    @PostMapping("addShopInfo")
    @ApiOperation(value = "新增商店信息", notes = "新增商店信息")
    public RestResultEntry addShopInfo(ShopInfoBean shopInfoBean) {
        AssertUtil.assertNotNull(shopInfoService, "商店服务shopInfoService未启用");
        AssertUtil.assertNotNull(userService, "用户服务userService未启用");
        AssertUtil.assertNotNull(systemService, "系统服务userService未启用");
        AssertUtil.assertNotNull(fdkShiroProperties, "框架属性fdkShiroProperties服务未启用");

        AssertUtil.assertNotNull(shopInfoBean, "商店信息不可以为空");

        // 获取系统信息
        SystemInfoBean systemInfoBean = systemService.getSystemInfoByCode(fdkShiroProperties.getSaCode());
        AssertUtil.assertNotNull(systemInfoBean, "系统信息[" + fdkShiroProperties.getSaCode() + "]不存在");

        // 1，检查店主信息是否存在
        UserInfoBean userInfoBean = userService.getUserInfoByLoginName(shopInfoBean.getShopKeeperName());
        AssertUtil.assertNull(userInfoBean, "店主账户已存在");
        if (userInfoBean == null) {// 店主信息不存在，插入店主信息
            Long userId = userService.insertUserInfo(shopInfoBean.getShopKeeperName(), shopInfoBean.getShopKeeperUserName()
                    , null, systemInfoBean.getSystemId(), UserType.ORGANIZATION, SessionUtil.getCurrentLoginName(), "");
            shopInfoBean.setShopKeeperId(userId);
//        } else {
//            shopInfoBean.setShopKeeperId(userInfoBean.getUserId());
        }
        shopInfoBean.setOriginSystem(systemInfoBean.getSystemId());
        shopInfoBean.setCreatePerson(SessionUtil.getCurrentLoginName());

        Long id = shopInfoService.insertShopInfo(shopInfoBean);
        return id != null && id > 0 ? RestResultEntry.createSuccessResult(null) : RestResultEntry.createErrorResult("商店信息保存失败：返回shopId=" + id, "商店信息保存失败");
    }

    @PostMapping("updateShopInfoById")
    @ApiOperation(value = "更新商店信息", notes = "通过商店Id来更新商店信息")
    public RestResultEntry updateShopInfoById(ShopInfoBean shopInfoBean) {
        AssertUtil.assertNotNull(shopInfoService, "商店服务shopInfoService未启用");
        AssertUtil.assertNotNull(shopInfoBean, "商店信息不可以为空");

        shopInfoBean.setUpdatePerson(SessionUtil.getCurrentLoginName());
        int count = shopInfoService.updateShopInfo(shopInfoBean);
        return count > 0 ? RestResultEntry.createSuccessResult(null) : RestResultEntry.createErrorResult("商店信息保存失败", "商店信息保存失败");
    }

    @PostMapping("deleteShopInfoByid")
    @ApiOperation(value = "删除商店信息", notes = "通过商店Id来删除商店信息")
    public RestResultEntry deleteShopInfoByid(Long shopId) {
        AssertUtil.assertNotNull(shopInfoService, "商店服务shopInfoService未启用");

        shopInfoService.deleteShopInfo(Collections.singletonList(shopId));
        return RestResultEntry.createSuccessResult(null);
    }

    @PostMapping("changeShopAvailableById")
    @ApiOperation(value = "更新商店启用状态信息", notes = "通过商店Id来更新商店启用状态信息")
    public RestResultEntry changeShopAvailableById(Long shopId, String shopState) {
        AssertUtil.assertNotNull(shopInfoService, "商店服务shopInfoService未启用");

        ShopInfoBean bean = new ShopInfoBean();
        bean.setShopId(shopId);
        bean.setUpdatePerson(SessionUtil.getCurrentLoginName());
        bean.setShopState(StringUtil.whetherYes(shopState) ? StringUtil.WHETHER_YES : StringUtil.WHETHER_NO);
        shopInfoService.updateShopInfo(bean);
        return RestResultEntry.createSuccessResult(null);
    }
}
