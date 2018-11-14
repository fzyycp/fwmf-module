package cn.faury.fwmf.module.service.order.service;

import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.order.bean.PackageRGoodsBean;
import cn.faury.fwmf.module.api.order.service.PackageRGoodsService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.order.mapper.PackageRGoodsMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现：套餐关联表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了PackageRGoodsService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class PackageRGoodsServiceImpl extends CrudBaseServiceImpl<PackageRGoodsBean, Long> implements PackageRGoodsService {

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public PackageRGoodsServiceImpl(CommonDao commonDao) {
        super(commonDao, PackageRGoodsMapper.class);
    }

    /**
     * 根据套餐ID获取关联商品列表
     *
     * @param packageId 套餐ID
     * @return 商品列表
     */
    @Override
    public List<PackageRGoodsBean> getBeanListByPackageId(Long packageId) {
        String state = this.mapper.getName() + ".getBeanListByPackageId";
        return this.commonDao.selectList(state, packageId);
    }

    /**
     * 插入套餐关联商品信息
     *
     * @param packageRGoodsBeanList 套餐关联商品信息
     * @return 成功插入的ID列表
     */
    @Override
    public List<Long> insertBatch(List<PackageRGoodsBean> packageRGoodsBeanList) {
        final List<Long> result = new ArrayList<>();
        packageRGoodsBeanList.forEach(packageRGoodsBean -> {
            Long id = this.insert(packageRGoodsBean);
            result.add(id);
        });
        return result;
    }

    /**
     * 根据套餐ID删除关联商品列表
     *
     * @param packageId 套餐ID
     * @return 成功删除条数
     */
    @Override
    public int deleteByPackageId(Long packageId) {
        String state = this.mapper.getName() + ".deleteByPackageId";
        return this.commonDao.delete(state, packageId);
    }
}
