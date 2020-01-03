package com.ruoyi.project.system.version.controller;

import java.util.List;

import com.ruoyi.project.system.version.domain.TVersion;
import com.ruoyi.project.system.version.service.ITVersionService;
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
 * 版本控制信息操作处理
 * 
 * @author ruoyi
 * @date 2019-11-28
 */
@Controller
@RequestMapping("/version/tVersion")
public class TVersionController extends BaseController
{
    private String prefix = "tVersion";
	
	@Autowired
	private ITVersionService tVersionService;
	
	@RequiresPermissions("version:tVersion:view")
	@GetMapping()
	public String tVersion()
	{
	    return prefix + "/tVersion";
	}
	
	/**
	 * 查询版本控制列表
	 */
	@RequiresPermissions("version:tVersion:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TVersion tVersion)
	{
		startPage();
        List<TVersion> list = tVersionService.selectTVersionList(tVersion);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出版本控制列表
	 */
	@RequiresPermissions("version:tVersion:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TVersion tVersion)
    {
    	List<TVersion> list = tVersionService.selectTVersionList(tVersion);
        ExcelUtil<TVersion> util = new ExcelUtil<TVersion>(TVersion.class);
        return util.exportExcel(list, "tVersion");
    }
	
	/**
	 * 新增版本控制
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存版本控制
	 */
	@RequiresPermissions("version:tVersion:add")
	@Log(title = "版本控制", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TVersion tVersion)
	{		
		return toAjax(tVersionService.insertTVersion(tVersion));
	}

	/**
	 * 修改版本控制
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TVersion tVersion = tVersionService.selectTVersionById(id);
		mmap.put("tVersion", tVersion);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存版本控制
	 */
	@RequiresPermissions("version:tVersion:edit")
	@Log(title = "版本控制", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TVersion tVersion)
	{		
		return toAjax(tVersionService.updateTVersion(tVersion));
	}
	
	/**
	 * 删除版本控制
	 */
	@RequiresPermissions("version:tVersion:remove")
	@Log(title = "版本控制", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tVersionService.deleteTVersionByIds(ids));
	}
	
}
