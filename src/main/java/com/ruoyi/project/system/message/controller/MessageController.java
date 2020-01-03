package com.ruoyi.project.system.message.controller;

import java.util.List;

import com.ruoyi.project.system.message.domain.Message;
import com.ruoyi.project.system.message.service.ITMessageService;
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
 * 消息管理信息操作处理
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/message/tMessage")
public class MessageController extends BaseController
{
    private String prefix = "message";
	
	@Autowired
	private ITMessageService tMessageService;
	
	@RequiresPermissions("message:tMessage:view")
	@GetMapping()
	public String tMessage()
	{
	    return prefix + "/tMessage";
	}
	
	/**
	 * 查询消息管理列表
	 */
	@RequiresPermissions("message:tMessage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Message tMessage)
	{
		startPage();
        List<Message> list = tMessageService.selectTMessageList(tMessage);
		return getDataTable(list);
	}


	/**
	 * 导出消息管理列表
	 */
	@RequiresPermissions("message:tMessage:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Message tMessage)
    {
    	List<Message> list = tMessageService.selectTMessageList(tMessage);
        ExcelUtil<Message> util = new ExcelUtil<Message>(Message.class);
        return util.exportExcel(list, "tMessage");
    }

	/**
	 * 新增消息管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	/**
	 * 新增保存消息管理
	 */
	@RequiresPermissions("message:tMessage:add")
	@Log(title = "消息管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Message tMessage)
	{
		return toAjax(tMessageService.insertTMessage(tMessage));
	}

	/**
	 * 修改消息管理
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		Message tMessage = tMessageService.selectTMessageById(id);
		mmap.put("tMessage", tMessage);
	    return prefix + "/edit";
	}

	/**
	 * 修改保存消息管理
	 */
	@RequiresPermissions("message:tMessage:edit")
	@Log(title = "消息管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Message tMessage)
	{
		return toAjax(tMessageService.updateTMessage(tMessage));
	}

	/**
	 * 删除消息管理
	 */
	@RequiresPermissions("message:tMessage:remove")
	@Log(title = "消息管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(tMessageService.deleteTMessageByIds(ids));
	}
	
}
