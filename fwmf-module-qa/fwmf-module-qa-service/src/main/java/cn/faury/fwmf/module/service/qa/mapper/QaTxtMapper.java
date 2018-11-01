package cn.faury.fwmf.module.service.qa.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.qa.bean.QaTxtBean;
import cn.faury.fwmf.module.service.qa.generate.mapper.QaTxtGenerateMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

/**
 * Mybatis Mapper：常见问题txt
 *
 * <pre>
 *     QaTxtGenerateMapper为数据库通用增删改查操作，不可修改
 *     当前Mapper继承自QaTxtGenerateMapper，用于项目业务代码扩展添加
 *     只需初始化生成一次，然后根据需要扩展，重新生成时注意合并自己添加的代码
 * </pre>
 */
@AutoScannedMapper
public interface QaTxtMapper extends QaTxtGenerateMapper {
    @Delete({
            "delete from sys_t_qa_txt",
            "where QA_ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByQaId(Long id);

    @Select({
            "select",
            "ID, QA_ID, CONTENT_JSON, CONTENT_HTML",
            "from sys_t_qa_txt",
            "where QA_ID = #{qaId,jdbcType=BIGINT}",
            "limit 1"
    })
    @Results({
            @Result(column="ID", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="QA_ID", property="qaId", jdbcType=JdbcType.BIGINT),
            @Result(column="CONTENT_JSON", property="contentJson", jdbcType=JdbcType.LONGVARCHAR),
            @Result(column="CONTENT_HTML", property="contentHtml", jdbcType=JdbcType.LONGVARCHAR)
    })
    QaTxtBean getBeanByQaId(Long qaId);

}