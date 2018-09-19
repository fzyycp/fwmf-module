package cn.faury.fwmf.module.api.code.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.code.generate.bean.CodeGroupInfoGenerateBean;
import java.io.Serializable;
import java.util.List;

/**
 * POJO对象：数据字典分组表
 *
 * <pre>
 *     CodeGroupInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自CodeGroupInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class CodeGroupInfoBean extends CodeGroupInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    private List<CodeInfoBean> codeInfos;

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKey() {
        return this.getCodeGroupId();
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

    public List<CodeInfoBean> getCodeInfos() {
        return codeInfos;
    }

    public void setCodeInfos(List<CodeInfoBean> codeInfos) {
        this.codeInfos = codeInfos;
    }
}