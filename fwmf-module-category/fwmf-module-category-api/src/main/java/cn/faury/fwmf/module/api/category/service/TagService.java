package cn.faury.fwmf.module.api.category.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fwmf.module.api.category.bean.TagGroupInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagGroupTreeNodeBean;
import cn.faury.fwmf.module.api.category.bean.TagInfoBean;
import cn.faury.fwmf.module.api.category.bean.TagValueInfoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 标签服务接口
 */
public interface TagService {

	/**
	 * 根据标签ID获取标签信息对象
	 * 
	 * @param tagProductId
	 *            标签ID
	 * @param isGroup
	 *            是否查询标签组【true:只查询标签组 false:只查询标签值 null:查询所有】
	 * @return 标签信息对象
	 * @deprecated
	 */
	default public TagInfoBean getTagInfoByTagId(final Long tagProductId, final Boolean isGroup){
		return getTagInfoByTagId(tagProductId, isGroup, false);
	}

	/**
	 * 根据标签ID获取标签信息对象
	 * 
	 * @param tagProductId
	 *            标签ID
	 * @param isGroup
	 *            是否查询标签组【true:只查询标签组 false:只查询标签值 null:查询所有】
	 * @param isDelte
	 *            是否删除【null:查询所有 ,false:查询未删除数据】
	 * @return 标签信息对象
	 */
	public TagInfoBean getTagInfoByTagId(final Long tagProductId, final Boolean isGroup, final Boolean isDelte);

	/**
	 * 根据多个标签ID获取标签信息对象
	 * 
	 * @param tagProductId
	 *            标签ID
	 * @param isGroup
	 *            是否查询标签组【true:只查询标签组 false:只查询标签值 null:查询所有】
	 * @return 标签信息对象
	 * @deprecated
	 */
	default public List<TagInfoBean> getTagInfoByTagId(final List<Long> tagProductId, final Boolean isGroup){
		return getTagInfoByTagId(tagProductId, isGroup, false);
	}

	/**
	 * 根据多个标签ID获取标签信息对象
	 * 
	 * @param tagProductId
	 *            标签ID
	 * @param isGroup
	 *            是否查询标签组【true:只查询标签组 false:只查询标签值 null:查询所有】
	 * @param isDelte
	 *            是否删除【null:查询所有 ,false:查询未删除数据】
	 * @return 标签信息对象
	 */
	public List<TagInfoBean> getTagInfoByTagId(final List<Long> tagProductId, final Boolean isGroup,
                                               final Boolean isDelte);

	/**
	 * 根据标签ID获取标签信息对象
	 *
	 * @param tagProductId
	 *            标签组ID（type：01）
	 * @param systemCode
	 *            系统code
	 * @return List<TagInfoBean>
	 * @deprecated
	 */
	default public List<TagInfoBean> getTagInfoByTagProductId(final Long tagProductId, final String systemCode){
        AssertUtil.assertNotNull(tagProductId,"标签组ID为空号或不存在");
        AssertUtil.assertNotEmpty(systemCode,"系统code为空或不存在");
        List<Long> tagProductIds = new ArrayList<Long>();
        tagProductIds.add(tagProductId);
        return queryTagInfoByTagProductId(tagProductIds, systemCode, null, false);
    }

	/**
	 * 根据标签ID获取标签信息对象
	 *
	 * @param tagProductId
	 *            标签组ID（type：01）
	 * @param systemCode
	 *            系统code
	 * @param isDelte
	 *            是否删除【null:查询所有 ,false:查询未删除数据】
	 * @return List<TagInfoBean>
	 */
	default public List<TagInfoBean> getTagInfoByTagProductId(final Long tagProductId, final String systemCode,
                                                      final Boolean isDelte){
		AssertUtil.assertNotNull(tagProductId,"标签组ID为空号或不存在");
		AssertUtil.assertNotEmpty(systemCode,"系统code为空或不存在");
		List<Long> tagProductIds = new ArrayList<>();
		tagProductIds.add(tagProductId);
		return queryTagInfoByTagProductId(tagProductIds, systemCode, null, isDelte);
	}

