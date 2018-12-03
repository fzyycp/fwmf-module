package cn.faury.fwmf.module.api.app.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.app.generate.bean.AppVersionGenerateBean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Optional;

/**
 * POJO对象：APP版本信息表
 * <p>
 * <pre>
 *     AppVersionGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自AppVersionGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class AppVersionBean extends AppVersionGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {
    @Override
    public String getPrimaryKeyName() {
        return "ID";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return this.getId();
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKey() {
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

    /**
     * APP系统类型
     */
    public enum AppSysType {
        /**
         * 安卓中文版
         */
        ANDROIDCN("01", "安卓中文版"),
        /**
         * IOS中文版
         */
        IOSCN("02", "IOS中文版"),
        /**
         * 安卓英文版
         */
        ANDORIDEN("03", "安卓英文版"),
        /**
         * IOS英文版
         */
        IOSEN("04", "IOS英文版");

        /**
         * 值
         */
        private String value;

        /**
         * 描述
         */
        private String desc;

        /**
         * 构造函数
         *
         * @param value 值
         */
        private AppSysType(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        /**
         * 编码转枚举对象
         *
         * @param value 枚举值
         * @return APP系统类型
         */
        public static AppSysType parse(String value) {
            Optional<AppSysType> obj = Arrays.stream(AppSysType.values())
                    .filter(type -> type.getValue().equals(value))
                    .findFirst();
            return obj.orElse(null);
        }

        public String getValue() {
            return value;
        }

        public String getDesc() {
            return desc;
        }

        @Override
        public String toString() {
            return this.getValue();
        }
    }
}