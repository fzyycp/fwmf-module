package cn.faury.fwmf.module.service.push.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.push.bean.PushInfoBean;
import cn.faury.fwmf.module.service.constant.DBConstOfPush;
import cn.faury.fwmf.module.service.push.sqlProvider.PushSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 推送信息表Mapper
 * 
 * @author cc.xue
 *
 */
@AutoScannedMapper
public interface PushMapper {

	/**
	 * 根据：任务标题 、 推送时间 前、推送时间 后 、 任务状态、行数、页数 、对象类型 查询推送列表的推送信息
	 * 
	 * <pre>
	 * messageTitle 任务标题【必选】 模糊查询
	 * pushDateStart 推送时间 前【必选】可为空
	 * pushDateEnd 推送时间 后【必选】可为空
	 * state 任务状态【必选】可为空
	 * typeCode 对象类型【必选】可为空
	 * rows 行数【必选】
	 * page 页数【必选】
	 * </pre>
	 * 
	 * @return 查询结果
	 */
	@SelectProvider(method = "queryPushInfo", type = PushSqlProvider.class)
	@Results({ @Result(property = "messageTitle", column = "MESSAGE_TITLE"),
	        @Result(property = "messageId", column = "MESSAGE_ID"),
	        @Result(property = "messageIntroduction", column = "MESSAGE_INTRODUCTION"),
	        @Result(property = "pushDate", column = "PUSH_DATE"), @Result(property = "endDate", column = "END_DATE"),
	        @Result(property = "type", column = "TYPE_CODE"), @Result(property = "pushType", column = "PUSH_TYPE"),
	        @Result(property = "readCount", column = "READ_COUNT"),
	        @Result(property = "pushCount", column = "PUSH_COUNT"),
	        @Result(property = "totalCount", column = "TOTAL_COUNT"), @Result(property = "state", column = "STATE") })
	public List<PushInfoBean> queryPushInfo(final Map<String, Object> pargram);

	@SelectProvider(method = "queryPushMessage", type = PushSqlProvider.class)
	@ResultType(PushInfoBean.class)
	public List<PushInfoBean> queryPushMessage(final Map<String, Object> pargram);

	/**
	 * 根据messageId 查询推送内容信息
	 */
	@Select("SELECT PMI.MESSAGE_ID AS messageId,MESSAGE_TITLE AS messageTitle,"
	        + " MESSAGE_CONTENT messageContent,MESSAGE_INTRODUCTION AS messageIntroduction,"
	        + "	PUSH_DATE AS pushDate,END_DATE AS endDate,STATE,TYPE,CREATE_TIME AS createTime,"
	        + "	UPDATE_TIME AS updateTime,PUSH_TYPE AS pushType,SYS_ID as sysId FROM "
	        + DBConstOfPush.TN_PUSH_MESSAGE_INFO + " PMI JOIN " + DBConstOfPush.TN_PUSH_MESSAGE_CONTENT_INFO
	        + " PMCI ON PMI.MESSAGE_ID = PMCI.MESSAGE_ID WHERE STATE= '3' ")
	// 获取待推送状态的推送信息
	@ResultType(PushInfoBean.class)
	public PushInfoBean getPushMessageInfo();

	/**
	 * 根据messageId 查询推送内容信息
	 * 
	 * @param messageId
	 * @return
	 */
	@Select("SELECT PMI.MESSAGE_ID AS messageId,PA.APP_ID appId,MESSAGE_TITLE AS messageTitle, MESSAGE_CONTENT messageContent,MESSAGE_INTRODUCTION AS messageIntroduction,"
	        + "	PUSH_DATE AS pushDate,END_DATE AS endDate,STATE,TYPE,IS_APNS_PRODUCTION isApnsProduction,TIME_TO_LIVE timeToLive,PMI.CREATE_TIME AS createTime,	PMI.UPDATE_TIME AS updateTime,PMI.PUSH_TYPE AS pushType,PMI.SYS_ID as sysId,GROUP_CONCAT(g.CODE_NUMBER) codeNumber"
	        + " FROM "
	        + DBConstOfPush.TN_PUSH_MESSAGE_INFO
	        + " PMI JOIN "
	        + DBConstOfPush.TN_PUSH_MESSAGE_CONTENT_INFO
	        + " PMCI ON PMI.MESSAGE_ID = PMCI.MESSAGE_ID "
	        + "JOIN "
	        + DBConstOfPush.TN_PUSH_R_APP
	        + " PA ON PMI.MESSAGE_ID = PA.MESSAGE_ID "
	        + "JOIN "
	        + DBConstOfPush.TN_APP_INFO
	        + " A ON PA.APP_ID=A.APP_ID  "
	        + " LEFT JOIN "
	        + DBConstOfPush.TN_PUSH_MESSAGE_GOODS
	        + " MG ON PMI.MESSAGE_ID = MG.MESSAGE_ID "
	        + " LEFT JOIN "
	        + DBConstOfPush.TN_GOODS_INFO
	        + " G ON MG.GOODS_ID = G.GOODS_ID"
	        + " WHERE PMI.MESSAGE_ID = #{messageId} GROUP BY PMI.MESSAGE_ID ")
	@ResultType(PushInfoBean.class)
	public PushInfoBean getPushInfoByMId(final Long messageId);

