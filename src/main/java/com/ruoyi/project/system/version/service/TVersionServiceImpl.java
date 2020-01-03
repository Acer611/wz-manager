package com.ruoyi.project.system.version.service;

import java.util.List;

import com.ruoyi.project.system.version.domain.TVersion;
import com.ruoyi.project.system.version.mapper.TVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 版本控制 服务层实现
 * 
 * @author ruoyi
 * @date 2019-11-28
 */
@Service
public class TVersionServiceImpl implements ITVersionService 
{
	@Autowired
	private TVersionMapper tVersionMapper;

	/**
     * 查询版本控制信息
     * 
     * @param id 版本控制ID
     * @return 版本控制信息
     */
    @Override
	public TVersion selectTVersionById(Long id)
	{
	    return tVersionMapper.selectTVersionById(id);
	}
	
	/**
     * 查询版本控制列表
     * 
     * @param tVersion 版本控制信息
     * @return 版本控制集合
     */
	@Override
	public List<TVersion> selectTVersionList(TVersion tVersion)
	{
	    return tVersionMapper.selectTVersionList(tVersion);
	}
	
    /**
     * 新增版本控制
     * 
     * @param tVersion 版本控制信息
     * @return 结果
     */
	@Override
	public int insertTVersion(TVersion tVersion)
	{
	    return tVersionMapper.insertTVersion(tVersion);
	}
	
	/**
     * 修改版本控制
     * 
     * @param tVersion 版本控制信息
     * @return 结果
     */
	@Override
	public int updateTVersion(TVersion tVersion)
	{
	    return tVersionMapper.updateTVersion(tVersion);
	}

	/**
     * 删除版本控制对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTVersionByIds(String ids)
	{
		return tVersionMapper.deleteTVersionByIds(Convert.toStrArray(ids));
	}
	
}
