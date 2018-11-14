package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.order.generate.bean.GoodsStockInfoGenerateBean;
import java.io.Serializable;

/**
 * POJO对象：商品库存信息表
 *
 * <pre>
 *     GoodsStockInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自GoodsStockInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class GoodsStockInfoBean extends GoodsStockInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    /**
     * 获取表主键字段名(自动生成代码)
     *
     * @return 主键字段名
     */
    @Override
    public String getPrimaryKeyName() {
        return "ID";
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKeyValue() {
        return this.getId();
    }

    /**
     * JSON序列化对象(自动生成代码)
     *
     * @return JSON化对象
     */
    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}