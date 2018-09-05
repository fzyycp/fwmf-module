package cn.faury.fwmf.module.api.sms.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fwmf.module.api.sms.bean.SmsVCodeBean;

/**
 * 服务接口：
 * <p>
 * <pre>
 *     CrudBaseService为数据库通用增删改查操作，不可修改
 *     当前服务接口继承自CrudBaseService，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public interface SmsVCodeService extends CrudBaseService<SmsVCodeBean, Long> {

    /**
     * 发送短信
     *
     * @param sms 短信对象
     * @return 是否发送成功
     */
    @Write
    public Boolean sendSmsMessage(final SmsVCodeBean sms);

    /**
     * 创建验证码
     *
     * @param mobileNum 接收手机号
     * @param saCode   手机APP编码/系统编码
     * @return 验证码对象
     */
    @Write
    public SmsVCodeBean createVCode(final String mobileNum, final String saCode);

    /**
     * 验证收到的验证码
     *
     * @param uuid      验证码UUID流水号
     * @param vcode     收到的验证码
     * @param mobileNum 手机号
     * @return 是否成功
     */
    @Read
    public Boolean validateVCode(final String uuid, final String vcode, final String mobileNum);

    /**
     * 创建并发送验证码
     *
     * @param mobileNum 手机号
     * @param saCode   手机APP编码/系统编码
     * @return 验证码UUID流水号
     */
    @Write
    public String createAndSendVCode(final String mobileNum, final String saCode);

    /**
     * 获取特定手机号最后一次获取验证码对象
     *
     * @param mobileNum 手机号
     * @param saCode   手机APP编码/系统编码
     * @return 验证码对象
     */
    @Read
    public SmsVCodeBean getLastVCodeByMobileNum(final String mobileNum, final String saCode);

    /**
     * 根据流水号获取验证码对象
     *
     * @param uuid 流水号
     * @return 验证码对象
     */
    @Read
    public SmsVCodeBean getVCodeByUuid(final String uuid);
}