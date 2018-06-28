/*
 * Copyright (c)
 */

package cn.faury.fwmf.module.service.code.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.exception.TipsException;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.code.bean.CodeInfoBean;
import cn.faury.fwmf.module.api.code.service.CodeInfoService;
import cn.faury.fwmf.module.service.code.mapper.CodeInfoMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典信息管理service实现类
 */
public class CodeInfoServiceImpl implements CodeInfoService {
    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public CodeInfoServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 字典搜索（分页）
     *
     * @param param 查询参数
     * @return 查询结果
     */
    @Override
    public PageInfo<CodeInfoBean> search(Map<String, Object> param) {
        PageParam pageParam = PageParam.buildDefaultIns(param);
        String state = CodeInfoMapper.class.getName() + ".search";
        return this.commonDao.selectPage(state, param, pageParam);
    }

    /**
     * 其他模块调用
     *
     * @param param 查询参数
     * @return 查询结果
     */
    @Override
    public List<CodeInfoBean> getCodeList(Map<String, Object> param) {
        String state = CodeInfoMapper.class.getName() + ".search";
        return this.commonDao.selectList(state, param);
    }

    /**
     * 字典新增
     *
     * @param codeInfo 字典信息
     * @return 字典ID
     */
    @Override
    public Long insertCodeInfo(CodeInfoBean codeInfo) {
        if (checkExistCodeInfo(codeInfo.getCodeCode(), codeInfo.getCodeName())) {
            throw new TipsException(RestResultCode.CODE500.getCode(), "字典编码重复", "全局系统或该系统已经存在了一个相同的字典编码：" + codeInfo.getCodeCode());
        }
        String statement = CodeInfoMapper.class.getName() + ".insertCodeInfo";
        int res = this.commonDao.insert(statement, codeInfo);
        return res > 0 ? codeInfo.getCodeId() : -1;
    }

    /**
     * 字典更新根据id
     *
     * @param codeId 字典ID
     * @param codeInfo 字典信息
     * @return 是否更新成功
     */
    @Override
    public Boolean updateCodeInfoByCodeId(Long codeId, CodeInfoBean codeInfo) {
        if (checkExistCodeInfo(codeInfo.getCodeCode(), codeInfo.getCodeName())) {
            throw new TipsException(RestResultCode.CODE500.getCode(), "字典编码已存在", codeInfo.getCodeCode() + "字典编码已存在");
        }

        Map<String, Object> parameter = new HashMap<String, Object>();
        if (codeId != null) {
            parameter.put("codeId", codeId);
        }
        if (codeInfo.getCodeName() != null) {
            parameter.put("codeName", codeInfo.getCodeName());
        }
        if (StringUtil.isNotEmpty(codeInfo.getCodeCode())) {
            parameter.put("codeCode", codeInfo.getCodeCode());
        }
        if (StringUtil.isNotEmpty(codeInfo.getCodeName())) {
            parameter.put("codeName", codeInfo.getCodeName());
        }
        if (StringUtil.isNotEmpty(codeInfo.getCodeType())) {
            parameter.put("codeType", codeInfo.getCodeType());
        }
        if (StringUtil.isNotEmpty(codeInfo.getCodeOrder())) {
            parameter.put("codeOrder", codeInfo.getCodeOrder());
        }
        String statement = CodeInfoMapper.class.getName() + ".updateCodeInfoByCodeId";
        int res = this.commonDao.update(statement, parameter);
        return res > 0;
    }

