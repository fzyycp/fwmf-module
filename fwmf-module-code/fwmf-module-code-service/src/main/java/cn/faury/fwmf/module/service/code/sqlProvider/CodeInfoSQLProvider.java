package cn.faury.fwmf.module.service.code.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.service.constant.DBConstOfCode;

import java.util.Map;

/**
 * 字典信息管理Provider
 */
public class CodeInfoSQLProvider {
    /**
     * 获取字典列表
     */
    public String search(Map<String, Object> param) {
        StringBuilder sql = new StringBuilder();

        sql.append(" SELECT CODE_ID codeId,CODE_NAME codeName,CODE_CODE codeCode,CODE_TYPE codeType,CODE_ORDER codeOrder");
        sql.append(" FROM " + DBConstOfCode.TN_CODE_INFO);
        sql.append(" WHERE 1 = 1 ");
        if (StringUtil.isNotEmpty((String) param.get("codeId"))) {
            sql.append(" AND CODE_ID =#{codeId}");
        }
        if (StringUtil.isNotEmpty((String) param.get("codeName"))) {
            sql.append(" AND CODE_NAME LIKE CONCAT('%',#{codeName},'%')");
        }
        if (StringUtil.isNotEmpty((String) param.get("codeCode"))) {
            sql.append(" AND CODE_CODE LIKE CONCAT('%',#{codeCode},'%')");
        }
        if (StringUtil.isNotEmpty((String) param.get("codeType"))) {
            sql.append(" AND CODE_TYPE LIKE CONCAT('%',#{codeType},'%')");
        }
        sql.append(" ORDER BY codeOrder ");
        return sql.toString();
    }

    /**
     * 更新字典信息
     */
    public String update(Map<String, Object> param) {
        return ("update " + DBConstOfCode.TN_CODE_INFO + " set code_code=#{codeCode},code_name=#{codeName},code_type=#{codeType},code_order=#{codeOrder} where code_id=#{codeId}");
    }


    public static String getCodeInfoListByCode(final Map<String, Object> parameter) {
        StringBuilder sql = new StringBuilder(128);
        if (parameter != null && parameter.size() > 0) {
            sql.append("SELECT CODE_ID codeId,CODE_TYPE codeType,CODE_NAME codeName,CODE_CODE codeCode,CODE_ORDER codeOrder ");
            sql.append("  FROM " + DBConstOfCode.TN_CODE_INFO);
            sql.append(" WHERE 1=1 ");
            if (parameter.containsKey("groupCode") && StringUtil.isNotEmpty((String) parameter.get("groupCode"))) {
                sql.append(" AND `CODE_TYPE` = #{groupCode}  ");
            }
            if (parameter.containsKey("wordCode") && StringUtil.isNotEmpty((String) parameter.get("wordCode"))) {
                sql.append(" AND `CODE_CODE`= #{wordCode} ");
            }
            sql.append("   ORDER BY CODE_ORDER ");
        }
        return sql.toString();
    }
}
