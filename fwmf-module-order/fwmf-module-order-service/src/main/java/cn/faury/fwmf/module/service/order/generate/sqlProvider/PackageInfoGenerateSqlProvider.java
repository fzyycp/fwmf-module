package cn.faury.fwmf.module.service.order.generate.sqlProvider;

import cn.faury.fwmf.module.api.order.generate.bean.PackageInfoGenerateBean;
import org.apache.ibatis.jdbc.SQL;

public class PackageInfoGenerateSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_package_info
     *
     * @mbg.generated Tue Aug 07 16:54:55 CST 2018
     */
    public String insertSelective(PackageInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("order_t_package_info");
        
        sql.VALUES("PACKAGE_ID", "#{packageId,jdbcType=BIGINT}");
        
        if (record.getPackageName() != null) {
            sql.VALUES("PACKAGE_NAME", "#{packageName,jdbcType=VARCHAR}");
        }
        
        if (record.getPackagePrice() != null) {
            sql.VALUES("PACKAGE_PRICE", "#{packagePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getShopId() != null) {
            sql.VALUES("SHOP_ID", "#{shopId,jdbcType=BIGINT}");
        }
        
        if (record.getStoreId() != null) {
            sql.VALUES("STORE_ID", "#{storeId,jdbcType=BIGINT}");
        }
        
        if (record.getPostageId() != null) {
            sql.VALUES("POSTAGE_ID", "#{postageId,jdbcType=BIGINT}");
        }
        
        if (record.getIsDelete() != null) {
            sql.VALUES("IS_DELETE", "#{isDelete,jdbcType=CHAR}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.VALUES("CREATE_PERSON", "#{createPerson,jdbcType=BIGINT}");
        }
        
        if (record.getCreatePersonName() != null) {
            sql.VALUES("CREATE_PERSON_NAME", "#{createPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("CREATE_TIME", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatePerson() != null) {
            sql.VALUES("UPDATE_PERSON", "#{updatePerson,jdbcType=BIGINT}");
        }
        
        if (record.getUpdatePersonName() != null) {
            sql.VALUES("UPDATE_PERSON_NAME", "#{updatePersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("UPDATE_TIME", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_t_package_info
     *
     * @mbg.generated Tue Aug 07 16:54:55 CST 2018
     */
    public String updateByPrimaryKeySelective(PackageInfoGenerateBean record) {
        SQL sql = new SQL();
        sql.UPDATE("order_t_package_info");
        
        if (record.getPackageName() != null) {
            sql.SET("PACKAGE_NAME = #{packageName,jdbcType=VARCHAR}");
        }
        
        if (record.getPackagePrice() != null) {
            sql.SET("PACKAGE_PRICE = #{packagePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getShopId() != null) {
            sql.SET("SHOP_ID = #{shopId,jdbcType=BIGINT}");
        }
        
        if (record.getStoreId() != null) {
            sql.SET("STORE_ID = #{storeId,jdbcType=BIGINT}");
        }
        
        if (record.getPostageId() != null) {
            sql.SET("POSTAGE_ID = #{postageId,jdbcType=BIGINT}");
        }
        
        if (record.getIsDelete() != null) {
            sql.SET("IS_DELETE = #{isDelete,jdbcType=CHAR}");
        }
        
        if (record.getCreatePerson() != null) {
            sql.SET("CREATE_PERSON = #{createPerson,jdbcType=BIGINT}");
        }
        
        if (record.getCreatePersonName() != null) {
            sql.SET("CREATE_PERSON_NAME = #{createPersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("CREATE_TIME = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatePerson() != null) {
            sql.SET("UPDATE_PERSON = #{updatePerson,jdbcType=BIGINT}");
        }
        
        if (record.getUpdatePersonName() != null) {
            sql.SET("UPDATE_PERSON_NAME = #{updatePersonName,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("UPDATE_TIME = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("PACKAGE_ID = #{packageId,jdbcType=BIGINT}");
        
        return sql.toString();
    }
}