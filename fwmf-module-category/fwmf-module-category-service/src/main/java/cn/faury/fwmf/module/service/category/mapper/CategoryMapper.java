package cn.faury.fwmf.module.service.category.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.category.bean.CategoryInfoBean;
import cn.faury.fwmf.module.service.category.sqlProvider.CategorySQLProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 分类Mapper
 */
@AutoScannedMapper
public interface CategoryMapper {

	/**
	 * 根据分类ID获取分类信息对象
	 * 
	 * <pre>
	 * 可能出现的参数：
	 * 【必填】Long categoryId 分类ID
	 * </pre>
	 * 
	 * @return 菜单信息
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "getCategoryInfoByCategoryId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "productCategoryName", column = "PRODUCT_CATEGORY_NAME"),
	        @Result(property = "displayOrder", column = "DISPLAY_ORDER"),
	        @Result(property = "parentId", column = "PARENT_ID"),
	        @Result(property = "templateId", column = "TEMPLATE_ID", javaType = Long.class),
	        @Result(property = "createPersonName", column = "CREATE_PERSON_NAME"),
	        @Result(property = "createTime", column = "CREATE_TIME"),
	        @Result(property = "updatePersonName", column = "UPDATE_PERSON_NAME"),
	        @Result(property = "updateTime", column = "UPDATE_TIME"),
	        @Result(property = "delFlag", column = "DEL_FLAG"), @Result(property = "xpath", column = "XPATH") })
	public List<CategoryInfoBean> getCategoryInfoByCategoryId();

	/**
	 * 根据分类ID获取子分类信息列表
	 * 
	 * <pre>
	 * 获取分类ID下<b><i>第一层</i></b>子分类；
	 * 分类以<b><i>List</i></b>的形式返回；
	 * 
	 * 可能出现的参数：
	 * 【必填】Long categoryId 分类ID
	 * </pre>
	 * 
	 * @return 菜单信息
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "getCategoryOneChildListByCategoryId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "productCategoryName", column = "PRODUCT_CATEGORY_NAME"),
	        @Result(property = "displayOrder", column = "DISPLAY_ORDER"),
	        @Result(property = "parentId", column = "PARENT_ID"),
	        @Result(property = "templateId", column = "TEMPLATE_ID", javaType = Long.class),
	        @Result(property = "createPersonName", column = "CREATE_PERSON_NAME"),
	        @Result(property = "createTime", column = "CREATE_TIME"),
	        @Result(property = "updatePersonName", column = "UPDATE_PERSON_NAME"),
	        @Result(property = "updateTime", column = "UPDATE_TIME"),
	        @Result(property = "delFlag", column = "DEL_FLAG"), @Result(property = "xpath", column = "XPATH") })
	public List<CategoryInfoBean> getCategoryOneChildListByCategoryId();

	/**
	 * 根据分类ID获取子分类信息列表
	 * 
	 * <pre>
	 * 获取分类ID下<b><i>第一、二层</i></b>子分类；
	 * 分类以<b><i>List</i></b>的形式返回；
	 * 
	 * 可能出现的参数：
	 * 【必填】Long categoryId 分类ID
	 * </pre>
	 * 
	 * @return 菜单信息
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "getCategoryTwoChildListByCategoryId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "productCategoryName", column = "PRODUCT_CATEGORY_NAME"),
	        @Result(property = "displayOrder", column = "DISPLAY_ORDER"),
	        @Result(property = "parentId", column = "PARENT_ID"),
	        @Result(property = "templateId", column = "TEMPLATE_ID", javaType = Long.class),
	        @Result(property = "createPersonName", column = "CREATE_PERSON_NAME"),
	        @Result(property = "createTime", column = "CREATE_TIME"),
	        @Result(property = "updatePersonName", column = "UPDATE_PERSON_NAME"),
	        @Result(property = "updateTime", column = "UPDATE_TIME"),
	        @Result(property = "delFlag", column = "DEL_FLAG"), @Result(property = "xpath", column = "XPATH") })
	public List<CategoryInfoBean> getCategoryTwoChildListByCategoryId();

	/**
	 * 根据分类ID获取所有子分类信息列表
	 * 
	 * <pre>
	 * 获取分类ID下<b><i>所有级联</i></b>子分类；
	 * 分类以<b><i>List</i></b>的形式返回；
	 * 
	 * 可能出现的参数：
	 * 【必填】Long categoryId 分类ID
	 * </pre>
	 * 
	 * @return 菜单信息
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "getCategoryAllChildListByCategoryId")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "productCategoryName", column = "PRODUCT_CATEGORY_NAME"),
	        @Result(property = "displayOrder", column = "DISPLAY_ORDER"),
	        @Result(property = "parentId", column = "PARENT_ID"),
	        @Result(property = "templateId", column = "TEMPLATE_ID", javaType = Long.class),
	        @Result(property = "createPersonName", column = "CREATE_PERSON_NAME"),
	        @Result(property = "createTime", column = "CREATE_TIME"),
	        @Result(property = "updatePersonName", column = "UPDATE_PERSON_NAME"),
	        @Result(property = "updateTime", column = "UPDATE_TIME"),
	        @Result(property = "delFlag", column = "DEL_FLAG"), @Result(property = "xpath", column = "XPATH") })
	public List<CategoryInfoBean> getCategoryAllChildListByCategoryId();

	/**
	 * 根据分类ID获取子分类信息列表
	 *
	 * <pre>
	 * 获取分类ID下<b><i>第一层</i></b>子分类；
	 * 分类以<b><i>List</i></b>的形式返回；
	 * 
	 * 可能出现的参数：
	 * 【必填】Long categoryId 分类ID
	 * 【非必填】String categoryName 分类名称
	 * 【非必填】String categoryState 分类状态
	 * </pre>
	 *
	 * @return 分类信息
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "getCategoryOneChildListByCategoryIdWithSelf")
	@ResultType(CategoryInfoBean.class)
	public List<CategoryInfoBean> getCategoryOneChildListByCategoryIdWithSelf();

	/**
	 * 获取全部分类信息
	 *
	 * <pre>
	 * 获取全部分类信息；
	 * 分类信息以<b><i>List</i></b>的形式返回；
	 * 
	 * 可能出现的参数：
	 * 【非必填】Boolean isDeleteFlag 是否删除
	 * </pre>
	 *
	 * @return 分类信息
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "getAllCategory")
	@Results({ @Result(property = "productCategoryId", column = "PRODUCT_CATEGORY_ID", javaType = Long.class),
	        @Result(property = "productCategoryName", column = "PRODUCT_CATEGORY_NAME"),
	        @Result(property = "displayOrder", column = "DISPLAY_ORDER"),
	        @Result(property = "parentId", column = "PARENT_ID"),
	        @Result(property = "templateId", column = "TEMPLATE_ID", javaType = Long.class),
	        @Result(property = "createPersonName", column = "CREATE_PERSON_NAME"),
	        @Result(property = "createTime", column = "CREATE_TIME"),
	        @Result(property = "updatePersonName", column = "UPDATE_PERSON_NAME"),
	        @Result(property = "updateTime", column = "UPDATE_TIME"),
	        @Result(property = "delFlag", column = "DEL_FLAG"), @Result(property = "xpath", column = "XPATH") })
	public List<CategoryInfoBean> getAllCategory();

	/**
	 * 检查分类名称是否重复
	 *
	 * @return 重复名称的数量
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "checkCategoryName")
	public Integer checkCategoryName();

	/**
	 * 检查是否含有子分类
	 *
	 * @return 子分类个数
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "checkHasChildren")
	public Integer checkHasChildren();

	/**
	 * 自动生成的显示排序
	 *
	 * @return
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "genDisplayOrder")
	public Integer genDisplayOrder();

	/**
	 * 新增分类信息
	 *
	 * @return 新增数量
	 */
	@InsertProvider(type = CategorySQLProvider.class, method = "insertCategoryInfo")
	@Options(keyProperty = "productCategoryId", useGeneratedKeys = true)
	public Integer insertCategoryInfo();

