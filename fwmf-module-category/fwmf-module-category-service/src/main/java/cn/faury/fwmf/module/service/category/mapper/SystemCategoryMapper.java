package cn.faury.fwmf.module.service.category.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.category.bean.SystemCategoryBean;
import cn.faury.fwmf.module.service.category.sqlProvider.SystemCategorySqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * 系统商品标签授权Mapper
 */
@AutoScannedMapper
public interface SystemCategoryMapper {

	/**
	 * 根据系统code获取分类信息
	 * 
	 * @return
	 */
	@SelectProvider(type = SystemCategorySqlProvider.class, method = "getSysCategoryAllByCondition")
	@ResultType(SystemCategoryBean.class)
	public List<SystemCategoryBean> getSysCategoryAllByCondition(final Map<String, Object> parameter);

	/**
	 * 获取已经授权分类信息以及父节点
	 * 
	 * @param parameter
	 * @return
	 */
	@SelectProvider(type = SystemCategorySqlProvider.class, method = "getSysCategoryAll")
	@ResultType(SystemCategoryBean.class)
	public List<SystemCategoryBean> getSysCategoryAll(final Map<String, Object> parameter);

	/**
	 * 保存商品分类
	 * 
	 * @param parameter
	 * @return
	 */
	@InsertProvider(method = "saveSystemCategoryInfo", type = SystemCategorySqlProvider.class)
	public Long saveSystemCategoryInfo(final Map<String, Object> parameter);

	/**
	 * 保存系统商品分类授权
	 * 
	 * @param parameter
	 *            多个系统商品分类授权实体Bean
	 * 
	 *            <pre>
	 *            	systemId:业务系统ID
	 * 			isLeaf：是否叶子节点 是：1 否：0
	 * 				categoryIds：分类Id集合
	 * </pre>
	 * @return 保存成功的记录数
	 */
	@InsertProvider(method = "saveSystemCategoryInfoForList", type = SystemCategorySqlProvider.class)
	public Long saveSystemCategoryInfoForList(final Map<String, Object> parameter);

	/**
	 * 删除商品分类
	 * 
	 * @param parameter
	 * @return
	 */
	@InsertProvider(method = "deleteSystemCategoryInfo", type = SystemCategorySqlProvider.class)
	public Long deleteSystemCategoryInfo(final Map<String, Object> parameter);
}
