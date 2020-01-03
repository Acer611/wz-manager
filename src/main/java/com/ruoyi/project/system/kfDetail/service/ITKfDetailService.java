package com.ruoyi.project.system.kfDetail.service;

import com.ruoyi.project.system.kfDetail.domain.TKfDetail;

import java.util.List;

/**
 * 客服详情 服务层
 * 
 * @author ruoyi
 * @date 2019-11-20
 */
public interface ITKfDetailService 
{
	/**
     * 查询客服详情信息
     * 
     * @param id 客服详情ID
     * @return 客服详情信息
     */
	public TKfDetail selectTKfDetailById(Long id);
	
	/**
     * 查询客服详情列表
     * 
     * @param tKfDetail 客服详情信息
     * @return 客服详情集合
     */
	public List<TKfDetail> selectTKfDetailList(TKfDetail tKfDetail);
	
	/**
     * 新增客服详情
     * 
     * @param tKfDetail 客服详情信息
     * @return 结果
     */
	public int insertTKfDetail(TKfDetail tKfDetail);
	
	/**
     * 修改客服详情
     * 
     * @param tKfDetail 客服详情信息
     * @return 结果
     */
	public int updateTKfDetail(TKfDetail tKfDetail);
		
	/**
     * 删除客服详情信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTKfDetailByIds(String ids);
	
}
