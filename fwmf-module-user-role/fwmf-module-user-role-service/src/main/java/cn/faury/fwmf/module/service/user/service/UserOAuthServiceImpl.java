package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.user.bean.UserOAuthInfoBean;
import cn.faury.fwmf.module.api.user.service.UserOAuthService;
import cn.faury.fwmf.module.service.user.mapper.UserOAuthInfoMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户OAuth服务提供者
 */
public class UserOAuthServiceImpl implements UserOAuthService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public UserOAuthServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    /**
     * 根据用户ID获取用户所有的第三方登录信息
     *
     * @param userId 用户ID
     * @return 用户第三方信息
     */
    @Override
    public List<UserOAuthInfoBean> getUserOAuthInfosByUserId(Long userId) {
        AssertUtil.assertTrue(userId!=null&&userId>0,"用户ID错误");

        String state = UserOAuthInfoMapper.class.getName() + ".getUserOAuthInfos";
        return this.commonDao.selectList(state, userId);
    }

    /**
     * 根据第三方颁发的用户统一标识获取用户信息
     *
     * @param unionId 用户统一标识
     * @return 用户授权信息
     */
    @Override
    public UserOAuthInfoBean getUserOAuthInfoByUnionId(String unionId) {
        AssertUtil.assertNotEmpty(unionId,"用户统一标识不可为空");
        String state = UserOAuthInfoMapper.class.getName() + ".getUserOAuthInfo";
        return this.commonDao.selectOne(state, unionId);
    }

    /**
     * 插入用户第三方授权信息
     * <pre>
     *     使用Bean参数：
     *     Long userId：用户ID
     *     String accessToken：接口调用凭证
     *     String refreshToken：用户刷新access_token
     *     String openid：授权用户唯一标识
     *     String unionid：用户统一标识
     *     String originUserId：第一次登录时创建的原始用户ID
     *     String oauthFrom：第三方类型
     * </pre>
     *
     * @param bean 用户第三方授权信息
     * @return 成功插入的唯一ID
     */
    @Override
    public Long insertUserOAuthInfo(UserOAuthInfoBean bean) {
        // 输入参数校验
        AssertUtil.assertNotNull(bean,"用户授权信息不可为空");
        AssertUtil.assertTrue(bean.getUserId()!=null&&bean.getUserId()>0,"用户授权信息对应用户ID不可为空");
        AssertUtil.assertNotEmpty(bean.getUnionid(),"用户授权信息统一标识不可为空");
        AssertUtil.assertNotEmpty(bean.getOauthFrom(),"用户授权信息来源类型不可为空");

        bean.setOriginUserId(bean.getUserId());

        // 插入数据
        String state = UserOAuthInfoMapper.class.getName() + ".insertUserOAuthInfo";
        Long res = (long) this.commonDao.insert(state, bean);
        return res > 0 ? bean.getUserId() : -1L;
    }

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
    @Override
    public int updateUserOAuthInfoByUnionId(UserOAuthInfoBean bean) {
        // 输入参数校验
        AssertUtil.assertNotNull(bean,"用户授权信息不可为空");

        final Map<String, Object> parameter = new HashMap<>();
        parameter.put("accessToken",bean.getAccessToken());
        parameter.put("refreshToken",bean.getRefreshToken());
        parameter.put("openid",bean.getOpenid());
        parameter.put("unionid",bean.getUnionid());

        String state = UserOAuthInfoMapper.class.getName() + ".updateUserOAuthInfoByUnionId";
        return this.commonDao.update(state, parameter);
    }

    /**
     * 绑定第三方登录账号对应的用户ID
     *
     * @param userId  新的用户ID
     * @param unionId 第三方登录统一标识
     * @return 成功修改条数
     */
    @Override
    public int bindUserAccountByUnionId(Long userId, String unionId) {
        // 输入参数校验
        AssertUtil.assertNotEmpty(unionId,"用户ID或第三方登录统一标识不可以为空");

        final Map<String, Object> parameter = new HashMap<>();
        parameter.put("userId",userId);
        parameter.put("unionid",unionId);

        String state = UserOAuthInfoMapper.class.getName() + ".bindUserAccountByUnionId";
        return this.commonDao.update(state, parameter);
    }

    /**
     * 解绑第三方登录账号对应的用户ID
     *
     * @param userId  新的用户ID
     * @param unionId 第三方登录统一标识
     * @return 成功修改条数
     */
    @Override
    public int unbindUserAccountByUnionId(Long userId, String unionId) {
        // 输入参数校验
        AssertUtil.assertNotEmpty(unionId,"用户ID或第三方登录统一标识不可以为空");

        final Map<String, Object> parameter = new HashMap<>();
        parameter.put("userId",userId);
        parameter.put("unionid",unionId);

        String state = UserOAuthInfoMapper.class.getName() + ".unbindUserAccountByUnionId";
        return this.commonDao.update(state, parameter);
    }
}
