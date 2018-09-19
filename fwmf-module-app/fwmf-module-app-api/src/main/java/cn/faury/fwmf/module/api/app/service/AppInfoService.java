package cn.faury.fwmf.module.api.app.service;

import cn.faury.fdk.common.anotation.permission.Read;
import cn.faury.fdk.common.anotation.permission.Write;
import cn.faury.fdk.common.db.CrudBaseService;
import cn.faury.fdk.common.db.PageInfo;
import cn.faury.fdk.common.entry.RestResultCode;
import cn.faury.fdk.common.utils.AssertUtil;
import cn.faury.fwmf.module.api.app.bean.AppInfoBean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * APP注册服务协议
 */
public interface AppInfoService extends CrudBaseService<AppInfoBean, Long> {

	/**
	 * 根据appCode获取APP注册信息
	 * 
	 * @param systemCode
	 *            【可选】系统Code 所对应业务系统中系统的code
	 * @param appCode
	 *            【必选】APP注册信息code
	 * @param isSysAvailable
	 *            【可选】业务系统是否可用，TRUE：可用，FALSE：不可用，NULL：全部
	 * @param isAppAvailable
	 *            【可选】APP注册信息是否可用，TRUE：可用，FALSE：不可用，NULL：全部
	 * @return APP注册信息对象
	 */
	@Read
	public default AppInfoBean getAppInfoBySystemCode(final String systemCode, final String appCode,
                                                      final Boolean isSysAvailable, final Boolean isAppAvailable){
		AssertUtil.assertNotEmpty(appCode, RestResultCode.CODE500.getCode(),"App编码不能为空");
		List<AppInfoBean> resList = getAppInfoList(systemCode, appCode, isSysAvailable, isAppAvailable);
		if (resList.size() > 0) {
			return resList.get(0);
		}
		return null;
	}

