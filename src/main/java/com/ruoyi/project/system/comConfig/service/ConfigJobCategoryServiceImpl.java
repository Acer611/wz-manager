package com.ruoyi.project.system.comConfig.service;

import java.util.List;

import com.ruoyi.project.system.comConfig.domain.ConfigJobCategory;
import com.ruoyi.project.system.comConfig.mapper.ConfigJobCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 职位分类 服务层实现
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Service
public class ConfigJobCategoryServiceImpl implements IConfigJobCategoryService 
{
	@Autowired
	private ConfigJobCategoryMapper configJobCategoryMapper;

	/**
     * 查询职位分类信息
     * 
     * @param id 职位分类ID
     * @return 职位分类信息
     */
    @Override
	public ConfigJobCategory selectConfigJobCategoryById(Integer id)
	{
	    return configJobCategoryMapper.selectConfigJobCategoryById(id);
	}
	
	/**
     * 查询职位分类列表
     * 
     * @param configJobCategory 职位分类信息
     * @return 职位分类集合
     */
	@Override
	public List<ConfigJobCategory> selectConfigJobCategoryList(ConfigJobCategory configJobCategory)
	{
	    return configJobCategoryMapper.selectConfigJobCategoryList(configJobCategory);
	}
	
    /**
     * 新增职位分类
     * 
     * @param configJobCategory 职位分类信息
     * @return 结果
     */
	@Override
	public int insertConfigJobCategory(ConfigJobCategory configJobCategory)
	{
		configJobCategory.setStatus(0);
	    return configJobCategoryMapper.insertConfigJobCategory(configJobCategory);
	}
	
	/**
     * 修改职位分类
     * 
     * @param configJobCategory 职位分类信息
     * @return 结果
     */
	@Override
	public int updateConfigJobCategory(ConfigJobCategory configJobCategory)
	{
	    return configJobCategoryMapper.updateConfigJobCategory(configJobCategory);
	}

	/**
     * 删除职位分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteConfigJobCategoryByIds(String ids)
	{
		return configJobCategoryMapper.deleteConfigJobCategoryByIds(Convert.toStrArray(ids));
	}
	
}
