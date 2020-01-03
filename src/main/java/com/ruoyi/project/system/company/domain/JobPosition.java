package com.ruoyi.project.system.company.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 公司职位信息 job_position
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public class JobPosition extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 公司ID */
	private Long companyId;
	/** 公司ID */
	private Long sourceId;
	/** 客服ID */
	private Long kfId;
	/** 职位标题 */
	private String title;
	/** 类型 （长期可做  短期 ） */
	private String type;
	/** 结算方式（300元/天） */
	private String cleanType;
	/** 招聘人数 */
	private Integer needPeople;
	/** 已录取人数 */
	private Integer hasPeople;
	/** 报名人数 */
	private Integer reportPeople;
	/** 薪资 */
	private String money;
	/** 工作要求（兼职  性别） */
	private String jobRequired;
	/** 任务类型（服务员  收银员,关联jobTitledetail 的id ） */
	private Integer taskType;
	/** 工作流程 */
	private String workflow;
	/** 职位详情 */
	private String jobDetail;
	/** 工作详细地点 */
	private String address;
	/** 位置  关联city 表的id */
	private Integer location;
	/** 职位标签（ 0  火爆  1 急聘   2  热门） */
	private Integer lable;
	/** 职位分类  （1 简单  2 躺赚 3 轻松   4 极速 关联 config_job_category 的ID） */
	private Integer category;
	/** 发布时间 */
	private Date publishTime;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 是否是热门推荐  0 不是  1 是 */
	private Integer isHot;
	/** 省份的ID */
	private Integer provinceId;


	private String locationName;
	private String lableName;
	private String jobCategory;
	private String companyName;
	private String jobTitle;


	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getKfId() {
		return kfId;
	}

	public void setKfId(Long kfId) {
		this.kfId = kfId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCleanType() {
		return cleanType;
	}

	public void setCleanType(String cleanType) {
		this.cleanType = cleanType;
	}

	public Integer getNeedPeople() {
		return needPeople;
	}

	public void setNeedPeople(Integer needPeople) {
		this.needPeople = needPeople;
	}

	public Integer getHasPeople() {
		return hasPeople;
	}

	public void setHasPeople(Integer hasPeople) {
		this.hasPeople = hasPeople;
	}

	public Integer getReportPeople() {
		return reportPeople;
	}

	public void setReportPeople(Integer reportPeople) {
		this.reportPeople = reportPeople;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getJobRequired() {
		return jobRequired;
	}

	public void setJobRequired(String jobRequired) {
		this.jobRequired = jobRequired;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public String getWorkflow() {
		return workflow;
	}

	public void setWorkflow(String workflow) {
		this.workflow = workflow;
	}

	public String getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(String jobDetail) {
		this.jobDetail = jobDetail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Integer getLable() {
		return lable;
	}

	public void setLable(Integer lable) {
		this.lable = lable;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@Override
	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public Date getUpdateTime() {
		return updateTime;
	}

	@Override
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLableName() {
		return lableName;
	}

	public void setLableName(String lableName) {
		this.lableName = lableName;
	}

	public String getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
}
