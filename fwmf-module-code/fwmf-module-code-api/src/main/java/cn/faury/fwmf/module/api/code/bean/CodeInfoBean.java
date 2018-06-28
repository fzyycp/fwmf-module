package cn.faury.fwmf.module.api.code.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 字典信息实体类
 */
public class CodeInfoBean implements Serializable {

    /**
     * 字典ID
     */
    private Long codeId;

    /**
     * 字典名称
     */
    private String codeName;

    /**
     * 字典编码
     */
    private String codeCode;

    /**
     * 字典类型【0：分组，1：字典】
     */
    private String codeType;

    /**
     * 排序
     */
    private String codeOrder;

    /**
     * 获取codeId
     *
     * @return codeId
     */
    public Long getCodeId() {
        return codeId;
    }

    /**
     * 设置codeId
     *
     * @param codeId 值
     */
    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    /**
     * 获取codeName
     *
     * @return codeName
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * 设置codeName
     *
     * @param codeName 值
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * 获取codeCode
     *
     * @return codeCode
     */
    public String getCodeCode() {
        return codeCode;
    }

    /**
     * 设置codeCode
     *
     * @param codeCode 值
     */
    public void setCodeCode(String codeCode) {
        this.codeCode = codeCode;
    }

    /**
     * 获取codeType
     *
     * @return codeType
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * 设置codeType
     *
     * @param codeType 值
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * 获取codeOrder
     *
     * @return codeOrder
     */
    public String getCodeOrder() {
        return codeOrder;
    }

    /**
     * 设置codeOrder
     *
     * @param codeOrder 值
     */
    public void setCodeOrder(String codeOrder) {
        this.codeOrder = codeOrder;
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}
