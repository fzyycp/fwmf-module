package cn.faury.fwmf.module.service.user.sqlProvider;

import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import cn.faury.fwmf.module.service.user.generate.sqlProvider.UserInfoGenerateSqlProvider;

/**
 * SQL Provider：后台用户管理
 *
 * <pre>
 *     UserInfoGenerateSqlProvider为数据库通用增删改查操作，不可修改
 *     当前SQL Provider继承自UserInfoGenerateSqlProvider，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class UserInfoSqlProvider extends UserInfoGenerateSqlProvider {
    private static Logger log = LoggerFactory.getLogger(UserInfoSqlProvider.class);

    /**
     * 获取后台用户信息列表
     *
     * @return SQL语句
     */
    public String search(Map<String, Object> param) {
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT DISTINCT t.USER_ID userId,LOGIN_NAME loginName,USER_NAME userName,`PASSWORD` `password`,EFCT_YMD efctYmd,");
        sql.append("       EXPR_YMD exprYmd,INS_TSTMP insTstmp,ORIGIN_OS_ID originOsId,IS_ENABLE isEnable," +
                "          CREATE_PERSON createPerson,UPDATE_PERSON updatePerson,UPDATE_TIME updateTime ");
        sql.append("  FROM " + DBConstOfUserRole.TN_USER_INFO + " t ");
        if (StringUtil.isNotEmpty((String) param.get("userRole"))) {
            sql.append("  LEFT JOIN " + DBConstOfUserRole.TN_USER_R_ROLE + " ur ON t.USER_ID=ur.USER_ID ");
            sql.append("  LEFT JOIN " + DBConstOfUserRole.TN_ROLE_INFO + " r");
            sql.append(" ON ur.ROLE_ID = r.ROLE_ID WHERE  r.ROLE_CODE=#{userRole} AND IS_DELETE='N' ");
        } else {
            sql.append(" WHERE IS_DELETE='N' ");
        }
        if (StringUtil.isNotEmpty((String) param.get("loginName"))) {
            sql.append(" AND LOGIN_NAME LIKE CONCAT('%',#{loginName},'%') ");
        }
        if (StringUtil.isNotEmpty((String) param.get("userName"))) {
            sql.append(" AND USER_NAME LIKE CONCAT('%',#{userName},'%') ");
        }


        sql.append(" ORDER BY loginName ");
        log.debug("SQL ==> " + sql.toString());
        return sql.toString();
    }

    public String updateUserInfoById(Map<String, Object> param) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE "+ DBConstOfUserRole.TN_USER_INFO);
        sql.append("   SET ");
        if (param!=null){
            if (param.containsKey("userName")){
                sql.append("USER_NAME=#{userName},");
            }
            if (param.containsKey("efctYmd")){
                sql.append("EFCT_YMD=#{efctYmd},");
            }
            if (param.containsKey("exprYmd")){
                sql.append("EXPR_YMD=#{exprYmd},");
            }
            if (param.containsKey("updatePerson")){
                sql.append("UPDATE_PERSON=#{updatePerson},");
            }
        }
        sql.append("       UPDATE_TIME=CURRENT_TIMESTAMP ");
        sql.append(" WHERE USER_ID=#{userId} ");
        return sql.toString();
    }
}
