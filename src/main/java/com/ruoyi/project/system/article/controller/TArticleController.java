package com.ruoyi.project.system.article.controller;

import java.util.List;

import com.ruoyi.project.system.article.domain.TArticle;
import com.ruoyi.project.system.article.service.ITArticleService;
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
 * 软文信息信息操作处理
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/article/tArticle")
public class TArticleController extends BaseController
{
    private String prefix = "tArticle";
	
	@Autowired
	private ITArticleService tArticleService;
	
	@RequiresPermissions("article:tArticle:view")
	@GetMapping()
	public String tArticle()
	{
	    return prefix + "/tArticle";
	}
	
	/**
	 * 查询软文信息列表
	 */
	@RequiresPermissions("article:tArticle:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TArticle tArticle)
	{
		startPage();
        List<TArticle> list = tArticleService.selectTArticleList(tArticle);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出软文信息列表
	 */
	@RequiresPermissions("article:tArticle:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TArticle tArticle)
    {
    	List<TArticle> list = tArticleService.selectTArticleList(tArticle);
        ExcelUtil<TArticle> util = new ExcelUtil<TArticle>(TArticle.class);
        return util.exportExcel(list, "tArticle");
    }
	
	/**
	 * 新增软文信息
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存软文信息
	 */
	@RequiresPermissions("article:tArticle:add")
	@Log(title = "软文信息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TArticle tArticle)
	{		
		return toAjax(tArticleService.insertTArticle(tArticle));
	}

	/**
	 * 修改软文信息
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TArticle tArticle = tArticleService.selectTArticleById(id);
		mmap.put("tArticle", tArticle);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存软文信息
	 */
	@RequiresPermissions("article:tArticle:edit")
	@Log(title = "软文信息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TArticle tArticle)
	{		
		return toAjax(tArticleService.updateTArticle(tArticle));
	}
	
	/**
	 * 删除软文信息
	 */
	@RequiresPermissions("article:tArticle:remove")
	@Log(title = "软文信息", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tArticleService.deleteTArticleByIds(ids));
	}
	
}
