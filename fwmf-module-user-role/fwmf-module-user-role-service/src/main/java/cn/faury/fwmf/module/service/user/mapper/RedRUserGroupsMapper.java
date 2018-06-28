package cn.faury.fwmf.module.service.user.mapper;


import cn.faury.fdk.mybatis.AutoScannedMapper;
import cn.faury.fwmf.module.api.user.bean.RedRUserGroupsBean;
import cn.faury.fwmf.module.service.user.sqlProvider.RedRUserGroupsSQLProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@AutoScannedMapper
public interface RedRUserGroupsMapper {

	/**
	 * 根据优惠ID获取相关联的用户组信息
	 * 
	 * <pre>
	 * 【必填】 Long redId 优惠ID
	 * 【必填】int page 第几页
	 * 【必填】 int rows 每一页条数
	 * </pre>
	 * 
	 * @return
	 */
	@SelectProvider(type = RedRUserGroupsSQLProvider.class, method = "queryRedRUserGroupsByRedId")
	@ResultType(RedRUserGroupsBean.class)
	public List<RedRUserGroupsBean> queryRedRUserGroupsByRedId(Map<String, Object> parameter);

	/**
	 * 根据优惠ID获取<b>未</b>关联的用户组信息
	 * 
	 * <pre>
	 * 【可选】 Long redId 优惠ID
	 * 【必填】int page 第几页
	 * 【必填】 int rows 每一页条数
	 * </pre>
	 * 
	 * @return
	 */
	@SelectProvider(type = RedRUserGroupsSQLProvider.class, method = "queryRedUnRUserGroupsByRedId")
	@ResultType(RedRUserGroupsBean.class)
	public List<RedRUserGroupsBean> queryRedUnRUserGroupsByRedId(Map<String, Object> parameter);

	/**
	 * 插入优惠用户群
	 * 
	 * <pre>
	 * 【必填】 List<RedRUserGroupsBean> list
	 * </pre>
	 * 
	 * @return
	 */
	@InsertProvider(type = RedRUserGroupsSQLProvider.class, method = "insert")
	public Integer insert(Map<String, Object> parameter);

	/**
	 * 删除优惠用户群
	 * 
	 * <pre>
	 * 1.【必填】 List<Long> ids 主键
	 * 2.【必填】List<Long> redIds 优惠ID
	 * 3.【必填】Long redId 优惠ID
	 * 【必填】List<Long> groupIds 用户群IDS
	 * </pre>
	 * 
	 * @return
	 */
	@DeleteProvider(type = RedRUserGroupsSQLProvider.class, method = "del")
	public Integer del(Map<String, Object> parameter);
}
