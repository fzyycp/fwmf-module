package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.user.bean.DiscusRUserGroupsBean;
import cn.faury.fwmf.module.api.user.service.DiscusRUserGroupsService;
import cn.faury.fwmf.module.service.user.mapper.DiscusRUserGroupsMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 优惠、用户组关联服务提供者
 */
public class DiscusRUserGroupsServiceImpl implements DiscusRUserGroupsService {

	/**
	 * 数据库操作器
	 */
	protected CommonDao commonDao;

    public DiscusRUserGroupsServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
	public PageInfo<DiscusRUserGroupsBean> queryDiscusRUserGroupsByDiscusId(final Map<String, Object> parameter) {
		AssertUtil.assertNotNull(parameter,"优惠ID不可以为空");
		AssertUtil.assertNotNull(parameter.get("discusId"),"优惠ID错误");
		PageParam pageParam = PageParam.buildDefaultIns(parameter);
		Map<String, Object> param = new HashMap<>();
		param.put("discusId", parameter.get("discusId"));
		String state = DiscusRUserGroupsMapper.class.getName() + ".queryDiscusRUserGroupsByDiscusId";
		return this.commonDao.selectPage(state, param, pageParam);
	}

	@Override
	public PageInfo<DiscusRUserGroupsBean> queryDiscusUnRUserGroupsByDiscusId(final Map<String, Object> parameter) {
        AssertUtil.assertNotNull(parameter,"系统ID不可以为空");
        AssertUtil.assertNotNull(parameter.get("systemId"),"系统ID错误");
        PageParam pageParam = PageParam.buildDefaultIns(parameter);
		Map<String, Object> param = new HashMap<>();
		param.put("systemId", parameter.get("systemId"));
		if (parameter.get("discusId")!=null && !parameter.get("discusId").equals(0L)) {
			param.put("discusId", parameter.get("discusId"));
		}
		if (StringUtil.isNotEmpty((String) parameter.get("userGroupName"))) {
			param.put("userGroupName", parameter.get("userGroupName"));
		}

		String state = DiscusRUserGroupsMapper.class.getName() + ".queryDiscusUnRUserGroupsByDiscusId";
		return this.commonDao.selectPage(state, param, pageParam);
	}

    @Override
    public Integer insert(List<DiscusRUserGroupsBean> list) {
        AssertUtil.assertNotEmpty(list,"要保存的优惠用户组信息为空");
	    list.forEach(bean->{
	        AssertUtil.assertTrue(bean.getDiscusId()!=null&&bean.getDiscusId()>0,"优惠ID为空");
	        AssertUtil.assertTrue(bean.getGroupId()!=null&&bean.getGroupId()>0,"用户群ID为空");
        });
        String state = DiscusRUserGroupsMapper.class.getName() + ".insert";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("list", list);
        int res = this.commonDao.insert(state, parameter);
        return res;
    }

    @Override
    public Integer delByIds(List<Long> ids) {
        AssertUtil.assertTrue(ids!=null&&ids.size()>0,"删除主键为空或不存在");
        String state = DiscusRUserGroupsMapper.class.getName() + ".del";
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("ids", ids);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    @Override
    public Integer delByDiscusId(List<Long> discusIds) {
        AssertUtil.assertTrue(discusIds!=null&&discusIds.size()>0,"优惠ID为空或不存在");
        String state = DiscusRUserGroupsMapper.class.getName() + ".del";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("discusIds", discusIds);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }

    @Override
    public Integer delByDiscusId(Long discusId, List<Long> groupIds) {
        AssertUtil.assertTrue(discusId!=null&&discusId>0,"优惠ID为空或不存在");
        AssertUtil.assertTrue(groupIds!=null&&groupIds.size()>0,"用户群ID为空或不存在");
        String state = DiscusRUserGroupsMapper.class.getName() + ".del";
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("discusId", discusId);
        parameter.put("groupIds", groupIds);
        int res = this.commonDao.delete(state, parameter);
        return res;
    }
}
