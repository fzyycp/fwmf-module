package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.PostageRAreaGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 邮费关联区域信息表
 */
public class PostageRAreaBean extends PostageRAreaGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    @Override
    public Long getPrimaryKey() {
        return this.getId();
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}