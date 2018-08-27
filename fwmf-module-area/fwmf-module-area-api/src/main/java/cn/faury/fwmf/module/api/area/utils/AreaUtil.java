package cn.faury.fwmf.module.api.area.utils;

import cn.faury.fdk.common.utils.StringUtil;

import java.util.Optional;

public class AreaUtil {

    /**
     * 只有省份编码
     *
     * @param areaCode 区域编码
     * @return 该区域编码是否只有省份编码，没有下级市县
     */
    public static boolean isProvinceOnly(String areaCode) {
        return "710000".equals(areaCode) || "810000".equals(areaCode) || "820000".equals(areaCode);
    }

    /**
     * 只有市编码
     *
     * @param areaCode 区域编码
     * @return 该区域编码是否只有市编码，没有下级区县
     */
    public static boolean isCityOnly(String areaCode) {
        return "441900".equals(areaCode) || "442000".equals(areaCode);
    }

    /**
     * 格式化省份编码
     *
     * @param areaCode 区域编码
     * @return 省份编码
     */
    public static Optional<String> formatProvinceCode(String areaCode) {
        return StringUtil.isNotEmpty(areaCode) && areaCode.length() >= 6
                ? Optional.of(areaCode.substring(0, 2) + "0000") : Optional.empty();
    }

    /**
     * 格式化市编码
     *
     * @param areaCode 区域编码
     * @return 市编码
     */
    public static Optional<String> formatCityCode(String areaCode) {
        return StringUtil.isNotEmpty(areaCode) && areaCode.length() >= 6
                ? Optional.of(areaCode.substring(0, 4) + "00") : Optional.empty();
    }

    /**
     * 格式化区县编码
     *
     * @param areaCode 区域编码
     * @return 市编码
     */
    public static Optional<String> formatCountryCode(String areaCode) {
        return StringUtil.isNotEmpty(areaCode) && areaCode.length() >= 6
                ? Optional.of(areaCode.substring(0, 6)) : Optional.empty();
    }
}
