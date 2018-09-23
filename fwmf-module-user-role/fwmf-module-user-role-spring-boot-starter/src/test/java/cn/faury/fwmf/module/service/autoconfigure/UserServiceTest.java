package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.DateUtil;
import cn.faury.fwmf.module.api.user.bean.UserInfoBean;
import cn.faury.fwmf.module.api.user.bean.UserPasswordBean;
import cn.faury.fwmf.module.api.user.service.UserInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserInfoService userInfoService;

    @Test
    public void getUserInfoByLoginName() throws Exception {
        UserInfoBean userInfoBean = userInfoService.getUserInfoByLoginName("system");
        System.out.println(userInfoBean);
        Assert.assertNotNull(userInfoBean);
        Assert.assertTrue("系统管理员".equals(userInfoBean.getUserName()));
    }

    @Test
    public void getUserPasswordByUserId() throws Exception {
        UserPasswordBean userPasswordBean = userInfoService.getUserPasswordByUserId(1L);
        Assert.assertNotNull(userPasswordBean);
        Assert.assertTrue("neyD8eWJSbO0e6vw47HfWg==".equals(userPasswordBean.getPassword()));
    }

    @Test
    public void isLoginNameExist() throws Exception {
        boolean exist = userInfoService.isLoginNameExist("faury-not-exist");
        Assert.assertFalse(exist);
        exist = userInfoService.isLoginNameExist("system");
        Assert.assertTrue(exist);
    }

    @Test
    public void insertUserInfo() throws Exception {
        UserInfoBean userInfo = new UserInfoBean();
        userInfo.setLoginName("faury" + System.currentTimeMillis());
        userInfo.setUserName("fauryName");
        userInfo.setPassword("faury-password");
        userInfo.setCreatePersonName("junit-tester");
        userInfo.setEfctYmd(DateUtil.parse("2018-06-07"));
        userInfo.setExprYmd(DateUtil.parse("20491231"));
        Long id = userInfoService.insertUserInfo(userInfo);
        System.out.println(id);
        Assert.assertNotNull(id);
        Assert.assertTrue(id > 0);
        System.out.println(userInfoService.getUserInfoByLoginName("faury"));
        // 清理数据
        userInfoService.deleteUserInfoById(id, "junit-clear");
    }

    @Test
    public void insertUserInfoWithRole() throws Exception {
        UserInfoBean userInfo = new UserInfoBean();
        userInfo.setLoginName("faury" + System.currentTimeMillis());
        userInfo.setUserName("fauryName");
        userInfo.setPassword("faury-password");
        userInfo.setCreatePersonName("junit-tester");
        userInfo.setEfctYmd(DateUtil.parse("2018-06-07"));
        userInfo.setExprYmd(DateUtil.parse("20491231"));

        userInfoService.insertUserInfoWithRole(userInfo, "SYSTEM");
    }

    @Test
    public void search() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put(PageParam.KEY.KEY_PAGE_SIZE, "2");
        param.put("loginName", "super");
        PageInfo<UserInfoBean> page = userInfoService.search(param);
        System.out.println(page);
    }

    @Test
    public void getUserInfoById() throws Exception {
        UserInfoBean userInfoBean = userInfoService.getUserInfoById(1L);
        Assert.assertNotNull(userInfoBean);
        Assert.assertTrue("super".equals(userInfoBean.getLoginName()));
    }

    @Test
    public void updateUserInfoById() throws Exception {
        int updated = userInfoService.updateUserInfoById("faury-test", DateUtil.parse("2018-01-01 12:34:56"), DateUtil.parse("2018-01-01 12:34:57"), "junit-test", 10L);
        Assert.assertTrue(updated == 1);
    }

    @Test
    public void updateUserInfoByIdWithRole() throws Exception {
        int updated = userInfoService.updateUserInfoByIdWithRole("faury-test", DateUtil.parse("2018-01-02 12:34:56"), DateUtil.parse("2018-01-02 12:34:57"), "junit-test", 10L, "SYSTEM");
        Assert.assertTrue(updated == 1);
    }

    @Test
    public void deleteUserInfoById() throws Exception {
        int deleted = userInfoService.deleteUserInfoById(10L, "junit-deleter");
        Assert.assertTrue(deleted == 1);
    }

    @Test
    public void changeEnable() throws Exception {
        int changed = userInfoService.changeEnable(11L, "N", "junit-updater");
        Assert.assertTrue(changed == 1);
    }

    @Test
    public void resetPassword() throws Exception {
        int reset = userInfoService.resetPassword(11L, "111111", "junit-updater");
        Assert.assertTrue(reset == 1);
    }

    @Test
    public void updatePassword() throws Exception {
        int updated = userInfoService.updatePassword("faury-password", "111111", 12L, "junit-updater");
        Assert.assertTrue(updated == 1);
        // 还原
        userInfoService.updatePassword("111111", "faury-password", 12L, "junit-updater");
    }

}