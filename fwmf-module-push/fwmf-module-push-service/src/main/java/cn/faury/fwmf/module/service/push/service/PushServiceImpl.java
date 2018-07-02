package cn.faury.fwmf.module.service.push.service;

import cn.faury.fdk.common.anotation.service.CanReadWrite;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.db.PageParam;
import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.StringUtil;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.push.bean.PushInfoBean;
import cn.faury.fwmf.module.api.push.config.PushConfig;
import cn.faury.fwmf.module.api.push.config.PushMessageState;
import cn.faury.fwmf.module.api.push.config.PushResult;
import cn.faury.fwmf.module.api.push.config.PushTool;
import cn.faury.fwmf.module.api.push.service.PushService;
import cn.faury.fwmf.module.service.push.mapper.PushMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CanReadWrite
public class PushServiceImpl implements PushService {

    /**
     * 数据库操作器
     */
    protected CommonDao commonDao;

    public PushServiceImpl(CommonDao commonDao) {
        this.commonDao = commonDao;
    }

    @Override
    public PageInfo<PushInfoBean> getPushMessageInfo(Map<String, String> parameter) {
        PageParam pageParam = PageParam.buildDefaultIns(parameter);
        String statement = PushMapper.class.getName() + ".queryPushInfo";
        return this.commonDao.selectPage(statement, parameter, pageParam);
    }

    /**
     * 根据MessageID查询推送的信息
     */
    @Override
    public PushInfoBean getPushMessageInfoById(Long messageId) {
        String statement = PushMapper.class.getName() + ".getPushInfoByMId";
        return this.commonDao.selectOne(statement, messageId);
    }

    @Override
    public List<PushInfoBean> queryPushMessage(Map<String, Object> param) {
        String state = PushMapper.class.getName() + ".queryPushMessage";
        return this.commonDao.selectList(state, param);
    }

    @Override
    public PushInfoBean getMessageReadByUserId(Long userId, String appCode, Long messageId) {
        AssertUtil.assertTrue(userId != null && userId >= 0, "用户ID为空或不存在");
        AssertUtil.assertTrue(messageId != null && messageId >= 0, "消息ID为空或不存在");
        AssertUtil.assertNotEmpty(appCode, "app编码为空或不存在");
        Map<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        param.put("messageId", messageId);
        param.put("appCode", appCode);
        String state = PushMapper.class.getName() + ".getMessageReadByUserId";
        return this.commonDao.selectOne(state, param);
    }

