package cn.faury.fwmf.module.api.code.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.code.bean.CodeInfoBean;

import java.util.List;
import java.util.Map;


/**
 * 字典信息管理service实现类
 */
public interface CodeInfoService {
    /**
     * 字典搜索（分页）
     *
     * @param param 查询参数
     * @return 查询结果
     */
    public PageInfo<CodeInfoBean> search(Map<String, Object> param);

    /**
     * 其他模块调用
     *
     * @param param 查询参数
     * @return 查询结果
     */
    public List<CodeInfoBean> getCodeList(Map<String, Object> param);

    /**
     * 字典新增
     *
     * @param codeInfo 字典信息
     * @return 字典ID
     */
    public Long insertCodeInfo(CodeInfoBean codeInfo);

    /**
     * 字典更新根据id
     *
     * @param codeId   字典ID
     * @param codeInfo 字典信息
     * @return 是否更新成功
     */
    public Boolean updateCodeInfoByCodeId(Long codeId, CodeInfoBean codeInfo);


    /**
     * 根据字典id获取字典信息
     *
     * @param codeId 字典ID
     * @return 字典信息
     */
    public CodeInfoBean getCodeInfoByCodeId(Long codeId);

    /**
     * 字典搜索（不分页）
     *
     * @param param 查询参数
     * @return 查询结果
     */
    public List<CodeInfoBean> getCodeInfoList(Map<String, Object> param);

    /**
     * 根据类型查找字典
     *
     * @param type 类型
     * @return 字典列表
     */
    public List<CodeInfoBean> getCodeInfoByType(String type);

    /**
     * 删除
     *
     * @param codeId 字典ID
     * @return 删除条数
     */
    public Integer deleteCodeInfoByCodeId(Long codeId);

    /**
     * 根据业务系统code、分组code、字典code获取公共代码配置信息
     *
     *
     * @param systemCode
     *            【必选】系统code
     * @param groupCode
     *            【必选】 分组code
     * @param wordCode
     *            【必选】 字典code
     *
     * @return 公共代码配置信息
     */
   default public CodeInfoBean getCodeInfoList(final String systemCode, final String groupCode, final String wordCode){
        List<CodeInfoBean> resList = getCodeInfoList(systemCode, groupCode, wordCode, Boolean.TRUE, Boolean.TRUE);
        if (resList.size() > 0) {
            return resList.get(0);
        }
        return null;
    }

    /**
     * 获取业务系统下公共代码配置信息
     *
     *
     * @param systemCode
     *            【必选】系统code
     * @param groupCode
     *            【必选】 分组code
     *
     * @return 公共代码配置信息 以<b>List</b>展示
     */
    default public List<CodeInfoBean> getCodeInfoList(final String systemCode, final String groupCode){
        return getCodeInfoList(systemCode, groupCode, null, Boolean.TRUE, Boolean.TRUE);
    }


	/* ==========part1:以下为需要读权限的服务接口========== */

    /**
     * 获取业务系统下公共代码配置信息
     *
     * <pre>
     * 说明
     *   <ol>
     *   <li>
     *   如果参数{wordCode}不为null或者不为空字符串则查询业务系统下分组下字典信息,
     *   返回为 {@link CodeInfoBean}</li> {@link #getCodeInfoList(String, String, String)}
     *   <li>
     *   如果参数{wordCode}为null或者空字符串则查询业务系统下分组信息,
     *   返回为
     *   List&lt;CodeInfoBean&gt;</li> {@link #getCodeInfoList(String, String)}
     *
     *   </ol>
     * </pre>
     *
     * @param systemCode
     *            【必选】系统code
     * @param groupCode
     *            【必选】 分组code
     * @param wordCode
     *            字典code
     * @param isSysAvailable
     *            系统是否可用
     * @param isCodeAvailable
     *            公共代码是否可用
     * @return 公共代码配置信息 以<b>List</b>展示
     */
    public List<CodeInfoBean> getCodeInfoList(final String systemCode, final String groupCode, final String wordCode,
                                              final Boolean isSysAvailable, final Boolean isCodeAvailable);

    /**
     * 获取业务系统下公共代码配置信息
     *
     * @param systemId
     *            【必选】系统Id
     * @param groupId
     *            【必选】分组Id
     * @param codeId
     *            公共代码Id
     * @param isSysAvailable
     *            系统是否可用
     * @param isCodeAvailable
     *            公共代码是否可用
     *            <p>
     *            说明
     *            </p>
     *            <ol>
     *            <li>
     *            如果参数{codeId}不为null或者不为-1则查询业务系统下分组下字典信息, 返回为
     *            {@link CodeInfoBean}</li>
     *            {@link #getCodeInfoList(Long, Long, Long)}
     *            <li>
     *            如果参数{codeId}为null或者为-1则查询业务系统下分组子级分组信息,返回为
     *            List&lt;CodeInfoBean&gt;</li>
     *
     *
     *            </ol>
     * @return 公共代码配置信息 以<b>List</b>展示
     */
    public List<CodeInfoBean> getCodeInfoList(final Long systemId, final Long groupId, final Long codeId,
                                              final Boolean isSysAvailable, final Boolean isCodeAvailable);

