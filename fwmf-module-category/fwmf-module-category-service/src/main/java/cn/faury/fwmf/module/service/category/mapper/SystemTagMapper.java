package cn.faury.fwmf.module.service.category.mapper;

import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.category.bean.SystemTagBean;
import cn.faury.fwmf.module.service.category.sqlProvider.SystemTagSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * 系统商品标签授权Mapper
 */
@AutoScannedMapper
public interface SystemTagMapper {

	@SelectProvider(method = "getSystemTagInfoByCondition", type = SystemTagSqlProvider.class)
	@ResultType(SystemTagBean.class)
	public List<SystemTagBean> getAllSystemTagInfo();

	/**
	 * 根据系统Id获取标签信息
	 */
	@SelectProvider(method = "getSystemTagInfoByCondition", type = SystemTagSqlProvider.class)
	@ResultType(SystemTagBean.class)
	public List<SystemTagBean> getSystemTagInfoBySystemId(final Map<String, Object> paramete);

	/**
	 * 根据系统Id获取标签信息
	 */
	@SelectProvider(method = "getSystemTagInfoByCondition", type = SystemTagSqlProvider.class)
	@ResultType(SystemTagBean.class)
	public List<SystemTagBean> getSystemTagInfoBySystemCode(final Map<String, Object> paramete);

	/**
	 * 根据系统code获取指定标签授权信息
	 */
	@SelectProvider(method = "getSystemTagInfoByCondition", type = SystemTagSqlProvider.class)
	@ResultType(SystemTagBean.class)
	public List<SystemTagBean> getSystemTagInfoByCondition(final Map<String, Object> parameter);

	/**
	 * 保存商品标签
	 */
	@InsertProvider(method = "saveSystemTagInfo", type = SystemTagSqlProvider.class)
	public Long saveSystemTagInfo(final Map<String, Object> parameter);

	/**
	 * 删除商品标签
	 */
	@InsertProvider(method = "deleteSystemTagInfo", type = SystemTagSqlProvider.class)
	public Long deleteSystemTagInfo(final Map<String, Object> parameter);
}
