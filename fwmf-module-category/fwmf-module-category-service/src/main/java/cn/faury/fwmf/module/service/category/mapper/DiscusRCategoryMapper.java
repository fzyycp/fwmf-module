package cn.faury.fwmf.module.service.category.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.category.bean.DiscusRCategoryBean;
import cn.faury.fwmf.module.service.category.sqlProvider.DiscusRCategorySQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface DiscusRCategoryMapper {

	@SelectProvider(method = "queryDiscusRCategoryByDiscusId", type = DiscusRCategorySQLProvider.class)
	@ResultType(DiscusRCategoryBean.class)
	public List<DiscusRCategoryBean> queryDiscusRCategoryByDiscusId(Map<String, Object> parameter);

	/**
	 * 插入优惠商品
	 * 
	 * <pre>
	 * 【必填】 List<DiscusRUserGroupsBean> list
	 * </pre>
	 * 
	 * @return
	 */
	@InsertProvider(type = DiscusRCategorySQLProvider.class, method = "insert")
	public Integer insert(Map<String, Object> parameter);

	/**
	 * 删除优惠商品
	 * 
	 * <pre>
	 * 1.【必填】 List<Long> ids 主键
	 * 2.【必填】List<Long> discusId 优惠ID
	 * 3.【必填】Long discusId 优惠ID
	 * 【必填】List<Long> productCategoryIds 商品分类IDS
	 * </pre>
	 * 
	 * @return
	 */
	@DeleteProvider(type = DiscusRCategorySQLProvider.class, method = "del")
	public Integer del(Map<String, Object> parameter);
}
