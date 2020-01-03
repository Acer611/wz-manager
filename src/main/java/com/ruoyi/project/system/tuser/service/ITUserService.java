package com.ruoyi.project.system.tuser.service;

import com.ruoyi.project.system.tuser.domain.TUser;

import java.util.List;

/**
 * 注册用户管理 服务层
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public interface ITUserService 
{
	/**
     * 查询注册用户管理信息
     * 
     * @param id 注册用户管理ID
     * @return 注册用户管理信息
     */
	public TUser selectTUserById(Long id);
	
	/**
     * 查询注册用户管理列表
     * 
     * @param tUser 注册用户管理信息
     * @return 注册用户管理集合
     */
	public List<TUser> selectTUserList(TUser tUser);
	
	/**
     * 新增注册用户管理
     * 
     * @param tUser 注册用户管理信息
     * @return 结果
     */
	public int insertTUser(TUser tUser);
	
	/**
     * 修改注册用户管理
     * 
     * @param tUser 注册用户管理信息
     * @return 结果
     */
	public int updateTUser(TUser tUser);
		
	/**
     * 删除注册用户管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserByIds(String ids);
	
}
