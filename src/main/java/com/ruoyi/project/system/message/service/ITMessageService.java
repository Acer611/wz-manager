package com.ruoyi.project.system.message.service;

import com.ruoyi.project.system.message.domain.Message;
import java.util.List;

/**
 * 消息管理 服务层
 * 
 * @author ruoyi
 * @date 2019-11-12
 */
public interface ITMessageService 
{
	/**
     * 查询消息管理信息
     * 
     * @param id 消息管理ID
     * @return 消息管理信息
     */
	public Message selectTMessageById(Long id);
	
	/**
     * 查询消息管理列表
     * 
     * @param tMessage 消息管理信息
     * @return 消息管理集合
     */
	public List<Message> selectTMessageList(Message tMessage);
	
	/**
     * 新增消息管理
     * 
     * @param tMessage 消息管理信息
     * @return 结果
     */
	public int insertTMessage(Message tMessage);
	
	/**
     * 修改消息管理
     * 
     * @param tMessage 消息管理信息
     * @return 结果
     */
	public int updateTMessage(Message tMessage);
		
	/**
     * 删除消息管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTMessageByIds(String ids);
	
}
