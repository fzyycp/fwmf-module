package cn.faury.fwmf.module.service.common.web;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.entry.RestResultEntry;
import cn.faury.fdk.common.utils.AssertUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用增删改查Controller
 *
 * @param <T> 业务Bean类型
 * @param <P> Bean对应数据库主键类型
 */
public interface CrudBaseController<T, P> {

    @RequestMapping("insert")
    default RestResultEntry insert(T bean) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        return RestResultEntry.createSuccessResult(getCrudBaseService().insert(bean));
    }

    @RequestMapping("update")
    default RestResultEntry update(T bean) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        return RestResultEntry.createSuccessResult(getCrudBaseService().update(bean));
    }

    @RequestMapping("delete")
    default RestResultEntry delete(T bean) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        return RestResultEntry.createSuccessResult(getCrudBaseService().delete(bean));
    }

    @RequestMapping("deleteById")
    default RestResultEntry deleteById(P id) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        return RestResultEntry.createSuccessResult(getCrudBaseService().deleteById(id));
    }

    @RequestMapping("deleteByIdBatch")
    default RestResultEntry deleteByIdBatch(List<P> ids) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        return RestResultEntry.createSuccessResult(getCrudBaseService().deleteByIdBatch(ids));
    }

    @RequestMapping("getBeanById")
    default RestResultEntry getBeanById(P id) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        return RestResultEntry.createSuccessResult(getCrudBaseService().getBeanById(id));
    }

    @RequestMapping("getBeanByIdBatch")
    default RestResultEntry getBeanByIdBatch(List<P> ids) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        return RestResultEntry.createSuccessResult(getCrudBaseService().getBeanByIdBatch(ids));
    }

    @RequestMapping("getBeansByBelongPrimaryId")
    default RestResultEntry getBeansByBelongPrimaryId(@RequestParam Map<String, Object> param) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        Map<String, Object> _param = new HashMap<>();
        // 设置默认分页，如果有设置则自动覆盖
        _param.put(PageParam.KEY.KEY_PAGE_NO,1);
        _param.put(PageParam.KEY.KEY_PAGE_SIZE,Integer.MAX_VALUE);
        _param.putAll(param);
        PageInfo result = getCrudBaseService().getBeansByBelongPrimaryId(param.get("belongPrimaryId"),PageParam.buildDefaultIns(_param));
        return RestResultEntry.createSuccessResult(result);
    }

    @RequestMapping("query")
    default RestResultEntry query(@RequestParam Map<String, Object> param) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        return RestResultEntry.createSuccessResult(getCrudBaseService().query(param));
    }

    @RequestMapping("search")
    default RestResultEntry search(@RequestParam Map<String, Object> param) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        return RestResultEntry.createSuccessResult(getCrudBaseService().search(param));
    }

    CrudBaseService<T, P> getCrudBaseService();
}
