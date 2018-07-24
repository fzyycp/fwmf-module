package cn.faury.fwmf.module.web.system.controller;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.entry.RestResultEntry;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.system.bean.SystemInfoBean;
import cn.faury.fwmf.module.api.system.service.SystemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fwmf/config/system")
@Api(value = "系统信息", tags = {"系统信息接口"})
public class SystemController {

    @Autowired(required = false)
    SystemService systemService;

    @RequestMapping(value = "/querySystemInfo", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "系统信息查询", notes = "系统信息查询")
    public RestResultEntry querySystemInfo(@ApiParam(name = "是否可用") String isAvailable, @ApiParam(name = "页码") String pageNo, @ApiParam(name = "分页大小") String pageSize) {
        AssertUtil.assertNotNull(systemService, "系统服务未启用");

        Map<String, Object> paramters = new HashMap<>();
        SystemInfoBean query = new SystemInfoBean();
        if (StringUtil.isNotEmpty(isAvailable)) {
            query.setIsAvailable(isAvailable);
            paramters.put("systemInfoBean", query);
        }
        if (StringUtil.isNotEmpty(pageNo)) {
            paramters.put(PageParam.KEY.KEY_PAGE_NO, pageNo);
        }
        if (StringUtil.isNotEmpty(pageSize)) {
            paramters.put(PageParam.KEY.KEY_PAGE_SIZE, pageSize);
        }
        PageInfo<SystemInfoBean> systems = systemService.querySystemInfoList(paramters);
        return RestResultEntry.createSuccessResult(Collections.singletonList(systems));
    }

    @RequestMapping(value = "/addSystemInfo", method = {RequestMethod.POST})
    @ApiOperation(value = "新增系统", notes = "添加系统信息")
    public RestResultEntry addSystemInfo(@ApiParam(name = "系统信息对象") SystemInfoBean bean) {
        AssertUtil.assertNotNull(systemService, "系统服务未启用");
        AssertUtil.assertNotNull(bean, "系统信息不可以为空");

        Long count = systemService.insertSystemInfo(bean.getSystemName(), bean.getSystemCode(), bean.getIsAvailable());

        return count > 0 ? RestResultEntry.createSuccessResult(null) : RestResultEntry.createErrorResult(RestResultCode.CODE500);
    }

    @RequestMapping(value = "/updateSystemInfo", method = {RequestMethod.POST})
    @ApiOperation(value = "修改系统信息", notes = "修改系统信息")
    public RestResultEntry updateSystemInfo(@ApiParam(name = "系统信息对象") SystemInfoBean bean) {
        AssertUtil.assertNotNull(systemService, "系统服务未启用");
        AssertUtil.assertNotNull(bean, "系统信息不可以为空");

        Boolean count = systemService.updateSystemInfoById(bean.getSystemName(), bean.getSystemCode(), bean.getIsAvailable(), bean.getSystemId());

        return count ? RestResultEntry.createSuccessResult(null) : RestResultEntry.createErrorResult(RestResultCode.CODE500);
    }

    @RequestMapping(value = "/changeSystemAvailableById", method = {RequestMethod.POST})
    @ApiOperation(value = "启禁用系统", notes = "修改系统的启用/禁用状态")
    public RestResultEntry changeSystemAvailableById(@ApiParam(name = "是否可用", required = true) String isAvailable, @ApiParam(name = "系统ID", required = true) String systemId) {
        AssertUtil.assertNotEmpty(isAvailable, "系统状态不可以为空");
        AssertUtil.assertNotEmpty(systemId, "系统ID不可以为空");
        AssertUtil.assertTrue("Y".equals(isAvailable) || "N".equals(isAvailable), "系统状态参数错误");

        Boolean updated = systemService.updateSystemInfoById(null, null, isAvailable, Long.parseLong(systemId));
        return updated ? RestResultEntry.createSuccessResult(null) : RestResultEntry.createErrorResult(RestResultCode.CODE500);
    }
}
