/**
 * 业务平台服务接口：ssk-platform-service-category
 * 
 * @date 2015年9月8日
 * @author yc.fan
 *
 * 版权所有：南京扫扫看数字科技有限公司
 */
package cn.faury.fwmf.module.api.category.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fwmf.module.api.category.bean.CategoryTagInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagGroupInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagValueInfoBean;

import java.util.List;
import java.util.Map;

/**
 * 分类标签服务接口
 * 
 * @author yc.fan
 *
 */
public interface CategoryTagService {

	/**
	 * 根据分类ID获取分类标签信息
	 * 
	 * @param categoryId
	 *            分类ID
	 * @param isCategoryDelete
	 *            分类是否删除【true:是 false：否 null：全部】
	 * @return 分类标签信息
	 */
	public List<CategoryTagInfoBean> getCategoryTagInfoByCategoryId(final Long categoryId,
																	final Boolean isCategoryDelete);

	/**
	 * 根据分类ID获取<b>未删除</b>分类标签信息
	 *
	 * @param categoryId
	 *            分类ID
	 * @return 分类标签信息
	 */
	public List<CategoryTagInfoBean> getCategoryTagInfoByCategoryId(final Long categoryId);

	/**
	 * 根据多个分类ID获取分类标签信息
	 *
	 * <pre>
	 * 格式：&lt;分类ID,分类标签对象&gt;
	 * </pre>
	 *
	 * @param categoryId
	 *            分类ID
	 * @param isCategoryDelete
	 *            分类是否删除【true:是 false：否 null：全部】
	 * @return 分类标签信息
	 */
	public Map<Long, List<CategoryTagInfoBean>> getCategoryTagInfoByCategoryId(final List<Long> categoryId,
                                                                               final Boolean isCategoryDelete);

	/**
	 * 根据多个分类ID获取<b>未删除</b>分类标签信息
	 *
	 * <pre>
	 * 格式：&lt;分类ID,分类标签对象&gt;
	 * </pre>
	 *
	 * @param categoryId
	 *            分类ID
	 * @return 分类标签信息
	 */
	public Map<Long, List<CategoryTagInfoBean>> getCategoryTagInfoByCategoryId(final List<Long> categoryId);

	/**
	 * 根据分类ID、系统code、用途获取关联的标签
	 *
	 * <pre>
	 * （<b>不</b>包括已删除）
	 * </pre>
	 *
	 * @param categoryId
	 *            【必填】分类id
	 * @param systemCode
	 *            【必填】系统code
	 * @param templateId
	 *            【必填】分类
	 * @return
	 */
	@Read
	public default List<TagInfoBean> getTagInfoByCategoryId(final List<Long> categoryId, final String systemCode,
													final Long templateId){
		AssertUtil.assertNotNull(categoryId, "分类ID为空或不存在");
		AssertUtil.assertTrue(templateId != null && templateId > 0, "用途为空或不存在");
		AssertUtil.assertNotEmpty(systemCode, "系统code为空或不存在");
		return queryTagInfoWithoutDelByCategoryId(categoryId, systemCode, templateId);
	}

	/**
	 * 根据多个分类ID、标签组ID获取分类标签信息下标签组对应标签值列表
	 *
	 * <pre>
	 * 格式：&lt;分类ID,&lt;分组ID,标签值&gt;&gt;
	 * </pre>
	 *
	 * @param categoryId
	 *            分类ID
	 * @param tagProductId
	 *            标签组ID
	 * @param isCategoryDelete
	 *            分类是否删除【true:是 false：否 null：全部】
	 * @return 标签值列表
	 */
	public Map<Long, Map<Long, List<TagValueInfoBean>>> getTagValueInfoByGroupId(final List<Long> categoryId,
																				 final List<Long> tagProductId, final Boolean isCategoryDelete);

	/**
	 * 根据多个分类ID、标签组ID获取<b>未删除</b>分类标签信息下标签组对应标签值列表
	 *
	 * <pre>
	 * 格式：&lt;分类ID,&lt;分组ID,标签值&gt;&gt;
	 * </pre>
	 *
	 * @param categoryId
	 *            分类ID
	 * @param tagProductId
	 *            标签组ID
	 * @return 标签值列表
	 */
	public Map<Long, Map<Long, List<TagValueInfoBean>>> getTagValueInfoByGroupId(final List<Long> categoryId,
																				 final List<Long> tagProductId);

	/**
	 * 根据分类ID、标签组ID获取分类标签信息下标签组对应标签值列表
	 *
	 * <pre>
	 * 格式：&lt;分组ID,标签值&gt;
	 * </pre>
	 *
	 * @param categoryId
	 *            分类ID
	 * @param tagProductId
	 *            标签组ID
	 * @param isCategoryDelete
	 *            分类是否删除【true:是 false：否 null：全部】
	 * @return 标签值列表
	 */
	public Map<Long, List<TagValueInfoBean>> getTagValueInfoByGroupId(final Long categoryId,
																	  final List<Long> tagProductId, final Boolean isCategoryDelete);

