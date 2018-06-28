package cn.faury.fwmf.module.service.category;

import cn.faury.fwmf.module.api.category.service.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllBeanInitTest {

    @Test
    public void checkInit(){
        Assert.assertNotNull(categoryService);
        Assert.assertNotNull(categoryTagService);
        Assert.assertNotNull(discusRCategoryService);
        Assert.assertNotNull(redRCategoryService);
        Assert.assertNotNull(systemCategoryService);
        Assert.assertNotNull(systemTagService);
        Assert.assertNotNull(tagService);
        categoryService.queryCategoryAllChildTreeWithTemplate(2L);
    }

    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryTagService categoryTagService;
    @Autowired
    DiscusRCategoryService discusRCategoryService;
    @Autowired
    RedRCategoryService redRCategoryService;
    @Autowired
    SystemCategoryService systemCategoryService;
    @Autowired
    SystemTagService systemTagService;
    @Autowired
    TagService tagService;
}
