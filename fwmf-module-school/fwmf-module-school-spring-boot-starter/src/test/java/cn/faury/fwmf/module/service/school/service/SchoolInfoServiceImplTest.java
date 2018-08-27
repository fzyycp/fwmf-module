package cn.faury.fwmf.module.service.school.service;

import cn.faury.fwmf.module.api.school.bean.SchoolInfoBean;
import cn.faury.fwmf.module.api.school.config.SchoolLevel;
import cn.faury.fwmf.module.api.school.service.SchoolInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolInfoServiceImplTest {
    @Autowired
    SchoolInfoService schoolInfoService;

    @Test
    public void getSchoolListByAreaCode() throws Exception {
        String areaCode = "320111";
        System.out.println(schoolInfoService.getSchoolListByAreaCode(areaCode, SchoolLevel.KINDERGARTEN));
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void getBeanById() throws Exception {
        SchoolInfoBean bean = schoolInfoService.getBeanById(1L);
        System.out.println(bean);
    }

    @Test
    public void search() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("areaCode", "710000");
        params.put("schoolLevel", "710000");
        params.put("telNo", "710000");
        System.out.println(schoolInfoService.search(params));
    }

}