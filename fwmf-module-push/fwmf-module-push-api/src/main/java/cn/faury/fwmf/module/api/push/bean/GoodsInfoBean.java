package cn.faury.fwmf.module.api.push.bean;

import cn.faury.fdk.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * 商品信息Bean
 */
public class GoodsInfoBean implements Serializable {

	/**
	 * 商品ID
	 */
	private Long goodsId = null;

	/**
	 * 商品名称
	 */
	private String goodsName = null;

	/**
	 * 获取goodsId
	 *
	 * @return goodsId
	 */
	public Long getGoodsId() {
		return goodsId;
	}

	/**
	 * 设置goodsId
	 *
	 * @param goodsId 值
	 */
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * 获取goodsName
	 *
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * 设置goodsName
	 *
	 * @param goodsName 值
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Override
	public String toString() {
		return JsonUtil.objectToJson(this);
	}

}
