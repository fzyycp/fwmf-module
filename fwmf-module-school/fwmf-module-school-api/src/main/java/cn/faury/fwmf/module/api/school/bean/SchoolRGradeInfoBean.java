package cn.faury.fwmf.module.api.school.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.school.generate.bean.SchoolRGradeInfoGenerateBean;
import java.io.Serializable;

/**
 * POJO对象：学校年级信息表
 *
 * <pre>
 *     SchoolRGradeInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自SchoolRGradeInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class SchoolRGradeInfoBean extends SchoolRGradeInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {
    @Override
    public String getPrimaryKeyName() {
        return "GRADE_ID";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return this.getGradeId();
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKey() {
        return this.getGradeId();
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