	/**
	 * 根据系统Code获取app注册信息列表
	 * 
	 * @param systemCode
	 *            【必选】系统Code 所对应业务系统中系统的code
	 * @return APP注册信息列表以<b>List</b>展示
	 */
	@Read
	public default List<AppInfoBean> getAppInfoList(final String systemCode){
        return getAppInfoList(systemCode, (Long) null, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据appCode获取APP注册信息
	 * 
	 * @param systemCode
	 *            【可选】系统Code 所对应业务系统中系统的code
	 * @param appCode
	 *            【必选】APP注册信息code
	 * @return APP注册信息对象
	 */
	@Read
	public default AppInfoBean getAppInfoBySystemCode(final String systemCode, final String appCode){
        return getAppInfoBySystemCode(systemCode, appCode, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据appCode判断App是否可以使用
	 * 
	 * @param appCode
	 *            【必选】APP注册信息code
	 * @return 判断APP是否可用，如果返回NULL代表该APP信息不可用。
	 */
	@Read
	public AppInfoBean isAppInUse(final String appCode);

	// ===============================================【只读】

	/**
	 * 根据系统Id、appId、系统是否可用以及app是否可用获取app注册信息列表
	 *
	 *
	 * @param systemId
	 *            【必选】所对应业务系统的ID
	 * @param appId
	 *            【可选】APP注册信息ID
	 *            <i>该参数如果传入null则表示不使用该参数，默认根据<b>systemId</b>执行查询所有APP注册信息列表
	 *            </i>
	 * @param isSysAvailable
	 *            【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
	 * @param isAppAvailable
	 *            【可选】APP注册信息是否可用，TRUE为可用，FALSE为不可用
	 * @return APP注册信息列表以<b>List</b>展示
	 */
	@Read
	public List<AppInfoBean> getAppInfoList(final Long systemId, final Long appId, final Boolean isSysAvailable,
                                            final Boolean isAppAvailable);

	/**
	 * 根据系统Code、appId、系统是否可用以及app是否可用获取app注册信息列表
	 *
	 * @param systemCode
	 *            【必选】系统Code 所对应业务系统中系统的code
	 * @param appId
	 *            【可选】APP注册信息ID
	 *            <i>该参数如果传入null则表示不使用该参数，默认根据<b>systemCode</b>执行查询所有APP注册信息列表
	 *            </i>
	 * @param isSysAvailable
	 *            【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
	 * @param isAppAvailable
	 *            【可选】APP注册信息是否可用，TRUE为可用，FALSE为不可用
	 * @return APP注册信息列表以<b>List</b>展示
	 */
	@Read
	public List<AppInfoBean> getAppInfoList(final String systemCode, final Long appId,
                                            final Boolean isSysAvailable, final Boolean isAppAvailable);

	/**
	 * 根据系统Id、appCode、系统是否可用以及app是否可用获取app注册信息列表
	 *
	 * @param systemId
	 *            【必选】所对应业务系统的ID
	 * @param appCode
	 *            【可选】APP注册信息code
	 *            <i>该参数如果传入null则表示不使用该参数，默认根据systemId执行查询所有APP注册信息列表</i>
	 * @param isSysAvailable
	 *            【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
	 * @param isAppAvailable
	 *            【可选】APP注册信息是否可用，TRUE为可用，FALSE为不可用
	 * @return APP注册信息列表以<b>List</b>展示
	 */
	@Read
	public List<AppInfoBean> getAppInfoList(final Long systemId, final String appCode,
                                            final Boolean isSysAvailable, final Boolean isAppAvailable);

	/**
	 * 根据系统Code、appCode、系统是否可用以及app是否可用获取app注册信息列表
	 *
	 * @param systemCode
	 *            【必选】系统Code 所对应业务系统中系统的code
	 * @param appCode 【可选】APP注册信息code
	 *        <i>该参数如果传入null则表示不使用该参数，默认根据<b>systemCode</b>执行查询所有APP注册信息列表</i>
	 * @param isSysAvailable
	 *            【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
	 * @param isAppAvailable
	 *            【可选】APP注册信息是否可用，TRUE为可用，FALSE为不可用
	 * @return APP注册信息列表以<b>List</b>展示
	 */
	@Read
	public List<AppInfoBean> getAppInfoList(final String systemCode, final String appCode,
                                            final Boolean isSysAvailable, final Boolean isAppAvailable);

	/**
	 * 根据AppId获取APP注册信息
	 *
	 * @param systemId
	 *            【必选】业务系统ID 所对应业务系统中系统的Id
	 * @param appId
	 *            【必选】APP注册信息ID
	 * @param isSysAvailable
	 *            【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
	 * @param isAppAvailable
	 *            【可选】APP注册信息是否可用，TRUE为可用，FALSE为不可用
	 * @return APP注册信息对象
	 */
	@Read
	public default AppInfoBean getAppInfoByAppId(final Long systemId, final Long appId, final Boolean isSysAvailable,
                                                 final Boolean isAppAvailable){
		List<AppInfoBean> resList = getAppInfoList(systemId, appId, isSysAvailable, isAppAvailable);
		if (resList.size() > 0) {
			return resList.get(0);
		}
		return null;
	}

	/**
	 * 根据AppId获取APP注册信息
	 *
	 * @param systemCode
	 *            【必选】系统Code 所对应业务系统中系统的code
	 * @param appId
	 *            【必选】APP注册信息ID
	 * @param isSysAvailable
	 *            【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
	 * @param isAppAvailable
	 *            【可选】APP注册信息是否可用，TRUE为可用，FALSE为不可用
	 * @return APP注册信息对象
	 */
	@Read
	public default AppInfoBean getAppInfoByAppId(final String systemCode, final Long appId, final Boolean isSysAvailable,
                                                 final Boolean isAppAvailable){
        List<AppInfoBean> resList = getAppInfoList(systemCode, appId, isSysAvailable, isAppAvailable);
        if (resList.size() > 0) {
            return resList.get(0);
        }
        return null;
    }

	/**
	 * 根据appCode获取APP注册信息
	 *
	 * @param systemId
	 *            【必选】业务系统ID 所对应业务系统中系统的Id
	 * @param appCode
	 *            【必选】APP注册信息CODE
	 * @param isSysAvailable
	 *            【可选】业务系统是否可用，TRUE为可用，FALSE为不可用
	 * @param isAppAvailable
	 *            【可选】APP注册信息是否可用，TRUE为可用，FALSE为不可用
	 * @return APP注册信息对象
	 */
	@Read
	public default AppInfoBean getAppInfoByAppCode(final Long systemId, final String appCode, final Boolean isSysAvailable,
                                                   final Boolean isAppAvailable){
        List<AppInfoBean> resList = getAppInfoList(systemId, appCode, isSysAvailable, isAppAvailable);
        if (resList.size() > 0) {
            return resList.get(0);
        }
        return null;
    }

	/**
	 * 根据推送信息ID获取APP
	 *
	 * @param messageId
	 *            推送信息ID
	 * @return APP注册信息
	 */
	public List<AppInfoBean> getAppInfoByMId(final Long messageId);

	/**
	 * 根据推送信息ID获取APP（合并APPId、和APPName）
	 *
	 * @param messageId
	 *            推送信息ID
	 * @return APP注册信息
	 */
	public AppInfoBean getAppInfoByMIdIsWithContact(final Long messageId);

	/**
	 * 分页查询APP注册信息
	 *
	 * @param parameter
	 *            参数列表 <br>
	 *            【appId】:APP注册信息Id<br>
	 *            【模糊匹配、区分大小写】appCode:APP注册信息code<br>
	 *            【模糊匹配】appName:APP注册信息名称<br>
	 *            【appOS】:APP注册信息描述<br>
	 *            【systemId】:业务系统Id<br>
	 *            【isAvailable】:APP注册信息是否可用<br>
	 *            【systemCode】:业务系统code<br>
	 *            【systemName】:业务系统ID<br>
	 *
	 * @return APP注册信息列表以<b>Page</b>展示
	 */
	@Read
	public PageInfo<AppInfoBean> queryAppInfoByPager(final Map<String, Object> parameter);

	/**
	 * checkAPP注册信息
	 *
	 * @param parameter 参数
	 *
	 * @return 是否存在重复信息
	 */
	public String checkAppInfo(final Map<String, Object> parameter);

	// ================================【只写】

	/**
	 * 新增APP注册信息
	 *
	 * @param app
	 *            APP注册对象
	 *
	 *            <pre>
	 *            	参数：<br>
	 *            appCode:APP注册信息code<br>
	 *            appName:APP注册信息名称<br>
	 *            appOS:APP注册信息描述<br>
	 *            isAvailable:APP注册信息是否可用<br>
	 *            systemId:业务系统Id
	 * </pre>
	 * @return 是否新增成功
	 *
	 *         <pre>
	 * 成功：返回新增APP新增<b>AppId</b>,失败：返回<b>-1</b>
	 * </pre>
	 */
	@Write
	public Long insertAppInfo(final AppInfoBean app);

	/**
	 * 根据appID删除APP注册信息
	 *
	 * @param appId
	 *            【必选】APP注册信息ID
	 * @return <pre>
	 * 成功：返回删除<b>记录数</b>,失败：返回<b>-1</b>
	 * </pre>
	 */
	@Write
	public default Integer deleteAppInfoByAppId(final Long appId){
        return deleteAppInfoByAppIds(Arrays.asList(appId));
    }

	/**
	 * 根据appID批量删除APP注册信息
	 *
	 * @param appIds
	 *            【必选】APP注册信息ID集合列表
	 * @return <pre>
	 * 成功：返回删除<b>记录数</b>,失败：返回<b>-1</b>
	 * </pre>
	 */
	@Write
	public Integer deleteAppInfoByAppIds(List<Long> appIds);

	/**
	 * 根据appCode删除APP注册信息
	 *
	 * @param appCode
	 *            【必选】APP注册信息code
	 * @return <pre>
	 * 成功：返回删除<b>记录数</b>,失败：返回<b>-1</b>
	 * </pre>
	 */
	@Write
	public default Long deleteAppInfoByAppCode(final String appCode){
        return deleteAppInfoByAppCodes(Arrays.asList(appCode));
    }

	/**
	 * 根据appCode批量删除APP注册信息
	 *
	 * @param appCodes
	 *            【必选】APP注册信息code列表
	 * @return <pre>
	 * 成功：返回删除<b>记录数</b>,失败：返回<b>-1</b>
	 * </pre>
	 */
	@Write
	public Long deleteAppInfoByAppCodes(final List<String> appCodes);

	/**
	 * 修改APP注册信息
	 *
	 * @param app
	 *            APP注册对象
	 *
	 *            <pre>
	 *            	参数信息：<br>
	 *            appId:APP注册信息ID<br>
	 *            appCode:APP注册信息code<br>
	 *            appName:APP注册信息名称<br>
	 *            appOS:APP注册信息描述<br>
	 *            isAvailable:APP注册信息是否可用<br>
	 *            systemId:业务系统Id
	 * </pre>
	 * @return 是否新增成功
	 *
	 *         <pre>
	 * 成功：返回更新<b>记录数</b>,失败：返回<b>-1</b>
	 * </pre>
	 */
	@Write
	public String updateAppInfo(final AppInfoBean app);

	/**
	 * 根据appCode 更新APP注册信息
	 *
	 * 【必选】系统Code 所对应业务系统中系统的code
	 *
	 * @param appCode
	 *            【必选】APP注册信息code
	 * @param appName
	 *            【必选】APP注册信息名称
	 * @param appOS
	 *            【必选】APP注册信息描述
	 * @param systemId
	 *            【必选】系统Id 所对应业务系统中系统的Id
	 *
	 * @return <pre>
	 * 成功：返回更新<b>记录数</b>,失败：返回<b>-1</b>
	 * </pre>
	 */
	@Write
	public default String updateAppInfoByAppCode(final String appCode, final String appName, final String appOS,
										 final Long systemId){
        AppInfoBean app = new AppInfoBean();
        app.setAppCode(appCode);
        app.setAppName(appName);
        app.setAppOs(appOS);
        app.setSystemId(systemId);
        return updateAppInfo(app);
    }

	// ==========================================【重载overload】
	/**
	 * check全局是否有重复APP注册信息
	 *
	 * @param appId
	 *            【必选】APP注册信息ID
	 * @param appCode
	 *            【必选】APP注册信息code
	 * @param appName
	 *            【必选】APP注册信息名称
	 * @return 是否存在重复信息
	 */
	public default String checkAppInfo(final Long appId, final String appCode, final String appName){
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("appId", appId);
        parameter.put("appName", appName);
        parameter.put("appName", appName);
        return checkAppInfo(parameter);
    }

	/**
	 * 查询APP注册信息(不分页) 如需分页 {@link #queryAppInfoByPager(Map)}
	 *
	 * @param parameter
	 *            参数列表 <br>
	 *            【appId】:APP注册信息Id<br>
	 *            【模糊匹配、区分大小写】appCode:APP注册信息code<br>
	 *            【模糊匹配】appName:APP注册信息名称<br>
	 *            【appOS】:APP注册信息描述<br>
	 *            【systemId】:业务系统Id<br>
	 *            【isAvailable】:APP注册信息是否可用<br>
	 *            【systemCode】:业务系统code<br>
	 *            【systemName】:业务系统ID<br>
	 *
	 * @return APP注册信息列表以<b>Page</b>展示
	 */
	@Read
	public List<AppInfoBean> queryAppInfo(final Map<String, Object> parameter);

	/**
	 * 查询APP注册信息(不分页) 如需分页 {@link #queryAppInfoByPager(Map)}
	 *
	 * @param isAppAvailable
	 *            APP是否可用 默认查询全部 true：可用 false：不可用 null：全部
	 * @return APP注册信息列表以<b>Page</b>展示
	 */
	@Read
	public default List<AppInfoBean> queryAppInfo(Boolean isAppAvailable){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isAppAvailable", isAppAvailable);
        return this.queryAppInfo(map);
    }

	/**
	 * 根据系统Id、appCode、系统是否可用以及app是否可用获取app注册信息列表
	 *
	 * @param systemId
	 *            【必选】所对应业务系统的ID
	 * @return APP注册信息列表以<b>List</b>展示
	 */
	@Read
	public default List<AppInfoBean> getAppInfoList(final Long systemId){
        return getAppInfoList(systemId, (Long) null, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据AppId获取APP注册信息
	 *
	 * @param systemId
	 *            【必选】系统ID 所对应业务系统中系统的ID
	 * @param appId
	 *            【必选】APP注册信息ID
	 * @return APP注册信息对象
	 */
	@Read
	public default AppInfoBean getAppInfoByAppId(final Long systemId, final Long appId){
        return getAppInfoByAppId(systemId, appId, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据AppId 获取手机APP注册信息
	 *
	 * @param appId
	 *            appId
	 * @return 手机APP注册信息
	 */
	public default AppInfoBean getAppInfoByAppId(final Long appId){
        return getAppInfoByAppId((Long) null, appId);
    }

	/**
	 * 根据AppId获取APP注册信息
	 *
	 * @param systemCode
	 *            【必选】系统Code 所对应业务系统中系统的code
	 * @param appId
	 *            【必选】APP注册信息ID
	 * @return APP注册信息对象
	 */
	@Read
	public default AppInfoBean getAppInfoByAppId(final String systemCode, final Long appId){
        return getAppInfoByAppId(systemCode, appId, Boolean.TRUE, Boolean.TRUE);
    }

	/**
	 * 根据appCode获取APP注册信息
	 *
	 * @param systemId
	 *            【必选】APP注册信息code
	 * @param appCode
	 *            【必选】APP注册信息CODE
	 * @return APP注册信息对象
	 */
	@Read
	public default AppInfoBean getAppInfoByAppCode(final Long systemId, final String appCode){
        return getAppInfoByAppCode(systemId, appCode, Boolean.TRUE, Boolean.TRUE);
    }

}
