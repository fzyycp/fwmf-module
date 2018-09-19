package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.PackageRGoodsGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 商品套餐关联商品信息
 */
public class PackageRGoodsBean extends PackageRGoodsGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    @Override
    public Long getPrimaryKey() {
        return this.getId();
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}