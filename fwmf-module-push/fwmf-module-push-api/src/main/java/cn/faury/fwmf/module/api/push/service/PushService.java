package cn.faury.fwmf.module.api.push.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fwmf.module.api.push.bean.PushInfoBean;
import cn.faury.fwmf.module.api.push.config.PushConfig;
import cn.faury.fwmf.module.api.push.config.PushMessageState;
import cn.faury.fwmf.module.api.push.config.PushResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推送服务
 */
public interface PushService {

	/**
	 * 
	 * 保存推送任务信息 *
	 * 
	 * <pre>
	 * 【必填】messageTitle  任务标题
	 * 【可选】messageIntroduction 简介            
	 * 【必填】pushDate 推送时间 前    可为空
	 * 【必填】endDate 推送时间 后    可为空
	 * 【必填】state 推送类型状态[ 1：保存 2：待审核 3：待推送 4：已推送 5：停用]
	 * 【必填】type   类型 [0：普通，1：微阅读]
	 * 【必填】pushType  推送类型：    [1:全部 2:指定用户群 3:固定用户（未登录用户）4.指定用户]
	 * 【必填】delFlag   删除标识【必选】
	 * 【必填】sysId  系统id
	 * 【必填】isApnsProductionIOS 推送是否正式版（默认1）
	 * 【必填】 timeToLive 离线消息保留时常（秒）
	 * 【必填】 appIds 推送APP
	 * 【必填】 messageContent 推送内容
	 * 【必填】userIds 推送用户Id集
	 * 【可选】pushGoodsIds推送商品id集
	 * createPerson、createTime、updatePerson、updateTime
	 * 
	 * </pre>
	 * 
	 * @param pushbean
	 *            推送信息
	 */
	@Write
	public Long savePushMessageInfo(final PushInfoBean pushbean);

	/**
	 * 通过条件查询推送信息
	 * 
	 * @param userId
	 *            【必填】用户ID
	 * @param systemCode
	 *            【可选】系统code
	 * @param appCode
	 *            【必填】appCode
	 * @param isRead
	 *            【可选】是否已读
	 * @param isPush
	 *            【可选】用户是否获取(查询后修改、添加)
	 * @param pushTime
	 *            【可选】推送时间
	 * @param pageParam
	 *            【必填】分页参数
	 * @return PageResult<PushInfoBean>
	 */
	@Write
	public PageInfo<PushInfoBean> queryPushMessage(final Long userId, final String systemCode, final String appCode,
												   final Boolean isRead, final Boolean isPush, final String pushTime, final PageParam pageParam);

	/**
	 * 阅读消息
	 *
	 * @param userId
	 *            用户ID
	 * @param messageId
	 *            消息ID
	 * @param appCode
	 *            appCode
	 * @param systemCode
	 *            系统code
	 * @return PushInfoBean
	 */
	@Write
	public PushInfoBean readMessage(final Long userId, final Long messageId, final String appCode,
                                    final String systemCode);

	/**
	 * 开始推送
	 * 
	 * @param messageId
	 *            推送信息ID
	 * @param systemCode
	 *            业务系统编码
	 * @param option
	 *            推送选项
	 * 
	 * @return 执行结果
	 */
	@Write
	public PushResult startPush(final Long messageId, final String systemCode, final PushConfig option);

	/**
	 * 用户删除推送消息
	 * 
	 * @param userId
	 *            用户ID
	 * @param appCode
	 *            appCode
	 * @param messageId
	 *            消息ID
	 * @return 删除的条数
	 */
	@Write
	public int deleteMessageByUserId(final Long userId, final String appCode, final Long messageId);

	/**
	 * 用户删除所有推送消息
	 * 
	 * @param userId
	 *            【必填】用户ID
	 * @param appCode
	 *            【必填】appCode
	 */
	@Write
	public void deleteAllMessageByUserId(final Long userId, final String appCode);

	/**
	 * 获取未阅读消息数量
	 * 
	 * @param userId
	 * @param appCode
	 * @return
	 */
	@Read
	public int getUnReadMessageCount(final Long userId, final String appCode);



