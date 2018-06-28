package cn.faury.fwmf.module.api.app.bean;


/**
 * 用户关联App对象Bean
 */
public class UserRAppInfoBean extends AppInfoBean {

	/**
	 * 唯一主键
	 */
	private Long id;

	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 如果按照用户来合并所有的授权APP， 则保存合并后的多个ID，以逗号隔开
	 */
	private String concatAppIds;

	/**
	 * 如果按照用户来合并所有的授权APP， 则保存合并后的多个名称，以逗号隔开
	 */
	private String concatAppNames;

	/**
	 * @return the id
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userId
	 */
	public final Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public final void setUserId(Long userId) {
		this.userId = userId;
	}


	/**
	 * @return the concatAppIds
	 */
	public final String getConcatAppIds() {
		return concatAppIds;
	}

	/**
	 * @param concatAppIds
	 *            the concatAppIds to set
	 */
	public final void setConcatAppIds(String concatAppIds) {
		this.concatAppIds = concatAppIds;
	}


	/**
	 * @return the concatAppNames
	 */
	public final String getConcatAppNames() {
		return concatAppNames;
	}

	
    /**
	 * @param concatAppNames
	 *            the concatAppNames to set
	 */
	public final void setConcatAppNames(String concatAppNames) {
		this.concatAppNames = concatAppNames;
	}


}
