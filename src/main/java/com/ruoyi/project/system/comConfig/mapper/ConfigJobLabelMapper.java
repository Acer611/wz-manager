package com.ruoyi.project.system.comConfig.mapper;

import com.ruoyi.project.system.comConfig.domain.ConfigJobLabel;
import java.util.List;

/**
 * 职位标签 数据层
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public interface ConfigJobLabelMapper 
{
	/**
     * 查询职位标签信息
     * 
     * @param id 职位标签ID
     * @return 职位标签信息
     */
	public ConfigJobLabel selectConfigJobLabelById(Integer id);
	
	/**
     * 查询职位标签列表
     * 
     * @param configJobLabel 职位标签信息
     * @return 职位标签集合
     */
	public List<ConfigJobLabel> selectConfigJobLabelList(ConfigJobLabel configJobLabel);
	
	/**
     * 新增职位标签
     * 
     * @param configJobLabel 职位标签信息
     * @return 结果
     */
	public int insertConfigJobLabel(ConfigJobLabel configJobLabel);
	
	/**
     * 修改职位标签
     * 
     * @param configJobLabel 职位标签信息
     * @return 结果
     */
	public int updateConfigJobLabel(ConfigJobLabel configJobLabel);
	
	/**
     * 删除职位标签
     * 
     * @param id 职位标签ID
     * @return 结果
     */
	public int deleteConfigJobLabelById(Integer id);
	
	/**
     * 批量删除职位标签
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteConfigJobLabelByIds(String[] ids);
	
}