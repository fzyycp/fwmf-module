package cn.faury.fwmf.module.service.menu;

import cn.faury.fdk.common.entry.TreeNodeEntry;
import cn.faury.fwmf.module.api.menu.bean.MenuInfoBean;
import cn.faury.fwmf.module.api.menu.service.UserRMenuService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRMenuServiceTest {

    @Autowired
    UserRMenuService userRMenuService;

    @Test
    public void getMenuInfoByUserId() throws Exception {
        List<MenuInfoBean> menuInfoBeans = userRMenuService.getMenuInfoByUserId("fwmf-web", 1L);
        System.out.println(menuInfoBeans);
        Assert.assertNotNull(menuInfoBeans);
    }

    @Test
    public void getMenuTreeNodeByUserId() throws Exception {
        List<TreeNodeEntry> treeNodeEntries = userRMenuService.getMenuTreeNodeByUserId("fwmf-web",1L);
        System.out.println(treeNodeEntries);
        Assert.assertNotNull(treeNodeEntries);
    }
}