	/**
	 * 修改推送信息,修改del_flag为1
	 * 
	 * @return Integer
	 */
	@Update("UPDATE "
	        + DBConstOfPush.TN_PUSH_MESSAGE_INFO
	        + "  SET MESSAGE_TITLE = #{messageTitle}, MESSAGE_INTRODUCTION =#{messageIntroduction},PUSH_DATE = #{pushDate},END_DATE=#{endDate},STATE =#{state},"
	        + "TYPE =#{type},PUSH_TYPE=#{pushType},SYS_ID =#{sysId},IS_APNS_PRODUCTION=#{isApnsProduction},TIME_TO_LIVE=#{timeToLive} WHERE MESSAGE_ID = #{messageId}")
	public Integer updatePushMsg(final PushInfoBean bean);

	/**
	 * 修改推送 state信息. <br/>
	 * 
	 * @param messageId
	 *            推送消息ID
	 * @param state
	 *            状态值
	 * @return Integer
	 */
	@Update("UPDATE " + DBConstOfPush.TN_PUSH_MESSAGE_INFO
	        + " SET STATE= #{state} WHERE MESSAGE_ID = #{messageId}  ")
	public Integer setPushMessageState(final Long messageId, final int state);

	/**
	 * 删除. <br/>
	 * 
	 * @return Integer
	 */
	@Update("UPDATE " + DBConstOfPush.TN_PUSH_MESSAGE_INFO + " SET DEL_FLAG= 1 WHERE MESSAGE_ID = #{messageId}  ")
	public Integer deletePushMessageInfo(final Long messageId);

	/**
	 * 根据messageId 查找出这条记录
	 * 
	 * @param messageId
	 * @return PushInfoBean
	 */
	@Select("SELECT MESSAGE_ID FROM T_PUSH_MESSAGE_CONTENT_INFO WHERE MESSAGE_ID= #{messageId}")
	@Results({ @Result(property = "messageId", column = "MESSAGE_ID") })
	public PushInfoBean findFirst(final Long messageId);

	/**
	 * 保存推送信息
	 * 
	 * @param bean
	 *            推送信息
	 * @return
	 */
	@Insert("INSERT INTO "
	        + DBConstOfPush.TN_PUSH_MESSAGE_INFO
	        + " ( MESSAGE_TITLE,MESSAGE_INTRODUCTION,PUSH_DATE,END_DATE,STATE,TYPE,CREATE_PERSON,CREATE_TIME,UPDATE_PERSON,UPDATE_TIME, DEL_FLAG,PUSH_TYPE,SYS_ID,IS_APNS_PRODUCTION,TIME_TO_LIVE) "
	        + " VALUES(#{messageTitle},#{messageIntroduction},#{pushDate},#{endDate},#{state},#{type},#{createPerson},CURRENT_TIMESTAMP,#{updatePerson},CURRENT_TIMESTAMP,'0',#{pushType},#{sysId},#{isApnsProduction},#{timeToLive})")
	@Options(useGeneratedKeys = true, keyProperty = "messageId")
	public Long insertPushMessageInfo(final PushInfoBean bean);

	/**
	 * 
	 * 新增推送信息内容
	 * 
	 * @author cc.xue
	 * @param bean
	 *            推送任务 bean.messageContent 推送内容
	 * @return 更新条数
	 */
	@Insert("INSERT INTO " + DBConstOfPush.TN_PUSH_MESSAGE_CONTENT_INFO
	        + " (MESSAGE_ID,MESSAGE_CONTENT) VALUES (#{messageId},#{messageContent})")
	public Long insertPushMsgContent(final PushInfoBean bean);

	/**
	 * 插入推送信息阅读表（全部用户、固定用户专用）
	 * 
	 * @param param
	 * @return
	 */
	@InsertProvider(method = "insertMessageRead", type = PushSqlProvider.class)
	public int insertMessageRead(Map<String, Object> param);


