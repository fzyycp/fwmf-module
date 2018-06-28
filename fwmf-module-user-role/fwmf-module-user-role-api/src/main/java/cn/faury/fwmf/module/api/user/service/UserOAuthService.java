package cn.faury.fwmf.module.api.user.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fwmf.module.api.user.bean.UserOAuthInfoBean;

import java.util.List;

/**
 * 用户OAuth信息服务协议
 */
public interface UserOAuthService {

    /**
     * 根据用户ID获取用户所有的第三方登录信息
     *
     * @param userId 用户ID
     * @return 用户第三方信息
     */
    @Read
    List<UserOAuthInfoBean> getUserOAuthInfosByUserId(Long userId);

    /**
     * 根据第三方颁发的用户统一标识获取用户信息
     *
     * @param unionId 用户统一标识
     * @return 用户授权信息
     */
    @Read
    UserOAuthInfoBean getUserOAuthInfoByUnionId(String unionId);

    /**
     * 插入用户第三方授权信息
     * <pre>
     *     使用Bean参数：
     *     Long userId：用户ID
     *     String accessToken：接口调用凭证
     *     String refreshToken：用户刷新access_token
     *     String openid：授权用户唯一标识
     *     String unionid：用户统一标识
     *     String oauthFrom：第三方类型(00:微信 01:QQ 02:新浪微博)
     * </pre>
     *
     * @param bean 用户第三方授权信息
     * @return 成功插入的唯一ID
     */
    @Write
    Long insertUserOAuthInfo(UserOAuthInfoBean bean);

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
     * @param bean 用户第三方授权信息
     * @return 成功更新条数
     */
    @Write
    int updateUserOAuthInfoByUnionId(UserOAuthInfoBean bean);

    /**
     * 绑定第三方登录账号对应的用户ID
     *
     * @param userId  新的用户ID
     * @param unionId 第三方登录统一标识
     * @return 成功修改条数
     */
    @Write
    int bindUserAccountByUnionId(Long userId, String unionId);

    /**
     * 解绑第三方登录账号对应的用户ID
     *
     * @param userId  新的用户ID
     * @param unionId 第三方登录统一标识
     * @return 成功修改条数
     */
    @Write
    int unbindUserAccountByUnionId(Long userId, String unionId);
}
