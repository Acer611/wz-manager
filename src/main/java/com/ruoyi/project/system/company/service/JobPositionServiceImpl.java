package com.ruoyi.project.system.company.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.system.company.domain.JobPosition;
import com.ruoyi.project.system.company.mapper.JobPositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 公司职位信息 服务层实现
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Service
public class JobPositionServiceImpl implements IJobPositionService 
{
	@Autowired
	private JobPositionMapper jobPositionMapper;

	/**
     * 查询公司职位信息信息
     * 
     * @param id 公司职位信息ID
     * @return 公司职位信息信息
     */
    @Override
	public JobPosition selectJobPositionById(Long id)
	{
	    return jobPositionMapper.selectJobPositionById(id);
	}
	
	/**
     * 查询公司职位信息列表
     * 
     * @param jobPosition 公司职位信息信息
     * @return 公司职位信息集合
     */
	@Override
	public List<JobPosition> selectJobPositionList(JobPosition jobPosition)
	{
	    return jobPositionMapper.selectJobPositionList(jobPosition);
	}
	
    /**
     * 新增公司职位信息
     * 
     * @param jobPosition 公司职位信息信息
     * @return 结果
     */
	@Override
	public int insertJobPosition(JobPosition jobPosition)
	{

		Integer cityId = jobPosition.getLocation();

		Integer provinceId = 0;
		if(null!=cityId){
			provinceId = jobPositionMapper.findProviceId(cityId);
		}
		jobPosition.setProvinceId(provinceId);
	    return jobPositionMapper.insertJobPosition(jobPosition);
	}
	
	/**
     * 修改公司职位信息
     * 
     * @param jobPosition 公司职位信息信息
     * @return 结果
     */
	@Override
	public int updateJobPosition(JobPosition jobPosition)
	{
	    return jobPositionMapper.updateJobPosition(jobPosition);
	}

	/**
     * 删除公司职位信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteJobPositionByIds(String ids)
	{
		return jobPositionMapper.deleteJobPositionByIds(Convert.toStrArray(ids));
	}

	/**
	 * 获取职位分类列表
	 * @return
	 */
	@Override
	public List<Map> getJobTitleList() {
		return jobPositionMapper.getJobTitleList();
	}

	/**
	 * 获取城市信息
	 * @return
	 */
	@Override
	public List<Map> getCityList() {
		return jobPositionMapper.getCityList();
	}

	/**
	 * 获取职位标签
	 * @return
	 */
	@Override
	public List<Map> getJobLabelList() {
		return jobPositionMapper.getJobLabelList();
	}

	/**
	 * 获取职位分类信息
	 * @return
	 */
	@Override
	public List<Map> getJobCategoryList() {
		return jobPositionMapper.getJobCategoryList();
	}

	/**
	 * 获取客服雷彪
	 * @return
	 */
	@Override
	public List<Map> getKFList() {
		return jobPositionMapper.getKFList();
	}

}