    /**
     * 根据系统Id、codeId获取系统公共代码配置信息
     *
     * @param systemId
     *            【必选】系统Id
     * @param codeId
     *            【必选】系统公共代码ID
     * @param isSysAvailable
     *            系统是否可用 <b>true&false</b>
     * @param isCodeAvailable
     *            公共代码是否可用 <b>true&false</b>
     * @return 系统公共代码配置信息对象
     */
    @Read
    public CodeInfoBean getCodeInfoByCodeId(final Long systemId, final Long codeId, final Boolean isSysAvailable,
                                            final Boolean isCodeAvailable);

    /**
     * 根据公共代码信息对象获取公共代码信息
     *
     * <pre>
     * 可分页
     * </pre>
     *
     * 分页参数
     *
     * <pre>
     * 【可选】codeId 	公共代码信息ID
     * 	【可选】codePId 上级公用代码ID
     * 	【可选】codeName 公共代码信息名称
     * 	【可选】codeCode 公共代码信息CODE
     * 	【可选】isLeaf 	是否末级,Y,是 N,否
     * 	【可选】isAvailable 是否可用,Y,是 N,否
     * 	【可选】systemId 	所属系统ID
     * </pre>
     *
     * @param parameter
     *            参数信息列表
     *
     *            参数形式: parameter.put(&quot;数据库字段名&quot;, &quot;值&quot;);
     * @return 分页查询公共代码信息列表
     */
    @Read
    public PageInfo<CodeInfoBean> getCodeInfoByPager(final Map<String, Object> parameter);

    /**
     * 根据系统Id、公共代码codePId获取业务系统下公共代码配置信息
     *
     * @param systemId
     *            系统code
     * @param groupId
     *            公共代码配置分组id
     * @return 公共代码配置信息列表 如需要转换tree显示
     */
    public List<CodeInfoBean> getCodeInfoTreeList(final Long systemId, final Long groupId);

    /**
     * 根据系统Id、公共代码codePId获取业务系统下公共代码配置信息
     *
     * @param systemCode
     *            【必选】系统code
     * @param groupCode
     *            【必选】 分组code
     * @return 公共代码配置信息列表 如需要转换tree显示
     */
    public List<CodeInfoBean> getCodeInfoTreeList(final String systemCode, final String groupCode);

    /**
     * 新增或者修改时check公共代码信息是否存在
     *
     * @return 存在返回true 则返回false
     */
    @Read
    public List<CodeInfoBean> checkExistCodeInfo(final CodeInfoBean instance);

    /**
     * 【批量删除】根据公共代码信息ID删除公共代码信息
     *
     * @param codeIds
     *            公共代码信息ID集合
     * @return 是否删除成功 -1表示失败
     */
    @Write
    public Integer deleteCodeInfoByCodeIds(final List<Long> codeIds);

    /**
     * 修改公共代码信息
     *
     * @param codeId
     *            【必选】 公共代码信息ID
     * @param groupId
     *            【可选】公共代码信息上级节点ID,如果该参数没有值则传null或者""
     * @param codeCode
     *            【可选】 删除分组信息则表示分组code、字典则表示字典code 如果该参数没有值则传null或者""
     * @param codeName
     *            【可选】公共代码信息NAME 如果该参数没有值则传null或者""
     * @param isLeaf
     *            【可选】 是否末级节点 如果该参数没有值则传null或者""
     * @param isAvailable
     *            【可选】是否可用 如果该参数没有值则传null或者""
     * @param systemId
     *            【可选】 系统ID 如果该参数没有值则传null或者""
     * @return 是否修改成功
     */
    @Write
    public Boolean updateCodeInfoByCodeId(final Long codeId, final Long groupId, final String codeCode,
                                          final String codeName, final String isLeaf, final String isAvailable, final Long systemId);

    /**
     * 获取业务系统下公共代码配置信息
     *
     * @param systemId
     *            【必选】系统Id
     * @param groupId
     *            【必选】 上级节点Id
     *            公共代码Id
     *            <p>
     *            说明
     *            </p>
     *            <ol>
     *            <li>
     *            如果参数{codeId}不为null或者不为-1则查询业务系统下分组下字典信息, 返回为
     *            {@link CodeInfoBean}</li>
     *            {@link #getCodeInfoList(Long, Long, Long)}
     *            <li>
     *            如果参数{codeId}为null或者为-1则查询业务系统下分组子级分组信息,返回为
     *            List&lt;CodeInfoBean&gt;</li>
     *            {@link #getCodeInfoList(Long, Long)}
     *
     *            </ol>
     * @return 公共代码配置信息 以<b>List</b>展示
     */
    default public List<CodeInfoBean> getCodeInfoList(final Long systemId, final Long groupId){
        return getCodeInfoList(systemId, groupId, null, Boolean.TRUE, Boolean.TRUE);
    }

    /**
     * 根据系统Id、分组Id、公共代码Id 获取公共代码配置信息
     *
     * @param systemId
     *            【必选】系统id
     * @param groupId
     *            【必选】 分组id
     * @param codeId
     *            【必选】公共代码id
     * @return 公共代码配置bean信息
     */
    default public CodeInfoBean getCodeInfoList(final Long systemId, final Long groupId, final Long codeId){
        List<CodeInfoBean> resList = getCodeInfoList(systemId, groupId, codeId, Boolean.TRUE, Boolean.TRUE);
        if (resList.size() > 0) {

            return resList.get(0);
        }
        return null;
    }

    /**
     * 根据分组ID查询分组下子节点
     *
     * @param codeId
     *            分组id
     * @return List<CodeInfoBean>
     */
    @Read
    public List<CodeInfoBean> getChildCodeInfoList(final Long codeId);

}
