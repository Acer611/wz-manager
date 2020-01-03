package com.ruoyi.project.system.comConfig.service;

import java.util.List;

import com.ruoyi.project.system.comConfig.domain.ConfigJobLabel;
import com.ruoyi.project.system.comConfig.mapper.ConfigJobLabelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 职位标签 服务层实现
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Service
public class ConfigJobLabelServiceImpl implements IConfigJobLabelService 
{
	@Autowired
	private ConfigJobLabelMapper configJobLabelMapper;

	/**
     * 查询职位标签信息
     * 
     * @param id 职位标签ID
     * @return 职位标签信息
     */
    @Override
	public ConfigJobLabel selectConfigJobLabelById(Integer id)
	{
	    return configJobLabelMapper.selectConfigJobLabelById(id);
	}
	
	/**
     * 查询职位标签列表
     * 
     * @param configJobLabel 职位标签信息
     * @return 职位标签集合
     */
	@Override
	public List<ConfigJobLabel> selectConfigJobLabelList(ConfigJobLabel configJobLabel)
	{
	    return configJobLabelMapper.selectConfigJobLabelList(configJobLabel);
	}
	
    /**
     * 新增职位标签
     * 
     * @param configJobLabel 职位标签信息
     * @return 结果
     */
	@Override
	public int insertConfigJobLabel(ConfigJobLabel configJobLabel)
	{
		configJobLabel.setStatus(0);
	    return configJobLabelMapper.insertConfigJobLabel(configJobLabel);
	}
	
	/**
     * 修改职位标签
     * 
     * @param configJobLabel 职位标签信息
     * @return 结果
     */
	@Override
	public int updateConfigJobLabel(ConfigJobLabel configJobLabel)
	{
	    return configJobLabelMapper.updateConfigJobLabel(configJobLabel);
	}

	/**
     * 删除职位标签对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteConfigJobLabelByIds(String ids)
	{
		return configJobLabelMapper.deleteConfigJobLabelByIds(Convert.toStrArray(ids));
	}
	
}
