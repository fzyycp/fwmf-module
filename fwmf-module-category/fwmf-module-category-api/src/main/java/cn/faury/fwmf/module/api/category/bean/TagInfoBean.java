package cn.faury.fwmf.module.api.category.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.category.generate.bean.TagInfoGenerateBean;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * POJO对象：标签信息表
 *
 * <pre>
 *     TagInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自TagInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class TagInfoBean extends TagInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

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
        return "TAG_ID";
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKeyValue() {
        return this.getTagId();
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

    /**
     * 标签类型
     */
    public enum Type{
        TAG_GROUP("01","标签组"),TAG_VALUE("02","标签值");

        /**
         * 编码
         */
        private String code;

        /**
         * 描述
         */
        private String desc;

        Type(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public static Optional<Type> parse(String code) {
            return Arrays.stream(Type.values()).filter(type -> type.getCode().equals(code)).findFirst();
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}