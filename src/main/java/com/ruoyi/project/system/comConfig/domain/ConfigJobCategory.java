package com.ruoyi.project.system.comConfig.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 职位分类 config_job_category
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public class ConfigJobCategory extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 分类名字  （简单上手，在家 躺赚，轻松兼职，极速可做） */
	private String jobCategory;
	/** 状态  0  可用  1 停用 */
	private Integer status;
	/** 类型  0  分类普通  1 H5跳转 */
	private Integer type;
	/** 图标地址  */
	private String icon;
	/** 跳转链接 */
	private String url;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setJobCategory(String jobCategory) 
	{
		this.jobCategory = jobCategory;
	}

	public String getJobCategory() 
	{
		return jobCategory;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
