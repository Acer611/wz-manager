package com.ruoyi.project.system.company.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 公司信息 t_company
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public class TCompany extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Long id;
	/** 公司名称 */
	private String company;
	/** 公司介绍 */
	private String description;
	/** 是否认证  0 未认证  1 已认证 */
	private Integer authentication;
	/** 所在地  关联城市表   */
	private Integer domain;
	/** 企业类型 */
	private String type;
	/** 经营状态 */
	private String status;
	/** 注册资本 */
	private String registeredCapital;
	/** 注册时间 */
	private Date registerDate;
	/** 注册地址 */
	private String address;
	/** 登记机关 */
	private String registrationAuthority;
	/** 统一社会信用代码 */
	private String creditCode;
	/** 组织机构代码 */
	private String groupCode;
	/** 经营范围 */
	private String businessScop;
	/**  创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
	/** 来源公司id */
	private Long companyId;

	//---------------------------------------------------------
	//==========================显示字段=========================
	/** 显示城市名称 */
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Integer authentication) {
		this.authentication = authentication;
	}

	public Integer getDomain() {
		return domain;
	}

	public void setDomain(Integer domain) {
		this.domain = domain;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(String registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegistrationAuthority() {
		return registrationAuthority;
	}

	public void setRegistrationAuthority(String registrationAuthority) {
		this.registrationAuthority = registrationAuthority;
	}

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getBusinessScop() {
		return businessScop;
	}

	public void setBusinessScop(String businessScop) {
		this.businessScop = businessScop;
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

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}