	/**
	 * 根据推送信息Id 查询推送信息
	 *
	 * @param messageId
	 *            推送消息Id 【必选】
	 * @return 消息对象
	 */
	@Read
	public PushInfoBean getPushMessageInfoById(final Long messageId);

	/**
	 * 根据推送推送标题，开始推送时间、截止推送时间获取推送信息
	 *
	 * <pre>
	 * <b>可选参数</b>：
	 * 【必填】sysId 系统ID
	 * 【可选】messageTitle 任务标题 模糊查询
	 * 【可选】pushDate 推送时间 前
	 * 【可选】endDate 推送时间 后
	 * 【可选】state 推送类型状态[ 1：保存 2：待审核 3：待推送 4：已推送 5：停用]
	 * 【可选】type   类型 [0：普通，1：微阅读]
	 * 【可选】pushType  推送类型：    [1:全部 2:指定用户群 3:固定用户（未登录用户）3：指定用户]
	 * </pre>
	 *
	 * @param parameters
	 *            参数信息
	 * @return 推送信息以<b>page</b>的形式返回
	 *
	 */
	@Read
	public PageInfo<PushInfoBean> getPushMessageInfo(final Map<String, String> parameters);

	/**
	 *
	 * 修改推送任务信息 *
	 *
	 * <pre>
	 * messageId 推送消息主键Id【必选】
	 *
	 * messageTitle
	 *            任务标题【必选】
	 * messageIntroduction 简介 【可选】
	 *
	 * pushDate
	 *            推送时间 前【必选】可为空
	 * endDate
	 *            推送时间 后【必选】可为空
	 * page
	 *            页数【必选】 默认1
	 *
	 * state      推送类型状态【必选】[ 1：保存 2：待审核 3：待推送 4：已推送 5：停用]
	 *
	 * type  	      类型 [0：普通，1：微阅读]
	 *
	 * pushType   推送类型：    [1:全部 2:指定用户群 3:固定用户（未登录用户）]
	 *
	 * delFlag    删除标识【必选】
	 * </pre>
	 *
	 * @param pushbean
	 */
	@Write
	public void updatePushMessageInfo(final PushInfoBean pushbean);

	/**
	 * 修改推送 state信息. <br/>
	 *
	 * @param messageId
	 *            推送id
	 * @param state
	 *            状态值
	 */
	@Write
	public void setPushMessageState(final Long messageId, final int state);

	/**
	 * 推送信息停用（物理设置推送状态为停用）
	 *
	 * @param messageId
	 *            推送id
	 */
	@Write
	public default void disablePushMessage(final Long messageId){
        setPushMessageState(messageId, PushMessageState.DISABLED.value());
    }

	// ============================重载

	/**
	 * 获取时间段推送消息
	 *
	 * @param pushDate
	 *            开始推送时间
	 * @param endDate
	 *            截止推送时间
	 * @return 查询时间段推送消息 分页展示
	 */
	@Read
	public default PageInfo<PushInfoBean> getPushMessageInfo(final String pushDate, final String endDate){
        Map<String, String> map = new HashMap<>();
        map.put("pushDateStart", pushDate);
        map.put("pushDateEnd", endDate);
        return getPushMessageInfo(map);
    }

	/**
	 * 根据推送消息Id 删除推送信息
	 *
	 * @param messageId
	 *            推送信息ID
	 * @return
	 */
	@Write
	public Long deletePushMessageInfoByMId(final Long messageId);

	/**
	 * 查询推送信息
	 *
	 * @param param
	 *            查询参数
	 * @return 查询结果
	 */
	@Read
	public List<PushInfoBean> queryPushMessage(final Map<String, Object> param);

	/**
	 * 插入read表（全部、固定用户已读表）
	 *
	 * <pre>
	 * 【必填】userId 用户ID
	 * 【必填】messageId 消息ID
	 * 【必填】appId APPID
	 * 【必填】sysId 系统ID
	 * 【可选，默认：N】isRead 是否已读
	 * 【可选，默认：now（）】readTime 阅读时间
	 * 【可选，默认：now（）】pushTime 推送获取时间
	 * 【可选，默认：‘0’】delFlag 删除标志
	 * </pre>
	 *
	 * @param listBean
	 * @return
	 */
	@Write
	public int insertMessageRead(final List<PushInfoBean> listBean);

