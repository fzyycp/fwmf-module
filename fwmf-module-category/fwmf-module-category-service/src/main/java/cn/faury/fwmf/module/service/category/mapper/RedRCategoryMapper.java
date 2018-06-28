package cn.faury.fwmf.module.service.category.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.category.bean.RedRCategoryBean;
import cn.faury.fwmf.module.service.category.sqlProvider.RedRCategorySQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface RedRCategoryMapper {

	@SelectProvider(method = "queryRedRCategoryByRedId", type = RedRCategorySQLProvider.class)
	@ResultType(RedRCategoryBean.class)
	public List<RedRCategoryBean> queryRedRCategoryByRedId(Map<String, Object> parameter);

	/**
	 * 插入优惠商品
	 * 
	 * <pre>
	 * 【必填】 List<RedRUserGroupsBean> list
	 * </pre>
	 * 
	 * @return
	 */
	@InsertProvider(type = RedRCategorySQLProvider.class, method = "insert")
	public Integer insert(Map<String, Object> parameter);

	/**
	 * 删除优惠商品
	 * 
	 * <pre>
	 * 1.【必填】 List<Long> ids 主键
	 * 2.【必填】List<Long> redIds 优惠ID
	 * 3.【必填】Long redId 优惠ID
	 * 【必填】List<Long> productCategoryIds 商品分类IDS
	 * </pre>
	 * 
	 * @return
	 */
	@DeleteProvider(type = RedRCategorySQLProvider.class, method = "del")
	public Integer del(Map<String, Object> parameter);
}
