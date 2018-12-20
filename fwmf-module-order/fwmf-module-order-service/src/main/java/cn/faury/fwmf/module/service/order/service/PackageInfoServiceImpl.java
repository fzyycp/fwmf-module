package cn.faury.fwmf.module.service.order.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.order.bean.PackageInfoBean;
import cn.faury.fwmf.module.api.order.service.PackageInfoService;
import cn.faury.fwmf.module.api.order.service.PackageRGoodsService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.order.mapper.PackageInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * 服务实现：套餐基本信息表
 *
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了PackageInfoService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class PackageInfoServiceImpl extends CrudBaseServiceImpl<PackageInfoBean, Long> implements PackageInfoService {

    @Autowired(required = false)
    protected PackageRGoodsService packageRGoodsService;

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public PackageInfoServiceImpl(CommonDao commonDao) {
        super(commonDao, PackageInfoMapper.class);
    }

    /**
     * 获取商品所在套餐列表
     *
     * @param goodsId   商品ID
     * @param pageParam 分页参数
     * @return 查询结果
     */
    @Override
    public PageInfo<PackageInfoBean> getGoodsPackageList(Long goodsId, PageParam pageParam) {
        String state = this.mapper.getName() + ".getGoodsPackageList";
        return this.commonDao.selectPage(state, goodsId, pageParam);
    }

    /**
     * 插入套餐和对应的关联商品
     *
     * @param packageInfoBean 套餐信息和商品信息
     * @return 套餐ID
     */
    @Override
    public Long insertPackageWithGoods(PackageInfoBean packageInfoBean) {
        // 插入套餐信息
        Long packageId = this.insert(packageInfoBean);
        if (packageInfoBean.getGoodsList() != null) {
            packageInfoBean.getGoodsList().forEach(packageRGoodsBean -> {
                packageRGoodsBean.setPackageId(packageId);
            });
            // 插入套餐商品信息
            packageRGoodsService.insertBatch(packageInfoBean.getGoodsList());
        }
        return packageId;
    }

    /**
     * 更新套餐和对应的关联商品
     *
     * @param packageInfoBean 套餐信息和商品信息
     * @return 套餐ID
     */
    @Override
    public int updatePackageWithGoods(PackageInfoBean packageInfoBean) {
        // 更新套餐信息
        int result = this.update(packageInfoBean);
        if (result > 0) {
            packageRGoodsService.deleteByPackageId(packageInfoBean.getPackageId());
            if (packageInfoBean.getGoodsList() != null) {
                packageInfoBean.getGoodsList().forEach(packageRGoodsBean -> {
                    packageRGoodsBean.setPackageId(packageInfoBean.getPackageId());
                });
                // 插入套餐商品信息
                packageRGoodsService.insertBatch(packageInfoBean.getGoodsList());
            }
        }
        return result;
    }

    /**
     * 删除套餐
     *
     * @param packageIds 多个套餐ID
     * @return 成功删除个数
     */
    @Override
    public int deletePackageBatch(List<Long> packageIds) {
        String state = this.mapper.getName() + ".deletePackageBatch";

        return this.commonDao.update(state, Collections.singletonMap("packageIds", packageIds));
    }
}
