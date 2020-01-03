package com.ruoyi.project.system.kfDetail.service;

import java.util.List;

import com.ruoyi.project.system.kfDetail.domain.TKfDetail;
import com.ruoyi.project.system.kfDetail.mapper.TKfDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 客服详情 服务层实现
 * 
 * @author ruoyi
 * @date 2019-11-20
 */
@Service
public class TKfDetailServiceImpl implements ITKfDetailService 
{
	@Autowired
	private TKfDetailMapper tKfDetailMapper;

	/**
     * 查询客服详情信息
     * 
     * @param id 客服详情ID
     * @return 客服详情信息
     */
    @Override
	public TKfDetail selectTKfDetailById(Long id)
	{
	    return tKfDetailMapper.selectTKfDetailById(id);
	}
	
	/**
     * 查询客服详情列表
     * 
     * @param tKfDetail 客服详情信息
     * @return 客服详情集合
     */
	@Override
	public List<TKfDetail> selectTKfDetailList(TKfDetail tKfDetail)
	{
	    return tKfDetailMapper.selectTKfDetailList(tKfDetail);
	}
	
    /**
     * 新增客服详情
     * 
     * @param tKfDetail 客服详情信息
     * @return 结果
     */
	@Override
	public int insertTKfDetail(TKfDetail tKfDetail)
	{
	    return tKfDetailMapper.insertTKfDetail(tKfDetail);
	}
	
	/**
     * 修改客服详情
     * 
     * @param tKfDetail 客服详情信息
     * @return 结果
     */
	@Override
	public int updateTKfDetail(TKfDetail tKfDetail)
	{
	    return tKfDetailMapper.updateTKfDetail(tKfDetail);
	}

	/**
     * 删除客服详情对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTKfDetailByIds(String ids)
	{
		return tKfDetailMapper.deleteTKfDetailByIds(Convert.toStrArray(ids));
	}
	
}
