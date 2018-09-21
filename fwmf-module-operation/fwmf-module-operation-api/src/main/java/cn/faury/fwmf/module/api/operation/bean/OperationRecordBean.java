package cn.faury.fwmf.module.api.operation.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.operation.config.Operation;
import cn.faury.fwmf.module.api.operation.generate.bean.OperationRecordGenerateBean;

import java.io.Serializable;

/**
 * POJO对象：操作记录信息表
 * <p>
 * <pre>
 *     OperationRecordGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自OperationRecordGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class OperationRecordBean extends OperationRecordGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKey() {
        return this.getOperationRecordId();
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

    /**
     * 设置操作记录配置
     *
     * @param operation 操作记录配置
     */
    public void setOperation(Operation operation) {
        if (operation != null) {
            this.setMenu(operation.menu());
            this.setFunction(operation.function());
            this.setOptLevel(operation.type().getLevel());
            this.setOptCode(operation.type().getCode());
            this.setOptDesc(operation.type().getDesc());
        }
    }

    /**
     * 设置操作记录配置
     *
     * @param menu     菜单名称
     * @param function 功能按钮名称
     * @param type     操作类型
     */
    public void setOperation(String menu, String function, Operation.Type type) {
        this.setMenu(menu);
        this.setFunction(function);
        if (type != null) {
            this.setOptLevel(type.getLevel());
            this.setOptCode(type.getCode());
            this.setOptDesc(type.getDesc());
        }
    }
}