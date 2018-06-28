package cn.faury.fwmf.module.service.user.service;

import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.user.bean.UserListBean;
import cn.faury.fwmf.module.api.user.service.PushRUserService;
import cn.faury.fwmf.module.service.user.mapper.PushRUserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推送用户关联
 */
public class PushRUserServiceImpl implements PushRUserService {

	/**
	 * 数据库操作器
	 */
	protected CommonDao commonDao;

	public PushRUserServiceImpl(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	@Override
	public List<UserListBean> getUserInfoByMessageId(List<Long> messageIds) {
		AssertUtil.assertNotEmpty(messageIds,"参数推送id为空或不存在");
		String state = PushRUserMapper.class.getName() + ".getUserInfoByMessageId";
		Map<String, Object> parameter = new HashMap<String, Object>();
		parameter.put("messageIds", messageIds);
		return this.commonDao.selectList(state, parameter);
	}
}
