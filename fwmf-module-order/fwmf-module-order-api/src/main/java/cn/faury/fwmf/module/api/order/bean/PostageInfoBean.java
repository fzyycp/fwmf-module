package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.PostageInfoGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * POJO对象：邮费信息表
 *
 * <pre>
 *     PostageInfoGenerateBean为数据库表自动生成POJO对象，不可修改
 *     当前POJO继承自PostageInfoGenerateBean，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
public class PostageInfoBean extends PostageInfoGenerateBean implements PrimaryKeyEnableBean<Long>, Serializable {

    /**
     * 邮费关联区域列表
     */
    private List<PostageRAreaBean> postageRAreaBeanList;

    /**
     * 获取postageRAreaBeanList
     *
     * @return postageRAreaBeanList
     */
    public List<PostageRAreaBean> getPostageRAreaBeanList() {
        return postageRAreaBeanList;
    }

    /**
     * 设置postageRAreaBeanList
     *
     * @param postageRAreaBeanList 值
     */
    public void setPostageRAreaBeanList(List<PostageRAreaBean> postageRAreaBeanList) {
        this.postageRAreaBeanList = postageRAreaBeanList;
    }

    /**
     * 获取表主键字段名(自动生成代码)
     *
     * @return 主键字段名
     */
    @Override
    public String getPrimaryKeyName() {
        return "POSTAGE_ID";
    }

    /**
     * 获取表主键Key值(自动生成代码)
     *
     * @return 主键值
     */
    @Override
    public Long getPrimaryKeyValue() {
        return this.getPostageId();
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

    public enum PostageType {
        NORMAL("00", "基本类型"), AREA("01", "区域类型");

        private String code;
        private String desc;

        private PostageType(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 编码转化为对象
         */
        public static PostageType parse(String code) {
            return Arrays.stream(PostageType.values())
                    .filter(value -> value.code.equals(code))
                    .findFirst().orElse(null);
        }

        /**
         * 获取code
         *
         * @return code
         */
        public String getCode() {
            return code;
        }

        /**
         * 获取desc
         *
         * @return desc
         */
        public String getDesc() {
            return desc;
        }
    }
}