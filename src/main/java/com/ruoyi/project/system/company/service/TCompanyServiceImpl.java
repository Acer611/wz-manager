package com.ruoyi.project.system.company.service;

import java.util.List;

import com.ruoyi.project.system.company.domain.TCompany;
import com.ruoyi.project.system.company.mapper.TCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 公司信息 服务层实现
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Service(value = "tCompanyService" )
public class TCompanyServiceImpl implements ITCompanyService 
{
	@Autowired
	private TCompanyMapper tCompanyMapper;

	/**
     * 查询公司信息信息
     * 
     * @param id 公司信息ID
     * @return 公司信息信息
     */
    @Override
	public TCompany selectTCompanyById(Long id)
	{
	    return tCompanyMapper.selectTCompanyById(id);
	}
	
	/**
     * 查询公司信息列表
     * 
     * @param tCompany 公司信息信息
     * @return 公司信息集合
     */
	@Override
	public List<TCompany> selectTCompanyList(TCompany tCompany)
	{
	    return tCompanyMapper.selectTCompanyList(tCompany);
	}
	
    /**
     * 新增公司信息
     * 
     * @param tCompany 公司信息信息
     * @return 结果
     */
	@Override
	public int insertTCompany(TCompany tCompany)
	{
	    return tCompanyMapper.insertTCompany(tCompany);
	}
	
	/**
     * 修改公司信息
     * 
     * @param tCompany 公司信息信息
     * @return 结果
     */
	@Override
	public int updateTCompany(TCompany tCompany)
	{
	    return tCompanyMapper.updateTCompany(tCompany);
	}

	/**
     * 删除公司信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTCompanyByIds(String ids)
	{
		return tCompanyMapper.deleteTCompanyByIds(Convert.toStrArray(ids));
	}

	/**
	 * 根据源ID查询公司详情
	 * @param id
	 * @return
	 */
	@Override
	public TCompany selectTCompanyBySourceId(Long id) {
		return tCompanyMapper.selectTCompanyBySourceId(id);
	}

}