    /**
     * 根据字典id获取字典信息
     *
     * @param codeId 字典ID
     * @return 字典信息
     */
    public CodeInfoBean getCodeInfoByCodeId(Long codeId) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("codeId", codeId);
        List<CodeInfoBean> codeInfoList = getCodeInfoList(param);
        if (codeInfoList.size() > 0) {
            return codeInfoList.get(0);
        }
        return null;
    }

    /**
     * 字典搜索（不分页）
     *
     * @param param 查询参数
     * @return 查询结果
     */
    public List<CodeInfoBean> getCodeInfoList(Map<String, Object> param) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        if (StringUtil.isNotEmpty((String) param.get("codeId"))) {
            parameter.put("codeId", param.get("codeId"));
        }
        if (StringUtil.isNotEmpty((String) param.get("codeName"))) {
            parameter.put("codeName", param.get("codeName"));
        }
        if (StringUtil.isNotEmpty((String) param.get("codeCode"))) {
            parameter.put("codeCode", param.get("codeCode"));
        }
        if (StringUtil.isNotEmpty((String) param.get("codeType"))) {
            parameter.put("codeType", param.get("codeType"));
        }

        String state = CodeInfoMapper.class.getName() + ".search";

        return this.commonDao.selectList(state, parameter);
    }

    /**
     * 根据类型查找字典
     *
     * @param type 类型
     * @return 字典列表
     */
    public List<CodeInfoBean> getCodeInfoByType(String type) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("codeType", StringUtil.emptyDefault(type,""));

        String state = CodeInfoMapper.class.getName() + ".getCodeInfoByType";

        return this.commonDao.selectList(state, parameter);
    }

    // 检查code是否存在
    private Boolean checkExistCodeInfo(String codeCode, String codeName) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("codeCode", codeCode);
        parameter.put("codeName", codeName);
        String statement = CodeInfoMapper.class.getName() + ".search";
        List<CodeInfoBean> resList = this.commonDao.selectList(statement, parameter);
        if (resList.size() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 删除
     *
     * @param codeId 字典ID
     * @return 删除条数
     */
    @Override
    public Integer deleteCodeInfoByCodeId(Long codeId) {
        String statement = CodeInfoMapper.class.getName() + ".delete";
        Integer res = this.commonDao.delete(statement, codeId);
        return res;
    }



    @Override
    public List<CodeInfoBean> getCodeInfoList(String systemCode, String groupCode, String wordCode,
                                              Boolean isSysAvailable, Boolean isCodeAvailable) {
        Map<String, Object> parameter = new HashMap<String, Object>();

        if (StringUtil.isNotEmpty(systemCode)) {
            parameter.put("systemCode", systemCode);
        }
        if (StringUtil.isNotEmpty(groupCode)) {
            parameter.put("groupCode", groupCode);
        }
        if (StringUtil.isNotEmpty(wordCode)) {
            parameter.put("wordCode", wordCode);
        }
        if (null != isSysAvailable) {
            parameter.put("isSysAvailable", isSysAvailable);
        }
        if (null != isCodeAvailable) {
            parameter.put("isCodeAvailable", isCodeAvailable);
        }
        String statement = CodeInfoMapper.class.getName() + ".getCodeInfoListByCode";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<CodeInfoBean> getCodeInfoList(Long systemId, Long codePId, Long codeId, Boolean isSysAvailable,
                                              Boolean isCodeAvailable) {
        Map<String, Object> parameter = new HashMap<>();
        if (null != systemId) {
            parameter.put("systemId", systemId);
        }
        if (null != codePId) {
            parameter.put("codePId", codePId);
        }
        if (null != codeId) {
            parameter.put("codeId", codeId);
        }
        if (null != isSysAvailable) {
            parameter.put("isSysAvailable", isSysAvailable);
        }
        if (null != isCodeAvailable) {
            parameter.put("isCodeAvailable", isCodeAvailable);
        }
        String statement = CodeInfoMapper.class.getName() + ".getCodeInfoListById";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public CodeInfoBean getCodeInfoByCodeId(Long systemId, Long codeId, Boolean isSysAvailable, Boolean isCodeAvailable) {
        AssertUtil.assertTrue(systemId!=null&&systemId>0,"业务系统ID不能为空或不存在");
        AssertUtil.assertTrue(codeId!=null&&codeId>0,"字典ID不能为空或不存在");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("codeId", codeId);
        parameter.put("systemId", systemId);
        if (null != isSysAvailable) {
            parameter.put("isSysAvailable", isSysAvailable);
        }
        if (null != isCodeAvailable) {
            parameter.put("isCodeAvailable", isCodeAvailable);
        }
        String statement = CodeInfoMapper.class.getName() + ".getCodeInfoByCodeId";
        return this.commonDao.selectOne(statement, parameter);
    }

    /*
     * 
     * @see
     * cn.wassk.platform.inteface.code.adapter.CodeServieAdapter#getCodeInfoByPager
     * (java.util.Map)
     */
    @Override
    public PageInfo<CodeInfoBean> getCodeInfoByPager(Map<String, Object> parameter) {
        String statement = CodeInfoMapper.class.getName() + ".getCodeInfoByPager";
        return this.commonDao.selectPage(statement, parameter, PageParam.buildDefaultIns(parameter));
    }

    @Override
    public List<CodeInfoBean> getCodeInfoTreeList(Long systemId, Long groupId) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        // 系统Id
        parameter.put("systemId", systemId);
        // 公共代码上级节点Id
        parameter.put("codePId", groupId);
        String statement = CodeInfoMapper.class.getName() + ".getCodeInfoListTree";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<CodeInfoBean> getCodeInfoTreeList(String systemCode, String groupCode) {
        Map<String, Object> parameter = new HashMap<String, Object>();

        if (StringUtil.isNotEmpty(systemCode)) {
            parameter.put("systemCode", systemCode);
        }
        if (StringUtil.isNotEmpty(groupCode)) {
            parameter.put("groupCode", groupCode);
        }
        String statement = CodeInfoMapper.class.getName() + ".getCodeInfoTreeListByCode";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<CodeInfoBean> checkExistCodeInfo(CodeInfoBean instance) {
        Map<String, Object> parameter = new HashMap<>();

        if (instance!=null){
            if (null != instance.getCodeId()) {
                parameter.put("codeId", instance.getCodeId());
            }
            if (StringUtil.isNotEmpty(instance.getCodeCode())) {
                parameter.put("codeCode", instance.getCodeCode());
            }
            if (StringUtil.isNotEmpty(instance.getCodeName())) {
                parameter.put("codeName", instance.getCodeName());
            }
        }
        String statement = CodeInfoMapper.class.getName() + ".checkCodeInfo";
        return this.commonDao.selectList(statement, parameter);
    }

    @Override
    public List<CodeInfoBean> getChildCodeInfoList(Long codeId) {
        AssertUtil.assertTrue(codeId!=null&&codeId>0,"分类组ID为空或不存在");
        String statement =  CodeInfoMapper.class.getName() + ".getChildCodeInfoList";
        return this.commonDao.selectList(statement, codeId);
    }

    @Override
    public Integer deleteCodeInfoByCodeIds(List<Long> codeIds) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("codeIds", codeIds);
        for (int i = 0; i < codeIds.size(); i++) {
            List<CodeInfoBean> list = this.getChildCodeInfoList(codeIds.get(i));
            AssertUtil.assertEmpty(list,"存在子节点，请先删除子节点");
        }
        String statement = CodeInfoMapper.class.getName() + ".deleteCodeInfoByCodeIds";
        return this.commonDao.delete(statement, parameter);
    }

    public Boolean checkExistCodeInfo(Long systemId, Long codePId, String codeCode) {
        CodeInfoBean bean = new CodeInfoBean();
        bean.setCodeCode(codeCode);
        List<CodeInfoBean> resList = this.checkExistCodeInfo(bean);
        if (resList.size() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Boolean updateCodeInfoByCodeId(Long codeId, Long codePId, String codeCode, String codeName, String isLeaf,
                                          String isAvailable, Long systemId) {
        CodeInfoBean resBean = getCodeInfoByCodeId(codeId);
        if (!resBean.getCodeCode().equals(codeCode)) {
            AssertUtil.assertFalse(checkExistCodeInfo(systemId, codePId, codeCode),"全局系统或该系统已经存在了一个相同的字典编码：" + codeCode);
        }
        Map<String, Object> parameter = new HashMap<String, Object>();
        if (codeId != null) {
            parameter.put("codeId", codeId);
        }
        if (codePId != null) {
            parameter.put("codePId", codePId);
        }
        if (systemId != null) {
            parameter.put("systemId", systemId);
        }
        if (StringUtil.isNotEmpty(codeCode)) {
            parameter.put("codeCode", codeCode);
        }
        if (StringUtil.isNotEmpty(codeName)) {
            parameter.put("codeName", codeName);
        }
        if (StringUtil.isNotEmpty(isLeaf)) {
            parameter.put("isLeaf", isLeaf);
        }
        if (StringUtil.isNotEmpty(isAvailable)) {
            parameter.put("isAvailable", isAvailable);
        }
        String statement = CodeInfoMapper.class.getName() + ".updateCodeInfoByCodeId";
        int res = this.commonDao.update(statement, parameter);
        return res > 0;
    }


}
