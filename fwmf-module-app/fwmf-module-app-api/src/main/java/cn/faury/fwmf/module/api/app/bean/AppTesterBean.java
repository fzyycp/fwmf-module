package cn.faury.fwmf.module.api.app.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.app.generate.bean.AppTesterGenerateBean;

import java.io.Serializable;

/**
 * POJO对象：APP测试用户信息表
 *
 * <pre>
 *     AppTesterGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自AppTesterGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class AppTesterBean extends AppTesterGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {
    @Override
    public String getPrimaryKeyName() {
        return "ID";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return this.getId();
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKey() {
        return this.getId();
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