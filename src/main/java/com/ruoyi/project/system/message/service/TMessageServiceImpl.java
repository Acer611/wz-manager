package com.ruoyi.project.system.message.service;

import java.util.Date;
import java.util.List;

import com.ruoyi.project.system.message.domain.Message;
import com.ruoyi.project.system.message.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.utils.text.Convert;

/**
 * 消息管理 服务层实现
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
@Service
public class TMessageServiceImpl implements ITMessageService 
{
	@Autowired
	private MessageMapper tMessageMapper;

	/**
     * 查询消息管理信息
     * 
     * @param id 消息管理ID
     * @return 消息管理信息
     */
    @Override
	public Message selectTMessageById(Long id)
	{
	    return tMessageMapper.selectTMessageById(id);
	}
	
	/**
     * 查询消息管理列表
     * 
     * @param tMessage 消息管理信息
     * @return 消息管理集合
     */
	@Override
	public List<Message> selectTMessageList(Message tMessage)
	{
	    return tMessageMapper.selectTMessageList(tMessage);
	}
	
    /**
     * 新增消息管理
     * 
     * @param tMessage 消息管理信息
     * @return 结果
     */
	@Override
	public int insertTMessage(Message tMessage)
	{
		tMessage.setType(0);
		tMessage.setStatus(0);
		tMessage.setCreateTime(new Date());
	    return tMessageMapper.insertTMessage(tMessage);
	}
	
	/**
     * 修改消息管理
     * 
     * @param tMessage 消息管理信息
     * @return 结果
     */
	@Override
	public int updateTMessage(Message tMessage)
	{

	    return tMessageMapper.updateTMessage(tMessage);
	}

	/**
     * 删除消息管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTMessageByIds(String ids)
	{
		return tMessageMapper.deleteTMessageByIds(Convert.toStrArray(ids));
	}
	
}
