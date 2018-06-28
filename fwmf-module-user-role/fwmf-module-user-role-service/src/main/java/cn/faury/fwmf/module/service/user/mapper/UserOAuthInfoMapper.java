package cn.faury.fwmf.module.service.user.mapper;


import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.UserOAuthInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfUserRole;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@AutoScannedMapper
public interface UserOAuthInfoMapper {

    /**
     * 根据用户ID获取用户所有的第三方授权信息
     *
     * @param userId 用户ID
     * @return 用户第三方授权信息信息
     */
    @Select("  SELECT OAUTH_ID oauthId,USER_ID userId,ACCESS_TOKEN accessToken,REFRESH_TOKEN refreshToken"
            + "       ,OPENID openid,UNIONID unionid,ORIGIN_USER_ID originUserId,OAUTH_FROM oauthFrom "
            + "  FROM " + DBConstOfUserRole.TN_USER_OAUTH + " " + " WHERE USER_ID = #{userId} ")
    @ResultType(UserOAuthInfoBean.class)
    UserOAuthInfoBean getUserOAuthInfos(final Long userId);

    /**
     * 根据用户统一标识获取用户信息
     *
     * @param unionId 用户统一标识
     * @return 用户第三方授权信息
     */
    @Select("  SELECT OAUTH_ID oauthId,USER_ID userId,ACCESS_TOKEN accessToken,REFRESH_TOKEN refreshToken"
            + "       ,OPENID openid,UNIONID unionid,ORIGIN_USER_ID originUserId,OAUTH_FROM oauthFrom "
            + "  FROM " + DBConstOfUserRole.TN_USER_OAUTH + " " + " WHERE UNIONID = #{unionId,jdbcType=VARCHAR} ")
    @ResultType(UserOAuthInfoBean.class)
    UserOAuthInfoBean getUserOAuthInfo(final String unionId);

    /**
     * 插入用户第三方授权信息
     *
     * @param bean 第三方授权信息
     * @return 成功插入唯一ID
     */
    @Insert("   INSERT INTO " + DBConstOfUserRole.TN_USER_OAUTH
            + "        (`USER_ID`, `ACCESS_TOKEN`,`REFRESH_TOKEN`,`OPENID`, `UNIONID`,`ORIGIN_USER_ID`,`OAUTH_FROM`) "
            + " VALUES (#{userId}, #{accessToken},#{refreshToken},#{openid}, #{unionid}, #{originUserId}, #{oauthFrom})")
    @Options(keyProperty = "oauthId", useGeneratedKeys = true)
    Long insertUserOAuthInfo(final UserOAuthInfoBean bean);

    /**
     * 更新用户第三方授权信息
     * <pre>
     *     使用Bean参数：
     *     String accessToken：接口调用凭证
     *     String refreshToken：用户刷新access_token
     *     String openid：授权用户唯一标识
     *     String unionid：用户统一标识
     * </pre>
     *
     * @param parameter 要更新的第三方授权信息
     * @return 成功更新条数
     */
    @Update("   UPDATE " + DBConstOfUserRole.TN_USER_OAUTH
            + "    SET `ACCESS_TOKEN` = #{accessToken} "
            + "        ,`REFRESH_TOKEN` = #{refreshToken} "
            + "        ,`OPENID` = #{openid} "
            + "  WHERE `UNIONID` = #{unionid} ")
    Long updateUserOAuthInfoByUnionId(final Map<String, Object> parameter);

    /**
     * 更新用户第三方账号绑定用户ID
     * <pre>
     *     Long userId：用户ID
     *     String unionid：用户统一标识
     * </pre>
     *
     * @param parameter 要更新的第三方授权信息
     * @return 成功更新条数
     */
    @Update("   UPDATE " + DBConstOfUserRole.TN_USER_OAUTH
            + "    SET `USER_ID` = #{userId} "
            + "  WHERE `UNIONID` = #{unionid} ")
    Long bindUserAccountByUnionId(final Map<String, Object> parameter);

    /**
     * 解绑用户第三方账号绑定用户ID
     * <pre>
     *     Long userId：用户ID
     *     String unionid：用户统一标识
     * </pre>
     *
     * @param parameter 要更新的第三方授权信息
     * @return 成功更新条数
     */
    @Update("   UPDATE " + DBConstOfUserRole.TN_USER_OAUTH
            + "    SET `USER_ID` = `ORIGIN_USER_ID` "
            + "  WHERE `UNIONID` = #{unionid} AND USER_ID=#{userId} ")
    Long unbindUserAccountByUnionId(final Map<String, Object> parameter);
}
