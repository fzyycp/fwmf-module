package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.role.service.RoleInfoService;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.api.user.bean.UserPasswordBean;
import cn.faury.fwmf.module.api.user.config.UserType;
import cn.faury.fwmf.module.api.user.service.UserInfoService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.user.mapper.UserInfoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 服务实现：后台用户管理
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了UserInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class UserInfoServiceImpl extends CrudBaseServiceImpl<UserInfoBean, Long> implements UserInfoService<UserInfoBean,UserPasswordBean> {

    /**
     * 角色服务
     */
    protected RoleInfoService roleInfoService;

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public UserInfoServiceImpl(CommonDao commonDao, RoleInfoService roleInfoService) {
        super(commonDao, UserInfoMapper.class);
        this.roleInfoService = roleInfoService;
    }

    /**
     * 根据用户登录名获取用户信息
     *
     * @param loginName 用户登录名
     * @return 用户信息
     */
    @Override
    public UserInfoBean getUserInfoByLoginName(String loginName) {
        AssertUtil.assertNotEmpty(loginName, "用户登录名不可以为空");

        String state = UserInfoMapper.class.getName() + ".getUserInfoByLoginName";
        return this.commonDao.selectOne(state, loginName);
    }

    /**
     * 根据用户ID获取用户密码信息
     *
     * @param userId 用户ID
     * @return 用户密码信息
     */
    @Override
    public UserPasswordBean getUserPasswordByUserId(Long userId) {
        AssertUtil.assertTrue((userId != null && userId > 0L), "用户ID错误");

        String state = UserInfoMapper.class.getName() + ".getUserPasswordByUserId";
        return this.commonDao.selectOne(state, userId);
    }

    /**
     * 插入用户信息
     *
     * @param loginName        用户登录名
     * @param userName         用户姓名
     * @param password         用户登录密码
     * @param systemId         所属系统ID
     * @param userType         用户类型
     * @param createPerson
     * @param createPersonName
     * @param updatePerson
     * @param updatePersonName @return 用户ID
     */
    @Override
    public Long insertUserInfo(String loginName, String userName, String password, Long systemId, UserType userType, Long createPerson, String createPersonName, Long updatePerson, String updatePersonName) {
        UserInfoBean userInfo = new UserInfoBean();
        userInfo.setLoginName(loginName);
        userInfo.setUserName(userName);
        userInfo.setEfctYmd(new Date());
        userInfo.setPassword(password);
        userInfo.setOriginOsId(systemId);
        userInfo.setUserType(userType.getValue());
        userInfo.setCreatePerson(createPerson);
        userInfo.setCreatePersonName(createPersonName);
        userInfo.setUpdatePerson(updatePerson != null ? updatePerson : createPerson);
        userInfo.setUpdatePersonName(StringUtil.emptyDefault(updatePersonName, createPersonName));
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
    @Override
    public Long insertUserInfoWithRole(UserInfoBean userInfoBean, String roleCode) {
        // 插入用户信息
        Long userId = this.insertUserInfo(userInfoBean);
        AssertUtil.assertTrue((userId != null && userId > 0), "插入用户信息失败");

        // 插入用户角色信息
        roleInfoService.insertUserRRole(userId, roleCode);
        return userId;
    }

    /**
     * 根据用户Id修改用户信息，为null则不更新
     *
     * @param userName         用户姓名
     * @param efctYmd          启用日期
     * @param exprYmd          失效日期
     * @param updatePerson     更新人
     * @param updatePersonName
     * @param userId           用户Id  @return 更新成功条数
     */
    @Override
    public int updateUserInfoById(String userName, Date efctYmd, Date exprYmd, Long updatePerson, String updatePersonName, Long userId) {
        //参数有效性验证
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotNull(updatePerson, "更新人不可以为空");
        AssertUtil.assertNotEmpty(updatePersonName, "更新人不可以为空");

        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.setUserId(userId);
        userInfoBean.setUpdatePerson(updatePerson);
        userInfoBean.setUpdatePersonName(updatePersonName);

        if (StringUtil.isNotEmpty(userName)) {
            userInfoBean.setUserName(userName);
        }
        if (efctYmd != null) {
            userInfoBean.setEfctYmd(efctYmd);
        }
        if (exprYmd != null) {
            userInfoBean.setExprYmd(exprYmd);
        }
        return this.update(userInfoBean);
    }

    /**
     * 根据用户Id修改用户信息和角色信息，为null则不更新
     *
     * @param userName     用户姓名
     * @param efctYmd      启用日期
     * @param exprYmd      失效日期
     * @param updatePerson 更新人
     * @param userId       用户Id
     * @param roleCode     角色编码
     * @return 更新成功条数
     */
    @Override
    @Transactional
    public int updateUserInfoByIdWithRole(String userName, Date efctYmd, Date exprYmd, Long updatePerson,String updatePersonName, Long userId, String roleCode) {
        AssertUtil.assertNotEmpty(roleCode, "角色编码不可以为空");

        // 更新用户信息
        int update1 = this.updateUserInfoById(userName, efctYmd, exprYmd, updatePerson,updatePersonName, userId);
        // 删除已有角色信息
        roleInfoService.deleteUserRRole(userId);
        // 插入新的角色信息
        roleInfoService.insertUserRRole(userId, roleCode);
        return update1;
    }

    /**
     * 根据用户ID删除用户信息,逻辑删除
     *
     * @param userId       用户ID
     * @param updatePerson 更新人
     * @param updatePersonName 更新人名称
     * @return 成功删除的条数
     */
    @Override
    public int deleteUserInfoById(Long userId, Long updatePerson,String updatePersonName) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotNull(updatePerson, "更新人不可以为空");
        AssertUtil.assertNotEmpty(updatePersonName, "更新人不可以为空");

        String state = UserInfoMapper.class.getName() + ".deleteUserInfoById";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("userId", userId);
        parameter.put("updatePerson", updatePerson);
        return this.commonDao.update(state, parameter);
    }

    /**
     * 根据用户ID，修改用户状态
     *
     * @param userId       用户ID
     * @param isEnable     启用或禁用(只能为0或者1，非法的参数都默认为0)
     * @param updatePerson 更新人
     * @return 成功修改的条数
     */
    @Override
    public int changeEnable(Long userId, String isEnable, Long updatePerson,String updatePersonName) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotNull(updatePerson, "更新人不可以为空");
        AssertUtil.assertNotEmpty(updatePersonName, "更新人不可以为空");

        if (!"N".equals(isEnable) && !"Y".equals(isEnable)) {
            isEnable = "N";
        }
        String state = UserInfoMapper.class.getName() + ".changeEnable";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("userId", userId);
        parameter.put("isEnable", isEnable);
        parameter.put("updatePerson", updatePerson);
        return this.commonDao.update(state, parameter);
    }

    /**
     * 重置用户密码
     *
     * @param userId       用户ID
     * @param password     新的密码，明文，插入数据库时后台加密
     * @param updatePerson 更新人
     * @return 成功修改条数
     */
    @Override
    public int resetPassword(Long userId, String password, Long updatePerson,String updatePersonName) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotEmpty(password, "新密码不可以为空");
        AssertUtil.assertNotNull(updatePerson, "更新人不可以为空");
        AssertUtil.assertNotEmpty(updatePersonName, "更新人不可以为空");

        String state = UserInfoMapper.class.getName() + ".resetPassword";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("userId", userId);
        parameter.put("password", encryptPassWord(password));
        parameter.put("updatePerson", updatePerson);
        return this.commonDao.update(state, parameter);
    }

    /**
     * 更新用户密码
     *
     * @param oldPassword  旧密码，明文
     * @param newPassword  新密码，明文，插入数据库时后台加密
     * @param userId       用户ID
     * @param updatePerson 更新人
     * @return 成功更新条数
     */
    @Override
    public int updatePassword(String oldPassword, String newPassword, Long userId, Long updatePerson,String updatePersonName) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotEmpty(oldPassword, "旧密码不可以为空");
        AssertUtil.assertNotEmpty(newPassword, "新密码不可以为空");
        AssertUtil.assertNotNull(updatePerson, "更新人不可以为空");
        AssertUtil.assertNotEmpty(updatePersonName, "更新人不可以为空");

        String state = this.mapper.getName() + ".updatePassword";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("userId", userId);
        parameter.put("oldPassword", encryptPassWord(oldPassword));
        parameter.put("newPassword", encryptPassWord(newPassword));
        parameter.put("updatePerson", updatePerson);
        return this.commonDao.update(state, parameter);
    }

}