	/**
	 * 保存app信息
	 * 
	 * @param bean
	 * @return
	 */
	@InsertProvider(type = PushSqlProvider.class, method = "insertAppInfo")
	@Options(useGeneratedKeys = true, keyProperty = "appId")
	public Long insertAppInfo(final PushInfoBean bean);

	/**
	 * 新增推送商品表
	 * 
	 * @param map
	 *            messageId 推送信息ID 【不可为空】 goodsId 商品ID集 【不可为空】
	 * @return Integer
	 **/
	@InsertProvider(type = PushSqlProvider.class, method = "insertPushMessageGoods")
	@Options(useGeneratedKeys = true, keyProperty = "goodsId")
	public Long insertPushMessageGoods(final Map<String, String> map);

	/**
	 * 新增用户
	 * 
	 * @return Integer
	 **/
	@InsertProvider(type = PushSqlProvider.class, method = "insertUser")
	@Options(useGeneratedKeys = true, keyProperty = "uId")
	public Long insertUser(final Map<String, String> map);

	/**
	 * 
	 * 新增推送任务客户群)
	 * 
	 * @return Integer
	 */
	@InsertProvider(type = PushSqlProvider.class, method = "insertUserGroups")
	@Options(useGeneratedKeys = true, keyProperty = "gId")
	public Long insertUserGroups(final PushInfoBean bean);

	/**
	 * 根据messageID删除 T_PUSH_MESSAGE_CONTENT_INFO 表记录
	 * 
	 * @param messageId
	 *            【必选】
	 * @return Integer
	 */
	@Delete("DELETE FROM " + DBConstOfPush.TN_PUSH_MESSAGE_CONTENT_INFO + " WHERE MESSAGE_ID = #{messageId} ")
	public Long delPushMContentInfo(final Long messageId);

	/**
	 * 删除用户
	 * 
	 * @param messageId
	 * @return
	 */
	@Delete("DELETE FROM " + DBConstOfPush.TN_PUSH_R_CUSTOMER_USER + " WHERE MESSAGE_ID = #{messageId}")
	public Long deleteUser(final Long messageId);

	/**
	 * 根据messageId 删除客户群
	 * 
	 * @param messageId
	 * @return boolean
	 */
	@Delete("DELETE FROM " + DBConstOfPush.TN_PUSH_R_CUSTOMER_GROUP + " WHERE MESSAGE_ID = #{messageId} ")
	public Long deleteCustomerGroup(final Long messageId);

	/**
	 * 根据messageId删除商品推送表信息
	 * 
	 * @param messageId
	 *            【不可为空】
	 * @return
	 */
	@Delete("DELETE FROM " + DBConstOfPush.TN_PUSH_MESSAGE_GOODS + " WHERE MESSAGE_ID = #{messageId}")
	public Long deleteGoods(final Long messageId);

	/**
	 * 删除内容
	 * 
	 * @param messageId
	 * @return
	 */
	@Delete("DELETE  FROM " + DBConstOfPush.TN_PUSH_MESSAGE_CONTENT_INFO + " WHERE MESSAGE_ID = #{messageId}")
	public Long deletePushMsgContent(final Long messageId);

	/**
	 * 删除APP
	 * 
	 * @param messageId
	 * @return
	 */
	@Delete("DELETE  FROM " + DBConstOfPush.TN_PUSH_R_APP + " WHERE MESSAGE_ID = #{messageId}")
	public Long deleteAppInfo(final Long messageId);

	/**
	 * 指定用户、用户群用户删除推送消息
	 * 
	 * @param param
	 * @return
	 */
	@Update("UPDATE "
	        + DBConstOfPush.TN_PUSH_MESSAGE_RECEIVE
	        + " SET DEL_FLAG= '1' WHERE MESSAGE_ID = #{messageId} AND USER_ID=#{userId} AND APP_ID = (SELECT APP_ID FROM "
	        + DBConstOfPush.TN_APP_INFO + " WHERE APP_CODE = #{appCode} )")
	public int delMessageReceive(final Map<String, Object> param);

	/**
	 * 已阅读全部用户、固定用户删除推送消息
	 * 
	 * @param param
	 * @return
	 */
	@Update("UPDATE "
	        + DBConstOfPush.TN_PUSH_MESSAGE_READ
	        + " SET DEL_FLAG= '1' WHERE MESSAGE_ID = #{messageId} AND USER_ID=#{userId} AND APP_ID = (SELECT APP_ID FROM "
	        + DBConstOfPush.TN_APP_INFO + " WHERE APP_CODE = #{appCode} )")
	public int delMessageRead(final Map<String, Object> param);

