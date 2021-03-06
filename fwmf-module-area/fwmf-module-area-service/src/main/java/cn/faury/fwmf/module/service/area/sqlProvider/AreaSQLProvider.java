package cn.faury.fwmf.module.service.area.sqlProvider;

import cn.faury.fwmf.module.service.constant.DBConstOfArea;

import java.util.Map;

public class AreaSQLProvider {

    /**
     * 获取指定的查询获取地区
     *
     * @param params 参数列表
     * @return sql语句
     */
    public String getAreaByCode(Map<String, Object> params) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ADMAREA_CODE, ADMAREA_NAME ");
        sql.append("  FROM " + DBConstOfArea.TN_AREA);
        sql.append(" WHERE ADMAREA_CODE LIKE #{areaCode} ");
        if (params.get("exCode") != null) {
            sql.append(" AND ADMAREA_CODE <> #{exCode}");
        }
        return sql.toString();
    }
}
