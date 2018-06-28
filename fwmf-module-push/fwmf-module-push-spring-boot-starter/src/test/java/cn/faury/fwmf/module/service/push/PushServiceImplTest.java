package cn.faury.fwmf.module.service.push;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fwmf.module.api.push.bean.PushInfoBean;
import cn.faury.fwmf.module.api.push.service.PushService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushServiceImplTest {
    @Test
    public void getPushMessageInfo() throws Exception {
        PageInfo<PushInfoBean> pushInfoBeanPageInfo = pushService.getPushMessageInfo(null,null);
        System.out.println(pushInfoBeanPageInfo);
    }

    @Test
    public void getPushMessageInfoById() throws Exception {
    }

    @Test
    public void queryPushMessage() throws Exception {
    }

    @Test
    public void getMessageReadByUserId() throws Exception {
    }

    @Test
    public void getLastPushTime() throws Exception {
    }

    @Test
    public void getUnReadMessageCount() throws Exception {
    }

    @Test
    public void savePushMessageInfo() throws Exception {
    }

    @Test
    public void updatePushMessageInfo() throws Exception {
    }

    @Test
    public void deletePushMessageInfoByMId() throws Exception {
    }

    @Test
    public void setPushMessageState() throws Exception {
    }

    @Test
    public void startPush() throws Exception {
    }

    @Test
    public void insertMessageRead() throws Exception {
    }

    @Test
    public void readMessage() throws Exception {
    }

    @Test
    public void deleteMessageByUserId() throws Exception {
    }

    @Test
    public void delMessageReceive() throws Exception {
    }

    @Test
    public void delMessageRead() throws Exception {
    }

    @Test
    public void insertDelMessageRead() throws Exception {
    }

    @Test
    public void deleteAllMessageByUserId() throws Exception {
    }

    @Test
    public void delMessageReadByUserId() throws Exception {
    }

    @Test
    public void delMessageReceiveByUserId() throws Exception {
    }

    @Test
    public void queryPushMessage1() throws Exception {
    }

    @Test
    public void updateGetMessageReceive() throws Exception {
    }

    @Test
    public void insertGetMessageRead() throws Exception {
    }

    @Test
    public void updateMessageRead() throws Exception {
    }

    @Autowired
    PushService pushService;

}