	/**
	 * 未阅读全部用户、固定用户删除推送消息
	 * 
	 * @param bean
	 * @return
	 */
	@Insert("INSERT INTO "
	        + DBConstOfPush.TN_PUSH_MESSAGE_READ
	        + " (MESSAGE_ID,SYS_ID,APP_ID,USER_ID,READ_TIME,DEL_FLAG) VALUES (#{messageId},#{sysId},#{appId},#{userId},now(),'1')")
	public int insertDelMessageRead(final PushInfoBean bean);

	/**
	 * 查询（全部、固定用户）消息是否获取
	 * 
	 * @param param
	 * @return
	 */
	@Select(" SELECT ID id,IS_READ isRead FROM " + DBConstOfPush.TN_PUSH_MESSAGE_READ
	        + " WHERE MESSAGE_ID = #{messageId} AND USER_ID=#{userId} AND APP_ID = (SELECT APP_ID FROM "
	        + DBConstOfPush.TN_APP_INFO + " where  APP_CODE = #{appCode} ) UNION SELECT ID id,IS_READ isRead FROM "
	        + DBConstOfPush.TN_PUSH_MESSAGE_RECEIVE
	        + " WHERE MESSAGE_ID = #{messageId} AND USER_ID=#{userId} AND APP_ID = (SELECT APP_ID FROM "
	        + DBConstOfPush.TN_APP_INFO + " where  APP_CODE = #{appCode} ) ")
	public PushInfoBean getMessageReadByUserId(final Map<String, Object> param);

	/**
	 * 获取用户上次查看消息时间
	 * 
	 * @return
	 */
	@Select(" SELECT PUSH_TIME FROM " + DBConstOfPush.TN_PUSH_MESSAGE_READ
	        + " WHERE USER_ID=#{userId} AND APP_ID = (SELECT APP_ID FROM " + DBConstOfPush.TN_APP_INFO
	        + " where APP_CODE = #{appCode} ) UNION SELECT PUSH_TIME FROM " + DBConstOfPush.TN_PUSH_MESSAGE_RECEIVE
	        + " WHERE USER_ID=#{userId} AND APP_ID = (SELECT APP_ID FROM " + DBConstOfPush.TN_APP_INFO
	        + " where APP_CODE = #{appCode} ) ORDER BY PUSH_TIME desc limit 1 ")
	public String getLastPushTime();

	/**
	 * （指定用户、用户群）用户消息获取 isPush:'y'
	 * 
	 * @param param
	 * @return
	 */
	@UpdateProvider(type = PushSqlProvider.class, method = "updateGetMessageReceive")
	public int updateGetMessageReceive(final Map<String, Object> param);

	/*
	*//**
	 * (固定、全部)用户消息获取 <b>不存在，插入新数据；isRead:n,</b>
	 * 
	 * @param param
	 * @return
	 */
	/*
	 * @UpdateProvider(type = PushSqlProvider.class, method =
	 * "insertGetMessageRead") public int insertGetMessageRead(final Map<String,
	 * Object> param);
	 */

	/**
	 * 更新（全部、固定）用户信息阅读表
	 * 
	 * @param param
	 * @return
	 */
	@UpdateProvider(type = PushSqlProvider.class, method = "updateMessageRead")
	public int updateMessageRead(Map<String, Object> param);

	/**
	 * 阅读消息
	 * 
	 * @param param
	 * @return
	 */
	@UpdateProvider(type = PushSqlProvider.class, method = "readMessageReceive")
	public int readMessageReceive(final Map<String, Object> param);

	/**
	 * 删除（用户、用户群）用户信息
	 * 
	 * @param param
	 * @return
	 */
	@UpdateProvider(type = PushSqlProvider.class, method = "delMessageReceiveByUserId")
	public int delMessageReceiveByUserId(Map<String, Object> param);

	/**
	 * 删除（全部、固定）用户信息
	 * 
	 * @param param
	 * @return
	 */
	@UpdateProvider(type = PushSqlProvider.class, method = "delMessageReadByUserId")
	public int delMessageReadByUserId(Map<String, Object> param);

	/**
	 * 更新消息已阅读人数
	 * 
	 * @param messageId
	 * @return
	 */
	@Update("update " + DBConstOfPush.TN_PUSH_MESSAGE_COUNT
	        + " set  READ_COUNT = CAST(READ_COUNT AS signed) + 1 WHERE MESSAGE_ID = #{messageId} ")
	public int updateMessageCount(Long messageId);

}
