package cn.faury.fwmf.module.api.category.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.category.generate.bean.CategoryInfoGenerateBean;
import java.io.Serializable;

/**
 * POJO对象：分类信息表
 *
 * <pre>
 *     CategoryInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自CategoryInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class CategoryInfoBean extends CategoryInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    /**
     * 父节点名称
     */
    private String parentName;

    /**
     * 获取表主键字段名(自动生成代码)
     *
     * @return 主键字段名
     */
    @Override
    public String getPrimaryKeyName() {
        return "PRODUCT_CATEGORY_ID";
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKeyValue() {
        return this.getProductCategoryId();
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

    /**
     * 获取parentName
     *
     * @return parentName
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 设置parentName
     *
     * @param parentName 值
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}