package com.ruoyi.project.system.article.mapper;

import com.ruoyi.project.system.article.domain.TArticle;
import java.util.List;

/**
 * 软文信息 数据层
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public interface TArticleMapper 
{
	/**
     * 查询软文信息信息
     * 
     * @param id 软文信息ID
     * @return 软文信息信息
     */
	public TArticle selectTArticleById(Long id);
	
	/**
     * 查询软文信息列表
     * 
     * @param tArticle 软文信息信息
     * @return 软文信息集合
     */
	public List<TArticle> selectTArticleList(TArticle tArticle);
	
	/**
     * 新增软文信息
     * 
     * @param tArticle 软文信息信息
     * @return 结果
     */
	public int insertTArticle(TArticle tArticle);
	
	/**
     * 修改软文信息
     * 
     * @param tArticle 软文信息信息
     * @return 结果
     */
	public int updateTArticle(TArticle tArticle);
	
	/**
     * 删除软文信息
     * 
     * @param id 软文信息ID
     * @return 结果
     */
	public int deleteTArticleById(Long id);
	
	/**
     * 批量删除软文信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTArticleByIds(String[] ids);
	
}