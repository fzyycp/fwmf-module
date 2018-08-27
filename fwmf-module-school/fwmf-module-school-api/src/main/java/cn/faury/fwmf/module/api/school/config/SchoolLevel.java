package cn.faury.fwmf.module.api.school.config;

import java.util.Arrays;

/**
 * 学校类别：
 * k:幼儿园 p:小学  j:初中  s:高中
 */
public enum SchoolLevel {

    KINDERGARTEN("k", "幼儿园"), PRIMARY("p", "小学"), JUNIOR("j", "初中"), SENIOR("s", "高中");

    private String code;
    private String desc;

    /**
     * 私有构造函数
     *
     * @param code 编码
     * @param desc 描述
     */
    private SchoolLevel(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 格式化对象
     *
     * @param code 对象code
     * @return 对象
     */
    public static SchoolLevel parse(String code) {
        return Arrays.stream(SchoolLevel.values())
                .filter(key -> key.code.equals(code))
                .findFirst()
                .orElse(null);
    }

    /**
     * 获取code
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置code
     *
     * @param code 值
     */
    public void setCode(String code) {
        this.code = code;
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
}
