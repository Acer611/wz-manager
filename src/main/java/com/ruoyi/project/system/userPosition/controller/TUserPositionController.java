package com.ruoyi.project.system.userPosition.controller;

import java.util.List;

import com.ruoyi.project.system.userPosition.domain.TUserPosition;
import com.ruoyi.project.system.userPosition.service.ITUserPositionService;
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
 * 用户报名信息信息操作处理
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/uerPosition/tUserPosition")
public class TUserPositionController extends BaseController
{
    private String prefix = "tUserPosition";
	
	@Autowired
	private ITUserPositionService tUserPositionService;
	
	@RequiresPermissions("uerPosition:tUserPosition:view")
	@GetMapping()
	public String tUserPosition()
	{
	    return prefix + "/tUserPosition";
	}
	
	/**
	 * 查询用户报名信息列表
	 */
	@RequiresPermissions("uerPosition:tUserPosition:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUserPosition tUserPosition)
	{
		startPage();
        List<TUserPosition> list = tUserPositionService.selectTUserPositionList(tUserPosition);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户报名信息列表
	 */
	@RequiresPermissions("uerPosition:tUserPosition:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TUserPosition tUserPosition)
    {
    	List<TUserPosition> list = tUserPositionService.selectTUserPositionList(tUserPosition);
        ExcelUtil<TUserPosition> util = new ExcelUtil<TUserPosition>(TUserPosition.class);
        return util.exportExcel(list, "tUserPosition");
    }
	
	/**
	 * 新增用户报名信息
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户报名信息
	 */
	@RequiresPermissions("uerPosition:tUserPosition:add")
	@Log(title = "用户报名信息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUserPosition tUserPosition)
	{		
		return toAjax(tUserPositionService.insertTUserPosition(tUserPosition));
	}

	/**
	 * 修改用户报名信息
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TUserPosition tUserPosition = tUserPositionService.selectTUserPositionById(id);
		mmap.put("tUserPosition", tUserPosition);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户报名信息
	 */
	@RequiresPermissions("uerPosition:tUserPosition:edit")
	@Log(title = "用户报名信息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUserPosition tUserPosition)
	{		
		return toAjax(tUserPositionService.updateTUserPosition(tUserPosition));
	}
	
	/**
	 * 删除用户报名信息
	 */
	@RequiresPermissions("uerPosition:tUserPosition:remove")
	@Log(title = "用户报名信息", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserPositionService.deleteTUserPositionByIds(ids));
	}
	
}
