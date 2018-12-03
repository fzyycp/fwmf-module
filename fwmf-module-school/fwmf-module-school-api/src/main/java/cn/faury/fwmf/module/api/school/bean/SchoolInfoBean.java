package cn.faury.fwmf.module.api.school.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.school.generate.bean.SchoolInfoGenerateBean;
import java.io.Serializable;

/**
 * POJO对象：学校信息表
 *
 * <pre>
 *     SchoolInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自SchoolInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class SchoolInfoBean extends SchoolInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {
    @Override
    public String getPrimaryKeyName() {
        return "SCHOOL_ID";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return this.getSchoolId();
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKey() {
        return this.getSchoolId();
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