package cn.faury.fwmf.module.service.code;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fwmf.module.api.code.bean.CodeInfoBean;
import cn.faury.fwmf.module.api.code.service.CodeInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeInfoServiceImplTest {

    @Autowired
    CodeInfoService codeInfoService;

    @Test
    public void search() throws Exception {
        Map<String, Object> param = new HashMap<>();
        PageInfo<CodeInfoBean> pageInfo = codeInfoService.search(param);
        System.out.println(pageInfo);
        Assert.assertNotNull(pageInfo);
    }

    @Test
    public void getCodeListByGroupCode(){
        List<CodeInfoBean> codes = codeInfoService.getCodeListByGroupCode("sex");
        System.out.println(codes);
        Assert.assertNotNull(codes);
    }
}
