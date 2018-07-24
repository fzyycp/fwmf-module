package cn.faury.fwmf.module.api.user.config;

import java.util.Arrays;
import java.util.Optional;

/**
 * 用户类型
 *
 * <pre>
*      0: 框架用户，
*      1: 系统用户，
*      2: 机构用户，
*      3: 终端用户，
*      9: 游客
 * </pre>
 */
public enum UserType {

    /**
     * 0:框架用户
     */
    FWMF("0", "框架用户"),
    /**
     * 1:系统用户
     */
    SYSTEM("1", "系统用户"),
    /**
     * 2:机构用户(原商店用户，包括店主和店员)
     */
    ORGANIZATION("2", "机构用户"),
    /**
     * 3:终端用户(原购物用户)
     */
    ENDUSER("3", "终端用户"),
    /**
     * 9:游客用户
     */
    GUEST("9", "游客用户");

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
     *
     * @param key 键值
     * @return 对象
     */
    public static UserType parse(String key) {
        Optional<UserType> userType = Arrays.stream(UserType.values())
                .filter(type -> type.value.equals(key)).findFirst();
        return userType.isPresent() ? userType.get() : null;
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