    @Override
    public String getLastPushTime(Long userId, String appCode) {
        AssertUtil.assertTrue(userId != null && userId >= 0, "用户ID为空或不存在");
        AssertUtil.assertNotEmpty(appCode, "app编码为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("appCode", appCode);
        String state = PushMapper.class.getName() + ".getLastPushTime";
        return this.commonDao.selectOne(state, param);
    }

    @Override
    public int getUnReadMessageCount(Long userId, String appCode) {
        Map<String, Object> param = new HashMap<String, Object>();
        AssertUtil.assertTrue(userId != null && userId >= 0, "用户ID为空或不存在");
        AssertUtil.assertNotEmpty(appCode, "app编码为空或不存在");
        param.put("userId", userId);
        param.put("appCode", appCode);
        param.put("isRead", Boolean.FALSE);

        String state = PushMapper.class.getName() + ".queryPushMessage";
        List<PushInfoBean> list = this.commonDao.selectList(state, param);
        return list == null ? 0 : list.size();
    }

    @Override
    @Transactional
    public Long savePushMessageInfo(PushInfoBean pushbean) {
        // 1、保存推送信息
        String statement = PushMapper.class.getName() + ".insertPushMessageInfo";
        this.commonDao.insert(statement, pushbean);
        // 类型 （0：普通，1：微阅读）
        Integer type = pushbean.getType();
        if (0 == type) {
            // 2、保存推送内容信息
            statement = PushMapper.class.getName() + ".insertPushMsgContent";
            this.commonDao.insert(statement, pushbean);
        } else if (1 == type) {
            // 3、保存微阅读推送信息
            statement = PushMapper.class.getName() + ".insertPushMessageWebEditor";
            this.commonDao.insert(statement, pushbean);
        }
        // 获得APP
        String[] appId = pushbean.getAppIds().split(",");
        List<Long> appIds = new ArrayList<Long>();
        for (String a : appId) {
            appIds.add(Long.parseLong(a));
        }
        Map<String, Object> paramsApp = new HashMap<String, Object>();
        // 4、保存推送APP信息
        statement = PushMapper.class.getName() + ".insertAppInfo";
        paramsApp.put("messageId", pushbean.getMessageId());
        paramsApp.put("sysId", pushbean.getSysId());
        paramsApp.put("appIds", appIds);
        this.commonDao.insert(statement, paramsApp);
        // 推送类型:1:全部 2:指定用户群 3:固定用户（未登录用户）4：指定用户
        String pushType = pushbean.getPushType();
        if ("2".equals(pushType)) { // 用户群
            // 获取指定用户群
            String[] customerGroupId = pushbean.getCustomerGroupIds().split(",");
            Map<String, Object> paramsUserGroups = new HashMap<String, Object>();
            List<Long> customerGroupIds = new ArrayList<Long>();
            for (String u : customerGroupId) {
                customerGroupIds.add(Long.parseLong(u));
            }
            // 5、保存推送用户群信息
            statement = PushMapper.class.getName() + ".insertUserGroups";
            paramsUserGroups.put("customerGroupIds", customerGroupIds);
            paramsUserGroups.put("sysId", pushbean.getSysId());
            paramsUserGroups.put("messageId", pushbean.getMessageId());
            this.commonDao.insert(statement, paramsUserGroups);
        } else if ("4".equals(pushType)) {// 指定用户
            // 获取指定用户
            String[] usersId = pushbean.getUserIds().split(",");
            Map<String, Object> paramsUser = new HashMap<String, Object>();
            List<Long> usersIds = new ArrayList<Long>();
            for (String u : usersId) {
                usersIds.add(Long.parseLong(u));
            }
            // 6、保存推送用户信息
            paramsUser.put("messageId", pushbean.getMessageId());
            paramsUser.put("sysId", pushbean.getSysId());
            paramsUser.put("usersIds", usersIds);
            statement = PushMapper.class.getName() + ".insertUser";
            this.commonDao.insert(statement, paramsUser);
        }
        // 获取商品
        String sPushGoodsIds = pushbean.getPushGoodsIds();
        if (StringUtil.isNotEmpty(sPushGoodsIds)) {
            Map<String, Object> paramsGoods = new HashMap<String, Object>();
            String[] pushGoodsIds = sPushGoodsIds.split(",");
            List<Long> goodsId = new ArrayList<Long>();
            for (String id : pushGoodsIds) {
                if (StringUtil.isNotEmpty(id)) {
                    goodsId.add(Long.parseLong(id));
                }
            }
            paramsGoods.put("messageId", pushbean.getMessageId());
            paramsGoods.put("pushGoodsId", goodsId);
            // 7、保存推送商品关联
            statement = PushMapper.class.getName() + ".insertPushMessageGoods";
            this.commonDao.insert(statement, paramsGoods);
        }
        return pushbean.getMessageId();
    }

    @Override
    @Transactional
    public void updatePushMessageInfo(PushInfoBean pushbean) {
        Long messageId = pushbean.getMessageId();
        // 1、修改推送信息
        String statement = PushMapper.class.getName() + ".updatePushMsg";
        this.commonDao.update(statement, pushbean);
        statement = PushMapper.class.getName() + ".deleteAppInfo";
        this.commonDao.update(statement, messageId);
        statement = PushMapper.class.getName() + ".deletePushMsgContent";
        this.commonDao.delete(statement, messageId);
        statement = PushMapper.class.getName() + ".deletePushMessageWebEditor";
        this.commonDao.delete(statement, messageId);
        statement = PushMapper.class.getName() + ".deleteCustomerGroup";
        this.commonDao.delete(statement, messageId);
        statement = PushMapper.class.getName() + ".deleteUser";
        this.commonDao.delete(statement, messageId);
        statement = PushMapper.class.getName() + ".deleteGoods";
        this.commonDao.delete(statement, messageId);
        // 类型 （0：普通，1：微阅读）
        Integer type = pushbean.getType();
        if (0 == type) {
            //
            statement = PushMapper.class.getName() + ".insertPushMsgContent";
            this.commonDao.insert(statement, pushbean);
        } else if (1 == type) {
            //
            statement = PushMapper.class.getName() + ".insertPushMessageWebEditor";
            this.commonDao.insert(statement, pushbean);
        }
        // APP
        // 获得APP
        String[] appId = pushbean.getAppIds().split(",");
        List<Long> appIds = new ArrayList<Long>();
        for (String a : appId) {
            appIds.add(Long.parseLong(a));
        }
        Map<String, Object> paramsApp = new HashMap<String, Object>();
        // 4、保存推送APP信息
        statement = PushMapper.class.getName() + ".insertAppInfo";
        paramsApp.put("messageId", pushbean.getMessageId());
        paramsApp.put("sysId", pushbean.getSysId());
        paramsApp.put("appIds", appIds);
        this.commonDao.insert(statement, paramsApp);
        // 用户 用户群
        if ("2".equals(pushbean.getPushType())) { // 用户群
            // 获取指定用户群
            String[] customerGroupId = pushbean.getCustomerGroupIds().split(",");
            Map<String, Object> paramsUserGroups = new HashMap<String, Object>();
            List<Long> customerGroupIds = new ArrayList<Long>();
            for (String u : customerGroupId) {
                customerGroupIds.add(Long.parseLong(u));
            }
            // 5、保存推送用户群信息
            statement = PushMapper.class.getName() + ".insertUserGroups";
            paramsUserGroups.put("customerGroupIds", customerGroupIds);
            paramsUserGroups.put("sysId", pushbean.getSysId());
            paramsUserGroups.put("messageId", messageId);
            this.commonDao.insert(statement, paramsUserGroups);
        } else if ("4".equals(pushbean.getPushType())) { // 用户
            // 获取指定用户
            String[] usersId = pushbean.getUserIds().split(",");
            Map<String, Object> paramsUser = new HashMap<String, Object>();
            List<Long> usersIds = new ArrayList<Long>();
            for (String u : usersId) {
                usersIds.add(Long.parseLong(u));
            }
            // 6、保存推送用户信息
            paramsUser.put("messageId", messageId);
            paramsUser.put("sysId", pushbean.getSysId());
            paramsUser.put("usersIds", usersIds);
            statement = PushMapper.class.getName() + ".insertUser";
            this.commonDao.insert(statement, paramsUser);
        }
        // 获取商品
        String sPushGoodsIds = pushbean.getPushGoodsIds();
        if (StringUtil.isNotEmpty(sPushGoodsIds)) {
            Map<String, Object> paramsGoods = new HashMap<String, Object>();
            String[] pushGoodsIds = sPushGoodsIds.split(",");
            List<Long> goodsId = new ArrayList<Long>();
            for (String id : pushGoodsIds) {
                if (StringUtil.isNotEmpty(id)) {
                    goodsId.add(Long.parseLong(id));
                }
            }
            paramsGoods.put("messageId", messageId);
            paramsGoods.put("pushGoodsId", goodsId);
            statement = PushMapper.class.getName() + ".insertPushMessageGoods";
            this.commonDao.insert(statement, paramsGoods);
        }
    }

    @Override
    public Long deletePushMessageInfoByMId(Long messageId) {
        String state = PushMapper.class.getName() + ".deletePushMessageInfo";
        return (long) commonDao.update(state, messageId);
    }

    @Override
    public void setPushMessageState(Long messageId, int state) {
        String sql = PushMapper.class.getName() + ".setPushMessageState";
        Map<Object, Object> param = new HashMap<Object, Object>();
        param.put("messageId", messageId);
        param.put("state", state);
        commonDao.update(sql, param);
    }

    @Override
    @Transactional
    public PushResult startPush(Long messageId, String systemCode, PushConfig option) {
        // 输入参数验证
        AssertUtil.assertTrue(messageId != null && messageId >= 0, "消息ID参数为空或不合法");
        AssertUtil.assertNotEmpty(systemCode, "业务系统编码参数不能为空");
        // 有效性认证
        PushInfoBean pushInfo = this.getPushMessageInfoById(messageId);
        AssertUtil.assertNotNull(pushInfo, RestResultCode.CODE500.getCode(), "要推送的消息不存在");
        AssertUtil.assertFalse("Y".equals(pushInfo.getDelFlag()), RestResultCode.CODE500.getCode(), "要推送的消息已被删除");
        AssertUtil.assertFalse(pushInfo.getState() != PushMessageState.SUBMITTED.value(), RestResultCode.CODE500.getCode(), "要推送的消息状态不正确[必须为待审核]");

        PushResult result = PushResult.createFailed("未找到推送工具");
        // 没有配置则采用内部推送
        if (option == null || option.getPushTool() == null) {
            result = inPush(messageId, systemCode, option);
        } else {
            // 是否为极光推送
            if (PushTool.JPUSH.value().equals(option.getPushTool().value())) {
                result = jPush(messageId, systemCode, option);
            } else {// 默认采用内部推送
                result = inPush(messageId, systemCode, option);
            }
        }
        return result;
    }

    /**
     * 启动极光推送
     * <p>
     * <pre>
     * 将状态修改为：7 极光
     * 将推送数据传输至极光，等待极光进行推送
     * </pre>
     * <p>
     * *
     *
     * @param messageId  推送消息ID
     * @param systemCode 业务系统编码
     * @param option     推送选项
     * @return 推送结果
     */
    private PushResult jPush(Long messageId, String systemCode, PushConfig option) {
        // 修改状态为：7 极光
        this.setPushMessageState(messageId, PushMessageState.JPUSH.value());

        // 组织要传输的数据
        PushResult result = PushResult.createFailed("极光推送尚未实现");
        PushInfoBean pushInfo = this.getPushMessageInfoById(messageId);
        if (pushInfo == null) {
            result = PushResult.createFailed("要推送的消息不存在！");
        } else if ("Y".equals(pushInfo.getDelFlag())) {
            result = PushResult.createFailed("要推送的消息已被删除！");
        } else {
            if ("3".equals(pushInfo.getPushType())) {

            }
        }

        // 传输数据到极光系统
        return result;
    }

    /**
     * 启动内部推送
     * <p>
     * <pre>
     * 将状态修改为：3 待推送
     * 等待定时任务推送
     * </pre>
     *
     * @param messageId  推送消息ID
     * @param systemCode 业务系统编码
     * @param option     推送选项
     * @return 推送结果
     */
    private PushResult inPush(Long messageId, String systemCode, PushConfig option) {
        // 将状态修改为：3 待推送
        this.setPushMessageState(messageId, PushMessageState.APPROVED.value());
        return PushResult.createSuccess(messageId);
    }

    // ------------------ 用户阅读 -------------------------

    /**
     * 全部、固定用户阅读
     */
    @Override
    public int insertMessageRead(List<PushInfoBean> listBean) {
        AssertUtil.assertNotNull(listBean, "全部、固定用户阅读保存参数为空或不存在");
        listBean.forEach(bean -> {
            AssertUtil.assertTrue(bean.getUserId() != null && bean.getUserId() > 0, "用户ID为空或不存在");
            AssertUtil.assertTrue(bean.getMessageId() != null && bean.getMessageId() > 0, "消息ID为空或不存在");
            AssertUtil.assertTrue(bean.getAppId() != null && bean.getAppId() > 0, "appid为空或不存在");
            AssertUtil.assertTrue(bean.getSysId() != null && bean.getSysId() > 0, "系统id为空或不存在");
        });
        Map<String, Object> param = new HashMap<>();
        param.put("list", listBean);
        String state = PushMapper.class.getName() + ".insertMessageRead";
        int n = commonDao.update(state, param);
        return n;
    }

    /**
     * 阅读消息
     */
    @Override
    @Transactional
    public PushInfoBean readMessage(Long userId, Long messageId, String appCode, String systemCode) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");
        AssertUtil.assertTrue(messageId != null && messageId > 0, "消息ID为空或不存在");
        AssertUtil.assertNotEmpty(appCode, "app编码为空或不存在");
        AssertUtil.assertNotEmpty(systemCode, "系统编码为空或不存在");

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("messageId", messageId);
        param.put("appCode", appCode);
        param.put("sysCode", systemCode);

        PushInfoBean bean = this.getPushMessageInfoById(messageId);

        PushInfoBean readbean = this.getMessageReadByUserId(userId, appCode, messageId);
        if (readbean.getIsRead().equals("N")) {
            String state = PushMapper.class.getName() + ".updateMessageCount";
            commonDao.update(state, messageId);
        }
        String state = PushMapper.class.getName() + ".readMessageReceive";
        if (bean.getPushType().equals("2") || bean.getPushType().equals("4")) {
            commonDao.update(state, param);
        } else {
            if (readbean != null) {// 用户已获得推送消息
                updateMessageRead(param);
            } else {// 用户未获得推送消息
                List<PushInfoBean> listBean = new ArrayList<PushInfoBean>();
                bean.setAppId(bean.getAppId());
                bean.setMessageId(messageId);
                bean.setUserId(userId);
                bean.setSysId(bean.getSysId());
                bean.setIsRead("Y");
                listBean.add(bean);
                insertMessageRead(listBean);
            }
        }

        return bean;

    }

