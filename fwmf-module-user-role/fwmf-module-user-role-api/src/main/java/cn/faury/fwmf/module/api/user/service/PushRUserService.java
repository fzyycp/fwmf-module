package cn.faury.fwmf.module.api.user.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fwmf.module.api.user.bean.UserListBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 推送用户关联
 */
public interface PushRUserService {

    /**
     * 根据推送信息ID查询推送用户信息
     *
     * @param messageIds
     *            多个推送信息ID
     * @return
     */
    @Read
    public List<UserListBean> getUserInfoByMessageId(final List<Long> messageIds);

    /**
     * 根据推送信息ID查询推送用户信息
     *
     * @param messageId
     *            推送信息ID
     * @return
     */
    @Read
    default public List<UserListBean> getUserInfoByMessageId(final Long messageId){
        List<Long> messageIds = new ArrayList<Long>();
        messageIds.add(messageId);
        return getUserInfoByMessageId(messageIds);
    }

}
