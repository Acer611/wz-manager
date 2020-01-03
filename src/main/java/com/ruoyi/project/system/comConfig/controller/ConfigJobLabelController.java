package com.ruoyi.project.system.comConfig.controller;

import java.util.List;

import com.ruoyi.project.system.comConfig.domain.ConfigJobLabel;
import com.ruoyi.project.system.comConfig.service.IConfigJobLabelService;
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
 * 职位标签信息操作处理
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/config/configJobLabel")
public class ConfigJobLabelController extends BaseController
{
    private String prefix = "comConfig/configJobLabel";
	
	@Autowired
	private IConfigJobLabelService configJobLabelService;
	
	@RequiresPermissions("config:configJobLabel:view")
	@GetMapping()
	public String configJobLabel()
	{
	    return prefix + "/configJobLabel";
	}
	
	/**
	 * 查询职位标签列表
	 */
	@RequiresPermissions("config:configJobLabel:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ConfigJobLabel configJobLabel)
	{
		startPage();
        List<ConfigJobLabel> list = configJobLabelService.selectConfigJobLabelList(configJobLabel);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出职位标签列表
	 */
	@RequiresPermissions("config:configJobLabel:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ConfigJobLabel configJobLabel)
    {
    	List<ConfigJobLabel> list = configJobLabelService.selectConfigJobLabelList(configJobLabel);
        ExcelUtil<ConfigJobLabel> util = new ExcelUtil<ConfigJobLabel>(ConfigJobLabel.class);
        return util.exportExcel(list, "configJobLabel");
    }
	
	/**
	 * 新增职位标签
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存职位标签
	 */
	@RequiresPermissions("config:configJobLabel:add")
	@Log(title = "职位标签", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ConfigJobLabel configJobLabel)
	{		
		return toAjax(configJobLabelService.insertConfigJobLabel(configJobLabel));
	}

	/**
	 * 修改职位标签
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		ConfigJobLabel configJobLabel = configJobLabelService.selectConfigJobLabelById(id);
		mmap.put("configJobLabel", configJobLabel);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存职位标签
	 */
	@RequiresPermissions("config:configJobLabel:edit")
	@Log(title = "职位标签", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ConfigJobLabel configJobLabel)
	{		
		return toAjax(configJobLabelService.updateConfigJobLabel(configJobLabel));
	}
	
	/**
	 * 删除职位标签
	 */
	@RequiresPermissions("config:configJobLabel:remove")
	@Log(title = "职位标签", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(configJobLabelService.deleteConfigJobLabelByIds(ids));
	}
	
}
