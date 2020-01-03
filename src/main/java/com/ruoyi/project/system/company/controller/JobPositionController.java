package com.ruoyi.project.system.company.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.company.domain.JobPosition;
import com.ruoyi.project.system.company.service.IJobPositionService;
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
 * 公司职位信息操作处理
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Controller
@RequestMapping("/job/jobPosition")
public class JobPositionController extends BaseController
{
    private String prefix = "job";
	
	@Autowired
	private IJobPositionService jobPositionService;
	
	@RequiresPermissions("job:jobPosition:view")
	@GetMapping()
	public String jobPosition()
	{
	    return prefix + "/allJob";
	}
	
	/**
	 * 查询公司职位信息列表
	 */
	@RequiresPermissions("job:jobPosition:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(JobPosition jobPosition)
	{
		startPage();
        List<JobPosition> list = jobPositionService.selectJobPositionList(jobPosition);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出公司职位信息列表
	 */
	@RequiresPermissions("job:jobPosition:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(JobPosition jobPosition)
    {
    	List<JobPosition> list = jobPositionService.selectJobPositionList(jobPosition);
        ExcelUtil<JobPosition> util = new ExcelUtil<JobPosition>(JobPosition.class);
        return util.exportExcel(list, "jobPosition");
    }
	
	/**
	 * 新增公司职位信息
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	/**
	 * 新增招聘职位信息
	 */
	@GetMapping("/addNewJob/{companyId}")
	public String addNewJob(@PathVariable("companyId") Long companyId,ModelMap mmap)
	{

		mmap.put("companyId", companyId);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存公司职位信息
	 */
	@RequiresPermissions("job:jobPosition:add")
	@Log(title = "公司职位信息", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(JobPosition jobPosition)
	{
		jobPosition.setCreateTime(new Date());
		jobPosition.setUpdateTime(new Date());
		jobPosition.setPublishTime(new Date());
		return toAjax(jobPositionService.insertJobPosition(jobPosition));
	}

	/**
	 * 修改公司职位信息
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		JobPosition jobPosition = jobPositionService.selectJobPositionById(id);
		mmap.put("jobPosition", jobPosition);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公司职位信息
	 */
	@RequiresPermissions("job:jobPosition:edit")
	@Log(title = "公司职位信息", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(JobPosition jobPosition)
	{		
		return toAjax(jobPositionService.updateJobPosition(jobPosition));
	}
	
	/**
	 * 删除公司职位信息
	 */
	@RequiresPermissions("job:jobPosition:remove")
	@Log(title = "公司职位信息", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(jobPositionService.deleteJobPositionByIds(ids));
	}

	/**
	 * 获取职位Title信息列表
	 * @return
	 */
	@PostMapping("/getJobTitleList")
	@ResponseBody
	public List<Map> getJobTitleList()
	{
		return jobPositionService.getJobTitleList();
	}

	/**
	 * 获取城市信息列表
	 * @return
	 */
	@PostMapping("/getCityList")
	@ResponseBody
	public List<Map> getCityList()
	{
		return jobPositionService.getCityList();
	}


	/**
	 * 获取职位信息列表
	 * @return
	 */
	@PostMapping("/getJobLabelList")
	@ResponseBody
	public List<Map> getJobLabelList()
	{
		return jobPositionService.getJobLabelList();
	}


	/**
	 * 获取职位分类列表
	 * @return
	 */
	@PostMapping("/getJobCategoryList")
	@ResponseBody
	public List<Map> getJobCategoryList()
	{
		return jobPositionService.getJobCategoryList();
	}


	/**
	 * 跳转分配客服页面
	 * @param id
	 * @param mmap
	 * @return
	 */
	@GetMapping("/authKF/{id}")
	public String resetPwd(@PathVariable("id") Long id, ModelMap mmap)
	{
		mmap.put("jobInfo", jobPositionService.selectJobPositionById(id));
		return prefix + "/authKF";
	}
	/**
	 * 获取客服列表
	 * @return
	 */
	@PostMapping("/getKFList")
	@ResponseBody
	public List<Map> getKFList()
	{
		return jobPositionService.getKFList();
	}

}
