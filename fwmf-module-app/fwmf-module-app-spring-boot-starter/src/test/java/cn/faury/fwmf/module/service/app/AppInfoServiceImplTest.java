package cn.faury.fwmf.module.service.app;

import cn.faury.fwmf.module.api.app.bean.AppInfoBean;
import cn.faury.fwmf.module.api.app.service.AppInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppInfoServiceImplTest {
    @Test
    public void queryAppInfoByPager() throws Exception {
    }

    @Test
    public void queryAppInfo() throws Exception {
    }

    @Test
    public void getAppInfoList() throws Exception {
    }

    @Test
    public void getAppInfoList1() throws Exception {
    }

    @Test
    public void getAppInfoList2() throws Exception {
    }

    @Test
    public void getAppInfoList3() throws Exception {
    }

    @Test
    public void getAppInfoByMId() throws Exception {
    }

    @Test
    public void getAppInfoByMIdIsWithContact() throws Exception {
    }

    @Test
    public void checkAppInfo() throws Exception {
    }

    @Test
    public void isAppInUse() throws Exception {
        AppInfoBean appInfoBean = appInfoService.isAppInUse("APP");
        System.out.println(appInfoBean);
    }

    @Test
    public void insertAppInfo() throws Exception {
    }

    @Test
    public void deleteAppInfoByAppCodes() throws Exception {
    }

    @Test
    public void deleteAppInfoByAppIds() throws Exception {
    }

    @Test
    public void updateAppInfo() throws Exception {
    }

    @Autowired
    AppInfoService appInfoService;
}
