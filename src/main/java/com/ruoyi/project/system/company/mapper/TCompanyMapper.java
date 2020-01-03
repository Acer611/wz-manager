package com.ruoyi.project.system.company.mapper;

import com.ruoyi.project.system.company.domain.TCompany;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 公司信息 数据层
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Mapper
public interface TCompanyMapper 
{
	/**
     * 查询公司信息信息
     * 
     * @param id 公司信息ID
     * @return 公司信息信息
     */
	public TCompany selectTCompanyById(Long id);
	
	/**
     * 查询公司信息列表
     * 
     * @param tCompany 公司信息信息
     * @return 公司信息集合
     */
	public List<TCompany> selectTCompanyList(TCompany tCompany);
	
	/**
     * 新增公司信息
     * 
     * @param tCompany 公司信息信息
     * @return 结果
     */
	public int insertTCompany(TCompany tCompany);
	
	/**
     * 修改公司信息
     * 
     * @param tCompany 公司信息信息
     * @return 结果
     */
	public int updateTCompany(TCompany tCompany);
	
	/**
     * 删除公司信息
     * 
     * @param id 公司信息ID
     * @return 结果
     */
	public int deleteTCompanyById(Long id);
	
	/**
     * 批量删除公司信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTCompanyByIds(String[] ids);

	/**
	 * 根据源id查询公司详情
	 * @param id
	 * @return
	 */
	@Select("select * from t_company where companyId =#{id}")
	TCompany selectTCompanyBySourceId(Long id);
}