package cn.faury.fwmf.module.api.code.service;

import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.code.bean.CodeInfoBean;

import java.util.List;

/**
 * 服务接口：数据字典表
 * <p>
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface CodeInfoService extends CrudBaseService<CodeInfoBean, Long> {

    /**
     * 根据分组编码获取该组列表
     *
     * @param codeGroupCode 分组编码
     * @return 该组列表
     */
    public List<CodeInfoBean> getCodeListByGroupCode(String codeGroupCode);

    /**
     * 根据分组编码删除该组列表
     *
     * @param codeGroupCode 分组编码
     * @return 成功删除条数
     */
    public int deleteByGroupCode(String codeGroupCode);

    /**
     * 根据分组ID删除该组列表
     *
     * @param codeGroupId 分组ID
     * @return 成功删除条数
     */
    public int deleteByGroupId(Long codeGroupId);
}