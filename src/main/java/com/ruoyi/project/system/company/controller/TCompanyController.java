package com.ruoyi.project.system.company.controller;

import java.util.List;

import com.ruoyi.project.system.company.domain.TCompany;
import com.ruoyi.project.system.company.service.ITCompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 公司信息信息操作处理
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/company/tCompany")
public class TCompanyController extends BaseController
{
    private String prefix = "company";
	private String prefixJob = "job";
	
	@Autowired
	private ITCompanyService tCompanyService;
	
	@RequiresPermissions("company:tCompany:view")
	@GetMapping()
	public String tCompany()
	{
	    return prefix + "/tCompany";
	}
	
	/**
	 * 查询公司信息列表
	 */
	@RequiresPermissions("company:tCompany:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TCompany tCompany)
	{
		startPage();
        List<TCompany> list = tCompanyService.selectTCompanyList(tCompany);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出公司信息列表
	 */
	@RequiresPermissions("company:tCompany:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TCompany tCompany)
    {
    	List<TCompany> list = tCompanyService.selectTCompanyList(tCompany);
        ExcelUtil<TCompany> util = new ExcelUtil<TCompany>(TCompany.class);
        return util.exportExcel(list, "tCompany");
    }
	
	/**
	 * 新增公司信息
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存公司信息
	 */
	@RequiresPermissions("company:tCompany:add")
	@Log(title = "公司信息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TCompany tCompany)
	{		
		return toAjax(tCompanyService.insertTCompany(tCompany));
	}

	/**
	 * 修改公司信息
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TCompany tCompany = tCompanyService.selectTCompanyById(id);
		mmap.put("tCompany", tCompany);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公司信息
	 */
	@RequiresPermissions("company:tCompany:edit")
	@Log(title = "公司信息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TCompany tCompany)
	{		
		return toAjax(tCompanyService.updateTCompany(tCompany));
	}
	
	/**
	 * 删除公司信息
	 */
	@RequiresPermissions("company:tCompany:remove")
	@Log(title = "公司信息", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tCompanyService.deleteTCompanyByIds(ids));
	}



	/**
	 * 公司在招职位信息
	 */
	@GetMapping("/onLineJob/{id}")
	public String onLineJob(@PathVariable("id") Long id, ModelMap mmap)
	{
		mmap.put("company", tCompanyService.selectTCompanyBySourceId(id));
		return prefixJob + "/jobPosition";
	}
	
}
