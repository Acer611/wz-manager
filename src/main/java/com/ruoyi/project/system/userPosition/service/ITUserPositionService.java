package com.ruoyi.project.system.userPosition.service;

import com.ruoyi.project.system.userPosition.domain.TUserPosition;

import java.util.List;

/**
 * 用户报名信息 服务层
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public interface ITUserPositionService 
{
	/**
     * 查询用户报名信息信息
     * 
     * @param id 用户报名信息ID
     * @return 用户报名信息信息
     */
	public TUserPosition selectTUserPositionById(Long id);
	
	/**
     * 查询用户报名信息列表
     * 
     * @param tUserPosition 用户报名信息信息
     * @return 用户报名信息集合
     */
	public List<TUserPosition> selectTUserPositionList(TUserPosition tUserPosition);
	
	/**
     * 新增用户报名信息
     * 
     * @param tUserPosition 用户报名信息信息
     * @return 结果
     */
	public int insertTUserPosition(TUserPosition tUserPosition);
	
	/**
     * 修改用户报名信息
     * 
     * @param tUserPosition 用户报名信息信息
     * @return 结果
     */
	public int updateTUserPosition(TUserPosition tUserPosition);
		
	/**
     * 删除用户报名信息信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserPositionByIds(String ids);
	
}
