package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.user.bean.UserGroupsInfoBean;
import cn.faury.fwmf.module.api.user.service.PushRUserGroupsService;
import cn.faury.fwmf.module.service.user.mapper.PushRUserGroupsMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推送用户群关联
 */
public class PushRUserGroupsServiceImpl implements PushRUserGroupsService {

	/**
	 * 数据库操作器
	 */
	protected CommonDao commonDao;

    public PushRUserGroupsServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
	public List<UserGroupsInfoBean> getUserGroupsInfoByMessageId(List<Long> messageIds) {
	    AssertUtil.assertNotEmpty(messageIds,"参数推送id为空或不存在");
		String state = PushRUserGroupsMapper.class.getName() + ".getUserGroupsInfoByMessageId";
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("messageIds", messageIds);
		return this.commonDao.selectList(state, parameter);
	}
}
