package cn.faury.fwmf.module.api.category.bean;


/**
 * 标签值Bean对象
 */
public class TagValueInfoBean extends TagInfoBean {

    /**
     * 标签值类型：02
     */
    public final static String TAG_TYPE_VALUE = "02";

    /**
     * 构造函数，默认类型为标签值
     */
    public TagValueInfoBean() {
        super();
        super.setTagProductType(TAG_TYPE_VALUE);
    }

    /**
     * 拷贝构造函数
     *
     * @param tag
     */
    public TagValueInfoBean(final TagInfoBean tag) {
        this();
        if (tag != null && TAG_TYPE_VALUE.equals(tag.getTagProductType())) {
            this.setTagProductId(tag.getParentId());
            this.setTagProductName(tag.getTagProductName());
            this.setTagProductType(TAG_TYPE_VALUE);
            this.setParentId(tag.getParentId());
            this.setXpath(tag.getXpath());
            this.setProductCategoryId(tag.getProductCategoryId());
        }
    }

    @Override
    public String getTagProductType() {
        return TAG_TYPE_VALUE;
    }

    @Override
    public void setTagProductType(final String tagProductType) {
        super.setTagProductType(TAG_TYPE_VALUE);
    }

}