	/**
	 * 根据分类ID、标签组ID获取<b>未删除</b>分类标签信息下标签组对应标签值列表
	 *
	 * <pre>
	 * 格式：&lt;分组ID,标签值&gt;
	 * </pre>
	 *
	 * @param categoryId
	 *            分类ID
	 * @param tagProductId
	 *            标签组ID
	 * @return 标签值列表
	 */
	public Map<Long, List<TagValueInfoBean>> getTagValueInfoByGroupId(final Long categoryId,
																	  final List<Long> tagProductId);

	/**
	 * 根据分类ID、标签组ID获取分类标签信息下标签组对应标签值列表
	 *
	 * @param categoryId
	 *            分类ID
	 * @param tagProductId
	 *            标签组ID
	 * @param isCategoryDelete
	 *            分类是否删除【true:是 false：否 null：全部】
	 * @return 标签值列表
	 */
	public List<TagValueInfoBean> getTagValueInfoByGroupId(final Long categoryId, final Long tagProductId,
														   final Boolean isCategoryDelete);

	/**
	 * 根据分类ID、标签组ID获取<b>未删除</b>分类标签信息下标签组对应标签值列表
	 *
	 * @param categoryId
	 *            分类ID
	 * @param tagProductId
	 *            标签组ID
	 * @return 标签值列表
	 */
	public List<TagValueInfoBean> getTagValueInfoByGroupId(final Long categoryId, final Long tagProductId);

	/**
	 * 根据多个分类ID获取分类下标签组信息列表
	 *
	 * <pre>
	 * 格式：&lt;分类ID,分组信息&gt;
	 * </pre>
	 *
	 * @param categoryId
	 *            分类ID
	 * @param isCategoryDelete
	 *            分类是否删除【true:是 false：否 null：全部】
	 * @return 标签信息列表
	 */
	public Map<Long, List<TagGroupInfoBean>> getTagGroupListByCategoryId(final List<Long> categoryId,
																		 final Boolean isCategoryDelete);

	/**
	 * 根据多个分类ID获取<b>未删除</b>分类下标签组信息列表
	 *
	 * <pre>
	 * 格式：&lt;分类ID,分组信息&gt;
	 * </pre>
	 *
	 * @param categoryId
	 *            分类ID
	 * @return 标签信息列表
	 */
	public Map<Long, List<TagGroupInfoBean>> getTagGroupListByCategoryId(final List<Long> categoryId);

	/**
	 * 根据分类ID获取分类下标签组信息列表
	 *
	 * @param categoryId
	 *            分类ID
	 * @param isCategoryDelete
	 *            分类是否删除【true:是 false：否 null：全部】
	 * @return 标签信息列表
	 */
	public List<TagGroupInfoBean> getTagGroupListByCategoryId(final Long categoryId, final Boolean isCategoryDelete);

	/**
	 * 根据分类ID获取<b>未删除</b>分类下标签组信息列表
	 *
	 * @param categoryId
	 *            分类ID
	 * @return 标签信息列表
	 */
	public List<TagGroupInfoBean> getTagGroupListByCategoryId(final Long categoryId);

	/**
	 * 保存分类标签
	 *
	 * @param categoryId
	 *            分类ID
	 * @param tagsId
	 *            标签ID
	 * @return 插入记录数
	 */
	public Integer saveCategoryTagInfo(Long categoryId, List<Map<String, Long>> tagsId);

	/**
	 * 根据分类ID、系统code、用途获取关联的标签
	 *
	 * @param categoryId
	 *            【必填】分类id
	 * @param systemCode
	 *            【可选】系统code
	 * @param templateId
	 *            【可选】分类
	 * @param isCategoryDelete
	 *            【可选】是否删除【true:是, false：否 ,null：全部】
	 * @return List<TagInfoBean>
	 */
	@Read
	public List<TagInfoBean> queryTagInfoByCategoryId(final List<Long> categoryId, final String systemCode,
													  final Long templateId, final Boolean isCategoryDelete);

	/**
	 * 根据分类ID、系统code、用途获取关联的标签
	 *
	 * <pre>
	 * （包括已删除）
	 * </pre>
	 *
	 * @param categoryId
	 *            【必填】分类id
	 * @param systemCode
	 *            【可选】系统code
	 * @param templateId
	 *            【可选】分类
	 * @return
	 */
	@Read
	public default List<TagInfoBean> queryTagInfoWithDelByCategoryId(final List<Long> categoryId, final String systemCode,
															 final Long templateId){
		return queryTagInfoByCategoryId(categoryId, systemCode, templateId, null);
	}

	/**
	 * 根据分类ID、系统code、用途获取关联的标签
	 *
	 * <pre>
	 * （<b>不</b>包括已删除）
	 * </pre>
	 *
	 * @param categoryId
	 *            【必填】分类id
	 * @param systemCode
	 *            【可选】系统code
	 * @param templateId
	 *            【可选】分类
	 * @return
	 */
	@Read
	public default List<TagInfoBean> queryTagInfoWithoutDelByCategoryId(final List<Long> categoryId, final String systemCode,
																final Long templateId){
		return queryTagInfoByCategoryId(categoryId, systemCode, templateId, false);
	}

}
