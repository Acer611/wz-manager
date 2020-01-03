package com.ruoyi.project.system.comConfig.controller;

import java.util.List;

import com.ruoyi.project.system.comConfig.domain.ConfigJobCategory;
import com.ruoyi.project.system.comConfig.service.IConfigJobCategoryService;
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
 * 职位分类信息操作处理
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/config/configJobCategory")
public class ConfigJobCategoryController extends BaseController
{
    private String prefix = "comConfig/configJobCategory";
	
	@Autowired
	private IConfigJobCategoryService configJobCategoryService;
	
	@RequiresPermissions("config:configJobCategory:view")
	@GetMapping()
	public String configJobCategory()
	{
	    return prefix + "/configJobCategory";
	}
	
	/**
	 * 查询职位分类列表
	 */
	@RequiresPermissions("config:configJobCategory:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ConfigJobCategory configJobCategory)
	{
		startPage();
        List<ConfigJobCategory> list = configJobCategoryService.selectConfigJobCategoryList(configJobCategory);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出职位分类列表
	 */
	@RequiresPermissions("config:configJobCategory:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ConfigJobCategory configJobCategory)
    {
    	List<ConfigJobCategory> list = configJobCategoryService.selectConfigJobCategoryList(configJobCategory);
        ExcelUtil<ConfigJobCategory> util = new ExcelUtil<ConfigJobCategory>(ConfigJobCategory.class);
        return util.exportExcel(list, "configJobCategory");
    }
	
	/**
	 * 新增职位分类
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存职位分类
	 */
	@RequiresPermissions("config:configJobCategory:add")
	@Log(title = "职位分类", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ConfigJobCategory configJobCategory)
	{		
		return toAjax(configJobCategoryService.insertConfigJobCategory(configJobCategory));
	}

	/**
	 * 修改职位分类
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		ConfigJobCategory configJobCategory = configJobCategoryService.selectConfigJobCategoryById(id);
		mmap.put("configJobCategory", configJobCategory);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存职位分类
	 */
	@RequiresPermissions("config:configJobCategory:edit")
	@Log(title = "职位分类", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ConfigJobCategory configJobCategory)
	{		
		return toAjax(configJobCategoryService.updateConfigJobCategory(configJobCategory));
	}
	
	/**
	 * 删除职位分类
	 */
	@RequiresPermissions("config:configJobCategory:remove")
	@Log(title = "职位分类", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(configJobCategoryService.deleteConfigJobCategoryByIds(ids));
	}
	
}
