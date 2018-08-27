package cn.faury.fwmf.module.service.school.service;

import cn.faury.fwmf.module.api.school.service.SchoolRGradeInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolRGradeInfoServiceImplTest {
    @Test
    public void getGradeListBySchoolId() throws Exception {
        Long schoolId = 1L;
        System.out.println(schoolRGradeInfoService.getGradeListBySchoolId(schoolId));
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
    }

    @Test
    public void search() throws Exception {
    }

    @Autowired
    SchoolRGradeInfoService schoolRGradeInfoService;
}