package com.ruoyi.project.system.version.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 版本控制 t_version
 * 
 * @author ruoyi
 * @date 2019-11-28
 */
public class TVersion extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Long id;
	/** 1 iso  2 android */
	private Integer type;
	/** 最新的版本 */
	private String newVersion;
	/** 最低使用版本 */
	private String lastVersion;
	/** 更新内容 */
	private String content;
	/** 更新链接 */
	private String url;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}

	public Integer getType() 
	{
		return type;
	}
	public void setNewVersion(String newVersion) 
	{
		this.newVersion = newVersion;
	}

	public String getNewVersion() 
	{
		return newVersion;
	}
	public void setLastVersion(String lastVersion) 
	{
		this.lastVersion = lastVersion;
	}

	public String getLastVersion() 
	{
		return lastVersion;
	}
	public void setContent(String content) 
	{
		this.content = content;
	}

	public String getContent() 
	{
		return content;
	}
	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("newVersion", getNewVersion())
            .append("lastVersion", getLastVersion())
            .append("content", getContent())
            .append("url", getUrl())
            .toString();
    }
}
