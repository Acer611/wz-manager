package com.ruoyi.project.system.kfDetail.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 客服详情 t_kf_detail
 * 
 * @author ruoyi
 * @date 2019-11-20
 */
public class TKfDetail extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 客服配置表的ID   关联 t_kf_config表的ID */
	private Long confId;
	/** qq */
	private String qq;
	/** 微信 */
	private String wechat;
	/** 支付宝 */
	private String aliPay;
	/** 客服名称 */
	private String name;
	/** 客服url */
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConfId() {
		return confId;
	}

	public void setConfId(Long confId) {
		this.confId = confId;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getAliPay() {
		return aliPay;
	}

	public void setAliPay(String aliPay) {
		this.aliPay = aliPay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
