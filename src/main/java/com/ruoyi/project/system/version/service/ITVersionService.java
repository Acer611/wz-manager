package com.ruoyi.project.system.version.service;

import com.ruoyi.project.system.version.domain.TVersion;

import java.util.List;

/**
 * 版本控制 服务层
 * 
 * @author ruoyi
 * @date 2019-11-28
 */
public interface ITVersionService 
{
	/**
     * 查询版本控制信息
     * 
     * @param id 版本控制ID
     * @return 版本控制信息
     */
	public TVersion selectTVersionById(Long id);
	
	/**
     * 查询版本控制列表
     * 
     * @param tVersion 版本控制信息
     * @return 版本控制集合
     */
	public List<TVersion> selectTVersionList(TVersion tVersion);
	
	/**
     * 新增版本控制
     * 
     * @param tVersion 版本控制信息
     * @return 结果
     */
	public int insertTVersion(TVersion tVersion);
	
	/**
     * 修改版本控制
     * 
     * @param tVersion 版本控制信息
     * @return 结果
     */
	public int updateTVersion(TVersion tVersion);
		
	/**
     * 删除版本控制信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTVersionByIds(String ids);
	
}
