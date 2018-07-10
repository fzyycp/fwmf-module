/*
 * Copyright (c)
 */

package cn.faury.fwmf.module.service.user.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.api.user.bean.UserPasswordBean;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import cn.faury.fwmf.module.service.user.sqlProvider.UserInfoSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 用户信息表Mapper
 */
@AutoScannedMapper
public interface UserInfoMapper {

    /**
     * 根据用户ID获取用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    @Select("SELECT USER_ID userId,LOGIN_NAME loginName,USER_NAME userName,`PASSWORD` `password`,EFCT_YMD efctYmd," +
            "       EXPR_YMD exprYmd,INS_TSTMP insTstmp,ORIGIN_OS_ID originOsId,IS_ENABLE isEnable," +
            "       CREATE_PERSON createPerson,UPDATE_PERSON updatePerson,UPDATE_TIME updateTime " +
            "  FROM " + DBConstOfUserRole.TN_USER_INFO
            + " WHERE IS_DELETE='N' AND USER_ID = #{userId,jdbcType=BIGINT} ")
    @ResultType(UserInfoBean.class)
    UserInfoBean getUserInfoById(final Long userId);

    /**
     * 根据用户登录名获取用户信息
     *
     * @param loginName 用户登录名
     * @return 用户信息
     */
    @Select("SELECT USER_ID userId,LOGIN_NAME loginName,USER_NAME userName,`PASSWORD` `password`,EFCT_YMD efctYmd," +
            "       EXPR_YMD exprYmd,INS_TSTMP insTstmp,ORIGIN_OS_ID originOsId,IS_ENABLE isEnable," +
            "       CREATE_PERSON createPerson,UPDATE_PERSON updatePerson,UPDATE_TIME updateTime " +
            "  FROM " + DBConstOfUserRole.TN_USER_INFO
            + " WHERE IS_DELETE='N' AND LOGIN_NAME = #{loginName,jdbcType=VARCHAR} ")
    @ResultType(UserInfoBean.class)
    public UserInfoBean getUserInfoByLoginName(final String loginName);

    /**
     * 根据用户ID获取用户密码信息
     *
     * @param userId 用户登录名
     * @return 用户密码信息
     */
    @Select("SELECT USER_ID userId,`PASSWORD` `password` "
            + "  FROM " + DBConstOfUserRole.TN_USER_INFO
            + " WHERE IS_DELETE='N' AND USER_ID = #{userId,jdbcType=BIGINT} ")
    @ResultType(UserPasswordBean.class)
    UserPasswordBean getUserPasswordByUserId(final Long userId);

    /**
     * 查询后台用户信息
     *
     * @param map 查询参数
     * @return 成功条数
     */
    @SelectProvider(method = "search", type = UserInfoSQLProvider.class)
    @ResultType(value = UserInfoBean.class)
    List<UserInfoBean> search(Map<String, Object> map);

    /**
     * 插入后台用户信息
     *
     * @param bean 用户信息对象
     * @return 用户ID
     */
    @Insert("INSERT INTO " + DBConstOfUserRole.TN_USER_INFO
            + " (LOGIN_NAME,USER_NAME,PASSWORD,EFCT_YMD,EXPR_YMD,ORIGIN_OS_ID,CREATE_PERSON,UPDATE_PERSON)"
            + "  VALUES(#{loginName},#{userName},#{password},#{efctYmd},#{exprYmd},#{originOsId},#{createPerson},#{createPerson}) ")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    Long insertUserInfo(UserInfoBean bean);

    @UpdateProvider(type = UserInfoSQLProvider.class,method = "updateUserInfoById")
    int updateUserInfoById(Map<String, Object> map);

    @Update("UPDATE " + DBConstOfUserRole.TN_USER_INFO + " SET IS_DELETE='Y',UPDATE_PERSON=#{updatePerson},UPDATE_TIME=CURRENT_TIMESTAMP WHERE USER_ID=#{userId}")
    int deleteUserInfoById(Map<String, Object> map);

    @Update("UPDATE " + DBConstOfUserRole.TN_USER_INFO + " SET IS_ENABLE=#{isEnable},UPDATE_PERSON=#{updatePerson},UPDATE_TIME=CURRENT_TIMESTAMP WHERE USER_ID=#{userId}")
    int changeEnable(Map<String, Object> map);

    @Update("UPDATE " + DBConstOfUserRole.TN_USER_INFO + " SET `PASSWORD`=#{password},UPDATE_PERSON=#{updatePerson},UPDATE_TIME=CURRENT_TIMESTAMP WHERE USER_ID=#{userId}")
    int resetPassword(Map<String, Object> map);

    @Update("UPDATE " + DBConstOfUserRole.TN_USER_INFO + " SET `PASSWORD`=#{newPassword},UPDATE_PERSON=#{updatePerson},UPDATE_TIME=CURRENT_TIMESTAMP WHERE USER_ID=#{userId} AND `PASSWORD`=#{oldPassword}")
    int updatePassword(Map<String, Object> map);

}
