package cn.faury.fwmf.module.api.order.bean;

import cn.faury.fwmf.module.api.order.generate.bean.PostageInfoGenerateBean;
import cn.faury.fdk.common.db.PrimaryKeyEnableBean;
import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 邮费信息表
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

    @Override
    public Long getPrimaryKey() {
        return this.getPostageId();
    }

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