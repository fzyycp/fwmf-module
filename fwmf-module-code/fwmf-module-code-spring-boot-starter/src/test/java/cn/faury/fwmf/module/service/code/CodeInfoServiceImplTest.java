package cn.faury.fwmf.module.service.code;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
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
        param.put("codeType", "test");
        param.put(PageParam.KEY.KEY_PAGE_SIZE, "2");
        param.put(PageParam.KEY.KEY_PAGE_NO, "2");
        PageInfo<CodeInfoBean> pageInfo = codeInfoService.search(param);
        System.out.println(pageInfo);
        Assert.assertNotNull(pageInfo);
        Assert.assertTrue(pageInfo.getList().size() == 2);
        Assert.assertTrue(pageInfo.getPages() == 3);
    }

    @Test
    public void getCodeList() throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("codeType", "test");
        List<CodeInfoBean> code = codeInfoService.getCodeList(param);
        System.out.println(code);
        Assert.assertNotNull(code);
        Assert.assertTrue(code.size() == 6);
    }

    @Test
    public void insertCodeInfo() throws Exception {
        CodeInfoBean codeInfoBean = new CodeInfoBean();
        codeInfoService.insertCodeInfo(codeInfoBean);
    }

    @Test
    public void updateCodeInfoByCodeId() throws Exception {
    }

    @Test
    public void getCodeInfoByCodeId() throws Exception {
    }

    @Test
    public void getCodeInfoList() throws Exception {
    }

    @Test
    public void getCodeInfoByType() throws Exception {
    }

    @Test
    public void deleteCodeInfoByCodeId() throws Exception {
    }
}
