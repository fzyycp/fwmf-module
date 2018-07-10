package cn.faury.fwmf.module.service.system;

import cn.faury.fwmf.module.api.system.service.ShopRSystemService;
import cn.faury.fwmf.module.api.system.service.SystemService;
import cn.faury.fwmf.module.api.system.service.UserRSystemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllBeanInitTest {

    @Test
    public void checkInit(){
        Assert.assertNotNull(shopRSystemService);
        Assert.assertNotNull(systemService);
        Assert.assertNotNull(userRSystemService);
    }

    @Autowired
    ShopRSystemService shopRSystemService;
    @Autowired
    SystemService systemService;
    @Autowired
    UserRSystemService userRSystemService;
}
