package cn.faury.fwmf.module.service.systemconfig;

import cn.faury.fwmf.module.api.systemconfig.service.SystemConfigService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllBeanInitTest {

    @Autowired
    SystemConfigService systemConfigService;
}
