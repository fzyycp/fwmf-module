package cn.faury.fwmf.module.api.school.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.school.generate.bean.SchoolRGradeInfoGenerateBean;

import java.io.Serializable;

/**
 * SchoolRGradeInfoGenerateBean扩展，用于项目业务代码添加，随便修改
 * 只需生成一次，后面不需要再生成
 */
public class SchoolRGradeInfoBean extends SchoolRGradeInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    @Override
    public Long getPrimaryKey() {
        return this.getGradeId();
    }

    @Override
    public String toString() {
        return JsonUtil.objectToJson(this);
    }
}