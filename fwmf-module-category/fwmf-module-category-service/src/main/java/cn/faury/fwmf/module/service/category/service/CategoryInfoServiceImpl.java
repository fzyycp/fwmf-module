package cn.faury.fwmf.module.service.category.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.category.bean.CategoryInfoBean;
import cn.faury.fwmf.module.api.category.service.CategoryInfoService;
import cn.faury.fwmf.module.service.category.mapper.CategoryInfoMapper;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;

import java.util.List;

/**
 * 服务实现：分类信息表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了CategoryInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class CategoryInfoServiceImpl extends CrudBaseServiceImpl<CategoryInfoBean, Long> implements CategoryInfoService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public CategoryInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, CategoryInfoMapper.class);
    }

    /**
     * 获取直接下级分类列表
     *
     * @param categoryId 分类ID
     * @return 下级分类列表
     */
    @Override
    public List<CategoryInfoBean> getSubCategoryList(Long categoryId) {
        return null;
    }
}