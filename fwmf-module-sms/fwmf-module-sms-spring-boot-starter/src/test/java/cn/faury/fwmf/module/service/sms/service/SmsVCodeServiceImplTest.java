package cn.faury.fwmf.module.service.sms.service;

import cn.faury.fwmf.module.api.sms.bean.SmsVCodeBean;
import cn.faury.fwmf.module.api.sms.service.SmsVCodeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsVCodeServiceImplTest {
    @Test
    public void sendSmsMessage() throws Exception {
    }

    @Test
    public void createVCode() throws Exception {
        SmsVCodeBean bean = smsVCodeService.createVCode("18602555655", "eb-web");
        Assert.assertNotNull(bean);
        System.out.println(bean);
    }

    @Test
    public void validateVCode() throws Exception {
        Boolean validate = smsVCodeService.validateVCode("6b4bbd59-cc7c-4b87-86e0-d50b8269eeff", "5540", "18602555655");
        Assert.assertTrue(validate);
    }

    @Test
    public void createAndSendVCode() throws Exception {
        smsVCodeService.createAndSendVCode("18602555655", "eb-web");
    }

    @Test
    public void getLastVCodeByMobileNum() throws Exception {
        SmsVCodeBean bean = smsVCodeService.getLastVCodeByMobileNum("18602555655", "eb-app");
        Assert.assertNotNull(bean);
        System.out.println(bean);
    }

    @Test
    public void getVCodeByUuid() throws Exception {
        SmsVCodeBean bean = smsVCodeService.getVCodeByUuid("201bb480-8b8f-4c7f-b2ab-a117ed6facfd");
        Assert.assertNotNull(bean);
        System.out.println(bean);
    }

    @Autowired
    SmsVCodeService smsVCodeService;
}