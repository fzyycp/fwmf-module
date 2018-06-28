package cn.faury.fwmf.module.service.user.service;


import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.user.bean.UserListBean;
import cn.faury.fwmf.module.api.user.service.SystemRUserService;
import cn.faury.fwmf.module.service.user.mapper.SystemRUserMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统用户服务
 */
public class SystemRUserServiceImpl implements SystemRUserService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public SystemRUserServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public PageInfo<UserListBean> getUserInfoList(PageParam pageParam, Map<String, Object> param) {
        if (param == null) {
            param = new HashMap<>();
        } else {
            if (StringUtil.isEmpty((String) param.get("systemCode"))) {
                param.remove("systemCode");
            }
            if (StringUtil.isEmpty((String) param.get("loginName"))) {
                param.remove("loginName");
            }
            if (StringUtil.isEmpty((String) param.get("startTime"))) {
                param.remove("startTime");
            }
            if (StringUtil.isEmpty((String) param.get("endTime"))) {
                param.remove("endTime");
            }
            if (param.get("userTypeList") == null) {
                param.remove("userTypeList");
            }
        }

        String state = SystemRUserMapper.class.getName() + ".getUserInfoList";
        if (pageParam != null) {
            return this.commonDao.selectPage(state, param, pageParam);
        } else {
            List<UserListBean> pageList = this.commonDao.selectList(state, param);
            return new PageInfo<>(pageList);
        }
    }
}
