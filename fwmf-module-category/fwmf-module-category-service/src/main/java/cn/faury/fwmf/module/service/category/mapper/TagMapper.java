package cn.faury.fwmf.module.service.category.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.category.bean.TagGroupInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagValueInfoBean;
import cn.faury.fwmf.module.service.category.sqlProvider.TagSQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 标签Mapper
 */
@AutoScannedMapper
public interface TagMapper {

	/**
	 * 根据多个标签ID获取标签信息对象
	 *
	 * <pre>
	 * 可能出现的参数：
	 * 【必填】List&lt;Long&gt; tagProductId 标签ID
	 * 【可选】Boolean isGroup 是否查询标签组【true:只查询标签组 false:只查询标签值 null:查询所有】
	 * </pre>
	 *
	 * @return 标签信息对象
	 */
	@SelectProvider(type = TagSQLProvider.class, method = "getTagInfoByTagId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "tagProductId", column = "TAG_PRODUCT_ID", javaType = Long.class),
	        @Result(property = "tagProductName", column = "TAG_PRODUCT_NAME"),
	        @Result(property = "tagProductType", column = "TAG_PRODUCT_TYPE"),
	        @Result(property = "parentId", column = "PARENT_ID", javaType = Long.class),
	        @Result(property = "xpath", column = "XPATH") })
	public List<TagInfoBean> getTagInfoByTagId();

	/**
	 * 根据多个标签组ID获取标签值信息对象
	 *
	 * <pre>
	 * 可能出现的参数：
	 * 【必填】List&lt;Long&gt; tagProductId 标签组ID
	 * </pre>
	 *
	 * @return 标签信息对象
	 */
	@SelectProvider(type = TagSQLProvider.class, method = "getTagValueListByTagId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "tagProductId", column = "TAG_PRODUCT_ID", javaType = Long.class),
	        @Result(property = "tagProductName", column = "TAG_PRODUCT_NAME"),
	        @Result(property = "tagProductType", column = "TAG_PRODUCT_TYPE"),
	        @Result(property = "parentId", column = "PARENT_ID", javaType = Long.class),
	        @Result(property = "xpath", column = "XPATH") })
	public List<TagInfoBean> getTagValueListByTagId();

	/**
	 * 根据分类获取多个标签值列表
	 *
	 * @return 标签值列表
	 */
	@SelectProvider(type = TagSQLProvider.class, method = "getTagValueListByCategoryId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "tagProductId", column = "TAG_PRODUCT_ID", javaType = Long.class),
	        @Result(property = "tagProductName", column = "TAG_PRODUCT_NAME"),
	        @Result(property = "tagProductType", column = "TAG_PRODUCT_TYPE"),
	        @Result(property = "parentId", column = "PARENT_ID", javaType = Long.class),
	        @Result(property = "xpath", column = "XPATH") })
	public List<TagValueInfoBean> getTagValueListByCategoryId();

	/**
	 * 根据标签ID获取<b>第一层</b>子标签对象列表
	 *
	 * <pre>
	 * 可能出现的参数：
	 * 【必填】Long tagProductId 标签ID
	 * </pre>
	 *
	 * @return 子标签对象列表
	 */
	@SelectProvider(type = TagSQLProvider.class, method = "getTagGroupOneChildListByTagId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "tagProductId", column = "TAG_PRODUCT_ID", javaType = Long.class),
	        @Result(property = "tagProductName", column = "TAG_PRODUCT_NAME"),
	        @Result(property = "tagProductType", column = "TAG_PRODUCT_TYPE"),
	        @Result(property = "parentId", column = "PARENT_ID", javaType = Long.class),
	        @Result(property = "xpath", column = "XPATH") })
	public List<TagGroupInfoBean> getTagGroupOneChildListByTagId();

	/**
	 * 根据标签ID获取<b>第一层、第二层</b>子标签对象列表
	 *
	 * <pre>
	 * 可能出现的参数：
	 * 【必填】Long tagProductId 标签ID
	 * </pre>
	 *
	 * @return 子标签对象列表
	 */
	@SelectProvider(type = TagSQLProvider.class, method = "getTagGroupTwoChildListByTagId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "tagProductId", column = "TAG_PRODUCT_ID", javaType = Long.class),
	        @Result(property = "tagProductName", column = "TAG_PRODUCT_NAME"),
	        @Result(property = "tagProductType", column = "TAG_PRODUCT_TYPE"),
	        @Result(property = "parentId", column = "PARENT_ID", javaType = Long.class),
	        @Result(property = "xpath", column = "XPATH") })
	public List<TagGroupInfoBean> getTagGroupTwoChildListByTagId();

	/**
	 * 根据标签ID获取<b>所有级联</b>子标签对象列表
	 *
	 * <pre>
	 * 可能出现的参数：
	 * 【必填】Long tagProductId 标签ID
	 * </pre>
	 *
	 * @return 子标签对象列表
	 */
	@SelectProvider(type = TagSQLProvider.class, method = "getTagGroupAllChildListByTagId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "tagProductId", column = "TAG_PRODUCT_ID", javaType = Long.class),
	        @Result(property = "tagProductName", column = "TAG_PRODUCT_NAME"),
	        @Result(property = "tagProductType", column = "TAG_PRODUCT_TYPE"),
	        @Result(property = "parentId", column = "PARENT_ID", javaType = Long.class),
	        @Result(property = "xpath", column = "XPATH") })
	public List<TagGroupInfoBean> getTagGroupAllChildListByTagId();

	/**
	 * 检查标签名称是否有重复
	 *
	 * @return 重复名称的数量
	 */
	@SelectProvider(type = TagSQLProvider.class, method = "checkSameName")
	public Integer checkSameName();

	/**
	 * 检查指定标签是否有子标签
	 *
	 * @return 子标签的数量
	 */
	@SelectProvider(type = TagSQLProvider.class, method = "checkHasCategory")
	public Integer checkHasCategory();

	/**
	 * 检查指定标签是否有子标签
	 *
	 * @return 子标签的数量
	 */
	@SelectProvider(type = TagSQLProvider.class, method = "checkHasChildren")
	public Integer checkHasChildren();

	/**
	 * 插入商品标签记录
	 *
	 * @return 保存记录的ID
	 */
	@InsertProvider(type = TagSQLProvider.class, method = "insertTagInfo")
	@Options(keyProperty = "tagProductId", useGeneratedKeys = true)
	public Integer insertTagInfo();

	/**
	 * 更新商品标签记录
	 */
	@UpdateProvider(type = TagSQLProvider.class, method = "updateTagInfo")
	public void updateTagInfo();

	/**
	 *
	 * @return 删除记录数
	 */
	@DeleteProvider(type = TagSQLProvider.class, method = "deleteTagInfo")
	public Integer deleteTagInfo();

	/**
	 * 根据多个标签ID获取标签信息对象
	 * 
	 * @return List<TagInfoBean>
	 */
	@SelectProvider(type = TagSQLProvider.class, method = "queryTagInfoByTagProductId")
	@ResultType(TagInfoBean.class)
	public List<TagInfoBean> queryTagInfoByTagProductId(final Map<String, Object> parameter);

}
