package com.ruoyi.project.system.company.mapper;

import com.ruoyi.project.system.company.domain.JobPosition;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 公司职位信息 数据层
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public interface JobPositionMapper 
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
     * 删除公司职位信息
     * 
     * @param id 公司职位信息ID
     * @return 结果
     */
	public int deleteJobPositionById(Long id);
	
	/**
     * 批量删除公司职位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteJobPositionByIds(String[] ids);

	/**
	 * 获取职位title的列表
	 * @return
	 */
	@Select("SELECT * from job_title_detail ")
    List<Map> getJobTitleList();

	/**
	 * 获取城市信息
	 * @return
	 */
	@Select("SELECT * from t_city")
	List<Map> getCityList();

	/**
	 * 获取职位label
	 * @return
	 */
	@Select("SELECT * FROM config_job_label")
    List<Map> getJobLabelList();

	/**
	 * 获取职位分类信息
	 * @return
	 */
	@Select("SELECT * FROM config_job_category where type =0")
	List<Map> getJobCategoryList();

	/**
	 * 获取所有客服信息
	 * @return
	 */
	@Select("SELECT * FROM t_kf_detail")
    List<Map> getKFList();

	/**
	 * 根据城市信息查找省份的ID
	 * @param cityId
	 * @return
	 */
	@Select("SELECT provinceId from t_city where provinceId =#{cityId} ")
    Integer findProviceId(Integer cityId);
}