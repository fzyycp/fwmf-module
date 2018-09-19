package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.GoodsStockGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;

import java.io.Serializable;

/**
 * 商品库存信息表
 */
public class GoodsStockBean extends GoodsStockGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    @Override
    public Long getPrimaryKey() {
        return this.getId();
    }
}