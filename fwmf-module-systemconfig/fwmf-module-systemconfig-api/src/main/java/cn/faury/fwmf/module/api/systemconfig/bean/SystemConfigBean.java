package cn.faury.fwmf.module.api.systemconfig.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.systemconfig.generate.bean.SystemConfigGenerateBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * POJO对象：系统参数配置表
 *
 * <pre>
 *     SystemConfigGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自SystemConfigGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class SystemConfigBean extends SystemConfigGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {
    /**
     * 附加属性
     */
    private Map<String, Object> attrs = new HashMap<>();;

    /**
     * 获取表主键字段名(自动生成代码)
     *
     * @return 主键字段名
     */
    @Override
    public String getPrimaryKeyName() {
        return "SYSTEM_CONFIG_ID";
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKeyValue() {
        return this.getSystemConfigId();
    }

    /**
     * 获取附加属性
     *
     * @return 附加属性
     */
    public Map<String, Object> getAttrs() {
        return attrs;
    }

    /**
     * 设置附加属性
     *
     * @param attrs 附加属性值
     */
    public void setAttrs(Map<String, Object> attrs) {
        this.attrs = attrs == null ? new HashMap<>() : attrs;
    }

    /**
     * 添加附加属性
     *
     * @param key   键
     * @param value 值
     *
     * @return 附加属性
     */
    public Map<String, Object> putAttr(String key, Object value) {
        if (attrs == null) {
            attrs = new HashMap<>();
        }
        attrs.put(key, value);
        return attrs;
    }

    /**
     * 设置附加属性
     *
     * @param key 键
     */
    public void removeAttr(String key) {
        if (attrs == null) {
            attrs = new HashMap<>();
        }
        attrs.remove(key);
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
}