package cn.faury.fwmf.module.api.user.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fwmf.module.api.user.bean.UserGroupsInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 推送用户群关联
 */
public interface PushRUserGroupsService {

    /**
     * 根据推送信息ID查询推送用户群信息
     *
     * @param messageIds
     *            多个推送信息ID
     * @return
     */
    @Read
    public List<UserGroupsInfoBean> getUserGroupsInfoByMessageId(final List<Long> messageIds);

    /**
     * 根据推送信息ID查询推送用户群信息
     *
     * @param messageId
     *            推送信息ID
     * @return
     */
    @Read
    default public List<UserGroupsInfoBean> getUserGroupsInfoByMessageId(final Long messageId){
        List<Long> messageIds = new ArrayList<>();
        messageIds.add(messageId);
        return getUserGroupsInfoByMessageId(messageIds);
    }

}
