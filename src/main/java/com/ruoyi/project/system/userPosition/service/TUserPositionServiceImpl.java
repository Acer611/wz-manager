package com.ruoyi.project.system.userPosition.service;

import java.util.Date;
import java.util.List;

import com.ruoyi.project.system.message.domain.Message;
import com.ruoyi.project.system.message.mapper.MessageMapper;
import com.ruoyi.project.system.userPosition.domain.TUserPosition;
import com.ruoyi.project.system.userPosition.mapper.TUserPositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 用户报名信息 服务层实现
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Service
public class TUserPositionServiceImpl implements ITUserPositionService 
{
	@Autowired
	private TUserPositionMapper tUserPositionMapper;
	@Autowired
	private MessageMapper tMessageMapper;

	/**
     * 查询用户报名信息信息
     * 
     * @param id 用户报名信息ID
     * @return 用户报名信息信息
     */
    @Override
	public TUserPosition selectTUserPositionById(Long id)
	{
	    return tUserPositionMapper.selectTUserPositionById(id);
	}
	
	/**
     * 查询用户报名信息列表
     * 
     * @param tUserPosition 用户报名信息信息
     * @return 用户报名信息集合
     */
	@Override
	public List<TUserPosition> selectTUserPositionList(TUserPosition tUserPosition)
	{
	    return tUserPositionMapper.selectTUserPositionList(tUserPosition);
	}
	
    /**
     * 新增用户报名信息
     * 
     * @param tUserPosition 用户报名信息信息
     * @return 结果
     */
	@Override
	public int insertTUserPosition(TUserPosition tUserPosition)
	{
	    return tUserPositionMapper.insertTUserPosition(tUserPosition);
	}
	
	/**
     * 修改用户报名信息
     * 
     * @param tUserPosition 用户报名信息信息
     * @return 结果
     */
	@Override
	public int updateTUserPosition(TUserPosition tUserPosition)
	{
		TUserPosition realUserInfo = tUserPositionMapper.selectTUserPositionById(tUserPosition.getId());
		if(tUserPosition.getStatus()!=null){
			Message message = new Message();
			message.setType(1);
			message.setStatus(0);
			message.setUserId(realUserInfo.getUserId());
			message.setTitle("报名审核通知");
			message.setCreateTime(new Date());
			if(tUserPosition.getStatus()==2){
				//待面试
				message.setContent("您的简历已被查看，面试官认为您很优秀，请您联系客服约定确切面试时间！！");
			}
			if(tUserPosition.getStatus()==3){
				//已录取
				message.setContent("恭喜你，您已经通过了面试！！");
			}
			if(tUserPosition.getStatus()==3){
				//已录取
				message.setContent("非常抱歉，您可能不适合这个职位，请看看其他的机会！！");
			}
			if(tUserPosition.getStatus()!=1){
				tMessageMapper.insertTMessage(message);
			}

		}

	    return tUserPositionMapper.updateTUserPosition(tUserPosition);
	}

	/**
     * 删除用户报名信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTUserPositionByIds(String ids)
	{
		return tUserPositionMapper.deleteTUserPositionByIds(Convert.toStrArray(ids));
	}
	
}
