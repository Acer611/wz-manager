package com.ruoyi.project.system.comConfig.mapper;

import com.ruoyi.project.system.comConfig.domain.ConfigJobCategory;
import java.util.List;

/**
 * 职位分类 数据层
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public interface ConfigJobCategoryMapper 
{
	/**
     * 查询职位分类信息
     * 
     * @param id 职位分类ID
     * @return 职位分类信息
     */
	public ConfigJobCategory selectConfigJobCategoryById(Integer id);
	
	/**
     * 查询职位分类列表
     * 
     * @param configJobCategory 职位分类信息
     * @return 职位分类集合
     */
	public List<ConfigJobCategory> selectConfigJobCategoryList(ConfigJobCategory configJobCategory);
	
	/**
     * 新增职位分类
     * 
     * @param configJobCategory 职位分类信息
     * @return 结果
     */
	public int insertConfigJobCategory(ConfigJobCategory configJobCategory);
	
	/**
     * 修改职位分类
     * 
     * @param configJobCategory 职位分类信息
     * @return 结果
     */
	public int updateConfigJobCategory(ConfigJobCategory configJobCategory);
	
	/**
     * 删除职位分类
     * 
     * @param id 职位分类ID
     * @return 结果
     */
	public int deleteConfigJobCategoryById(Integer id);
	
	/**
     * 批量删除职位分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteConfigJobCategoryByIds(String[] ids);
	
}