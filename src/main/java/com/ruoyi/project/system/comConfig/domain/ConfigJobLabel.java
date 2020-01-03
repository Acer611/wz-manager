package com.ruoyi.project.system.comConfig.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 职位标签 config_job_label
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public class ConfigJobLabel extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 职位标签（ 0  火爆  1 急聘   2  热门） */
	private String lable;
	/** 状态  0 启用   1  停用 */
	private Integer status;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setLable(String lable) 
	{
		this.lable = lable;
	}

	public String getLable() 
	{
		return lable;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("lable", getLable())
            .append("status", getStatus())
            .toString();
    }
}
