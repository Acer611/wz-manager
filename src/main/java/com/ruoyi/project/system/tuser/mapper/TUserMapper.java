package com.ruoyi.project.system.tuser.mapper;

import com.ruoyi.project.system.tuser.domain.TUser;

import java.util.List;

/**
 * 注册用户管理 数据层
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public interface TUserMapper 
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
     * 删除注册用户管理
     * 
     * @param id 注册用户管理ID
     * @return 结果
     */
	public int deleteTUserById(Long id);
	
	/**
     * 批量删除注册用户管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTUserByIds(String[] ids);
	
}