    // -------------------------- 用户删除消息 -----------------------------
    @Override
    public int deleteMessageByUserId(Long userId, String appCode, Long messageId) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");
        AssertUtil.assertTrue(messageId != null && messageId > 0, "消息ID为空或不存在");
        AssertUtil.assertNotEmpty(appCode, "app编码为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("messageId", messageId);
        param.put("appCode", appCode);
        PushInfoBean bean = this.getPushMessageInfoById(messageId);
        int i = 0;
        if (bean.getPushType().equals("2") || bean.getPushType().equals("4")) {
            i = this.delMessageReceive(userId, appCode, messageId);
        } else {
            PushInfoBean readbean = this.getMessageReadByUserId(userId, appCode, messageId);
            if (readbean != null) {
                i = this.delMessageRead(userId, appCode, messageId);
            } else {
                Long sysId = bean.getSysId();
                i = this.insertDelMessageRead(userId, bean.getAppId(), sysId, messageId);
            }
        }
        return i;

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * cn.wassk.platform.service.push.service.PushService#delMessageReceive(
     * java.lang.Long, java.lang.String, java.lang.Long)
     */
    @Override
    public int delMessageReceive(Long userId, String appCode, Long messageId) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");
        AssertUtil.assertTrue(messageId != null && messageId > 0, "消息ID为空或不存在");
        AssertUtil.assertNotEmpty(appCode, "app编码为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("messageId", messageId);
        param.put("appCode", appCode);
        String state = PushMapper.class.getName() + ".delMessageReceive";
        return this.commonDao.update(state, param);
    }

