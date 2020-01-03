package com.ruoyi.project.system.article.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 软文信息 t_article
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public class TArticle extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 标题 */
	private String title;
	/** 链接地址 */
	private String url;
	/** 软文内容 */
	private String content;
	/** 是否删除 0 未删除  1  已删除 */
	private Integer status;
	/** 软文标签 */
	private String label;
	/** 阅读次数 */
	private Long readTimes;
	/** 软文icon */
	private String imgUrl;
	/** 创建时间 */
	private Date createTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getReadTimes() {
		return readTimes;
	}

	public void setReadTimes(Long readTimes) {
		this.readTimes = readTimes;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
