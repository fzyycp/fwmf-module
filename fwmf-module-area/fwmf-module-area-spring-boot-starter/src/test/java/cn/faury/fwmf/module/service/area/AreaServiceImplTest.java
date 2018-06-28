package cn.faury.fwmf.module.service.area;

import cn.faury.fwmf.module.api.area.service.AreaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceImplTest {
    @Test
    public void getAreaOneTreeByCode() throws Exception {
        System.out.println(areaService.getAreaOneTreeByCode("110100"));
    }

    @Test
    public void getAreaAllTreeByCode() throws Exception {
        System.out.println(areaService.getAreaAllTreeByCode("110100"));
    }

    @Autowired
    AreaService areaService;
}
