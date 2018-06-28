package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.user.bean.RedRUserGroupsBean;
import cn.faury.fwmf.module.api.user.service.RedRUserGroupsService;
import cn.faury.fwmf.module.service.user.mapper.RedRUserGroupsMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 红包、用户组关联
 */
public class RedRUserGroupsServiceImpl implements RedRUserGroupsService {

	/**
	 * 数据库操作器
	 */
	protected CommonDao commonDao;

    public RedRUserGroupsServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
	public PageInfo<RedRUserGroupsBean> queryRedRUserGroupsByRedId(final Map<String, Object> parameter) {
		AssertUtil.assertNotEmpty(parameter,"红包ID不可以为空");
		AssertUtil.assertNotNull(parameter.get("redId"),"红包ID错误");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("redId", parameter.get("redId"));
		String state = RedRUserGroupsMapper.class.getName() + ".queryRedRUserGroupsByRedId";
		return this.commonDao.selectPage(state, param, PageParam.buildDefaultIns(parameter));
	}

	@Override
	public PageInfo<RedRUserGroupsBean> queryRedUnRUserGroupsByRedId(final Map<String, Object> parameter) {
		AssertUtil.assertNotEmpty(parameter,"系统ID不可以为空");
		AssertUtil.assertNotNull(parameter.get("systemId"),"系统ID错误");
		Map<String, Object> param = new HashMap<>();
		param.put("systemId", parameter.get("systemId"));
		if (parameter.get("redId")!=null && !parameter.get("redId").equals(0L)) {
			param.put("redId", parameter.get("redId"));
		}
		if (StringUtil.isNotEmpty((String) parameter.get("userGroupName"))) {
			param.put("userGroupName", parameter.get("userGroupName"));
		}

		String state = RedRUserGroupsMapper.class.getName() + ".queryRedUnRUserGroupsByRedId";
		return this.commonDao.selectPage(state, param, PageParam.buildDefaultIns(parameter));
	}

	@Override
	public Integer insert(List<RedRUserGroupsBean> list) {
		AssertUtil.assertNotEmpty(list,"参数不可以为空");
		list.forEach(bean->{
			AssertUtil.assertTrue(bean.getRedId()!=null&&bean.getRedId()>0,"优惠ID为空或不存在");
			AssertUtil.assertTrue(bean.getGroupId()!=null&&bean.getGroupId()>0,"用户群ID为空或不存在");
		});
		String state = RedRUserGroupsMapper.class.getName() + ".insert";
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("list", list);
		int res = this.commonDao.insert(state, parameter);
		return res;
	}

	@Override
	public Integer delByIds(List<Long> ids) {
		AssertUtil.assertNotEmpty(ids,"删除主键为空或不存在");
		String state = RedRUserGroupsMapper.class.getName() + ".del";
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("ids", ids);
		int res = this.commonDao.delete(state, parameter);
		return res;
	}

	@Override
	public Integer delByRedId(List<Long> redIds) {
		AssertUtil.assertNotEmpty(redIds,"优惠ID为空或不存在");
		String state = RedRUserGroupsMapper.class.getName() + ".del";
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("redIds", redIds);
		int res = this.commonDao.delete(state, parameter);
		return res;
	}

	@Override
	public Integer delByRedId(Long redId, List<Long> groupIds) {
		AssertUtil.assertTrue(redId!=null&&redId>0,"优惠ID为空或不存在");
		AssertUtil.assertNotEmpty(groupIds,"用户群ID为空或不存在");
		String state = RedRUserGroupsMapper.class.getName() + ".del";
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("redId", redId);
		parameter.put("groupIds", groupIds);
		int res = this.commonDao.delete(state, parameter);
		return res;
	}
}