	/**
	 * 修改分类信息
	 *
	 * @return 修改数量
	 */
	@UpdateProvider(type = CategorySQLProvider.class, method = "updateCategoryInfo")
	public Integer updateCategoryInfo();

	/**
	 * 删除分类信息
	 *
	 * @return 删除数量
	 */
	@UpdateProvider(type = CategorySQLProvider.class, method = "deleteCategoryInfo")
	public Integer deleteCategoryInfo();

	/**
	 * 根据分类ID获取第一层子分类树
	 * 
	 * <pre>
	 * 获取分类ID下<b>第一层</b>子分类；
	 * 分类以<b>List</b>的形式返回；
	 * </pre>
	 * 
	 * <pre>
	 * 查询参数：
	 * Long categoryId 分类ID
	 * Long templateId 用途ID
	 * String systemCode 系统code
	 * boolean isDeleteFlag
	 *            是否删除【true:是, false：否 ,null：全部】
	 * </pre>
	 * 
	 * @return List<CategoryInfoBean>
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "queryCategoryOneChildListByCategoryId")
	@ResultType(CategoryInfoBean.class)
	public List<CategoryInfoBean> queryCategoryOneChildListByCategoryId();

	/**
	 * 根据分类ID获取第一、二层子分类
	 * 
	 * <pre>
	 * 获取分类ID下<b>第一、二层</b>子分类；
	 * 分类以<b>List非树形结构</b>返回；
	 * </pre>
	 * 
	 * @return List<CategoryInfoBean>
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "queryCategoryTwoChildListByCategoryId")
	@ResultType(CategoryInfoBean.class)
	public List<CategoryInfoBean> queryCategoryTwoChildListByCategoryId();

	/**
	 * 根据分类ID获取所有子分类
	 * 
	 * <pre>
	 * 获取分类ID下<b>所有</b>子分类；
	 * 分类以<b>List</b>的形式返回；
	 * </pre>
	 * 
	 * @return List<CategoryInfoBean>
	 */
	@SelectProvider(type = CategorySQLProvider.class, method = "queryCategoryAllChildListByCategoryId")
	@ResultType(CategoryInfoBean.class)
	public List<CategoryInfoBean> queryCategoryAllChildListByCategoryId();

}
