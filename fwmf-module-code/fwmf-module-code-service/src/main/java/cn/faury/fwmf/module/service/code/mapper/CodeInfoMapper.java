package cn.faury.fwmf.module.service.code.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.code.bean.CodeInfoBean;
import cn.faury.fwmf.module.service.code.sqlProvider.CodeInfoSQLProvider;
import cn.faury.fwmf.module.service.constant.DBConstOfCode;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 字典信息管理mapper类
 */
@AutoScannedMapper
public interface CodeInfoMapper {
    /**
     * 查询字典
     *
     * @param map 查询参数
     * @return 成功条数
     */
    @SelectProvider(method = "search", type = CodeInfoSQLProvider.class)
    @ResultType(value = CodeInfoBean.class)
    public List<CodeInfoBean> search(Map<String, Object> map);

    /**
     * 根据类型查找字典
     */
    @Select(" SELECT CODE_ID codeId,CODE_NAME codeName,CODE_CODE codeCode,CODE_TYPE codeType,CODE_ORDER codeOrder"
            + " FROM " + DBConstOfCode.TN_CODE_INFO
            + " WHERE CODE_TYPE = #{codeType} "
            + " ORDER BY codeOrder ")
    @ResultType(value = CodeInfoBean.class)
    public List<CodeInfoBean> getCodeInfoByType(Map<String, Object> map);

    /**
     * 根据系统code、 公共代码code 获取公共代码配置
     *
     * @param parameter
     * @return
     */
    @SelectProvider(method = "getCodeInfoListByCode", type = CodeInfoSQLProvider.class)
    @ResultType(CodeInfoBean.class)
    public List<CodeInfoBean> getCodeInfoListByCode(final Map<String, Object> parameter);

    @Insert("insert into " + DBConstOfCode.TN_CODE_INFO
            + " (code_code,code_name,code_type,code_order)"
            + "  values(#{codeCode},#{codeName},#{codeType},#{codeOrder}) ")
    @Options(useGeneratedKeys = true, keyProperty = "codeId")
    public Long insertCodeInfo(CodeInfoBean bean);

    @UpdateProvider(type = CodeInfoSQLProvider.class, method = "update")
    public int updateCodeInfoByCodeId(Map<String, Object> map);

    @Delete("delete from " + DBConstOfCode.TN_CODE_INFO + " where code_id=#{_paramter} ")
    public long delete(Long codeId);
}
