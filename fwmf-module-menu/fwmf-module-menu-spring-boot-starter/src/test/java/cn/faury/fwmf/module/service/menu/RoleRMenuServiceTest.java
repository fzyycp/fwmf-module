package cn.faury.fwmf.module.service.menu;

import cn.faury.fwmf.module.api.menu.bean.MenuTreeNodeBean;
import cn.faury.fwmf.module.api.menu.service.RoleRMenuService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRMenuServiceTest {
    private Long usreId = 2L;
    private String systemCode = "jl-yexs-manager";

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getMenuTreeByUserSystem() throws Exception{
        List<MenuTreeNodeBean> result = roleRMenuService.getMenuTreeByUserSystem(usreId,systemCode, Boolean.FALSE);
        System.out.println(result);
    }

    @Autowired
    RoleRMenuService roleRMenuService;
}