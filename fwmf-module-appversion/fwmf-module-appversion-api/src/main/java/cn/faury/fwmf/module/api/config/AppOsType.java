package cn.faury.fwmf.module.api.config;

import java.util.Arrays;
import java.util.Optional;

/**
 * APP系统类型
 */
public enum AppOsType {
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
    private AppOsType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    /**
     * 编码转枚举对象
     *
     * @param value 枚举值
     * @return APP系统类型
     */
    public static AppOsType parse(String value) {
        Optional<AppOsType> obj = Arrays.stream(AppOsType.values())
                .filter(type -> type.getValue().equals(value))
                .findFirst();
        return obj.orElse(null);
    }

    /**
     * @return the value
     */
    public final String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public final void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
