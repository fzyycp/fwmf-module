/*
 * Copyright (c)
 */

package cn.faury.fwmf.module.service.user.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.api.user.bean.UserPasswordBean;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import cn.faury.fwmf.module.service.user.generate.mapper.UserInfoGenerateMapper;
import cn.faury.fwmf.module.service.user.sqlProvider.UserInfoSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Mybatis Mapper：后台用户管理
 *
 * <pre>
 *     UserInfoGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自UserInfoGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface UserInfoMapper extends UserInfoGenerateMapper {

    /**
     * 根据用户登录名获取用户信息
     *
     * @param loginName 用户登录名
     * @return 用户信息
     */
    @Select("SELECT USER_ID userId,LOGIN_NAME loginName,USER_NAME userName,`PASSWORD` `password`,EFCT_YMD efctYmd," +
            "       EXPR_YMD exprYmd,INS_TSTMP insTstmp,ORIGIN_OS_ID originOsId,USER_TYPE userType,IS_ENABLE isEnable," +
            "       IS_DELETE isDelete,CREATE_PERSON createPerson,UPDATE_PERSON updatePerson,UPDATE_TIME updateTime " +
            "  FROM " + DBConstOfUserRole.TN_USER_INFO
            + " WHERE LOGIN_NAME = #{loginName,jdbcType=VARCHAR} ")
    @ResultType(UserInfoBean.class)
    UserInfoBean getUserInfoByLoginName(final String loginName);

    /**
     * 根据用户ID获取用户密码信息
     *
     * @param userId 用户登录名
     * @return 用户密码信息
     */
    @Select("SELECT USER_ID userId,`PASSWORD` `password` "
            + "  FROM " + DBConstOfUserRole.TN_USER_INFO
            + " WHERE USER_ID = #{userId,jdbcType=BIGINT} ")
    @ResultType(UserPasswordBean.class)
    UserPasswordBean getUserPasswordByUserId(final Long userId);

    @Update("UPDATE " + DBConstOfUserRole.TN_USER_INFO + " SET IS_DELETE='Y',UPDATE_PERSON=#{updatePerson},UPDATE_TIME=CURRENT_TIMESTAMP WHERE USER_ID=#{userId}")
    int deleteUserInfoById(Map<String, Object> map);

    @Update("UPDATE " + DBConstOfUserRole.TN_USER_INFO + " SET IS_ENABLE=#{isEnable},UPDATE_PERSON=#{updatePerson},UPDATE_TIME=CURRENT_TIMESTAMP WHERE USER_ID=#{userId}")
    int changeEnable(Map<String, Object> map);

    @Update("UPDATE " + DBConstOfUserRole.TN_USER_INFO + " SET `PASSWORD`=#{password},UPDATE_PERSON=#{updatePerson},UPDATE_TIME=CURRENT_TIMESTAMP WHERE USER_ID=#{userId}")
    int resetPassword(Map<String, Object> map);

    @Update("UPDATE " + DBConstOfUserRole.TN_USER_INFO + " SET `PASSWORD`=#{newPassword},UPDATE_PERSON=#{updatePerson},UPDATE_TIME=CURRENT_TIMESTAMP WHERE USER_ID=#{userId} AND `PASSWORD`=#{oldPassword}")
    int updatePassword(Map<String, Object> map);

}
