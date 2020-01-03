package com.ruoyi.project.system.tuser.controller;

import java.util.List;

import com.ruoyi.project.system.tuser.domain.TUser;
import com.ruoyi.project.system.tuser.service.ITUserService;
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
 * 注册用户管理信息操作处理
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/user/tUser")
public class TUserController extends BaseController
{
    private String prefix = "tUser";
	
	@Autowired
	private ITUserService tUserService;
	
	@RequiresPermissions("user:tUser:view")
	@GetMapping()
	public String tUser()
	{
	    return prefix + "/tUser";
	}
	
	/**
	 * 查询注册用户管理列表
	 */
	@RequiresPermissions("user:tUser:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TUser tUser)
	{
		startPage();
        List<TUser> list = tUserService.selectTUserList(tUser);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出注册用户管理列表
	 */
	@RequiresPermissions("user:tUser:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TUser tUser)
    {
    	List<TUser> list = tUserService.selectTUserList(tUser);
        ExcelUtil<TUser> util = new ExcelUtil<TUser>(TUser.class);
        return util.exportExcel(list, "tUser");
    }
	
	/**
	 * 新增注册用户管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存注册用户管理
	 */
	@RequiresPermissions("user:tUser:add")
	@Log(title = "注册用户管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TUser tUser)
	{		
		return toAjax(tUserService.insertTUser(tUser));
	}

	/**
	 * 修改注册用户管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TUser tUser = tUserService.selectTUserById(id);
		mmap.put("tUser", tUser);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存注册用户管理
	 */
	@RequiresPermissions("user:tUser:edit")
	@Log(title = "注册用户管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TUser tUser)
	{		
		return toAjax(tUserService.updateTUser(tUser));
	}
	
	/**
	 * 删除注册用户管理
	 */
	@RequiresPermissions("user:tUser:remove")
	@Log(title = "注册用户管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tUserService.deleteTUserByIds(ids));
	}
	
}
