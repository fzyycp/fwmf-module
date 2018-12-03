package cn.faury.fwmf.module.api.menu.bean;

import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;
import cn.faury.fwmf.module.api.menu.generate.bean.MenuInfoGenerateBean;

import java.io.Serializable;
import java.util.List;

/**
 * POJO对象：菜单信息表
 * <p>
 * <pre>
 *     MenuInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自MenuInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class MenuInfoBean extends MenuInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    private List<FunctionInfoBean> functionInfoBeans;

    @Override
    public String getPrimaryKeyName() {
        return "MENU_ID";
    }

    @Override
    public Long getPrimaryKeyValue() {
        return getMenuId();
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKey() {
        return this.getMenuId();
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
     * 获取functionInfoBeans
     *
     * @return functionInfoBeans
     */
    public List<FunctionInfoBean> getFunctionInfoBeans() {
        return functionInfoBeans;
    }

    /**
     * 设置functionInfoBeans
     *
     * @param functionInfoBeans 值
     */
    public void setFunctionInfoBeans(List<FunctionInfoBean> functionInfoBeans) {
        this.functionInfoBeans = functionInfoBeans;
    }
}