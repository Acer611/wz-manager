package com.ruoyi.project.system.company.service;

import com.ruoyi.project.system.company.domain.JobPosition;
import java.util.List;
import java.util.Map;

/**
 * 公司职位信息 服务层
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public interface IJobPositionService 
{
	/**
     * 查询公司职位信息信息
     * 
     * @param id 公司职位信息ID
     * @return 公司职位信息信息
     */
	public JobPosition selectJobPositionById(Long id);
	
	/**
     * 查询公司职位信息列表
     * 
     * @param jobPosition 公司职位信息信息
     * @return 公司职位信息集合
     */
	public List<JobPosition> selectJobPositionList(JobPosition jobPosition);
	
	/**
     * 新增公司职位信息
     * 
     * @param jobPosition 公司职位信息信息
     * @return 结果
     */
	public int insertJobPosition(JobPosition jobPosition);
	
	/**
     * 修改公司职位信息
     * 
     * @param jobPosition 公司职位信息信息
     * @return 结果
     */
	public int updateJobPosition(JobPosition jobPosition);
		
	/**
     * 删除公司职位信息信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteJobPositionByIds(String ids);

	/**
	 * 获取职位分类列表
	 * @return
	 */
    List<Map> getJobTitleList();

	/**
	 * 获取城市信息
	 * @return
	 */
	List<Map> getCityList();

	/**
	 * 获取职位label
	 * @return
	 */
    List<Map> getJobLabelList();

	/**
	 * 获取职位分类
	 * @return
	 */
	List<Map> getJobCategoryList();

	/**
	 * 获取客服列表
	 * @return
	 */
    List<Map> getKFList();
}
