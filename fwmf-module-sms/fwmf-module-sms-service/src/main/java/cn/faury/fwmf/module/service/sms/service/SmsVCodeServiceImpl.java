package cn.faury.fwmf.module.service.sms.service;

import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.entry.RestResultEntry;
import cn.faury.fdk.common.exception.TipsException;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fdk.common.utils.DateUtil;
import cn.faury.fdk.http.client.HttpUtil;
import cn.faury.fdk.http.client.core.HttpResponse;
import cn.faury.fdk.mybatis.dao.CommonDao;
import cn.faury.fwmf.module.api.sms.bean.SmsVCodeBean;
import cn.faury.fwmf.module.api.sms.service.SmsVCodeService;
import cn.faury.fwmf.module.service.common.service.CrudBaseServiceImpl;
import cn.faury.fwmf.module.service.sms.mapper.SmsVCodeMapper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 服务实现：
 * <p>
 * <pre>
 *     CrudBaseServiceImpl为数据库通用增删改查操作实现，不可修改
 *     当前服务实现了SmsVCodeService服务接口，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class SmsVCodeServiceImpl extends CrudBaseServiceImpl<SmsVCodeBean, Long> implements SmsVCodeService {

    /**
     * 发送短信URL
     */
    private String sendMessageUrl = "";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 构造函数(自动生成代码)
     *
     * @param commonDao 数据库操作器
     */
    public SmsVCodeServiceImpl(CommonDao commonDao, String sendMessageUrl) {
        super(commonDao, SmsVCodeMapper.class);
        this.sendMessageUrl = sendMessageUrl;
    }

    /**
     * 发送短信
     *
     * @param sms 短信对象
     * @return 是否发送成功
     */
    @Override
    public Boolean sendSmsMessage(SmsVCodeBean sms) {
        AssertUtil.assertNotNull(sms, "短信对象Bean不可为空");
        AssertUtil.assertNotEmpty(sms.getSaCode(), "APP/系统编码不可为空");
        AssertUtil.assertNotEmpty(sms.getMobileNum(), "接收手机号不可为空");
        AssertUtil.assertNotEmpty(sendMessageUrl, "未配置发送短信网关地址");
        logger.debug("发送短信服务收到的参数：{}", sms.toString());

        ArrayList<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("recNumber", sms.getMobileNum()));
        parameters.add(new BasicNameValuePair("sendMessages", sms.getvCode()));
        parameters.add(new BasicNameValuePair("sendType", sms.getTemplate().getCode()));
        parameters.add(new BasicNameValuePair("sendSaCode", sms.getSaCode()));
        HttpResponse res = HttpUtil.post(this.sendMessageUrl, parameters);

        AssertUtil.assertNotNull(res, "请求发送短信网关服务未响应");

        logger.debug("请求发送短信网关服务返回响应：{}", res);
        boolean isSuccess = false;
        try {
            RestResultEntry result = res.getResult(RestResultEntry.class);
            isSuccess = result.isSuccess();
        } catch (Exception ignored) {
        }
        return isSuccess;
    }

    /**
     * 创建验证码
     *
     * @param mobileNum 接收手机号
     * @param saCode    手机APP编码/系统编码
     * @return 验证码对象
     */
    @Override
    public SmsVCodeBean createVCode(String mobileNum, String saCode) {
        AssertUtil.assertNotEmpty(mobileNum, "手机号不能为空");
        AssertUtil.assertNotEmpty(saCode, "APP/系统编码不能为空");
        // 生成验证码，4位随机数字
        Random random = new Random();
        int rand = random.nextInt(9999);
        String vcode = String.format("%04d", rand);
        // 保存到数据库
        SmsVCodeBean bean = new SmsVCodeBean();
        bean.setUuid(UUID.randomUUID().toString());
        bean.setMobileNum(mobileNum);
        bean.setvCode(vcode);
        bean.setSaCode(saCode);
        bean.setCreateTime(DateUtil.getCurrentDate());

        // 插入数据
        Long res = this.insert(bean);

        return res > 0 ? bean : null;
    }

    /**
     * 验证收到的验证码
     *
     * @param uuid      验证码UUID流水号
     * @param vcode     收到的验证码
     * @param mobileNum 手机号
     * @return 是否成功
     */
    @Override
    public Boolean validateVCode(String uuid, String vcode, String mobileNum) {
        AssertUtil.assertNotEmpty(uuid, "流水号不能为空");
        AssertUtil.assertNotEmpty(vcode, "验证码不能为空");
        AssertUtil.assertNotEmpty(mobileNum, "手机号不能为空");
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("uuid", uuid);
        parameter.put("vcode", vcode);
        parameter.put("mobileNum", mobileNum);
        List<SmsVCodeBean> beanList = this.query(parameter);
        if (beanList == null || beanList.size() <= 0) {
            return Boolean.FALSE;
        } else {
            // 验证码时效10分钟
            long epha = DateUtil.getCurrentDate().getTime() - beanList.get(0).getCreateTime().getTime();
            AssertUtil.assertFalse(epha > 10 * 60 * 1000, "验证码已失效");
            return Boolean.TRUE;
        }
    }

    /**
     * 创建并发送验证码
     *
     * @param mobileNum 手机号
     * @param saCode    手机APP编码/系统编码
     * @return 验证码UUID流水号
     */
    @Override
    public String createAndSendVCode(String mobileNum, String saCode) {
        SmsVCodeBean vcode = createVCode(mobileNum, saCode);
        if (sendSmsMessage(vcode)) {
            return vcode.getUuid();
        }
        throw new TipsException(RestResultCode.CODE500.getCode(), "短信验证码发送失败");
    }

    /**
     * 获取特定手机号最后一次获取验证码对象
     *
     * @param mobileNum 手机号
     * @param saCode    手机APP编码/系统编码
     * @return 验证码对象
     */
    @Override
    public SmsVCodeBean getLastVCodeByMobileNum(String mobileNum, String saCode) {
        AssertUtil.assertNotEmpty(mobileNum, "手机号不能为空");
        AssertUtil.assertNotEmpty(saCode, "APP/系统编码不能为空");
        // 查询数据
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("mobileNum", mobileNum);
        parameters.put("appCode", saCode);
        parameters.put("ORDER_BY", "CREATE_TIME,DESC");
        List<SmsVCodeBean> beans = this.query(parameters);
        return beans != null && beans.size() > 0 ? beans.get(0) : null;
    }

    /**
     * 根据流水号获取验证码对象
     *
     * @param uuid 流水号
     * @return 验证码对象
     */
    @Override
    public SmsVCodeBean getVCodeByUuid(String uuid) {
        AssertUtil.assertNotEmpty(uuid, "流水号不能为空");

        List<SmsVCodeBean> bean = this.query(Collections.singletonMap("uuid", uuid));
        return bean != null && bean.size() > 0 ? bean.get(0) : null;
    }

    public String getSendMessageUrl() {
        return sendMessageUrl;
    }

    public void setSendMessageUrl(String sendMessageUrl) {
        this.sendMessageUrl = sendMessageUrl;
    }
}