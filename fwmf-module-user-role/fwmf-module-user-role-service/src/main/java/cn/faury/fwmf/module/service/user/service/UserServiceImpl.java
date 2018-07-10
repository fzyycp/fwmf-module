package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.DateUtil;
import cn.faury.fdk.common.utils.SigAESUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.role.service.RoleService;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.api.user.bean.UserPasswordBean;
import cn.faury.fwmf.module.api.user.service.UserService;
import cn.faury.fwmf.module.service.user.mapper.UserInfoMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台用户服务提供者
 */
public class UserServiceImpl implements UserService<UserInfoBean,UserPasswordBean> {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    /**
     * 角色服务
     */
    protected RoleService roleService;

    public UserServiceImpl(CommonDao commonDao, RoleService roleService) {
        this.commonDao = commonDao;
        this.roleService = roleService;
    }

    /**
     * 加密密码
     *
     * @param password 明文密码
     * @return 密文密码
     */
    @Override
    public String encryptPassWord(String password) {
        AssertUtil.assertNotEmpty(password, "密码不可以为空");
        return SigAESUtil.encryptPassWord(password);
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
     * 验证用户登录名是否存在
     *
     * @param loginName 用户登录名
     * @return 是否存在
     */
    @Override
    public Boolean isLoginNameExist(String loginName) {
        return this.getUserInfoByLoginName(loginName) != null;
    }

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
    @Override
    public Long insertUserInfo(UserInfoBean userInfoBean) {
        //参数有效性验证
        AssertUtil.assertNotNull(userInfoBean, "用户信息不可以为空");
        AssertUtil.assertNotEmpty(userInfoBean.getLoginName(), "用户姓名不可以为空");
        AssertUtil.assertNotEmpty(userInfoBean.getUserName(), "用户姓名不可以为空");
        AssertUtil.assertNotNull(userInfoBean.getEfctYmd(), "启用日期不可以为空");
        if (userInfoBean.getExprYmd() == null) {
            userInfoBean.setExprYmd(DateUtil.parse("2049-12-31"));
        }
        AssertUtil.assertFalse(this.isLoginNameExist(userInfoBean.getLoginName()), "用户登录名已存在");

        userInfoBean.setPassword(encryptPassWord(StringUtil.isEmpty(userInfoBean.getPassword()) ? "123456" : userInfoBean.getPassword()));//加密存储

        String statement = UserInfoMapper.class.getName() + ".insertUserInfo";
        int res = this.commonDao.insert(statement, userInfoBean);
        return res > 0 ? userInfoBean.getUserId() : -1L;
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
        roleService.insertUserRRole(userId, roleCode);
        return userId;
    }

    /**
     * 后台用户信息搜索（分页）
     *
     * @param param 查询参数
     * @return 查询结果
     */
    @Override
    public PageInfo<UserInfoBean> search(Map<String, Object> param) {
        PageParam pageParam = PageParam.buildDefaultIns(param);

        String state = UserInfoMapper.class.getName() + ".search";

        return this.commonDao.selectPage(state, param, pageParam);
    }

    /**
     * 根据后台用户ID获取后台用户信息
     *
     * @param userId 后台用户ID
     * @return 后台用户信息
     */
    @Override
    public UserInfoBean getUserInfoById(Long userId) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");

        String state = UserInfoMapper.class.getName() + ".getUserInfoById";
        return this.commonDao.selectOne(state, userId);
    }

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
    @Override
    public int updateUserInfoById(String userName, Date efctYmd, Date exprYmd, String updatePerson, Long userId) {
        //参数有效性验证
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
//        AssertUtil.assertNotEmpty(userName, "用户姓名不可以为空");
//        AssertUtil.assertNotNull(efctYmd, "生效日期不可以为空");
//        AssertUtil.assertNotNull(exprYmd, "失效日期不可以为空");
        AssertUtil.assertNotEmpty(updatePerson, "更新人不可以为空");

        String state = UserInfoMapper.class.getName() + ".updateUserInfoById";
        Map<String, Object> parameter = new HashMap<>();
        if (StringUtil.isNotEmpty(userName)){
            parameter.put("userName", userName);
        }
        if (efctYmd!=null){
            parameter.put("efctYmd", DateUtil.formatDate(efctYmd));
        }
        if(exprYmd!=null){
            parameter.put("exprYmd", DateUtil.formatDate(exprYmd));
        }
        parameter.put("userId", userId);
        parameter.put("updatePerson", updatePerson);
        return this.commonDao.update(state, parameter);
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
    public int updateUserInfoByIdWithRole(String userName, Date efctYmd, Date exprYmd, String updatePerson, Long userId, String roleCode) {
        AssertUtil.assertNotEmpty(roleCode, "角色编码不可以为空");

        // 更新用户信息
        int update1 = this.updateUserInfoById(userName, efctYmd, exprYmd, updatePerson, userId);
        // 删除已有角色信息
        roleService.deleteUserRRole(userId);
        // 插入新的角色信息
        roleService.insertUserRRole(userId, roleCode);
        return update1;
    }

    /**
     * 根据用户ID删除用户信息,逻辑删除
     *
     * @param userId       用户ID
     * @param updatePerson 更新人
     * @return 成功删除的条数
     */
    @Override
    public int deleteUserInfoById(Long userId, String updatePerson) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotEmpty(updatePerson, "更新人不可以为空");

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
    public int changeEnable(Long userId, String isEnable, String updatePerson) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotEmpty(updatePerson, "更新人不可以为空");

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
    public int resetPassword(Long userId, String password, String updatePerson) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotEmpty(password, "新密码不可以为空");
        AssertUtil.assertNotEmpty(updatePerson, "更新人不可以为空");

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
    public int updatePassword(String oldPassword, String newPassword, Long userId, String updatePerson) {
        AssertUtil.assertTrue((userId != null && userId > 0), "用户ID参数错误");
        AssertUtil.assertNotEmpty(oldPassword, "旧密码不可以为空");
        AssertUtil.assertNotEmpty(newPassword, "新密码不可以为空");
        AssertUtil.assertNotEmpty(updatePerson, "更新人不可以为空");

        String state = UserInfoMapper.class.getName() + ".updatePassword";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("userId", userId);
        parameter.put("oldPassword", encryptPassWord(oldPassword));
        parameter.put("newPassword", encryptPassWord(newPassword));
        parameter.put("updatePerson", updatePerson);
        return this.commonDao.update(state, parameter);
    }
}
