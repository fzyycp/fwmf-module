package cn.faury.fwmf.module.service.autoconfigure;

import cn.faury.fwmf.module.api.role.bean.RoleInfoBean;
import cn.faury.fwmf.module.api.role.service.RoleInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {

    @Autowired
    RoleInfoService roleInfoService;

    @Test
    public void getUserRolesByUserId() throws Exception {
        List<RoleInfoBean> roleInfoBeans = roleInfoService.getUserRolesByUserId("fwmf-web", 2L);
        System.out.println(roleInfoBeans);
        Assert.assertNotNull(roleInfoBeans);
        Assert.assertTrue(roleInfoBeans.size() == 1);
        Assert.assertTrue(2 == roleInfoBeans.get(0).getRoleId());
    }

    @Test
    public void getUserRolePermsByUserId() throws Exception {
        List<String> perms = roleInfoService.getUserRolePermsByUserId("fwmf-web", 2L);
        System.out.println(perms);
        Assert.assertNotNull(perms);
        Assert.assertTrue(perms.size() == 0);
    }

    @Test
    public void getRoleInfoByCode() throws Exception {
        RoleInfoBean roleInfoBean = roleInfoService.getRoleInfoByCode("SYSTEM");
        System.out.println(roleInfoBean);
        Assert.assertNotNull(roleInfoBean);
        Assert.assertTrue(roleInfoBean.getRoleId() == 2L);
    }

    @Test
    public void insertUserRRole() throws Exception {
        int add = roleInfoService.insertUserRRole(100L, "SYSTEM");
        Assert.assertTrue(add == 1);
    }

    @Test
    public void deleteUserRRole() throws Exception {
        int deleted = roleInfoService.deleteUserRRole(100L);
        Assert.assertTrue(deleted >= 1);
    }

    @Test
    public void updateUserRRole() throws Exception {
        int updated = roleInfoService.updateUserRRole(100L, "SUPER");
        Assert.assertTrue(updated == 1);
    }

}