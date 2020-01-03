package com.ruoyi.project.system.kfDetail.controller;

import java.util.List;

import com.ruoyi.project.system.kfDetail.domain.TKfDetail;
import com.ruoyi.project.system.kfDetail.service.ITKfDetailService;
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
 * 客服详情信息操作处理
 * 
 * @author ruoyi
 * @date 2019-11-20
 */
@Controller
@RequestMapping("/kf/tKfDetail")
public class TKfDetailController extends BaseController
{
    private String prefix = "kf/tKfDetail";
	
	@Autowired
	private ITKfDetailService tKfDetailService;
	
	@RequiresPermissions("kf:tKfDetail:view")
	@GetMapping()
	public String tKfDetail()
	{
	    return prefix + "/tKfDetail";
	}
	
	/**
	 * 查询客服详情列表
	 */
	@RequiresPermissions("kf:tKfDetail:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TKfDetail tKfDetail)
	{
		startPage();
        List<TKfDetail> list = tKfDetailService.selectTKfDetailList(tKfDetail);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出客服详情列表
	 */
	@RequiresPermissions("kf:tKfDetail:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TKfDetail tKfDetail)
    {
    	List<TKfDetail> list = tKfDetailService.selectTKfDetailList(tKfDetail);
        ExcelUtil<TKfDetail> util = new ExcelUtil<TKfDetail>(TKfDetail.class);
        return util.exportExcel(list, "tKfDetail");
    }
	
	/**
	 * 新增客服详情
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存客服详情
	 */
	@RequiresPermissions("kf:tKfDetail:add")
	@Log(title = "客服详情", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TKfDetail tKfDetail)
	{		
		return toAjax(tKfDetailService.insertTKfDetail(tKfDetail));
	}

	/**
	 * 修改客服详情
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TKfDetail tKfDetail = tKfDetailService.selectTKfDetailById(id);
		mmap.put("tKfDetail", tKfDetail);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存客服详情
	 */
	@RequiresPermissions("kf:tKfDetail:edit")
	@Log(title = "客服详情", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TKfDetail tKfDetail)
	{		
		return toAjax(tKfDetailService.updateTKfDetail(tKfDetail));
	}
	
	/**
	 * 删除客服详情
	 */
	@RequiresPermissions("kf:tKfDetail:remove")
	@Log(title = "客服详情", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tKfDetailService.deleteTKfDetailByIds(ids));
	}
	
}
