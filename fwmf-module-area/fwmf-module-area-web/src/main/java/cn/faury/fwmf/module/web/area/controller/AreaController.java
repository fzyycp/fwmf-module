package cn.faury.fwmf.module.web.area.controller;

import cn.faury.fdk.common.entry.RestResultEntry;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fwmf.module.api.area.bean.AreaBean;
import cn.faury.fwmf.module.api.area.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fwmf/config/area")
@Api(value = "地区信息", tags = {"地区信息接口"})
public class AreaController {

    @Autowired(required = false)
    AreaService areaService;

    @RequestMapping(value = "/getAreaByParam", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "地区信息查询", notes = "地区信息查询")
    public RestResultEntry getAreaByParam(@ApiParam(name = "省市区代码") String areaCode) {
        AssertUtil.assertNotNull(areaService, "地区服务未启用");

        List<AreaBean> areaBeans = areaService.getAreaOneTreeByCode(areaCode);
        return RestResultEntry.createSuccessResult(areaBeans);
    }

}