	/**
	 * 指定用户、用户群用户删除推送消息
	 *
	 * @param userId
	 *            用户ID
	 * @param appCode
	 *            appCode
	 * @param messageId
	 *            消息ID
	 * @return
	 */
	@Write
	public int delMessageReceive(final Long userId, final String appCode, final Long messageId);

	/**
	 * 已阅读全部用户、固定用户删除推送消息
	 *
	 * @param userId
	 *            用户ID
	 * @param appCode
	 *            appCode
	 * @param messageId
	 *            消息ID
	 * @return
	 */
	@Write
	public int delMessageRead(final Long userId, final String appCode, final Long messageId);

	/**
	 * 未阅读全部用户、固定用户删除推送消息
	 *
	 * @param userId
	 *            用户ID
	 * @param appId
	 *            APPID
	 * @param sysId
	 *            系统ID
	 * @param messageId
	 *            消息ID
	 * @return
	 */
	@Write
	public int insertDelMessageRead(final Long userId, final Long appId, final Long sysId, final Long messageId);

	/**
	 * 查询（全部、固定用户）消息是否获取
	 *
	 * @param userId
	 *            用户ID
	 * @param appCode
	 *            appCode
	 * @param messageId
	 *            消息ID
	 * @return
	 */
	@Read
	public PushInfoBean getMessageReadByUserId(final Long userId, final String appCode, final Long messageId);

	/**
	 *
	 *
	 * @param userId
	 * @param messageId
	 * @return
	 */
	/**
	 * 用户获取消息（用户群、指定用户）
	 *
	 * <pre>
	 *  【必填】userId 用户ID
	 *  【必填】messageId 消息ID
	 * </pre>
	 *
	 * @param listBean
	 * @return
	 */
	@Write
	public int updateGetMessageReceive(final List<PushInfoBean> listBean);

	/**
	 * 用户获取消息（全部、固定用户）
	 *
	 * <pre>
	 * 【必填】userId 用户ID
	 * 【必填】appId APPID
	 * 【必填】sysId 系统ID
	 * 【必填】messageId 消息ID
	 * </pre>
	 *
	 * @return
	 */
	@Write
	public int insertGetMessageRead(final List<PushInfoBean> listBean);

	/*
	*//**
	 * 查询（全部、固定用户）是否阅读消息
	 *
	 * @param userId
	 *            用户ID
	 * @param appId
	 *            APPID
	 * @param messageId
	 *            消息ID
	 * @return
	 */
	/*
	 * @Read public Boolean isMessageReadExist(final Long userId, final Long
	 * appId, final Long messageId);
	 */
	/**
	 * 更新（全部、固定）用户信息阅读表
	 *
	 * <pre>
	 * 【必填】userId 用户id
	 * 【可选】appId/appCode APP ID/编码
	 * 【必填】messageId 消息ID
	 * 【可选】sysId/sysCode 系统ID/编码
	 * </pre>
	 *
	 * @param param
	 * @return
	 */
	@Write
	public int updateMessageRead(final Map<String, Object> param);

	/**
	 * 根据用户ID将已获取的用户阅读记录设为删除（全部、固定用户）
	 *
	 * @param userId
	 *            用户ID
	 * @param messageIds
	 *            已获取的信息
	 * @return
	 */
	@Write
	public int delMessageReadByUserId(final Long userId, final List<Long> messageIds);

	/**
	 * 根据用户ID将已获取的用户阅读记录设为删除（指定用户、用户群）
	 *
	 * @param userId
	 *            用户ID
	 * @param messageIds
	 *            已获取的信息
	 * @return
	 */
	@Write
	public int delMessageReceiveByUserId(final Long userId, final List<Long> messageIds);

	/**
	 * 获取用户上次查看消息时间
	 *
	 * @param userId
	 *            用户ID
	 * @param appCode
	 * @return
	 */
	@Read
	public String getLastPushTime(final Long userId, final String appCode);

}
