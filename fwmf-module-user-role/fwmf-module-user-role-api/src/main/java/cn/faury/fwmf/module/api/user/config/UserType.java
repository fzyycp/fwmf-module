package cn.faury.fwmf.module.api.user.config;

import java.util.Arrays;

/**
 * 用户类型
 * <p>
 * <pre>
 * 0:框架用户，1:业务系统用户，
 * 3:购物用户，9:游客
 * </pre>
 */
public enum UserType {

    /**
     * 0:平台用户
     */
    FWMF("0", "框架用户"),
    /**
     * 1:业务系统用户(原商店用户)
     */
    SYSTEM("1", "业务系统用户"),
    /**
     * 3:购物用户
     */
    SHOPPING("3", "购物用户"),
    /**
     * 9:游客
     */
    GUEST("9", "游客");

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
    private UserType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    /**
     * 转换key到类型
     * @param key 键值
     * @return 对象
     */
    public static UserType parse(String key) {
        if (FWMF.value.equals(key)) {
            return FWMF;
        } else if (SYSTEM.value.equals(key)) {
            return SYSTEM;
        } else if (SHOPPING.value.equals(key)) {
            return SHOPPING;
        } else if (GUEST.value.equals(key)) {
            return GUEST;
        }
        return null;
    }

    /**
     * 获取value
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置value
     *
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取desc
     *
     * @return desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置desc
     *
     * @param desc 值
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /*
         * (non-Javadoc)
         *
         * @see java.lang.Enum#toString()
         */
    @Override
    public String toString() {
        return this.getValue();
    }

}
