package cn.faury.fwmf.module.api.user.config;

/**
 * 第三方OAuth2登录来源
 *
 * <pre>
 * 00: 自建,
 * 10: 微信,
 * 11: QQ
 * 20: 新浪微博,
 * 99: 其他
 * </pre>
 */
public enum OAuthFrom {

    SSK("00", "自建"),
    WEIXIN("10", "微信"),
    QQ("11", "QQ"),
    WEIXIN_MP("12", "微信公众号"),
    SINA_WEIBO("20", "新浪微博"),
    OTHER("99", "其他");

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
     * @param value
     *            值
     */
    private OAuthFrom(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    /**
     * @return the value
     */
    public final String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
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
     * @param desc
     *            the desc to set
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