    @Override
    public int delMessageRead(Long userId, String appCode, Long messageId) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");
        AssertUtil.assertTrue(messageId != null && messageId > 0, "消息ID为空或不存在");
        AssertUtil.assertNotEmpty(appCode, "app编码为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("messageId", messageId);
        param.put("appCode", appCode);
        String state = PushMapper.class.getName() + ".delMessageRead";
        return this.commonDao.update(state, param);
    }

    @Override
    public int insertDelMessageRead(Long userId, Long appId, Long sysId, Long messageId) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");
        AssertUtil.assertTrue(messageId != null && messageId > 0, "消息ID为空或不存在");
        AssertUtil.assertTrue(appId != null && appId > 0, "appid为空或不存在");
        AssertUtil.assertTrue(sysId != null && sysId > 0, "系统id为空或不存在");
        PushInfoBean bean = new PushInfoBean();
        bean.setUserId(userId);
        bean.setMessageId(messageId);
        bean.setAppId(appId);
        bean.setSysId(sysId);

        String state = PushMapper.class.getName() + ".insertDelMessageRead";
        return this.commonDao.insert(state, bean);
    }

    // -------------------------- 用户删除消息 ----------------------------- END

    // --------------------------- 删除全部消息 ------------------------------------
    @Override
    public void deleteAllMessageByUserId(Long userId, String appCode) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");
        AssertUtil.assertNotEmpty(appCode, "app编码为空或不存在");

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("appCode", appCode);
        param.put("isPush", Boolean.TRUE);
        List<PushInfoBean> list = this.queryPushMessage(param);
        List<Long> readList = new ArrayList<Long>();
        List<Long> receiveList = new ArrayList<Long>();
        if (list != null && list.size() > 0) {
            for (PushInfoBean bean : list) {
                if (bean.getPushType().equals("2") || bean.getPushType().equals("4")) {
                    receiveList.add(bean.getMessageId());
                } else {
                    readList.add(bean.getMessageId());
                }
            }
        }
        if (receiveList != null && receiveList.size() > 0) {
            this.delMessageReceiveByUserId(userId, receiveList);
        }
        if (readList != null && readList.size() > 0) {
            this.delMessageReadByUserId(userId, readList);
        }

    }

    @Override
    public int delMessageReadByUserId(Long userId, List<Long> messageIds) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");
        AssertUtil.assertTrue(messageIds != null && messageIds.size() > 0, "删除消息ID为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("list", messageIds);

        String state = PushMapper.class.getName() + ".delMessageReadByUserId";
        return this.commonDao.update(state, param);
    }

    @Override
    public int delMessageReceiveByUserId(Long userId, List<Long> messageIds) {
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");
        AssertUtil.assertTrue(messageIds != null && messageIds.size() > 0, "删除消息ID为空或不存在");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userId", userId);
        param.put("list", messageIds);
        String state = PushMapper.class.getName() + ".delMessageReceiveByUserId";
        return this.commonDao.update(state, param);
    }

    // --------------------------- 删除全部消息 ------------------------------ END

    @Override
    public PageInfo<PushInfoBean> queryPushMessage(Long userId, String systemCode, String appCode, Boolean isRead,
                                                   Boolean isPush, String pushTime, PageParam pageParam) {
        Map<String, Object> param = new HashMap<String, Object>();
        AssertUtil.assertTrue(userId != null && userId > 0, "用户ID为空或不存在");
        AssertUtil.assertNotEmpty(appCode, "app编码为空或不存在");
        param.put("userId", userId);
        param.put("appCode", appCode);

        String state = PushMapper.class.getName() + ".queryPushMessage";
        List<PushInfoBean> list = this.commonDao.selectList(state, param);

        List<PushInfoBean> allList = list;
        List<PushInfoBean> uList = new ArrayList<PushInfoBean>();
        List<PushInfoBean> iList = new ArrayList<PushInfoBean>();
        if (allList != null) {
            for (int i = 0; i < allList.size(); i++) {
                PushInfoBean bean = allList.get(i);
                if (bean.getPushType().equals("2") || bean.getPushType().equals("4")) {
                    uList.add(bean);
                } else {
                    PushInfoBean readbean = this.getMessageReadByUserId(userId, appCode, bean.getMessageId());
                    if (readbean != null) {
                        iList.add(bean);
                    }
                }
            }
            if (uList != null) {
                this.updateGetMessageReceive(uList);
            }
            if (iList != null) {
                this.insertGetMessageRead(iList);
            }
        }
        if (StringUtil.isNotEmpty(systemCode)) {
            param.put("systemCode", systemCode);
        }
        if (isRead != null) {
            param.put("isRead", isRead);
        }
        if (isPush != null) {
            param.put("isPush", isPush);
        }
        if (StringUtil.isNotEmpty(pushTime)) {
            param.put("pushTime", pushTime);
        } else {
            param.put("pushTime", this.getLastPushTime(userId, appCode));
        }
        if (pageParam == null) {
            pageParam = new PageParam(1, Integer.MAX_VALUE);
        }
        return this.commonDao.selectPage(state, param, pageParam);
    }

    @Override
    public int updateGetMessageReceive(List<PushInfoBean> listBean) {
        AssertUtil.assertNotNull(listBean,"指定、用户群用户阅读保存参数为空或不存在");
        listBean.forEach(bean->{
            AssertUtil.assertTrue(bean.getUserId() != null && bean.getUserId() > 0, "用户ID为空或不存在");
            AssertUtil.assertTrue(bean.getMessageId() != null && bean.getMessageId() > 0, "消息ID为空或不存在");
        });
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("list", listBean);
        String state = PushMapper.class.getName() + ".updateGetMessageReceive";
        return this.commonDao.update(state, param);
    }

    @Override
    public int insertGetMessageRead(List<PushInfoBean> listBean) {
        AssertUtil.assertNotNull(listBean,"指定、固定用户阅读保存参数为空或不存在");
        listBean.forEach(bean->{
            AssertUtil.assertTrue(bean.getUserId() != null && bean.getUserId() > 0, "用户ID为空或不存在");
            AssertUtil.assertTrue(bean.getMessageId() != null && bean.getMessageId() > 0, "消息ID为空或不存在");
            AssertUtil.assertTrue(bean.getAppId() != null && bean.getAppId() > 0, "appid为空或不存在");
            AssertUtil.assertTrue(bean.getSysId() != null && bean.getSysId() > 0, "系统id为空或不存在");

            bean.setIsRead("N");
            bean.setDelFlag("N");
        });

        return this.insertMessageRead(listBean);
    }

    @Override
    public int updateMessageRead(Map<String, Object> param) {
        AssertUtil.assertNotNull(param.get("userId"), "用户ID为空或不存在");
        AssertUtil.assertNotNull(param.get("appId"), "APP ID为空或不存在");
        AssertUtil.assertNotNull(param.get("appCode"), "APP编码为空或不存在");
        AssertUtil.assertNotNull(param.get("messageId"), "消息ID为空或不存在");
        AssertUtil.assertNotNull(param.get("sysId"), "系统ID为空或不存在");
        AssertUtil.assertNotNull(param.get("sysCode"), "系统编码为空或不存在");

        String state = PushMapper.class.getName() + ".updateMessageRead";
        return this.commonDao.update(state, param);
    }

}