	/**
	 * 根据标签组ID获取标签值列表
	 *
	 * @param tagProductId
	 *            标签组ID
	 * @return 标签值列表
	 */
	public List<TagValueInfoBean> getTagValueListByTagId(final Long tagProductId, final Boolean isDelete);

	/**
	 * 根据多个标签组ID获取标签值列表
	 *
	 * @param tagProductId
	 *            标签组ID
	 * @return 标签值列表
	 */
	public Map<Long, List<TagValueInfoBean>> getTagValueListByTagId(final List<Long> tagProductId,
																	final Boolean isDelete);

	/**
	 * 根据分类获取多个标签值列表
	 *
	 * @param categoryId
	 *            分类ID
	 * @return 标签值列表
	 */
	public List<TagValueInfoBean> getTagValueListByCategoryId(final List<Long> categoryId, final Boolean isDelete);

	/**
	 * 根据标签ID获取<b>第一层</b>子标签组对象列表
	 *
	 * @param tagProductId
	 *            标签ID
	 * @return 子标签对象列表
	 */
	public List<TagGroupInfoBean> getTagGroupOneChildListByTagId(final Long tagProductId, final Boolean isDelete);

	/**
	 * 根据标签ID获取<b>第一层、第二层</b>子标签组对象列表
	 *
	 * @param tagProductId
	 *            标签ID
	 * @return 子标签对象列表
	 */
	public List<TagGroupInfoBean> getTagGroupTwoChildListByTagId(final Long tagProductId, final Boolean isDelete);

	/**
	 * 根据标签ID获取<b>所有级联</b>子标签组对象列表
	 *
	 * @param tagProductId
	 *            标签ID
	 * @return 子标签对象列表
	 */
	public List<TagGroupInfoBean> getTagGroupAllChildListByTagId(final Long tagProductId, final Boolean isDelete);

	/**
	 * 根据标签ID获取<b>第一层</b>子标签组对象树
	 *
	 * @param tagProductId
	 *            标签ID
	 * @return 子标签对象树
	 */
	public List<TagGroupTreeNodeBean> getTagGroupOneChildTreeByTagId(final Long tagProductId, final Boolean isDelete);

	/**
	 * 根据标签ID获取<b>第一层、第二层</b>子标签组对象树
	 *
	 * @param tagProductId
	 *            标签ID
	 * @return 子标签对象树
	 */
	public List<TagGroupTreeNodeBean> getTagGroupTwoChildTreeByTagId(final Long tagProductId, final Boolean isDelete);

	/**
	 * 根据标签ID获取<b>所有级联</b>子标签组对象树
	 *
	 * @param tagProductId
	 *            标签ID
	 * @return 子标签对象树
	 */
	public List<TagGroupTreeNodeBean> getTagGroupAllChildTreeByTagId(final Long tagProductId, final Boolean isDelete);

	/**
	 * 检索标签列表可反映
	 *
	 * @param params
	 *            检索参数
	 * @return 检索结果
	 */
	public PageInfo<TagInfoBean> searchList(Map<String, String[]> params);

	/**
	 * 保存标签信息
	 *
	 * @param tagInfoBean
	 *            保存的标签信息
	 * @return 保存的标签ID
	 */
	public Long saveTag(TagInfoBean tagInfoBean);

	/**
	 * 删除标签信息
	 *
	 * @param ids
	 *            删除标签ID集
	 * @return 删除记录数
	 */
	public Integer deleteTag(String ids);

	/**
	 * 根据多个标签ID获取标签信息对象
	 *
	 * @param tagProductId
	 *            标签组ID（type：01）
	 * @param systemCode
	 *            系统code
	 * @param isGroup
	 *            是否查询标签组【true:只查询标签组 ;false:只查询标签值 ;null:查询所有】
	 * @return List<TagInfoBean>
	 */
	public List<TagInfoBean> queryTagInfoByTagProductId(final List<Long> tagProductId, final String systemCode,
														final Boolean isGroup, final Boolean isDelete);

}
