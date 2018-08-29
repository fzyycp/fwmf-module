package cn.faury.fwmf.module.service.common.web;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fdk.common.entry.RestResultEntry;
import cn.faury.fdk.common.utils.AssertUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("getBeanById")
    default RestResultEntry getBeanById(P id) {
        AssertUtil.assertNotNull(getCrudBaseService(), "服务未启用");
        return RestResultEntry.createSuccessResult(getCrudBaseService().getBeanById(id));
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
