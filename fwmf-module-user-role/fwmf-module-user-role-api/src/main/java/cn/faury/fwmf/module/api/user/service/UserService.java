package cn.faury.fwmf.module.api.user.service;

import cn.faury.fdk.common.anotation.NonNull;
import cn.faury.fdk.common.anotation.Nullable;
import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.api.user.bean.UserPasswordBean;
import cn.faury.fwmf.module.api.user.config.UserType;

import java.util.Date;
import java.util.Map;

/**
 * 后台用户管理服务协议
 */
public interface UserService<T extends UserInfoBean, P extends UserPasswordBean> {

    /**
     * 加密密码
     *
     * @param password 明文密码
     * @return 密文密码
     */
    String encryptPassWord(@NonNull final String password);

    /**
     * 根据用户登录名获取用户信息
     *
     * @param loginName 用户登录名
     * @return 用户信息
     */
    @Read
    T getUserInfoByLoginName(@NonNull final String loginName);

    /**
     * 根据用户ID获取用户密码信息
     *
     * @param userId 用户ID
     * @return 用户密码信息
     */
    @Read
    P getUserPasswordByUserId(@NonNull final Long userId);

    /**
     * 验证用户登录名是否存在
     *
     * @param loginName 用户登录名
     * @return 是否存在
     */
    @Read
    Boolean isLoginNameExist(@NonNull final String loginName);

    /**
     * 插入后台用户信息
     *
     * @param userInfoBean 用户信息对象
     *                     <p>
     *                     支持以下变量：
     *                     loginName 用户登录名
     *                     userName  用户姓名
     *                     password  用户登录密码(明文，插入数据库时后台加密）
     *                     efctYmd   启用日期
     *                     exprYmd   失效日期
     *                     systemId  所属系统ID
     *                     createPerson 创建人
     *                     </p>
     * @return 用户ID
     */
    @Write
    <U extends UserInfoBean> Long insertUserInfo(@NonNull final U userInfoBean);

    /**
     * 插入用户信息
     *
     * @param loginName 用户登录名
     * @param userName  用户姓名
     * @param password  用户登录密码
     * @param systemId  所属系统ID
     * @param userType  用户类型
     * @return 用户ID
     */
    @Write
    default public Long insertUserInfo(final String loginName, final String userName, final String password,
                                       final Long systemId, final UserType userType, final String createPerson, final String updatePerson) {
        UserInfoBean userInfo = new UserInfoBean();
        userInfo.setLoginName(loginName);
        userInfo.setUserName(userName);
        userInfo.setEfctYmd(new Date());
        userInfo.setPassword(password);
        userInfo.setOriginOsId(systemId);
        userInfo.setUserType(userType.getValue());
        userInfo.setCreatePerson(createPerson);
        userInfo.setUpdatePerson(StringUtil.emptyDefault(createPerson, updatePerson));
        return insertUserInfo(userInfo);
    }

    /**
     * 插入后台用户信息，并插入角色信息
     *
     * @param userInfoBean 用户信息对象
     *                     <p>
     *                     支持以下变量：
     *                     loginName 用户登录名
     *                     userName  用户姓名
     *                     password  用户登录密码(明文，插入数据库时后台加密）
     *                     efctYmd   启用日期
     *                     exprYmd   失效日期
     *                     systemId  所属系统ID
     *                     createPerson 创建人
     *                     </p>
     * @param roleCode     角色编码
     * @return 用户ID
     */
    @Write
    Long insertUserInfoWithRole(@NonNull final T userInfoBean, @NonNull final String roleCode);

    /**
     * 后台用户信息搜索（分页）
     *
     * @param param 查询参数
     * @return 查询结果
     */
    @Read
    PageInfo<T> search(Map<String, Object> param);

    /**
     * 根据后台用户ID获取后台用户信息
     *
     * @param userId 后台用户ID
     * @return 后台用户信息
     */
    @Read
    T getUserInfoById(@NonNull Long userId);

    /**
     * 根据用户Id修改用户信息，为null则不更新
     *
     * @param userName     用户姓名
     * @param efctYmd      启用日期
     * @param exprYmd      失效日期
     * @param updatePerson 更新人
     * @param userId       用户Id
     * @return 更新成功条数
     */
    @Write
    int updateUserInfoById(@NonNull final String userName, @Nullable final Date efctYmd, @Nullable final Date exprYmd, @NonNull final String updatePerson, @NonNull final Long userId);

    /**
     * 根据用户Id修改用户信息和角色信息，为null则不更新
     *
     * @param userName     用户姓名
     * @param efctYmd      启用日期
     * @param exprYmd      失效日期
     * @param userId       用户Id
     * @param updatePerson 更新人
     * @param roleCode     角色编码
     * @return 更新成功条数
     */
    @Write
    int updateUserInfoByIdWithRole(@NonNull final String userName, @Nullable final Date efctYmd, @Nullable final Date exprYmd, @NonNull final String updatePerson, @NonNull final Long userId, @NonNull final String roleCode);

    /**
     * 根据用户ID删除用户信息,逻辑删除
     *
     * @param userId       用户ID
     * @param updatePerson 更新人
     * @return 成功删除的条数
     */
    @Write
    int deleteUserInfoById(@NonNull final Long userId, @NonNull final String updatePerson);

    /**
     * 根据用户ID，修改用户状态
     *
     * @param userId       用户ID
     * @param isEnable     启用或禁用(只能为0或者1，非法的参数都默认为0)
     * @param updatePerson 更新人
     * @return 成功修改的条数
     */
    @Write
    int changeEnable(@NonNull final Long userId, @NonNull final String isEnable, @NonNull final String updatePerson);

    /**
     * 重置用户密码
     *
     * @param userId       用户ID
     * @param password     新的密码，明文，插入数据库时后台加密
     * @param updatePerson 更新人
     * @return 成功修改条数
     */
    @Write
    int resetPassword(@NonNull final Long userId, @NonNull final String password, @NonNull final String updatePerson);

    /**
     * 更新用户密码
     *
     * @param oldPassword  旧密码，明文
     * @param newPassword  新密码，明文，插入数据库时后台加密
     * @param userId       用户ID
     * @param updatePerson 更新人
     * @return 成功更新条数
     */
    @Write
    int updatePassword(@NonNull final String oldPassword, @NonNull final String newPassword, @NonNull final Long userId, @NonNull final String updatePerson);
}
