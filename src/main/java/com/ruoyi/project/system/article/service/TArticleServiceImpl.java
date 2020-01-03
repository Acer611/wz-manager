package com.ruoyi.project.system.article.service;

import java.util.Date;
import java.util.List;

import com.ruoyi.project.system.article.domain.TArticle;
import com.ruoyi.project.system.article.mapper.TArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 软文信息 服务层实现
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Service
public class TArticleServiceImpl implements ITArticleService 
{
	@Autowired
	private TArticleMapper tArticleMapper;

	/**
     * 查询软文信息信息
     * 
     * @param id 软文信息ID
     * @return 软文信息信息
     */
    @Override
	public TArticle selectTArticleById(Long id)
	{
	    return tArticleMapper.selectTArticleById(id);
	}
	
	/**
     * 查询软文信息列表
     * 
     * @param tArticle 软文信息信息
     * @return 软文信息集合
     */
	@Override
	public List<TArticle> selectTArticleList(TArticle tArticle)
	{
	    return tArticleMapper.selectTArticleList(tArticle);
	}
	
    /**
     * 新增软文信息
     * 
     * @param tArticle 软文信息信息
     * @return 结果
     */
	@Override
	public int insertTArticle(TArticle tArticle)
	{
		tArticle.setCreateTime(new Date());
	    return tArticleMapper.insertTArticle(tArticle);
	}
	
	/**
     * 修改软文信息
     * 
     * @param tArticle 软文信息信息
     * @return 结果
     */
	@Override
	public int updateTArticle(TArticle tArticle)
	{
	    return tArticleMapper.updateTArticle(tArticle);
	}

	/**
     * 删除软文信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTArticleByIds(String ids)
	{
		return tArticleMapper.deleteTArticleByIds(Convert.toStrArray(ids));
	}
	
}
