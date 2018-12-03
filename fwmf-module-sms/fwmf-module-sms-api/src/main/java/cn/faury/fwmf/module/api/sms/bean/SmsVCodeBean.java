package cn.faury.fwmf.module.api.sms.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.sms.generate.bean.SmsVCodeGenerateBean;
import java.io.Serializable;

/**
 * POJO对象：
 *
 * <pre>
 *     SmsVCodeGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自SmsVCodeGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class SmsVCodeBean extends SmsVCodeGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    private Template template = Template.VCODE;

    @Override
    public String getPrimaryKeyName() {
        return "SMS_ID";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return this.getSmsId();
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKey() {
        return this.getSmsId();
    }

    /**
     * JSON序列化对象(自动生成代码)
     *
     * @return JSON化对象
     */
    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    /**
     * 短信模板
     */
    public enum Template {
        CUSTOM("0","自定义"), VCODE("1","验证码");

        private String code;
        private String desc;

        Template(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
    }
}