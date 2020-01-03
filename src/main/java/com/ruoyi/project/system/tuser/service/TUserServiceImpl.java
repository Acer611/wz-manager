package com.ruoyi.project.system.tuser.service;

import java.util.List;

import com.ruoyi.project.system.tuser.domain.TUser;
import com.ruoyi.project.system.tuser.mapper.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 注册用户管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Service
public class TUserServiceImpl implements ITUserService 
{
	@Autowired
	private TUserMapper tUserMapper;

	/**
     * 查询注册用户管理信息
     * 
     * @param id 注册用户管理ID
     * @return 注册用户管理信息
     */
    @Override
	public TUser selectTUserById(Long id)
	{
	    return tUserMapper.selectTUserById(id);
	}
	
	/**
     * 查询注册用户管理列表
     * 
     * @param tUser 注册用户管理信息
     * @return 注册用户管理集合
     */
	@Override
	public List<TUser> selectTUserList(TUser tUser)
	{
	    return tUserMapper.selectTUserList(tUser);
	}
	
    /**
     * 新增注册用户管理
     * 
     * @param tUser 注册用户管理信息
     * @return 结果
     */
	@Override
	public int insertTUser(TUser tUser)
	{
	    return tUserMapper.insertTUser(tUser);
	}
	
	/**
     * 修改注册用户管理
     * 
     * @param tUser 注册用户管理信息
     * @return 结果
     */
	@Override
	public int updateTUser(TUser tUser)
	{
	    return tUserMapper.updateTUser(tUser);
	}

	/**
     * 删除注册用户管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserByIds(String ids)
	{
		return tUserMapper.deleteTUserByIds(Convert.toStrArray(ids));
	}
	
}
