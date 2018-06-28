package cn.faury.fwmf.module.service.category.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.category.bean.TagGroupInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagValueInfoBean;
import cn.faury.fwmf.module.service.category.sqlProvider.CategoryTagSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 分类标签Mapper
 */
@AutoScannedMapper
public interface CategoryTagMapper {

	/**
	 * 根据多分类ID、标签组ID获取分类标签下标签组所拥有的标签值列表
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【必填】Long categoryId 分类ID
	 * 【必填】List&lt;Long&gt; tagProductId 标签组ID
	 * 【可选】Boolean isCategoryDelete 分类是否删除【true:是 false：否 null：全部】
	 * </pre>
	 * 
	 * @return 标签值列表
	 */
	@SelectProvider(type = CategoryTagSQLProvider.class, method = "getTagValueInfoByGroupId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "tagProductId", column = "TAG_PRODUCT_ID", javaType = Long.class),
	        @Result(property = "tagProductName", column = "TAG_PRODUCT_NAME"),
	        @Result(property = "tagProductType", column = "TAG_PRODUCT_TYPE"),
	        @Result(property = "parentId", column = "PARENT_ID", javaType = Long.class),
	        @Result(property = "xpath", column = "XPATH") })
	public List<TagValueInfoBean> getTagValueInfoByGroupId();

	/**
	 * 根据分类ID获取分类标签下所拥有的标签组列表
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【必填】Long categoryId 分类ID
	 * 【可选】Boolean isCategoryDelete 分类是否删除【true:是 false：否 null：全部】
	 * </pre>
	 * 
	 * @return 标签组列表
	 */
	@SelectProvider(type = CategoryTagSQLProvider.class, method = "getTagGroupListByCategoryId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "tagProductId", column = "TAG_PRODUCT_ID", javaType = Long.class),
	        @Result(property = "tagProductName", column = "TAG_PRODUCT_NAME"),
	        @Result(property = "tagProductType", column = "TAG_PRODUCT_TYPE"),
	        @Result(property = "parentId", column = "PARENT_ID", javaType = Long.class),
	        @Result(property = "xpath", column = "XPATH") })
	public List<TagGroupInfoBean> getTagGroupListByCategoryId();

	/**
	 * 插入分类标签信息
	 *
	 * @return 插入记录数
	 */
	@InsertProvider(type = CategoryTagSQLProvider.class, method = "insertCategoryTagInfo")
	public Integer insertCategoryTagInfo();

	/**
	 * 删除分类标签信息
	 *
	 * @return 删除记录数
	 */
	@DeleteProvider(type = CategoryTagSQLProvider.class, method = "deleteCategoryTagInfo")
	public Integer deleteCategoryTagInfo();

	/**
	 * 根据分类ID、系统code、用途获取关联的标签
	 * 
	 * @return List<TagInfoBean>
	 */
	@SelectProvider(type = CategoryTagSQLProvider.class, method = "queryTagInfoByCategoryId")
	@ResultType(TagInfoBean.class)
	public List<TagInfoBean> queryTagInfoByCategoryId();
}
